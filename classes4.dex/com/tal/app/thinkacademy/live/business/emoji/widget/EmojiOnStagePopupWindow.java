package com.tal.app.thinkacademy.live.business.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceItemDecoration;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowEmojiAllonstageBinding;
import com.tal.app.thinkacademy.live.business.emoji.adapter.EmojiListAdapter;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.data.EmojiData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0005J-\u0010\u0015\u001a\u00020\u00112%\u0010\u0016\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000b\u001a#\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiOnStagePopupWindow;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "mContext", "Landroid/content/Context;", "adaptWidthPx", "", "(Landroid/content/Context;I)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mEmojiSelect", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "Lkotlin/ParameterName;", "name", "item", "", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessPopupwindowEmojiAllonstageBinding;", "getPopupWidth", "onEmojiSelected", "action", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiOnStagePopupWindow.kt */
public final class EmojiOnStagePopupWindow extends EasyPopup {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "EmojiOnStagePopupWindow";
    private Context mContext;
    private Function1<? super EmojiBean<?>, Unit> mEmojiSelect;
    private LiveBusinessPopupwindowEmojiAllonstageBinding mViewBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiOnStagePopupWindow(Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        LiveBusinessPopupwindowEmojiAllonstageBinding inflate = LiveBusinessPopupwindowEmojiAllonstageBinding.inflate(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutInflater.from(context))");
        this.mViewBinding = inflate;
        int dp2px = SizeUtils.dp2px(46.0f);
        int i2 = i / dp2px;
        setContentView((View) this.mViewBinding.getRoot()).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setWidth(dp2px * i2).setHeight(this.mContext.getResources().getDimensionPixelOffset(R.dimen.size_110dp)).setOnDismissListener(EmojiOnStagePopupWindow$$ExternalSyntheticLambda0.INSTANCE).createPopup();
        if (getContentView() != null) {
            this.mViewBinding.rvEmoji.setHasFixedSize(true);
            this.mViewBinding.rvEmoji.setItemAnimator(new DefaultItemAnimator());
            this.mViewBinding.rvEmoji.addItemDecoration(new SpaceItemDecoration(0, 0, 0, 0, 0, 0));
            this.mViewBinding.rvEmoji.setLayoutManager(new GridLayoutManager(getMContext(), i2));
            RecyclerView.Adapter emojiListAdapter = new EmojiListAdapter(EmojiData.getEmojis());
            this.mViewBinding.rvEmoji.setAdapter(emojiListAdapter);
            emojiListAdapter.addChildClickViewIds(new int[]{R.id.emojiListItemRL});
            emojiListAdapter.setOnItemChildClickListener(new EmojiOnStagePopupWindow$$ExternalSyntheticLambda1(this));
        }
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiOnStagePopupWindow$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EmojiOnStagePopupWindow.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m223_init_$lambda0() {
        XesLog.dt(TAG, "表情列表消失");
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-3$lambda-2  reason: not valid java name */
    public static final void m224lambda3$lambda2(EmojiOnStagePopupWindow emojiOnStagePopupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(emojiOnStagePopupWindow, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "inAdapter");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        Object item = baseQuickAdapter.getItem(i);
        if (item != null && (item instanceof EmojiBean)) {
            XesLog.dt(TAG, "表情被选中");
            Function1<? super EmojiBean<?>, Unit> function1 = emojiOnStagePopupWindow.mEmojiSelect;
            if (function1 != null) {
                function1.invoke(item);
            }
        }
        emojiOnStagePopupWindow.dismiss();
    }

    public final int getPopupWidth() {
        return this.mWidth;
    }

    public final void onEmojiSelected(Function1<? super EmojiBean<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.mEmojiSelect = function1;
    }
}
