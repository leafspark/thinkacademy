package com.tal.app.thinkacademy.live.business.function;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/EmojiTipsView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mHandler", "Landroid/os/Handler;", "destroy", "", "getLayoutId", "", "setTips", "text", "", "showTime", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiTipsView.kt */
public class EmojiTipsView extends BaseLivePluginView {
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new EmojiTipsView$$ExternalSyntheticLambda0(this));
    private final ILiveRoomProvider provider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiTipsView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
    }

    /* access modifiers changed from: private */
    /* renamed from: mHandler$lambda-0  reason: not valid java name */
    public static final boolean m227mHandler$lambda0(EmojiTipsView emojiTipsView, Message message) {
        Intrinsics.checkNotNullParameter(emojiTipsView, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        if (message.what == 1) {
            emojiTipsView.provider.removeView((View) emojiTipsView);
        }
        return true;
    }

    public static /* synthetic */ void setTips$default(EmojiTipsView emojiTipsView, String str, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                j = 3000;
            }
            emojiTipsView.setTips(str, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTips");
    }

    public final void setTips(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "text");
        ((TextView) findViewById(R.id.tv_tip_body)).setText(str);
        this.mHandler.sendEmptyMessageDelayed(1, j);
    }

    public int getLayoutId() {
        return R.layout.live_business_function_tips_layout;
    }

    public final void destroy() {
        this.provider.removeView((View) this);
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
