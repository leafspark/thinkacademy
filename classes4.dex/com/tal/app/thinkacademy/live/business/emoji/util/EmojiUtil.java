package com.tal.app.thinkacademy.live.business.emoji.util;

import android.os.Build;
import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineLottieResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.event.SendEmojiEvent;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.FromUserInfoBean;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiViewEntity;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.HashMap;
import java.util.Map;

public class EmojiUtil {
    private static Map<String, String> DEVICE_DOWN_NEGATIVE = null;
    private static final String TAG = "EmojiUtil";

    static {
        HashMap hashMap = new HashMap();
        DEVICE_DOWN_NEGATIVE = hashMap;
        hashMap.put("SM-P555C", "三星GalaxyTabA");
    }

    public static void sendPhoneEmojiMsg(ILiveRoomProvider iLiveRoomProvider, EmojiBean emojiBean) {
        String str;
        if (emojiBean != null && iLiveRoomProvider != null) {
            IircControllerProvider ircControllerProvider = iLiveRoomProvider.getIrcControllerProvider();
            FromUserInfoBean fromUserInfoBean = null;
            UserInfoProxy userInfo = (iLiveRoomProvider.getDataStorage() == null || iLiveRoomProvider.getDataStorage().getUserInfo() == null) ? null : iLiveRoomProvider.getDataStorage().getUserInfo();
            if (userInfo != null) {
                fromUserInfoBean = new FromUserInfoBean();
                if (!StringUtils.isEmpty(userInfo.getNickName())) {
                    str = userInfo.getNickName();
                } else if (!StringUtils.isEmpty(userInfo.getName())) {
                    str = userInfo.getName();
                } else {
                    str = userInfo.getEnglishName();
                }
                fromUserInfoBean.setUsername(str);
                fromUserInfoBean.setPath(userInfo.getAvatar());
            }
            MsgBean msgBean = new MsgBean();
            if (emojiBean.getType() == 1) {
                EmojiBean emojiBean2 = new EmojiBean(emojiBean.getName(), emojiBean.getType());
                PluginEventBus.onEvent(DataBusKey.SEND_EMOJI, new PluginEventData(SendEmojiEvent.class, DataBusKey.SEND_EMOJI, GsonUtil.getInstance().objToJson(emojiBean2)));
                if (ircControllerProvider != null) {
                    msgBean.setIrcType(DataBusKey.SEND_EMOJI);
                    if (fromUserInfoBean != null) {
                        msgBean.setFrom(fromUserInfoBean);
                    }
                    msgBean.setData(emojiBean2);
                    ircControllerProvider.sendNormalMessage(msgBean);
                }
            }
        }
    }

    public static EmojiBean sendPadEmojiMsg(ILiveRoomProvider iLiveRoomProvider, EmojiAssembleBean emojiAssembleBean) {
        return sendPadEmojiMsg(iLiveRoomProvider, emojiAssembleBean, (long[]) null);
    }

