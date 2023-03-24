package btree.decorators;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

import static btree.Task.STATUS.FAILED;
import static btree.Task.STATUS.SUCCEEDED;

public class Inverter extends Decorator {
    public Inverter(LoopScript script, Task child) {
        super(script, child);
    }

    @Override
    public STATUS run() {
        STATUS status = child.run();
        switch (status) {
            case SUCCEEDED:
                return FAILED;
            case FAILED:
                return SUCCEEDED;
            default:
                return status;
        }
    }
}
