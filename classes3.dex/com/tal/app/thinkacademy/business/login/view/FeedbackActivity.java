package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.flexbox.FlexboxItemDecoration;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.PhotoAdapter;
import com.tal.app.thinkacademy.business.login.adapter.ProblemAdapter;
import com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding;
import com.tal.app.thinkacademy.business.login.presenter.FeedbackViewModel;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J*\u0010!\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0014J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\b\u0010.\u001a\u00020\u001eH\u0003J\"\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0012\u00104\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00107\u001a\u00020\u001e2\b\u00108\u001a\u0004\u0018\u000109H\u0014J(\u0010:\u001a\u00020\u001e2\u000e\u0010;\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020\u000eH\u0016J(\u0010?\u001a\u00020\u001e2\u000e\u0010;\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020\u000eH\u0016J*\u0010@\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0016J\b\u0010B\u001a\u00020\u001eH\u0002J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\fH\u0002J\b\u0010E\u001a\u00020\u001eH\u0016J\b\u0010F\u001a\u00020\u001eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001c*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/FeedbackActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/FeedbackViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityFeedbackBinding;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "Landroid/text/TextWatcher;", "Landroid/view/View$OnClickListener;", "()V", "mChooseDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mHasAddListener", "", "mMaxPhoto", "", "mNeedFinish", "mPhotoAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/PhotoAdapter;", "mPhotoList", "", "", "mProblemAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/ProblemAdapter;", "mProblemList", "mProblemTag", "mUploadId", "mUploadIndex", "tag", "kotlin.jvm.PlatformType", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "finish", "init", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "position", "onItemClick", "onTextChanged", "before", "showChooseDialog", "showCustomToast", "success", "showLoading", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedbackActivity.kt */
public final class FeedbackActivity extends BaseVmActivity<FeedbackViewModel, ActivityFeedbackBinding> implements OnItemClickListener, OnItemChildClickListener, TextWatcher, View.OnClickListener {
    private BaseDialog mChooseDialog;
    private boolean mHasAddListener;
    /* access modifiers changed from: private */
    public int mMaxPhoto = 3;
    private boolean mNeedFinish = true;
    private PhotoAdapter mPhotoAdapter;
    private List<String> mPhotoList;
    private ProblemAdapter mProblemAdapter;
    private List<String> mProblemList;
    /* access modifiers changed from: private */
    public String mProblemTag = "";
    /* access modifiers changed from: private */
    public int mUploadId;
    /* access modifiers changed from: private */
    public int mUploadIndex;
    private final String tag = "FeedbackActivity";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedbackActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public ActivityFeedbackBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityFeedbackBinding inflate = ActivityFeedbackBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        FeedbackActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        init();
    }

    private final void init() {
        LeanplumUtil.commonTrack$default("app_feedback_pv", (HashMap) null, 2, (Object) null);
        if (this.mProblemAdapter == null) {
            List<String> arrayList = new ArrayList<>();
            this.mProblemList = arrayList;
            String string = getString(R.string.features_malfunction);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.features_malfunction)");
            arrayList.add(string);
            String string2 = getString(R.string.teaching);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.teaching)");
            arrayList.add(string2);
            String string3 = getString(R.string.features_suggestions);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.features_suggestions)");
            arrayList.add(string3);
            String string4 = getString(R.string.overall_experience);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.overall_experience)");
            arrayList.add(string4);
            String string5 = getString(R.string.in_class_experience);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.in_class_experience)");
            arrayList.add(string5);
            String string6 = getString(R.string.other_problems);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.other_problems)");
            arrayList.add(string6);
            this.mProblemAdapter = new ProblemAdapter(this.mProblemList);
            Context context = (Context) this;
            RecyclerView.LayoutManager flexboxLayoutManager = new FlexboxLayoutManager(context);
            flexboxLayoutManager.setFlexWrap(1);
            flexboxLayoutManager.setFlexDirection(0);
            flexboxLayoutManager.setAlignItems(4);
            flexboxLayoutManager.setJustifyContent(0);
            getBinding().rvTags.setLayoutManager(flexboxLayoutManager);
            RecyclerView.ItemDecoration flexboxItemDecoration = new FlexboxItemDecoration(context);
            flexboxItemDecoration.setDrawable(ContextCompat.getDrawable(context, R.drawable.item_divider_problem));
            getBinding().rvTags.addItemDecoration(flexboxItemDecoration);
            ProblemAdapter problemAdapter = this.mProblemAdapter;
            if (problemAdapter != null) {
                problemAdapter.setOnItemClickListener((OnItemClickListener) this);
            }
            getBinding().rvTags.setAdapter(this.mProblemAdapter);
        }
        if (this.mPhotoAdapter == null) {
            List<String> arrayList2 = new ArrayList<>();
            this.mPhotoList = arrayList2;
            arrayList2.add("");
            this.mPhotoAdapter = new PhotoAdapter(this.mPhotoList);
            Context context2 = (Context) this;
            getBinding().rvPhotos.setLayoutManager(new LinearLayoutManager(context2, 0, false));
            RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(context2, 0);
            Drawable drawable = ContextCompat.getDrawable(context2, R.drawable.item_divider_photo);
            Intrinsics.checkNotNull(drawable);
            dividerItemDecoration.setDrawable(drawable);
            getBinding().rvPhotos.addItemDecoration(dividerItemDecoration);
            PhotoAdapter photoAdapter = this.mPhotoAdapter;
            if (photoAdapter != null) {
                photoAdapter.addChildClickViewIds(new int[]{R.id.item_iv_del});
            }
            PhotoAdapter photoAdapter2 = this.mPhotoAdapter;
            if (photoAdapter2 != null) {
                photoAdapter2.setOnItemChildClickListener((OnItemChildClickListener) this);
            }
            PhotoAdapter photoAdapter3 = this.mPhotoAdapter;
            if (photoAdapter3 != null) {
                photoAdapter3.setOnItemClickListener((OnItemClickListener) this);
            }
            getBinding().rvPhotos.setAdapter(this.mPhotoAdapter);
        }
        getBinding().titleBarFeedback.setOnTitleBarListener(new FeedbackActivity$init$3(this));
        getBinding().etContent.addTextChangedListener(this);
        getBinding().tvSubmit.setOnClickListener(this);
    }

    public void startObserve() {
        getMViewModel().getFeedback().observe((LifecycleOwner) this, new FeedbackActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-3  reason: not valid java name */
    public static final void m71startObserve$lambda3(FeedbackActivity feedbackActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(feedbackActivity, "this$0");
        feedbackActivity.mNeedFinish = false;
        feedbackActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            feedbackActivity.showCustomToast(true);
            new Handler(Looper.getMainLooper()).postDelayed(new FeedbackActivity$$ExternalSyntheticLambda2(feedbackActivity), 2000);
            return;
        }
        feedbackActivity.showCustomToast(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-3$lambda-2  reason: not valid java name */
    public static final void m72startObserve$lambda3$lambda2(FeedbackActivity feedbackActivity) {
        Intrinsics.checkNotNullParameter(feedbackActivity, "this$0");
        feedbackActivity.finish();
    }

    private final void showChooseDialog() {
        if (this.mChooseDialog == null) {
            this.mChooseDialog = new ChoosePicDialog((Context) this, new FeedbackActivity$showChooseDialog$1(this));
        }
        BaseDialog baseDialog = this.mChooseDialog;
        if (baseDialog != null) {
            baseDialog.show();
        }
    }

    private final void showCustomToast(boolean z) {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.layout_custom_toast;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ayout_custom_toast, null)");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        if (z) {
            imageView.setImageResource(R.drawable.add_account_success);
            textView.setText(getString(R.string.submission_successful));
        } else {
            imageView.setImageResource(R.drawable.add_account_failed);
            textView.setText(getString(R.string.submission_failed));
        }
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showCustomShort(inflate);
    }

    public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = false;
        if (Intrinsics.areEqual((Object) baseQuickAdapter, (Object) this.mProblemAdapter)) {
            ProblemAdapter problemAdapter = this.mProblemAdapter;
            if (problemAdapter != null) {
                problemAdapter.setSelectPosition(i);
            }
            ProblemAdapter problemAdapter2 = this.mProblemAdapter;
            if (problemAdapter2 != null) {
                problemAdapter2.notifyDataSetChanged();
            }
            List<String> list = this.mProblemList;
            Intrinsics.checkNotNull(list);
            this.mProblemTag = list.get(i);
            TextView textView = getBinding().tvSubmit;
            CharSequence valueOf = String.valueOf(getBinding().etContent.getText());
            if (valueOf == null || StringsKt.isBlank(valueOf)) {
                z = true;
            }
            textView.setEnabled(!z);
        } else if (Intrinsics.areEqual((Object) baseQuickAdapter, (Object) this.mPhotoAdapter)) {
            List<String> list2 = this.mPhotoList;
            String str = list2 == null ? null : list2.get(i);
            Intrinsics.checkNotNull(str);
            if (str.length() == 0) {
                z = true;
            }
            if (z) {
                showChooseDialog();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        List<String> list;
        FeedbackActivity.super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            List obtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
            List<String> list2 = this.mPhotoList;
            Integer num = null;
            Integer valueOf = list2 == null ? null : Integer.valueOf(list2.size());
            List<String> list3 = this.mPhotoList;
            if (list3 != null) {
                Intrinsics.checkNotNull(valueOf);
                String remove = list3.remove(valueOf.intValue() - 1);
            }
            int size = obtainMultipleResult.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                List<String> list4 = this.mPhotoList;
                if (list4 != null) {
                    String compressPath = ((LocalMedia) obtainMultipleResult.get(i3)).getCompressPath();
                    Intrinsics.checkNotNullExpressionValue(compressPath, "list[index].compressPath");
                    list4.add(0, compressPath);
                }
                i3 = i4;
            }
            List<String> list5 = this.mPhotoList;
            if (list5 != null) {
                num = Integer.valueOf(list5.size());
            }
            Intrinsics.checkNotNull(num);
            int intValue = 3 - num.intValue();
            this.mMaxPhoto = intValue;
            if (intValue > 0 && (list = this.mPhotoList) != null) {
                list.add("");
            }
            PhotoAdapter photoAdapter = this.mPhotoAdapter;
            if (photoAdapter != null) {
                photoAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onItemChildClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
        List<String> list;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        List<String> list2 = this.mPhotoList;
        if (list2 != null) {
            String remove = list2.remove(i);
        }
        if (this.mMaxPhoto == 0 && (list = this.mPhotoList) != null) {
            list.add("");
        }
        this.mMaxPhoto++;
        PhotoAdapter photoAdapter = this.mPhotoAdapter;
        if (photoAdapter != null) {
            photoAdapter.notifyDataSetChanged();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if ((java.lang.String.valueOf(r5).length() == 0) == false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(android.text.Editable r5) {
        /*
            r4 = this;
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding) r0
            android.widget.TextView r0 = r0.tvSubmit
            java.lang.String r1 = r4.mProblemTag
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
            r1 = r2
            goto L_0x0017
        L_0x0016:
            r1 = r3
        L_0x0017:
            if (r1 != 0) goto L_0x002b
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0027
            r5 = r2
            goto L_0x0028
        L_0x0027:
            r5 = r3
        L_0x0028:
            if (r5 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = r3
        L_0x002c:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.FeedbackActivity.afterTextChanged(android.text.Editable):void");
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, FeedbackActivity.class);
        LeanplumUtil.commonTrack$default("app_feedback_pv", (HashMap) null, 2, (Object) null);
        showLoading();
        int i = this.mMaxPhoto;
        if (i != 3) {
            int i2 = 3 - i;
            String[] strArr = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                strArr[i3] = "";
            }
            for (int i4 = 0; i4 < i2; i4++) {
                strArr[i4] = i4 + ".jpg";
            }
            AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "this.application");
            List mutableList = ArraysKt.toMutableList((T[]) strArr);
            List<String> list = this.mPhotoList;
            Intrinsics.checkNotNull(list);
            awsS3Util.uploadFilesWithPaths(application, "feedback", mutableList, list, new FeedbackActivity$onClick$1(this));
        } else {
            FeedbackViewModel.submitFeedback$default(getMViewModel(), this.mProblemTag, StringsKt.trim(String.valueOf(getBinding().etContent.getText())).toString(), (String[]) null, 4, (Object) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void showLoading() {
        FeedbackActivity.super.showLoading();
        this.mNeedFinish = true;
        if (!this.mHasAddListener) {
            this.mHasAddListener = true;
            getLoadingDialog().setCanceledOnTouchOutside(false);
            getLoadingDialog().setDismissListener(new FeedbackActivity$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showLoading$lambda-4  reason: not valid java name */
    public static final void m70showLoading$lambda4(FeedbackActivity feedbackActivity) {
        Intrinsics.checkNotNullParameter(feedbackActivity, "this$0");
        XesLog.dt(feedbackActivity.tag, new Object[]{"loadingDialog dismiss"});
        if (feedbackActivity.mNeedFinish) {
            feedbackActivity.finish();
        }
    }

    public void finish() {
        AwsS3Util.INSTANCE.cancelAndReset();
        FeedbackActivity.super.finish();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0) {
            KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus());
        }
        return FeedbackActivity.super.dispatchTouchEvent(motionEvent);
    }
}
