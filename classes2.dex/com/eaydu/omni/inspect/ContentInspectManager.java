package com.eaydu.omni.inspect;

import android.text.TextUtils;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.eaydu.omni.BaseRtcEngine;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.net.okhttp3.Call;
import com.eaydu.omni.net.okhttp3.Callback;
import com.eaydu.omni.net.okhttp3.MediaType;
import com.eaydu.omni.net.okhttp3.MultipartBody;
import com.eaydu.omni.net.okhttp3.OkHttpClient;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.RequestBody;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.net.okio.Buffer;
import com.eaydu.omni.net.okio.BufferedSink;
import com.eaydu.omni.net.okio.Okio;
import com.eaydu.omni.net.okio.Source;
import com.eaydu.omni.urls.UrlManager;
import com.eaydu.omni.utils.HttpUtils;
import com.eaydu.omni.utils.TimerUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentInspectManager implements TimerUtil.TimerObserver, RTCEngine.ContentInspectListener {
    private static final int CACHE_AUTH_FILE_COUNT = 5;
    /* access modifiers changed from: private */
    public static final String TAG = "ContentInspectManager";
    private String arguments;
    private byte[] bucketBuffer;
    /* access modifiers changed from: private */
    public ArrayBlockingQueue<ImageObject> cachedFileNames;
    /* access modifiers changed from: private */
    public boolean hasStop;
    private Runnable imageHandleTask;
    private final ThreadPoolExecutor imageHandleThreadPool;
    private String mAppId;
    private BaseRtcEngine mBaseRtcEngine;
    private String mRoomId;
    private Long mUserId;
    private OkHttpClient mhttpClient;
    private int rateAI;
    private int ratePorn;
    private long timeIntervalMill;
    private TimerUtil timerUtil;

    private ContentInspectManager() {
        this.mhttpClient = HttpUtils.getHttpClient();
        this.cachedFileNames = new ArrayBlockingQueue<>(5);
        this.hasStop = false;
        this.imageHandleThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        this.bucketBuffer = null;
        this.arguments = "";
        createTimerUtil();
    }

    private void createTimerUtil() {
        this.timerUtil = new TimerUtil(this);
    }

    public int stop() {
        destroy();
        this.hasStop = true;
        return 0;
    }

    public void setRatePorn(int i) {
        this.ratePorn = i;
    }

    public void setRateAI(int i) {
        this.rateAI = i;
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ContentInspectManager INSTANCE = new ContentInspectManager();

        private InstanceHolder() {
        }
    }

    public class ImageObject {
        public String mCallback;
        public String mHost;
        public String mKey;
        public String mOSSAccessKeyId;
        public String mPolicy;
        public String mSignature;
        public String mSuccess_action_status;

        public ImageObject() {
        }
    }

    public static ContentInspectManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public synchronized int start(int i, BaseRtcEngine baseRtcEngine, String str, String str2, Long l) {
        String str3 = TAG;
        Log.d(str3, "start.");
        Logger.i(str3 + " start appid： " + str + " roomId： " + str2 + " userId： " + l, new Object[0]);
        this.timeIntervalMill = (long) (i * ResultCode.KARAOKE_SUCCESS);
        this.mBaseRtcEngine = baseRtcEngine;
        baseRtcEngine.setContentInspectListener(this);
        this.mAppId = str;
        this.mRoomId = str2;
        this.mUserId = l;
        this.hasStop = false;
        try {
            if (this.timerUtil == null) {
                createTimerUtil();
            }
            this.timerUtil.delayAddLoop(this.timeIntervalMill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.cachedFileNames.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public void setArguments(String str) {
        Logger.i(TAG + " setArguments arguments： " + str, new Object[0]);
        this.arguments = str;
    }

    public void onTimeUpdate(long j) {
        BaseRtcEngine baseRtcEngine;
        try {
            if (!this.hasStop && (baseRtcEngine = this.mBaseRtcEngine) != null) {
                baseRtcEngine.takePreEncodeSnapshot();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTakePreEncodeSnapshot(final byte[] bArr) {
        try {
            if (!this.hasStop) {
                AnonymousClass1 r0 = new Runnable() {
                    public void run() {
                        try {
                            if (!ContentInspectManager.this.hasStop) {
                                ContentInspectManager.this.handleTakeSnapshotInter(bArr);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                this.imageHandleTask = r0;
                this.imageHandleThreadPool.execute(r0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleTakeSnapshotInter(byte[] bArr) {
        try {
            if (this.cachedFileNames.isEmpty()) {
                requestEncode(bArr);
            } else {
                ImageObject poll = this.cachedFileNames.poll();
                if (poll != null) {
                    upLoadOss(bArr, poll);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void onTakePreEncodeSnapshot(String str, int i, final String str2, int i2, int i3, int i4) {
        try {
            if (!this.hasStop) {
                AnonymousClass2 r1 = new Runnable() {
                    public void run() {
                        try {
                            if (!ContentInspectManager.this.hasStop) {
                                byte[] access$400 = ContentInspectManager.this.getBytesFromFile(str2);
                                if (!ContentInspectManager.this.hasStop) {
                                    ContentInspectManager.this.handleTakeSnapshotInter(access$400);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                this.imageHandleTask = r1;
                this.imageHandleThreadPool.execute(r1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0052 A[SYNTHETIC, Splitter:B:38:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0068 A[SYNTHETIC, Splitter:B:53:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] getBytesFromFile(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0071 }
            r0.<init>()     // Catch:{ all -> 0x0071 }
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            byte[] r6 = r5.bucketBuffer     // Catch:{ IOException -> 0x003f }
            if (r6 != 0) goto L_0x0016
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x003f }
            r5.bucketBuffer = r6     // Catch:{ IOException -> 0x003f }
        L_0x0016:
            byte[] r6 = r5.bucketBuffer     // Catch:{ IOException -> 0x003f }
            int r6 = r2.read(r6)     // Catch:{ IOException -> 0x003f }
            r3 = -1
            if (r6 == r3) goto L_0x0026
            byte[] r3 = r5.bucketBuffer     // Catch:{ IOException -> 0x003f }
            r4 = 0
            r0.write(r3, r4, r6)     // Catch:{ IOException -> 0x003f }
            goto L_0x0016
        L_0x0026:
            r0.flush()     // Catch:{ IOException -> 0x003f }
            byte[] r6 = r0.toByteArray()     // Catch:{ IOException -> 0x003f }
            r0.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0071 }
        L_0x0035:
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0071 }
        L_0x003d:
            monitor-exit(r5)
            return r6
        L_0x003f:
            r6 = move-exception
            goto L_0x0045
        L_0x0041:
            r6 = move-exception
            goto L_0x005e
        L_0x0043:
            r6 = move-exception
            r2 = r1
        L_0x0045:
            r6.printStackTrace()     // Catch:{ all -> 0x005c }
            r0.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0071 }
        L_0x0050:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0071 }
        L_0x005a:
            monitor-exit(r5)
            return r1
        L_0x005c:
            r6 = move-exception
            r1 = r2
        L_0x005e:
            r0.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0071 }
        L_0x0066:
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0071 }
        L_0x0070:
            throw r6     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.inspect.ContentInspectManager.getBytesFromFile(java.lang.String):byte[]");
    }

    public void destroy() {
        ThreadPoolExecutor threadPoolExecutor;
        String str = TAG;
        Log.d(str, "destroy.");
        Logger.i(str + " destroy.", new Object[0]);
        this.hasStop = true;
        try {
            TimerUtil timerUtil2 = this.timerUtil;
            if (timerUtil2 != null) {
                timerUtil2.release();
                this.timerUtil = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
            if (baseRtcEngine != null) {
                baseRtcEngine.setContentInspectListener((RTCEngine.ContentInspectListener) null);
                this.mBaseRtcEngine = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            ArrayBlockingQueue<ImageObject> arrayBlockingQueue = this.cachedFileNames;
            if (arrayBlockingQueue != null) {
                arrayBlockingQueue.clear();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            Runnable runnable = this.imageHandleTask;
            if (runnable != null && (threadPoolExecutor = this.imageHandleThreadPool) != null) {
                threadPoolExecutor.remove(runnable);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void requestEncode(final byte[] bArr) {
        if (!this.hasStop && bArr != null && !TextUtils.isEmpty(this.arguments)) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("userid", this.mUserId);
                jSONObject.put("appid", this.mAppId);
                jSONObject.put("roomid", this.mRoomId);
                jSONObject.put("params", this.arguments);
                jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, Constants.ScionAnalytics.PARAM_LABEL);
                long currentTimeMillis = System.currentTimeMillis() - this.timeIntervalMill;
                for (int i = 0; i < 5; i++) {
                    currentTimeMillis += this.timeIntervalMill;
                    jSONArray.put((this.mAppId + "_" + 0 + "_uid_s" + this.mUserId + "_uid_e_video_" + currentTimeMillis) + PictureMimeType.JPG);
                }
                jSONObject.put("filenames", jSONArray);
                jSONObject.put("client", "4.1");
                jSONObject.put("rates", this.ratePorn + "|" + this.rateAI);
                MediaType parse = MediaType.parse("application/json; charset=utf-8");
                Log.e("requestEncode", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                this.mhttpClient.newCall(new Request.Builder().url(UrlManager.getInstance().getUrlInspect()).post(RequestBody.create(parse, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject))).build()).enqueue(new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        Logger.i(ContentInspectManager.TAG + "requestEncode onFailure e: " + iOException, new Object[0]);
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        String access$500 = ContentInspectManager.TAG;
                        Log.d(access$500, "requestEncode onResponse responseStr: " + string);
                        if (!ContentInspectManager.this.hasStop) {
                            try {
                                JSONObject jSONObject = new JSONObject(string);
                                if (jSONObject.has("code") && Integer.parseInt(jSONObject.getString("code")) == 0 && jSONObject.has(FirebaseAnalytics.Param.CONTENT)) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject(FirebaseAnalytics.Param.CONTENT);
                                    if (jSONObject2.has("body")) {
                                        JSONObject jSONObject3 = jSONObject2.getJSONObject("body");
                                        String string2 = jSONObject3.getString("ossAccessKeyId");
                                        String string3 = jSONObject3.getString("host");
                                        String string4 = jSONObject3.getString("policy");
                                        String string5 = jSONObject3.getString("signature");
                                        String string6 = jSONObject3.getString("success_action_status");
                                        if (jSONObject3.has("fileinfo")) {
                                            JSONArray jSONArray = jSONObject3.getJSONArray("fileinfo");
                                            for (int i = 0; i < jSONArray.length(); i++) {
                                                JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                                                String string7 = jSONObject4.getString("key");
                                                String string8 = jSONObject4.getString("callback");
                                                ImageObject imageObject = new ImageObject();
                                                imageObject.mHost = string3;
                                                imageObject.mOSSAccessKeyId = string2;
                                                imageObject.mPolicy = string4;
                                                imageObject.mSignature = string5;
                                                imageObject.mSuccess_action_status = string6;
                                                imageObject.mKey = string7;
                                                imageObject.mCallback = string8;
                                                ContentInspectManager.this.cachedFileNames.offer(imageObject);
                                            }
                                            ImageObject imageObject2 = (ImageObject) ContentInspectManager.this.cachedFileNames.poll();
                                            if (imageObject2 != null) {
                                                ContentInspectManager.this.upLoadOss(bArr, imageObject2);
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void upLoadOss(byte[] bArr, ImageObject imageObject) {
        if (!this.hasStop) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userid", this.mUserId);
                jSONObject.put("appid", this.mAppId);
                jSONObject.put("roomid", this.mRoomId);
                MultipartBody build = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("OSSAccessKeyId", imageObject.mOSSAccessKeyId).addFormDataPart("policy", imageObject.mPolicy).addFormDataPart("Signature", imageObject.mSignature).addFormDataPart("success_action_status", imageObject.mSuccess_action_status).addFormDataPart("key", imageObject.mKey).addFormDataPart("callback", imageObject.mCallback).addFormDataPart("file", "rtc.jpg", createProgressRequestBody(MediaType.parse("image/jpeg"), (File) null, bArr)).build();
                String str = imageObject.mHost;
                if (str != null && !str.startsWith("http")) {
                    str = "https://" + imageObject.mHost;
                }
                this.mhttpClient.newCall(new Request.Builder().url(str).post(build).build()).enqueue(new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        Logger.i(ContentInspectManager.TAG + "upLoadOss onFailure e: " + iOException, new Object[0]);
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        String access$500 = ContentInspectManager.TAG;
                        Log.d(access$500, "upLoadOss onResponse responseStr： " + string);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public RequestBody createProgressRequestBody(final MediaType mediaType, final File file, final byte[] bArr) {
        return new RequestBody() {
            public MediaType contentType() {
                return mediaType;
            }

            public long contentLength() {
                byte[] bArr = bArr;
                if (bArr != null) {
                    return (long) bArr.length;
                }
                return file.length();
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                try {
                    if (bArr != null) {
                        Source source = Okio.source((InputStream) new ByteArrayInputStream(bArr));
                        Buffer buffer = new Buffer();
                        contentLength();
                        while (true) {
                            long read = source.read(buffer, 2048);
                            if (read != -1) {
                                bufferedSink.write(buffer, read);
                            } else {
                                return;
                            }
                        }
                    } else {
                        Source source2 = Okio.source(file);
                        Buffer buffer2 = new Buffer();
                        contentLength();
                        while (true) {
                            long read2 = source2.read(buffer2, 2048);
                            if (read2 != -1) {
                                bufferedSink.write(buffer2, read2);
                            } else {
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
