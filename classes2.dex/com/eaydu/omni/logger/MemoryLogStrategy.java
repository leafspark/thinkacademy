package com.eaydu.omni.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class MemoryLogStrategy implements LogStrategy {
    private final Handler handler;

    public void stop() {
    }

    public MemoryLogStrategy(Handler handler2) {
        this.handler = (Handler) Utils.checkNotNull(handler2);
    }

    public void log(int i, String str, String str2) {
        Utils.checkNotNull(str2);
        Handler handler2 = this.handler;
        Message obtainMessage = handler2.obtainMessage(i, str2);
        if (!(handler2 instanceof Handler)) {
            handler2.sendMessage(obtainMessage);
        } else {
            AsynchronousInstrumentation.sendMessage(handler2, obtainMessage);
        }
    }

    static class WriteHandler extends Handler {
        final Object lock = new Object();
        private final int maxFileSize;
        final StringBuffer sb = new StringBuffer();

        WriteHandler(Looper looper, int i) {
            super((Looper) Utils.checkNotNull(looper));
            this.maxFileSize = i;
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            try {
                this.sb.append((String) message.obj);
                if (this.sb.length() > this.maxFileSize) {
                    this.sb.setLength(0);
                }
            } catch (Exception unused) {
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }

        public StringBuffer getData() {
            return this.sb;
        }
    }
}
