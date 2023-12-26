package com.wushuangtech.library.video;

import android.text.TextUtils;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VideoDataRender {
    private BufferedReader mBufferedReader;
    private final String mDataSizeFilePath;
    private FileInputStream mFileInputStream;
    private final String mFilePath;

    public static class VideoFrame {
        public byte[] data;
        public ExternalVideoModuleCallback.VideoFrameType frameType;
        public int height;
        public int width;
    }

    public VideoDataRender(String str, String str2) {
        this.mFilePath = str;
        this.mDataSizeFilePath = str2;
    }

    public void init() {
        if (this.mFileInputStream == null) {
            try {
                this.mFileInputStream = new FileInputStream(this.mFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (this.mBufferedReader == null) {
            try {
                this.mBufferedReader = new BufferedReader(new FileReader(this.mDataSizeFilePath));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void unInit() {
        FileInputStream fileInputStream = this.mFileInputStream;
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
                this.mFileInputStream = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedReader bufferedReader = this.mBufferedReader;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.mBufferedReader = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public VideoFrame readBytes() {
        String str;
        BufferedReader bufferedReader = this.mBufferedReader;
        if (bufferedReader == null) {
            return null;
        }
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            unInit();
            init();
            try {
                str = bufferedReader.readLine();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split("_");
        byte[] bArr = new byte[Integer.parseInt(split[0])];
        try {
            this.mFileInputStream.read(bArr);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        VideoFrame videoFrame = new VideoFrame();
        videoFrame.data = bArr;
        videoFrame.width = Integer.parseInt(split[1]);
        videoFrame.height = Integer.parseInt(split[2]);
        int parseInt = Integer.parseInt(split[3]);
        if (parseInt == 1) {
            videoFrame.frameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_SPS_PPS;
        } else if (parseInt == 2) {
            videoFrame.frameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I;
        } else if (parseInt == 3) {
            videoFrame.frameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P;
        }
        return videoFrame;
    }
}
