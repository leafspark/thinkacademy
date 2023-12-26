package com.tal.appthinkacademy.push;

import android.content.Context;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.main.push.PushCenter;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.appthinkacademy.Tag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eH\u0016J\f\u0010\u000f\u001a\u00020\f*\u00020\bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/tal/appthinkacademy/push/HwIntentService;", "Lcom/igexin/sdk/GTIntentService;", "()V", "onNotificationMessageArrived", "", "context", "Landroid/content/Context;", "message", "Lcom/igexin/sdk/message/GTNotificationMessage;", "onNotificationMessageClicked", "onReceiveClientId", "clientId", "", "onReceiveMessageData", "Lcom/igexin/sdk/message/GTTransmitMessage;", "toJson", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwIntentService.kt */
public final class HwIntentService extends GTIntentService {
    public void onReceiveClientId(Context context, String str) {
        XesLog.s(Tag.PUSH, new Object[]{Intrinsics.stringPlus("个推登录成功，cid=", str)});
        ShareDataManager.getInstance().put("push_client_id", str == null ? "" : str, ShareDataManager.SHAREDATA_NOT_CLEAR);
        StickyLiveData with = XesDataBus.with("push_client_login");
        if (str == null) {
            str = "";
        }
        with.postStickyData(str);
    }

    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
        byte[] payload;
        PushAutoTrackHelper.onGeTuiReceiveMessageData(gTTransmitMessage);
        String str = null;
        String taskId = gTTransmitMessage == null ? null : gTTransmitMessage.getTaskId();
        if (gTTransmitMessage != null) {
            str = gTTransmitMessage.getMessageId();
        }
        String str2 = "";
        if (!(gTTransmitMessage == null || (payload = gTTransmitMessage.getPayload()) == null)) {
            str2 = new String(payload, Charsets.UTF_8);
        }
        if (str2.length() == 0) {
            XesLog.e(Tag.PUSH, new Object[]{"通知透传信息为空 messageId=" + str + " taskId=" + taskId});
            return;
        }
        XesLog.s(Tag.PUSH, new Object[]{"通知中心缓存消息 messageId=" + str + ", taskId=" + taskId + ", router=" + str2});
        PushCenter.Companion.get().savePayloadMsg(str2);
        if (PushCenter.Companion.get().isMainAlive()) {
            XesLog.i(Tag.PUSH, new Object[]{"首页存在，通知中心直接分发"});
            PushCenter.Companion.get().consume();
        }
    }

    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
        PushAutoTrackHelper.onGeTuiNotificationClicked(gTNotificationMessage);
        XesLogTag xesLogTag = Tag.PUSH;
        Object[] objArr = new Object[1];
        objArr[0] = Intrinsics.stringPlus("通知点击 : ", gTNotificationMessage == null ? null : toJson(gTNotificationMessage));
        XesLog.a(xesLogTag, objArr);
    }

    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
        XesLogTag xesLogTag = Tag.PUSH;
        Object[] objArr = new Object[1];
        objArr[0] = Intrinsics.stringPlus("通知到达 : ", gTNotificationMessage == null ? null : toJson(gTNotificationMessage));
        XesLog.s(xesLogTag, objArr);
    }

    private final String toJson(GTNotificationMessage gTNotificationMessage) {
        return "{messageId:" + gTNotificationMessage.getMessageId() + ", taskId:" + gTNotificationMessage.getTaskId() + ", title:" + gTNotificationMessage.getTitle() + ", content:" + gTNotificationMessage.getContent() + ", clientId:" + gTNotificationMessage.getClientId() + ", pkgName:" + gTNotificationMessage.getPkgName() + ", appId:" + gTNotificationMessage.getAppid() + '}';
    }
}
