package com.wushuangtech.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.wushuangtech.library.GlobalHolder;
import java.util.List;

public class AppUtils {
    private static final String TAG = "AppUtils";

    public static boolean isBackground(Context context) {
        if (context == null) {
            OmniLog.e("Context is null!");
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            OmniLog.e("ActivityManager is null!");
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            OmniLog.e("get running app process info list is empty!");
            return false;
        }
        while (true) {
            boolean z = true;
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.equals(context.getPackageName())) {
                    if (next.importance != 400 && (next.importance == 100 || next.importance == 200)) {
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    public static boolean hasPermission(String str) {
        Context context = GlobalHolder.getInstance().getContext();
        if (context != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r1 != null) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1 == null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkCameraPermission(int r5) {
        /*
            r0 = 0
            r1 = 0
            android.hardware.Camera r1 = android.hardware.Camera.open(r5)     // Catch:{ Exception -> 0x001e }
            if (r1 != 0) goto L_0x000e
            if (r1 == 0) goto L_0x000d
            r1.release()
        L_0x000d:
            return r0
        L_0x000e:
            android.hardware.Camera$Parameters r5 = r1.getParameters()     // Catch:{ Exception -> 0x001e }
            r1.setParameters(r5)     // Catch:{ Exception -> 0x001e }
            r0 = 1
            if (r1 == 0) goto L_0x003c
        L_0x0018:
            r1.release()
            goto L_0x003c
        L_0x001c:
            r5 = move-exception
            goto L_0x003d
        L_0x001e:
            r5 = move-exception
            java.lang.String r2 = "AppUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r3.<init>()     // Catch:{ all -> 0x001c }
            java.lang.String r4 = "checkCameraPermission:"
            r3.append(r4)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x001c }
            r3.append(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x001c }
            android.util.Log.e(r2, r5)     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x003c
            goto L_0x0018
        L_0x003c:
            return r0
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.release()
        L_0x0042:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.AppUtils.checkCameraPermission(int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkAudioPermission() {
        /*
            r0 = 44100(0xac44, float:6.1797E-41)
            r1 = 12
            r2 = 2
            int r0 = android.media.AudioRecord.getMinBufferSize(r0, r1, r2)
            r1 = 0
            r2 = 0
            android.media.AudioRecord r9 = new android.media.AudioRecord     // Catch:{ Exception -> 0x005b }
            r4 = 1
            r6 = 12
            r7 = 2
            r5 = 44100(0xac44, float:6.1797E-41)
            r3 = r9
            r8 = r0
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005b }
            int r2 = r9.getState()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r3 = 1
            if (r2 == r3) goto L_0x0028
            r9.stop()
            r9.release()
            return r1
        L_0x0028:
            r9.startRecording()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            int r2 = r9.getRecordingState()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r4 = 3
            if (r2 == r4) goto L_0x0039
            r9.stop()
            r9.release()
            return r1
        L_0x0039:
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            int r2 = r9.read(r2, r1, r0)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r4 = -3
            if (r2 == r4) goto L_0x004c
            if (r2 == r0) goto L_0x0045
            goto L_0x004c
        L_0x0045:
            r9.stop()
            r9.release()
            return r3
        L_0x004c:
            r9.stop()
            r9.release()
            return r1
        L_0x0053:
            r0 = move-exception
            r2 = r9
            goto L_0x007f
        L_0x0056:
            r0 = move-exception
            r2 = r9
            goto L_0x005c
        L_0x0059:
            r0 = move-exception
            goto L_0x007f
        L_0x005b:
            r0 = move-exception
        L_0x005c:
            java.lang.String r3 = "AppUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r4.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r5 = "checkAudioPermission:"
            r4.append(r5)     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0059 }
            r4.append(r0)     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0059 }
            android.util.Log.e(r3, r0)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x007e
            r2.stop()
            r2.release()
        L_0x007e:
            return r1
        L_0x007f:
            if (r2 == 0) goto L_0x0087
            r2.stop()
            r2.release()
        L_0x0087:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.AppUtils.checkAudioPermission():boolean");
    }
}
