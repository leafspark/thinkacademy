package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0006\u0010\u001c\u001a\u00020\nJL\u0010\u001d\u001a\u00020\u000e2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000e0\t2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tJ\u0006\u0010 \u001a\u00020\u000eJ&\u0010!\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/DataManager;", "", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "mMessageQueue", "Lkotlin/collections/ArrayDeque;", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeMessage;", "mPollCountBlock", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "likeCount", "", "mPollUrlBlock", "", "url", "mStopPolling", "", "add", "message", "destroy", "handleMessage", "msg", "Landroid/os/Message;", "handleMessage$lib_commui_release", "loopData", "loopRemoveTotalLikeCount", "startPolling", "blockUrl", "blockCount", "stopPolling", "loopRemove", "block", "Companion", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseController.kt */
public final class DataManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long LOOP_TIME = 1000;
    public static final int TIMEOUT = 2000;
    public static final int WHAT_POLL_TYPE = 11;
    private final Handler handler;
    private final ArrayDeque<LikeMessage> mMessageQueue = new ArrayDeque<>();
    private Function1<? super Integer, Unit> mPollCountBlock;
    /* access modifiers changed from: private */
    public Function1<? super String, Unit> mPollUrlBlock;
    private boolean mStopPolling;

    public DataManager(Handler handler2) {
        Intrinsics.checkNotNullParameter(handler2, "handler");
        this.handler = handler2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/DataManager$Companion;", "", "()V", "LOOP_TIME", "", "TIMEOUT", "", "WHAT_POLL_TYPE", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void handleMessage$lib_commui_release(Message message) {
        Intrinsics.checkNotNullParameter(message, "msg");
        if (message.what == 11 && !this.mStopPolling) {
            this.handler.sendEmptyMessageDelayed(11, 1000);
            loopData();
        }
    }

    private final void loopData() {
        if (!this.mStopPolling) {
            long currentTimeMillis = System.currentTimeMillis();
            Ref.IntRef intRef = new Ref.IntRef();
            loopRemove(this.mMessageQueue, new DataManager$loopData$1(intRef, currentTimeMillis, this));
            if (intRef.element > 0) {
                XesLog.it("PraiseController-DataManager", new Object[]{Intrinsics.stringPlus("likeCount:", Integer.valueOf(intRef.element))});
                Function1<? super Integer, Unit> function1 = this.mPollCountBlock;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(intRef.element));
                }
            }
        }
    }

    public final void startPolling(Function1<? super String, Unit> function1, Function1<? super Integer, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "blockUrl");
        Intrinsics.checkNotNullParameter(function12, "blockCount");
        this.mStopPolling = false;
        this.mPollUrlBlock = function1;
        this.mPollCountBlock = function12;
        this.handler.removeMessages(11);
        Handler handler2 = this.handler;
        if (!(handler2 instanceof Handler)) {
            handler2.sendEmptyMessage(11);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler2, 11);
        }
    }

    public final void stopPolling() {
        this.mStopPolling = true;
        this.handler.removeMessages(11);
    }

    public final void add(LikeMessage likeMessage) {
        Intrinsics.checkNotNullParameter(likeMessage, "message");
        this.mMessageQueue.addLast(likeMessage);
    }

    public final int loopRemoveTotalLikeCount() {
        Ref.IntRef intRef = new Ref.IntRef();
        loopRemove(this.mMessageQueue, new DataManager$loopRemoveTotalLikeCount$1(intRef));
        return intRef.element;
    }

    public final void destroy() {
        this.mStopPolling = true;
        this.mMessageQueue.clear();
        this.mPollUrlBlock = null;
        this.mPollCountBlock = null;
    }

    private final void loopRemove(ArrayDeque<LikeMessage> arrayDeque, Function1<? super LikeMessage, Boolean> function1) {
        if (!arrayDeque.isEmpty()) {
            boolean z = true;
            while (z) {
                LikeMessage removeFirstOrNull = arrayDeque.removeFirstOrNull();
                if (removeFirstOrNull == null || function1.invoke(removeFirstOrNull).booleanValue()) {
                    z = false;
                }
            }
        }
    }
}
