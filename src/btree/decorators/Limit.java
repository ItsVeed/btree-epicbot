package btree.decorators;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class Limit extends Decorator {
    private int limit;
    private int runCount;
    public Limit(LoopScript script, Task child, int limit) {
        super(script, child);
        this.limit = limit;
    }

    @Override
    public STATUS run() {
        if (runCount < limit) {
            runCount ++;
            return child.run();
        } else {
            return STATUS.FAILED;
        }
    }


}
