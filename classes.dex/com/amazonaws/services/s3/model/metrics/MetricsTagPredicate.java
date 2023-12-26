package com.amazonaws.services.s3.model.metrics;

import com.amazonaws.services.s3.model.Tag;

public final class MetricsTagPredicate extends MetricsFilterPredicate {
    private final Tag tag;

    public MetricsTagPredicate(Tag tag2) {
        this.tag = tag2;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.visit(this);
    }
}
