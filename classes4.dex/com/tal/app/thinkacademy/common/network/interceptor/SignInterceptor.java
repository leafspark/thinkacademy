package com.tal.app.thinkacademy.common.network.interceptor;

import android.util.Base64;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.thinkacademy.encryptkey.EncryptKey;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/SignInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "sign", "", "key", "timestamp", "body", "", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignInterceptor.kt */
public final class SignInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEADER_SIGN = "x-tal-signature";
    private static final String HEADER_SIGN_TAG = "local-sign-tag";
    public static final String OPEN_LOCAL_SIGN = "local-sign-tag: true";
    private static final byte[] SIGN_ARRAY = {64, 107, 67, 66, 79, 119, 75, 105, 126, 53, 104, 108, 64, 107, 98, 109, 84, 75};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/SignInterceptor$Companion;", "", "()V", "HEADER_SIGN", "", "HEADER_SIGN_TAG", "OPEN_LOCAL_SIGN", "SIGN_ARRAY", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SignInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (!Intrinsics.areEqual(chain.request().header(HEADER_SIGN_TAG), "true")) {
            return chain.proceed(chain.request());
        }
        Request.Builder newBuilder = chain.request().newBuilder();
        newBuilder.removeHeader(HEADER_SIGN_TAG);
        RequestBody body = chain.request().body();
        if (body != null) {
            long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            String decryptString = EncryptKey.INSTANCE.decryptString(SIGN_ARRAY, 36);
            BufferedSink buffer = new Buffer();
            body.writeTo(buffer);
            String readString = buffer.readString(Charsets.UTF_8);
            XesLog.it("签名验证", Intrinsics.stringPlus("body : ", readString));
            String valueOf = String.valueOf(currentTimeMillis);
            byte[] bytes = readString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String sign = sign(decryptString, valueOf, bytes);
            XesLog.it("签名验证", Intrinsics.stringPlus("sign : ", sign));
            newBuilder.addHeader(HEADER_SIGN, sign);
        }
        return chain.proceed(newBuilder.build());
    }

    private final String sign(String str, String str2, byte[] bArr) {
        Mac instance = Mac.getInstance("HmacSHA256");
        byte[] bytes = Intrinsics.stringPlus(str, str2).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        instance.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] doFinal = instance.doFinal(bArr);
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(doFinal, "hmac");
        int length = doFinal.length;
        int i = 0;
        while (i < length) {
            byte b = doFinal[i];
            i++;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb.append(format);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "hexString.toString()");
        byte[] bytes2 = Intrinsics.stringPlus(sb2, str2).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes2, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "getInstance(\"HmacSHA256\"…Base64.NO_WRAP)\n        }");
        return encodeToString;
    }
}
