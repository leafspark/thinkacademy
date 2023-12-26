package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateEnum;
import com.tal.app.thinkacademy.business.shop.bean.LeaveDataType;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ShopWheelDialog;
import com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.common.user.GradeStage;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0002J4\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00102\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemSelect;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "showDialog", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentData;", "showGradeDialog", "mGradeList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/common/user/Grade;", "Lkotlin/collections/ArrayList;", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemSelect.kt */
public final class GradeAggregateLeaveInfoItemSelect extends BaseNodeProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "留资组件";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateLeaveInfoItemSelect.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemSelect$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateLeaveInfoItemSelect.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int getItemViewType() {
        return GradeAggregateEnum.LEAVE_INFO_SINGLE_SELECT.getValue();
    }

    public int getLayoutId() {
        return R.layout.bus_shop_aggregate_leaveinfo_item_select;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof UserLeaveComponentData) {
            StringBuilder sb = new StringBuilder();
            sb.append("数据更新 = ");
            sb.append(baseViewHolder.getLayoutPosition());
            sb.append(" name = ");
            UserLeaveComponentData userLeaveComponentData = (UserLeaveComponentData) baseNode;
            sb.append(userLeaveComponentData.getName());
            XesLog.it(TAG, new Object[]{sb.toString()});
            ((TextView) baseViewHolder.getView(R.id.singleSelectText)).setHint(userLeaveComponentData.getName());
            ((TextView) baseViewHolder.getView(R.id.singleSelectText)).setText(userLeaveComponentData.getMLocalSelectText());
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
            baseViewHolder.getView(R.id.singleSelectGroup).setOnClickListener(new GradeAggregateLeaveInfoItemSelect$$ExternalSyntheticLambda0(baseNode, this, baseViewHolder));
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
    public static final void m221convert$lambda0(BaseNode baseNode, GradeAggregateLeaveInfoItemSelect gradeAggregateLeaveInfoItemSelect, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.checkNotNullParameter(baseNode, "$item");
        Intrinsics.checkNotNullParameter(gradeAggregateLeaveInfoItemSelect, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$helper");
        UserLeaveComponentData userLeaveComponentData = (UserLeaveComponentData) baseNode;
        if (Intrinsics.areEqual((Object) userLeaveComponentData.getKey(), (Object) "gradeId")) {
            gradeAggregateLeaveInfoItemSelect.showGradeDialog(baseViewHolder, userLeaveComponentData);
        } else {
            gradeAggregateLeaveInfoItemSelect.showDialog(baseViewHolder, userLeaveComponentData);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showDialog(BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData) {
        ShopWheelDialog shopWheelDialog = new ShopWheelDialog(getContext(), new GradeAggregateLeaveInfoItemSelect$showDialog$dialog$1(userLeaveComponentData, baseViewHolder));
        shopWheelDialog.setData(userLeaveComponentData.getOptions());
        shopWheelDialog.show();
    }

    private final void showGradeDialog(BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData) {
        boolean z = false;
        if (getContext() instanceof GradeAggregateActivity) {
            LifecycleOwner lifecycleOwner = (GradeAggregateActivity) getContext();
            XesLog.it(TAG, new Object[]{"这是聚合详情页@@"});
            GradeAggregateAdapter adapter = getAdapter();
            if (adapter instanceof GradeAggregateAdapter) {
                GradeAggregateAdapter gradeAggregateAdapter = adapter;
                Collection mGradeList = gradeAggregateAdapter.getMGradeList();
                if (mGradeList == null || mGradeList.isEmpty()) {
                    XesLog.it(TAG, new Object[]{"需要请求年级数据"});
                    z = true;
                } else {
                    showGradeDialog(baseViewHolder, userLeaveComponentData, gradeAggregateAdapter.getMGradeList());
                    XesLog.it(TAG, new Object[]{"不需需要请求年级数据"});
                }
                if (z) {
                    lifecycleOwner.getGradeViewModel().getGradeStageLists().observe(lifecycleOwner, new GradeAggregateLeaveInfoItemSelect$$ExternalSyntheticLambda1(lifecycleOwner, adapter, this, baseViewHolder, userLeaveComponentData));
                    lifecycleOwner.showLoading();
                    lifecycleOwner.getGradeViewModel().getGradeStageLists();
                    return;
                }
                return;
            }
            return;
        }
        XesLog.it(TAG, new Object[]{"不是聚合详情页"});
    }

    /* access modifiers changed from: private */
    /* renamed from: showGradeDialog$lambda-2  reason: not valid java name */
    public static final void m222showGradeDialog$lambda2(GradeAggregateActivity gradeAggregateActivity, BaseNodeAdapter baseNodeAdapter, GradeAggregateLeaveInfoItemSelect gradeAggregateLeaveInfoItemSelect, BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData, StateData stateData) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "$activity");
        Intrinsics.checkNotNullParameter(gradeAggregateLeaveInfoItemSelect, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$helper");
        Intrinsics.checkNotNullParameter(userLeaveComponentData, "$item");
        gradeAggregateActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            XesLog.it(TAG, new Object[]{"请求年级数据成功"});
            GradeStageList gradeStageList = (GradeStageList) stateData.getData();
            if (gradeStageList != null) {
                ArrayList arrayList = new ArrayList();
                List list = gradeStageList.getList();
                int size = list.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 1;
                    List list2 = ((GradeStage) list.get(i)).getList();
                    int size2 = list2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        arrayList.add((Grade) list2.get(i3));
                    }
                    i = i2;
                }
                GradeAggregateAdapter gradeAggregateAdapter = (GradeAggregateAdapter) baseNodeAdapter;
                gradeAggregateAdapter.setMGradeList(arrayList);
                gradeAggregateLeaveInfoItemSelect.showGradeDialog(baseViewHolder, userLeaveComponentData, gradeAggregateAdapter.getMGradeList());
                return;
            }
            return;
        }
        XesLog.it(TAG, new Object[]{"请求年级数据失败"});
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
    }

    private final void showGradeDialog(BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData, ArrayList<Grade> arrayList) {
        ShopWheelDialog shopWheelDialog = new ShopWheelDialog(getContext(), new GradeAggregateLeaveInfoItemSelect$showGradeDialog$dialog$1(userLeaveComponentData, baseViewHolder));
        shopWheelDialog.setData(arrayList);
        shopWheelDialog.show();
    }
}
