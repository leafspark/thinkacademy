package atd.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i {
    private final String a;
    private final f b;
    private final Map<String, List<String>> c;
    private final byte[] d;

    i(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
    }

    public byte[] a() {
        byte[] bArr = this.d;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    public Map<String, List<String>> b() {
        return this.c;
    }

    public f c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public static final class a {
        String a;
        f b = f.GET;
        Map<String, List<String>> c = new HashMap();
        byte[] d;

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException(atd.s0.a.a(-101875288173120L));
            } else if (!str.isEmpty()) {
                this.a = str;
                return this;
            } else {
                throw new NullPointerException(atd.s0.a.a(-101922532813376L));
            }
        }

        public a b() {
            return a(f.GET, (byte[]) null);
        }

        public a a(Map<String, List<String>> map) {
            this.c = map;
            return this;
        }

        public a a(byte[] bArr) {
            return a(f.POST, bArr);
        }

        public a a(f fVar, byte[] bArr) {
            if (fVar == null) {
                throw new NullPointerException(atd.s0.a.a(-101759324056128L));
            } else if (bArr != null && !f.a(fVar)) {
                throw new IllegalArgumentException(atd.s0.a.a(-101828043532864L) + fVar + atd.s0.a.a(-102137281178176L));
            } else if (bArr != null || !f.b(fVar)) {
                this.b = fVar;
                this.d = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            } else {
                throw new IllegalArgumentException(atd.s0.a.a(-102004137192000L) + fVar + atd.s0.a.a(-102038496930368L));
            }
        }

        public i a() {
            if (this.a != null) {
                return new i(this);
            }
            throw new IllegalStateException(atd.s0.a.a(-101338417261120L));
        }
    }
}
