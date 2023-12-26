package com.tal.app.thinkacademy.common.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.adapter.TreeBean;
import com.tal.app.thinkacademy.common.adapter.TreeChildBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00050\u0007:\u0001GB!\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\tH$J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u00022\u0006\u0010\u001b\u001a\u00020\tH\u0014¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u0010\u001f\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010 J+\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u0010\u001f\u001a\u00028\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0014¢\u0006\u0002\u0010$J-\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00028\u00022\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH$¢\u0006\u0002\u0010*J;\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00028\u00022\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0014¢\u0006\u0002\u0010+J%\u0010,\u001a\u00020\u00192\u0006\u0010&\u001a\u00028\u00022\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH$¢\u0006\u0002\u0010-J3\u0010,\u001a\u00020\u00192\u0006\u0010&\u001a\u00028\u00022\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0014¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0016¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00020\t¢\u0006\u0002\u00103J\u0015\u00104\u001a\u0004\u0018\u00018\u00002\u0006\u00102\u001a\u00020\t¢\u0006\u0002\u00103J\b\u00105\u001a\u0004\u0018\u00010\u0013J\u0017\u00106\u001a\u0004\u0018\u00018\u00002\u0006\u0010(\u001a\u00020\tH\u0016¢\u0006\u0002\u00103J\u0018\u00107\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00022\u0006\u00102\u001a\u00020\tH\u0016J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\tH\u0014J\u000e\u0010;\u001a\u0002092\u0006\u00102\u001a\u00020\tJ\u001d\u0010<\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u00102\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u001cJ+\u0010<\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u00102\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0016¢\u0006\u0002\u0010=J\u0019\u0010>\u001a\u00020\u00192\n\b\u0001\u0010?\u001a\u0004\u0018\u00010\tH\u0004¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u00020\u00192\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\u00192\b\u0010E\u001a\u0004\u0018\u00010\u0013J\u0019\u0010F\u001a\u00020\u00192\n\b\u0001\u0010?\u001a\u0004\u0018\u00010\tH\u0004¢\u0006\u0002\u0010@R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/tal/app/thinkacademy/common/adapter/BaseTreeAdapter;", "T", "Lcom/tal/app/thinkacademy/common/adapter/TreeBean;", "C", "Lcom/tal/app/thinkacademy/common/adapter/TreeChildBean;", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "parentResId", "", "treeBeanList", "", "(ILjava/util/List;)V", "mList", "getMList", "()Ljava/util/List;", "setMList", "(Ljava/util/List;)V", "mOnTreeItemClickListener", "Lcom/tal/app/thinkacademy/common/adapter/OnTreeItemClickListener;", "mRealList", "getMRealList", "setMRealList", "bindChildView", "bindViewClickListener", "", "viewHolder", "viewType", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "convert", "holder", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/tal/app/thinkacademy/common/adapter/TreeBean;)V", "payloads", "", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/tal/app/thinkacademy/common/adapter/TreeBean;Ljava/util/List;)V", "convertChild", "helper", "realPosition", "parentPosition", "childPosition", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;III)V", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;IIILjava/util/List;)V", "convertParent", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;II)V", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;IILjava/util/List;)V", "getChildItem", "(II)Lcom/tal/app/thinkacademy/common/adapter/TreeChildBean;", "getItem", "position", "(I)Lcom/tal/app/thinkacademy/common/adapter/TreeBean;", "getItemOrNull", "getOnTreeItemClickListener", "getParentItem", "getRealItem", "isFixedViewType", "", "type", "isParent", "onBindViewHolder", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "setChildLayout", "layoutResId", "(Ljava/lang/Integer;)V", "setList", "list", "", "setOnTreeItemClickListener", "listener", "setParentLayout", "SimpleListener", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseTreeAdapter.kt */
public abstract class BaseTreeAdapter<T extends TreeBean<C>, C extends TreeChildBean, VH extends BaseViewHolder> extends BaseMultiItemQuickAdapter<T, VH> {
    private List<T> mList;
    private OnTreeItemClickListener mOnTreeItemClickListener;
    private List<T> mRealList;
    private final int parentResId;
    private final List<T> treeBeanList;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J8\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J8\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J8\u0010\u0010\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J0\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u0014\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/adapter/BaseTreeAdapter$SimpleListener;", "Lcom/tal/app/thinkacademy/common/adapter/OnTreeItemClickListener;", "()V", "onChildItemClick", "", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "parentPosition", "childPosition", "onChildItemLongClick", "", "onChildViewClick", "onChildViewLongClick", "onParentItemClick", "onParentItemLongClick", "onParentViewClick", "onParentViewLongClick", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseTreeAdapter.kt */
    public static class SimpleListener implements OnTreeItemClickListener {
        public void onChildItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public boolean onChildItemLongClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            return false;
        }

