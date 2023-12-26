package com.wushuangtech.videocore;

import android.content.Context;
import android.os.Build;
import com.wushuangtech.api.ExternalVideoDecoderPluginCallback;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.api.VideoSender;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.utils.MyCameraUtils;

public abstract class MyVideoApi implements ExternalVideoModuleCallback, ExternalVideoDecoderPluginCallback {
    private static MyVideoApi mVideoApi;

    public abstract void addVideoSender(VideoSender videoSender);

    public abstract VideoConfig getVideoConfig();

    public abstract void removeVideoSender(VideoSender videoSender);

    public abstract void setVideoConfig(VideoConfig videoConfig);

    public abstract void updateLocalVideoState(int i, int i2);

    public abstract void updateVideoDecoderSpentTime();

    public static class VideoConfig implements Cloneable {
        private int mCameraID = 1;
        private boolean mCanSwitchCamera;
        private boolean mHasBackCam;
        private boolean mHasExtraCam;
        private boolean mHasFrontCam;
        public boolean openflash = false;
        public int startBitrate = 300000;
        public int videoBitRate = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_BITRATE;
        public int videoBitrateMode;
        public int videoFrameRate = 15;
        public int videoHeight = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT;
        public int videoMaxKeyframeInterval = 1;
        public int videoWidth = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH;

        public VideoConfig() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.videoBitrateMode = 1;
            }
        }

        private void initSwitchCamera() {
            if (Build.VERSION.SDK_INT <= 21 || !GlobalConfig.mUseCamera2Api) {
                this.mHasFrontCam = MyCameraUtils.hasFrontFacingCamera();
                this.mHasBackCam = MyCameraUtils.hasBackFacingCamera();
            } else {
                Context context = GlobalHolder.getInstance().getContext();
                this.mHasFrontCam = MyCameraUtils.hasFrontFacingCamera2(context);
                this.mHasBackCam = MyCameraUtils.hasBackFacingCamera2(context);
                this.mHasExtraCam = MyCameraUtils.hasExtraFacingCamera2(context);
            }
            this.mCanSwitchCamera = this.mHasFrontCam && this.mHasBackCam;
        }

        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.toString());
                return null;
            }
        }

        public int getmCameraID() {
            return MyCameraUtils.autoSelectCameraID(this.mCameraID);
        }

        public String getmCamera2ID() {
            return MyCameraUtils.autoSelectCamera2ID(GlobalHolder.getInstance().getContext(), this.mCameraID);
        }

        public int getCameraFace() {
            if (Build.VERSION.SDK_INT <= 21 || !GlobalConfig.mUseCamera2Api) {
                int i = this.mCameraID;
                if (i == 1) {
                    return Constants.CAMERA_FRONT;
                }
                if (i == 0) {
                    return Constants.CAMERA_BACK;
                }
                return -1;
            }
            int i2 = this.mCameraID;
            if (i2 == 0) {
                return Constants.CAMERA_FRONT;
            }
            if (i2 == 1) {
                return Constants.CAMERA_BACK;
            }
            if (i2 == 2) {
                return Constants.CAMERA_EXTERNAL;
            }
            return -1;
        }

        public String toString() {
            return "VideoConfig{videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoFrameRate=" + this.videoFrameRate + ", videoMaxKeyframeInterval=" + this.videoMaxKeyframeInterval + ", videoBitRate=" + this.videoBitRate + ", videoBitrateMode=" + this.videoBitrateMode + ", startBitrate=" + this.startBitrate + ", openflash=" + this.openflash + ", mCameraID=" + this.mCameraID + ", mHasFrontCam=" + this.mHasFrontCam + ", mHasBackCam=" + this.mHasBackCam + ", mHasExtraCam=" + this.mHasExtraCam + ", mCanSwitchCamera=" + this.mCanSwitchCamera + '}';
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.videocore.MyVideoApi getInstance() {
        /*
            java.lang.Class<com.wushuangtech.videocore.MyVideoApi> r0 = com.wushuangtech.videocore.MyVideoApi.class
            monitor-enter(r0)
            com.wushuangtech.videocore.MyVideoApi r1 = mVideoApi     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.wushuangtech.videocore.MyVideoApi r1 = mVideoApi     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.wushuangtech.videocore.MyVideoApiImpl r1 = new com.wushuangtech.videocore.MyVideoApiImpl     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            mVideoApi = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.wushuangtech.videocore.MyVideoApi r1 = mVideoApi     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.MyVideoApi.getInstance():com.wushuangtech.videocore.MyVideoApi");
    }
}
