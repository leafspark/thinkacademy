package com.tal.app.thinkacademy.live.business.raisehand;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import org.json.JSONObject;

public class RaiseHandUtil {
    private static final String TAG = "RaiseHandUtil";

    public static void sendRaiseHandMsg(IircControllerProvider iircControllerProvider, String str, String str2, JSONObject jSONObject) {
        PluginEventBus.onEvent(DataBusKey.RAISE_HAND, new PluginEventData(RaiseHandEvent.class, DataBusKey.RAISE_HAND, ""));
        sendRaiseHandToTeacher();
        sendRaiseHandToTutor(iircControllerProvider, str, str2, jSONObject);
        if (iircControllerProvider != null) {
            MsgBean msgBean = new MsgBean();
            msgBean.setIrcType(DataBusKey.RAISE_HAND);
            iircControllerProvider.sendNoticeMessage(msgBean);
        }
    }

    private static void sendRaiseHandToTeacher() {
        PluginEventBus.onEvent(DataBusKey.CLASS_HANDUP, new PluginEventData(RaiseHandUtil.class, DataBusKey.CLASS_HANDUP, ""));
    }

    private static void sendRaiseHandToTutor(IircControllerProvider iircControllerProvider, String str, String str2, JSONObject jSONObject) {
        if (iircControllerProvider != null) {
            if (TextUtils.isEmpty(str)) {
                XesLog.dt(TAG, "辅导老师昵称为空");
            } else if (TextUtils.isEmpty(str2)) {
                XesLog.dt(TAG, "聊天消息昵称为空");
            } else if (jSONObject == null) {
                XesLog.dt(TAG, "举手参数为空");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("type", "160");
                    jSONObject2.put("name", str2);
                    jSONObject2.put("parameter", jSONObject);
                    jSONObject2.put("msg", "raiseHand");
                    iircControllerProvider.sendPeerNoticeMessage(str, !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendRaiseHandMsg(IircControllerProvider iircControllerProvider) {
        if (iircControllerProvider != null) {
            MsgBean msgBean = new MsgBean();
            msgBean.setIrcType(DataBusKey.RAISE_HAND);
            iircControllerProvider.sendNoticeMessage(msgBean);
        }
    }
}
