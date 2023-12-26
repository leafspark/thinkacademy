package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J)\u0010!\u001a\u00020\u00132!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eJ\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0006\u0010&\u001a\u00020\u0013J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/PraiseController;", "", "()V", "mClickLooping", "", "mDataManager", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/DataManager;", "mFlyAnimGroup", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/FlyAnimGroup;", "mHandler", "Landroid/os/Handler;", "mLikeManager", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeManager;", "mLoopClickEnd", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "count", "", "mSelfClickNum", "addQueueMessage", "msg", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeMessage;", "bindFlyAnimGroup", "animGroup", "bindLikeCountView", "likeView", "Landroid/widget/TextView;", "clearQueueAndFlyGroup", "destroy", "increaseLikeCount", "loopClick", "setUserClickEnd", "block", "startLoopClick", "url", "", "startPoll", "stopLoopClick", "userClickLike", "Companion", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseController.kt */
public final class PraiseController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long LOOP_CLICK_DURATION = 300;
    public static final int MAX_LIKE_COUNT = 999;
    private static final int WHAT_LOOP_CLICK = 112;
    private boolean mClickLooping;
    /* access modifiers changed from: private */
    public final DataManager mDataManager;
    /* access modifiers changed from: private */
    public FlyAnimGroup mFlyAnimGroup;
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final LikeManager mLikeManager = new LikeManager();
    private Function1<? super Integer, Unit> mLoopClickEnd;
    private int mSelfClickNum;

    public PraiseController() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        Handler praiseController$mHandler$1 = new PraiseController$mHandler$1(this, myLooper);
        this.mHandler = praiseController$mHandler$1;
        this.mDataManager = new DataManager(praiseController$mHandler$1);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/PraiseController$Companion;", "", "()V", "LOOP_CLICK_DURATION", "", "MAX_LIKE_COUNT", "", "WHAT_LOOP_CLICK", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void bindLikeCountView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "likeView");
        this.mLikeManager.bindView(textView, MAX_LIKE_COUNT);
    }

    public final void bindFlyAnimGroup(FlyAnimGroup flyAnimGroup) {
        Intrinsics.checkNotNullParameter(flyAnimGroup, "animGroup");
        this.mFlyAnimGroup = flyAnimGroup;
    }

    public final void startPoll() {
        this.mDataManager.startPolling(new PraiseController$startPoll$1(this), new PraiseController$startPoll$2(this));
    }

    public final void addQueueMessage(LikeMessage likeMessage) {
        Intrinsics.checkNotNullParameter(likeMessage, "msg");
        this.mDataManager.add(likeMessage);
    }

    public final void userClickLike(String str) {
        if (this.mClickLooping) {
            XesLog.it("PraiseController", new Object[]{"click loop"});
            loopClick();
        } else {
            XesLog.it("PraiseController", new Object[]{"start click"});
            this.mClickLooping = true;
            startLoopClick(str);
        }
        this.mHandler.removeMessages(112);
        this.mHandler.sendEmptyMessageDelayed(112, 300);
    }

    public final void setUserClickEnd(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mLoopClickEnd = function1;
    }

    private final void startLoopClick(String str) {
        clearQueueAndFlyGroup();
        if (str == null) {
            FlyAnimGroup flyAnimGroup = this.mFlyAnimGroup;
            if (flyAnimGroup != null) {
                flyAnimGroup.addFlyViews(3, new String[0]);
            }
        } else {
            FlyAnimGroup flyAnimGroup2 = this.mFlyAnimGroup;
            if (flyAnimGroup2 != null) {
                flyAnimGroup2.addFlyViews(3, str);
            }
        }
        increaseLikeCount();
    }

    private final void loopClick() {
        FlyAnimGroup flyAnimGroup = this.mFlyAnimGroup;
        if (flyAnimGroup != null) {
            flyAnimGroup.addFlyViews(3, new String[0]);
        }
        increaseLikeCount();
    }

    /* access modifiers changed from: private */
    public final void stopLoopClick() {
        XesLog.it("PraiseController", new Object[]{"stop click"});
        int i = this.mSelfClickNum;
        this.mSelfClickNum = 0;
        Function1<? super Integer, Unit> function1 = this.mLoopClickEnd;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        this.mClickLooping = false;
        startPoll();
    }

    private final void clearQueueAndFlyGroup() {
        this.mDataManager.stopPolling();
        this.mLikeManager.increase(this.mDataManager.loopRemoveTotalLikeCount(), false);
        FlyAnimGroup flyAnimGroup = this.mFlyAnimGroup;
        if (flyAnimGroup != null) {
            flyAnimGroup.clearAll();
        }
    }

    private final void increaseLikeCount() {
        this.mSelfClickNum++;
        this.mLikeManager.increase(1, false);
    }

    public final void destroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mLikeManager.destroy();
        this.mDataManager.destroy();
        this.mFlyAnimGroup = null;
        this.mLoopClickEnd = null;
    }
}
