package com.tal.app.thinkacademy.live.business.liveplayback.dialog;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.common.entity.AddressBean;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/liveplayback/dialog/PlaybackSwitchLineAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/common/entity/AddressBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mSelectIndex", "", "getMSelectIndex", "()I", "setMSelectIndex", "(I)V", "convert", "", "holder", "item", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaybackSwitchLineAdapter.kt */
public final class PlaybackSwitchLineAdapter extends BaseQuickAdapter<AddressBean, BaseViewHolder> {
    private int mSelectIndex;

    public PlaybackSwitchLineAdapter() {
        super(R.layout.playback_switch_line_item, (List) null);
    }

    public final int getMSelectIndex() {
        return this.mSelectIndex;
    }

    public final void setMSelectIndex(int i) {
        this.mSelectIndex = i;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, AddressBean addressBean) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(addressBean, "item");
        int layoutPosition = baseViewHolder.getLayoutPosition();
        baseViewHolder.itemView.setSelected(this.mSelectIndex == layoutPosition);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s %s", Arrays.copyOf(new Object[]{baseViewHolder.itemView.getContext().getString(R.string.playback_line), Integer.valueOf(layoutPosition + 1)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ((TextView) baseViewHolder.getView(R.id.lineName)).setText(format);
    }
}
