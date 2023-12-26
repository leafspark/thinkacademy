package com.wushuangtech.audiocore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class AudioDataWriter {
    private static final String TAG = "AudioDataWriter";
    private final File mAudioRecordAfter3AFile;
    private FileOutputStream mAudioRecordAfter3AOutputFile;
    private final File mAudioRecordFile;
    private FileOutputStream mAudioRecordOutputFile;

    public AudioDataWriter(String str) {
        File file = new File(str, "recrod.pcm");
        this.mAudioRecordFile = file;
        this.mAudioRecordAfter3AFile = new File(str, "recrod_after_3a.pcm");
        try {
            this.mAudioRecordOutputFile = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.mAudioRecordAfter3AOutputFile = new FileOutputStream(this.mAudioRecordAfter3AFile);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void clearResource() {
        try {
            this.mAudioRecordFile.delete();
            this.mAudioRecordAfter3AFile.delete();
            FileOutputStream fileOutputStream = this.mAudioRecordOutputFile;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.mAudioRecordOutputFile = null;
            }
            FileOutputStream fileOutputStream2 = this.mAudioRecordAfter3AOutputFile;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
                this.mAudioRecordAfter3AOutputFile = null;
            }
        } catch (Exception unused) {
        }
    }

    public void writeAudioRecordDatas(byte[] bArr) {
        if (bArr != null && this.mAudioRecordOutputFile != null) {
            if (!this.mAudioRecordFile.exists() || this.mAudioRecordFile.length() <= 20971520) {
                try {
                    this.mAudioRecordOutputFile.write(bArr, 0, bArr.length);
                    this.mAudioRecordOutputFile.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void writeAudioRecordAfter3ADatas(byte[] bArr) {
        if (bArr != null && this.mAudioRecordAfter3AOutputFile != null) {
            if (!this.mAudioRecordAfter3AFile.exists() || this.mAudioRecordAfter3AFile.length() <= 20971520) {
                try {
                    this.mAudioRecordAfter3AOutputFile.write(bArr, 0, bArr.length);
                    this.mAudioRecordAfter3AOutputFile.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
