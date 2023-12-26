package com.wushuangtech.wstechapi;

import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.inter.OmniInterSyncHelper;
import com.wushuangtech.wstechapi.internal.OmniInterSyncHelperImpl;
import com.wushuangtech.wstechapi.internal.OmniRtcChannelEventDispatcher;

public abstract class OmniRtcBaseChannel {
    protected final String TAG;
    protected String mChannelName;
    protected boolean mDefaultChannel;
    protected OmniRtcChannelEventHandler mEventHandler = null;
    protected final OmniInterSyncHelperImpl mOmniInterSyncHelperImpl;
    protected OmniRtcChannelEventDispatcher mRtcChannelEventDispatcher;

    public OmniRtcBaseChannel(String str, boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = new OmniInterSyncHelperImpl();
        this.mOmniInterSyncHelperImpl = omniInterSyncHelperImpl;
        String str2 = "OmniRtcChannel<" + str + ">";
        this.TAG = str2;
        this.mDefaultChannel = z;
        this.mChannelName = str;
        omniInterSyncHelperImpl.setTag(str2);
        omniInterSyncHelperImpl.setChannelType(false);
        omniInterSyncHelperImpl.setChannelName(str);
    }

    public void setRtcChannelEventHandler(final OmniRtcChannelEventHandler omniRtcChannelEventHandler) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "eventHandler : " + omniRtcChannelEventHandler, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (omniRtcChannelEventHandler == null) {
                    String str2 = OmniRtcBaseChannel.this.TAG;
                    OmniLog.e(str2, "Set call back failed... RtcChannelEventHandler is null! " + OmniRtcBaseChannel.this.mChannelName);
                    return null;
                }
                if (OmniRtcBaseChannel.this.mRtcChannelEventDispatcher == null) {
                    OmniRtcBaseChannel omniRtcBaseChannel = OmniRtcBaseChannel.this;
                    omniRtcBaseChannel.mRtcChannelEventDispatcher = new OmniRtcChannelEventDispatcher((OmniRtcChannel) omniRtcBaseChannel);
                    OmniRtcBaseChannel.this.mRtcChannelEventDispatcher.createCallBackThread();
                }
                OmniRtcBaseChannel.this.mEventHandler = omniRtcChannelEventHandler;
                OmniRtcBaseChannel.this.mRtcChannelEventDispatcher.setRtcChannelEventHandler(OmniRtcBaseChannel.this.mEventHandler);
                return null;
            }
        });
    }

    public OmniRtcChannelEventHandler getEventHandler() {
        return this.mEventHandler;
    }

    public OmniInterSyncHelperImpl getInterSyncHeplerImpl() {
        return this.mOmniInterSyncHelperImpl;
    }

    public String getInvokedMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
}
