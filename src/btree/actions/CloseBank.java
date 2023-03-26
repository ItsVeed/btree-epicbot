package btree.actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class CloseBank extends Task {
    public CloseBank(LoopScript script) {
        super(script);
    }

    @Override
    public STATUS run() {
        ctx.bank().close();

        return STATUS.SUCCEEDED;
    }
}
