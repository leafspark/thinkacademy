package com.adyen.threeds2.internal.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.widget.Toast;
import atd.c.g;
import atd.c.h;
import atd.c.i;
import atd.c.j;
import atd.p0.b;
import atd.p0.c;
import atd.p0.d;
import atd.p0.e;
import atd.s0.a;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.f;
import java.util.List;

public class ChallengeActivity extends b implements e, d, c, b {
    static final String d = "ChallengeActivity";
    static final String e = (d + a.a(-842310470134336L));
    static final String f = (d + a.a(-842688427256384L));
    static final String g = (d + a.a(-842516628564544L));
    static final String h = (d + a.a(-842589643008576L));
    static final String i = (d + a.a(-841898153273920L));
    private static final String j = (d + a.a(-841687699876416L));
    private static final String k = (d + a.a(-841786484124224L));
    private a a;
    private atd.d.a b;
    private boolean c;

    public static Intent a(Context context, atd.d.a aVar) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        intent.setAction(g);
        intent.putExtra(i, aVar);
        return intent;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        intent.setAction(e);
        return intent;
    }

    public static boolean g() {
        return a.g();
    }

    private void h() {
        atd.q0.a c2 = this.a.c();
        if (c2 != null) {
            c2.setChallengeListener(null);
        }
    }

    public void c() {
    }

    public void d() {
        a((atd.c.c) new h());
    }

    /* access modifiers changed from: package-private */
    public com.adyen.threeds2.internal.h e() {
        return com.adyen.threeds2.internal.h.a;
    }

    public void onBackPressed() {
        super.onBackPressed();
        a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            if (Process.myPid() != bundle.getInt(k)) {
                finish();
            } else {
                this.c = bundle.getBoolean(j, false);
            }
        }
        this.a = new a(this, this);
        try {
            a(getIntent());
        } catch (SDKRuntimeException e2) {
            f.d().a((Throwable) e2, e2.getMessage());
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.a.a();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        h();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        atd.d.a aVar;
        super.onResume();
        a((atd.p0.a) this);
        if (this.c && (aVar = this.b) != null) {
            this.a.a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(j, this.c);
        bundle.putInt(k, Process.myPid());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.c = true;
    }

    public void b() {
        a((atd.c.c) new atd.c.f());
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        intent.setAction(h);
        return intent;
    }

    public void b(String str) {
        a((atd.c.c) new atd.c.e(str));
    }

    public void a() {
        a((atd.c.c) new atd.c.a());
    }

    public void a(String str, String str2) {
        a((atd.c.c) new j(str), str2);
    }

    public void a(List<String> list, String str) {
        a((atd.c.c) new i(list), str);
    }

    public void a(Uri uri) {
        Intent intent = new Intent(a.a(-843311197514304L));
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.c = true;
            startActivity(intent);
            return;
        }
        Toast.makeText(this, a.a(-843160873658944L) + uri, 0).show();
    }

    public void a(String str) {
        a((atd.c.c) new g(), str);
    }

    private void a(Intent intent) {
        setIntent(intent);
        if (e.equals(intent.getAction())) {
            this.a.i();
        } else if (f.equals(intent.getAction())) {
            this.a.f();
        } else if (g.equals(intent.getAction())) {
            atd.d.a aVar = (atd.d.a) intent.getParcelableExtra(i);
            this.b = aVar;
            this.a.b(aVar);
        } else if (h.equals(intent.getAction())) {
            finish();
        } else if (!a.a(-842400664447552L).equals(intent.getAction()) || intent.getData() == null || !a.a(-842250340592192L).equals(intent.getData().getScheme())) {
            throw atd.y.c.CHALLENGE_PRESENTATION_FAILURE.a();
        } else {
            atd.q0.a c2 = this.a.c();
            String str = null;
            if (c2 instanceof atd.q0.e) {
                str = ((atd.q0.e) c2).getWhitelistStatus();
            }
            a((atd.c.c) new g(), str);
        }
    }

    private void a(atd.p0.a aVar) {
        atd.q0.a c2 = this.a.c();
        if (c2 != null) {
            c2.setChallengeListener(aVar);
        }
    }

    private void a(atd.c.c cVar) {
        a(cVar, (String) null);
    }

    private void a(atd.c.c cVar, String str) {
        f.d().a(cVar, str);
    }
}
