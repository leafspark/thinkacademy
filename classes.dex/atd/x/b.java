package atd.x;

import atd.r0.g;
import atd.s0.a;
import atd.y.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static final Map<String, List<String>> a = Collections.unmodifiableMap(a());

    private static Map<String, List<String>> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(a.a(-313114664692288L), Collections.singletonList(a.a(-312461829663296L)));
        hashMap.put(a.a(-351357053495872L), Collections.singletonList(a.a(-351803730094656L)));
        hashMap.put(a.a(-320639447394880L), Collections.singletonList(a.a(-320811246086720L)));
        hashMap.put(a.a(-501302951733824L), Arrays.asList(new String[]{a.a(-501199872518720L), a.a(-552430242425408L)}));
        hashMap.put(a.a(-452318849722944L), Collections.singletonList(a.a(-452215770507840L)));
        hashMap.put(a.a(-492369419758144L), Collections.singletonList(a.a(-491716584729152L)));
        hashMap.put(a.a(-473196685748800L), Collections.singletonList(a.a(-472268972812864L)));
        hashMap.put(a.a(-666002062633536L), Collections.singletonList(a.a(-666173861325376L)));
        hashMap.put(a.a(-636899364235840L), Collections.singletonList(a.a(-636246529206848L)));
        hashMap.put(a.a(-683078852602432L), Collections.singletonList(a.a(-682426017573440L)));
        return hashMap;
    }

    public static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : a.entrySet()) {
            if (a((String) next.getKey()).equalsIgnoreCase(str)) {
                for (String a2 : (List) next.getValue()) {
                    arrayList.add(a(a2));
                }
                return arrayList;
            }
        }
        throw c.UNKNOWN_DIRECTORY_SERVER.a();
    }

    private static String a(String str) {
        return g.a(str);
    }
}
