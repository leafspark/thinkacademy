package com.adyen.threeds2.internal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import atd.d0.g;
import atd.g0.e;
import atd.h0.d;
import atd.r0.f;
import atd.y.b;
import atd.y.c;
import com.adyen.threeds2.AuthenticationRequestParameters;
import com.adyen.threeds2.ChallengeStatusReceiver;
import com.adyen.threeds2.CompletionEvent;
import com.adyen.threeds2.ProgressDialog;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;
import com.adyen.threeds2.Transaction;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.ui.activity.ChallengeActivity;
import com.adyen.threeds2.parameters.ChallengeParameters;
import java.lang.ref.WeakReference;
import java.security.cert.X509Certificate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class i implements Transaction, a {
    final List<X509Certificate> a;
    final atd.g0.a b;
    private AuthenticationRequestParameters c;
    private WeakReference<Activity> d;
    private ChallengeStatusReceiver e;
    private f f;
    /* access modifiers changed from: private */
    public atd.o0.a g;

    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            atd.o0.a unused = i.this.g = null;
        }
    }

    i(List<X509Certificate> list, atd.g0.a aVar, AuthenticationRequestParameters authenticationRequestParameters) {
        this.a = list;
        this.b = aVar;
        this.c = authenticationRequestParameters;
    }

    private ChallengeStatusReceiver c() {
        ChallengeStatusReceiver challengeStatusReceiver = this.e;
        if (challengeStatusReceiver != null) {
            return challengeStatusReceiver;
        }
        throw c.CHALLENGE_PRESENTATION_FAILURE.a();
    }

    private Activity d() {
        WeakReference<Activity> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    private void e() {
        Activity d2 = d();
        if (d2 == null) {
            runtimeError(b.ACTIVITY_REFERENCE_MISSING.a());
        } else if (!ChallengeActivity.g()) {
            d2.startActivity(b(d2));
        }
    }

    /* access modifiers changed from: package-private */
    public Intent b(Activity activity) {
        return ChallengeActivity.b((Context) activity);
    }

    public void cancelled() {
        b();
        ChallengeStatusReceiver c2 = c();
        if (c2 != null) {
            c2.cancelled();
        }
    }

    public void close() {
        this.b.c();
        this.c = null;
        this.e = null;
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null) {
            weakReference.clear();
            this.d = null;
        }
        f fVar = this.f;
        if (fVar != null) {
            fVar.b();
            this.f = null;
        }
        atd.o0.a aVar = this.g;
        if (aVar != null) {
            aVar.hide();
            this.g = null;
        }
    }

    public void completed(CompletionEvent completionEvent) {
        b();
        ChallengeStatusReceiver c2 = c();
        if (c2 != null) {
            c2.completed(completionEvent);
        }
    }

    public void doChallenge(Activity activity, ChallengeParameters challengeParameters, ChallengeStatusReceiver challengeStatusReceiver, int i) throws InvalidInputException {
        Activity activity2 = activity;
        ChallengeStatusReceiver challengeStatusReceiver2 = challengeStatusReceiver;
        f.a((Object) activity, atd.y.a.CURRENT_ACTIVITY);
        ChallengeParameters challengeParameters2 = challengeParameters;
        f.a((Object) challengeParameters, atd.y.a.CHALLENGE_PARAMETERS);
        f.b(challengeParameters.getAcsTransactionID(), atd.y.a.CHALLENGE_PARAMETERS);
        f.b(challengeParameters.get3DSServerTransactionID(), atd.y.a.CHALLENGE_PARAMETERS);
        f.a((Object) challengeStatusReceiver2, atd.y.a.CHALLENGE_STATUS_RECEIVER);
        f.a(i, 5, atd.y.a.TIMEOUT);
        this.d = new WeakReference<>(activity);
        this.e = challengeStatusReceiver2;
        atd.g.a a2 = a(challengeParameters.getAcsSignedContent());
        atd.d.b bVar = new atd.d.b(this.c.getMessageVersion(), challengeParameters.get3DSServerTransactionID(), challengeParameters.getAcsTransactionID(), this.c.getSDKTransactionID(), !this.c.getMessageVersion().equals(d.V2_1_0.c()) ? challengeParameters.getThreeDSRequestorAppURL() : null);
        atd.f0.a a3 = a(challengeParameters.getAcsTransactionID(), a2.a());
        f d2 = f.d();
        this.f = d2;
        d2.a(a2.b(), a3, bVar, i, this);
    }

    public AuthenticationRequestParameters getAuthenticationRequestParameters() {
        return this.c;
    }

    public ProgressDialog getProgressView(Activity activity) throws InvalidInputException {
        f.a((Object) activity, atd.y.a.CURRENT_ACTIVITY);
        if (this.g == null) {
            this.g = new atd.o0.a(activity, new a());
        }
        return this.g;
    }

    public void protocolError(ProtocolErrorEvent protocolErrorEvent) {
        b();
        ChallengeStatusReceiver c2 = c();
        if (c2 != null) {
            c2.protocolError(protocolErrorEvent);
        }
    }

    public void runtimeError(RuntimeErrorEvent runtimeErrorEvent) {
        b();
        ChallengeStatusReceiver c2 = c();
        if (c2 != null) {
            c2.runtimeError(runtimeErrorEvent);
        }
    }

    public void timedout() {
        b();
        ChallengeStatusReceiver c2 = c();
        if (c2 != null) {
            c2.timedout();
        }
    }

    private void b(atd.d.a aVar) {
        Activity d2 = d();
        if (d2 == null) {
            runtimeError(b.ACTIVITY_REFERENCE_MISSING.a());
            return;
        }
        atd.o0.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.hide();
        }
        d2.startActivity(a(d2, aVar));
    }

    public void a() {
        e();
    }

    public void a(atd.d.a aVar) {
        b(aVar);
    }

    /* access modifiers changed from: package-private */
    public Intent a(Activity activity, atd.d.a aVar) {
        return ChallengeActivity.a((Context) activity, aVar);
    }

    /* access modifiers changed from: package-private */
    public Intent a(Activity activity) {
        return ChallengeActivity.a((Context) activity);
    }

    private atd.g.a a(String str) throws InvalidInputException {
        try {
            d a2 = d.a(str);
            a2.a(this.a);
            return new atd.g.a(a2.a().d());
        } catch (SDKRuntimeException | JSONException e2) {
            throw atd.y.a.CHALLENGE_PARAMETERS.a(e2);
        }
    }

    private atd.f0.a a(String str, atd.g0.b bVar) {
        if (bVar instanceof atd.g0.a) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(atd.s0.a.a(-103000569604672L), str);
                atd.f0.f fVar = new atd.f0.f(g.a, atd.c0.c.a, jSONObject);
                e eVar = new e((String) null, this.b.a((String) null, (String) null, this.c.getSDKReferenceNumber(), ((atd.g0.a) bVar).f()));
                this.b.c();
                try {
                    return new atd.f0.a(fVar, fVar.f().a(fVar, eVar), eVar);
                } catch (JSONException e2) {
                    throw c.CRYPTO_FAILURE.a(e2);
                }
            } catch (JSONException e3) {
                throw c.CRYPTO_FAILURE.a(e3);
            }
        } else {
            throw c.CRYPTO_FAILURE.a();
        }
    }

    private void b() {
        Activity d2 = d();
        if (d2 != null) {
            d2.startActivity(a(d2));
        }
    }
}
