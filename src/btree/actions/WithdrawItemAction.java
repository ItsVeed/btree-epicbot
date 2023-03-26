package btree.actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class WithdrawItemAction extends Task {
    private final int item;
    private final int quantity;

    public WithdrawItemAction(LoopScript script, int item, int quantity) {
        super(script);
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public STATUS run() {
        try {
            ctx.bank().withdraw(quantity, item);
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
