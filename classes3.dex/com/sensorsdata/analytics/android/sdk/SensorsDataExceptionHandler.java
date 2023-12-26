package com.sensorsdata.analytics.android.sdk;

import android.os.Process;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class SensorsDataExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int SLEEP_TIMEOUT_MS = 500;
    private static boolean isTrackCrash = false;
    private static final ArrayList<SAExceptionListener> sExceptionListeners = new ArrayList<>();
    private static SensorsDataExceptionHandler sInstance;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public interface SAExceptionListener {
        void uncaughtException(Thread thread, Throwable th);
    }

    private SensorsDataExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized void init() {
        synchronized (SensorsDataExceptionHandler.class) {
            if (sInstance == null) {
                sInstance = new SensorsDataExceptionHandler();
            }
        }
    }

    static void addExceptionListener(SAExceptionListener sAExceptionListener) {
        sExceptionListeners.add(sAExceptionListener);
    }

    static void enableAppCrash() {
        isTrackCrash = true;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (isTrackCrash) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                            cause.printStackTrace(printWriter);
                        }
                        printWriter.close();
                        jSONObject.put("app_crashed_reason", stringWriter.toString());
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                    SensorsDataAPI.sharedInstance().trackEvent(EventType.TRACK, "AppCrashed", jSONObject, (String) null);
                } catch (Exception e2) {
                    SALog.printStackTrace(e2);
                }
            }
            Iterator<SAExceptionListener> it = sExceptionListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Exception e3) {
                    SALog.printStackTrace(e3);
                }
            }
            SensorsDataAPI.sharedInstance().flush();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e4) {
                SALog.printStackTrace(e4);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                killProcessAndExit();
            }
        } catch (Exception unused) {
        }
    }

    private void killProcessAndExit() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Exception unused) {
        }
    }
}
