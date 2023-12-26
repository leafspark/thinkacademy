package com.sensorsdata.analytics.android.sdk.remote;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.ServerUrl;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import org.json.JSONObject;

public class SensorsDataRemoteManagerDebug extends BaseSensorsDataSDKRemoteManager {
    private static final String TAG = "SA.SensorsDataRemoteManagerDebug";
    private String errorMsg = "";

    public SensorsDataRemoteManagerDebug(SensorsDataAPI sensorsDataAPI) {
        super(sensorsDataAPI);
        SALog.i(TAG, "remote config: Construct a SensorsDataRemoteManagerDebug");
    }

    public void pullSDKConfigFromServer() {
        SALog.i(TAG, "remote config: Running pullSDKConfigFromServer");
    }

    public void requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z) {
        SALog.i(TAG, "remote config: Running requestRemoteConfig");
    }

    public void resetPullSDKConfigTimer() {
        SALog.i(TAG, "remote config: Running resetPullSDKConfigTimer");
    }

    public void applySDKConfigFromCache() {
        SALog.i(TAG, "remote config: Running applySDKConfigFromCache");
    }

    public void setSDKRemoteConfig(SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("$app_remote_config", sensorsDataSDKRemoteConfig.toJson().put("debug", true).toString());
            SensorsDataAPI.sharedInstance().trackInternal("$AppRemoteConfigChanged", jSONObject);
            SensorsDataAPI.sharedInstance().flush();
            mSDKRemoteConfig = sensorsDataSDKRemoteConfig;
            SALog.i(TAG, "remote config: The remote configuration takes effect immediately");
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void checkRemoteConfig(final Uri uri, final Activity activity) {
        if (verifyRemoteRequestParameter(uri, activity)) {
            SensorsDataDialogUtils.showDialog(activity, "提示", "开始获取采集控制信息", "继续", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    final SensorsDataLoadingDialog sensorsDataLoadingDialog = new SensorsDataLoadingDialog(activity);
                    SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
                    SensorsDataRemoteManagerDebug.this.requestRemoteConfig(false, (HttpCallback.StringCallback) new HttpCallback.StringCallback() {
                        public void onAfter() {
                        }

                        public void onFailure(int i, String str) {
                            sensorsDataLoadingDialog.dismiss();
                            SensorsDataDialogUtils.showDialog(activity, "远程配置获取失败，请稍后重新扫描二维码");
                            SALog.i(SensorsDataRemoteManagerDebug.TAG, "remote config: Remote request was failed,code is " + i + ",errorMessage is" + str);
                        }

                        public void onResponse(String str) {
                            sensorsDataLoadingDialog.dismiss();
                            if (!TextUtils.isEmpty(str)) {
                                SensorsDataSDKRemoteConfig sDKRemoteConfig = SensorsDataRemoteManagerDebug.this.toSDKRemoteConfig(str);
                                String queryParameter = uri.getQueryParameter("nv");
                                if (!sDKRemoteConfig.getNewVersion().equals(queryParameter)) {
                                    Activity activity = activity;
                                    SensorsDataDialogUtils.showDialog(activity, "信息版本不一致", "获取到采集控制信息的版本：" + sDKRemoteConfig.getNewVersion() + "，二维码信息的版本：" + queryParameter + "，请稍后重新扫描二维码", "确认", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            SensorsDataDialogUtils.startLaunchActivity(activity);
                                        }
                                    }, (String) null, (DialogInterface.OnClickListener) null);
                                } else {
                                    SensorsDataDialogUtils.showDialog(activity, "采集控制加载完成，可以通过 Android Studio 控制台日志来调试");
                                    SensorsDataRemoteManagerDebug.this.setSDKRemoteConfig(sDKRemoteConfig);
                                }
                            } else {
                                SensorsDataDialogUtils.showDialog(activity, "远程配置获取失败，请稍后再试");
                            }
                            SALog.i(SensorsDataRemoteManagerDebug.TAG, "remote config: Remote request was successful,response data is " + str);
                        }
                    });
                }
            }, "取消", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                }
            });
            return;
        }
        SensorsDataDialogUtils.showDialog(activity, this.errorMsg);
    }

    private boolean verifyRemoteRequestParameter(Uri uri, Activity activity) {
        boolean z;
        String queryParameter = uri.getQueryParameter("app_id");
        String queryParameter2 = uri.getQueryParameter("os");
        String queryParameter3 = uri.getQueryParameter("project");
        String queryParameter4 = uri.getQueryParameter("nv");
        String serverUrl = this.mSensorsDataAPI.getServerUrl();
        String project = !TextUtils.isEmpty(serverUrl) ? new ServerUrl(serverUrl).getProject() : "";
        SALog.i(TAG, "remote config: ServerUrl is " + serverUrl);
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            this.errorMsg = "网络连接失败，请检查设备网络，确认网络畅通后，请重新扫描二维码进行调试";
        } else if (this.mSensorsDataAPI != null && !this.mSensorsDataAPI.isNetworkRequestEnable()) {
            this.errorMsg = "SDK 网络权限已关闭，请允许 SDK 访问网络";
            SALog.i(TAG, "enableNetworkRequest is false");
        } else if (this.mDisableDefaultRemoteConfig) {
            this.errorMsg = "采集控制网络权限已关闭，请允许采集控制访问网络";
            SALog.i(TAG, "disableDefaultRemoteConfig is true");
        } else if (!project.equals(queryParameter3)) {
            this.errorMsg = "App 集成的项目与二维码对应的项目不同，无法进行调试";
        } else if (!"Android".equals(queryParameter2)) {
            this.errorMsg = "App 与二维码对应的操作系统不同，无法进行调试";
        } else if (!AppInfoUtils.getProcessName(activity).equals(queryParameter)) {
            this.errorMsg = "当前 App 与二维码对应的 App 不同，无法进行调试";
        } else if (TextUtils.isEmpty(queryParameter4)) {
            this.errorMsg = "二维码信息校验失败，请检查采集控制是否配置正确";
        } else {
            z = true;
            SALog.i(TAG, "remote config: Uri is " + uri.toString());
            SALog.i(TAG, "remote config: The verification result is " + z);
            return z;
        }
        z = false;
        SALog.i(TAG, "remote config: Uri is " + uri.toString());
        SALog.i(TAG, "remote config: The verification result is " + z);
        return z;
    }
}
