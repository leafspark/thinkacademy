package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateEnum;
import com.tal.app.thinkacademy.business.shop.bean.LeaveDataType;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ShopLeaveInfoMoreSelectDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemMoreSelect;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "showDialog", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentData;", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemMoreSelect.kt */
public final class GradeAggregateLeaveInfoItemMoreSelect extends BaseNodeProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "留资组件";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemMoreSelect$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateLeaveInfoItemMoreSelect.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int getItemViewType() {
        return GradeAggregateEnum.LEAVE_INFO_MORE_SELECT.getValue();
    }

    public int getLayoutId() {
        return R.layout.bus_shop_aggregate_leaveinfo_item_more_select;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof UserLeaveComponentData) {
            UserLeaveComponentData userLeaveComponentData = (UserLeaveComponentData) baseNode;
            userLeaveComponentData.setMLocalMulti(true);
            XesLog.it(TAG, new Object[]{"数据更新 = " + baseViewHolder.getLayoutPosition() + " name = " + userLeaveComponentData.getName()});
            ((TextView) baseViewHolder.getView(R.id.moreSelectText)).setHint(userLeaveComponentData.getName());
            ((TextView) baseViewHolder.getView(R.id.moreSelectText)).setText(userLeaveComponentData.getMLocalDisplaySelectText());
            if (userLeaveComponentData.getMLocalType() == LeaveDataType.DATA_HEAD.getValue()) {
                int dp2px = SizeUtils.dp2px(8.0f);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_TL(dp2px);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_TR(dp2px);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_BL(0);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_BR(0);
            } else {
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_TL(0);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_TR(0);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_BL(0);
                baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_BR(0);
            }
            baseViewHolder.getView(R.id.moreSelectGroup).setOnClickListener(new GradeAggregateLeaveInfoItemMoreSelect$$ExternalSyntheticLambda0(this, baseViewHolder, baseNode));
            if (userLeaveComponentData.getRequired()) {
                CharSequence mLocalSelectText = userLeaveComponentData.getMLocalSelectText();
                if (mLocalSelectText == null || StringsKt.isBlank(mLocalSelectText)) {
                    UserLeaveButtonData mLocalLeaveButtonData = userLeaveComponentData.getMLocalLeaveButtonData();
                    if (mLocalLeaveButtonData != null && mLocalLeaveButtonData.getMLocalIsClick()) {
                        baseViewHolder.setText(R.id.promptTextView, R.string.leave_info_input_for_normal);
                        baseViewHolder.setGone(R.id.promptTextView, false);
                        return;
                    }
                }
            }
            baseViewHolder.setGone(R.id.promptTextView, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-0  reason: not valid java name */
    public static final void m215convert$lambda0(GradeAggregateLeaveInfoItemMoreSelect gradeAggregateLeaveInfoItemMoreSelect, BaseViewHolder baseViewHolder, BaseNode baseNode, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateLeaveInfoItemMoreSelect, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$helper");
        Intrinsics.checkNotNullParameter(baseNode, "$item");
        gradeAggregateLeaveInfoItemMoreSelect.showDialog(baseViewHolder, (UserLeaveComponentData) baseNode);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showDialog(BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData) {
        ShopLeaveInfoMoreSelectDialog shopLeaveInfoMoreSelectDialog = new ShopLeaveInfoMoreSelectDialog(getContext(), new GradeAggregateLeaveInfoItemMoreSelect$showDialog$dialog$1(userLeaveComponentData, baseViewHolder));
        shopLeaveInfoMoreSelectDialog.setData(userLeaveComponentData.getOptions());
        shopLeaveInfoMoreSelectDialog.show();
    }
}
