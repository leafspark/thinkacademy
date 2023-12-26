package com.tal.app.thinkacademy.live.business.nps.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.google.android.flexbox.FlexboxItemDecoration;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.entity.NpsTagConfig;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNpsDialogBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012&\u0010\u0007\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/dialog/NpsDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessNpsDialogBinding;", "context", "Landroid/content/Context;", "mNpsTagConfig", "Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;", "mNpsSaveListener", "Lkotlin/Function3;", "", "", "", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;Lkotlin/jvm/functions/Function3;)V", "mNpsAdapter", "Lcom/tal/app/thinkacademy/live/business/nps/dialog/NpsAdapter;", "score", "changeEtVisibility", "flag", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "initListener", "initRatingBar", "initViews", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsDialog.kt */
public final class NpsDialog extends BaseBindDialog<LiveBusinessNpsDialogBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.NPS;
    private NpsAdapter mNpsAdapter;
    private final Function3<List<Integer>, Integer, String, Unit> mNpsSaveListener;
    private final NpsTagConfig mNpsTagConfig;
    private int score;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NpsDialog(Context context, NpsTagConfig npsTagConfig, Function3<? super List<Integer>, ? super Integer, ? super String, Unit> function3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNpsTagConfig = npsTagConfig;
        this.mNpsSaveListener = function3;
        canceledOnTouchOutside(false);
        layoutParams(new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.size_343dp), -2));
        initViews();
        initListener();
        initRatingBar();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/dialog/NpsDialog$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NpsDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessNpsDialogBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessNpsDialogBinding inflate = LiveBusinessNpsDialogBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    private final void initViews() {
        if (this.mNpsAdapter == null) {
            this.mNpsAdapter = new NpsAdapter();
            RecyclerView.LayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
            flexboxLayoutManager.setFlexWrap(1);
            flexboxLayoutManager.setFlexDirection(0);
            flexboxLayoutManager.setAlignItems(4);
            flexboxLayoutManager.setJustifyContent(0);
            this.binding.rvTags.setLayoutManager(flexboxLayoutManager);
            RecyclerView.ItemDecoration flexboxItemDecoration = new FlexboxItemDecoration(getContext());
            flexboxItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.item_divider_problem));
            this.binding.rvTags.addItemDecoration(flexboxItemDecoration);
            this.binding.rvTags.setAdapter(this.mNpsAdapter);
        }
    }

    private final void initRatingBar() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        this.binding.RatingBar.setOnRatingBarChangeListener(new NpsDialog$$ExternalSyntheticLambda2(this, objectRef));
    }

    /* access modifiers changed from: private */
    /* renamed from: initRatingBar$lambda-0  reason: not valid java name */
    public static final void m347initRatingBar$lambda0(NpsDialog npsDialog, Ref.ObjectRef objectRef, RatingBar ratingBar, float f, boolean z) {
        Intrinsics.checkNotNullParameter(npsDialog, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$currentTagList");
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        boolean z2 = true;
        npsDialog.binding.tvSubmit.setEnabled(!(i == 0));
        List<NpsTagConfig.NpsTag> list = null;
        if (f == 5.0f) {
            XesLog.i(TAG, "用户点击了5颗星");
            npsDialog.score = 5;
            NpsTagConfig npsTagConfig = npsDialog.mNpsTagConfig;
            if (npsTagConfig != null) {
                list = npsTagConfig.getFiveTagList();
            }
            objectRef.element = list;
            npsDialog.binding.ivEmoji.setImageResource(R.drawable.nps_emoji_happy);
        } else {
            if (f == 4.0f) {
                XesLog.i(TAG, "用户点击了4颗星");
                npsDialog.score = 4;
                NpsTagConfig npsTagConfig2 = npsDialog.mNpsTagConfig;
                if (npsTagConfig2 != null) {
                    list = npsTagConfig2.getFourTagList();
                }
                objectRef.element = list;
                npsDialog.binding.ivEmoji.setImageResource(R.drawable.nps_emoji_happy);
            } else {
                if (f == 3.0f) {
                    XesLog.i(TAG, "用户点击了3颗星");
                    npsDialog.score = 3;
                    NpsTagConfig npsTagConfig3 = npsDialog.mNpsTagConfig;
                    if (npsTagConfig3 != null) {
                        list = npsTagConfig3.getThreeTagList();
                    }
                    objectRef.element = list;
                    npsDialog.binding.ivEmoji.setImageResource(R.drawable.nps_emoji_normal);
                } else {
                    if (f == 2.0f) {
                        XesLog.i(TAG, "用户点击了2颗星");
                        npsDialog.score = 2;
                        NpsTagConfig npsTagConfig4 = npsDialog.mNpsTagConfig;
                        if (npsTagConfig4 != null) {
                            list = npsTagConfig4.getTwoTagList();
                        }
                        objectRef.element = list;
                        npsDialog.binding.ivEmoji.setImageResource(R.drawable.nps_emoji_sad);
                    } else {
                        if (f == 1.0f) {
                            XesLog.i(TAG, "用户点击了1颗星");
                            npsDialog.score = 1;
                            NpsTagConfig npsTagConfig5 = npsDialog.mNpsTagConfig;
                            if (npsTagConfig5 != null) {
                                list = npsTagConfig5.getOneTagList();
                            }
                            objectRef.element = list;
                            npsDialog.binding.ivEmoji.setImageResource(R.drawable.nps_emoji_sad);
                        } else {
                            if (i == 0) {
                                XesLog.i(TAG, "用户取消（0颗星）");
                                npsDialog.score = 0;
                                objectRef.element = null;
                            }
                        }
                    }
                }
            }
        }
        if (npsDialog.score == 0) {
            npsDialog.binding.ivEmoji.setVisibility(8);
        } else {
            npsDialog.binding.ivEmoji.setVisibility(0);
        }
        npsDialog.binding.etContent.setText("");
        Collection collection = (Collection) objectRef.element;
        if (collection != null && !collection.isEmpty()) {
            z2 = false;
        }
        if (z2) {
            npsDialog.binding.layout.setVisibility(8);
        } else {
            npsDialog.binding.layout.setVisibility(0);
            NpsAdapter npsAdapter = npsDialog.mNpsAdapter;
            if (npsAdapter != null) {
                npsAdapter.setList((Collection) objectRef.element);
            }
            npsDialog.changeEtVisibility(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(ratingBar);
    }

    private final void initListener() {
        NpsAdapter npsAdapter = this.mNpsAdapter;
        Intrinsics.checkNotNull(npsAdapter);
        npsAdapter.setEtVisibleListener(new NpsDialog$initListener$1(this));
        this.binding.ivCancel.setOnClickListener(new NpsDialog$$ExternalSyntheticLambda1(this));
        this.binding.tvSubmit.setOnClickListener(new NpsDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-1  reason: not valid java name */
    public static final void m345initListener$lambda1(NpsDialog npsDialog, View view) {
        Intrinsics.checkNotNullParameter(npsDialog, "this$0");
        XesLog.i(TAG, "用户点击了关闭窗口");
        npsDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-2  reason: not valid java name */
    public static final void m346initListener$lambda2(NpsDialog npsDialog, View view) {
        Intrinsics.checkNotNullParameter(npsDialog, "this$0");
        XesLog.i(TAG, "点击了提交按钮");
        Function3<List<Integer>, Integer, String, Unit> function3 = npsDialog.mNpsSaveListener;
        if (function3 != null) {
            NpsAdapter npsAdapter = npsDialog.mNpsAdapter;
            List<Integer> selectedTags = npsAdapter == null ? null : npsAdapter.getSelectedTags();
            if (selectedTags == null) {
                selectedTags = new ArrayList<>();
            }
            function3.invoke(selectedTags, Integer.valueOf(npsDialog.score), StringsKt.trim(String.valueOf(npsDialog.binding.etContent.getText())).toString());
        }
        npsDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void changeEtVisibility(boolean z) {
        if (z) {
            this.binding.etLayout.setVisibility(0);
            return;
        }
        this.binding.etLayout.setVisibility(8);
        KeyboardUtil.hideKeyboard((View) this.binding.etContent);
    }
}
