package btree.subtrees;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class Subtree extends Task {

    protected Task child;

    public Subtree(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        return child.run();
    }
}
