package com.wushuangtech.library.video;

import android.text.TextUtils;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class VideoDataWriter {
    private static final String TAG = "VideoDataWriter";
    private BufferedWriter mBufferedWriter;
    private String mDataSizeFilePath;
    private String mFilePath;
    private boolean mInited;
    private FileOutputStream mOutput;

    public VideoDataWriter() {
    }

    public VideoDataWriter(String str) {
        File externalFilesDir = GlobalHolder.getInstance().getContext().getExternalFilesDir((String) null);
        this.mFilePath = externalFilesDir + File.separator + str + ".h264";
        this.mDataSizeFilePath = externalFilesDir + File.separator + str + "_SIZE.txt";
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void initTest() {
        if (!this.mInited) {
            if (!TextUtils.isEmpty(this.mFilePath)) {
                try {
                    File file = new File(this.mFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    this.mOutput = new FileOutputStream(this.mFilePath, true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(this.mDataSizeFilePath)) {
                try {
                    File file2 = new File(this.mDataSizeFilePath);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    this.mBufferedWriter = new BufferedWriter(new FileWriter(this.mDataSizeFilePath));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            this.mInited = true;
        }
    }

    public void closeWrite() {
        FileOutputStream fileOutputStream = this.mOutput;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
                this.mOutput = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = this.mBufferedWriter;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
                this.mBufferedWriter = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        this.mInited = false;
    }

    public void writeVideoRawDatas(byte[] bArr, int i, int i2) {
        if (bArr != null && i != 0 && i2 != 0) {
            File file = new File(this.mFilePath);
            long j = 0;
            if (file.exists()) {
                j = file.length();
                if (j > 104857600) {
                    closeWrite();
                    return;
                }
            }
            OmniLog.i2(TAG, "totalSpace : " + j + " | " + bArr.length + " | " + i + " | " + i2);
            try {
                this.mOutput.write(bArr, 0, bArr.length);
                this.mOutput.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void writeVideoRawDatas(byte[] bArr, int i, int i2, int i3) {
        if (bArr != null) {
            File file = new File(this.mFilePath);
            long j = 0;
            if (file.exists()) {
                j = file.length();
                if (j > 52428800) {
                    closeWrite();
                    return;
                }
            }
            OmniLog.d(TAG, "totalSpace : " + j + " | " + bArr.length);
            try {
                FileOutputStream fileOutputStream = this.mOutput;
                if (fileOutputStream != null) {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    this.mOutput.flush();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            writeVideoRawDataLen(bArr.length, i, i2, i3);
        }
    }

    public void writeVideoRawDataLen(int i, int i2, int i3, int i4) {
        if (this.mBufferedWriter != null) {
            File file = new File(this.mDataSizeFilePath);
            long j = 0;
            if (file.exists()) {
                j = file.length();
                if (j > 52428800) {
                    closeWrite();
                    return;
                }
            }
            OmniLog.d(TAG, "totalSpace : " + j + " | " + i);
            try {
                BufferedWriter bufferedWriter = this.mBufferedWriter;
                bufferedWriter.write(String.valueOf(i) + "_" + i2 + "_" + i3 + "_" + i4);
                this.mBufferedWriter.newLine();
                this.mBufferedWriter.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
