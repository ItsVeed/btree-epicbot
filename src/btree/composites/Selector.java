package btree.composites;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

import java.util.ArrayList;
import java.util.Arrays;

import static btree.Task.STATUS.FAILED;
import static btree.Task.STATUS.SUCCEEDED;

public class Selector extends Composite {
    public Selector(LoopScript script, Task... children) {
        super(script);
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public Selector(LoopScript script, ArrayList<Task> children) {
        super(script, children);
    }

    @Override
    public STATUS run() {
        for (Task task : children) {
            if (task.run() == SUCCEEDED) {
                System.out.println("Succeded");
                return SUCCEEDED;
            }
        }
        System.out.println("Failed");
        return FAILED;
    }
}
