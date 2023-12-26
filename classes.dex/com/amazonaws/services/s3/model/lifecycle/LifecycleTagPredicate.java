package com.amazonaws.services.s3.model.lifecycle;

import com.amazonaws.services.s3.model.Tag;

public final class LifecycleTagPredicate extends LifecycleFilterPredicate {
    private final Tag tag;

    public LifecycleTagPredicate(Tag tag2) {
        this.tag = tag2;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.visit(this);
    }
}
