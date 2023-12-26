package com.tal.app.thinkacademy.live.business.livemessage;

import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayBackMsgPluginDriver.kt */
final class PlayBackMsgPluginDriver$observeListener$1 extends Lambda implements Function1<ChatBoxListenerBody, Unit> {
    final /* synthetic */ PlayBackMsgPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayBackMsgPluginDriver$observeListener$1(PlayBackMsgPluginDriver playBackMsgPluginDriver) {
        super(1);
        this.this$0 = playBackMsgPluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChatBoxListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChatBoxListenerBody chatBoxListenerBody) {
        Intrinsics.checkNotNullParameter(chatBoxListenerBody, "$this$observeListener");
        final PlayBackMsgPluginDriver playBackMsgPluginDriver = this.this$0;
        chatBoxListenerBody.onPlayBackMessage(new Function1<List<? extends ChatBoxItemBean>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends ChatBoxItemBean>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends ChatBoxItemBean> list) {
                LiveBackMsgPluginView access$getMLiveBackMsgPluginView$p;
                Intrinsics.checkNotNullParameter(list, "it");
                for (ChatBoxItemBean chatBoxItemBean : list) {
                    if (!(chatBoxItemBean == null || (access$getMLiveBackMsgPluginView$p = playBackMsgPluginDriver.mLiveBackMsgPluginView) == null)) {
                        access$getMLiveBackMsgPluginView$p.addData(chatBoxItemBean);
                    }
                }
            }
        });
    }
}
