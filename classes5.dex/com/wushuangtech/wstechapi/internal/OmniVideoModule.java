package com.wushuangtech.wstechapi.internal;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.bean.AVSourceSyncBean;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.bean.RtcFuncInvokeIntervalBean;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.constants.RtcGlobalMessage;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.expansion.bean.OmniVideoFrame;
import com.wushuangtech.inter.OnRtcGlobalMessageCallBack;
import com.wushuangtech.inter.OnVideoDecoderSettingSizeToViewCallBack;
import com.wushuangtech.inter.OnVideoWaterMarkChangeListener;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.RtcFuncInvokeIntervalCalculator;
import com.wushuangtech.library.video.opengles.WaterMarkController;
import com.wushuangtech.myvideoimprove.ExternalVideoSource;
import com.wushuangtech.myvideoimprove.RemoteVideoRenderModel;
import com.wushuangtech.myvideoimprove.VideoModuleRendererEntry;
import com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean;
import com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder;
import com.wushuangtech.myvideoimprove.inter.OnLocalVideoModuleEventCallBack;
import com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer;
import com.wushuangtech.myvideoimprove.utils.MyCameraUtils;
import com.wushuangtech.myvideoimprove.view.OmniSurfaceView;
import com.wushuangtech.myvideoimprove.view.OmniTextureView;
import com.wushuangtech.myvideoimprove.view.OmniVideoRenderView;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.videocore.MyVideoApi;
import com.wushuangtech.videocore.MyVideoApiImpl;
import com.wushuangtech.videocore.VideoDecoderManager;
import com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig;
import com.wushuangtech.wstechapi.bean.VideoBitrateMode;
import com.wushuangtech.wstechapi.bean.VideoEncoderConfiguration;
import com.wushuangtech.wstechapi.bean.VideoRotate;
import com.wushuangtech.wstechapi.bean.WaterMarkPosition;
import com.wushuangtech.wstechapi.constants.OmniModuleConstants;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.ref.WeakReference;

class OmniVideoModule implements OnVideoWaterMarkChangeListener, OnRtcGlobalMessageCallBack {
    /* access modifiers changed from: private */
    public static final String TAG = "OmniVideoModule";
    private static volatile OmniVideoModule holder;
    private boolean mDualEncoderOpened;
    private boolean mEncoderOpened;
    private final FastLogCacheBean mExternalVideoPushBeginWatcher;
    private final FastLogCacheBean mExternalVideoPushWatcher;
    private long mLastRecvEVFrameTimestamp;
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public RemoteVideoRenderModel mRemoteVideoRenderModel;
    private final RtcFuncInvokeIntervalCalculator mRtcFuncInvokeIntervalCalculator = new RtcFuncInvokeIntervalCalculator();
    /* access modifiers changed from: private */
    public long mVideoLocalEnabledTimestamp;
    private VideoModuleRendererEntry mVideoRendererEntry;

    private int getRemoteHeight(String str) {
        return 0;
    }

    private int getRemoteWidth(String str) {
        return 0;
    }

    private OmniVideoModule() {
        String str = TAG;
        this.mExternalVideoPushBeginWatcher = new FastLogCacheBean("OmniVideoModule-pushExternalVideoFrame1", OmniLog.EXTERNAL_VIDEO_WATCH, str, 4);
        this.mExternalVideoPushWatcher = new FastLogCacheBean("OmniVideoModule-pushExternalVideoFrame2", OmniLog.EXTERNAL_VIDEO_WATCH, str, 4);
    }

    public static OmniVideoModule getInstance() {
        if (holder == null) {
            synchronized (OmniVideoModule.class) {
                if (holder == null) {
                    holder = new OmniVideoModule();
                }
            }
        }
        return holder;
    }

