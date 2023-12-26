package com.tal.app.thinkacademy.common.business.browser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.common.business.browser.helper.BrowserDataHelper;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserFragment;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryParam;
import com.tal.app.thinkacademy.common.entity.HomeworkApiRusultData;
import com.tal.app.thinkacademy.common.entity.SubmitHomeworkData;
import com.tal.app.thinkacademy.common.entity.SubmitHomeworkResult;
import com.tal.app.thinkacademy.common.entity.SycHomeWork;
import com.tal.app.thinkacademy.common.entity.WebHeaderData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.network.CommonApi;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.PictureSelectorHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\n\u0010(\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0016J\"\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0012\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0015J\b\u00105\u001a\u00020#H\u0014J\u001a\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020#H\u0014J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u0015H\u0016J \u0010=\u001a\u00020#2\u0016\u0010>\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00120\u0011H\u0002J\u0010\u0010?\u001a\u00020#2\u0006\u00100\u001a\u00020@H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/tal/app/thinkacademy/common/business/browser/helper/FragmentListener;", "Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserFragment$OnBrowserListener;", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "isChoose", "", "isDestroy", "mBrowserData", "Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserDataHelper;", "mChooseDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mGoldCoinDialog", "Lcom/tal/app/thinkacademy/common/business/browser/view/GoldCoinDialog;", "mUploadMsg", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "getMWebAgent", "()Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "setMWebAgent", "(Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;)V", "mWebFileSelectModel", "Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel;", "titleBar", "Lcom/tal/app/thinkacademy/lib/commui/widget/bar/TitleBar;", "getTitleBar", "()Lcom/tal/app/thinkacademy/lib/commui/widget/bar/TitleBar;", "setTitleBar", "(Lcom/tal/app/thinkacademy/lib/commui/widget/bar/TitleBar;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "choosePhoto", "clearUploadMessage", "getData", "getLifeHandler", "", "Lcom/tal/app/thinkacademy/common/business/browser/handler/WebViewLifeHandler;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onResume", "process", "webAgent", "showFileChooser", "uploadMsg", "submitHomework", "Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkData;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserActivity.kt */
public class BrowserActivity extends FragmentActivity implements FragmentListener, BrowserFragment.OnBrowserListener {
    private final Tag TAG = Tag.BROWSE_ACTIVITY;
    /* access modifiers changed from: private */
    public boolean isChoose;
    /* access modifiers changed from: private */
    public boolean isDestroy;
    private BrowserDataHelper mBrowserData;
    private BaseDialog mChooseDialog;
    /* access modifiers changed from: private */
    public GoldCoinDialog mGoldCoinDialog;
    private ValueCallback<Uri[]> mUploadMsg;
    private WebAgent mWebAgent;
    private final WebFileSelectModel mWebFileSelectModel = new WebFileSelectModel((FragmentActivity) this, new BrowserActivity$mWebFileSelectModel$1(this));
    public TitleBar titleBar;

    public void finish() {
        BrowserActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public List<WebViewLifeHandler> getLifeHandler() {
        return null;
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        BrowserActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        BrowserActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        BrowserActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        BrowserActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    public final WebAgent getMWebAgent() {
        return this.mWebAgent;
    }

    public final void setMWebAgent(WebAgent webAgent) {
        this.mWebAgent = webAgent;
    }

    public final TitleBar getTitleBar() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 != null) {
            return titleBar2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        return null;
    }

    public final void setTitleBar(TitleBar titleBar2) {
        Intrinsics.checkNotNullParameter(titleBar2, "<set-?>");
        this.titleBar = titleBar2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        ActivityInfo.startTraceActivity(getClass().getName());
        Activity activity = (Activity) this;
        PadAutoUtil.setupAutoScreenOrientation(activity);
        BrowserActivity.super.onCreate(bundle);
        setContentView(R.layout.activity_browser);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        this.mBrowserData = new BrowserDataHelper(intent);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_activity_browser_main, BrowserFragment.Companion.getInstance("")).commit();
        boolean z = true;
        XesStatusBar.INSTANCE.setStatusBar(activity, true, -1, false);
        View findViewById = findViewById(R.id.web_titleBar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.web_titleBar)");
        setTitleBar((TitleBar) findViewById);
        BrowserDataHelper browserDataHelper = this.mBrowserData;
        Integer num = null;
        AgentConfig config = browserDataHelper == null ? null : browserDataHelper.getConfig();
        if (config == null) {
            str = null;
        } else {
            str = config.getLocalTitle();
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            getTitleBar().setVisibility(0);
            TitleBar titleBar2 = getTitleBar();
            Intrinsics.checkNotNull(config);
            titleBar2.setTitle((CharSequence) config.getLocalTitle());
            getTitleBar().setOnTitleBarListener(new BrowserActivity$onCreate$1(this));
        }
        JsonObject jsonObject = new JsonObject();
        BrowserDataHelper browserDataHelper2 = this.mBrowserData;
        jsonObject.addProperty("homeworkId", browserDataHelper2 == null ? null : browserDataHelper2.getHomeworkId());
        BrowserDataHelper browserDataHelper3 = this.mBrowserData;
        jsonObject.addProperty("homeworkClassId", browserDataHelper3 == null ? null : browserDataHelper3.getClassId());
        BrowserDataHelper browserDataHelper4 = this.mBrowserData;
        jsonObject.addProperty("planId", browserDataHelper4 == null ? null : browserDataHelper4.getPlanId());
        BrowserDataHelper browserDataHelper5 = this.mBrowserData;
        if (browserDataHelper5 != null) {
            num = browserDataHelper5.getHomeworkType();
        }
        jsonObject.addProperty("homeworkType", num);
        XesLog.ut("BrowserActivity", jsonObject);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.HEADERS_DATA).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda6(this));
        XesDataBus.with(DataBusKey.NATIVE_FINISH).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda5(this));
        XesDataBus.with(DataBusKey.SHOW_FILE_CHOOSER).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda0(this));
        XesDataBus.with(DataBusKey.HOMEWORK_RESPONSE).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda7(this));
        XesDataBus.with(DataBusKey.HOMEWORK_UPLOAD_IMG).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda8(this));
        XesDataBus.with(DataBusKey.HOMEWORK_SUBMIT_SUCCESS).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda2(this));
        XesDataBus.with(DataBusKey.CUSTOM_SELECT_PHOTO_VIDEO).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda1(this));
        XesDataBus.with(DataBusKey.BRIDGE_GET_WECHAT_SHARE_RESULT).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda3(this));
        XesDataBus.with(DataBusKey.BRIDGE_SAVE_PICTURE_RESULT).observe(lifecycleOwner, new BrowserActivity$$ExternalSyntheticLambda4(this));
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m11onCreate$lambda1(BrowserActivity browserActivity, String str) {
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        WebAgent webAgent = browserActivity.mWebAgent;
        if (webAgent != null) {
            webAgent.jsCallBack("window.clientMessageHandlers", str);
        }
        XesLog.dt("studyHeaders", str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m17onCreate$lambda2(BrowserActivity browserActivity, String str) {
        BrowserActivity browserActivity2 = browserActivity;
        Intrinsics.checkNotNullParameter(browserActivity2, "this$0");
        BrowserDataHelper browserDataHelper = browserActivity2.mBrowserData;
        WebHeaderData.HeadersParams headersParams = r2;
        WebHeaderData.HeadersParams headersParams2 = new WebHeaderData.HeadersParams((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, browserDataHelper == null ? null : browserDataHelper.getShareCode(), (String) null, 3071, (DefaultConstructorMarker) null);
        String json = GsonUtils.toJson(new WebHeaderData((String) null, headersParams, 1, (DefaultConstructorMarker) null));
        WebAgent webAgent = browserActivity2.mWebAgent;
        if (webAgent != null) {
            webAgent.jsCallBack("window.clientMessageHandlers", json);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m18onCreate$lambda4(BrowserActivity browserActivity, ValueCallback valueCallback) {
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        if (valueCallback != null) {
            browserActivity.showFileChooser(valueCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7  reason: not valid java name */
    public static final void m19onCreate$lambda7(BrowserActivity browserActivity, Object obj) {
        String str;
        String str2;
        Object status;
        Object responseTime;
        Object path;
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        if (obj != null) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
            JSONObject jSONObject = new JSONObject((LinkedTreeMap) obj);
            HomeworkApiRusultData homeworkApiRusultData = (HomeworkApiRusultData) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), HomeworkApiRusultData.class);
            JsonObject jsonObject = new JsonObject();
            BrowserDataHelper browserDataHelper = browserActivity.mBrowserData;
            String str3 = null;
            jsonObject.addProperty("homeworkId", browserDataHelper == null ? null : browserDataHelper.getHomeworkId());
            BrowserDataHelper browserDataHelper2 = browserActivity.mBrowserData;
            jsonObject.addProperty("homeworkClassId", browserDataHelper2 == null ? null : browserDataHelper2.getClassId());
            if (homeworkApiRusultData == null || (path = homeworkApiRusultData.getPath()) == null) {
                str = null;
            } else {
                str = path.toString();
            }
            jsonObject.addProperty("homeworkApiPath", str);
            if (homeworkApiRusultData == null || (responseTime = homeworkApiRusultData.getResponseTime()) == null) {
                str2 = null;
            } else {
                str2 = responseTime.toString();
            }
            jsonObject.addProperty("homeworkResponseTime", str2);
            if (!(homeworkApiRusultData == null || (status = homeworkApiRusultData.getStatus()) == null)) {
                str3 = status.toString();
            }
            jsonObject.addProperty("homeworkStatus", str3);
            XesLog.ut("homeworkSubmit", jsonObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-10  reason: not valid java name */
    public static final void m12onCreate$lambda10(BrowserActivity browserActivity, Object obj) {
        String str;
        String str2;
        Object uploadType;
        Object uploadStatus;
        Object uploadDuration;
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        if (obj != null) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
            JSONObject jSONObject = new JSONObject((LinkedTreeMap) obj);
            HomeworkApiRusultData homeworkApiRusultData = (HomeworkApiRusultData) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), HomeworkApiRusultData.class);
            JsonObject jsonObject = new JsonObject();
            BrowserDataHelper browserDataHelper = browserActivity.mBrowserData;
            String str3 = null;
            jsonObject.addProperty("homeworkId", browserDataHelper == null ? null : browserDataHelper.getHomeworkId());
            BrowserDataHelper browserDataHelper2 = browserActivity.mBrowserData;
            jsonObject.addProperty("homeworkClassId", browserDataHelper2 == null ? null : browserDataHelper2.getClassId());
            if (homeworkApiRusultData == null || (uploadDuration = homeworkApiRusultData.getUploadDuration()) == null) {
                str = null;
            } else {
                str = uploadDuration.toString();
            }
            jsonObject.addProperty("homeworkUploadDuration", str);
            if (homeworkApiRusultData == null || (uploadStatus = homeworkApiRusultData.getUploadStatus()) == null) {
                str2 = null;
            } else {
                str2 = uploadStatus.toString();
            }
            jsonObject.addProperty("homeworkUploadStatus", str2);
            if (!(homeworkApiRusultData == null || (uploadType = homeworkApiRusultData.getUploadType()) == null)) {
                str3 = uploadType.toString();
            }
            jsonObject.addProperty("homeworkType", str3);
            XesLog.ut("homeworkUpload", jsonObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-13  reason: not valid java name */
    public static final void m13onCreate$lambda13(BrowserActivity browserActivity, SycHomeWork sycHomeWork) {
        String classId;
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        if (sycHomeWork != null) {
            BrowserDataHelper browserDataHelper = browserActivity.mBrowserData;
            Integer num = null;
            Integer planId = browserDataHelper == null ? null : browserDataHelper.getPlanId();
            BrowserDataHelper browserDataHelper2 = browserActivity.mBrowserData;
            Integer valueOf = (browserDataHelper2 == null || (classId = browserDataHelper2.getClassId()) == null) ? null : Integer.valueOf(Integer.parseInt(classId));
            BrowserDataHelper browserDataHelper3 = browserActivity.mBrowserData;
            String homeworkId = browserDataHelper3 == null ? null : browserDataHelper3.getHomeworkId();
            BrowserDataHelper browserDataHelper4 = browserActivity.mBrowserData;
            Integer homeworkType = browserDataHelper4 == null ? null : browserDataHelper4.getHomeworkType();
            String state = sycHomeWork.getState();
            browserActivity.submitHomework(new SubmitHomeworkData(planId, valueOf, state == null ? null : Integer.valueOf((int) Double.parseDouble(state)), homeworkType, homeworkId));
            JsonObject jsonObject = new JsonObject();
            BrowserDataHelper browserDataHelper5 = browserActivity.mBrowserData;
            jsonObject.addProperty("homeworkId", browserDataHelper5 == null ? null : browserDataHelper5.getHomeworkId());
            BrowserDataHelper browserDataHelper6 = browserActivity.mBrowserData;
            jsonObject.addProperty("homeworkClassId", browserDataHelper6 == null ? null : browserDataHelper6.getClassId());
            BrowserDataHelper browserDataHelper7 = browserActivity.mBrowserData;
            jsonObject.addProperty("planId", browserDataHelper7 == null ? null : browserDataHelper7.getPlanId());
            BrowserDataHelper browserDataHelper8 = browserActivity.mBrowserData;
            if (browserDataHelper8 != null) {
                num = browserDataHelper8.getHomeworkType();
            }
            jsonObject.addProperty("homeworkType", num);
            XesLog.ut("HOMEWORK_SUBMIT_SUCCESS", jsonObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-15  reason: not valid java name */
    public static final void m14onCreate$lambda15(BrowserActivity browserActivity, H5PhotoLibraryParam h5PhotoLibraryParam) {
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        if (h5PhotoLibraryParam != null) {
            browserActivity.mWebFileSelectModel.showFileSelectDialog(h5PhotoLibraryParam);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-16  reason: not valid java name */
    public static final void m15onCreate$lambda16(BrowserActivity browserActivity, Integer num) {
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        XesLog.i(browserActivity.TAG, Intrinsics.stringPlus("收到分享回调=", num));
        String str = "{\"type\":\"share_completed\",\"data\":{\"success\":" + num + "}}";
        WebAgent webAgent = browserActivity.mWebAgent;
        if (webAgent != null) {
            webAgent.jsCallBack("window.clientMessageHandlers", str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-17  reason: not valid java name */
    public static final void m16onCreate$lambda17(BrowserActivity browserActivity, Integer num) {
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        XesLog.i(browserActivity.TAG, Intrinsics.stringPlus("收到保存图片回调=", num));
        String str = "{\"type\":\"save_photo_completed\",\"data\":{\"success\":" + num + "}}";
        WebAgent webAgent = browserActivity.mWebAgent;
        if (webAgent != null) {
            webAgent.jsCallBack("window.clientMessageHandlers", str);
        }
    }

    public void process(WebAgent webAgent) {
        Intrinsics.checkNotNullParameter(webAgent, "webAgent");
        this.mWebAgent = webAgent;
    }

    private final void clearUploadMessage() {
        ValueCallback<Uri[]> valueCallback = this.mUploadMsg;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
        }
        this.mUploadMsg = null;
    }

    private final void showFileChooser(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMsg = valueCallback;
        this.isChoose = false;
        if (this.mChooseDialog == null) {
            this.mChooseDialog = new ChoosePicDialog((Context) this, (Function1<? super ChoosePicType, Unit>) new BrowserActivity$showFileChooser$1(this));
        }
        BaseDialog baseDialog = this.mChooseDialog;
        if (baseDialog != null) {
            baseDialog.show();
        }
        BaseDialog baseDialog2 = this.mChooseDialog;
        if (baseDialog2 != null) {
            baseDialog2.setDismissListener(new BrowserActivity$$ExternalSyntheticLambda9(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showFileChooser$lambda-18  reason: not valid java name */
    public static final void m20showFileChooser$lambda18(BrowserActivity browserActivity) {
        Intrinsics.checkNotNullParameter(browserActivity, "this$0");
        if (!browserActivity.isChoose) {
            browserActivity.clearUploadMessage();
        }
    }

    /* access modifiers changed from: private */
    public final void choosePhoto() {
        if (PadUtils.isPad((Context) this)) {
            PictureSelectorHelper.choosePhoto$default(PictureSelectorHelper.Companion.getInstance(), (Activity) this, 10, false, false, 0, (OnResultCallbackListener) null, 36, (Object) null);
        } else {
            PictureSelectorHelper.choosePhoto$default(PictureSelectorHelper.Companion.getInstance(), (Activity) this, 10, false, false, 0, (OnResultCallbackListener) null, 52, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        BrowserActivity.super.onActivityResult(i, i2, intent);
        if (i != 35 && i != 36) {
            return;
        }
        if (i2 == -1) {
            List obtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
            Collection collection = obtainMultipleResult;
            if (!(collection == null || collection.isEmpty())) {
                Uri[] uriArr = new Uri[obtainMultipleResult.size()];
                if (i == 35) {
                    CharSequence compressPath = ((LocalMedia) obtainMultipleResult.get(0)).getCompressPath();
                    if (!(compressPath == null || StringsKt.isBlank(compressPath))) {
                        File file = new File(((LocalMedia) obtainMultipleResult.get(0)).getCompressPath());
                        if (file.exists()) {
                            uriArr = new Uri[]{Uri.fromFile(file)};
                        }
                    }
                } else if (i == 36) {
                    int size = obtainMultipleResult.size();
                    int i3 = 0;
                    while (i3 < size) {
                        int i4 = i3 + 1;
                        CharSequence compressPath2 = ((LocalMedia) obtainMultipleResult.get(i3)).getCompressPath();
                        if (!(compressPath2 == null || StringsKt.isBlank(compressPath2))) {
                            File file2 = new File(((LocalMedia) obtainMultipleResult.get(i3)).getCompressPath());
                            if (file2.exists()) {
                                uriArr[i3] = Uri.fromFile(file2);
                            }
                        }
                        i3 = i4;
                    }
                }
                ValueCallback<Uri[]> valueCallback = this.mUploadMsg;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(uriArr);
                    return;
                }
                return;
            }
            return;
        }
        clearUploadMessage();
    }

    private final void submitHomework(SubmitHomeworkData submitHomeworkData) {
        Call<HiResponse<SubmitHomeworkResult>> submitHomework = ((CommonApi) Api.create(CommonApi.class)).submitHomework(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/homework-api/student/sync"), submitHomeworkData);
        Callback browserActivity$submitHomework$1 = new BrowserActivity$submitHomework$1(this, new BrowserActivity$submitHomework$2());
        if (!(submitHomework instanceof Call)) {
            submitHomework.enqueue(browserActivity$submitHomework$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) submitHomework, browserActivity$submitHomework$1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebAgent webAgent;
        if (i != 4 || (webAgent = this.mWebAgent) == null || !webAgent.canGoBack()) {
            return BrowserActivity.super.onKeyDown(i, keyEvent);
        }
        XesDataBus.with(DataBusKey.JS_GO_BACK).setStickyData("WebBack");
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        BrowserActivity.super.onResume();
        BrowserDataHelper browserDataHelper = this.mBrowserData;
        AgentConfig config = browserDataHelper == null ? null : browserDataHelper.getConfig();
        boolean z = true;
        if (config == null || !config.isLandscape()) {
            z = false;
        }
        if (z) {
            setRequestedOrientation(0);
        }
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BrowserActivity.super.onDestroy();
        this.isDestroy = true;
        this.mBrowserData = null;
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
        this.mWebFileSelectModel.onDestroy();
    }

    public BrowserDataHelper getData() {
        return this.mBrowserData;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Unit unit;
        if (context == null) {
            unit = null;
        } else {
            BrowserActivity.super.attachBaseContext(LanguageUtil.attachBaseContext(context));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            BrowserActivity browserActivity = this;
            BrowserActivity.super.attachBaseContext(context);
        }
    }
}
