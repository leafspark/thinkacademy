package com.wushuangtech.handler;

import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.bean.ChannelInfoBean;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.log.RtcHeartbeatReporter;
import java.util.List;

public class RtcGlobalSignalPreHandler {
    public void handleSessionId(String str, String str2) {
        GlobalHolder.getInstance().handleUserActionReport("", str, 7, str2);
        RtcHeartbeatReporter rtcHeartbeatReporter = GlobalHolder.getInstance().getRtcHeartbeatReporter(str);
        if (rtcHeartbeatReporter != null) {
            rtcHeartbeatReporter.setSessionId(str2);
        } else {
            GlobalHolder.getInstance().putCacheForSessionId(String.valueOf(str), str2);
        }
    }

    public void prefixHandleRoomConnectSuccess() {
        List<ChannelInfoBean> rtcChannelNames = GlobalHolder.getInstance().getRtcChannelNames();
        if (rtcChannelNames != null) {
            for (ChannelInfoBean channelInfoBean : rtcChannelNames) {
                CommonEventBean commonEventBean = new CommonEventBean();
                commonEventBean.mObjects = new Object[]{channelInfoBean.mChannelName, 0L, true};
                ExternalVideoModule.getInstance().resetVideoDecoderStatus(commonEventBean);
            }
        }
    }
}
