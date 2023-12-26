package atd.q0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import atd.a.h;
import atd.d.g;
import atd.d.l;
import atd.e.b;
import atd.p0.a;
import com.adyen.threeds2.R;
import com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

abstract class d<C extends l, L extends a> extends a<C, L> implements View.OnClickListener {
    private final TextView b = ((TextView) findViewById(R.id.textView_infoHeader));
    private final TextView c = ((TextView) findViewById(R.id.textView_infoText));
    private final TextView d = ((TextView) findViewById(R.id.textView_infoLabel));
    private final ImageView e = ((ImageView) findViewById(R.id.imageView_infoTextIndicator));
    private final Button f = ((Button) findViewById(R.id.button_resend));
    private final ExpandableInfoTextView g = ((ExpandableInfoTextView) findViewById(R.id.expandableInfoText_why));
    private final ExpandableInfoTextView h = ((ExpandableInfoTextView) findViewById(R.id.expandableInfoText_explained));
    private final View i = findViewById(R.id.dividerView_logos);
    private final ImageView j = ((ImageView) findViewById(R.id.imageView_issuer));
    private final ImageView k = ((ImageView) findViewById(R.id.imageView_scheme));
    private final SwitchCompat l = ((SwitchCompat) findViewById(R.id.switch_whitelist));

    d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LinearLayout.inflate(context, getChallengeLayoutId(), (ViewGroup) findViewById(R.id.linearLayout_challengeContainer));
    }

    private void setImagesOrHide(C c2) {
        g g2 = c2.g();
        g h2 = c2.h();
        boolean z = true;
        if (g2 == null || h2 == null) {
            a(this.i, false);
            a((View) this.j, g2 != null);
            ImageView imageView = this.k;
            if (h2 == null) {
                z = false;
            }
            a((View) imageView, z);
        } else {
            a(this.i, true);
            a((View) this.j, true);
            a((View) this.k, true);
        }
        h.d.a(this.j, g2);
        h.d.a(this.k, h2);
    }

    private void setWhitelistOrHide(C c2) {
        a((View) this.l, !TextUtils.isEmpty(c2.j()));
        this.l.setText(c2.j());
    }

    public void a(C c2) {
        a(this.b, (CharSequence) c2.b());
        a(this.c, (CharSequence) c2.d());
        a(this.d, (CharSequence) c2.c());
        a((View) this.e, c2.m());
        if (c2.a() == b.SINGLE_TEXT_INPUT) {
            a((TextView) this.f, (CharSequence) c2.i());
        } else {
            this.f.setVisibility(8);
        }
        a(this.g, c2.k(), c2.l());
        a(this.h, c2.e(), c2.f());
        setImagesOrHide(c2);
        setWhitelistOrHide(c2);
        this.f.setOnClickListener(this);
        b(c2);
    }

    /* access modifiers changed from: protected */
    public abstract void b(C c2);

    /* access modifiers changed from: protected */
    public int getChallengeContainerLayoutId() {
        return R.layout.a3ds2_view_challenge_native_container;
    }

    /* access modifiers changed from: protected */
    public abstract int getChallengeLayoutId();

    /* access modifiers changed from: protected */
    public String getWhitelistStatus() {
        if (this.l.getVisibility() != 0) {
            return null;
        }
        return atd.s0.a.a(this.l.isChecked() ? -840858771188288L : -840884540992064L);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, d.class);
        if (getChallengeListener() != null && view.equals(this.f)) {
            this.f.setEnabled(false);
            getChallengeListener().d();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public void setInfoLabelFor(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.d.setLabelFor(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void setInfoTextIndicatorVisibility(boolean z) {
        a((View) this.e, z);
    }

    /* access modifiers changed from: protected */
    public void setInfoTextOrHide(CharSequence charSequence) {
        a(this.c, charSequence);
    }

    private void a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    private void a(ExpandableInfoTextView expandableInfoTextView, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            expandableInfoTextView.setVisibility(8);
            return;
        }
        expandableInfoTextView.setTitle(str);
        expandableInfoTextView.setInfo(str2);
    }

    private void a(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
