package com.tal.app.thinkacademy.live.business.chatbox;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChangeChatStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChangeTeacherControlStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.CloseChatBox;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.IrcConnectSuccess;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.OnlyPrivateChatMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.OpenChatBox;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ReceiveChatHistoryMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ReceiveChatMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.UpdateSendMsgStatus;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxInputListener;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListener;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxInputPluginView;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxPluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;

@PluginAnnotation(classType = 1, desc = "ChatBox", deviceType = 1, ircType = {"local_chat_msg", "openchat", "chat_msg_control", "local_joinRoom", "local_netDisconnect", "private_mute_chat"}, launchType = "initmodule", moduleId = "3008")
@ViewLevels({@ViewLevel(level = 120, name = "ChatBoxView"), @ViewLevel(level = 140, name = "ChatBoxInputView")})
public class ChatBoxPluginDriver extends BaseLivePluginDriver implements ChatBoxListener, ChatBoxInputListener {
    private static final String CHAT_MSG_CONTROL = "chat_msg_control";
    private static final String LOCAL_CHAT_MSG = "local_chat_msg";
    private static final String LOCAL_JOIN_ROOM = "local_joinRoom";
    private static final String LOCAL_NET_DISCONNECT = "local_netDisconnect";
    private static final String MUTE_CHAT = "private_mute_chat";
    private static final String OPEN_CHAT = "openchat";
    public static final Tag TAG = Tag.CHAT_BOX;
    /* access modifiers changed from: private */
    public ChatBoxInputPluginView mChatBoxInputPluginView;
    /* access modifiers changed from: private */
    public ChatBoxPluginView mChatBoxView;
    private Context mContext;
    /* access modifiers changed from: private */
    public ChatBoxViewModel mViewModel = AbilityPack.get().getViewModel(ChatBoxViewModel.class);

    public void onDestroy() {
    }

