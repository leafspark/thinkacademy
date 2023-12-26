package atd.i0;

import atd.s0.a;
import com.adyen.threeds2.internal.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class c {
    public static byte[] a(byte[] bArr, int i, String str, String str2, String str3) {
        byte[] a = a(1);
        byte[] a2 = a(str);
        byte[] a3 = a(str2);
        byte[] a4 = a(str3);
        byte[] a5 = a(i);
        byte[] bArr2 = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(a);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(a2);
            byteArrayOutputStream.write(a3);
            byteArrayOutputStream.write(a4);
            byteArrayOutputStream.write(a5);
            byteArrayOutputStream.write(bArr2);
            try {
                MessageDigest instance = MessageDigest.getInstance(a.a(-796599133203008L));
                instance.update(byteArrayOutputStream.toByteArray());
                return Arrays.copyOf(instance.digest(), i / 8);
            } catch (NoSuchAlgorithmException e) {
                throw atd.y.c.CRYPTO_FAILURE.a(e);
            }
        } catch (IOException e2) {
            throw atd.y.c.CRYPTO_FAILURE.a(e2);
        }
    }

    private static byte[] a(String str) {
        if (str == null) {
            str = a.a(-796633492941376L);
        }
        return ByteBuffer.allocate(str.length() + 4).putInt(str.length()).put(str.getBytes(b.a)).array();
    }

    private static byte[] a(int i) {
        return ByteBuffer.allocate(4).putInt(i).array();
    }
}
