package com.amazonaws.services.s3.model.analytics;

import java.util.List;

public class AnalyticsAndOperator extends AnalyticsNAryOperator {
    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }

    public AnalyticsAndOperator(List<AnalyticsFilterPredicate> list) {
        super(list);
    }

    public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor) {
        analyticsPredicateVisitor.visit(this);
    }
}
