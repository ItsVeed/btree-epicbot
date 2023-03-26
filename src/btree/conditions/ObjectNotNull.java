package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.entity.SceneObject;
import com.epicbot.api.shared.script.LoopScript;

public class ObjectNotNull extends Task {
    private final SceneObject object;

    public ObjectNotNull(LoopScript script, SceneObject object) {
        super(script);
        this.object = object;
    }

    @Override
    public STATUS run() {
        if (object != null) {
            return STATUS.SUCCEEDED;
        } else {
            return STATUS.FAILED;
        }
    }
}
