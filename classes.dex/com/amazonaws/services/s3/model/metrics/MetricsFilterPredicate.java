package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

public abstract class MetricsFilterPredicate implements Serializable {
    public abstract void accept(MetricsPredicateVisitor metricsPredicateVisitor);
}
