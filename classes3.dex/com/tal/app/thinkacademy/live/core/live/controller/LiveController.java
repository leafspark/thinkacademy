package com.tal.app.thinkacademy.live.core.live.controller;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.callback.BinaryMessageCallback;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.IrcController;
import com.tal.app.thinkacademy.live.core.irc.IrcDispatch;
import com.tal.app.thinkacademy.live.core.irc.entity.BatchBinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;
import com.tal.app.thinkacademy.live.core.irc.entity.IrcInitEntity;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;
import com.tal.app.thinkacademy.live.core.plugin.PluginLoadHelper;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LiveController extends BaseLiveController implements ILiveControllerProvider {
    private static final String TAG = "LiveController";
    protected Set<BinaryMessageCallback> mBinaryMessageCallbacks = new HashSet();
    protected IrcController mIrcController;
    protected IrcDispatch mIrcDispatch;
    protected Map<String, List<String>> mIrcTypeMap;

    public boolean isLive() {
        return true;
    }

    public void unregisterPlayerTimeCallback(PlayerTimeCallBack playerTimeCallBack) {
    }

    public LiveController(ILiveActivityProvider iLiveActivityProvider) {
        super(iLiveActivityProvider);
    }

    public void onEnterReqSuccess(EnterEntity enterEntity, boolean z) {
        super.onEnterReqSuccess(enterEntity, z);
    }

    /* access modifiers changed from: protected */
    public List<PluginConfData> initPluginConfig(Context context) {
        List<PluginConfData> list;
        if ("2".equals(this.mClassType)) {
            list = PluginLoadHelper.parsePluginConf(1, 0);
        } else {
            list = PluginLoadHelper.parsePluginConf(0, 0);
        }
        buildIrcDataMap(list);
        return list;
    }

    private void buildIrcDataMap(List<PluginConfData> list) {
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            for (PluginConfData next : list) {
                List<String> ircType = next.getIrcType();
                if (ircType != null) {
                    for (String next2 : ircType) {
                        List list2 = (List) hashMap.get(next2);
                        if (list2 == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(next.getClassName());
                            hashMap.put(next2, arrayList);
                        } else {
                            list2.add(next.getClassName());
                        }
                    }
                }
            }
            this.mIrcTypeMap = hashMap;
        }
    }

    public void onInitModuleReqSuccess(InitModuleEntity initModuleEntity) {
        super.onInitModuleReqSuccess(initModuleEntity);
        initIrc();
    }

    private void initIrc() {
        String str;
        String str2;
        List<String> list;
        PlanInfoProxy planInfo = this.mDataStorage.getPlanInfo();
        EnterConfigProxy enterConfig = this.mDataStorage.getEnterConfig();
        CourseInfoProxy courseInfo = this.mDataStorage.getCourseInfo();
        String str3 = "";
        String stuIrcId = enterConfig == null ? str3 : enterConfig.getStuIrcId();
        if (planInfo == null) {
            str = str3;
        } else {
            str = planInfo.getId();
        }
        if (enterConfig == null) {
            str2 = str3;
        } else {
            str2 = enterConfig.getBusinessId();
        }
        if (enterConfig == null) {
            list = null;
        } else {
            list = enterConfig.getIrcRooms();
        }
        IrcInitEntity ircInitEntity = new IrcInitEntity(stuIrcId, str, str2, list);
        if (courseInfo != null) {
            str3 = String.valueOf(courseInfo.getClassId());
        }
        ircInitEntity.setClassId(str3);
        IrcController ircController = new IrcController(this, ircInitEntity);
        this.mIrcController = ircController;
        ircController.initController();
        this.mIrcDispatch = new IrcDispatch(this);
    }

    public Map<String, List<String>> getIrcTypeMap() {
        return this.mIrcTypeMap;
    }

    public void dispatchIrcMessage(String str, String str2) {
        this.mIrcDispatch.dispatchIrcMessage(str, str2);
    }

    public void dispatchIrcMessage(Map<String, String> map) {
        this.mIrcDispatch.dispatchIrcMessageMap(map);
    }

    public void dispatchBinaryMessage(BinaryMessage binaryMessage) {
        Set<BinaryMessageCallback> set = this.mBinaryMessageCallbacks;
        if (set != null) {
            for (BinaryMessageCallback onBinaryMessage : set) {
                onBinaryMessage.onBinaryMessage(binaryMessage);
            }
        }
    }

    public void dispatchBinaryMessage(BinaryMessageInfo binaryMessageInfo) {
        Set<BinaryMessageCallback> set = this.mBinaryMessageCallbacks;
        if (set != null) {
            for (BinaryMessageCallback onBinaryMessage : set) {
                onBinaryMessage.onBinaryMessage(binaryMessageInfo);
            }
        }
    }

    public void dispatchBatchBinaryMessage(BatchBinaryMessage batchBinaryMessage) {
        Set<BinaryMessageCallback> set = this.mBinaryMessageCallbacks;
        if (set != null) {
            for (BinaryMessageCallback onBatchHistoryBinaryMessage : set) {
                onBatchHistoryBinaryMessage.onBatchHistoryBinaryMessage(batchBinaryMessage);
            }
        }
    }

    public Set<BinaryMessageCallback> getBinaryCallbackList() {
        return this.mBinaryMessageCallbacks;
    }

    public void requestAllRoomData() {
        List<String> ircRooms;
        EnterConfigProxy enterConfig = this.mDataStorage.getEnterConfig();
        if (enterConfig != null && (ircRooms = enterConfig.getIrcRooms()) != null) {
            for (String next : ircRooms) {
                IrcController ircController = this.mIrcController;
                if (ircController != null) {
                    ircController.requestAllRoomData(next);
                }
            }
        }
    }

    public IircControllerProvider getIrcControllerProvider() {
        return this.mIrcController;
    }

    public void registerPlayerTimeCallback(PlayerTimeCallBack playerTimeCallBack) {
        throw new IllegalArgumentException("直播的时候不允许注册播放器进度的回掉");
    }

    public void doPlaying(long j, long j2) {
        throw new IllegalArgumentException("直播的时候不允许调用播放器进度的分发");
    }

    public void doSeiCurrent(long j) {
        throw new IllegalArgumentException("直播的时候不允许调用播放器sei的分发");
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        XesLog.dt(TAG, new Object[]{"onLifecycleDestroy"});
        onDestroy();
    }

    private void onDestroy() {
        IrcController ircController = this.mIrcController;
        if (ircController != null) {
            ircController.onDestroy();
        }
        IrcDispatch ircDispatch = this.mIrcDispatch;
        if (ircDispatch != null) {
            ircDispatch.destroy();
        }
        Map<String, List<String>> map = this.mIrcTypeMap;
        if (map != null) {
            map.clear();
            this.mIrcTypeMap = null;
        }
        super.destroy();
    }
}
