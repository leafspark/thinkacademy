package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    private static final int FOURTEEN = 14;
    private static final int SIXTEEN_K = 16384;

    public static byte[] computeMD5Hash(InputStream inputStream) throws IOException {
        Class<Md5Utils> cls = Md5Utils.class;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[SIXTEEN_K];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, SIXTEEN_K);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
                Log log = LogFactory.getLog(cls);
                log.debug("Unable to close input stream of hash candidate: " + e);
            }
            return digest;
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Exception e3) {
                Log log2 = LogFactory.getLog(cls);
                log2.debug("Unable to close input stream of hash candidate: " + e3);
            }
            throw th;
        }
    }

    public static String md5AsBase64(InputStream inputStream) throws IOException {
        return Base64.encodeAsString(computeMD5Hash(inputStream));
    }

    public static byte[] computeMD5Hash(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String md5AsBase64(byte[] bArr) {
        return Base64.encodeAsString(computeMD5Hash(bArr));
    }

    public static byte[] computeMD5Hash(File file) throws IOException {
        return computeMD5Hash((InputStream) new FileInputStream(file));
    }

    public static String md5AsBase64(File file) throws IOException {
        return Base64.encodeAsString(computeMD5Hash(file));
    }
}
