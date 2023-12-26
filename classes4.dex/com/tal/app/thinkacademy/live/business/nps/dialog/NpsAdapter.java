package com.tal.app.thinkacademy.live.business.nps.dialog;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundTextView;
import com.flyco.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.entity.NpsTagConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\u001a\u0010\u0015\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0018\u0010\u0017\u001a\u00020\b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/dialog/NpsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig$NpsTag;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "etVisibleListener", "Lkotlin/Function1;", "", "", "mSelectedTags", "", "", "mSelectedWithFlagTags", "tag", "Lcom/tal/app/thinkacademy/live/Tag;", "convert", "holder", "item", "etIsVisible", "getSelectedTags", "", "setEtVisibleListener", "listener", "setList", "list", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsAdapter.kt */
public final class NpsAdapter extends BaseQuickAdapter<NpsTagConfig.NpsTag, BaseViewHolder> {
    private Function1<? super Boolean, Unit> etVisibleListener;
    private final List<Integer> mSelectedTags = new ArrayList();
    private final List<NpsTagConfig.NpsTag> mSelectedWithFlagTags = new ArrayList();
    private final Tag tag = Tag.NPS;

    public NpsAdapter() {
        super(R.layout.layout_item_nps, (List) null);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, NpsTagConfig.NpsTag npsTag) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(npsTag, "item");
        RoundTextView view = baseViewHolder.getView(R.id.item_tv_descriptor);
        view.setText(npsTag.getName());
        int id = npsTag.getId();
        int itemPosition = getItemPosition(npsTag);
        RoundViewDelegate delegate = view.getDelegate();
        if (this.mSelectedTags.contains(Integer.valueOf(id))) {
            view.setSelected(true);
            delegate.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_fff9ec));
        } else {
            view.setSelected(false);
            delegate.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_f8f8f9));
        }
        view.setOnClickListener(new NpsAdapter$$ExternalSyntheticLambda0(this, itemPosition, npsTag, id));
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-0  reason: not valid java name */
    public static final void m342convert$lambda0(NpsAdapter npsAdapter, int i, NpsTagConfig.NpsTag npsTag, int i2, View view) {
        Intrinsics.checkNotNullParameter(npsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(npsTag, "$item");
        XesLog.i(npsAdapter.tag, "用户点击了第 " + i + " 个标签");
        boolean etIsVisible = npsAdapter.etIsVisible(npsTag);
        Function1<? super Boolean, Unit> function1 = npsAdapter.etVisibleListener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(etIsVisible));
        }
        if (npsAdapter.mSelectedTags.contains(Integer.valueOf(i2))) {
            npsAdapter.mSelectedTags.remove(Integer.valueOf(i2));
        } else {
            npsAdapter.mSelectedTags.add(Integer.valueOf(i2));
        }
        npsAdapter.notifyItemChanged(i);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setList(Collection<NpsTagConfig.NpsTag> collection) {
        NpsAdapter.super.setList(collection);
        this.mSelectedTags.clear();
        this.mSelectedWithFlagTags.clear();
    }

    public final List<Integer> getSelectedTags() {
        return this.mSelectedTags;
    }

    public final void setEtVisibleListener(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        this.etVisibleListener = function1;
    }

    private final boolean etIsVisible(NpsTagConfig.NpsTag npsTag) {
        if (this.mSelectedWithFlagTags.contains(npsTag)) {
            this.mSelectedWithFlagTags.remove(npsTag);
        } else if (npsTag.getDetailFlag() == 1) {
            this.mSelectedWithFlagTags.add(npsTag);
        }
        return !this.mSelectedWithFlagTags.isEmpty();
    }
}
