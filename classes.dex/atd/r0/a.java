package atd.r0;

import android.util.Base64;
import com.adyen.threeds2.internal.b;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final Charset c = b.a;
    private final Charset a;
    private final int b;

    private a(Charset charset, int i) {
        this.a = charset;
        this.b = i;
    }

    public static a a() {
        return a(c, 11);
    }

    private byte[] e(String str) {
        return str.getBytes(this.a);
    }

    public Charset b() {
        return this.a;
    }

    public byte[] c(byte[] bArr) {
        return Base64.encode(bArr, this.b);
    }

    public String d(byte[] bArr) {
        return e(c(bArr));
    }

    public static a a(Charset charset) {
        return a(charset, 11);
    }

    private String e(byte[] bArr) {
        return new String(bArr, this.a);
    }

    public String b(byte[] bArr) {
        return new String(a(bArr), this.a);
    }

    public String c(String str) {
        return b(str.getBytes(this.a));
    }

    public String d(String str) {
        return d(str.getBytes(this.a));
    }

    public static a a(Charset charset, int... iArr) {
        int i = 0;
        if (iArr != null) {
            int length = iArr.length;
            int i2 = 0;
            while (i < length) {
                i2 |= iArr[i];
                i++;
            }
            i = i2;
        }
        return new a(charset, i);
    }

    public JSONObject b(String str) throws JSONException {
        return new JSONObject(c(str));
    }

    public byte[] a(byte[] bArr) {
        return Base64.decode(bArr, this.b);
    }

    public byte[] a(String str) {
        return a(e(str));
    }
}
