package com.tal.app.thinkacademy.business.home.main.shop.provider;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopHomeViewType;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopListener;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootFootNode;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootViewMoreNode;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006H\u0017J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/provider/RootFooterNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "shopListener", "Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;)V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "mShopListener", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "onChildClick", "view", "Landroid/view/View;", "position", "reportViewMoreClick", "isViewMore", "", "parentNode", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RootFooterNodeProvider.kt */
public final class RootFooterNodeProvider extends BaseNodeProvider {
    private ShopListener mShopListener;

    public RootFooterNodeProvider(ShopListener shopListener) {
        Intrinsics.checkNotNullParameter(shopListener, "shopListener");
        this.mShopListener = shopListener;
        addChildClickViewIds(new int[]{R.id.view_more_btn});
    }

    public int getItemViewType() {
        return ShopHomeViewType.ROOT_VIEW_FOOT.getValue();
    }

    public int getLayoutId() {
        return R.layout.shop_view_more_foot_layout;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        int i;
        Drawable drawable;
        List data;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, DbParams.KEY_DATA);
        if (baseNode instanceof ShopRootFootNode) {
            ShopRootFootNode shopRootFootNode = (ShopRootFootNode) baseNode;
            if (shopRootFootNode.isClassCard()) {
                i = SizeUtils.dp2px(10.0f);
            } else {
                i = SizeUtils.dp2px(20.0f);
            }
            try {
                View view = baseViewHolder.getView(R.id.view_more_btn);
                if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                }
            } catch (Exception unused) {
            }
            if (shopRootFootNode.getParentNode() != null && (shopRootFootNode.getParentNode() instanceof ShopRootViewMoreNode)) {
                ShopRootViewMoreNode parentNode = shopRootFootNode.getParentNode();
                Objects.requireNonNull(parentNode, "null cannot be cast to non-null type com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootViewMoreNode");
                ShopRootViewMoreNode shopRootViewMoreNode = parentNode;
                BaseNodeAdapter adapter = getAdapter();
                int i2 = -1;
                if (!(adapter == null || (data = adapter.getData()) == null)) {
                    i2 = data.indexOf(shopRootViewMoreNode);
                }
                if (i2 >= 0) {
                    View view2 = baseViewHolder.getView(R.id.view_more_btn);
                    if (!shopRootViewMoreNode.isExpanded()) {
                        TextView textView = (TextView) view2;
                        textView.setText(textView.getContext().getText(R.string.view_more));
                        textView.setTextColor(getContext().getColor(R.color.color_ffaa0a));
                        drawable = getContext().getDrawable(R.drawable.shop_view_more_icon);
                    } else {
                        TextView textView2 = (TextView) view2;
                        textView2.setText(textView2.getContext().getText(R.string.view_less));
                        textView2.setTextColor(getContext().getColor(R.color.color_a2aab8));
                        drawable = getContext().getDrawable(R.drawable.shop_view_less_icon);
                    }
                    if (drawable != null) {
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                        ((TextView) view2).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                    }
                }
            }
        }
    }

    private final void reportViewMoreClick(boolean z, BaseNode baseNode) {
        if (baseNode.getChildNode() != null) {
            List childNode = baseNode.getChildNode();
            int i = 0;
            if ((childNode == null ? 0 : childNode.size()) > 0) {
                List childNode2 = baseNode.getChildNode();
                BaseNode baseNode2 = childNode2 == null ? null : (BaseNode) childNode2.get(0);
                if (baseNode2 instanceof ShopHomeDataType1Course) {
                    if (z) {
                        ShopTrack shopTrack = ShopTrack.INSTANCE;
                        ShopListener shopListener = this.mShopListener;
                        if (shopListener != null) {
                            i = shopListener.getChannelId();
                        }
                        shopTrack.hw_shop_card_more_click(i, ShopTrack.ShopColumnType.COURSE_CARD);
                        return;
                    }
                    ShopTrack shopTrack2 = ShopTrack.INSTANCE;
                    ShopListener shopListener2 = this.mShopListener;
                    if (shopListener2 != null) {
                        i = shopListener2.getChannelId();
                    }
                    shopTrack2.hw_shop_card_fold_click(i, ShopTrack.ShopColumnType.COURSE_CARD);
                } else if (baseNode2 instanceof ShopHomeDataType12CourseConfig) {
                    if (z) {
                        ShopTrack shopTrack3 = ShopTrack.INSTANCE;
                        ShopListener shopListener3 = this.mShopListener;
                        if (shopListener3 != null) {
                            i = shopListener3.getChannelId();
                        }
                        shopTrack3.hw_shop_card_more_click(i, ShopTrack.ShopColumnType.COURSE_TOGETHER);
                        return;
                    }
                    ShopTrack shopTrack4 = ShopTrack.INSTANCE;
                    ShopListener shopListener4 = this.mShopListener;
                    if (shopListener4 != null) {
                        i = shopListener4.getChannelId();
                    }
                    shopTrack4.hw_shop_card_fold_click(i, ShopTrack.ShopColumnType.COURSE_TOGETHER);
                } else if (!(baseNode2 instanceof ShopClassGoodsData)) {
                } else {
                    if (z) {
                        ShopTrack shopTrack5 = ShopTrack.INSTANCE;
                        ShopListener shopListener5 = this.mShopListener;
                        if (shopListener5 != null) {
                            i = shopListener5.getChannelId();
                        }
                        shopTrack5.hw_shop_card_more_click(i, ShopTrack.ShopColumnType.CLASS_CARD);
                        return;
                    }
                    ShopTrack shopTrack6 = ShopTrack.INSTANCE;
                    ShopListener shopListener6 = this.mShopListener;
                    if (shopListener6 != null) {
                        i = shopListener6.getChannelId();
                    }
                    shopTrack6.hw_shop_card_fold_click(i, ShopTrack.ShopColumnType.CLASS_CARD);
                }
            }
        }
    }

    public void onChildClick(BaseViewHolder baseViewHolder, View view, BaseNode baseNode, int i) {
        List data;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(baseNode, DbParams.KEY_DATA);
        if (view.getId() == R.id.view_more_btn && !CommonUtilsKt.isFastClick() && (baseNode instanceof ShopRootFootNode)) {
            ShopRootFootNode shopRootFootNode = (ShopRootFootNode) baseNode;
            if (shopRootFootNode.getParentNode() != null && (shopRootFootNode.getParentNode() instanceof ShopRootViewMoreNode)) {
                BaseNode parentNode = shopRootFootNode.getParentNode();
                Objects.requireNonNull(parentNode, "null cannot be cast to non-null type com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootViewMoreNode");
                BaseNode baseNode2 = (ShopRootViewMoreNode) parentNode;
                BaseNodeAdapter adapter = getAdapter();
                int i2 = -1;
                if (!(adapter == null || (data = adapter.getData()) == null)) {
                    i2 = data.indexOf(baseNode2);
                }
                int i3 = i2;
                if (i3 >= 0) {
                    if (view instanceof TextView) {
                        if (baseNode2.isExpanded()) {
                            TextView textView = (TextView) view;
                            textView.setText(textView.getContext().getText(R.string.view_more));
                            textView.setTextColor(getContext().getColor(R.color.color_ffaa0a));
                            drawable = getContext().getDrawable(R.drawable.shop_view_more_icon);
                        } else {
                            TextView textView2 = (TextView) view;
                            textView2.setText(textView2.getContext().getText(R.string.view_less));
                            textView2.setTextColor(getContext().getColor(R.color.color_a2aab8));
                            drawable = getContext().getDrawable(R.drawable.shop_view_less_icon);
                        }
                        reportViewMoreClick(!baseNode2.isExpanded(), baseNode2);
                        if (drawable != null) {
                            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                            ((TextView) view).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                        }
                    }
                    BaseNodeAdapter adapter2 = getAdapter();
                    if (adapter2 != null) {
                        BaseNodeAdapter.expandOrCollapse$default(adapter2, i3, false, false, (Object) null, 14, (Object) null);
                    }
                }
            }
        }
    }
}
