package atd.a;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public final class e {

    public static final class b {
        private final a a;
        private final Charset b;

        b(a aVar, Charset charset) {
            this.a = aVar;
            this.b = charset == null ? com.adyen.threeds2.internal.b.a : charset;
        }

        public Charset a() {
            return this.b;
        }

        public a b() {
            return this.a;
        }

        public String c() {
            return this.a.a() + atd.s0.a.a(-102317669804608L) + atd.s0.a.a(-102309079870016L) + atd.s0.a.a(-102343439608384L) + this.b.name();
        }

        public String toString() {
            return c();
        }
    }

    static {
        atd.s0.a.a(-102742871566912L);
        atd.s0.a.a(-102781526272576L);
        atd.s0.a.a(-102553893005888L);
        atd.s0.a.a(-102579662809664L);
        atd.s0.a.a(-102614022548032L);
    }

    public static b a(Map<String, List<String>> map) {
        List<String> list;
        b a2;
        if (map == null) {
            return null;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!(next == null || !atd.s0.a.a(-102369209412160L).equalsIgnoreCase((String) next.getKey()) || (list = (List) next.getValue()) == null)) {
                for (String str : list) {
                    if (str != null && (a2 = a(str.split(atd.s0.a.a(-102691331959360L)))) != null) {
                        return a2;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public enum a {
        APPLICATION_JSON(atd.s0.a.a(-103189548165696L)),
        APPLICATION_JOSE(atd.s0.a.a(-102528123202112L));
        
        private final String mValue;

        private a(String str) {
            this.mValue = str;
        }

        static a a(String str) {
            for (a aVar : values()) {
                if (aVar.mValue.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public String toString() {
            return this.mValue;
        }

        public String a() {
            return this.mValue;
        }

        public b a(Charset charset) {
            return new b(this, charset);
        }
    }

    private static b a(String... strArr) {
        Charset charset;
        a aVar;
        if (strArr.length > 0) {
            aVar = a.a(strArr[0]);
            if (aVar == null) {
                return null;
            }
            charset = strArr.length > 1 ? a(strArr[1]) : null;
        } else {
            charset = null;
            aVar = null;
        }
        if (aVar != null) {
            return aVar.a(charset);
        }
        return null;
    }

    private static Charset a(String str) {
        String[] split = str.split(atd.s0.a.a(-102717101763136L));
        if (split.length > 1 && atd.s0.a.a(-102708511828544L).equalsIgnoreCase(split[0])) {
            try {
                return Charset.forName(split[1]);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
