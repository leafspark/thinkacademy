package com.wushuangtech.wstechapi.internal;

import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import com.wushuangtech.api.RtcChannelAVManager;
import com.wushuangtech.api.RtcChannelHandler;
import com.wushuangtech.api.RtcChannelHandlerImpl;
import com.wushuangtech.bean.RtcChannelMediaOptions;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.inter.OnRtcChannelHandlerEventCallBack;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcBaseChannel;
import com.wushuangtech.wstechapi.OmniRtcChannel;
import com.wushuangtech.wstechapi.OmniRtcEngine;
import com.wushuangtech.wstechapi.bean.ChannelMediaOptions;
import com.wushuangtech.wstechapi.inter.OmniInterSyncHelper;
import java.util.Arrays;

class OnRtcChannelImpl extends OmniRtcBaseChannel implements OmniRtcChannel, OnRtcChannelHandlerEventCallBack {
    private boolean mIsReport;
    /* access modifiers changed from: private */
    public final RtcChannelHandler mRtcChannelHandler;

    public int createDataStream(boolean z, boolean z2) {
        return 0;
    }

    public int getConnectionState() {
        return 0;
    }

    public int publish() {
        return 0;
    }

    public int removeInjectStreamUrl(String str) {
        return 0;
    }

    public int sendStreamMessage(int i, byte[] bArr) {
        return 0;
    }

    public int setRemoteDefaultVideoStreamType(int i) {
        return 0;
    }

    public int setRemoteUserPriority(int i, int i2) {
        return 0;
    }

    public int setRemoteVoicePosition(int i, double d, double d2) {
        return 0;
    }

    public int setRemoteVolumeAll(int i) {
        return 0;
    }

    public int unpublish() {
        return 0;
    }

    public OnRtcChannelImpl(String str, boolean z) {
        this(str, z, (RtcChannelAVManager) null);
    }

    public OnRtcChannelImpl(String str, boolean z, RtcChannelAVManager rtcChannelAVManager) {
        super(str, z);
        this.mIsReport = true;
        GlobalHolder.getInstance().initChannelInterInvokeReporter(str);
        this.mRtcChannelHandler = new RtcChannelHandlerImpl(this.TAG, str, rtcChannelAVManager, this);
    }

    public void setReport(boolean z) {
        this.mIsReport = z;
    }

