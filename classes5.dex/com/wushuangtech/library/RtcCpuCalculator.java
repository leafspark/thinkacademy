package com.wushuangtech.library;

import android.os.Process;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.OmniLog;
import com.yalantis.ucrop.view.CropImageView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RtcCpuCalculator implements Runnable {
    private static final String TAG = "RtcCpuCalculator";
    private float mAppUseCpu;
    private int mCpuCoreNum;
    private int mCpuIndex;
    private volatile boolean mDestoryed;
    private final int mLeftDecimalNum;
    private int tryNum = 50;

    public RtcCpuCalculator(int i) {
        this.mLeftDecimalNum = i;
    }

    public float getAppUseCpu() {
        if (this.mCpuIndex < 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return this.mAppUseCpu;
    }

    public void start() {
        Thread thread = new Thread(this, "cpu_calc");
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    public void stop() {
        this.mDestoryed = true;
    }

    public void run() {
        int myPid = Process.myPid();
        this.mCpuIndex = getCpuIndex();
        log("cpu title index : " + this.mCpuIndex);
        if (this.mCpuIndex >= 0) {
            do {
                int i = this.tryNum;
                if (i > 0) {
                    this.tryNum = i - 1;
                } else {
                    return;
                }
            } while (!startCpuCalc(myPid));
        }
    }

    private int getCpuIndex() {
        Process process;
        try {
            process = Runtime.getRuntime().exec("top -n 1");
        } catch (IOException e) {
            e.printStackTrace();
            process = null;
        }
        if (process == null) {
            logW("Get top process failed...");
            return -1;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        int i = -2;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if (trim.contains("CPU")) {
                    String[] split = trim.split("\\s+");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split.length) {
                            break;
                        } else if (split[i2].contains("CPU")) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            } catch (IOException e2) {
                logW("IOException happend... " + e2.getLocalizedMessage());
                process.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return -3;
            } catch (Throwable th) {
                process.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
        process.destroy();
        try {
            bufferedReader.close();
        } catch (IOException unused3) {
        }
        return i;
    }

    private boolean startCpuCalc(int i) {
        Process process;
        try {
            process = Runtime.getRuntime().exec("top");
        } catch (IOException e) {
            e.printStackTrace();
            process = null;
        }
        if (process == null) {
            logW("Get top process failed...");
            return false;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (this.mDestoryed) {
                    break;
                } else if (TextUtils.isEmpty(readLine)) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    try {
                        produceCpuInfo(readLine, i);
                    } catch (Exception e3) {
                        logW("Exception happend... " + e3.getLocalizedMessage());
                    }
                }
            } catch (IOException e4) {
                logW("IOException happend... " + e4.getLocalizedMessage());
                process.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return false;
            } catch (Throwable th) {
                process.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
        process.destroy();
        try {
            bufferedReader.close();
        } catch (IOException unused3) {
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        r3 = r3.split("\\s+");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void produceCpuInfo(java.lang.String r3, int r4) {
        /*
            r2 = this;
            java.lang.String r3 = r3.trim()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            int r0 = r2.mCpuIndex
            if (r4 > r0) goto L_0x001b
            return
        L_0x001b:
            r3 = r3[r0]
            java.lang.String r4 = "%"
            boolean r0 = r3.endsWith(r4)
            r1 = 0
            if (r0 == 0) goto L_0x002e
            int r4 = r3.lastIndexOf(r4)
            java.lang.String r3 = r3.substring(r1, r4)
        L_0x002e:
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r4 >= r0) goto L_0x003c
            float r3 = java.lang.Float.parseFloat(r3)
            r4 = 1120403456(0x42c80000, float:100.0)
        L_0x003a:
            float r3 = r3 / r4
            goto L_0x0056
        L_0x003c:
            int r4 = r2.mCpuCoreNum
            if (r4 != 0) goto L_0x0049
            int r4 = r2.getNumberOfCPUCores()
            if (r4 != 0) goto L_0x0047
            return
        L_0x0047:
            r2.mCpuCoreNum = r4
        L_0x0049:
            int r4 = r2.mCpuCoreNum
            int r1 = r4 * 100
            if (r1 != 0) goto L_0x0050
            return
        L_0x0050:
            float r3 = java.lang.Float.parseFloat(r3)
            float r4 = (float) r1
            goto L_0x003a
        L_0x0056:
            r4 = 0
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x005e
            r2.mAppUseCpu = r4
            goto L_0x0066
        L_0x005e:
            int r4 = r2.mLeftDecimalNum
            float r3 = com.wushuangtech.utils.MyMathUtils.formatNumberDecimal((int) r4, (float) r3)
            r2.mAppUseCpu = r3
        L_0x0066:
            float r3 = r2.mAppUseCpu
            com.wushuangtech.library.GlobalConfig.mAppCpuUsageRate = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "cpu infos mAppUseCpu : "
            r3.append(r4)
            float r4 = r2.mAppUseCpu
            r3.append(r4)
            java.lang.String r4 = " | totalCpu : "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = " | os version : "
            r3.append(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r3.append(r4)
            java.lang.String r4 = " | Thread id : "
            r3.append(r4)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            long r0 = r4.getId()
            r3.append(r0)
            java.lang.String r4 = " | Thread size : "
            r3.append(r4)
            int r4 = java.lang.Thread.activeCount()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r3 = move-exception
            r3.printStackTrace()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcCpuCalculator.produceCpuInfo(java.lang.String, int):void");
    }

    private int getNumberOfCPUCores() {
        DeviceUtils deviceUtils;
        GlobalChannelConfig globalChannelConfig = GlobalHolder.getInstance().getGlobalChannelConfig();
        if (globalChannelConfig == null || (deviceUtils = globalChannelConfig.getDeviceUtils()) == null) {
            return 0;
        }
        return deviceUtils.getNumberOfCPUCores();
    }

    private void log(String str) {
        OmniLog.d(OmniLog.LOG_WATCH, TAG, str);
    }

    private void logW(String str) {
        OmniLog.w(OmniLog.LOG_WATCH, TAG, str);
    }
}
