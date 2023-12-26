package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class KeyProvider18 implements KeyProvider {
    static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    static final String AWS_KEY_VALUE_STORE_VERSION_1_KEY_STORE_ALIAS_FOR_RSA_SUFFIX = ".rsaKeyStoreAlias";
    static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    static final String CIPHER_PROVIDER_NAME_FOR_RSA = "AndroidOpenSSL";
    static final String CIPHER_RSA_MODE = "RSA/ECB/PKCS1Padding";
    static final String ENCRYPTED_AES_KEY = "AesGcmNoPadding18-encrypted-encryption-key";
    static final String KEY_ALGORITHM_AES = "AES";
    static final String KEY_ALGORITHM_RSA = "RSA";
    private static final Log logger = LogFactory.getLog((Class<?>) KeyProvider18.class);
    private Context context;
    private SecureRandom secureRandom;
    private SharedPreferences sharedPreferences;

    KeyProvider18(Context context2, SharedPreferences sharedPreferences2) {
        this.context = context2;
        this.sharedPreferences = sharedPreferences2;
    }

    private byte[] rsaEncrypt(String str, byte[] bArr) {
        try {
            KeyStore instance = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
            instance.load((KeyStore.LoadStoreParameter) null);
            Cipher instance2 = Cipher.getInstance(CIPHER_RSA_MODE, CIPHER_PROVIDER_NAME_FOR_RSA);
            instance2.init(1, ((KeyStore.PrivateKeyEntry) instance.getEntry(str, (KeyStore.ProtectionParameter) null)).getCertificate().getPublicKey());
            return instance2.doFinal(bArr);
        } catch (Exception e) {
            Log log = logger;
            log.error("Exception occurred while encrypting data. " + e.getMessage());
            return null;
        }
    }

    private byte[] rsaDecrypt(String str, byte[] bArr) {
        try {
            KeyStore instance = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
            instance.load((KeyStore.LoadStoreParameter) null);
            Cipher instance2 = Cipher.getInstance(CIPHER_RSA_MODE, CIPHER_PROVIDER_NAME_FOR_RSA);
            instance2.init(2, ((KeyStore.PrivateKeyEntry) instance.getEntry(str, (KeyStore.ProtectionParameter) null)).getPrivateKey());
            return instance2.doFinal(bArr);
        } catch (Exception e) {
            logger.error("Exception occurred while decrypting the encrypted AES key. ", e);
            return null;
        }
    }

    public synchronized Key generateKey(String str) throws KeyNotGeneratedException {
        SecretKey generateKey;
        try {
            KeyStore.getInstance(ANDROID_KEY_STORE_NAME).load((KeyStore.LoadStoreParameter) null);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 30);
            KeyPairGeneratorSpec.Builder alias = new KeyPairGeneratorSpec.Builder(this.context).setAlias(str);
            KeyPairGeneratorSpec build = alias.setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.TEN).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
            KeyPairGenerator instance3 = KeyPairGenerator.getInstance(KEY_ALGORITHM_RSA, ANDROID_KEY_STORE_NAME);
            instance3.initialize(build);
            instance3.generateKeyPair();
            this.secureRandom = new SecureRandom();
            KeyGenerator instance4 = KeyGenerator.getInstance("AES");
            instance4.init(256, this.secureRandom);
            generateKey = instance4.generateKey();
            if (generateKey != null) {
                byte[] encoded = generateKey.getEncoded();
                if (encoded == null || encoded.length == 0) {
                    throw new KeyNotGeneratedException("Error in generating the AES encryption key for the alias: AesGcmNoPadding18-encrypted-encryption-key");
                }
                byte[] rsaEncrypt = rsaEncrypt(str, encoded);
                if (rsaEncrypt == null || rsaEncrypt.length == 0) {
                    throw new KeyNotGeneratedException("Error in RSA encrypting the AES encryption key for the AES keyAlias: AesGcmNoPadding18-encrypted-encryption-key using the rsaKeyAlias: " + str);
                }
                String encodeAsString = Base64.encodeAsString(rsaEncrypt);
                if (encodeAsString != null) {
                    this.sharedPreferences.edit().putString(ENCRYPTED_AES_KEY, encodeAsString).apply();
                    logger.info("Generated and saved the Encrypted AES encryption key for the AES keyAlias: AesGcmNoPadding18-encrypted-encryption-key to SharedPreferences.");
                } else {
                    throw new KeyNotGeneratedException("Error in Base64 encoding of the Encrypted AES key for the AES keyAlias: AesGcmNoPadding18-encrypted-encryption-key using the rsaKeyAlias: " + str);
                }
            } else {
                throw new KeyNotGeneratedException("Error in generating the AES encryption key for the alias: AesGcmNoPadding18-encrypted-encryption-key");
            }
        } catch (Exception e) {
            throw new KeyNotGeneratedException("Error in generating the RSA Encryption key for the rsaKeyAlias: " + str + " in " + ANDROID_KEY_STORE_NAME, e);
        } catch (Exception e2) {
            throw new KeyNotGeneratedException("Error in generating the AES key and RSA encrypting the AES key using the rsaKeyAlias: " + str + " in " + ANDROID_KEY_STORE_NAME, e2);
        } catch (Throwable th) {
            throw th;
        }
        return generateKey;
    }

    public synchronized Key retrieveKey(String str) throws KeyNotFoundException {
        byte[] rsaDecrypt;
        try {
            KeyStore instance = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
            instance.load((KeyStore.LoadStoreParameter) null);
            if (!instance.containsAlias(str)) {
                throw new KeyNotFoundException("The RSA Key identified by the alias: " + str + " cannot be found in " + ANDROID_KEY_STORE_NAME);
            } else if (this.sharedPreferences.contains(ENCRYPTED_AES_KEY)) {
                logger.debug("Loading the encryption key from SharedPreferences");
                String string = this.sharedPreferences.getString(ENCRYPTED_AES_KEY, (String) null);
                if (string != null) {
                    byte[] decode = Base64.decode(string);
                    if (decode == null || decode.length == 0) {
                        throw new KeyNotFoundException("Unable to Base64 decode the encrypted AES key identified by: AesGcmNoPadding18-encrypted-encryption-key");
                    }
                    rsaDecrypt = rsaDecrypt(str, decode);
                    if (rsaDecrypt == null || rsaDecrypt.length == 0) {
                        throw new KeyNotFoundException("Unable to RSA decrypt the encrypted AES key identified by: AesGcmNoPadding18-encrypted-encryption-key using the RSA key identified by keyAlias: " + str);
                    }
                } else {
                    throw new KeyNotFoundException("Unable to retrieve the encrypted AES Key identified by AesGcmNoPadding18-encrypted-encryption-key from the SharedPreferences.");
                }
            } else {
                throw new KeyNotFoundException("SharedPreferences does not have the key for keyAlias: AesGcmNoPadding18-encrypted-encryption-key");
            }
        } catch (Exception e) {
            throw new KeyNotFoundException("Error occurred while accessing AndroidKeyStore to retrieve the key for keyAlias: " + str, e);
        }
        return new SecretKeySpec(rsaDecrypt, "AES");
    }

    public synchronized void deleteKey(String str) {
        try {
            this.sharedPreferences.edit().remove(ENCRYPTED_AES_KEY).apply();
        } catch (Exception e) {
            logger.error("Error in deleting the encrypted AES key identified by AesGcmNoPadding18-encrypted-encryption-key from SharedPreferences.", e);
        }
        try {
            KeyStore instance = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
            instance.load((KeyStore.LoadStoreParameter) null);
            instance.deleteEntry(str);
        } catch (Exception e2) {
            Log log = logger;
            log.error("Error in deleting the RSA Key identified by the keyAlias: " + str + " from " + ANDROID_KEY_STORE_NAME, e2);
        }
        return;
    }
}
