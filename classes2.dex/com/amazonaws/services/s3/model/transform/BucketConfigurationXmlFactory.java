package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CloudFunctionConfiguration;
import com.amazonaws.services.s3.model.Filter;
import com.amazonaws.services.s3.model.FilterRule;
import com.amazonaws.services.s3.model.LambdaConfiguration;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.services.s3.model.QueueConfiguration;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3KeyFilter;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsPredicateVisitor;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryFilterPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePredicateVisitor;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsPredicateVisitor;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BucketConfigurationXmlFactory {
    public byte[] convertToXmlByteArray(BucketVersioningConfiguration bucketVersioningConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("VersioningConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        xmlWriter.start("Status").value(bucketVersioningConfiguration.getStatus()).end();
        Boolean isMfaDeleteEnabled = bucketVersioningConfiguration.isMfaDeleteEnabled();
        if (isMfaDeleteEnabled != null) {
            if (isMfaDeleteEnabled.booleanValue()) {
                xmlWriter.start("MfaDelete").value("Enabled").end();
            } else {
                xmlWriter.start("MfaDelete").value("Disabled").end();
            }
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketAccelerateConfiguration bucketAccelerateConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("AccelerateConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        xmlWriter.start("Status").value(bucketAccelerateConfiguration.getStatus()).end();
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketLoggingConfiguration bucketLoggingConfiguration) {
        bucketLoggingConfiguration.getLogFilePrefix();
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("BucketLoggingStatus", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        if (bucketLoggingConfiguration.isLoggingEnabled()) {
            xmlWriter.start("LoggingEnabled");
            xmlWriter.start("TargetBucket").value(bucketLoggingConfiguration.getDestinationBucketName()).end();
            xmlWriter.start("TargetPrefix").value(bucketLoggingConfiguration.getLogFilePrefix()).end();
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketNotificationConfiguration bucketNotificationConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("NotificationConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        for (Map.Entry entry : bucketNotificationConfiguration.getConfigurations().entrySet()) {
            String str = (String) entry.getKey();
            BucketNotificationConfiguration.TopicConfiguration topicConfiguration = (NotificationConfiguration) entry.getValue();
            if (topicConfiguration instanceof BucketNotificationConfiguration.TopicConfiguration) {
                xmlWriter.start("TopicConfiguration");
                xmlWriter.start("Id").value(str).end();
                xmlWriter.start("Topic").value(topicConfiguration.getTopicARN()).end();
                addEventsAndFilterCriteria(xmlWriter, topicConfiguration);
                xmlWriter.end();
            } else if (topicConfiguration instanceof QueueConfiguration) {
                xmlWriter.start("QueueConfiguration");
                xmlWriter.start("Id").value(str).end();
                xmlWriter.start("Queue").value(topicConfiguration.getQueueARN()).end();
                addEventsAndFilterCriteria(xmlWriter, topicConfiguration);
                xmlWriter.end();
            } else if (topicConfiguration instanceof CloudFunctionConfiguration) {
                xmlWriter.start("CloudFunctionConfiguration");
                xmlWriter.start("Id").value(str).end();
                CloudFunctionConfiguration cloudFunctionConfiguration = topicConfiguration;
                xmlWriter.start("InvocationRole").value(cloudFunctionConfiguration.getInvocationRoleARN()).end();
                xmlWriter.start("CloudFunction").value(cloudFunctionConfiguration.getCloudFunctionARN()).end();
                addEventsAndFilterCriteria(xmlWriter, topicConfiguration);
                xmlWriter.end();
            } else if (topicConfiguration instanceof LambdaConfiguration) {
                xmlWriter.start("CloudFunctionConfiguration");
                xmlWriter.start("Id").value(str).end();
                xmlWriter.start("CloudFunction").value(topicConfiguration.getFunctionARN()).end();
                addEventsAndFilterCriteria(xmlWriter, topicConfiguration);
                xmlWriter.end();
            }
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void addEventsAndFilterCriteria(XmlWriter xmlWriter, NotificationConfiguration notificationConfiguration) {
        for (String value : notificationConfiguration.getEvents()) {
            xmlWriter.start("Event").value(value).end();
        }
        Filter filter = notificationConfiguration.getFilter();
        if (filter != null) {
            validateFilter(filter);
            xmlWriter.start("Filter");
            if (filter.getS3KeyFilter() != null) {
                validateS3KeyFilter(filter.getS3KeyFilter());
                xmlWriter.start("S3Key");
                for (FilterRule filterRule : filter.getS3KeyFilter().getFilterRules()) {
                    xmlWriter.start("FilterRule");
                    xmlWriter.start("Name").value(filterRule.getName()).end();
                    xmlWriter.start("Value").value(filterRule.getValue()).end();
                    xmlWriter.end();
                }
                xmlWriter.end();
            }
            xmlWriter.end();
        }
    }

    private void validateFilter(Filter filter) {
        if (filter.getS3KeyFilter() == null) {
            throw new AmazonClientException("Cannot have a Filter without any criteria");
        }
    }

    private void validateS3KeyFilter(S3KeyFilter s3KeyFilter) {
        if (isNullOrEmpty(s3KeyFilter.getFilterRules())) {
            throw new AmazonClientException("Cannot have an S3KeyFilter without any filter rules");
        }
    }

    public byte[] convertToXmlByteArray(BucketReplicationConfiguration bucketReplicationConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("ReplicationConfiguration");
        Map rules = bucketReplicationConfiguration.getRules();
        xmlWriter.start("Role").value(bucketReplicationConfiguration.getRoleARN()).end();
        for (Map.Entry entry : rules.entrySet()) {
            ReplicationRule replicationRule = (ReplicationRule) entry.getValue();
            xmlWriter.start("Rule");
            xmlWriter.start("ID").value((String) entry.getKey()).end();
            xmlWriter.start("Prefix").value(replicationRule.getPrefix()).end();
            xmlWriter.start("Status").value(replicationRule.getStatus()).end();
            ReplicationDestinationConfig destinationConfig = replicationRule.getDestinationConfig();
            xmlWriter.start("Destination");
            xmlWriter.start("Bucket").value(destinationConfig.getBucketARN()).end();
            if (destinationConfig.getStorageClass() != null) {
                xmlWriter.start("StorageClass").value(destinationConfig.getStorageClass()).end();
            }
            xmlWriter.end();
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketWebsiteConfiguration bucketWebsiteConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("WebsiteConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        if (bucketWebsiteConfiguration.getIndexDocumentSuffix() != null) {
            XmlWriter start = xmlWriter.start("IndexDocument");
            start.start("Suffix").value(bucketWebsiteConfiguration.getIndexDocumentSuffix()).end();
            start.end();
        }
        if (bucketWebsiteConfiguration.getErrorDocument() != null) {
            XmlWriter start2 = xmlWriter.start("ErrorDocument");
            start2.start("Key").value(bucketWebsiteConfiguration.getErrorDocument()).end();
            start2.end();
        }
        RedirectRule redirectAllRequestsTo = bucketWebsiteConfiguration.getRedirectAllRequestsTo();
        if (redirectAllRequestsTo != null) {
            XmlWriter start3 = xmlWriter.start("RedirectAllRequestsTo");
            if (redirectAllRequestsTo.getprotocol() != null) {
                xmlWriter.start("Protocol").value(redirectAllRequestsTo.getprotocol()).end();
            }
            if (redirectAllRequestsTo.getHostName() != null) {
                xmlWriter.start("HostName").value(redirectAllRequestsTo.getHostName()).end();
            }
            if (redirectAllRequestsTo.getReplaceKeyPrefixWith() != null) {
                xmlWriter.start("ReplaceKeyPrefixWith").value(redirectAllRequestsTo.getReplaceKeyPrefixWith()).end();
            }
            if (redirectAllRequestsTo.getReplaceKeyWith() != null) {
                xmlWriter.start("ReplaceKeyWith").value(redirectAllRequestsTo.getReplaceKeyWith()).end();
            }
            start3.end();
        }
        if (bucketWebsiteConfiguration.getRoutingRules() != null && bucketWebsiteConfiguration.getRoutingRules().size() > 0) {
            XmlWriter start4 = xmlWriter.start("RoutingRules");
            for (RoutingRule writeRule : bucketWebsiteConfiguration.getRoutingRules()) {
                writeRule(start4, writeRule);
            }
            start4.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketLifecycleConfiguration bucketLifecycleConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("LifecycleConfiguration");
        for (BucketLifecycleConfiguration.Rule writeRule : bucketLifecycleConfiguration.getRules()) {
            writeRule(xmlWriter, writeRule);
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketCrossOriginConfiguration bucketCrossOriginConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("CORSConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        for (CORSRule writeRule : bucketCrossOriginConfiguration.getRules()) {
            writeRule(xmlWriter, writeRule);
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeRule(XmlWriter xmlWriter, BucketLifecycleConfiguration.Rule rule) {
        xmlWriter.start("Rule");
        if (rule.getId() != null) {
            xmlWriter.start("ID").value(rule.getId()).end();
        }
        writePrefix(xmlWriter, rule);
        xmlWriter.start("Status").value(rule.getStatus()).end();
        writeLifecycleFilter(xmlWriter, rule.getFilter());
        addTransitions(xmlWriter, rule.getTransitions());
        addNoncurrentTransitions(xmlWriter, rule.getNoncurrentVersionTransitions());
        if (hasCurrentExpirationPolicy(rule)) {
            xmlWriter.start("Expiration");
            if (rule.getExpirationInDays() != -1) {
                XmlWriter start = xmlWriter.start("Days");
                start.value("" + rule.getExpirationInDays()).end();
            }
            if (rule.getExpirationDate() != null) {
                xmlWriter.start("Date").value(ServiceUtils.formatIso8601Date(rule.getExpirationDate())).end();
            }
            if (rule.isExpiredObjectDeleteMarker()) {
                xmlWriter.start("ExpiredObjectDeleteMarker").value("true").end();
            }
            xmlWriter.end();
        }
        if (rule.getNoncurrentVersionExpirationInDays() != -1) {
            xmlWriter.start("NoncurrentVersionExpiration");
            xmlWriter.start("NoncurrentDays").value(Integer.toString(rule.getNoncurrentVersionExpirationInDays())).end();
            xmlWriter.end();
        }
        if (rule.getAbortIncompleteMultipartUpload() != null) {
            xmlWriter.start("AbortIncompleteMultipartUpload");
            xmlWriter.start("DaysAfterInitiation").value(Integer.toString(rule.getAbortIncompleteMultipartUpload().getDaysAfterInitiation())).end();
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    private void addTransitions(XmlWriter xmlWriter, List<BucketLifecycleConfiguration.Transition> list) {
        if (list != null && !list.isEmpty()) {
            for (BucketLifecycleConfiguration.Transition next : list) {
                if (next != null) {
                    xmlWriter.start("Transition");
                    if (next.getDate() != null) {
                        xmlWriter.start("Date");
                        xmlWriter.value(ServiceUtils.formatIso8601Date(next.getDate()));
                        xmlWriter.end();
                    }
                    if (next.getDays() != -1) {
                        xmlWriter.start("Days");
                        xmlWriter.value(Integer.toString(next.getDays()));
                        xmlWriter.end();
                    }
                    xmlWriter.start("StorageClass");
                    xmlWriter.value(next.getStorageClass().toString());
                    xmlWriter.end();
                    xmlWriter.end();
                }
            }
        }
    }

    private void addNoncurrentTransitions(XmlWriter xmlWriter, List<BucketLifecycleConfiguration.NoncurrentVersionTransition> list) {
        if (list != null && !list.isEmpty()) {
            for (BucketLifecycleConfiguration.NoncurrentVersionTransition next : list) {
                if (next != null) {
                    xmlWriter.start("NoncurrentVersionTransition");
                    if (next.getDays() != -1) {
                        xmlWriter.start("NoncurrentDays");
                        xmlWriter.value(Integer.toString(next.getDays()));
                        xmlWriter.end();
                    }
                    xmlWriter.start("StorageClass");
                    xmlWriter.value(next.getStorageClass().toString());
                    xmlWriter.end();
                    xmlWriter.end();
                }
            }
        }
    }

    private void writeLifecycleFilter(XmlWriter xmlWriter, LifecycleFilter lifecycleFilter) {
        if (lifecycleFilter != null) {
            xmlWriter.start("Filter");
            writeLifecycleFilterPredicate(xmlWriter, lifecycleFilter.getPredicate());
            xmlWriter.end();
        }
    }

    private void writeLifecycleFilterPredicate(XmlWriter xmlWriter, LifecycleFilterPredicate lifecycleFilterPredicate) {
        if (lifecycleFilterPredicate != null) {
            lifecycleFilterPredicate.accept(new LifecyclePredicateVisitorImpl(xmlWriter));
        }
    }

    private class LifecyclePredicateVisitorImpl implements LifecyclePredicateVisitor {
        private final XmlWriter xml;

        public LifecyclePredicateVisitorImpl(XmlWriter xmlWriter) {
            this.xml = xmlWriter;
        }

        public void visit(LifecyclePrefixPredicate lifecyclePrefixPredicate) {
            BucketConfigurationXmlFactory.this.writePrefix(this.xml, lifecyclePrefixPredicate.getPrefix());
        }

        public void visit(LifecycleTagPredicate lifecycleTagPredicate) {
            BucketConfigurationXmlFactory.this.writeTag(this.xml, lifecycleTagPredicate.getTag());
        }

        public void visit(LifecycleAndOperator lifecycleAndOperator) {
            this.xml.start("And");
            for (LifecycleFilterPredicate accept : lifecycleAndOperator.getOperands()) {
                accept.accept(this);
            }
            this.xml.end();
        }
    }

    private boolean hasCurrentExpirationPolicy(BucketLifecycleConfiguration.Rule rule) {
        return (rule.getExpirationInDays() == -1 && rule.getExpirationDate() == null && !rule.isExpiredObjectDeleteMarker()) ? false : true;
    }

    private void writeRule(XmlWriter xmlWriter, CORSRule cORSRule) {
        xmlWriter.start("CORSRule");
        if (cORSRule.getId() != null) {
            xmlWriter.start("ID").value(cORSRule.getId()).end();
        }
        if (cORSRule.getAllowedOrigins() != null) {
            for (String value : cORSRule.getAllowedOrigins()) {
                xmlWriter.start("AllowedOrigin").value(value).end();
            }
        }
        if (cORSRule.getAllowedMethods() != null) {
            for (CORSRule.AllowedMethods allowedMethods : cORSRule.getAllowedMethods()) {
                xmlWriter.start("AllowedMethod").value(allowedMethods.toString()).end();
            }
        }
        if (cORSRule.getMaxAgeSeconds() != 0) {
            xmlWriter.start("MaxAgeSeconds").value(Integer.toString(cORSRule.getMaxAgeSeconds())).end();
        }
        if (cORSRule.getExposedHeaders() != null) {
            for (String value2 : cORSRule.getExposedHeaders()) {
                xmlWriter.start("ExposeHeader").value(value2).end();
            }
        }
        if (cORSRule.getAllowedHeaders() != null) {
            for (String value3 : cORSRule.getAllowedHeaders()) {
                xmlWriter.start("AllowedHeader").value(value3).end();
            }
        }
        xmlWriter.end();
    }

    private void writeRule(XmlWriter xmlWriter, RoutingRule routingRule) {
        xmlWriter.start("RoutingRule");
        RoutingRuleCondition condition = routingRule.getCondition();
        if (condition != null) {
            xmlWriter.start("Condition");
            xmlWriter.start("KeyPrefixEquals");
            if (condition.getKeyPrefixEquals() != null) {
                xmlWriter.value(condition.getKeyPrefixEquals());
            }
            xmlWriter.end();
            if (condition.getHttpErrorCodeReturnedEquals() != null) {
                xmlWriter.start("HttpErrorCodeReturnedEquals ").value(condition.getHttpErrorCodeReturnedEquals()).end();
            }
            xmlWriter.end();
        }
        xmlWriter.start("Redirect");
        RedirectRule redirect = routingRule.getRedirect();
        if (redirect != null) {
            if (redirect.getprotocol() != null) {
                xmlWriter.start("Protocol").value(redirect.getprotocol()).end();
            }
            if (redirect.getHostName() != null) {
                xmlWriter.start("HostName").value(redirect.getHostName()).end();
            }
            if (redirect.getReplaceKeyPrefixWith() != null) {
                xmlWriter.start("ReplaceKeyPrefixWith").value(redirect.getReplaceKeyPrefixWith()).end();
            }
            if (redirect.getReplaceKeyWith() != null) {
                xmlWriter.start("ReplaceKeyWith").value(redirect.getReplaceKeyWith()).end();
            }
            if (redirect.getHttpRedirectCode() != null) {
                xmlWriter.start("HttpRedirectCode").value(redirect.getHttpRedirectCode()).end();
            }
        }
        xmlWriter.end();
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(BucketTaggingConfiguration bucketTaggingConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("Tagging");
        for (TagSet writeRule : bucketTaggingConfiguration.getAllTagSets()) {
            writeRule(xmlWriter, writeRule);
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(InventoryConfiguration inventoryConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("InventoryConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        xmlWriter.start("Id").value(inventoryConfiguration.getId()).end();
        xmlWriter.start("IsEnabled").value(String.valueOf(inventoryConfiguration.isEnabled())).end();
        xmlWriter.start("IncludedObjectVersions").value(inventoryConfiguration.getIncludedObjectVersions()).end();
        writeInventoryDestination(xmlWriter, inventoryConfiguration.getDestination());
        writeInventoryFilter(xmlWriter, inventoryConfiguration.getInventoryFilter());
        addInventorySchedule(xmlWriter, inventoryConfiguration.getSchedule());
        addInventoryOptionalFields(xmlWriter, inventoryConfiguration.getOptionalFields());
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeInventoryDestination(XmlWriter xmlWriter, InventoryDestination inventoryDestination) {
        if (inventoryDestination != null) {
            xmlWriter.start("Destination");
            InventoryS3BucketDestination s3BucketDestination = inventoryDestination.getS3BucketDestination();
            if (s3BucketDestination != null) {
                xmlWriter.start("S3BucketDestination");
                addParameterIfNotNull(xmlWriter, "AccountId", s3BucketDestination.getAccountId());
                addParameterIfNotNull(xmlWriter, "Bucket", s3BucketDestination.getBucketArn());
                addParameterIfNotNull(xmlWriter, "Prefix", s3BucketDestination.getPrefix());
                addParameterIfNotNull(xmlWriter, "Format", s3BucketDestination.getFormat());
                xmlWriter.end();
            }
            xmlWriter.end();
        }
    }

    private void writeInventoryFilter(XmlWriter xmlWriter, InventoryFilter inventoryFilter) {
        if (inventoryFilter != null) {
            xmlWriter.start("Filter");
            writeInventoryFilterPredicate(xmlWriter, inventoryFilter.getPredicate());
            xmlWriter.end();
        }
    }

    private void writeInventoryFilterPredicate(XmlWriter xmlWriter, InventoryFilterPredicate inventoryFilterPredicate) {
        if (inventoryFilterPredicate != null && (inventoryFilterPredicate instanceof InventoryPrefixPredicate)) {
            writePrefix(xmlWriter, ((InventoryPrefixPredicate) inventoryFilterPredicate).getPrefix());
        }
    }

    private void addInventorySchedule(XmlWriter xmlWriter, InventorySchedule inventorySchedule) {
        if (inventorySchedule != null) {
            xmlWriter.start("Schedule");
            addParameterIfNotNull(xmlWriter, "Frequency", inventorySchedule.getFrequency());
            xmlWriter.end();
        }
    }

    private void addInventoryOptionalFields(XmlWriter xmlWriter, List<String> list) {
        if (!isNullOrEmpty(list)) {
            xmlWriter.start("OptionalFields");
            for (String value : list) {
                xmlWriter.start("Field").value(value).end();
            }
            xmlWriter.end();
        }
    }

    private void writeRule(XmlWriter xmlWriter, TagSet tagSet) {
        xmlWriter.start("TagSet");
        for (String str : tagSet.getAllTags().keySet()) {
            xmlWriter.start("Tag");
            xmlWriter.start("Key").value(str).end();
            xmlWriter.start("Value").value(tagSet.getTag(str)).end();
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    private boolean hasTags(TagSet tagSet) {
        return (tagSet == null || tagSet.getAllTags() == null || tagSet.getAllTags().size() <= 0) ? false : true;
    }

    public byte[] convertToXmlByteArray(AnalyticsConfiguration analyticsConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("AnalyticsConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        addParameterIfNotNull(xmlWriter, "Id", analyticsConfiguration.getId());
        writeAnalyticsFilter(xmlWriter, analyticsConfiguration.getFilter());
        writeStorageClassAnalysis(xmlWriter, analyticsConfiguration.getStorageClassAnalysis());
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeAnalyticsFilter(XmlWriter xmlWriter, AnalyticsFilter analyticsFilter) {
        if (analyticsFilter != null) {
            xmlWriter.start("Filter");
            writeAnalyticsFilterPredicate(xmlWriter, analyticsFilter.getPredicate());
            xmlWriter.end();
        }
    }

    private void writeAnalyticsFilterPredicate(XmlWriter xmlWriter, AnalyticsFilterPredicate analyticsFilterPredicate) {
        if (analyticsFilterPredicate != null) {
            analyticsFilterPredicate.accept(new AnalyticsPredicateVisitorImpl(xmlWriter));
        }
    }

    private void writeStorageClassAnalysis(XmlWriter xmlWriter, StorageClassAnalysis storageClassAnalysis) {
        if (storageClassAnalysis != null) {
            xmlWriter.start("StorageClassAnalysis");
            if (storageClassAnalysis.getDataExport() != null) {
                StorageClassAnalysisDataExport dataExport = storageClassAnalysis.getDataExport();
                xmlWriter.start("DataExport");
                addParameterIfNotNull(xmlWriter, "OutputSchemaVersion", dataExport.getOutputSchemaVersion());
                writeAnalyticsExportDestination(xmlWriter, dataExport.getDestination());
                xmlWriter.end();
            }
            xmlWriter.end();
        }
    }

    private void writeAnalyticsExportDestination(XmlWriter xmlWriter, AnalyticsExportDestination analyticsExportDestination) {
        if (analyticsExportDestination != null) {
            xmlWriter.start("Destination");
            if (analyticsExportDestination.getS3BucketDestination() != null) {
                xmlWriter.start("S3BucketDestination");
                AnalyticsS3BucketDestination s3BucketDestination = analyticsExportDestination.getS3BucketDestination();
                addParameterIfNotNull(xmlWriter, "Format", s3BucketDestination.getFormat());
                addParameterIfNotNull(xmlWriter, "BucketAccountId", s3BucketDestination.getBucketAccountId());
                addParameterIfNotNull(xmlWriter, "Bucket", s3BucketDestination.getBucketArn());
                addParameterIfNotNull(xmlWriter, "Prefix", s3BucketDestination.getPrefix());
                xmlWriter.end();
            }
            xmlWriter.end();
        }
    }

    private class AnalyticsPredicateVisitorImpl implements AnalyticsPredicateVisitor {
        private final XmlWriter xml;

        public AnalyticsPredicateVisitorImpl(XmlWriter xmlWriter) {
            this.xml = xmlWriter;
        }

        public void visit(AnalyticsPrefixPredicate analyticsPrefixPredicate) {
            BucketConfigurationXmlFactory.this.writePrefix(this.xml, analyticsPrefixPredicate.getPrefix());
        }

        public void visit(AnalyticsTagPredicate analyticsTagPredicate) {
            BucketConfigurationXmlFactory.this.writeTag(this.xml, analyticsTagPredicate.getTag());
        }

        public void visit(AnalyticsAndOperator analyticsAndOperator) {
            this.xml.start("And");
            for (AnalyticsFilterPredicate accept : analyticsAndOperator.getOperands()) {
                accept.accept(this);
            }
            this.xml.end();
        }
    }

    public byte[] convertToXmlByteArray(MetricsConfiguration metricsConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("MetricsConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        addParameterIfNotNull(xmlWriter, "Id", metricsConfiguration.getId());
        writeMetricsFilter(xmlWriter, metricsConfiguration.getFilter());
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeMetricsFilter(XmlWriter xmlWriter, MetricsFilter metricsFilter) {
        if (metricsFilter != null) {
            xmlWriter.start("Filter");
            writeMetricsFilterPredicate(xmlWriter, metricsFilter.getPredicate());
            xmlWriter.end();
        }
    }

    private void writeMetricsFilterPredicate(XmlWriter xmlWriter, MetricsFilterPredicate metricsFilterPredicate) {
        if (metricsFilterPredicate != null) {
            metricsFilterPredicate.accept(new MetricsPredicateVisitorImpl(xmlWriter));
        }
    }

    private class MetricsPredicateVisitorImpl implements MetricsPredicateVisitor {
        private final XmlWriter xml;

        public MetricsPredicateVisitorImpl(XmlWriter xmlWriter) {
            this.xml = xmlWriter;
        }

        public void visit(MetricsPrefixPredicate metricsPrefixPredicate) {
            BucketConfigurationXmlFactory.this.writePrefix(this.xml, metricsPrefixPredicate.getPrefix());
        }

        public void visit(MetricsTagPredicate metricsTagPredicate) {
            BucketConfigurationXmlFactory.this.writeTag(this.xml, metricsTagPredicate.getTag());
        }

        public void visit(MetricsAndOperator metricsAndOperator) {
            this.xml.start("And");
            for (MetricsFilterPredicate accept : metricsAndOperator.getOperands()) {
                accept.accept(this);
            }
            this.xml.end();
        }
    }

    private void addParameterIfNotNull(XmlWriter xmlWriter, String str, String str2) {
        if (str2 != null) {
            xmlWriter.start(str).value(str2).end();
        }
    }

    private void writePrefix(XmlWriter xmlWriter, BucketLifecycleConfiguration.Rule rule) {
        if (rule.getFilter() == null) {
            xmlWriter.start("Prefix").value(rule.getPrefix() == null ? "" : rule.getPrefix()).end();
        } else if (rule.getPrefix() != null) {
            throw new IllegalArgumentException("Prefix cannot be used with Filter. Use LifecyclePrefixPredicate to create a LifecycleFilter");
        }
    }

    /* access modifiers changed from: private */
    public void writePrefix(XmlWriter xmlWriter, String str) {
        addParameterIfNotNull(xmlWriter, "Prefix", str);
    }

    /* access modifiers changed from: private */
    public void writeTag(XmlWriter xmlWriter, Tag tag) {
        if (tag != null) {
            xmlWriter.start("Tag");
            xmlWriter.start("Key").value(tag.getKey()).end();
            xmlWriter.start("Value").value(tag.getValue()).end();
            xmlWriter.end();
        }
    }

    private <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
