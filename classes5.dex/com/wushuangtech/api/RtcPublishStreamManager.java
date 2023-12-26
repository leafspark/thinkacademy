package com.wushuangtech.api;

import android.text.TextUtils;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.List;

public class RtcPublishStreamManager extends RtcBaseManager {
    private static final String TAG = "RtcPublishStreamManager";
    private List<String> mPushStreamUrls = new ArrayList();

    public RtcPublishStreamManager(String str) {
        super(str);
    }

    public int addPublishStreamUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return -5;
        }
        List<String> list = this.mPushStreamUrls;
        if (list == null || list.contains(str)) {
            return 0;
        }
        this.mPushStreamUrls.add(str);
        String str2 = TAG;
        OmniLog.i(OmniLog.RTC_PUBLISH_WATCH, str2, "Add a new stream url : " + str + ", channelName : " + this.mChannelName);
        RoomJni.getInstance().AddPublishStreamUrl(this.mChannelName, str);
        return 0;
    }

    public int removePublishStreamUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return -5;
        }
        List<String> list = this.mPushStreamUrls;
        if (list == null) {
            return 0;
        }
        list.remove(str);
        String str2 = TAG;
        OmniLog.i(OmniLog.RTC_PUBLISH_WATCH, str2, "Remove a new stream url : " + str + ", channelName : " + this.mChannelName);
        RoomJni.getInstance().RemovePublishStreamUrl(this.mChannelName, str);
        return 0;
    }

    public int removeMixUserVideo(long j) {
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(this.mChannelName);
        if (deviceManager == null) {
            return -3;
        }
        UserDeviceConfig videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(j);
        if (videoDeviceForDefault == null) {
            OmniLog.e("Remove mix user video failed! UserDeviceConfig is null! uid : " + j);
            return -3;
        } else if (this.mPushStreamUrls == null) {
            return 0;
        } else {
            String deviceId = videoDeviceForDefault.getDeviceId();
            for (int i = 0; i < this.mPushStreamUrls.size(); i++) {
                VideoJni.getInstance().RtmpAddVideo(this.mChannelName, j, deviceId, -1, this.mPushStreamUrls.get(i));
            }
            return 0;
        }
    }

    public List<String> getStreamUrlList() {
        synchronized (this.mLock) {
            if (this.mPushStreamUrls == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.mPushStreamUrls);
            return arrayList;
        }
    }

    public void clearResource() {
        List<String> list = this.mPushStreamUrls;
        if (list != null) {
            list.clear();
            this.mPushStreamUrls = null;
        }
    }
}
