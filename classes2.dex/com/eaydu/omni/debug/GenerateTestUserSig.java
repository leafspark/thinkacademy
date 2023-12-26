package com.eaydu.omni.debug;

import android.util.Base64;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class GenerateTestUserSig {
    private static final int EXPIRETIME = 604800;
    public static final String SECRETKEY = "217a9b4a174649a8a41ea7166faa8666e0973a3312ef9b20ad1ad52e9bbb5e94";

    public static String genTestUserSig(String str) {
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String GenTLSSignature(long r15, java.lang.String r17, long r18, byte[] r20, java.lang.String r21) {
        /*
            r1 = r20
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r9 = r2 / r4
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r0 = "TLS.ver"
            java.lang.String r3 = "2.0"
            r2.put(r0, r3)     // Catch:{ JSONException -> 0x0037 }
            java.lang.String r0 = "TLS.identifier"
            r3 = r17
            r2.put(r0, r3)     // Catch:{ JSONException -> 0x0034 }
            java.lang.String r0 = "TLS.sdkappid"
            r4 = r15
            r2.put(r0, r4)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r0 = "TLS.expire"
            r11 = r18
            r2.put(r0, r11)     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r0 = "TLS.time"
            r2.put(r0, r9)     // Catch:{ JSONException -> 0x0030 }
            goto L_0x0040
        L_0x0030:
            r0 = move-exception
            goto L_0x003d
        L_0x0032:
            r0 = move-exception
            goto L_0x003b
        L_0x0034:
            r0 = move-exception
            r4 = r15
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            r4 = r15
            r3 = r17
        L_0x003b:
            r11 = r18
        L_0x003d:
            r0.printStackTrace()
        L_0x0040:
            r0 = 0
            if (r1 == 0) goto L_0x0054
            r0 = 2
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r0)
            java.lang.String r0 = "TLS.userbuf"
            r2.put(r0, r1)     // Catch:{ JSONException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            r14 = r1
            goto L_0x0055
        L_0x0054:
            r14 = r0
        L_0x0055:
            r6 = r15
            r8 = r17
            r11 = r18
            r13 = r21
            java.lang.String r0 = hmacsha256(r6, r8, r9, r11, r13, r14)
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0069
            java.lang.String r0 = ""
            return r0
        L_0x0069:
            java.lang.String r1 = "TLS.sig"
            r2.put(r1, r0)     // Catch:{ JSONException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0073:
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            r0.<init>()
            boolean r1 = r2 instanceof org.json.JSONObject
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = r2.toString()
            goto L_0x0087
        L_0x0081:
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            java.lang.String r1 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r2)
        L_0x0087:
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
            byte[] r1 = r1.getBytes(r2)
            r0.setInput(r1)
            r0.finish()
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]
            int r2 = r0.deflate(r1)
            r0.end()
            java.lang.String r0 = new java.lang.String
            r3 = 0
            byte[] r1 = java.util.Arrays.copyOfRange(r1, r3, r2)
            byte[] r1 = base64EncodeUrl(r1)
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.debug.GenerateTestUserSig.GenTLSSignature(long, java.lang.String, long, byte[], java.lang.String):java.lang.String");
    }

    private static String hmacsha256(long j, String str, long j2, long j3, String str2, String str3) {
        String str4 = "TLS.identifier:" + str + "\nTLS.sdkappid:" + j + "\nTLS.time:" + j2 + "\nTLS.expire:" + j3 + "\n";
        if (str3 != null) {
            str4 = str4 + "TLS.userbuf:" + str3 + "\n";
        }
        try {
            byte[] bytes = str2.getBytes(Key.STRING_CHARSET_NAME);
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(bytes, "HmacSHA256"));
            return new String(Base64.encode(instance.doFinal(str4.getBytes(Key.STRING_CHARSET_NAME)), 2));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static byte[] base64EncodeUrl(byte[] bArr) {
        byte[] bytes = new String(Base64.encode(bArr, 2)).getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (b == 43) {
                bytes[i] = 42;
            } else if (b == 47) {
                bytes[i] = 45;
            } else if (b == 61) {
                bytes[i] = 95;
            }
        }
        return bytes;
    }
}
