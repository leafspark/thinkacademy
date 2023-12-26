package com.bonree.sdk.av;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.amazonaws.services.s3.util.Mimetypes;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.LogReturnInfoBean;
import com.bonree.sdk.agent.business.entity.LogReturnUserInfoRequestBean;
import com.bonree.sdk.agent.business.entity.LogReturnUserInfoResponseBean;
import com.bonree.sdk.agent.business.entity.LogTaskDataBean;
import com.bonree.sdk.agent.business.entity.LogTaskRequestBean;
import com.bonree.sdk.agent.business.entity.LogTaskResponseBean;
import com.bonree.sdk.agent.business.util.k;
import com.bonree.sdk.agent.engine.state.j;
import com.bonree.sdk.agent.engine.state.m;
import com.bonree.sdk.av.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.aa;
import com.bonree.sdk.bs.ac;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static final String a = "LogReturnUploadHandler";
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static int e = 3;
    private static String f = "BR-LogCycle-Thread";
    private static final int l = 30000;
    private Handler g;
    private LogReturnInfoBean h;
    private LogTaskDataBean i;
    /* access modifiers changed from: private */
    public final Map<String, String> j;
    private final f k = com.bonree.sdk.be.a.a();
    private volatile boolean m;
    private final String n = "/sdcard/";
    private final String o = "file/";
    private final String p = "cache/";

    public c() {
        HashMap hashMap = new HashMap();
        this.j = hashMap;
        hashMap.put("Content-Type", Mimetypes.MIMETYPE_OCTET_STREAM);
    }

    public final synchronized void a() {
        if (d.a().a("BR-LogCycle-Thread", this.g) && !this.m) {
            this.m = true;
            this.g.sendEmptyMessage(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Handler handler) {
        try {
            this.g = handler;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("UpLog-handler startWorker error ", th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        LogReturnUserInfoResponseBean logReturnUserInfoResponseBean;
        int i2 = message.what;
        if (i2 == 0) {
            try {
                if (this.h != null) {
                    LogTaskRequestBean logTaskRequestBean = new LogTaskRequestBean();
                    logTaskRequestBean.mDeviceId = com.bonree.sdk.am.f.d();
                    String json = new Gson().toJson((Object) logTaskRequestBean);
                    byte[] bytes = json.getBytes();
                    f fVar = this.k;
                    fVar.c("LogReturnUploadHandler sendLogTask request:" + json, new Object[0]);
                    k.a a2 = k.b().a(bytes, this.h.getGetLogTask(), (String) null, (int) l);
                    if (a2 != null) {
                        String str = new String(a2.a);
                        if (!TextUtils.isEmpty(str)) {
                            f fVar2 = this.k;
                            fVar2.a("LogReturnUploadHandler LogTaskResponse response:" + str, new Object[0]);
                            LogTaskResponseBean logTaskResponseBean = (LogTaskResponseBean) ad.a(str, (Class<?>) LogTaskResponseBean.class);
                            if (logTaskResponseBean == null) {
                                this.k.c("LogReturnUploadHandler sendLogTask responseBean = null", new Object[0]);
                            } else if (!logTaskResponseBean.isSuccess()) {
                                this.k.a(logTaskResponseBean.toString(), new Object[0]);
                            } else {
                                this.i = logTaskResponseBean.data;
                                this.g.sendEmptyMessage(1);
                                return;
                            }
                        } else {
                            this.k.c("LogReturnUploadHandler sendLogTask response = null", new Object[0]);
                        }
                    } else {
                        this.k.c("LogReturnUploadHandler sendLogTask httpResult = null", new Object[0]);
                    }
                } else {
                    this.k.c("LogReturnUploadHandler sendLogTask mLogCycleInfoBean = null", new Object[0]);
                }
            } catch (Exception e2) {
                this.k.a("LogReturnUploadHandlersendLogTask Exception e: %s", (Throwable) e2);
            }
            this.m = false;
        } else if (i2 == 1) {
            try {
                if (this.h != null) {
                    LogTaskDataBean logTaskDataBean = this.i;
                    if (logTaskDataBean != null) {
                        if (logTaskDataBean.netStandard != 2) {
                            if (this.i.netStandard != 1 || !com.bonree.sdk.d.a.Z().equals("WiFi")) {
                                m.g().registerService((j) a.C0008a.a);
                                return;
                            }
                        }
                        e();
                        return;
                    }
                }
                this.m = false;
            } catch (Exception e3) {
                this.k.c("LogReturnUploadHandler realUploadFile: %s", e3);
            }
        } else if (i2 == 2) {
            e();
        } else if (i2 == 3) {
            Object obj = message.obj;
            LogReturnInfoBean logReturnInfoBean = this.h;
            if (logReturnInfoBean == null || ad.a(logReturnInfoBean.getUploadUserInfo())) {
                f fVar3 = this.k;
                fVar3.c("LogReturnUploadHandler mLogCycleInfoBean is " + this.h, new Object[0]);
                return;
            }
            try {
                if (!(obj instanceof LogReturnUserInfoRequestBean)) {
                    this.k.c("LogReturnUploadHandler!(obj instanceof LogCycleUserInfoRequestBean)", new Object[0]);
                    return;
                }
                LogReturnUserInfoRequestBean logReturnUserInfoRequestBean = (LogReturnUserInfoRequestBean) obj;
                String json2 = new Gson().toJson((Object) logReturnUserInfoRequestBean);
                f fVar4 = this.k;
                fVar4.a("LogReturnUploadHandler sendUserInfo requestBeans:" + json2, new Object[0]);
                k.a a3 = k.b().a(json2.getBytes(), this.h.getUploadUserInfo(), (String) null, (int) l);
                if (a3 != null) {
                    String str2 = new String(a3.a);
                    f fVar5 = this.k;
                    fVar5.a("LogReturnUploadHandler sendUserInfo response:" + str2, new Object[0]);
                    if (!ad.a(str2) && (logReturnUserInfoResponseBean = (LogReturnUserInfoResponseBean) ad.a(str2, (Class<?>) LogReturnUserInfoResponseBean.class)) != null && logReturnUserInfoResponseBean.isSuccess()) {
                        a(logReturnUserInfoRequestBean);
                        this.m = false;
                        return;
                    }
                } else {
                    this.k.c("LogReturnUploadHandler sendUserInfo httpResult: null", new Object[0]);
                }
                a(logReturnUserInfoRequestBean, json2, 1);
                this.m = false;
            } catch (Exception e4) {
                f fVar6 = this.k;
                fVar6.e("LogReturnUploadHandler sendUserInfo error:" + e4.toString(), new Object[0]);
            } finally {
                this.m = false;
            }
        }
    }

    private void a(Object obj) {
        LogReturnUserInfoResponseBean logReturnUserInfoResponseBean;
        LogReturnInfoBean logReturnInfoBean = this.h;
        if (logReturnInfoBean == null || ad.a(logReturnInfoBean.getUploadUserInfo())) {
            f fVar = this.k;
            fVar.c("LogReturnUploadHandler mLogCycleInfoBean is " + this.h, new Object[0]);
            return;
        }
        try {
            if (!(obj instanceof LogReturnUserInfoRequestBean)) {
                this.k.c("LogReturnUploadHandler!(obj instanceof LogCycleUserInfoRequestBean)", new Object[0]);
                return;
            }
            LogReturnUserInfoRequestBean logReturnUserInfoRequestBean = (LogReturnUserInfoRequestBean) obj;
            String json = new Gson().toJson((Object) logReturnUserInfoRequestBean);
            f fVar2 = this.k;
            fVar2.a("LogReturnUploadHandler sendUserInfo requestBeans:" + json, new Object[0]);
            k.a a2 = k.b().a(json.getBytes(), this.h.getUploadUserInfo(), (String) null, (int) l);
            if (a2 != null) {
                String str = new String(a2.a);
                f fVar3 = this.k;
                fVar3.a("LogReturnUploadHandler sendUserInfo response:" + str, new Object[0]);
                if (!ad.a(str) && (logReturnUserInfoResponseBean = (LogReturnUserInfoResponseBean) ad.a(str, (Class<?>) LogReturnUserInfoResponseBean.class)) != null && logReturnUserInfoResponseBean.isSuccess()) {
                    a(logReturnUserInfoRequestBean);
                    this.m = false;
                    return;
                }
            } else {
                this.k.c("LogReturnUploadHandler sendUserInfo httpResult: null", new Object[0]);
            }
            a(logReturnUserInfoRequestBean, json, 1);
            this.m = false;
        } catch (Exception e2) {
            f fVar4 = this.k;
            fVar4.e("LogReturnUploadHandler sendUserInfo error:" + e2.toString(), new Object[0]);
        } finally {
            this.m = false;
        }
    }

    private void a(LogReturnUserInfoRequestBean logReturnUserInfoRequestBean, String str, int i2) {
        while (i2 < 5) {
            f fVar = this.k;
            fVar.c("LogReturnUploadHandler retrySend retryCount:" + i2, new Object[0]);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException unused) {
            }
            if (!this.g.hasMessages(3)) {
                f fVar2 = this.k;
                fVar2.a("LogReturnUploadHandler retrySend requestBeans:" + str, new Object[0]);
                k.a a2 = k.b().a(str.getBytes(), this.h.getUploadUserInfo(), (String) null, (int) l);
                if (a2 != null) {
                    String str2 = new String(a2.a);
                    f fVar3 = this.k;
                    fVar3.a("LogReturnUploadHandler retrySend response:" + str2, new Object[0]);
                    if (!ad.a(str2)) {
                        LogReturnUserInfoResponseBean logReturnUserInfoResponseBean = (LogReturnUserInfoResponseBean) ad.a(str2, (Class<?>) LogReturnUserInfoResponseBean.class);
                        if (logReturnUserInfoResponseBean == null) {
                            this.k.a("LogReturnUploadHandler retrySend responseBean is null", new Object[0]);
                        } else if (logReturnUserInfoResponseBean.isSuccess()) {
                            a(logReturnUserInfoRequestBean);
                            return;
                        }
                    } else {
                        this.k.a("LogReturnUploadHandler retrySend response isEmpty", new Object[0]);
                    }
                } else {
                    this.k.a("LogReturnUploadHandler retrySend httpResult is null", new Object[0]);
                }
                i2++;
            } else {
                return;
            }
        }
        f fVar4 = this.k;
        fVar4.c("LogReturnUploadHandler retrySend failed:" + logReturnUserInfoRequestBean.toString(), new Object[0]);
    }

    private static void a(LogReturnUserInfoRequestBean logReturnUserInfoRequestBean) {
        if (!ad.a(logReturnUserInfoRequestBean.userId)) {
            aa.a(com.bonree.sdk.bs.a.a(), "logUserInfo", "logUserId", logReturnUserInfoRequestBean.userId);
        }
        if (!ad.a(logReturnUserInfoRequestBean.extraInfo)) {
            aa.a(com.bonree.sdk.bs.a.a(), "logUserInfo", "logExtraInfo", logReturnUserInfoRequestBean.extraInfo);
        }
        if (!ad.a(logReturnUserInfoRequestBean.appId)) {
            aa.a(com.bonree.sdk.bs.a.a(), "logUserInfo", "logAppId", logReturnUserInfoRequestBean.appId);
        }
        if (!ad.a(logReturnUserInfoRequestBean.deviceId)) {
            aa.a(com.bonree.sdk.bs.a.a(), "logUserInfo", "logDeviceId", logReturnUserInfoRequestBean.deviceId);
        }
    }

    public final void a(LogReturnInfoBean logReturnInfoBean) {
        this.h = logReturnInfoBean;
    }

    public final void a(com.bonree.sdk.agent.engine.state.k kVar) {
        LogTaskDataBean logTaskDataBean;
        if (this.h == null || (logTaskDataBean = this.i) == null || kVar == null) {
            this.m = false;
        } else if (logTaskDataBean.netStandard == 2 || (this.i.netStandard == 1 && kVar.b().equals("WiFi"))) {
            this.g.sendEmptyMessage(2);
        }
    }

    private void c() {
        try {
            if (this.h != null) {
                LogTaskRequestBean logTaskRequestBean = new LogTaskRequestBean();
                logTaskRequestBean.mDeviceId = com.bonree.sdk.am.f.d();
                String json = new Gson().toJson((Object) logTaskRequestBean);
                byte[] bytes = json.getBytes();
                f fVar = this.k;
                fVar.c("LogReturnUploadHandler sendLogTask request:" + json, new Object[0]);
                k.a a2 = k.b().a(bytes, this.h.getGetLogTask(), (String) null, (int) l);
                if (a2 != null) {
                    String str = new String(a2.a);
                    if (!TextUtils.isEmpty(str)) {
                        f fVar2 = this.k;
                        fVar2.a("LogReturnUploadHandler LogTaskResponse response:" + str, new Object[0]);
                        LogTaskResponseBean logTaskResponseBean = (LogTaskResponseBean) ad.a(str, (Class<?>) LogTaskResponseBean.class);
                        if (logTaskResponseBean == null) {
                            this.k.c("LogReturnUploadHandler sendLogTask responseBean = null", new Object[0]);
                        } else if (!logTaskResponseBean.isSuccess()) {
                            this.k.a(logTaskResponseBean.toString(), new Object[0]);
                        } else {
                            this.i = logTaskResponseBean.data;
                            this.g.sendEmptyMessage(1);
                            return;
                        }
                    } else {
                        this.k.c("LogReturnUploadHandler sendLogTask response = null", new Object[0]);
                    }
                } else {
                    this.k.c("LogReturnUploadHandler sendLogTask httpResult = null", new Object[0]);
                }
            } else {
                this.k.c("LogReturnUploadHandler sendLogTask mLogCycleInfoBean = null", new Object[0]);
            }
        } catch (Exception e2) {
            this.k.a("LogReturnUploadHandlersendLogTask Exception e: %s", (Throwable) e2);
        }
        this.m = false;
    }

    private void d() {
        try {
            if (this.h != null) {
                LogTaskDataBean logTaskDataBean = this.i;
                if (logTaskDataBean != null) {
                    if (logTaskDataBean.netStandard != 2) {
                        if (this.i.netStandard != 1 || !com.bonree.sdk.d.a.Z().equals("WiFi")) {
                            m.g().registerService((j) a.C0008a.a);
                            return;
                        }
                    }
                    e();
                    return;
                }
            }
            this.m = false;
        } catch (Exception e2) {
            this.k.c("LogReturnUploadHandler realUploadFile: %s", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e A[SYNTHETIC, Splitter:B:35:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012c A[SYNTHETIC, Splitter:B:45:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String f() {
        /*
            r9 = this;
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)
            r1 = 0
            java.lang.String r2 = ""
            if (r0 != 0) goto L_0x013c
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            java.lang.String r3 = "/sdcard/"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x0037
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = com.bonree.sdk.bs.ad.b()
            r2.append(r4)
            java.lang.String r4 = java.io.File.separator
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.replace(r3, r2)
            goto L_0x009a
        L_0x0037:
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            java.lang.String r3 = "file/"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x0069
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r4 = com.bonree.sdk.bs.a.a()
            java.io.File r4 = r4.getFilesDir()
            java.lang.String r4 = r4.getAbsolutePath()
            r2.append(r4)
            java.lang.String r4 = java.io.File.separator
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.replace(r3, r2)
            goto L_0x009a
        L_0x0069:
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            java.lang.String r3 = "cache/"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x0130
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r0 = r9.i
            java.lang.String r0 = r0.filePath
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r4 = com.bonree.sdk.bs.a.a()
            java.io.File r4 = r4.getCacheDir()
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            java.lang.String r4 = java.io.File.separator
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.replace(r3, r2)
        L_0x009a:
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            boolean r4 = r3.isDirectory()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            if (r4 != 0) goto L_0x00ee
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            com.bonree.sdk.be.f r5 = r9.k     // Catch:{ Exception -> 0x00ec }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec }
            java.lang.String r7 = "LogReturnUploadHandler realUploadFile fileByte.length:"
            r6.<init>(r7)     // Catch:{ Exception -> 0x00ec }
            long r7 = r3.length()     // Catch:{ Exception -> 0x00ec }
            r6.append(r7)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r7 = "  fileSize:"
            r6.append(r7)     // Catch:{ Exception -> 0x00ec }
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r7 = r9.i     // Catch:{ Exception -> 0x00ec }
            int r7 = r7.fileSize     // Catch:{ Exception -> 0x00ec }
            r6.append(r7)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00ec }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00ec }
            r5.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x00ec }
            long r5 = r3.length()     // Catch:{ Exception -> 0x00ec }
            com.bonree.sdk.agent.business.entity.LogTaskDataBean r3 = r9.i     // Catch:{ Exception -> 0x00ec }
            int r3 = r3.fileSize     // Catch:{ Exception -> 0x00ec }
            int r3 = r3 << 10
            long r7 = (long) r3     // Catch:{ Exception -> 0x00ec }
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ea
            com.bonree.sdk.be.f r3 = r9.k     // Catch:{ Exception -> 0x00ec }
            java.lang.String r5 = "LogReturnUploadHandler log file over with file limit "
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00ec }
            r3.c(r5, r6)     // Catch:{ Exception -> 0x00ec }
            r3 = r1
            goto L_0x00f9
        L_0x00ea:
            r3 = 1
            goto L_0x00f9
        L_0x00ec:
            r3 = move-exception
            goto L_0x0103
        L_0x00ee:
            com.bonree.sdk.be.f r3 = r9.k     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            java.lang.String r4 = "LogReturnUploadHandler log file is directory"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            r3.c(r4, r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            r3 = r1
            r4 = r2
        L_0x00f9:
            if (r4 == 0) goto L_0x0122
            r4.close()     // Catch:{ IOException -> 0x0122 }
            goto L_0x0122
        L_0x00ff:
            r0 = move-exception
            goto L_0x012a
        L_0x0101:
            r3 = move-exception
            r4 = r2
        L_0x0103:
            com.bonree.sdk.be.f r5 = r9.k     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            java.lang.String r7 = "LogReturnUploadHandler check log file error:"
            r6.<init>(r7)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0128 }
            r6.append(r3)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0128 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0128 }
            r5.e(r3, r6)     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x0121
            r4.close()     // Catch:{ IOException -> 0x0121 }
        L_0x0121:
            r3 = r1
        L_0x0122:
            if (r3 != 0) goto L_0x0127
            r9.m = r1
            r0 = r2
        L_0x0127:
            return r0
        L_0x0128:
            r0 = move-exception
            r2 = r4
        L_0x012a:
            if (r2 == 0) goto L_0x012f
            r2.close()     // Catch:{ IOException -> 0x012f }
        L_0x012f:
            throw r0
        L_0x0130:
            com.bonree.sdk.be.f r0 = r9.k
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r4 = "LogReturnUploadHandler log return file path error!"
            r0.c(r4, r3)
            r9.m = r1
            return r2
        L_0x013c:
            r9.m = r1
            com.bonree.sdk.be.f r0 = r9.k
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "LogReturnUploadHandler log return file isEmpty!"
            r0.c(r3, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.av.c.f():java.lang.String");
    }

    private void a(String str, String str2, Map<String, String> map) {
        f fVar = this.k;
        fVar.a("LogReturnUploadHandler loadFileAndSend start time:" + ad.c(), new Object[0]);
        k.a a2 = k.b().a(true, str, str2, (String) null, 60000, map);
        if (a2 != null) {
            String str3 = new String(a2.a);
            f fVar2 = this.k;
            fVar2.c("LogReturnUploadHandler LogReturn Result:" + str3, new Object[0]);
        } else {
            this.k.c("LogReturnUploadHandler sendUploadFile httpResult = null", new Object[0]);
        }
        f fVar3 = this.k;
        fVar3.a("LogReturnUploadHandler loadFileAndSend end time:" + ad.c(), new Object[0]);
        this.m = false;
    }

    private byte[] a(String str) {
        File file = new File(str);
        try {
            f fVar = this.k;
            fVar.a("LogReturnUploadHandler realUploadFile fileByte.length:" + file.length() + "  fileSize:" + this.i.fileSize, new Object[0]);
            if (file.length() > ((long) (this.i.fileSize << 10))) {
                this.k.a("LogReturnUploadHandler log file over with file limit ", new Object[0]);
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(PictureFileUtils.KB);
            byte[] bArr = new byte[PictureFileUtils.KB];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e2) {
            f fVar2 = this.k;
            fVar2.c("LogReturnUploadHandlergetBytesByFile:" + e2.toString(), new Object[0]);
            return null;
        }
    }

    public static c b() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final c a = new c();

        private a() {
        }
    }

    private void e() {
        m.g().unRegisterService(a.C0008a.a);
        String str = this.h.getUploadLogFile() + "?di=" + com.bonree.sdk.am.f.d();
        this.k.c("LogReturnUploadHandler uploadFile:" + str, new Object[0]);
        String f2 = f();
        if (!ad.a(f2)) {
            ac.a(new d(this, str, f2));
        }
    }

    static /* synthetic */ void a(c cVar, String str, String str2, Map map) {
        f fVar = cVar.k;
        fVar.a("LogReturnUploadHandler loadFileAndSend start time:" + ad.c(), new Object[0]);
        k.a a2 = k.b().a(true, str, str2, (String) null, 60000, (Map<String, String>) map);
        if (a2 != null) {
            String str3 = new String(a2.a);
            f fVar2 = cVar.k;
            fVar2.c("LogReturnUploadHandler LogReturn Result:" + str3, new Object[0]);
        } else {
            cVar.k.c("LogReturnUploadHandler sendUploadFile httpResult = null", new Object[0]);
        }
        f fVar3 = cVar.k;
        fVar3.a("LogReturnUploadHandler loadFileAndSend end time:" + ad.c(), new Object[0]);
        cVar.m = false;
    }
}
