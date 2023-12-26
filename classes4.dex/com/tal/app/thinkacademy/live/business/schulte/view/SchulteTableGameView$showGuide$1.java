package com.tal.app.thinkacademy.live.business.schulte.view;

import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.schulte.adapter.SchulteTableAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "clickRigth", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableGameView.kt */
final class SchulteTableGameView$showGuide$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SchulteTableGameView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTableGameView$showGuide$1(SchulteTableGameView schulteTableGameView) {
        super(1);
        this.this$0 = schulteTableGameView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            SchulteTableGameView schulteTableGameView = this.this$0;
            String access$getMCurrent$p = schulteTableGameView.mCurrent;
            SchulteTableAdapter access$getMAdapter$p = this.this$0.mAdapter;
            schulteTableGameView.checkRight(access$getMCurrent$p, access$getMAdapter$p == null ? null : access$getMAdapter$p.getItemView(this.this$0.mDataList.indexOf(this.this$0.mCurrent)));
        }
        this.this$0.mLayoutGuide.setVisibility(8);
        this.this$0.mTvGameIntro.getDelegate().setBackgroundColor(ContextCompat.getColor(this.this$0.mContext, R.color.color_white_60));
    }
}
