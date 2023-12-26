package com.wushuangtech.library;

import android.os.Handler;
import android.os.Message;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.utils.OmniLog;
import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HandlerSyncExtend {
    private static final int WAIT_MAX_TIME = 300;
    private CommonEventBean mCommonEventBean;
    private volatile boolean mDestroyed;
    private final Lock mLock = new ReentrantLock(true);
    private final String mTag;

    public HandlerSyncExtend(String str) {
        this.mTag = str + "-HandlerSyncExtend";
    }

    public void handleSyncMessage(Handler handler, int i, Object obj) {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = i;
        commonEventBean.mObject = obj;
        handleSyncMessage(handler, i, commonEventBean);
    }

    public void handleSyncMessage(Handler handler, CommonEventBean commonEventBean) {
        handleSyncMessage(handler, commonEventBean.mEventType, commonEventBean);
    }

    public void handleSyncMessage(Handler handler, int i, CommonEventBean commonEventBean) {
        int i2;
        if (handler != null && commonEventBean != null && !this.mDestroyed) {
            try {
                log("Prepare execute task, event=" + commonEventBean.toString());
                this.mLock.lock();
                Thread thread = handler.getLooper().getThread();
                Thread.State state = thread.getState();
                i2 = 0;
                int i3 = 0;
                while (true) {
                    if (state == Thread.State.RUNNABLE) {
                        break;
                    }
                    Thread.sleep((long) 10);
                    i3 += 10;
                    if (i3 >= 300) {
                        logE("Thread of Handler can't available! task=" + commonEventBean);
                        break;
                    } else if (this.mDestroyed) {
                        break;
                    } else {
                        state = thread.getState();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.mLock.unlock();
                throw th;
            }
            logI("Start execute task, task=" + commonEventBean.toString());
            this.mCommonEventBean = commonEventBean;
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = commonEventBean;
            int sendMessageAtFrontOfQueue = sendMessageAtFrontOfQueue(handler, obtain);
            if (sendMessageAtFrontOfQueue != 0) {
                logE("Task execute failed! result=" + sendMessageAtFrontOfQueue + ", task=" + commonEventBean.toString());
            } else {
                do {
                    try {
                        Thread.sleep((long) 10);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    i2 += 10;
                    if (!commonEventBean.mNotified) {
                        if (i2 >= 300) {
                            logW("Task execute too slow! task=" + commonEventBean.toString());
                        }
                    }
                    logI("Task execute finish! task=" + commonEventBean.toString() + ", spent=" + i2);
                    this.mLock.unlock();
                    return;
                } while (!this.mDestroyed);
            }
            this.mLock.unlock();
        }
    }

    public void clearResource() {
        if (!this.mDestroyed) {
            this.mCommonEventBean = null;
            this.mDestroyed = true;
        }
    }

    public void notifyEvent(CommonEventBean commonEventBean) {
        if (!this.mDestroyed) {
            CommonEventBean commonEventBean2 = this.mCommonEventBean;
            if (commonEventBean != null && commonEventBean2 != null) {
                if (!commonEventBean.mUniqueUid.equals(commonEventBean2.mUniqueUid)) {
                    log("Recv notification of task completion, But does't match the target task, target=" + commonEventBean.toString() + ", wait=" + commonEventBean2.toString());
                    return;
                }
                commonEventBean.mNotified = true;
            }
        }
    }

    private int sendMessageAtFrontOfQueue(Handler handler, Message message) {
        if (!(handler == null || message == null)) {
            try {
                handler.sendMessageAtFrontOfQueue(message);
                return 0;
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private void logI(String str) {
        OmniLog.i(this.mTag, str);
    }

    private void log(String str) {
        OmniLog.d(this.mTag, str);
    }

    private void logW(String str) {
        OmniLog.w(this.mTag, str);
    }

    private void logE(String str) {
        OmniLog.e(this.mTag, str);
    }
}
