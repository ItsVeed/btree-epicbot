package btree.subtrees;

import btree.actions.Error;
import btree.actions.OpenBank;
import btree.actions.WalkToNearestBank;
import btree.actions.WithdrawItemAction;
import btree.composites.Selector;
import btree.composites.Sequence;
import btree.conditions.BankHasItem;
import btree.conditions.BankIsOpen;
import btree.conditions.BankIsReachable;
import btree.conditions.HasInventorySpace;
import btree.decorators.Inverter;
import com.epicbot.api.shared.script.LoopScript;

public class WithdrawItem extends Subtree {
    public WithdrawItem(LoopScript script, int item, int quantity) {
        super(script);
        this.child = new Sequence(script,
                new Selector(script,
                        new BankIsReachable(script),
                        new WalkToNearestBank(script)
                ),
                new Selector(script,
                        new BankIsOpen(script),
                        new OpenBank(script)
                ),
                new Selector(script,
                        new BankHasItem(script, item),
                        new Error(script, "Bank does not have the needed items.")
                ),
                new WithdrawItemAction(script, item, quantity)
        );
    }
}
