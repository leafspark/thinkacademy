package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxPluginView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginDriver.kt */
final class AllOnStagePluginDriver$observeListener$4 extends Lambda implements Function1<ChatBoxListenerBody, Unit> {
    final /* synthetic */ AllOnStagePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginDriver$observeListener$4(AllOnStagePluginDriver allOnStagePluginDriver) {
        super(1);
        this.this$0 = allOnStagePluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChatBoxListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChatBoxListenerBody chatBoxListenerBody) {
        Intrinsics.checkNotNullParameter(chatBoxListenerBody, "$this$observeListener");
        final AllOnStagePluginDriver allOnStagePluginDriver = this.this$0;
        chatBoxListenerBody.onReceiveChatMessage(new Function1<ChatBoxItemBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChatBoxItemBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ChatBoxItemBean chatBoxItemBean) {
                Intrinsics.checkNotNullParameter(chatBoxItemBean, "it");
                allOnStagePluginDriver.addData(chatBoxItemBean);
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver2 = this.this$0;
        chatBoxListenerBody.onChangeChatStatus(new Function2<Boolean, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, String str) {
                allOnStagePluginDriver2.changeChatStatus(Boolean.valueOf(z), str);
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver3 = this.this$0;
        chatBoxListenerBody.onChangeTeacherControlStatus(new Function1<List<? extends ChatBoxItemBean>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends ChatBoxItemBean>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends ChatBoxItemBean> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                allOnStagePluginDriver3.changeTeacherControlStatus(list);
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver4 = this.this$0;
        chatBoxListenerBody.onIrcConnectSuccess(new Function0<Unit>() {
            public final void invoke() {
                allOnStagePluginDriver4.ircConnectSuccess();
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver5 = this.this$0;
        chatBoxListenerBody.onUpdateSendMsgStatus(new Function1<ChatBoxItemBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChatBoxItemBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ChatBoxItemBean chatBoxItemBean) {
                Intrinsics.checkNotNullParameter(chatBoxItemBean, "it");
                allOnStagePluginDriver5.updateSendMsgStatus(chatBoxItemBean);
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver6 = this.this$0;
        chatBoxListenerBody.onReceiveChatHistoryMessage(new Function1<List<? extends ChatBoxItemBean>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends ChatBoxItemBean>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends ChatBoxItemBean> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                allOnStagePluginDriver6.addHistoryData(list);
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver7 = this.this$0;
        chatBoxListenerBody.onOnlyPrivateChatMessage(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                ChatBoxPluginView access$getMChatBoxView$p = allOnStagePluginDriver7.mChatBoxView;
                if (access$getMChatBoxView$p != null) {
                    access$getMChatBoxView$p.setIsOnlyPrivateChat(z);
                }
            }
        });
    }
}
