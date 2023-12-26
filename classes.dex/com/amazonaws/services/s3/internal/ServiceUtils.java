package com.amazonaws.services.s3.internal;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.SSEAlgorithm;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.net.ssl.SSLProtocolException;

public class ServiceUtils {
    public static final boolean APPEND_MODE = true;
    @Deprecated
    protected static final DateUtils DATE_UTILS = new DateUtils();
    private static final int DEAFAULT_BYTE_SIZE = 10240;
    public static final boolean OVERWRITE_MODE = false;
    private static final Log log = LogFactory.getLog((Class<?>) ServiceUtils.class);

    public interface RetryableS3DownloadTask {
        S3Object getS3ObjectStream();

        boolean needIntegrityCheck();
    }

    public static Date parseIso8601Date(String str) {
        return DateUtils.parseISO8601Date(str);
    }

    public static String formatIso8601Date(Date date) {
        return DateUtils.formatISO8601Date(date);
    }

    public static Date parseRfc822Date(String str) {
        return DateUtils.parseRFC822Date(str);
    }

    public static String formatRfc822Date(Date date) {
        return DateUtils.formatRFC822Date(date);
    }

    public static boolean isMultipartUploadETag(String str) {
        return str.contains("-");
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(StringUtils.UTF8);
    }

    public static String removeQuotes(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }

    public static URL convertRequestToUrl(Request<?> request) {
        return convertRequestToUrl(request, false);
    }