    public static EmojiBean sendPadEmojiMsg(ILiveRoomProvider iLiveRoomProvider, EmojiAssembleBean emojiAssembleBean, long[] jArr) {
        FromUserInfoBean fromUserInfoBean;
        EmojiBean emojiBean;
        String str;
        EmojiBean emojiBean2 = null;
        if (!(emojiAssembleBean == null || iLiveRoomProvider == null)) {
            UserInfoProxy userInfo = (iLiveRoomProvider.getDataStorage() == null || iLiveRoomProvider.getDataStorage().getUserInfo() == null) ? null : iLiveRoomProvider.getDataStorage().getUserInfo();
            if (userInfo != null) {
                fromUserInfoBean = new FromUserInfoBean();
                if (!StringUtils.isEmpty(userInfo.getNickName())) {
                    str = userInfo.getNickName();
                } else if (!StringUtils.isEmpty(userInfo.getName())) {
                    str = userInfo.getName();
                } else {
                    str = userInfo.getEnglishName();
                }
                fromUserInfoBean.setUsername(str);
                fromUserInfoBean.setPath(userInfo.getAvatar());
            } else {
                fromUserInfoBean = null;
            }
            MsgBean msgBean = new MsgBean();
            if (emojiAssembleBean.getType().intValue() == 1) {
                emojiBean2 = new EmojiBean(emojiAssembleBean.getEmojiName(), emojiAssembleBean.getType().intValue());
                PluginEventBus.onEvent(DataBusKey.SEND_EMOJI, new PluginEventData(SendEmojiEvent.class, DataBusKey.SEND_EMOJI, GsonUtil.getInstance().objToJson(emojiBean2)));
                msgBean.setIrcType(DataBusKey.SEND_EMOJI);
                if (fromUserInfoBean != null) {
                    msgBean.setFrom(fromUserInfoBean);
                }
                msgBean.setData(emojiBean2);
            } else {
                if (emojiAssembleBean.getType().intValue() == 2) {
                    emojiBean = new EmojiBean(emojiAssembleBean.getEmojiName(), emojiAssembleBean.getType().intValue(), new EmojiOnlineLottieResourceBean(emojiAssembleBean.getLottieUrl()));
                    PluginEventBus.onEvent(DataBusKey.SEND_EMOJI, new PluginEventData(SendEmojiEvent.class, DataBusKey.SEND_EMOJI, GsonUtil.getInstance().objToJson(emojiBean)));
                    EmojiBean emojiBean3 = new EmojiBean(emojiAssembleBean.getEmojiName(), 2, new EmojiViewEntity(emojiAssembleBean.getEmojiName(), emojiAssembleBean.getEmojiId(), emojiAssembleBean.getEmojiPicture(), emojiAssembleBean.getLottieUrl(), -1, 2));
                    msgBean.setIrcType("animation_emoji");
                    if (fromUserInfoBean != null) {
                        msgBean.setFrom(fromUserInfoBean);
                    }
                    msgBean.setData(emojiBean3);
                } else if (emojiAssembleBean.getType().intValue() == 3) {
                    emojiBean = new EmojiBean(emojiAssembleBean.getEmojiName(), emojiAssembleBean.getType().intValue(), new EmojiOnlineImageResourceBean(emojiAssembleBean.getLottieUrl()));
                    PluginEventBus.onEvent(DataBusKey.SEND_EMOJI, new PluginEventData(SendEmojiEvent.class, DataBusKey.SEND_EMOJI, GsonUtil.getInstance().objToJson(emojiBean)));
                    EmojiBean emojiBean4 = new EmojiBean(emojiAssembleBean.getEmojiName(), 3, new EmojiViewEntity(emojiAssembleBean.getEmojiName(), emojiAssembleBean.getEmojiId(), emojiAssembleBean.getEmojiPicture(), emojiAssembleBean.getLottieUrl(), -1, 3));
                    msgBean.setIrcType("animation_emoji");
                    if (fromUserInfoBean != null) {
                        msgBean.setFrom(fromUserInfoBean);
                    }
                    msgBean.setData(emojiBean4);
                }
                emojiBean2 = emojiBean;
            }
            IircControllerProvider ircControllerProvider = iLiveRoomProvider.getIrcControllerProvider();
            if (ircControllerProvider != null && !TextUtils.isEmpty(msgBean.getIrcType())) {
                ircControllerProvider.sendNormalMessage(msgBean, jArr);
            }
        }
        return emojiBean2;
    }

    public static int getOffsetDirection() {
        try {
            XesLog.dt(TAG, "设备型号：" + Build.MODEL);
            Map<String, String> map = DEVICE_DOWN_NEGATIVE;
            if (map == null || map.size() <= 0 || !DEVICE_DOWN_NEGATIVE.containsKey(Build.MODEL)) {
                return 1;
            }
            return 2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
