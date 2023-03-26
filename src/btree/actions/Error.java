package btree.actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class Error extends Task {
    private final String error;

    public Error(LoopScript script, String error) {
        super(script);
        this.error = error;
    }

    @Override
    public STATUS run() {
        ctx.script().stop(error);

        return STATUS.SUCCEEDED;
    }
}
