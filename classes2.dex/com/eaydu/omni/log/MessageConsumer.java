package com.eaydu.omni.log;

import com.eaydu.omni.log.LogReportBase;
import com.eaydu.omni.logger.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;

public class MessageConsumer {
    private static final int MAX_LOG_LENGTH = 500;
    private static final int TIME_INTERVAL_MIN_MS = 1000;
    private static final int TIME_INTERVAL_MS = 15000;
    private long lastSendTime = System.currentTimeMillis();
    private final LinkedList<LogMessage> logMessages = new LinkedList<>();
    public boolean mContinue = true;
    private Object mLogLock = new Object();
    private Timer mSendTimer = null;
    private LogReportBase.LogSendListener mlogSendMessage;

    public MessageConsumer(LogReportBase.LogSendListener logSendListener) {
        this.mlogSendMessage = logSendListener;
    }

    public void add(LogMessage logMessage) {
        synchronized (this.mLogLock) {
            if (this.mContinue) {
                if (!(logMessage == null || logMessage.param == null || this.logMessages.size() >= 500)) {
                    Logger.i("Kibana message: " + logMessage.param.toString(), new Object[0]);
                }
                this.logMessages.add(logMessage);
            }
        }
    }

    public synchronized void start() {
        Timer timer = this.mSendTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mContinue = true;
        Timer timer2 = new Timer();
        this.mSendTimer = timer2;
        timer2.schedule(new TimerTask() {
            public void run() {
                try {
                    MessageConsumer.this.send();
                } catch (Exception e) {
                    Logger.i("MessageConsumer mSendTimer.schedule " + e.getMessage(), new Object[0]);
                }
            }
        }, 0, 1000);
    }

    public void send() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastSendTime < 15000 && this.mContinue && this.logMessages.size() < 500) {
            return;
        }
        if (currentTimeMillis - this.lastSendTime > 1000 || this.logMessages.size() < 500) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.mLogLock) {
                Iterator it = this.logMessages.iterator();
                while (it.hasNext()) {
                    LogMessage logMessage = (LogMessage) it.next();
                    if (logMessage.param != null) {
                        jSONArray.put(logMessage.param);
                    }
                }
                this.logMessages.clear();
            }
            if (jSONArray.length() > 0) {
                LogMessage logMessage2 = new LogMessage(jSONArray);
                LogReportBase.LogSendListener logSendListener = this.mlogSendMessage;
                if (logSendListener != null) {
                    logSendListener.onNeedlogUpload(logMessage2, true);
                }
            } else {
                Logger.i("MessageConsumer no need to send!", new Object[0]);
            }
            this.lastSendTime = currentTimeMillis;
            return;
        }
        synchronized (this.mLogLock) {
            this.logMessages.clear();
        }
    }

    public synchronized void stop() {
        this.mContinue = false;
        Timer timer = this.mSendTimer;
        if (timer != null) {
            timer.cancel();
            this.mSendTimer = null;
        }
        try {
            send();
        } catch (Exception e) {
            Logger.i("MessageConsumer stop error: " + e.getMessage(), new Object[0]);
        }
        return;
    }
}
