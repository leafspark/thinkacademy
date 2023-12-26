package com.wushuangtech.log;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.wushuangtech.utils.OmniLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogRecorder {
    /* access modifiers changed from: private */
    public static final String TAG = "LogRecorder";
    private String mCmdString;
    private final WeakReference<Context> mContextRef;
    private String mLogDirPath;
    private LogDumper mLogDumper = null;

    public LogRecorder(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    public void setLogDirPath(String str) {
        this.mLogDirPath = str + "/OMNILog";
    }

    public void setCmdString(String str) {
        this.mCmdString = str;
    }

    public boolean start() {
        if (TextUtils.isEmpty(this.mLogDirPath) || TextUtils.isEmpty(this.mCmdString)) {
            return false;
        }
        LogDumper logDumper = this.mLogDumper;
        if (logDumper != null) {
            logDumper.stopDumping();
            this.mLogDumper = null;
        }
        LogDumper logDumper2 = new LogDumper(this);
        this.mLogDumper = logDumper2;
        logDumper2.init(this.mCmdString, this.mLogDirPath, LogFileHelper.LOG_SAVE_FILE_MAX_SIZE);
        this.mLogDumper.start();
        return true;
    }

    public void stop() {
        LogDumper logDumper = this.mLogDumper;
        if (logDumper != null) {
            logDumper.stopDumping();
            this.mLogDumper = null;
        }
    }

    /* access modifiers changed from: private */
    public File getNewLogFile() {
        return LogFileHelper.getInstance().getUserSystemNewWritingFile((Context) this.mContextRef.get());
    }

    private static class LogDumper extends Thread {
        private static final int ERROR_FILE_CREATE_FAILED = -2;
        private static final int ERROR_FILE_RECREATE = -10;
        private static final int ERROR_LOGCAT_PROCESS_CREATE_FAILED = -1;
        private static final int ERROR_NORMAL_EXCEPTION = -5;
        private static final int ERROR_STREAM_CREATE_FAILED = -3;
        private static final int ERROR_STREAM_READ_EXCEPTION = -4;
        private static final int RESTART_LOG_RECORD_COUNT = 10;
        private final Format FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        private long mCurrentFileSize;
        private String mLogCmd;
        private String mLogDirPath;
        private int mLogFileLimitation;
        private Process mLogcatProc = null;
        private final WeakReference<LogRecorder> mOutReference;
        private BufferedReader mReader = null;
        private final AtomicBoolean mRunning = new AtomicBoolean(true);
        private File mSaveFile;
        private BufferedWriter mWriter = null;

        LogDumper(LogRecorder logRecorder) {
            super("log_write_thread");
            this.mOutReference = new WeakReference<>(logRecorder);
        }

        /* access modifiers changed from: package-private */
        public void init(String str, String str2, int i) {
            this.mLogCmd = str;
            this.mLogDirPath = str2;
            this.mLogFileLimitation = i;
            LogFileHelper.getInstance().initUserLogSaveDirPath(str2);
        }

        /* access modifiers changed from: package-private */
        public void stopDumping() {
            this.mRunning.set(false);
        }

        public void run() {
            long j;
            log("Thread create! " + Thread.currentThread().getId());
            int i = 0;
            int i2 = 0;
            while (this.mRunning.get()) {
                i = processLog();
                clearResource();
                if (i != 0) {
                    i2++;
                    if (i == ERROR_FILE_RECREATE) {
                        clearLogcat();
                        j = 500;
                    } else {
                        j = 10000;
                    }
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (this.mRunning.get()) {
                        log("Restart log recorder, reason = " + i + ", sleepTime = " + j);
                    }
                    if (i2 > 10) {
                        logE("Restart log recorder too many count!, exit thread!");
                        return;
                    }
                }
            }
            log("Thread exit! " + Thread.currentThread().getId() + ", reason = " + i);
        }

        private int processLog() {
            try {
                if (this.mLogcatProc == null) {
                    this.mLogcatProc = Runtime.getRuntime().exec(this.mLogCmd);
                }
            } catch (IOException e) {
                log("Create logcat process failed! " + e.getLocalizedMessage());
            }
            if (this.mLogcatProc == null) {
                return -1;
            }
            File file = new File(this.mLogDirPath);
            if (file.exists() || file.mkdirs()) {
                if (this.mSaveFile == null) {
                    LogRecorder logRecorder = (LogRecorder) this.mOutReference.get();
                    if (logRecorder == null) {
                        return -2;
                    }
                    File access$000 = logRecorder.getNewLogFile();
                    if (access$000 == null || !access$000.exists()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Create save file failed! path = ");
                        sb.append(access$000 == null ? "null" : access$000.getAbsolutePath());
                        logE(sb.toString());
                        return -2;
                    }
                    this.mSaveFile = access$000;
                }
                log("Save path " + this.mSaveFile.getAbsolutePath() + " | size:" + this.mSaveFile.length());
                try {
                    if (this.mReader == null) {
                        this.mReader = new BufferedReader(new InputStreamReader(this.mLogcatProc.getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    }
                    if (this.mWriter == null) {
                        this.mWriter = new BufferedWriter(new FileWriter(this.mSaveFile, true));
                    }
                } catch (Exception e2) {
                    log("Create stream failed! " + e2.getLocalizedMessage());
                }
                if (this.mReader == null || this.mWriter == null) {
                    return -3;
                }
                try {
                    log("Start read log...");
                    String property = System.getProperty("line.separator");
                    while (true) {
                        String readLine = this.mReader.readLine();
                        if (readLine == null) {
                            return -5;
                        }
                        if (readLine.length() != 0) {
                            if (!this.mRunning.get()) {
                                log("Stop read log!");
                                return 0;
                            }
                            try {
                                String format = this.FORMAT.format(Long.valueOf(System.currentTimeMillis()));
                                this.mWriter.write(format + readLine);
                                this.mWriter.write(property);
                                this.mWriter.flush();
                                if (checkFileOverflow((readLine + "\n").getBytes().length)) {
                                    return ERROR_FILE_RECREATE;
                                }
                            } catch (Exception e3) {
                                log("Write log failed! " + e3.getLocalizedMessage());
                                return -4;
                            }
                        }
                    }
                } catch (Exception e4) {
                    log("Read log failed! " + e4.getLocalizedMessage());
                    return -5;
                }
            } else {
                logE("Create log save dir failed! path = " + this.mLogDirPath);
                return -2;
            }
        }

        private void clearResource() {
            Process process = this.mLogcatProc;
            if (process != null) {
                process.destroy();
                this.mLogcatProc = null;
            }
            BufferedReader bufferedReader = this.mReader;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    log("BufferedReader close Exception! " + e.getLocalizedMessage());
                }
                this.mReader = null;
            }
            BufferedWriter bufferedWriter = this.mWriter;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e2) {
                    log("BufferedWriter close Exception! " + e2.getLocalizedMessage());
                }
                this.mWriter = null;
            }
        }

        private void clearLogcat() {
            try {
                Process exec = Runtime.getRuntime().exec("logcat -c");
                if (exec != null) {
                    processWaitFor(exec);
                    exec.destroy();
                }
                log("Clear logcat success!");
            } catch (IOException e) {
                logE("Clear logcat exception! " + e.getLocalizedMessage());
            }
        }

        private boolean checkFileOverflow(int i) {
            File file;
            int i2 = this.mLogFileLimitation;
            if (i2 == 0) {
                return false;
            }
            long j = this.mCurrentFileSize + ((long) i);
            this.mCurrentFileSize = j;
            if (j < ((long) i2) && (file = this.mSaveFile) != null && file.exists()) {
                return false;
            }
            log("The size of the system log file currently being written has exceeded the limit , needs to be changed : " + this.mCurrentFileSize);
            this.mCurrentFileSize = 0;
            return true;
        }

        private void processWaitFor(Process process) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        System.out.println(readLine);
                    } else {
                        process.waitFor();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        private void log(String str) {
            OmniLog.d(OmniLog.RECORD_LOG_WATCH, LogRecorder.TAG, str);
        }

        private void logE(String str) {
            OmniLog.e(OmniLog.RECORD_LOG_WATCH, LogRecorder.TAG, str);
        }
    }
}
