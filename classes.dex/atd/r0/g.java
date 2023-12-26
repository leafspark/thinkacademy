package atd.r0;

import atd.s0.a;
import java.nio.charset.Charset;
import java.util.Random;

public final class g {
    static {
        a.a(-840373439883840L);
    }

    public static String a(String str) {
        a a = a.a();
        Charset b = a.b();
        String[] split = a.c(str).split(a.a(-840382029818432L));
        return new String(a(a.c(split[0]).getBytes(b), a.c(split[1]).getBytes(b)), b);
    }

    public static String b(String str) {
        a a = a.a();
        byte[] bytes = str.getBytes(a.b());
        byte[] a2 = a(bytes.length);
        byte[] a3 = a(bytes, a2);
        String d = a.d(a2);
        String d2 = a.d(a3);
        return a.d(d + a.a(-840356260014656L) + d2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    private static byte[] a(int i) {
        byte[] bArr = new byte[i];
        new Random(System.currentTimeMillis()).nextBytes(bArr);
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (Math.abs(bArr[i2]) % 127);
        }
        return bArr;
    }
}
