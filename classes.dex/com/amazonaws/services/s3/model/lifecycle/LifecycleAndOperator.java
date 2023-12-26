package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

public final class LifecycleAndOperator extends LifecycleNAryOperator {
    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }

    public LifecycleAndOperator(List<LifecycleFilterPredicate> list) {
        super(list);
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.visit(this);
    }
}
