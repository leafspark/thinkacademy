package com.amazonaws.services.s3;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.FileDeletionEvent;
import com.amazonaws.services.s3.internal.PartCreationEvent;
import com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UploadObjectObserver {
    private ExecutorService es;
    private final List<Future<UploadPartResult>> futures = new ArrayList();
    private UploadObjectRequest req;
    private AmazonS3 s3;
    private S3DirectSpi s3direct;
    private String uploadId;

    public UploadObjectObserver init(UploadObjectRequest uploadObjectRequest, S3DirectSpi s3DirectSpi, AmazonS3 amazonS3, ExecutorService executorService) {
        this.req = uploadObjectRequest;
        this.s3direct = s3DirectSpi;
        this.s3 = amazonS3;
        this.es = executorService;
        return this;
    }

    /* access modifiers changed from: protected */
    public InitiateMultipartUploadRequest newInitiateMultipartUploadRequest(UploadObjectRequest uploadObjectRequest) {
        return (InitiateMultipartUploadRequest) new EncryptedInitiateMultipartUploadRequest(uploadObjectRequest.getBucketName(), uploadObjectRequest.getKey(), uploadObjectRequest.getMetadata()).withMaterialsDescription(uploadObjectRequest.getMaterialsDescription()).withRedirectLocation(uploadObjectRequest.getRedirectLocation()).withSSEAwsKeyManagementParams(uploadObjectRequest.getSSEAwsKeyManagementParams()).withSSECustomerKey(uploadObjectRequest.getSSECustomerKey()).withStorageClass(uploadObjectRequest.getStorageClass()).withAccessControlList(uploadObjectRequest.getAccessControlList()).withCannedACL(uploadObjectRequest.getCannedAcl()).withGeneralProgressListener(uploadObjectRequest.getGeneralProgressListener()).withRequestMetricCollector(uploadObjectRequest.getRequestMetricCollector());
    }

    public String onUploadInitiation(UploadObjectRequest uploadObjectRequest) {
        String uploadId2 = this.s3.initiateMultipartUpload(newInitiateMultipartUploadRequest(uploadObjectRequest)).getUploadId();
        this.uploadId = uploadId2;
        return uploadId2;
    }

    public void onPartCreate(PartCreationEvent partCreationEvent) {
        final File part = partCreationEvent.getPart();
        final UploadPartRequest newUploadPartRequest = newUploadPartRequest(partCreationEvent, part);
        final OnFileDelete fileDeleteObserver = partCreationEvent.getFileDeleteObserver();
        appendUserAgent(newUploadPartRequest, AmazonS3EncryptionClient.USER_AGENT);
        this.futures.add(this.es.submit(new Callable<UploadPartResult>() {
            public UploadPartResult call() {
                try {
                    UploadPartResult uploadPart = UploadObjectObserver.this.uploadPart(newUploadPartRequest);
                    if (!part.delete()) {
                        Log log = LogFactory.getLog(getClass());
                        log.debug("Ignoring failure to delete file " + part + " which has already been uploaded");
                    } else {
                        OnFileDelete onFileDelete = fileDeleteObserver;
                        if (onFileDelete != null) {
                            onFileDelete.onFileDelete((FileDeletionEvent) null);
                        }
                    }
                    return uploadPart;
                } catch (Throwable th) {
                    if (part.delete()) {
                        OnFileDelete onFileDelete2 = fileDeleteObserver;
                        if (onFileDelete2 != null) {
                            onFileDelete2.onFileDelete((FileDeletionEvent) null);
                        }
                    } else {
                        Log log2 = LogFactory.getLog(getClass());
                        log2.debug("Ignoring failure to delete file " + part + " which has already been uploaded");
                    }
                    throw th;
                }
            }
        }));
    }

    public CompleteMultipartUploadResult onCompletion(List<PartETag> list) {
        return this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.req.getBucketName(), this.req.getKey(), this.uploadId, list));
    }

    public void onAbort() {
        for (Future<UploadPartResult> cancel : getFutures()) {
            cancel.cancel(true);
        }
        if (this.uploadId != null) {
            try {
                this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(this.req.getBucketName(), this.req.getKey(), this.uploadId));
            } catch (Exception e) {
                Log log = LogFactory.getLog(getClass());
                log.debug("Failed to abort multi-part upload: " + this.uploadId, e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public UploadPartRequest newUploadPartRequest(PartCreationEvent partCreationEvent, File file) {
        return new UploadPartRequest().withBucketName(this.req.getBucketName()).withFile(file).withKey(this.req.getKey()).withPartNumber(partCreationEvent.getPartNumber()).withPartSize(file.length()).withLastPart(partCreationEvent.isLastPart()).withUploadId(this.uploadId).withObjectMetadata(this.req.getUploadPartMetadata());
    }

    /* access modifiers changed from: protected */
    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) {
        return this.s3direct.uploadPart(uploadPartRequest);
    }

    /* access modifiers changed from: protected */
    public <X extends AmazonWebServiceRequest> X appendUserAgent(X x, String str) {
        x.getRequestClientOptions().appendUserAgent(str);
        return x;
    }

    public List<Future<UploadPartResult>> getFutures() {
        return this.futures;
    }

    /* access modifiers changed from: protected */
    public UploadObjectRequest getRequest() {
        return this.req;
    }

    /* access modifiers changed from: protected */
    public String getUploadId() {
        return this.uploadId;
    }

    /* access modifiers changed from: protected */
    public S3DirectSpi getS3DirectSpi() {
        return this.s3direct;
    }

    /* access modifiers changed from: protected */
    public AmazonS3 getAmazonS3() {
        return this.s3;
    }

    /* access modifiers changed from: protected */
    public ExecutorService getExecutorService() {
        return this.es;
    }
}
