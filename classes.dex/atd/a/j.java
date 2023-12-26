package atd.a;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class j {
    private final Map<String, List<String>> a;
    private final byte[] b;

    public static final class a {
        int a;
        String b;
        Map<String, List<String>> c;
        byte[] d;

        public a a(int i) {
            this.a = i;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(Map<String, List<String>> map) {
            this.c = map;
            return this;
        }

        public a a(byte[] bArr) {
            this.d = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public j a() {
            return new j(this);
        }
    }

    j(a aVar) {
        int i = aVar.a;
        String str = aVar.b;
        this.a = aVar.c;
        this.b = aVar.d;
    }

    public byte[] a() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    public Map<String, List<String>> b() {
        return this.a;
    }
}
