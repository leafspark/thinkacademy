package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.services.s3.model.CryptoMode;
import java.security.SecureRandom;

@Deprecated
final class S3CryptoScheme {
    static final String AES = "AES";
    static final String RSA = "RSA";
    private static final SecureRandom SRAND = new SecureRandom();
    private final ContentCryptoScheme contentCryptoScheme;
    private final S3KeyWrapScheme kwScheme;

    S3CryptoScheme(ContentCryptoScheme contentCryptoScheme2) {
        this.contentCryptoScheme = contentCryptoScheme2;
        this.kwScheme = new S3KeyWrapScheme();
    }

    private S3CryptoScheme(ContentCryptoScheme contentCryptoScheme2, S3KeyWrapScheme s3KeyWrapScheme) {
        this.contentCryptoScheme = contentCryptoScheme2;
        this.kwScheme = s3KeyWrapScheme;
    }

    /* access modifiers changed from: package-private */
    public SecureRandom getSecureRandom() {
        return SRAND;
    }

    /* access modifiers changed from: package-private */
    public ContentCryptoScheme getContentCryptoScheme() {
        return this.contentCryptoScheme;
    }

    /* access modifiers changed from: package-private */
    public S3KeyWrapScheme getKeyWrapScheme() {
        return this.kwScheme;
    }

    static boolean isAesGcm(String str) {
        return ContentCryptoScheme.AES_GCM.getCipherAlgorithm().equals(str);
    }

    /* renamed from: com.amazonaws.services.s3.internal.crypto.S3CryptoScheme$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$services$s3$model$CryptoMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.amazonaws.services.s3.model.CryptoMode[] r0 = com.amazonaws.services.s3.model.CryptoMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$amazonaws$services$s3$model$CryptoMode = r0
                com.amazonaws.services.s3.model.CryptoMode r1 = com.amazonaws.services.s3.model.CryptoMode.EncryptionOnly     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$amazonaws$services$s3$model$CryptoMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazonaws.services.s3.model.CryptoMode r1 = com.amazonaws.services.s3.model.CryptoMode.AuthenticatedEncryption     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$amazonaws$services$s3$model$CryptoMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazonaws.services.s3.model.CryptoMode r1 = com.amazonaws.services.s3.model.CryptoMode.StrictAuthenticatedEncryption     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.crypto.S3CryptoScheme.AnonymousClass1.<clinit>():void");
        }
    }

    static S3CryptoScheme from(CryptoMode cryptoMode) {
        int i = AnonymousClass1.$SwitchMap$com$amazonaws$services$s3$model$CryptoMode[cryptoMode.ordinal()];
        if (i == 1) {
            return new S3CryptoScheme(ContentCryptoScheme.AES_CBC, S3KeyWrapScheme.NONE);
        }
        if (i == 2 || i == 3) {
            return new S3CryptoScheme(ContentCryptoScheme.AES_GCM, new S3KeyWrapScheme());
        }
        throw new IllegalStateException();
    }
}
