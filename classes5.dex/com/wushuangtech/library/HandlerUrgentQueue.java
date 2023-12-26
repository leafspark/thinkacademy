package com.wushuangtech.library;

import android.os.Handler;
import android.os.Message;
import com.wushuangtech.utils.OmniLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HandlerUrgentQueue {
    private final String TAG;
    private boolean mDestroyed;
    private final Lock mLock = new ReentrantLock();
    private LinkedList<Message> mQueue = new LinkedList<>();
    private volatile boolean mUrgentMsgExecuting;

    public HandlerUrgentQueue(String str) {
        this.TAG = str + "[HandlerUrgentQueue";
    }

    public boolean executeUrgentMsg(Handler handler, Message message) {
        if (handler == null || message == null) {
            return true;
        }
        try {
            this.mLock.lock();
            int i = 0;
            if (!this.mDestroyed) {
                message.arg1 = 1;
                if (this.mUrgentMsgExecuting) {
                    if (this.mQueue.size() > 0) {
                        Iterator it = this.mQueue.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            } else if (((Message) it.next()).what == message.what) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            this.mQueue.add(message);
                            logD("Remove cache message! message = " + this.mQueue.remove(i).what + ", index=" + i + ", cache size=" + this.mQueue.size());
                        }
                    }
                    this.mQueue.add(message);
                    logI("Cache a new message! message = " + message.what + ", cache size=" + this.mQueue.size());
                    this.mLock.unlock();
                    return true;
                } else if (handler.sendMessageAtFrontOfQueue(message)) {
                    this.mUrgentMsgExecuting = true;
                    logI("Send urgent message success! what = " + message.what);
                } else {
                    logW("Send urgent message failed! what = " + message.what);
                }
                this.mLock.unlock();
                return true;
            }
            return false;
        } finally {
            this.mLock.unlock();
        }
    }

    public void destroyQueue() {
        try {
            this.mLock.lock();
            LinkedList<Message> linkedList = this.mQueue;
            if (linkedList != null) {
                linkedList.clear();
                this.mQueue = null;
            }
            this.mDestroyed = true;
        } finally {
            this.mLock.unlock();
        }
    }

    public void onUrgentMessageExecuteFinish(Handler handler, int i) {
        Message poll;
        if (handler != null) {
            try {
                this.mLock.lock();
                if (!this.mDestroyed) {
                    if (this.mQueue.size() <= 0 || (poll = this.mQueue.poll()) == null) {
                        logI("All cached messages have been executed. last message = " + i + ", start waiting!");
                        this.mUrgentMsgExecuting = false;
                        this.mLock.unlock();
                        return;
                    }
                    boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(poll);
                    logI("Auto execute next urgent message = " + poll.what + ", result = " + sendMessageAtFrontOfQueue + ", cache size : " + this.mQueue.size());
                }
            } finally {
                this.mLock.unlock();
            }
        }
    }

    private void logI(String str) {
        OmniLog.i(this.TAG, str);
    }

    private void logD(String str) {
        OmniLog.d(this.TAG, str);
    }

    private void logW(String str) {
        OmniLog.w(this.TAG, str);
    }
}