    public ChatBoxPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        initView();
        observeListener();
    }

    private void observeListener() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.getMListenerBody().observerSticky(this, false, new Observer<ChatBoxListenerBody>() {
                public void onChanged(ChatBoxListenerBody chatBoxListenerBody) {
                    if (chatBoxListenerBody instanceof OpenChatBox) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChatBoxPluginDriver.this.mChatBoxView.rootViewIsShow(true);
                        }
                    } else if (chatBoxListenerBody instanceof CloseChatBox) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChatBoxPluginDriver.this.mChatBoxView.rootViewIsShow(false);
                        }
                    } else if (chatBoxListenerBody instanceof IrcConnectSuccess) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChatBoxPluginDriver.this.mChatBoxView.ircConnectSuccess();
                        }
                    } else if (chatBoxListenerBody instanceof ChangeChatStatus) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChangeChatStatus changeChatStatus = (ChangeChatStatus) chatBoxListenerBody;
                            ChatBoxPluginDriver.this.mChatBoxView.changeChatStatus(changeChatStatus.isOpenChat(), changeChatStatus.getText());
                        }
                        if (!((ChangeChatStatus) chatBoxListenerBody).isOpenChat() && ChatBoxPluginDriver.this.mChatBoxInputPluginView != null) {
                            ChatBoxPluginDriver.this.mChatBoxInputPluginView.hide();
                        }
                    } else if (chatBoxListenerBody instanceof ChangeTeacherControlStatus) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChatBoxPluginDriver.this.mChatBoxView.setData(((ChangeTeacherControlStatus) chatBoxListenerBody).getChatBoxItemBeans());
                        }
                    } else if (chatBoxListenerBody instanceof UpdateSendMsgStatus) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChatBoxPluginDriver.this.mChatBoxView.refreshSendMsgStatus(((UpdateSendMsgStatus) chatBoxListenerBody).getChatBoxItemBean());
                        }
                    } else if (chatBoxListenerBody instanceof ReceiveChatMessage) {
                        if (ChatBoxPluginDriver.this.mChatBoxView != null) {
                            ChatBoxPluginDriver.this.mChatBoxView.addData(((ReceiveChatMessage) chatBoxListenerBody).getChatBoxItemBean());
                        }
                    } else if (chatBoxListenerBody instanceof ReceiveChatHistoryMessage) {
                        List<ChatBoxItemBean> chatBoxItemBeans = ((ReceiveChatHistoryMessage) chatBoxListenerBody).getChatBoxItemBeans();
                        if (chatBoxItemBeans != null && chatBoxItemBeans.size() > 0) {
                            for (ChatBoxItemBean next : chatBoxItemBeans) {
                                if (ChatBoxPluginDriver.this.mChatBoxView != null && (next instanceof ChatBoxTextMsgBean)) {
                                    if (!(ChatBoxPluginDriver.this.mViewModel != null ? ChatBoxPluginDriver.this.mViewModel.isNeedFilter(next) : false)) {
                                        ChatBoxPluginDriver.this.mChatBoxView.addData(next);
                                    }
                                }
                            }
                        }
                    } else if ((chatBoxListenerBody instanceof OnlyPrivateChatMessage) && ChatBoxPluginDriver.this.mChatBoxView != null) {
                        ChatBoxPluginDriver.this.mChatBoxView.setIsOnlyPrivateChat(((OnlyPrivateChatMessage) chatBoxListenerBody).isOnlyPrivateChat());
                    }
                }
            });
        }
    }

    private void initView() {
        this.mChatBoxView = new ChatBoxPluginView(this.mContext, ChatBoxUseScenes.CLASS.name());
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.formatInitData(this.mInitModuleJsonStr, new ChatBoxPluginDriver$$ExternalSyntheticLambda1(this));
        }
        this.mChatBoxView.setChatBoxListener(this);
        LiveAreaLayoutParams titleLp = LiveAreaContext.get().getTitleLp();
        LiveAreaLayoutParams visibleLp = LiveAreaContext.get().getVisibleLp();
        FrameLayout.LayoutParams newLp = visibleLp.newLp();
        newLp.topMargin = titleLp.top + titleLp.height;
        newLp.height = visibleLp.height - titleLp.height;
        this.mLiveRoomProvider.addView(this, this.mChatBoxView, "ChatBoxView", newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new ChatBoxPluginDriver$$ExternalSyntheticLambda0(this));
        ChatBoxInputPluginView chatBoxInputPluginView = new ChatBoxInputPluginView(this.mContext, ChatBoxUseScenes.CLASS.name());
        this.mChatBoxInputPluginView = chatBoxInputPluginView;
        chatBoxInputPluginView.setChatBoxInputListener(this);
        this.mLiveRoomProvider.addView(this, this.mChatBoxInputPluginView, "ChatBoxInputView", new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ Unit lambda$initView$0$ChatBoxPluginDriver(ChatBoxConfigBean chatBoxConfigBean) {
        this.mChatBoxView.setQuickMessages(chatBoxConfigBean.getQuickMsgArray());
        return null;
    }

    public /* synthetic */ void lambda$initView$1$ChatBoxPluginDriver(LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mChatBoxView.getLayoutParams();
        LiveAreaLayoutParams visibleLp = liveAreaContext.getVisibleLp();
        visibleLp.mergeLp(layoutParams);
        LiveAreaLayoutParams titleLp = liveAreaContext.getTitleLp();
        layoutParams.topMargin = titleLp.top + titleLp.height;
        layoutParams.height = visibleLp.height - titleLp.height;
        this.mChatBoxView.setLayoutParams(layoutParams);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
        if (r6.equals(CHAT_MSG_CONTROL) == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ircTypeKey="
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = "，message="
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            r6.hashCode()
            int r0 = r6.hashCode()
            r2 = -1
            switch(r0) {
                case -2100397970: goto L_0x0066;
                case -821145544: goto L_0x005d;
                case -644962439: goto L_0x0052;
                case -504200030: goto L_0x0047;
                case -160819131: goto L_0x003c;
                case 994163202: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            r1 = r2
            goto L_0x0070
        L_0x0031:
            java.lang.String r0 = "private_mute_chat"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x003a
            goto L_0x002f
        L_0x003a:
            r1 = 5
            goto L_0x0070
        L_0x003c:
            java.lang.String r0 = "local_netDisconnect"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0045
            goto L_0x002f
        L_0x0045:
            r1 = 4
            goto L_0x0070
        L_0x0047:
            java.lang.String r0 = "openchat"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x002f
        L_0x0050:
            r1 = 3
            goto L_0x0070
        L_0x0052:
            java.lang.String r0 = "local_joinRoom"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005b
            goto L_0x002f
        L_0x005b:
            r1 = 2
            goto L_0x0070
        L_0x005d:
            java.lang.String r0 = "chat_msg_control"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0070
            goto L_0x002f
        L_0x0066:
            java.lang.String r0 = "local_chat_msg"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x006f
            goto L_0x002f
        L_0x006f:
            r1 = r4
        L_0x0070:
            switch(r1) {
                case 0: goto L_0x009c;
                case 1: goto L_0x0094;
                case 2: goto L_0x008c;
                case 3: goto L_0x0084;
                case 4: goto L_0x007c;
                case 5: goto L_0x0074;
                default: goto L_0x0073;
            }
        L_0x0073:
            goto L_0x00a3
        L_0x0074:
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r6 = r5.mViewModel
            if (r6 == 0) goto L_0x00a3
            r6.onReceiveSmallMuteChatMsg(r7)
            goto L_0x00a3
        L_0x007c:
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r6 = r5.mViewModel
            if (r6 == 0) goto L_0x00a3
            r6.onIrcDisconnect()
            goto L_0x00a3
        L_0x0084:
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r0 = r5.mViewModel
            if (r0 == 0) goto L_0x00a3
            r0.onReceiveOpenChatMsg(r6, r7)
            goto L_0x00a3
        L_0x008c:
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r6 = r5.mViewModel
            if (r6 == 0) goto L_0x00a3
            r6.onIrcConnect()
            goto L_0x00a3
        L_0x0094:
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r6 = r5.mViewModel
            if (r6 == 0) goto L_0x00a3
            r6.onTeacherControlMsg(r7)
            goto L_0x00a3
        L_0x009c:
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r6 = r5.mViewModel
            if (r6 == 0) goto L_0x00a3
            r6.onReceiveRoomTextMessage(r7)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.chatbox.ChatBoxPluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    public boolean onClickQuickMsg() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel == null) {
            return true;
        }
        Pair<Boolean, Long> isFrequently = chatBoxViewModel.isFrequently();
        if (!((Boolean) isFrequently.getFirst()).booleanValue()) {
            return true;
        }
        ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
        if (chatBoxPluginView == null) {
            return false;
        }
        chatBoxPluginView.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
        return false;
    }

    public void onClickSaySomethingBtn() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            Pair<Boolean, Long> isFrequently = chatBoxViewModel.isFrequently();
            if (((Boolean) isFrequently.getFirst()).booleanValue()) {
                ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
                if (chatBoxPluginView != null) {
                    chatBoxPluginView.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
                    return;
                }
                return;
            }
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.show();
        }
    }

    public void onClickSendBtn(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "输入聊天内容为空");
            return;
        }
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.addMyChatMessage(str);
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.clearInputContent();
        }
    }

    public void onClickHotWords(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "输入聊天内容为空");
            return;
        }
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.addMyChatMessage(str);
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.clearInputContent();
        }
    }

    public void onClickCloseBtn() {
        ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
        if (chatBoxPluginView != null) {
            chatBoxPluginView.rootViewIsShow(false);
        }
        sendChatBoxViewClosedEvent();
    }

    public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxViewModel chatBoxViewModel;
        if ((chatBoxItemBean instanceof ChatBoxTextMsgBean) && (chatBoxViewModel = this.mViewModel) != null) {
            chatBoxViewModel.sendChatMessage((ChatBoxTextMsgBean) chatBoxItemBean);
        }
    }

    private void sendChatBoxViewClosedEvent() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.syncChatBoxViewClosed();
        }
    }

    public void onInputTextChanged(CharSequence charSequence) {
        ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
        if (chatBoxPluginView != null) {
            chatBoxPluginView.refreshInputText(charSequence);
        }
    }
}
