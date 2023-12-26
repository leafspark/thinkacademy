package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.ObjectAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/SwitchLineAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mLineIndex", "", "getMLineIndex", "()I", "setMLineIndex", "(I)V", "convert", "", "holder", "item", "startProgressAnimator", "view", "Landroid/widget/ProgressBar;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchLineAdapter.kt */
public final class SwitchLineAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int mLineIndex;

    public SwitchLineAdapter() {
        super(R.layout.video_switch_line_item, (List) null);
    }

    public final int getMLineIndex() {
        return this.mLineIndex;
    }

    public final void setMLineIndex(int i) {
        this.mLineIndex = i;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(str, "item");
        int size = getData().size();
        if (size == 1) {
            baseViewHolder.itemView.getLayoutParams().width = SizeUtils.dp2px(580.0f);
        } else if (size != 2) {
            baseViewHolder.itemView.getLayoutParams().width = SizeUtils.dp2px(180.0f);
        } else {
            baseViewHolder.itemView.getLayoutParams().width = SizeUtils.dp2px(280.0f);
        }
        boolean z = this.mLineIndex == baseViewHolder.getLayoutPosition();
        baseViewHolder.itemView.setSelected(z);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = baseViewHolder.itemView.getContext().getString(R.string.vod_player_switch_line_item);
        Intrinsics.checkNotNullExpressionValue(string, "holder.itemView.context.…_player_switch_line_item)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(baseViewHolder.getLayoutPosition() + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ((TextView) baseViewHolder.getView(R.id.lineNumber)).setText(format);
        if (z) {
            baseViewHolder.setGone(R.id.lineProgressBar, false);
            startProgressAnimator((ProgressBar) baseViewHolder.getView(R.id.lineProgressBar));
            return;
        }
        baseViewHolder.setGone(R.id.lineProgressBar, true);
    }

    private final void startProgressAnimator(ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(0);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(progressBar, "progress", new int[]{0, 100});
            ofInt.setDuration(200);
            ofInt.start();
        }
    }
}
