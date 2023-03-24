package btree.actions;

import btree.Task;
import com.epicbot.api.shared.entity.GameEntity;
import com.epicbot.api.shared.script.LoopScript;

public class ClickObject extends Task {
    private final GameEntity entity;

    public ClickObject(LoopScript script, GameEntity entity) {
        super(script);
        this.entity = entity;
    }

    @Override
    public STATUS run() {
        try {
            if (entity != null) {
                entity.click();
            } else {
                return STATUS.FAILED;
            }
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
