package com.igexin.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.a.a.j;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class i {
    protected final Set<String> a;
    protected final f b;
    protected final e c;
    protected boolean d;
    protected boolean e;
    protected h f;

    protected i() {
        this(new k(), new a());
    }

    protected i(f fVar, e eVar) {
        this.a = new HashSet();
        if (fVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (eVar != null) {
            this.b = fVar;
            this.c = eVar;
        } else {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
    }

    private void c(Context context, String str, String str2) {
        j jVar;
        j jVar2;
        if (!this.a.contains(str) || this.d) {
            try {
                this.b.a(str);
                this.a.add(str);
                a("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e2) {
                a("Loading the library normally failed: %s", Log.getStackTraceString(e2));
                a("%s (%s) was not loaded normally, re-linking...", str, str2);
                File a2 = a(context, str, str2);
                if (!a2.exists() || this.d) {
                    if (this.d) {
                        a("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    b(context, str, str2);
                    this.c.a(context, this.b.a(), this.b.c(str), a2, this);
                }
                try {
                    if (this.e) {
                        jVar = null;
                        jVar2 = new j(a2);
                        List<String> b2 = jVar2.b();
                        jVar2.close();
                        for (String d2 : b2) {
                            a(context, this.b.d(d2));
                        }
                    }
                } catch (IOException unused) {
                }
                this.b.b(a2.getAbsolutePath());
                this.a.add(str);
                a("%s (%s) was re-linked!", str, str2);
            } catch (Throwable th) {
                th = th;
                jVar = jVar2;
                jVar.close();
                throw th;
            }
        } else {
            a("%s already loaded previously!", str);
        }
    }

    public i a() {
        this.d = true;
        return this;
    }

    public i a(h hVar) {
        this.f = hVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    /* access modifiers changed from: protected */
    public File a(Context context, String str, String str2) {
        String c2 = this.b.c(str);
        if (TextUtils.isEmpty(str2)) {
            return new File(a(context), c2);
        }
        File a2 = a(context);
        return new File(a2, c2 + "." + str2);
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (g) null);
    }

    public void a(Context context, String str, String str2, g gVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!TextUtils.isEmpty(str)) {
            a("Beginning load of %s...", str);
            if (gVar == null) {
                c(context, str, str2);
                return;
            }
            try {
                c(context, str, str2);
                gVar.a();
            } catch (c | UnsatisfiedLinkError e2) {
                gVar.a(e2);
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    public void a(String str) {
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(str);
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }

    public i b() {
        this.e = true;
        return this;
    }

    /* access modifiers changed from: protected */
    public void b(Context context, String str, String str2) {
        File a2 = a(context);
        File a3 = a(context, str, str2);
        File[] listFiles = a2.listFiles(new j(this, this.b.c(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.d || !file.getAbsolutePath().equals(a3.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }
}
