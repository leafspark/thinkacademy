package com.eaydu.omni.log;

import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.eaydu.omni.net.okhttp3.MediaType;
import com.eaydu.omni.net.okhttp3.OkHttpClient;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.RequestBody;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.urls.UrlManager;
import com.eaydu.omni.utils.FilePathUtils;
import com.eaydu.omni.utils.HttpUtils;
import com.eaydu.omni.utils.ZipUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoreRtcLogUpload {
    private final int OVER_TIME = 1200000;
    /* access modifiers changed from: private */
    public String TAG = "CoreRtcLogUpload";
    private UploadRunnable mUploadRunnable = null;
    private Thread mUploadThread = null;

    enum LogState {
        INIT,
        ZIP_STATE,
        LOG_AUTH,
        UPLOAD_START,
        UPLOAD_SUCCESS_STATE,
        UPLOAD_FAIL_STATE
    }

    public void start(long j, String str, String str2) {
        UploadRunnable uploadRunnable = new UploadRunnable(j, str, str2);
        this.mUploadRunnable = uploadRunnable;
        Thread thread = new Thread(uploadRunnable);
        this.mUploadThread = thread;
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    public boolean isRun() {
        UploadRunnable uploadRunnable = this.mUploadRunnable;
        if (uploadRunnable == null) {
            return false;
        }
        return uploadRunnable.isRun();
    }

    private class UploadRunnable implements Runnable {
        private String appid;
        private LogState mLogState;
        /* access modifiers changed from: private */
        public long mUpdatetime = 0;
        private String roomid;
        /* access modifiers changed from: private */
        public int tryCount = 0;
        private UploadParam uploadParam = new UploadParam();
        private long userid;
        private String zipFileName;
        private String zipFilePath;

        UploadRunnable(long j, String str, String str2) {
            this.userid = j;
            this.appid = str;
            this.roomid = str2;
            updateState(LogState.INIT);
        }

        /* access modifiers changed from: private */
        public void updateState(LogState logState) {
            this.mLogState = logState;
        }

        private void deleteOldZip() {
            String zipFilePath2 = FilePathUtils.getZipFilePath();
            File file = new File(zipFilePath2);
            if (file.isDirectory()) {
                String[] list = file.list();
                for (int i = 0; i < list.length; i++) {
                    String str = list[i];
                    if (str.contains(String.valueOf(this.userid) + "_android_") && list[i].endsWith(".zip")) {
                        deleteFile(zipFilePath2 + list[i]);
                    }
                }
            }
        }

        public boolean isRun() {
            if (System.currentTimeMillis() - this.mUpdatetime < 180000) {
                Log.i(CoreRtcLogUpload.this.TAG, "isRun in 3 * 60 * 1000");
                return true;
            }
            String access$000 = CoreRtcLogUpload.this.TAG;
            Log.i(access$000, "mLogState:" + this.mLogState);
            if (this.mLogState == LogState.INIT || this.mLogState == LogState.UPLOAD_SUCCESS_STATE) {
                return false;
            }
            return true;
        }

        private boolean checkOverTime(long j) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j <= 1200000) {
                return false;
            }
            String access$000 = CoreRtcLogUpload.this.TAG;
            Log.i(access$000, "upload overtime mCurrTime:" + currentTimeMillis + " mUploadStartTime:" + j);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                com.eaydu.omni.log.CoreRtcLogUpload r0 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r0 = r0.TAG
                java.lang.String r1 = "start UploadRunnable"
                android.util.Log.i(r0, r1)
                r4.deleteOldZip()
                com.eaydu.omni.log.CoreRtcLogUpload r0 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r0 = r0.TAG
                java.lang.String r1 = "ZIP_STATE"
                android.util.Log.i(r0, r1)
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r0 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.ZIP_STATE
                r4.updateState(r0)
                r0 = 0
                r1 = r0
                r2 = r1
            L_0x0021:
                r3 = 2
                if (r1 >= r3) goto L_0x002e
                boolean r2 = r4.zipFile()
                if (r2 == 0) goto L_0x002b
                goto L_0x002e
            L_0x002b:
                int r1 = r1 + 1
                goto L_0x0021
            L_0x002e:
                if (r2 != 0) goto L_0x0052
                com.eaydu.omni.log.CoreRtcLogUpload r0 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r0 = r0.TAG
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "zip failed zipFilePath="
                r1.append(r2)
                java.lang.String r2 = r4.zipFilePath
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.i(r0, r1)
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r0 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.INIT
                r4.updateState(r0)
                return
            L_0x0052:
                com.eaydu.omni.log.CoreRtcLogUpload r1 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r1 = r1.TAG
                java.lang.String r2 = "LOG_AUTH"
                android.util.Log.i(r1, r2)
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r1 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.LOG_AUTH
                r4.updateState(r1)
                r1 = r0
            L_0x0063:
                if (r0 >= r3) goto L_0x006f
                boolean r1 = r4.logAuth()
                if (r1 == 0) goto L_0x006c
                goto L_0x006f
            L_0x006c:
                int r0 = r0 + 1
                goto L_0x0063
            L_0x006f:
                if (r1 != 0) goto L_0x0082
                com.eaydu.omni.log.CoreRtcLogUpload r0 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r0 = r0.TAG
                java.lang.String r1 = "LOG_AUTH failed"
                android.util.Log.i(r0, r1)
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r0 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.INIT
                r4.updateState(r0)
                return
            L_0x0082:
                com.eaydu.omni.log.CoreRtcLogUpload r0 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r0 = r0.TAG
                java.lang.String r1 = "UPLOAD_START"
                android.util.Log.i(r0, r1)
                long r0 = java.lang.System.currentTimeMillis()
            L_0x0091:
                int r2 = r4.tryCount
                int r2 = r2 + 1
                r4.tryCount = r2
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r2 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.UPLOAD_START
                r4.updateState(r2)
                com.eaydu.omni.log.UploadParam r2 = r4.uploadParam
                com.eaydu.omni.log.CoreRtcLogUpload$UploadRunnable$1 r3 = new com.eaydu.omni.log.CoreRtcLogUpload$UploadRunnable$1
                r3.<init>()
                com.eaydu.omni.log.AliosUploadFile.aliosUploadFile(r2, r3)
            L_0x00a6:
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r2 = r4.mLogState
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r3 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.UPLOAD_START
                if (r2 != r3) goto L_0x00be
                boolean r2 = r4.checkOverTime(r0)
                if (r2 == 0) goto L_0x00b3
                goto L_0x00be
            L_0x00b3:
                r2 = 10000(0x2710, double:4.9407E-320)
                java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x00b9 }
                goto L_0x00a6
            L_0x00b9:
                r2 = move-exception
                r2.printStackTrace()
                goto L_0x00a6
            L_0x00be:
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r2 = r4.mLogState
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r3 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.UPLOAD_SUCCESS_STATE
                if (r2 != r3) goto L_0x00c5
                goto L_0x00cb
            L_0x00c5:
                boolean r2 = r4.checkOverTime(r0)
                if (r2 == 0) goto L_0x0091
            L_0x00cb:
                com.eaydu.omni.log.CoreRtcLogUpload r0 = com.eaydu.omni.log.CoreRtcLogUpload.this
                java.lang.String r0 = r0.TAG
                java.lang.String r1 = "UPLOAD END"
                android.util.Log.i(r0, r1)
                java.lang.String r0 = r4.zipFilePath
                r4.deleteFile(r0)
                com.eaydu.omni.log.CoreRtcLogUpload$LogState r0 = com.eaydu.omni.log.CoreRtcLogUpload.LogState.INIT
                r4.updateState(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.log.CoreRtcLogUpload.UploadRunnable.run():void");
        }

        private void deleteFile(String str) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }

        private boolean checkFile(String str) {
            return new File(str).exists();
        }

        private boolean zipFile() {
            String fileFolderPath = FilePathUtils.getFileFolderPath();
            this.zipFileName = FilePathUtils.getZipFileName(String.valueOf(this.userid));
            String str = FilePathUtils.getZipFilePath() + this.zipFileName;
            this.zipFilePath = str;
            try {
                ZipUtils.ZipFolder(fileFolderPath, str);
                return checkFile(this.zipFilePath);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private String toJsonData(long j, String str, String str2, String str3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userid", j);
                jSONObject.put("appid", str);
                jSONObject.put("roomid", str2);
                jSONObject.put("params", "");
                jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, "");
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                jSONObject.put("filenames", new JSONArray(arrayList));
                return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
            } catch (JSONException unused) {
                return null;
            }
        }

        private boolean logAuth() {
            OkHttpClient httpClient = HttpUtils.getHttpClient();
            MediaType parse = MediaType.parse("application/json; charset=utf-8");
            String jsonData = toJsonData(this.userid, this.appid, this.roomid, this.zipFileName);
            if (jsonData.isEmpty()) {
                Log.i(CoreRtcLogUpload.this.TAG, "tmpData isEmpty");
                return false;
            }
            try {
                Response execute = httpClient.newCall(new Request.Builder().url(UrlManager.getInstance().getUrlUploadLog()).get().post(RequestBody.create(parse, jsonData)).build()).execute();
                if (!execute.isSuccessful()) {
                    Log.i(CoreRtcLogUpload.this.TAG, "tmpData:" + jsonData);
                    execute.close();
                    return false;
                }
                String string = execute.body().string();
                execute.close();
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    String string2 = jSONObject.getString("msg");
                    if (!string2.equalsIgnoreCase("Success")) {
                        Log.i(CoreRtcLogUpload.this.TAG, "msg:" + string2);
                        return false;
                    }
                    jSONObject.getString("msg");
                    JSONObject jSONObject2 = jSONObject.getJSONObject(FirebaseAnalytics.Param.CONTENT);
                    jSONObject2.getString(FirebaseAnalytics.Param.METHOD);
                    this.uploadParam.host = jSONObject2.getString("host");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("body");
                    this.uploadParam.ossAccessKeyId = jSONObject3.getString("ossAccessKeyId");
                    this.uploadParam.policy = jSONObject3.getString("policy");
                    this.uploadParam.signature = jSONObject3.getString("signature");
                    this.uploadParam.successActionStatus = jSONObject3.getString("success_action_status");
                    JSONArray jSONArray = jSONObject3.getJSONArray("fileinfo");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                        this.uploadParam.key = jSONObject4.getString("key");
                        this.uploadParam.callback = jSONObject4.getString("callback");
                    }
                    Log.i(CoreRtcLogUpload.this.TAG, "uploadParam.key:" + this.uploadParam.key + " uploadParam.host:" + this.uploadParam.host);
                    this.uploadParam.filePath = this.zipFilePath;
                    this.uploadParam.fileName = this.zipFileName;
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
