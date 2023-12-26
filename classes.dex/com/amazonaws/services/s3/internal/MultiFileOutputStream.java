package com.amazonaws.services.s3.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.OnFileDelete;
import com.amazonaws.services.s3.UploadObjectObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class MultiFileOutputStream extends OutputStream implements OnFileDelete {
    private static final int DEFAULT_PART_SIZE = 5242880;
    private static final int PART_BYTE = 5;
    private static final int SHIFT_VALUE = 20;
    private boolean closed;
    private int currFileBytesWritten;
    private long diskLimit;
    private Semaphore diskPermits;
    private int filesCreated;
    private final String namePrefix;
    private UploadObjectObserver observer;
    private FileOutputStream os;
    private long partSize;
    private final File root;
    private long totalBytesWritten;

    public MultiFileOutputStream() {
        this.partSize = 5242880;
        this.diskLimit = Long.MAX_VALUE;
        this.root = new File(System.getProperty("java.io.tmpdir"));
        this.namePrefix = yyMMdd_hhmmss() + "." + UUID.randomUUID();
    }

    public MultiFileOutputStream(File file, String str) {
        this.partSize = 5242880;
        this.diskLimit = Long.MAX_VALUE;
        if (file == null || !file.isDirectory() || !file.canWrite()) {
            throw new IllegalArgumentException(file + " must be a writable directory");
        } else if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Please specify a non-empty name prefix");
        } else {
            this.root = file;
            this.namePrefix = str;
        }
    }

    public MultiFileOutputStream init(UploadObjectObserver uploadObjectObserver, long j, long j2) {
        Semaphore semaphore;
        if (uploadObjectObserver != null) {
            this.observer = uploadObjectObserver;
            if (j2 >= (j << 1)) {
                this.partSize = j;
                this.diskLimit = j2;
                int i = (int) (j2 / j);
                if (i < 0) {
                    semaphore = null;
                } else {
                    semaphore = new Semaphore(i);
                }
                this.diskPermits = semaphore;
                return this;
            }
            throw new IllegalArgumentException("Maximum temporary disk space must be at least twice as large as the part size: partSize=" + j + ", diskSize=" + j2);
        }
        throw new IllegalArgumentException("Observer must be specified");
    }

    public void write(int i) throws IOException {
        fos().write(i);
        this.currFileBytesWritten++;
        this.totalBytesWritten++;
    }

    public void write(byte[] bArr) throws IOException {
        if (bArr.length != 0) {
            fos().write(bArr);
            this.currFileBytesWritten += bArr.length;
            this.totalBytesWritten += (long) bArr.length;
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr.length != 0) {
            fos().write(bArr, i, i2);
            this.currFileBytesWritten += i2;
            this.totalBytesWritten += (long) i2;
        }
    }

    private FileOutputStream fos() throws IOException {
        if (!this.closed) {
            FileOutputStream fileOutputStream = this.os;
            if (fileOutputStream == null || ((long) this.currFileBytesWritten) >= this.partSize) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    this.observer.onPartCreate(new PartCreationEvent(getFile(this.filesCreated), this.filesCreated, false, this));
                }
                this.currFileBytesWritten = 0;
                this.filesCreated++;
                blockIfNecessary();
                File file = getFile(this.filesCreated);
                file.deleteOnExit();
                this.os = new FileOutputStream(file);
            }
            return this.os;
        }
        throw new IOException("Output stream is already closed");
    }

    public void onFileDelete(FileDeletionEvent fileDeletionEvent) {
        Semaphore semaphore = this.diskPermits;
        if (semaphore != null) {
            semaphore.release();
        }
    }

    private void blockIfNecessary() {
        Semaphore semaphore = this.diskPermits;
        if (semaphore != null && this.diskLimit != Long.MAX_VALUE) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new AbortedException((Throwable) e);
            }
        }
    }

    public void flush() throws IOException {
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            FileOutputStream fileOutputStream = this.os;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                File file = getFile(this.filesCreated);
                if (file.length() != 0) {
                    this.observer.onPartCreate(new PartCreationEvent(getFile(this.filesCreated), this.filesCreated, true, this));
                } else if (!file.delete()) {
                    Log log = LogFactory.getLog(getClass());
                    log.debug("Ignoring failure to delete empty file " + file);
                }
            }
        }
    }

    public void cleanup() {
        for (int i = 0; i < getNumFilesWritten(); i++) {
            File file = getFile(i);
            if (file.exists() && !file.delete()) {
                Log log = LogFactory.getLog(getClass());
                log.debug("Ignoring failure to delete file " + file);
            }
        }
    }

    public int getNumFilesWritten() {
        return this.filesCreated;
    }

    public File getFile(int i) {
        File file = this.root;
        return new File(file, this.namePrefix + "." + i);
    }

    public long getPartSize() {
        return this.partSize;
    }

    public File getRoot() {
        return this.root;
    }

    public String getNamePrefix() {
        return this.namePrefix;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    static String yyMMdd_hhmmss() {
        return new SimpleDateFormat("yyMMdd-hhmmss").format(new Date());
    }

    public boolean isClosed() {
        return this.closed;
    }

    public long getDiskLimit() {
        return this.diskLimit;
    }
}
