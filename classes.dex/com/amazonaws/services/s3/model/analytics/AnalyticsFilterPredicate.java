package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public abstract class AnalyticsFilterPredicate implements Serializable {
    public abstract void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor);
}
