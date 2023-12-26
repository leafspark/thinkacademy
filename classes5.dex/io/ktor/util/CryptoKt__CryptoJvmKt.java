package io.ktor.util;

import io.ktor.http.ContentDisposition;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\r\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u0006\u001a1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0002¢\u0006\u0002\b\r\u001a=\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\n\u001a\u00020\u00032!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0002\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\f\u001a\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b¨\u0006\u0013"}, d2 = {"Digest", "Lio/ktor/util/Digest;", "name", "", "generateNonce", "generateNonceBlocking", "generateNonceBlocking$CryptoKt__CryptoJvmKt", "getDigest", "", "text", "algorithm", "salt", "Lkotlin/Function1;", "getDigest$CryptoKt__CryptoJvmKt", "getDigestFunction", "Lkotlin/ParameterName;", "value", "sha1", "bytes", "ktor-utils"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
/* compiled from: CryptoJvm.kt */
final /* synthetic */ class CryptoKt__CryptoJvmKt {
    public static final Function1<String, byte[]> getDigestFunction(String str, Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(function1, "salt");
        return (Function1) new CryptoKt__CryptoJvmKt$getDigestFunction$1(str, function1);
    }

    /* access modifiers changed from: private */
    public static final byte[] getDigest$CryptoKt__CryptoJvmKt(String str, String str2, Function1<? super String, String> function1) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        byte[] bytes = ((String) function1.invoke(str)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        instance.update(bytes);
        byte[] bytes2 = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes2);
        Intrinsics.checkNotNullExpressionValue(digest, "with(MessageDigest.getIn…text.toByteArray())\n    }");
        return digest;
    }

    public static final byte[] sha1(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
        Intrinsics.checkNotNullExpressionValue(digest, "getInstance(\"SHA1\").digest(bytes)");
        return digest;
    }

    public static final Digest Digest(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        MessageDigest instance = MessageDigest.getInstance(str);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(name)");
        return DigestImpl.m6boximpl(DigestImpl.m8constructorimpl(instance));
    }

    public static final String generateNonce() {
        String str = (String) ChannelResult.getOrNull-impl(NonceKt.getSeedChannel().tryReceive-PtdJZtk());
        if (str != null) {
            return str;
        }
        return generateNonceBlocking$CryptoKt__CryptoJvmKt();
    }

    private static final String generateNonceBlocking$CryptoKt__CryptoJvmKt() {
        NonceKt.ensureNonceGeneratorRunning();
        return (String) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new CryptoKt__CryptoJvmKt$generateNonceBlocking$1((Continuation<? super CryptoKt__CryptoJvmKt$generateNonceBlocking$1>) null), 1, (Object) null);
    }
}
