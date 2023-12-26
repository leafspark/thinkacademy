package com.tal.app.thinkacademy.live.business.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceItemDecoration;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessListEmojiAllonstageBinding;
import com.tal.app.thinkacademy.live.business.emoji.adapter.EmojiListAdapter;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.data.EmojiData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0013J-\u0010\u0014\u001a\u00020\r2%\u0010\u0015\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJ\u0006\u0010\u0016\u001a\u00020\rR/\u0010\u0007\u001a#\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiOnStageListView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "mEmojiSelect", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "Lkotlin/ParameterName;", "name", "item", "", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessListEmojiAllonstageBinding;", "destroy", "hide", "isShowing", "", "onEmojiSelected", "action", "show", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiOnStageListView.kt */
public final class EmojiOnStageListView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "EmojiOnStageListView";
    private Function1<? super EmojiBean<?>, Unit> mEmojiSelect;
    private LiveBusinessListEmojiAllonstageBinding mViewBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiOnStageListView(Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LiveBusinessListEmojiAllonstageBinding inflate = LiveBusinessListEmojiAllonstageBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this, true)");
        this.mViewBinding = inflate;
        inflate.rvEmoji.setLayoutManager(new GridLayoutManager(context, i, 1, false));
        this.mViewBinding.rvEmoji.setHasFixedSize(true);
        this.mViewBinding.rvEmoji.setItemAnimator(new DefaultItemAnimator());
        this.mViewBinding.rvEmoji.addItemDecoration(new SpaceItemDecoration(0, 0, 0, 0, 0, 0));
        RecyclerView.Adapter emojiListAdapter = new EmojiListAdapter(EmojiData.getEmojis());
        this.mViewBinding.rvEmoji.setAdapter(emojiListAdapter);
        emojiListAdapter.addChildClickViewIds(new int[]{R.id.emojiListItemRL});
        emojiListAdapter.setOnItemChildClickListener(new EmojiOnStageListView$$ExternalSyntheticLambda1(this));
        this.mViewBinding.btnClose.setOnClickListener(new EmojiOnStageListView$$ExternalSyntheticLambda0(this));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiOnStageListView$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EmojiOnStageListView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m221_init_$lambda1(EmojiOnStageListView emojiOnStageListView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(emojiOnStageListView, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "inAdapter");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        Object item = baseQuickAdapter.getItem(i);
        if (item != null && (item instanceof EmojiBean)) {
            XesLog.dt(TAG, "表情被选中");
            Function1<? super EmojiBean<?>, Unit> function1 = emojiOnStageListView.mEmojiSelect;
            if (function1 != null) {
                function1.invoke(item);
            }
        }
        emojiOnStageListView.hide();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m222_init_$lambda2(EmojiOnStageListView emojiOnStageListView, View view) {
        Intrinsics.checkNotNullParameter(emojiOnStageListView, "this$0");
        emojiOnStageListView.hide();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    public final void show() {
        setVisibility(0);
    }

    public final void hide() {
        setVisibility(8);
    }

    public final void destroy() {
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public final void onEmojiSelected(Function1<? super EmojiBean<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.mEmojiSelect = function1;
    }
}
