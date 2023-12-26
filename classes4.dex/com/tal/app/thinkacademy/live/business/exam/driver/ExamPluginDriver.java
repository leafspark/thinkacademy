package com.tal.app.thinkacademy.live.business.exam.driver;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.JsonObject;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.constants.ClassTabConstants;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.common.utils.PictureSelectorHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.exam.bean.ClassExam;
import com.tal.app.thinkacademy.live.business.exam.view.ExamPluginView;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.photosonthewall.util.TakePhotoStateUtil;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "课中考试", ircType = {"class_examination", "mode"}, liveType = 10086, moduleId = "250", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 30, name = "ExamView")})
public class ExamPluginDriver extends BaseLivePluginDriver {
    private final XesLogTag TAG = Tag.ExamPluginDriver;
    private boolean isChoose = false;
    /* access modifiers changed from: private */
    public boolean isTakePhoto;
    /* access modifiers changed from: private */
    public volatile BaseDialog mChooseDialog = null;
    protected Context mContext;
    private ExamPluginView mExamPluginView;
    private int mExamStatus = 0;
    private String mFrom = EnterRoomMuteData.STATUS_UN_MUTE;
    private IircControllerProvider mIrcControllerProvider;
    private boolean mIsReportDialogShowing = false;
    private OnResultCallbackListener mOnResultCallbackListener;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mUploadMsg = null;

