package com.tal.app.thinkacademy.business.home.main.shop.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ChannelSelectDialogAdapter;
import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelDialogSection;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopChannelSelectDialogLayoutBinding;
import com.tal.app.thinkacademy.common.entity.ChannelSaveData;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0014J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020$J\u001e\u0010%\u001a\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\b\u0010)\u001a\u0004\u0018\u00010\u0007J\u0006\u0010*\u001a\u00020\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001b\"\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/view/ChannelSelectDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopChannelSelectDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "Lkotlin/ParameterName;", "name", "channel", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mAdapter", "Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ChannelSelectDialogAdapter;", "getMAdapter", "()Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ChannelSelectDialogAdapter;", "setMAdapter", "(Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ChannelSelectDialogAdapter;)V", "mListener", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mMaxHeight", "", "getMMaxHeight", "()I", "mMinHeight", "getMMinHeight", "setMMinHeight", "(I)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setChannelSelectTitle", "", "setData", "list", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelDialogSection;", "defaultChannel", "updateData", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelSelectDialog.kt */
public final class ChannelSelectDialog extends BaseBindDialog<ShopChannelSelectDialogLayoutBinding> {
    private ChannelSelectDialogAdapter mAdapter;
    private Function1<? super Channel, Unit> mListener;
    private final int mMaxHeight = SizeUtils.dp2px(383.0f);
    private int mMinHeight = SizeUtils.dp2px(242.0f);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelSelectDialog(Context context, Function1<? super Channel, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "listener");
        this.mListener = function1;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        gravity(80);
        animType(BaseDialog.AnimInType.BOTTOM);
        this.binding.recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        this.binding.recyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(5.0f, 5.0f, 0.0f, 0.0f));
        this.mAdapter = new ChannelSelectDialogAdapter(new Function2<Integer, Channel, Unit>(this) {
            final /* synthetic */ ChannelSelectDialog this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), (Channel) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, Channel channel) {
                Intrinsics.checkNotNullParameter(channel, "channel");
                ChannelSaveData channelSaveData = new ChannelSaveData((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                channelSaveData.setId(channel.getId());
                channelSaveData.setName(channel.getName());
                UserInfoBll.Companion.getInstance().putSelectedChannel(channelSaveData);
                Function1<Channel, Unit> mListener = this.this$0.getMListener();
                if (mListener != null) {
                    mListener.invoke(channel);
                }
                this.this$0.dismiss();
            }
        });
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.shop_select_dialog_item_foot;
        ViewGroup viewGroup = this.binding.recyclerView;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter != null) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            BaseQuickAdapter.addFooterView$default(baseQuickAdapter, inflate, 0, 0, 6, (Object) null);
        }
        this.binding.recyclerView.setAdapter(this.mAdapter);
        this.binding.btnClose.setOnClickListener(new ChannelSelectDialog$$ExternalSyntheticLambda0(this));
    }

    public final ChannelSelectDialogAdapter getMAdapter() {
        return this.mAdapter;
    }

    public final void setMAdapter(ChannelSelectDialogAdapter channelSelectDialogAdapter) {
        this.mAdapter = channelSelectDialogAdapter;
    }

    public final int getMMaxHeight() {
        return this.mMaxHeight;
    }

    public final int getMMinHeight() {
        return this.mMinHeight;
    }

    public final void setMMinHeight(int i) {
        this.mMinHeight = i;
    }

    public final Function1<Channel, Unit> getMListener() {
        return this.mListener;
    }

    public final void setMListener(Function1<? super Channel, Unit> function1) {
        this.mListener = function1;
    }

    /* access modifiers changed from: protected */
    public ShopChannelSelectDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopChannelSelectDialogLayoutBinding inflate = ShopChannelSelectDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m41_init_$lambda1(ChannelSelectDialog channelSelectDialog, View view) {
        Intrinsics.checkNotNullParameter(channelSelectDialog, "this$0");
        channelSelectDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setChannelSelectTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TextView textView = this.binding.channelDialogTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setData(List<ChannelDialogSection> list, Channel channel) {
        Integer id;
        Intrinsics.checkNotNullParameter(list, "list");
        ChannelSelectDialogAdapter channelSelectDialogAdapter = this.mAdapter;
        if (channelSelectDialogAdapter != null) {
            int i = -1;
            if (!(channel == null || (id = channel.getId()) == null)) {
                i = id.intValue();
            }
            channelSelectDialogAdapter.setMSelectedId(i);
        }
        ChannelSelectDialogAdapter channelSelectDialogAdapter2 = this.mAdapter;
        if (channelSelectDialogAdapter2 != null) {
            channelSelectDialogAdapter2.setList(list);
        }
    }

    public final void updateData() {
        ChannelSelectDialogAdapter channelSelectDialogAdapter = this.mAdapter;
        if (channelSelectDialogAdapter != null) {
            channelSelectDialogAdapter.notifyDataSetChanged();
        }
    }
}
