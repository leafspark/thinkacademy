package com.tal.app.thinkacademy.business.login.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.common.user.GradeStage;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/SelectGradeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/common/user/GradeStage;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "mSelectPosition", "", "mShowArrow", "", "mShowSubtitlePosition", "mSubtitle", "", "convert", "", "holder", "item", "getSubtitlePosition", "setSelectPosition", "position", "setSubtitle", "subtitle", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectGradeAdapter.kt */
public final class SelectGradeAdapter extends BaseQuickAdapter<GradeStage, BaseViewHolder> {
    private int mSelectPosition = -1;
    private boolean mShowArrow;
    private int mShowSubtitlePosition = -1;
    private String mSubtitle = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectGradeAdapter(List<GradeStage> list) {
        super(R.layout.layout_item_select_grade, list);
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, GradeStage gradeStage) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(gradeStage, "item");
        boolean z = this.mSelectPosition == getItemPosition(gradeStage);
        baseViewHolder.itemView.setSelected(z);
        boolean z2 = this.mShowSubtitlePosition == baseViewHolder.getBindingAdapterPosition();
        if (z2) {
            baseViewHolder.setText(R.id.tv_grade_name, this.mSubtitle);
        } else {
            baseViewHolder.setText(R.id.tv_grade_name, "");
        }
        if (this.mShowArrow && z && z2) {
            if (this.mSubtitle.length() == 0) {
                baseViewHolder.setVisible(R.id.iv_icon_arrow, true);
                baseViewHolder.setVisible(R.id.tv_grade_name, z2);
                baseViewHolder.setText(R.id.tv_name, gradeStage.getGradeStage());
                ImageLoaderJ.load(getContext(), gradeStage.getIcon(), (ImageView) baseViewHolder.getView(R.id.iv_grade_icon));
            }
        }
        if (this.mShowArrow && z && z2) {
            if (this.mSubtitle.length() > 0) {
                baseViewHolder.setVisible(R.id.iv_icon_arrow, false);
                baseViewHolder.setVisible(R.id.tv_grade_name, z2);
                baseViewHolder.setText(R.id.tv_name, gradeStage.getGradeStage());
                ImageLoaderJ.load(getContext(), gradeStage.getIcon(), (ImageView) baseViewHolder.getView(R.id.iv_grade_icon));
            }
        }
        if (!this.mShowArrow || !z) {
            baseViewHolder.setVisible(R.id.iv_icon_arrow, false);
        } else {
            baseViewHolder.setVisible(R.id.iv_icon_arrow, true);
        }
        baseViewHolder.setVisible(R.id.tv_grade_name, z2);
        baseViewHolder.setText(R.id.tv_name, gradeStage.getGradeStage());
        ImageLoaderJ.load(getContext(), gradeStage.getIcon(), (ImageView) baseViewHolder.getView(R.id.iv_grade_icon));
    }

    public final void setSelectPosition(int i) {
        this.mSelectPosition = i;
        this.mShowArrow = i != -1;
        notifyDataSetChanged();
    }

    public final void setSubtitle(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "subtitle");
        this.mSubtitle = str;
        this.mShowSubtitlePosition = i;
        notifyDataSetChanged();
    }

    public final int getSubtitlePosition() {
        return this.mShowSubtitlePosition;
    }
}
