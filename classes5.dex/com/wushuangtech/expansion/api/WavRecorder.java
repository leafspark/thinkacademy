package com.wushuangtech.expansion.api;

import android.media.AudioRecord;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WavRecorder {
    private static final int AUDIO_CHANNEL = 16;
    private static final int AUDIO_ENCODING = 2;
    private static final int AUDIO_INPUT = 1;
    private static final int AUDIO_SAMPLE_RATE = 16000;
    private AudioRecord audioRecord;
    private int bufferSizeInBytes = 0;
    private String fileName;
    private String mPcmPath;
    private String mWavPath;
    private Status status = Status.STATUS_NO_READY;

    public enum Status {
        STATUS_NO_READY,
        STATUS_READY,
        STATUS_START,
        STATUS_STOP
    }

    public void createDefaultAudio(String str) {
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            this.audioRecord = null;
        }
        this.bufferSizeInBytes = AudioRecord.getMinBufferSize(16000, 16, 2);
        AudioRecord audioRecord3 = new AudioRecord(1, 16000, 16, 2, this.bufferSizeInBytes);
        this.audioRecord = audioRecord3;
        if (audioRecord3.getState() == 1) {
            this.fileName = str;
            this.status = Status.STATUS_READY;
            this.mPcmPath = GlobalConfig.mChatSendPath + "pcm" + File.separator;
            File file = new File(this.mPcmPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mPcmPath += str + ".pcm";
            this.mWavPath = GlobalConfig.mChatSendPath;
            this.mWavPath += str + ".wav";
            return;
        }
        throw new IllegalStateException("Failed to create a new AudioRecord instance~");
    }

    public String getWavPath() {
        return this.mWavPath;
    }

    public Status getStatus() {
        return this.status;
    }

    public void startRecord() {
        if (this.status == Status.STATUS_NO_READY || TextUtils.isEmpty(this.fileName)) {
            throw new IllegalStateException("录音尚未初始化~");
        } else if (this.status != Status.STATUS_START) {
            this.audioRecord.startRecording();
            OmniLog.d("AudioRecorder", "WavRecorder try startRecording : " + this.audioRecord.getState());
            int i = 0;
            while (this.audioRecord.getRecordingState() != 3 && (i = i + 1) < 2) {
                OmniLog.d("AudioRecorder", "WavRecorder numberOfStateChecks : " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    OmniLog.e("AudioRecorder", "WavRecorder Thread.sleep failed: " + e.getMessage());
                }
            }
            if (this.audioRecord.getRecordingState() == 3) {
                this.status = Status.STATUS_START;
                OmniLog.d("AudioRecorder", "WavRecorder real startRecord successfully !...");
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        WavRecorder.this.writeDataTOFile();
                    }
                });
                if (!(thread instanceof Thread)) {
                    thread.start();
                } else {
                    AsynchronousInstrumentation.threadStart(thread);
                }
            } else {
                throw new IllegalStateException("开始录音失败 , state : " + this.audioRecord.getRecordingState());
            }
        } else {
            throw new IllegalStateException("正在录音");
        }
    }

    public void stopRecord() {
        OmniLog.d("AudioRecorder", "WavRecorder real stopRecord successfully!... status : " + this.status);
        if (this.status == Status.STATUS_START) {
            this.audioRecord.stop();
            this.status = Status.STATUS_STOP;
            release();
        }
    }

    public void release() {
        OmniLog.d("AudioRecorder", "===release===");
        try {
            makePCMFileToWAVFile(this.mPcmPath, this.mWavPath, true);
            AudioRecord audioRecord2 = this.audioRecord;
            if (audioRecord2 != null) {
                audioRecord2.release();
                this.audioRecord = null;
            }
            this.status = Status.STATUS_NO_READY;
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void canel() {
        this.fileName = null;
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            this.audioRecord = null;
        }
        this.status = Status.STATUS_NO_READY;
    }

    /* access modifiers changed from: private */
    public void writeDataTOFile() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.bufferSizeInBytes];
        try {
            File file = new File(this.mPcmPath);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (IllegalStateException e) {
            OmniLog.e("AudioRecorder", e.getMessage());
            throw new IllegalStateException(e.getMessage());
        } catch (FileNotFoundException e2) {
            OmniLog.e("AudioRecorder", e2.getMessage());
            fileOutputStream = null;
        }
        while (this.status == Status.STATUS_START) {
            if (this.audioRecord.read(bArr, 0, this.bufferSizeInBytes) > 0 && fileOutputStream != null) {
                try {
                    fileOutputStream.write(bArr);
                } catch (IOException e3) {
                    OmniLog.e("AudioRecorder", e3.getMessage());
                }
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
                OmniLog.e("AudioRecorder", e4.getMessage());
            }
        }
    }

    public static boolean makePCMFileToWAVFile(String str, String str2, boolean z) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        int length = (int) file.length();
        WaveHeader waveHeader = new WaveHeader();
        waveHeader.fileLength = length + 36;
        waveHeader.FmtHdrLeth = 16;
        waveHeader.BitsPerSample = 16;
        waveHeader.Channels = 1;
        waveHeader.FormatTag = 1;
        waveHeader.SamplesPerSec = 16000;
        waveHeader.BlockAlign = (short) ((waveHeader.Channels * waveHeader.BitsPerSample) / 8);
        waveHeader.AvgBytesPerSec = waveHeader.BlockAlign * waveHeader.SamplesPerSec;
        waveHeader.DataHdrLeth = length;
        try {
            byte[] header = waveHeader.getHeader();
            if (header.length != 44) {
                OmniLog.e("AudioRecorder", "makePCMFileToWAVFile failed , length not 44!");
                return false;
            }
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                byte[] bArr = new byte[4096];
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                bufferedOutputStream.write(header, 0, header.length);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr);
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                if (z) {
                    file.delete();
                }
                OmniLog.i("AudioRecorder", "makePCMFileToWAVFile  success!" + new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
                return true;
            } catch (FileNotFoundException e) {
                OmniLog.e("AudioRecorder", "makePCMFileToWAVFile FileNotFoundException : " + e.getMessage());
                return false;
            } catch (IOException e2) {
                OmniLog.e("AudioRecorder", "makePCMFileToWAVFile IOException : " + e2.getMessage());
                return false;
            }
        } catch (IOException e3) {
            OmniLog.e("AudioRecorder", "makePCMFileToWAVFile getHeader IOException : " + e3.getMessage());
            return false;
        }
    }
}
