package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AwsChunkedEncodingInputStream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.BinaryUtils;
import java.io.IOException;
import java.io.InputStream;

public class AWSS3V4Signer extends AWS4Signer {
    private static final String CONTENT_SHA_256 = "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
    private static final int DEFAULT_BYTE_LENGTH = 4096;

    /* access modifiers changed from: protected */
    public String calculateContentHashPresign(Request<?> request) {
        return "UNSIGNED-PAYLOAD";
    }

    public AWSS3V4Signer() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void processRequestPayload(Request<?> request, AWS4Signer.HeaderSigningResult headerSigningResult) {
        if (useChunkEncoding(request)) {
            request.setContent(new AwsChunkedEncodingInputStream(request.getContent(), headerSigningResult.getKSigning(), headerSigningResult.getDateTime(), headerSigningResult.getScope(), BinaryUtils.toHex(headerSigningResult.getSignature()), this));
        }
    }

    /* access modifiers changed from: protected */
    public String calculateContentHash(Request<?> request) {
        long j;
        request.addHeader("x-amz-content-sha256", "required");
        if (!useChunkEncoding(request)) {
            return super.calculateContentHash(request);
        }
        String str = request.getHeaders().get("Content-Length");
        if (str != null) {
            j = Long.parseLong(str);
        } else {
            try {
                j = getContentLength(request);
            } catch (IOException e) {
                throw new AmazonClientException("Cannot get the content-lenght of the request content.", e);
            }
        }
        request.addHeader("x-amz-decoded-content-length", Long.toString(j));
        request.addHeader("Content-Length", Long.toString(AwsChunkedEncodingInputStream.calculateStreamContentLength(j)));
        return CONTENT_SHA_256;
    }

    private static boolean useChunkEncoding(Request<?> request) {
        return (request.getOriginalRequest() instanceof PutObjectRequest) || (request.getOriginalRequest() instanceof UploadPartRequest);
    }

    static long getContentLength(Request<?> request) throws IOException {
        InputStream content = request.getContent();
        if (content.markSupported()) {
            long j = 0;
            byte[] bArr = new byte[4096];
            content.mark(-1);
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    j += (long) read;
                } else {
                    content.reset();
                    return j;
                }
            }
        } else {
            throw new AmazonClientException("Failed to get content length");
        }
    }
}
