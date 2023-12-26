package org.apache.commons.fileupload.util.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class MimeUtility {
    private static final String BASE64_ENCODING_MARKER = "B";
    private static final String ENCODED_TOKEN_FINISHER = "?=";
    private static final String ENCODED_TOKEN_MARKER = "=?";
    private static final String LINEAR_WHITESPACE = " \t\r\n";
    private static final Map<String, String> MIME2JAVA;
    private static final String QUOTEDPRINTABLE_ENCODING_MARKER = "Q";
    private static final String US_ASCII_CHARSET = "US-ASCII";

    static {
        HashMap hashMap = new HashMap();
        MIME2JAVA = hashMap;
        hashMap.put("iso-2022-cn", "ISO2022CN");
        hashMap.put("iso-2022-kr", "ISO2022KR");
        hashMap.put("utf-8", "UTF8");
        hashMap.put("utf8", "UTF8");
        hashMap.put("ja_jp.iso2022-7", "ISO2022JP");
        hashMap.put("ja_jp.eucjp", "EUCJIS");
        hashMap.put("euc-kr", "KSC5601");
        hashMap.put("euckr", "KSC5601");
        hashMap.put("us-ascii", "ISO-8859-1");
        hashMap.put("x-us-ascii", "ISO-8859-1");
    }

    private MimeUtility() {
    }

    public static String decodeText(String str) throws UnsupportedEncodingException {
        if (str.indexOf(ENCODED_TOKEN_MARKER) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (i < length) {
            if (LINEAR_WHITESPACE.indexOf(str.charAt(i)) != -1) {
                int i4 = i;
                while (true) {
                    if (i4 < length) {
                        if (LINEAR_WHITESPACE.indexOf(str.charAt(i4)) == -1) {
                            i3 = i4;
                            i2 = i;
                            i = i3;
                            break;
                        }
                        i4++;
                    } else {
                        int i5 = i4;
                        i2 = i;
                        i = i5;
                        break;
                    }
                }
            } else {
                int i6 = i;
                while (i6 < length && LINEAR_WHITESPACE.indexOf(str.charAt(i6)) == -1) {
                    i6++;
                }
                String substring = str.substring(i, i6);
                if (substring.startsWith(ENCODED_TOKEN_MARKER)) {
                    try {
                        String decodeWord = decodeWord(substring);
                        if (!z && i2 != -1) {
                            sb.append(str.substring(i2, i3));
                            i2 = -1;
                        }
                        sb.append(decodeWord);
                        z = true;
                    } catch (ParseException unused) {
                    }
                    i = i6;
                }
                if (i2 != -1) {
                    sb.append(str.substring(i2, i3));
                    i2 = -1;
                }
                sb.append(substring);
                z = false;
                i = i6;
            }
        }
        return sb.toString();
    }

    private static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        if (str.startsWith(ENCODED_TOKEN_MARKER)) {
            int indexOf = str.indexOf(63, 2);
            if (indexOf != -1) {
                String lowerCase = str.substring(2, indexOf).toLowerCase(Locale.ENGLISH);
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(63, i);
                if (indexOf2 != -1) {
                    String substring = str.substring(i, indexOf2);
                    int i2 = indexOf2 + 1;
                    int indexOf3 = str.indexOf(ENCODED_TOKEN_FINISHER, i2);
                    if (indexOf3 != -1) {
                        String substring2 = str.substring(i2, indexOf3);
                        if (substring2.length() == 0) {
                            return "";
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(substring2.length());
                            byte[] bytes = substring2.getBytes("US-ASCII");
                            if (substring.equals(BASE64_ENCODING_MARKER)) {
                                Base64Decoder.decode(bytes, byteArrayOutputStream);
                            } else if (substring.equals(QUOTEDPRINTABLE_ENCODING_MARKER)) {
                                QuotedPrintableDecoder.decode(bytes, byteArrayOutputStream);
                            } else {
                                throw new UnsupportedEncodingException("Unknown RFC 2047 encoding: " + substring);
                            }
                            return new String(byteArrayOutputStream.toByteArray(), javaCharset(lowerCase));
                        } catch (IOException unused) {
                            throw new UnsupportedEncodingException("Invalid RFC 2047 encoding");
                        }
                    } else {
                        throw new ParseException("Missing encoded text in RFC 2047 encoded-word: " + str);
                    }
                } else {
                    throw new ParseException("Missing encoding in RFC 2047 encoded-word: " + str);
                }
            } else {
                throw new ParseException("Missing charset in RFC 2047 encoded-word: " + str);
            }
        } else {
            throw new ParseException("Invalid RFC 2047 encoded-word: " + str);
        }
    }

    private static String javaCharset(String str) {
        if (str == null) {
            return null;
        }
        String str2 = MIME2JAVA.get(str.toLowerCase(Locale.ENGLISH));
        return str2 == null ? str : str2;
    }
}
