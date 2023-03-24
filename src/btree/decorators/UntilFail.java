package btree.decorators;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class UntilFail extends Decorator {
    public UntilFail(LoopScript script, Task child) {
        super(script, child);
    }

    @Override
    public STATUS run() {
        STATUS status = child.run();
        while (status == STATUS.SUCCEEDED) {
            status = child.run();
        }
        return status;
    }
}
