package com.tal.app.thinkacademy.live.core.irc;

import android.os.SystemClock;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal100.chatsdk.PMDefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001b\u001a\u00020\u0013J*\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\tJ\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ*\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u00072\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\tJ\u0006\u0010'\u001a\u00020\u0013R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/live/core/irc/IrcTrackUtil;", "", "()V", "mIsFirst", "", "Ljava/lang/Boolean;", "mLiveInfo", "Lcom/tal100/chatsdk/PMDefs$LiveInfo;", "mLocation", "", "mReConnectionNum", "", "mRoomIds", "", "mStartConnectTime", "", "Ljava/lang/Long;", "mStartTime", "trackConnectFailEvent", "", "errorMsg", "trackConnectReStartEvent", "trackConnectStartEvent", "trackConnectSuccessEvent", "trackFailEvent", "errorType", "Lcom/tal/app/thinkacademy/live/core/irc/IrcFailEventType;", "trackReStartEvent", "trackSendMessageFailEvent", "ircMsgType", "Lcom/tal/app/thinkacademy/live/core/irc/IrcMsgType;", "sendMsgFailEventType", "Lcom/tal/app/thinkacademy/live/core/irc/SendMsgFailEventType;", "msgInfo", "trackSendMessageSuccessEvent", "trackStartEvent", "liveInfo", "roomIds", "location", "trackSuccessEvent", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcTrackUtil.kt */
public final class IrcTrackUtil {
    public static final IrcTrackUtil INSTANCE = new IrcTrackUtil();
    private static Boolean mIsFirst;
    private static PMDefs.LiveInfo mLiveInfo;
    private static String mLocation;
    private static int mReConnectionNum;
    private static List<String> mRoomIds;
    private static Long mStartConnectTime;
    private static Long mStartTime;

    private IrcTrackUtil() {
    }

    public final void trackStartEvent(PMDefs.LiveInfo liveInfo, List<String> list, String str) {
        mLiveInfo = liveInfo;
        mRoomIds = list;
        mReConnectionNum = 0;
        mStartTime = Long.valueOf(SystemClock.elapsedRealtime());
        mIsFirst = true;
        mLocation = str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "start");
            jSONObject.put("is_first", "是");
            jSONObject.put("re_connect_num", mReConnectionNum);
            if (str != null) {
                jSONObject.put("location", str);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackReStartEvent() {
        mStartTime = Long.valueOf(SystemClock.elapsedRealtime());
        mIsFirst = false;
        mReConnectionNum++;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "start");
            jSONObject.put("is_first", "否");
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str = mLocation;
            if (str != null) {
                jSONObject.put("location", str);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackFailEvent(IrcFailEventType ircFailEventType, String str) {
        Intrinsics.checkNotNullParameter(ircFailEventType, "errorType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "fail");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            jSONObject.put("error_type", ircFailEventType.getValue());
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
            PMDefs.LiveInfo liveInfo = mLiveInfo;
            if (liveInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                String str2 = liveInfo.classId;
                if (str2 != null) {
                    jSONObject2.put(LearnMaterialsListActivityKt.CLASSID, str2);
                }
                String str3 = liveInfo.liveId;
                if (str3 != null) {
                    jSONObject2.put("liveId", str3);
                }
                String str4 = liveInfo.nickname;
                if (str4 != null) {
                    jSONObject2.put("nickname", str4);
                }
                List<String> list = mRoomIds;
                if (list != null) {
                    jSONObject2.put("roomIds", list);
                }
                jSONObject.put("live_info", !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
            }
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str5 = mLocation;
            if (str5 != null) {
                jSONObject.put("location", str5);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackSuccessEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "success");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            Long l = mStartTime;
            if (l != null) {
                jSONObject.put("irc_join_room_duration", SystemClock.elapsedRealtime() - l.longValue());
            }
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str = mLocation;
            if (str != null) {
                jSONObject.put("location", str);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackConnectStartEvent() {
        mStartConnectTime = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "start");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str = mLocation;
            if (str != null) {
                jSONObject.put("location", str);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_connect", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackConnectReStartEvent() {
        mStartConnectTime = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "start");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str = mLocation;
            if (str != null) {
                jSONObject.put("location", str);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_connect", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackConnectFailEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "fail");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
            PMDefs.LiveInfo liveInfo = mLiveInfo;
            if (liveInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                String str2 = liveInfo.classId;
                if (str2 != null) {
                    jSONObject2.put(LearnMaterialsListActivityKt.CLASSID, str2);
                }
                String str3 = liveInfo.liveId;
                if (str3 != null) {
                    jSONObject2.put("liveId", str3);
                }
                String str4 = liveInfo.nickname;
                if (str4 != null) {
                    jSONObject2.put("nickname", str4);
                }
                List<String> list = mRoomIds;
                if (list != null) {
                    jSONObject2.put("roomIds", list);
                }
                jSONObject.put("live_info", !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
            }
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str5 = mLocation;
            if (str5 != null) {
                jSONObject.put("location", str5);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_connect", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackConnectSuccessEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "success");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            Long l = mStartConnectTime;
            if (l != null) {
                jSONObject.put("irc_connect_duration", SystemClock.elapsedRealtime() - l.longValue());
            }
            jSONObject.put("re_connect_num", mReConnectionNum);
            String str = mLocation;
            if (str != null) {
                jSONObject.put("location", str);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_connect", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackSendMessageSuccessEvent(IrcMsgType ircMsgType) {
        Intrinsics.checkNotNullParameter(ircMsgType, "ircMsgType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "success");
            jSONObject.put("irc_message_type", ircMsgType.getValue());
            HwTrackUtil.INSTANCE.track("hw_irc_send_message", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackSendMessageFailEvent(IrcMsgType ircMsgType, SendMsgFailEventType sendMsgFailEventType, String str, String str2) {
        Intrinsics.checkNotNullParameter(ircMsgType, "ircMsgType");
        Intrinsics.checkNotNullParameter(sendMsgFailEventType, "sendMsgFailEventType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, "fail");
            jSONObject.put("irc_message_type", ircMsgType.getValue());
            jSONObject.put("error_type", sendMsgFailEventType.getValue());
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
            if (str2 != null) {
                jSONObject.put("msg_info", str2);
            }
            HwTrackUtil.INSTANCE.track("hw_irc_send_message", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
