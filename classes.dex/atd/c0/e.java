package atd.c0;

import java.util.Arrays;

public final class e {
    private final byte[] a;
    private final byte[] b;

    e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null) {
            Arrays.copyOf(bArr, bArr.length);
        }
        byte[] bArr4 = null;
        this.a = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : null;
        this.b = bArr3 != null ? Arrays.copyOf(bArr3, bArr3.length) : bArr4;
    }

    public byte[] a() {
        byte[] bArr = this.b;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public byte[] b() {
        byte[] bArr = this.a;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
