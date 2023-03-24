package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class HasInventorySpace extends Task {

    public HasInventorySpace(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        if (ctx.inventory().isFull()) {
            return STATUS.FAILED;
        }
        return STATUS.SUCCEEDED;
    }

}