        public void onChildViewClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public boolean onChildViewLongClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            return false;
        }

        public void onParentItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public boolean onParentItemLongClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            return false;
        }

        public void onParentViewClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public boolean onParentViewLongClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i, int i2) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract int bindChildView();

    /* access modifiers changed from: protected */
    public void convert(VH vh, T t) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        Intrinsics.checkNotNullParameter(t, "item");
    }

    /* access modifiers changed from: protected */
    public void convert(VH vh, T t, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        Intrinsics.checkNotNullParameter(t, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
    }

    /* access modifiers changed from: protected */
    public abstract void convertChild(VH vh, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public void convertChild(VH vh, int i, int i2, int i3, List<Object> list) {
        Intrinsics.checkNotNullParameter(vh, "helper");
        Intrinsics.checkNotNullParameter(list, "payloads");
    }

    /* access modifiers changed from: protected */
    public abstract void convertParent(VH vh, int i, int i2);

    /* access modifiers changed from: protected */
    public void convertParent(VH vh, int i, int i2, List<Object> list) {
        Intrinsics.checkNotNullParameter(vh, "helper");
        Intrinsics.checkNotNullParameter(list, "payloads");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseTreeAdapter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }

    public BaseTreeAdapter(int i, List<T> list) {
        super(list);
        this.parentResId = i;
        this.treeBeanList = list;
        this.mList = new ArrayList();
        this.mRealList = new ArrayList();
        setParentLayout(Integer.valueOf(i));
        setChildLayout(Integer.valueOf(bindChildView()));
        BaseTreeAdapter baseTreeAdapter = this;
        Collection collection = list;
        BaseTreeAdapter baseTreeAdapter2 = (collection == null || collection.isEmpty()) ^ true ? this : null;
        setMList(list);
        setList(getMList());
    }

    public final List<T> getMList() {
        return this.mList;
    }

    public final void setMList(List<T> list) {
        this.mList = list;
    }

    public final List<T> getMRealList() {
        return this.mRealList;
    }

    public final void setMRealList(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mRealList = list;
    }

    public void setList(Collection<? extends T> collection) {
        this.mList = TypeIntrinsics.asMutableList(collection);
        BaseTreeAdapter baseTreeAdapter = this;
        BaseTreeAdapter baseTreeAdapter2 = true ^ (collection == null || collection.isEmpty()) ? this : null;
        getMRealList().clear();
        if (collection != null) {
            int i = 0;
            for (Object next : collection) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TreeBean treeBean = (TreeBean) next;
                treeBean.setParentPosition(Integer.valueOf(i));
                treeBean.setChildPosition(-1);
                getMRealList().add(treeBean);
                List children = treeBean.getChildren();
                if (children != null) {
                    int i3 = 0;
                    for (Object next2 : children) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        TreeChildBean treeChildBean = (TreeChildBean) next2;
                        treeChildBean.setParentPosition(Integer.valueOf(i));
                        treeChildBean.setChildPosition(Integer.valueOf(i3));
                        getMRealList().add(treeChildBean);
                        i3 = i4;
                    }
                }
                i = i2;
            }
        }
        BaseTreeAdapter.super.setList(this.mRealList);
    }

    /* access modifiers changed from: protected */
    public final void setParentLayout(Integer num) {
        if (num != null) {
            addItemType(-100, num.intValue());
        }
    }

    /* access modifiers changed from: protected */
    public final void setChildLayout(Integer num) {
        if (num != null) {
            addItemType(-99, num.intValue());
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFixedViewType(int i) {
        return BaseTreeAdapter.super.isFixedViewType(i) || i == -100;
    }

    public void onBindViewHolder(VH vh, int i) {
        int i2;
        Integer childPosition;
        Integer parentPosition;
        Integer parentPosition2;
        Intrinsics.checkNotNullParameter(vh, "holder");
        TreeBean realItem = getRealItem(i);
        int i3 = 0;
        if (vh.getItemViewType() == -100) {
            int headerLayoutCount = i - getHeaderLayoutCount();
            if (!(realItem == null || (parentPosition2 = realItem.getParentPosition()) == null)) {
                i3 = parentPosition2.intValue();
            }
            convertParent(vh, headerLayoutCount, i3);
            return;
        }
        BaseTreeAdapter.super.onBindViewHolder(vh, i);
        switch (vh.getItemViewType()) {
            case 268435729:
            case 268436002:
            case 268436275:
            case 268436821:
                return;
            default:
                int headerLayoutCount2 = i - getHeaderLayoutCount();
                if (realItem == null || (parentPosition = realItem.getParentPosition()) == null) {
                    i2 = 0;
                } else {
                    i2 = parentPosition.intValue();
                }
                if (!(realItem == null || (childPosition = realItem.getChildPosition()) == null)) {
                    i3 = childPosition.intValue();
                }
                convertChild(vh, headerLayoutCount2, i2, i3);
                return;
        }
    }

    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        int i2;
        Integer childPosition;
        Integer parentPosition;
        Integer parentPosition2;
        Intrinsics.checkNotNullParameter(vh, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(vh, i);
            return;
        }
        TreeBean realItem = getRealItem(i);
        int i3 = 0;
        if (vh.getItemViewType() == -100) {
            int headerLayoutCount = i - getHeaderLayoutCount();
            if (!(realItem == null || (parentPosition2 = realItem.getParentPosition()) == null)) {
                i3 = parentPosition2.intValue();
            }
            convertParent(vh, headerLayoutCount, i3, list);
            return;
        }
        BaseTreeAdapter.super.onBindViewHolder(vh, i, list);
        switch (vh.getItemViewType()) {
            case 268435729:
            case 268436002:
            case 268436275:
            case 268436821:
                return;
            default:
                int headerLayoutCount2 = i - getHeaderLayoutCount();
                if (realItem == null || (parentPosition = realItem.getParentPosition()) == null) {
                    i2 = 0;
                } else {
                    i2 = parentPosition.intValue();
                }
                if (!(realItem == null || (childPosition = realItem.getChildPosition()) == null)) {
                    i3 = childPosition.intValue();
                }
                convertChild(vh, headerLayoutCount2, i2, i3, list);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewClickListener(VH vh, int i) {
        Intrinsics.checkNotNullParameter(vh, "viewHolder");
        BaseTreeAdapter.super.bindViewClickListener(vh, i);
        if (this.mOnTreeItemClickListener != null) {
            vh.itemView.setOnClickListener(new BaseTreeAdapter$$ExternalSyntheticLambda0(vh, this));
        }
        if (this.mOnTreeItemClickListener != null) {
            vh.itemView.setOnLongClickListener(new BaseTreeAdapter$$ExternalSyntheticLambda2(vh, this));
        }
        if (this.mOnTreeItemClickListener != null) {
            Iterator it = getChildClickViewIds().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                View view = vh.itemView;
                Intrinsics.checkNotNullExpressionValue(num, "id");
                View findViewById = view.findViewById(num.intValue());
                if (findViewById != null) {
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new BaseTreeAdapter$$ExternalSyntheticLambda1(vh, this));
                }
            }
        }
        if (this.mOnTreeItemClickListener != null) {
            Iterator it2 = getChildLongClickViewIds().iterator();
            while (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                View view2 = vh.itemView;
                Intrinsics.checkNotNullExpressionValue(num2, "id");
                View findViewById2 = view2.findViewById(num2.intValue());
                if (findViewById2 != null) {
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new BaseTreeAdapter$$ExternalSyntheticLambda3(vh, this));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindViewClickListener$lambda-9$lambda-8  reason: not valid java name */
    public static final void m3bindViewClickListener$lambda9$lambda8(BaseViewHolder baseViewHolder, BaseTreeAdapter baseTreeAdapter, View view) {
        int i;
        Integer childPosition;
        Integer parentPosition;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseTreeAdapter, "this$0");
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int i2 = -1;
        if (adapterPosition == -1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int headerLayoutCount = adapterPosition - baseTreeAdapter.getHeaderLayoutCount();
        TreeBean realItem = baseTreeAdapter.getRealItem(headerLayoutCount);
        boolean z = false;
        if (realItem != null && realItem.isParent()) {
            z = true;
        }
        if (z) {
            OnTreeItemClickListener onTreeItemClickListener = baseTreeAdapter.mOnTreeItemClickListener;
            if (onTreeItemClickListener != null) {
                BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter) baseTreeAdapter;
                Intrinsics.checkNotNullExpressionValue(view, "v");
                Integer parentPosition2 = realItem.getParentPosition();
                if (parentPosition2 != null) {
                    i2 = parentPosition2.intValue();
                }
                onTreeItemClickListener.onParentItemClick(baseQuickAdapter, view, headerLayoutCount, i2);
            }
        } else {
            OnTreeItemClickListener onTreeItemClickListener2 = baseTreeAdapter.mOnTreeItemClickListener;
            if (onTreeItemClickListener2 != null) {
                BaseQuickAdapter baseQuickAdapter2 = (BaseQuickAdapter) baseTreeAdapter;
                Intrinsics.checkNotNullExpressionValue(view, "v");
                if (realItem == null || (parentPosition = realItem.getParentPosition()) == null) {
                    i = -1;
                } else {
                    i = parentPosition.intValue();
                }
                if (!(realItem == null || (childPosition = realItem.getChildPosition()) == null)) {
                    i2 = childPosition.intValue();
                }
                onTreeItemClickListener2.onChildItemClick(baseQuickAdapter2, view, headerLayoutCount, i, i2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindViewClickListener$lambda-11$lambda-10  reason: not valid java name */
    public static final boolean m0bindViewClickListener$lambda11$lambda10(BaseViewHolder baseViewHolder, BaseTreeAdapter baseTreeAdapter, View view) {
        int i;
        Integer childPosition;
        Integer parentPosition;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseTreeAdapter, "this$0");
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int i2 = -1;
        if (adapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = adapterPosition - baseTreeAdapter.getHeaderLayoutCount();
        TreeBean realItem = baseTreeAdapter.getRealItem(headerLayoutCount);
        boolean z = true;
        if (realItem == null || !realItem.isParent()) {
            z = false;
        }
        if (z) {
            OnTreeItemClickListener onTreeItemClickListener = baseTreeAdapter.mOnTreeItemClickListener;
            if (onTreeItemClickListener == null) {
                return false;
            }
            BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter) baseTreeAdapter;
            Intrinsics.checkNotNullExpressionValue(view, "v");
            Integer parentPosition2 = realItem.getParentPosition();
            if (parentPosition2 != null) {
                i2 = parentPosition2.intValue();
            }
            return onTreeItemClickListener.onParentItemLongClick(baseQuickAdapter, view, headerLayoutCount, i2);
        }
        OnTreeItemClickListener onTreeItemClickListener2 = baseTreeAdapter.mOnTreeItemClickListener;
        if (onTreeItemClickListener2 == null) {
            return false;
        }
        BaseQuickAdapter baseQuickAdapter2 = (BaseQuickAdapter) baseTreeAdapter;
        Intrinsics.checkNotNullExpressionValue(view, "v");
        if (realItem == null || (parentPosition = realItem.getParentPosition()) == null) {
            i = -1;
        } else {
            i = parentPosition.intValue();
        }
        if (!(realItem == null || (childPosition = realItem.getChildPosition()) == null)) {
            i2 = childPosition.intValue();
        }
        return onTreeItemClickListener2.onChildItemLongClick(baseQuickAdapter2, view, headerLayoutCount, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindViewClickListener$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m1bindViewClickListener$lambda14$lambda13$lambda12(BaseViewHolder baseViewHolder, BaseTreeAdapter baseTreeAdapter, View view) {
        int i;
        Integer childPosition;
        Integer parentPosition;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseTreeAdapter, "this$0");
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int i2 = -1;
        if (adapterPosition == -1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int headerLayoutCount = adapterPosition - baseTreeAdapter.getHeaderLayoutCount();
        TreeBean realItem = baseTreeAdapter.getRealItem(headerLayoutCount);
        boolean z = false;
        if (realItem != null && realItem.isParent()) {
            z = true;
        }
        if (z) {
            OnTreeItemClickListener onTreeItemClickListener = baseTreeAdapter.mOnTreeItemClickListener;
            if (onTreeItemClickListener != null) {
                BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter) baseTreeAdapter;
                Intrinsics.checkNotNullExpressionValue(view, "v");
                Integer parentPosition2 = realItem.getParentPosition();
                if (parentPosition2 != null) {
                    i2 = parentPosition2.intValue();
                }
                onTreeItemClickListener.onParentViewClick(baseQuickAdapter, view, headerLayoutCount, i2);
            }
        } else {
            OnTreeItemClickListener onTreeItemClickListener2 = baseTreeAdapter.mOnTreeItemClickListener;
            if (onTreeItemClickListener2 != null) {
                BaseQuickAdapter baseQuickAdapter2 = (BaseQuickAdapter) baseTreeAdapter;
                Intrinsics.checkNotNullExpressionValue(view, "v");
                if (realItem == null || (parentPosition = realItem.getParentPosition()) == null) {
                    i = -1;
                } else {
                    i = parentPosition.intValue();
                }
                if (!(realItem == null || (childPosition = realItem.getChildPosition()) == null)) {
                    i2 = childPosition.intValue();
                }
                onTreeItemClickListener2.onChildViewClick(baseQuickAdapter2, view, headerLayoutCount, i, i2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindViewClickListener$lambda-17$lambda-16$lambda-15  reason: not valid java name */
    public static final boolean m2bindViewClickListener$lambda17$lambda16$lambda15(BaseViewHolder baseViewHolder, BaseTreeAdapter baseTreeAdapter, View view) {
        int i;
        Integer childPosition;
        Integer parentPosition;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseTreeAdapter, "this$0");
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int i2 = -1;
        if (adapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = adapterPosition - baseTreeAdapter.getHeaderLayoutCount();
        TreeBean realItem = baseTreeAdapter.getRealItem(headerLayoutCount);
        boolean z = true;
        if (realItem == null || !realItem.isParent()) {
            z = false;
        }
        if (z) {
            OnTreeItemClickListener onTreeItemClickListener = baseTreeAdapter.mOnTreeItemClickListener;
            if (onTreeItemClickListener == null) {
                return false;
            }
            BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter) baseTreeAdapter;
            Intrinsics.checkNotNullExpressionValue(view, "v");
            Integer parentPosition2 = realItem.getParentPosition();
            if (parentPosition2 != null) {
                i2 = parentPosition2.intValue();
            }
            return onTreeItemClickListener.onParentViewLongClick(baseQuickAdapter, view, headerLayoutCount, i2);
        }
        OnTreeItemClickListener onTreeItemClickListener2 = baseTreeAdapter.mOnTreeItemClickListener;
        if (onTreeItemClickListener2 == null) {
            return false;
        }
        BaseQuickAdapter baseQuickAdapter2 = (BaseQuickAdapter) baseTreeAdapter;
        Intrinsics.checkNotNullExpressionValue(view, "v");
        if (realItem == null || (parentPosition = realItem.getParentPosition()) == null) {
            i = -1;
        } else {
            i = parentPosition.intValue();
        }
        if (!(realItem == null || (childPosition = realItem.getChildPosition()) == null)) {
            i2 = childPosition.intValue();
        }
        return onTreeItemClickListener2.onChildViewLongClick(baseQuickAdapter2, view, headerLayoutCount, i, i2);
    }

    public T getParentItem(int i) {
        try {
            BaseTreeAdapter baseTreeAdapter = this;
            List mList2 = getMList();
            if ((mList2 == null ? false : mList2.isEmpty() ^ true ? this : null) == null) {
                return null;
            }
            List mList3 = getMList();
            if (mList3 == null) {
                return null;
            }
            return (TreeBean) mList3.get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public C getChildItem(int i, int i2) {
        try {
            BaseTreeAdapter baseTreeAdapter = this;
            List mList2 = getMList();
            if ((mList2 == null ? false : mList2.isEmpty() ^ true ? this : null) == null) {
                return null;
            }
            List mList3 = getMList();
            if (mList3 == null) {
                return null;
            }
            TreeBean treeBean = (TreeBean) mList3.get(i);
            if (treeBean == null) {
                return null;
            }
            List children = treeBean.getChildren();
            if (children == null) {
                return null;
            }
            return (TreeChildBean) children.get(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    public TreeBean<C> getRealItem(int i) {
        try {
            BaseTreeAdapter baseTreeAdapter = this;
            if ((getMRealList().isEmpty() ^ true ? this : null) == null) {
                return null;
            }
            return (TreeBean) getMRealList().get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public final T getItem(int i) {
        return (TreeBean) BaseTreeAdapter.super.getItem(i);
    }

    public final T getItemOrNull(int i) {
        return (TreeBean) BaseTreeAdapter.super.getItemOrNull(i);
    }

    public final boolean isParent(int i) {
        TreeBean realItem = getRealItem(i);
        if (realItem == null) {
            return false;
        }
        return realItem.isParent();
    }

    public final void setOnTreeItemClickListener(OnTreeItemClickListener onTreeItemClickListener) {
        this.mOnTreeItemClickListener = onTreeItemClickListener;
    }

    public final OnTreeItemClickListener getOnTreeItemClickListener() {
        return this.mOnTreeItemClickListener;
    }
}
