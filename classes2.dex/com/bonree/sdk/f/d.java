package com.bonree.sdk.f;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.CrashEventInfoBean;
import com.bonree.sdk.agent.business.entity.DeviceStateInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean;
import com.bonree.sdk.agent.business.entity.UserInfoBean;
import com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo;
import com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean;
import com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean;
import com.bonree.sdk.agent.business.util.g;
import com.bonree.sdk.al.b;
import com.bonree.sdk.ax.c;
import com.bonree.sdk.bb.k;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.c.a;
import com.bonree.sdk.common.json.JSONArray;
import com.bonree.sdk.common.json.JSONException;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.d.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {
    final f a;
    final e b;
    final g c;
    a d;
    private h e;
    private final AtomicBoolean f;
    private String g;
    private final f h;

    private static String c(int i) {
        return i != 2 ? i != 3 ? i != 5 ? i != 6 ? i != 7 ? "UP ??" : "UP NA CRASH" : "UP EXIT" : "UP CRASH" : "UP TIMER" : "UP BACKGROUND";
    }

    public d(e eVar, a aVar) {
        this.f = new AtomicBoolean(false);
        this.g = "BR-UploadStorage-Thread";
        this.h = new f((UploadDataResponseBean) null, true);
        this.a = com.bonree.sdk.be.a.a();
        this.b = eVar;
        this.d = aVar;
        this.c = new g(eVar.c().getFilesDir().getAbsolutePath() + "/up/");
    }

    public final synchronized void a(boolean z) {
        try {
            if (this.e == null) {
                HandlerThread handlerThread = new HandlerThread(this.g);
                handlerThread.start();
                this.e = new h(this, handlerThread.getLooper());
            }
            if (!this.e.hasMessages(z ? h.b : h.a) && !this.e.c && this.e.a()) {
                this.e.sendEmptyMessage(z ? h.b : h.a);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(UploadDataResponseBean uploadDataResponseBean) {
        if (uploadDataResponseBean != null) {
            try {
                int responseCode = uploadDataResponseBean.getResponseCode();
                boolean z = (responseCode >= 0 && responseCode <= 10000) || responseCode == 20105;
                if (z) {
                    f fVar = com.bonree.sdk.d.a.a;
                    fVar.a("UR OK " + responseCode);
                    this.a.c("upload success , response code:%d", Integer.valueOf(responseCode));
                    com.bonree.sdk.bs.a.a();
                    ad.f("数据上传成功:" + responseCode + "\nappkey为:" + com.bonree.sdk.d.a.k().v() + "\nconfig地址为:" + com.bonree.sdk.d.a.k().M() + "\nupload地址为:" + com.bonree.sdk.d.a.k().N());
                } else {
                    f fVar2 = com.bonree.sdk.d.a.a;
                    fVar2.a("No need to trace from Upload " + responseCode);
                    f fVar3 = this.a;
                    fVar3.d("No need to trace from Upload " + responseCode, new Object[0]);
                    com.bonree.sdk.bs.a.a();
                    ad.f("数据返回采集数据开关为false: " + responseCode + "\nappkey为:" + com.bonree.sdk.d.a.k().v() + "\nconfig地址为:" + com.bonree.sdk.d.a.k().M() + "\nupload地址为:" + com.bonree.sdk.d.a.k().N());
                }
                return z;
            } catch (Throwable unused) {
            }
        } else {
            com.bonree.sdk.d.a.a.a("UP Rsp NULL!");
            this.a.c("upload resp is null: ", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0073=Splitter:B:34:0x0073, B:38:0x0079=Splitter:B:38:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean a(int r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = c((int) r5)     // Catch:{ all -> 0x0084 }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x0084 }
            com.bonree.sdk.be.f r0 = r4.a     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = c((int) r5)     // Catch:{ all -> 0x0084 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0084 }
            r0.c(r1, r3)     // Catch:{ all -> 0x0084 }
            boolean r0 = com.bonree.sdk.d.e.v()     // Catch:{ all -> 0x0084 }
            r1 = 0
            if (r0 == 0) goto L_0x0028
            com.bonree.sdk.be.f r5 = r4.a     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = "Agent has been stopped and cannot be uploaded!!!! "
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0084 }
            r5.d(r0, r2)     // Catch:{ all -> 0x0084 }
            monitor-exit(r4)
            return r1
        L_0x0028:
            com.bonree.sdk.c.a r0 = r4.d     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0079
            com.bonree.sdk.c.b r0 = r0.c()     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0079
            com.bonree.sdk.c.a r0 = r4.d     // Catch:{ all -> 0x0084 }
            com.bonree.sdk.c.b r0 = r0.c()     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0084 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0043
            goto L_0x0079
        L_0x0043:
            r0 = 3
            if (r5 == r0) goto L_0x0049
            r0 = 2
            if (r5 != r0) goto L_0x0063
        L_0x0049:
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f     // Catch:{ all -> 0x0084 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0063
            com.bonree.sdk.be.f r5 = r4.a     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = "upload is running , return !"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0084 }
            r5.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0084 }
            com.bonree.sdk.be.f r5 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = "UP RUNNING"
            r5.a((java.lang.String) r0)     // Catch:{ all -> 0x0084 }
            monitor-exit(r4)
            return r1
        L_0x0063:
            r0 = 6
            if (r5 == r0) goto L_0x0073
            r0 = 5
            if (r5 == r0) goto L_0x0073
            r0 = 7
            if (r5 != r0) goto L_0x006d
            goto L_0x0073
        L_0x006d:
            com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean r5 = r4.d(r5)     // Catch:{ all -> 0x0084 }
            monitor-exit(r4)
            return r5
        L_0x0073:
            com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean r5 = r4.b((int) r5)     // Catch:{ all -> 0x0084 }
            monitor-exit(r4)
            return r5
        L_0x0079:
            com.bonree.sdk.be.f r5 = r4.a     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = "upload state is waring ! No config occurred !"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0084 }
            r5.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0084 }
            monitor-exit(r4)
            return r1
        L_0x0084:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.d.a(int):com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(2:4|(3:6|7|(12:9|(1:11)|12|(1:14)|15|(3:19|(1:21)(1:22)|23)|24|(1:28)|29|(1:33)|34|(1:36)(1:37))))(1:38)|39|40|(2:42|(1:44)(6:45|(1:47)(1:48)|49|(1:51)(1:52)|53|58))|54|55) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0152 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015c A[Catch:{ all -> 0x01be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean b(int r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.f     // Catch:{ all -> 0x01be }
            r3 = 1
            r2.getAndSet(r3)     // Catch:{ all -> 0x01be }
            r2 = 7
            if (r10 != r2) goto L_0x0151
            com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean r10 = r9.c((boolean) r1)     // Catch:{ all -> 0x01be }
            if (r10 == 0) goto L_0x0152
            com.bonree.sdk.d.e r2 = r9.b     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.af.a r2 = r2.f()     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.EventBean r2 = r2.g()     // Catch:{ all -> 0x0152 }
            if (r2 == 0) goto L_0x0152
            com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean r4 = new com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean     // Catch:{ all -> 0x0152 }
            r4.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r10.getSession()     // Catch:{ all -> 0x0152 }
            r4.mSession = r5     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = com.bonree.sdk.d.a.c     // Catch:{ all -> 0x0152 }
            r4.mProcessIdentifier = r5     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = com.bonree.sdk.agent.business.util.g.a()     // Catch:{ all -> 0x0152 }
            r4.mProcessName = r5     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r4.mProcessName     // Catch:{ all -> 0x0152 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x0044
            android.content.Context r5 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = com.bonree.sdk.agent.business.util.g.a((android.content.Context) r5)     // Catch:{ all -> 0x0152 }
            r4.mProcessName = r5     // Catch:{ all -> 0x0152 }
        L_0x0044:
            java.lang.String r5 = r4.mProcessName     // Catch:{ all -> 0x0152 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x005f
            com.bonree.sdk.be.f r5 = r9.a     // Catch:{ all -> 0x0152 }
            java.lang.String r6 = "Upload get ProcessName failed!"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x0152 }
            r5.c(r6, r7)     // Catch:{ all -> 0x0152 }
            android.content.Context r5 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = com.bonree.sdk.bs.a.c(r5)     // Catch:{ all -> 0x0152 }
            r4.mProcessName = r5     // Catch:{ all -> 0x0152 }
        L_0x005f:
            com.bonree.sdk.d.a r5 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.AppStateInfoBean r5 = r5.i()     // Catch:{ all -> 0x0152 }
            r4.mAppStateInfo = r5     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r10.getAgentVersion()     // Catch:{ all -> 0x0152 }
            r4.mVersion = r5     // Catch:{ all -> 0x0152 }
            long r5 = r10.getMonitorTime()     // Catch:{ all -> 0x0152 }
            long r5 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x0152 }
            r4.mMonitorTime = r5     // Catch:{ all -> 0x0152 }
            long r5 = r10.getConfigMonitorTime()     // Catch:{ all -> 0x0152 }
            r4.mConfigMonitorTime = r5     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.AppInfoBean r5 = r10.getAppInfo()     // Catch:{ all -> 0x0152 }
            r4.mAppInfo = r5     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.DeviceInfoBean r5 = r10.getDeviceInfo()     // Catch:{ all -> 0x0152 }
            r4.mDeviceInfo = r5     // Catch:{ all -> 0x0152 }
            long r5 = com.bonree.sdk.d.a.e()     // Catch:{ all -> 0x0152 }
            r4.mUnitSessionDuration = r5     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r10.getTrackID()     // Catch:{ all -> 0x0152 }
            r4.mTrackID = r5     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.DataFusionInfo r5 = r10.getDataFusionInfo()     // Catch:{ all -> 0x0152 }
            r4.mDataFusionInfo = r5     // Catch:{ all -> 0x0152 }
            java.util.Map r5 = r10.getUserInfoBean()     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x00cd
            java.lang.String[] r6 = r2.mStateIndex     // Catch:{ all -> 0x0152 }
            r6 = r6[r1]     // Catch:{ all -> 0x0152 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.UserInfoBean r5 = (com.bonree.sdk.agent.business.entity.UserInfoBean) r5     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x00cd
            java.lang.String r7 = r10.getFirstUserInfo()     // Catch:{ all -> 0x0152 }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x0152 }
            if (r7 == 0) goto L_0x00be
            java.lang.String r7 = r10.getFirstUserInfo()     // Catch:{ all -> 0x0152 }
            goto L_0x00bf
        L_0x00be:
            r7 = r0
        L_0x00bf:
            r4.mFirstUserInfo = r7     // Catch:{ all -> 0x0152 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0152 }
            r7.<init>(r3)     // Catch:{ all -> 0x0152 }
            r4.mUserInfoBean = r7     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.UserInfoBean> r7 = r4.mUserInfoBean     // Catch:{ all -> 0x0152 }
            r7.put(r6, r5)     // Catch:{ all -> 0x0152 }
        L_0x00cd:
            java.util.Map r5 = r10.getDeviceStateInfo()     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x00eb
            java.lang.String[] r6 = r2.mStateIndex     // Catch:{ all -> 0x0152 }
            r6 = r6[r3]     // Catch:{ all -> 0x0152 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.DeviceStateInfoBean r5 = (com.bonree.sdk.agent.business.entity.DeviceStateInfoBean) r5     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x00eb
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0152 }
            r7.<init>(r3)     // Catch:{ all -> 0x0152 }
            r4.mDeviceStateInfo = r7     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.DeviceStateInfoBean> r7 = r4.mDeviceStateInfo     // Catch:{ all -> 0x0152 }
            r7.put(r6, r5)     // Catch:{ all -> 0x0152 }
        L_0x00eb:
            java.util.Map r5 = r10.getNetWorkStateInfo()     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x010a
            java.lang.String[] r6 = r2.mStateIndex     // Catch:{ all -> 0x0152 }
            r7 = 2
            r6 = r6[r7]     // Catch:{ all -> 0x0152 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean r5 = (com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean) r5     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x010a
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0152 }
            r7.<init>(r3)     // Catch:{ all -> 0x0152 }
            r4.mNetWorkStateInfo = r7     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean> r7 = r4.mNetWorkStateInfo     // Catch:{ all -> 0x0152 }
            r7.put(r6, r5)     // Catch:{ all -> 0x0152 }
        L_0x010a:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0152 }
            r5.<init>()     // Catch:{ all -> 0x0152 }
            r4.mEvents = r5     // Catch:{ all -> 0x0152 }
            java.util.List<com.bonree.sdk.agent.business.entity.EventBean> r5 = r4.mEvents     // Catch:{ all -> 0x0152 }
            r5.add(r2)     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.c.a r2 = r9.d     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.agent.business.util.i r2 = r2.e()     // Catch:{ all -> 0x0152 }
            byte[] r2 = r2.a((com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r4)     // Catch:{ all -> 0x0152 }
            if (r2 != 0) goto L_0x0123
            goto L_0x0152
        L_0x0123:
            com.bonree.sdk.f.c r5 = new com.bonree.sdk.f.c     // Catch:{ all -> 0x0152 }
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0152 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0152 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r7.<init>()     // Catch:{ all -> 0x0152 }
            com.bonree.sdk.d.a r8 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x0152 }
            java.lang.String r8 = r8.j()     // Catch:{ all -> 0x0152 }
            r7.append(r8)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = c((com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r4)     // Catch:{ all -> 0x0152 }
            r7.append(r4)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0152 }
            r5.<init>(r6, r2, r4)     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = "brnc"
            r9.a((com.bonree.sdk.f.c) r5, (java.lang.String) r2)     // Catch:{ all -> 0x0152 }
            goto L_0x0152
        L_0x0151:
            r10 = r0
        L_0x0152:
            com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean r10 = r9.a((boolean) r3, (com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r10)     // Catch:{ all -> 0x01be }
            byte[] r2 = r9.b((com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r10)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x01b8
            int r3 = r2.length     // Catch:{ all -> 0x01be }
            r4 = 4
            if (r3 > r4) goto L_0x0161
            goto L_0x01b8
        L_0x0161:
            com.bonree.sdk.f.c r3 = new com.bonree.sdk.f.c     // Catch:{ all -> 0x01be }
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01be }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01be }
            r5.<init>()     // Catch:{ all -> 0x01be }
            com.bonree.sdk.d.a r6 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x01be }
            java.lang.String r6 = r6.j()     // Catch:{ all -> 0x01be }
            r5.append(r6)     // Catch:{ all -> 0x01be }
            java.lang.String r10 = c((com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r10)     // Catch:{ all -> 0x01be }
            r5.append(r10)     // Catch:{ all -> 0x01be }
            java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x01be }
            r3.<init>(r4, r2, r10)     // Catch:{ all -> 0x01be }
            com.bonree.sdk.d.e r10 = r9.b     // Catch:{ all -> 0x01be }
            com.bonree.sdk.af.a r10 = r10.f()     // Catch:{ all -> 0x01be }
            boolean r10 = r10.g     // Catch:{ all -> 0x01be }
            if (r10 == 0) goto L_0x0196
            java.lang.String r10 = "brjc"
            goto L_0x0198
        L_0x0196:
            java.lang.String r10 = ""
        L_0x0198:
            java.lang.String r10 = r9.a((com.bonree.sdk.f.c) r3, (java.lang.String) r10)     // Catch:{ all -> 0x01be }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x01be }
            android.os.Looper r4 = android.os.Looper.myLooper()     // Catch:{ all -> 0x01be }
            if (r2 != r4) goto L_0x01af
            com.bonree.sdk.f.e r2 = new com.bonree.sdk.f.e     // Catch:{ all -> 0x01be }
            r2.<init>(r9, r10, r3)     // Catch:{ all -> 0x01be }
            com.bonree.sdk.bs.ac.a(r2)     // Catch:{ all -> 0x01be }
            goto L_0x01b2
        L_0x01af:
            r9.a((java.lang.String) r10, (com.bonree.sdk.f.c) r3)     // Catch:{ all -> 0x01be }
        L_0x01b2:
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.f     // Catch:{ all -> 0x01be }
            r10.getAndSet(r1)     // Catch:{ all -> 0x01be }
            goto L_0x01c3
        L_0x01b8:
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.f     // Catch:{ all -> 0x01be }
            r10.getAndSet(r1)     // Catch:{ all -> 0x01be }
            return r0
        L_0x01be:
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.f
            r10.getAndSet(r1)
        L_0x01c3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.d.b(int):com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean");
    }

    private void a(UploadDataRequestBean uploadDataRequestBean) {
        String str;
        NetWorkStateInfoBean netWorkStateInfoBean;
        String str2;
        DeviceStateInfoBean deviceStateInfoBean;
        String str3;
        UserInfoBean userInfoBean;
        if (uploadDataRequestBean != null) {
            try {
                EventBean g2 = this.b.f().g();
                if (g2 != null) {
                    UploadDataRequestBean uploadDataRequestBean2 = new UploadDataRequestBean();
                    uploadDataRequestBean2.mSession = uploadDataRequestBean.getSession();
                    uploadDataRequestBean2.mProcessIdentifier = com.bonree.sdk.d.a.c;
                    uploadDataRequestBean2.mProcessName = g.a();
                    if (TextUtils.isEmpty(uploadDataRequestBean2.mProcessName)) {
                        uploadDataRequestBean2.mProcessName = g.a(com.bonree.sdk.bs.a.a());
                    }
                    if (TextUtils.isEmpty(uploadDataRequestBean2.mProcessName)) {
                        this.a.c("Upload get ProcessName failed!", new Object[0]);
                        uploadDataRequestBean2.mProcessName = com.bonree.sdk.bs.a.c(com.bonree.sdk.bs.a.a());
                    }
                    uploadDataRequestBean2.mAppStateInfo = com.bonree.sdk.d.a.k().i();
                    uploadDataRequestBean2.mVersion = uploadDataRequestBean.getAgentVersion();
                    uploadDataRequestBean2.mMonitorTime = Math.abs(uploadDataRequestBean.getMonitorTime());
                    uploadDataRequestBean2.mConfigMonitorTime = uploadDataRequestBean.getConfigMonitorTime();
                    uploadDataRequestBean2.mAppInfo = uploadDataRequestBean.getAppInfo();
                    uploadDataRequestBean2.mDeviceInfo = uploadDataRequestBean.getDeviceInfo();
                    uploadDataRequestBean2.mUnitSessionDuration = com.bonree.sdk.d.a.e();
                    uploadDataRequestBean2.mTrackID = uploadDataRequestBean.getTrackID();
                    uploadDataRequestBean2.mDataFusionInfo = uploadDataRequestBean.getDataFusionInfo();
                    Map<String, UserInfoBean> userInfoBean2 = uploadDataRequestBean.getUserInfoBean();
                    if (!(userInfoBean2 == null || (userInfoBean = userInfoBean2.get(str3)) == null)) {
                        uploadDataRequestBean2.mFirstUserInfo = str3.equals(uploadDataRequestBean.getFirstUserInfo()) ? uploadDataRequestBean.getFirstUserInfo() : null;
                        uploadDataRequestBean2.mUserInfoBean = new HashMap(1);
                        uploadDataRequestBean2.mUserInfoBean.put((str3 = g2.mStateIndex[0]), userInfoBean);
                    }
                    Map<String, DeviceStateInfoBean> deviceStateInfo = uploadDataRequestBean.getDeviceStateInfo();
                    if (!(deviceStateInfo == null || (deviceStateInfoBean = deviceStateInfo.get(str2)) == null)) {
                        uploadDataRequestBean2.mDeviceStateInfo = new HashMap(1);
                        uploadDataRequestBean2.mDeviceStateInfo.put((str2 = g2.mStateIndex[1]), deviceStateInfoBean);
                    }
                    Map<String, NetWorkStateInfoBean> netWorkStateInfo = uploadDataRequestBean.getNetWorkStateInfo();
                    if (!(netWorkStateInfo == null || (netWorkStateInfoBean = netWorkStateInfo.get(str)) == null)) {
                        uploadDataRequestBean2.mNetWorkStateInfo = new HashMap(1);
                        uploadDataRequestBean2.mNetWorkStateInfo.put((str = g2.mStateIndex[2]), netWorkStateInfoBean);
                    }
                    uploadDataRequestBean2.mEvents = new ArrayList();
                    uploadDataRequestBean2.mEvents.add(g2);
                    byte[] a2 = this.d.e().a(uploadDataRequestBean2);
                    if (a2 != null) {
                        String uuid = UUID.randomUUID().toString();
                        a(new c(uuid, a2, com.bonree.sdk.d.a.k().j() + c(uploadDataRequestBean2)), "brnc");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized List<EventBean> b(boolean z) {
        ArrayList arrayList;
        this.a.c("****************************************************************************", new Object[0]);
        this.a.c("************************** print UploadData infos **************************", new Object[0]);
        this.a.c("****************************************************************************", new Object[0]);
        arrayList = new ArrayList();
        try {
            EventBean a2 = this.b.r().a(z);
            if (a2 != null) {
                arrayList.add(a2);
            }
            List<EventBean> a3 = com.bonree.sdk.ar.e.a();
            if (a(a3)) {
                arrayList.addAll(a3);
            }
            List<EventBean> a4 = k.a();
            if (a(a4)) {
                arrayList.addAll(a4);
            }
            List<EventBean> d2 = k.d();
            if (a(d2)) {
                arrayList.addAll(d2);
            }
            List<EventBean> h2 = this.b.g().h();
            if (a(h2)) {
                arrayList.addAll(h2);
            }
            List<EventBean> a5 = b.a();
            if (a(a5)) {
                arrayList.addAll(a5);
            }
            List<EventBean> d3 = b.d();
            if (a(d3)) {
                arrayList.addAll(d3);
            }
            List<EventBean> e2 = b.e();
            if (a(e2)) {
                arrayList.addAll(e2);
            }
            EventBean e3 = this.b.k().e();
            if (e3 != null) {
                arrayList.add(e3);
            }
            List<EventBean> h3 = this.b.f().h();
            if (a(h3)) {
                arrayList.addAll(h3);
            }
            EventBean e4 = this.b.f().e();
            if (e4 != null) {
                arrayList.add(e4);
                f fVar = com.bonree.sdk.d.a.a;
                fVar.a("UP CRASH: " + ((CrashEventInfoBean) e4.mEventInfo).causedBy);
            }
            List<EventBean> a6 = this.b.n().a(z);
            if (a(a6)) {
                arrayList.addAll(a6);
            }
            List<EventBean> a7 = this.b.i().a(z);
            if (a(a7)) {
                arrayList.addAll(a7);
            }
            List<EventBean> e5 = this.b.h().e();
            if (a(e5)) {
                arrayList.addAll(e5);
            }
            List<EventBean> e6 = com.bonree.sdk.as.a.g().e();
            if (a(e6)) {
                arrayList.addAll(e6);
            }
            List<EventBean> a8 = this.b.o().a(z);
            if (a(a8)) {
                arrayList.addAll(a8);
            }
            List<EventBean> e7 = com.bonree.sdk.ao.d.g().e();
            if (a(e7)) {
                arrayList.addAll(e7);
            }
            List<EventBean> b2 = com.bonree.sdk.ae.a.e().b((!z || !com.bonree.sdk.d.a.k().J()) ? com.bonree.sdk.agent.engine.state.e.FOREGROUND : com.bonree.sdk.agent.engine.state.e.BACKGROUND);
            if (a(b2)) {
                arrayList.addAll(b2);
            }
            c.h().g();
            if (arrayList.isEmpty()) {
                com.bonree.sdk.d.a.a.a("upload data is empty ,skip!");
                this.a.c("upload data is empty ,skip!", new Object[0]);
                return null;
            }
        } catch (Throwable th) {
            com.bonree.sdk.d.a.a.a("createUploadData error: ", th);
            this.a.a("UploadExecutor createUploadData Throwable upload Error :", th);
        }
        return arrayList;
    }

    private static boolean a(List<EventBean> list) {
        return list != null && list.size() > 0;
    }

    private synchronized byte[] b(UploadDataRequestBean uploadDataRequestBean) {
        try {
            byte[] a2 = this.d.e().a(uploadDataRequestBean);
            if (a2 != null && a2.length > 4) {
                return a2;
            }
            this.a.c("uploadExecute sdkReqBeanBytes is null", new Object[0]);
            return null;
        } catch (Throwable th) {
            this.a.a("Throwable upload Error  , return", th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean a(boolean r5, com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List r5 = r4.b((boolean) r5)     // Catch:{ all -> 0x007c }
            r0 = 0
            if (r5 == 0) goto L_0x007a
            int r1 = r5.size()     // Catch:{ all -> 0x007c }
            if (r1 > 0) goto L_0x000f
            goto L_0x007a
        L_0x000f:
            if (r6 != 0) goto L_0x0017
            r6 = 1
            com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean r6 = r4.c((boolean) r6)     // Catch:{ all -> 0x007c }
            goto L_0x001d
        L_0x0017:
            long r1 = com.bonree.sdk.d.a.e()     // Catch:{ all -> 0x007c }
            r6.mUnitSessionDuration = r1     // Catch:{ all -> 0x007c }
        L_0x001d:
            if (r6 != 0) goto L_0x0021
            monitor-exit(r4)
            return r0
        L_0x0021:
            r6.mEvents = r5     // Catch:{ all -> 0x007c }
            com.bonree.sdk.be.f r5 = r4.a     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "statmainid { "
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            java.lang.String r1 = r6.mSession     // Catch:{ all -> 0x007c }
            r0.append(r1)     // Catch:{ all -> 0x007c }
            java.lang.String r1 = " }"
            r0.append(r1)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007c }
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x007c }
            r5.c(r0, r2)     // Catch:{ all -> 0x007c }
            com.bonree.sdk.be.f r5 = r4.a     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "monitorStartTime { "
            r0.<init>(r2)     // Catch:{ all -> 0x007c }
            long r2 = r6.mMonitorTime     // Catch:{ all -> 0x007c }
            r0.append(r2)     // Catch:{ all -> 0x007c }
            java.lang.String r2 = " }"
            r0.append(r2)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007c }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x007c }
            r5.c(r0, r2)     // Catch:{ all -> 0x007c }
            com.bonree.sdk.be.f r5 = r4.a     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "configMonitorTime { "
            r0.<init>(r2)     // Catch:{ all -> 0x007c }
            long r2 = r6.mConfigMonitorTime     // Catch:{ all -> 0x007c }
            r0.append(r2)     // Catch:{ all -> 0x007c }
            java.lang.String r2 = " }"
            r0.append(r2)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007c }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x007c }
            r5.c(r0, r1)     // Catch:{ all -> 0x007c }
            monitor-exit(r4)
            return r6
        L_0x007a:
            monitor-exit(r4)
            return r0
        L_0x007c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.d.a(boolean, com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean):com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean");
    }

    private UploadDataRequestBean c(boolean z) {
        UploadDataRequestBean uploadDataRequestBean = new UploadDataRequestBean();
        com.bonree.sdk.c.b g2 = this.b.y().g();
        if (g2 == null) {
            return null;
        }
        uploadDataRequestBean.mSession = g2.b();
        uploadDataRequestBean.mProcessIdentifier = com.bonree.sdk.d.a.c;
        uploadDataRequestBean.mProcessName = g.a();
        if (TextUtils.isEmpty(uploadDataRequestBean.mProcessName)) {
            uploadDataRequestBean.mProcessName = g.a(com.bonree.sdk.bs.a.a());
        }
        if (TextUtils.isEmpty(uploadDataRequestBean.mProcessName)) {
            this.a.c("Upload get ProcessName failed!", new Object[0]);
            uploadDataRequestBean.mProcessName = com.bonree.sdk.bs.a.c(com.bonree.sdk.bs.a.a());
        }
        uploadDataRequestBean.mAppStateInfo = com.bonree.sdk.d.a.k().i();
        uploadDataRequestBean.mVersion = Agent.getAgentVersion();
        uploadDataRequestBean.mMonitorTime = Math.abs(com.bonree.sdk.d.a.l());
        uploadDataRequestBean.mConfigMonitorTime = g2.c();
        uploadDataRequestBean.mAppInfo = com.bonree.sdk.am.g.k().e();
        uploadDataRequestBean.mDeviceInfo = com.bonree.sdk.am.g.k().g();
        uploadDataRequestBean.mFirstUserInfo = com.bonree.sdk.az.b.h().b(uploadDataRequestBean.mSession);
        uploadDataRequestBean.mTrafficInfo = this.b.q().a();
        uploadDataRequestBean.mUserInfoBean = com.bonree.sdk.az.b.h().a();
        uploadDataRequestBean.mDeviceStateInfo = com.bonree.sdk.am.g.k().d();
        uploadDataRequestBean.mNetWorkStateInfo = com.bonree.sdk.at.c.m().g();
        uploadDataRequestBean.mDataFusionInfo = com.bonree.sdk.d.a.k().a();
        OnlineTrackingInfo a2 = com.bonree.sdk.e.b.b().a();
        if (a2 != null) {
            uploadDataRequestBean.mTrackID = a2.getTrackID();
        }
        if (z) {
            uploadDataRequestBean.mUnitSessionDuration = com.bonree.sdk.d.a.e();
        }
        return uploadDataRequestBean;
    }

    private static String a() {
        return UUID.randomUUID().toString();
    }

    private synchronized String a(c cVar, String str) {
        String str2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss.SSS", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        str2 = simpleDateFormat.format(date) + str;
        this.c.a(str2, (Object) cVar);
        f fVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(Thread.currentThread().getId());
        fVar.d("upload save UploadContent , thread name: %s , thread id: %s ,save storage.. file name is %s", Thread.currentThread().getName(), sb.toString(), str2);
        com.bonree.sdk.d.a.a.a("UP SL OK " + str2);
        return str2;
    }

    private static String c(UploadDataRequestBean uploadDataRequestBean) {
        if (uploadDataRequestBean == null) {
            return "";
        }
        return "&mt=" + uploadDataRequestBean.mMonitorTime + "&cmt=" + uploadDataRequestBean.mConfigMonitorTime + "&s=" + uploadDataRequestBean.mSession;
    }

    /* access modifiers changed from: private */
    public void a(String str, c cVar) {
        try {
            String str2 = com.bonree.sdk.d.a.k().N() + cVar.a();
            com.bonree.sdk.d.a.a.a("UP S S.." + str);
            if (a(b(cVar.c(), str2, cVar.b(), false).a())) {
                this.a.c("upload ok or code == 20105,del file %s , result is %b", str, Boolean.valueOf(this.c.a(str)));
            }
        } finally {
            this.h.c();
            this.f.getAndSet(false);
        }
    }

    private synchronized UploadDataResponseBean d(int i) {
        this.f.getAndSet(true);
        UploadDataResponseBean uploadDataResponseBean = null;
        try {
            UploadDataRequestBean a2 = a(false, (UploadDataRequestBean) null);
            if (a2 == null) {
                this.f.getAndSet(false);
                return null;
            }
            byte[] b2 = b(a2);
            if (b2 != null) {
                if (b2.length > 4) {
                    String str = com.bonree.sdk.d.a.k().j() + c(a2);
                    String uuid = UUID.randomUUID().toString();
                    f b3 = b(b2, com.bonree.sdk.d.a.k().N() + str, uuid, true);
                    if (i != 3 || (b3 != null && b3.b())) {
                        if (b3 != null) {
                            uploadDataResponseBean = b3.a();
                            if (a(uploadDataResponseBean)) {
                                h hVar = this.e;
                                if (hVar == null || hVar.hasMessages(h.a) || this.e.c || !this.e.a()) {
                                    f fVar = this.a;
                                    Object[] objArr = new Object[1];
                                    h hVar2 = this.e;
                                    objArr[0] = hVar2 != null ? Boolean.valueOf(hVar2.c) : " handler is null!!!";
                                    fVar.e("UPStorageCacheHandler or thread is not invalid or is busy ? %b", objArr);
                                    this.h.c();
                                    this.f.getAndSet(false);
                                    return uploadDataResponseBean;
                                }
                                this.e.sendEmptyMessage(h.a);
                                this.h.c();
                                this.f.getAndSet(false);
                                return uploadDataResponseBean;
                            }
                        }
                        a(new c(uuid, b2, str), "");
                        this.h.c();
                        this.f.getAndSet(false);
                        return uploadDataResponseBean;
                    }
                    this.a.d("The upload data is discarded because the current network state is illegal !", new Object[0]);
                    com.bonree.sdk.d.a.a.a("UR DC");
                    this.f.getAndSet(false);
                    this.h.c();
                    this.f.getAndSet(false);
                    return null;
                }
            }
            this.a.e("upload data bytes is null..", new Object[0]);
            this.f.getAndSet(false);
            this.h.c();
            this.f.getAndSet(false);
            return null;
        } finally {
            this.h.c();
            this.f.getAndSet(false);
        }
    }

    private synchronized f b(byte[] bArr, String str, String str2, boolean z) {
        if (com.bonree.sdk.d.a.k().Y()) {
            this.h.a(false);
            this.h.a((UploadDataResponseBean) null);
            return this.h;
        }
        this.h.a(a(bArr, str, str2, z));
        this.h.a(true);
        return this.h;
    }

    public final synchronized UploadDataResponseBean a(byte[] bArr, String str, String str2, boolean z) {
        UploadDataResponseBean a2;
        OnlineTrackingInfo onlineTrackingInfo;
        a2 = this.d.e().a(bArr, str, str2);
        if (!(a2 == null || !z || (onlineTrackingInfo = a2.getOnlineTrackingInfo()) == null)) {
            com.bonree.sdk.d.a.a.a("ONLINE");
            String session = onlineTrackingInfo.getSession();
            if (!TextUtils.isEmpty(session) && session.equals(this.d.c().b())) {
                com.bonree.sdk.e.b.b().a(onlineTrackingInfo);
            }
        }
        return a2;
    }

    public d() {
    }

    public static String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static long b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getLong(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int d(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static double e(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0d;
        }
    }

    private static boolean h(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static float f(JSONObject jSONObject, String str) {
        try {
            return (float) jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0f;
        }
    }

    public static Object g(JSONObject jSONObject, String str) {
        try {
            return jSONObject.get(str);
        } catch (JSONException unused) {
            return "";
        }
    }
}
