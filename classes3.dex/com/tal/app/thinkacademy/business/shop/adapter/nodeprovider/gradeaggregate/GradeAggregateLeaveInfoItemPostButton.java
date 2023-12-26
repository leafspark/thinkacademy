package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyData;
import com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyDataFormData;
import com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyYachProfile;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateEnum;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType;
import com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemPostButton;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "gotoPost", "data", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBodyData;", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemPostButton.kt */
public final class GradeAggregateLeaveInfoItemPostButton extends BaseNodeProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "留资组件";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemPostButton$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateLeaveInfoItemPostButton.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int getItemViewType() {
        return GradeAggregateEnum.LEAVE_INFO_POST_BUTTON.getValue();
    }

    public int getLayoutId() {
        return R.layout.bus_shop_aggregate_leaveinfo_item_post_button;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof UserLeaveButtonData) {
            int dp2px = SizeUtils.dp2px(8.0f);
            baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_TL(0);
            baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_TR(0);
            baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_BL(dp2px);
            baseViewHolder.getView(R.id.parentBgView).getDelegate().setCornerRadius_BR(dp2px);
            UserLeaveButtonData userLeaveButtonData = (UserLeaveButtonData) baseNode;
            if (userLeaveButtonData.isShowEmailSubscribe()) {
                baseViewHolder.setGone(R.id.llSeleted, false);
                baseViewHolder.getView(R.id.llSeleted).setSelected(userLeaveButtonData.getEmailSubscribe());
                baseViewHolder.getView(R.id.llSeleted).setOnClickListener(new GradeAggregateLeaveInfoItemPostButton$$ExternalSyntheticLambda0(baseNode, baseViewHolder));
            } else {
                baseViewHolder.setGone(R.id.llSeleted, true);
                userLeaveButtonData.setEmailSubscribe(false);
            }
            ((TextView) baseViewHolder.getView(R.id.tvSubmit)).setOnClickListener(new GradeAggregateLeaveInfoItemPostButton$$ExternalSyntheticLambda1(baseViewHolder, baseNode, this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-0  reason: not valid java name */
    public static final void m217convert$lambda0(BaseNode baseNode, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.checkNotNullParameter(baseNode, "$item");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$helper");
        UserLeaveButtonData userLeaveButtonData = (UserLeaveButtonData) baseNode;
        userLeaveButtonData.setEmailSubscribe(!userLeaveButtonData.getEmailSubscribe());
        baseViewHolder.getView(R.id.llSeleted).setSelected(userLeaveButtonData.getEmailSubscribe());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-2  reason: not valid java name */
    public static final void m218convert$lambda2(BaseViewHolder baseViewHolder, BaseNode baseNode, GradeAggregateLeaveInfoItemPostButton gradeAggregateLeaveInfoItemPostButton, View view) {
        boolean z;
        BaseNode baseNode2 = baseNode;
        GradeAggregateLeaveInfoItemPostButton gradeAggregateLeaveInfoItemPostButton2 = gradeAggregateLeaveInfoItemPostButton;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$helper");
        Intrinsics.checkNotNullParameter(baseNode2, "$item");
        Intrinsics.checkNotNullParameter(gradeAggregateLeaveInfoItemPostButton2, "this$0");
        int layoutPosition = baseViewHolder.getLayoutPosition();
        XesLog.it(TAG, new Object[]{Intrinsics.stringPlus("当前的pos = ", Integer.valueOf(layoutPosition))});
        UserLeaveButtonData userLeaveButtonData = (UserLeaveButtonData) baseNode2;
        List<UserLeaveComponentData> mLocalButtonTypeChild = userLeaveButtonData.getMLocalButtonTypeChild();
        int size = mLocalButtonTypeChild == null ? 0 : mLocalButtonTypeChild.size();
        userLeaveButtonData.setMLocalIsClick(true);
        BaseNodeAdapter adapter = gradeAggregateLeaveInfoItemPostButton.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(layoutPosition - size, size);
        }
        List arrayList = new ArrayList();
        LeaveInfoPostBodyData leaveInfoPostBodyData = new LeaveInfoPostBodyData(arrayList, (String) null, (String) null, false, (String) null, (List) null, (LeaveInfoPostBodyYachProfile) null, 126, (DefaultConstructorMarker) null);
        leaveInfoPostBodyData.setComponentId(userLeaveButtonData.getComponentId());
        leaveInfoPostBodyData.setEmailSubscribe(userLeaveButtonData.getEmailSubscribe());
        leaveInfoPostBodyData.setComponentName(userLeaveButtonData.getComponentName());
        leaveInfoPostBodyData.setTags(userLeaveButtonData.getTags());
        leaveInfoPostBodyData.setYachProfile(new LeaveInfoPostBodyYachProfile(userLeaveButtonData.getHost(), userLeaveButtonData.getSecret()));
        List<UserLeaveComponentData> mLocalButtonTypeChild2 = userLeaveButtonData.getMLocalButtonTypeChild();
        if (mLocalButtonTypeChild2 == null) {
            z = true;
        } else {
            z = true;
            int i = 0;
            for (Object next : mLocalButtonTypeChild2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UserLeaveComponentData userLeaveComponentData = (UserLeaveComponentData) next;
                XesLog.it(TAG, new Object[]{Intrinsics.stringPlus("选项数据为 = ", userLeaveComponentData.getMLocalSelectText())});
                LeaveInfoPostBodyDataFormData leaveInfoPostBodyDataFormData = new LeaveInfoPostBodyDataFormData((String) null, (String) null, (String) null, false, false, 31, (DefaultConstructorMarker) null);
                leaveInfoPostBodyDataFormData.setCustom(userLeaveComponentData.getCustom());
                leaveInfoPostBodyDataFormData.setKey(userLeaveComponentData.getKey());
                leaveInfoPostBodyDataFormData.setValue(userLeaveComponentData.getMLocalSelectText());
                leaveInfoPostBodyDataFormData.setMulti(userLeaveComponentData.getMLocalMulti());
                leaveInfoPostBodyDataFormData.setName(userLeaveComponentData.getName());
                if (Intrinsics.areEqual((Object) UserLeaveComponentDataKeyType.PHONE.getContent(), (Object) leaveInfoPostBodyDataFormData.getKey())) {
                    LeaveInfoPostBodyDataFormData leaveInfoPostBodyDataFormData2 = new LeaveInfoPostBodyDataFormData((String) null, (String) null, (String) null, false, false, 31, (DefaultConstructorMarker) null);
                    leaveInfoPostBodyDataFormData2.setCustom(userLeaveComponentData.getCustom());
                    leaveInfoPostBodyDataFormData2.setKey("areaCode");
                    leaveInfoPostBodyDataFormData2.setValue(userLeaveComponentData.getMLocalPhoneAreaNum());
                    leaveInfoPostBodyDataFormData2.setMulti(userLeaveComponentData.getMLocalMulti());
                    leaveInfoPostBodyDataFormData2.setName("areaCode");
                    arrayList.add(leaveInfoPostBodyDataFormData2);
                }
                arrayList.add(leaveInfoPostBodyDataFormData);
                if (userLeaveComponentData.getRequired()) {
                    CharSequence mLocalSelectText = userLeaveComponentData.getMLocalSelectText();
                    if (!(mLocalSelectText == null || StringsKt.isBlank(mLocalSelectText))) {
                        String key = userLeaveComponentData.getKey();
                        if (!Intrinsics.areEqual((Object) key, (Object) UserLeaveComponentDataKeyType.PHONE.getContent())) {
                            if (Intrinsics.areEqual((Object) key, (Object) UserLeaveComponentDataKeyType.EMAIL.getContent())) {
                                if (userLeaveComponentData.checkEmailIsValid()) {
                                }
                            }
                            i = i2;
                        } else if (userLeaveComponentData.checkPhoneIsValid()) {
                            i = i2;
                        }
                    }
                } else {
                    CharSequence mLocalSelectText2 = userLeaveComponentData.getMLocalSelectText();
                    if (!(mLocalSelectText2 == null || StringsKt.isBlank(mLocalSelectText2))) {
                        String key2 = userLeaveComponentData.getKey();
                        if (Intrinsics.areEqual((Object) key2, (Object) UserLeaveComponentDataKeyType.PHONE.getContent())) {
                            if (userLeaveComponentData.checkPhoneIsValid()) {
                            }
                        } else if (Intrinsics.areEqual((Object) key2, (Object) UserLeaveComponentDataKeyType.EMAIL.getContent())) {
                            if (userLeaveComponentData.checkEmailIsValid()) {
                            }
                        }
                    }
                    i = i2;
                }
                z = false;
                i = i2;
            }
        }
        if (z) {
            XesLog.dt(TAG, new Object[]{"开始提交数据"});
            gradeAggregateLeaveInfoItemPostButton2.gotoPost(leaveInfoPostBodyData);
        } else {
            XesLog.dt(TAG, new Object[]{"校验不通过，无法提交数据"});
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void gotoPost(LeaveInfoPostBodyData leaveInfoPostBodyData) {
        if (getContext() instanceof GradeAggregateActivity) {
            GradeAggregateActivity gradeAggregateActivity = (GradeAggregateActivity) getContext();
            gradeAggregateActivity.showLoading();
            gradeAggregateActivity.getGradeViewModel().postLeaveInfo(leaveInfoPostBodyData);
        }
    }
}
