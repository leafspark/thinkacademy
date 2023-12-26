package com.wushuangtech.myvideoimprove.codec.encoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import com.wushuangtech.utils.OmniLog;
import java.util.Arrays;

public class HardwareEncoderExplore {
    private static final String ENCODER_TYPE = "video/avc";
    private static final String TAG = "HardwareEncoderExplore";
    private MediaCodecInfo mMediaCodecInfo;
    private String mMimeType;

    public HardwareEncoderExplore(String str, MediaCodecInfo mediaCodecInfo) {
        this.mMimeType = str;
        this.mMediaCodecInfo = mediaCodecInfo;
    }

    public void watchVideoEncodeMediaCodecInfo() {
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mMediaCodecInfo.getCapabilitiesForType(this.mMimeType);
            String str = TAG;
            Log.d(str, "CodecCapabilities -> colorFormats : " + Arrays.toString(capabilitiesForType.colorFormats));
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
            int length = codecProfileLevelArr.length;
            for (int i = 0; i < length; i++) {
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i];
                String str2 = TAG;
                Log.d(str2, "CodecCapabilities -> CodecProfileLevel -> CodecProfileLevel level : " + codecProfileLevel.profile + " | " + codecProfileLevel.level);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                MediaFormat defaultFormat = capabilitiesForType.getDefaultFormat();
                String str3 = TAG;
                Log.d(str3, "CodecCapabilities -> getDefaultFormat : " + defaultFormat.toString());
            }
            if (Build.VERSION.SDK_INT >= 28) {
                int maxSupportedInstances = capabilitiesForType.getMaxSupportedInstances();
                String str4 = TAG;
                Log.d(str4, "CodecCapabilities -> getMaxSupportedInstances : " + maxSupportedInstances);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                boolean isBitrateModeSupported = encoderCapabilities.isBitrateModeSupported(0);
                boolean isBitrateModeSupported2 = encoderCapabilities.isBitrateModeSupported(2);
                boolean isBitrateModeSupported3 = encoderCapabilities.isBitrateModeSupported(1);
                String str5 = TAG;
                Log.d(str5, "CodecCapabilities -> EncoderCapabilities -> Bitrate mode support, CQ : " + isBitrateModeSupported + " | CBR : " + isBitrateModeSupported2 + " | VBR : " + isBitrateModeSupported3);
                Range<Integer> complexityRange = encoderCapabilities.getComplexityRange();
                StringBuilder sb = new StringBuilder();
                sb.append("CodecCapabilities -> EncoderCapabilities -> getComplexityRange : ");
                sb.append(complexityRange.toString());
                Log.d(str5, sb.toString());
                if (Build.VERSION.SDK_INT >= 28) {
                    Range<Integer> qualityRange = encoderCapabilities.getQualityRange();
                    Log.d(str5, "CodecCapabilities -> EncoderCapabilities -> getQualityRange : " + qualityRange.toString());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
                String str6 = TAG;
                Log.d(str6, "CodecCapabilities -> VideoCapabilities -> getBitrateRange : " + bitrateRange);
                int widthAlignment = videoCapabilities.getWidthAlignment();
                Log.d(str6, "CodecCapabilities -> VideoCapabilities -> getWidthAlignment : " + widthAlignment);
                int heightAlignment = videoCapabilities.getHeightAlignment();
                Log.d(str6, "CodecCapabilities -> VideoCapabilities -> getHeightAlignment : " + heightAlignment);
                Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                Log.d(str6, "CodecCapabilities -> VideoCapabilities -> getSupportedFrameRates : " + supportedFrameRates.toString());
                Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                Log.d(str6, "CodecCapabilities -> VideoCapabilities -> getSupportedWidths : " + supportedWidths.toString());
                Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                Log.d(str6, "CodecCapabilities -> VideoCapabilities -> getSupportedHeights : " + supportedHeights.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void watchMediaCodecInfo() {
        MediaCodecInfo chooseVideoEncoderInfo = chooseVideoEncoderInfo();
        if (chooseVideoEncoderInfo != null) {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = chooseVideoEncoderInfo.getCapabilitiesForType(ENCODER_TYPE);
            Log.d(TAG, "CodecCapabilities -> colorFormats : " + Arrays.toString(capabilitiesForType.colorFormats));
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                Log.d(TAG, "CodecCapabilities -> CodecProfileLevel -> CodecProfileLevel level : " + codecProfileLevel.profile + " | " + codecProfileLevel.level);
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = capabilitiesForType.getAudioCapabilities();
            if (audioCapabilities != null) {
                Range<Integer> bitrateRange = audioCapabilities.getBitrateRange();
                String str = TAG;
                Log.d(str, "CodecCapabilities -> AudioCapabilities getBitrateRange : " + bitrateRange.toString());
                Log.d(str, "CodecCapabilities -> AudioCapabilities getMaxInputChannelCount : " + audioCapabilities.getMaxInputChannelCount());
                Range[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
                Log.d(str, "CodecCapabilities -> AudioCapabilities getSupportedSampleRateRanges : " + Arrays.toString(supportedSampleRateRanges));
                int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
                Log.d(str, "CodecCapabilities -> AudioCapabilities getSupportedSampleRates : " + Arrays.toString(supportedSampleRates));
            }
            MediaFormat defaultFormat = capabilitiesForType.getDefaultFormat();
            String str2 = TAG;
            Log.d(str2, "CodecCapabilities -> getDefaultFormat : " + defaultFormat.toString());
            MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            Range<Integer> complexityRange = encoderCapabilities.getComplexityRange();
            Log.d(str2, "CodecCapabilities -> EncoderCapabilities -> getComplexityRange : " + complexityRange.toString());
            Range<Integer> qualityRange = encoderCapabilities.getQualityRange();
            Log.d(str2, "CodecCapabilities -> EncoderCapabilities -> getQualityRange : " + qualityRange.toString());
            Log.d(str2, "CodecCapabilities -> getMaxSupportedInstances : " + capabilitiesForType.getMaxSupportedInstances());
            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
            Log.d(str2, "CodecCapabilities -> VideoCapabilities -> getBitrateRange : " + videoCapabilities.getBitrateRange());
            Log.d(str2, "CodecCapabilities -> VideoCapabilities -> getWidthAlignment : " + videoCapabilities.getWidthAlignment());
            Log.d(str2, "CodecCapabilities -> VideoCapabilities -> getHeightAlignment : " + videoCapabilities.getHeightAlignment());
            Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
            Log.d(str2, "CodecCapabilities -> VideoCapabilities -> getSupportedFrameRates : " + supportedFrameRates.toString());
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Log.d(str2, "CodecCapabilities -> VideoCapabilities -> getSupportedWidths : " + supportedWidths.toString());
            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
            Log.d(str2, "CodecCapabilities -> VideoCapabilities -> getSupportedHeights : " + supportedHeights.toString());
        }
    }

    public void watchMediaFormat(MediaFormat mediaFormat) {
        String string = mediaFormat.getString("mime");
        String str = TAG;
        Log.d(str, "KEY_MIME :" + string);
        int integer = mediaFormat.getInteger("color-format");
        Log.d(str, "KEY_COLOR_FORMAT :" + integer);
        int integer2 = mediaFormat.getInteger("bitrate");
        Log.d(str, "KEY_BIT_RATE :" + integer2);
        int integer3 = mediaFormat.getInteger("frame-rate");
        Log.d(str, "KEY_FRAME_RATE :" + integer3);
        int integer4 = mediaFormat.getInteger("i-frame-interval");
        Log.d(str, "KEY_I_FRAME_INTERVAL :" + integer4);
        int integer5 = mediaFormat.getInteger("bitrate-mode");
        Log.d(str, "KEY_BITRATE_MODE :" + integer5);
        int integer6 = mediaFormat.getInteger("profile");
        Log.d(str, "KEY_PROFILE :" + integer6);
        int integer7 = mediaFormat.getInteger("level");
        Log.d(str, "KEY_LEVEL :" + integer7);
        int integer8 = mediaFormat.getInteger("max-input-size");
        Log.d(str, "KEY_MAX_INPUT_SIZE :" + integer8);
        int integer9 = mediaFormat.getInteger("capture-rate");
        Log.d(str, "KEY_CAPTURE_RATE :" + integer9);
        int integer10 = mediaFormat.getInteger("intra-refresh-period");
        Log.d(str, "KEY_INTRA_REFRESH_PERIOD :" + integer10);
        int integer11 = mediaFormat.getInteger("latency");
        Log.d(str, "KEY_LATENCY :" + integer11);
        int integer12 = mediaFormat.getInteger("repeat-previous-frame-after");
        Log.d(str, "KEY_REPEAT_PREVIOUS_FRAME_AFTER :" + integer12);
        int integer13 = mediaFormat.getInteger("ts-schema");
        Log.d(str, "KEY_TEMPORAL_LAYERING :" + integer13);
    }

    private MediaCodecInfo chooseVideoEncoderInfo() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    OmniLog.d(TAG, String.format("vencoder support %s types: %s", new Object[]{codecInfoAt.getName(), str}));
                    if (str.equalsIgnoreCase(ENCODER_TYPE)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
