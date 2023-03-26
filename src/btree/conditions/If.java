package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class If extends Task {
    private final boolean cond;

    public If(LoopScript script, boolean cond) {
        super(script);
        this.cond = cond;
    }

    @Override
    public STATUS run() {
        if (cond) {
            return STATUS.SUCCEEDED;
        } else {
            return STATUS.FAILED;
        }
    }
}
