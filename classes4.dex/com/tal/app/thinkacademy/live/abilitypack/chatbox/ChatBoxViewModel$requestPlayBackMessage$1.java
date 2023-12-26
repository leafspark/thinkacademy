package com.tal.app.thinkacademy.live.abilitypack.chatbox;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.livemessage.entity.PlayBackMsgBean;
import com.tal.app.thinkacademy.live.business.livemessage.entity.PlayBackMsgEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel$requestPlayBackMessage$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxViewModel.kt */
public final class ChatBoxViewModel$requestPlayBackMessage$1 extends OmyCallback<HiResponse<PlayBackMsgBean>> {
    final /* synthetic */ ChatBoxViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatBoxViewModel$requestPlayBackMessage$1(ChatBoxViewModel chatBoxViewModel, ChatBoxViewModel$requestPlayBackMessage$2 chatBoxViewModel$requestPlayBackMessage$2) {
        super(chatBoxViewModel$requestPlayBackMessage$2);
        this.this$0 = chatBoxViewModel;
    }

    public void onSuccess(HiResponse<PlayBackMsgBean> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        XesLog.i(ChatBoxViewModel.TAG, Intrinsics.stringPlus("请求回放群聊消息成功", GsonUtil.getInstance().objToJson(hiResponse)));
        this.this$0.mIsRequesting = false;
        PlayBackMsgBean data = hiResponse.getData();
        if (data != null) {
            ChatBoxViewModel chatBoxViewModel = this.this$0;
            Integer page = data.getPage();
            if (page != null) {
                chatBoxViewModel.mCurPage = page.intValue();
            }
            Integer pages = data.getPages();
            if (pages != null) {
                chatBoxViewModel.mTotalPage = Integer.valueOf(pages.intValue());
            }
            ArrayList<PlayBackMsgEntity> messages = data.getMessages();
            if (messages != null) {
                if (chatBoxViewModel.mPlayBackMsgList == null) {
                    chatBoxViewModel.mPlayBackMsgList = messages;
                    return;
                }
                ArrayList access$getMPlayBackMsgList$p = chatBoxViewModel.mPlayBackMsgList;
                if (access$getMPlayBackMsgList$p != null) {
                    access$getMPlayBackMsgList$p.addAll(messages);
                }
            }
        }
    }
}
