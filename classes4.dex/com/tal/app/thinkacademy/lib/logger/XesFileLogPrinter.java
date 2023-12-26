package com.tal.app.thinkacademy.lib.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class XesFileLogPrinter implements XesLogPrinter {
    /* access modifiers changed from: private */
    public static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
    private static XesFileLogPrinter instance;
    /* access modifiers changed from: private */
    public final String logPath;
    private final long retentionTime;
    private volatile PrintWorker worker = new PrintWorker();
    private LogWriter writer = new LogWriter();

    public static synchronized XesFileLogPrinter getInstance(String str, long j) {
        XesFileLogPrinter xesFileLogPrinter;
        synchronized (XesFileLogPrinter.class) {
            if (instance == null) {
                instance = new XesFileLogPrinter(str, j);
            }
            xesFileLogPrinter = instance;
        }
        return xesFileLogPrinter;
    }

    private XesFileLogPrinter(String str, long j) {
        this.logPath = str;
        this.retentionTime = j;
        cleanExpiredLog();
    }

    /* access modifiers changed from: private */
    public void doPrint(XesLogMo xesLogMo) {
        if (this.writer.getPreFileName() == null) {
            String genFileName = genFileName();
            if (this.writer.isReady()) {
                this.writer.close();
            }
            if (!this.writer.ready(genFileName)) {
                return;
            }
        }
        this.writer.append(xesLogMo.flattenedLog());
    }

    private String genFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    private void cleanExpiredLog() {
        if (this.retentionTime > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            File[] listFiles = new File(this.logPath).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (currentTimeMillis - file.lastModified() > this.retentionTime) {
                        file.delete();
                    }
                }
            }
        }
    }

    public void print(XesLogConfig xesLogConfig, int i, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.worker.isRunning()) {
            this.worker.start();
        }
        this.worker.put(new XesLogMo(currentTimeMillis, i, str, "", "", "", "", "", str2));
    }

    private class PrintWorker implements Runnable {
        private BlockingQueue<XesLogMo> logs;
        private volatile boolean running;

        private PrintWorker() {
            this.logs = new LinkedBlockingQueue();
        }

        /* access modifiers changed from: package-private */
        public void put(XesLogMo xesLogMo) {
            try {
                this.logs.put(xesLogMo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isRunning() {
            boolean z;
            synchronized (this) {
                z = this.running;
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            synchronized (this) {
                XesFileLogPrinter.EXECUTOR.execute(this);
                this.running = true;
            }
        }

        public void run() {
            while (true) {
                try {
                    XesFileLogPrinter.this.doPrint(this.logs.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    synchronized (this) {
                        this.running = false;
                        return;
                    }
                }
            }
        }
    }

    private class LogWriter {
        private BufferedWriter bufferedWriter;
        private File logFile;
        private String preFileName;

        private LogWriter() {
        }

        /* access modifiers changed from: package-private */
        public boolean isReady() {
            return this.bufferedWriter != null;
        }

        /* access modifiers changed from: package-private */
        public String getPreFileName() {
            return this.preFileName;
        }

        /* access modifiers changed from: package-private */
        public boolean ready(String str) {
            this.preFileName = str;
            File file = new File(XesFileLogPrinter.this.logPath, str);
            this.logFile = file;
            if (!file.exists()) {
                try {
                    File parentFile = this.logFile.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    this.logFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.preFileName = null;
                    this.logFile = null;
                    return false;
                }
            }
            try {
                this.bufferedWriter = new BufferedWriter(new FileWriter(this.logFile, true));
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                this.preFileName = null;
                this.logFile = null;
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean close() {
            BufferedWriter bufferedWriter2 = this.bufferedWriter;
            if (bufferedWriter2 == null) {
                return true;
            }
            try {
                bufferedWriter2.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                this.bufferedWriter = null;
                this.preFileName = null;
                this.logFile = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void append(String str) {
            try {
                this.bufferedWriter.write(str);
                this.bufferedWriter.newLine();
                this.bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
