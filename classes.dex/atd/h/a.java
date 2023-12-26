package atd.h;

import java.util.ArrayList;
import java.util.List;

public enum a {
    V1_1(atd.s0.a.a(-86688283814464L), false),
    V1_4(atd.s0.a.a(-86718348585536L), true);
    
    private final boolean mActive;
    private final String mVersion;

    private a(String str, boolean z) {
        this.mVersion = str;
        this.mActive = z;
    }

    public static List<a> a() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : values()) {
            if (aVar.c()) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public String b() {
        return this.mVersion;
    }

    public boolean c() {
        return this.mActive;
    }

    public String toString() {
        return this.mVersion;
    }
}
