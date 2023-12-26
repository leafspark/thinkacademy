package com.adyen.threeds2.internal.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import atd.d.n;
import atd.d.o;
import atd.d.q;
import atd.q0.c;
import atd.q0.e;
import atd.q0.f;
import atd.q0.g;
import com.adyen.threeds2.R;
import java.util.ArrayDeque;
import java.util.Queue;

final class a {
    private static boolean e;
    private final FragmentActivity a;
    /* access modifiers changed from: private */
    public final atd.p0.a b;
    /* access modifiers changed from: private */
    public final Queue<AnimatorSet> c;
    private final c d = c.a();

    /* renamed from: com.adyen.threeds2.internal.ui.activity.a$a  reason: collision with other inner class name */
    class C0009a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;
        final /* synthetic */ View b;

        C0009a(View view, View view2) {
            this.a = view;
            this.b = view2;
        }

        public void onAnimationEnd(Animator animator) {
            animator.removeAllListeners();
            a.this.b(this.a);
            a.this.h();
            if (a.this.c.isEmpty() && !(this.b instanceof c)) {
                a.this.b.c();
            }
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                atd.e.b[] r0 = atd.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.e.b r1 = atd.e.b.SINGLE_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.b r1 = atd.e.b.SINGLE_SELECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.e.b r1 = atd.e.b.MULTI_SELECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.e.b r1 = atd.e.b.OUT_OF_BAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                atd.e.b r1 = atd.e.b.HTML_UI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.ui.activity.a.b.<clinit>():void");
        }
    }

    static {
        atd.s0.a.a(-841979757652544L);
    }

    a(FragmentActivity fragmentActivity, atd.p0.a aVar) {
        this.a = fragmentActivity;
        this.b = aVar;
        this.c = new ArrayDeque();
    }

    private ViewGroup d() {
        return (ViewGroup) this.a.findViewById(16908290);
    }

    private View e() {
        ViewGroup d2 = d();
        int childCount = d2.getChildCount();
        return d2.getChildAt(childCount > 0 ? childCount - 1 : 0);
    }

    static boolean g() {
        return e;
    }

    /* access modifiers changed from: private */
    public void h() {
        AnimatorSet peek;
        this.c.poll();
        if (!this.c.isEmpty() && (peek = this.c.peek()) != null) {
            peek.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            a(false);
            if (this.d.isAdded()) {
                this.d.dismiss();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (!g()) {
            a(true);
            if (!this.d.isAdded()) {
                this.d.show(this.a.getSupportFragmentManager(), atd.s0.a.a(-842190211050048L));
            }
        }
    }

    private void c(View view) {
        View e2 = e();
        if (e2 == null) {
            this.a.setContentView(view);
            if (!(view instanceof c)) {
                this.b.c();
            }
        } else if (!e2.equals(view)) {
            a(e2, view);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(atd.d.a aVar) {
        f();
        int i = b.a[aVar.a().ordinal()];
        if (i == 1) {
            g gVar = new g(this.a);
            c((View) gVar);
            gVar.a((q) aVar);
        } else if (i == 2 || i == 3) {
            f fVar = new f(this.a);
            c((View) fVar);
            fVar.a((o) aVar);
        } else if (i == 4) {
            e eVar = new e(this.a);
            c((View) eVar);
            eVar.a((n) aVar);
        } else if (i == 5) {
            atd.q0.b bVar = new atd.q0.b(this.a);
            c((View) bVar);
            bVar.a((atd.d.f) aVar);
        } else {
            throw atd.y.c.CHALLENGE_PRESENTATION_FAILURE.a();
        }
    }

    private static void a(boolean z) {
        e = z;
    }

    /* access modifiers changed from: package-private */
    public void a(atd.d.a aVar) {
        atd.q0.a c2 = c();
        if (c2 != null && !(c2 instanceof c)) {
            int i = b.a[aVar.a().ordinal()];
            if (i == 4) {
                ((e) c2).b((n) aVar);
            } else if (i == 5) {
                ((atd.q0.b) c2).b((atd.d.f) aVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public atd.q0.a c() {
        View b2 = b();
        if (b2 instanceof atd.q0.a) {
            return (atd.q0.a) b2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        while (!this.c.isEmpty()) {
            AnimatorSet poll = this.c.poll();
            if (poll != null) {
                poll.cancel();
                poll.removeAllListeners();
            }
        }
    }

    private void a(View view, View view2) {
        View findViewById = view.findViewById(R.id.scrollView_content);
        View findViewById2 = view2.findViewById(R.id.scrollView_content);
        findViewById2.setAlpha(0.0f);
        a(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById2, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new C0009a(view, view2));
        a(animatorSet);
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        d().removeView(view);
    }

    private View b() {
        return d().getChildAt(0);
    }

    private void a(View view) {
        ViewGroup d2 = d();
        if (view instanceof c) {
            d2.addView(view, d2.getChildCount());
        } else {
            d2.addView(view, 0);
        }
    }

    private void a(AnimatorSet animatorSet) {
        if (this.c.isEmpty()) {
            this.c.add(animatorSet);
            animatorSet.start();
            return;
        }
        this.c.add(animatorSet);
    }
}
