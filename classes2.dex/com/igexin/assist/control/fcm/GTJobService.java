package com.igexin.assist.control.fcm;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class GTJobService extends Service {
    public static final String TAG = "Assist_FCM";
    public static final long WAIT_TIME = 30000;
    private Service mService;
    /* access modifiers changed from: private */
    public volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;
    private BlockingQueue<Intent> messageQueue;

    public class JobIntentService extends JobService {
        public JobIntentService(Service service) {
            try {
                InvokeUtil.findMethod(getClass(), AppStateInfo.ATTACH_BASE_CONTEXT, Context.class).invoke(this, new Object[]{service});
            } catch (Throwable th) {
                th.printStackTrace();
                Log.e("Assist_FCM", "GTJobService init error: " + th.toString());
            }
        }

        public boolean onStartJob(final JobParameters jobParameters) {
            GTJobService.this.mServiceHandler.post(new Runnable() {
                public void run() {
                    try {
                        Class<?> cls = Class.forName("android.app.job.JobWorkItem");
                        Method findMethod = InvokeUtil.findMethod(JobParameters.class, "dequeueWork", new Class[0]);
                        Method findMethod2 = InvokeUtil.findMethod(cls, "getIntent", new Class[0]);
                        Method findMethod3 = InvokeUtil.findMethod(JobParameters.class, "completeWork", cls);
                        while (true) {
                            Object invoke = findMethod.invoke(jobParameters, new Object[0]);
                            if (invoke != null) {
                                findMethod3.invoke(jobParameters, new Object[]{invoke});
                                GTJobService.this.onHandleIntent((Intent) findMethod2.invoke(invoke, new Object[0]));
                            } else {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        Log.e("Assist_FCM", "onStartJob error: " + th.toString());
                    }
                }
            });
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    final class ServiceHandler extends Handler {
        private ServiceHandler(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            GTJobService.this.onHandleIntent((Intent) message.obj);
            GTJobService.this.stopSelf(message.arg1);
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    public IBinder onBind(Intent intent) {
        Service service = this.mService;
        if (service == null) {
            return null;
        }
        return service.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName());
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        this.mServiceHandler = new ServiceHandler(this.mServiceLooper);
        if (Build.VERSION.SDK_INT >= 26) {
            this.mService = new JobIntentService(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mServiceLooper.quit();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                processOnHandleIntent(intent);
                BlockingQueue<Intent> blockingQueue = this.messageQueue;
                if (blockingQueue != null) {
                    blockingQueue.remove(intent);
                    this.messageQueue.poll(WAIT_TIME, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            if (this.messageQueue == null) {
                this.messageQueue = new LinkedBlockingQueue();
            }
            this.messageQueue.offer(intent);
            Message obtainMessage = this.mServiceHandler.obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = intent;
            this.mServiceHandler.sendMessage(obtainMessage);
            return 2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void processOnHandleIntent(Intent intent);
}
