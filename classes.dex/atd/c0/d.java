package atd.c0;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class d extends SecretKeySpec {
    private final SecretKey a;
    private final Key b;

    public d(byte[] bArr, b bVar) {
        super(bArr, bVar.e());
        int length = bArr.length;
        int i = length / 2;
        this.a = new SecretKeySpec(Arrays.copyOfRange(bArr, i, length), bVar.e());
        this.b = new SecretKeySpec(Arrays.copyOfRange(bArr, 0, i), bVar.g());
    }

    public SecretKey a() {
        return this.a;
    }

    public Key b() {
        return this.b;
    }

    public d(SecretKey secretKey, b bVar) {
        this(secretKey.getEncoded(), bVar);
    }
}
