package com.tal.app.thinkacademy.business.login.adapter;

import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.item.SchoolItem;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/view/item/SchoolItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "mCheckedPosition", "", "mItemClickListener", "Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter$OnItemCheckedListener;", "getMItemClickListener", "()Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter$OnItemCheckedListener;", "setMItemClickListener", "(Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter$OnItemCheckedListener;)V", "convert", "", "holder", "item", "setOnItemClickListener", "OnItemCheckedListener", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectSchoolAdapter.kt */
public final class SelectSchoolAdapter extends BaseQuickAdapter<SchoolItem, BaseViewHolder> {
    /* access modifiers changed from: private */
    public int mCheckedPosition = -1;
    private OnItemCheckedListener mItemClickListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter$OnItemCheckedListener;", "", "onChecked", "", "position", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SelectSchoolAdapter.kt */
    public interface OnItemCheckedListener {
        void onChecked(int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectSchoolAdapter(List<SchoolItem> list) {
        super(R.layout.layout_item_select_school, list);
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
    }

    public final OnItemCheckedListener getMItemClickListener() {
        return this.mItemClickListener;
    }

    public final void setMItemClickListener(OnItemCheckedListener onItemCheckedListener) {
        this.mItemClickListener = onItemCheckedListener;
    }

    public final void setOnItemClickListener(OnItemCheckedListener onItemCheckedListener) {
        this.mItemClickListener = onItemCheckedListener;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, SchoolItem schoolItem) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(schoolItem, "item");
        XesImageLoader.loadImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.iv_country), getContext(), schoolItem.getResFlag(), R.drawable.icon_think_launch, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
        baseViewHolder.setText(R.id.tv_country, schoolItem.getCountry());
        baseViewHolder.getView(R.id.tv_country).setSelected(schoolItem.isChecked());
        baseViewHolder.itemView.setSelected(schoolItem.isChecked());
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        View view = baseViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, view, 0, new SelectSchoolAdapter$convert$1(this, baseViewHolder, schoolItem), 1, (Object) null);
    }
}
