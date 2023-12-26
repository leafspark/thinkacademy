package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.RepeatableCipherInputStream;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.util.Base64;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
public class EncryptionUtils {
    static final String INSTRUCTION_SUFFIX = ".instruction";

    @Deprecated
    public static PutObjectRequest encryptRequestUsingMetadata(PutObjectRequest putObjectRequest, EncryptionMaterials encryptionMaterials, Provider provider) {
        EncryptionInstruction generateInstruction = generateInstruction(encryptionMaterials, provider);
        PutObjectRequest encryptRequestUsingInstruction = encryptRequestUsingInstruction(putObjectRequest, generateInstruction);
        updateMetadataWithEncryptionInstruction(putObjectRequest, generateInstruction);
        return encryptRequestUsingInstruction;
    }

    @Deprecated
    public static S3Object decryptObjectUsingMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return decryptObjectUsingInstruction(s3Object, buildInstructionFromObjectMetadata(s3Object, encryptionMaterials, provider));
    }

    @Deprecated
    public static EncryptionInstruction generateInstruction(EncryptionMaterials encryptionMaterials, Provider provider) {
        return generateInstruction((EncryptionMaterialsProvider) new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        return buildInstruction(encryptionMaterialsProvider.getEncryptionMaterials(), provider);
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Map<String, String> map, Provider provider) {
        return buildInstruction(encryptionMaterialsProvider.getEncryptionMaterials(map), provider);
    }

    private static EncryptionInstruction buildInstruction(EncryptionMaterials encryptionMaterials, Provider provider) {
        SecretKey generateOneTimeUseSymmetricKey = generateOneTimeUseSymmetricKey();
        CipherFactory cipherFactory = new CipherFactory(generateOneTimeUseSymmetricKey, 1, (byte[]) null, provider);
        return new EncryptionInstruction(encryptionMaterials.getMaterialsDescription(), getEncryptedSymmetricKey(generateOneTimeUseSymmetricKey, encryptionMaterials, provider), generateOneTimeUseSymmetricKey, cipherFactory);
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromInstructionFile(s3Object, (EncryptionMaterialsProvider) new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        Map<String, String> parseJSONInstruction = parseJSONInstruction(s3Object);
        Map<String, String> convertJSONToMap = convertJSONToMap(parseJSONInstruction.get(Headers.MATERIALS_DESCRIPTION));
        byte[] decode = Base64.decode(parseJSONInstruction.get(Headers.CRYPTO_KEY));
        byte[] decode2 = Base64.decode(parseJSONInstruction.get(Headers.CRYPTO_IV));
        if (decode == null || decode2 == null) {
            throw new AmazonClientException(String.format("Necessary encryption info not found in the instruction file '%s' in bucket '%s'", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
        }
        EncryptionMaterials retrieveOriginalMaterials = retrieveOriginalMaterials(convertJSONToMap, encryptionMaterialsProvider);
        if (retrieveOriginalMaterials != null) {
            SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(decode, retrieveOriginalMaterials, provider);
            return new EncryptionInstruction(convertJSONToMap, decode, decryptedSymmetricKey, new CipherFactory(decryptedSymmetricKey, 2, decode2, provider));
        }
        throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file '%s' in bucket '%s'.", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromObjectMetadata(s3Object, (EncryptionMaterialsProvider) new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        byte[] cryptoBytesFromMetadata = getCryptoBytesFromMetadata(Headers.CRYPTO_KEY, objectMetadata);
        byte[] cryptoBytesFromMetadata2 = getCryptoBytesFromMetadata(Headers.CRYPTO_IV, objectMetadata);
        Map<String, String> convertJSONToMap = convertJSONToMap(getStringFromMetadata(Headers.MATERIALS_DESCRIPTION, objectMetadata));
        if (cryptoBytesFromMetadata == null || cryptoBytesFromMetadata2 == null) {
            throw new AmazonClientException(String.format("Necessary encryption info not found in the headers of file '%s' in bucket '%s'", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
        }
        EncryptionMaterials retrieveOriginalMaterials = retrieveOriginalMaterials(convertJSONToMap, encryptionMaterialsProvider);
        if (retrieveOriginalMaterials != null) {
            SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(cryptoBytesFromMetadata, retrieveOriginalMaterials, provider);
            return new EncryptionInstruction(convertJSONToMap, cryptoBytesFromMetadata, decryptedSymmetricKey, new CipherFactory(decryptedSymmetricKey, 2, cryptoBytesFromMetadata2, provider));
        }
        throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted file '%s' in bucket '%s'.", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
    }

    public static PutObjectRequest encryptRequestUsingInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (metadata.getContentMD5() != null) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, metadata.getContentMD5());
        }
        metadata.setContentMD5((String) null);
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, metadata);
        if (unencryptedContentLength >= 0) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(unencryptedContentLength));
        }
        long calculateCryptoContentLength = calculateCryptoContentLength(encryptionInstruction.getSymmetricCipher(), putObjectRequest, metadata);
        if (calculateCryptoContentLength >= 0) {
            metadata.setContentLength(calculateCryptoContentLength);
        }
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(getEncryptedInputStream(putObjectRequest, encryptionInstruction.getCipherFactory(), unencryptedContentLength));
        putObjectRequest.setFile((File) null);
        return putObjectRequest;
    }

    public static S3Object decryptObjectUsingInstruction(S3Object s3Object, EncryptionInstruction encryptionInstruction) {
        s3Object.setObjectContent(new S3ObjectInputStream(new RepeatableCipherInputStream(s3Object.getObjectContent(), encryptionInstruction.getCipherFactory())));
        return s3Object;
    }

    public static PutObjectRequest createInstructionPutRequest(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        byte[] bytes = JsonUtils.mapToString(convertInstructionToJSONObject(encryptionInstruction)).getBytes(StringUtils.UTF8);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        metadata.setContentLength((long) bytes.length);
        metadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        putObjectRequest.setKey(putObjectRequest.getKey() + INSTRUCTION_SUFFIX);
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(byteArrayInputStream);
        return putObjectRequest;
    }

    public static PutObjectRequest createInstructionPutRequest(String str, String str2, EncryptionInstruction encryptionInstruction) {
        byte[] bytes = JsonUtils.mapToString(convertInstructionToJSONObject(encryptionInstruction)).getBytes(StringUtils.UTF8);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength((long) bytes.length);
        objectMetadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        return new PutObjectRequest(str, str2 + INSTRUCTION_SUFFIX, byteArrayInputStream, objectMetadata);
    }

    public static GetObjectRequest createInstructionGetRequest(GetObjectRequest getObjectRequest) {
        String bucketName = getObjectRequest.getBucketName();
        return new GetObjectRequest(bucketName, getObjectRequest.getKey() + INSTRUCTION_SUFFIX, getObjectRequest.getVersionId());
    }

    public static DeleteObjectRequest createInstructionDeleteObjectRequest(DeleteObjectRequest deleteObjectRequest) {
        String bucketName = deleteObjectRequest.getBucketName();
        return new DeleteObjectRequest(bucketName, deleteObjectRequest.getKey() + INSTRUCTION_SUFFIX);
    }

    public static boolean isEncryptionInfoInMetadata(S3Object s3Object) {
        Map<String, String> userMetadata = s3Object.getObjectMetadata().getUserMetadata();
        return userMetadata != null && userMetadata.containsKey(Headers.CRYPTO_IV) && userMetadata.containsKey(Headers.CRYPTO_KEY);
    }

    public static boolean isEncryptionInfoInInstructionFile(S3Object s3Object) {
        Map<String, String> userMetadata;
        if (s3Object == null || (userMetadata = s3Object.getObjectMetadata().getUserMetadata()) == null) {
            return false;
        }
        return userMetadata.containsKey(Headers.CRYPTO_INSTRUCTION_FILE);
    }

    public static long[] getAdjustedCryptoRange(long[] jArr) {
        if (jArr == null || jArr[0] > jArr[1]) {
            return null;
        }
        return new long[]{getCipherBlockLowerBound(jArr[0]), getCipherBlockUpperBound(jArr[1])};
    }

    public static S3Object adjustOutputToDesiredRange(S3Object s3Object, long[] jArr) {
        if (jArr == null || jArr[0] > jArr[1]) {
            return s3Object;
        }
        try {
            s3Object.setObjectContent(new S3ObjectInputStream(new AdjustedRangeInputStream(s3Object.getObjectContent(), jArr[0], jArr[1])));
            return s3Object;
        } catch (IOException e) {
            throw new AmazonClientException("Error adjusting output to desired byte range: " + e.getMessage());
        }
    }

    public static SecretKey generateOneTimeUseSymmetricKey() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            instance.init(256, new SecureRandom());
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new AmazonClientException("Unable to generate envelope symmetric key:" + e.getMessage(), e);
        }
    }

    public static Cipher createSymmetricCipher(SecretKey secretKey, int i, Provider provider, byte[] bArr) {
        Cipher cipher;
        if (provider != null) {
            try {
                cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, provider);
            } catch (Exception e) {
                throw new AmazonClientException("Unable to build cipher: " + e.getMessage() + "\nMake sure you have the JCE unlimited strength policy files installed and configured for your JVM: http://www.ngs.ac.uk/tools/jcepolicyfiles", e);
            }
        } else {
            cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        }
        if (bArr != null) {
            cipher.init(i, secretKey, new IvParameterSpec(bArr));
        } else {
            cipher.init(i, secretKey);
        }
        return cipher;
    }

    public static byte[] getEncryptedSymmetricKey(SecretKey secretKey, EncryptionMaterials encryptionMaterials, Provider provider) {
        Key key;
        Cipher cipher;
        if (encryptionMaterials.getKeyPair() != null) {
            key = encryptionMaterials.getKeyPair().getPublic();
        } else {
            key = encryptionMaterials.getSymmetricKey();
        }
        try {
            byte[] encoded = secretKey.getEncoded();
            if (provider != null) {
                cipher = Cipher.getInstance(key.getAlgorithm(), provider);
            } else {
                cipher = Cipher.getInstance(key.getAlgorithm());
            }
            cipher.init(1, key);
            return cipher.doFinal(encoded);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to encrypt symmetric key: " + e.getMessage(), e);
        }
    }

    private static SecretKey getDecryptedSymmetricKey(byte[] bArr, EncryptionMaterials encryptionMaterials, Provider provider) {
        Key key;
        Cipher cipher;
        if (encryptionMaterials.getKeyPair() != null) {
            key = encryptionMaterials.getKeyPair().getPrivate();
        } else {
            key = encryptionMaterials.getSymmetricKey();
        }
        if (provider != null) {
            try {
                cipher = Cipher.getInstance(key.getAlgorithm(), provider);
            } catch (Exception e) {
                throw new AmazonClientException("Unable to decrypt symmetric key from object metadata : " + e.getMessage(), e);
            }
        } else {
            cipher = Cipher.getInstance(key.getAlgorithm());
        }
        cipher.init(2, key);
        return new SecretKeySpec(cipher.doFinal(bArr), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    private static InputStream getEncryptedInputStream(PutObjectRequest putObjectRequest, CipherFactory cipherFactory, long j) {
        try {
            InputStream inputStream = putObjectRequest.getInputStream();
            if (putObjectRequest.getFile() != null) {
                inputStream = new RepeatableFileInputStream(putObjectRequest.getFile());
            }
            if (j > -1) {
                inputStream = new LengthCheckInputStream(inputStream, j, false);
            }
            return new RepeatableCipherInputStream(inputStream, cipherFactory);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to create cipher input stream: " + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.amazonaws.services.s3.internal.RepeatableCipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.amazonaws.services.s3.internal.RepeatableCipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.amazonaws.services.s3.internal.InputSubstream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.amazonaws.services.s3.internal.RepeatableCipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.amazonaws.services.s3.internal.InputSubstream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.services.s3.internal.InputSubstream} */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amazonaws.services.s3.internal.crypto.ByteRangeCapturingInputStream getEncryptedInputStream(com.amazonaws.services.s3.model.UploadPartRequest r9, com.amazonaws.services.s3.internal.crypto.CipherFactory r10) {
        /*
            java.io.InputStream r0 = r9.getInputStream()     // Catch:{ Exception -> 0x0056 }
            java.io.File r1 = r9.getFile()     // Catch:{ Exception -> 0x0056 }
            if (r1 == 0) goto L_0x0025
            com.amazonaws.services.s3.internal.InputSubstream r0 = new com.amazonaws.services.s3.internal.InputSubstream     // Catch:{ Exception -> 0x0056 }
            com.amazonaws.services.s3.internal.RepeatableFileInputStream r3 = new com.amazonaws.services.s3.internal.RepeatableFileInputStream     // Catch:{ Exception -> 0x0056 }
            java.io.File r1 = r9.getFile()     // Catch:{ Exception -> 0x0056 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0056 }
            long r4 = r9.getFileOffset()     // Catch:{ Exception -> 0x0056 }
            long r6 = r9.getPartSize()     // Catch:{ Exception -> 0x0056 }
            boolean r8 = r9.isLastPart()     // Catch:{ Exception -> 0x0056 }
            r2 = r0
            r2.<init>(r3, r4, r6, r8)     // Catch:{ Exception -> 0x0056 }
        L_0x0025:
            com.amazonaws.services.s3.internal.RepeatableCipherInputStream r2 = new com.amazonaws.services.s3.internal.RepeatableCipherInputStream     // Catch:{ Exception -> 0x0056 }
            r2.<init>(r0, r10)     // Catch:{ Exception -> 0x0056 }
            boolean r0 = r9.isLastPart()     // Catch:{ Exception -> 0x0056 }
            if (r0 != 0) goto L_0x003f
            com.amazonaws.services.s3.internal.InputSubstream r0 = new com.amazonaws.services.s3.internal.InputSubstream     // Catch:{ Exception -> 0x0056 }
            r3 = 0
            long r5 = r9.getPartSize()     // Catch:{ Exception -> 0x0056 }
            r7 = 0
            r1 = r0
            r1.<init>(r2, r3, r5, r7)     // Catch:{ Exception -> 0x0056 }
            r1 = r0
            goto L_0x0040
        L_0x003f:
            r1 = r2
        L_0x0040:
            long r4 = r9.getPartSize()     // Catch:{ Exception -> 0x0056 }
            javax.crypto.Cipher r9 = r10.createCipher()     // Catch:{ Exception -> 0x0056 }
            int r9 = r9.getBlockSize()     // Catch:{ Exception -> 0x0056 }
            com.amazonaws.services.s3.internal.crypto.ByteRangeCapturingInputStream r10 = new com.amazonaws.services.s3.internal.crypto.ByteRangeCapturingInputStream     // Catch:{ Exception -> 0x0056 }
            long r2 = (long) r9     // Catch:{ Exception -> 0x0056 }
            long r2 = r4 - r2
            r0 = r10
            r0.<init>(r1, r2, r4)     // Catch:{ Exception -> 0x0056 }
            return r10
        L_0x0056:
            r9 = move-exception
            com.amazonaws.AmazonClientException r10 = new com.amazonaws.AmazonClientException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to create cipher input stream: "
            r0.append(r1)
            java.lang.String r1 = r9.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.crypto.EncryptionUtils.getEncryptedInputStream(com.amazonaws.services.s3.model.UploadPartRequest, com.amazonaws.services.s3.internal.crypto.CipherFactory):com.amazonaws.services.s3.internal.crypto.ByteRangeCapturingInputStream");
    }

    private static byte[] getCryptoBytesFromMetadata(String str, ObjectMetadata objectMetadata) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata == null || !userMetadata.containsKey(str)) {
            return null;
        }
        return Base64.decode(userMetadata.get(str));
    }

    private static String getStringFromMetadata(String str, ObjectMetadata objectMetadata) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata == null || !userMetadata.containsKey(str)) {
            return null;
        }
        return userMetadata.get(str);
    }

    private static Map<String, String> convertJSONToMap(String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonUtils.jsonToMap(str);
        } catch (AmazonClientException e) {
            throw new AmazonClientException("Unable to parse encryption materials description from metadata :" + e.getMessage());
        }
    }

    public static void updateMetadataWithEncryptionInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        byte[] encryptedSymmetricKey = encryptionInstruction.getEncryptedSymmetricKey();
        Cipher symmetricCipher = encryptionInstruction.getSymmetricCipher();
        Map<String, String> materialsDescription = encryptionInstruction.getMaterialsDescription();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (putObjectRequest.getFile() != null) {
            metadata.setContentType(Mimetypes.getInstance().getMimetype(putObjectRequest.getFile()));
        }
        updateMetadata(metadata, encryptedSymmetricKey, symmetricCipher, materialsDescription);
        putObjectRequest.setMetadata(metadata);
    }

    private static void updateMetadata(ObjectMetadata objectMetadata, byte[] bArr, Cipher cipher, Map<String, String> map) {
        if (bArr != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEY, Base64.encodeAsString(bArr));
        }
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(cipher.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, JsonUtils.mapToString(map));
    }

    public static ObjectMetadata updateMetadataWithEncryptionInfo(InitiateMultipartUploadRequest initiateMultipartUploadRequest, byte[] bArr, Cipher cipher, Map<String, String> map) {
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        updateMetadata(objectMetadata, bArr, cipher, map);
        return objectMetadata;
    }

    private static EncryptionMaterials retrieveOriginalMaterials(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor) {
        if (encryptionMaterialsAccessor == null) {
            return null;
        }
        return encryptionMaterialsAccessor.getEncryptionMaterials(map);
    }

    private static long calculateCryptoContentLength(Cipher cipher, PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, objectMetadata);
        if (unencryptedContentLength < 0) {
            return -1;
        }
        long blockSize = (long) cipher.getBlockSize();
        return unencryptedContentLength + (blockSize - (unencryptedContentLength % blockSize));
    }

    public static long calculateCryptoContentLength(Cipher cipher, UploadPartRequest uploadPartRequest) {
        long j;
        if (uploadPartRequest.getFile() != null) {
            if (uploadPartRequest.getPartSize() > 0) {
                j = uploadPartRequest.getPartSize();
            } else {
                j = uploadPartRequest.getFile().length();
            }
        } else if (uploadPartRequest.getInputStream() == null) {
            return -1;
        } else {
            j = uploadPartRequest.getPartSize();
        }
        long blockSize = (long) cipher.getBlockSize();
        return j + (blockSize - (j % blockSize));
    }

    private static long getUnencryptedContentLength(PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        if (putObjectRequest.getFile() != null) {
            return putObjectRequest.getFile().length();
        }
        if (putObjectRequest.getInputStream() == null || objectMetadata.getRawMetadataValue("Content-Length") == null) {
            return -1;
        }
        return objectMetadata.getContentLength();
    }

    private static Map<String, String> convertInstructionToJSONObject(EncryptionInstruction encryptionInstruction) {
        HashMap hashMap = new HashMap();
        hashMap.put(Headers.MATERIALS_DESCRIPTION, JsonUtils.mapToString(encryptionInstruction.getMaterialsDescription()));
        hashMap.put(Headers.CRYPTO_KEY, Base64.encodeAsString(encryptionInstruction.getEncryptedSymmetricKey()));
        hashMap.put(Headers.CRYPTO_IV, Base64.encodeAsString(encryptionInstruction.getSymmetricCipher().getIV()));
        return hashMap;
    }

    private static Map<String, String> parseJSONInstruction(S3Object s3Object) {
        try {
            return JsonUtils.jsonToMap(convertStreamToString(s3Object.getObjectContent()));
        } catch (Exception e) {
            throw new AmazonClientException("Error parsing JSON instruction file: " + e.getMessage());
        }
    }

    /* JADX INFO: finally extract failed */
    private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    inputStream.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static long getCipherBlockLowerBound(long j) {
        long j2 = (j - (j % 16)) - 16;
        if (j2 < 0) {
            return 0;
        }
        return j2;
    }

    private static long getCipherBlockUpperBound(long j) {
        return j + (16 - (j % 16)) + 16;
    }
}
