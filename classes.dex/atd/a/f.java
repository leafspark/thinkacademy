package atd.a;

import atd.s0.a;

public enum f {
    GET(a.a(-102622612482624L), false),
    POST(a.a(-102652677253696L), true);
    
    private boolean mDoOutput;
    private String mValue;

    private f(String str, boolean z) {
        this.mValue = str;
        this.mDoOutput = z;
    }

    public static boolean a(f fVar) {
        return !fVar.equals(GET);
    }

    public static boolean b(f fVar) {
        return fVar.equals(POST);
    }

    public String a() {
        return this.mValue;
    }

    public boolean b() {
        return this.mDoOutput;
    }
}
