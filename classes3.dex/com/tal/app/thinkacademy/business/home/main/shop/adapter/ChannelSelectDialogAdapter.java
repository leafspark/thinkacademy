package com.tal.app.thinkacademy.business.home.main.shop.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelDialogSection;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelGroup;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B=\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0016RL\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ChannelSelectDialogAdapter;", "Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelDialogSection;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pos", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "channel", "", "(Lkotlin/jvm/functions/Function2;)V", "mListener", "getMListener", "()Lkotlin/jvm/functions/Function2;", "setMListener", "mSelectedId", "getMSelectedId", "()I", "setMSelectedId", "(I)V", "mSelectedPosition", "getMSelectedPosition", "setMSelectedPosition", "convert", "holder", "item", "convertHeader", "helper", "onBindViewHolder", "position", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelSelectDialogAdapter.kt */
public final class ChannelSelectDialogAdapter extends BaseSectionQuickAdapter<ChannelDialogSection, BaseViewHolder> {
    private Function2<? super Integer, ? super Channel, Unit> mListener;
    private int mSelectedId = -1;
    private int mSelectedPosition = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelSelectDialogAdapter(Function2<? super Integer, ? super Channel, Unit> function2) {
        super(R.layout.shop_select_dialog_item_head, R.layout.shop_select_dialog_item_normal, (List) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(function2, "listener");
        addChildClickViewIds(new int[]{R.id.channel_item_name});
        this.mListener = function2;
        setOnItemChildClickListener(new OnItemChildClickListener(this) {
            final /* synthetic */ ChannelSelectDialogAdapter this$0;

            {
                this.this$0 = r1;
            }

            public void onItemChildClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                if (!CommonUtilsKt.isFastClick()) {
                    ChannelDialogSection channelDialogSection = (ChannelDialogSection) this.this$0.getData().get(i);
                    if (channelDialogSection instanceof Channel) {
                        ChannelSelectDialogAdapter channelSelectDialogAdapter = this.this$0;
                        Integer id = ((Channel) channelDialogSection).getId();
                        channelSelectDialogAdapter.setMSelectedId(id == null ? -1 : id.intValue());
                        if (this.this$0.getMSelectedPosition() > 0 && this.this$0.getMSelectedPosition() < this.this$0.getData().size()) {
                            ChannelSelectDialogAdapter channelSelectDialogAdapter2 = this.this$0;
                            channelSelectDialogAdapter2.notifyItemChanged(channelSelectDialogAdapter2.getMSelectedPosition());
                        }
                        this.this$0.setMSelectedPosition(i);
                        ChannelSelectDialogAdapter channelSelectDialogAdapter3 = this.this$0;
                        channelSelectDialogAdapter3.notifyItemChanged(channelSelectDialogAdapter3.getMSelectedPosition());
                        Function2<Integer, Channel, Unit> mListener = this.this$0.getMListener();
                        if (mListener != null) {
                            mListener.invoke(Integer.valueOf(i), channelDialogSection);
                        }
                    }
                }
            }
        });
    }

    public final int getMSelectedId() {
        return this.mSelectedId;
    }

    public final void setMSelectedId(int i) {
        this.mSelectedId = i;
    }

    public final int getMSelectedPosition() {
        return this.mSelectedPosition;
    }

    public final void setMSelectedPosition(int i) {
        this.mSelectedPosition = i;
    }

    public final Function2<Integer, Channel, Unit> getMListener() {
        return this.mListener;
    }

    public final void setMListener(Function2<? super Integer, ? super Channel, Unit> function2) {
        this.mListener = function2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, ChannelDialogSection channelDialogSection) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(channelDialogSection, "item");
        if (channelDialogSection instanceof Channel) {
            TextView textView = (TextView) baseViewHolder.getView(R.id.channel_item_name);
            Channel channel = (Channel) channelDialogSection;
            textView.setText(channel.getName());
            Integer id = channel.getId();
            int i = this.mSelectedId;
            if (id != null && id.intValue() == i) {
                textView.setSelected(true);
                this.mSelectedPosition = baseViewHolder.getAdapterPosition();
                return;
            }
            textView.setSelected(false);
        }
    }

    /* access modifiers changed from: protected */
    public void convertHeader(BaseViewHolder baseViewHolder, ChannelDialogSection channelDialogSection) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(channelDialogSection, "item");
        if (channelDialogSection instanceof ChannelGroup) {
            baseViewHolder.setText(R.id.head_name, ((ChannelGroup) channelDialogSection).getName());
        }
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        if (baseViewHolder.getItemViewType() == -99) {
            TextView textView = (TextView) baseViewHolder.getView(R.id.head_name);
            if (i - getHeaderLayoutCount() == 0) {
                i2 = SizeUtils.dp2px(5.0f);
            } else {
                i2 = SizeUtils.dp2px(25.0f);
            }
            if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams).topMargin = i2;
            }
            convertHeader(baseViewHolder, (ChannelDialogSection) getItem(i - getHeaderLayoutCount()));
            return;
        }
        ChannelSelectDialogAdapter.super.onBindViewHolder(baseViewHolder, i);
    }
}
