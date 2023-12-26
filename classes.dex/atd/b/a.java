package atd.b;

import android.text.TextUtils;
import atd.a.e;
import atd.a.i;
import atd.d.i;
import atd.d.j;
import atd.e.c;
import atd.e.d;
import atd.f0.h;
import com.adyen.threeds2.internal.b;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class a extends atd.a.a {
    private static final int f = ((int) TimeUnit.SECONDS.toMillis(10));
    private static final int g = ((int) TimeUnit.SECONDS.toMillis(10));
    private static final Charset h = b.a;
    private final String d;
    private final atd.f0.a e;

    /* renamed from: atd.b.a$a  reason: collision with other inner class name */
    class C0001a implements Callable<j> {
        final /* synthetic */ i a;

        C0001a(i iVar) {
            this.a = iVar;
        }

        /* renamed from: a */
        public j call() throws atd.a0.a {
            return a.this.a(a.this.b(this.a), this.a);
        }
    }

    a(String str, atd.f0.a aVar) {
        this.d = str;
        this.e = aVar;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return g;
    }

    /* access modifiers changed from: package-private */
    public final Callable<j> c(i iVar) {
        return new C0001a(iVar);
    }

    /* access modifiers changed from: private */
    public j b(i iVar) throws atd.a0.a {
        try {
            try {
                return a(a(a(iVar)));
            } catch (SocketTimeoutException e2) {
                throw new atd.a0.a(atd.s0.a.a(-101162323601984L), e2, c.TRANSACTION_TIMED_OUT);
            } catch (IOException e3) {
                throw new atd.a0.a(atd.s0.a.a(-101291172620864L), e3, c.SYSTEM_CONNECTION_FAILURE);
            }
        } catch (GeneralSecurityException | JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* access modifiers changed from: protected */
    public int a() {
        return f;
    }

    private atd.a.i a(i iVar) throws JSONException, GeneralSecurityException {
        i.a a = new i.a().a(this.d);
        if (iVar.i()) {
            a.a(atd.f.a.a()).a(a(a((atd.f.b) iVar)));
        } else {
            a.a(atd.f.a.b()).a(a((atd.f.b) iVar));
        }
        return a.a();
    }

    private byte[] a(byte[] bArr) throws GeneralSecurityException {
        return this.e.a(bArr).e().getBytes(h);
    }

    private byte[] a(atd.f.b bVar) throws JSONException {
        JSONObject a = bVar.a();
        return (!(a instanceof JSONObject) ? a.toString() : JSONObjectInstrumentation.toString(a)).getBytes(h);
    }

    private j a(atd.a.j jVar) throws atd.a0.a {
        byte[] a = jVar.a();
        Charset charset = null;
        if (a == null || a.length <= 0) {
            return null;
        }
        e.b a2 = e.a(jVar.b());
        e.a b = a2 != null ? a2.b() : null;
        if (a2 != null) {
            charset = a2.a();
        }
        boolean z = b == e.a.APPLICATION_JOSE;
        if (z) {
            try {
                a = a(a, charset);
            } catch (GeneralSecurityException e2) {
                throw new atd.a0.a(atd.s0.a.a(-101673424710208L), e2, c.DATA_DECRYPTION_FAILURE);
            }
        }
        if (z || b == e.a.APPLICATION_JSON) {
            try {
                j a3 = j.a(b(a, charset));
                if (z || !a3.f()) {
                    return a3;
                }
                throw new atd.a0.a(atd.s0.a.a(-100719941970496L), c.MESSAGE_RECEIVED_INVALID);
            } catch (JSONException e3) {
                throw new atd.a0.a(atd.s0.a.a(-101557460593216L), e3, c.MESSAGE_RECEIVED_INVALID);
            }
        } else {
            throw new atd.a0.a(atd.s0.a.a(-100810136283712L), c.MESSAGE_RECEIVED_INVALID);
        }
    }

    private JSONObject b(byte[] bArr, Charset charset) throws JSONException {
        if (charset == null) {
            charset = h;
        }
        return new JSONObject(new String(bArr, charset));
    }

    private byte[] a(byte[] bArr, Charset charset) throws GeneralSecurityException {
        if (charset == null) {
            charset = h;
        }
        return this.e.a(h.a(new String(bArr, charset)));
    }

    /* access modifiers changed from: private */
    public j a(j jVar, atd.d.i iVar) throws atd.a0.a {
        if (jVar != null || d.ERROR.equals(iVar.c())) {
            if (jVar != null && !d.ERROR.equals(jVar.b())) {
                if (!iVar.d().equals(jVar.c())) {
                    String join = TextUtils.join(atd.s0.a.a(-100260380469824L), com.adyen.threeds2.internal.d.a());
                    throw new atd.a0.a(String.format(atd.s0.a.a(-100251790535232L), new Object[]{jVar.c(), join}), c.MESSAGE_VERSION_NOT_SUPPORTED);
                } else if (!iVar.h().equalsIgnoreCase(jVar.e())) {
                    throw new atd.a0.a(atd.s0.a.a(-100483718769216L), c.TRANSACTION_ID_NOT_RECOGNIZED);
                } else if (!iVar.b().equalsIgnoreCase(jVar.a())) {
                    throw new atd.a0.a(atd.s0.a.a(-100359164717632L), c.TRANSACTION_ID_NOT_RECOGNIZED);
                } else if (!iVar.f().equalsIgnoreCase(jVar.d())) {
                    throw new atd.a0.a(atd.s0.a.a(-99663380015680L), c.TRANSACTION_ID_NOT_RECOGNIZED);
                } else if ((jVar instanceof atd.d.c) && iVar.e() != ((atd.d.c) jVar).g()) {
                    throw new atd.a0.a(atd.s0.a.a(-99551710865984L), c.DATA_DECRYPTION_FAILURE);
                }
            }
            return jVar;
        }
        throw new atd.a0.a(atd.s0.a.a(-100934690335296L), c.MESSAGE_RECEIVED_INVALID);
    }
}