    public void setVideoCapRotate(int i) {
        this.mVideoRendererEntry.setVideoCapRotateFromSystem(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.view.TextureView] */
    /* JADX WARNING: type inference failed for: r1v18, types: [android.view.TextureView] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object receiveVideoModuleEvent(com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig r11) {
        /*
            r10 = this;
            r1 = 0
            if (r11 != 0) goto L_0x0004
            return r1
        L_0x0004:
            int r2 = r11.eventType
            r3 = 40
            if (r2 <= r3) goto L_0x0015
            int r2 = r11.eventType
            r3 = 50
            if (r2 >= r3) goto L_0x0015
            java.lang.Object r0 = r10.handleUnityEvent(r11)
            return r0
        L_0x0015:
            int r2 = r11.eventType
            r3 = 150(0x96, float:2.1E-43)
            if (r2 <= r3) goto L_0x0026
            int r2 = r11.eventType
            r3 = 160(0xa0, float:2.24E-43)
            if (r2 >= r3) goto L_0x0026
            java.lang.Object r0 = r10.handleCameraEvent(r11)
            return r0
        L_0x0026:
            int r2 = r11.eventType
            if (r2 == 0) goto L_0x0314
            r3 = 1
            if (r2 == r3) goto L_0x0310
            r4 = 2
            r5 = 0
            if (r2 == r4) goto L_0x0302
            r6 = 3
            if (r2 == r6) goto L_0x02ef
            r7 = 7
            r8 = 5
            r9 = 4
            if (r2 == r7) goto L_0x0295
            r7 = 8
            if (r2 == r7) goto L_0x025f
            switch(r2) {
                case 10: goto L_0x0246;
                case 11: goto L_0x0219;
                case 12: goto L_0x020a;
                default: goto L_0x0040;
            }
        L_0x0040:
            switch(r2) {
                case 15: goto L_0x01f7;
                case 16: goto L_0x01f0;
                case 17: goto L_0x01bd;
                case 18: goto L_0x01ae;
                default: goto L_0x0043;
            }
        L_0x0043:
            switch(r2) {
                case 20: goto L_0x0196;
                case 21: goto L_0x0183;
                case 22: goto L_0x0171;
                case 23: goto L_0x0156;
                default: goto L_0x0046;
            }
        L_0x0046:
            switch(r2) {
                case 25: goto L_0x0133;
                case 26: goto L_0x0110;
                case 27: goto L_0x00f3;
                case 28: goto L_0x00e0;
                case 29: goto L_0x00d5;
                case 30: goto L_0x00ce;
                default: goto L_0x0049;
            }
        L_0x0049:
            switch(r2) {
                case 142: goto L_0x00bb;
                case 143: goto L_0x00a8;
                case 144: goto L_0x0099;
                case 145: goto L_0x0080;
                case 146: goto L_0x0053;
                case 147: goto L_0x004e;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x034d
        L_0x004e:
            java.lang.Object r0 = r10.executeGetCameraId()
            return r0
        L_0x0053:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object[] r3 = r11.objs
            r3 = r3[r4]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r6]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10.executeVideoLocalDualEncoderParams(r1, r2, r3, r0)
            goto L_0x034d
        L_0x0080:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Object r0 = r10.executeVideoLocalRenderMirror(r1, r0)
            return r0
        L_0x0099:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.Object r0 = r10.executeVideoLocalStreamEnabled(r0)
            return r0
        L_0x00a8:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            int r0 = r10.enableLocalVideoInternal(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x00bb:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            int r0 = r10.executeVideoEnabled(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x00ce:
            java.lang.Object[] r0 = r11.objs
            java.lang.Object r0 = r10.executeSetAVSyncSource(r0)
            return r0
        L_0x00d5:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            com.wushuangtech.wstechapi.bean.VideoBitrateMode r0 = (com.wushuangtech.wstechapi.bean.VideoBitrateMode) r0
            r10.executeSetVideoBitrateMode(r0)
            goto L_0x034d
        L_0x00e0:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            int r0 = r10.executeVideoRemoteMirror(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x00f3:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r3]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            int r0 = r10.executeVideoLocalMirror(r1, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x0110:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r3]
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r4]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r10.executeBeautfyAdjust(r1, r2, r0)
            goto L_0x034d
        L_0x0133:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r4]
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            android.view.SurfaceView r1 = (android.view.SurfaceView) r1
            r2 = 0
            r4 = 0
            long r8 = com.wushuangtech.library.GlobalConfig.mVideoMixerUserID
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r7 = r0.intValue()
            r0 = r10
            r3 = r4
            r4 = r8
            r0.executeSetupRemoteVideo(r1, r2, r3, r4, r6, r7)
            goto L_0x034d
        L_0x0156:
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r5]
            byte[] r2 = (byte[]) r2
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r3]
            if (r0 == 0) goto L_0x0165
            r1 = r0
            byte[] r1 = (byte[]) r1
        L_0x0165:
            com.wushuangtech.videocore.MyVideoApi r0 = com.wushuangtech.videocore.MyVideoApi.getInstance()
            com.wushuangtech.videocore.MyVideoApiImpl r0 = (com.wushuangtech.videocore.MyVideoApiImpl) r0
            int r3 = r2.length
            byte[] r0 = r0.CheckFrame(r2, r5, r3, r1)
            return r0
        L_0x0171:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            byte[] r1 = (byte[]) r1
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r3]
            byte[] r0 = (byte[]) r0
            int r2 = r0.length
            com.wushuangtech.videocore.SeiPacket.fill_sei_packet(r1, r3, r0, r2)
            goto L_0x034d
        L_0x0183:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = com.wushuangtech.videocore.SeiPacket.get_sei_packet_size(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x0196:
            com.wushuangtech.api.ExternalRtmpPublishModule r0 = com.wushuangtech.api.ExternalRtmpPublishModule.getInstance()
            com.wushuangtech.videocore.MyVideoApi r1 = com.wushuangtech.videocore.MyVideoApi.getInstance()
            r0.setExternalVideoModuleCallback(r1)
            com.wushuangtech.videocore.MyVideoApi r0 = com.wushuangtech.videocore.MyVideoApi.getInstance()
            com.wushuangtech.api.ExternalRtmpPublishModule r1 = com.wushuangtech.api.ExternalRtmpPublishModule.getInstance()
            r0.addVideoSender(r1)
            goto L_0x034d
        L_0x01ae:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            com.wushuangtech.expansion.bean.OmniVideoFrame r0 = (com.wushuangtech.expansion.bean.OmniVideoFrame) r0
            boolean r0 = r10.executePushExternalVideoFrame(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x01bd:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r6]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.wushuangtech.myvideoimprove.ExternalVideoSource r2 = com.wushuangtech.myvideoimprove.ExternalVideoSource.getInstance()
            java.lang.Object[] r6 = r11.objs
            r5 = r6[r5]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Object[] r6 = r11.objs
            r3 = r6[r3]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r4]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r1 = r1 * 1000
            r2.setExternalVideoParams(r5, r3, r0, r1)
            goto L_0x034d
        L_0x01f0:
            java.lang.Object[] r0 = r11.objs
            java.lang.Object r0 = r10.executeControlExternalVideo(r0)
            return r0
        L_0x01f7:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.String r0 = (java.lang.String) r0
            com.wushuangtech.api.ExternalVideoModule r1 = com.wushuangtech.api.ExternalVideoModule.getInstance()
            byte[] r0 = r0.getBytes()
            r1.insertH264SeiContent(r0)
            goto L_0x034d
        L_0x020a:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            com.wushuangtech.wstechapi.bean.VideoEncoderConfiguration r0 = (com.wushuangtech.wstechapi.bean.VideoEncoderConfiguration) r0
            int r0 = r10.executeSetVideoConfig(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x0219:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object[] r3 = r11.objs
            r3 = r3[r4]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r6]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10.executeSetVideoProfileModel(r1, r2, r3, r0)
            goto L_0x034d
        L_0x0246:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r3]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r10.executeSetVideoProfileModel(r1, r0)
            goto L_0x034d
        L_0x025f:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r5]
            android.view.SurfaceView r1 = (android.view.SurfaceView) r1
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r3]
            android.view.TextureView r2 = (android.view.TextureView) r2
            java.lang.Object[] r3 = r11.objs
            r3 = r3[r4]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object[] r4 = r11.objs
            r4 = r4[r6]
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            java.lang.Object[] r6 = r11.objs
            r6 = r6[r9]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r8]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r7 = r0.intValue()
            r0 = r10
            int r0 = r0.executeSetupRemoteVideo(r1, r2, r3, r4, r6, r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x0295:
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r5]
            if (r2 != 0) goto L_0x029d
            r2 = r1
            goto L_0x02a3
        L_0x029d:
            java.lang.Object[] r2 = r11.objs
            r2 = r2[r5]
            android.view.SurfaceView r2 = (android.view.SurfaceView) r2
        L_0x02a3:
            java.lang.Object[] r5 = r11.objs
            r5 = r5[r3]
            if (r5 != 0) goto L_0x02aa
            goto L_0x02b0
        L_0x02aa:
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r3]
            android.view.TextureView r1 = (android.view.TextureView) r1
        L_0x02b0:
            r3 = r1
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r4]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r4 = r1.booleanValue()
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r6]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r5 = r1.intValue()
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r9]
            r6 = r1
            com.wushuangtech.wstechapi.bean.VideoRotate r6 = (com.wushuangtech.wstechapi.bean.VideoRotate) r6
            java.lang.Object[] r1 = r11.objs
            r1 = r1[r8]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r7 = r1.intValue()
            java.lang.Object[] r0 = r11.objs
            r1 = 6
            r0 = r0[r1]
            r8 = r0
            com.wushuangtech.wstechapi.bean.WaterMarkPosition r8 = (com.wushuangtech.wstechapi.bean.WaterMarkPosition) r8
            r0 = r10
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            int r0 = r0.executeSetupLocalVideo(r1, r2, r3, r4, r5, r6, r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x02ef:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            int r0 = r10.executingLocalVideoPreviewAdjust(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L_0x0302:
            java.lang.Object[] r0 = r11.objs
            r0 = r0[r5]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r10.adjustVideoSender(r0)
            goto L_0x034d
        L_0x0310:
            r10.executeVideoDestroy()
            goto L_0x034d
        L_0x0314:
            r10.initVideoModule()
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            android.content.Context r0 = r0.getContext()
            com.wushuangtech.wstechapi.internal.OmniVideoModule$LocalVideoModuleEventCallBackImpl r2 = new com.wushuangtech.wstechapi.internal.OmniVideoModule$LocalVideoModuleEventCallBackImpl
            r2.<init>(r10)
            com.wushuangtech.myvideoimprove.VideoModuleRendererEntry r3 = new com.wushuangtech.myvideoimprove.VideoModuleRendererEntry
            r3.<init>()
            r10.mVideoRendererEntry = r3
            r3.createNewLocalVideoRenderModel(r0)
            com.wushuangtech.myvideoimprove.VideoModuleRendererEntry r0 = r10.mVideoRendererEntry
            r0.setOnLocalVideoModuleEventCallBack(r2)
            com.wushuangtech.wstechapi.internal.OmniVideoModule$RemoteVideoModuleEvetCallBackImpl r0 = new com.wushuangtech.wstechapi.internal.OmniVideoModule$RemoteVideoModuleEvetCallBackImpl
            r0.<init>()
            com.wushuangtech.myvideoimprove.RemoteVideoRenderModel r1 = new com.wushuangtech.myvideoimprove.RemoteVideoRenderModel
            r1.<init>(r0)
            r10.mRemoteVideoRenderModel = r1
            com.wushuangtech.myvideoimprove.ExternalVideoSource r0 = com.wushuangtech.myvideoimprove.ExternalVideoSource.getInstance()
            r0.setOnLocalVideoModuleEventCallBack(r2)
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            r0.addRtcGlobalMessageCallBack(r10)
        L_0x034d:
            r0 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniVideoModule.receiveVideoModuleEvent(com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig):java.lang.Object");
    }

    private void executeVideoDestroy() {
        OmniLog.i(TAG, "executeVideoDestroy");
        this.mVideoRendererEntry.resetLocalVideoRenderModel();
    }

    private int executeSetVideoConfig(VideoEncoderConfiguration videoEncoderConfiguration) {
        VideoModuleRendererEntry videoModuleRendererEntry = this.mVideoRendererEntry;
        if (videoModuleRendererEntry == null) {
            return -1;
        }
        OmniLog.i(TAG, "executeSetVideoConfig config:" + videoEncoderConfiguration.toString());
        int i = videoEncoderConfiguration.dimensions.width;
        int i2 = videoEncoderConfiguration.dimensions.height;
        if (i > 0 && i2 > 0) {
            int i3 = videoEncoderConfiguration.bitrate;
            int i4 = videoEncoderConfiguration.frameRate;
            if (i3 > 0 && i4 > 0) {
                VideoEncoderConfiguration.ORIENTATION_MODE orientation_mode = videoEncoderConfiguration.orientationMode;
                boolean z = true;
                if (VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_PORTRAIT == orientation_mode) {
                    videoModuleRendererEntry.setActivityDirector(1);
                } else if (VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_LANDSCAPE == orientation_mode) {
                    videoModuleRendererEntry.setActivityDirector(0);
                }
                executeSetVideoProfileModel(i, i2, i4, i3);
                int i5 = videoEncoderConfiguration.mirrorMode;
                if (i5 == 160200) {
                    i5 = Constants.VIDEO_MIRROR_MODE_DISABLED;
                }
                VideoModuleRendererEntry videoModuleRendererEntry2 = this.mVideoRendererEntry;
                if (i5 != 160201) {
                    z = false;
                }
                videoModuleRendererEntry2.setVideoLocalEncodedMirror(z);
                return 0;
            }
        }
        return -5;
    }

    /* access modifiers changed from: package-private */
    public Object receiveVideoModuleEvent(int i) {
        return receiveVideoModuleEvent(new OmniLocalModuleConfig(i, (Object[]) null));
    }

    private Object handleUnityEvent(OmniLocalModuleConfig omniLocalModuleConfig) {
        switch (omniLocalModuleConfig.eventType) {
            case 41:
            case 42:
            case 46:
                return Integer.valueOf(getRemoteWidth((String) omniLocalModuleConfig.objs[0]));
            case 43:
                return Integer.valueOf(getRemoteHeight((String) omniLocalModuleConfig.objs[0]));
            case 44:
            case 45:
                return 0;
            default:
                return null;
        }
    }

    private Object handleCameraEvent(OmniLocalModuleConfig omniLocalModuleConfig) {
        switch (omniLocalModuleConfig.eventType) {
            case 151:
                return Integer.valueOf(executeSwitchCamera());
            case 152:
                return Boolean.valueOf(executeCameraFuncCheck(((Integer) omniLocalModuleConfig.objs[0]).intValue()));
            case 153:
                return Boolean.valueOf(executeSetCameraTorch(((Boolean) omniLocalModuleConfig.objs[0]).booleanValue()));
            case 154:
                return Boolean.valueOf(executeSetCameraZoom(((Integer) omniLocalModuleConfig.objs[0]).intValue()));
            case 155:
                return Integer.valueOf(executeGetCameraMaxZoom());
            case 156:
                return executeCameraPreviewResolution(omniLocalModuleConfig.objs);
            default:
                return null;
        }
    }

    private void initVideoModule() {
        OmniLog.i(TAG, "initVideoModule");
        ExternalVideoModule instance = ExternalVideoModule.getInstance();
        MyVideoApi instance2 = MyVideoApi.getInstance();
        instance.setExternalVideoModuleCallback(instance2);
        instance2.addVideoSender(instance);
    }

    private int executeVideoEnabled(boolean z) {
        String invokedMethodName = OmniLog.getInvokedMethodName();
        boolean z2 = GlobalConfig.mVideoEnabled;
        boolean z3 = GlobalConfig.mVideoLocalEnabled;
        String str = GlobalConfig.mAVUploadChannelName;
        String str2 = TAG;
        OmniLog.i(str2, invokedMethodName + "enabled = " + z + ", current video module = " + z2 + ", current video local module = " + z3 + ", upload channel = " + str);
        if (z2 == z) {
            return 0;
        }
        EnterConfApi instance = EnterConfApi.getInstance();
        instance.muteAllRemoteVideo(!z);
        GlobalConfig.mVideoEnabled = z;
        executeEnableLocalVideoInternal(z && z3);
        if (!GlobalHolder.getInstance().isJoinedChannel()) {
            return 0;
        }
        instance.updateHeartbeatReporterVideoStatus(Boolean.valueOf(z), (Boolean) null, (Boolean) null);
        if (z) {
            if (GlobalConfig.mVideoLocalStreamEnabled && !TextUtils.isEmpty(str)) {
                RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_LOCAL_MUTED, str, false);
            }
        } else if (!TextUtils.isEmpty(str)) {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_LOCAL_MUTED, str, true);
        }
        return 0;
    }

    private int enableLocalVideoInternal(boolean z) {
        boolean z2 = GlobalConfig.mVideoEnabled;
        boolean z3 = GlobalConfig.mVideoLocalEnabled;
        String invokedMethodName = OmniLog.getInvokedMethodName();
        String str = TAG;
        OmniLog.i(str, invokedMethodName + "enabled = " + z + ", current video local module = " + z3 + ", current role = " + GlobalConfig.mLocalRole + ", current video module enabled = " + z2);
        if (z3 == z) {
            return 0;
        }
        if (!z2) {
            return -3;
        }
        GlobalConfig.mVideoLocalEnabled = z;
        return executeEnableLocalVideoInternal(z);
    }

    private Object executeVideoLocalStreamEnabled(boolean z) {
        String invokedMethodName = OmniLog.getInvokedMethodName();
        String str = TAG;
        OmniLog.i(str, invokedMethodName + "muted = " + z);
        return Integer.valueOf(EnterConfApi.getInstance().muteLocalVideo(z));
    }

    private int executeVideoLocalMirror(boolean z, boolean z2) {
        return setLocalVideoRenderModeAndMirror((Integer) null, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    private Object executeVideoLocalRenderMirror(int i, int i2) {
        return Integer.valueOf(setLocalVideoRenderModeAndMirror(Integer.valueOf(i), Boolean.valueOf(160201 == i2), (Boolean) null));
    }

    private int executeVideoRemoteMirror(boolean z) {
        GlobalConfig.mLocalVideoSentDataHorMirrorEnabled = z;
        this.mVideoRendererEntry.setVideoLocalEncodedMirror(z);
        ExternalVideoSource.getInstance().setExternalVideoMirror(z);
        return 0;
    }

    private void adjustVideoSender(boolean z) {
        String str = TAG;
        OmniLog.i(str, "adjustVideoSender isClose:" + z);
        if (z) {
            MyVideoApi.getInstance().removeVideoSender(ExternalVideoModule.getInstance());
        } else {
            MyVideoApi.getInstance().addVideoSender(ExternalVideoModule.getInstance());
        }
    }

    private int executingLocalVideoPreviewAdjust(boolean z) {
        String str = TAG;
        OmniLog.i(str, "executingLocalVideoPreviewAdjust enabled:" + z + " mVideoEnabled:" + GlobalConfig.mVideoEnabled + " mVideoImproveEnabled:" + GlobalConfig.mVideoImproveEnabled);
        if (!GlobalConfig.mVideoEnabled) {
            return -3;
        }
        GlobalConfig.mLocalVideoPreview = z;
        if (z) {
            this.mVideoRendererEntry.startPreview();
            return 0;
        }
        this.mVideoRendererEntry.stopPreview();
        return 0;
    }

    private int executeSetupLocalVideo(SurfaceView surfaceView, TextureView textureView, boolean z, int i, VideoRotate videoRotate, int i2, WaterMarkPosition waterMarkPosition) {
        VideoRenderView videoRenderView;
        int i3;
        Log.i(TAG, "executeSetupLocalVideo surfaceView:" + surfaceView + " textureView:" + textureView + " activityOrientation:" + i + " rotate:" + videoRotate + " showMode:" + i2);
        if (surfaceView != null) {
            if (surfaceView instanceof OmniSurfaceView) {
                videoRenderView = (VideoRenderView) surfaceView;
            } else {
                videoRenderView = new OmniVideoRenderView(surfaceView);
            }
        } else if (textureView instanceof OmniTextureView) {
            videoRenderView = (VideoRenderView) textureView;
        } else {
            videoRenderView = new OmniVideoRenderView(textureView);
        }
        WaterMarkController waterMarkController = null;
        if (waterMarkPosition != null) {
            waterMarkPosition.mOnVideoWaterMarkChangeListener = this;
            waterMarkController = new WaterMarkController();
            waterMarkController.setX_soffset(waterMarkPosition.getX_soffset());
            waterMarkController.setY_soffset(waterMarkPosition.getY_soffset());
            waterMarkController.setBitmap(waterMarkPosition.getBitmap());
            waterMarkController.setWidthAndHeight(waterMarkPosition.getWidth(), waterMarkPosition.getHeight());
        }
        if (z) {
            int i4 = 90;
            if (videoRotate == VideoRotate.ROTATE_0) {
                i4 = 0;
            } else if (videoRotate == VideoRotate.ROTATE_180) {
                i4 = LocalSDKConstants.SCREEN_ROTATE_180;
            } else if (videoRotate == VideoRotate.ROTATE_270) {
                i4 = LocalSDKConstants.SCREEN_ROTATE_270;
            }
            i3 = this.mVideoRendererEntry.setupLocalVideo(videoRenderView, waterMarkController, i4, i2);
        } else {
            i3 = this.mVideoRendererEntry.setupLocalVideoDirector(videoRenderView, waterMarkController, i, i2);
        }
        if (i3 != 0) {
            return -6;
        }
        if (GlobalConfig.mVideoEnabled && GlobalConfig.mVideoLocalEnabled) {
            this.mVideoRendererEntry.startRender();
        }
        return 0;
    }

    private int executeSetupRemoteVideo(SurfaceView surfaceView, TextureView textureView, String str, long j, String str2, int i) {
        VideoRenderView videoRenderView;
        String invokedMethodName = OmniLog.getInvokedMethodName();
        String str3 = TAG;
        OmniLog.rv_i(str3, invokedMethodName + " surfaceView = " + surfaceView + ", textureView = " + textureView + ", channelName = " + str + ", uid = " + j + ", deviceId = " + str2 + ", renderMode = " + i);
        if (surfaceView != null) {
            if (surfaceView instanceof OmniSurfaceView) {
                videoRenderView = (VideoRenderView) surfaceView;
            } else {
                videoRenderView = new OmniVideoRenderView(surfaceView);
            }
        } else if (textureView instanceof OmniTextureView) {
            videoRenderView = (VideoRenderView) textureView;
        } else {
            videoRenderView = new OmniVideoRenderView(textureView);
        }
        videoRenderView.setDeviceId(str2);
        if (this.mRemoteVideoRenderModel.changeVideoRenderView(str2, videoRenderView)) {
            OmniLog.rv_i(str3, invokedMethodName + " Change video render view success!");
            registerVideoView(j, str2, Integer.toHexString(videoRenderView.hashCode()));
            return 0;
        }
        RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = new RemoteVideoModelConfigureBean();
        remoteVideoModelConfigureBean.mChannelName = str;
        remoteVideoModelConfigureBean.mUid = j;
        remoteVideoModelConfigureBean.mDeviceId = str2;
        remoteVideoModelConfigureBean.mVideoRenderView = videoRenderView;
        if (!this.mRemoteVideoRenderModel.createVideoRenderer(remoteVideoModelConfigureBean)) {
            OmniLog.rv_e(str3, invokedMethodName + " Create video renderer failed! " + remoteVideoModelConfigureBean.toString());
            return -6;
        }
        this.mRemoteVideoRenderModel.setRenderMode(str2, i);
        if (!this.mRemoteVideoRenderModel.startVideoRender(remoteVideoModelConfigureBean)) {
            OmniLog.rv_e(str3, invokedMethodName + " Start video renderer failed! " + remoteVideoModelConfigureBean.toString());
            return -6;
        }
        registerVideoView(j, str2, Integer.toHexString(videoRenderView.hashCode()));
        return 0;
    }

    private void registerVideoView(long j, final String str, String str2) {
        VideoDecoderManager.getInstance().registerVideoView(j, str, str2, new OnVideoDecoderSettingSizeToViewCallBack() {
            public void onVideoTexture() {
                SurfaceTexture surfaceTexture;
                RemoteVideoRenderer videoRenderer = OmniVideoModule.this.mRemoteVideoRenderModel.getVideoRenderer(str);
                if (videoRenderer != null && (surfaceTexture = videoRenderer.getSurfaceTexture()) != null) {
                    VideoDecoderManager.getInstance().setVideoSurfaceTexture(str, surfaceTexture);
                }
            }

            public void onVideoDataSize(int i, int i2) {
                RemoteVideoRenderer videoRenderer = OmniVideoModule.this.mRemoteVideoRenderModel.getVideoRenderer(str);
                if (videoRenderer != null) {
                    videoRenderer.setVideoSize(i, i2);
                }
            }
        });
    }

    private int executeSwitchCamera() {
        if (!MyCameraUtils.supportSwitchCamera()) {
            return 0;
        }
        this.mVideoRendererEntry.setCameraSwitch();
        return 0;
    }

    private void executeSetVideoProfileModel(int i, boolean z) {
        int i2 = 480;
        int i3 = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT;
        int i4 = 600;
        int i5 = 15;
        switch (i) {
            case Constants.RTC_VIDEOPROFILE_120P:
                i2 = OmniModuleConstants.VIDEO_LOCAL_STREAM_ENABLED;
                i3 = 192;
                i4 = 65;
                break;
            case Constants.RTC_VIDEOPROFILE_180P:
                i2 = LocalSDKConstants.SCREEN_ROTATE_180;
                i4 = 140;
                break;
            case Constants.RTC_VIDEOPROFILE_240P:
                i2 = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH;
                i4 = 200;
                break;
            case Constants.RTC_VIDEOPROFILE_480P:
                i3 = 848;
                i4 = 1000;
                break;
            case Constants.RTC_VIDEOPROFILE_720P:
                i2 = 720;
                i3 = PlatformPlugin.DEFAULT_SYSTEM_UI;
                i5 = 20;
                i4 = 2400;
                break;
            case Constants.RTC_VIDEOPROFILE_1080P:
                i2 = 1080;
                i3 = 1920;
                i4 = 3000;
                break;
            case Constants.RTC_VIDEOPROFILE_640x480:
                i4 = 800;
                break;
            case Constants.RTC_VIDEOPROFILE_960x540:
                i2 = 540;
                i3 = 960;
                i5 = 24;
                i4 = 1600;
                break;
            default:
                i2 = 360;
                break;
        }
        i3 = 640;
        if (z) {
            int i6 = i3;
            i3 = i2;
            i2 = i6;
        }
        executeSetVideoProfileModel(i2, i3, i5, i4);
    }

    private void executeSetVideoProfileModel(int i, int i2, int i3, int i4) {
        int i5 = i * i2 >= 307200 ? i4 * 1000 : (int) (((float) (i4 * 1000)) * 0.9f);
        MyVideoApi.VideoConfig videoConfig = MyVideoApi.getInstance().getVideoConfig();
        videoConfig.videoWidth = i;
        videoConfig.videoHeight = i2;
        videoConfig.videoFrameRate = i3;
        videoConfig.videoBitRate = i5;
        MyVideoApi.getInstance().setVideoConfig(videoConfig);
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            globalVideoConfig.setUserVideoEncoderParams(i, i2, i3, i5);
        }
        if (GlobalConfig.mVideoImproveEnabled) {
            this.mVideoRendererEntry.setVideoEncodeParams(i, i2, i3, i5);
        }
        ExternalVideoSource.getInstance().setExternalVideoParams(i, i2, i3, i5);
    }

    private Object executeControlExternalVideo(Object[] objArr) {
        boolean booleanValue = objArr[0].booleanValue();
        boolean z = true;
        boolean booleanValue2 = objArr[1].booleanValue();
        this.mLastRecvEVFrameTimestamp = 0;
        ExternalVideoSource instance = ExternalVideoSource.getInstance();
        if (booleanValue) {
            this.mVideoRendererEntry.stopRender();
            instance.setFocusSoftEncode(true);
            z = instance.startExterVideoSource(booleanValue2);
        } else {
            instance.stopExterVideoSource();
        }
        return Boolean.valueOf(z);
    }

    private boolean executePushExternalVideoFrame(OmniVideoFrame omniVideoFrame) {
        int i;
        this.mRtcFuncInvokeIntervalCalculator.invoke();
        RtcFuncInvokeIntervalBean rtcFuncInvokeIntervalBean = this.mRtcFuncInvokeIntervalCalculator.get();
        FastLogCacheBean fastLogCacheBean = this.mExternalVideoPushBeginWatcher;
        fastLogCacheBean.mMessage = "External video enabled: " + GlobalConfig.mExternalVideoSource + ", " + rtcFuncInvokeIntervalBean.toString();
        OmniLog.fd(this.mExternalVideoPushBeginWatcher);
        if (!GlobalConfig.mExternalVideoSource) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastRecvEVFrameTimestamp;
        if ((j > 0 || currentTimeMillis > j) && (i = (int) (currentTimeMillis - j)) > 500) {
            String str = GlobalConfig.mAVUploadChannelName;
            long j2 = GlobalConfig.mLocalOwnerUid;
            if (TextUtils.isEmpty(str) || j2 == 0) {
                OmniLog.e("Executing push external video frame, report input stuck event failed! channel name or uid is empty!");
            } else {
                GlobalHolder.getInstance().handleRtcEventReport(str, LogEvent.VIDEO_LOCAL_UPSTREAM_STUCK, String.valueOf(j2), 1, Integer.valueOf(i));
            }
        }
        this.mLastRecvEVFrameTimestamp = currentTimeMillis;
        int handleVideoFrame = ExternalVideoSource.getInstance().handleVideoFrame(omniVideoFrame);
        FastLogCacheBean fastLogCacheBean2 = this.mExternalVideoPushWatcher;
        fastLogCacheBean2.mMessage = "External video push status: " + handleVideoFrame + ", frame: " + omniVideoFrame.toString();
        OmniLog.fd(this.mExternalVideoPushWatcher);
        if (handleVideoFrame == 0) {
            return true;
        }
        return false;
    }

    private void executeBeautfyAdjust(boolean z, float f, float f2) {
        this.mVideoRendererEntry.setBeautfyEnabled(z);
        this.mVideoRendererEntry.setBeautfyParams(f, f2);
    }

    private boolean executeCameraFuncCheck(int i) {
        return this.mVideoRendererEntry.cameraInspectFunction(i);
    }

    private boolean executeSetCameraTorch(boolean z) {
        return this.mVideoRendererEntry.setCameraTorch(z);
    }

    private boolean executeSetCameraZoom(int i) {
        return this.mVideoRendererEntry.setCameraZoom(i);
    }

    private int executeGetCameraMaxZoom() {
        return this.mVideoRendererEntry.getCameraMaxZoom();
    }

    private Object executeCameraPreviewResolution(Object[] objArr) {
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        if (intValue <= 0 || intValue2 <= 0) {
            return -5;
        }
        this.mVideoRendererEntry.setCameraPreviewResolution(intValue, intValue2);
        return 0;
    }

    private void executeSetVideoBitrateMode(VideoBitrateMode videoBitrateMode) {
        ExternalVideoSource.getInstance().setVideoBitrateMode(videoBitrateMode.ordinal());
        this.mVideoRendererEntry.setVideoBitrateMode(videoBitrateMode.ordinal());
    }

    private void executeVideoLocalDualEncoderParams(int i, int i2, int i3, int i4) {
        int i5 = i4 * 1000;
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            globalVideoConfig.setUserVideoDualEncodeParams(i, i2, i3, i5);
        }
        this.mVideoRendererEntry.setVideoDualEncodeParams(i, i2, i3, i5);
    }

    private Object executeSetAVSyncSource(Object[] objArr) {
        String str = objArr[0];
        long longValue = objArr[1].longValue();
        if (GlobalHolder.getInstance().isJoinedChannel(str)) {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.UPDATE_AV_SOURCE, str, Long.valueOf(longValue));
        } else {
            GlobalHolder.getInstance().getGlobalAVInterface().cacheAVSourceSyncOpt(new AVSourceSyncBean(str, longValue));
        }
        return 0;
    }

    private Object executeGetCameraId() {
        return this.mVideoRendererEntry.getCameraId();
    }

    private int executeEnableLocalVideoInternal(boolean z) {
        if (z) {
            this.mVideoLocalEnabledTimestamp = System.currentTimeMillis();
            if (!this.mVideoRendererEntry.isSetupLocalVideo()) {
                this.mVideoRendererEntry.setupLocalVideoDirector((VideoRenderView) null, (WaterMarkController) null, 0, 1);
            } else {
                this.mVideoRendererEntry.startRender();
            }
        } else {
            this.mVideoRendererEntry.stopRender();
        }
        if (GlobalHolder.getInstance().isJoinedChannel()) {
            EnterConfApi.getInstance().enableLocalVideo(z);
            if (!z) {
                MyVideoApi.getInstance().updateLocalVideoState(0, 0);
            }
        }
        return 0;
    }

    private int setLocalVideoRenderModeAndMirror(Integer num, Boolean bool, Boolean bool2) {
        if (num != null) {
            this.mVideoRendererEntry.setVideoRenderMode(num.intValue());
        }
        if (bool == null) {
            bool = Boolean.valueOf(GlobalConfig.mLocalVideoHorMirrorEnabled);
        } else {
            GlobalConfig.mLocalVideoHorMirrorEnabled = bool.booleanValue();
        }
        if (bool2 == null) {
            bool2 = Boolean.valueOf(GlobalConfig.mLocalVideoVrtMirrorEnabled);
        } else {
            GlobalConfig.mLocalVideoVrtMirrorEnabled = bool2.booleanValue();
        }
        this.mVideoRendererEntry.setVideoLocalRenderMirror(bool.booleanValue(), bool2.booleanValue());
        return 0;
    }

    public void onBitmapChanged(Bitmap bitmap) {
        this.mVideoRendererEntry.waterMarkBitmapChanged(bitmap);
    }

    public void onLocationChanged(float f, float f2) {
        this.mVideoRendererEntry.waterMarkLocationChanged(f, f2);
    }

    public void onGlobalMessage(int i, Object... objArr) {
        if (i == 500) {
            this.mVideoRendererEntry.setVideoLocalEncodedMirror(GlobalConfig.mLocalVideoSentDataHorMirrorEnabled);
            this.mVideoRendererEntry.setVideoLocalRenderMirror(GlobalConfig.mLocalVideoHorMirrorEnabled, GlobalConfig.mLocalVideoVrtMirrorEnabled);
        } else if (i == 1000) {
            handleGlobalMsgForStopPlay(objArr[0]);
        } else if (i == 1014) {
            this.mRemoteVideoRenderModel.setVideoRenderMirror(objArr[0], objArr[1].intValue());
        } else if (i == 1011) {
            this.mRemoteVideoRenderModel.waitForTextureUpdated(objArr[0]);
        } else if (i != 1012) {
            switch (i) {
                case 1002:
                    handleGlobalMsgForStopPlay("all");
                    return;
                case 1003:
                    this.mRemoteVideoRenderModel.setRenderMode(objArr[0], objArr[1].intValue());
                    return;
                case 1004:
                    this.mRemoteVideoRenderModel.setVideoSize(objArr[0], new int[]{objArr[1].intValue(), objArr[2].intValue()});
                    return;
                case 1005:
                    this.mRemoteVideoRenderModel.requestRender(objArr[0]);
                    return;
                default:
                    switch (i) {
                        case RtcGlobalMessage.VIDEO_LOCAL_CAP_START:
                            this.mVideoRendererEntry.startRender();
                            return;
                        case RtcGlobalMessage.VIDEO_LOCAL_ENC_START:
                            handleGlobalMsgForLocalVideoEnc(true, objArr[0].booleanValue());
                            return;
                        case RtcGlobalMessage.VIDEO_LOCAL_ENC_STOP:
                            handleGlobalMsgForLocalVideoEnc(false, objArr[0].booleanValue());
                            return;
                        case RtcGlobalMessage.VIDEO_LOCAL_ENC_DYNAMIC_BITRATE:
                            handleGlobalMsgForEncDynamicParams(objArr[0].booleanValue(), objArr[1].intValue(), objArr[2].intValue());
                            return;
                        case RtcGlobalMessage.VIDEO_LOCAL_ENC_MODE:
                            handleGlobalMsgForEncBitrateMode(objArr[0]);
                            return;
                        case RtcGlobalMessage.VIDEO_LOCAL_ENC_REQUEST_KEY_FRAME:
                            handleGlobalMsgForEncKeyFrame(objArr[0].booleanValue());
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.mRemoteVideoRenderModel.stopWaitForTextureUpdated(objArr[0]);
        }
    }

    private void handleGlobalMsgForLocalVideoEnc(boolean z, boolean z2) {
        synchronized (this.mLock) {
            if (z) {
                if (z2) {
                    this.mDualEncoderOpened = true;
                } else {
                    this.mEncoderOpened = true;
                }
                this.mVideoRendererEntry.videoEncodeStarted(z2);
            } else {
                if (z2) {
                    this.mDualEncoderOpened = false;
                } else {
                    this.mEncoderOpened = false;
                }
                this.mVideoRendererEntry.videoEncodeStoped(z2);
            }
        }
    }

    private void handleGlobalMsgForEncDynamicParams(boolean z, int i, int i2) {
        this.mVideoRendererEntry.videoEncodeParamsChanged(z, i, i2);
        if (!z) {
            ExternalVideoSource.getInstance().changeEncParam(i, i2);
        }
    }

    private void handleGlobalMsgForEncBitrateMode(VideoBitrateMode videoBitrateMode) {
        executeSetVideoBitrateMode(videoBitrateMode);
    }

    private void handleGlobalMsgForEncKeyFrame(boolean z) {
        if (z) {
            ExternalVideoSource.getInstance().requestKeyFrame(LocalVideoEncoder.VideoEncoderType.DUAL);
            this.mVideoRendererEntry.requestKeyFrame(LocalVideoEncoder.VideoEncoderType.DUAL);
            return;
        }
        ExternalVideoSource.getInstance().requestKeyFrame(LocalVideoEncoder.VideoEncoderType.MAIN);
        this.mVideoRendererEntry.requestKeyFrame(LocalVideoEncoder.VideoEncoderType.MAIN);
    }

    private void handleGlobalMsgForStopPlay(String str) {
        RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = new RemoteVideoModelConfigureBean();
        remoteVideoModelConfigureBean.mDeviceId = str;
        this.mRemoteVideoRenderModel.destroyVideoRenderer(remoteVideoModelConfigureBean);
    }

    private static class LocalVideoModuleEventCallBackImpl implements OnLocalVideoModuleEventCallBack {
        private final WeakReference<OmniVideoModule> mOutReference;

        public LocalVideoModuleEventCallBackImpl(OmniVideoModule omniVideoModule) {
            this.mOutReference = new WeakReference<>(omniVideoModule);
        }

        public int onVideoTextureFrameReport(int i, byte[] bArr, int i2, int i3, int i4, long j) {
            int i5 = i2 / 2;
            GlobalHolder.getInstance().sendSyncRtcEngineEvent(RtcEngineEvent.VideoEvent.EVENT_VIDEO_LOCAL_RAW_FRAME, bArr, 0, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i4), Long.valueOf(j));
            return i;
        }

        public void onVideoNV21FrameReport(byte[] bArr, int i, int i2, int i3, long j) {
            GlobalHolder.getInstance().sendSyncGlobalVideoCameraPreviewFrame(bArr, i, i2, i3, j);
        }

        public void onVideoCameraSuccess(int i, int i2, int i3) {
            GlobalHolder.getInstance().notifyCameraStartPreview(i, i2, i3, 0);
            MyVideoApi.getInstance().updateLocalVideoState(1, 0);
        }

        public void onVideoCameraError(int i) {
            if (!(i == 603 || i == 0)) {
                GlobalHolder.getInstance().notifyCameraStartPreview(0, 0, 0, i);
                if (i != -1) {
                    String access$200 = OmniVideoModule.TAG;
                    OmniLog.e(OmniLog.VIDEO_CAP_WATCH, access$200, "Video camera opt error : " + i);
                }
            }
            if (i == 602) {
                MyVideoApi.getInstance().updateLocalVideoState(3, 2);
            } else if (i == 603) {
                MyVideoApi.getInstance().updateLocalVideoState(3, 3);
            }
        }

        public void onVideoRenderError(int i) {
            String access$200 = OmniVideoModule.TAG;
            OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, access$200, "Video render opt error : " + i);
        }

        public void onVideoEncodeError(int i) {
            if (i >= -110 && OmniLog.DEBUG_MODE) {
                throw new RuntimeException("video encode error  : " + i);
            }
        }

        public void onVideoFirstLocalVideoFrame(int i, int i2) {
            OmniVideoModule omniVideoModule = (OmniVideoModule) this.mOutReference.get();
            int currentTimeMillis = omniVideoModule != null ? (int) (System.currentTimeMillis() - omniVideoModule.mVideoLocalEnabledTimestamp) : 0;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            GlobalHolder.getInstance().sendRtcEngineEvent(10, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(currentTimeMillis));
        }

        public void onVideoEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j) {
            if (i == ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I.ordinal()) {
                ((MyVideoApiImpl) MyVideoApi.getInstance()).encodedVideoFrame(bArr, ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I, i2, i3, z, j);
                return;
            }
            ((MyVideoApiImpl) MyVideoApi.getInstance()).encodedVideoFrame(bArr, ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P, i2, i3, z, j);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void reportLocalVideoRawFrmae(byte[] r9, int r10, int r11, int r12, long r13) {
            /*
                r8 = this;
                com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
                com.wushuangtech.library.video.LibYuvManager r1 = r0.getYuvManager()
                if (r1 != 0) goto L_0x000b
                return
            L_0x000b:
                r2 = 180(0xb4, float:2.52E-43)
                r3 = 270(0x10e, float:3.78E-43)
                r7 = 0
                if (r12 != 0) goto L_0x0014
                r12 = r7
                goto L_0x001e
            L_0x0014:
                if (r12 != r2) goto L_0x0018
            L_0x0016:
                r12 = r2
                goto L_0x001e
            L_0x0018:
                if (r12 != r3) goto L_0x001d
                r2 = 90
                goto L_0x0016
            L_0x001d:
                r12 = r3
            L_0x001e:
                r5 = 0
                r6 = 0
                r2 = r9
                r3 = r10
                r4 = r11
                byte[] r9 = r1.transNV21ToI420(r2, r3, r4, r5, r6)
                if (r9 != 0) goto L_0x002a
                return
            L_0x002a:
                r1 = 15002(0x3a9a, float:2.1022E-41)
                r2 = 10
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r7] = r9
                r3 = 1
                java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
                r2[r3] = r4
                java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
                r4 = 2
                r2[r4] = r3
                r3 = 3
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                r2[r3] = r11
                r11 = 4
                int r9 = r9.length
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                r2[r11] = r9
                r9 = 5
                java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
                r2[r9] = r11
                r9 = 6
                int r10 = r10 / r4
                java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
                r2[r9] = r11
                r9 = 7
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                r2[r9] = r10
                r9 = 8
                java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
                r2[r9] = r10
                r9 = 9
                java.lang.Long r10 = java.lang.Long.valueOf(r13)
                r2[r9] = r10
                r0.sendSyncRtcEngineEvent(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniVideoModule.LocalVideoModuleEventCallBackImpl.reportLocalVideoRawFrmae(byte[], int, int, int, long):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void testForVerifyData(int r8, int r9, byte[] r10, byte[] r11, byte[] r12, int r13, long r14) {
            /*
                r7 = this;
                int r0 = r8 * r9
                r1 = 3
                int r0 = r0 * r1
                r2 = 2
                int r0 = r0 / r2
                byte[] r3 = new byte[r0]
                int r4 = r10.length
                r5 = 0
                java.lang.System.arraycopy(r10, r5, r3, r5, r4)
                int r4 = r10.length
                int r6 = r11.length
                java.lang.System.arraycopy(r11, r5, r3, r4, r6)
                int r10 = r10.length
                int r11 = r11.length
                int r10 = r10 + r11
                int r11 = r12.length
                java.lang.System.arraycopy(r12, r5, r3, r10, r11)
                com.wushuangtech.expansion.bean.OmniVideoFrame r10 = new com.wushuangtech.expansion.bean.OmniVideoFrame
                r10.<init>()
                r10.buf = r3
                r10.stride = r8
                r10.height = r9
                com.wushuangtech.library.GlobalHolder r10 = com.wushuangtech.library.GlobalHolder.getInstance()
                r11 = 10
                java.lang.Object[] r11 = new java.lang.Object[r11]
                r11[r5] = r3
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                r3 = 1
                r11[r3] = r12
                java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
                r11[r2] = r12
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                r11[r1] = r9
                java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
                r12 = 4
                r11[r12] = r9
                java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
                r12 = 5
                r11[r12] = r9
                int r8 = r8 / r2
                java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
                r12 = 6
                r11[r12] = r9
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                r9 = 7
                r11[r9] = r8
                java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
                r9 = 8
                r11[r9] = r8
                java.lang.Long r8 = java.lang.Long.valueOf(r14)
                r9 = 9
                r11[r9] = r8
                r8 = 15002(0x3a9a, float:2.1022E-41)
                r10.sendRtcEngineEvent(r8, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniVideoModule.LocalVideoModuleEventCallBackImpl.testForVerifyData(int, int, byte[], byte[], byte[], int, long):void");
        }
    }

    private static class RemoteVideoModuleEvetCallBackImpl implements RemoteVideoRenderModel.OnRemoteVideoRenderModelCallBack {
        private RemoteVideoModuleEvetCallBackImpl() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, String str) {
            VideoDecoderManager.getInstance().registerSurfaceTexture(surfaceTexture, str);
        }

        public void onRenderFinish(String str) {
            VideoDecoderManager.getInstance().receiveVideoRenderFinish(str);
        }
    }
}
