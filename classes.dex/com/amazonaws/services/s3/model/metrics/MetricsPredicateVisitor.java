package com.amazonaws.services.s3.model.metrics;

public interface MetricsPredicateVisitor {
    void visit(MetricsAndOperator metricsAndOperator);

    void visit(MetricsPrefixPredicate metricsPrefixPredicate);

    void visit(MetricsTagPredicate metricsTagPredicate);
}
