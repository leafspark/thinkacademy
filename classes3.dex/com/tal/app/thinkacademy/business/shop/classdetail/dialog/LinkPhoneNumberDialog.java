package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.flyco.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding;
import com.tal.app.thinkacademy.business.shop.databinding.ShopLinkPhoneNumberDialogLayoutBinding;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.ChosenSchoolBean;
import com.tal.app.thinkacademy.common.entity.SchoolContactInfo;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0002R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R@\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/LinkPhoneNumberDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopLinkPhoneNumberDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "phone", "callCode", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "mChangeCountryDialog", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopDialogWheelBinding;", "mChosenCountryIndex", "", "mChosenSchoolBean", "Lcom/tal/app/thinkacademy/common/entity/ChosenSchoolBean;", "mListener", "mPhoneLengthMax", "mPhoneLengthMin", "mSchoolCode", "mTempCountryIndex", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "getInternationalList", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "initData", "resetStatus", "showWheelDialog", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkPhoneNumberDialog.kt */
public final class LinkPhoneNumberDialog extends BaseBindDialog<ShopLinkPhoneNumberDialogLayoutBinding> {
    private BaseBindDialog<ShopDialogWheelBinding> mChangeCountryDialog;
    private int mChosenCountryIndex;
    private ChosenSchoolBean mChosenSchoolBean;
    private Function2<? super String, ? super String, Unit> mListener;
    /* access modifiers changed from: private */
    public int mPhoneLengthMax;
    /* access modifiers changed from: private */
    public int mPhoneLengthMin;
    private String mSchoolCode;
    private int mTempCountryIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkPhoneNumberDialog(Context context, Function2<? super String, ? super String, Unit> function2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function2;
        this.mChosenCountryIndex = -1;
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
        this.mSchoolCode = string;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        this.binding.dialogClose.setOnClickListener(new LinkPhoneNumberDialog$$ExternalSyntheticLambda3(this));
        this.binding.linkNumberBtnNext.setOnClickListener(new LinkPhoneNumberDialog$$ExternalSyntheticLambda1(this));
        this.binding.btnSelectPhonePrefix.setOnClickListener(new LinkPhoneNumberDialog$$ExternalSyntheticLambda0(this));
        this.binding.phoneEdit.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LinkPhoneNumberDialog this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                boolean z = false;
                if ((editable == null ? 0 : editable.length()) <= this.this$0.mPhoneLengthMax) {
                    if ((editable == null ? 0 : editable.length()) >= this.this$0.mPhoneLengthMin) {
                        z = true;
                    }
                }
                this.this$0.binding.linkNumberBtnNext.setEnabled(z);
            }
        });
        SchoolContactInfo schoolContactInfo = SchoolConstants.INSTANCE.getSchoolContactInfo(this.mSchoolCode);
        if (schoolContactInfo != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{context.getString(R.string.link_phone_num_dialog_tips), schoolContactInfo.getContactInfo()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String contactInfo = schoolContactInfo.getContactInfo();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = this.binding.linkNumberTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.linkNumberTips");
            textHighLightUtil.setTextHighLightWithClick(textView, format, contactInfo == null ? "" : contactInfo, R.color.color_3370FF, new LinkPhoneNumberDialog$$ExternalSyntheticLambda5(schoolContactInfo, context));
        }
        initData();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkPhoneNumberDialog(Context context, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function2);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m288_init_$lambda1(LinkPhoneNumberDialog linkPhoneNumberDialog, View view) {
        Intrinsics.checkNotNullParameter(linkPhoneNumberDialog, "this$0");
        linkPhoneNumberDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m289_init_$lambda2(LinkPhoneNumberDialog linkPhoneNumberDialog, View view) {
        Intrinsics.checkNotNullParameter(linkPhoneNumberDialog, "this$0");
        Function2<? super String, ? super String, Unit> function2 = linkPhoneNumberDialog.mListener;
        if (function2 != null) {
            String obj = StringsKt.trim(linkPhoneNumberDialog.binding.phoneEdit.getText().toString()).toString();
            CharSequence text = linkPhoneNumberDialog.binding.btnSelectPhonePrefix.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.btnSelectPhonePrefix.text");
            function2.invoke(obj, StringsKt.trim(text.subSequence(1, text.length()).toString()).toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m290_init_$lambda3(LinkPhoneNumberDialog linkPhoneNumberDialog, View view) {
        Intrinsics.checkNotNullParameter(linkPhoneNumberDialog, "this$0");
        Collection internationalList = linkPhoneNumberDialog.getInternationalList();
        if (internationalList == null || internationalList.isEmpty()) {
            ImConfig.INSTANCE.getConfigInfo();
        } else {
            linkPhoneNumberDialog.binding.phoneEdit.clearFocus();
            linkPhoneNumberDialog.showWheelDialog();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-5$lambda-4  reason: not valid java name */
    public static final void m291lambda5$lambda4(SchoolContactInfo schoolContactInfo, Context context, View view) {
        Intrinsics.checkNotNullParameter(schoolContactInfo, "$schoolContactInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        String str = "";
        if (schoolContactInfo.isPhone()) {
            String contactInfo = schoolContactInfo.getContactInfo();
            if (contactInfo != null) {
                str = contactInfo;
            }
            CommonUtilsKt.startCallPhoneNumber(str, context);
        } else {
            String contactInfo2 = schoolContactInfo.getContactInfo();
            if (contactInfo2 != null) {
                str = contactInfo2;
            }
            CommonUtilsKt.startCallEmail(str, context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void initData() {
        List<ConfigInfo.Country> internationalList;
        ChosenSchoolBean chosenSchoolBean = (ChosenSchoolBean) ShareDataManager.getInstance().getCacheEntity(ChosenSchoolBean.class, "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
        this.mChosenSchoolBean = chosenSchoolBean;
        if (chosenSchoolBean == null) {
            return;
        }
        if (this.mChosenCountryIndex == -1) {
            RoundTextView roundTextView = this.binding.btnSelectPhonePrefix;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.Login_format_call_code);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.Login_format_call_code)");
            Object[] objArr = new Object[1];
            ChosenSchoolBean chosenSchoolBean2 = this.mChosenSchoolBean;
            objArr[0] = chosenSchoolBean2 == null ? null : chosenSchoolBean2.countryCallingCode;
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            roundTextView.setText(format);
            ChosenSchoolBean chosenSchoolBean3 = this.mChosenSchoolBean;
            this.mPhoneLengthMin = chosenSchoolBean3 == null ? 1 : chosenSchoolBean3.phoneMinLength;
            ChosenSchoolBean chosenSchoolBean4 = this.mChosenSchoolBean;
            this.mPhoneLengthMax = chosenSchoolBean4 == null ? 99 : chosenSchoolBean4.phoneMaxLength;
            SchoolConstants schoolConstants = SchoolConstants.INSTANCE;
            ChosenSchoolBean chosenSchoolBean5 = this.mChosenSchoolBean;
            SchoolDataInfo schoolInfo = schoolConstants.getSchoolInfo(chosenSchoolBean5 == null ? 0 : chosenSchoolBean5.schoolCode);
            if (schoolInfo != null) {
                this.mPhoneLengthMin = schoolInfo.getPhoneMinLength();
                this.mPhoneLengthMax = schoolInfo.getPhoneMaxLength();
            }
            this.binding.phoneEdit.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
            if (getInternationalList() != null && (internationalList = getInternationalList()) != null) {
                int i = 0;
                for (Object next : internationalList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ConfigInfo.Country country = (ConfigInfo.Country) next;
                    ChosenSchoolBean chosenSchoolBean6 = this.mChosenSchoolBean;
                    if (Intrinsics.areEqual((Object) chosenSchoolBean6 == null ? null : chosenSchoolBean6.countryCallingCode, (Object) country.getCountryCallingCode())) {
                        this.mChosenCountryIndex = i;
                        this.mPhoneLengthMin = country.getPhoneMinLength();
                        this.mPhoneLengthMax = country.getPhoneMaxLength();
                        this.binding.phoneEdit.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
                        return;
                    }
                    i = i2;
                }
                return;
            }
            return;
        }
        List<ConfigInfo.Country> internationalList2 = getInternationalList();
        if (internationalList2 != null) {
            ConfigInfo.Country country2 = internationalList2.get(this.mChosenCountryIndex);
            RoundTextView roundTextView2 = this.binding.btnSelectPhonePrefix;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getContext().getString(R.string.Login_format_call_code);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.Login_format_call_code)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{country2.getCountryCallingCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            roundTextView2.setText(format2);
            this.mPhoneLengthMin = country2.getPhoneMinLength();
            this.mPhoneLengthMax = country2.getPhoneMaxLength();
            this.binding.phoneEdit.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
        }
    }

    private final List<ConfigInfo.Country> getInternationalList() {
        return ImConfig.INSTANCE.getInternationalInfo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f2, code lost:
        r2 = r2.binding;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showWheelDialog() {
        /*
            r5 = this;
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            r1 = 0
            if (r0 != 0) goto L_0x016a
            android.content.Context r0 = r5.getContext()
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$showWheelDialog$1 r2 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$showWheelDialog$1
            r2.<init>(r0)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog r2 = (com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog) r2
            r5.mChangeCountryDialog = r2
            r0 = 80
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r2.gravity(r0)
            if (r0 != 0) goto L_0x001b
            goto L_0x002f
        L_0x001b:
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r0.layoutParams(r2)
            if (r0 != 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            r2 = 1
            r0.canceledOnTouchOutside(r2)
        L_0x002f:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x0034
            goto L_0x0044
        L_0x0034:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x003b
            goto L_0x0044
        L_0x003b:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x0040
            goto L_0x0044
        L_0x0040:
            r2 = 0
            r0.setCyclic(r2)
        L_0x0044:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x0049
            goto L_0x005e
        L_0x0049:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0050
            goto L_0x005e
        L_0x0050:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x0055
            goto L_0x005e
        L_0x0055:
            r2 = 1114636288(0x42700000, float:60.0)
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r2)
            r0.setItemHeight(r2)
        L_0x005e:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x0063
            goto L_0x0078
        L_0x0063:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x006a
            goto L_0x0078
        L_0x006a:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x006f
            goto L_0x0078
        L_0x006f:
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r2)
            r0.setRoundRadius(r2)
        L_0x0078:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x007d
            goto L_0x0096
        L_0x007d:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0084
            goto L_0x0096
        L_0x0084:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x0089
            goto L_0x0096
        L_0x0089:
            android.content.Context r2 = r5.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_ffaa0a
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r0.setTextColorCenter(r2)
        L_0x0096:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x009b
            goto L_0x00b4
        L_0x009b:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x00a2
            goto L_0x00b4
        L_0x00a2:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x00a7
            goto L_0x00b4
        L_0x00a7:
            android.content.Context r2 = r5.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r0.setTextColorOut(r2)
        L_0x00b4:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x00b9
            goto L_0x00d2
        L_0x00b9:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x00c0
            goto L_0x00d2
        L_0x00c0:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x00c5
            goto L_0x00d2
        L_0x00c5:
            android.content.Context r2 = r5.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_14ffaa0a
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r0.setDividerColor(r2)
        L_0x00d2:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x00d7
            goto L_0x00e8
        L_0x00d7:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x00de
            goto L_0x00e8
        L_0x00de:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x00e3
            goto L_0x00e8
        L_0x00e3:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView$DividerType r2 = com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView.DividerType.ROUND_RECT
            r0.setDividerType(r2)
        L_0x00e8:
            java.util.List r0 = r5.getInternationalList()
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r2 = r5.mChangeCountryDialog
            if (r2 != 0) goto L_0x00f2
        L_0x00f0:
            r2 = r1
            goto L_0x00fb
        L_0x00f2:
            androidx.viewbinding.ViewBinding r2 = r2.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r2
            if (r2 != 0) goto L_0x00f9
            goto L_0x00f0
        L_0x00f9:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r2 = r2.wheelView
        L_0x00fb:
            if (r2 != 0) goto L_0x00fe
            goto L_0x0108
        L_0x00fe:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$showWheelDialog$2 r3 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$showWheelDialog$2
            r3.<init>(r0)
            com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter r3 = (com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter) r3
            r2.setAdapter(r3)
        L_0x0108:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r2 = r5.mChangeCountryDialog
            if (r2 != 0) goto L_0x010d
            goto L_0x0116
        L_0x010d:
            androidx.viewbinding.ViewBinding r2 = r2.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r2
            if (r2 != 0) goto L_0x0114
            goto L_0x0116
        L_0x0114:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r2.wheelView
        L_0x0116:
            if (r1 != 0) goto L_0x0119
            goto L_0x011e
        L_0x0119:
            int r2 = r5.mChosenCountryIndex
            r1.setCurrentItem(r2)
        L_0x011e:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r5.mChangeCountryDialog
            if (r1 != 0) goto L_0x0123
            goto L_0x0137
        L_0x0123:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x012a
            goto L_0x0137
        L_0x012a:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x012f
            goto L_0x0137
        L_0x012f:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$$ExternalSyntheticLambda6 r2 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$$ExternalSyntheticLambda6
            r2.<init>(r5)
            r1.setOnItemSelectedListener(r2)
        L_0x0137:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r5.mChangeCountryDialog
            if (r1 != 0) goto L_0x013c
            goto L_0x0150
        L_0x013c:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0143
            goto L_0x0150
        L_0x0143:
            android.widget.ImageView r1 = r1.ivCancel
            if (r1 != 0) goto L_0x0148
            goto L_0x0150
        L_0x0148:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$$ExternalSyntheticLambda2 r2 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$$ExternalSyntheticLambda2
            r2.<init>(r5)
            r1.setOnClickListener(r2)
        L_0x0150:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r5.mChangeCountryDialog
            if (r1 != 0) goto L_0x0155
            goto L_0x017e
        L_0x0155:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x015c
            goto L_0x017e
        L_0x015c:
            android.widget.ImageView r1 = r1.ivConfirm
            if (r1 != 0) goto L_0x0161
            goto L_0x017e
        L_0x0161:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$$ExternalSyntheticLambda4 r2 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog$$ExternalSyntheticLambda4
            r2.<init>(r5, r0)
            r1.setOnClickListener(r2)
            goto L_0x017e
        L_0x016a:
            if (r0 != 0) goto L_0x016d
            goto L_0x0176
        L_0x016d:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0174
            goto L_0x0176
        L_0x0174:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r0.wheelView
        L_0x0176:
            if (r1 != 0) goto L_0x0179
            goto L_0x017e
        L_0x0179:
            int r0 = r5.mChosenCountryIndex
            r1.setCurrentItem(r0)
        L_0x017e:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r5.mChangeCountryDialog
            if (r0 != 0) goto L_0x0183
            goto L_0x0186
        L_0x0183:
            r0.show()
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog.showWheelDialog():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showWheelDialog$lambda-10  reason: not valid java name */
    public static final void m292showWheelDialog$lambda10(LinkPhoneNumberDialog linkPhoneNumberDialog, int i) {
        Intrinsics.checkNotNullParameter(linkPhoneNumberDialog, "this$0");
        XesLog.dt("LoginActivity", new Object[]{Intrinsics.stringPlus("index = ", Integer.valueOf(i))});
        linkPhoneNumberDialog.mTempCountryIndex = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: showWheelDialog$lambda-11  reason: not valid java name */
    public static final void m293showWheelDialog$lambda11(LinkPhoneNumberDialog linkPhoneNumberDialog, View view) {
        Intrinsics.checkNotNullParameter(linkPhoneNumberDialog, "this$0");
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = linkPhoneNumberDialog.mChangeCountryDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showWheelDialog$lambda-12  reason: not valid java name */
    public static final void m294showWheelDialog$lambda12(LinkPhoneNumberDialog linkPhoneNumberDialog, List list, View view) {
        Intrinsics.checkNotNullParameter(linkPhoneNumberDialog, "this$0");
        linkPhoneNumberDialog.mChosenCountryIndex = linkPhoneNumberDialog.mTempCountryIndex;
        Intrinsics.checkNotNull(list);
        ConfigInfo.Country country = (ConfigInfo.Country) list.get(linkPhoneNumberDialog.mChosenCountryIndex);
        RoundTextView roundTextView = linkPhoneNumberDialog.binding.btnSelectPhonePrefix;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = linkPhoneNumberDialog.getContext().getString(R.string.Login_format_call_code);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.Login_format_call_code)");
        String format = String.format(string, Arrays.copyOf(new Object[]{country.getCountryCallingCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        roundTextView.setText(format);
        linkPhoneNumberDialog.mPhoneLengthMin = country.getPhoneMinLength();
        linkPhoneNumberDialog.mPhoneLengthMax = country.getPhoneMaxLength();
        linkPhoneNumberDialog.binding.phoneEdit.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(linkPhoneNumberDialog.mPhoneLengthMax)});
        linkPhoneNumberDialog.resetStatus();
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = linkPhoneNumberDialog.mChangeCountryDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void resetStatus() {
        this.binding.phoneEdit.setText("");
    }

    /* access modifiers changed from: protected */
    public ShopLinkPhoneNumberDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopLinkPhoneNumberDialogLayoutBinding inflate = ShopLinkPhoneNumberDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
