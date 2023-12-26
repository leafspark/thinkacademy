package com.tal.app.thinkacademy.business.login.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageFragment.kt */
final class MePageFragment$mFootView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ MePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MePageFragment$mFootView$2(MePageFragment mePageFragment) {
        super(0);
        this.this$0 = mePageFragment;
    }

    public final View invoke() {
        LayoutInflater layoutInflater = this.this$0.getLayoutInflater();
        int i = R.layout.global_footview_height_110dp;
        ViewGroup viewGroup = this.this$0.getBinding().rvShowDetail;
        return !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
    }
}
