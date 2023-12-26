package com.tal.app.thinkacademy.live.core.interfaces;

import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import java.util.List;
import java.util.Map;

public interface ILiveBackControllerProvider extends IBaseLiveControllerProvider {
    void dispatchIrcMessage(String str, String str2);

    List<MetaDataEvent> getMetaDataList();

    Map<String, List<String>> getMetaDataMap();
}
