package btree.composites;


import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

import java.util.ArrayList;
import java.util.Arrays;

public class Composite extends Task {

    protected ArrayList<Task> children;
    public Composite(LoopScript script) {
        super(script);
    }

    public Composite(LoopScript script, ArrayList<Task> children) {
        super(script);
        this.children = children;
    }

    public Composite(LoopScript script, Task[] children) {
        super(script);
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public STATUS run() {
        return STATUS.FRESH;
    }

}
