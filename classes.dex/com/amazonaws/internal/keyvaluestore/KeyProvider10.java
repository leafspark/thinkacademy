package com.amazonaws.internal.keyvaluestore;

import android.content.SharedPreferences;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

class KeyProvider10 implements KeyProvider {
    private static final String AES_KEY_ALGORITHM = "AES";
    private static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    static final String KEY_ALIAS = "AesGcmNoPaddingEncryption10-encryption-key";
    private static final Log logger = LogFactory.getLog("KeyProvider10");
    private SharedPreferences sharedPreferences;

    KeyProvider10(SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }

    public synchronized Key generateKey(String str) throws KeyNotGeneratedException {
        SecretKey generateKey;
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256, secureRandom);
            generateKey = instance.generateKey();
            SecretKey generateKey2 = instance.generateKey();
            if (generateKey2 != null) {
                byte[] encoded = generateKey2.getEncoded();
                if (encoded == null || encoded.length == 0) {
                    throw new KeyNotGeneratedException("Error in getting the encoded bytes for the AES encryption key identified by the aesEncryptionKeyAlias: " + str);
                }
                String encodeAsString = Base64.encodeAsString(encoded);
                if (encodeAsString != null) {
                    this.sharedPreferences.edit().putString(str, encodeAsString).apply();
                    Log log = logger;
                    log.info("Generated and saved the AES encryption key identified by the aesEncryptionKeyAlias: " + str + " to SharedPreferences.");
                } else {
                    throw new KeyNotGeneratedException("Error in Base64 encoding of the AES encryption key for the aesEncryptionKeyAlias: " + str);
                }
            } else {
                throw new KeyNotGeneratedException("Error in generating the AES encryption key identified by the aesEncryptionKeyAlias: " + str);
            }
        } catch (Exception e) {
            throw new KeyNotGeneratedException("Error in generating the AES Encryption key for the aesEncryptionKeyAlias", e);
        }
        return generateKey;
    }

    public synchronized Key retrieveKey(String str) throws KeyNotFoundException {
        byte[] decode;
        try {
            if (this.sharedPreferences.contains(str)) {
                logger.debug("Loading the encryption key from SharedPreferences");
                String string = this.sharedPreferences.getString(str, (String) null);
                if (string != null) {
                    decode = Base64.decode(string);
                    if (decode == null || decode.length == 0) {
                        throw new KeyNotFoundException("Error in Base64 decoding the AES encryption key identified by the keyAlias: " + str);
                    }
                } else {
                    throw new KeyNotFoundException("SharedPreferences does not have the key for keyAlias: " + str);
                }
            } else {
                throw new KeyNotFoundException("SharedPreferences does not have the key for keyAlias: " + str);
            }
        } catch (Exception e) {
            throw new KeyNotFoundException("Error occurred while retrieving key for keyAlias: " + str, e);
        }
        return new SecretKeySpec(decode, "AES");
    }

    public synchronized void deleteKey(String str) {
        try {
            this.sharedPreferences.edit().remove(str).apply();
        } catch (Exception e) {
            Log log = logger;
            log.error("Error in deleting the AES key identified by " + str + " from SharedPreferences.", e);
        }
        return;
    }
}
