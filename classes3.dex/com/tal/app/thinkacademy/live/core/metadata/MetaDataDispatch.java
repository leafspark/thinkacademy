package com.tal.app.thinkacademy.live.core.metadata;

import com.tal.app.thinkacademy.lib.util.ConvertUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveBackControllerProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MetaDataDispatch {
    private ILiveBackControllerProvider mLivePlaybackControllerProvider;

    public MetaDataDispatch(ILiveBackControllerProvider iLiveBackControllerProvider) {
        this.mLivePlaybackControllerProvider = iLiveBackControllerProvider;
    }

    public void dispatchMetaData(long j, long j2) {
        long millis2TimeSpan = ConvertUtils.millis2TimeSpan(j, 1000);
        List metaDataList = this.mLivePlaybackControllerProvider.getMetaDataList();
        Map metaDataMap = this.mLivePlaybackControllerProvider.getMetaDataMap();
        List<MetaDataEvent> findMetaDataEventsWitchCurrentTime = findMetaDataEventsWitchCurrentTime(millis2TimeSpan, metaDataList);
        if (findMetaDataEventsWitchCurrentTime != null && metaDataMap != null) {
            for (MetaDataEvent next : findMetaDataEventsWitchCurrentTime) {
                List<String> list = (List) metaDataMap.get(next.getIrcType());
                if (list != null) {
                    for (String activationPluginDriver : list) {
                        dispatchMessage(next, activationPluginDriver(activationPluginDriver));
                    }
                }
            }
        }
    }

    public void dispatchIrcMessage(String str, String str2) {
        List<String> list = (List) this.mLivePlaybackControllerProvider.getMetaDataMap().get(str);
        if (list != null) {
            for (String activationPluginDriver : list) {
                BaseLivePluginDriver activationPluginDriver2 = activationPluginDriver(activationPluginDriver);
                if (activationPluginDriver2 != null) {
                    activationPluginDriver2.onMessage(str, str2);
                }
            }
        }
    }

    private List<MetaDataEvent> findMetaDataEventsWitchCurrentTime(long j, List<MetaDataEvent> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaDataEvent next : list) {
            long beginTime = next.getBeginTime();
            long endTime = next.getEndTime();
            int i2 = (beginTime > j ? 1 : (beginTime == j ? 0 : -1));
            if (i2 == 0 || endTime == j || (i2 < 0 && i > 0)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private BaseLivePluginDriver activationPluginDriver(String str) {
        BaseLivePluginDriver baseLivePluginDriver = (BaseLivePluginDriver) this.mLivePlaybackControllerProvider.getActivePluginMap().get(str);
        if (baseLivePluginDriver != null) {
            return baseLivePluginDriver;
        }
        return this.mLivePlaybackControllerProvider.loadPlugin(str);
    }

    private void dispatchMessage(MetaDataEvent metaDataEvent, BaseLivePluginDriver baseLivePluginDriver) {
        if (baseLivePluginDriver != null && metaDataEvent != null) {
            baseLivePluginDriver.onMessage(metaDataEvent.getIrcType(), GsonUtils.toJson(metaDataEvent));
        }
    }
}
