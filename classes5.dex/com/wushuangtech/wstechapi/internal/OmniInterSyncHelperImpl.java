package com.wushuangtech.wstechapi.internal;

import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.log.ReportLoggerImpl;
import com.wushuangtech.wstechapi.inter.OmniInterSyncHelper;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OmniInterSyncHelperImpl {
    private static final int EXECUTE_TYPE_BOOLEAN = 1;
    private static final int EXECUTE_TYPE_INT = 2;
    private static final int EXECUTE_TYPE_OBJECT = 3;
    private String mChannelName;
    private boolean mEngineType;
    private final Lock mInterLock = new ReentrantLock();
    private String mTag;

    public Lock getLock() {
        return this.mInterLock;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public void setChannelName(String str) {
        this.mChannelName = str;
    }

    public void setChannelType(boolean z) {
        this.mEngineType = z;
    }

    public int executeInter(String str, OmniInterSyncHelper omniInterSyncHelper) {
        return ((Integer) executeInter(2, str, omniInterSyncHelper)).intValue();
    }

    public int executeInter(String str, String str2, OmniInterSyncHelper omniInterSyncHelper) {
        return ((Integer) executeInter(2, str + " " + str2, omniInterSyncHelper)).intValue();
    }

    public boolean executeInterBool(String str, OmniInterSyncHelper omniInterSyncHelper) {
        return ((Boolean) executeInter(1, str, omniInterSyncHelper)).booleanValue();
    }

    public boolean executeInterBool(String str, String str2, OmniInterSyncHelper omniInterSyncHelper) {
        return ((Boolean) executeInter(1, str + " " + str2, omniInterSyncHelper)).booleanValue();
    }

    public <T> T executeInterObj(String str, String str2, OmniInterSyncHelper omniInterSyncHelper) {
        return executeInter(3, str + " " + str2, omniInterSyncHelper);
    }

    public <T> T executeInterObj(String str, OmniInterSyncHelper omniInterSyncHelper) {
        return executeInter(3, str, omniInterSyncHelper);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object executeInter(int r10, java.lang.String r11, com.wushuangtech.wstechapi.inter.OmniInterSyncHelper r12) {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            java.util.concurrent.locks.Lock r3 = r9.mInterLock     // Catch:{ InterruptedException -> 0x00b7, all -> 0x00b5 }
            r4 = 2000(0x7d0, double:9.88E-321)
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x00b7, all -> 0x00b5 }
            boolean r3 = r3.tryLock(r4, r6)     // Catch:{ InterruptedException -> 0x00b7, all -> 0x00b5 }
            if (r3 != 0) goto L_0x002b
            java.lang.String r4 = r9.mTag     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0028 }
            r5.<init>()     // Catch:{ InterruptedException -> 0x0028 }
            r5.append(r11)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r6 = " -> can't get lock object!!!"
            r5.append(r6)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r5 = r5.toString()     // Catch:{ InterruptedException -> 0x0028 }
            com.wushuangtech.utils.OmniLog.w(r4, r5)     // Catch:{ InterruptedException -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r10 = move-exception
            goto L_0x00b9
        L_0x002b:
            r4 = 1
            if (r10 != r4) goto L_0x0037
            boolean r10 = r12.runBool()     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch:{ InterruptedException -> 0x0028 }
            goto L_0x0047
        L_0x0037:
            r4 = 2
            if (r10 != r4) goto L_0x0043
            int r10 = r12.run()     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ InterruptedException -> 0x0028 }
            goto L_0x0047
        L_0x0043:
            java.lang.Object r10 = r12.runObj(r11)     // Catch:{ InterruptedException -> 0x0028 }
        L_0x0047:
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ InterruptedException -> 0x0028 }
            if (r12 != 0) goto L_0x00ad
            java.lang.String r12 = r9.mChannelName     // Catch:{ InterruptedException -> 0x0028 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r4 = " | result : "
            java.lang.String r5 = " -> execute time : "
            if (r12 != 0) goto L_0x008b
            java.lang.String r12 = r9.mTag     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0028 }
            r6.<init>()     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r7 = "channel : "
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r7 = r9.mChannelName     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r7 = " | "
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r11)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r5)     // Catch:{ InterruptedException -> 0x0028 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x0028 }
            long r7 = r7 - r0
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r4)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r10)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r0 = r6.toString()     // Catch:{ InterruptedException -> 0x0028 }
            com.wushuangtech.utils.OmniLog.i2(r12, r0)     // Catch:{ InterruptedException -> 0x0028 }
            goto L_0x00ad
        L_0x008b:
            java.lang.String r12 = r9.mTag     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0028 }
            r6.<init>()     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r11)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r5)     // Catch:{ InterruptedException -> 0x0028 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x0028 }
            long r7 = r7 - r0
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r4)     // Catch:{ InterruptedException -> 0x0028 }
            r6.append(r10)     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r0 = r6.toString()     // Catch:{ InterruptedException -> 0x0028 }
            com.wushuangtech.utils.OmniLog.i2(r12, r0)     // Catch:{ InterruptedException -> 0x0028 }
        L_0x00ad:
            if (r3 == 0) goto L_0x00b4
            java.util.concurrent.locks.Lock r11 = r9.mInterLock
            r11.unlock()
        L_0x00b4:
            return r10
        L_0x00b5:
            r10 = move-exception
            goto L_0x00e4
        L_0x00b7:
            r10 = move-exception
            r3 = r2
        L_0x00b9:
            java.lang.String r12 = r9.mTag     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r0.<init>()     // Catch:{ all -> 0x00e2 }
            r0.append(r11)     // Catch:{ all -> 0x00e2 }
            java.lang.String r11 = " -> Can't get lock object!!! Exception : "
            r0.append(r11)     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x00e2 }
            r0.append(r10)     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x00e2 }
            com.wushuangtech.utils.OmniLog.e(r12, r10)     // Catch:{ all -> 0x00e2 }
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00e1
            java.util.concurrent.locks.Lock r11 = r9.mInterLock
            r11.unlock()
        L_0x00e1:
            return r10
        L_0x00e2:
            r10 = move-exception
            r2 = r3
        L_0x00e4:
            if (r2 == 0) goto L_0x00eb
            java.util.concurrent.locks.Lock r11 = r9.mInterLock
            r11.unlock()
        L_0x00eb:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniInterSyncHelperImpl.executeInter(int, java.lang.String, com.wushuangtech.wstechapi.inter.OmniInterSyncHelper):java.lang.Object");
    }

    public void buildReportLogAndSend(String str, Object... objArr) {
        buildReportLogAndSend(5, str, objArr);
    }

    public void buildReportLogAndSendForCallBack(String str, Object... objArr) {
        buildReportLogAndSend(6, str, objArr);
    }

    public void buildReportLogAndSend(int i, String str, Object... objArr) {
        String str2 = !this.mEngineType ? LocalSDKConstants.USER_ACTION_PREFIX_CHANNEL : LocalSDKConstants.USER_ACTION_PREFIX_ENGINE;
        ReportLoggerImpl.EventBean eventBean = new ReportLoggerImpl.EventBean();
        eventBean.timestamp = System.currentTimeMillis();
        eventBean.funName = str;
        eventBean.objs = objArr;
        GlobalHolder.getInstance().handleUserActionReport(str2, this.mChannelName, i, eventBean);
    }
}
