package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class BankHasItem extends Task {
    private final int item;

    public BankHasItem(LoopScript script, int item) {
        super(script);
        this.item = item;
    }

    @Override
    public STATUS run() {
        if (ctx.bank().contains(item)) {
            return STATUS.SUCCEEDED;
        } else {
            return STATUS.FAILED;
        }
    }
}
