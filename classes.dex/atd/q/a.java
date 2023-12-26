package atd.q;

import android.content.Context;
import atd.i.b;
import atd.i.c;

public abstract class a implements b {
    private final String a;
    private final String b;
    private C0005a c;

    /* renamed from: atd.q.a$a  reason: collision with other inner class name */
    protected enum C0005a {
        STRING,
        FLOAT,
        INTEGER,
        LONG
    }

    protected a(String str, String str2) {
        this(str, str2, C0005a.STRING);
    }

    public String a() {
        return this.a;
    }

    public a b() {
        this.c = C0005a.FLOAT;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract Object b(Context context) throws c;

    public a c() {
        this.c = C0005a.INTEGER;
        return this;
    }

    public a d() {
        this.c = C0005a.LONG;
        return this;
    }

    public String e() {
        return this.b;
    }

    public C0005a f() {
        return this.c;
    }

    private a(String str, String str2, C0005a aVar) {
        this.a = str;
        this.b = str2;
        this.c = aVar;
    }

    public Object a(Context context) throws c {
        return b(context);
    }
}
