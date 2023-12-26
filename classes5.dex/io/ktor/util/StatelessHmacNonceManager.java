package io.ktor.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\nB1\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lio/ktor/util/StatelessHmacNonceManager;", "Lio/ktor/util/NonceManager;", "key", "", "algorithm", "", "timeoutMillis", "", "nonceGenerator", "Lkotlin/Function0;", "([BLjava/lang/String;JLkotlin/jvm/functions/Function0;)V", "keySpec", "Ljavax/crypto/spec/SecretKeySpec;", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLkotlin/jvm/functions/Function0;)V", "getAlgorithm", "()Ljava/lang/String;", "getKeySpec", "()Ljavax/crypto/spec/SecretKeySpec;", "macLength", "", "getNonceGenerator", "()Lkotlin/jvm/functions/Function0;", "getTimeoutMillis", "()J", "newNonce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyNonce", "", "nonce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StatelessHmacNonceManager.kt */
public final class StatelessHmacNonceManager implements NonceManager {
    private final String algorithm;
    private final SecretKeySpec keySpec;
    private final int macLength;
    private final Function0<String> nonceGenerator;
    private final long timeoutMillis;

    public StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(secretKeySpec, "keySpec");
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(function0, "nonceGenerator");
        this.keySpec = secretKeySpec;
        this.algorithm = str;
        this.timeoutMillis = j;
        this.nonceGenerator = function0;
        Mac instance = Mac.getInstance(str);
        instance.init(secretKeySpec);
        this.macLength = instance.getMacLength();
    }

    public final SecretKeySpec getKeySpec() {
        return this.keySpec;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretKeySpec, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000 : j, (Function0<String>) (i & 8) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public final Function0<String> getNonceGenerator() {
        return this.nonceGenerator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000 : j, (Function0<String>) (i & 8) != 0 ? AnonymousClass2.INSTANCE : function0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager(byte[] bArr, String str, long j, Function0<String> function0) {
        this(new SecretKeySpec(bArr, str), str, j, function0);
        Intrinsics.checkNotNullParameter(bArr, "key");
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(function0, "nonceGenerator");
    }

    public Object newNonce(Continuation<? super String> continuation) {
        String str = (String) this.nonceGenerator.invoke();
        String l = Long.toString(System.nanoTime(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(l, "toString(this, checkRadix(radix))");
        String padStart = StringsKt.padStart(l, 16, '0');
        Mac instance = Mac.getInstance(this.algorithm);
        instance.init(this.keySpec);
        byte[] bytes = (str + ':' + padStart).getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        instance.update(bytes);
        byte[] doFinal = instance.doFinal();
        Intrinsics.checkNotNullExpressionValue(doFinal, "getInstance(algorithm).a…)\n            }.doFinal()");
        String hex = CryptoKt.hex(doFinal);
        return str + '+' + padStart + '+' + hex;
    }

    public Object verifyNonce(String str, Continuation<? super Boolean> continuation) {
        boolean z = true;
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{'+'}, false, 0, 6, (Object) null);
        if (split$default.size() != 3) {
            return Boxing.boxBoolean(false);
        }
        String str2 = (String) split$default.get(0);
        String str3 = (String) split$default.get(1);
        String str4 = (String) split$default.get(2);
        if (str2.length() < 8) {
            return Boxing.boxBoolean(false);
        }
        if (str4.length() != this.macLength * 2) {
            return Boxing.boxBoolean(false);
        }
        if (str3.length() != 16) {
            return Boxing.boxBoolean(false);
        }
        if (Long.parseLong(str3, CharsKt.checkRadix(16)) + TimeUnit.MILLISECONDS.toNanos(this.timeoutMillis) < System.nanoTime()) {
            return Boxing.boxBoolean(false);
        }
        Mac instance = Mac.getInstance(this.algorithm);
        instance.init(this.keySpec);
        byte[] bytes = (str2 + ':' + str3).getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        instance.update(bytes);
        byte[] doFinal = instance.doFinal();
        Intrinsics.checkNotNullExpressionValue(doFinal, "getInstance(algorithm).a…)\n            }.doFinal()");
        String hex = CryptoKt.hex(doFinal);
        int min = Math.min(hex.length(), str4.length());
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            if (hex.charAt(i2) == str4.charAt(i2)) {
                i++;
            }
        }
        if (i != this.macLength * 2) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }
}
