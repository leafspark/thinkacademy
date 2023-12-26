package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.ObjectAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/SpeedAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "convert", "", "holder", "item", "startProgressAnimator", "view", "Landroid/widget/ProgressBar;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedAdapter.kt */
public final class SpeedAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int mCurrentIndex = 2;

    public SpeedAdapter() {
        super(R.layout.video_speed_select_item, (List) null);
    }

    public final int getMCurrentIndex() {
        return this.mCurrentIndex;
    }

    public final void setMCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(str, "item");
        boolean z = this.mCurrentIndex == baseViewHolder.getLayoutPosition();
        baseViewHolder.itemView.setSelected(z);
        ((TextView) baseViewHolder.getView(R.id.speed_number)).setText(str);
        XesLog.dt("SpeedAdapter", new Object[]{"convert position = " + baseViewHolder.getLayoutPosition() + ",isSelect = " + z});
        if (z) {
            baseViewHolder.setGone(R.id.speedProgressBar, false);
            startProgressAnimator((ProgressBar) baseViewHolder.getView(R.id.speedProgressBar));
            return;
        }
        baseViewHolder.setGone(R.id.speedProgressBar, true);
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
