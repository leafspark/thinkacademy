package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.view.View;
import android.widget.TextView;
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
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.KeyboardUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemInput;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "checkIsShowPrompt", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentData;", "convert", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getCurrentPhonePrefix", "setAreaInfo", "adapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/GradeAggregateAdapter;", "showPhoneAreaNumDialog", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemInput.kt */
public final class GradeAggregateLeaveInfoItemInput extends BaseNodeProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "留资组件";

    public final void getCurrentPhonePrefix() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemInput$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateLeaveInfoItemInput.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int getItemViewType() {
        return GradeAggregateEnum.LEAVE_INFO_INPUT.getValue();
    }

    public int getLayoutId() {
        return R.layout.bus_shop_aggregate_leaveinfo_item_input;
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
            boolean z = false;
            XesLog.it(TAG, new Object[]{sb.toString()});
            ClearEditText clearEditText = (ClearEditText) baseViewHolder.getView(R.id.inputTextView);
            KeyboardUtils.hideSoftInput((View) clearEditText);
            clearEditText.clearFocus();
            ((ClearEditText) baseViewHolder.getView(R.id.inputTextView)).addCustomTextWatcher(new GradeAggregateLeaveInfoItemInput$convert$2(baseNode));
            ((ClearEditText) baseViewHolder.getView(R.id.inputTextView)).setHint(userLeaveComponentData.getName());
            ((ClearEditText) baseViewHolder.getView(R.id.inputTextView)).setText(userLeaveComponentData.getMLocalSelectText());
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
            ((ClearEditText) baseViewHolder.getView(R.id.inputTextView)).setOnFocusListener(new GradeAggregateLeaveInfoItemInput$convert$3(baseViewHolder, this));
            if (Intrinsics.areEqual((Object) "phone", (Object) userLeaveComponentData.getKey())) {
                GradeAggregateAdapter adapter = getAdapter();
                if (adapter instanceof GradeAggregateAdapter) {
                    GradeAggregateAdapter gradeAggregateAdapter = adapter;
                    if (gradeAggregateAdapter.getMChosenCountryIndex() == -1) {
                        gradeAggregateAdapter.getPhoneAreaInfo();
                    }
                    setAreaInfo(userLeaveComponentData, gradeAggregateAdapter);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getContext().getString(R.string.Login_format_call_code);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.Login_format_call_code)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{gradeAggregateAdapter.getMPhoneAreaNum()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ((TextView) baseViewHolder.getView(R.id.text_phone_prefix)).setText(format);
                }
                baseViewHolder.setGone(R.id.btn_select_phone_prefix, false);
                ((ClearEditText) baseViewHolder.getView(R.id.inputTextView)).setInputType(2);
                baseViewHolder.getView(R.id.btn_select_phone_prefix).setOnClickListener(new GradeAggregateLeaveInfoItemInput$$ExternalSyntheticLambda0(this, baseViewHolder, baseNode));
            } else {
                baseViewHolder.setGone(R.id.btn_select_phone_prefix, true);
                ((ClearEditText) baseViewHolder.getView(R.id.inputTextView)).setInputType(1);
            }
            UserLeaveButtonData mLocalLeaveButtonData = userLeaveComponentData.getMLocalLeaveButtonData();
            if (mLocalLeaveButtonData != null && mLocalLeaveButtonData.getMLocalIsClick()) {
                z = true;
            }
            if (z) {
                checkIsShowPrompt(baseViewHolder, userLeaveComponentData);
            } else {
                baseViewHolder.setGone(R.id.promptTextView, true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-1  reason: not valid java name */
    public static final void m213convert$lambda1(GradeAggregateLeaveInfoItemInput gradeAggregateLeaveInfoItemInput, BaseViewHolder baseViewHolder, BaseNode baseNode, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateLeaveInfoItemInput, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$helper");
        Intrinsics.checkNotNullParameter(baseNode, "$item");
        gradeAggregateLeaveInfoItemInput.showPhoneAreaNumDialog(baseViewHolder, (UserLeaveComponentData) baseNode);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkIsShowPrompt(com.chad.library.adapter.base.viewholder.BaseViewHolder r8, com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData r9) {
        /*
            r7 = this;
            boolean r0 = r9.getRequired()
            java.lang.String r1 = "邮箱校验 showPrompt = "
            java.lang.String r2 = "手机号校验 showPrompt = "
            java.lang.String r3 = "留资组件"
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x008b
            java.lang.String r0 = r9.getMLocalSelectText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x001f
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = r4
            goto L_0x0020
        L_0x001f:
            r0 = r5
        L_0x0020:
            if (r0 == 0) goto L_0x002c
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r0 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_normal
            r8.setText(r9, r0)
            r9 = r5
            goto L_0x00fb
        L_0x002c:
            java.lang.String r0 = r9.getKey()
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType r6 = com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType.PHONE
            java.lang.String r6 = r6.getContent()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0059
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r1 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_phone
            r8.setText(r0, r1)
            boolean r9 = r9.checkPhoneIsValid()
            r9 = r9 ^ r5
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r3, r0)
            goto L_0x00fb
        L_0x0059:
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType r2 = com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType.EMAIL
            java.lang.String r2 = r2.getContent()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0082
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r2 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_email
            r8.setText(r0, r2)
            boolean r9 = r9.checkEmailIsValid()
            r9 = r9 ^ r5
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r9)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r3, r0)
            goto L_0x00fb
        L_0x0082:
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r0 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_normal
            r8.setText(r9, r0)
            goto L_0x00fa
        L_0x008b:
            java.lang.String r0 = r9.getMLocalSelectText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x009c
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x009a
            goto L_0x009c
        L_0x009a:
            r0 = r4
            goto L_0x009d
        L_0x009c:
            r0 = r5
        L_0x009d:
            if (r0 != 0) goto L_0x00fa
            java.lang.String r0 = r9.getKey()
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType r6 = com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType.PHONE
            java.lang.String r6 = r6.getContent()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00cb
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r1 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_phone
            r8.setText(r0, r1)
            boolean r9 = r9.checkPhoneIsValid()
            r9 = r9 ^ r5
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r3, r0)
            goto L_0x00fb
        L_0x00cb:
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType r2 = com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataKeyType.EMAIL
            java.lang.String r2 = r2.getContent()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x00f3
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r2 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_email
            r8.setText(r0, r2)
            boolean r9 = r9.checkEmailIsValid()
            r9 = r9 ^ r5
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r9)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r3, r0)
            goto L_0x00fb
        L_0x00f3:
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            int r0 = com.tal.app.thinkacademy.business.shop.R.string.leave_info_input_for_normal
            r8.setText(r9, r0)
        L_0x00fa:
            r9 = r4
        L_0x00fb:
            if (r9 == 0) goto L_0x0103
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            r8.setGone(r9, r4)
            goto L_0x0108
        L_0x0103:
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            r8.setGone(r9, r5)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateLeaveInfoItemInput.checkIsShowPrompt(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData):void");
    }

    /* access modifiers changed from: private */
    public final void setAreaInfo(UserLeaveComponentData userLeaveComponentData, GradeAggregateAdapter gradeAggregateAdapter) {
        int i;
        userLeaveComponentData.setMLocalPhoneAreaNum(gradeAggregateAdapter.getMPhoneAreaNum());
        userLeaveComponentData.setMLocalPhoneLengthMin(gradeAggregateAdapter.getMPhoneLengthMin());
        userLeaveComponentData.setMLocalPhoneLengthMax(gradeAggregateAdapter.getMPhoneLengthMax());
        if (gradeAggregateAdapter.getMChosenCountryIndex() < 0) {
            i = 0;
        } else {
            i = gradeAggregateAdapter.getMChosenCountryIndex();
        }
        userLeaveComponentData.setMLocalPhoneAreaIndex(i);
        XesLog.dt(TAG, new Object[]{"区号: " + userLeaveComponentData.getMLocalPhoneAreaNum() + ", 最小长度:" + userLeaveComponentData.getMLocalPhoneLengthMin() + " ,最大长度：" + userLeaveComponentData.getMLocalPhoneLengthMax()});
    }

    private final void showPhoneAreaNumDialog(BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData) {
        GradeAggregateAdapter adapter = getAdapter();
        if (adapter instanceof GradeAggregateAdapter) {
            GradeAggregateAdapter gradeAggregateAdapter = adapter;
            if (gradeAggregateAdapter.getMChosenCountryIndex() == -1) {
                gradeAggregateAdapter.getPhoneAreaInfo();
            }
            List<ConfigInfo.Country> internationalList = gradeAggregateAdapter.getInternationalList();
            ShopWheelDialog shopWheelDialog = new ShopWheelDialog(getContext(), new GradeAggregateLeaveInfoItemInput$showPhoneAreaNumDialog$dialog$1(internationalList, baseViewHolder, this, adapter, userLeaveComponentData));
            shopWheelDialog.setData(internationalList);
            shopWheelDialog.setCurrentIndex(userLeaveComponentData.getMLocalPhoneAreaIndex());
            shopWheelDialog.show();
        }
    }
}
