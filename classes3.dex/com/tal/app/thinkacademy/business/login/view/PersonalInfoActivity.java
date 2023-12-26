package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding;
import com.tal.app.thinkacademy.business.login.entity.UseGetInfo;
import com.tal.app.thinkacademy.business.login.presenter.PersonalInfoViewModel;
import com.tal.app.thinkacademy.business.login.widget.PersonalInfoItem;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.common.user.GradeStage;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.widget.TextInputFilter;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bH\u0014J\b\u0010.\u001a\u00020\u0013H\u0002J\b\u0010/\u001a\u00020\u0013H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\u0018\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020)H\u0002J\"\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0012\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010>\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\u001a\u0010A\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010B\u001a\u00020\bH\u0016J\u0012\u0010C\u001a\u00020)2\b\b\u0002\u0010D\u001a\u00020\bH\u0002J\b\u0010E\u001a\u00020)H\u0002J\b\u0010F\u001a\u00020)H\u0002J\b\u0010G\u001a\u00020)H\u0002J\b\u0010H\u001a\u00020)H\u0002J\b\u0010I\u001a\u00020)H\u0002J\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020)H\u0002J\u0010\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\u0015H\u0002J\b\u0010N\u001a\u00020)H\u0017J\u0010\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/PersonalInfoActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/PersonalInfoViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityPersonalInfoBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "()V", "easternNameOrderEnabled", "", "mChangeDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mChooseDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mContactItemList", "", "Lcom/tal/app/thinkacademy/business/login/widget/PersonalInfoItem;", "mCropParameterStyle", "Lcom/luck/picture/lib/style/PictureCropParameterStyle;", "mFromPath", "", "mGradeId", "", "Ljava/lang/Integer;", "mGradeList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/common/user/Grade;", "Lkotlin/collections/ArrayList;", "mGradePosition", "mHasChangeAvatar", "mMaxDisplayNameLength", "mNameOneKeyListen", "Landroid/text/method/KeyListener;", "mNameTwoKeyListen", "mNickNameKeyListen", "mOnlyChangePhoto", "mPhotoPath", "mPhotoUrl", "mUserInfo", "Lcom/tal/app/thinkacademy/business/login/entity/UseGetInfo;", "tag", "clearFocus", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getFirstName", "getLastName", "getUserInfo", "hideFullLoading", "loadAvatar", "path", "hasChange", "modifyUserBasicInfo", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "hasFocus", "saveUserInfo", "onlyAvatar", "setDisplayNameHint", "setListener", "setViewValues", "showFullLoading", "showFullLoadingError", "showGradeDialog", "showUserInfo", "showWarning", "visibility", "startObserve", "track", "key", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoActivity.kt */
public final class PersonalInfoActivity extends BaseVmActivity<PersonalInfoViewModel, ActivityPersonalInfoBinding> implements View.OnClickListener, ClearEditText.OnFocusListener {
    private boolean easternNameOrderEnabled;
    private WheelDialog mChangeDialog;
    /* access modifiers changed from: private */
    public BaseDialog mChooseDialog;
    private List<PersonalInfoItem> mContactItemList = new ArrayList();
    private PictureCropParameterStyle mCropParameterStyle;
    private String mFromPath;
    /* access modifiers changed from: private */
    public Integer mGradeId = 0;
    /* access modifiers changed from: private */
    public ArrayList<Grade> mGradeList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int mGradePosition = -1;
    private boolean mHasChangeAvatar;
    private final int mMaxDisplayNameLength = 65;
    private KeyListener mNameOneKeyListen;
    private KeyListener mNameTwoKeyListen;
    private KeyListener mNickNameKeyListen;
    /* access modifiers changed from: private */
    public boolean mOnlyChangePhoto;
    private String mPhotoPath = "";
    /* access modifiers changed from: private */
    public String mPhotoUrl = "";
    /* access modifiers changed from: private */
    public UseGetInfo mUserInfo;
    private final String tag = "PersonalInfoActivity";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalInfoActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public ActivityPersonalInfoBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityPersonalInfoBinding inflate = ActivityPersonalInfoBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PersonalInfoActivity.super.onCreate(bundle);
        LoginTrack.INSTANCE.personalInfoPageShow();
        boolean z = false;
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        this.mFromPath = getIntent().getStringExtra("page_path");
        SchoolDataInfo currentSchoolInfo = SchoolConstants.INSTANCE.getCurrentSchoolInfo();
        if (currentSchoolInfo != null) {
            z = currentSchoolInfo.getEasternNameOrderEnabled();
        }
        this.easternNameOrderEnabled = z;
        getUserInfo();
        setViewValues();
        setListener();
        track("edit_profile_page_pv");
    }

    /* access modifiers changed from: private */
    public final void getUserInfo() {
        showFullLoading();
        getMViewModel().getUserInfo();
    }

    private final void hideFullLoading() {
        getBinding().statusLoading.restoreView();
    }

    private final void showFullLoading() {
        getBinding().statusLoading.showFullLoadingView(R.color.color_F4F6FA);
    }

    private final void showFullLoadingError() {
        LoadStatusView loadStatusView = getBinding().statusLoading;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.statusLoading");
        String string = getString(R.string.retry);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.retry)");
        LoadStatusView.showErrorView$default(loadStatusView, 0, (String) null, string, (String) null, new PersonalInfoActivity$showFullLoadingError$1(this), 11, (Object) null);
        getBinding().statusLoading.setContentBg(R.color.color_F4F6FA);
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getMUserGetInfo().observe(lifecycleOwner, new PersonalInfoActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().getGradeStageList().observe(lifecycleOwner, new PersonalInfoActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().getChangeUser().observe(lifecycleOwner, new PersonalInfoActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        r0 = r0.getLinkedAccount();
     */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m106startObserve$lambda1(com.tal.app.thinkacademy.business.login.view.PersonalInfoActivity r14, com.tal.app.thinkacademy.common.entity.StateData r15) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r0 = r15.getStatus()
            int[] r1 = com.tal.app.thinkacademy.business.login.view.PersonalInfoActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 != r1) goto L_0x00fc
            r14.hideFullLoading()
            java.lang.Object r0 = r15.getData()
            com.tal.app.thinkacademy.business.login.entity.UseGetInfo r0 = (com.tal.app.thinkacademy.business.login.entity.UseGetInfo) r0
            r14.mUserInfo = r0
            java.lang.Object r0 = r15.getData()
            com.tal.app.thinkacademy.business.login.entity.UseGetInfo r0 = (com.tal.app.thinkacademy.business.login.entity.UseGetInfo) r0
            r2 = 0
            if (r0 != 0) goto L_0x002a
        L_0x0028:
            r0 = r2
            goto L_0x0035
        L_0x002a:
            java.util.List r0 = r0.getLinkedAccount()
            if (r0 != 0) goto L_0x0031
            goto L_0x0028
        L_0x0031:
            int r0 = r0.size()
        L_0x0035:
            if (r0 <= 0) goto L_0x00e0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Object r15 = r15.getData()
            com.tal.app.thinkacademy.business.login.entity.UseGetInfo r15 = (com.tal.app.thinkacademy.business.login.entity.UseGetInfo) r15
            if (r15 != 0) goto L_0x0045
            goto L_0x009e
        L_0x0045:
            java.util.List r15 = r15.getLinkedAccount()
            if (r15 != 0) goto L_0x004c
            goto L_0x009e
        L_0x004c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
            r4 = r2
        L_0x0053:
            boolean r5 = r15.hasNext()
            if (r5 == 0) goto L_0x009e
            java.lang.Object r5 = r15.next()
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x0064
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0064:
            com.tal.app.thinkacademy.business.login.entity.LinkedAccount r5 = (com.tal.app.thinkacademy.business.login.entity.LinkedAccount) r5
            com.tal.app.thinkacademy.business.login.widget.PersonalInfoItem r13 = new com.tal.app.thinkacademy.business.login.widget.PersonalInfoItem
            r8 = r14
            android.content.Context r8 = (android.content.Context) r8
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            r13.setData(r5)
            java.util.List<com.tal.app.thinkacademy.business.login.widget.PersonalInfoItem> r7 = r14.mContactItemList
            r7.add(r13)
            androidx.viewbinding.ViewBinding r7 = r14.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r7 = (com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding) r7
            android.widget.LinearLayout r7 = r7.contactInfoLayout
            android.view.View r13 = (android.view.View) r13
            r7.addView(r13)
            if (r5 != 0) goto L_0x008c
            r5 = 0
            goto L_0x0090
        L_0x008c:
            java.lang.String r5 = r5.getName()
        L_0x0090:
            r3.append(r5)
            int r5 = r0 + -1
            if (r4 == r5) goto L_0x009c
            java.lang.String r4 = "/"
            r3.append(r4)
        L_0x009c:
            r4 = r6
            goto L_0x0053
        L_0x009e:
            kotlin.jvm.internal.StringCompanionObject r15 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            int r15 = com.tal.app.thinkacademy.business.login.R.string.personal_contac_info_desc
            java.lang.String r15 = r14.getString(r15)
            java.lang.String r0 = "getString(R.string.personal_contac_info_desc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r0)
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r0[r2] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r15 = java.lang.String.format(r15, r0)
            java.lang.String r0 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r0)
            androidx.viewbinding.ViewBinding r0 = r14.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding) r0
            android.widget.TextView r0 = r0.contactDesc
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0.setText(r15)
            androidx.viewbinding.ViewBinding r15 = r14.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r15 = (com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding) r15
            android.widget.LinearLayout r15 = r15.contactInfoLayout
            r15.setVisibility(r2)
            androidx.viewbinding.ViewBinding r15 = r14.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r15 = (com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding) r15
            android.widget.TextView r15 = r15.contactDesc
            r15.setVisibility(r2)
            goto L_0x00f8
        L_0x00e0:
            androidx.viewbinding.ViewBinding r15 = r14.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r15 = (com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding) r15
            android.widget.LinearLayout r15 = r15.contactInfoLayout
            r0 = 8
            r15.setVisibility(r0)
            androidx.viewbinding.ViewBinding r15 = r14.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r15 = (com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding) r15
            android.widget.TextView r15 = r15.contactDesc
            r15.setVisibility(r0)
        L_0x00f8:
            r14.showUserInfo()
            goto L_0x00ff
        L_0x00fc:
            r14.showFullLoadingError()
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.PersonalInfoActivity.m106startObserve$lambda1(com.tal.app.thinkacademy.business.login.view.PersonalInfoActivity, com.tal.app.thinkacademy.common.entity.StateData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-2  reason: not valid java name */
    public static final void m107startObserve$lambda2(PersonalInfoActivity personalInfoActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(personalInfoActivity, "this$0");
        personalInfoActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            GradeStageList gradeStageList = (GradeStageList) stateData.getData();
            List list = gradeStageList == null ? null : gradeStageList.getList();
            if (list == null) {
                list = new ArrayList();
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                List list2 = ((GradeStage) list.get(i)).getList();
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    int i4 = i3 + 1;
                    Grade grade = (Grade) list2.get(i3);
                    personalInfoActivity.mGradeList.add(grade);
                    UseGetInfo useGetInfo = personalInfoActivity.mUserInfo;
                    if (useGetInfo != null && useGetInfo.getGradeId() == grade.getValue()) {
                        personalInfoActivity.mGradePosition = personalInfoActivity.mGradeList.size() - 1;
                    }
                    i3 = i4;
                }
                i = i2;
            }
            personalInfoActivity.showGradeDialog();
            return;
        }
        personalInfoActivity.showToast(personalInfoActivity.getString(R.string.fail_hint));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-3  reason: not valid java name */
    public static final void m108startObserve$lambda3(PersonalInfoActivity personalInfoActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(personalInfoActivity, "this$0");
        personalInfoActivity.hideLoading();
        String str = personalInfoActivity.tag;
        XesLog.dt(str, new Object[]{"status = " + stateData.getStatus() + " code = " + stateData.getCode()});
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            personalInfoActivity.track("edit_profile_success");
            personalInfoActivity.showToast(personalInfoActivity.getString(R.string.edit_successful));
            if (personalInfoActivity.mOnlyChangePhoto) {
                personalInfoActivity.saveUserInfo(true);
                UseGetInfo useGetInfo = personalInfoActivity.mUserInfo;
                if (useGetInfo != null) {
                    useGetInfo.setAvatar(personalInfoActivity.mPhotoUrl);
                    return;
                }
                return;
            }
            saveUserInfo$default(personalInfoActivity, false, 1, (Object) null);
            personalInfoActivity.finish();
            return;
        }
        personalInfoActivity.showToast(personalInfoActivity.getString(R.string.edit_failed));
    }

    private final void setViewValues() {
        Context context = (Context) this;
        this.mCropParameterStyle = new PictureCropParameterStyle(ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.picture_color_black), true);
        String string = ShareDataManager.getInstance().getString("user_avatar", getResources().getResourceName(R.drawable.self_image_user), ShareDataManager.SHAREDATA_USER);
        Intrinsics.checkNotNullExpressionValue(string, "userAvatar");
        loadAvatar(string, false);
        if (this.mUserInfo != null) {
            showUserInfo();
        }
        getBinding().tvSave.setOnClickListener(this);
        getBinding().etNickname.setFilters(new TextInputFilter[]{new TextInputFilter()});
        getBinding().etNameOne.setFilters(new TextInputFilter[]{new TextInputFilter()});
        getBinding().etNameTwo.setFilters(new TextInputFilter[]{new TextInputFilter()});
        this.mNickNameKeyListen = getBinding().etNickname.getKeyListener();
        this.mNameOneKeyListen = getBinding().etNameOne.getKeyListener();
        this.mNameTwoKeyListen = getBinding().etNameTwo.getKeyListener();
        if (!getBinding().etNickname.hasFocus()) {
            getBinding().etNickname.setKeyListener((KeyListener) null);
            getBinding().etNickname.setText(getBinding().etNickname.getText());
        }
        if (!getBinding().etNameOne.hasFocus()) {
            getBinding().etNameOne.setKeyListener((KeyListener) null);
            getBinding().etNameOne.setText(getBinding().etNameOne.getText());
        }
        if (!getBinding().etNameTwo.hasFocus()) {
            getBinding().etNameTwo.setKeyListener((KeyListener) null);
            getBinding().etNameTwo.setText(getBinding().etNameTwo.getText());
        }
        ClearEditText.OnFocusListener onFocusListener = this;
        getBinding().etNickname.setOnFocusListener(onFocusListener);
        getBinding().etNameOne.setOnFocusListener(onFocusListener);
        getBinding().etNameTwo.setOnFocusListener(onFocusListener);
        getBinding().etNickname.addCustomTextWatcher(new PersonalInfoActivity$setViewValues$1(this, this.mMaxDisplayNameLength, getBinding().etNickname));
        getBinding().etNameOne.addCustomTextWatcher(new PersonalInfoActivity$setViewValues$2(this, getBinding().etNameOne));
        getBinding().etNameTwo.addCustomTextWatcher(new PersonalInfoActivity$setViewValues$3(this, getBinding().etNameTwo));
    }

    /* access modifiers changed from: private */
    public final void setDisplayNameHint() {
        String firstName = getFirstName();
        String lastName = getLastName();
        boolean z = true;
        if (firstName.length() == 0) {
            if (lastName.length() != 0) {
                z = false;
            }
            if (z) {
                getBinding().etNickname.setHint(getString(R.string.enter_display_name));
                return;
            }
        }
        getBinding().etNickname.setHint(firstName + ' ' + lastName);
    }

    private final void showUserInfo() {
        boolean z = this.easternNameOrderEnabled;
        boolean z2 = true;
        String str = null;
        if (z) {
            getBinding().tvNameOne.setText(getString(R.string.last_name));
            getBinding().etNameOne.setHint(getString(R.string.enter_last_name));
            getBinding().tvNameTwo.setText(getString(R.string.first_name));
            getBinding().etNameTwo.setHint(getString(R.string.enter_first_name));
            ClearEditText clearEditText = getBinding().etNameOne;
            UseGetInfo useGetInfo = this.mUserInfo;
            clearEditText.setText(useGetInfo == null ? null : useGetInfo.getLastName());
            ClearEditText clearEditText2 = getBinding().etNameTwo;
            UseGetInfo useGetInfo2 = this.mUserInfo;
            clearEditText2.setText(useGetInfo2 == null ? null : useGetInfo2.getFirstName());
        } else if (!z) {
            getBinding().tvNameOne.setText(getString(R.string.first_name));
            getBinding().etNameOne.setHint(getString(R.string.enter_first_name));
            getBinding().tvNameTwo.setText(getString(R.string.last_name));
            getBinding().etNameTwo.setHint(getString(R.string.enter_last_name));
            ClearEditText clearEditText3 = getBinding().etNameOne;
            UseGetInfo useGetInfo3 = this.mUserInfo;
            clearEditText3.setText(useGetInfo3 == null ? null : useGetInfo3.getFirstName());
            ClearEditText clearEditText4 = getBinding().etNameTwo;
            UseGetInfo useGetInfo4 = this.mUserInfo;
            clearEditText4.setText(useGetInfo4 == null ? null : useGetInfo4.getLastName());
        }
        UseGetInfo useGetInfo5 = this.mUserInfo;
        if (useGetInfo5 != null && useGetInfo5.getNickNameModified()) {
            ClearEditText clearEditText5 = getBinding().etNickname;
            UseGetInfo useGetInfo6 = this.mUserInfo;
            clearEditText5.setText(useGetInfo6 == null ? null : useGetInfo6.getNickName());
        } else {
            getBinding().etNickname.setText("");
        }
        TextView textView = getBinding().tvGrade;
        UseGetInfo useGetInfo7 = this.mUserInfo;
        textView.setText(useGetInfo7 == null ? null : useGetInfo7.getGradeName());
        UseGetInfo useGetInfo8 = this.mUserInfo;
        this.mGradeId = useGetInfo8 == null ? null : Integer.valueOf(useGetInfo8.getGradeId());
        UseGetInfo useGetInfo9 = this.mUserInfo;
        if (useGetInfo9 != null) {
            str = useGetInfo9.getAvatar();
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            loadAvatar(str, false);
        }
    }

    private final void setListener() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = getBinding().ivUser;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivUser");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, imageView, 0, new PersonalInfoActivity$setListener$1(this), 1, (Object) null);
        getBinding().tvGrade.setOnClickListener(this);
        getBinding().personalTitleBar.setOnTitleBarListener(new PersonalInfoActivity$setListener$2(this));
    }

    private final void loadAvatar(String str, boolean z) {
        this.mHasChangeAvatar = z;
        this.mPhotoPath = str;
        ImageLoaderJ.loadCircle((Context) this, str, getBinding().ivUser, R.drawable.self_image_user);
    }

    private final void track(String str) {
        LeanplumUtil.longTrack$default(str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, this.mFromPath, (String) null, (String) null, 14334, (Object) null);
    }

    static /* synthetic */ void saveUserInfo$default(PersonalInfoActivity personalInfoActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        personalInfoActivity.saveUserInfo(z);
    }

    private final void saveUserInfo(boolean z) {
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String uid;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        UserBean userBean = new UserBean((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 1023, (DefaultConstructorMarker) null);
        String str6 = null;
        if (userInfoEntity == null || (uid = userInfoEntity.getUid()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(Integer.parseInt(uid));
        }
        userBean.setUid(num);
        if (this.mPhotoUrl.length() == 0) {
            UseGetInfo useGetInfo = this.mUserInfo;
            userBean.setAvatar(useGetInfo == null ? null : useGetInfo.getAvatar());
        } else {
            userBean.setAvatar(this.mPhotoUrl);
        }
        if (userInfoEntity == null) {
            str = null;
        } else {
            str = userInfoEntity.getPhone();
        }
        userBean.setPhone(str);
        if (userInfoEntity == null) {
            str2 = null;
        } else {
            str2 = userInfoEntity.getEmail();
        }
        userBean.setEmail(str2);
        if (z) {
            if (userInfoEntity == null) {
                str5 = null;
            } else {
                str5 = userInfoEntity.getNickName();
            }
            userBean.setNickName(str5);
        } else {
            userBean.setNickName(String.valueOf(getBinding().etNickname.getText()));
        }
        if (userInfoEntity == null) {
            str3 = null;
        } else {
            str3 = userInfoEntity.getCountryCallingCode();
        }
        userBean.setCountryCallingCode(str3);
        if (userInfoEntity == null) {
            str4 = null;
        } else {
            str4 = userInfoEntity.getUnifiedAccessToken();
        }
        userBean.setUnifiedAccessToken(str4);
        if (userInfoEntity != null) {
            str6 = userInfoEntity.getCard();
        }
        userBean.setCard(str6);
        UserInfoBll.Companion.getInstance().saveUserInfo(userBean);
    }

    private final void showWarning(int i) {
        getBinding().ivWarning.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        PersonalInfoActivity.super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String compressPath = ((LocalMedia) PictureSelector.obtainMultipleResult(intent).get(0)).getCompressPath();
            Intrinsics.checkNotNullExpressionValue(compressPath, "selectList[0].compressPath");
            this.mPhotoPath = compressPath;
            showLoading();
            loadAvatar(this.mPhotoPath, true);
            AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "this.application");
            awsS3Util.uploadFile(application, "avatar", System.currentTimeMillis() + ".jpg", this.mPhotoPath, new PersonalInfoActivity$onActivityResult$1(this));
        }
    }

    public void onClick(View view) {
        Integer num;
        MethodInfo.onClickEventEnter(view, PersonalInfoActivity.class);
        clearFocus();
        if (view == null) {
            num = null;
        } else {
            num = Integer.valueOf(view.getId());
        }
        int i = R.id.tv_grade;
        if (num == null || num.intValue() != i) {
            int i2 = R.id.tv_save;
            if (num != null && num.intValue() == i2) {
                modifyUserBasicInfo();
            }
        } else if (this.mGradeList.isEmpty()) {
            showLoading();
            getMViewModel().getGradeStageList();
        } else {
            showGradeDialog();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    private final void clearFocus() {
        getBinding().etNickname.clearFocus();
        getBinding().etNameOne.clearFocus();
        getBinding().etNameTwo.clearFocus();
    }

    private final void modifyUserBasicInfo() {
        int i = 0;
        this.mOnlyChangePhoto = false;
        track("click_edit_profile_save");
        String valueOf = String.valueOf(getBinding().etNameOne.getText());
        if (StringsKt.isBlank(valueOf)) {
            showToast(getString(R.string.all_fields_are_required_please_complete));
            return;
        }
        String valueOf2 = String.valueOf(getBinding().etNameTwo.getText());
        if (StringsKt.isBlank(valueOf2)) {
            showToast(getString(R.string.all_fields_are_required_please_complete));
            return;
        }
        String valueOf3 = String.valueOf(getBinding().etNickname.getText());
        if (StringsKt.isBlank(valueOf3)) {
            valueOf3 = getFirstName() + ' ' + getLastName();
            int length = valueOf3.length();
            int i2 = this.mMaxDisplayNameLength;
            if (length > i2) {
                valueOf3 = valueOf3.substring(0, i2);
                Intrinsics.checkNotNullExpressionValue(valueOf3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
        }
        String str = valueOf3;
        if (StringsKt.isBlank(getBinding().tvGrade.getText().toString())) {
            showToast(getString(R.string.all_fields_are_required_please_complete));
            return;
        }
        KeyboardUtil.hideKeyboard((View) getBinding().etNickname);
        showLoading();
        for (Object next : this.mContactItemList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((PersonalInfoItem) next).getLinkAccount();
            i = i3;
        }
        PersonalInfoViewModel mViewModel = getMViewModel();
        UseGetInfo useGetInfo = this.mUserInfo;
        String avatar = useGetInfo == null ? null : useGetInfo.getAvatar();
        boolean z = this.easternNameOrderEnabled;
        String str2 = z ? valueOf2 : valueOf;
        String str3 = z ? valueOf : valueOf2;
        Integer num = this.mGradeId;
        UseGetInfo useGetInfo2 = this.mUserInfo;
        mViewModel.modifyUserBasicInfo(avatar, str, str2, str3, num, useGetInfo2 == null ? null : useGetInfo2.getLinkedAccount());
    }

    private final void showGradeDialog() {
        if (this.mChangeDialog == null) {
            WheelDialog wheelDialog = new WheelDialog((Context) this, new PersonalInfoActivity$showGradeDialog$1(this), (Function0) null, 4, (DefaultConstructorMarker) null);
            this.mChangeDialog = wheelDialog;
            wheelDialog.setWheelAdapter(new PersonalInfoActivity$showGradeDialog$2(this));
        }
        int i = this.mGradePosition;
        if (i != -1) {
            WheelDialog wheelDialog2 = this.mChangeDialog;
            if (wheelDialog2 != null) {
                wheelDialog2.setCurrentItem(i);
            }
        } else {
            WheelDialog wheelDialog3 = this.mChangeDialog;
            if (wheelDialog3 != null) {
                wheelDialog3.setCurrentItem(0);
            }
        }
        WheelDialog wheelDialog4 = this.mChangeDialog;
        if (wheelDialog4 != null) {
            wheelDialog4.show();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNickname)) {
                showWarning(8);
                getBinding().etNickname.setKeyListener(this.mNickNameKeyListen);
                getBinding().etNickname.setText(getBinding().etNickname.getText());
            } else if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNameOne)) {
                getBinding().etNameOne.setKeyListener(this.mNameOneKeyListen);
                getBinding().etNameOne.setText(getBinding().etNameOne.getText());
            } else if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNameTwo)) {
                getBinding().etNameTwo.setKeyListener(this.mNameTwoKeyListen);
                getBinding().etNameTwo.setText(getBinding().etNameTwo.getText());
            }
            if (view != null) {
                view.setBackgroundResource(R.drawable.bg_radius_edit_info);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNickname)) {
            getBinding().etNickname.setKeyListener((KeyListener) null);
            getBinding().etNickname.setText(getBinding().etNickname.getText());
        } else if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNameOne)) {
            getBinding().etNameOne.setKeyListener((KeyListener) null);
            getBinding().etNameOne.setText(getBinding().etNameOne.getText());
        } else if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNameTwo)) {
            getBinding().etNameTwo.setKeyListener((KeyListener) null);
            getBinding().etNameTwo.setText(getBinding().etNameTwo.getText());
        }
        if (view != null) {
            view.setBackgroundColor(ContextCompat.getColor((Context) this, R.color.transparent));
        }
    }

    private final String getFirstName() {
        return String.valueOf(getBinding().etNameOne.getText());
    }

    private final String getLastName() {
        return String.valueOf(getBinding().etNameTwo.getText());
    }
}
