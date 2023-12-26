package com.tal.app.thinkacademy.live.core.backplay.controller;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.backplay.http.response.MetaDataEntity;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveBackControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.live.controller.BaseLiveController;
import com.tal.app.thinkacademy.live.core.metadata.MetaDataDispatch;
import com.tal.app.thinkacademy.live.core.plugin.PluginLoadHelper;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivePlayBackController extends BaseLiveController implements ILiveBackControllerProvider {
    private static final String TAG = "LivePlayBackController";
    protected MetaDataDispatch mMetaDataDispatch = new MetaDataDispatch(this);
    protected List<MetaDataEvent> mMetaDataEventList;
    protected Map<String, List<String>> mMetaDataMap;
    protected List<PlayerTimeCallBack> mPlayerTimeCallBack = new ArrayList();

    public boolean isLive() {
        return false;
    }

    public LivePlayBackController(ILiveActivityProvider iLiveActivityProvider) {
        super(iLiveActivityProvider);
    }

    /* access modifiers changed from: protected */
    public List<PluginConfData> initPluginConfig(Context context) {
        List<PluginConfData> parsePluginConf = PluginLoadHelper.parsePluginConf(0, 1);
        buildMetaDataMap(parsePluginConf);
        return parsePluginConf;
    }

    public void onMetaDataSuccess(MetaDataEntity metaDataEntity) {
        if (metaDataEntity != null) {
            this.mDataStorage.setMetaDataResp(metaDataEntity);
            this.mMetaDataEventList = metaDataEntity.getEvent();
            onMetadataRequestSuccess();
        }
    }

    public void onPlaybackUrlSuccess(PlaybackUrlEntity playbackUrlEntity) {
        if (playbackUrlEntity != null) {
            this.mDataStorage.setPlaybackUrlResp(playbackUrlEntity);
        }
    }

    private void buildMetaDataMap(List<PluginConfData> list) {
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            for (PluginConfData next : list) {
                List<String> metaDataKey = next.getMetaDataKey();
                if (metaDataKey != null) {
                    for (String str : metaDataKey) {
                        List list2 = (List) hashMap.get(str);
                        if (list2 == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(next.getClassName());
                            hashMap.put(str, arrayList);
                        } else {
                            list2.add(next.getClassName());
                        }
                    }
                }
            }
            this.mMetaDataMap = hashMap;
        }
    }

    public Map<String, List<String>> getMetaDataMap() {
        return this.mMetaDataMap;
    }

    public List<MetaDataEvent> getMetaDataList() {
        return this.mMetaDataEventList;
    }

    public void dispatchIrcMessage(String str, String str2) {
        this.mMetaDataDispatch.dispatchIrcMessage(str, str2);
    }

    public IircControllerProvider getIrcControllerProvider() {
        throw new IllegalArgumentException("回放没有初始化irc，不允许调用irc 的能力");
    }

    public void registerPlayerTimeCallback(PlayerTimeCallBack playerTimeCallBack) {
        if (this.mPlayerTimeCallBack == null) {
            this.mPlayerTimeCallBack = new ArrayList();
        }
        this.mPlayerTimeCallBack.add(playerTimeCallBack);
    }

    public void unregisterPlayerTimeCallback(PlayerTimeCallBack playerTimeCallBack) {
        List<PlayerTimeCallBack> list = this.mPlayerTimeCallBack;
        if (list != null) {
            list.remove(playerTimeCallBack);
        }
    }

    public void doPlaying(long j, long j2) {
        List<PlayerTimeCallBack> list = this.mPlayerTimeCallBack;
        if (list != null) {
            for (PlayerTimeCallBack onPlaying : list) {
                onPlaying.onPlaying(j, j2);
            }
        }
    }

    public void doSeiCurrent(long j) {
        List<PlayerTimeCallBack> list = this.mPlayerTimeCallBack;
        if (list != null) {
            for (PlayerTimeCallBack onSeiCurrent : list) {
                onSeiCurrent.onSeiCurrent(j);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        LivePlayBackController.super.onLifecycleDestroy(lifecycleOwner);
        destroy();
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        Map<String, List<String>> map = this.mMetaDataMap;
        if (map != null) {
            map.clear();
            this.mMetaDataMap = null;
        }
        List<MetaDataEvent> list = this.mMetaDataEventList;
        if (list != null) {
            list.clear();
            this.mMetaDataEventList = null;
        }
        List<PlayerTimeCallBack> list2 = this.mPlayerTimeCallBack;
        if (list2 != null) {
            list2.clear();
        }
        this.mMetaDataDispatch = null;
        LivePlayBackController.super.destroy();
    }
}
