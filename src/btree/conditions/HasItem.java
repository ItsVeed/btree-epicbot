package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class HasItem extends Task {

    int item;

    public HasItem(LoopScript script, int item) {
        super(script);
        this.item = item;
    }

    public STATUS run() {
        if (!ctx.inventory().contains(item)) {
            return STATUS.FAILED;
        } else {
            return STATUS.SUCCEEDED;
        }
    }
}
