package com.tal.app.thinkacademy.live.business.pageindex;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel;
import com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import com.tal.app.thinkacademy.live.abilitypack.playback.listenbody.PlaybackListenerBody;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PluginAnnotation(desc = "回放翻页索引列表", launchType = "enter", liveType = 1, moduleId = "-108")
@ViewLevels({@ViewLevel(level = 30, name = "pageIndex")})
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/pageindex/PageIndexPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mLayoutObserver", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaContext;", "mPageIndexPluginView", "Lcom/tal/app/thinkacademy/live/business/pageindex/PageIndexPluginView;", "mPlaybackViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/PlaybackViewModel;", "onDestroy", "", "onMessage", "ircTypeKey", "", "message", "setPageIndexVisible", "visible", "", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageIndexPluginDriver.kt */
public final class PageIndexPluginDriver extends BaseLivePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.PLAYBACK_PAGE_INDEX;
    private static final String TARGET = "PageIndexPluginDriver.observer";
    private Observer<LiveAreaContext> mLayoutObserver = new PageIndexPluginDriver$$ExternalSyntheticLambda0(this);
    /* access modifiers changed from: private */
    public PageIndexPluginView mPageIndexPluginView;
    /* access modifiers changed from: private */
    public final PlaybackViewModel mPlaybackViewModel;

    public void onMessage(String str, String str2) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageIndexPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        ListenerData<PlaybackListenerBody> mListenerData;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        PlaybackViewModel playbackViewModel = PlaybackViewModelKt.getPlaybackViewModel(AbilityPack.Companion.get());
        this.mPlaybackViewModel = playbackViewModel;
        if (playbackViewModel != null && (mListenerData = playbackViewModel.getMListenerData()) != null) {
            mListenerData.observeListener((LifecycleOwner) this, false, TARGET, new Function1<PlaybackListenerBody, Unit>(this) {
                final /* synthetic */ PageIndexPluginDriver this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PlaybackListenerBody) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(PlaybackListenerBody playbackListenerBody) {
                    Intrinsics.checkNotNullParameter(playbackListenerBody, "$this$observeListener");
                    final PageIndexPluginDriver pageIndexPluginDriver = this.this$0;
                    playbackListenerBody.onPageIndexVisible(new Function1<Boolean, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            pageIndexPluginDriver.setPageIndexVisible(z);
                        }
                    });
                    final PageIndexPluginDriver pageIndexPluginDriver2 = this.this$0;
                    playbackListenerBody.onPageIndexChanged(new Function1<Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i) {
                            PageIndexPluginView access$getMPageIndexPluginView$p = pageIndexPluginDriver2.mPageIndexPluginView;
                            if (access$getMPageIndexPluginView$p != null) {
                                access$getMPageIndexPluginView$p.scrollToPageIndex(i);
                            }
                        }
                    });
                    final PageIndexPluginDriver pageIndexPluginDriver3 = this.this$0;
                    playbackListenerBody.onObtainPageIndexData(new Function1<List<? extends PageIndexData>, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((List<PageIndexData>) (List) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<PageIndexData> list) {
                            Intrinsics.checkNotNullParameter(list, "it");
                            PageIndexPluginView access$getMPageIndexPluginView$p = pageIndexPluginDriver3.mPageIndexPluginView;
                            if (access$getMPageIndexPluginView$p != null) {
                                access$getMPageIndexPluginView$p.setPageIndexList(list);
                            }
                        }
                    });
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/pageindex/PageIndexPluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PageIndexPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mLayoutObserver$lambda-2  reason: not valid java name */
    public static final void m348mLayoutObserver$lambda2(PageIndexPluginDriver pageIndexPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(pageIndexPluginDriver, "this$0");
        PageIndexPluginView pageIndexPluginView = pageIndexPluginDriver.mPageIndexPluginView;
        if (pageIndexPluginView != null) {
            ViewGroup.LayoutParams layoutParams = pageIndexPluginView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                liveAreaContext.getPptLp().mergeLp(layoutParams2);
                pageIndexPluginView.setLayoutParams(layoutParams2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setPageIndexVisible(boolean z) {
        ILiveRoomProvider iLiveRoomProvider;
        WeakReference<Context> weakRefContext;
        Context context;
        BaseLivePluginDriver baseLivePluginDriver = this;
        int i = 0;
        if (!(baseLivePluginDriver.mPageIndexPluginView != null || (iLiveRoomProvider = baseLivePluginDriver.mLiveRoomProvider) == null || (weakRefContext = iLiveRoomProvider.getWeakRefContext()) == null || (context = (Context) weakRefContext.get()) == null)) {
            XesLog.i(TAG, "初始化视图");
            BaseLivePluginView pageIndexPluginView = new PageIndexPluginView(context);
            pageIndexPluginView.setOnPageIndexSelected(new PageIndexPluginDriver$setPageIndexVisible$1$1$1$1(baseLivePluginDriver));
            PlaybackViewModel playbackViewModel = baseLivePluginDriver.mPlaybackViewModel;
            pageIndexPluginView.setPageIndexList(playbackViewModel == null ? null : playbackViewModel.getPageIndexList());
            baseLivePluginDriver.mLiveRoomProvider.addView(baseLivePluginDriver, pageIndexPluginView, "pageIndex", LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observerSticky((LifecycleOwner) this, false, baseLivePluginDriver.mLayoutObserver);
            baseLivePluginDriver.mPageIndexPluginView = pageIndexPluginView;
        }
        PageIndexPluginView pageIndexPluginView2 = baseLivePluginDriver.mPageIndexPluginView;
        if (pageIndexPluginView2 != null) {
            XesLog.i(TAG, Intrinsics.stringPlus("翻页索引控制展示：", Boolean.valueOf(z)));
            if (!z) {
                i = 8;
            }
            pageIndexPluginView2.setVisibility(i);
        }
    }

    public void onDestroy() {
        LiveAreaContext.get().layoutObserver.removeObserver(this.mLayoutObserver);
        PageIndexPluginView pageIndexPluginView = this.mPageIndexPluginView;
        if (pageIndexPluginView != null) {
            ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
            if (iLiveRoomProvider != null) {
                iLiveRoomProvider.removeView((View) pageIndexPluginView);
            }
            pageIndexPluginView.destroy();
            this.mPageIndexPluginView = null;
        }
    }
}
