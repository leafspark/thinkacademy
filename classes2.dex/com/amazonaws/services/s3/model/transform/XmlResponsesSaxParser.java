package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlResponsesSaxParser {
    /* access modifiers changed from: private */
    public static final Log log = LogFactory.getLog(XmlResponsesSaxParser.class);
    private final boolean sanitizeXmlDocument = true;
    private XMLReader xr = null;

    public XmlResponsesSaxParser() throws AmazonClientException {
        try {
            this.xr = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            try {
                this.xr = XMLReaderFactory.createXMLReader();
            } catch (SAXException unused) {
                throw new AmazonClientException("Couldn't initialize a sax driver for the XMLReader", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void parseXmlInputStream(DefaultHandler defaultHandler, InputStream inputStream) throws IOException {
        try {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Parsing XML response document with handler: " + defaultHandler.getClass());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Key.STRING_CHARSET_NAME));
            this.xr.setContentHandler(defaultHandler);
            this.xr.setErrorHandler(defaultHandler);
            this.xr.parse(new InputSource(bufferedReader));
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                if (log.isErrorEnabled()) {
                    log.error("Unable to close response InputStream up after XML parse failure", e2);
                }
            }
            throw new AmazonClientException("Failed to parse XML document with handler " + defaultHandler.getClass(), th);
        }
    }

    /* access modifiers changed from: protected */
    public InputStream sanitizeXmlDocument(DefaultHandler defaultHandler, InputStream inputStream) throws IOException {
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Sanitizing XML document destined for handler " + defaultHandler.getClass());
        }
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Key.STRING_CHARSET_NAME));
            char[] cArr = new char[8192];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    bufferedReader.close();
                    return new ByteArrayInputStream(sb.toString().replaceAll("\r", "&#013;").getBytes(StringUtils.UTF8));
                }
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                if (log.isErrorEnabled()) {
                    log.error("Unable to close response InputStream after failure sanitizing XML document", e2);
                }
            }
            throw new AmazonClientException("Failed to sanitize XML document destined for handler " + defaultHandler.getClass(), th);
        }
    }

    /* access modifiers changed from: private */
    public static String checkForEmptyString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            Log log2 = log;
            log2.error("Unable to parse integer value '" + str + "'", e);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            Log log2 = log;
            log2.error("Unable to parse long value '" + str + "'", e);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public static String findAttributeValue(String str, Attributes attributes) {
        if (!StringUtils.isBlank(str) && attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).trim().equalsIgnoreCase(str.trim())) {
                    return attributes.getValue(i);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static String decodeIfSpecified(String str, boolean z) {
        return z ? S3HttpUtils.urlDecode(str) : str;
    }

    public ListBucketHandler parseListBucketObjectsResponse(InputStream inputStream, boolean z) throws IOException {
        ListBucketHandler listBucketHandler = new ListBucketHandler(z);
        parseXmlInputStream(listBucketHandler, sanitizeXmlDocument(listBucketHandler, inputStream));
        return listBucketHandler;
    }

    public ListObjectsV2Handler parseListObjectsV2Response(InputStream inputStream, boolean z) throws IOException {
        ListObjectsV2Handler listObjectsV2Handler = new ListObjectsV2Handler(z);
        parseXmlInputStream(listObjectsV2Handler, sanitizeXmlDocument(listObjectsV2Handler, inputStream));
        return listObjectsV2Handler;
    }

    public ListVersionsHandler parseListVersionsResponse(InputStream inputStream, boolean z) throws IOException {
        ListVersionsHandler listVersionsHandler = new ListVersionsHandler(z);
        parseXmlInputStream(listVersionsHandler, sanitizeXmlDocument(listVersionsHandler, inputStream));
        return listVersionsHandler;
    }

    public ListAllMyBucketsHandler parseListMyBucketsResponse(InputStream inputStream) throws IOException {
        ListAllMyBucketsHandler listAllMyBucketsHandler = new ListAllMyBucketsHandler();
        parseXmlInputStream(listAllMyBucketsHandler, sanitizeXmlDocument(listAllMyBucketsHandler, inputStream));
        return listAllMyBucketsHandler;
    }

    public AccessControlListHandler parseAccessControlListResponse(InputStream inputStream) throws IOException {
        AccessControlListHandler accessControlListHandler = new AccessControlListHandler();
        parseXmlInputStream(accessControlListHandler, inputStream);
        return accessControlListHandler;
    }

    public BucketLoggingConfigurationHandler parseLoggingStatusResponse(InputStream inputStream) throws IOException {
        BucketLoggingConfigurationHandler bucketLoggingConfigurationHandler = new BucketLoggingConfigurationHandler();
        parseXmlInputStream(bucketLoggingConfigurationHandler, inputStream);
        return bucketLoggingConfigurationHandler;
    }

    public BucketLifecycleConfigurationHandler parseBucketLifecycleConfigurationResponse(InputStream inputStream) throws IOException {
        BucketLifecycleConfigurationHandler bucketLifecycleConfigurationHandler = new BucketLifecycleConfigurationHandler();
        parseXmlInputStream(bucketLifecycleConfigurationHandler, inputStream);
        return bucketLifecycleConfigurationHandler;
    }

    public BucketCrossOriginConfigurationHandler parseBucketCrossOriginConfigurationResponse(InputStream inputStream) throws IOException {
        BucketCrossOriginConfigurationHandler bucketCrossOriginConfigurationHandler = new BucketCrossOriginConfigurationHandler();
        parseXmlInputStream(bucketCrossOriginConfigurationHandler, inputStream);
        return bucketCrossOriginConfigurationHandler;
    }

    public String parseBucketLocationResponse(InputStream inputStream) throws IOException {
        BucketLocationHandler bucketLocationHandler = new BucketLocationHandler();
        parseXmlInputStream(bucketLocationHandler, inputStream);
        return bucketLocationHandler.getLocation();
    }

    public BucketVersioningConfigurationHandler parseVersioningConfigurationResponse(InputStream inputStream) throws IOException {
        BucketVersioningConfigurationHandler bucketVersioningConfigurationHandler = new BucketVersioningConfigurationHandler();
        parseXmlInputStream(bucketVersioningConfigurationHandler, inputStream);
        return bucketVersioningConfigurationHandler;
    }

    public BucketWebsiteConfigurationHandler parseWebsiteConfigurationResponse(InputStream inputStream) throws IOException {
        BucketWebsiteConfigurationHandler bucketWebsiteConfigurationHandler = new BucketWebsiteConfigurationHandler();
        parseXmlInputStream(bucketWebsiteConfigurationHandler, inputStream);
        return bucketWebsiteConfigurationHandler;
    }

    public BucketReplicationConfigurationHandler parseReplicationConfigurationResponse(InputStream inputStream) throws IOException {
        BucketReplicationConfigurationHandler bucketReplicationConfigurationHandler = new BucketReplicationConfigurationHandler();
        parseXmlInputStream(bucketReplicationConfigurationHandler, inputStream);
        return bucketReplicationConfigurationHandler;
    }

    public BucketTaggingConfigurationHandler parseTaggingConfigurationResponse(InputStream inputStream) throws IOException {
        BucketTaggingConfigurationHandler bucketTaggingConfigurationHandler = new BucketTaggingConfigurationHandler();
        parseXmlInputStream(bucketTaggingConfigurationHandler, inputStream);
        return bucketTaggingConfigurationHandler;
    }

    public BucketAccelerateConfigurationHandler parseAccelerateConfigurationResponse(InputStream inputStream) throws IOException {
        BucketAccelerateConfigurationHandler bucketAccelerateConfigurationHandler = new BucketAccelerateConfigurationHandler();
        parseXmlInputStream(bucketAccelerateConfigurationHandler, inputStream);
        return bucketAccelerateConfigurationHandler;
    }

    public DeleteObjectsHandler parseDeletedObjectsResult(InputStream inputStream) throws IOException {
        DeleteObjectsHandler deleteObjectsHandler = new DeleteObjectsHandler();
        parseXmlInputStream(deleteObjectsHandler, inputStream);
        return deleteObjectsHandler;
    }

    public CopyObjectResultHandler parseCopyObjectResponse(InputStream inputStream) throws IOException {
        CopyObjectResultHandler copyObjectResultHandler = new CopyObjectResultHandler();
        parseXmlInputStream(copyObjectResultHandler, inputStream);
        return copyObjectResultHandler;
    }

    public CompleteMultipartUploadHandler parseCompleteMultipartUploadResponse(InputStream inputStream) throws IOException {
        CompleteMultipartUploadHandler completeMultipartUploadHandler = new CompleteMultipartUploadHandler();
        parseXmlInputStream(completeMultipartUploadHandler, inputStream);
        return completeMultipartUploadHandler;
    }

    public InitiateMultipartUploadHandler parseInitiateMultipartUploadResponse(InputStream inputStream) throws IOException {
        InitiateMultipartUploadHandler initiateMultipartUploadHandler = new InitiateMultipartUploadHandler();
        parseXmlInputStream(initiateMultipartUploadHandler, inputStream);
        return initiateMultipartUploadHandler;
    }

    public ListMultipartUploadsHandler parseListMultipartUploadsResponse(InputStream inputStream) throws IOException {
        ListMultipartUploadsHandler listMultipartUploadsHandler = new ListMultipartUploadsHandler();
        parseXmlInputStream(listMultipartUploadsHandler, inputStream);
        return listMultipartUploadsHandler;
    }

    public ListPartsHandler parseListPartsResponse(InputStream inputStream) throws IOException {
        ListPartsHandler listPartsHandler = new ListPartsHandler();
        parseXmlInputStream(listPartsHandler, inputStream);
        return listPartsHandler;
    }

    public GetObjectTaggingHandler parseObjectTaggingResponse(InputStream inputStream) throws IOException {
        GetObjectTaggingHandler getObjectTaggingHandler = new GetObjectTaggingHandler();
        parseXmlInputStream(getObjectTaggingHandler, inputStream);
        return getObjectTaggingHandler;
    }

    public GetBucketMetricsConfigurationHandler parseGetBucketMetricsConfigurationResponse(InputStream inputStream) throws IOException {
        GetBucketMetricsConfigurationHandler getBucketMetricsConfigurationHandler = new GetBucketMetricsConfigurationHandler();
        parseXmlInputStream(getBucketMetricsConfigurationHandler, inputStream);
        return getBucketMetricsConfigurationHandler;
    }

    public ListBucketMetricsConfigurationsHandler parseListBucketMetricsConfigurationsResponse(InputStream inputStream) throws IOException {
        ListBucketMetricsConfigurationsHandler listBucketMetricsConfigurationsHandler = new ListBucketMetricsConfigurationsHandler();
        parseXmlInputStream(listBucketMetricsConfigurationsHandler, inputStream);
        return listBucketMetricsConfigurationsHandler;
    }

    public GetBucketAnalyticsConfigurationHandler parseGetBucketAnalyticsConfigurationResponse(InputStream inputStream) throws IOException {
        GetBucketAnalyticsConfigurationHandler getBucketAnalyticsConfigurationHandler = new GetBucketAnalyticsConfigurationHandler();
        parseXmlInputStream(getBucketAnalyticsConfigurationHandler, inputStream);
        return getBucketAnalyticsConfigurationHandler;
    }

    public ListBucketAnalyticsConfigurationHandler parseListBucketAnalyticsConfigurationResponse(InputStream inputStream) throws IOException {
        ListBucketAnalyticsConfigurationHandler listBucketAnalyticsConfigurationHandler = new ListBucketAnalyticsConfigurationHandler();
        parseXmlInputStream(listBucketAnalyticsConfigurationHandler, inputStream);
        return listBucketAnalyticsConfigurationHandler;
    }

    public GetBucketInventoryConfigurationHandler parseGetBucketInventoryConfigurationResponse(InputStream inputStream) throws IOException {
        GetBucketInventoryConfigurationHandler getBucketInventoryConfigurationHandler = new GetBucketInventoryConfigurationHandler();
        parseXmlInputStream(getBucketInventoryConfigurationHandler, inputStream);
        return getBucketInventoryConfigurationHandler;
    }

    public ListBucketInventoryConfigurationsHandler parseBucketListInventoryConfigurationsResponse(InputStream inputStream) throws IOException {
        ListBucketInventoryConfigurationsHandler listBucketInventoryConfigurationsHandler = new ListBucketInventoryConfigurationsHandler();
        parseXmlInputStream(listBucketInventoryConfigurationsHandler, inputStream);
        return listBucketInventoryConfigurationsHandler;
    }

    public RequestPaymentConfigurationHandler parseRequestPaymentConfigurationResponse(InputStream inputStream) throws IOException {
        RequestPaymentConfigurationHandler requestPaymentConfigurationHandler = new RequestPaymentConfigurationHandler();
        parseXmlInputStream(requestPaymentConfigurationHandler, inputStream);
        return requestPaymentConfigurationHandler;
    }

    public static class ListBucketHandler extends AbstractHandler {
        private S3ObjectSummary currentObject = null;
        private Owner currentOwner = null;
        private String lastKey = null;
        private final ObjectListing objectListing = new ObjectListing();
        private final boolean shouldSDKDecodeResponse;

        public ListBucketHandler(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public ObjectListing getObjectListing() {
            return this.objectListing;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListBucketResult")) {
                if (str2.equals("Contents")) {
                    S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                    this.currentObject = s3ObjectSummary;
                    s3ObjectSummary.setBucketName(this.objectListing.getBucketName());
                }
            } else if (in("ListBucketResult", "Contents") && str2.equals("Owner")) {
                this.currentOwner = new Owner();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v86, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doEndElement(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
            /*
                r4 = this;
                boolean r5 = r4.atTopLevel()
                r7 = 1
                r0 = 0
                java.lang.String r1 = "ListBucketResult"
                if (r5 == 0) goto L_0x007d
                boolean r5 = r6.equals(r1)
                if (r5 == 0) goto L_0x029e
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                boolean r5 = r5.isTruncated()
                if (r5 == 0) goto L_0x029e
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r5 = r5.getNextMarker()
                if (r5 != 0) goto L_0x029e
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.util.List r5 = r5.getObjectSummaries()
                boolean r5 = r5.isEmpty()
                if (r5 != 0) goto L_0x0048
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.util.List r5 = r5.getObjectSummaries()
                com.amazonaws.services.s3.model.ObjectListing r6 = r4.objectListing
                java.util.List r6 = r6.getObjectSummaries()
                int r6 = r6.size()
                int r6 = r6 - r7
                java.lang.Object r5 = r5.get(r6)
                com.amazonaws.services.s3.model.S3ObjectSummary r5 = (com.amazonaws.services.s3.model.S3ObjectSummary) r5
                java.lang.String r0 = r5.getKey()
                goto L_0x0076
            L_0x0048:
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.util.List r5 = r5.getCommonPrefixes()
                boolean r5 = r5.isEmpty()
                if (r5 != 0) goto L_0x006d
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.util.List r5 = r5.getCommonPrefixes()
                com.amazonaws.services.s3.model.ObjectListing r6 = r4.objectListing
                java.util.List r6 = r6.getCommonPrefixes()
                int r6 = r6.size()
                int r6 = r6 - r7
                java.lang.Object r5 = r5.get(r6)
                r0 = r5
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x0076
            L_0x006d:
                com.amazonaws.logging.Log r5 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.log
                java.lang.String r6 = "S3 response indicates truncated results, but contains no object summaries or common prefixes."
                r5.error(r6)
            L_0x0076:
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                r5.setNextMarker(r0)
                goto L_0x029e
            L_0x007d:
                java.lang.String[] r5 = new java.lang.String[]{r1}
                boolean r5 = r4.in(r5)
                java.lang.String r2 = "Prefix"
                java.lang.String r3 = "Contents"
                if (r5 == 0) goto L_0x01bd
                java.lang.String r5 = "Name"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x00c6
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                r5.setBucketName(r6)
                com.amazonaws.logging.Log r5 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.log
                boolean r5 = r5.isDebugEnabled()
                if (r5 == 0) goto L_0x029e
                com.amazonaws.logging.Log r5 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.log
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Examining listing for bucket: "
                r6.append(r7)
                com.amazonaws.services.s3.model.ObjectListing r7 = r4.objectListing
                java.lang.String r7 = r7.getBucketName()
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r5.debug(r6)
                goto L_0x029e
            L_0x00c6:
                boolean r5 = r6.equals(r2)
                if (r5 == 0) goto L_0x00e1
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.checkForEmptyString(r6)
                boolean r7 = r4.shouldSDKDecodeResponse
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.decodeIfSpecified(r6, r7)
                r5.setPrefix(r6)
                goto L_0x029e
            L_0x00e1:
                java.lang.String r5 = "Marker"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x00fe
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.checkForEmptyString(r6)
                boolean r7 = r4.shouldSDKDecodeResponse
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.decodeIfSpecified(r6, r7)
                r5.setMarker(r6)
                goto L_0x029e
            L_0x00fe:
                java.lang.String r5 = "NextMarker"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x0117
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                boolean r7 = r4.shouldSDKDecodeResponse
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.decodeIfSpecified(r6, r7)
                r5.setNextMarker(r6)
                goto L_0x029e
            L_0x0117:
                java.lang.String r5 = "MaxKeys"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x012e
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                int r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.parseInt(r6)
                r5.setMaxKeys(r6)
                goto L_0x029e
            L_0x012e:
                java.lang.String r5 = "Delimiter"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x014b
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.checkForEmptyString(r6)
                boolean r7 = r4.shouldSDKDecodeResponse
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.decodeIfSpecified(r6, r7)
                r5.setDelimiter(r6)
                goto L_0x029e
            L_0x014b:
                java.lang.String r5 = "EncodingType"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x0162
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.lang.String r6 = r4.getText()
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.checkForEmptyString(r6)
                r5.setEncodingType(r6)
                goto L_0x029e
            L_0x0162:
                java.lang.String r5 = "IsTruncated"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x01a8
                java.lang.String r5 = r4.getText()
                java.lang.String r5 = com.amazonaws.util.StringUtils.lowerCase(r5)
                java.lang.String r6 = "false"
                boolean r6 = r5.startsWith(r6)
                if (r6 == 0) goto L_0x0182
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                r6 = 0
                r5.setTruncated(r6)
                goto L_0x029e
            L_0x0182:
                java.lang.String r6 = "true"
                boolean r6 = r5.startsWith(r6)
                if (r6 == 0) goto L_0x0191
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                r5.setTruncated(r7)
                goto L_0x029e
            L_0x0191:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r0 = "Invalid value for IsTruncated field: "
                r7.append(r0)
                r7.append(r5)
                java.lang.String r5 = r7.toString()
                r6.<init>(r5)
                throw r6
            L_0x01a8:
                boolean r5 = r6.equals(r3)
                if (r5 == 0) goto L_0x029e
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.util.List r5 = r5.getObjectSummaries()
                com.amazonaws.services.s3.model.S3ObjectSummary r6 = r4.currentObject
                r5.add(r6)
                r4.currentObject = r0
                goto L_0x029e
            L_0x01bd:
                java.lang.String[] r5 = new java.lang.String[]{r1, r3}
                boolean r5 = r4.in(r5)
                java.lang.String r7 = "Owner"
                if (r5 == 0) goto L_0x024b
                java.lang.String r5 = "Key"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x01e4
                java.lang.String r5 = r4.getText()
                r4.lastKey = r5
                com.amazonaws.services.s3.model.S3ObjectSummary r6 = r4.currentObject
                boolean r7 = r4.shouldSDKDecodeResponse
                java.lang.String r5 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.decodeIfSpecified(r5, r7)
                r6.setKey(r5)
                goto L_0x029e
            L_0x01e4:
                java.lang.String r5 = "LastModified"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x01fb
                com.amazonaws.services.s3.model.S3ObjectSummary r5 = r4.currentObject
                java.lang.String r6 = r4.getText()
                java.util.Date r6 = com.amazonaws.services.s3.internal.ServiceUtils.parseIso8601Date(r6)
                r5.setLastModified(r6)
                goto L_0x029e
            L_0x01fb:
                java.lang.String r5 = "ETag"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x0212
                com.amazonaws.services.s3.model.S3ObjectSummary r5 = r4.currentObject
                java.lang.String r6 = r4.getText()
                java.lang.String r6 = com.amazonaws.services.s3.internal.ServiceUtils.removeQuotes(r6)
                r5.setETag(r6)
                goto L_0x029e
            L_0x0212:
                java.lang.String r5 = "Size"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x0229
                com.amazonaws.services.s3.model.S3ObjectSummary r5 = r4.currentObject
                java.lang.String r6 = r4.getText()
                long r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.parseLong(r6)
                r5.setSize(r6)
                goto L_0x029e
            L_0x0229:
                java.lang.String r5 = "StorageClass"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x023b
                com.amazonaws.services.s3.model.S3ObjectSummary r5 = r4.currentObject
                java.lang.String r6 = r4.getText()
                r5.setStorageClass(r6)
                goto L_0x029e
            L_0x023b:
                boolean r5 = r6.equals(r7)
                if (r5 == 0) goto L_0x029e
                com.amazonaws.services.s3.model.S3ObjectSummary r5 = r4.currentObject
                com.amazonaws.services.s3.model.Owner r6 = r4.currentOwner
                r5.setOwner(r6)
                r4.currentOwner = r0
                goto L_0x029e
            L_0x024b:
                java.lang.String[] r5 = new java.lang.String[]{r1, r3, r7}
                boolean r5 = r4.in(r5)
                if (r5 == 0) goto L_0x0279
                java.lang.String r5 = "ID"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x0267
                com.amazonaws.services.s3.model.Owner r5 = r4.currentOwner
                java.lang.String r6 = r4.getText()
                r5.setId(r6)
                goto L_0x029e
            L_0x0267:
                java.lang.String r5 = "DisplayName"
                boolean r5 = r6.equals(r5)
                if (r5 == 0) goto L_0x029e
                com.amazonaws.services.s3.model.Owner r5 = r4.currentOwner
                java.lang.String r6 = r4.getText()
                r5.setDisplayName(r6)
                goto L_0x029e
            L_0x0279:
                java.lang.String r5 = "CommonPrefixes"
                java.lang.String[] r5 = new java.lang.String[]{r1, r5}
                boolean r5 = r4.in(r5)
                if (r5 == 0) goto L_0x029e
                boolean r5 = r6.equals(r2)
                if (r5 == 0) goto L_0x029e
                com.amazonaws.services.s3.model.ObjectListing r5 = r4.objectListing
                java.util.List r5 = r5.getCommonPrefixes()
                java.lang.String r6 = r4.getText()
                boolean r7 = r4.shouldSDKDecodeResponse
                java.lang.String r6 = com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.decodeIfSpecified(r6, r7)
                r5.add(r6)
            L_0x029e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListBucketHandler.doEndElement(java.lang.String, java.lang.String, java.lang.String):void");
        }
    }

    public static class ListObjectsV2Handler extends AbstractHandler {
        private S3ObjectSummary currentObject = null;
        private Owner currentOwner = null;
        private String lastKey = null;
        private final ListObjectsV2Result result = new ListObjectsV2Result();
        private final boolean shouldSDKDecodeResponse;

        public ListObjectsV2Handler(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public ListObjectsV2Result getResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListBucketResult")) {
                if (str2.equals("Contents")) {
                    S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                    this.currentObject = s3ObjectSummary;
                    s3ObjectSummary.setBucketName(this.result.getBucketName());
                }
            } else if (in("ListBucketResult", "Contents") && str2.equals("Owner")) {
                this.currentOwner = new Owner();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            String str4 = null;
            if (atTopLevel()) {
                if (str2.equals("ListBucketResult") && this.result.isTruncated() && this.result.getNextContinuationToken() == null) {
                    if (!this.result.getObjectSummaries().isEmpty()) {
                        str4 = ((S3ObjectSummary) this.result.getObjectSummaries().get(this.result.getObjectSummaries().size() - 1)).getKey();
                    } else {
                        XmlResponsesSaxParser.log.error("S3 response indicates truncated results, but contains no object summaries.");
                    }
                    this.result.setNextContinuationToken(str4);
                }
            } else if (in("ListBucketResult")) {
                if (str2.equals("Name")) {
                    this.result.setBucketName(getText());
                    if (XmlResponsesSaxParser.log.isDebugEnabled()) {
                        Log access$000 = XmlResponsesSaxParser.log;
                        access$000.debug("Examining listing for bucket: " + this.result.getBucketName());
                    }
                } else if (str2.equals("Prefix")) {
                    this.result.setPrefix(XmlResponsesSaxParser.decodeIfSpecified(XmlResponsesSaxParser.checkForEmptyString(getText()), this.shouldSDKDecodeResponse));
                } else if (str2.equals("MaxKeys")) {
                    this.result.setMaxKeys(XmlResponsesSaxParser.parseInt(getText()));
                } else if (str2.equals("NextContinuationToken")) {
                    this.result.setNextContinuationToken(getText());
                } else if (str2.equals("ContinuationToken")) {
                    this.result.setContinuationToken(getText());
                } else if (str2.equals("StartAfter")) {
                    this.result.setStartAfter(XmlResponsesSaxParser.decodeIfSpecified(getText(), this.shouldSDKDecodeResponse));
                } else if (str2.equals("KeyCount")) {
                    this.result.setKeyCount(XmlResponsesSaxParser.parseInt(getText()));
                } else if (str2.equals("Delimiter")) {
                    this.result.setDelimiter(XmlResponsesSaxParser.decodeIfSpecified(XmlResponsesSaxParser.checkForEmptyString(getText()), this.shouldSDKDecodeResponse));
                } else if (str2.equals("EncodingType")) {
                    this.result.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("IsTruncated")) {
                    String lowerCase = StringUtils.lowerCase(getText());
                    if (lowerCase.startsWith("false")) {
                        this.result.setTruncated(false);
                    } else if (lowerCase.startsWith("true")) {
                        this.result.setTruncated(true);
                    } else {
                        throw new IllegalStateException("Invalid value for IsTruncated field: " + lowerCase);
                    }
                } else if (str2.equals("Contents")) {
                    this.result.getObjectSummaries().add(this.currentObject);
                    this.currentObject = null;
                }
            } else if (in("ListBucketResult", "Contents")) {
                if (str2.equals("Key")) {
                    String text = getText();
                    this.lastKey = text;
                    this.currentObject.setKey(XmlResponsesSaxParser.decodeIfSpecified(text, this.shouldSDKDecodeResponse));
                } else if (str2.equals("LastModified")) {
                    this.currentObject.setLastModified(ServiceUtils.parseIso8601Date(getText()));
                } else if (str2.equals("ETag")) {
                    this.currentObject.setETag(ServiceUtils.removeQuotes(getText()));
                } else if (str2.equals("Size")) {
                    this.currentObject.setSize(XmlResponsesSaxParser.parseLong(getText()));
                } else if (str2.equals("StorageClass")) {
                    this.currentObject.setStorageClass(getText());
                } else if (str2.equals("Owner")) {
                    this.currentObject.setOwner(this.currentOwner);
                    this.currentOwner = null;
                }
            } else if (in("ListBucketResult", "Contents", "Owner")) {
                if (str2.equals("ID")) {
                    this.currentOwner.setId(getText());
                } else if (str2.equals("DisplayName")) {
                    this.currentOwner.setDisplayName(getText());
                }
            } else if (in("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                this.result.getCommonPrefixes().add(XmlResponsesSaxParser.decodeIfSpecified(getText(), this.shouldSDKDecodeResponse));
            }
        }
    }

    public static class ListAllMyBucketsHandler extends AbstractHandler {
        private final List<Bucket> buckets = new ArrayList();
        private Owner bucketsOwner = null;
        private Bucket currentBucket = null;

        public List<Bucket> getBuckets() {
            return this.buckets;
        }

        public Owner getOwner() {
            return this.bucketsOwner;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListAllMyBucketsResult")) {
                if (str2.equals("Owner")) {
                    this.bucketsOwner = new Owner();
                }
            } else if (in("ListAllMyBucketsResult", "Buckets") && str2.equals("Bucket")) {
                Bucket bucket = new Bucket();
                this.currentBucket = bucket;
                bucket.setOwner(this.bucketsOwner);
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListAllMyBucketsResult", "Owner")) {
                if (str2.equals("ID")) {
                    this.bucketsOwner.setId(getText());
                } else if (str2.equals("DisplayName")) {
                    this.bucketsOwner.setDisplayName(getText());
                }
            } else if (in("ListAllMyBucketsResult", "Buckets")) {
                if (str2.equals("Bucket")) {
                    this.buckets.add(this.currentBucket);
                    this.currentBucket = null;
                }
            } else if (!in("ListAllMyBucketsResult", "Buckets", "Bucket")) {
            } else {
                if (str2.equals("Name")) {
                    this.currentBucket.setName(getText());
                } else if (str2.equals("CreationDate")) {
                    this.currentBucket.setCreationDate(DateUtils.parseISO8601Date(getText()));
                }
            }
        }
    }

    public static class AccessControlListHandler extends AbstractHandler {
        private final AccessControlList accessControlList = new AccessControlList();
        private Grantee currentGrantee = null;
        private Permission currentPermission = null;

        public AccessControlList getAccessControlList() {
            return this.accessControlList;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("AccessControlPolicy")) {
                if (str2.equals("Owner")) {
                    this.accessControlList.setOwner(new Owner());
                }
            } else if (in("AccessControlPolicy", "AccessControlList", "Grant") && str2.equals("Grantee")) {
                String access$500 = XmlResponsesSaxParser.findAttributeValue("xsi:type", attributes);
                if ("AmazonCustomerByEmail".equals(access$500)) {
                    this.currentGrantee = new EmailAddressGrantee((String) null);
                } else if ("CanonicalUser".equals(access$500)) {
                    this.currentGrantee = new CanonicalGrantee((String) null);
                } else {
                    "Group".equals(access$500);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("AccessControlPolicy", "Owner")) {
                if (str2.equals("ID")) {
                    this.accessControlList.getOwner().setId(getText());
                } else if (str2.equals("DisplayName")) {
                    this.accessControlList.getOwner().setDisplayName(getText());
                }
            } else if (in("AccessControlPolicy", "AccessControlList")) {
                if (str2.equals("Grant")) {
                    this.accessControlList.grantPermission(this.currentGrantee, this.currentPermission);
                    this.currentGrantee = null;
                    this.currentPermission = null;
                }
            } else if (in("AccessControlPolicy", "AccessControlList", "Grant")) {
                if (str2.equals("Permission")) {
                    this.currentPermission = Permission.parsePermission(getText());
                }
            } else if (!in("AccessControlPolicy", "AccessControlList", "Grant", "Grantee")) {
            } else {
                if (str2.equals("ID")) {
                    this.currentGrantee.setIdentifier(getText());
                } else if (str2.equals("EmailAddress")) {
                    this.currentGrantee.setIdentifier(getText());
                } else if (str2.equals("URI")) {
                    this.currentGrantee = GroupGrantee.parseGroupGrantee(getText());
                } else if (str2.equals("DisplayName")) {
                    this.currentGrantee.setDisplayName(getText());
                }
            }
        }
    }

    public static class BucketLoggingConfigurationHandler extends AbstractHandler {
        private final BucketLoggingConfiguration bucketLoggingConfiguration = new BucketLoggingConfiguration();

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
        }

        public BucketLoggingConfiguration getBucketLoggingConfiguration() {
            return this.bucketLoggingConfiguration;
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (!in("BucketLoggingStatus", "LoggingEnabled")) {
                return;
            }
            if (str2.equals("TargetBucket")) {
                this.bucketLoggingConfiguration.setDestinationBucketName(getText());
            } else if (str2.equals("TargetPrefix")) {
                this.bucketLoggingConfiguration.setLogFilePrefix(getText());
            }
        }
    }

    public static class BucketLocationHandler extends AbstractHandler {
        private String location = null;

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
        }

        public String getLocation() {
            return this.location;
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (atTopLevel() && str2.equals("LocationConstraint")) {
                String text = getText();
                if (text.length() == 0) {
                    this.location = null;
                } else {
                    this.location = text;
                }
            }
        }
    }

    public static class CopyObjectResultHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {
        private String errorCode = null;
        private String errorHostId = null;
        private String errorMessage = null;
        private String errorRequestId = null;
        private boolean receivedErrorResponse = false;
        private final CopyObjectResult result = new CopyObjectResult();

        /* access modifiers changed from: protected */
        public ServerSideEncryptionResult sseResult() {
            return this.result;
        }

        public Date getLastModified() {
            return this.result.getLastModifiedDate();
        }

        public String getVersionId() {
            return this.result.getVersionId();
        }

        public void setVersionId(String str) {
            this.result.setVersionId(str);
        }

        public Date getExpirationTime() {
            return this.result.getExpirationTime();
        }

        public void setExpirationTime(Date date) {
            this.result.setExpirationTime(date);
        }

        public String getExpirationTimeRuleId() {
            return this.result.getExpirationTimeRuleId();
        }

        public void setExpirationTimeRuleId(String str) {
            this.result.setExpirationTimeRuleId(str);
        }

        public String getETag() {
            return this.result.getETag();
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorHostId() {
            return this.errorHostId;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public String getErrorRequestId() {
            return this.errorRequestId;
        }

        public boolean isErrorResponse() {
            return this.receivedErrorResponse;
        }

        public boolean isRequesterCharged() {
            return this.result.isRequesterCharged();
        }

        public void setRequesterCharged(boolean z) {
            this.result.setRequesterCharged(z);
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (!atTopLevel()) {
                return;
            }
            if (str2.equals("CopyObjectResult") || str2.equals("CopyPartResult")) {
                this.receivedErrorResponse = false;
            } else if (str2.equals("Error")) {
                this.receivedErrorResponse = true;
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("CopyObjectResult") || in("CopyPartResult")) {
                if (str2.equals("LastModified")) {
                    this.result.setLastModifiedDate(ServiceUtils.parseIso8601Date(getText()));
                } else if (str2.equals("ETag")) {
                    this.result.setETag(ServiceUtils.removeQuotes(getText()));
                }
            } else if (!in("Error")) {
            } else {
                if (str2.equals("Code")) {
                    this.errorCode = getText();
                } else if (str2.equals("Message")) {
                    this.errorMessage = getText();
                } else if (str2.equals("RequestId")) {
                    this.errorRequestId = getText();
                } else if (str2.equals("HostId")) {
                    this.errorHostId = getText();
                }
            }
        }
    }

    public static class RequestPaymentConfigurationHandler extends AbstractHandler {
        private String payer = null;

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
        }

        public RequestPaymentConfiguration getConfiguration() {
            return new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.valueOf(this.payer));
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("RequestPaymentConfiguration") && str2.equals("Payer")) {
                this.payer = getText();
            }
        }
    }

    public static class ListVersionsHandler extends AbstractHandler {
        private Owner currentOwner;
        private S3VersionSummary currentVersionSummary;
        private final boolean shouldSDKDecodeResponse;
        private final VersionListing versionListing = new VersionListing();

        public ListVersionsHandler(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public VersionListing getListing() {
            return this.versionListing;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListVersionsResult")) {
                if (str2.equals("Version")) {
                    S3VersionSummary s3VersionSummary = new S3VersionSummary();
                    this.currentVersionSummary = s3VersionSummary;
                    s3VersionSummary.setBucketName(this.versionListing.getBucketName());
                } else if (str2.equals("DeleteMarker")) {
                    S3VersionSummary s3VersionSummary2 = new S3VersionSummary();
                    this.currentVersionSummary = s3VersionSummary2;
                    s3VersionSummary2.setBucketName(this.versionListing.getBucketName());
                    this.currentVersionSummary.setIsDeleteMarker(true);
                }
            } else if ((in("ListVersionsResult", "Version") || in("ListVersionsResult", "DeleteMarker")) && str2.equals("Owner")) {
                this.currentOwner = new Owner();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListVersionsResult")) {
                if (str2.equals("Name")) {
                    this.versionListing.setBucketName(getText());
                } else if (str2.equals("Prefix")) {
                    this.versionListing.setPrefix(XmlResponsesSaxParser.decodeIfSpecified(XmlResponsesSaxParser.checkForEmptyString(getText()), this.shouldSDKDecodeResponse));
                } else if (str2.equals("KeyMarker")) {
                    this.versionListing.setKeyMarker(XmlResponsesSaxParser.decodeIfSpecified(XmlResponsesSaxParser.checkForEmptyString(getText()), this.shouldSDKDecodeResponse));
                } else if (str2.equals("VersionIdMarker")) {
                    this.versionListing.setVersionIdMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("MaxKeys")) {
                    this.versionListing.setMaxKeys(Integer.parseInt(getText()));
                } else if (str2.equals("Delimiter")) {
                    this.versionListing.setDelimiter(XmlResponsesSaxParser.decodeIfSpecified(XmlResponsesSaxParser.checkForEmptyString(getText()), this.shouldSDKDecodeResponse));
                } else if (str2.equals("EncodingType")) {
                    this.versionListing.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("NextKeyMarker")) {
                    this.versionListing.setNextKeyMarker(XmlResponsesSaxParser.decodeIfSpecified(XmlResponsesSaxParser.checkForEmptyString(getText()), this.shouldSDKDecodeResponse));
                } else if (str2.equals("NextVersionIdMarker")) {
                    this.versionListing.setNextVersionIdMarker(getText());
                } else if (str2.equals("IsTruncated")) {
                    this.versionListing.setTruncated("true".equals(getText()));
                } else if (str2.equals("Version") || str2.equals("DeleteMarker")) {
                    this.versionListing.getVersionSummaries().add(this.currentVersionSummary);
                    this.currentVersionSummary = null;
                }
            } else if (in("ListVersionsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    String access$100 = XmlResponsesSaxParser.checkForEmptyString(getText());
                    List commonPrefixes = this.versionListing.getCommonPrefixes();
                    if (this.shouldSDKDecodeResponse) {
                        access$100 = S3HttpUtils.urlDecode(access$100);
                    }
                    commonPrefixes.add(access$100);
                }
            } else if (in("ListVersionsResult", "Version") || in("ListVersionsResult", "DeleteMarker")) {
                if (str2.equals("Key")) {
                    this.currentVersionSummary.setKey(XmlResponsesSaxParser.decodeIfSpecified(getText(), this.shouldSDKDecodeResponse));
                } else if (str2.equals("VersionId")) {
                    this.currentVersionSummary.setVersionId(getText());
                } else if (str2.equals("IsLatest")) {
                    this.currentVersionSummary.setIsLatest("true".equals(getText()));
                } else if (str2.equals("LastModified")) {
                    this.currentVersionSummary.setLastModified(ServiceUtils.parseIso8601Date(getText()));
                } else if (str2.equals("ETag")) {
                    this.currentVersionSummary.setETag(ServiceUtils.removeQuotes(getText()));
                } else if (str2.equals("Size")) {
                    this.currentVersionSummary.setSize(Long.parseLong(getText()));
                } else if (str2.equals("Owner")) {
                    this.currentVersionSummary.setOwner(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("StorageClass")) {
                    this.currentVersionSummary.setStorageClass(getText());
                }
            } else if (!in("ListVersionsResult", "Version", "Owner") && !in("ListVersionsResult", "DeleteMarker", "Owner")) {
            } else {
                if (str2.equals("ID")) {
                    this.currentOwner.setId(getText());
                } else if (str2.equals("DisplayName")) {
                    this.currentOwner.setDisplayName(getText());
                }
            }
        }
    }

    public static class BucketWebsiteConfigurationHandler extends AbstractHandler {
        private final BucketWebsiteConfiguration configuration = new BucketWebsiteConfiguration((String) null);
        private RoutingRuleCondition currentCondition = null;
        private RedirectRule currentRedirectRule = null;
        private RoutingRule currentRoutingRule = null;

        public BucketWebsiteConfiguration getConfiguration() {
            return this.configuration;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.currentRedirectRule = new RedirectRule();
                }
            } else if (in("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.currentRoutingRule = new RoutingRule();
                }
            } else if (!in("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
            } else {
                if (str2.equals("Condition")) {
                    this.currentCondition = new RoutingRuleCondition();
                } else if (str2.equals("Redirect")) {
                    this.currentRedirectRule = new RedirectRule();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.configuration.setRedirectAllRequestsTo(this.currentRedirectRule);
                    this.currentRedirectRule = null;
                }
            } else if (in("WebsiteConfiguration", "IndexDocument")) {
                if (str2.equals("Suffix")) {
                    this.configuration.setIndexDocumentSuffix(getText());
                }
            } else if (in("WebsiteConfiguration", "ErrorDocument")) {
                if (str2.equals("Key")) {
                    this.configuration.setErrorDocument(getText());
                }
            } else if (in("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.configuration.getRoutingRules().add(this.currentRoutingRule);
                    this.currentRoutingRule = null;
                }
            } else if (in("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.currentRoutingRule.setCondition(this.currentCondition);
                    this.currentCondition = null;
                } else if (str2.equals("Redirect")) {
                    this.currentRoutingRule.setRedirect(this.currentRedirectRule);
                    this.currentRedirectRule = null;
                }
            } else if (in("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition")) {
                if (str2.equals("KeyPrefixEquals")) {
                    this.currentCondition.setKeyPrefixEquals(getText());
                } else if (str2.equals("HttpErrorCodeReturnedEquals")) {
                    this.currentCondition.setHttpErrorCodeReturnedEquals(getText());
                }
            } else if (!in("WebsiteConfiguration", "RedirectAllRequestsTo") && !in("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect")) {
            } else {
                if (str2.equals("Protocol")) {
                    this.currentRedirectRule.setProtocol(getText());
                } else if (str2.equals("HostName")) {
                    this.currentRedirectRule.setHostName(getText());
                } else if (str2.equals("ReplaceKeyPrefixWith")) {
                    this.currentRedirectRule.setReplaceKeyPrefixWith(getText());
                } else if (str2.equals("ReplaceKeyWith")) {
                    this.currentRedirectRule.setReplaceKeyWith(getText());
                } else if (str2.equals("HttpRedirectCode")) {
                    this.currentRedirectRule.setHttpRedirectCode(getText());
                }
            }
        }
    }

    public static class BucketVersioningConfigurationHandler extends AbstractHandler {
        private final BucketVersioningConfiguration configuration = new BucketVersioningConfiguration();

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
        }

        public BucketVersioningConfiguration getConfiguration() {
            return this.configuration;
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (!in("VersioningConfiguration")) {
                return;
            }
            if (str2.equals("Status")) {
                this.configuration.setStatus(getText());
            } else if (str2.equals("MfaDelete")) {
                String text = getText();
                if (text.equals("Disabled")) {
                    this.configuration.setMfaDeleteEnabled(false);
                } else if (text.equals("Enabled")) {
                    this.configuration.setMfaDeleteEnabled(true);
                } else {
                    this.configuration.setMfaDeleteEnabled((Boolean) null);
                }
            }
        }
    }

    public static class BucketAccelerateConfigurationHandler extends AbstractHandler {
        private final BucketAccelerateConfiguration configuration = new BucketAccelerateConfiguration((String) null);

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
        }

        public BucketAccelerateConfiguration getConfiguration() {
            return this.configuration;
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("AccelerateConfiguration") && str2.equals("Status")) {
                this.configuration.setStatus(getText());
            }
        }
    }

    public static class CompleteMultipartUploadHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult {
        private AmazonS3Exception ase;
        private String errorCode;
        private String hostId;
        private String requestId;
        private CompleteMultipartUploadResult result;

        /* access modifiers changed from: protected */
        public ServerSideEncryptionResult sseResult() {
            return this.result;
        }

        public Date getExpirationTime() {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult == null) {
                return null;
            }
            return completeMultipartUploadResult.getExpirationTime();
        }

        public void setExpirationTime(Date date) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTime(date);
            }
        }

        public String getExpirationTimeRuleId() {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult == null) {
                return null;
            }
            return completeMultipartUploadResult.getExpirationTimeRuleId();
        }

        public void setExpirationTimeRuleId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTimeRuleId(str);
            }
        }

        public void setVersionId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setVersionId(str);
            }
        }

        public String getVersionId() {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult == null) {
                return null;
            }
            return completeMultipartUploadResult.getVersionId();
        }

        public boolean isRequesterCharged() {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult == null) {
                return false;
            }
            return completeMultipartUploadResult.isRequesterCharged();
        }

        public void setRequesterCharged(boolean z) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.result;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setRequesterCharged(z);
            }
        }

        public CompleteMultipartUploadResult getCompleteMultipartUploadResult() {
            return this.result;
        }

        public AmazonS3Exception getAmazonS3Exception() {
            return this.ase;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (atTopLevel() && str2.equals("CompleteMultipartUploadResult")) {
                this.result = new CompleteMultipartUploadResult();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            AmazonS3Exception amazonS3Exception;
            if (atTopLevel()) {
                if (str2.equals("Error") && (amazonS3Exception = this.ase) != null) {
                    amazonS3Exception.setErrorCode(this.errorCode);
                    this.ase.setRequestId(this.requestId);
                    this.ase.setExtendedRequestId(this.hostId);
                }
            } else if (in("CompleteMultipartUploadResult")) {
                if (str2.equals("Location")) {
                    this.result.setLocation(getText());
                } else if (str2.equals("Bucket")) {
                    this.result.setBucketName(getText());
                } else if (str2.equals("Key")) {
                    this.result.setKey(getText());
                } else if (str2.equals("ETag")) {
                    this.result.setETag(ServiceUtils.removeQuotes(getText()));
                }
            } else if (!in("Error")) {
            } else {
                if (str2.equals("Code")) {
                    this.errorCode = getText();
                } else if (str2.equals("Message")) {
                    this.ase = new AmazonS3Exception(getText());
                } else if (str2.equals("RequestId")) {
                    this.requestId = getText();
                } else if (str2.equals("HostId")) {
                    this.hostId = getText();
                }
            }
        }
    }

    public static class InitiateMultipartUploadHandler extends AbstractHandler {
        private final InitiateMultipartUploadResult result = new InitiateMultipartUploadResult();

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
        }

        public InitiateMultipartUploadResult getInitiateMultipartUploadResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (!in("InitiateMultipartUploadResult")) {
                return;
            }
            if (str2.equals("Bucket")) {
                this.result.setBucketName(getText());
            } else if (str2.equals("Key")) {
                this.result.setKey(getText());
            } else if (str2.equals("UploadId")) {
                this.result.setUploadId(getText());
            }
        }
    }

    public static class ListMultipartUploadsHandler extends AbstractHandler {
        private MultipartUpload currentMultipartUpload;
        private Owner currentOwner;
        private final MultipartUploadListing result = new MultipartUploadListing();

        public MultipartUploadListing getListMultipartUploadsResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListMultipartUploadsResult")) {
                if (str2.equals("Upload")) {
                    this.currentMultipartUpload = new MultipartUpload();
                }
            } else if (!in("ListMultipartUploadsResult", "Upload")) {
            } else {
                if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.currentOwner = new Owner();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListMultipartUploadsResult")) {
                if (str2.equals("Bucket")) {
                    this.result.setBucketName(getText());
                } else if (str2.equals("KeyMarker")) {
                    this.result.setKeyMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("Delimiter")) {
                    this.result.setDelimiter(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("Prefix")) {
                    this.result.setPrefix(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("UploadIdMarker")) {
                    this.result.setUploadIdMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("NextKeyMarker")) {
                    this.result.setNextKeyMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("NextUploadIdMarker")) {
                    this.result.setNextUploadIdMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("MaxUploads")) {
                    this.result.setMaxUploads(Integer.parseInt(getText()));
                } else if (str2.equals("EncodingType")) {
                    this.result.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated(Boolean.parseBoolean(getText()));
                } else if (str2.equals("Upload")) {
                    this.result.getMultipartUploads().add(this.currentMultipartUpload);
                    this.currentMultipartUpload = null;
                }
            } else if (in("ListMultipartUploadsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    this.result.getCommonPrefixes().add(getText());
                }
            } else if (in("ListMultipartUploadsResult", "Upload")) {
                if (str2.equals("Key")) {
                    this.currentMultipartUpload.setKey(getText());
                } else if (str2.equals("UploadId")) {
                    this.currentMultipartUpload.setUploadId(getText());
                } else if (str2.equals("Owner")) {
                    this.currentMultipartUpload.setOwner(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("Initiator")) {
                    this.currentMultipartUpload.setInitiator(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("StorageClass")) {
                    this.currentMultipartUpload.setStorageClass(getText());
                } else if (str2.equals("Initiated")) {
                    this.currentMultipartUpload.setInitiated(ServiceUtils.parseIso8601Date(getText()));
                }
            } else if (!in("ListMultipartUploadsResult", "Upload", "Owner") && !in("ListMultipartUploadsResult", "Upload", "Initiator")) {
            } else {
                if (str2.equals("ID")) {
                    this.currentOwner.setId(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("DisplayName")) {
                    this.currentOwner.setDisplayName(XmlResponsesSaxParser.checkForEmptyString(getText()));
                }
            }
        }
    }

    public static class ListPartsHandler extends AbstractHandler {
        private Owner currentOwner;
        private PartSummary currentPart;
        private final PartListing result = new PartListing();

        public PartListing getListPartsResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (!in("ListPartsResult")) {
                return;
            }
            if (str2.equals("Part")) {
                this.currentPart = new PartSummary();
            } else if (str2.equals("Owner") || str2.equals("Initiator")) {
                this.currentOwner = new Owner();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListPartsResult")) {
                if (str2.equals("Bucket")) {
                    this.result.setBucketName(getText());
                } else if (str2.equals("Key")) {
                    this.result.setKey(getText());
                } else if (str2.equals("UploadId")) {
                    this.result.setUploadId(getText());
                } else if (str2.equals("Owner")) {
                    this.result.setOwner(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("Initiator")) {
                    this.result.setInitiator(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("StorageClass")) {
                    this.result.setStorageClass(getText());
                } else if (str2.equals("PartNumberMarker")) {
                    this.result.setPartNumberMarker(parseInteger(getText()).intValue());
                } else if (str2.equals("NextPartNumberMarker")) {
                    this.result.setNextPartNumberMarker(parseInteger(getText()).intValue());
                } else if (str2.equals("MaxParts")) {
                    this.result.setMaxParts(parseInteger(getText()).intValue());
                } else if (str2.equals("EncodingType")) {
                    this.result.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated(Boolean.parseBoolean(getText()));
                } else if (str2.equals("Part")) {
                    this.result.getParts().add(this.currentPart);
                    this.currentPart = null;
                }
            } else if (in("ListPartsResult", "Part")) {
                if (str2.equals("PartNumber")) {
                    this.currentPart.setPartNumber(Integer.parseInt(getText()));
                } else if (str2.equals("LastModified")) {
                    this.currentPart.setLastModified(ServiceUtils.parseIso8601Date(getText()));
                } else if (str2.equals("ETag")) {
                    this.currentPart.setETag(ServiceUtils.removeQuotes(getText()));
                } else if (str2.equals("Size")) {
                    this.currentPart.setSize(Long.parseLong(getText()));
                }
            } else if (!in("ListPartsResult", "Owner") && !in("ListPartsResult", "Initiator")) {
            } else {
                if (str2.equals("ID")) {
                    this.currentOwner.setId(XmlResponsesSaxParser.checkForEmptyString(getText()));
                } else if (str2.equals("DisplayName")) {
                    this.currentOwner.setDisplayName(XmlResponsesSaxParser.checkForEmptyString(getText()));
                }
            }
        }

        private Integer parseInteger(String str) {
            String access$100 = XmlResponsesSaxParser.checkForEmptyString(getText());
            if (access$100 == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(access$100));
        }
    }

    public static class BucketReplicationConfigurationHandler extends AbstractHandler {
        private static final String BUCKET = "Bucket";
        private static final String DESTINATION = "Destination";
        private static final String ID = "ID";
        private static final String PREFIX = "Prefix";
        private static final String REPLICATION_CONFIG = "ReplicationConfiguration";
        private static final String ROLE = "Role";
        private static final String RULE = "Rule";
        private static final String STATUS = "Status";
        private static final String STORAGECLASS = "StorageClass";
        private final BucketReplicationConfiguration bucketReplicationConfiguration = new BucketReplicationConfiguration();
        private ReplicationRule currentRule;
        private String currentRuleId;
        private ReplicationDestinationConfig destinationConfig;

        public BucketReplicationConfiguration getConfiguration() {
            return this.bucketReplicationConfiguration;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in(REPLICATION_CONFIG)) {
                if (str2.equals(RULE)) {
                    this.currentRule = new ReplicationRule();
                }
            } else if (in(REPLICATION_CONFIG, RULE) && str2.equals(DESTINATION)) {
                this.destinationConfig = new ReplicationDestinationConfig();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in(REPLICATION_CONFIG)) {
                if (str2.equals(RULE)) {
                    this.bucketReplicationConfiguration.addRule(this.currentRuleId, this.currentRule);
                    this.currentRule = null;
                    this.currentRuleId = null;
                    this.destinationConfig = null;
                } else if (str2.equals(ROLE)) {
                    this.bucketReplicationConfiguration.setRoleARN(getText());
                }
            } else if (in(REPLICATION_CONFIG, RULE)) {
                if (str2.equals(ID)) {
                    this.currentRuleId = getText();
                } else if (str2.equals(PREFIX)) {
                    this.currentRule.setPrefix(getText());
                } else if (str2.equals(STATUS)) {
                    this.currentRule.setStatus(getText());
                } else if (str2.equals(DESTINATION)) {
                    this.currentRule.setDestinationConfig(this.destinationConfig);
                }
            } else if (!in(REPLICATION_CONFIG, RULE, DESTINATION)) {
            } else {
                if (str2.equals(BUCKET)) {
                    this.destinationConfig.setBucketARN(getText());
                } else if (str2.equals(STORAGECLASS)) {
                    this.destinationConfig.setStorageClass(getText());
                }
            }
        }
    }

    public static class BucketTaggingConfigurationHandler extends AbstractHandler {
        private final BucketTaggingConfiguration configuration = new BucketTaggingConfiguration();
        private String currentTagKey;
        private Map<String, String> currentTagSet;
        private String currentTagValue;

        public BucketTaggingConfiguration getConfiguration() {
            return this.configuration;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("Tagging") && str2.equals("TagSet")) {
                this.currentTagSet = new HashMap();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            String str4;
            if (in("Tagging")) {
                if (str2.equals("TagSet")) {
                    this.configuration.getAllTagSets().add(new TagSet(this.currentTagSet));
                    this.currentTagSet = null;
                }
            } else if (in("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    String str5 = this.currentTagKey;
                    if (!(str5 == null || (str4 = this.currentTagValue) == null)) {
                        this.currentTagSet.put(str5, str4);
                    }
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (!in("Tagging", "TagSet", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            }
        }
    }

    public static class GetObjectTaggingHandler extends AbstractHandler {
        private String currentTagKey;
        private String currentTagValue;
        private GetObjectTaggingResult getObjectTaggingResult;
        private List<Tag> tagSet;

        public GetObjectTaggingResult getResult() {
            return this.getObjectTaggingResult;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("Tagging") && str2.equals("TagSet")) {
                this.tagSet = new ArrayList();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("Tagging") && str2.equals("TagSet")) {
                this.getObjectTaggingResult = new GetObjectTaggingResult(this.tagSet);
                this.tagSet = null;
            }
            if (in("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    this.tagSet.add(new Tag(this.currentTagKey, this.currentTagValue));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (!in("Tagging", "TagSet", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            }
        }
    }

    public static class DeleteObjectsHandler extends AbstractHandler {
        private DeleteObjectsResult.DeletedObject currentDeletedObject = null;
        private MultiObjectDeleteException.DeleteError currentError = null;
        private final DeleteObjectsResponse response = new DeleteObjectsResponse();

        public DeleteObjectsResponse getDeleteObjectResult() {
            return this.response;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (!in("DeleteResult")) {
                return;
            }
            if (str2.equals("Deleted")) {
                this.currentDeletedObject = new DeleteObjectsResult.DeletedObject();
            } else if (str2.equals("Error")) {
                this.currentError = new MultiObjectDeleteException.DeleteError();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.response.getDeletedObjects().add(this.currentDeletedObject);
                    this.currentDeletedObject = null;
                } else if (str2.equals("Error")) {
                    this.response.getErrors().add(this.currentError);
                    this.currentError = null;
                }
            } else if (in("DeleteResult", "Deleted")) {
                if (str2.equals("Key")) {
                    this.currentDeletedObject.setKey(getText());
                } else if (str2.equals("VersionId")) {
                    this.currentDeletedObject.setVersionId(getText());
                } else if (str2.equals("DeleteMarker")) {
                    this.currentDeletedObject.setDeleteMarker(getText().equals("true"));
                } else if (str2.equals("DeleteMarkerVersionId")) {
                    this.currentDeletedObject.setDeleteMarkerVersionId(getText());
                }
            } else if (!in("DeleteResult", "Error")) {
            } else {
                if (str2.equals("Key")) {
                    this.currentError.setKey(getText());
                } else if (str2.equals("VersionId")) {
                    this.currentError.setVersionId(getText());
                } else if (str2.equals("Code")) {
                    this.currentError.setCode(getText());
                } else if (str2.equals("Message")) {
                    this.currentError.setMessage(getText());
                }
            }
        }
    }

    public static class BucketLifecycleConfigurationHandler extends AbstractHandler {
        private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
        private List<LifecycleFilterPredicate> andOperandsList;
        private final BucketLifecycleConfiguration configuration = new BucketLifecycleConfiguration(new ArrayList());
        private LifecycleFilter currentFilter;
        private BucketLifecycleConfiguration.NoncurrentVersionTransition currentNcvTransition;
        private BucketLifecycleConfiguration.Rule currentRule;
        private String currentTagKey;
        private String currentTagValue;
        private BucketLifecycleConfiguration.Transition currentTransition;

        public BucketLifecycleConfiguration getConfiguration() {
            return this.configuration;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.currentRule = new BucketLifecycleConfiguration.Rule();
                }
            } else if (in("LifecycleConfiguration", "Rule")) {
                if (str2.equals("Transition")) {
                    this.currentTransition = new BucketLifecycleConfiguration.Transition();
                } else if (str2.equals("NoncurrentVersionTransition")) {
                    this.currentNcvTransition = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.abortIncompleteMultipartUpload = new AbortIncompleteMultipartUpload();
                } else if (str2.equals("Filter")) {
                    this.currentFilter = new LifecycleFilter();
                }
            } else if (in("LifecycleConfiguration", "Rule", "Filter") && str2.equals("And")) {
                this.andOperandsList = new ArrayList();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.configuration.getRules().add(this.currentRule);
                    this.currentRule = null;
                }
            } else if (in("LifecycleConfiguration", "Rule")) {
                if (str2.equals("ID")) {
                    this.currentRule.setId(getText());
                } else if (str2.equals("Prefix")) {
                    this.currentRule.setPrefix(getText());
                } else if (str2.equals("Status")) {
                    this.currentRule.setStatus(getText());
                } else if (str2.equals("Transition")) {
                    this.currentRule.addTransition(this.currentTransition);
                    this.currentTransition = null;
                } else if (str2.equals("NoncurrentVersionTransition")) {
                    this.currentRule.addNoncurrentVersionTransition(this.currentNcvTransition);
                    this.currentNcvTransition = null;
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.currentRule.setAbortIncompleteMultipartUpload(this.abortIncompleteMultipartUpload);
                    this.abortIncompleteMultipartUpload = null;
                } else if (str2.equals("Filter")) {
                    this.currentRule.setFilter(this.currentFilter);
                    this.currentFilter = null;
                }
            } else if (in("LifecycleConfiguration", "Rule", "Expiration")) {
                if (str2.equals("Date")) {
                    this.currentRule.setExpirationDate(ServiceUtils.parseIso8601Date(getText()));
                } else if (str2.equals("Days")) {
                    this.currentRule.setExpirationInDays(Integer.parseInt(getText()));
                } else if (str2.equals("ExpiredObjectDeleteMarker") && "true".equals(getText())) {
                    this.currentRule.setExpiredObjectDeleteMarker(true);
                }
            } else if (in("LifecycleConfiguration", "Rule", "Transition")) {
                if (str2.equals("StorageClass")) {
                    this.currentTransition.setStorageClass(getText());
                } else if (str2.equals("Date")) {
                    this.currentTransition.setDate(ServiceUtils.parseIso8601Date(getText()));
                } else if (str2.equals("Days")) {
                    this.currentTransition.setDays(Integer.parseInt(getText()));
                }
            } else if (in("LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration")) {
                if (str2.equals("NoncurrentDays")) {
                    this.currentRule.setNoncurrentVersionExpirationInDays(Integer.parseInt(getText()));
                }
            } else if (in("LifecycleConfiguration", "Rule", "NoncurrentVersionTransition")) {
                if (str2.equals("StorageClass")) {
                    this.currentNcvTransition.setStorageClass(getText());
                } else if (str2.equals("NoncurrentDays")) {
                    this.currentNcvTransition.setDays(Integer.parseInt(getText()));
                }
            } else if (in("LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload")) {
                if (str2.equals("DaysAfterInitiation")) {
                    this.abortIncompleteMultipartUpload.setDaysAfterInitiation(Integer.parseInt(getText()));
                }
            } else if (in("LifecycleConfiguration", "Rule", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.currentFilter.setPredicate(new LifecyclePrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.currentFilter.setPredicate(new LifecycleTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                } else if (str2.equals("And")) {
                    this.currentFilter.setPredicate(new LifecycleAndOperator(this.andOperandsList));
                    this.andOperandsList = null;
                }
            } else if (in("LifecycleConfiguration", "Rule", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("LifecycleConfiguration", "Rule", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.andOperandsList.add(new LifecyclePrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.andOperandsList.add(new LifecycleTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (!in("LifecycleConfiguration", "Rule", "Filter", "And", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            }
        }
    }

    public static class BucketCrossOriginConfigurationHandler extends AbstractHandler {
        private List<String> allowedHeaders = null;
        private List<CORSRule.AllowedMethods> allowedMethods = null;
        private List<String> allowedOrigins = null;
        private final BucketCrossOriginConfiguration configuration = new BucketCrossOriginConfiguration(new ArrayList());
        private CORSRule currentRule;
        private List<String> exposedHeaders = null;

        public BucketCrossOriginConfiguration getConfiguration() {
            return this.configuration;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.currentRule = new CORSRule();
                }
            } else if (!in("CORSConfiguration", "CORSRule")) {
            } else {
                if (str2.equals("AllowedOrigin")) {
                    if (this.allowedOrigins == null) {
                        this.allowedOrigins = new ArrayList();
                    }
                } else if (str2.equals("AllowedMethod")) {
                    if (this.allowedMethods == null) {
                        this.allowedMethods = new ArrayList();
                    }
                } else if (str2.equals("ExposeHeader")) {
                    if (this.exposedHeaders == null) {
                        this.exposedHeaders = new ArrayList();
                    }
                } else if (str2.equals("AllowedHeader") && this.allowedHeaders == null) {
                    this.allowedHeaders = new LinkedList();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.currentRule.setAllowedHeaders(this.allowedHeaders);
                    this.currentRule.setAllowedMethods(this.allowedMethods);
                    this.currentRule.setAllowedOrigins(this.allowedOrigins);
                    this.currentRule.setExposedHeaders(this.exposedHeaders);
                    this.allowedHeaders = null;
                    this.allowedMethods = null;
                    this.allowedOrigins = null;
                    this.exposedHeaders = null;
                    this.configuration.getRules().add(this.currentRule);
                    this.currentRule = null;
                }
            } else if (!in("CORSConfiguration", "CORSRule")) {
            } else {
                if (str2.equals("ID")) {
                    this.currentRule.setId(getText());
                } else if (str2.equals("AllowedOrigin")) {
                    this.allowedOrigins.add(getText());
                } else if (str2.equals("AllowedMethod")) {
                    this.allowedMethods.add(CORSRule.AllowedMethods.fromValue(getText()));
                } else if (str2.equals("MaxAgeSeconds")) {
                    this.currentRule.setMaxAgeSeconds(Integer.parseInt(getText()));
                } else if (str2.equals("ExposeHeader")) {
                    this.exposedHeaders.add(getText());
                } else if (str2.equals("AllowedHeader")) {
                    this.allowedHeaders.add(getText());
                }
            }
        }
    }

    public static class GetBucketMetricsConfigurationHandler extends AbstractHandler {
        private List<MetricsFilterPredicate> andOperandsList;
        private final MetricsConfiguration configuration = new MetricsConfiguration();
        private String currentTagKey;
        private String currentTagValue;
        private MetricsFilter filter;

        public GetBucketMetricsConfigurationResult getResult() {
            return new GetBucketMetricsConfigurationResult().withMetricsConfiguration(this.configuration);
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.filter = new MetricsFilter();
                }
            } else if (in("MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.andOperandsList = new ArrayList();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.configuration.setId(getText());
                } else if (str2.equals("Filter")) {
                    this.configuration.setFilter(this.filter);
                    this.filter = null;
                }
            } else if (in("MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.filter.setPredicate(new MetricsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.filter.setPredicate(new MetricsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                } else if (str2.equals("And")) {
                    this.filter.setPredicate(new MetricsAndOperator(this.andOperandsList));
                    this.andOperandsList = null;
                }
            } else if (in("MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.andOperandsList.add(new MetricsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.andOperandsList.add(new MetricsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (!in("MetricsConfiguration", "Filter", "And", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            }
        }
    }

    public static class ListBucketMetricsConfigurationsHandler extends AbstractHandler {
        private List<MetricsFilterPredicate> andOperandsList;
        private MetricsConfiguration currentConfiguration;
        private MetricsFilter currentFilter;
        private String currentTagKey;
        private String currentTagValue;
        private final ListBucketMetricsConfigurationsResult result = new ListBucketMetricsConfigurationsResult();

        public ListBucketMetricsConfigurationsResult getResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    this.currentConfiguration = new MetricsConfiguration();
                }
            } else if (in("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.currentFilter = new MetricsFilter();
                }
            } else if (in("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.andOperandsList = new ArrayList();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    if (this.result.getMetricsConfigurationList() == null) {
                        this.result.setMetricsConfigurationList(new ArrayList());
                    }
                    this.result.getMetricsConfigurationList().add(this.currentConfiguration);
                    this.currentConfiguration = null;
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated("true".equals(getText()));
                } else if (str2.equals("ContinuationToken")) {
                    this.result.setContinuationToken(getText());
                } else if (str2.equals("NextContinuationToken")) {
                    this.result.setNextContinuationToken(getText());
                }
            } else if (in("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.currentConfiguration.setId(getText());
                } else if (str2.equals("Filter")) {
                    this.currentConfiguration.setFilter(this.currentFilter);
                    this.currentFilter = null;
                }
            } else if (in("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.currentFilter.setPredicate(new MetricsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.currentFilter.setPredicate(new MetricsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                } else if (str2.equals("And")) {
                    this.currentFilter.setPredicate(new MetricsAndOperator(this.andOperandsList));
                    this.andOperandsList = null;
                }
            } else if (in("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.andOperandsList.add(new MetricsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.andOperandsList.add(new MetricsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (!in("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            }
        }
    }

    public static class GetBucketAnalyticsConfigurationHandler extends AbstractHandler {
        private List<AnalyticsFilterPredicate> andOperandsList;
        private final AnalyticsConfiguration configuration = new AnalyticsConfiguration();
        private String currentTagKey;
        private String currentTagValue;
        private StorageClassAnalysisDataExport dataExport;
        private AnalyticsExportDestination destination;
        private AnalyticsFilter filter;
        private AnalyticsS3BucketDestination s3BucketDestination;
        private StorageClassAnalysis storageClassAnalysis;

        public GetBucketAnalyticsConfigurationResult getResult() {
            return new GetBucketAnalyticsConfigurationResult().withAnalyticsConfiguration(this.configuration);
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.filter = new AnalyticsFilter();
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.storageClassAnalysis = new StorageClassAnalysis();
                }
            } else if (in("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.andOperandsList = new ArrayList();
                }
            } else if (in("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.dataExport = new StorageClassAnalysisDataExport();
                }
            } else if (in("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.destination = new AnalyticsExportDestination();
                }
            } else if (in("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.s3BucketDestination = new AnalyticsS3BucketDestination();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.configuration.setId(getText());
                } else if (str2.equals("Filter")) {
                    this.configuration.setFilter(this.filter);
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.configuration.setStorageClassAnalysis(this.storageClassAnalysis);
                }
            } else if (in("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.filter.setPredicate(new AnalyticsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.filter.setPredicate(new AnalyticsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                } else if (str2.equals("And")) {
                    this.filter.setPredicate(new AnalyticsAndOperator(this.andOperandsList));
                    this.andOperandsList = null;
                }
            } else if (in("AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.andOperandsList.add(new AnalyticsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.andOperandsList.add(new AnalyticsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (in("AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.storageClassAnalysis.setDataExport(this.dataExport);
                }
            } else if (in("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.dataExport.setOutputSchemaVersion(getText());
                } else if (str2.equals("Destination")) {
                    this.dataExport.setDestination(this.destination);
                }
            } else if (in("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.destination.setS3BucketDestination(this.s3BucketDestination);
                }
            } else if (!in("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
            } else {
                if (str2.equals("Format")) {
                    this.s3BucketDestination.setFormat(getText());
                } else if (str2.equals("BucketAccountId")) {
                    this.s3BucketDestination.setBucketAccountId(getText());
                } else if (str2.equals("Bucket")) {
                    this.s3BucketDestination.setBucketArn(getText());
                } else if (str2.equals("Prefix")) {
                    this.s3BucketDestination.setPrefix(getText());
                }
            }
        }
    }

    public static class ListBucketAnalyticsConfigurationHandler extends AbstractHandler {
        private List<AnalyticsFilterPredicate> andOperandsList;
        private AnalyticsConfiguration currentConfiguration;
        private AnalyticsFilter currentFilter;
        private String currentTagKey;
        private String currentTagValue;
        private StorageClassAnalysisDataExport dataExport;
        private AnalyticsExportDestination destination;
        private final ListBucketAnalyticsConfigurationsResult result = new ListBucketAnalyticsConfigurationsResult();
        private AnalyticsS3BucketDestination s3BucketDestination;
        private StorageClassAnalysis storageClassAnalysis;

        public ListBucketAnalyticsConfigurationsResult getResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    this.currentConfiguration = new AnalyticsConfiguration();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.currentFilter = new AnalyticsFilter();
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.storageClassAnalysis = new StorageClassAnalysis();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.andOperandsList = new ArrayList();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.dataExport = new StorageClassAnalysisDataExport();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.destination = new AnalyticsExportDestination();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.s3BucketDestination = new AnalyticsS3BucketDestination();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    if (this.result.getAnalyticsConfigurationList() == null) {
                        this.result.setAnalyticsConfigurationList(new ArrayList());
                    }
                    this.result.getAnalyticsConfigurationList().add(this.currentConfiguration);
                    this.currentConfiguration = null;
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated("true".equals(getText()));
                } else if (str2.equals("ContinuationToken")) {
                    this.result.setContinuationToken(getText());
                } else if (str2.equals("NextContinuationToken")) {
                    this.result.setNextContinuationToken(getText());
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.currentConfiguration.setId(getText());
                } else if (str2.equals("Filter")) {
                    this.currentConfiguration.setFilter(this.currentFilter);
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.currentConfiguration.setStorageClassAnalysis(this.storageClassAnalysis);
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.currentFilter.setPredicate(new AnalyticsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.currentFilter.setPredicate(new AnalyticsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                } else if (str2.equals("And")) {
                    this.currentFilter.setPredicate(new AnalyticsAndOperator(this.andOperandsList));
                    this.andOperandsList = null;
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.andOperandsList.add(new AnalyticsPrefixPredicate(getText()));
                } else if (str2.equals("Tag")) {
                    this.andOperandsList.add(new AnalyticsTagPredicate(new Tag(this.currentTagKey, this.currentTagValue)));
                    this.currentTagKey = null;
                    this.currentTagValue = null;
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.currentTagKey = getText();
                } else if (str2.equals("Value")) {
                    this.currentTagValue = getText();
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.storageClassAnalysis.setDataExport(this.dataExport);
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.dataExport.setOutputSchemaVersion(getText());
                } else if (str2.equals("Destination")) {
                    this.dataExport.setDestination(this.destination);
                }
            } else if (in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.destination.setS3BucketDestination(this.s3BucketDestination);
                }
            } else if (!in("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
            } else {
                if (str2.equals("Format")) {
                    this.s3BucketDestination.setFormat(getText());
                } else if (str2.equals("BucketAccountId")) {
                    this.s3BucketDestination.setBucketAccountId(getText());
                } else if (str2.equals("Bucket")) {
                    this.s3BucketDestination.setBucketArn(getText());
                } else if (str2.equals("Prefix")) {
                    this.s3BucketDestination.setPrefix(getText());
                }
            }
        }
    }

    public static class GetBucketInventoryConfigurationHandler extends AbstractHandler {
        private final InventoryConfiguration configuration = new InventoryConfiguration();
        private InventoryFilter filter;
        private InventoryDestination inventoryDestination;
        private InventorySchedule inventorySchedule;
        private List<String> optionalFields;
        private final GetBucketInventoryConfigurationResult result = new GetBucketInventoryConfigurationResult();
        private InventoryS3BucketDestination s3BucketDestination;

        public GetBucketInventoryConfigurationResult getResult() {
            return this.result.withInventoryConfiguration(this.configuration);
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("InventoryConfiguration")) {
                if (str2.equals("Destination")) {
                    this.inventoryDestination = new InventoryDestination();
                } else if (str2.equals("Filter")) {
                    this.filter = new InventoryFilter();
                } else if (str2.equals("Schedule")) {
                    this.inventorySchedule = new InventorySchedule();
                } else if (str2.equals("OptionalFields")) {
                    this.optionalFields = new ArrayList();
                }
            } else if (in("InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                this.s3BucketDestination = new InventoryS3BucketDestination();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.configuration.setId(getText());
                } else if (str2.equals("Destination")) {
                    this.configuration.setDestination(this.inventoryDestination);
                    this.inventoryDestination = null;
                } else if (str2.equals("IsEnabled")) {
                    this.configuration.setEnabled(Boolean.valueOf("true".equals(getText())));
                } else if (str2.equals("Filter")) {
                    this.configuration.setInventoryFilter(this.filter);
                    this.filter = null;
                } else if (str2.equals("IncludedObjectVersions")) {
                    this.configuration.setIncludedObjectVersions(getText());
                } else if (str2.equals("Schedule")) {
                    this.configuration.setSchedule(this.inventorySchedule);
                    this.inventorySchedule = null;
                } else if (str2.equals("OptionalFields")) {
                    this.configuration.setOptionalFields(this.optionalFields);
                    this.optionalFields = null;
                }
            } else if (in("InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.inventoryDestination.setS3BucketDestination(this.s3BucketDestination);
                    this.s3BucketDestination = null;
                }
            } else if (in("InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.s3BucketDestination.setAccountId(getText());
                } else if (str2.equals("Bucket")) {
                    this.s3BucketDestination.setBucketArn(getText());
                } else if (str2.equals("Format")) {
                    this.s3BucketDestination.setFormat(getText());
                } else if (str2.equals("Prefix")) {
                    this.s3BucketDestination.setPrefix(getText());
                }
            } else if (in("InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.filter.setPredicate(new InventoryPrefixPredicate(getText()));
                }
            } else if (in("InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.inventorySchedule.setFrequency(getText());
                }
            } else if (in("InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.optionalFields.add(getText());
            }
        }
    }

    public static class ListBucketInventoryConfigurationsHandler extends AbstractHandler {
        private InventoryConfiguration currentConfiguration;
        private InventoryDestination currentDestination;
        private InventoryFilter currentFilter;
        private List<String> currentOptionalFieldsList;
        private InventoryS3BucketDestination currentS3BucketDestination;
        private InventorySchedule currentSchedule;
        private final ListBucketInventoryConfigurationsResult result = new ListBucketInventoryConfigurationsResult();

        public ListBucketInventoryConfigurationsResult getResult() {
            return this.result;
        }

        /* access modifiers changed from: protected */
        public void doStartElement(String str, String str2, String str3, Attributes attributes) {
            if (in("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    this.currentConfiguration = new InventoryConfiguration();
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Destination")) {
                    this.currentDestination = new InventoryDestination();
                } else if (str2.equals("Filter")) {
                    this.currentFilter = new InventoryFilter();
                } else if (str2.equals("Schedule")) {
                    this.currentSchedule = new InventorySchedule();
                } else if (str2.equals("OptionalFields")) {
                    this.currentOptionalFieldsList = new ArrayList();
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                this.currentS3BucketDestination = new InventoryS3BucketDestination();
            }
        }

        /* access modifiers changed from: protected */
        public void doEndElement(String str, String str2, String str3) {
            if (in("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    if (this.result.getInventoryConfigurationList() == null) {
                        this.result.setInventoryConfigurationList(new ArrayList());
                    }
                    this.result.getInventoryConfigurationList().add(this.currentConfiguration);
                    this.currentConfiguration = null;
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated("true".equals(getText()));
                } else if (str2.equals("ContinuationToken")) {
                    this.result.setContinuationToken(getText());
                } else if (str2.equals("NextContinuationToken")) {
                    this.result.setNextContinuationToken(getText());
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.currentConfiguration.setId(getText());
                } else if (str2.equals("Destination")) {
                    this.currentConfiguration.setDestination(this.currentDestination);
                    this.currentDestination = null;
                } else if (str2.equals("IsEnabled")) {
                    this.currentConfiguration.setEnabled(Boolean.valueOf("true".equals(getText())));
                } else if (str2.equals("Filter")) {
                    this.currentConfiguration.setInventoryFilter(this.currentFilter);
                    this.currentFilter = null;
                } else if (str2.equals("IncludedObjectVersions")) {
                    this.currentConfiguration.setIncludedObjectVersions(getText());
                } else if (str2.equals("Schedule")) {
                    this.currentConfiguration.setSchedule(this.currentSchedule);
                    this.currentSchedule = null;
                } else if (str2.equals("OptionalFields")) {
                    this.currentConfiguration.setOptionalFields(this.currentOptionalFieldsList);
                    this.currentOptionalFieldsList = null;
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.currentDestination.setS3BucketDestination(this.currentS3BucketDestination);
                    this.currentS3BucketDestination = null;
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.currentS3BucketDestination.setAccountId(getText());
                } else if (str2.equals("Bucket")) {
                    this.currentS3BucketDestination.setBucketArn(getText());
                } else if (str2.equals("Format")) {
                    this.currentS3BucketDestination.setFormat(getText());
                } else if (str2.equals("Prefix")) {
                    this.currentS3BucketDestination.setPrefix(getText());
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.currentFilter.setPredicate(new InventoryPrefixPredicate(getText()));
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.currentSchedule.setFrequency(getText());
                }
            } else if (in("ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.currentOptionalFieldsList.add(getText());
            }
        }
    }
}
