package btree.subtrees;

import btree.actions.InteractItem;
import btree.composites.Selector;
import btree.composites.Sequence;
import btree.conditions.HasItem;
import btree.conditions.ItemSelected;
import btree.decorators.Inverter;
import com.epicbot.api.shared.script.LoopScript;

public class CombineItems extends Subtree{
    public CombineItems(LoopScript script, int item1, int item2) {
        super(script);
        this.child = new Sequence(script,
                    new Selector(script,
                            new ItemSelected(script, item1),
                            new Sequence(script,
                                    new HasItem(script, item1),
                                    new InteractItem(script, item1, null)
                            )
                    ),
                    new Sequence(script,
                        new HasItem(script, item1),
                        new InteractItem(script, item1, null)
                    )
                );
    }
}
