package btree.conditions;

import btree.Task;
import com.epicbot.api.shared.entity.GameEntity;
import com.epicbot.api.shared.script.LoopScript;

public class CanSee extends Task {


    private final GameEntity entity;

    public CanSee(LoopScript script, GameEntity entity) {
        super(script);
        this.entity = entity;
    }

    public STATUS run() {
        if (entity != null) {
            if (entity.isVisible()) {
                return STATUS.SUCCEEDED;
            } else {
                return STATUS.FAILED;
            }
        } else {
            return STATUS.FAILED;
        }
    }
}
