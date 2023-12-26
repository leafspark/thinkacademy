package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PluginAnnotation(desc = "回放聊天消息插件", launchType = "enter", liveType = 1, moduleId = "-102")
@ViewLevels({@ViewLevel(level = 120, name = "LiveBackMsgView")})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/PlayBackMsgPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/core/callback/PlayerTimeCallBack;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "mCurrentSeiTime", "", "mLiveBackMsgPluginView", "Lcom/tal/app/thinkacademy/live/business/livemessage/LiveBackMsgPluginView;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel;", "destroyView", "", "loadView", "observeListener", "onDestroy", "onMessage", "ircTypeKey", "", "message", "onPlaying", "currentPosition", "duration", "onSeiCurrent", "currentSei", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayBackMsgPluginDriver.kt */
public final class PlayBackMsgPluginDriver extends BaseLivePluginDriver implements PlayerTimeCallBack {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TARGET = "LiveBackMsgPluginDriver.Observer";
    private Context mContext = ((Context) this.mLiveRoomProvider.getWeakRefContext().get());
    private long mCurrentSeiTime;
    /* access modifiers changed from: private */
    public LiveBackMsgPluginView mLiveBackMsgPluginView;
    private ChatBoxViewModel mViewModel = AbilityPackKt.getAbilityPack().getViewModel(ChatBoxViewModel.class);

    public void onMessage(String str, String str2) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayBackMsgPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        XesLog.i(Tag.CHAT_BOX, "回放聊天消息插件激活");
        loadView();
        observeListener();
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.requestPlayBackMessage();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/PlayBackMsgPluginDriver$Companion;", "", "()V", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayBackMsgPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void observeListener() {
        ListenerData<ChatBoxListenerBody> mListenerBody;
        this.mLiveRoomProvider.registerPlayerTimeCallback(this);
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null && (mListenerBody = chatBoxViewModel.getMListenerBody()) != null) {
            mListenerBody.observeListener((LifecycleOwner) this, false, TARGET, new PlayBackMsgPluginDriver$observeListener$1(this));
        }
    }

    private final void loadView() {
        Context context = this.mContext;
        if (context != null) {
            XesLog.i(Tag.CHAT_BOX, "加载View");
            this.mLiveBackMsgPluginView = new LiveBackMsgPluginView(context);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mLiveBackMsgPluginView, "LiveBackMsgView", LiveAreaContext.get().getMsgLp().newLp());
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new PlayBackMsgPluginDriver$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadView$lambda-2$lambda-1  reason: not valid java name */
    public static final void m325loadView$lambda2$lambda1(PlayBackMsgPluginDriver playBackMsgPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(playBackMsgPluginDriver, "this$0");
        LiveBackMsgPluginView liveBackMsgPluginView = playBackMsgPluginDriver.mLiveBackMsgPluginView;
        if (liveBackMsgPluginView != null) {
            ViewGroup.LayoutParams layoutParams = liveBackMsgPluginView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            liveAreaContext.getMsgLp().mergeLp(layoutParams2);
            liveBackMsgPluginView.setLayoutParams(layoutParams2);
        }
    }

    private final void destroyView() {
        LiveBackMsgPluginView liveBackMsgPluginView = this.mLiveBackMsgPluginView;
        if (liveBackMsgPluginView != null) {
            XesLog.i(Tag.CHAT_BOX, "销毁View");
            this.mLiveRoomProvider.removeView((View) liveBackMsgPluginView);
        }
        this.mLiveBackMsgPluginView = null;
    }

    public void onDestroy() {
        ListenerData<ChatBoxListenerBody> mListenerBody;
        this.mLiveRoomProvider.unregisterPlayerTimeCallback(this);
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (!(chatBoxViewModel == null || (mListenerBody = chatBoxViewModel.getMListenerBody()) == null)) {
            mListenerBody.removeListener(TARGET);
        }
        destroyView();
    }

    public void onPlaying(long j, long j2) {
        ChatBoxViewModel chatBoxViewModel;
        ChatBoxViewModel chatBoxViewModel2 = this.mViewModel;
        boolean z = false;
        if (chatBoxViewModel2 != null && chatBoxViewModel2.checkSeiTimestamp(this.mCurrentSeiTime)) {
            z = true;
        }
        if (z && (chatBoxViewModel = this.mViewModel) != null) {
            chatBoxViewModel.requestPlayBackMessage();
        }
        ChatBoxViewModel chatBoxViewModel3 = this.mViewModel;
        if (chatBoxViewModel3 != null) {
            chatBoxViewModel3.addPlayBackMessage(this.mCurrentSeiTime);
        }
    }

    public void onSeiCurrent(long j) {
        this.mCurrentSeiTime = j;
    }
}
