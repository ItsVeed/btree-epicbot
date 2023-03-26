package btree.actions;

import btree.Task;
import com.epicbot.api.shared.entity.ItemWidget;
import com.epicbot.api.shared.script.LoopScript;
import com.epicbot.api.shared.util.time.Time;

public class InteractItem extends Task {
    private final int id;
    private final String interaction;

    public InteractItem(LoopScript script, int id, String interaction) {
        super(script);
        this.id = id;
        this.interaction = interaction;
    }

    @Override
    public STATUS run() {
        ItemWidget item = ctx.inventory().getItem(id);

        if (item != null) {
            if (interaction == null) {
                item.interact();
            } else {
                item.interact(interaction);
            }
            Time.sleep(413, 628);
        } else {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;

    }
}
