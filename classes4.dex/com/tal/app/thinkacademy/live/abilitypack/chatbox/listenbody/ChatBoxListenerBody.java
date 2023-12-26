package com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody;

import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0000H\u0016J@\u0010$\u001a\u00020\u000b28\u0010%\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004J/\u0010&\u001a\u00020\u000b2'\u0010%\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\rJ\u0014\u0010'\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J\u0014\u0010(\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J/\u0010)\u001a\u00020\u000b2'\u0010%\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\rJ\u0014\u0010*\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J\u0014\u0010+\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J)\u0010,\u001a\u00020\u000b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\rJ\u0014\u0010-\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J1\u0010.\u001a\u00020\u000b2)\u0010%\u001a%\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\rJ)\u0010/\u001a\u00020\u000b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\rJ/\u00100\u001a\u00020\u000b2'\u0010%\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\rJ)\u00101\u001a\u00020\u000b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\rJ\u0014\u00102\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J)\u00103\u001a\u00020\u000b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\rJ)\u00104\u001a\u00020\u000b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\rRB\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R1\u0010\f\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R1\u0010\u0014\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R3\u0010\u001a\u001a'\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R1\u0010\u001d\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R+\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000\u0001\u001056789:;<=>?@ABCD¨\u0006E"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "changeChatStatusAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isOpenChat", "", "text", "", "changeTeacherControlStatusAction", "Lkotlin/Function1;", "", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;", "chatBoxItemBeans", "chatBoxViewClosedAction", "Lkotlin/Function0;", "closeChatBoxAction", "historyPrivateMessageAction", "ircConnectSuccessAction", "ircDisConnectAction", "onlyPrivateChatMessageAction", "isOnlyPrivateChat", "openChatBoxAction", "playBackMessageAction", "privateMessageAction", "chatBoxItemBean", "receiveChatHistoryMessageAction", "receiveChatMessageAction", "showChatBoxRedRotAction", "updateSendMsgStatusAction", "updateSendPrivateMsgStatusAction", "dispatch", "listener", "onChangeChatStatus", "action", "onChangeTeacherControlStatus", "onChatBoxViewClosed", "onCloseChatBox", "onHistoryPrivateMessage", "onIrcConnectSuccess", "onIrcDisConnect", "onOnlyPrivateChatMessage", "onOpenChatBox", "onPlayBackMessage", "onPrivateMessage", "onReceiveChatHistoryMessage", "onReceiveChatMessage", "onShowChatBoxRedRot", "onUpdateSendMsgStatus", "onUpdateSendPrivateMsgStatus", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/OpenChatBox;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/CloseChatBox;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ReceiveChatMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChangeChatStatus;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChangeTeacherControlStatus;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/IrcConnectSuccess;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/IrcDisConnect;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/UpdateSendMsgStatus;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ReceiveChatHistoryMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxViewClosed;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ShowChatBoxRedRot;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/PrivateMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/UpdateSendPrivateMsgStatus;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/HistoryPrivateMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/PlayBackMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/OnlyPrivateChatMessage;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxListenerBody.kt */
public abstract class ChatBoxListenerBody extends ListenerBody<ChatBoxListenerBody> {
    private Function2<? super Boolean, ? super String, Unit> changeChatStatusAction;
    private Function1<? super List<? extends ChatBoxItemBean>, Unit> changeTeacherControlStatusAction;
    private Function0<Unit> chatBoxViewClosedAction;
    private Function0<Unit> closeChatBoxAction;
    private Function1<? super List<? extends ChatBoxItemBean>, Unit> historyPrivateMessageAction;
    private Function0<Unit> ircConnectSuccessAction;
    private Function0<Unit> ircDisConnectAction;
    private Function1<? super Boolean, Unit> onlyPrivateChatMessageAction;
    private Function0<Unit> openChatBoxAction;
    private Function1<? super List<? extends ChatBoxItemBean>, Unit> playBackMessageAction;
    private Function1<? super ChatBoxItemBean, Unit> privateMessageAction;
    private Function1<? super List<? extends ChatBoxItemBean>, Unit> receiveChatHistoryMessageAction;
    private Function1<? super ChatBoxItemBean, Unit> receiveChatMessageAction;
    private Function0<Unit> showChatBoxRedRotAction;
    private Function1<? super ChatBoxItemBean, Unit> updateSendMsgStatusAction;
    private Function1<? super ChatBoxItemBean, Unit> updateSendPrivateMsgStatusAction;

    public /* synthetic */ ChatBoxListenerBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChatBoxListenerBody() {
    }

