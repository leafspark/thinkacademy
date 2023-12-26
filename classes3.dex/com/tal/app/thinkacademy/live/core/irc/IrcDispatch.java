package com.tal.app.thinkacademy.live.core.irc;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.common.debugger.DebugIrc;
import com.tal.app.thinkacademy.common.debugger.IrcDispatchHandler;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.ShortIrcMessageEntity;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IrcDispatch implements IrcDispatchHandler {
    private static final String TAG = "IrcDispatch";
    private boolean isFirstJoinRoom = false;
    private boolean isTutorVideoCall = false;
    protected Map<String, Long> mLastMessageTimeMap = new HashMap();
    private ILiveControllerProvider mLiveControllerProvider;

    public IrcDispatch(ILiveControllerProvider iLiveControllerProvider) {
        this.mLiveControllerProvider = iLiveControllerProvider;
        XesDataBus.with("class_tutor_video_call").observe((FragmentActivity) iLiveControllerProvider.getWeakRefContext().get(), new IrcDispatch$$ExternalSyntheticLambda0(this));
        DebugIrc.init(this);
    }

    public /* synthetic */ void lambda$new$0$IrcDispatch(Object obj) {
        this.isTutorVideoCall = ((Boolean) obj).booleanValue();
    }

    private void dispatchIrcMessage(final String str, final String str2, final boolean z) {
        XesLog.dt(TAG, new Object[]{"进入消息分发: irckey:" + str + " : " + str2});
        if (this.isTutorVideoCall) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("video_mic");
            arrayList.add("speech_interact");
            if (arrayList.contains(str)) {
                return;
            }
        }
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (IrcDispatch.this.processLastMessageTime(str, str2, z)) {
                    XesLog.dt(IrcDispatch.TAG, new Object[]{"这条消息需要进行分发: irckey:" + str});
                    IrcDispatch.this.findPluginObjectAndDispatch(str, str2, IrcDispatch.this.findIrcTypeClassNameList(str));
                    return;
                }
                XesLog.dt(IrcDispatch.TAG, new Object[]{"当前这条消息不需要进行分发:" + str + " : " + str2});
            }
        });
        if (LocalBusinessKey.LOCAL_JOIN_ROOM.equals(str)) {
            this.isFirstJoinRoom = true;
        }
        if (!IrcDispatchKey.modeChange.equals(str)) {
            return;
        }
        if (this.isFirstJoinRoom) {
            this.isFirstJoinRoom = false;
        } else if (str2 != null) {
            try {
                if (!TextUtils.isEmpty(new JSONObject(str2).optString(IrcDispatchKey.modeChange)) && z) {
                    XesLog.dt(TAG, new Object[]{"过虑到主辅切流的消息 请求全部房间历史数据"});
                    this.mLiveControllerProvider.requestAllRoomData();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean processLastMessageTime(String str, String str2, boolean z) {
        if (!z) {
            return true;
        }
        try {
            String optString = new JSONObject(str2).optString("sendTime");
            if (!TextUtils.isEmpty(optString)) {
                long tryParseLong = ParseUtils.tryParseLong(optString, 0);
                if (tryParseLong == -1) {
                    XesLog.dt(TAG, new Object[]{"当前这条消息是本地消息，直接分发 irckey:" + str});
                    return true;
                }
                Map<String, Long> map = this.mLastMessageTimeMap;
                if (map != null) {
                    Long l = map.get(str);
                    if (z) {
                        if (l != null) {
                            if (l.longValue() >= tryParseLong) {
                                l.longValue();
                                return false;
                            }
                        }
                        this.mLastMessageTimeMap.put(str, Long.valueOf(tryParseLong));
                        return true;
                    }
                    if (l == null || l.longValue() < tryParseLong) {
                        this.mLastMessageTimeMap.put(str, Long.valueOf(tryParseLong));
                    }
                    return true;
                }
                return false;
            }
            XesLog.dt(TAG, new Object[]{"当前消息没有sendTime 为了兼容辅导端没有sendTime 暂时进行分发 irckey:" + str});
            return true;
        } catch (Exception e) {
            XesLog.et(TAG, new Object[]{"irc消息分发消息转json对象失败 ：" + e.getMessage()});
        }
    }

    public void dispatchIrcMessage(String str, String str2) {
        dispatchIrcMessage(str, str2, false);
    }

    public void dispatchIrcMessageMap(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            resetLastSendTime();
            List<ShortIrcMessageEntity> shortMessageBySendTime = shortMessageBySendTime(map);
            if (shortMessageBySendTime != null) {
                for (ShortIrcMessageEntity next : shortMessageBySendTime) {
                    dispatchIrcMessage(next.getIrcKey(), next.getMessage(), false);
                }
            }
        }
    }

    private List<ShortIrcMessageEntity> shortMessageBySendTime(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : map.keySet()) {
            String str = map.get(next);
            try {
                arrayList.add(new ShortIrcMessageEntity(next, ParseUtils.tryParseLong(new JSONObject(str).optString("sendTime"), 0), str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private void resetLastSendTime() {
        this.mLastMessageTimeMap.clear();
    }

    /* access modifiers changed from: private */
    public void findPluginObjectAndDispatch(String str, String str2, List<String> list) {
        PluginConfData pluginConfData;
        if (list != null) {
            Map activePluginMap = this.mLiveControllerProvider.getActivePluginMap();
            Map pluginConfDataMap = this.mLiveControllerProvider.getPluginConfDataMap();
            if (activePluginMap != null && pluginConfDataMap != null) {
                for (String next : list) {
                    BaseLivePluginDriver baseLivePluginDriver = (BaseLivePluginDriver) activePluginMap.get(next);
                    if (baseLivePluginDriver == null && (pluginConfData = (PluginConfData) pluginConfDataMap.get(next)) != null) {
                        List<String> noActiveKey = pluginConfData.getNoActiveKey();
                        if (noActiveKey == null || !noActiveKey.contains(str)) {
                            baseLivePluginDriver = this.mLiveControllerProvider.loadPlugin(next);
                        }
                    }
                    if (baseLivePluginDriver != null) {
                        realDispatchIrcMessage(str, str2, baseLivePluginDriver);
                    }
                }
            }
        }
    }

    private void realDispatchIrcMessage(String str, String str2, BaseLivePluginDriver baseLivePluginDriver) {
        baseLivePluginDriver.onMessage(str, str2);
    }

    /* access modifiers changed from: private */
    public List<String> findIrcTypeClassNameList(String str) {
        ILiveControllerProvider iLiveControllerProvider;
        Map ircTypeMap;
        if (TextUtils.isEmpty(str) || (iLiveControllerProvider = this.mLiveControllerProvider) == null || (ircTypeMap = iLiveControllerProvider.getIrcTypeMap()) == null) {
            return null;
        }
        return (List) ircTypeMap.get(str);
    }

    public void destroy() {
        DebugIrc.destroy();
        Map<String, Long> map = this.mLastMessageTimeMap;
        if (map != null) {
            map.clear();
            this.mLastMessageTimeMap = null;
        }
        if (this.mLiveControllerProvider != null) {
            this.mLiveControllerProvider = null;
        }
    }
}
