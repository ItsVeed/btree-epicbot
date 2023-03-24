package btree.actions;

import btree.Task;
import com.epicbot.api.shared.entity.GameEntity;
import com.epicbot.api.shared.entity.details.Locatable;
import com.epicbot.api.shared.script.LoopScript;

public class TurnTo extends Task {

    private final Locatable entity;

    public TurnTo(LoopScript script, Locatable entity) {
        super(script);
        this.entity = entity;
    }

    public STATUS run() {
        try {
            if (entity != null) {
                ctx.camera().turnTo(entity);
            } else {
                return STATUS.FAILED;
            }
        }  catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
