package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import com.tal.app.thinkacademy.live.core.layout.LiveAreaType;

public class DriverDelegateFactory {
    public static BaseClassRoomTitleBarDelegate create(LiveAreaType liveAreaType, boolean z) {
        if (z) {
            if (liveAreaType == LiveAreaType.LIVE_BIG) {
                return new BigClassAuditorDelegate();
            }
            return new PadSmallClassBarDelegate();
        } else if (liveAreaType == LiveAreaType.LIVE_SMALL_PAD) {
            return new PadSmallClassBarDelegate();
        } else {
            if (liveAreaType == LiveAreaType.LIVE_SMALL_PHONE) {
                return new PhoneSmallClassBarDelegate();
            }
            return new BigClassTitleBarBarDelegate();
        }
    }
}
