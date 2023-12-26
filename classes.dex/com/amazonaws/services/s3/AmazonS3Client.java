package com.amazonaws.services.s3;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amazonaws.AbortedException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.DefaultRequest;
import com.amazonaws.HttpMethod;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.Presigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressReportingInputStream;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.internal.AWSS3V4Signer;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryCondition;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.DeleteObjectTaggingHeaderHandler;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.GetObjectTaggingResponseHeaderHandler;
import com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain;
import com.amazonaws.services.s3.internal.S3ErrorResponseHandler;
import com.amazonaws.services.s3.internal.S3ExecutionContext;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazonaws.services.s3.internal.S3ObjectResponseHandler;
import com.amazonaws.services.s3.internal.S3QueryStringSigner;
import com.amazonaws.services.s3.internal.S3RequesterChargedHeaderHandler;
import com.amazonaws.services.s3.internal.S3Signer;
import com.amazonaws.services.s3.internal.S3StringResponseHandler;
import com.amazonaws.services.s3.internal.S3VersionHeaderHandler;
import com.amazonaws.services.s3.internal.S3XmlResponseHandler;
import com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.internal.SetObjectTaggingResponseHeaderHandler;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketPolicy;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketPolicyRequest;
import com.amazonaws.services.s3.model.DeleteBucketReplicationConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectTaggingRequest;
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.DeleteVersionRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GenericBucketRequest;
import com.amazonaws.services.s3.model.GetBucketAccelerateConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketAclRequest;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.GetBucketLoggingConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketNotificationConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketPolicyRequest;
import com.amazonaws.services.s3.model.GetBucketReplicationConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketVersioningConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.GetObjectAclRequest;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.GetObjectTaggingRequest;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.GetRequestPaymentConfigurationRequest;
import com.amazonaws.services.s3.model.GetS3AccountOwnerRequest;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsRequest;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsRequest;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsRequest;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketsRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListNextBatchOfObjectsRequest;
import com.amazonaws.services.s3.model.ListNextBatchOfVersionsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.MultiFactorAuthentication;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.RestoreObjectRequest;
import com.amazonaws.services.s3.model.S3AccelerateUnsupported;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketAclRequest;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketPolicyRequest;
import com.amazonaws.services.s3.model.SetBucketReplicationConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.SetObjectAclRequest;
import com.amazonaws.services.s3.model.SetObjectTaggingRequest;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazonaws.services.s3.model.SetRequestPaymentConfigurationRequest;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.transform.AclXmlFactory;
import com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.BucketNotificationConfigurationStaxUnmarshaller;
import com.amazonaws.services.s3.model.transform.HeadBucketResultHandler;
import com.amazonaws.services.s3.model.transform.MultiObjectDeleteXmlFactory;
import com.amazonaws.services.s3.model.transform.ObjectTaggingXmlFactory;
import com.amazonaws.services.s3.model.transform.RequestPaymentConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.RequestXmlFactory;
import com.amazonaws.services.s3.model.transform.Unmarshallers;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.Md5Utils;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.util.ServiceClientHolderInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.ValidationUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

