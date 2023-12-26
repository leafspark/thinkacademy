package com.adyen.checkout.cse;

import android.util.Base64;
import com.adyen.checkout.cse.exception.EncryptionException;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.text.Charsets;

public class ClientSideEncrypter {
    private static final String PREFIX = "adyenan";
    private static final String SEPARATOR = "$";
    private static final String VERSION = "0_1_1";
    private final Cipher mAesCipher;
    private final Cipher mRsaCipher;
    private final SecureRandom mSecureRandom;

    public ClientSideEncrypter(String str) throws EncryptionException {
        if (ValidationUtils.isPublicKeyValid(str)) {
            this.mSecureRandom = new SecureRandom();
            String[] split = str.split("\\|");
            try {
                try {
                    PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(split[1].toLowerCase(Locale.getDefault()), 16), new BigInteger(split[0].toLowerCase(Locale.getDefault()), 16)));
                    try {
                        this.mAesCipher = Cipher.getInstance("AES/CCM/NoPadding");
                        try {
                            Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
                            this.mRsaCipher = instance;
                            instance.init(1, generatePublic);
                        } catch (NoSuchAlgorithmException e) {
                            throw new EncryptionException("Problem instantiation RSA Cipher Algorithm", e);
                        } catch (NoSuchPaddingException e2) {
                            throw new EncryptionException("Problem instantiation RSA Cipher Padding", e2);
                        } catch (InvalidKeyException e3) {
                            throw new EncryptionException("Invalid public key: " + str, e3);
                        }
                    } catch (NoSuchAlgorithmException e4) {
                        throw new EncryptionException("Problem instantiation AES Cipher Algorithm", e4);
                    } catch (NoSuchPaddingException e5) {
                        throw new EncryptionException("Problem instantiation AES Cipher Padding", e5);
                    }
                } catch (InvalidKeySpecException e6) {
                    throw new EncryptionException("Problem reading public key: " + str, e6);
                }
            } catch (NoSuchAlgorithmException e7) {
                throw new EncryptionException("RSA KeyFactory not found.", e7);
            }
        } else {
            throw new EncryptionException("Invalid public key: " + str, (Throwable) null);
        }
    }

    public String encrypt(String str) throws EncryptionException {
        SecretKey generateAesKey = generateAesKey();
        byte[] generateIV = generateIV();
        try {
            this.mAesCipher.init(1, generateAesKey, new IvParameterSpec(generateIV));
            byte[] doFinal = this.mAesCipher.doFinal(str.getBytes(Charsets.UTF_8));
            byte[] bArr = new byte[(generateIV.length + doFinal.length)];
            System.arraycopy(generateIV, 0, bArr, 0, generateIV.length);
            System.arraycopy(doFinal, 0, bArr, generateIV.length, doFinal.length);
            try {
                return String.format("%s%s%s%s%s%s", new Object[]{PREFIX, VERSION, SEPARATOR, Base64.encodeToString(this.mRsaCipher.doFinal(generateAesKey.getEncoded()), 2), SEPARATOR, Base64.encodeToString(bArr, 2)});
            } catch (IllegalBlockSizeException e) {
                throw new EncryptionException("Incorrect RSA Block Size", e);
            } catch (BadPaddingException e2) {
                throw new EncryptionException("Incorrect RSA Padding", e2);
            }
        } catch (IllegalBlockSizeException e3) {
            throw new EncryptionException("Incorrect AES Block Size", e3);
        } catch (BadPaddingException e4) {
            throw new EncryptionException("Incorrect AES Padding", e4);
        } catch (InvalidKeyException e5) {
            throw new EncryptionException("Invalid AES Key", e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new EncryptionException("Invalid AES Parameters", e6);
        }
    }

    private SecretKey generateAesKey() throws EncryptionException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            instance.init(256);
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptionException("Unable to get AES algorithm", e);
        }
    }

    private byte[] generateIV() {
        byte[] bArr = new byte[12];
        this.mSecureRandom.nextBytes(bArr);
        return bArr;
    }
}