    public int destroy() {
        OmniRtcEngineImpl omniRtcEngineImpl = (OmniRtcEngineImpl) OmniRtcEngine.getInstance();
        if (omniRtcEngineImpl == null) {
            String str = this.TAG;
            OmniLog.e(str, "destroy failed! OmniRtcEngine is null! " + this.mChannelName);
            return -6;
        }
        omniRtcEngineImpl.removeChannel(this.mChannelName);
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(3, str, new Object[0]);
                if (OnRtcChannelImpl.this.mRtcChannelEventDispatcher != null) {
                    OnRtcChannelImpl.this.mRtcChannelEventDispatcher.clearResource();
                    OmniRtcChannelEventDispatcher unused = OnRtcChannelImpl.this.mRtcChannelEventDispatcher = null;
                }
                return Integer.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.destroy());
            }
        })).intValue();
    }

    public String channelId() {
        return this.mRtcChannelHandler.channelName();
    }

    public String getChannelSessionId() {
        return (String) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return OnRtcChannelImpl.this.mRtcChannelHandler.getChannelSessionId();
            }
        });
    }

    public int joinChannel(String str, long j, ChannelMediaOptions channelMediaOptions) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str2 = invokedMethodName;
        final String str3 = str;
        final long j2 = j;
        final ChannelMediaOptions channelMediaOptions2 = channelMediaOptions;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "token : " + str + " optionalUid : " + j, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                RtcChannelMediaOptions rtcChannelMediaOptions;
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(str2, str3, Long.valueOf(j2));
                if (channelMediaOptions2 != null) {
                    rtcChannelMediaOptions = new RtcChannelMediaOptions();
                    rtcChannelMediaOptions.autoSubscribeAudio = channelMediaOptions2.autoSubscribeAudio;
                    rtcChannelMediaOptions.autoSubscribeVideo = channelMediaOptions2.autoSubscribeVideo;
                } else {
                    rtcChannelMediaOptions = null;
                }
                return OnRtcChannelImpl.this.mRtcChannelHandler.joinChannel(str3, j2, rtcChannelMediaOptions, OnRtcChannelImpl.this.mDefaultChannel);
            }
        });
    }

    public int leaveChannel() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(3, invokedMethodName, new Object[0]);
                return OnRtcChannelImpl.this.mRtcChannelHandler.leaveChannel();
            }
        });
    }

    public int renewToken(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "token : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, str);
                return OnRtcChannelImpl.this.mRtcChannelHandler.renewToken(str);
            }
        });
    }

    public int setClientRole(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "role : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i));
                int i = i;
                if (i == 1 || i == 2) {
                    return OnRtcChannelImpl.this.mRtcChannelHandler.setClientRole(i);
                }
                return -5;
            }
        });
    }

    public int setRemoteRenderMode(long j, int i, int i2) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | renderMode : " + i + " | mirrorMode : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(str, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4));
                return OnRtcChannelImpl.this.mRtcChannelHandler.setRemoteRenderMode(j2, i3, i4);
            }
        });
    }

    public int setRemoteRenderMode(final int i, final int i2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "renderMode : " + i + " | mirrorMode : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(i2));
                return OnRtcChannelImpl.this.mRtcChannelHandler.setRemoteRenderMode(-200, i, i2);
            }
        });
    }

    public int muteAllRemoteAudioStreams(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                return OnRtcChannelImpl.this.mRtcChannelHandler.muteAllRemoteAudioStreams(z);
            }
        });
    }

    public int adjustUserPlaybackSignalVolume(final long j, final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | volume : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                return OnRtcChannelImpl.this.mRtcChannelHandler.adjustUserPlaybackSignalVolume(j, i);
            }
        });
    }

    public int muteRemoteAudioStream(long j, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final boolean z2 = z;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(str, Long.valueOf(j2), Boolean.valueOf(z2));
                return OnRtcChannelImpl.this.mRtcChannelHandler.muteRemoteAudioStream(j2, z2);
            }
        });
    }

    public int muteAllRemoteVideoStreams(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                return OnRtcChannelImpl.this.mRtcChannelHandler.muteAllRemoteVideoStreams(z);
            }
        });
    }

    public int muteRemoteVideoStream(long j, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final boolean z2 = z;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(str, Long.valueOf(j2), Boolean.valueOf(z2));
                return OnRtcChannelImpl.this.mRtcChannelHandler.muteRemoteVideoStream(j2, z2);
            }
        });
    }

    public int setRemoteVideoStreamType(long j, int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final int i2 = i;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | streamType : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(str, Long.valueOf(j2), Integer.valueOf(i2));
                return OnRtcChannelImpl.this.mRtcChannelHandler.setRemoteVideoStreamType(j2, i2);
            }
        });
    }

    public int addPublishStreamUrl(final String str, final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "url : " + str + " | transcodingEnabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int addPublishStreamUrl = OnRtcChannelImpl.this.mRtcChannelHandler.addPublishStreamUrl(str, z);
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(addPublishStreamUrl));
                return addPublishStreamUrl;
            }
        });
    }

    public int removePublishStreamUrl(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "url : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int removePublishStreamUrl = OnRtcChannelImpl.this.mRtcChannelHandler.removePublishStreamUrl(str);
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(removePublishStreamUrl));
                return removePublishStreamUrl;
            }
        });
    }

    public int startChannelMediaRelay(final ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("config : ");
        sb.append(channelMediaRelayConfiguration == null ? "null" : channelMediaRelayConfiguration.toString());
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int startChannelMediaRelay = OnRtcChannelImpl.this.mRtcChannelHandler.startChannelMediaRelay(channelMediaRelayConfiguration);
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(startChannelMediaRelay));
                return startChannelMediaRelay;
            }
        });
    }

    public int stopChannelMediaRelay() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                int stopChannelMediaRelay = OnRtcChannelImpl.this.mRtcChannelHandler.stopChannelMediaRelay();
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(stopChannelMediaRelay));
                return stopChannelMediaRelay;
            }
        });
    }

    public int updateChannelMediaRelay(final ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("config : ");
        sb.append(channelMediaRelayConfiguration == null ? "null" : channelMediaRelayConfiguration.toString());
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int startChannelMediaRelay = OnRtcChannelImpl.this.mRtcChannelHandler.startChannelMediaRelay(channelMediaRelayConfiguration);
                OnRtcChannelImpl.this.mOmniInterSyncHelperImpl.buildReportLogAndSend(invokedMethodName, Integer.valueOf(startChannelMediaRelay));
                return startChannelMediaRelay;
            }
        });
    }

    public int muteLocalAudioStream(final boolean z) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.muteLocalAudioStream(z));
            }
        })).intValue();
    }

    public int muteLocalVideoStream(final boolean z) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.muteLocalVideoStream(z));
            }
        })).intValue();
    }

    public int setDefaultMuteAllRemoteAudioStreams(final boolean z) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.setDefaultMuteAllRemoteAudioStreams(z));
            }
        })).intValue();
    }

    public int setDefaultMuteAllRemoteVideoStreams(final boolean z) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.setDefaultMuteAllRemoteVideoStreams(z));
            }
        })).intValue();
    }

    public long getUid() {
        return ((Long) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Long.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.getUserId());
            }
        })).longValue();
    }

    public int getRole() {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.getRole());
            }
        })).intValue();
    }

    public boolean isJoinedChannel() {
        return ((Boolean) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Boolean.valueOf(OnRtcChannelImpl.this.mRtcChannelHandler.isJoinedChannel());
            }
        })).booleanValue();
    }

    public void onChannelError(int i) {
        sendCallBack(2, Integer.valueOf(i));
    }

    public void onJoinChannelSuccess(long j, int i) {
        sendCallBack(1, Long.valueOf(j), Integer.valueOf(i));
    }

    public void onRejoinChannelSuccess(long j, int i) {
        sendCallBack(14, Long.valueOf(j), Integer.valueOf(i));
    }

    public void onLeaveChannel(RtcStats rtcStats) {
        sendCallBack(3, rtcStats);
    }

    public void onTokenPrivilegeWillExpire(String str) {
        sendCallBack(10, str);
    }

    public void onRequestToken() {
        sendCallBack(11, new Object[0]);
    }

    public void onUserJoined(long j, int i) {
        sendCallBack(4, Long.valueOf(j), Integer.valueOf(i));
    }

    public void onUserOffline(long j, int i) {
        sendCallBack(5, Long.valueOf(j), Integer.valueOf(i));
    }

    public void onUserKicked(long j, int i, int i2) {
        sendCallBack(13, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onClientRoleChanged(int i, int i2) {
        sendCallBack(6, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onRemoteAudioStats(RemoteAudioStats remoteAudioStats) {
        sendCallBack(200, remoteAudioStats);
    }

    public void onRemoteVideoStats(RemoteVideoStats remoteVideoStats) {
        sendCallBack(300, remoteVideoStats);
    }

    public void onRtcStats(RtcStats rtcStats) {
        sendCallBack(7, rtcStats);
    }

    public void onConnectionLost() {
        sendCallBack(8, new Object[0]);
    }

    public void onConnectionStateChanged(int i, int i2) {
        sendCallBack(9, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onStreamMessage(long j, int i, byte[] bArr) {
        sendCallBack(12, Long.valueOf(j), Integer.valueOf(i), bArr);
    }

    public void onFirstRemoteAudioDecoded(long j, int i) {
        sendCallBack(201, Long.valueOf(j), Integer.valueOf(i));
    }

    public void onRemoteAudioStateChanged(long j, int i, int i2, int i3) {
        sendCallBack(202, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onRemoteVideoStateChanged(long j, int i, int i2, int i3) {
        sendCallBack(301, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onFirstRemoteVideoFrame(long j, int i, int i2, int i3) {
        sendCallBack(302, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onAudioBufferingStateChanged(long j, int i, long j2) {
        sendCallBack(203, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2));
    }

    public void OnVideoBufferingStateChanged(long j, int i, long j2) {
        sendCallBack(303, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2));
    }

    public void onChannelMediaRelayStateChanged(int i, int i2) {
        sendCallBack(15, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onChannelMediaRelayEvent(int i) {
        sendCallBack(16, Integer.valueOf(i));
    }

    public void onCaptureVideoSize(int i, int i2) {
        sendCallBack(304, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onRemoteStreamSubscribeAdvice(long j, int i, int i2) {
        sendCallBack(17, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onTakeRemoteViewSnapshot(long j, Bitmap bitmap) {
        sendCallBack(305, Long.valueOf(j), bitmap);
    }

    public void onVideoPublishStateChanged(int i, int i2, int i3) {
        sendCallBack(306, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onAudioPublishStateChanged(int i, int i2, int i3) {
        sendCallBack(204, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onVideoSubscribeStateChanged(long j, int i, int i2, int i3) {
        sendCallBack(307, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onAudioSubscribeStateChanged(long j, int i, int i2, int i3) {
        sendCallBack(205, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onNetworkQuality(long j, int i, int i2) {
        sendCallBack(18, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public int takeRemoteViewSnapshot(long j) {
        if (this.mRtcChannelHandler.channelName().length() < 1) {
            return -1;
        }
        GlobalHolder.getInstance().sendSyncGlobalMessage(1013, this.mRtcChannelHandler.channelName(), Long.valueOf(j));
        return 0;
    }

    private void sendCallBack(int i, Object... objArr) {
        try {
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            if (TextUtils.isEmpty(methodName)) {
                String str = this.TAG;
                OmniLog.e(str, "Send call back failed... targetMethodName is null... " + i);
            } else if (this.mIsReport) {
                if (!OmniLog.isFastCallBackMessage(methodName)) {
                    OmniLog.omniCall(this.mChannelName, methodName, Arrays.toString(objArr));
                    this.mOmniInterSyncHelperImpl.buildReportLogAndSendForCallBack(methodName, objArr);
                }
                if (this.mRtcChannelEventDispatcher != null) {
                    Message obtain = Message.obtain();
                    obtain.what = i;
                    obtain.obj = objArr;
                    this.mRtcChannelEventDispatcher.sendMessage(obtain);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = this.TAG;
            OmniLog.e(str2, "Send call back failed... targetMethodName is null... " + i);
        }
    }
}
