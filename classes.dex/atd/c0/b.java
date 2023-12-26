package atd.c0;

import atd.b0.a;
import atd.y.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public abstract class b extends a {
    b() {
    }

    public final byte[] a(d dVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (Arrays.equals(bArr4, a(dVar, bArr, bArr3, bArr2))) {
            return a(dVar, 2, bArr, bArr2);
        }
        throw new GeneralSecurityException(atd.s0.a.a(-799541185800768L));
    }

    public final byte[] b() {
        byte[] bArr = new byte[d()];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public abstract String c();

    public abstract int d();

    public abstract String e();

    public abstract int f();

    public abstract String g();

    public abstract int h();

    public final e b(d dVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] a = a(dVar, 1, bArr, bArr2);
        return new e(bArr, a, a(dVar, bArr, bArr3, a));
    }

    private byte[] a(d dVar, int i, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        SecretKey a = dVar.a();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher instance = Cipher.getInstance(c());
        instance.init(i, a, ivParameterSpec, new SecureRandom());
        return instance.doFinal(bArr2);
    }

    private byte[] a(d dVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] a = a(bArr2, bArr, bArr3);
        Mac instance = Mac.getInstance(g());
        instance.init(dVar.b());
        instance.update(a);
        return Arrays.copyOf(instance.doFinal(), h());
    }

    private byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c = atd.r0.a.a(Charset.forName(atd.s0.a.a(-799425221683776L))).c(bArr);
            byteArrayOutputStream.write(c);
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(a(c.length));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    private byte[] a(int i) {
        return ByteBuffer.allocate(8).putLong((long) (i * 8)).array();
    }
}
