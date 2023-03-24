package btree;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.LoopScript;

public abstract class Task {

    public enum STATUS {
        FRESH, SUCCEEDED, FAILED, RUNNING, CANCELLED
    }

    protected APIContext ctx;
    protected LoopScript script;

    public Task(LoopScript script) {
        this.script = script;
        this.ctx = script.getAPIContext();
    }

    public abstract STATUS run();
}
