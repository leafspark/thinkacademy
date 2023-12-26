package com.eaydu.omni.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiskLogStrategy implements LogStrategy {
    private final Handler handler;
    private boolean isStop = false;

    public DiskLogStrategy(Handler handler2) {
        this.handler = (Handler) Utils.checkNotNull(handler2);
    }

    public void log(int i, String str, String str2) {
        Utils.checkNotNull(str2);
        if (!this.isStop) {
            Handler handler2 = this.handler;
            Message obtainMessage = handler2.obtainMessage(i, str2);
            if (!(handler2 instanceof Handler)) {
                handler2.sendMessage(obtainMessage);
            } else {
                AsynchronousInstrumentation.sendMessage(handler2, obtainMessage);
            }
        }
    }

    public void stop() {
        this.isStop = true;
        Handler handler2 = this.handler;
        Message obtainMessage = handler2.obtainMessage(-1, "");
        if (!(handler2 instanceof Handler)) {
            handler2.sendMessage(obtainMessage);
        } else {
            AsynchronousInstrumentation.sendMessage(handler2, obtainMessage);
        }
    }

    public static class WriteHandler extends Handler {
        private final String fileName = "corertclog";
        private final String folder;
        private FileWriter mFileWriter = null;
        private File mLogFile = null;
        private final int maxFileCount;
        private final int maxFileSize;
        private final String suffix = ".log";

        public WriteHandler(Looper looper, String str, int i, int i2) {
            super((Looper) Utils.checkNotNull(looper));
            this.folder = (String) Utils.checkNotNull(str);
            this.maxFileSize = i;
            this.maxFileCount = i2;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerMessageBegin(r6, r7)
                java.lang.Object r0 = r7.obj
                java.lang.String r0 = (java.lang.String) r0
                int r7 = r7.what
                r1 = -1
                if (r7 != r1) goto L_0x000f
                r6.closeLogFile()
            L_0x000f:
                java.io.File r7 = r6.mLogFile     // Catch:{  }
                r1 = 1
                if (r7 != 0) goto L_0x002c
                java.io.File r7 = new java.io.File     // Catch:{  }
                java.lang.String r2 = r6.folder     // Catch:{  }
                java.lang.String r3 = r6.fileName     // Catch:{  }
                java.lang.String r3 = r6.getLogFileName(r3, r1)     // Catch:{  }
                r7.<init>(r2, r3)     // Catch:{  }
                r6.mLogFile = r7     // Catch:{  }
                java.io.FileWriter r7 = new java.io.FileWriter     // Catch:{  }
                java.io.File r2 = r6.mLogFile     // Catch:{  }
                r7.<init>(r2, r1)     // Catch:{  }
                r6.mFileWriter = r7     // Catch:{  }
            L_0x002c:
                java.io.File r7 = r6.mLogFile     // Catch:{  }
                boolean r7 = r7.exists()     // Catch:{  }
                if (r7 == 0) goto L_0x0054
                java.io.File r7 = r6.mLogFile     // Catch:{  }
                long r2 = r7.length()     // Catch:{  }
                int r7 = r6.maxFileSize     // Catch:{  }
                long r4 = (long) r7     // Catch:{  }
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 <= 0) goto L_0x0054
                java.lang.String r7 = r6.folder     // Catch:{  }
                java.lang.String r2 = r6.fileName     // Catch:{  }
                java.io.File r7 = r6.getNextLogFile(r7, r2)     // Catch:{  }
                r6.mLogFile = r7     // Catch:{  }
                java.io.FileWriter r7 = new java.io.FileWriter     // Catch:{  }
                java.io.File r2 = r6.mLogFile     // Catch:{  }
                r7.<init>(r2, r1)     // Catch:{  }
                r6.mFileWriter = r7     // Catch:{  }
            L_0x0054:
                java.io.FileWriter r7 = r6.mFileWriter     // Catch:{ Exception -> 0x0059 }
                r6.writeLog(r7, r0)     // Catch:{ Exception -> 0x0059 }
            L_0x0059:
                com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerMessageEnd()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.logger.DiskLogStrategy.WriteHandler.handleMessage(android.os.Message):void");
        }

        private void writeLog(FileWriter fileWriter, String str) throws IOException {
            Utils.checkNotNull(fileWriter);
            Utils.checkNotNull(str);
            this.mFileWriter.append(str);
            this.mFileWriter.flush();
        }

        public void closeLogFile() {
            try {
                FileWriter fileWriter = this.mFileWriter;
                if (fileWriter != null) {
                    fileWriter.flush();
                    this.mFileWriter.close();
                    this.mFileWriter = null;
                }
            } catch (IOException unused) {
            }
        }

        private boolean checkFile(String str) {
            return new File(this.folder, str).exists();
        }

        private File getNextLogFile(String str, String str2) {
            closeLogFile();
            for (int i = this.maxFileCount; i > 1; i--) {
                String logFileName = getLogFileName(str2, i - 1);
                String logFileName2 = getLogFileName(str2, i);
                if (checkFile(logFileName)) {
                    new File(str, logFileName).renameTo(new File(str, logFileName2));
                }
            }
            return new File(str, getLogFileName(str2, 1));
        }

        private String getLogFileName(String str, int i) {
            return str + "_" + i + this.suffix;
        }
    }
}
