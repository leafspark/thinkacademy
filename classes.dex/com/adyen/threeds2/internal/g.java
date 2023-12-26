package com.adyen.threeds2.internal;

import android.content.Context;
import atd.h.b;
import atd.i0.d;
import atd.r0.f;
import atd.x.c;
import atd.y.a;
import com.adyen.threeds2.Transaction;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.exception.SDKAlreadyInitializedException;
import com.adyen.threeds2.exception.SDKNotInitializedException;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

class g implements h {
    private Context b;
    private ConfigParameters c;
    private UiCustomization d;
    private List<Warning> e;
    private b f;
    private boolean g;

    g() {
    }

    private synchronized void b() throws SDKNotInitializedException {
        if (!this.g) {
            throw new SDKNotInitializedException();
        }
    }

    private synchronized void c() throws SDKAlreadyInitializedException {
        if (this.g) {
            throw new SDKAlreadyInitializedException();
        }
    }

    public UiCustomization a() {
        return this.d;
    }

    public synchronized void cleanup(Context context) throws SDKNotInitializedException {
        b();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
    }

    public Transaction createTransaction(String str, String str2) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException {
        b();
        f.a((Object) str2, a.MESSAGE_VERSION);
        d b2 = d.b(str2);
        JSONObject a = this.f.a(b2.b());
        atd.g0.b a2 = c.a(str, this.c);
        String e2 = c.a((atd.f0.b) a2, a).e();
        if (a2 instanceof atd.g0.c) {
            ((atd.g0.c) a2).c();
        }
        String uuid = UUID.randomUUID().toString();
        e a3 = e.a(this.b, atd.k0.b.a());
        atd.g0.a aVar = new atd.g0.a(atd.s0.a.a(-102961914899008L), d.P256);
        JSONObject g2 = aVar.g();
        return new i(atd.x.a.a(str, this.c), aVar, new atd.j0.a(uuid, e2, !(g2 instanceof JSONObject) ? g2.toString() : JSONObjectInstrumentation.toString(g2), a3.a(), a3.b(), b2.c()));
    }

    public String getSDKVersion() {
        return atd.s0.a.a(-102991979670080L);
    }

    public List<Warning> getWarnings() {
        return new ArrayList(this.e);
    }

    public synchronized void initialize(Context context, ConfigParameters configParameters, String str, UiCustomization uiCustomization) throws InvalidInputException, SDKAlreadyInitializedException, SDKRuntimeException {
        c();
        atd.r0.b.a(6);
        f.a((Object) context, a.APPLICATION_CONTEXT);
        f.a((Object) configParameters, a.CONFIG_PARAMETERS);
        atd.r0.c.b(str);
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = configParameters;
        this.d = uiCustomization;
        List<Warning> a = atd.l0.g.a(applicationContext, configParameters).a();
        this.e = a;
        this.f = b.a(this.b, this.c, a);
        this.g = true;
    }
}
