package com.tal.app.thinkacademy.live.business.schulte.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.constant.MemoryConstants;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableRankListUserDataBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableRankTopView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "topList", "", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableRankListUserDataBean;", "onlyHead", "", "(Landroid/content/Context;Ljava/util/List;Z)V", "bindItemView", "", "index", "", "user", "itemView", "Landroid/view/View;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableRankTopView.kt */
public final class SchulteTableRankTopView extends LinearLayout {
    private final boolean onlyHead;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTableRankTopView(Context context, List<SchulteTableRankListUserDataBean> list, boolean z) {
        super(context);
        SchulteTableRankListUserDataBean schulteTableRankListUserDataBean;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "topList");
        this.onlyHead = z;
        setOrientation(0);
        setGravity(80);
        setBackgroundResource(R.drawable.bg_schulte_table_rank_top);
        for (int i = 0; i < 3; i++) {
            LayoutInflater from = LayoutInflater.from(context);
            int i2 = R.layout.item_schulte_table_rank_top;
            ViewGroup viewGroup = this;
            View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false);
            if (i < list.size()) {
                schulteTableRankListUserDataBean = list.get(i);
            } else {
                schulteTableRankListUserDataBean = null;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.bottomMargin = SizeUtils.dp2px(this.onlyHead ? 33.0f : 8.0f);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            bindItemView(i, schulteTableRankListUserDataBean, inflate);
            if (i == 1) {
                addView(inflate, 0, layoutParams);
            } else {
                addView(inflate, layoutParams);
            }
        }
    }

    private final void bindItemView(int i, SchulteTableRankListUserDataBean schulteTableRankListUserDataBean, View view) {
        String avatar;
        String coin;
        String duration;
        String nickName;
        TextView textView = (TextView) view.findViewById(R.id.rank_name);
        TextView textView2 = (TextView) view.findViewById(R.id.rank_score);
        ImageView imageView = (ImageView) view.findViewById(R.id.rank_head);
        TextView textView3 = (TextView) view.findViewById(R.id.rank_coins);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.rank_desk);
        if (!(schulteTableRankListUserDataBean == null || (nickName = schulteTableRankListUserDataBean.getNickName()) == null)) {
            textView.setText(nickName);
        }
        if (!(schulteTableRankListUserDataBean == null || (duration = schulteTableRankListUserDataBean.getDuration()) == null)) {
            textView2.setText(Intrinsics.stringPlus(duration, "s"));
        }
        Unit unit = null;
        if (!(schulteTableRankListUserDataBean == null || (coin = schulteTableRankListUserDataBean.getCoin()) == null)) {
            textView3.setText(Intrinsics.stringPlus("+", coin));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SchulteTableRankTopView schulteTableRankTopView = this;
            textView3.setVisibility(4);
        }
        if (!(schulteTableRankListUserDataBean == null || (avatar = schulteTableRankListUserDataBean.getAvatar()) == null)) {
            ImageLoaderJ.loadCircle(getContext(), avatar, imageView, R.drawable.icon_default_user);
        }
        if (i == 0) {
            imageView2.setImageResource(R.drawable.ic_schulte_table_rank_top1);
        } else if (i != 1) {
            imageView2.setImageResource(R.drawable.ic_schulte_table_rank_top3);
        } else {
            imageView2.setImageResource(R.drawable.ic_schulte_table_rank_top2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.onlyHead) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(SizeUtils.dp2px(176.0f), MemoryConstants.GB));
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(SizeUtils.dp2px(125.0f), MemoryConstants.GB));
        }
    }
}
