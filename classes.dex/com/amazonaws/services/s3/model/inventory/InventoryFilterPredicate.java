package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public abstract class InventoryFilterPredicate implements Serializable {
    public abstract void accept(InventoryPredicateVisitor inventoryPredicateVisitor);
}
