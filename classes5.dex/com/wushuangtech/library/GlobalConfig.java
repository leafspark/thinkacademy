package com.wushuangtech.library;

import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.utils.OmniLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalConfig {
    public static final String ENGINE_NAME = "Engine";
    public static final String GIT_BRANCH = "rc-xes-9.75";
    private static volatile int GbSlicedThreads = 0;
    public static final String LOCAL_SDK_VERSION_NAME = "3.6.140(2023_03_23)";
    public static final String LOG_VERSION = "1.6.1";
    public static final String SDK_VERSION_DATE = "(2023_03_23)";
    public static final String SDK_VERSION_NAME = "CoreRTC_Android_V3.6.140";
    public static final String SDK_VERSION_NUMBER = "3.6.140";
    public static final String SDK_VERSION_TEST_NUMBER = "rc-xes-9.75-3.6.140.3";
    public static final byte[] guid = {-120, -123, 111, -40, -37, -15, -116, 33, -77, -76, 83, 106, 54, -94, -42, -110};
    public static volatile String mAVUploadChannelName = "";
    public static float mAppCpuUsageRate;
    public static String mAppId;
    public static boolean mAppInBackground = false;
    public static volatile boolean mAudioEnabled = true;
    public static volatile boolean mAudioLocalEnabled = true;
    public static volatile boolean mAudioLocalStreamEnabled = true;
    public static int mBranch = LocalSDKConstants.BRANCH_CLIENT_NEW;
    public static String mChatReceivePath;
    public static String mChatSendPath;
    public static int mConnectState = 1;
    public static float mCpuAvgUseage;
    public static float mCpuMaxUseage;
    public static float mCpuUseage;
    public static int mCurrentChannelMode = 0;
    public static int mDefaultAudioRoute = 1;
    public static boolean mDefaultMuteAllRemoteAudioStreams;
    public static boolean mDefaultMuteAllRemoteVideoStreams;
    public static int mDualDefStream = 0;
    public static long mEnterRoomTime;
    public static boolean mErrorTest;
    public static boolean mExternalAudioSource;
    public static boolean mExternalVideoSource;
    public static boolean mExternalVideoSourceIsTexture;
    public static final String[] mFastCallBack = {"OnAudioLevelReport", "OnMixAudioLevelReport", "OnRecvAudioMsg", "OnNetTestQuality", "OnCheckNetQuality", "OnRemoteStreamSubscribeAdvice", "onStreamMessage", "onRemoteStreamSubscribeAdvice", "onRtcStats", "onRemoteAudioStats", "onRemoteVideoStats", "onNetworkQuality", "onGlobalAudioVolumeIndication", "onGlobalLocalAudioStats", "onGlobalLocalVideoStats", "onGlobalRemoteVideoStats", "onGlobalRemoteAudioStats", "onGlobalonRtcStats", "OnReportImageFireEvent"};
    public static boolean mForceVideoSoftDecoder = true;
    public static boolean mForceVideoSoftEncoder;
    public static boolean mIsA2DPHeadSet;
    public static boolean mIsAudioStartPlay;
    public static boolean mIsAuthAlwaysSuccess = false;
    public static boolean mIsCreateVideoMixer;
    public static AtomicBoolean mIsEnableAudioMixer = new AtomicBoolean(false);
    public static boolean mIsEnableVideoDualStream;
    public static AtomicBoolean mIsEnableVideoMixer = new AtomicBoolean(false);
    public static boolean mIsInPullRoom;
    public static AtomicBoolean mIsInRoom = new AtomicBoolean();
    public static AtomicBoolean mIsLogining = new AtomicBoolean();
    public static boolean mIsNeedSetRole;
    public static boolean mIsPureAudio;
    public static boolean mIsRequireChair;
    public static AtomicBoolean mIsScreenRecordShare = new AtomicBoolean(false);
    public static AtomicBoolean mIsScreenRecording = new AtomicBoolean(false);
    public static boolean mIsServerAuth = true;
    public static boolean mIsSpeakerphoneEnabled = true;
    public static boolean mIsSupportPBO;
    public static boolean mIsUnityMode;
    public static boolean mIsVoiceSDK = false;
    public static int mJpgQuality = 50;
    public static int mLocalAudioDataProcessAvgEffeciency;
    public static int mLocalAudioFocus;
    public static volatile long mLocalOwnerUid = 0;
    public static boolean mLocalRenderHorMirror = false;
    public static volatile int mLocalRole = 1;
    public static String mLocalRoomName;
    public static long mLocalUserID;
    public static boolean mLocalVideoHorMirrorEnabled = true;
    public static boolean mLocalVideoPreview = true;
    public static boolean mLocalVideoSentDataHorMirrorEnabled = false;
    public static boolean mLocalVideoVrtMirrorEnabled = false;
    public static volatile int mLogFilterLevel = 15;
    public static int mLogReportInterval;
    public static float mMemAvgUseage;
    public static float mMemMaxUseage;
    public static float mMemUseage;
    public static int mMixAudioDataProcessAvgEffeciency;
    public static int mNetTestSigLost;
    public static int mNetTestSigQuality;
    public static int mNetTestSigStrength;
    public static int mNetworkType;
    public static volatile int mRelayMode;
    public static int mRemoteAudioDataProcessAvgEffeciency;
    public static boolean mRemoteVideoHorMirrorEnabled = false;
    public static boolean mRemoteVideoImproveEnabled = true;
    public static int mRemoteVideoRenderMode = 1;
    public static boolean mRemoteVideoTransByBuffer = true;
    public static volatile boolean mScreenCastEnabled;
    public static int mServerAudioBitrate;
    public static String mServerIP;
    public static String mServerLogUrl = "";
    public static AtomicBoolean mServerPermissionSpeak = new AtomicBoolean(true);
    public static int mServerPort;
    public static int mServerTimout = 90;
    public static int mSpeakStatus = 1;
    private static int mTestVideoDeviceCloseSize;
    private static int mTestVideoDeviceOpenSize;
    public static boolean mUseCamera2Api;
    private static int mUserEnterSize;
    private static int mUserLeaveSize;
    public static boolean mVersaModuleEnabled;
    public static int mVideoCapStartCount;
    public static long mVideoCapStartTimestamp;
    public static int mVideoDecoderHardwareSize = 5;
    public static volatile boolean mVideoEnabled;
    public static boolean mVideoImproveEnabled = true;
    public static volatile boolean mVideoLocalEnabled = true;
    public static boolean mVideoLocalRawDataReplaced = false;
    public static volatile boolean mVideoLocalStreamEnabled = true;
    public static long mVideoMixerUserID = -100;
    public static boolean mVideoRemoteRenderTexture = false;
    public static int mWifiRSSI;

    public static void testUpdateUserSize(boolean z) {
        if (z) {
            mUserEnterSize++;
        } else {
            mUserLeaveSize++;
        }
        OmniLog.debugD(OmniLog.TEST_WATCH, "user join : " + mUserEnterSize + " | leave : " + mUserLeaveSize);
    }

    public static void testUpdateVideoDeviceOptSize(boolean z) {
        if (z) {
            mTestVideoDeviceOpenSize++;
        } else {
            mTestVideoDeviceCloseSize++;
        }
        OmniLog.debugD(OmniLog.TEST_WATCH, "open : " + mTestVideoDeviceOpenSize + " | close : " + mTestVideoDeviceCloseSize);
    }

    public static void resetEngineStats() {
        mIsInRoom.set(false);
        mLocalRoomName = "";
        mLocalUserID = 0;
        mEnterRoomTime = 0;
        mLocalRole = 1;
        mAudioLocalStreamEnabled = true;
        mVideoLocalStreamEnabled = true;
        mDefaultMuteAllRemoteAudioStreams = false;
        mDefaultMuteAllRemoteVideoStreams = false;
    }

    public static void resetGlobalConfig() {
        mLocalOwnerUid = 0;
        mIsPureAudio = false;
        mIsEnableVideoDualStream = false;
        mSpeakStatus = 1;
        mServerIP = "";
        mServerPort = 0;
        mConnectState = 1;
        mAudioLocalEnabled = true;
        mVideoLocalEnabled = true;
        mLocalVideoHorMirrorEnabled = true;
        mLocalVideoVrtMirrorEnabled = false;
        mLocalVideoSentDataHorMirrorEnabled = false;
        mRemoteVideoHorMirrorEnabled = false;
        mExternalVideoSource = false;
        mVideoLocalRawDataReplaced = false;
        mServerPermissionSpeak.set(true);
        mUserEnterSize = 0;
        mUserLeaveSize = 0;
        mTestVideoDeviceOpenSize = 0;
        mTestVideoDeviceCloseSize = 0;
        mJpgQuality = 50;
    }

    public static void setEncoderBSlicedThread(int i) {
        GbSlicedThreads = i;
    }

    public static int getEncoderBSlicedThread() {
        return GbSlicedThreads;
    }

    public static void setLocalRenderHorMirror(boolean z) {
        mLocalRenderHorMirror = z;
    }

    public static boolean getLocalRenderHorMirror() {
        return mLocalRenderHorMirror;
    }
}
