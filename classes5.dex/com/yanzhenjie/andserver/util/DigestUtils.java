package com.yanzhenjie.andserver.util;

import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    private static final String MD5_ALGORITHM_NAME = "MD5";

    public static byte[] md5Digest(String str) {
        return md5Digest(str.getBytes());
    }

    public static byte[] md5Digest(byte[] bArr) {
        return digest(MD5_ALGORITHM_NAME, bArr);
    }

    public static byte[] md5Digest(InputStream inputStream) throws IOException {
        return digest(MD5_ALGORITHM_NAME, inputStream);
    }

    public static String md5DigestAsHex(String str) {
        return md5DigestAsHex(str.getBytes());
    }

    public static String md5DigestAsHex(byte[] bArr) {
        return digestAsHexString(MD5_ALGORITHM_NAME, bArr);
    }

    public static String md5DigestAsHex(InputStream inputStream) throws IOException {
        return digestAsHexString(MD5_ALGORITHM_NAME, inputStream);
    }

    public static StringBuilder appendMd5DigestAsHex(byte[] bArr, StringBuilder sb) {
        return appendDigestAsHex(MD5_ALGORITHM_NAME, bArr, sb);
    }

    public static StringBuilder appendMd5DigestAsHex(InputStream inputStream, StringBuilder sb) throws IOException {
        return appendDigestAsHex(MD5_ALGORITHM_NAME, inputStream, sb);
    }

    private static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Could not find MessageDigest with algorithm \"" + str + "\"", e);
        }
    }

    private static byte[] digest(String str, byte[] bArr) {
        return getDigest(str).digest(bArr);
    }

    private static byte[] digest(String str, InputStream inputStream) throws IOException {
        MessageDigest digest = getDigest(str);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return digest.digest();
            }
            digest.update(bArr, 0, read);
        }
    }

    private static String digestAsHexString(String str, byte[] bArr) {
        return new String(digestAsHexChars(str, bArr));
    }

    private static String digestAsHexString(String str, InputStream inputStream) throws IOException {
        return new String(digestAsHexChars(str, inputStream));
    }

    private static StringBuilder appendDigestAsHex(String str, byte[] bArr, StringBuilder sb) {
        sb.append(digestAsHexChars(str, bArr));
        return sb;
    }

    private static StringBuilder appendDigestAsHex(String str, InputStream inputStream, StringBuilder sb) throws IOException {
        sb.append(digestAsHexChars(str, inputStream));
        return sb;
    }

    private static char[] digestAsHexChars(String str, byte[] bArr) {
        return encodeHex(digest(str, bArr));
    }

    private static char[] digestAsHexChars(String str, InputStream inputStream) throws IOException {
        return encodeHex(digest(str, inputStream));
    }

    private static char[] encodeHex(byte[] bArr) {
        char[] cArr = new char[32];
        for (int i = 0; i < 32; i += 2) {
            byte b = bArr[i / 2];
            char[] cArr2 = HEX_CHARS;
            cArr[i] = cArr2[(b >>> 4) & 15];
            cArr[i + 1] = cArr2[b & 15];
        }
        return cArr;
    }
}