    public ExamPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        init();
    }

    private void init() {
        XesDataBus.with(DataBusKey.SHOW_FILE_CHOOSER).observe(this, new ExamPluginDriver$$ExternalSyntheticLambda0(this));
        XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).observe(this, new ExamPluginDriver$$ExternalSyntheticLambda1(this));
        XesDataBus.with(DataBusKey.COMPLETED_EXAM_SUCCESS).observe(this, new ExamPluginDriver$$ExternalSyntheticLambda2(this));
        XesDataBus.with(DataBusKey.EXAM_REPEAT).observe(this, new ExamPluginDriver$$ExternalSyntheticLambda3(this));
        XesDataBus.with(DataBusKey.EXAM_REPORT_SHOWING).observe(this, new ExamPluginDriver$$ExternalSyntheticLambda4(this));
    }

    public /* synthetic */ void lambda$init$0$ExamPluginDriver(Object obj) {
        if (obj != null) {
            XesLogTag xesLogTag = this.TAG;
            XesLog.i(xesLogTag, "showFileChooser + time = " + System.currentTimeMillis() + "  driver = " + hashCode());
            showFileChooser((ValueCallback) obj);
        }
    }

    public /* synthetic */ void lambda$init$1$ExamPluginDriver(Object obj) {
        if (!this.mIsReportDialogShowing) {
            removeExam();
        }
    }

    public /* synthetic */ void lambda$init$2$ExamPluginDriver(Object obj) {
        completedExam();
    }

    public /* synthetic */ void lambda$init$3$ExamPluginDriver(Object obj) {
        stopExam();
    }

    public /* synthetic */ void lambda$init$4$ExamPluginDriver(Object obj) {
        this.mIsReportDialogShowing = ((Boolean) obj).booleanValue();
    }

    private void showFileChooser(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMsg = valueCallback;
        this.isChoose = false;
        if (this.mChooseDialog == null) {
            this.mChooseDialog = new ChoosePicDialog(this.mContext, (Function1<? super ChoosePicType, Unit>) new ExamPluginDriver$$ExternalSyntheticLambda6(this));
        }
        if (!this.mChooseDialog.isShowing()) {
            this.mChooseDialog.show();
        }
        XesLogTag xesLogTag = this.TAG;
        XesLog.i(xesLogTag, "dialog = " + this.mChooseDialog.hashCode());
        this.mChooseDialog.setDismissListener(new ExamPluginDriver$$ExternalSyntheticLambda5(this));
    }

    public /* synthetic */ Unit lambda$showFileChooser$5$ExamPluginDriver(ChoosePicType choosePicType) {
        if (choosePicType == ChoosePicType.take) {
            this.isChoose = true;
            TakePhotoStateUtil.startTakePhoto();
            takePhoto();
            this.isTakePhoto = true;
            return null;
        } else if (choosePicType != ChoosePicType.choose) {
            return null;
        } else {
            this.isChoose = true;
            choosePhoto();
            return null;
        }
    }

    public /* synthetic */ void lambda$showFileChooser$6$ExamPluginDriver() {
        if (!this.isChoose) {
            clearUploadMessage();
        }
    }

    private OnResultCallbackListener getOnResultCallbackListener() {
        return new OnResultCallbackListener<LocalMedia>() {
            public void onResult(List<LocalMedia> list) {
                try {
                    Uri[] uriArr = new Uri[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        File file = new File(list.get(i).getCompressPath());
                        if (file.exists()) {
                            uriArr[i] = Uri.fromFile(file);
                        }
                    }
                    if (ExamPluginDriver.this.mUploadMsg != null) {
                        ExamPluginDriver.this.mUploadMsg.onReceiveValue(uriArr);
                    }
                    if (ExamPluginDriver.this.isTakePhoto) {
                        TakePhotoStateUtil.finishTakePhoto();
                    }
                    if (ExamPluginDriver.this.mChooseDialog != null && ExamPluginDriver.this.mChooseDialog.isShowing()) {
                        ExamPluginDriver.this.mChooseDialog.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onCancel() {
                if (ExamPluginDriver.this.mChooseDialog != null && ExamPluginDriver.this.mChooseDialog.isShowing()) {
                    ExamPluginDriver.this.mChooseDialog.dismiss();
                }
                ExamPluginDriver.this.clearUploadMessage();
                if (ExamPluginDriver.this.isTakePhoto) {
                    TakePhotoStateUtil.finishTakePhoto();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void clearUploadMessage() {
        try {
            ValueCallback<Uri[]> valueCallback = this.mUploadMsg;
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
            }
            this.mUploadMsg = null;
        } catch (Exception unused) {
        }
    }

    private void takePhoto() {
        if (this.mOnResultCallbackListener == null) {
            this.mOnResultCallbackListener = getOnResultCallbackListener();
        }
        PictureSelectorHelper.Companion.getInstance().takePhotoForExam((Activity) this.mContext, 1, false, false, 0, this.mOnResultCallbackListener);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("takePhoto", "课中考试拍照");
        XesLog.i(this.TAG, jsonObject);
    }

    private void choosePhoto() {
        if (this.mOnResultCallbackListener == null) {
            this.mOnResultCallbackListener = getOnResultCallbackListener();
        }
        PictureSelectorHelper.Companion.getInstance().choosePhoto((Activity) this.mContext, 10, false, false, 0, this.mOnResultCallbackListener);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("choosePhoto", "课中考试选择图片");
        XesLog.i(this.TAG, jsonObject);
    }

    private void startExam(String str) {
        if (this.mExamPluginView == null) {
            this.mExamPluginView = new ExamPluginView(this.mContext);
            this.mLiveRoomProvider.addView(this, this.mExamPluginView, this.mPluginConfData.getViewLevel("ExamView"), LiveAreaContext.get().getPptLp().newLp());
            this.mExamPluginView.loadUrl(str);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("startExam", str);
        XesLog.i(this.TAG, jsonObject);
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.view.View, com.tal.app.thinkacademy.live.business.exam.view.ExamPluginView] */
    public void removeExam() {
        ExamPluginView examPluginView = this.mExamPluginView;
        if (examPluginView != null) {
            examPluginView.setVisibility(8);
            this.mExamPluginView.onDestroy();
            this.mLiveRoomProvider.removeView(this.mExamPluginView);
            this.mExamPluginView = null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("removeExam", "停止考试");
        XesLog.i(this.TAG, jsonObject);
    }

    private void stopExam() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("stopExam", "结束考试");
        XesLog.i(this.TAG, jsonObject);
        removeExam();
        destroy();
    }

    private void completedExam() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP);
            jSONObject.put("submit", true);
            IircControllerProvider ircControllerProvider = this.mLiveRoomProvider.getIrcControllerProvider();
            this.mIrcControllerProvider = ircControllerProvider;
            ircControllerProvider.sendPeerMessage(this.mFrom, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), 0);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("completedExam", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            XesLog.i(this.TAG, jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onMessage(String str, String str2) {
        XesLogTag xesLogTag = this.TAG;
        XesLog.i(xesLogTag, "ircTypeKey = " + str + " message = " + str2);
        if (TextUtils.equals(str, "class_examination")) {
            try {
                ClassExam classExam = (ClassExam) GsonUtils.fromJson(new JSONObject(str2).optString("class_examination"), ClassExam.class);
                this.mFrom = classExam.getFrom();
                if (classExam.isPub()) {
                    XesDataBus.with(DataBusKey.LESSON_EXAM_STATE).postStickyData("close");
                    int status = classExam.getStatus();
                    if (status == 1) {
                        startExam(getExamUrl(classExam));
                        this.mExamStatus = 1;
                    } else if (status == 2) {
                        if (this.mExamStatus == 0) {
                            startExam(getExamUrl(classExam));
                        }
                        changeExamTime(classExam);
                        this.mExamStatus = 2;
                    } else {
                        if (this.mExamStatus == 0) {
                            startExam(getExamUrl(classExam));
                        }
                        if (this.mExamPluginView != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", "completeExam");
                            this.mExamPluginView.getWebAgent().jsCallBack("window.clientMessageHandlers", GsonUtils.toJson(hashMap));
                        }
                        this.mExamStatus = 3;
                    }
                } else {
                    XesDataBus.with(DataBusKey.LESSON_EXAM_STATE).postStickyData("open");
                    stopExam();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeExamTime(ClassExam classExam) {
        WebAgent webAgent;
        ExamPluginView examPluginView = this.mExamPluginView;
        if (examPluginView != null && (webAgent = examPluginView.getWebAgent()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "updateRemainSecondsTo");
            hashMap.put("remainSeconds", getRemainSeconds(classExam) + "");
            webAgent.jsCallBack("window.clientMessageHandlers", GsonUtils.toJson(hashMap));
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "updateRemainSecondsTo");
            jsonObject.addProperty("remainSeconds", getRemainSeconds(classExam) + "");
            XesLog.i(this.TAG, jsonObject);
        }
    }

    private String getExamUrl(ClassExam classExam) {
        Uri.Builder buildUpon = Uri.parse(classExam.getExamUrl()).buildUpon();
        String str = "1";
        buildUpon.appendQueryParameter(LeanplumUtil.platform, PadUtils.isPad(this.mContext) ? "4" : str);
        buildUpon.appendQueryParameter("token", UserInfoBll.getInstance().getUserInfoEntity().getUnifiedAccessToken());
        buildUpon.appendQueryParameter("studentId", UserInfoBll.getInstance().getUserInfoEntity().getUid());
        buildUpon.appendQueryParameter("classId", this.mLiveRoomProvider.getDataStorage().getCourseInfo().getClassId() + "");
        buildUpon.appendQueryParameter("isLate", this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime() - classExam.getBeginTime() > 59 ? str : EnterRoomMuteData.STATUS_UN_MUTE);
        buildUpon.appendQueryParameter("remainSeconds", getRemainSeconds(classExam) + "");
        buildUpon.appendQueryParameter("duration", classExam.getTotaltime() + "");
        if (classExam.getStatus() != 3) {
            str = EnterRoomMuteData.STATUS_UN_MUTE;
        }
        buildUpon.appendQueryParameter("completed", str);
        buildUpon.appendQueryParameter("from", ClassTabConstants.Live);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("url", buildUpon.toString());
        XesLog.i(this.TAG, jsonObject);
        return buildUpon.toString();
    }

    private long getRemainSeconds(ClassExam classExam) {
        return (classExam.getBeginTime() + ((long) classExam.getTotaltime())) - this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime();
    }

    public void onDestroy() {
        XesDataBus.with(DataBusKey.SHOW_FILE_CHOOSER).removeObservers(this);
        XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).removeObservers(this);
        XesDataBus.with(DataBusKey.COMPLETED_EXAM_SUCCESS).removeObservers(this);
        XesDataBus.with(DataBusKey.EXAM_REPEAT).removeObservers(this);
        XesDataBus.with(DataBusKey.EXAM_REPORT_SHOWING).removeObservers(this);
    }
}
