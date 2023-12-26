package com.wushuangtech.library.video;

import android.text.TextUtils;
import com.wushuangtech.api.RtcBaseManager;
import com.wushuangtech.api.RtcDeviceManager;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.bean.VideoDualStreamBean;
import com.wushuangtech.utils.OmniLog;
import java.util.concurrent.ConcurrentHashMap;

public class VideoDualStreamManager extends RtcBaseManager {
    private static final String TAG = "VideoDualStreamManager";
    private ConcurrentHashMap<Long, VideoDualStreamBean> mStreams = new ConcurrentHashMap<>();

    public VideoDualStreamManager(String str) {
        super(str);
    }

    public int setRemoteVideoStreamType(long j, int i) {
        if (i != 0 && i != 1 && i != 2) {
            return -5;
        }
        String userDefaultDevice = getUserDefaultDevice(j);
        if (TextUtils.isEmpty(userDefaultDevice)) {
            OmniLog.i(OmniLog.DUAL_VIDEO, TAG, "Set remote video stream type faild... device is null... " + j);
            return -6;
        }
        ConcurrentHashMap<Long, VideoDualStreamBean> concurrentHashMap = this.mStreams;
        if (concurrentHashMap == null) {
            return 0;
        }
        VideoDualStreamBean videoDualStreamBean = concurrentHashMap.get(Long.valueOf(j));
        if (videoDualStreamBean == null || !userDefaultDevice.equals(videoDualStreamBean.mDeviceId)) {
            VideoDualStreamBean videoDualStreamBean2 = new VideoDualStreamBean();
            videoDualStreamBean2.mChannelName = this.mChannelName;
            videoDualStreamBean2.mUid = j;
            videoDualStreamBean2.mDeviceId = userDefaultDevice;
            videoDualStreamBean2.mStreamType = i;
            concurrentHashMap.put(Long.valueOf(j), videoDualStreamBean2);
        } else if (videoDualStreamBean.mStreamType == i) {
            return 0;
        } else {
            videoDualStreamBean.mStreamType = i;
        }
        RoomJni.getInstance().SetRemoteVideoStreamType(j, userDefaultDevice, i);
        OmniLog.i(OmniLog.DUAL_VIDEO, TAG, "Set remote video stream type success... " + userDefaultDevice + " | " + i);
        return 0;
    }

    private String getUserDefaultDevice(long j) {
        UserDeviceConfig videoDeviceForDefault;
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(this.mChannelName);
        if (deviceManager == null || (videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(j)) == null) {
            return null;
        }
        return videoDeviceForDefault.getDeviceId();
    }

    public void clearResource() {
        ConcurrentHashMap<Long, VideoDualStreamBean> concurrentHashMap = this.mStreams;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mStreams = null;
        }
    }
}
