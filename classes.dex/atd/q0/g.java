package atd.q0;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import atd.d.q;
import atd.p0.e;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final class g extends d<q, e> implements View.OnClickListener {
    private final EditText m;
    private final Button n;

    public g(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(q qVar) {
        setInfoLabelFor(this.m.getId());
        this.n.setText(qVar.n());
        this.n.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int getChallengeLayoutId() {
        return R.layout.a3ds2_view_challenge_text;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, g.class);
        super.onClick(view);
        if (getChallengeListener() != null && view.equals(this.n)) {
            this.n.setEnabled(false);
            String obj = this.m.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                ((e) getChallengeListener()).b();
            } else {
                ((e) getChallengeListener()).a(obj, getWhitelistStatus());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = (EditText) findViewById(R.id.editText_text);
        this.n = (Button) findViewById(R.id.button_continue);
    }
}
