package btree.actions;

import btree.Task;
import com.epicbot.api.shared.model.Tile;
import com.epicbot.api.shared.script.LoopScript;

public class WalkToLocal extends Task {

    Tile location;

    public WalkToLocal(LoopScript script, Tile location) {
        super(script);
        this.location = location;
    }

    public STATUS run() {
        try {
            ctx.walking().walkTo(location);
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
