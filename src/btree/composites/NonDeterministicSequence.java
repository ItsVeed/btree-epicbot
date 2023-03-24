package btree.composites;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

import java.util.ArrayList;
import java.util.Arrays;

import static btree.Task.STATUS.FAILED;
import static btree.Task.STATUS.SUCCEEDED;
import static java.util.Collections.shuffle;

public class NonDeterministicSequence extends Composite {
    public NonDeterministicSequence(LoopScript script, Task... children) {
        super(script);
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public NonDeterministicSequence(LoopScript script, ArrayList<Task> children) {
        super(script, children);
    }

    @Override
    public STATUS run() {
        shuffle(children);
        for (Task task : children) {
            if (task.run() == FAILED) {
                return FAILED;
            }
        }
        return SUCCEEDED;
    }
}
