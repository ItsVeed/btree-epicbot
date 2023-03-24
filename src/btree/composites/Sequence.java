package btree.composites;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

import java.util.ArrayList;
import java.util.Arrays;

import static btree.Task.STATUS.FAILED;
import static btree.Task.STATUS.SUCCEEDED;

public class Sequence extends Composite{

    public Sequence(LoopScript script, Task... children) {
        super(script);
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public Sequence(LoopScript script, ArrayList<Task> children) {
        super(script, children);
    }

    @Override
    public STATUS run() {
        for (Task task : children) {
            if (task.run() == FAILED) {
                System.out.println("Failed");
                return FAILED;
            }
        }
        System.out.println("Succeded");
        return SUCCEEDED;
    }
}
