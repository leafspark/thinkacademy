package com.igexin.assist.control.fcm;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class JobSender {
    public static final String TAG = "Assist_FCM";
    private static JobSender mSender;

    private JobSender() {
    }

    public static synchronized JobSender getInstance() {
        JobSender jobSender;
        synchronized (JobSender.class) {
            if (mSender == null) {
                mSender = new JobSender();
            }
            jobSender = mSender;
        }
        return jobSender;
    }

    public boolean runJob(Context context, Intent intent, int i) {
        String str;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (context == null) {
            str = "runJob, context is null!";
        } else if (intent == null || intent.getComponent() == null) {
            str = "runJob, intent is null!";
        } else {
            try {
                JobInfo build = new JobInfo.Builder(i, intent.getComponent()).setOverrideDeadline(0).build();
                Class<?> cls = Class.forName("android.app.job.JobWorkItem");
                Object newInstance = cls.getConstructor(new Class[]{Intent.class}).newInstance(new Object[]{intent});
                JobScheduler.class.getDeclaredMethod("enqueue", new Class[]{JobInfo.class, cls}).invoke((JobScheduler) context.getSystemService("jobscheduler"), new Object[]{build, newInstance});
                Log.d("Assist_FCM", "started by JobSender");
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        Log.d("Assist_FCM", str);
        return false;
    }
}
