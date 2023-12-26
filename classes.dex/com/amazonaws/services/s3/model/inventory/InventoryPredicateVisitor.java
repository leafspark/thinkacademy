package com.amazonaws.services.s3.model.inventory;

public interface InventoryPredicateVisitor {
    void visit(InventoryPrefixPredicate inventoryPrefixPredicate);
}
