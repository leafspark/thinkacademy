package io.ktor.util;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lio/ktor/util/DigestImpl;", "Lio/ktor/util/Digest;", "delegate", "Ljava/security/MessageDigest;", "constructor-impl", "(Ljava/security/MessageDigest;)Ljava/security/MessageDigest;", "getDelegate", "()Ljava/security/MessageDigest;", "build", "", "build-impl", "(Ljava/security/MessageDigest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "", "equals-impl", "(Ljava/security/MessageDigest;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/security/MessageDigest;)I", "plusAssign", "", "bytes", "plusAssign-impl", "(Ljava/security/MessageDigest;[B)V", "reset", "reset-impl", "(Ljava/security/MessageDigest;)V", "toString", "", "toString-impl", "(Ljava/security/MessageDigest;)Ljava/lang/String;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: CryptoJvm.kt */
final class DigestImpl implements Digest {
    private final MessageDigest delegate;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DigestImpl m6boximpl(MessageDigest messageDigest) {
        return new DigestImpl(messageDigest);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static MessageDigest m8constructorimpl(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "delegate");
        return messageDigest;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m9equalsimpl(MessageDigest messageDigest, Object obj) {
        return (obj instanceof DigestImpl) && Intrinsics.areEqual(messageDigest, ((DigestImpl) obj).m15unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10equalsimpl0(MessageDigest messageDigest, MessageDigest messageDigest2) {
        return Intrinsics.areEqual(messageDigest, messageDigest2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m11hashCodeimpl(MessageDigest messageDigest) {
        return messageDigest.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m14toStringimpl(MessageDigest messageDigest) {
        return "DigestImpl(delegate=" + messageDigest + ')';
    }

    public boolean equals(Object obj) {
        return m9equalsimpl(this.delegate, obj);
    }

    public int hashCode() {
        return m11hashCodeimpl(this.delegate);
    }

    public String toString() {
        return m14toStringimpl(this.delegate);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ MessageDigest m15unboximpl() {
        return this.delegate;
    }

    private /* synthetic */ DigestImpl(MessageDigest messageDigest) {
        this.delegate = messageDigest;
    }

    public final MessageDigest getDelegate() {
        return this.delegate;
    }

    public void plusAssign(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        m12plusAssignimpl(this.delegate, bArr);
    }

    /* renamed from: plusAssign-impl  reason: not valid java name */
    public static void m12plusAssignimpl(MessageDigest messageDigest, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        messageDigest.update(bArr);
    }

    public void reset() {
        m13resetimpl(this.delegate);
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static void m13resetimpl(MessageDigest messageDigest) {
        messageDigest.reset();
    }

    /* renamed from: build-impl  reason: not valid java name */
    public static Object m7buildimpl(MessageDigest messageDigest, Continuation<? super byte[]> continuation) {
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "delegate.digest()");
        return digest;
    }

    public Object build(Continuation<? super byte[]> continuation) {
        return m7buildimpl(this.delegate, continuation);
    }
}
