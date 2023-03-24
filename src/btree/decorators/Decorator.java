package btree.decorators;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class Decorator extends Task {

    protected Task child;

    public Decorator(LoopScript script, Task child) {
        super(script);
        this.child = child;
    }

    public STATUS run() {
        return child.run();
    }
}
