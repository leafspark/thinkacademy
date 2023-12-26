package com.igexin.push.extension.distribution.basic.c;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.igexin.b.a.c.b;

public class a {
    private static a a;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public boolean a(Context context, Intent intent, int i) {
        b.a("JobSender| JobSender.runJob()", new Object[0]);
        if (!(Build.VERSION.SDK_INT < 26 || context == null || intent == null || intent.getComponent() == null)) {
            try {
                JobInfo build = new JobInfo.Builder(i, intent.getComponent()).setOverrideDeadline(0).build();
                Class<?> cls = Class.forName("android.app.job.JobWorkItem");
                Object newInstance = cls.getConstructor(new Class[]{Intent.class}).newInstance(new Object[]{intent});
                JobScheduler.class.getDeclaredMethod("enqueue", new Class[]{JobInfo.class, cls}).invoke((JobScheduler) context.getSystemService("jobscheduler"), new Object[]{build, newInstance});
                b.a("JobSender| started by JobSender", new Object[0]);
                return true;
            } catch (Throwable th) {
                b.a("JobSender|" + th.toString(), new Object[0]);
            }
        }
        return false;
    }
}
