package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.DateUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractS3ResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {
    private static final Set<String> IGNORED_HEADERS;
    private static final Log log = LogFactory.getLog((Class<?>) S3MetadataResponseHandler.class);

    public boolean needsConnectionLeftOpen() {
        return false;
    }

    static {
        HashSet hashSet = new HashSet();
        IGNORED_HEADERS = hashSet;
        hashSet.add("Date");
        hashSet.add(Headers.SERVER);
        hashSet.add(Headers.REQUEST_ID);
        hashSet.add(Headers.EXTENDED_REQUEST_ID);
        hashSet.add(Headers.CLOUD_FRONT_ID);
        hashSet.add(Headers.CONNECTION);
    }

    /* access modifiers changed from: protected */
    public AmazonWebServiceResponse<T> parseResponseMetadata(HttpResponse httpResponse) {
        AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse<>();
        HashMap hashMap = new HashMap();
        hashMap.put(ResponseMetadata.AWS_REQUEST_ID, httpResponse.getHeaders().get(Headers.REQUEST_ID));
        hashMap.put(S3ResponseMetadata.HOST_ID, httpResponse.getHeaders().get(Headers.EXTENDED_REQUEST_ID));
        hashMap.put(S3ResponseMetadata.CLOUD_FRONT_ID, httpResponse.getHeaders().get(Headers.CLOUD_FRONT_ID));
        amazonWebServiceResponse.setResponseMetadata(new S3ResponseMetadata((Map<String, String>) hashMap));
        return amazonWebServiceResponse;
    }

    /* access modifiers changed from: protected */
    public void populateObjectMetadata(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        for (Map.Entry next : httpResponse.getHeaders().entrySet()) {
            String str = (String) next.getKey();
            if (str.startsWith(Headers.S3_USER_METADATA_PREFIX)) {
                objectMetadata.addUserMetadata(str.substring(11), (String) next.getValue());
            } else if (IGNORED_HEADERS.contains(str)) {
                log.debug(String.format("%s is ignored.", new Object[]{str}));
            } else if (str.equalsIgnoreCase("Last-Modified")) {
                try {
                    objectMetadata.setHeader(str, ServiceUtils.parseRfc822Date((String) next.getValue()));
                } catch (Exception e) {
                    Log log2 = log;
                    log2.warn("Unable to parse last modified date: " + ((String) next.getValue()), e);
                }
            } else if (str.equalsIgnoreCase("Content-Length")) {
                try {
                    objectMetadata.setHeader(str, Long.valueOf(Long.parseLong((String) next.getValue())));
                } catch (NumberFormatException e2) {
                    Log log3 = log;
                    log3.warn("Unable to parse content length: " + ((String) next.getValue()), e2);
                }
            } else if (str.equalsIgnoreCase("ETag")) {
                objectMetadata.setHeader(str, ServiceUtils.removeQuotes((String) next.getValue()));
            } else if (str.equalsIgnoreCase("Expires")) {
                try {
                    objectMetadata.setHttpExpiresDate(DateUtils.parseRFC822Date((String) next.getValue()));
                } catch (Exception e3) {
                    Log log4 = log;
                    log4.warn("Unable to parse http expiration date: " + ((String) next.getValue()), e3);
                }
            } else if (str.equalsIgnoreCase(Headers.EXPIRATION)) {
                new ObjectExpirationHeaderHandler().handle(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase(Headers.RESTORE)) {
                new ObjectRestoreHeaderHandler().handle(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase(Headers.REQUESTER_CHARGED_HEADER)) {
                new S3RequesterChargedHeaderHandler().handle(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase(Headers.S3_PARTS_COUNT)) {
                try {
                    objectMetadata.setHeader(str, Integer.valueOf(Integer.parseInt((String) next.getValue())));
                } catch (NumberFormatException e4) {
                    throw new AmazonClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + e4.getMessage(), e4);
                }
            } else {
                objectMetadata.setHeader(str, next.getValue());
            }
        }
    }
}
