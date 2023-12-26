package atd.q0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import atd.d.a;
import atd.p0.a;
import com.adyen.threeds2.R;
import com.adyen.threeds2.internal.ui.widget.ToolbarView;

public abstract class a<C extends atd.d.a, L extends atd.p0.a> extends LinearLayout implements ToolbarView.a {
    private L a;

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LinearLayout.inflate(context, R.layout.a3ds2_view_challenge_container, this);
        LinearLayout.inflate(context, getChallengeContainerLayoutId(), (ViewGroup) findViewById(R.id.scrollView_content));
        ((ToolbarView) findViewById(R.id.toolbarView)).setToolbarListener(this);
    }

    public void a() {
        L l = this.a;
        if (l != null) {
            l.a();
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getChallengeContainerLayoutId();

    public L getChallengeListener() {
        if (this.a == null) {
            atd.s0.a.a(-842044182161984L);
            Class<atd.p0.a> cls = atd.p0.a.class;
            atd.s0.a.a(-841296857852480L);
        }
        return this.a;
    }

    public void setChallengeListener(L l) {
        this.a = l;
    }
}
