package org.extra.relinker;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.extra.relinker.c;
import org.extra.relinker.elf.i;

public class d {
    protected final Set a;
    protected final c.b b;
    protected final c.a c;
    protected boolean d;
    protected boolean e;

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        a(Context context, String str, String str2, c.C0001c cVar) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        public void run() {
            try {
                d.this.c(this.a, this.b, this.c);
                throw null;
            } catch (UnsatisfiedLinkError unused) {
                throw null;
            } catch (b unused2) {
                throw null;
            }
        }
    }

    class b implements FilenameFilter {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.a);
        }
    }

    protected d() {
        this(new e(), new a());
    }

    /* access modifiers changed from: private */
    public void c(Context context, String str, String str2) {
        i iVar;
        i iVar2;
        if (!this.a.contains(str) || this.d) {
            try {
                this.b.a(str);
                this.a.add(str);
                a("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e2) {
                a("Loading the library normally failed: %s", Log.getStackTraceString(e2));
                a("%s (%s) was not loaded normally, re-linking...", str, str2);
                File b2 = b(context, str, str2);
                if (!b2.exists() || this.d) {
                    if (this.d) {
                        a("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    a(context, str, str2);
                    this.c.a(context, this.b.a(), this.b.d(str), b2, this);
                }
                try {
                    if (this.e) {
                        iVar = null;
                        iVar2 = new i(b2);
                        List<String> b3 = iVar2.b();
                        iVar2.close();
                        for (String b4 : b3) {
                            a(context, this.b.b(b4));
                        }
                    }
                } catch (IOException unused) {
                }
                this.b.c(b2.getAbsolutePath());
                this.a.add(str);
                a("%s (%s) was re-linked!", str, str2);
            } catch (Throwable th) {
                th = th;
                iVar = iVar2;
                iVar.close();
                throw th;
            }
        } else {
            a("%s already loaded previously!", str);
        }
    }

    public void a(String str) {
    }

    /* access modifiers changed from: protected */
    public File b(Context context, String str, String str2) {
        String d2 = this.b.d(str);
        if (f.a(str2)) {
            return new File(a(context), d2);
        }
        File a2 = a(context);
        return new File(a2, d2 + "." + str2);
    }

    protected d(c.b bVar, c.a aVar) {
        this.a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (aVar != null) {
            this.b = bVar;
            this.c = aVar;
        } else {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (c.C0001c) null);
    }

    public void a(Context context, String str, String str2, c.C0001c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!f.a(str)) {
            a("Beginning load of %s...", str);
            if (cVar == null) {
                c(context, str, str2);
                return;
            }
            try {
                new Thread(new a(context, str, str2, cVar)).start();
            } catch (Error | Exception e2) {
                cVar.a(e2);
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    /* access modifiers changed from: protected */
    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str, String str2) {
        File a2 = a(context);
        File b2 = b(context, str, str2);
        File[] listFiles = a2.listFiles(new b(this.b.d(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.d || !file.getAbsolutePath().equals(b2.getAbsolutePath())) {
                    try {
                        file.delete();
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }
}