public class AmazonS3Client extends AmazonWebServiceClient implements AmazonS3 {
    private static final int BUCKET_REGION_CACHE_SIZE = 300;
    public static final String S3_SERVICE_NAME = "s3";
    private static final String S3_V4_SIGNER = "AWSS3V4SignerType";
    private static final BucketConfigurationXmlFactory bucketConfigurationXmlFactory = new BucketConfigurationXmlFactory();
    private static final Map<String, String> bucketRegionCache = Collections.synchronizedMap(new LinkedHashMap<String, String>(BUCKET_REGION_CACHE_SIZE, 1.1f, true) {
        private static final long serialVersionUID = 23453;

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > AmazonS3Client.BUCKET_REGION_CACHE_SIZE;
        }
    });
    private static Log log = LogFactory.getLog((Class<?>) AmazonS3Client.class);
    private static final RequestPaymentConfigurationXmlFactory requestPaymentConfigurationXmlFactory = new RequestPaymentConfigurationXmlFactory();
    private final AWSCredentialsProvider awsCredentialsProvider;
    protected S3ClientOptions clientOptions;
    volatile String clientRegion;
    private final CompleteMultipartUploadRetryCondition completeMultipartUploadRetryCondition;
    private final S3ErrorResponseHandler errorResponseHandler;
    private int notificationThreshold;
    private final S3XmlResponseHandler<Void> voidResponseHandler;

    static {
        AwsSdkMetrics.addAll(Arrays.asList(S3ServiceMetric.values()));
        SignerFactory.registerSigner(S3_V4_SIGNER, AWSS3V4Signer.class);
    }

    static Map<String, String> getBucketRegionCache() {
        return bucketRegionCache;
    }

    @Deprecated
    public AmazonS3Client() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain());
    }

    @Deprecated
    public AmazonS3Client(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    @Deprecated
    public AmazonS3Client(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
        this.errorResponseHandler = new S3ErrorResponseHandler();
        this.voidResponseHandler = new S3XmlResponseHandler<>((Unmarshaller) null);
        this.clientOptions = new S3ClientOptions();
        this.notificationThreshold = 1024;
        this.completeMultipartUploadRetryCondition = new CompleteMultipartUploadRetryCondition();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.errorResponseHandler = new S3ErrorResponseHandler();
        this.voidResponseHandler = new S3XmlResponseHandler<>((Unmarshaller) null);
        this.clientOptions = new S3ClientOptions();
        this.notificationThreshold = 1024;
        this.completeMultipartUploadRetryCondition = new CompleteMultipartUploadRetryCondition();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    @Deprecated
    public AmazonS3Client(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, Region region) {
        this(aWSCredentials, region, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, Region region, ClientConfiguration clientConfiguration) {
        this(aWSCredentials, region, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), region, clientConfiguration, httpClient);
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, Region region) {
        this(aWSCredentialsProvider, region, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, Region region, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, region, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.errorResponseHandler = new S3ErrorResponseHandler();
        this.voidResponseHandler = new S3XmlResponseHandler<>((Unmarshaller) null);
        this.clientOptions = new S3ClientOptions();
        this.notificationThreshold = 1024;
        this.completeMultipartUploadRetryCondition = new CompleteMultipartUploadRetryCondition();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init(region, clientConfiguration);
    }

    public AmazonS3Client(ClientConfiguration clientConfiguration, Region region) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), region, clientConfiguration);
    }

    @Deprecated
    private void init() {
        setEndpoint(Constants.S3_HOSTNAME);
        this.endpointPrefix = "s3";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/s3/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/s3/request.handler2s"));
    }

    private void init(Region region, ClientConfiguration clientConfiguration) {
        if (this.awsCredentialsProvider == null) {
            throw new IllegalArgumentException("Credentials cannot be null. Credentials is required to sign the request");
        } else if (region != null) {
            this.clientConfiguration = clientConfiguration;
            this.endpointPrefix = "s3";
            setEndpoint(Constants.S3_HOSTNAME);
            setRegion(region);
            HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
            this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/s3/request.handlers"));
            this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/s3/request.handler2s"));
            Log log2 = log;
            log2.debug("initialized with endpoint = " + this.endpoint);
        } else {
            throw new IllegalArgumentException("Region cannot be null. Region is required to sign the request");
        }
    }

    public void setNotificationThreshold(int i) {
        this.notificationThreshold = i;
    }

    public void setEndpoint(String str) {
        if (!str.endsWith(Constants.S3_ACCELERATE_HOSTNAME)) {
            super.setEndpoint(str);
            if (!str.endsWith(Constants.S3_HOSTNAME)) {
                this.clientRegion = AwsHostNameUtils.parseRegionName(this.endpoint.getHost(), "s3");
                return;
            }
            return;
        }
        throw new IllegalStateException("To enable accelerate mode, please use AmazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());");
    }

    public void setRegion(Region region) {
        super.setRegion(region);
        this.clientRegion = region.getName();
    }

    public void setS3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.clientOptions = new S3ClientOptions(s3ClientOptions);
    }

    public VersionListing listNextBatchOfVersions(VersionListing versionListing) throws AmazonClientException, AmazonServiceException {
        return listNextBatchOfVersions(new ListNextBatchOfVersionsRequest(versionListing));
    }

    public VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest listNextBatchOfVersionsRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(listNextBatchOfVersionsRequest, "The request object parameter must be specified when listing the next batch of versions in a bucket");
        VersionListing previousVersionListing = listNextBatchOfVersionsRequest.getPreviousVersionListing();
        if (previousVersionListing.isTruncated()) {
            return listVersions(listNextBatchOfVersionsRequest.toListVersionsRequest());
        }
        VersionListing versionListing = new VersionListing();
        versionListing.setBucketName(previousVersionListing.getBucketName());
        versionListing.setDelimiter(previousVersionListing.getDelimiter());
        versionListing.setKeyMarker(previousVersionListing.getNextKeyMarker());
        versionListing.setVersionIdMarker(previousVersionListing.getNextVersionIdMarker());
        versionListing.setMaxKeys(previousVersionListing.getMaxKeys());
        versionListing.setPrefix(previousVersionListing.getPrefix());
        versionListing.setEncodingType(previousVersionListing.getEncodingType());
        versionListing.setTruncated(false);
        return versionListing;
    }

    public VersionListing listVersions(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return listVersions(new ListVersionsRequest(str, str2, (String) null, (String) null, (String) null, (Integer) null));
    }

    public VersionListing listVersions(String str, String str2, String str3, String str4, String str5, Integer num) throws AmazonClientException, AmazonServiceException {
        return listVersions(new ListVersionsRequest().withBucketName(str).withPrefix(str2).withDelimiter(str5).withKeyMarker(str3).withVersionIdMarker(str4).withMaxResults(num));
    }

    public VersionListing listVersions(ListVersionsRequest listVersionsRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(listVersionsRequest.getBucketName(), "The bucket name parameter must be specified when listing versions in a bucket");
        boolean equals = Constants.URL_ENCODING.equals(listVersionsRequest.getEncodingType());
        Request createRequest = createRequest(listVersionsRequest.getBucketName(), (String) null, listVersionsRequest, HttpMethodName.GET);
        createRequest.addParameter("versions", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.PREFIX, listVersionsRequest.getPrefix());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.DELIMITER, listVersionsRequest.getDelimiter());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.KEY_MARKER, listVersionsRequest.getKeyMarker());
        addParameterIfNotNull((Request<?>) createRequest, "version-id-marker", listVersionsRequest.getVersionIdMarker());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.ENCODING_TYPE, listVersionsRequest.getEncodingType());
        if (listVersionsRequest.getMaxResults() != null && listVersionsRequest.getMaxResults().intValue() >= 0) {
            createRequest.addParameter(RequestParameters.MAX_KEYS, listVersionsRequest.getMaxResults().toString());
        }
        return (VersionListing) invoke(createRequest, new Unmarshallers.VersionListUnmarshaller(equals), listVersionsRequest.getBucketName(), (String) null);
    }

    public ObjectListing listObjects(String str) throws AmazonClientException, AmazonServiceException {
        return listObjects(new ListObjectsRequest(str, (String) null, (String) null, (String) null, (Integer) null));
    }

    public ObjectListing listObjects(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return listObjects(new ListObjectsRequest(str, str2, (String) null, (String) null, (Integer) null));
    }

    public ObjectListing listObjects(ListObjectsRequest listObjectsRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(listObjectsRequest.getBucketName(), "The bucket name parameter must be specified when listing objects in a bucket");
        boolean equals = Constants.URL_ENCODING.equals(listObjectsRequest.getEncodingType());
        Request createRequest = createRequest(listObjectsRequest.getBucketName(), (String) null, listObjectsRequest, HttpMethodName.GET);
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.PREFIX, listObjectsRequest.getPrefix());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.DELIMITER, listObjectsRequest.getDelimiter());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.MARKER, listObjectsRequest.getMarker());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.ENCODING_TYPE, listObjectsRequest.getEncodingType());
        populateRequesterPaysHeader(createRequest, listObjectsRequest.isRequesterPays());
        if (listObjectsRequest.getMaxKeys() != null && listObjectsRequest.getMaxKeys().intValue() >= 0) {
            createRequest.addParameter(RequestParameters.MAX_KEYS, listObjectsRequest.getMaxKeys().toString());
        }
        return (ObjectListing) invoke(createRequest, new Unmarshallers.ListObjectsUnmarshaller(equals), listObjectsRequest.getBucketName(), (String) null);
    }

    public ListObjectsV2Result listObjectsV2(String str) throws AmazonClientException, AmazonServiceException {
        return listObjectsV2(new ListObjectsV2Request().withBucketName(str));
    }

    public ListObjectsV2Result listObjectsV2(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return listObjectsV2(new ListObjectsV2Request().withBucketName(str).withPrefix(str2));
    }

    public ListObjectsV2Result listObjectsV2(ListObjectsV2Request listObjectsV2Request) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(listObjectsV2Request.getBucketName(), "The bucket name parameter must be specified when listing objects in a bucket");
        Request createRequest = createRequest(listObjectsV2Request.getBucketName(), (String) null, listObjectsV2Request, HttpMethodName.GET);
        createRequest.addParameter("list-type", ExifInterface.GPS_MEASUREMENT_2D);
        addParameterIfNotNull((Request<?>) createRequest, "start-after", listObjectsV2Request.getStartAfter());
        addParameterIfNotNull((Request<?>) createRequest, "continuation-token", listObjectsV2Request.getContinuationToken());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.DELIMITER, listObjectsV2Request.getDelimiter());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.MAX_KEYS, listObjectsV2Request.getMaxKeys());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.PREFIX, listObjectsV2Request.getPrefix());
        addParameterIfNotNull((Request<?>) createRequest, RequestParameters.ENCODING_TYPE, listObjectsV2Request.getEncodingType());
        createRequest.addParameter("fetch-owner", Boolean.toString(listObjectsV2Request.isFetchOwner()));
        populateRequesterPaysHeader(createRequest, listObjectsV2Request.isRequesterPays());
        return (ListObjectsV2Result) invoke(createRequest, new Unmarshallers.ListObjectsV2Unmarshaller(Constants.URL_ENCODING.equals(listObjectsV2Request.getEncodingType())), listObjectsV2Request.getBucketName(), (String) null);
    }

    public ObjectListing listNextBatchOfObjects(ObjectListing objectListing) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(objectListing, "The previous object listing parameter must be specified when listing the next batch of objects in a bucket");
        return listNextBatchOfObjects(new ListNextBatchOfObjectsRequest(objectListing));
    }

    public ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest listNextBatchOfObjectsRequest) throws AmazonClientException, AmazonServiceException {
        ObjectListing previousObjectListing = listNextBatchOfObjectsRequest.getPreviousObjectListing();
        if (previousObjectListing.isTruncated()) {
            return listObjects(listNextBatchOfObjectsRequest.toListObjectsRequest());
        }
        ObjectListing objectListing = new ObjectListing();
        objectListing.setBucketName(previousObjectListing.getBucketName());
        objectListing.setDelimiter(previousObjectListing.getDelimiter());
        objectListing.setMarker(previousObjectListing.getNextMarker());
        objectListing.setMaxKeys(previousObjectListing.getMaxKeys());
        objectListing.setPrefix(previousObjectListing.getPrefix());
        objectListing.setEncodingType(previousObjectListing.getEncodingType());
        objectListing.setTruncated(false);
        return objectListing;
    }

    public Owner getS3AccountOwner() throws AmazonClientException, AmazonServiceException {
        return getS3AccountOwner(new GetS3AccountOwnerRequest());
    }

    public Owner getS3AccountOwner(GetS3AccountOwnerRequest getS3AccountOwnerRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getS3AccountOwnerRequest, "The request object parameter getS3AccountOwnerRequest must be specified.");
        return (Owner) invoke(createRequest((String) null, (String) null, new ListBucketsRequest(), HttpMethodName.GET), new Unmarshallers.ListBucketsOwnerUnmarshaller(), (String) null, (String) null);
    }

    public List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest) throws AmazonClientException, AmazonServiceException {
        return (List) invoke(createRequest((String) null, (String) null, listBucketsRequest, HttpMethodName.GET), new Unmarshallers.ListBucketsUnmarshaller(), (String) null, (String) null);
    }

    public List<Bucket> listBuckets() throws AmazonClientException, AmazonServiceException {
        return listBuckets(new ListBucketsRequest());
    }

    public String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getBucketLocationRequest, "The request parameter must be specified when requesting a bucket's location");
        String bucketName = getBucketLocationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's location");
        Request createRequest = createRequest(bucketName, (String) null, getBucketLocationRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_LOCATION, (String) null);
        return (String) invoke(createRequest, new Unmarshallers.BucketLocationUnmarshaller(), bucketName, (String) null);
    }

    public String getBucketLocation(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketLocation(new GetBucketLocationRequest(str));
    }

    public Bucket createBucket(String str) throws AmazonClientException, AmazonServiceException {
        return createBucket(new CreateBucketRequest(str));
    }

    public Bucket createBucket(String str, com.amazonaws.services.s3.model.Region region) throws AmazonClientException, AmazonServiceException {
        return createBucket(new CreateBucketRequest(str, region));
    }

    public Bucket createBucket(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return createBucket(new CreateBucketRequest(str, str2));
    }

    public Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(createBucketRequest, "The CreateBucketRequest parameter must be specified when creating a bucket");
        String bucketName = createBucketRequest.getBucketName();
        String region = createBucketRequest.getRegion();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when creating a bucket");
        if (bucketName != null) {
            bucketName = bucketName.trim();
        }
        BucketNameUtils.validateBucketName(bucketName);
        Request createRequest = createRequest(bucketName, (String) null, createBucketRequest, HttpMethodName.PUT);
        if (createBucketRequest.getAccessControlList() != null) {
            addAclHeaders(createRequest, createBucketRequest.getAccessControlList());
        } else if (createBucketRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.S3_CANNED_ACL, createBucketRequest.getCannedAcl().toString());
        }
        if (!this.endpoint.getHost().equals(Constants.S3_HOSTNAME) && (region == null || region.isEmpty())) {
            try {
                region = RegionUtils.getRegionByEndpoint(this.endpoint.getHost()).getName();
            } catch (IllegalArgumentException unused) {
            }
        }
        if (region != null && !StringUtils.upperCase(region).equals(com.amazonaws.services.s3.model.Region.US_Standard.toString())) {
            XmlWriter xmlWriter = new XmlWriter();
            xmlWriter.start("CreateBucketConfiguration", "xmlns", Constants.XML_NAMESPACE);
            xmlWriter.start(com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_LOCATIONCONSTRAINT).value(region).end();
            xmlWriter.end();
            byte[] bytes = xmlWriter.getBytes();
            createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
            createRequest.setContent(new ByteArrayInputStream(bytes));
        }
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
        return new Bucket(bucketName);
    }

    public AccessControlList getObjectAcl(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return getObjectAcl(new GetObjectAclRequest(str, str2));
    }

    public AccessControlList getObjectAcl(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        return getObjectAcl(new GetObjectAclRequest(str, str2, str3));
    }

    public AccessControlList getObjectAcl(GetObjectAclRequest getObjectAclRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getObjectAclRequest, "The request parameter must be specified when requesting an object's ACL");
        ValidationUtils.assertParameterNotNull(getObjectAclRequest.getBucketName(), "The bucket name parameter must be specified when requesting an object's ACL");
        ValidationUtils.assertParameterNotNull(getObjectAclRequest.getKey(), "The key parameter must be specified when requesting an object's ACL");
        return getAcl(getObjectAclRequest.getBucketName(), getObjectAclRequest.getKey(), getObjectAclRequest.getVersionId(), getObjectAclRequest.isRequesterPays(), getObjectAclRequest);
    }

    public void setObjectAcl(String str, String str2, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {
        setObjectAcl(str, str2, (String) null, accessControlList);
    }

    public void setObjectAcl(String str, String str2, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {
        setObjectAcl(str, str2, (String) null, cannedAccessControlList);
    }

    public void setObjectAcl(String str, String str2, String str3, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {
        setObjectAcl(new SetObjectAclRequest(str, str2, str3, accessControlList));
    }

    public void setObjectAcl(String str, String str2, String str3, AccessControlList accessControlList, RequestMetricCollector requestMetricCollector) throws AmazonClientException, AmazonServiceException {
        setObjectAcl((SetObjectAclRequest) new SetObjectAclRequest(str, str2, str3, accessControlList).withRequestMetricCollector(requestMetricCollector));
    }

    public void setObjectAcl(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {
        setObjectAcl(new SetObjectAclRequest(str, str2, str3, cannedAccessControlList));
    }

    public void setObjectAcl(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList, RequestMetricCollector requestMetricCollector) {
        setObjectAcl((SetObjectAclRequest) new SetObjectAclRequest(str, str2, str3, cannedAccessControlList).withRequestMetricCollector(requestMetricCollector));
    }

    public void setObjectAcl(SetObjectAclRequest setObjectAclRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(setObjectAclRequest, "The request must not be null.");
        ValidationUtils.assertParameterNotNull(setObjectAclRequest.getBucketName(), "The bucket name parameter must be specified when setting an object's ACL");
        ValidationUtils.assertParameterNotNull(setObjectAclRequest.getKey(), "The key parameter must be specified when setting an object's ACL");
        if (setObjectAclRequest.getAcl() != null && setObjectAclRequest.getCannedAcl() != null) {
            throw new IllegalArgumentException("Only one of the ACL and CannedACL parameters can be specified, not both.");
        } else if (setObjectAclRequest.getAcl() != null) {
            setAcl(setObjectAclRequest.getBucketName(), setObjectAclRequest.getKey(), setObjectAclRequest.getVersionId(), setObjectAclRequest.getAcl(), setObjectAclRequest.isRequesterPays(), (AmazonWebServiceRequest) setObjectAclRequest);
        } else if (setObjectAclRequest.getCannedAcl() != null) {
            setAcl(setObjectAclRequest.getBucketName(), setObjectAclRequest.getKey(), setObjectAclRequest.getVersionId(), setObjectAclRequest.getCannedAcl(), setObjectAclRequest.isRequesterPays(), (AmazonWebServiceRequest) setObjectAclRequest);
        } else {
            throw new IllegalArgumentException("At least one of the ACL and CannedACL parameters should be specified");
        }
    }

    public AccessControlList getBucketAcl(String str) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucket name parameter must be specified when requesting a bucket's ACL");
        return getAcl(str, (String) null, (String) null, false, (AmazonWebServiceRequest) null);
    }

    public AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = getBucketAclRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's ACL");
        return getAcl(bucketName, (String) null, (String) null, false, getBucketAclRequest);
    }

    public void setBucketAcl(String str, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {
        setBucketAcl0(str, accessControlList, (RequestMetricCollector) null);
    }

    public void setBucketAcl(String str, AccessControlList accessControlList, RequestMetricCollector requestMetricCollector) {
        setBucketAcl0(str, accessControlList, requestMetricCollector);
    }

    private void setBucketAcl0(String str, AccessControlList accessControlList, RequestMetricCollector requestMetricCollector) {
        ValidationUtils.assertParameterNotNull(str, "The bucket name parameter must be specified when setting a bucket's ACL");
        ValidationUtils.assertParameterNotNull(accessControlList, "The ACL parameter must be specified when setting a bucket's ACL");
        setAcl(str, (String) null, (String) null, accessControlList, false, new GenericBucketRequest(str).withRequestMetricCollector(requestMetricCollector));
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = setBucketAclRequest.getBucketName();
        AccessControlList acl = setBucketAclRequest.getAcl();
        CannedAccessControlList cannedAcl = setBucketAclRequest.getCannedAcl();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting a bucket's ACL");
        if (acl != null) {
            setAcl(bucketName, (String) null, (String) null, acl, false, (AmazonWebServiceRequest) setBucketAclRequest);
        } else if (cannedAcl != null) {
            setAcl(bucketName, (String) null, (String) null, cannedAcl, false, (AmazonWebServiceRequest) setBucketAclRequest);
        } else {
            ValidationUtils.assertParameterNotNull((Object) null, "The ACL parameter must be specified when setting a bucket's ACL");
        }
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {
        setBucketAcl0(str, cannedAccessControlList, (RequestMetricCollector) null);
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList, RequestMetricCollector requestMetricCollector) throws AmazonClientException, AmazonServiceException {
        setBucketAcl0(str, cannedAccessControlList, requestMetricCollector);
    }

    private void setBucketAcl0(String str, CannedAccessControlList cannedAccessControlList, RequestMetricCollector requestMetricCollector) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucket name parameter must be specified when setting a bucket's ACL");
        ValidationUtils.assertParameterNotNull(cannedAccessControlList, "The ACL parameter must be specified when setting a bucket's ACL");
        setAcl(str, (String) null, (String) null, cannedAccessControlList, false, new GenericBucketRequest(str).withRequestMetricCollector(requestMetricCollector));
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return getObjectMetadata(new GetObjectMetadataRequest(str, str2));
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getObjectMetadataRequest, "The GetObjectMetadataRequest parameter must be specified when requesting an object's metadata");
        String bucketName = getObjectMetadataRequest.getBucketName();
        String key = getObjectMetadataRequest.getKey();
        String versionId = getObjectMetadataRequest.getVersionId();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting an object's metadata");
        ValidationUtils.assertParameterNotNull(key, "The key parameter must be specified when requesting an object's metadata");
        Request createRequest = createRequest(bucketName, key, getObjectMetadataRequest, HttpMethodName.HEAD);
        if (versionId != null) {
            createRequest.addParameter("versionId", versionId);
        }
        populateRequesterPaysHeader(createRequest, getObjectMetadataRequest.isRequesterPays());
        addPartNumberIfNotNull(createRequest, getObjectMetadataRequest.getPartNumber());
        populateSSE_C(createRequest, getObjectMetadataRequest.getSSECustomerKey());
        return (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
    }

    public S3Object getObject(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return getObject(new GetObjectRequest(str, str2));
    }

    public boolean doesBucketExist(String str) throws AmazonClientException, AmazonServiceException {
        try {
            headBucket(new HeadBucketRequest(str));
            return true;
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 301 || e.getStatusCode() == 403) {
                return true;
            }
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public boolean doesObjectExist(String str, String str2) throws AmazonServiceException, AmazonClientException {
        try {
            getObjectMetadata(str, str2);
            return true;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public HeadBucketResult headBucket(HeadBucketRequest headBucketRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = headBucketRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucketName parameter must be specified.");
        return (HeadBucketResult) invoke(createRequest(bucketName, (String) null, headBucketRequest, HttpMethodName.HEAD), new HeadBucketResultHandler(), bucketName, (String) null);
    }

    public void changeObjectStorageClass(String str, String str2, StorageClass storageClass) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucketName parameter must be specified when changing an object's storage class");
        ValidationUtils.assertParameterNotNull(str2, "The key parameter must be specified when changing an object's storage class");
        ValidationUtils.assertParameterNotNull(storageClass, "The newStorageClass parameter must be specified when changing an object's storage class");
        copyObject(new CopyObjectRequest(str, str2, str, str2).withStorageClass(storageClass.toString()));
    }

    public void setObjectRedirectLocation(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucketName parameter must be specified when changing an object's storage class");
        ValidationUtils.assertParameterNotNull(str2, "The key parameter must be specified when changing an object's storage class");
        ValidationUtils.assertParameterNotNull(str3, "The newStorageClass parameter must be specified when changing an object's storage class");
        copyObject(new CopyObjectRequest(str, str2, str, str2).withRedirectLocation(str3));
    }

    public S3Object getObject(GetObjectRequest getObjectRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getObjectRequest, "The GetObjectRequest parameter must be specified when requesting an object");
        ValidationUtils.assertParameterNotNull(getObjectRequest.getBucketName(), "The bucket name parameter must be specified when requesting an object");
        ValidationUtils.assertParameterNotNull(getObjectRequest.getKey(), "The key parameter must be specified when requesting an object");
        Request createRequest = createRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey(), getObjectRequest, HttpMethodName.GET);
        if (getObjectRequest.getVersionId() != null) {
            createRequest.addParameter("versionId", getObjectRequest.getVersionId());
        }
        long[] range = getObjectRequest.getRange();
        if (range != null) {
            String str = "bytes=" + Long.toString(range[0]) + "-";
            if (range[1] >= 0) {
                str = str + Long.toString(range[1]);
            }
            createRequest.addHeader("Range", str);
        }
        populateRequesterPaysHeader(createRequest, getObjectRequest.isRequesterPays());
        addResponseHeaderParameters(createRequest, getObjectRequest.getResponseHeaders());
        addDateHeader(createRequest, "If-Modified-Since", getObjectRequest.getModifiedSinceConstraint());
        addDateHeader(createRequest, "If-Unmodified-Since", getObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(createRequest, "If-Match", getObjectRequest.getMatchingETagConstraints());
        addStringListHeader(createRequest, "If-None-Match", getObjectRequest.getNonmatchingETagConstraints());
        populateSSE_C(createRequest, getObjectRequest.getSSECustomerKey());
        ProgressListenerCallbackExecutor wrapListener = ProgressListenerCallbackExecutor.wrapListener(getObjectRequest.getGeneralProgressListener());
        try {
            S3Object s3Object = (S3Object) invoke(createRequest, new S3ObjectResponseHandler(), getObjectRequest.getBucketName(), getObjectRequest.getKey());
            s3Object.setBucketName(getObjectRequest.getBucketName());
            s3Object.setKey(getObjectRequest.getKey());
            ProgressReportingInputStream serviceClientHolderInputStream = new ServiceClientHolderInputStream(s3Object.getObjectContent(), this);
            if (wrapListener != null) {
                ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(serviceClientHolderInputStream, wrapListener);
                progressReportingInputStream.setFireCompletedEvent(true);
                progressReportingInputStream.setNotificationThreshold(this.notificationThreshold);
                fireProgressEvent(wrapListener, 2);
                serviceClientHolderInputStream = progressReportingInputStream;
            }
            s3Object.setObjectContent(new S3ObjectInputStream(new LengthCheckInputStream(serviceClientHolderInputStream, s3Object.getObjectMetadata().getContentLength(), true)));
            return s3Object;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == 412 || e.getStatusCode() == 304) {
                fireProgressEvent(wrapListener, 16);
                return null;
            }
            fireProgressEvent(wrapListener, 8);
            throw e;
        }
    }

    public ObjectMetadata getObject(final GetObjectRequest getObjectRequest, File file) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(file, "The destination file parameter must be specified when downloading an object directly to a file");
        boolean z = false;
        if (getObjectRequest.getRange() != null && getObjectRequest.getRange()[0] > 0) {
            z = true;
        }
        S3Object retryableDownloadS3ObjectToFile = ServiceUtils.retryableDownloadS3ObjectToFile(file, new ServiceUtils.RetryableS3DownloadTask() {
            public S3Object getS3ObjectStream() {
                return AmazonS3Client.this.getObject(getObjectRequest);
            }

            public boolean needIntegrityCheck() {
                return !ServiceUtils.skipMd5CheckPerRequest(getObjectRequest, AmazonS3Client.this.clientOptions);
            }
        }, z);
        if (retryableDownloadS3ObjectToFile == null) {
            return null;
        }
        return retryableDownloadS3ObjectToFile.getObjectMetadata();
    }

    public void deleteBucket(String str) throws AmazonClientException, AmazonServiceException {
        deleteBucket(new DeleteBucketRequest(str));
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(deleteBucketRequest, "The DeleteBucketRequest parameter must be specified when deleting a bucket");
        String bucketName = deleteBucketRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting a bucket");
        invoke(createRequest(bucketName, (String) null, deleteBucketRequest, HttpMethodName.DELETE), this.voidResponseHandler, bucketName, (String) null);
        bucketRegionCache.remove(bucketName);
    }

    public PutObjectResult putObject(String str, String str2, File file) throws AmazonClientException, AmazonServiceException {
        return putObject(new PutObjectRequest(str, str2, file).withMetadata(new ObjectMetadata()));
    }

    public PutObjectResult putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonClientException, AmazonServiceException {
        return putObject(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws AmazonClientException, AmazonServiceException {
        ByteArrayInputStream byteArrayInputStream;
        PutObjectRequest putObjectRequest2 = putObjectRequest;
        ValidationUtils.assertParameterNotNull(putObjectRequest2, "The PutObjectRequest parameter must be specified when uploading an object");
        String bucketName = putObjectRequest.getBucketName();
        String key = putObjectRequest.getKey();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        InputStream inputStream = putObjectRequest.getInputStream();
        ProgressListenerCallbackExecutor wrapListener = ProgressListenerCallbackExecutor.wrapListener(putObjectRequest.getGeneralProgressListener());
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when uploading an object");
        ValidationUtils.assertParameterNotNull(key, "The key parameter must be specified when uploading an object");
        boolean skipMd5CheckPerRequest = ServiceUtils.skipMd5CheckPerRequest(putObjectRequest2, this.clientOptions);
        if (putObjectRequest.getFile() != null) {
            File file = putObjectRequest.getFile();
            metadata.setContentLength(file.length());
            boolean z = metadata.getContentMD5() == null;
            if (metadata.getContentType() == null) {
                metadata.setContentType(Mimetypes.getInstance().getMimetype(file));
            }
            if (z && !skipMd5CheckPerRequest) {
                try {
                    metadata.setContentMD5(Md5Utils.md5AsBase64(file));
                } catch (Exception e) {
                    throw new AmazonClientException("Unable to calculate MD5 hash: " + e.getMessage(), e);
                }
            }
            try {
                inputStream = new RepeatableFileInputStream(file);
            } catch (FileNotFoundException e2) {
                throw new AmazonClientException("Unable to find file to upload", e2);
            }
        }
        Request createRequest = createRequest(bucketName, key, putObjectRequest2, HttpMethodName.PUT);
        if (putObjectRequest.getAccessControlList() != null) {
            addAclHeaders(createRequest, putObjectRequest.getAccessControlList());
        } else if (putObjectRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.S3_CANNED_ACL, putObjectRequest.getCannedAcl().toString());
        }
        if (putObjectRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.STORAGE_CLASS, putObjectRequest.getStorageClass());
        }
        ByteArrayInputStream byteArrayInputStream2 = inputStream;
        if (putObjectRequest.getRedirectLocation() != null) {
            createRequest.addHeader(Headers.REDIRECT_LOCATION, putObjectRequest.getRedirectLocation());
            byteArrayInputStream2 = inputStream;
            if (inputStream == null) {
                setZeroContentLength(createRequest);
                byteArrayInputStream2 = new ByteArrayInputStream(new byte[0]);
            }
        }
        addHeaderIfNotNull(createRequest, Headers.S3_TAGGING, urlEncodeTags(putObjectRequest.getTagging()));
        populateRequesterPaysHeader(createRequest, putObjectRequest.isRequesterPays());
        populateSSE_C(createRequest, putObjectRequest.getSSECustomerKey());
        Long l = (Long) metadata.getRawMetadataValue("Content-Length");
        if (l != null) {
            long longValue = l.longValue();
            byteArrayInputStream = byteArrayInputStream2;
            if (longValue >= 0) {
                ByteArrayInputStream lengthCheckInputStream = new LengthCheckInputStream(byteArrayInputStream2, longValue, false);
                createRequest.addHeader("Content-Length", l.toString());
                byteArrayInputStream = lengthCheckInputStream;
            }
        } else if (!byteArrayInputStream2.markSupported()) {
            log.warn("No content length specified for stream data.  Stream contents will be buffered in memory and could result in out of memory errors.");
            ByteArrayInputStream byteArray = toByteArray(byteArrayInputStream2);
            createRequest.addHeader("Content-Length", String.valueOf(byteArray.available()));
            createRequest.setStreaming(true);
            byteArrayInputStream = byteArray;
        } else {
            createRequest.addHeader("Content-Length", String.valueOf(calculateContentLength(byteArrayInputStream2)));
            byteArrayInputStream = byteArrayInputStream2;
        }
        if (wrapListener != null) {
            ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(byteArrayInputStream, wrapListener);
            progressReportingInputStream.setNotificationThreshold(this.notificationThreshold);
            fireProgressEvent(wrapListener, 2);
            byteArrayInputStream = progressReportingInputStream;
        }
        if (metadata.getContentType() == null) {
            metadata.setContentType(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        }
        populateRequestMetadata(createRequest, metadata);
        populateSSE_KMS(createRequest, putObjectRequest.getSSEAwsKeyManagementParams());
        createRequest.setContent(byteArrayInputStream);
        try {
            ObjectMetadata objectMetadata = (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
            try {
                byteArrayInputStream.close();
            } catch (AbortedException unused) {
            } catch (Exception e3) {
                Exception exc = e3;
                Log log2 = log;
                log2.debug("Unable to cleanly close input stream: " + exc.getMessage(), exc);
            }
            fireProgressEvent(wrapListener, 4);
            PutObjectResult putObjectResult = new PutObjectResult();
            putObjectResult.setVersionId(objectMetadata.getVersionId());
            putObjectResult.setSSEAlgorithm(objectMetadata.getSSEAlgorithm());
            putObjectResult.setSSECustomerAlgorithm(objectMetadata.getSSECustomerAlgorithm());
            putObjectResult.setSSECustomerKeyMd5(objectMetadata.getSSECustomerKeyMd5());
            putObjectResult.setExpirationTime(objectMetadata.getExpirationTime());
            putObjectResult.setExpirationTimeRuleId(objectMetadata.getExpirationTimeRuleId());
            putObjectResult.setETag(objectMetadata.getETag());
            putObjectResult.setMetadata(objectMetadata);
            putObjectResult.setRequesterCharged(objectMetadata.isRequesterCharged());
            putObjectResult.setContentMd5(objectMetadata.getContentMD5());
            return putObjectResult;
        } catch (AmazonClientException e4) {
            fireProgressEvent(wrapListener, 8);
            throw e4;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                byteArrayInputStream.close();
            } catch (AbortedException unused2) {
            } catch (Exception e5) {
                Exception exc2 = e5;
                Log log3 = log;
                log3.debug("Unable to cleanly close input stream: " + exc2.getMessage(), exc2);
            }
            throw th2;
        }
    }

    private long calculateContentLength(InputStream inputStream) {
        byte[] bArr = new byte[8192];
        inputStream.mark(-1);
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    j += (long) read;
                } else {
                    inputStream.reset();
                    return j;
                }
            } catch (IOException e) {
                throw new AmazonClientException("Could not calculate content length.", e);
            }
        }
    }

    private static void addAclHeaders(Request<? extends AmazonWebServiceRequest> request, AccessControlList accessControlList) {
        Set<Grant> grants = accessControlList.getGrants();
        HashMap hashMap = new HashMap();
        for (Grant next : grants) {
            if (!hashMap.containsKey(next.getPermission())) {
                hashMap.put(next.getPermission(), new LinkedList());
            }
            ((Collection) hashMap.get(next.getPermission())).add(next.getGrantee());
        }
        for (Permission permission : Permission.values()) {
            if (hashMap.containsKey(permission)) {
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                for (Grantee grantee : (Collection) hashMap.get(permission)) {
                    if (!z) {
                        z = true;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(grantee.getTypeIdentifier());
                    sb.append("=");
                    sb.append("\"");
                    sb.append(grantee.getIdentifier());
                    sb.append("\"");
                }
                request.addHeader(permission.getHeaderName(), sb.toString());
            }
        }
    }

    public CopyObjectResult copyObject(String str, String str2, String str3, String str4) throws AmazonClientException, AmazonServiceException {
        return copyObject(new CopyObjectRequest(str, str2, str3, str4));
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(copyObjectRequest.getSourceBucketName(), "The source bucket name must be specified when copying an object");
        ValidationUtils.assertParameterNotNull(copyObjectRequest.getSourceKey(), "The source object key must be specified when copying an object");
        ValidationUtils.assertParameterNotNull(copyObjectRequest.getDestinationBucketName(), "The destination bucket name must be specified when copying an object");
        ValidationUtils.assertParameterNotNull(copyObjectRequest.getDestinationKey(), "The destination object key must be specified when copying an object");
        String destinationKey = copyObjectRequest.getDestinationKey();
        String destinationBucketName = copyObjectRequest.getDestinationBucketName();
        Request createRequest = createRequest(destinationBucketName, destinationKey, copyObjectRequest, HttpMethodName.PUT);
        populateRequestWithCopyObjectParameters(createRequest, copyObjectRequest);
        populateSSE_KMS(createRequest, copyObjectRequest.getSSEAwsKeyManagementParams());
        setZeroContentLength(createRequest);
        try {
            XmlResponsesSaxParser.CopyObjectResultHandler copyObjectResultHandler = (XmlResponsesSaxParser.CopyObjectResultHandler) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.CopyObjectUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new S3VersionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3RequesterChargedHeaderHandler()), destinationBucketName, destinationKey);
            if (copyObjectResultHandler.getErrorCode() == null) {
                CopyObjectResult copyObjectResult = new CopyObjectResult();
                copyObjectResult.setETag(copyObjectResultHandler.getETag());
                copyObjectResult.setLastModifiedDate(copyObjectResultHandler.getLastModified());
                copyObjectResult.setVersionId(copyObjectResultHandler.getVersionId());
                copyObjectResult.setSSEAlgorithm(copyObjectResultHandler.getSSEAlgorithm());
                copyObjectResult.setSSECustomerAlgorithm(copyObjectResultHandler.getSSECustomerAlgorithm());
                copyObjectResult.setSSECustomerKeyMd5(copyObjectResultHandler.getSSECustomerKeyMd5());
                copyObjectResult.setExpirationTime(copyObjectResultHandler.getExpirationTime());
                copyObjectResult.setExpirationTimeRuleId(copyObjectResultHandler.getExpirationTimeRuleId());
                copyObjectResult.setRequesterCharged(copyObjectResultHandler.isRequesterCharged());
                return copyObjectResult;
            }
            String errorCode = copyObjectResultHandler.getErrorCode();
            String errorMessage = copyObjectResultHandler.getErrorMessage();
            String errorRequestId = copyObjectResultHandler.getErrorRequestId();
            String errorHostId = copyObjectResultHandler.getErrorHostId();
            AmazonS3Exception amazonS3Exception = new AmazonS3Exception(errorMessage);
            amazonS3Exception.setErrorCode(errorCode);
            amazonS3Exception.setErrorType(AmazonServiceException.ErrorType.Service);
            amazonS3Exception.setRequestId(errorRequestId);
            amazonS3Exception.setExtendedRequestId(errorHostId);
            amazonS3Exception.setServiceName(createRequest.getServiceName());
            amazonS3Exception.setStatusCode(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
            throw amazonS3Exception;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == 412) {
                return null;
            }
            throw e;
        }
    }

    public CopyPartResult copyPart(CopyPartRequest copyPartRequest) {
        ValidationUtils.assertParameterNotNull(copyPartRequest.getSourceBucketName(), "The source bucket name must be specified when copying a part");
        ValidationUtils.assertParameterNotNull(copyPartRequest.getSourceKey(), "The source object key must be specified when copying a part");
        ValidationUtils.assertParameterNotNull(copyPartRequest.getDestinationBucketName(), "The destination bucket name must be specified when copying a part");
        ValidationUtils.assertParameterNotNull(copyPartRequest.getUploadId(), "The upload id must be specified when copying a part");
        ValidationUtils.assertParameterNotNull(copyPartRequest.getDestinationKey(), "The destination object key must be specified when copying a part");
        ValidationUtils.assertParameterNotNull(Integer.valueOf(copyPartRequest.getPartNumber()), "The part number must be specified when copying a part");
        String destinationKey = copyPartRequest.getDestinationKey();
        String destinationBucketName = copyPartRequest.getDestinationBucketName();
        Request createRequest = createRequest(destinationBucketName, destinationKey, copyPartRequest, HttpMethodName.PUT);
        populateRequestWithCopyPartParameters(createRequest, copyPartRequest);
        createRequest.addParameter(RequestParameters.UPLOAD_ID, copyPartRequest.getUploadId());
        createRequest.addParameter(RequestParameters.PART_NUMBER, Integer.toString(copyPartRequest.getPartNumber()));
        setZeroContentLength(createRequest);
        try {
            XmlResponsesSaxParser.CopyObjectResultHandler copyObjectResultHandler = (XmlResponsesSaxParser.CopyObjectResultHandler) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.CopyObjectUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new S3VersionHeaderHandler()), destinationBucketName, destinationKey);
            if (copyObjectResultHandler.getErrorCode() == null) {
                CopyPartResult copyPartResult = new CopyPartResult();
                copyPartResult.setETag(copyObjectResultHandler.getETag());
                copyPartResult.setPartNumber(copyPartRequest.getPartNumber());
                copyPartResult.setLastModifiedDate(copyObjectResultHandler.getLastModified());
                copyPartResult.setVersionId(copyObjectResultHandler.getVersionId());
                copyPartResult.setSSEAlgorithm(copyObjectResultHandler.getSSEAlgorithm());
                copyPartResult.setSSECustomerAlgorithm(copyObjectResultHandler.getSSECustomerAlgorithm());
                copyPartResult.setSSECustomerKeyMd5(copyObjectResultHandler.getSSECustomerKeyMd5());
                return copyPartResult;
            }
            String errorCode = copyObjectResultHandler.getErrorCode();
            String errorMessage = copyObjectResultHandler.getErrorMessage();
            String errorRequestId = copyObjectResultHandler.getErrorRequestId();
            String errorHostId = copyObjectResultHandler.getErrorHostId();
            AmazonS3Exception amazonS3Exception = new AmazonS3Exception(errorMessage);
            amazonS3Exception.setErrorCode(errorCode);
            amazonS3Exception.setErrorType(AmazonServiceException.ErrorType.Service);
            amazonS3Exception.setRequestId(errorRequestId);
            amazonS3Exception.setExtendedRequestId(errorHostId);
            amazonS3Exception.setServiceName(createRequest.getServiceName());
            amazonS3Exception.setStatusCode(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
            throw amazonS3Exception;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == 412) {
                return null;
            }
            throw e;
        }
    }

    public void deleteObject(String str, String str2) throws AmazonClientException, AmazonServiceException {
        deleteObject(new DeleteObjectRequest(str, str2));
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(deleteObjectRequest, "The delete object request must be specified when deleting an object");
        ValidationUtils.assertParameterNotNull(deleteObjectRequest.getBucketName(), "The bucket name must be specified when deleting an object");
        ValidationUtils.assertParameterNotNull(deleteObjectRequest.getKey(), "The key must be specified when deleting an object");
        invoke(createRequest(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey(), deleteObjectRequest, HttpMethodName.DELETE), this.voidResponseHandler, deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey());
    }

    public DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest) {
        Request createRequest = createRequest(deleteObjectsRequest.getBucketName(), (String) null, deleteObjectsRequest, HttpMethodName.POST);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_DELETE, (String) null);
        if (deleteObjectsRequest.getMfa() != null) {
            populateRequestWithMfaDetails(createRequest, deleteObjectsRequest.getMfa());
        }
        populateRequesterPaysHeader(createRequest, deleteObjectsRequest.isRequesterPays());
        byte[] convertToXmlByteArray = new MultiObjectDeleteXmlFactory().convertToXmlByteArray(deleteObjectsRequest);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            ResponseHeaderHandlerChain responseHeaderHandlerChain = new ResponseHeaderHandlerChain(new Unmarshallers.DeleteObjectsResultUnmarshaller(), new S3RequesterChargedHeaderHandler());
            DeleteObjectsResponse deleteObjectsResponse = (DeleteObjectsResponse) invoke(createRequest, responseHeaderHandlerChain, deleteObjectsRequest.getBucketName(), (String) null);
            if (deleteObjectsResponse.getErrors().isEmpty()) {
                return new DeleteObjectsResult(deleteObjectsResponse.getDeletedObjects(), deleteObjectsResponse.isRequesterCharged());
            }
            Map<String, String> responseHeaders = responseHeaderHandlerChain.getResponseHeaders();
            MultiObjectDeleteException multiObjectDeleteException = new MultiObjectDeleteException(deleteObjectsResponse.getErrors(), deleteObjectsResponse.getDeletedObjects());
            multiObjectDeleteException.setStatusCode(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
            multiObjectDeleteException.setRequestId(responseHeaders.get(Headers.REQUEST_ID));
            multiObjectDeleteException.setExtendedRequestId(responseHeaders.get(Headers.EXTENDED_REQUEST_ID));
            multiObjectDeleteException.setCloudFrontId(responseHeaders.get(Headers.CLOUD_FRONT_ID));
            throw multiObjectDeleteException;
        } catch (Exception e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void deleteVersion(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        deleteVersion(new DeleteVersionRequest(str, str2, str3));
    }

    public void deleteVersion(DeleteVersionRequest deleteVersionRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(deleteVersionRequest, "The delete version request object must be specified when deleting a version");
        String bucketName = deleteVersionRequest.getBucketName();
        String key = deleteVersionRequest.getKey();
        String versionId = deleteVersionRequest.getVersionId();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specified when deleting a version");
        ValidationUtils.assertParameterNotNull(key, "The key must be specified when deleting a version");
        ValidationUtils.assertParameterNotNull(versionId, "The version ID must be specified when deleting a version");
        Request createRequest = createRequest(bucketName, key, deleteVersionRequest, HttpMethodName.DELETE);
        if (versionId != null) {
            createRequest.addParameter("versionId", versionId);
        }
        if (deleteVersionRequest.getMfa() != null) {
            populateRequestWithMfaDetails(createRequest, deleteVersionRequest.getMfa());
        }
        invoke(createRequest, this.voidResponseHandler, bucketName, key);
    }

    public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(setBucketVersioningConfigurationRequest, "The SetBucketVersioningConfigurationRequest object must be specified when setting versioning configuration");
        String bucketName = setBucketVersioningConfigurationRequest.getBucketName();
        BucketVersioningConfiguration versioningConfiguration = setBucketVersioningConfigurationRequest.getVersioningConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting versioning configuration");
        ValidationUtils.assertParameterNotNull(versioningConfiguration, "The bucket versioning parameter must be specified when setting versioning configuration");
        if (versioningConfiguration.isMfaDeleteEnabled() != null) {
            ValidationUtils.assertParameterNotNull(setBucketVersioningConfigurationRequest.getMfa(), "The MFA parameter must be specified when changing MFA Delete status in the versioning configuration");
        }
        Request createRequest = createRequest(bucketName, (String) null, setBucketVersioningConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("versioning", (String) null);
        if (!(versioningConfiguration.isMfaDeleteEnabled() == null || setBucketVersioningConfigurationRequest.getMfa() == null)) {
            populateRequestWithMfaDetails(createRequest, setBucketVersioningConfigurationRequest.getMfa());
        }
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(versioningConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public BucketVersioningConfiguration getBucketVersioningConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketVersioningConfiguration(new GetBucketVersioningConfigurationRequest(str));
    }

    public BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest getBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getBucketVersioningConfigurationRequest, "The request object parameter getBucketVersioningConfigurationRequest must be specified.");
        String bucketName = getBucketVersioningConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when querying versioning configuration");
        Request createRequest = createRequest(bucketName, (String) null, getBucketVersioningConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("versioning", (String) null);
        return (BucketVersioningConfiguration) invoke(createRequest, new Unmarshallers.BucketVersioningConfigurationUnmarshaller(), bucketName, (String) null);
    }

    public BucketWebsiteConfiguration getBucketWebsiteConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketWebsiteConfiguration(new GetBucketWebsiteConfigurationRequest(str));
    }

    public BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = getBucketWebsiteConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's website configuration");
        Request createRequest = createRequest(bucketName, (String) null, getBucketWebsiteConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_WEBSITE, (String) null);
        createRequest.addHeader("Content-Type", "application/xml");
        try {
            return (BucketWebsiteConfiguration) invoke(createRequest, new Unmarshallers.BucketWebsiteConfigurationUnmarshaller(), bucketName, (String) null);
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                return null;
            }
            throw e;
        }
    }

    public BucketLifecycleConfiguration getBucketLifecycleConfiguration(String str) {
        return getBucketLifecycleConfiguration(new GetBucketLifecycleConfigurationRequest(str));
    }

    public BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(getBucketLifecycleConfigurationRequest, "The request object pamameter getBucketLifecycleConfigurationRequest must be specified.");
        String bucketName = getBucketLifecycleConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specifed when retrieving the bucket lifecycle configuration.");
        Request createRequest = createRequest(bucketName, (String) null, getBucketLifecycleConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_LIFECYCLE, (String) null);
        try {
            return (BucketLifecycleConfiguration) invoke(createRequest, new Unmarshallers.BucketLifecycleConfigurationUnmarshaller(), bucketName, (String) null);
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                return null;
            }
            throw e;
        }
    }

    public void setBucketLifecycleConfiguration(String str, BucketLifecycleConfiguration bucketLifecycleConfiguration) {
        setBucketLifecycleConfiguration(new SetBucketLifecycleConfigurationRequest(str, bucketLifecycleConfiguration));
    }

    public void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(setBucketLifecycleConfigurationRequest, "The set bucket lifecycle configuration request object must be specified.");
        String bucketName = setBucketLifecycleConfigurationRequest.getBucketName();
        BucketLifecycleConfiguration lifecycleConfiguration = setBucketLifecycleConfigurationRequest.getLifecycleConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting bucket lifecycle configuration.");
        ValidationUtils.assertParameterNotNull(lifecycleConfiguration, "The lifecycle configuration parameter must be specified when setting bucket lifecycle configuration.");
        Request createRequest = createRequest(bucketName, (String) null, setBucketLifecycleConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_LIFECYCLE, (String) null);
        byte[] convertToXmlByteArray = new BucketConfigurationXmlFactory().convertToXmlByteArray(lifecycleConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
        } catch (Exception e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void deleteBucketLifecycleConfiguration(String str) {
        deleteBucketLifecycleConfiguration(new DeleteBucketLifecycleConfigurationRequest(str));
    }

    public void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(deleteBucketLifecycleConfigurationRequest, "The delete bucket lifecycle configuration request object must be specified.");
        String bucketName = deleteBucketLifecycleConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting bucket lifecycle configuration.");
        Request createRequest = createRequest(bucketName, (String) null, deleteBucketLifecycleConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_LIFECYCLE, (String) null);
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String str) {
        return getBucketCrossOriginConfiguration(new GetBucketCrossOriginConfigurationRequest(str));
    }

    public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest getBucketCrossOriginConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(getBucketCrossOriginConfigurationRequest, "The request object parameter getBucketCrossOriginConfigurationRequest must be specified.");
        String bucketName = getBucketCrossOriginConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specified when retrieving the bucket cross origin configuration.");
        Request createRequest = createRequest(bucketName, (String) null, getBucketCrossOriginConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_CORS, (String) null);
        try {
            return (BucketCrossOriginConfiguration) invoke(createRequest, new Unmarshallers.BucketCrossOriginConfigurationUnmarshaller(), bucketName, (String) null);
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                return null;
            }
            throw e;
        }
    }

    public void setBucketCrossOriginConfiguration(String str, BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {
        setBucketCrossOriginConfiguration(new SetBucketCrossOriginConfigurationRequest(str, bucketCrossOriginConfiguration));
    }

    public void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(setBucketCrossOriginConfigurationRequest, "The set bucket cross origin configuration request object must be specified.");
        String bucketName = setBucketCrossOriginConfigurationRequest.getBucketName();
        BucketCrossOriginConfiguration crossOriginConfiguration = setBucketCrossOriginConfigurationRequest.getCrossOriginConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting bucket cross origin configuration.");
        ValidationUtils.assertParameterNotNull(crossOriginConfiguration, "The cross origin configuration parameter must be specified when setting bucket cross origin configuration.");
        Request createRequest = createRequest(bucketName, (String) null, setBucketCrossOriginConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_CORS, (String) null);
        byte[] convertToXmlByteArray = new BucketConfigurationXmlFactory().convertToXmlByteArray(crossOriginConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
        } catch (Exception e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void deleteBucketCrossOriginConfiguration(String str) {
        deleteBucketCrossOriginConfiguration(new DeleteBucketCrossOriginConfigurationRequest(str));
    }

    public void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(deleteBucketCrossOriginConfigurationRequest, "The delete bucket cross origin configuration request object must be specified.");
        String bucketName = deleteBucketCrossOriginConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting bucket cross origin configuration.");
        Request createRequest = createRequest(bucketName, (String) null, deleteBucketCrossOriginConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_CORS, (String) null);
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public BucketTaggingConfiguration getBucketTaggingConfiguration(String str) {
        return getBucketTaggingConfiguration(new GetBucketTaggingConfigurationRequest(str));
    }

    public BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest getBucketTaggingConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(getBucketTaggingConfigurationRequest, "The request object parameter getBucketTaggingConfigurationRequest must be specifed.");
        String bucketName = getBucketTaggingConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specified when retrieving the bucket tagging configuration.");
        Request createRequest = createRequest(bucketName, (String) null, getBucketTaggingConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("tagging", (String) null);
        try {
            return (BucketTaggingConfiguration) invoke(createRequest, new Unmarshallers.BucketTaggingConfigurationUnmarshaller(), bucketName, (String) null);
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                return null;
            }
            throw e;
        }
    }

    public void setBucketTaggingConfiguration(String str, BucketTaggingConfiguration bucketTaggingConfiguration) {
        setBucketTaggingConfiguration(new SetBucketTaggingConfigurationRequest(str, bucketTaggingConfiguration));
    }

    public void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(setBucketTaggingConfigurationRequest, "The set bucket tagging configuration request object must be specified.");
        String bucketName = setBucketTaggingConfigurationRequest.getBucketName();
        BucketTaggingConfiguration taggingConfiguration = setBucketTaggingConfigurationRequest.getTaggingConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting bucket tagging configuration.");
        ValidationUtils.assertParameterNotNull(taggingConfiguration, "The tagging configuration parameter must be specified when setting bucket tagging configuration.");
        Request createRequest = createRequest(bucketName, (String) null, setBucketTaggingConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("tagging", (String) null);
        byte[] convertToXmlByteArray = new BucketConfigurationXmlFactory().convertToXmlByteArray(taggingConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
        } catch (Exception e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void deleteBucketTaggingConfiguration(String str) {
        deleteBucketTaggingConfiguration(new DeleteBucketTaggingConfigurationRequest(str));
    }

    public void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest) {
        ValidationUtils.assertParameterNotNull(deleteBucketTaggingConfigurationRequest, "The delete bucket tagging configuration request object must be specified.");
        String bucketName = deleteBucketTaggingConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting bucket tagging configuration.");
        Request createRequest = createRequest(bucketName, (String) null, deleteBucketTaggingConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter("tagging", (String) null);
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public void setBucketWebsiteConfiguration(String str, BucketWebsiteConfiguration bucketWebsiteConfiguration) throws AmazonClientException, AmazonServiceException {
        setBucketWebsiteConfiguration(new SetBucketWebsiteConfigurationRequest(str, bucketWebsiteConfiguration));
    }

    public void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = setBucketWebsiteConfigurationRequest.getBucketName();
        BucketWebsiteConfiguration configuration = setBucketWebsiteConfigurationRequest.getConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting a bucket's website configuration");
        ValidationUtils.assertParameterNotNull(configuration, "The bucket website configuration parameter must be specified when setting a bucket's website configuration");
        if (configuration.getRedirectAllRequestsTo() == null) {
            ValidationUtils.assertParameterNotNull(configuration.getIndexDocumentSuffix(), "The bucket website configuration parameter must specify the index document suffix when setting a bucket's website configuration");
        }
        Request createRequest = createRequest(bucketName, (String) null, setBucketWebsiteConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_WEBSITE, (String) null);
        createRequest.addHeader("Content-Type", "application/xml");
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(configuration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public void deleteBucketWebsiteConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        deleteBucketWebsiteConfiguration(new DeleteBucketWebsiteConfigurationRequest(str));
    }

    public void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = deleteBucketWebsiteConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting a bucket's website configuration");
        Request createRequest = createRequest(bucketName, (String) null, deleteBucketWebsiteConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_WEBSITE, (String) null);
        createRequest.addHeader("Content-Type", "application/xml");
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public void setBucketNotificationConfiguration(String str, BucketNotificationConfiguration bucketNotificationConfiguration) throws AmazonClientException, AmazonServiceException {
        setBucketNotificationConfiguration(new SetBucketNotificationConfigurationRequest(str, bucketNotificationConfiguration));
    }

    public void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(setBucketNotificationConfigurationRequest, "The set bucket notification configuration request object must be specified.");
        String bucketName = setBucketNotificationConfigurationRequest.getBucketName();
        BucketNotificationConfiguration notificationConfiguration = setBucketNotificationConfigurationRequest.getNotificationConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting bucket notification configuration.");
        ValidationUtils.assertParameterNotNull(notificationConfiguration, "The notification configuration parameter must be specified when setting bucket notification configuration.");
        Request createRequest = createRequest(bucketName, (String) null, setBucketNotificationConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter(TransferService.INTENT_KEY_NOTIFICATION, (String) null);
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(notificationConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public BucketNotificationConfiguration getBucketNotificationConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucket name parameter must be specified when querying notification configuration");
        return getBucketNotificationConfiguration(new GetBucketNotificationConfigurationRequest(str));
    }

    public BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = getBucketNotificationConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket request must specify a bucket name when querying notification configuration");
        Request createRequest = createRequest(bucketName, (String) null, getBucketNotificationConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter(TransferService.INTENT_KEY_NOTIFICATION, (String) null);
        return (BucketNotificationConfiguration) invoke(createRequest, BucketNotificationConfigurationStaxUnmarshaller.getInstance(), bucketName, (String) null);
    }

    public BucketLoggingConfiguration getBucketLoggingConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucket name parameter must be specified when requesting a bucket's logging status");
        return getBucketLoggingConfiguration(new GetBucketLoggingConfigurationRequest(str));
    }

    public BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest getBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getBucketLoggingConfigurationRequest, "The bucket logging configuration");
        Request createRequest = createRequest(getBucketLoggingConfigurationRequest.getBucketName(), (String) null, getBucketLoggingConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_LOGGING, (String) null);
        return (BucketLoggingConfiguration) invoke(createRequest, new Unmarshallers.BucketLoggingConfigurationnmarshaller(), getBucketLoggingConfigurationRequest.getBucketName(), (String) null);
    }

    public void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(setBucketLoggingConfigurationRequest, "The set bucket logging configuration request object must be specified when enabling server access logging");
        String bucketName = setBucketLoggingConfigurationRequest.getBucketName();
        BucketLoggingConfiguration loggingConfiguration = setBucketLoggingConfigurationRequest.getLoggingConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when enabling server access logging");
        ValidationUtils.assertParameterNotNull(loggingConfiguration, "The logging configuration parameter must be specified when enabling server access logging");
        Request createRequest = createRequest(bucketName, (String) null, setBucketLoggingConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_LOGGING, (String) null);
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(loggingConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public BucketAccelerateConfiguration getBucketAccelerateConfiguration(String str) throws AmazonServiceException, AmazonClientException {
        return getBucketAccelerateConfiguration(new GetBucketAccelerateConfigurationRequest(str));
    }

    public BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(getBucketAccelerateConfigurationRequest, "getBucketAccelerateConfigurationRequest must be specified.");
        String bucketName = getBucketAccelerateConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when querying accelerate configuration");
        Request createRequest = createRequest(bucketName, (String) null, getBucketAccelerateConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("accelerate", (String) null);
        return (BucketAccelerateConfiguration) invoke(createRequest, new Unmarshallers.BucketAccelerateConfigurationUnmarshaller(), bucketName, (String) null);
    }

    public void setBucketAccelerateConfiguration(String str, BucketAccelerateConfiguration bucketAccelerateConfiguration) throws AmazonServiceException, AmazonClientException {
        setBucketAccelerateConfiguration(new SetBucketAccelerateConfigurationRequest(str, bucketAccelerateConfiguration));
    }

    public void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest setBucketAccelerateConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(setBucketAccelerateConfigurationRequest, "setBucketAccelerateConfigurationRequest must be specified");
        String bucketName = setBucketAccelerateConfigurationRequest.getBucketName();
        BucketAccelerateConfiguration accelerateConfiguration = setBucketAccelerateConfigurationRequest.getAccelerateConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting accelerate configuration.");
        ValidationUtils.assertParameterNotNull(accelerateConfiguration, "The bucket accelerate configuration parameter must be specified.");
        ValidationUtils.assertParameterNotNull(accelerateConfiguration.getStatus(), "The status parameter must be specified when updating bucket accelerate configuration.");
        Request createRequest = createRequest(bucketName, (String) null, setBucketAccelerateConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("accelerate", (String) null);
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(accelerateConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public BucketPolicy getBucketPolicy(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketPolicy(new GetBucketPolicyRequest(str));
    }

    public void setBucketPolicy(String str, String str2) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(str, "The bucket name must be specified when setting a bucket policy");
        ValidationUtils.assertParameterNotNull(str2, "The policy text must be specified when setting a bucket policy");
        Request createRequest = createRequest(str, (String) null, new GenericBucketRequest(str), HttpMethodName.PUT);
        createRequest.addParameter("policy", (String) null);
        byte[] byteArray = ServiceUtils.toByteArray(str2);
        createRequest.addHeader("Content-Length", String.valueOf(byteArray.length));
        createRequest.setContent(new ByteArrayInputStream(byteArray));
        invoke(createRequest, this.voidResponseHandler, str, (String) null);
    }

    public void deleteBucketPolicy(String str) throws AmazonClientException, AmazonServiceException {
        deleteBucketPolicy(new DeleteBucketPolicyRequest(str));
    }

    public BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(getBucketPolicyRequest, "The request object must be specified when getting a bucket policy");
        String bucketName = getBucketPolicyRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specified when getting a bucket policy");
        Request createRequest = createRequest(bucketName, (String) null, getBucketPolicyRequest, HttpMethodName.GET);
        createRequest.addParameter("policy", (String) null);
        BucketPolicy bucketPolicy = new BucketPolicy();
        try {
            bucketPolicy.setPolicyText((String) invoke(createRequest, new S3StringResponseHandler(), bucketName, (String) null));
            return bucketPolicy;
        } catch (AmazonServiceException e) {
            if (e.getErrorCode().equals("NoSuchBucketPolicy")) {
                return bucketPolicy;
            }
            throw e;
        }
    }

    public void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(setBucketPolicyRequest, "The request object must be specified when setting a bucket policy");
        String bucketName = setBucketPolicyRequest.getBucketName();
        String policyText = setBucketPolicyRequest.getPolicyText();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specified when setting a bucket policy");
        ValidationUtils.assertParameterNotNull(policyText, "The policy text must be specified when setting a bucket policy");
        Request createRequest = createRequest(bucketName, (String) null, setBucketPolicyRequest, HttpMethodName.PUT);
        createRequest.addParameter("policy", (String) null);
        byte[] byteArray = ServiceUtils.toByteArray(policyText);
        createRequest.addHeader("Content-Length", String.valueOf(byteArray.length));
        createRequest.setContent(new ByteArrayInputStream(byteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(deleteBucketPolicyRequest, "The request object must be specified when deleting a bucket policy");
        String bucketName = deleteBucketPolicyRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name must be specified when deleting a bucket policy");
        Request createRequest = createRequest(bucketName, (String) null, deleteBucketPolicyRequest, HttpMethodName.DELETE);
        createRequest.addParameter("policy", (String) null);
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public URL generatePresignedUrl(String str, String str2, Date date) throws AmazonClientException {
        return generatePresignedUrl(str, str2, date, HttpMethod.GET);
    }

    public URL generatePresignedUrl(String str, String str2, Date date, HttpMethod httpMethod) throws AmazonClientException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethod);
        generatePresignedUrlRequest.setExpiration(date);
        return generatePresignedUrl(generatePresignedUrlRequest);
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException {
        ValidationUtils.assertParameterNotNull(generatePresignedUrlRequest, "The request parameter must be specified when generating a pre-signed URL");
        String bucketName = generatePresignedUrlRequest.getBucketName();
        String key = generatePresignedUrlRequest.getKey();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when generating a pre-signed URL");
        ValidationUtils.assertParameterNotNull(generatePresignedUrlRequest.getMethod(), "The HTTP method request parameter must be specified when generating a pre-signed URL");
        if (generatePresignedUrlRequest.getExpiration() == null) {
            generatePresignedUrlRequest.setExpiration(new Date(System.currentTimeMillis() + 900000));
        }
        Request createRequest = createRequest(bucketName, key, generatePresignedUrlRequest, HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod().toString()));
        addParameterIfNotNull((Request<?>) createRequest, "versionId", generatePresignedUrlRequest.getVersionId());
        if (generatePresignedUrlRequest.isZeroByteContent()) {
            createRequest.setContent(new ByteArrayInputStream(new byte[0]));
        }
        for (Map.Entry next : generatePresignedUrlRequest.getRequestParameters().entrySet()) {
            createRequest.addParameter((String) next.getKey(), (String) next.getValue());
        }
        if (generatePresignedUrlRequest.getContentType() != null) {
            createRequest.addHeader("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMd5() != null) {
            createRequest.addHeader("Content-MD5", generatePresignedUrlRequest.getContentMd5());
        }
        populateSSE_C(createRequest, generatePresignedUrlRequest.getSSECustomerKey());
        addHeaderIfNotNull(createRequest, Headers.SERVER_SIDE_ENCRYPTION, generatePresignedUrlRequest.getSSEAlgorithm());
        addHeaderIfNotNull(createRequest, Headers.SERVER_SIDE_ENCRYPTION_KMS_KEY_ID, generatePresignedUrlRequest.getKmsCmkId());
        Map<String, String> customQueryParameters = generatePresignedUrlRequest.getCustomQueryParameters();
        if (customQueryParameters != null) {
            for (Map.Entry next2 : customQueryParameters.entrySet()) {
                createRequest.addParameter((String) next2.getKey(), (String) next2.getValue());
            }
        }
        addResponseHeaderParameters(createRequest, generatePresignedUrlRequest.getResponseHeaders());
        Signer createSigner = createSigner(createRequest, bucketName, key);
        if (createSigner instanceof Presigner) {
            ((Presigner) createSigner).presignRequest(createRequest, this.awsCredentialsProvider.getCredentials(), generatePresignedUrlRequest.getExpiration());
        } else {
            presignRequest(createRequest, generatePresignedUrlRequest.getMethod(), bucketName, key, generatePresignedUrlRequest.getExpiration(), (String) null);
        }
        return ServiceUtils.convertRequestToUrl(createRequest, true);
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(abortMultipartUploadRequest, "The request parameter must be specified when aborting a multipart upload");
        ValidationUtils.assertParameterNotNull(abortMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when aborting a multipart upload");
        ValidationUtils.assertParameterNotNull(abortMultipartUploadRequest.getKey(), "The key parameter must be specified when aborting a multipart upload");
        ValidationUtils.assertParameterNotNull(abortMultipartUploadRequest.getUploadId(), "The upload ID parameter must be specified when aborting a multipart upload");
        String bucketName = abortMultipartUploadRequest.getBucketName();
        String key = abortMultipartUploadRequest.getKey();
        Request createRequest = createRequest(bucketName, key, abortMultipartUploadRequest, HttpMethodName.DELETE);
        createRequest.addParameter(RequestParameters.UPLOAD_ID, abortMultipartUploadRequest.getUploadId());
        populateRequesterPaysHeader(createRequest, abortMultipartUploadRequest.isRequesterPays());
        invoke(createRequest, this.voidResponseHandler, bucketName, key);
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(completeMultipartUploadRequest, "The request parameter must be specified when completing a multipart upload");
        String bucketName = completeMultipartUploadRequest.getBucketName();
        String key = completeMultipartUploadRequest.getKey();
        String uploadId = completeMultipartUploadRequest.getUploadId();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when completing a multipart upload");
        ValidationUtils.assertParameterNotNull(key, "The key parameter must be specified when completing a multipart upload");
        ValidationUtils.assertParameterNotNull(uploadId, "The upload ID parameter must be specified when completing a multipart upload");
        ValidationUtils.assertParameterNotNull(completeMultipartUploadRequest.getPartETags(), "The part ETags parameter must be specified when completing a multipart upload");
        int i = 0;
        while (true) {
            Request createRequest = createRequest(bucketName, key, completeMultipartUploadRequest, HttpMethodName.POST);
            createRequest.addParameter(RequestParameters.UPLOAD_ID, uploadId);
            populateRequesterPaysHeader(createRequest, completeMultipartUploadRequest.isRequesterPays());
            byte[] convertToXmlByteArray = RequestXmlFactory.convertToXmlByteArray(completeMultipartUploadRequest.getPartETags());
            createRequest.addHeader("Content-Type", "application/xml");
            createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
            createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
            XmlResponsesSaxParser.CompleteMultipartUploadHandler completeMultipartUploadHandler = (XmlResponsesSaxParser.CompleteMultipartUploadHandler) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.CompleteMultipartUploadResultUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3VersionHeaderHandler(), new S3RequesterChargedHeaderHandler()), bucketName, key);
            if (completeMultipartUploadHandler.getCompleteMultipartUploadResult() != null) {
                return completeMultipartUploadHandler.getCompleteMultipartUploadResult();
            }
            int i2 = i + 1;
            if (shouldRetryCompleteMultipartUpload(completeMultipartUploadRequest, completeMultipartUploadHandler.getAmazonS3Exception(), i)) {
                i = i2;
            } else {
                throw completeMultipartUploadHandler.getAmazonS3Exception();
            }
        }
    }

    private boolean shouldRetryCompleteMultipartUpload(AmazonWebServiceRequest amazonWebServiceRequest, AmazonS3Exception amazonS3Exception, int i) {
        RetryPolicy retryPolicy = this.clientConfiguration.getRetryPolicy();
        if (retryPolicy == null || retryPolicy.getRetryCondition() == null || retryPolicy == PredefinedRetryPolicies.NO_RETRY_POLICY) {
            return false;
        }
        return this.completeMultipartUploadRetryCondition.shouldRetry(amazonWebServiceRequest, amazonS3Exception, i);
    }

    public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(initiateMultipartUploadRequest, "The request parameter must be specified when initiating a multipart upload");
        ValidationUtils.assertParameterNotNull(initiateMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when initiating a multipart upload");
        ValidationUtils.assertParameterNotNull(initiateMultipartUploadRequest.getKey(), "The key parameter must be specified when initiating a multipart upload");
        Request createRequest = createRequest(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), initiateMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_UPLOADS, (String) null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.STORAGE_CLASS, initiateMultipartUploadRequest.getStorageClass().toString());
        }
        if (initiateMultipartUploadRequest.getRedirectLocation() != null) {
            createRequest.addHeader(Headers.REDIRECT_LOCATION, initiateMultipartUploadRequest.getRedirectLocation());
        }
        if (initiateMultipartUploadRequest.getAccessControlList() != null) {
            addAclHeaders(createRequest, initiateMultipartUploadRequest.getAccessControlList());
        } else if (initiateMultipartUploadRequest.getCannedACL() != null) {
            createRequest.addHeader(Headers.S3_CANNED_ACL, initiateMultipartUploadRequest.getCannedACL().toString());
        }
        if (initiateMultipartUploadRequest.objectMetadata != null) {
            populateRequestMetadata(createRequest, initiateMultipartUploadRequest.objectMetadata);
        }
        addHeaderIfNotNull(createRequest, Headers.S3_TAGGING, urlEncodeTags(initiateMultipartUploadRequest.getTagging()));
        populateRequesterPaysHeader(createRequest, initiateMultipartUploadRequest.isRequesterPays());
        populateSSE_C(createRequest, initiateMultipartUploadRequest.getSSECustomerKey());
        populateSSE_KMS(createRequest, initiateMultipartUploadRequest.getSSEAwsKeyManagementParams());
        setZeroContentLength(createRequest);
        createRequest.setContent(new ByteArrayInputStream(new byte[0]));
        return (InitiateMultipartUploadResult) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.InitiateMultipartUploadResultUnmarshaller(), new ServerSideEncryptionHeaderHandler()), initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey());
    }

    public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(listMultipartUploadsRequest, "The request parameter must be specified when listing multipart uploads");
        ValidationUtils.assertParameterNotNull(listMultipartUploadsRequest.getBucketName(), "The bucket name parameter must be specified when listing multipart uploads");
        Request createRequest = createRequest(listMultipartUploadsRequest.getBucketName(), (String) null, listMultipartUploadsRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_UPLOADS, (String) null);
        if (listMultipartUploadsRequest.getKeyMarker() != null) {
            createRequest.addParameter(RequestParameters.KEY_MARKER, listMultipartUploadsRequest.getKeyMarker());
        }
        if (listMultipartUploadsRequest.getMaxUploads() != null) {
            createRequest.addParameter(RequestParameters.MAX_UPLOADS, listMultipartUploadsRequest.getMaxUploads().toString());
        }
        if (listMultipartUploadsRequest.getUploadIdMarker() != null) {
            createRequest.addParameter(RequestParameters.UPLOAD_ID_MARKER, listMultipartUploadsRequest.getUploadIdMarker());
        }
        if (listMultipartUploadsRequest.getDelimiter() != null) {
            createRequest.addParameter(RequestParameters.DELIMITER, listMultipartUploadsRequest.getDelimiter());
        }
        if (listMultipartUploadsRequest.getPrefix() != null) {
            createRequest.addParameter(RequestParameters.PREFIX, listMultipartUploadsRequest.getPrefix());
        }
        if (listMultipartUploadsRequest.getEncodingType() != null) {
            createRequest.addParameter(RequestParameters.ENCODING_TYPE, listMultipartUploadsRequest.getEncodingType());
        }
        return (MultipartUploadListing) invoke(createRequest, new Unmarshallers.ListMultipartUploadsResultUnmarshaller(), listMultipartUploadsRequest.getBucketName(), (String) null);
    }

    public PartListing listParts(ListPartsRequest listPartsRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.assertParameterNotNull(listPartsRequest, "The request parameter must be specified when listing parts");
        ValidationUtils.assertParameterNotNull(listPartsRequest.getBucketName(), "The bucket name parameter must be specified when listing parts");
        ValidationUtils.assertParameterNotNull(listPartsRequest.getKey(), "The key parameter must be specified when listing parts");
        ValidationUtils.assertParameterNotNull(listPartsRequest.getUploadId(), "The upload ID parameter must be specified when listing parts");
        Request createRequest = createRequest(listPartsRequest.getBucketName(), listPartsRequest.getKey(), listPartsRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.UPLOAD_ID, listPartsRequest.getUploadId());
        if (listPartsRequest.getMaxParts() != null) {
            createRequest.addParameter(RequestParameters.MAX_PARTS, listPartsRequest.getMaxParts().toString());
        }
        if (listPartsRequest.getPartNumberMarker() != null) {
            createRequest.addParameter(RequestParameters.PART_NUMBER_MARKER, listPartsRequest.getPartNumberMarker().toString());
        }
        if (listPartsRequest.getEncodingType() != null) {
            createRequest.addParameter(RequestParameters.ENCODING_TYPE, listPartsRequest.getEncodingType());
        }
        populateRequesterPaysHeader(createRequest, listPartsRequest.isRequesterPays());
        return (PartListing) invoke(createRequest, new Unmarshallers.ListPartsResultUnmarshaller(), listPartsRequest.getBucketName(), listPartsRequest.getKey());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.amazonaws.event.ProgressReportingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.amazonaws.event.ProgressReportingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: com.amazonaws.services.s3.internal.InputSubstream} */
    /* JADX WARNING: type inference failed for: r2v17, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.s3.model.UploadPartResult uploadPart(com.amazonaws.services.s3.model.UploadPartRequest r13) throws com.amazonaws.AmazonClientException, com.amazonaws.AmazonServiceException {
        /*
            r12 = this;
            java.lang.String r0 = "The request parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.assertParameterNotNull(r13, r0)
            java.lang.String r0 = r13.getBucketName()
            java.lang.String r1 = r13.getKey()
            java.lang.String r2 = r13.getUploadId()
            int r3 = r13.getPartNumber()
            long r8 = r13.getPartSize()
            java.lang.String r4 = "The bucket name parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.assertParameterNotNull(r0, r4)
            java.lang.String r4 = "The key parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.assertParameterNotNull(r1, r4)
            java.lang.String r4 = "The upload ID parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.assertParameterNotNull(r2, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "The part number parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.assertParameterNotNull(r4, r5)
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            java.lang.String r5 = "The part size parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.assertParameterNotNull(r4, r5)
            com.amazonaws.http.HttpMethodName r4 = com.amazonaws.http.HttpMethodName.PUT
            com.amazonaws.Request r11 = r12.createRequest(r0, r1, r13, r4)
            java.lang.String r4 = "uploadId"
            r11.addParameter(r4, r2)
            java.lang.String r2 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "partNumber"
            r11.addParameter(r4, r2)
            com.amazonaws.services.s3.model.ObjectMetadata r2 = r13.getObjectMetadata()
            if (r2 == 0) goto L_0x0058
            populateRequestMetadata(r11, r2)
        L_0x0058:
            java.lang.String r2 = java.lang.Long.toString(r8)
            java.lang.String r4 = "Content-Length"
            r11.addHeader(r4, r2)
            boolean r2 = r13.isRequesterPays()
            populateRequesterPaysHeader(r11, r2)
            com.amazonaws.services.s3.model.SSECustomerKey r2 = r13.getSSECustomerKey()
            populateSSE_C(r11, r2)
            java.io.InputStream r2 = r13.getInputStream()
            if (r2 == 0) goto L_0x007a
            java.io.InputStream r2 = r13.getInputStream()
            goto L_0x0094
        L_0x007a:
            java.io.File r2 = r13.getFile()
            if (r2 == 0) goto L_0x014a
            com.amazonaws.services.s3.internal.InputSubstream r2 = new com.amazonaws.services.s3.internal.InputSubstream     // Catch:{ FileNotFoundException -> 0x0141 }
            com.amazonaws.services.s3.internal.RepeatableFileInputStream r5 = new com.amazonaws.services.s3.internal.RepeatableFileInputStream     // Catch:{ FileNotFoundException -> 0x0141 }
            java.io.File r4 = r13.getFile()     // Catch:{ FileNotFoundException -> 0x0141 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0141 }
            long r6 = r13.getFileOffset()     // Catch:{ FileNotFoundException -> 0x0141 }
            r10 = 1
            r4 = r2
            r4.<init>(r5, r6, r8, r10)     // Catch:{ FileNotFoundException -> 0x0141 }
        L_0x0094:
            java.lang.String r4 = r13.getMd5Digest()
            if (r4 != 0) goto L_0x00d1
            com.amazonaws.services.s3.S3ClientOptions r4 = r12.clientOptions
            boolean r4 = com.amazonaws.services.s3.internal.ServiceUtils.skipMd5CheckPerRequest(r13, r4)
            if (r4 != 0) goto L_0x00d1
            boolean r4 = r2.markSupported()
            if (r4 == 0) goto L_0x00d1
            java.lang.String r4 = com.amazonaws.util.Md5Utils.md5AsBase64(r2)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r5 = "Content-MD5"
            addHeaderIfNotNull(r11, r5, r4)     // Catch:{ Exception -> 0x00b5 }
            r2.reset()     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00d1
        L_0x00b5:
            r13 = move-exception
            com.amazonaws.AmazonClientException r0 = new com.amazonaws.AmazonClientException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to calculate MD5 hash: "
            r1.append(r2)
            java.lang.String r2 = r13.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r13)
            throw r0
        L_0x00d1:
            com.amazonaws.event.ProgressListener r13 = r13.getGeneralProgressListener()
            com.amazonaws.event.ProgressListenerCallbackExecutor r13 = com.amazonaws.event.ProgressListenerCallbackExecutor.wrapListener(r13)
            if (r13 == 0) goto L_0x00ee
            com.amazonaws.event.ProgressReportingInputStream r4 = new com.amazonaws.event.ProgressReportingInputStream
            r4.<init>(r2, r13)
            r2 = r4
            com.amazonaws.event.ProgressReportingInputStream r2 = (com.amazonaws.event.ProgressReportingInputStream) r2
            int r5 = r12.notificationThreshold
            r2.setNotificationThreshold(r5)
            r2 = 1024(0x400, float:1.435E-42)
            r12.fireProgressEvent(r13, r2)
            r2 = r4
        L_0x00ee:
            r11.setContent(r2)     // Catch:{ AmazonClientException -> 0x0134 }
            com.amazonaws.services.s3.internal.S3MetadataResponseHandler r4 = new com.amazonaws.services.s3.internal.S3MetadataResponseHandler     // Catch:{ AmazonClientException -> 0x0134 }
            r4.<init>()     // Catch:{ AmazonClientException -> 0x0134 }
            java.lang.Object r0 = r12.invoke(r11, r4, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ AmazonClientException -> 0x0134 }
            com.amazonaws.services.s3.model.ObjectMetadata r0 = (com.amazonaws.services.s3.model.ObjectMetadata) r0     // Catch:{ AmazonClientException -> 0x0134 }
            r1 = 2048(0x800, float:2.87E-42)
            r12.fireProgressEvent(r13, r1)     // Catch:{ AmazonClientException -> 0x0134 }
            com.amazonaws.services.s3.model.UploadPartResult r1 = new com.amazonaws.services.s3.model.UploadPartResult     // Catch:{ AmazonClientException -> 0x0134 }
            r1.<init>()     // Catch:{ AmazonClientException -> 0x0134 }
            java.lang.String r4 = r0.getETag()     // Catch:{ AmazonClientException -> 0x0134 }
            r1.setETag(r4)     // Catch:{ AmazonClientException -> 0x0134 }
            r1.setPartNumber(r3)     // Catch:{ AmazonClientException -> 0x0134 }
            java.lang.String r3 = r0.getSSEAlgorithm()     // Catch:{ AmazonClientException -> 0x0134 }
            r1.setSSEAlgorithm(r3)     // Catch:{ AmazonClientException -> 0x0134 }
            java.lang.String r3 = r0.getSSECustomerAlgorithm()     // Catch:{ AmazonClientException -> 0x0134 }
            r1.setSSECustomerAlgorithm(r3)     // Catch:{ AmazonClientException -> 0x0134 }
            java.lang.String r3 = r0.getSSECustomerKeyMd5()     // Catch:{ AmazonClientException -> 0x0134 }
            r1.setSSECustomerKeyMd5(r3)     // Catch:{ AmazonClientException -> 0x0134 }
            boolean r0 = r0.isRequesterCharged()     // Catch:{ AmazonClientException -> 0x0134 }
            r1.setRequesterCharged(r0)     // Catch:{ AmazonClientException -> 0x0134 }
            if (r2 == 0) goto L_0x0131
            r2.close()     // Catch:{ Exception -> 0x0131 }
        L_0x0131:
            return r1
        L_0x0132:
            r13 = move-exception
            goto L_0x013b
        L_0x0134:
            r0 = move-exception
            r1 = 4096(0x1000, float:5.74E-42)
            r12.fireProgressEvent(r13, r1)     // Catch:{ all -> 0x0132 }
            throw r0     // Catch:{ all -> 0x0132 }
        L_0x013b:
            if (r2 == 0) goto L_0x0140
            r2.close()     // Catch:{ Exception -> 0x0140 }
        L_0x0140:
            throw r13
        L_0x0141:
            r13 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The specified file doesn't exist"
            r0.<init>(r1, r13)
            throw r0
        L_0x014a:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "A File or InputStream must be specified when uploading part"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.AmazonS3Client.uploadPart(com.amazonaws.services.s3.model.UploadPartRequest):com.amazonaws.services.s3.model.UploadPartResult");
    }

    public S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return (S3ResponseMetadata) this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public void restoreObject(RestoreObjectRequest restoreObjectRequest) throws AmazonServiceException {
        String bucketName = restoreObjectRequest.getBucketName();
        String key = restoreObjectRequest.getKey();
        String versionId = restoreObjectRequest.getVersionId();
        int expirationInDays = restoreObjectRequest.getExpirationInDays();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when copying a glacier object");
        ValidationUtils.assertParameterNotNull(key, "The key parameter must be specified when copying a glacier object");
        if (expirationInDays != -1) {
            Request createRequest = createRequest(bucketName, key, restoreObjectRequest, HttpMethodName.POST);
            createRequest.addParameter(RequestParameters.X_OSS_RESTORE, (String) null);
            if (versionId != null) {
                createRequest.addParameter("versionId", versionId);
            }
            populateRequesterPaysHeader(createRequest, restoreObjectRequest.isRequesterPays());
            byte[] convertToXmlByteArray = RequestXmlFactory.convertToXmlByteArray(restoreObjectRequest);
            createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
            createRequest.addHeader("Content-Type", "application/xml");
            createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
            try {
                createRequest.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
                invoke(createRequest, this.voidResponseHandler, bucketName, key);
            } catch (Exception e) {
                throw new AmazonClientException("Couldn't compute md5 sum", e);
            }
        } else {
            throw new IllegalArgumentException("The expiration in days parameter must be specified when copying a glacier object");
        }
    }

    public void restoreObject(String str, String str2, int i) throws AmazonServiceException {
        restoreObject(new RestoreObjectRequest(str, str2, i));
    }

    private void fireProgressEvent(ProgressListenerCallbackExecutor progressListenerCallbackExecutor, int i) {
        if (progressListenerCallbackExecutor != null) {
            ProgressEvent progressEvent = new ProgressEvent(0);
            progressEvent.setEventCode(i);
            progressListenerCallbackExecutor.progressChanged(progressEvent);
        }
    }

    private AccessControlList getAcl(String str, String str2, String str3, boolean z, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (amazonWebServiceRequest == null) {
            amazonWebServiceRequest = new GenericBucketRequest(str);
        }
        Request createRequest = createRequest(str, str2, amazonWebServiceRequest, HttpMethodName.GET);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_ACL, (String) null);
        if (str3 != null) {
            createRequest.addParameter("versionId", str3);
        }
        populateRequesterPaysHeader(createRequest, z);
        return (AccessControlList) invoke(createRequest, new Unmarshallers.AccessControlListUnmarshaller(), str, str2);
    }

    private void setAcl(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList, boolean z, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (amazonWebServiceRequest == null) {
            amazonWebServiceRequest = new GenericBucketRequest(str);
        }
        Request createRequest = createRequest(str, str2, amazonWebServiceRequest, HttpMethodName.PUT);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_ACL, (String) null);
        createRequest.addHeader(Headers.S3_CANNED_ACL, cannedAccessControlList.toString());
        if (str3 != null) {
            createRequest.addParameter("versionId", str3);
        }
        populateRequesterPaysHeader(createRequest, z);
        invoke(createRequest, this.voidResponseHandler, str, str2);
    }

    private void setAcl(String str, String str2, String str3, AccessControlList accessControlList, boolean z, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (amazonWebServiceRequest == null) {
            amazonWebServiceRequest = new GenericBucketRequest(str);
        }
        Request createRequest = createRequest(str, str2, amazonWebServiceRequest, HttpMethodName.PUT);
        createRequest.addParameter(RequestParameters.SUBRESOURCE_ACL, (String) null);
        if (str3 != null) {
            createRequest.addParameter("versionId", str3);
        }
        populateRequesterPaysHeader(createRequest, z);
        byte[] convertToXmlByteArray = new AclXmlFactory().convertToXmlByteArray(accessControlList);
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, str, str2);
    }

    /* access modifiers changed from: protected */
    public Signer createSigner(Request<?> request, String str, String str2) {
        URI uri;
        String str3;
        if (this.clientOptions.isAccelerateModeEnabled()) {
            uri = this.endpoint;
        } else {
            uri = request.getEndpoint();
        }
        Signer signerByURI = getSignerByURI(uri);
        if (!isSignerOverridden()) {
            if ((signerByURI instanceof AWSS3V4Signer) && noExplicitRegionProvided(request)) {
                String str4 = this.clientRegion == null ? bucketRegionCache.get(str) : this.clientRegion;
                if (str4 != null) {
                    resolveRequestEndpoint(request, str, str2, RuntimeHttpUtils.toUri(RegionUtils.getRegion(str4).getServiceEndpoint("s3"), this.clientConfiguration));
                    AWSS3V4Signer aWSS3V4Signer = (AWSS3V4Signer) signerByURI;
                    setAWSS3V4SignerWithServiceNameAndRegion(aWSS3V4Signer, str4);
                    return aWSS3V4Signer;
                } else if (request.getOriginalRequest() instanceof GeneratePresignedUrlRequest) {
                    return createSigV2Signer(request, str, str2);
                }
            }
            if (getSignerRegionOverride() == null) {
                str3 = this.clientRegion == null ? bucketRegionCache.get(str) : this.clientRegion;
            } else {
                str3 = getSignerRegionOverride();
            }
            if (str3 != null) {
                AWSS3V4Signer aWSS3V4Signer2 = new AWSS3V4Signer();
                setAWSS3V4SignerWithServiceNameAndRegion(aWSS3V4Signer2, str3);
                return aWSS3V4Signer2;
            }
        }
        return signerByURI instanceof S3Signer ? createSigV2Signer(request, str, str2) : signerByURI;
    }

    private void setAWSS3V4SignerWithServiceNameAndRegion(AWSS3V4Signer aWSS3V4Signer, String str) {
        aWSS3V4Signer.setServiceName(getServiceNameIntern());
        aWSS3V4Signer.setRegionName(str);
    }

    private boolean isSignerOverridden() {
        return (this.clientConfiguration == null || this.clientConfiguration.getSignerOverride() == null) ? false : true;
    }

    private boolean noExplicitRegionProvided(Request<?> request) {
        return isStandardEndpoint(request.getEndpoint()) && getSignerRegion() == null;
    }

    private String getSignerRegion() {
        String signerRegionOverride = getSignerRegionOverride();
        return signerRegionOverride == null ? this.clientRegion : signerRegionOverride;
    }

    private boolean isStandardEndpoint(URI uri) {
        return uri.getHost().endsWith(Constants.S3_HOSTNAME);
    }

    @Deprecated
    private S3Signer createSigV2Signer(Request<?> request, String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(ExpiryDateInput.SEPARATOR);
        if (str != null) {
            str3 = str + ExpiryDateInput.SEPARATOR;
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return new S3Signer(request.getHttpMethod().toString(), sb.toString());
    }

    /* access modifiers changed from: protected */
    public <T> void presignRequest(Request<T> request, HttpMethod httpMethod, String str, String str2, Date date, String str3) {
        String str4;
        beforeRequest(request);
        StringBuilder sb = new StringBuilder();
        sb.append(ExpiryDateInput.SEPARATOR);
        String str5 = "";
        if (str != null) {
            str4 = str + ExpiryDateInput.SEPARATOR;
        } else {
            str4 = str5;
        }
        sb.append(str4);
        if (str2 == null) {
            str2 = str5;
        }
        sb.append(str2);
        if (str3 != null) {
            str5 = "?" + str3;
        }
        sb.append(str5);
        String replaceAll = sb.toString().replaceAll("(?<=/)/", "%2F");
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
            credentials = originalRequest.getRequestCredentials();
        }
        new S3QueryStringSigner(httpMethod.toString(), replaceAll, date).sign(request, credentials);
        if (request.getHeaders().containsKey(Headers.SECURITY_TOKEN)) {
            request.addParameter(Headers.SECURITY_TOKEN, request.getHeaders().get(Headers.SECURITY_TOKEN));
            request.getHeaders().remove(Headers.SECURITY_TOKEN);
        }
    }

    private <T> void beforeRequest(Request<T> request) {
        if (this.requestHandler2s != null) {
            for (RequestHandler2 beforeRequest : this.requestHandler2s) {
                beforeRequest.beforeRequest(request);
            }
        }
    }

    private URI convertToVirtualHostEndpoint(URI uri, String str) {
        try {
            return new URI(uri.getScheme() + "://" + str + "." + uri.getAuthority());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid bucket name: " + str, e);
        }
    }

    protected static void populateRequestMetadata(Request<?> request, ObjectMetadata objectMetadata) {
        Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
        if (rawMetadata.get(Headers.SERVER_SIDE_ENCRYPTION_KMS_KEY_ID) == null || ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION.equals(rawMetadata.get(Headers.SERVER_SIDE_ENCRYPTION))) {
            if (rawMetadata != null) {
                for (Map.Entry next : rawMetadata.entrySet()) {
                    request.addHeader((String) next.getKey(), next.getValue().toString());
                }
            }
            Date httpExpiresDate = objectMetadata.getHttpExpiresDate();
            if (httpExpiresDate != null) {
                request.addHeader("Expires", DateUtils.formatRFC822Date(httpExpiresDate));
            }
            Map<String, String> userMetadata = objectMetadata.getUserMetadata();
            if (userMetadata != null) {
                for (Map.Entry next2 : userMetadata.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    if (!Headers.S3_TAGGING.equals(str)) {
                        request.addHeader(Headers.S3_USER_METADATA_PREFIX + str, str2);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("If you specify a KMS key id for server side encryption, you must also set the SSEAlgorithm to ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION");
    }

    private void populateRequestWithMfaDetails(Request<?> request, MultiFactorAuthentication multiFactorAuthentication) {
        if (multiFactorAuthentication != null) {
            String uri = request.getEndpoint().toString();
            if (uri.startsWith("http://")) {
                request.setEndpoint(URI.create(uri.replace("http://", "https://")));
                log.info("Overriding current endpoint to use HTTPS as required by S3 for requests containing an MFA header");
            }
            request.addHeader(Headers.S3_MFA, multiFactorAuthentication.getDeviceSerialNumber() + " " + multiFactorAuthentication.getToken());
        }
    }

    private void populateRequestWithCopyObjectParameters(Request<? extends AmazonWebServiceRequest> request, CopyObjectRequest copyObjectRequest) {
        String str = ExpiryDateInput.SEPARATOR + copyObjectRequest.getSourceBucketName() + ExpiryDateInput.SEPARATOR + copyObjectRequest.getSourceKey();
        if (copyObjectRequest.getSourceVersionId() != null) {
            str = str + "?versionId=" + copyObjectRequest.getSourceVersionId();
        }
        request.addHeader("x-amz-copy-source", str);
        addDateHeader(request, Headers.COPY_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(request, Headers.COPY_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_NO_MATCH, copyObjectRequest.getNonmatchingETagConstraints());
        if (copyObjectRequest.getAccessControlList() != null) {
            addAclHeaders(request, copyObjectRequest.getAccessControlList());
        } else if (copyObjectRequest.getCannedAccessControlList() != null) {
            request.addHeader(Headers.S3_CANNED_ACL, copyObjectRequest.getCannedAccessControlList().toString());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            request.addHeader(Headers.STORAGE_CLASS, copyObjectRequest.getStorageClass());
        }
        if (copyObjectRequest.getRedirectLocation() != null) {
            request.addHeader(Headers.REDIRECT_LOCATION, copyObjectRequest.getRedirectLocation());
        }
        populateRequesterPaysHeader(request, copyObjectRequest.isRequesterPays());
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            request.addHeader(Headers.METADATA_DIRECTIVE, "REPLACE");
            populateRequestMetadata(request, newObjectMetadata);
        }
        populateSourceSSE_C(request, copyObjectRequest.getSourceSSECustomerKey());
        populateSSE_C(request, copyObjectRequest.getDestinationSSECustomerKey());
    }

    private void populateRequestWithCopyPartParameters(Request<?> request, CopyPartRequest copyPartRequest) {
        String str = ExpiryDateInput.SEPARATOR + copyPartRequest.getSourceBucketName() + ExpiryDateInput.SEPARATOR + copyPartRequest.getSourceKey();
        if (copyPartRequest.getSourceVersionId() != null) {
            str = str + "?versionId=" + copyPartRequest.getSourceVersionId();
        }
        request.addHeader("x-amz-copy-source", str);
        addDateHeader(request, Headers.COPY_SOURCE_IF_MODIFIED_SINCE, copyPartRequest.getModifiedSinceConstraint());
        addDateHeader(request, Headers.COPY_SOURCE_IF_UNMODIFIED_SINCE, copyPartRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_MATCH, copyPartRequest.getMatchingETagConstraints());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_NO_MATCH, copyPartRequest.getNonmatchingETagConstraints());
        if (!(copyPartRequest.getFirstByte() == null || copyPartRequest.getLastByte() == null)) {
            request.addHeader(Headers.COPY_PART_RANGE, "bytes=" + copyPartRequest.getFirstByte() + "-" + copyPartRequest.getLastByte());
        }
        populateSourceSSE_C(request, copyPartRequest.getSourceSSECustomerKey());
        populateSSE_C(request, copyPartRequest.getDestinationSSECustomerKey());
    }

    private static void populateSSE_C(Request<?> request, SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey != null) {
            addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM, sSECustomerKey.getAlgorithm());
            addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY, sSECustomerKey.getKey());
            addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, sSECustomerKey.getMd5());
            if (sSECustomerKey.getKey() != null && sSECustomerKey.getMd5() == null) {
                request.addHeader(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, Md5Utils.md5AsBase64(Base64.decode(sSECustomerKey.getKey())));
            }
        }
    }

    private static void populateSourceSSE_C(Request<?> request, SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey != null) {
            addHeaderIfNotNull(request, Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM, sSECustomerKey.getAlgorithm());
            addHeaderIfNotNull(request, Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY, sSECustomerKey.getKey());
            addHeaderIfNotNull(request, Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, sSECustomerKey.getMd5());
            if (sSECustomerKey.getKey() != null && sSECustomerKey.getMd5() == null) {
                request.addHeader(Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, Md5Utils.md5AsBase64(Base64.decode(sSECustomerKey.getKey())));
            }
        }
    }

    private static void populateSSE_KMS(Request<?> request, SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null) {
            addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION, sSEAwsKeyManagementParams.getEncryption());
            addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_KMS_KEY_ID, sSEAwsKeyManagementParams.getAwsKmsKeyId());
        }
    }

    private void addPartNumberIfNotNull(Request<?> request, Integer num) {
        if (num != null) {
            request.addParameter(RequestParameters.PART_NUMBER, num.toString());
        }
    }

    private static void addHeaderIfNotNull(Request<?> request, String str, String str2) {
        if (str2 != null) {
            request.addHeader(str, str2);
        }
    }

    private static void addParameterIfNotNull(Request<?> request, String str, Integer num) {
        if (num != null) {
            addParameterIfNotNull(request, str, num.toString());
        }
    }

    private static void addParameterIfNotNull(Request<?> request, String str, String str2) {
        if (str2 != null) {
            request.addParameter(str, str2);
        }
    }

    private static void addDateHeader(Request<?> request, String str, Date date) {
        if (date != null) {
            request.addHeader(str, ServiceUtils.formatRfc822Date(date));
        }
    }

    private static void addStringListHeader(Request<?> request, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            request.addHeader(str, ServiceUtils.join(list));
        }
    }

    private static void addResponseHeaderParameters(Request<?> request, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.getCacheControl() != null) {
                request.addParameter("response-cache-control", responseHeaderOverrides.getCacheControl());
            }
            if (responseHeaderOverrides.getContentDisposition() != null) {
                request.addParameter("response-content-disposition", responseHeaderOverrides.getContentDisposition());
            }
            if (responseHeaderOverrides.getContentEncoding() != null) {
                request.addParameter("response-content-encoding", responseHeaderOverrides.getContentEncoding());
            }
            if (responseHeaderOverrides.getContentLanguage() != null) {
                request.addParameter("response-content-language", responseHeaderOverrides.getContentLanguage());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                request.addParameter("response-content-type", responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.getExpires() != null) {
                request.addParameter("response-expires", responseHeaderOverrides.getExpires());
            }
        }
    }

    public String getResourceUrl(String str, String str2) {
        try {
            return getUrl(str, str2).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public URL getUrl(String str, String str2) {
        DefaultRequest defaultRequest = new DefaultRequest(Constants.S3_SERVICE_DISPLAY_NAME);
        resolveRequestEndpoint(defaultRequest, str, str2);
        return ServiceUtils.convertRequestToUrl(defaultRequest);
    }

    public com.amazonaws.services.s3.model.Region getRegion() {
        String authority = this.endpoint.getAuthority();
        if (Constants.S3_HOSTNAME.equals(authority)) {
            return com.amazonaws.services.s3.model.Region.US_Standard;
        }
        Matcher matcher = com.amazonaws.services.s3.model.Region.S3_REGIONAL_ENDPOINT_PATTERN.matcher(authority);
        if (matcher.matches()) {
            return com.amazonaws.services.s3.model.Region.fromValue(matcher.group(1));
        }
        throw new IllegalStateException("S3 client with invalid S3 endpoint configured");
    }

    /* access modifiers changed from: protected */
    public <X extends AmazonWebServiceRequest> Request<X> createRequest(String str, String str2, X x, HttpMethodName httpMethodName) {
        return createRequest(str, str2, x, httpMethodName, (URI) null);
    }

    /* access modifiers changed from: protected */
    public <X extends AmazonWebServiceRequest> Request<X> createRequest(String str, String str2, X x, HttpMethodName httpMethodName, URI uri) {
        DefaultRequest defaultRequest = new DefaultRequest(x, Constants.S3_SERVICE_DISPLAY_NAME);
        if (this.clientOptions.isAccelerateModeEnabled() && !(defaultRequest.getOriginalRequest() instanceof S3AccelerateUnsupported)) {
            if (this.clientOptions.isDualstackEnabled()) {
                uri = RuntimeHttpUtils.toUri(Constants.S3_ACCELERATE_DUALSTACK_HOSTNAME, this.clientConfiguration);
            } else {
                uri = RuntimeHttpUtils.toUri(Constants.S3_ACCELERATE_HOSTNAME, this.clientConfiguration);
            }
        }
        defaultRequest.setHttpMethod(httpMethodName);
        resolveRequestEndpoint(defaultRequest, str, str2, uri);
        return defaultRequest;
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, InputStream> unmarshaller, String str, String str2) {
        return invoke(request, new S3XmlResponseHandler(unmarshaller), str, str2);
    }

    /* access modifiers changed from: protected */
    public final ExecutionContext createExecutionContext(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new S3ExecutionContext(this.requestHandler2s, isRequestMetricsEnabled(amazonWebServiceRequest) || isProfilingEnabled(), this);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.amazonaws.Request, com.amazonaws.Request<Y>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <X, Y extends com.amazonaws.AmazonWebServiceRequest> X invoke(com.amazonaws.Request<Y> r8, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<X>> r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "Content-Type"
            com.amazonaws.AmazonWebServiceRequest r1 = r8.getOriginalRequest()
            com.amazonaws.http.ExecutionContext r2 = r7.createExecutionContext(r1)
            com.amazonaws.util.AWSRequestMetrics r3 = r2.getAwsRequestMetrics()
            r8.setAWSRequestMetrics(r3)
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r3.startEvent(r4)
            r4 = 0
            long r5 = r7.timeOffset     // Catch:{ AmazonS3Exception -> 0x006a }
            r8.setTimeOffset((long) r5)     // Catch:{ AmazonS3Exception -> 0x006a }
            java.util.Map r5 = r8.getHeaders()     // Catch:{ AmazonS3Exception -> 0x006a }
            boolean r5 = r5.containsKey(r0)     // Catch:{ AmazonS3Exception -> 0x006a }
            if (r5 != 0) goto L_0x002b
            java.lang.String r5 = "application/octet-stream"
            r8.addHeader(r0, r5)     // Catch:{ AmazonS3Exception -> 0x006a }
        L_0x002b:
            if (r10 == 0) goto L_0x003e
            com.amazonaws.AmazonWebServiceRequest r0 = r8.getOriginalRequest()     // Catch:{ AmazonS3Exception -> 0x006a }
            boolean r0 = r0 instanceof com.amazonaws.services.s3.model.CreateBucketRequest     // Catch:{ AmazonS3Exception -> 0x006a }
            if (r0 != 0) goto L_0x003e
            boolean r0 = r7.noExplicitRegionProvided(r8)     // Catch:{ AmazonS3Exception -> 0x006a }
            if (r0 == 0) goto L_0x003e
            r7.fetchRegionFromCache(r10)     // Catch:{ AmazonS3Exception -> 0x006a }
        L_0x003e:
            com.amazonaws.auth.AWSCredentialsProvider r0 = r7.awsCredentialsProvider     // Catch:{ AmazonS3Exception -> 0x006a }
            com.amazonaws.auth.AWSCredentials r0 = r0.getCredentials()     // Catch:{ AmazonS3Exception -> 0x006a }
            com.amazonaws.auth.AWSCredentials r5 = r1.getRequestCredentials()     // Catch:{ AmazonS3Exception -> 0x006a }
            if (r5 == 0) goto L_0x004e
            com.amazonaws.auth.AWSCredentials r0 = r1.getRequestCredentials()     // Catch:{ AmazonS3Exception -> 0x006a }
        L_0x004e:
            com.amazonaws.auth.Signer r11 = r7.createSigner(r8, r10, r11)     // Catch:{ AmazonS3Exception -> 0x006a }
            r2.setSigner(r11)     // Catch:{ AmazonS3Exception -> 0x006a }
            r2.setCredentials(r0)     // Catch:{ AmazonS3Exception -> 0x006a }
            com.amazonaws.http.AmazonHttpClient r11 = r7.client     // Catch:{ AmazonS3Exception -> 0x006a }
            com.amazonaws.services.s3.internal.S3ErrorResponseHandler r0 = r7.errorResponseHandler     // Catch:{ AmazonS3Exception -> 0x006a }
            com.amazonaws.Response r4 = r11.execute(r8, r9, r0, r2)     // Catch:{ AmazonS3Exception -> 0x006a }
            java.lang.Object r9 = r4.getAwsResponse()     // Catch:{ AmazonS3Exception -> 0x006a }
            r7.endClientExecution(r3, r8, r4)
            return r9
        L_0x0068:
            r9 = move-exception
            goto L_0x00a5
        L_0x006a:
            r9 = move-exception
            int r11 = r9.getStatusCode()     // Catch:{ all -> 0x0068 }
            r0 = 301(0x12d, float:4.22E-43)
            if (r11 != r0) goto L_0x00a4
            java.util.Map r11 = r9.getAdditionalDetails()     // Catch:{ all -> 0x0068 }
            if (r11 == 0) goto L_0x00a4
            java.util.Map r11 = r9.getAdditionalDetails()     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "x-amz-bucket-region"
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0068 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0068 }
            java.util.Map<java.lang.String, java.lang.String> r0 = bucketRegionCache     // Catch:{ all -> 0x0068 }
            r0.put(r10, r11)     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r10.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "The bucket is in this region: "
            r10.append(r0)     // Catch:{ all -> 0x0068 }
            r10.append(r11)     // Catch:{ all -> 0x0068 }
            java.lang.String r11 = ". Please use this region to retry the request"
            r10.append(r11)     // Catch:{ all -> 0x0068 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0068 }
            r9.setErrorMessage(r10)     // Catch:{ all -> 0x0068 }
        L_0x00a4:
            throw r9     // Catch:{ all -> 0x0068 }
        L_0x00a5:
            r7.endClientExecution(r3, r8, r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.AmazonS3Client.invoke(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, java.lang.String, java.lang.String):java.lang.Object");
    }

    public void enableRequesterPays(String str) {
        setBucketRequestPayment(new SetRequestPaymentConfigurationRequest(str, new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.Requester)));
    }

    public void disableRequesterPays(String str) {
        setBucketRequestPayment(new SetRequestPaymentConfigurationRequest(str, new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.BucketOwner)));
    }

    public boolean isRequesterPaysEnabled(String str) {
        return getBucketRequestPayment(new GetRequestPaymentConfigurationRequest(str)).getPayer() == RequestPaymentConfiguration.Payer.Requester;
    }

    private void setBucketRequestPayment(SetRequestPaymentConfigurationRequest setRequestPaymentConfigurationRequest) {
        String bucketName = setRequestPaymentConfigurationRequest.getBucketName();
        RequestPaymentConfiguration configuration = setRequestPaymentConfigurationRequest.getConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified while setting the Requester Pays.");
        ValidationUtils.assertParameterNotNull(configuration, "The request payment configuration parameter must be specified when setting the Requester Pays.");
        Request createRequest = createRequest(bucketName, (String) null, setRequestPaymentConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("requestPayment", (String) null);
        createRequest.addHeader("Content-Type", "application/xml");
        byte[] convertToXmlByteArray = requestPaymentConfigurationXmlFactory.convertToXmlByteArray(configuration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    private RequestPaymentConfiguration getBucketRequestPayment(GetRequestPaymentConfigurationRequest getRequestPaymentConfigurationRequest) {
        String bucketName = getRequestPaymentConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified while getting the Request Payment Configuration.");
        Request createRequest = createRequest(bucketName, (String) null, getRequestPaymentConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("requestPayment", (String) null);
        createRequest.addHeader("Content-Type", "application/xml");
        return (RequestPaymentConfiguration) invoke(createRequest, new Unmarshallers.RequestPaymentConfigurationUnmarshaller(), bucketName, (String) null);
    }

    private void setZeroContentLength(Request<?> request) {
        request.addHeader("Content-Length", String.valueOf(0));
    }

    private ByteArrayInputStream toByteArray(InputStream inputStream) {
        int i = 262144;
        byte[] bArr = new byte[262144];
        int i2 = 0;
        while (i > 0) {
            try {
                int read = inputStream.read(bArr, i2, i);
                if (read == -1) {
                    break;
                }
                i2 += read;
                i -= read;
            } catch (IOException e) {
                throw new AmazonClientException("Failed to read from inputstream", e);
            }
        }
        if (inputStream.read() == -1) {
            inputStream.close();
            return new ByteArrayInputStream(bArr, 0, i2);
        }
        throw new AmazonClientException("Input stream exceeds 256k buffer.");
    }

    public void setBucketReplicationConfiguration(String str, BucketReplicationConfiguration bucketReplicationConfiguration) throws AmazonServiceException, AmazonClientException {
        setBucketReplicationConfiguration(new SetBucketReplicationConfigurationRequest(str, bucketReplicationConfiguration));
    }

    public void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest setBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(setBucketReplicationConfigurationRequest, "The set bucket replication configuration request object must be specified.");
        String bucketName = setBucketReplicationConfigurationRequest.getBucketName();
        BucketReplicationConfiguration replicationConfiguration = setBucketReplicationConfigurationRequest.getReplicationConfiguration();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting replication configuration.");
        ValidationUtils.assertParameterNotNull(replicationConfiguration, "The replication configuration parameter must be specified when setting replication configuration.");
        Request createRequest = createRequest(bucketName, (String) null, setBucketReplicationConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("replication", (String) null);
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(replicationConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
        } catch (Exception e) {
            throw new AmazonClientException("Not able to compute MD5 of the replication rule configuration. Exception Message : " + e.getMessage(), e);
        }
    }

    public BucketReplicationConfiguration getBucketReplicationConfiguration(String str) throws AmazonServiceException, AmazonClientException {
        return getBucketReplicationConfiguration(new GetBucketReplicationConfigurationRequest(str));
    }

    public BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest getBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(getBucketReplicationConfigurationRequest, "The bucket request parameter must be specified when retrieving replication configuration");
        String bucketName = getBucketReplicationConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket request must specify a bucket name when retrieving replication configuration");
        Request createRequest = createRequest(bucketName, (String) null, getBucketReplicationConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("replication", (String) null);
        return (BucketReplicationConfiguration) invoke(createRequest, new Unmarshallers.BucketReplicationConfigurationUnmarshaller(), bucketName, (String) null);
    }

    public void deleteBucketReplicationConfiguration(String str) throws AmazonServiceException, AmazonClientException {
        deleteBucketReplicationConfiguration(new DeleteBucketReplicationConfigurationRequest(str));
    }

    public void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest deleteBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        String bucketName = deleteBucketReplicationConfigurationRequest.getBucketName();
        ValidationUtils.assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting replication configuration");
        Request createRequest = createRequest(bucketName, (String) null, deleteBucketReplicationConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter("replication", (String) null);
        invoke(createRequest, this.voidResponseHandler, bucketName, (String) null);
    }

    public DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException {
        return deleteBucketMetricsConfiguration(new DeleteBucketMetricsConfigurationRequest(str, str2));
    }

    public DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(deleteBucketMetricsConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(deleteBucketMetricsConfigurationRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(deleteBucketMetricsConfigurationRequest.getId(), "Metrics Id");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, deleteBucketMetricsConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter("metrics", (String) null);
        createRequest.addParameter("id", assertStringNotEmpty2);
        return (DeleteBucketMetricsConfigurationResult) invoke(createRequest, new Unmarshallers.DeleteBucketMetricsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException {
        return getBucketMetricsConfiguration(new GetBucketMetricsConfigurationRequest(str, str2));
    }

    public GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(getBucketMetricsConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(getBucketMetricsConfigurationRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(getBucketMetricsConfigurationRequest.getId(), "Metrics Id");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, getBucketMetricsConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("metrics", (String) null);
        createRequest.addParameter("id", assertStringNotEmpty2);
        return (GetBucketMetricsConfigurationResult) invoke(createRequest, new Unmarshallers.GetBucketMetricsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(String str, MetricsConfiguration metricsConfiguration) throws AmazonServiceException, AmazonClientException {
        return setBucketMetricsConfiguration(new SetBucketMetricsConfigurationRequest(str, metricsConfiguration));
    }

    public SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(SetBucketMetricsConfigurationRequest setBucketMetricsConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        new SetBucketMetricsConfigurationRequest();
        ValidationUtils.assertParameterNotNull(setBucketMetricsConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(setBucketMetricsConfigurationRequest.getBucketName(), "BucketName");
        MetricsConfiguration metricsConfiguration = (MetricsConfiguration) ValidationUtils.assertNotNull(setBucketMetricsConfigurationRequest.getMetricsConfiguration(), "Metrics Configuration");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, setBucketMetricsConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("metrics", (String) null);
        createRequest.addParameter("id", (String) ValidationUtils.assertNotNull(metricsConfiguration.getId(), "Metrics Id"));
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(metricsConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        return (SetBucketMetricsConfigurationResult) invoke(createRequest, new Unmarshallers.SetBucketMetricsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public ListBucketMetricsConfigurationsResult listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(listBucketMetricsConfigurationsRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(listBucketMetricsConfigurationsRequest.getBucketName(), "BucketName");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, listBucketMetricsConfigurationsRequest, HttpMethodName.GET);
        createRequest.addParameter("metrics", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, "continuation-token", listBucketMetricsConfigurationsRequest.getContinuationToken());
        return (ListBucketMetricsConfigurationsResult) invoke(createRequest, new Unmarshallers.ListBucketMetricsConfigurationsUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException {
        return deleteBucketAnalyticsConfiguration(new DeleteBucketAnalyticsConfigurationRequest(str, str2));
    }

    public DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(deleteBucketAnalyticsConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(deleteBucketAnalyticsConfigurationRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(deleteBucketAnalyticsConfigurationRequest.getId(), "Analytics Id");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, deleteBucketAnalyticsConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter("analytics", (String) null);
        createRequest.addParameter("id", assertStringNotEmpty2);
        return (DeleteBucketAnalyticsConfigurationResult) invoke(createRequest, new Unmarshallers.DeleteBucketAnalyticsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException {
        return getBucketAnalyticsConfiguration(new GetBucketAnalyticsConfigurationRequest(str, str2));
    }

    public GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(getBucketAnalyticsConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(getBucketAnalyticsConfigurationRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(getBucketAnalyticsConfigurationRequest.getId(), "Analytics Id");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, getBucketAnalyticsConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("analytics", (String) null);
        createRequest.addParameter("id", assertStringNotEmpty2);
        return (GetBucketAnalyticsConfigurationResult) invoke(createRequest, new Unmarshallers.GetBucketAnalyticsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(String str, AnalyticsConfiguration analyticsConfiguration) throws AmazonServiceException, AmazonClientException {
        return setBucketAnalyticsConfiguration(new SetBucketAnalyticsConfigurationRequest(str, analyticsConfiguration));
    }

    public SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(SetBucketAnalyticsConfigurationRequest setBucketAnalyticsConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(setBucketAnalyticsConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(setBucketAnalyticsConfigurationRequest.getBucketName(), "BucketName");
        AnalyticsConfiguration analyticsConfiguration = (AnalyticsConfiguration) ValidationUtils.assertNotNull(setBucketAnalyticsConfigurationRequest.getAnalyticsConfiguration(), "Analytics Configuration");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, setBucketAnalyticsConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("analytics", (String) null);
        createRequest.addParameter("id", (String) ValidationUtils.assertNotNull(analyticsConfiguration.getId(), "Analytics Id"));
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(analyticsConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        return (SetBucketAnalyticsConfigurationResult) invoke(createRequest, new Unmarshallers.SetBucketAnalyticsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public ListBucketAnalyticsConfigurationsResult listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(listBucketAnalyticsConfigurationsRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(listBucketAnalyticsConfigurationsRequest.getBucketName(), "BucketName");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, listBucketAnalyticsConfigurationsRequest, HttpMethodName.GET);
        createRequest.addParameter("analytics", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, "continuation-token", listBucketAnalyticsConfigurationsRequest.getContinuationToken());
        return (ListBucketAnalyticsConfigurationsResult) invoke(createRequest, new Unmarshallers.ListBucketAnalyticsConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException {
        return deleteBucketInventoryConfiguration(new DeleteBucketInventoryConfigurationRequest(str, str2));
    }

    public DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(deleteBucketInventoryConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(deleteBucketInventoryConfigurationRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(deleteBucketInventoryConfigurationRequest.getId(), "Inventory id");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, deleteBucketInventoryConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter("inventory", (String) null);
        createRequest.addParameter("id", assertStringNotEmpty2);
        return (DeleteBucketInventoryConfigurationResult) invoke(createRequest, new Unmarshallers.DeleteBucketInventoryConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException {
        return getBucketInventoryConfiguration(new GetBucketInventoryConfigurationRequest(str, str2));
    }

    public GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(getBucketInventoryConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(getBucketInventoryConfigurationRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(getBucketInventoryConfigurationRequest.getId(), "Inventory id");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, getBucketInventoryConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("inventory", (String) null);
        createRequest.addParameter("id", assertStringNotEmpty2);
        return (GetBucketInventoryConfigurationResult) invoke(createRequest, new Unmarshallers.GetBucketInventoryConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(String str, InventoryConfiguration inventoryConfiguration) throws AmazonServiceException, AmazonClientException {
        return setBucketInventoryConfiguration(new SetBucketInventoryConfigurationRequest(str, inventoryConfiguration));
    }

    public SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(SetBucketInventoryConfigurationRequest setBucketInventoryConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(setBucketInventoryConfigurationRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(setBucketInventoryConfigurationRequest.getBucketName(), "BucketName");
        InventoryConfiguration inventoryConfiguration = (InventoryConfiguration) ValidationUtils.assertNotNull(setBucketInventoryConfigurationRequest.getInventoryConfiguration(), "InventoryConfiguration");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, setBucketInventoryConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("inventory", (String) null);
        createRequest.addParameter("id", (String) ValidationUtils.assertNotNull(inventoryConfiguration.getId(), "Inventory id"));
        byte[] convertToXmlByteArray = bucketConfigurationXmlFactory.convertToXmlByteArray(inventoryConfiguration);
        createRequest.addHeader("Content-Length", String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader("Content-Type", "application/xml");
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        return (SetBucketInventoryConfigurationResult) invoke(createRequest, new Unmarshallers.SetBucketInventoryConfigurationUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    public ListBucketInventoryConfigurationsResult listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(listBucketInventoryConfigurationsRequest, "The request cannot be null");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(listBucketInventoryConfigurationsRequest.getBucketName(), "BucketName");
        Request createRequest = createRequest(assertStringNotEmpty, (String) null, listBucketInventoryConfigurationsRequest, HttpMethodName.GET);
        createRequest.addParameter("inventory", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, "continuation-token", listBucketInventoryConfigurationsRequest.getContinuationToken());
        return (ListBucketInventoryConfigurationsResult) invoke(createRequest, new Unmarshallers.ListBucketInventoryConfigurationsUnmarshaller(), assertStringNotEmpty, (String) null);
    }

    private String urlEncodeTags(ObjectTagging objectTagging) {
        if (objectTagging == null || objectTagging.getTagSet() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Tag> it = objectTagging.getTagSet().iterator();
        while (it.hasNext()) {
            Tag next = it.next();
            sb.append(S3HttpUtils.urlEncode(next.getKey(), false));
            sb.append('=');
            sb.append(S3HttpUtils.urlEncode(next.getValue(), false));
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    private void setContent(Request<?> request, byte[] bArr, String str, boolean z) {
        request.setContent(new ByteArrayInputStream(bArr));
        request.addHeader("Content-Length", Integer.toString(bArr.length));
        request.addHeader("Content-Type", str);
        if (z) {
            try {
                request.addHeader("Content-MD5", BinaryUtils.toBase64(Md5Utils.computeMD5Hash(bArr)));
            } catch (Exception e) {
                throw new AmazonClientException("Couldn't compute md5 sum", e);
            }
        }
    }

    protected static void populateRequesterPaysHeader(Request<?> request, boolean z) {
        if (z) {
            request.addHeader(Headers.REQUESTER_PAYS_HEADER, Constants.REQUESTER_PAYS);
        }
    }

    public String getObjectAsString(String str, String str2) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(str, "Bucket name must be provided");
        ValidationUtils.assertParameterNotNull(str2, "Object key must be provided");
        try {
            return IOUtils.toString(getObject(str, str2).getObjectContent());
        } catch (IOException unused) {
            throw new AmazonClientException("Error streaming content from S3 during download");
        }
    }

    public GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest) {
        ValidationUtils.assertParameterNotNull(getObjectTaggingRequest, "The request parameter must be specified when getting the object tags");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(getObjectTaggingRequest.getBucketName(), "BucketName");
        String str = (String) ValidationUtils.assertNotNull(getObjectTaggingRequest.getKey(), "Key");
        Request createRequest = createRequest(assertStringNotEmpty, str, getObjectTaggingRequest, HttpMethodName.GET);
        createRequest.addParameter("tagging", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, "versionId", getObjectTaggingRequest.getVersionId());
        return (GetObjectTaggingResult) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.GetObjectTaggingResponseUnmarshaller(), new GetObjectTaggingResponseHeaderHandler()), assertStringNotEmpty, str);
    }

    public SetObjectTaggingResult setObjectTagging(SetObjectTaggingRequest setObjectTaggingRequest) {
        ValidationUtils.assertParameterNotNull(setObjectTaggingRequest, "The request parameter must be specified setting the object tags");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(setObjectTaggingRequest.getBucketName(), "BucketName");
        String str = (String) ValidationUtils.assertNotNull(setObjectTaggingRequest.getKey(), "Key");
        Request createRequest = createRequest(assertStringNotEmpty, str, setObjectTaggingRequest, HttpMethodName.PUT);
        createRequest.addParameter("tagging", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, "versionId", setObjectTaggingRequest.getVersionId());
        setContent(createRequest, new ObjectTaggingXmlFactory().convertToXmlByteArray((ObjectTagging) ValidationUtils.assertNotNull(setObjectTaggingRequest.getTagging(), "ObjectTagging")), "application/xml", true);
        return (SetObjectTaggingResult) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.SetObjectTaggingResponseUnmarshaller(), new SetObjectTaggingResponseHeaderHandler()), assertStringNotEmpty, str);
    }

    public DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest) {
        ValidationUtils.assertParameterNotNull(deleteObjectTaggingRequest, "The request parameter must be specified when delete the object tags");
        String assertStringNotEmpty = ValidationUtils.assertStringNotEmpty(deleteObjectTaggingRequest.getBucketName(), "BucketName");
        String assertStringNotEmpty2 = ValidationUtils.assertStringNotEmpty(deleteObjectTaggingRequest.getKey(), "Key");
        Request createRequest = createRequest(assertStringNotEmpty, assertStringNotEmpty2, deleteObjectTaggingRequest, HttpMethodName.DELETE);
        createRequest.addParameter("tagging", (String) null);
        addParameterIfNotNull((Request<?>) createRequest, "versionId", deleteObjectTaggingRequest.getVersionId());
        return (DeleteObjectTaggingResult) invoke(createRequest, new ResponseHeaderHandlerChain(new Unmarshallers.DeleteObjectTaggingResponseUnmarshaller(), new DeleteObjectTaggingHeaderHandler()), assertStringNotEmpty, assertStringNotEmpty2);
    }

    public PutObjectResult putObject(String str, String str2, String str3) throws AmazonServiceException, AmazonClientException {
        ValidationUtils.assertParameterNotNull(str, "Bucket name must be provided");
        ValidationUtils.assertParameterNotNull(str2, "Object key must be provided");
        ValidationUtils.assertParameterNotNull(str3, "String content must be provided");
        byte[] bytes = str3.getBytes(StringUtils.UTF8);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("text/plain");
        objectMetadata.setContentLength((long) bytes.length);
        return putObject(new PutObjectRequest(str, str2, byteArrayInputStream, objectMetadata));
    }

    public String getRegionName() {
        String authority = this.endpoint.getAuthority();
        if (Constants.S3_HOSTNAME.equals(authority)) {
            return "us-east-1";
        }
        Matcher matcher = com.amazonaws.services.s3.model.Region.S3_REGIONAL_ENDPOINT_PATTERN.matcher(authority);
        try {
            matcher.matches();
            return RegionUtils.getRegion(matcher.group(1)).getName();
        } catch (Exception e) {
            throw new IllegalStateException("No valid region has been specified. Unable to return region name", e);
        }
    }

    private String fetchRegionFromCache(String str) {
        Map<String, String> map = bucketRegionCache;
        String str2 = map.get(str);
        if (str2 == null) {
            if (log.isDebugEnabled()) {
                Log log2 = log;
                log2.debug("Bucket region cache doesn't have an entry for " + str + ". Trying to get bucket region from Amazon S3.");
            }
            str2 = getBucketRegionViaHeadRequest(str);
            if (str2 != null) {
                map.put(str, str2);
            }
        }
        if (log.isDebugEnabled()) {
            Log log3 = log;
            log3.debug("Region for " + str + " is " + str2);
        }
        return str2;
    }

    private String getBucketRegionViaHeadRequest(String str) {
        String str2 = null;
        try {
            str2 = ((HeadBucketResult) invoke(createRequest(str, (String) null, new HeadBucketRequest(str), HttpMethodName.HEAD, new URI("https://s3-us-west-1.amazonaws.com")), new HeadBucketResultHandler(), str, (String) null)).getBucketRegion();
        } catch (AmazonS3Exception e) {
            if (e.getAdditionalDetails() != null) {
                str2 = e.getAdditionalDetails().get(Headers.S3_BUCKET_REGION);
            }
        } catch (URISyntaxException unused) {
            log.warn("Error while creating URI");
        }
        if (str2 == null && log.isDebugEnabled()) {
            Log log2 = log;
            log2.debug("Not able to derive region of the " + str + " from the HEAD Bucket requests.");
        }
        return str2;
    }

    public void resolveRequestEndpoint(Request<?> request, String str, String str2) {
        resolveRequestEndpoint(request, str, str2, (URI) null);
    }

    public void resolveRequestEndpoint(Request<?> request, String str, String str2, URI uri) {
        if (uri == null) {
            uri = this.endpoint;
        }
        if (shouldUseVirtualAddressing(uri, str)) {
            Log log2 = log;
            log2.debug("Using virtual style addressing. Endpoint = " + uri);
            request.setEndpoint(convertToVirtualHostEndpoint(uri, str));
            request.setResourcePath(getHostStyleResourcePath(str2));
        } else {
            Log log3 = log;
            log3.debug("Using path style addressing. Endpoint = " + uri);
            request.setEndpoint(uri);
            if (str != null) {
                request.setResourcePath(getPathStyleResourcePath(str, str2));
            }
        }
        Log log4 = log;
        log4.debug("Key: " + str2 + "; Request: " + request);
    }

    private boolean shouldUseVirtualAddressing(URI uri, String str) {
        return !this.clientOptions.isPathStyleAccess() && BucketNameUtils.isDNSBucketName(str) && !isValidIpV4Address(uri.getHost());
    }

    private String getHostStyleResourcePath(String str) {
        if (str == null || !str.startsWith(ExpiryDateInput.SEPARATOR)) {
            return str;
        }
        return ExpiryDateInput.SEPARATOR + str;
    }

    private String getPathStyleResourcePath(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ExpiryDateInput.SEPARATOR);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    static boolean isValidIpV4Address(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt >= 0 && parseInt <= 255) {
                    i++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }
}
