package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.KeyWrapException;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazonaws.services.s3.model.KMSEncryptionMaterials;
import com.amazonaws.services.s3.model.MaterialsDescriptionProvider;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
final class ContentCryptoMaterial {
    private final CipherLite cipherLite;
    private final byte[] encryptedCEK;
    private final Map<String, String> kekMaterialsDescription;
    private final String keyWrappingAlgorithm;

    ContentCryptoMaterial(Map<String, String> map, byte[] bArr, String str, CipherLite cipherLite2) {
        this.cipherLite = cipherLite2;
        this.keyWrappingAlgorithm = str;
        this.encryptedCEK = (byte[]) bArr.clone();
        this.kekMaterialsDescription = map;
    }

    /* access modifiers changed from: package-private */
    public String getKeyWrappingAlgorithm() {
        return this.keyWrappingAlgorithm;
    }

    private boolean usesKMSKey() {
        return KMSSecuredCEK.isKMSKeyWrapped(this.keyWrappingAlgorithm);
    }

    /* access modifiers changed from: package-private */
    public ContentCryptoScheme getContentCryptoScheme() {
        return this.cipherLite.getContentCryptoScheme();
    }

    /* access modifiers changed from: package-private */
    public ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata, CryptoMode cryptoMode) {
        if (cryptoMode != CryptoMode.EncryptionOnly || usesKMSKey()) {
            return toObjectMetadata(objectMetadata);
        }
        return toObjectMetadataEO(objectMetadata);
    }

    private ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata) {
        objectMetadata.addUserMetadata(Headers.CRYPTO_KEY_V2, Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        objectMetadata.addUserMetadata(Headers.CRYPTO_CEK_ALGORITHM, contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_TAG_LENGTH, String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm2 = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm2 != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEYWRAP_ALGORITHM, keyWrappingAlgorithm2);
        }
        return objectMetadata;
    }

    private ObjectMetadata toObjectMetadataEO(ObjectMetadata objectMetadata) {
        objectMetadata.addUserMetadata(Headers.CRYPTO_KEY, Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        return objectMetadata;
    }

    /* access modifiers changed from: package-private */
    public String toJsonString(CryptoMode cryptoMode) {
        return (cryptoMode != CryptoMode.EncryptionOnly || usesKMSKey()) ? toJsonString() : toJsonStringEO();
    }

    /* access modifiers changed from: package-private */
    public String toJsonString() {
        HashMap hashMap = new HashMap();
        hashMap.put(Headers.CRYPTO_KEY_V2, Base64.encodeAsString(getEncryptedCEK()));
        hashMap.put(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        hashMap.put(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        hashMap.put(Headers.CRYPTO_CEK_ALGORITHM, contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            hashMap.put(Headers.CRYPTO_TAG_LENGTH, String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm2 = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm2 != null) {
            hashMap.put(Headers.CRYPTO_KEYWRAP_ALGORITHM, keyWrappingAlgorithm2);
        }
        return JsonUtils.mapToString(hashMap);
    }

    private String toJsonStringEO() {
        HashMap hashMap = new HashMap();
        hashMap.put(Headers.CRYPTO_KEY, Base64.encodeAsString(getEncryptedCEK()));
        hashMap.put(Headers.CRYPTO_IV, Base64.encodeAsString(this.cipherLite.getIV()));
        hashMap.put(Headers.MATERIALS_DESCRIPTION, kekMaterialDescAsJson());
        return JsonUtils.mapToString(hashMap);
    }

    private String kekMaterialDescAsJson() {
        Map<String, String> kEKMaterialsDescription = getKEKMaterialsDescription();
        if (kEKMaterialsDescription == null) {
            kEKMaterialsDescription = Collections.emptyMap();
        }
        return JsonUtils.mapToString(kEKMaterialsDescription);
    }

    private static Map<String, String> matdescFromJson(String str) {
        Map jsonToMap = JsonUtils.jsonToMap(str);
        if (jsonToMap == null) {
            return null;
        }
        return Collections.unmodifiableMap(jsonToMap);
    }

    private static SecretKey cek(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, Provider provider, ContentCryptoScheme contentCryptoScheme, AWSKMSClient aWSKMSClient) {
        Key key;
        Cipher cipher;
        Cipher cipher2;
        if (KMSSecuredCEK.isKMSKeyWrapped(str)) {
            return cekByKMS(bArr, str, encryptionMaterials, contentCryptoScheme, aWSKMSClient);
        }
        if (encryptionMaterials.getKeyPair() != null) {
            key = encryptionMaterials.getKeyPair().getPrivate();
            if (key == null) {
                throw new AmazonClientException("Key encrypting key not available");
            }
        } else {
            key = encryptionMaterials.getSymmetricKey();
            if (key == null) {
                throw new AmazonClientException("Key encrypting key not available");
            }
        }
        if (str != null) {
            if (provider == null) {
                try {
                    cipher2 = Cipher.getInstance(str);
                } catch (Exception e) {
                    throw new AmazonClientException("Unable to decrypt symmetric key from object metadata", e);
                }
            } else {
                cipher2 = Cipher.getInstance(str, provider);
            }
            cipher2.init(4, key);
            return (SecretKey) cipher2.unwrap(bArr, str, 3);
        }
        if (provider != null) {
            cipher = Cipher.getInstance(key.getAlgorithm(), provider);
        } else {
            cipher = Cipher.getInstance(key.getAlgorithm());
        }
        cipher.init(2, key);
        return new SecretKeySpec(cipher.doFinal(bArr), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    private static SecretKey cekByKMS(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, AWSKMSClient aWSKMSClient) {
        return new SecretKeySpec(BinaryUtils.copyAllBytesFrom(aWSKMSClient.decrypt(new DecryptRequest().withEncryptionContext(encryptionMaterials.getMaterialsDescription()).withCiphertextBlob(ByteBuffer.wrap(bArr))).getPlaintext()), contentCryptoScheme.getKeyGeneratorAlgorithm());
    }

    static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, AWSKMSClient aWSKMSClient) {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, (long[]) null, ExtraMaterialsDescription.NONE, z, aWSKMSClient);
    }

    static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, jArr, extraMaterialsDescription, z, aWSKMSClient);
    }

    private static ContentCryptoMaterial fromObjectMetadata0(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        EncryptionMaterials encryptionMaterials;
        int parseInt;
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        String str = userMetadata.get(Headers.CRYPTO_KEY_V2);
        if (str == null && (str = userMetadata.get(Headers.CRYPTO_KEY)) == null) {
            throw new AmazonClientException("Content encrypting key not found.");
        }
        byte[] decode = Base64.decode(str);
        byte[] decode2 = Base64.decode(userMetadata.get(Headers.CRYPTO_IV));
        if (decode == null || decode2 == null) {
            throw new AmazonClientException("Content encrypting key or IV not found.");
        }
        String str2 = userMetadata.get(Headers.CRYPTO_KEYWRAP_ALGORITHM);
        boolean isKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str2);
        Map<String, String> matdescFromJson = matdescFromJson(userMetadata.get(Headers.MATERIALS_DESCRIPTION));
        Map<String, String> mergeInto = (isKMSKeyWrapped || extraMaterialsDescription == null) ? matdescFromJson : extraMaterialsDescription.mergeInto(matdescFromJson);
        if (isKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials(matdescFromJson.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            encryptionMaterials.addDescriptions(matdescFromJson);
        } else {
            if (encryptionMaterialsAccessor == null) {
                encryptionMaterials = null;
            } else {
                encryptionMaterials = encryptionMaterialsAccessor.getEncryptionMaterials(mergeInto);
            }
            if (encryptionMaterials == null) {
                throw new AmazonClientException("Unable to retrieve the client encryption materials");
            }
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        String str3 = userMetadata.get(Headers.CRYPTO_CEK_ALGORITHM);
        boolean z2 = jArr != null;
        ContentCryptoScheme fromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str3, z2);
        if (z2) {
            decode2 = fromCEKAlgo.adjustIV(decode2, jArr[0]);
        } else {
            int tagLengthInBits = fromCEKAlgo.getTagLengthInBits();
            if (tagLengthInBits > 0 && tagLengthInBits != (parseInt = Integer.parseInt(userMetadata.get(Headers.CRYPTO_TAG_LENGTH)))) {
                throw new AmazonClientException("Unsupported tag length: " + parseInt + ", expected: " + tagLengthInBits);
            }
        }
        byte[] bArr = decode2;
        if (!z || str2 != null) {
            return new ContentCryptoMaterial(mergeInto, decode, str2, fromCEKAlgo.createCipherLite(cek(decode, str2, encryptionMaterials2, provider, fromCEKAlgo, aWSKMSClient), bArr, 2, provider));
        }
        throw newKeyWrapException();
    }

    private static KeyWrapException newKeyWrapException() {
        return new KeyWrapException("Missing key-wrap for the content-encrypting-key");
    }

    static ContentCryptoMaterial fromInstructionFile(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, AWSKMSClient aWSKMSClient) {
        return fromInstructionFile0(map, encryptionMaterialsAccessor, provider, (long[]) null, ExtraMaterialsDescription.NONE, z, aWSKMSClient);
    }

    static ContentCryptoMaterial fromInstructionFile(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        return fromInstructionFile0(map, encryptionMaterialsAccessor, provider, jArr, extraMaterialsDescription, z, aWSKMSClient);
    }

    private static ContentCryptoMaterial fromInstructionFile0(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        EncryptionMaterials encryptionMaterials;
        int parseInt;
        String str = map.get(Headers.CRYPTO_KEY_V2);
        if (str == null && (str = map.get(Headers.CRYPTO_KEY)) == null) {
            throw new AmazonClientException("Content encrypting key not found.");
        }
        byte[] decode = Base64.decode(str);
        byte[] decode2 = Base64.decode(map.get(Headers.CRYPTO_IV));
        if (decode == null || decode2 == null) {
            throw new AmazonClientException("Necessary encryption info not found in the instruction file " + map);
        }
        String str2 = map.get(Headers.CRYPTO_KEYWRAP_ALGORITHM);
        boolean isKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str2);
        Map<String, String> matdescFromJson = matdescFromJson(map.get(Headers.MATERIALS_DESCRIPTION));
        Map<String, String> mergeInto = (extraMaterialsDescription == null || isKMSKeyWrapped) ? matdescFromJson : extraMaterialsDescription.mergeInto(matdescFromJson);
        if (isKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials(matdescFromJson.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            encryptionMaterials.addDescriptions(matdescFromJson);
        } else {
            if (encryptionMaterialsAccessor == null) {
                encryptionMaterials = null;
            } else {
                encryptionMaterials = encryptionMaterialsAccessor.getEncryptionMaterials(mergeInto);
            }
            if (encryptionMaterials == null) {
                throw new AmazonClientException("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file " + map);
            }
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        String str3 = map.get(Headers.CRYPTO_CEK_ALGORITHM);
        boolean z2 = jArr != null;
        ContentCryptoScheme fromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str3, z2);
        if (z2) {
            decode2 = fromCEKAlgo.adjustIV(decode2, jArr[0]);
        } else {
            int tagLengthInBits = fromCEKAlgo.getTagLengthInBits();
            if (tagLengthInBits > 0 && tagLengthInBits != (parseInt = Integer.parseInt(map.get(Headers.CRYPTO_TAG_LENGTH)))) {
                throw new AmazonClientException("Unsupported tag length: " + parseInt + ", expected: " + tagLengthInBits);
            }
        }
        byte[] bArr = decode2;
        if (!z || str2 != null) {
            return new ContentCryptoMaterial(mergeInto, decode, str2, fromCEKAlgo.createCipherLite(cek(decode, str2, encryptionMaterials2, provider, fromCEKAlgo, aWSKMSClient), bArr, 2, provider));
        }
        throw newKeyWrapException();
    }

    static String parseInstructionFile(S3Object s3Object) {
        try {
            return convertStreamToString(s3Object.getObjectContent());
        } catch (Exception e) {
            throw new AmazonClientException("Error parsing JSON instruction file", e);
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

    /* access modifiers changed from: package-private */
    public CipherLite getCipherLite() {
        return this.cipherLite;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getKEKMaterialsDescription() {
        return this.kekMaterialsDescription;
    }

    /* access modifiers changed from: package-private */
    public byte[] getEncryptedCEK() {
        return (byte[]) this.encryptedCEK.clone();
    }

    /* access modifiers changed from: package-private */
    public ContentCryptoMaterial recreate(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials;
        Map<String, String> map2 = map;
        EncryptionMaterialsAccessor encryptionMaterialsAccessor2 = encryptionMaterialsAccessor;
        if (usesKMSKey() || !map2.equals(this.kekMaterialsDescription)) {
            if (usesKMSKey()) {
                encryptionMaterials = new KMSEncryptionMaterials(this.kekMaterialsDescription.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            } else {
                encryptionMaterials = encryptionMaterialsAccessor2.getEncryptionMaterials(this.kekMaterialsDescription);
            }
            EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
            EncryptionMaterials encryptionMaterials3 = encryptionMaterialsAccessor2.getEncryptionMaterials(map2);
            if (encryptionMaterials3 != null) {
                EncryptionMaterials encryptionMaterials4 = encryptionMaterials3;
                ContentCryptoMaterial create = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, encryptionMaterials2, provider, getContentCryptoScheme(), aWSKMSClient), this.cipherLite.getIV(), encryptionMaterials4, getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
                if (!Arrays.equals(create.encryptedCEK, this.encryptedCEK)) {
                    return create;
                }
                throw new SecurityException("The new KEK must differ from the original");
            }
            throw new AmazonClientException("No material available with the description " + map2 + " from the encryption material provider");
        }
        throw new SecurityException("Material description of the new KEK must differ from the current one");
    }

    /* access modifiers changed from: package-private */
    public ContentCryptoMaterial recreate(EncryptionMaterials encryptionMaterials, EncryptionMaterialsAccessor encryptionMaterialsAccessor, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials2;
        if (usesKMSKey() || !encryptionMaterials.getMaterialsDescription().equals(this.kekMaterialsDescription)) {
            if (usesKMSKey()) {
                encryptionMaterials2 = new KMSEncryptionMaterials(this.kekMaterialsDescription.get(KMSEncryptionMaterials.CUSTOMER_MASTER_KEY_ID));
            } else {
                encryptionMaterials2 = encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription);
            }
            EncryptionMaterials encryptionMaterials3 = encryptionMaterials;
            ContentCryptoMaterial create = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, encryptionMaterials2, provider, getContentCryptoScheme(), aWSKMSClient), this.cipherLite.getIV(), encryptionMaterials3, getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
            if (!Arrays.equals(create.encryptedCEK, this.encryptedCEK)) {
                return create;
            }
            throw new SecurityException("The new KEK must differ from the original");
        }
        throw new SecurityException("Material description of the new KEK must differ from the current one");
    }

    static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return doCreate(secretKey, bArr, encryptionMaterials, contentCryptoScheme, s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
    }

    static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return doCreate(secretKey, bArr, encryptionMaterials, s3CryptoScheme.getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
    }

    private static ContentCryptoMaterial doCreate(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return wrap(secretKey, bArr, contentCryptoScheme, provider, secureCEK(secretKey, encryptionMaterials, s3CryptoScheme.getKeyWrapScheme(), s3CryptoScheme.getSecureRandom(), provider, aWSKMSClient, amazonWebServiceRequest));
    }

    public static ContentCryptoMaterial wrap(SecretKey secretKey, byte[] bArr, ContentCryptoScheme contentCryptoScheme, Provider provider, SecuredCEK securedCEK) {
        return new ContentCryptoMaterial(securedCEK.getMaterialDescription(), securedCEK.getEncrypted(), securedCEK.getKeyWrapAlgorithm(), contentCryptoScheme.createCipherLite(secretKey, bArr, 1, provider));
    }

    private static SecuredCEK secureCEK(SecretKey secretKey, EncryptionMaterials encryptionMaterials, S3KeyWrapScheme s3KeyWrapScheme, SecureRandom secureRandom, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        Key key;
        Cipher cipher;
        Cipher cipher2;
        if (encryptionMaterials.isKMSEnabled()) {
            Map<String, String> mergeMaterialDescriptions = mergeMaterialDescriptions(encryptionMaterials, amazonWebServiceRequest);
            EncryptRequest withPlaintext = new EncryptRequest().withEncryptionContext(mergeMaterialDescriptions).withKeyId(encryptionMaterials.getCustomerMasterKeyId()).withPlaintext(ByteBuffer.wrap(secretKey.getEncoded()));
            withPlaintext.withGeneralProgressListener(amazonWebServiceRequest.getGeneralProgressListener()).withRequestMetricCollector(amazonWebServiceRequest.getRequestMetricCollector());
            return new KMSSecuredCEK(BinaryUtils.copyAllBytesFrom(aWSKMSClient.encrypt(withPlaintext).getCiphertextBlob()), mergeMaterialDescriptions);
        }
        Map<String, String> materialsDescription = encryptionMaterials.getMaterialsDescription();
        if (encryptionMaterials.getKeyPair() != null) {
            key = encryptionMaterials.getKeyPair().getPublic();
        } else {
            key = encryptionMaterials.getSymmetricKey();
        }
        String keyWrapAlgorithm = s3KeyWrapScheme.getKeyWrapAlgorithm(key, provider);
        if (keyWrapAlgorithm != null) {
            if (provider == null) {
                try {
                    cipher2 = Cipher.getInstance(keyWrapAlgorithm);
                } catch (Exception e) {
                    throw new AmazonClientException("Unable to encrypt symmetric key", e);
                }
            } else {
                cipher2 = Cipher.getInstance(keyWrapAlgorithm, provider);
            }
            cipher2.init(3, key, secureRandom);
            return new SecuredCEK(cipher2.wrap(secretKey), keyWrapAlgorithm, materialsDescription);
        }
        byte[] encoded = secretKey.getEncoded();
        String algorithm = key.getAlgorithm();
        if (provider != null) {
            cipher = Cipher.getInstance(algorithm, provider);
        } else {
            cipher = Cipher.getInstance(algorithm);
        }
        cipher.init(1, key);
        return new SecuredCEK(cipher.doFinal(encoded), (String) null, materialsDescription);
    }

    static Map<String, String> mergeMaterialDescriptions(EncryptionMaterials encryptionMaterials, AmazonWebServiceRequest amazonWebServiceRequest) {
        Map<String, String> materialsDescription;
        Map<String, String> materialsDescription2 = encryptionMaterials.getMaterialsDescription();
        if (!(amazonWebServiceRequest instanceof MaterialsDescriptionProvider) || (materialsDescription = ((MaterialsDescriptionProvider) amazonWebServiceRequest).getMaterialsDescription()) == null) {
            return materialsDescription2;
        }
        TreeMap treeMap = new TreeMap(materialsDescription2);
        treeMap.putAll(materialsDescription);
        return treeMap;
    }
}
