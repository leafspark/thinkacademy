package com.bonree.sdk.agent.engine.external;

import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.k.d;
import java.lang.reflect.Field;

public class AsynchronousInstrumentation {
    public static final String HANDLER_HANDLE_MESSAGE = "Handler/handleMessage";
    public static final String HANDLER_POST = "Handler/post";
    public static final String HANDLER_SEND_EMPTY_MESSAGE = "Handler/sendEmptyMessage";
    public static final String HANDLER_SEND_MESSAGE = "Handler/sendMessage";
    public static final String THREAD_RUN = "Thread/run";
    public static final String THREAD_START = "Thread/start";

    static class BrRunnable implements Runnable {
        private Runnable mRunnable;

        public BrRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }

        public void run() {
            if (this.mRunnable != null) {
                d.a(AsynchronousInstrumentation.THREAD_RUN, hashCode());
                this.mRunnable.run();
                d.b(AsynchronousInstrumentation.THREAD_RUN, hashCode());
            }
        }
    }

    public static void threadStart(Thread thread) {
        if (thread != null) {
            BrRunnable brRunnable = new BrRunnable((Runnable) z.b(thread, "target", null, Thread.class));
            try {
                Field a = z.a(thread.getClass(), "target");
                a.setAccessible(true);
                a.set(thread, brRunnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
            d.a(THREAD_START, thread.getId(), brRunnable.hashCode());
            thread.start();
            d.b(THREAD_START, thread.getId(), brRunnable.hashCode());
        }
    }

    public static boolean sendEmptyMessage(Handler handler, int i) {
        if (handler == null) {
            return false;
        }
        d.c(HANDLER_SEND_EMPTY_MESSAGE, handler.getLooper().getThread().getId(), i);
        boolean sendEmptyMessage = handler.sendEmptyMessage(i);
        d.d(HANDLER_SEND_EMPTY_MESSAGE, handler.getLooper().getThread().getId(), i);
        return sendEmptyMessage;
    }

    public static boolean sendMessage(Handler handler, Message message) {
        if (handler == null) {
            return false;
        }
        d.c(HANDLER_SEND_MESSAGE, handler.getLooper().getThread().getId(), message.hashCode());
        boolean sendMessage = handler.sendMessage(message);
        d.d(HANDLER_SEND_MESSAGE, handler.getLooper().getThread().getId(), message.hashCode());
        return sendMessage;
    }

    public static boolean handlerPost(Handler handler, Runnable runnable) {
        if (handler == null || runnable == null) {
            return false;
        }
        long id = handler.getLooper().getThread().getId();
        BrRunnable brRunnable = new BrRunnable(runnable);
        d.c(HANDLER_POST, id, brRunnable.hashCode());
        boolean post = handler.post(brRunnable);
        d.d(HANDLER_POST, id, brRunnable.hashCode());
        return post;
    }

    public static void handlerMessageBegin(Object obj, Message message) {
        d.a(HANDLER_HANDLE_MESSAGE, message.what, message.hashCode(), message.getCallback() != null ? message.getCallback().hashCode() : 0);
    }

    public static void handlerMessageEnd() {
        d.a(HANDLER_HANDLE_MESSAGE);
    }
}
