package com.sensorsdata.analytics.android.sdk.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.ThreadNameConstants;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.OaidHelper;
import com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.visual.HeatMapService;
import com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService;
import com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public class SensorsDataDialogUtils {
    private static final String TAG = "SA.SensorsDataDialogUtils";
    private static Dialog sDialog;

    public static void showDialog(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setCancelable(false);
        builder.setNegativeButton(str4, onClickListener2);
        builder.setPositiveButton(str3, onClickListener);
        dialogShowDismissOld(builder.create());
    }

    public static void showChannelDebugDialog(final Activity activity, String str, String str2, String str3, String str4) {
        final Activity activity2 = activity;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        showDialog(activity, "即将开启联调模式", "", "确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Context applicationContext = activity2.getApplicationContext();
                boolean isTrackInstallation = ChannelUtils.isTrackInstallation(applicationContext);
                if (!isTrackInstallation || ChannelUtils.isCorrectTrackInstallation(applicationContext)) {
                    String androidID = SensorsDataUtils.getAndroidID(applicationContext);
                    String oaid = OaidHelper.getOAID(applicationContext);
                    if (isTrackInstallation && !ChannelUtils.isGetDeviceInfo(applicationContext, androidID, oaid)) {
                        SensorsDataDialogUtils.showChannelDebugErrorDialog(activity2);
                    } else if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
                        SensorsDataDialogUtils.showDialog(activity2, "当前网络不可用，请检查网络！");
                    } else {
                        String deviceInfo = ChannelUtils.getDeviceInfo(activity2, androidID, oaid);
                        final SensorsDataLoadingDialog sensorsDataLoadingDialog = new SensorsDataLoadingDialog(activity2);
                        SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
                        SensorsDataDialogUtils.requestActiveChannel(str5, str6, str7, str8, deviceInfo, isTrackInstallation, new HttpCallback.JsonCallback() {
                            public void onFailure(int i, String str) {
                                sensorsDataLoadingDialog.dismiss();
                                SALog.i(SensorsDataDialogUtils.TAG, "ChannelDebug request error:" + str);
                                SensorsDataDialogUtils.showDialog(activity2, "网络异常,请求失败!");
                            }

                            public void onResponse(JSONObject jSONObject) {
                                sensorsDataLoadingDialog.dismiss();
                                if (jSONObject == null) {
                                    SALog.i(SensorsDataDialogUtils.TAG, "ChannelDebug response error msg: response is null");
                                    SensorsDataDialogUtils.showDialog(activity2, "添加白名单请求失败，请联系神策技术支持人员排查问题!");
                                } else if (jSONObject.optInt("code", 0) == 1) {
                                    SensorsDataAutoTrackHelper.showChannelDebugActiveDialog(activity2);
                                } else {
                                    SALog.i(SensorsDataDialogUtils.TAG, "ChannelDebug response error msg:" + jSONObject.optString("message"));
                                    SensorsDataDialogUtils.showDialog(activity2, "添加白名单请求失败，请联系神策技术支持人员排查问题!");
                                }
                            }
                        });
                    }
                } else {
                    SensorsDataDialogUtils.showChannelDebugErrorDialog(activity2);
                }
            }
        }, "取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void showChannelDebugErrorDialog(final Activity activity) {
        showDialog(activity, "检测到 “设备码为空”，可能原因如下，请排查：", "1. 开启 App 时拒绝“电话”授权；\n2. 手机系统权限设置中是否关闭“电话”授权；\n3. 请联系研发人员确认是否“调用 trackInstallation 接口在获取“电话”授权之后。\n\n 排查修复后，请先卸载应用并重新安装，再扫码进行联调。", "确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
            }
        }, (String) null, (DialogInterface.OnClickListener) null);
    }

    public static void showPopupWindowDialog(final Activity activity, Uri uri) {
        AnonymousClass4 r0;
        try {
            Class<?> cls = Class.forName("com.sensorsdata.sf.ui.utils.PreviewUtil");
            String queryParameter = uri.getQueryParameter("sf_popup_test");
            String queryParameter2 = uri.getQueryParameter("popup_window_id");
            boolean parseBoolean = !TextUtils.isEmpty(queryParameter) ? Boolean.parseBoolean(queryParameter) : false;
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            Method method = null;
            while (true) {
                if (i >= length) {
                    r0 = null;
                    break;
                }
                Method method2 = declaredMethods[i];
                if (method2.getName().equals("showPreview")) {
                    if (method2.getParameterTypes().length == 4) {
                        r0 = new Runnable() {
                            public void run() {
                                Activity activity = activity;
                                if (activity != null) {
                                    activity.runOnUiThread(new Runnable() {
                                        public void run() {
                                            SensorsDataDialogUtils.showDialog(activity, "测试弹窗加载失败，请确认网络或项目环境是否正常！");
                                        }
                                    });
                                }
                            }
                        };
                        method = method2;
                        break;
                    }
                    method = method2;
                }
                i++;
            }
            if (method != null) {
                if (r0 != null) {
                    method.invoke((Object) null, new Object[]{activity, Boolean.valueOf(parseBoolean), queryParameter2, r0});
                } else {
                    method.invoke((Object) null, new Object[]{activity, Boolean.valueOf(parseBoolean), queryParameter2});
                }
                SchemeActivity.isPopWindow = true;
                return;
            }
            startLaunchActivity(activity);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            startLaunchActivity(activity);
        }
    }

    public static void showDebugModeSelectDialog(final Activity activity, final String str, final String str2, final String str3) {
        try {
            DebugModeSelectDialog debugModeSelectDialog = new DebugModeSelectDialog(activity, SensorsDataAPI.sharedInstance().getDebugMode());
            debugModeSelectDialog.setCanceledOnTouchOutside(false);
            debugModeSelectDialog.setOnDebugModeDialogClickListener(new DebugModeSelectDialog.OnDebugModeViewClickListener() {
                public void onCancel(Dialog dialog) {
                    dialog.cancel();
                }

                public void setDebugMode(Dialog dialog, SensorsDataAPI.DebugMode debugMode) {
                    SensorsDataAPI.sharedInstance().setDebugMode(debugMode);
                    dialog.cancel();
                }
            });
            debugModeSelectDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    String str;
                    String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
                    SensorsDataAPI.DebugMode debugMode = SensorsDataAPI.sharedInstance().getDebugMode();
                    if (SensorsDataAPI.sharedInstance().isNetworkRequestEnable() && !TextUtils.isEmpty(serverUrl) && !TextUtils.isEmpty(str) && debugMode != SensorsDataAPI.DebugMode.DEBUG_OFF) {
                        if (TextUtils.isEmpty(str2)) {
                            new SendDebugIdThread(serverUrl, SensorsDataAPI.sharedInstance().getDistinctId(), str, ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                        } else {
                            try {
                                if (!TextUtils.isEmpty(str3)) {
                                    String str2 = str2 + "?project=" + str3;
                                    SALog.i(SensorsDataDialogUtils.TAG, "sf url:" + str2);
                                    new SendDebugIdThread(str2, SensorsDataAPI.sharedInstance().getDistinctId(), str, ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                                }
                            } catch (Exception e) {
                                SALog.printStackTrace(e);
                            }
                        }
                    }
                    if (debugMode == SensorsDataAPI.DebugMode.DEBUG_OFF) {
                        str = "已关闭调试模式，请重新扫描二维码进行开启";
                    } else if (debugMode == SensorsDataAPI.DebugMode.DEBUG_ONLY) {
                        str = "开启调试模式，校验数据，但不进行数据导入；关闭 App 进程后，将自动关闭调试模式";
                    } else {
                        str = debugMode == SensorsDataAPI.DebugMode.DEBUG_AND_TRACK ? "开启调试模式，校验数据，并将数据导入到神策分析中；关闭 App 进程后，将自动关闭调试模式" : "";
                    }
                    Toast.makeText(activity, str, 1).show();
                    SALog.info(SensorsDataDialogUtils.TAG, "您当前的调试模式是：" + debugMode, (Throwable) null);
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                }
            });
            dialogShowDismissOld(debugModeSelectDialog);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void showOpenHeatMapDialog(final Activity activity, final String str, final String str2) {
        boolean z;
        try {
            if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
                showDialog(activity, "已关闭网络请求（NetworkRequest），无法使用 App 点击分析，请开启后再试！");
            } else if (!SensorsDataAPI.sharedInstance().isHeatMapEnabled()) {
                showDialog(activity, "SDK 没有被正确集成，请联系贵方技术人员开启点击分析。");
            } else {
                try {
                    z = "WIFI".equals(NetworkUtils.networkType(activity));
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                    z = false;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("提示");
                if (z) {
                    builder.setMessage("正在连接 App 点击分析...");
                } else {
                    builder.setMessage("正在连接 App 点击分析，建议在 WiFi 环境下使用。");
                }
                builder.setCancelable(false);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HeatMapService.getInstance().start(activity, str, str2);
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                AlertDialog create = builder.create();
                dialogShowDismissOld(create);
                try {
                    create.getButton(-2).setTextColor(-16777216);
                    create.getButton(-2).setBackgroundColor(-1);
                    create.getButton(-1).setTextColor(-65536);
                    create.getButton(-1).setBackgroundColor(-1);
                    if (Build.VERSION.SDK_INT >= 16) {
                        create.getButton(-2).setBackground(getDrawable());
                        create.getButton(-1).setBackground(getDrawable());
                        return;
                    }
                    create.getButton(-2).setBackgroundDrawable(getDrawable());
                    create.getButton(-1).setBackgroundDrawable(getDrawable());
                } catch (Exception e2) {
                    SALog.printStackTrace(e2);
                }
            }
        } catch (Exception e3) {
            SALog.printStackTrace(e3);
        }
    }

    static StateListDrawable getDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#dddddd"));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842908}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    public static void showOpenVisualizedAutoTrackDialog(final Activity activity, final String str, final String str2) {
        boolean z;
        try {
            if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
                showDialog(activity, "已关闭网络请求（NetworkRequest），无法使用 App 可视化全埋点，请开启后再试！");
            } else if (!SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) {
                showDialog(activity, "SDK 没有被正确集成，请联系贵方技术人员开启可视化全埋点。");
            } else {
                try {
                    z = "WIFI".equals(NetworkUtils.networkType(activity));
                } catch (Exception unused) {
                    z = false;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("提示");
                if (z) {
                    builder.setMessage("正在连接 App 可视化全埋点...");
                } else {
                    builder.setMessage("正在连接 App 可视化全埋点，建议在 WiFi 环境下使用。");
                }
                builder.setCancelable(false);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        VisualizedAutoTrackService.getInstance().start(activity, str, str2);
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                AlertDialog create = builder.create();
                dialogShowDismissOld(create);
                try {
                    create.getButton(-2).setTextColor(-16777216);
                    create.getButton(-2).setBackgroundColor(-1);
                    create.getButton(-1).setTextColor(-65536);
                    create.getButton(-1).setBackgroundColor(-1);
                    if (Build.VERSION.SDK_INT >= 16) {
                        create.getButton(-2).setBackground(getDrawable());
                        create.getButton(-1).setBackground(getDrawable());
                        return;
                    }
                    create.getButton(-2).setBackgroundDrawable(getDrawable());
                    create.getButton(-1).setBackgroundDrawable(getDrawable());
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        } catch (Exception e2) {
            SALog.printStackTrace(e2);
        }
    }

    public static void showDialog(final Context context, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示").setMessage(str).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SensorsDataDialogUtils.startLaunchActivity(context);
            }
        });
        AlertDialog create = builder.create();
        dialogShowDismissOld(create);
        try {
            create.getButton(-1).setTextColor(-65536);
            create.getButton(-1).setBackgroundColor(-1);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void showPairingCodeInputDialog(final Context context) {
        if (context == null) {
            SALog.i(TAG, "The argument context can't be null");
        } else if (!(context instanceof Activity)) {
            SALog.i(TAG, "The static method showPairingCodeEditDialog(Context context) only accepts Activity as a parameter");
        } else {
            ((Activity) context).runOnUiThread(new Runnable() {
                public void run() {
                    new PairingCodeEditDialog(context).show();
                }
            });
        }
    }

    public static void startLaunchActivity(Context context) {
        try {
            if (isSchemeActivity(context)) {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
                ((SchemeActivity) context).finish();
                SALog.i(TAG, "startLaunchActivity");
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static boolean isSchemeActivity(Context context) {
        if (context == null) {
            return false;
        }
        return context instanceof SchemeActivity;
    }

    public static void dialogShowDismissOld(Dialog dialog) {
        try {
            Dialog dialog2 = sDialog;
            if (dialog2 != null && dialog2.isShowing()) {
                try {
                    sDialog.dismiss();
                    SALog.i(TAG, "Dialog dismiss");
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
            sDialog = dialog;
            dialog.show();
        } catch (Exception e2) {
            SALog.printStackTrace(e2);
        }
    }

    /* access modifiers changed from: private */
    public static void requestActiveChannel(String str, String str2, String str3, String str4, String str5, boolean z, HttpCallback httpCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("monitor_id", str2);
            jSONObject.put("distinct_id", SensorsDataAPI.sharedInstance().getDistinctId());
            jSONObject.put("project_id", str3);
            jSONObject.put("account_id", str4);
            jSONObject.put("has_active", z ? "true" : "false");
            jSONObject.put("device_code", str5);
            HttpMethod httpMethod = HttpMethod.POST;
            new RequestHelper.Builder(httpMethod, str + "/api/sdk/channel_tool/url").jsonData(jSONObject.toString()).callback(httpCallback).execute();
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private static class SendDebugIdThread extends Thread {
        private String distinctId;
        private String infoId;
        private String serverUrl;

        SendDebugIdThread(String str, String str2, String str3, String str4) {
            super(str4);
            this.distinctId = str2;
            this.infoId = str3;
            this.serverUrl = str;
        }

        public void run() {
            super.run();
            sendHttpRequest(this.serverUrl, false);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.io.BufferedOutputStream} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void sendHttpRequest(java.lang.String r14, boolean r15) {
            /*
                r13 = this;
                java.lang.String r0 = "SA.SensorsDataDialogUtils"
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                r3.<init>()     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                r3.append(r14)     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.String r4 = "&info_id=%s"
                r3.append(r4)     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.String r6 = r13.infoId     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                r7 = 0
                r5[r7] = r6     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.String r3 = "DebugMode URL:%s"
                java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                r5[r7] = r2     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r3, r1)     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.net.URLConnection r3 = r2.openConnection()     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x011d, all -> 0x0118 }
                if (r3 != 0) goto L_0x004f
                java.lang.String r14 = "can not connect %s,shouldn't happen"
                java.lang.Object[] r15 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                r15[r7] = r2     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                java.lang.String r14 = java.lang.String.format(r14, r15)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r14, r1)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                r13.closeStream(r1, r1, r1, r3)
                return
            L_0x004f:
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                if (r2 == 0) goto L_0x0065
                javax.net.ssl.SSLSocketFactory r5 = r2.mSSLSocketFactory     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                if (r5 == 0) goto L_0x0065
                boolean r5 = r3 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                if (r5 == 0) goto L_0x0065
                r5 = r3
                javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                javax.net.ssl.SSLSocketFactory r2 = r2.mSSLSocketFactory     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                r5.setSSLSocketFactory(r2)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            L_0x0065:
                r3.setInstanceFollowRedirects(r7)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                r2.<init>()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r5.<init>(r2)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r6.<init>()     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r8 = "{\"distinct_id\": \""
                r6.append(r8)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r8 = r13.distinctId     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r6.append(r8)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r8 = "\"}"
                r6.append(r8)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r5.write(r6)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r5.flush()     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r5 = "DebugMode request body : %s"
                java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r8[r7] = r6     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r5 = java.lang.String.format(r5, r8)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r5, r1)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r3.setDoOutput(r4)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                r3.setUseCaches(r7)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r5 = "POST"
                r3.setRequestMethod(r5)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.lang.String r5 = "Content-type"
                java.lang.String r6 = "text/plain"
                r3.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ Exception -> 0x010d, all -> 0x0108 }
                java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0105, all -> 0x0102 }
                r6.<init>(r5)     // Catch:{ Exception -> 0x0105, all -> 0x0102 }
                java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                java.lang.String r9 = "UTF-8"
                byte[] r8 = r8.getBytes(r9)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                r6.write(r8)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                r6.flush()     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                r2.close()     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                int r8 = r3.getResponseCode()     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                java.util.Locale r9 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                java.lang.String r10 = "DebugMode 后端的响应码是:%d"
                java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                r11[r7] = r12     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                java.lang.String r7 = java.lang.String.format(r9, r10, r11)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r7, r1)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                if (r15 != 0) goto L_0x00fa
                boolean r15 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(r8)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                if (r15 == 0) goto L_0x00fa
                java.lang.String r14 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(r3, r14)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                if (r15 != 0) goto L_0x00fa
                r13.closeStream(r2, r5, r6, r3)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
                r13.sendHttpRequest(r14, r4)     // Catch:{ Exception -> 0x0100, all -> 0x00fe }
            L_0x00fa:
                r13.closeStream(r2, r5, r6, r3)
                goto L_0x0127
            L_0x00fe:
                r14 = move-exception
                goto L_0x010b
            L_0x0100:
                r14 = move-exception
                goto L_0x0110
            L_0x0102:
                r14 = move-exception
                r6 = r1
                goto L_0x010b
            L_0x0105:
                r14 = move-exception
                r6 = r1
                goto L_0x0110
            L_0x0108:
                r14 = move-exception
                r5 = r1
                r6 = r5
            L_0x010b:
                r1 = r2
                goto L_0x0129
            L_0x010d:
                r14 = move-exception
                r5 = r1
                r6 = r5
            L_0x0110:
                r1 = r2
                goto L_0x0121
            L_0x0112:
                r14 = move-exception
                r5 = r1
                goto L_0x011b
            L_0x0115:
                r14 = move-exception
                r5 = r1
                goto L_0x0120
            L_0x0118:
                r14 = move-exception
                r3 = r1
                r5 = r3
            L_0x011b:
                r6 = r5
                goto L_0x0129
            L_0x011d:
                r14 = move-exception
                r3 = r1
                r5 = r3
            L_0x0120:
                r6 = r5
            L_0x0121:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r14)     // Catch:{ all -> 0x0128 }
                r13.closeStream(r1, r5, r6, r3)
            L_0x0127:
                return
            L_0x0128:
                r14 = move-exception
            L_0x0129:
                r13.closeStream(r1, r5, r6, r3)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.SendDebugIdThread.sendHttpRequest(java.lang.String, boolean):void");
        }

        private void closeStream(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream, BufferedOutputStream bufferedOutputStream, HttpURLConnection httpURLConnection) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    SALog.printStackTrace(e2);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e3) {
                    SALog.printStackTrace(e3);
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e4) {
                    SALog.printStackTrace(e4);
                }
            }
        }
    }
}
