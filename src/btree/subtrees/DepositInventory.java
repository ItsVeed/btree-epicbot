package btree.subtrees;

import btree.Task;
import btree.actions.OpenBank;
import btree.actions.WalkToNearestBank;
import btree.composites.Selector;
import btree.composites.Sequence;
import btree.conditions.BankIsOpen;
import btree.conditions.BankIsReachable;
import btree.conditions.HasInventorySpace;
import btree.decorators.Decorator;
import btree.decorators.Inverter;
import com.epicbot.api.shared.script.LoopScript;

public class DepositInventory extends Subtree {
    public DepositInventory(LoopScript script) {
        super(script);

        this.child = new Sequence(script,
                        new Inverter(script, new HasInventorySpace(script)),
                        new Selector(script,
                                new BankIsReachable(script),
                                new WalkToNearestBank(script)
                        ),
                        new Selector(script,
                                new BankIsOpen(script),
                                new OpenBank(script)
                        ),
                        new DepositInventory(script)
                    );

    }
}
