package com.tal.app.thinkacademy.common.business.browser.dispatch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryParam;
import com.tal.app.thinkacademy.common.entity.HwShareWebPageUrlBean;
import com.tal.app.thinkacademy.common.entity.SycHomeWork;
import com.tal.app.thinkacademy.common.util.HwFileUtil;
import com.tal.app.thinkacademy.common.util.WxShareUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.Base64Util;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.PermissionHelper;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class LogInOutDispatcher implements IDispatcher {
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.JS_BRIDGE;
    private WeakReference<FragmentActivity> mActivityWef;

    public LogInOutDispatcher(FragmentActivity fragmentActivity) {
        this.mActivityWef = new WeakReference<>(fragmentActivity);
    }

    public void dispatch(JsInjection jsInjection, String str, Map<String, Object> map) {
        if (TextUtils.equals(str, "login")) {
            Bundle bundle = new Bundle();
            bundle.putInt("login_user_type", 1);
            XesRoute.getInstance().navigation(RouteMap.ROUTE_LOGIN_ACTIVITY, bundle);
        } else if (TextUtils.equals(str, "goBack")) {
            finishActivity();
        } else if (TextUtils.equals(str, "buyCourseSuccess")) {
            XesDataBus.with(DataBusKey.BUY_COURSE_SUCCESS).postStickyData("buyCourseSuccess");
        } else if (TextUtils.equals(str, "jsGetNaviteParame")) {
            XesDataBus.with(DataBusKey.NATIVE_FINISH).postStickyData("");
        } else if (TextUtils.equals(str, "goCourseList")) {
            XesDataBus.with(DataBusKey.GO_COURSE_LIST).postStickyData("");
        } else if (TextUtils.equals(str, "hwHomeWorkBreakOff")) {
            finishActivity();
        } else if (TextUtils.equals(str, "hwHomeWorkSubmitSuccess")) {
            XesLog.i(TAG, "收到js提交作业,hwHomeWorkSubmitSuccess，回调");
            ((FragmentActivity) this.mActivityWef.get()).runOnUiThread(new LogInOutDispatcher$$ExternalSyntheticLambda0(map));
        } else if (TextUtils.equals(str, "hwHomeWorkCompletion")) {
            XesLog.i(TAG, "收到js提交作业,hwHomeWorkCompletion，回调");
            ((FragmentActivity) this.mActivityWef.get()).runOnUiThread(LogInOutDispatcher$$ExternalSyntheticLambda1.INSTANCE);
        } else if (TextUtils.equals(str, "hwHomeWorkRequestTimeOut")) {
            XesLog.i(TAG, "收到js提交作业,hwHomeWorkRequestTimeOut，回调");
            finishActivity();
            XesDataBus.with(DataBusKey.REQUEST_HOMEWORK_OUT_TIME).postStickyData(DataBusKey.REQUEST_HOMEWORK_OUT_TIME);
        } else if (TextUtils.equals(str, "hwHomeWorkQuitWebView")) {
            finishActivity();
            XesDataBus.with(DataBusKey.EXIT_HOMEWORK).postStickyData(DataBusKey.EXIT_HOMEWORK);
        } else if (TextUtils.equals(str, "hwApiResponse")) {
            XesDataBus.with(DataBusKey.HOMEWORK_RESPONSE).postStickyData(map);
        } else if (TextUtils.equals(str, "hwUploadImg")) {
            XesDataBus.with(DataBusKey.HOMEWORK_UPLOAD_IMG).postStickyData(map);
        } else if (TextUtils.equals(str, "completedExamSuccess")) {
            XesDataBus.with(DataBusKey.COMPLETED_EXAM_SUCCESS).postStickyData(DataBusKey.COMPLETED_EXAM_SUCCESS);
        } else if (TextUtils.equals(str, "dismissView")) {
            XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).postStickyData(DataBusKey.WEB_DISMISS_VIEW);
        } else if (TextUtils.equals(str, "hwHomeWorkRepeat")) {
            XesDataBus.with(DataBusKey.EXAM_REPEAT).postStickyData(DataBusKey.EXAM_REPEAT);
        } else if (TextUtils.equals("photoLibrary", str)) {
            try {
                final H5PhotoLibraryParam h5PhotoLibraryParam = (H5PhotoLibraryParam) GsonUtils.fromJson(GsonUtils.toJson(map), H5PhotoLibraryParam.class);
                ((FragmentActivity) this.mActivityWef.get()).runOnUiThread(new Runnable() {
                    public void run() {
                        XesDataBus.with(DataBusKey.CUSTOM_SELECT_PHOTO_VIDEO).postStickyData(h5PhotoLibraryParam);
                    }
                });
            } catch (Exception e) {
                XesLog.dt("", "photoLibrary error = " + e.toString());
            }
        } else {
            onProcessData(jsInjection, str, map);
        }
    }

    static /* synthetic */ void lambda$dispatch$0(Map map) {
        String obj = map.get("paperId").toString();
        String obj2 = map.get("state").toString();
        Object obj3 = map.get("type");
        int i = 0;
        if (obj3 != null) {
            try {
                i = ((Integer) obj3).intValue();
            } catch (Exception unused) {
            }
        }
        SycHomeWork sycHomeWork = new SycHomeWork(obj, obj2, Integer.valueOf(i));
        if (obj != null) {
            XesDataBus.with(DataBusKey.SYC_HOMEWORK).postStickyData(sycHomeWork);
            XesDataBus.with(DataBusKey.HOMEWORK_SUBMIT_SUCCESS).postStickyData(sycHomeWork);
        }
    }

    static /* synthetic */ void lambda$dispatch$1() {
        XesLog.i(TAG, "收到js提交作业,hwHomeWorkCompletion，回调开始发送eventbus");
        XesDataBus.with(DataBusKey.SYC_HOMEWORK).postStickyData("");
        XesDataBus.with(DataBusKey.SYNC_HOMEWORK_SUCCESS).postStickyData("");
    }

    private void onProcessData(JsInjection jsInjection, String str, final Map<String, Object> map) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1890676037:
                if (str.equals("nativeImageShare")) {
                    c = 0;
                    break;
                }
                break;
            case 112917697:
                if (str.equals("savePicture")) {
                    c = 1;
                    break;
                }
                break;
            case 163616773:
                if (str.equals("shareWeChat")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Tag tag = TAG;
                XesLog.i(tag, "调用原生分享接口,nativeImageShare");
                FragmentActivity fragmentActivity = (FragmentActivity) this.mActivityWef.get();
                if (fragmentActivity != null) {
                    fragmentActivity.runOnUiThread(new Runnable() {
                        public void run() {
                            try {
                                LogInOutDispatcher.this.onNativeImageShare((String) map.get("imageData"));
                            } catch (Exception e) {
                                Tag access$300 = LogInOutDispatcher.TAG;
                                XesLog.i(access$300, "调用原生分享接口 失败=" + e);
                            }
                        }
                    });
                    return;
                }
                XesLog.i(tag, "调用原生分享接口 失败，activity=null");
                return;
            case 1:
                Tag tag2 = TAG;
                XesLog.i(tag2, "保存图片接口,savePicture");
                FragmentActivity fragmentActivity2 = (FragmentActivity) this.mActivityWef.get();
                if (fragmentActivity2 != null) {
                    fragmentActivity2.runOnUiThread(new Runnable() {
                        public void run() {
                            try {
                                LogInOutDispatcher.this.onSavePic((String) map.get("imageData"));
                            } catch (Exception e) {
                                LogInOutDispatcher.this.sendSavePicBusMsg(false);
                                Tag access$300 = LogInOutDispatcher.TAG;
                                XesLog.i(access$300, "保存图片接口 保存图片失败=" + e);
                            }
                        }
                    });
                    return;
                }
                sendSavePicBusMsg(false);
                XesLog.i(tag2, "保存图片接口 保存图片失败，activity=null");
                return;
            case 2:
                FragmentActivity fragmentActivity3 = (FragmentActivity) this.mActivityWef.get();
                if (fragmentActivity3 != null) {
                    fragmentActivity3.runOnUiThread(new Runnable() {
                        public void run() {
                            LogInOutDispatcher.this.onShareWechat(map);
                        }
                    });
                    return;
                }
                XesLog.i(TAG, "分享接口，分享失败，activity=null");
                WxShareUtil.INSTANCE.sendShareResult(false);
                return;
            default:
                XesLog.i(TAG, "onProcessData 调用其他bridge接口");
                return;
        }
    }

    public void setActivityWef(WeakReference<FragmentActivity> weakReference) {
        this.mActivityWef = weakReference;
    }

    private void finishActivity() {
        FragmentActivity fragmentActivity = (FragmentActivity) this.mActivityWef.get();
        if (fragmentActivity != null && !fragmentActivity.getLocalClassName().endsWith("live.core.live.LiveActivity")) {
            fragmentActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public void onShareWechat(Map<String, Object> map) {
        int i;
        XesLog.i(TAG, "调用微信分享接口,shareWeChat");
        try {
            i = (int) Double.parseDouble(map.get("type").toString());
        } catch (Exception e) {
            Tag tag = TAG;
            XesLog.i(tag, "调用微信分享接口,获取type失败=" + e);
            i = 1;
        }
        try {
            HwShareWebPageUrlBean hwShareWebPageUrlBean = new HwShareWebPageUrlBean();
            hwShareWebPageUrlBean.setType(i);
            hwShareWebPageUrlBean.setTitle((String) map.get("title"));
            hwShareWebPageUrlBean.setWebpageUrl((String) map.get("webpageUrl"));
            hwShareWebPageUrlBean.setDescription((String) map.get("description"));
            hwShareWebPageUrlBean.setThumbData((String) map.get("thumbData"));
            WxShareUtil.INSTANCE.shareWebPageMsg(hwShareWebPageUrlBean);
        } catch (Exception e2) {
            Tag tag2 = TAG;
            XesLog.i(tag2, "调用微信分享接口,失败=" + e2);
            WxShareUtil.INSTANCE.sendShareResult(false);
        }
    }

    /* access modifiers changed from: private */
    public void onSavePic(final String str) {
        if (PermissionUtils.isGranted("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")) {
            startToSavePic(str);
            XesLog.i(TAG, "保存图片接口 已经获取了Sdcard存储权限，");
            return;
        }
        Tag tag = TAG;
        XesLog.i(tag, "保存图片接口 未获取Sdcard存储权限，开始申请权限");
        FragmentActivity fragmentActivity = (FragmentActivity) this.mActivityWef.get();
        if (fragmentActivity == null) {
            sendSavePicBusMsg(false);
            XesLog.i(tag, "保存图片接口,未获取Sdcard存储权限，activity == null");
            return;
        }
        PermissionHelper.INSTANCE.request(fragmentActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, new Function1<Boolean, Unit>() {
            public Unit invoke(Boolean bool) {
                if (bool.booleanValue()) {
                    LogInOutDispatcher.this.startToSavePic(str);
                    return null;
                }
                LogInOutDispatcher.this.sendSavePicBusMsg(false);
                XesLog.i(LogInOutDispatcher.TAG, "申请权限失败，未获取了Sdcard存储权限");
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void startToSavePic(String str) {
        boolean z;
        Bitmap base64ToBitmap = Base64Util.base64ToBitmap(str);
        if (base64ToBitmap != null) {
            String str2 = "xueersiPic" + System.currentTimeMillis() + ".jpg";
            File file = new File(HwFileUtil.INSTANCE.getSaveCameraDir(), str2);
            z = ImageUtils.save(base64ToBitmap, file, Bitmap.CompressFormat.JPEG);
            HwFileUtil.INSTANCE.saveToGallery(Utils.getApp(), file.getAbsolutePath(), str2, str2);
        } else {
            z = false;
        }
        if (z) {
            sendSavePicBusMsg(true);
            XesLog.i(TAG, "保存图片成功");
            return;
        }
        sendSavePicBusMsg(false);
        XesLog.i(TAG, "保存图片失败");
    }

    /* access modifiers changed from: private */
    public void sendSavePicBusMsg(boolean z) {
        XesDataBus.with(DataBusKey.BRIDGE_SAVE_PICTURE_RESULT).postStickyData(Integer.valueOf(z ? 1 : 0));
    }

    /* access modifiers changed from: private */
    public void onNativeImageShare(String str) {
        Bitmap base64ToBitmap = Base64Util.base64ToBitmap(str);
        if (base64ToBitmap != null) {
            Tag tag = TAG;
            XesLog.i(tag, "系统分享,base64转图片成功");
            File saveCameraDir = HwFileUtil.INSTANCE.getSaveCameraDir();
            File file = new File(saveCameraDir, "xueersiPic" + System.currentTimeMillis() + ".jpg");
            if (!ImageUtils.save(base64ToBitmap, file, Bitmap.CompressFormat.JPEG)) {
                XesLog.i(tag, "系统分享,保存图片失败");
            } else if (file.exists()) {
                XesLog.i(tag, "系统分享,保存文件成功，文件存在");
                FragmentActivity fragmentActivity = (FragmentActivity) this.mActivityWef.get();
                if (fragmentActivity != null) {
                    gotoSystemImageShare(fragmentActivity, file);
                    return;
                }
                XesLog.i(tag, "系统分享,吊起分享失败，activity=null");
            } else {
                XesLog.i(tag, "系统分享,保存文件失败，文件不存在");
            }
        } else {
            XesLog.e(TAG, "系统分享,base64转图片失败");
        }
    }

    /* access modifiers changed from: package-private */
    public void gotoSystemImageShare(Context context, File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", HwFileUtil.INSTANCE.fromFile(file));
        intent.setType("image/*");
        intent.addFlags(268435456);
        if (context != null) {
            context.startActivity(Intent.createChooser(intent, ""));
        }
    }
}
