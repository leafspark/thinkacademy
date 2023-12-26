package com.wushuangtech.wstechapi.internal;

import android.content.Context;
import com.wushuangtech.api.ExternalRtmpPublishModule;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig;

class OmniRtmpModule {
    private static volatile OmniRtmpModule holder;
    private boolean mIsPushing;

    private OmniRtmpModule() {
    }

    public static OmniRtmpModule getInstance() {
        if (holder == null) {
            synchronized (OmniRtmpModule.class) {
                if (holder == null) {
                    holder = new OmniRtmpModule();
                }
            }
        }
        return holder;
    }

    /* access modifiers changed from: package-private */
    public Object receiveRtmpModuleEvent(OmniLocalModuleConfig omniLocalModuleConfig) {
        if (omniLocalModuleConfig == null) {
            return -5;
        }
        int i = omniLocalModuleConfig.eventType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return -3;
                        }
                        ExternalRtmpPublishModule.getInstance().setIsPause(false);
                        return 0;
                    }
                    ExternalRtmpPublishModule.getInstance().setIsPause(true);
                    return 0;
                }
            } else if (this.mIsPushing) {
                return 0;
            } else {
                ExternalRtmpPublishModule instance = ExternalRtmpPublishModule.getInstance();
                if (instance.startPublish((String) omniLocalModuleConfig.objs[0])) {
                    instance.setIsPause(false);
                    this.mIsPushing = true;
                    return 0;
                }
            }
            if (!this.mIsPushing) {
                return 0;
            }
            ExternalRtmpPublishModule instance2 = ExternalRtmpPublishModule.getInstance();
            if (instance2.stopPublish()) {
                instance2.setIsPause(true);
                this.mIsPushing = false;
                return 0;
            }
            ExternalRtmpPublishModule.getInstance().setIsPause(true);
            return 0;
        }
        MyAudioApi instance3 = MyAudioApi.getInstance((Context) null);
        ExternalRtmpPublishModule instance4 = ExternalRtmpPublishModule.getInstance();
        instance4.setExternalAudioModuleCallback(instance3);
        instance3.addAudioSender(instance4);
        instance4.setIsPause(true);
        return 0;
    }
}
