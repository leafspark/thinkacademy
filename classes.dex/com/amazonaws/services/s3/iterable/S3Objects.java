package com.amazonaws.services.s3.iterable;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.Iterator;

public final class S3Objects implements Iterable<S3ObjectSummary> {
    private Integer batchSize = null;
    private String bucketName;
    private String prefix = null;
    private AmazonS3 s3;

    private S3Objects(AmazonS3 amazonS3, String str) {
        this.s3 = amazonS3;
        this.bucketName = str;
    }

    public static S3Objects inBucket(AmazonS3 amazonS3, String str) {
        return new S3Objects(amazonS3, str);
    }

    public static S3Objects withPrefix(AmazonS3 amazonS3, String str, String str2) {
        S3Objects s3Objects = new S3Objects(amazonS3, str);
        s3Objects.prefix = str2;
        return s3Objects;
    }

    public S3Objects withBatchSize(int i) {
        this.batchSize = Integer.valueOf(i);
        return this;
    }

    public Integer getBatchSize() {
        return this.batchSize;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public AmazonS3 getS3() {
        return this.s3;
    }

    private class S3ObjectIterator implements Iterator<S3ObjectSummary> {
        private Iterator<S3ObjectSummary> currentIterator;
        private ObjectListing currentListing;

        private S3ObjectIterator() {
            this.currentListing = null;
            this.currentIterator = null;
        }

        public boolean hasNext() {
            prepareCurrentListing();
            return this.currentIterator.hasNext();
        }

        public S3ObjectSummary next() {
            prepareCurrentListing();
            return this.currentIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void prepareCurrentListing() {
            while (true) {
                if (this.currentListing == null || (!this.currentIterator.hasNext() && this.currentListing.isTruncated())) {
                    if (this.currentListing == null) {
                        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
                        listObjectsRequest.setBucketName(S3Objects.this.getBucketName());
                        listObjectsRequest.setPrefix(S3Objects.this.getPrefix());
                        listObjectsRequest.setMaxKeys(S3Objects.this.getBatchSize());
                        this.currentListing = S3Objects.this.getS3().listObjects(listObjectsRequest);
                    } else {
                        this.currentListing = S3Objects.this.getS3().listNextBatchOfObjects(this.currentListing);
                    }
                    this.currentIterator = this.currentListing.getObjectSummaries().iterator();
                } else {
                    return;
                }
            }
        }
    }

    public Iterator<S3ObjectSummary> iterator() {
        return new S3ObjectIterator();
    }
}
