package btree.actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;
import com.epicbot.api.shared.util.time.Time;

public class DepositInvAction extends Task {
    public DepositInvAction(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        try {
            ctx.bank().depositInventory();
            Time.sleep(395, 728);
            ctx.bank().close();
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
