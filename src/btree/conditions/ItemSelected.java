package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class ItemSelected extends Task {
    private final int item;

    public ItemSelected(LoopScript script, int item) {
        super(script);
        this.item = item;
    }

    @Override
    public STATUS run() {
        if (ctx.inventory().getSelectedItemId() == item) {
            return STATUS.SUCCEEDED;
        } else {
            return STATUS.FAILED;
        }
    }
}
