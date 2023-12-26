package com.tal.app.thinkacademy.business.shop.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/MoreSelectDialogAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentDataOption;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MoreSelectDialogAdapter.kt */
public final class MoreSelectDialogAdapter extends BaseQuickAdapter<UserLeaveComponentDataOption, BaseViewHolder> {
    public MoreSelectDialogAdapter(List<UserLeaveComponentDataOption> list) {
        super(R.layout.bus_shop_aggregate_dialog_more_select_item, list);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, UserLeaveComponentDataOption userLeaveComponentDataOption) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(userLeaveComponentDataOption, "item");
        baseViewHolder.setText(R.id.selectTitle, userLeaveComponentDataOption.getName());
        baseViewHolder.itemView.setSelected(userLeaveComponentDataOption.getMLocalIsSelect());
        baseViewHolder.itemView.setOnClickListener(new MoreSelectDialogAdapter$$ExternalSyntheticLambda0(userLeaveComponentDataOption, baseViewHolder));
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-0  reason: not valid java name */
    public static final void m211convert$lambda0(UserLeaveComponentDataOption userLeaveComponentDataOption, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.checkNotNullParameter(userLeaveComponentDataOption, "$item");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$holder");
        userLeaveComponentDataOption.setMLocalIsSelect(!userLeaveComponentDataOption.getMLocalIsSelect());
        baseViewHolder.itemView.setSelected(userLeaveComponentDataOption.getMLocalIsSelect());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
