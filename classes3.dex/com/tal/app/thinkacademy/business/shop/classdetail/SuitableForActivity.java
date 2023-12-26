package com.tal.app.thinkacademy.business.shop.classdetail;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlacement;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData;
import com.tal.app.thinkacademy.business.shop.databinding.ActivitySuitableForLayoutBinding;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/SuitableForActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ActivitySuitableForLayoutBinding;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/classdetail/SuitableForAdapter;", "mFootView", "Landroid/widget/TextView;", "mOperation", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;", "addFootView", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "initData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuitableForActivity.kt */
public final class SuitableForActivity extends BaseVmActivity<BaseViewModel, ActivitySuitableForLayoutBinding> {
    private final SuitableForAdapter mAdapter = new SuitableForAdapter();
    private TextView mFootView;
    private ShopClassDetailOperation mOperation;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SuitableForActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        getBinding().titleView.setOnTitleBarListener(new SuitableForActivity$onCreate$1(this));
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager((Context) this, 1, false));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        addFootView();
        initData();
        this.mAdapter.setOnItemClickListener(new SuitableForActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m260onCreate$lambda1(SuitableForActivity suitableForActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ShopClassDetailOperation shopClassDetailOperation;
        ShopClassDetailStaticData staticData;
        ShopClassDetailPortrait portrait;
        ShopClassDetailPlacement placement;
        String link;
        Intrinsics.checkNotNullParameter(suitableForActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj instanceof ShopClassDetailItemCommon) {
            int itemType = ((ShopClassDetailItemCommon) obj).getItemType();
            if ((itemType == 2 || itemType == 3) && (shopClassDetailOperation = suitableForActivity.mOperation) != null && (staticData = shopClassDetailOperation.getStaticData()) != null && (portrait = staticData.getPortrait()) != null && (placement = portrait.getPlacement()) != null && (link = placement.getLink()) != null) {
                if (link.length() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("jump_key", link);
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle(" ").setShowTitle(false).build());
                    XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                }
            }
        }
    }

    private final void initData() {
        ShopClassDetailStaticData staticData;
        ShopClassDetailPortrait portrait;
        ShopClassDetailOperation mDetailOperation = ShopClassDetailDataManager.Companion.getInstance().getMDetailOperation();
        this.mOperation = mDetailOperation;
        if (mDetailOperation != null && (staticData = mDetailOperation.getStaticData()) != null && (portrait = staticData.getPortrait()) != null) {
            List arrayList = new ArrayList();
            List<String> describes = portrait.getDescribes();
            if (describes != null) {
                describes.size();
            }
            List<String> describes2 = portrait.getDescribes();
            int i = 0;
            if (describes2 != null) {
                int i2 = 0;
                for (Object next : describes2) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) next;
                    if (i2 == 0) {
                        arrayList.add(new ShopClassDetailItemCommon(1, str, ShopPositionType.First.getType()));
                    }
                    i2 = i3;
                }
            }
            ShopClassDetailPlacement placement = portrait.getPlacement();
            if (placement != null) {
                arrayList.add(new ShopClassDetailItemCommon(2, placement, 0, 4, (DefaultConstructorMarker) null));
            }
            List<String> illustrations = portrait.getIllustrations();
            int size = illustrations == null ? 0 : illustrations.size();
            List<String> illustrations2 = portrait.getIllustrations();
            if (illustrations2 != null) {
                for (Object next2 : illustrations2) {
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ShopClassDetailItemCommon shopClassDetailItemCommon = new ShopClassDetailItemCommon(3, (String) next2, ShopPositionType.First.getType());
                    if (size != 1) {
                        if (i == 0) {
                            shopClassDetailItemCommon.setLocal_position_type(ShopPositionType.First.getType());
                        }
                        if (i == size - 1) {
                            shopClassDetailItemCommon.setLocal_position_type(ShopPositionType.Last.getType());
                        }
                    } else if (i == 0) {
                        shopClassDetailItemCommon.setLocal_position_type(ShopPositionType.ONLY_ONE.getType());
                    }
                    arrayList.add(shopClassDetailItemCommon);
                    i = i4;
                }
            }
            this.mAdapter.setList(arrayList);
        }
    }

    private final void addFootView() {
        if (this.mFootView == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, SizeUtils.dp2px(40.0f));
            TextView textView = new TextView((Context) this);
            this.mFootView = textView;
            textView.setLayoutParams(layoutParams);
        }
        TextView textView2 = this.mFootView;
        if (textView2 != null && textView2.getParent() == null) {
            BaseQuickAdapter.addFooterView$default(this.mAdapter, textView2, 0, 0, 6, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public ActivitySuitableForLayoutBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivitySuitableForLayoutBinding inflate = ActivitySuitableForLayoutBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
