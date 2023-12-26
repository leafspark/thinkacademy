package com.bonree.sdk.ao;

import android.os.Looper;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.instruction.FileInstructionContentBean;
import com.bonree.sdk.agent.business.entity.instruction.FileInstructionResultBean;
import com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean;
import com.bonree.sdk.be.f;
import com.bonree.sdk.common.onlineTools.c;
import com.google.firebase.messaging.Constants;
import java.io.File;
import org.json.JSONObject;

public final class a extends c {
    private static String a = "File-Instruction-Thread";
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final int i = 6;
    private f e = com.bonree.sdk.be.a.a();

    private a(Looper looper) {
        super(looper);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d3 A[Catch:{ all -> 0x011b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r14) {
        /*
            r13 = this;
            int r0 = r14.what
            if (r0 != 0) goto L_0x013c
            java.lang.Object r14 = r14.obj
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration r14 = (com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration) r14
            com.bonree.sdk.agent.business.entity.instruction.InstructionContentBean r0 = r14.getInstructionContentBean()
            boolean r1 = r0 instanceof com.bonree.sdk.agent.business.entity.instruction.FileInstructionContentBean
            r2 = 0
            if (r1 == 0) goto L_0x0135
            com.bonree.sdk.agent.business.entity.instruction.FileInstructionResultBean r1 = new com.bonree.sdk.agent.business.entity.instruction.FileInstructionResultBean
            r1.<init>()
            r3 = 0
            r4 = 1
            com.bonree.sdk.agent.business.entity.instruction.FileInstructionContentBean r0 = (com.bonree.sdk.agent.business.entity.instruction.FileInstructionContentBean) r0     // Catch:{ all -> 0x011b }
            int r5 = r0.getPathPrefix()     // Catch:{ all -> 0x011b }
            java.lang.String r6 = r0.getFilePath()     // Catch:{ all -> 0x011b }
            long r7 = r0.getSize()     // Catch:{ all -> 0x011b }
            r9 = 3
            if (r5 != r9) goto L_0x0047
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r5.<init>()     // Catch:{ all -> 0x011b }
            android.content.Context r9 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x011b }
            java.io.File r9 = r9.getFilesDir()     // Catch:{ all -> 0x011b }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011b }
            goto L_0x00a3
        L_0x0047:
            r9 = 4
            if (r5 != r9) goto L_0x0068
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r5.<init>()     // Catch:{ all -> 0x011b }
            android.content.Context r9 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x011b }
            java.io.File r9 = r9.getCacheDir()     // Catch:{ all -> 0x011b }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011b }
            goto L_0x00a3
        L_0x0068:
            r9 = 5
            if (r5 != r9) goto L_0x0085
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r5.<init>()     // Catch:{ all -> 0x011b }
            android.content.Context r9 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x011b }
            java.io.File r9 = r9.getExternalCacheDir()     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011b }
            goto L_0x00a3
        L_0x0085:
            r9 = 6
            if (r5 != r9) goto L_0x00a2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r5.<init>()     // Catch:{ all -> 0x011b }
            android.content.Context r9 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x011b }
            java.io.File r9 = r9.getExternalFilesDir(r2)     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x011b }
            r5.append(r9)     // Catch:{ all -> 0x011b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011b }
            goto L_0x00a3
        L_0x00a2:
            r5 = r2
        L_0x00a3:
            if (r5 != 0) goto L_0x00a7
        L_0x00a5:
            r6 = r2
            goto L_0x00d1
        L_0x00a7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r9.<init>()     // Catch:{ all -> 0x011b }
            r9.append(r5)     // Catch:{ all -> 0x011b }
            r9.append(r6)     // Catch:{ all -> 0x011b }
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x011b }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x011b }
            r6.<init>(r5)     // Catch:{ all -> 0x011b }
            boolean r5 = r6.exists()     // Catch:{ all -> 0x011b }
            if (r5 != 0) goto L_0x00c2
            goto L_0x00a5
        L_0x00c2:
            long r9 = r6.length()     // Catch:{ all -> 0x011b }
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a5
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d1
            goto L_0x00a5
        L_0x00d1:
            if (r6 == 0) goto L_0x0135
            com.bonree.sdk.common.onlineTools.a r5 = new com.bonree.sdk.common.onlineTools.a     // Catch:{ all -> 0x011b }
            r5.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r0 = r0.getUrl()     // Catch:{ all -> 0x011b }
            java.lang.String r0 = r5.a(r6, r0)     // Catch:{ all -> 0x011b }
            com.bonree.sdk.be.f r5 = r13.e     // Catch:{ all -> 0x011b }
            java.lang.String r6 = b     // Catch:{ all -> 0x011b }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            java.lang.String r9 = "resultJson="
            r8.<init>(r9)     // Catch:{ all -> 0x011b }
            r8.append(r0)     // Catch:{ all -> 0x011b }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x011b }
            r7[r3] = r8     // Catch:{ all -> 0x011b }
            r5.c(r6, r7)     // Catch:{ all -> 0x011b }
            if (r0 == 0) goto L_0x0135
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x011b }
            r5.<init>(r0)     // Catch:{ all -> 0x011b }
            java.lang.String r0 = "code"
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x011b }
            r6 = 200(0xc8, float:2.8E-43)
            if (r0 != r6) goto L_0x0135
            java.lang.String r0 = "data"
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x011b }
            r1.setFilePath(r0)     // Catch:{ all -> 0x011b }
            java.lang.String r0 = r14.getTaskID()     // Catch:{ all -> 0x011b }
            r13.a(r0, r1)     // Catch:{ all -> 0x011b }
            return
        L_0x011b:
            r0 = move-exception
            com.bonree.sdk.be.f r1 = r13.e
            java.lang.String r5 = b
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "executeTask: "
            r6.<init>(r7)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r4[r3] = r0
            r1.e(r5, r4)
        L_0x0135:
            java.lang.String r14 = r14.getTaskID()
            r13.a(r14, r2)
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ao.a.handleMessage(android.os.Message):void");
    }

    private void a(HeartbeatResponseDataBean.TaskConfiguration<?> taskConfiguration) {
        Object instructionContentBean = taskConfiguration.getInstructionContentBean();
        if (instructionContentBean instanceof FileInstructionContentBean) {
            FileInstructionResultBean fileInstructionResultBean = new FileInstructionResultBean();
            try {
                FileInstructionContentBean fileInstructionContentBean = (FileInstructionContentBean) instructionContentBean;
                File a2 = a(fileInstructionContentBean.getPathPrefix(), fileInstructionContentBean.getFilePath(), fileInstructionContentBean.getSize());
                if (a2 != null) {
                    String a3 = new com.bonree.sdk.common.onlineTools.a().a(a2, fileInstructionContentBean.getUrl());
                    f fVar = this.e;
                    String str = b;
                    fVar.c(str, "resultJson=" + a3);
                    if (a3 != null) {
                        JSONObject jSONObject = new JSONObject(a3);
                        if (jSONObject.getInt("code") == 200) {
                            fileInstructionResultBean.setFilePath(jSONObject.getString(Constants.ScionAnalytics.MessageType.DATA_MESSAGE));
                            a(taskConfiguration.getTaskID(), fileInstructionResultBean);
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                f fVar2 = this.e;
                String str2 = b;
                fVar2.e(str2, "executeTask: " + th);
            }
        }
        a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
    }

    private static File a(int i2, String str, long j) {
        String str2;
        if (i2 == 3) {
            str2 = com.bonree.sdk.bs.a.a().getFilesDir().getAbsolutePath() + File.separator;
        } else if (i2 == 4) {
            str2 = com.bonree.sdk.bs.a.a().getCacheDir().toString() + File.separator;
        } else if (i2 == 5) {
            str2 = com.bonree.sdk.bs.a.a().getExternalCacheDir() + File.separator;
        } else if (i2 == 6) {
            str2 = com.bonree.sdk.bs.a.a().getExternalFilesDir((String) null) + File.separator;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        File file = new File(str2 + str);
        if (!file.exists()) {
            return null;
        }
        long length = file.length();
        if (length <= 0 || length > j) {
            return null;
        }
        return file;
    }

    public static a a(c cVar) {
        a aVar = new a(d.a().a("File-Instruction-Thread"));
        aVar.d = cVar;
        return aVar;
    }
}
