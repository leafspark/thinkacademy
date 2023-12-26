package atd.q0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import atd.d.n;
import atd.p0.c;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final class e extends d<n, c> implements View.OnClickListener {
    private final Button m;
    private final Button n;

    public e(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(n nVar) {
        String p = nVar.p();
        if (p != null) {
            this.m.setTag(Uri.parse(p));
            this.m.setText(nVar.o());
            this.m.setOnClickListener(this);
        } else {
            this.m.setVisibility(8);
        }
        this.n.setText(nVar.q());
        this.n.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int getChallengeLayoutId() {
        return R.layout.a3ds2_view_challenge_out_of_band;
    }

    public String getWhitelistStatus() {
        return super.getWhitelistStatus();
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, e.class);
        super.onClick(view);
        if (getChallengeListener() != null) {
            if (view.equals(this.n)) {
                this.n.setEnabled(false);
                ((c) getChallengeListener()).a(getWhitelistStatus());
            } else if (view.equals(this.m)) {
                this.m.setEnabled(false);
                ((c) getChallengeListener()).a((Uri) this.m.getTag());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b(n nVar) {
        String n2 = nVar.n();
        if (!TextUtils.isEmpty(n2)) {
            setInfoTextOrHide(n2);
            setInfoTextIndicatorVisibility(false);
        }
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = (Button) findViewById(R.id.button_app);
        this.n = (Button) findViewById(R.id.button_continue);
    }
}
