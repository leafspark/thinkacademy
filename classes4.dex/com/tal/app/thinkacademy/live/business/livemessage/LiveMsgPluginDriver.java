package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChangeChatStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChangeTeacherControlStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.HistoryPrivateMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.IrcConnectSuccess;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.IrcDisConnect;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.PrivateMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ReceiveChatHistoryMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ReceiveChatMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.UpdateSendMsgStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.UpdateSendPrivateMsgStatus;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxEmojiMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxInputListener;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListener;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxInputPluginView;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.yy.mobile.rollingtextview.RollingTextView;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONObject;

@PluginAnnotation(classType = 0, desc = "聊天消息插件", ircType = {"local_joinRoom", "local_mute", "local_netDisconnect", "local_chat_msg", "level_chat_msg", "openchat", "openchat_f", "peer_mute_chat", "peer_chat_msg", "send_emoji", "animation_emoji"}, launchType = "enter", moduleId = "-102")
@ViewLevels({@ViewLevel(level = 120, name = "LiveMsgView"), @ViewLevel(level = 140, name = "LiveMsgInPut"), @ViewLevel(level = 140, name = "LiveMsgHotWord"), @ViewLevel(level = 120, name = "LiveMsgPrivate"), @ViewLevel(level = 120, name = "LivePrivateRemind")})
public class LiveMsgPluginDriver extends BaseLivePluginDriver implements ChatBoxInputListener, ChatBoxListener {
    private static final String ANIMATION_EMOJI = "animation_emoji";
    private static final String LEVEL_CHAT_MSG = "level_chat_msg";
    private static final String LOCAL_CHAT_MSG = "local_chat_msg";
    private static final String LOCAL_JOIN_ROOM = "local_joinRoom";
    private static final String LOCAL_NET_DISCONNECT = "local_netDisconnect";
    private static final String OPEN_CHAT = "openchat";
    private static final String OPEN_CHAT_F = "openchat_f";
    private static final String PEER_CHAT_MSG = "peer_chat_msg";
    private static final String PEER_MUTE_CHAT = "peer_mute_chat";
    private static final String SEND_EMOJI = "send_emoji";
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.CHAT_BOX;
    /* access modifiers changed from: private */
    public boolean isAuditor;
    /* access modifiers changed from: private */
    public boolean isParentAuditor;
    /* access modifiers changed from: private */
    public boolean isShowPrivateMsg;
    /* access modifiers changed from: private */
    public boolean isSmallClass;
    /* access modifiers changed from: private */
    public ChatBoxInputPluginView mChatBoxInputPluginView;
    private Context mContext;
    private LiveMsgHotWordPhoneView mLiveMsgHotWordPhoneView;
    /* access modifiers changed from: private */
    public LiveMsgPluginView mLiveMsgPluginView;
    /* access modifiers changed from: private */
    public LiveMsgPrivatePluginView mLiveMsgPrivatePluginView;
    /* access modifiers changed from: private */
    public LiveMsgPrivateRemindView mLiveMsgPrivateRemindView;
    private ILiveRoomProvider mLiveRoomProvider;
    private Observer<ChatBoxListenerBody> mPrivateMsgObserver = new Observer<ChatBoxListenerBody>() {
        public void onChanged(ChatBoxListenerBody chatBoxListenerBody) {
            if (chatBoxListenerBody instanceof PrivateMessage) {
                ChatBoxItemBean chatBoxItemBean = ((PrivateMessage) chatBoxListenerBody).getChatBoxItemBean();
                LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView.addData(chatBoxItemBean);
                if (LiveMsgPluginDriver.this.mLiveMsgPluginView != null) {
                    LiveMsgPluginDriver.this.mLiveMsgPluginView.notifyReceivePrivateMsg();
                }
                if (LiveMsgPluginDriver.this.mLiveMsgPrivateRemindView != null && (chatBoxItemBean instanceof ChatBoxTextMsgBean) && !LiveMsgPluginDriver.this.isShowPrivateMsg) {
                    LiveMsgPluginDriver.this.mLiveMsgPrivateRemindView.receiveTutorMsg((ChatBoxTextMsgBean) chatBoxItemBean);
                }
                LiveMsgPluginDriver.this.updatePrivateMessage();
            }
        }
    };
    /* access modifiers changed from: private */
    public RedPackageRainViewModel mRedPackageRainViewModel = null;
    private UserInfoProxy mUserInfo;
    /* access modifiers changed from: private */
    public ChatBoxViewModel mViewModel;
    public Observer<PluginEventData> observerFeedback = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (pluginEventData != null && (pluginEventData.getObject() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) pluginEventData.getObject();
                if (LiveMsgPluginDriver.this.mViewModel != null) {
                    LiveMsgPluginDriver.this.mViewModel.sendFeedbackMsg("I send a feedback", jSONObject);
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(AwsS3Util.scene_feedback, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                XesLog.ut((XesLogTag) LiveMsgPluginDriver.TAG, jsonObject);
            }
        }
    };
    public Observer<PluginEventData> observerHandup = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (pluginEventData != null && (pluginEventData.getObject() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) pluginEventData.getObject();
                if (LiveMsgPluginDriver.this.mViewModel != null) {
                    LiveMsgPluginDriver.this.mViewModel.sendHandUpMsg("raiseHand", jSONObject);
                }
            }
        }
    };
    public Observer<PluginEventData> observerHasStudentVideo = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (!PadUtils.isPad(Utils.getApp()) || !LiveMsgPluginDriver.this.isSmallClass) {
                new Handler(Looper.getMainLooper()).postDelayed(new LiveMsgPluginDriver$5$$ExternalSyntheticLambda0(this), 1000);
            }
        }

        public /* synthetic */ void lambda$onChanged$0$LiveMsgPluginDriver$5() {
            if (LiveMsgPluginDriver.this.mLiveMsgPluginView == null) {
                return;
            }
            if (!LiveMsgPluginDriver.this.isAuditor || PadUtils.isPad(Utils.getApp()) || LiveMsgPluginDriver.this.isParentAuditor) {
                LiveMsgPluginDriver.this.mLiveMsgPluginView.startTopAndBottomAnimation(true);
            }
        }
    };
    public Observer<PluginEventData> observerHotWord = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            LiveMsgPluginDriver.this.showHotWord();
        }
    };
    public Observer<PluginEventData> observerInputMsg = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (LiveMsgPluginDriver.this.mChatBoxInputPluginView != null) {
                LiveMsgPluginDriver.this.mChatBoxInputPluginView.show();
            }
        }
    };
    public Observer<PluginEventData> observerStudentVideo = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            String str = "1";
            boolean equals = str.equals(pluginEventData.getData());
            if (!PadUtils.isPad(Utils.getApp()) || !LiveMsgPluginDriver.this.isSmallClass) {
                if (LiveMsgPluginDriver.this.mRedPackageRainViewModel == null) {
                    RedPackageRainViewModel unused = LiveMsgPluginDriver.this.mRedPackageRainViewModel = AbilityPack.get().getViewModel(RedPackageRainViewModel.class);
                }
                if (LiveMsgPluginDriver.this.mRedPackageRainViewModel != null) {
                    LiveMsgPluginDriver.this.mRedPackageRainViewModel.setIsCloseVideo(Boolean.valueOf(!equals));
                    CoinCenterViewModel coinCenterViewModel = CoinCenterViewModelKt.getCoinCenterViewModel(AbilityPack.get());
                    if (coinCenterViewModel != null) {
                        ImageView coinImageView = LiveMsgPluginDriver.this.mRedPackageRainViewModel.getCoinImageView();
                        Objects.requireNonNull(coinImageView);
                        RollingTextView coinTextView = LiveMsgPluginDriver.this.mRedPackageRainViewModel.getCoinTextView();
                        Objects.requireNonNull(coinTextView);
                        coinCenterViewModel.bindingCoinView(coinImageView, coinTextView, (View) null);
                    }
                }
                LiveMsgPluginDriver.this.mLiveMsgPluginView.startTopAndBottomAnimation(equals);
            } else {
                LiveMsgPluginDriver.this.mLiveMsgPluginView.rootViewIsShow(!equals);
                LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView.rootViewIsShow(!equals);
            }
            LiveMsgPluginDriver liveMsgPluginDriver = LiveMsgPluginDriver.this;
            if (equals) {
                str = EnterRoomMuteData.STATUS_UN_MUTE;
            }
            liveMsgPluginDriver.track_click_group_mode(str);
            LiveMsgPluginDriver.this.eventMuteStudentVideo(equals);
        }
    };
    public Observer<PluginEventData> observerTeacherOnly = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            LiveMsgPluginDriver.this.switchChatState("1".equals(pluginEventData.getData()));
        }
    };
    public Observer<PluginEventData> observerUserCoins = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("source", (String) pluginEventData.getObject());
                jsonObject.addProperty("coins", pluginEventData.getData());
                XesLog.ut((XesLogTag) LiveMsgPluginDriver.TAG, jsonObject);
                LiveMsgPluginDriver.this.mLiveMsgPluginView.setUserCoins(pluginEventData.getData());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    public Observer<PluginEventData> observerUserLevel = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (LiveMsgPluginDriver.this.mViewModel != null) {
                LiveMsgPluginDriver.this.mViewModel.sendLevelUpMsg(Integer.valueOf(Integer.parseInt(pluginEventData.getData())));
            }
        }
    };
    public Observer<PluginEventData> observerVideoState = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            boolean equals = EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData());
            if (PadUtils.isPad(Utils.getApp()) && LiveMsgPluginDriver.this.isSmallClass) {
                LiveMsgPluginDriver.this.mLiveMsgPluginView.rootViewIsShow(equals);
                LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView.rootViewIsShow(equals);
            }
        }
    };

    public void onClickCloseBtn() {
    }

    public boolean onClickQuickMsg() {
        return false;
    }

    public void onInputTextChanged(CharSequence charSequence) {
    }

    public LiveMsgPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mLiveRoomProvider = iLiveRoomProvider;
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mViewModel = AbilityPack.get().getViewModel(ChatBoxViewModel.class);
        this.isSmallClass = iLiveRoomProvider.isSmallClass();
        this.mUserInfo = iLiveRoomProvider.getDataStorage().getUserInfo();
        CourseInfoProxy courseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        if (courseInfo != null) {
            this.isAuditor = courseInfo.getIsAudition() == CourseInfo.ROLE_AUDITION;
            this.isParentAuditor = courseInfo.getIsParentAuditLocal();
        }
        initLiveMsgView();
        initPadLiveTutorMsgView();
        PluginEventBus.register(this, DataBusKey.UPDATE_COINS, this.observerUserCoins);
        PluginEventBus.register(this, DataBusKey.STUDENTVIDEO_KEY, this.observerHasStudentVideo);
        PluginEventBus.register(this, DataBusKey.LIVE_MESSAGE_ANIMATION_KEY, this.observerStudentVideo);
        PluginEventBus.register(this, DataBusKey.LIVE_MSG_INPUT, this.observerInputMsg);
        PluginEventBus.register(this, DataBusKey.LIVE_MSG_TEACHER_ONLY, this.observerTeacherOnly);
        PluginEventBus.register(this, DataBusKey.LIVE_MSG_HOT_WORD, this.observerHotWord);
        PluginEventBus.register(this, DataBusKey.CLASS_FEEDBACK, this.observerFeedback);
        PluginEventBus.register(this, DataBusKey.CLASS_HANDUP, this.observerHandup);
        PluginEventBus.register(this, DataBusKey.LEVEL_KEY, this.observerUserLevel);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            PluginEventBus.register(this, DataBusKey.VIDEO_CHAT_TOGGLE, this.observerVideoState);
        }
        observeListener();
    }

    private void observeListener() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.getMListenerBody().observerSticky(this, false, new Observer<ChatBoxListenerBody>() {
                public void onChanged(ChatBoxListenerBody chatBoxListenerBody) {
                    if (chatBoxListenerBody instanceof IrcConnectSuccess) {
                        if (LiveMsgPluginDriver.this.mLiveMsgPluginView != null) {
                            LiveMsgPluginDriver.this.mLiveMsgPluginView.ircConnectSuccess();
                        }
                        if (LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView != null) {
                            LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView.ircConnectSuccess();
                        }
                    } else if (chatBoxListenerBody instanceof IrcDisConnect) {
                        if (LiveMsgPluginDriver.this.mViewModel != null) {
                            LiveMsgPluginDriver.this.mViewModel.showIrcDisconnectStatus();
                        }
                    } else if (chatBoxListenerBody instanceof ChangeChatStatus) {
                        if (LiveMsgPluginDriver.this.mLiveMsgPluginView != null) {
                            LiveMsgPluginDriver.this.mLiveMsgPluginView.openChat(((ChangeChatStatus) chatBoxListenerBody).isOpenChat());
                        }
                        ChangeChatStatus changeChatStatus = (ChangeChatStatus) chatBoxListenerBody;
                        LiveMsgPluginDriver.this.eventInputMsgEnable(changeChatStatus.isOpenChat());
                        if (!changeChatStatus.isOpenChat() && LiveMsgPluginDriver.this.mChatBoxInputPluginView != null) {
                            LiveMsgPluginDriver.this.mChatBoxInputPluginView.hide();
                        }
                    } else if (chatBoxListenerBody instanceof ChangeTeacherControlStatus) {
                        if (LiveMsgPluginDriver.this.mLiveMsgPluginView != null) {
                            LiveMsgPluginDriver.this.mLiveMsgPluginView.setData(((ChangeTeacherControlStatus) chatBoxListenerBody).getChatBoxItemBeans());
                        }
                    } else if (chatBoxListenerBody instanceof UpdateSendMsgStatus) {
                        if (LiveMsgPluginDriver.this.mLiveMsgPluginView != null) {
                            LiveMsgPluginDriver.this.mLiveMsgPluginView.refreshSendMsgStatus(((UpdateSendMsgStatus) chatBoxListenerBody).getChatBoxItemBean());
                        }
                    } else if (chatBoxListenerBody instanceof ReceiveChatMessage) {
                        if (LiveMsgPluginDriver.this.mLiveMsgPluginView != null) {
                            LiveMsgPluginDriver.this.mLiveMsgPluginView.addData(((ReceiveChatMessage) chatBoxListenerBody).getChatBoxItemBean());
                        }
                    } else if (chatBoxListenerBody instanceof ReceiveChatHistoryMessage) {
                        List<ChatBoxItemBean> chatBoxItemBeans = ((ReceiveChatHistoryMessage) chatBoxListenerBody).getChatBoxItemBeans();
                        if (chatBoxItemBeans != null && chatBoxItemBeans.size() > 0) {
                            for (ChatBoxItemBean next : chatBoxItemBeans) {
                                if (!(LiveMsgPluginDriver.this.mLiveMsgPluginView == null || next == null)) {
                                    boolean z = false;
                                    if (LiveMsgPluginDriver.this.mViewModel != null) {
                                        z = LiveMsgPluginDriver.this.mViewModel.isNeedFilter(next);
                                    }
                                    if (!z) {
                                        LiveMsgPluginDriver.this.mLiveMsgPluginView.addData(next);
                                    }
                                }
                            }
                        }
                    } else if (chatBoxListenerBody instanceof HistoryPrivateMessage) {
                        List<ChatBoxItemBean> chatBoxItemBeans2 = ((HistoryPrivateMessage) chatBoxListenerBody).getChatBoxItemBeans();
                        if (chatBoxItemBeans2 != null && chatBoxItemBeans2.size() > 0) {
                            for (ChatBoxItemBean next2 : chatBoxItemBeans2) {
                                if (!(LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView == null || next2 == null)) {
                                    LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView.addHistoryData(next2);
                                }
                            }
                        }
                    } else if ((chatBoxListenerBody instanceof UpdateSendPrivateMsgStatus) && LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView != null) {
                        LiveMsgPluginDriver.this.mLiveMsgPrivatePluginView.refreshSendMsgStatus(((UpdateSendPrivateMsgStatus) chatBoxListenerBody).getChatBoxItemBean());
                    }
                }
            });
            this.mViewModel.getMListenerBody().observeForever(this, false, this.mPrivateMsgObserver);
        }
    }

    private void initLiveMsgView() {
        if (this.isAuditor) {
            this.mLiveMsgPluginView = new LiveMsgAuditorPluginView(this.mContext, this);
        } else {
            this.mLiveMsgPluginView = new LiveMsgPluginView(this.mContext, this);
        }
        this.mLiveMsgPluginView.setChatBoxListener(this);
        this.mLiveMsgPluginView.setDriver(this);
        LiveAreaLayoutParams msgLp = LiveAreaContext.get().getMsgLp();
        FrameLayout.LayoutParams newLp = msgLp.newLp();
        int dp2px = SizeUtils.dp2px(65.0f);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            newLp.height -= dp2px;
            newLp.topMargin += dp2px;
        } else if (!PadUtils.isPad(Utils.getApp()) && this.isParentAuditor) {
            newLp.height -= (newLp.width * 3) / 4;
            newLp.topMargin += (newLp.width * 3) / 4;
        }
        this.mLiveMsgPluginView.setMsgViewHeight(newLp.height);
        this.mLiveRoomProvider.addView(this, this.mLiveMsgPluginView, "LiveMsgView", newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new LiveMsgPluginDriver$$ExternalSyntheticLambda1(this, dp2px));
        ChatBoxInputPluginView chatBoxInputPluginView = new ChatBoxInputPluginView(this.mContext, ChatBoxUseScenes.CLASS.name());
        this.mChatBoxInputPluginView = chatBoxInputPluginView;
        chatBoxInputPluginView.setChatBoxInputListener(this);
        if (PadUtils.isPad(Utils.getApp()) && !this.isSmallClass) {
            this.mChatBoxInputPluginView.setupHotWord();
        }
        this.mLiveRoomProvider.addView(this, this.mChatBoxInputPluginView, "LiveMsgInPut", new FrameLayout.LayoutParams(-1, -1));
        this.mLiveMsgPluginView.setUserCoins(String.valueOf(this.mUserInfo.getGoldNum()));
        LiveMsgPrivatePluginView liveMsgPrivatePluginView = new LiveMsgPrivatePluginView(this.mContext, this);
        this.mLiveMsgPrivatePluginView = liveMsgPrivatePluginView;
        liveMsgPrivatePluginView.setChatBoxListener(this);
        FrameLayout.LayoutParams newLp2 = msgLp.newLp();
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            newLp2.height -= dp2px;
            newLp2.topMargin += dp2px;
        }
        this.mLiveRoomProvider.addView(this, this.mLiveMsgPrivatePluginView, "LiveMsgPrivate", newLp2);
        this.mLiveMsgPrivatePluginView.setLayoutParams(newLp2);
        LiveAreaContext.get().layoutObserver.observe(this, new LiveMsgPluginDriver$$ExternalSyntheticLambda2(this, dp2px));
        if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
            this.mLiveMsgPluginView.rootViewIsShow(true);
            this.mLiveMsgPrivatePluginView.rootViewIsShow(true);
            return;
        }
        this.mLiveMsgPluginView.rootViewIsShow(false);
        this.mLiveMsgPrivatePluginView.rootViewIsShow(false);
    }

    public /* synthetic */ void lambda$initLiveMsgView$0$LiveMsgPluginDriver(int i, LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLiveMsgPluginView.getLayoutParams();
        liveAreaContext.getMsgLp().mergeLp(layoutParams);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            layoutParams.height -= i;
            layoutParams.topMargin += i;
        } else if (!PadUtils.isPad(Utils.getApp()) && this.isParentAuditor) {
            layoutParams.height -= (layoutParams.width * 3) / 4;
            layoutParams.topMargin += (layoutParams.width * 3) / 4;
        }
        this.mLiveMsgPluginView.setMsgViewHeight(layoutParams.height);
        this.mLiveMsgPluginView.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void lambda$initLiveMsgView$1$LiveMsgPluginDriver(int i, LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLiveMsgPluginView.getLayoutParams();
        liveAreaContext.getMsgLp().mergeLp(layoutParams);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            layoutParams.height -= i;
            layoutParams.topMargin += i;
        }
        this.mLiveMsgPrivatePluginView.setLayoutParams(layoutParams);
    }

    private void initPadLiveTutorMsgView() {
        if (PadUtils.isPad(Utils.getApp())) {
            this.mLiveMsgPrivateRemindView = new LiveMsgPrivateRemindView(this.mContext, this.mLiveRoomProvider);
            this.mLiveRoomProvider.addView(this, this.mLiveMsgPrivateRemindView, "LivePrivateRemind", LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observe(this, new LiveMsgPluginDriver$$ExternalSyntheticLambda0(this));
            this.mLiveMsgPrivateRemindView.onGotItTutorMsg(new LiveMsgPluginDriver$$ExternalSyntheticLambda3(this));
            this.mLiveMsgPrivateRemindView.onReplyTutorMsg(new LiveMsgPluginDriver$$ExternalSyntheticLambda4(this));
        }
    }

    public /* synthetic */ void lambda$initPadLiveTutorMsgView$2$LiveMsgPluginDriver(LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLiveMsgPrivateRemindView.getLayoutParams();
        if (layoutParams != null) {
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            this.mLiveMsgPrivateRemindView.setLayoutParams(layoutParams);
        }
    }

    public /* synthetic */ Unit lambda$initPadLiveTutorMsgView$3$LiveMsgPluginDriver() {
        LiveMsgPluginView liveMsgPluginView = this.mLiveMsgPluginView;
        if (liveMsgPluginView == null) {
            return null;
        }
        liveMsgPluginView.removePrivateMsgRedDot();
        return null;
    }

    public /* synthetic */ Unit lambda$initPadLiveTutorMsgView$4$LiveMsgPluginDriver() {
        LiveMsgPluginView liveMsgPluginView = this.mLiveMsgPluginView;
        if (liveMsgPluginView != null) {
            liveMsgPluginView.removePrivateMsgRedDot();
        }
        LiveMsgPrivatePluginView liveMsgPrivatePluginView = this.mLiveMsgPrivatePluginView;
        if (liveMsgPrivatePluginView == null) {
            return null;
        }
        liveMsgPrivatePluginView.openPrivateMsg();
        return null;
    }

    public boolean isSmallClass() {
        return this.isSmallClass;
    }

    private void initHotWordView() {
        if (this.mLiveMsgHotWordPhoneView == null) {
            LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
            this.mLiveMsgHotWordPhoneView = new LiveMsgHotWordPhoneView(this.mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pptLp.width - SizeUtils.dp2px(20.0f), SizeUtils.dp2px(80.0f));
            layoutParams.setMarginStart(SizeUtils.dp2px(10.0f));
            layoutParams.setMarginEnd(SizeUtils.dp2px(10.0f));
            layoutParams.gravity = 80;
            this.mLiveMsgHotWordPhoneView.setDriver(this);
            this.mLiveRoomProvider.addView(this, this.mLiveMsgHotWordPhoneView, "LiveMsgHotWord", layoutParams);
        }
    }

    public void onMessage(String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2100397970:
                if (str.equals("local_chat_msg")) {
                    c = 0;
                    break;
                }
                break;
            case -1925166133:
                if (str.equals(ANIMATION_EMOJI)) {
                    c = 1;
                    break;
                }
                break;
            case -644962439:
                if (str.equals("local_joinRoom")) {
                    c = 2;
                    break;
                }
                break;
            case -504200030:
                if (str.equals(OPEN_CHAT)) {
                    c = 3;
                    break;
                }
                break;
            case -160819131:
                if (str.equals(LOCAL_NET_DISCONNECT)) {
                    c = 4;
                    break;
                }
                break;
            case 393365621:
                if (str.equals("level_chat_msg")) {
                    c = 5;
                    break;
                }
                break;
            case 772471585:
                if (str.equals(PEER_MUTE_CHAT)) {
                    c = 6;
                    break;
                }
                break;
            case 795078665:
                if (str.equals(OPEN_CHAT_F)) {
                    c = 7;
                    break;
                }
                break;
            case 814542031:
                if (str.equals("send_emoji")) {
                    c = 8;
                    break;
                }
                break;
            case 1148136535:
                if (str.equals(PEER_CHAT_MSG)) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ChatBoxViewModel chatBoxViewModel = this.mViewModel;
                if (chatBoxViewModel != null) {
                    chatBoxViewModel.onReceiveRoomTextMessage(str2);
                    return;
                }
                return;
            case 1:
            case 8:
                ChatBoxViewModel chatBoxViewModel2 = this.mViewModel;
                if (chatBoxViewModel2 != null) {
                    chatBoxViewModel2.onReceiveRoomEmojiMessage(str2);
                    return;
                }
                return;
            case 2:
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("IRC status", "连接成功");
                XesLog.ut((XesLogTag) TAG, jsonObject);
                ChatBoxViewModel chatBoxViewModel3 = this.mViewModel;
                if (chatBoxViewModel3 != null) {
                    chatBoxViewModel3.onIrcConnect();
                    return;
                }
                return;
            case 3:
            case 7:
                ChatBoxViewModel chatBoxViewModel4 = this.mViewModel;
                if (chatBoxViewModel4 != null) {
                    chatBoxViewModel4.onReceiveOpenChatMsg(str, str2);
                    return;
                }
                return;
            case 4:
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("IRC status", "断开连接");
                XesLog.ut((XesLogTag) TAG, jsonObject2);
                ChatBoxViewModel chatBoxViewModel5 = this.mViewModel;
                if (chatBoxViewModel5 != null) {
                    chatBoxViewModel5.onIrcDisconnect();
                    return;
                }
                return;
            case 5:
                ChatBoxViewModel chatBoxViewModel6 = this.mViewModel;
                if (chatBoxViewModel6 != null) {
                    chatBoxViewModel6.onReceiveLevelMsg(str, str2);
                    return;
                }
                return;
            case 6:
                ChatBoxViewModel chatBoxViewModel7 = this.mViewModel;
                if (chatBoxViewModel7 != null) {
                    chatBoxViewModel7.onReceiveTutorOpenChatMsg(str2);
                    return;
                }
                return;
            case 9:
                ChatBoxViewModel chatBoxViewModel8 = this.mViewModel;
                if (chatBoxViewModel8 != null) {
                    chatBoxViewModel8.onReceivePrivateMsg(str2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void eventInputMsgEnable(boolean z) {
        PluginEventBus.onEvent(DataBusKey.LIVE_MSG_UNABLE, new PluginEventData(LiveMsgPluginDriver.class, DataBusKey.LIVE_MSG_UNABLE, z ? EnterRoomMuteData.STATUS_UN_MUTE : "1"));
    }

    public void eventPrivateMsgState(boolean z) {
        PluginEventBus.onEvent(DataBusKey.LIVE_PRIVATE_MSG_STATE, new PluginEventData(LiveMsgPluginDriver.class, DataBusKey.LIVE_PRIVATE_MSG_STATE, z ? EnterRoomMuteData.STATUS_UN_MUTE : "1"));
    }

    public void updatePrivateMessage() {
        PluginEventBus.onEvent(DataBusKey.PRIVATE_MESSAGE_REMIND, new PluginEventData(MediaControlLiveDriver.class, DataBusKey.PRIVATE_MESSAGE_REMIND, ""));
    }

    public void sendPadEmojiMsg(EmojiAssembleBean emojiAssembleBean) {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null && emojiAssembleBean != null) {
            chatBoxViewModel.addMyEmojiMessage(emojiAssembleBean);
        }
    }

    public void sendHotWord(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "内容为空");
            return;
        }
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.addMyChatMessage(str);
        }
    }

    public void onClickHotWordBtn() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            Pair<Boolean, Long> isFrequently = chatBoxViewModel.isFrequently();
            if (((Boolean) isFrequently.getFirst()).booleanValue()) {
                LiveMsgPluginView liveMsgPluginView = this.mLiveMsgPluginView;
                if (liveMsgPluginView != null) {
                    liveMsgPluginView.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
                    return;
                }
                return;
            }
        }
        LiveMsgPluginView liveMsgPluginView2 = this.mLiveMsgPluginView;
        if (liveMsgPluginView2 != null) {
            liveMsgPluginView2.showHotWord();
        }
    }

    public void onClickEmojiBtn() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            Pair<Boolean, Long> isFrequently = chatBoxViewModel.isFrequently();
            if (((Boolean) isFrequently.getFirst()).booleanValue()) {
                LiveMsgPluginView liveMsgPluginView = this.mLiveMsgPluginView;
                if (liveMsgPluginView != null) {
                    liveMsgPluginView.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
                    return;
                }
                return;
            }
        }
        LiveMsgPluginView liveMsgPluginView2 = this.mLiveMsgPluginView;
        if (liveMsgPluginView2 != null) {
            liveMsgPluginView2.showEmojiPopupWindow();
        }
    }

    public void onClickSaySomethingBtn() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            Pair<Boolean, Long> isFrequently = chatBoxViewModel.isFrequently();
            if (((Boolean) isFrequently.getFirst()).booleanValue()) {
                if (this.isShowPrivateMsg) {
                    LiveMsgPrivatePluginView liveMsgPrivatePluginView = this.mLiveMsgPrivatePluginView;
                    if (liveMsgPrivatePluginView != null) {
                        liveMsgPrivatePluginView.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
                        return;
                    }
                    return;
                }
                LiveMsgPluginView liveMsgPluginView = this.mLiveMsgPluginView;
                if (liveMsgPluginView != null) {
                    liveMsgPluginView.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
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

    public void animationStart() {
        switchEnable(false);
    }

    public void animationEnd() {
        switchEnable(true);
    }

    public void switchEnable(boolean z) {
        PluginEventBus.onEvent(DataBusKey.SWITCHENABLE_KEY, new PluginEventData(LiveMsgPluginDriver.class, DataBusKey.SWITCHENABLE_KEY, z ? "1" : EnterRoomMuteData.STATUS_UN_MUTE));
    }

    public void setPrivateMsgState(boolean z) {
        this.isShowPrivateMsg = z;
    }

    public boolean getPrivateMsgState() {
        return this.isShowPrivateMsg;
    }

    public void openTutorPrivateMsg() {
        LiveMsgPrivatePluginView liveMsgPrivatePluginView = this.mLiveMsgPrivatePluginView;
        if (liveMsgPrivatePluginView != null) {
            liveMsgPrivatePluginView.openPrivateMsg();
        }
        LiveMsgPrivateRemindView liveMsgPrivateRemindView = this.mLiveMsgPrivateRemindView;
        if (liveMsgPrivateRemindView != null) {
            liveMsgPrivateRemindView.hide();
        }
    }

    public ILiveRoomProvider getLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        LiveMsgPluginDriver.super.onLifecycleDestroy(lifecycleOwner);
        LiveMsgPluginView liveMsgPluginView = this.mLiveMsgPluginView;
        if (liveMsgPluginView != null) {
            liveMsgPluginView.dismissCommonWindow();
        }
    }

    public void onDestroy() {
        PluginEventBus.unregister(DataBusKey.UPDATE_COINS, this.observerUserCoins);
        PluginEventBus.unregister(DataBusKey.STUDENTVIDEO_KEY, this.observerHasStudentVideo);
        PluginEventBus.unregister(DataBusKey.LIVE_MESSAGE_ANIMATION_KEY, this.observerStudentVideo);
        PluginEventBus.unregister(DataBusKey.LIVE_MSG_INPUT, this.observerInputMsg);
        PluginEventBus.unregister(DataBusKey.LIVE_MSG_TEACHER_ONLY, this.observerTeacherOnly);
        PluginEventBus.unregister(DataBusKey.LIVE_MSG_HOT_WORD, this.observerHotWord);
        PluginEventBus.unregister(DataBusKey.CLASS_FEEDBACK, this.observerFeedback);
        PluginEventBus.unregister(DataBusKey.CLASS_HANDUP, this.observerHandup);
        PluginEventBus.unregister(DataBusKey.LEVEL_KEY, this.observerUserLevel);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            PluginEventBus.unregister(DataBusKey.VIDEO_CHAT_TOGGLE, this.observerVideoState);
        }
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.getMListenerBody().removeObserver(this.mPrivateMsgObserver);
        }
    }

    /* access modifiers changed from: private */
    public void showHotWord() {
        initHotWordView();
        this.mLiveMsgHotWordPhoneView.showHotWordView();
        DriverTrack.INSTANCE.classRoomInteractShorcutShow();
    }

    public void onClickSendBtn(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "输入聊天内容为空");
            return;
        }
        if (this.isShowPrivateMsg) {
            ChatBoxViewModel chatBoxViewModel = this.mViewModel;
            if (chatBoxViewModel != null) {
                chatBoxViewModel.addMyPrivateChatMessage(str);
            }
            DriverTrack.INSTANCE.classRoomInteractMessageReply();
        } else {
            ChatBoxViewModel chatBoxViewModel2 = this.mViewModel;
            if (chatBoxViewModel2 != null) {
                chatBoxViewModel2.addMyChatMessage(str);
            }
            DriverTrack.INSTANCE.classRoomInteractChatSend();
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.clearInputContent();
        }
        track_click_chat();
    }

    public void onClickHotWords(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "输入聊天内容为空");
            return;
        }
        if (this.isShowPrivateMsg) {
            ChatBoxViewModel chatBoxViewModel = this.mViewModel;
            if (chatBoxViewModel != null) {
                chatBoxViewModel.addMyPrivateChatMessage(str);
            }
        } else {
            ChatBoxViewModel chatBoxViewModel2 = this.mViewModel;
            if (chatBoxViewModel2 != null) {
                chatBoxViewModel2.addMyChatMessage(str);
            }
        }
        DriverTrack.INSTANCE.classRoomInteractShorcutSend(str);
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.clearInputContent();
        }
        track_click_chat();
    }

    public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxViewModel chatBoxViewModel;
        if (chatBoxItemBean instanceof ChatBoxTextMsgBean) {
            ChatBoxViewModel chatBoxViewModel2 = this.mViewModel;
            if (chatBoxViewModel2 == null) {
                return;
            }
            if (this.isShowPrivateMsg) {
                chatBoxViewModel2.sendPrivateChatMessage((ChatBoxTextMsgBean) chatBoxItemBean);
            } else {
                chatBoxViewModel2.sendChatMessage((ChatBoxTextMsgBean) chatBoxItemBean);
            }
        } else if ((chatBoxItemBean instanceof ChatBoxEmojiMsgBean) && (chatBoxViewModel = this.mViewModel) != null) {
            chatBoxViewModel.sendEmojiMessage((ChatBoxEmojiMsgBean) chatBoxItemBean);
        }
    }

    public void switchChatState(boolean z) {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.switchOnlyLookTeacher(z);
        }
        track_click_only_teacher(z ? EnterRoomMuteData.STATUS_UN_MUTE : "1");
    }

    public void track_click_group_mode(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("button_status", str);
        LeanplumUtil.commonTrack(LeanplumUtil.click_group_mode, trackMap);
    }

    public void track_click_chat() {
        LeanplumUtil.commonTrack(LeanplumUtil.click_chat, LeanplumUtil.trackMap());
    }

    public void track_click_only_teacher(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("button_status", str);
        LeanplumUtil.commonTrack(LeanplumUtil.click_only_teacher, trackMap);
    }

    public void track_click_quickr_reply(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("content", str);
        LeanplumUtil.commonTrack(LeanplumUtil.click_quickr_reply, trackMap);
    }

    public void eventMuteStudentVideo(boolean z) {
        PluginEventBus.onEvent(DataBusKey.STUDENTVIDEO_MUTE, new PluginEventData(LiveMsgPluginDriver.class, DataBusKey.STUDENTVIDEO_MUTE, String.valueOf(z ? 2 : 0)));
    }
}
