package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.List;

public class Unmarshallers {

    public static final class InputStreamUnmarshaller implements Unmarshaller<InputStream, InputStream> {
        public InputStream unmarshall(InputStream inputStream) throws Exception {
            return inputStream;
        }
    }

    public static final class ListBucketsUnmarshaller implements Unmarshaller<List<Bucket>, InputStream> {
        public List<Bucket> unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListMyBucketsResponse(inputStream).getBuckets();
        }
    }

    public static final class ListBucketsOwnerUnmarshaller implements Unmarshaller<Owner, InputStream> {
        public Owner unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListMyBucketsResponse(inputStream).getOwner();
        }
    }

    public static final class ListObjectsUnmarshaller implements Unmarshaller<ObjectListing, InputStream> {
        private final boolean shouldSDKDecodeResponse;

        public ListObjectsUnmarshaller(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public ObjectListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListBucketObjectsResponse(inputStream, this.shouldSDKDecodeResponse).getObjectListing();
        }
    }

    public static final class ListObjectsV2Unmarshaller implements Unmarshaller<ListObjectsV2Result, InputStream> {
        private final boolean shouldSDKDecodeResponse;

        public ListObjectsV2Unmarshaller(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public ListObjectsV2Result unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListObjectsV2Response(inputStream, this.shouldSDKDecodeResponse).getResult();
        }
    }

    public static final class VersionListUnmarshaller implements Unmarshaller<VersionListing, InputStream> {
        private final boolean shouldSDKDecodeResponse;

        public VersionListUnmarshaller(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public VersionListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListVersionsResponse(inputStream, this.shouldSDKDecodeResponse).getListing();
        }
    }

    public static final class AccessControlListUnmarshaller implements Unmarshaller<AccessControlList, InputStream> {
        public AccessControlList unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseAccessControlListResponse(inputStream).getAccessControlList();
        }
    }

    public static final class BucketLoggingConfigurationnmarshaller implements Unmarshaller<BucketLoggingConfiguration, InputStream> {
        public BucketLoggingConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseLoggingStatusResponse(inputStream).getBucketLoggingConfiguration();
        }
    }

    public static final class BucketLocationUnmarshaller implements Unmarshaller<String, InputStream> {
        public String unmarshall(InputStream inputStream) throws Exception {
            String parseBucketLocationResponse = new XmlResponsesSaxParser().parseBucketLocationResponse(inputStream);
            return parseBucketLocationResponse == null ? "US" : parseBucketLocationResponse;
        }
    }

    public static final class BucketVersioningConfigurationUnmarshaller implements Unmarshaller<BucketVersioningConfiguration, InputStream> {
        public BucketVersioningConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseVersioningConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketWebsiteConfigurationUnmarshaller implements Unmarshaller<BucketWebsiteConfiguration, InputStream> {
        public BucketWebsiteConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseWebsiteConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketReplicationConfigurationUnmarshaller implements Unmarshaller<BucketReplicationConfiguration, InputStream> {
        public BucketReplicationConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseReplicationConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketTaggingConfigurationUnmarshaller implements Unmarshaller<BucketTaggingConfiguration, InputStream> {
        public BucketTaggingConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseTaggingConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketAccelerateConfigurationUnmarshaller implements Unmarshaller<BucketAccelerateConfiguration, InputStream> {
        public BucketAccelerateConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseAccelerateConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class CopyObjectUnmarshaller implements Unmarshaller<XmlResponsesSaxParser.CopyObjectResultHandler, InputStream> {
        public XmlResponsesSaxParser.CopyObjectResultHandler unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseCopyObjectResponse(inputStream);
        }
    }

    public static final class CompleteMultipartUploadResultUnmarshaller implements Unmarshaller<XmlResponsesSaxParser.CompleteMultipartUploadHandler, InputStream> {
        public XmlResponsesSaxParser.CompleteMultipartUploadHandler unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseCompleteMultipartUploadResponse(inputStream);
        }
    }

    public static final class InitiateMultipartUploadResultUnmarshaller implements Unmarshaller<InitiateMultipartUploadResult, InputStream> {
        public InitiateMultipartUploadResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseInitiateMultipartUploadResponse(inputStream).getInitiateMultipartUploadResult();
        }
    }

    public static final class ListMultipartUploadsResultUnmarshaller implements Unmarshaller<MultipartUploadListing, InputStream> {
        public MultipartUploadListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListMultipartUploadsResponse(inputStream).getListMultipartUploadsResult();
        }
    }

    public static final class ListPartsResultUnmarshaller implements Unmarshaller<PartListing, InputStream> {
        public PartListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListPartsResponse(inputStream).getListPartsResult();
        }
    }

    public static final class DeleteObjectsResultUnmarshaller implements Unmarshaller<DeleteObjectsResponse, InputStream> {
        public DeleteObjectsResponse unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseDeletedObjectsResult(inputStream).getDeleteObjectResult();
        }
    }

    public static final class BucketLifecycleConfigurationUnmarshaller implements Unmarshaller<BucketLifecycleConfiguration, InputStream> {
        public BucketLifecycleConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseBucketLifecycleConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketCrossOriginConfigurationUnmarshaller implements Unmarshaller<BucketCrossOriginConfiguration, InputStream> {
        public BucketCrossOriginConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseBucketCrossOriginConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class RequestPaymentConfigurationUnmarshaller implements Unmarshaller<RequestPaymentConfiguration, InputStream> {
        public RequestPaymentConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseRequestPaymentConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class GetObjectTaggingResponseUnmarshaller implements Unmarshaller<GetObjectTaggingResult, InputStream> {
        public GetObjectTaggingResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseObjectTaggingResponse(inputStream).getResult();
        }
    }

    public static final class SetObjectTaggingResponseUnmarshaller implements Unmarshaller<SetObjectTaggingResult, InputStream> {
        public SetObjectTaggingResult unmarshall(InputStream inputStream) throws Exception {
            return new SetObjectTaggingResult();
        }
    }

    public static final class DeleteObjectTaggingResponseUnmarshaller implements Unmarshaller<DeleteObjectTaggingResult, InputStream> {
        public DeleteObjectTaggingResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteObjectTaggingResult();
        }
    }

    public static final class GetBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<GetBucketAnalyticsConfigurationResult, InputStream> {
        public GetBucketAnalyticsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseGetBucketAnalyticsConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class ListBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<ListBucketAnalyticsConfigurationsResult, InputStream> {
        public ListBucketAnalyticsConfigurationsResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListBucketAnalyticsConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class DeleteBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<DeleteBucketAnalyticsConfigurationResult, InputStream> {
        public DeleteBucketAnalyticsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteBucketAnalyticsConfigurationResult();
        }
    }

    public static final class SetBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<SetBucketAnalyticsConfigurationResult, InputStream> {
        public SetBucketAnalyticsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new SetBucketAnalyticsConfigurationResult();
        }
    }

    public static final class GetBucketMetricsConfigurationUnmarshaller implements Unmarshaller<GetBucketMetricsConfigurationResult, InputStream> {
        public GetBucketMetricsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseGetBucketMetricsConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class ListBucketMetricsConfigurationsUnmarshaller implements Unmarshaller<ListBucketMetricsConfigurationsResult, InputStream> {
        public ListBucketMetricsConfigurationsResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListBucketMetricsConfigurationsResponse(inputStream).getResult();
        }
    }

    public static final class DeleteBucketMetricsConfigurationUnmarshaller implements Unmarshaller<DeleteBucketMetricsConfigurationResult, InputStream> {
        public DeleteBucketMetricsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteBucketMetricsConfigurationResult();
        }
    }

    public static final class SetBucketMetricsConfigurationUnmarshaller implements Unmarshaller<SetBucketMetricsConfigurationResult, InputStream> {
        public SetBucketMetricsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new SetBucketMetricsConfigurationResult();
        }
    }

    public static final class GetBucketInventoryConfigurationUnmarshaller implements Unmarshaller<GetBucketInventoryConfigurationResult, InputStream> {
        public GetBucketInventoryConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseGetBucketInventoryConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class ListBucketInventoryConfigurationsUnmarshaller implements Unmarshaller<ListBucketInventoryConfigurationsResult, InputStream> {
        public ListBucketInventoryConfigurationsResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseBucketListInventoryConfigurationsResponse(inputStream).getResult();
        }
    }

    public static final class DeleteBucketInventoryConfigurationUnmarshaller implements Unmarshaller<DeleteBucketInventoryConfigurationResult, InputStream> {
        public DeleteBucketInventoryConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteBucketInventoryConfigurationResult();
        }
    }

    public static final class SetBucketInventoryConfigurationUnmarshaller implements Unmarshaller<SetBucketInventoryConfigurationResult, InputStream> {
        public SetBucketInventoryConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new SetBucketInventoryConfigurationResult();
        }
    }
}