    public static URL convertRequestToUrl(Request<?> request, boolean z) {
        String str;
        boolean z2 = true;
        String urlEncode = S3HttpUtils.urlEncode(request.getResourcePath(), true);
        if (z && urlEncode.startsWith(ExpiryDateInput.SEPARATOR)) {
            urlEncode = urlEncode.substring(1);
        }
        String str2 = request.getEndpoint() + (ExpiryDateInput.SEPARATOR + urlEncode).replaceAll("(?<=/)/", "%2F");
        for (String next : request.getParameters().keySet()) {
            if (z2) {
                str = str2 + "?";
                z2 = false;
            } else {
                str = str2 + "&";
            }
            str2 = str + next + "=" + S3HttpUtils.urlEncode(request.getParameters().get(next), false);
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }

    public static String join(List<String> list) {
        String str = "";
        boolean z = true;
        for (String next : list) {
            if (!z) {
                str = str + ", ";
            }
            str = str + next;
            z = false;
        }
        return str;
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void downloadObjectToFile(com.amazonaws.services.s3.model.S3Object r5, java.io.File r6, boolean r7, boolean r8) {
        /*
            java.lang.String r0 = "Caught exception. Ignoring."
            java.io.File r1 = r6.getParentFile()
            if (r1 == 0) goto L_0x0011
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0011
            r1.mkdirs()
        L_0x0011:
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00c2 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c2 }
            r3.<init>(r6, r8)     // Catch:{ IOException -> 0x00c2 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00c2 }
            r8 = 10240(0x2800, float:1.4349E-41)
            byte[] r8 = new byte[r8]     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
        L_0x0020:
            com.amazonaws.services.s3.model.S3ObjectInputStream r3 = r5.getObjectContent()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            int r3 = r3.read(r8)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            r4 = -1
            if (r3 <= r4) goto L_0x0030
            r4 = 0
            r2.write(r8, r4, r3)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            goto L_0x0020
        L_0x0030:
            r2.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0039
        L_0x0034:
            com.amazonaws.logging.Log r8 = log
            r8.debug(r0)
        L_0x0039:
            com.amazonaws.services.s3.model.S3ObjectInputStream r8 = r5.getObjectContent()     // Catch:{ Exception -> 0x0041 }
            r8.close()     // Catch:{ Exception -> 0x0041 }
            goto L_0x0046
        L_0x0041:
            com.amazonaws.logging.Log r8 = log
            r8.debug(r0)
        L_0x0046:
            com.amazonaws.services.s3.model.ObjectMetadata r8 = r5.getObjectMetadata()     // Catch:{ Exception -> 0x006e }
            java.lang.String r8 = r8.getETag()     // Catch:{ Exception -> 0x006e }
            boolean r8 = isMultipartUploadETag(r8)     // Catch:{ Exception -> 0x006e }
            if (r8 != 0) goto L_0x006c
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006e }
            r8.<init>(r6)     // Catch:{ Exception -> 0x006e }
            byte[] r8 = com.amazonaws.util.Md5Utils.computeMD5Hash(r8)     // Catch:{ Exception -> 0x006e }
            com.amazonaws.services.s3.model.ObjectMetadata r5 = r5.getObjectMetadata()     // Catch:{ Exception -> 0x006a }
            java.lang.String r5 = r5.getETag()     // Catch:{ Exception -> 0x006a }
            byte[] r5 = com.amazonaws.util.BinaryUtils.fromHex(r5)     // Catch:{ Exception -> 0x006a }
            goto L_0x008b
        L_0x006a:
            r5 = move-exception
            goto L_0x0070
        L_0x006c:
            r5 = r1
            goto L_0x008c
        L_0x006e:
            r5 = move-exception
            r8 = r1
        L_0x0070:
            com.amazonaws.logging.Log r0 = log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to calculate MD5 hash to validate download: "
            r2.append(r3)
            java.lang.String r3 = r5.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.warn(r2, r5)
            r5 = r1
        L_0x008b:
            r1 = r8
        L_0x008c:
            if (r7 == 0) goto L_0x00b9
            if (r1 == 0) goto L_0x00b9
            if (r5 == 0) goto L_0x00b9
            boolean r5 = java.util.Arrays.equals(r1, r5)
            if (r5 == 0) goto L_0x0099
            goto L_0x00b9
        L_0x0099:
            com.amazonaws.AmazonClientException r5 = new com.amazonaws.AmazonClientException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data stored in '"
            r7.append(r8)
            java.lang.String r6 = r6.getAbsolutePath()
            r7.append(r6)
            java.lang.String r6 = "' may be corrupt."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x00b9:
            return
        L_0x00ba:
            r6 = move-exception
            r1 = r2
            goto L_0x00e5
        L_0x00bd:
            r6 = move-exception
            r1 = r2
            goto L_0x00c3
        L_0x00c0:
            r6 = move-exception
            goto L_0x00e5
        L_0x00c2:
            r6 = move-exception
        L_0x00c3:
            com.amazonaws.services.s3.model.S3ObjectInputStream r7 = r5.getObjectContent()     // Catch:{ all -> 0x00c0 }
            r7.abort()     // Catch:{ all -> 0x00c0 }
            com.amazonaws.AmazonClientException r7 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x00c0 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            r8.<init>()     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = "Unable to store object contents to disk: "
            r8.append(r2)     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = r6.getMessage()     // Catch:{ all -> 0x00c0 }
            r8.append(r2)     // Catch:{ all -> 0x00c0 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00c0 }
            r7.<init>(r8, r6)     // Catch:{ all -> 0x00c0 }
            throw r7     // Catch:{ all -> 0x00c0 }
        L_0x00e5:
            r1.close()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00ee
        L_0x00e9:
            com.amazonaws.logging.Log r7 = log
            r7.debug(r0)
        L_0x00ee:
            com.amazonaws.services.s3.model.S3ObjectInputStream r5 = r5.getObjectContent()     // Catch:{ Exception -> 0x00f6 }
            r5.close()     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00fb
        L_0x00f6:
            com.amazonaws.logging.Log r5 = log
            r5.debug(r0)
        L_0x00fb:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.ServiceUtils.downloadObjectToFile(com.amazonaws.services.s3.model.S3Object, java.io.File, boolean, boolean):void");
    }

    public static S3Object retryableDownloadS3ObjectToFile(File file, RetryableS3DownloadTask retryableS3DownloadTask, boolean z) {
        S3Object s3ObjectStream;
        boolean z2;
        boolean z3 = false;
        do {
            s3ObjectStream = retryableS3DownloadTask.getS3ObjectStream();
            if (s3ObjectStream == null) {
                return null;
            }
            z2 = true;
            try {
                downloadObjectToFile(s3ObjectStream, file, retryableS3DownloadTask.needIntegrityCheck(), z);
                s3ObjectStream.getObjectContent().abort();
                z2 = false;
                continue;
            } catch (AmazonClientException e) {
                if (!e.isRetryable()) {
                    throw e;
                } else if ((e.getCause() instanceof SocketException) || (e.getCause() instanceof SSLProtocolException)) {
                    throw e;
                } else if (!z3) {
                    log.info("Retry the download of object " + s3ObjectStream.getKey() + " (bucket " + s3ObjectStream.getBucketName() + ")", e);
                    s3ObjectStream.getObjectContent().abort();
                    z3 = true;
                    continue;
                } else {
                    throw e;
                }
            } catch (Throwable th) {
                s3ObjectStream.getObjectContent().abort();
                throw th;
            }
        } while (z2);
        return s3ObjectStream;
    }

    public static boolean skipMd5CheckPerResponse(ObjectMetadata objectMetadata) {
        return skipMd5CheckPerResponse(objectMetadata, (S3ClientOptions) null);
    }

    public static boolean skipMd5CheckPerResponse(ObjectMetadata objectMetadata, S3ClientOptions s3ClientOptions) {
        if (s3ClientOptions != null && s3ClientOptions.isContentMd5CheckSkipped()) {
            return true;
        }
        if (objectMetadata == null) {
            return false;
        }
        boolean equals = SSEAlgorithm.KMS.toString().equals(objectMetadata.getSSEAlgorithm());
        if (objectMetadata.getSSECustomerAlgorithm() != null || equals) {
            return true;
        }
        return false;
    }

    public static boolean skipMd5CheckPerRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return skipMd5CheckPerRequest(amazonWebServiceRequest, (S3ClientOptions) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean skipMd5CheckPerRequest(com.amazonaws.AmazonWebServiceRequest r2, com.amazonaws.services.s3.S3ClientOptions r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L_0x000a
            boolean r3 = r3.isContentMd5CheckSkipped()
            if (r3 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r3 = "com.amazonaws.services.s3.disableGetObjectMD5Validation"
            java.lang.String r3 = java.lang.System.getProperty(r3)
            if (r3 == 0) goto L_0x0013
            return r0
        L_0x0013:
            boolean r3 = r2 instanceof com.amazonaws.services.s3.model.GetObjectRequest
            r1 = 0
            if (r3 == 0) goto L_0x0028
            com.amazonaws.services.s3.model.GetObjectRequest r2 = (com.amazonaws.services.s3.model.GetObjectRequest) r2
            long[] r3 = r2.getRange()
            if (r3 == 0) goto L_0x0021
            return r0
        L_0x0021:
            com.amazonaws.services.s3.model.SSECustomerKey r2 = r2.getSSECustomerKey()
            if (r2 == 0) goto L_0x006c
            return r0
        L_0x0028:
            boolean r3 = r2 instanceof com.amazonaws.services.s3.model.PutObjectRequest
            if (r3 == 0) goto L_0x005d
            com.amazonaws.services.s3.model.PutObjectRequest r2 = (com.amazonaws.services.s3.model.PutObjectRequest) r2
            com.amazonaws.services.s3.model.ObjectMetadata r3 = r2.getMetadata()
            if (r3 == 0) goto L_0x003b
            java.lang.String r3 = r3.getSSEAlgorithm()
            if (r3 == 0) goto L_0x003b
            return r0
        L_0x003b:
            com.amazonaws.services.s3.model.SSECustomerKey r3 = r2.getSSECustomerKey()
            if (r3 == 0) goto L_0x0042
            return r0
        L_0x0042:
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r3 = r2.getSSEAwsKeyManagementParams()
            if (r3 == 0) goto L_0x006c
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r3 = r2.getSSEAwsKeyManagementParams()
            java.lang.String r3 = r3.getEncryption()
            if (r3 != 0) goto L_0x005c
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r2 = r2.getSSEAwsKeyManagementParams()
            java.lang.String r2 = r2.getAwsKmsKeyId()
            if (r2 == 0) goto L_0x006c
        L_0x005c:
            return r0
        L_0x005d:
            boolean r3 = r2 instanceof com.amazonaws.services.s3.model.UploadPartRequest
            if (r3 == 0) goto L_0x006c
            com.amazonaws.services.s3.model.UploadPartRequest r2 = (com.amazonaws.services.s3.model.UploadPartRequest) r2
            com.amazonaws.services.s3.model.SSECustomerKey r2 = r2.getSSECustomerKey()
            if (r2 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r0 = r1
        L_0x006b:
            return r0
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.ServiceUtils.skipMd5CheckPerRequest(com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.s3.S3ClientOptions):boolean");
    }
}
