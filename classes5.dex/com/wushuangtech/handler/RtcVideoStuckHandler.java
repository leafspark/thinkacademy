package com.wushuangtech.handler;

import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.bean.VideoStuckStatsBean;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class RtcVideoStuckHandler {
    private static final String TAG = "RtcVideoStuckHandler";
    private final WeakReference<ExternalVideoModule> externalVideoModuleWeakReference;
    private boolean mReportLog;
    private final Object mVideoStuckLock = new Object();
    private LinkedList<VideoStuckStatsBean> mVideoStuckStatsBeans;

    public RtcVideoStuckHandler(ExternalVideoModule externalVideoModule) {
        this.externalVideoModuleWeakReference = new WeakReference<>(externalVideoModule);
    }

    public LinkedList<VideoStuckStatsBean> getVideoStuckDatas() {
        LinkedList<VideoStuckStatsBean> linkedList;
        ExternalVideoModule externalVideoModule = (ExternalVideoModule) this.externalVideoModuleWeakReference.get();
        if (externalVideoModule == null) {
            return null;
        }
        this.mVideoStuckStatsBeans = new LinkedList<>();
        this.mReportLog = true;
        externalVideoModule.getNativeVdieoStuckStats();
        this.mReportLog = false;
        synchronized (this.mVideoStuckLock) {
            linkedList = this.mVideoStuckStatsBeans;
            this.mVideoStuckStatsBeans = null;
        }
        return linkedList;
    }

    public void receiveVideoStuckStats(String str, long j, int i, int i2, long j2) {
        int i3;
        int i4;
        OmniLog.i("VIDEO_DOWNLOAD_FREEZE", TAG, "Receive video stuck stats, channelName: " + str + ", uid: " + j + ", stat: " + i + ", stuck_ms: " + i2 + ", ts: " + j2);
        synchronized (this.mVideoStuckLock) {
            if (this.mReportLog) {
                VideoStuckStatsBean videoStuckStatsBean = new VideoStuckStatsBean();
                videoStuckStatsBean.mChannelName = str;
                videoStuckStatsBean.mUid = j;
                videoStuckStatsBean.mStats = i;
                videoStuckStatsBean.mStuckMs = (long) i2;
                videoStuckStatsBean.mTimeStamp = j2;
                this.mVideoStuckStatsBeans.add(videoStuckStatsBean);
            } else {
                if (i == 1) {
                    i3 = 2;
                    i4 = 2;
                } else {
                    i3 = 3;
                    i4 = 1;
                }
                OmniLog.i("Call back remote video state changed ... " + i3 + " | " + i4);
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.VIDEO_REMOTE_STATE_CHANGED, str, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4), 0);
            }
        }
    }
}
