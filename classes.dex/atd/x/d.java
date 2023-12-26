package atd.x;

import atd.r0.g;
import atd.s0.a;
import atd.y.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static final Map<String, String> a = Collections.unmodifiableMap(a());

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(a.a(-582185775852096L), a.a(-581258062916160L));
        hashMap.put(a.a(-575532871510592L), a.a(-575429792295488L));
        hashMap.put(a.a(-572762617604672L), a.a(-572659538389568L));
        hashMap.put(a.a(-566144073001536L), a.a(-566040993786432L));
        hashMap.put(a.a(-629022394214976L), a.a(-629469070813760L));
        hashMap.put(a.a(-623009440000576L), a.a(-623181238692416L));
        hashMap.put(a.a(-617271363693120L), a.a(-617168284478016L));
        hashMap.put(a.a(-610343581444672L), a.a(-610515380136512L));
        hashMap.put(a.a(-604687109515840L), a.a(-604584030300736L));
        return hashMap;
    }

    public static String b(String str) {
        for (Map.Entry next : a.entrySet()) {
            if (a((String) next.getKey()).equalsIgnoreCase(str)) {
                return a((String) next.getValue());
            }
        }
        throw c.UNKNOWN_DIRECTORY_SERVER.a();
    }

    private static String a(String str) {
        return g.a(str);
    }
}