    public void dispatch(ChatBoxListenerBody chatBoxListenerBody) {
        Function1<? super Boolean, Unit> function1;
        Intrinsics.checkNotNullParameter(chatBoxListenerBody, "listener");
        if (chatBoxListenerBody instanceof OpenChatBox) {
            Function0<Unit> function0 = this.openChatBoxAction;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (chatBoxListenerBody instanceof CloseChatBox) {
            Function0<Unit> function02 = this.closeChatBoxAction;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (chatBoxListenerBody instanceof ReceiveChatMessage) {
            Function1<? super ChatBoxItemBean, Unit> function12 = this.receiveChatMessageAction;
            if (function12 != null) {
                function12.invoke(((ReceiveChatMessage) chatBoxListenerBody).getChatBoxItemBean());
            }
        } else if (chatBoxListenerBody instanceof ChangeChatStatus) {
            Function2<? super Boolean, ? super String, Unit> function2 = this.changeChatStatusAction;
            if (function2 != null) {
                ChangeChatStatus changeChatStatus = (ChangeChatStatus) chatBoxListenerBody;
                function2.invoke(Boolean.valueOf(changeChatStatus.isOpenChat()), changeChatStatus.getText());
            }
        } else if (chatBoxListenerBody instanceof ChangeTeacherControlStatus) {
            Function1<? super List<? extends ChatBoxItemBean>, Unit> function13 = this.changeTeacherControlStatusAction;
            if (function13 != null) {
                function13.invoke(((ChangeTeacherControlStatus) chatBoxListenerBody).getChatBoxItemBeans());
            }
        } else if (chatBoxListenerBody instanceof IrcConnectSuccess) {
            Function0<Unit> function03 = this.ircConnectSuccessAction;
            if (function03 != null) {
                function03.invoke();
            }
        } else if (chatBoxListenerBody instanceof IrcDisConnect) {
            Function0<Unit> function04 = this.ircDisConnectAction;
            if (function04 != null) {
                function04.invoke();
            }
        } else if (chatBoxListenerBody instanceof UpdateSendMsgStatus) {
            Function1<? super ChatBoxItemBean, Unit> function14 = this.updateSendMsgStatusAction;
            if (function14 != null) {
                function14.invoke(((UpdateSendMsgStatus) chatBoxListenerBody).getChatBoxItemBean());
            }
        } else if (chatBoxListenerBody instanceof ReceiveChatHistoryMessage) {
            Function1<? super List<? extends ChatBoxItemBean>, Unit> function15 = this.receiveChatHistoryMessageAction;
            if (function15 != null) {
                function15.invoke(((ReceiveChatHistoryMessage) chatBoxListenerBody).getChatBoxItemBeans());
            }
        } else if (chatBoxListenerBody instanceof ChatBoxViewClosed) {
            Function0<Unit> function05 = this.chatBoxViewClosedAction;
            if (function05 != null) {
                function05.invoke();
            }
        } else if (chatBoxListenerBody instanceof ShowChatBoxRedRot) {
            Function0<Unit> function06 = this.showChatBoxRedRotAction;
            if (function06 != null) {
                function06.invoke();
            }
        } else if (chatBoxListenerBody instanceof HistoryPrivateMessage) {
            Function1<? super List<? extends ChatBoxItemBean>, Unit> function16 = this.historyPrivateMessageAction;
            if (function16 != null) {
                function16.invoke(((HistoryPrivateMessage) chatBoxListenerBody).getChatBoxItemBeans());
            }
        } else if (chatBoxListenerBody instanceof PrivateMessage) {
            Function1<? super ChatBoxItemBean, Unit> function17 = this.privateMessageAction;
            if (function17 != null) {
                function17.invoke(((PrivateMessage) chatBoxListenerBody).getChatBoxItemBean());
            }
        } else if (chatBoxListenerBody instanceof UpdateSendPrivateMsgStatus) {
            Function1<? super ChatBoxItemBean, Unit> function18 = this.updateSendMsgStatusAction;
            if (function18 != null) {
                function18.invoke(((UpdateSendPrivateMsgStatus) chatBoxListenerBody).getChatBoxItemBean());
            }
        } else if (chatBoxListenerBody instanceof PlayBackMessage) {
            Function1<? super List<? extends ChatBoxItemBean>, Unit> function19 = this.playBackMessageAction;
            if (function19 != null) {
                function19.invoke(((PlayBackMessage) chatBoxListenerBody).getChatBoxItemBeans());
            }
        } else if ((chatBoxListenerBody instanceof OnlyPrivateChatMessage) && (function1 = this.onlyPrivateChatMessageAction) != null) {
            function1.invoke(Boolean.valueOf(((OnlyPrivateChatMessage) chatBoxListenerBody).isOnlyPrivateChat()));
        }
    }

    public final void onOpenChatBox(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.openChatBoxAction = function0;
    }

    public final void onCloseChatBox(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.closeChatBoxAction = function0;
    }

    public final void onReceiveChatMessage(Function1<? super ChatBoxItemBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (this instanceof ReceiveChatMessage) {
            function1.invoke(((ReceiveChatMessage) this).getChatBoxItemBean());
        }
    }

    public final void onChangeChatStatus(Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.changeChatStatusAction = function2;
    }

    public final void onChangeTeacherControlStatus(Function1<? super List<? extends ChatBoxItemBean>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.changeTeacherControlStatusAction = function1;
    }

    public final void onIrcConnectSuccess(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.ircConnectSuccessAction = function0;
    }

    public final void onIrcDisConnect(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.ircDisConnectAction = function0;
    }

    public final void onUpdateSendMsgStatus(Function1<? super ChatBoxItemBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.updateSendMsgStatusAction = function1;
    }

    public final void onReceiveChatHistoryMessage(Function1<? super List<? extends ChatBoxItemBean>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.receiveChatHistoryMessageAction = function1;
    }

    public final void onChatBoxViewClosed(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.chatBoxViewClosedAction = function0;
    }

    public final void onShowChatBoxRedRot(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.showChatBoxRedRotAction = function0;
    }

    public final void onHistoryPrivateMessage(Function1<? super List<? extends ChatBoxItemBean>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.historyPrivateMessageAction = function1;
    }

    public final void onPrivateMessage(Function1<? super ChatBoxItemBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.privateMessageAction = function1;
    }

    public final void onUpdateSendPrivateMsgStatus(Function1<? super ChatBoxItemBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.updateSendPrivateMsgStatusAction = function1;
    }

    public final void onPlayBackMessage(Function1<? super List<? extends ChatBoxItemBean>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.playBackMessageAction = function1;
    }

    public final void onOnlyPrivateChatMessage(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.onlyPrivateChatMessageAction = function1;
    }
}
