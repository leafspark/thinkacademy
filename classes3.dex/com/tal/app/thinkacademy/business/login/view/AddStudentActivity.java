package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivityAddStudentBinding;
import com.tal.app.thinkacademy.business.login.presenter.AddStudentViewModel;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.common.user.GradeStage;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.commui.widget.TextInputFilter;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0014J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\fH\u0002J\u0012\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u001a\u0010,\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/AddStudentActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/AddStudentViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityAddStudentBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "()V", "easternNameOrderEnabled", "", "mChangeDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mFromPath", "", "mGradeId", "", "Ljava/lang/Integer;", "mGradeList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/common/user/Grade;", "Lkotlin/collections/ArrayList;", "mGradePosition", "mMaxDisplayNameLength", "mNameOneKeyListen", "Landroid/text/method/KeyListener;", "mNameTwoKeyListen", "mNickNameKeyListen", "addNewStudent", "", "clearFocus", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getFirstName", "getLastName", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "hasFocus", "setDisplayNameHint", "setListener", "setViewValues", "shakeAnimation", "Landroid/view/animation/Animation;", "showAddToast", "success", "showGradeDialog", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddStudentActivity.kt */
public final class AddStudentActivity extends BaseVmActivity<AddStudentViewModel, ActivityAddStudentBinding> implements View.OnClickListener, ClearEditText.OnFocusListener {
    private boolean easternNameOrderEnabled;
    private WheelDialog mChangeDialog;
    private String mFromPath;
    /* access modifiers changed from: private */
    public Integer mGradeId = 0;
    /* access modifiers changed from: private */
    public ArrayList<Grade> mGradeList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int mGradePosition = -1;
    private final int mMaxDisplayNameLength = 65;
    private KeyListener mNameOneKeyListen;
    private KeyListener mNameTwoKeyListen;
    private KeyListener mNickNameKeyListen;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddStudentActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AddStudentActivity.super.onCreate(bundle);
        LoginTrack.INSTANCE.addStudentPageShow();
        boolean z = false;
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        this.mFromPath = getIntent().getStringExtra("page_path");
        SchoolDataInfo currentSchoolInfo = SchoolConstants.INSTANCE.getCurrentSchoolInfo();
        if (currentSchoolInfo != null) {
            z = currentSchoolInfo.getEasternNameOrderEnabled();
        }
        this.easternNameOrderEnabled = z;
        setViewValues();
        setListener();
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getGradeStageList().observe(lifecycleOwner, new AddStudentActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().getAddNewStudent().observe(lifecycleOwner, new AddStudentActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m59startObserve$lambda0(AddStudentActivity addStudentActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(addStudentActivity, "this$0");
        addStudentActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            Object data = stateData.getData();
            Intrinsics.checkNotNull(data);
            List list = ((GradeStageList) data).getList();
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                List list2 = ((GradeStage) list.get(i)).getList();
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    addStudentActivity.mGradeList.add((Grade) list2.get(i3));
                }
                i = i2;
            }
            addStudentActivity.showGradeDialog();
            return;
        }
        addStudentActivity.showToast(addStudentActivity.getString(R.string.fail_hint));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m60startObserve$lambda1(AddStudentActivity addStudentActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(addStudentActivity, "this$0");
        addStudentActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            addStudentActivity.showAddToast(true);
            XesDataBus.with("add_new_student").setStickyData("add_new_student");
            addStudentActivity.finish();
            return;
        }
        addStudentActivity.showAddToast(false);
    }

    private final void setListener() {
        getBinding().titleBarAdd.setOnTitleBarListener(new AddStudentActivity$setListener$1(this));
        View.OnClickListener onClickListener = this;
        getBinding().tvGrade.setOnClickListener(onClickListener);
        getBinding().tvAdd.setOnClickListener(onClickListener);
    }

    private final void setViewValues() {
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
        getBinding().etEmail.setOnFocusListener(onFocusListener);
        getBinding().etNickname.addCustomTextWatcher(new AddStudentActivity$setViewValues$1(this, this.mMaxDisplayNameLength, getBinding().etNickname));
        getBinding().etNameOne.addCustomTextWatcher(new AddStudentActivity$setViewValues$2(this, getBinding().etNameOne));
        getBinding().etNameTwo.addCustomTextWatcher(new AddStudentActivity$setViewValues$3(this, getBinding().etNameTwo));
        if (this.easternNameOrderEnabled) {
            getBinding().tvNameOne.setText(getString(R.string.last_name));
            getBinding().etNameOne.setHint(getString(R.string.enter_last_name));
            getBinding().tvNameTwo.setText(getString(R.string.first_name));
            getBinding().etNameTwo.setHint(getString(R.string.enter_first_name));
            return;
        }
        getBinding().tvNameOne.setText(getString(R.string.first_name));
        getBinding().etNameOne.setHint(getString(R.string.enter_first_name));
        getBinding().tvNameTwo.setText(getString(R.string.last_name));
        getBinding().etNameTwo.setHint(getString(R.string.enter_last_name));
    }

    private final void showGradeDialog() {
        if (this.mChangeDialog == null) {
            WheelDialog wheelDialog = new WheelDialog((Context) this, new AddStudentActivity$showGradeDialog$1(this), (Function0) null, 4, (DefaultConstructorMarker) null);
            wheelDialog.setWheelAdapter(new AddStudentActivity$showGradeDialog$2$1(this));
            this.mChangeDialog = wheelDialog;
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

    private final void showAddToast(boolean z) {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.layout_custom_toast;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ayout_custom_toast, null)");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        if (z) {
            imageView.setImageResource(R.drawable.add_account_success);
            textView.setText(getString(R.string.add_student_success_tip));
        } else {
            imageView.setImageResource(R.drawable.add_account_failed);
            textView.setText(getString(R.string.add_student_failed_tip));
        }
        ToastUtils.showCustomShort(inflate);
    }

    private final void clearFocus() {
        getBinding().etNickname.clearFocus();
        getBinding().etNameOne.clearFocus();
        getBinding().etNameTwo.clearFocus();
        getBinding().etEmail.clearFocus();
    }

    private final void addNewStudent() {
        String valueOf = String.valueOf(getBinding().etNickname.getText());
        String valueOf2 = String.valueOf((this.easternNameOrderEnabled ? getBinding().etNameTwo : getBinding().etNameOne).getText());
        String valueOf3 = String.valueOf((this.easternNameOrderEnabled ? getBinding().etNameOne : getBinding().etNameTwo).getText());
        boolean z = true;
        if (valueOf2.length() == 0) {
            showToast(getString(R.string.param_is_invalid, new Object[]{getString(R.string.first_name)}));
            if (this.easternNameOrderEnabled) {
                getBinding().layoutNameTwo.startAnimation(shakeAnimation());
            } else {
                getBinding().layoutNameOne.startAnimation(shakeAnimation());
            }
        } else {
            if (valueOf3.length() == 0) {
                showToast(getString(R.string.param_is_invalid, new Object[]{getString(R.string.last_name)}));
                if (this.easternNameOrderEnabled) {
                    getBinding().layoutNameOne.startAnimation(shakeAnimation());
                } else {
                    getBinding().layoutNameTwo.startAnimation(shakeAnimation());
                }
            } else {
                Integer num = this.mGradeId;
                if (num != null && num.intValue() == 0) {
                    showToast(getString(R.string.please_select_grade));
                    getBinding().layoutGrade.startAnimation(shakeAnimation());
                    return;
                }
                if (valueOf.length() != 0) {
                    z = false;
                }
                if (z) {
                    valueOf = getFirstName() + ' ' + getLastName();
                    int length = valueOf.length();
                    int i = this.mMaxDisplayNameLength;
                    if (length > i) {
                        valueOf = valueOf.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(valueOf, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                }
                showLoading();
                getMViewModel().addNewStudent(valueOf, valueOf2, valueOf3, this.mGradeId, "");
            }
        }
    }

    private final Animation shakeAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(4.0f));
        translateAnimation.setRepeatCount(1);
        translateAnimation.setDuration(500);
        return translateAnimation;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            clearFocus();
        }
        return AddStudentActivity.super.dispatchTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        Integer num;
        MethodInfo.onClickEventEnter(view, AddStudentActivity.class);
        clearFocus();
        if (view == null) {
            num = null;
        } else {
            num = Integer.valueOf(view.getId());
        }
        int i = R.id.tv_grade;
        if (num == null || num.intValue() != i) {
            int i2 = R.id.tv_add;
            if (num != null && num.intValue() == i2) {
                addNewStudent();
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

    public void onFocusChange(View view, boolean z) {
        if (z) {
            if (Intrinsics.areEqual((Object) view, (Object) getBinding().etNickname)) {
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

    /* access modifiers changed from: protected */
    public ActivityAddStudentBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityAddStudentBinding inflate = ActivityAddStudentBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
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

    private final String getFirstName() {
        return String.valueOf(getBinding().etNameOne.getText());
    }

    private final String getLastName() {
        return String.valueOf(getBinding().etNameTwo.getText());
    }
}
