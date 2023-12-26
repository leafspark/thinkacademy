package com.chad.library.adapter.base;

import androidx.recyclerview.widget.DiffUtil;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J2\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J2\u0010\u001e\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J2\u0010!\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007JR\u0010\"\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010'\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u000e\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0002J\u0010\u0010(\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bJ-\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\bH\u0014J\u0016\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u001e\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002J$\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0016\u00103\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0002J\u0016\u00103\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\bJ\u001c\u00105\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u001e\u00106\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u00109\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0018\u0010<\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0018\u0010?\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016J\u0018\u0010@\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "nodeList", "", "(Ljava/util/List;)V", "fullSpanNodeTypeSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "addData", "", "data", "position", "newData", "", "addFooterNodeProvider", "provider", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "addFullSpanNodeProvider", "addItemProvider", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "addNodeProvider", "collapse", "animate", "", "notify", "parentPayload", "", "isChangeChildCollapse", "collapseAndChild", "expand", "isChangeChildExpand", "expandAndChild", "expandAndCollapseOther", "isExpandedChild", "isCollapseChild", "expandPayload", "collapsePayload", "expandOrCollapse", "findParentNode", "node", "flatData", "list", "isExpanded", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "isFixedViewType", "type", "nodeAddData", "parentNode", "childIndex", "nodeRemoveData", "childNode", "nodeReplaceChildData", "nodeSetData", "removeAt", "removeChildAt", "removeNodesAt", "setData", "index", "setDiffNewData", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "setList", "setNewInstance", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseNodeAdapter.kt */
public abstract class BaseNodeAdapter extends BaseProviderMultiAdapter<BaseNode> {
    private final HashSet<Integer> fullSpanNodeTypeSet;

    public BaseNodeAdapter() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public final int collapse(int i) {
        return collapse$default(this, i, false, false, (Object) null, 14, (Object) null);
    }

    public final int collapse(int i, boolean z) {
        return collapse$default(this, i, z, false, (Object) null, 12, (Object) null);
    }

    public final int collapse(int i, boolean z, boolean z2) {
        return collapse$default(this, i, z, z2, (Object) null, 8, (Object) null);
    }

    public final int collapseAndChild(int i) {
        return collapseAndChild$default(this, i, false, false, (Object) null, 14, (Object) null);
    }

    public final int collapseAndChild(int i, boolean z) {
        return collapseAndChild$default(this, i, z, false, (Object) null, 12, (Object) null);
    }

    public final int collapseAndChild(int i, boolean z, boolean z2) {
        return collapseAndChild$default(this, i, z, z2, (Object) null, 8, (Object) null);
    }

    public final int expand(int i) {
        return expand$default(this, i, false, false, (Object) null, 14, (Object) null);
    }

    public final int expand(int i, boolean z) {
        return expand$default(this, i, z, false, (Object) null, 12, (Object) null);
    }

    public final int expand(int i, boolean z, boolean z2) {
        return expand$default(this, i, z, z2, (Object) null, 8, (Object) null);
    }

    public final int expandAndChild(int i) {
        return expandAndChild$default(this, i, false, false, (Object) null, 14, (Object) null);
    }

    public final int expandAndChild(int i, boolean z) {
        return expandAndChild$default(this, i, z, false, (Object) null, 12, (Object) null);
    }

    public final int expandAndChild(int i, boolean z, boolean z2) {
        return expandAndChild$default(this, i, z, z2, (Object) null, 8, (Object) null);
    }

    public final void expandAndCollapseOther(int i) {
        expandAndCollapseOther$default(this, i, false, false, false, false, (Object) null, (Object) null, 126, (Object) null);
    }

    public final void expandAndCollapseOther(int i, boolean z) {
        expandAndCollapseOther$default(this, i, z, false, false, false, (Object) null, (Object) null, 124, (Object) null);
    }

    public final void expandAndCollapseOther(int i, boolean z, boolean z2) {
        expandAndCollapseOther$default(this, i, z, z2, false, false, (Object) null, (Object) null, 120, (Object) null);
    }

    public final void expandAndCollapseOther(int i, boolean z, boolean z2, boolean z3) {
        expandAndCollapseOther$default(this, i, z, z2, z3, false, (Object) null, (Object) null, 112, (Object) null);
    }

    public final void expandAndCollapseOther(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        expandAndCollapseOther$default(this, i, z, z2, z3, z4, (Object) null, (Object) null, 96, (Object) null);
    }

    public final void expandAndCollapseOther(int i, boolean z, boolean z2, boolean z3, boolean z4, Object obj) {
        expandAndCollapseOther$default(this, i, z, z2, z3, z4, obj, (Object) null, 64, (Object) null);
    }

    public final int expandOrCollapse(int i) {
        return expandOrCollapse$default(this, i, false, false, (Object) null, 14, (Object) null);
    }

    public final int expandOrCollapse(int i, boolean z) {
        return expandOrCollapse$default(this, i, z, false, (Object) null, 12, (Object) null);
    }

    public final int expandOrCollapse(int i, boolean z, boolean z2) {
        return expandOrCollapse$default(this, i, z, z2, (Object) null, 8, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseNodeAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public BaseNodeAdapter(List<BaseNode> list) {
        super((List) null);
        this.fullSpanNodeTypeSet = new HashSet<>();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            getData().addAll(flatData$default(this, collection, (Boolean) null, 2, (Object) null));
        }
    }

    public final void addNodeProvider(BaseNodeProvider baseNodeProvider) {
        Intrinsics.checkParameterIsNotNull(baseNodeProvider, "provider");
        addItemProvider(baseNodeProvider);
    }

    public final void addFullSpanNodeProvider(BaseNodeProvider baseNodeProvider) {
        Intrinsics.checkParameterIsNotNull(baseNodeProvider, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(baseNodeProvider.getItemViewType()));
        addItemProvider(baseNodeProvider);
    }

    public final void addFooterNodeProvider(BaseNodeProvider baseNodeProvider) {
        Intrinsics.checkParameterIsNotNull(baseNodeProvider, "provider");
        addFullSpanNodeProvider(baseNodeProvider);
    }

    public void addItemProvider(BaseItemProvider<BaseNode> baseItemProvider) {
        Intrinsics.checkParameterIsNotNull(baseItemProvider, "provider");
        if (baseItemProvider instanceof BaseNodeProvider) {
            super.addItemProvider(baseItemProvider);
            return;
        }
        throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
    }

    /* access modifiers changed from: protected */
    public boolean isFixedViewType(int i) {
        return super.isFixedViewType(i) || this.fullSpanNodeTypeSet.contains(Integer.valueOf(i));
    }

    public void setNewInstance(List<BaseNode> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        super.setNewInstance(flatData$default(this, list, (Boolean) null, 2, (Object) null));
    }

    public void setList(Collection<? extends BaseNode> collection) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        super.setList(flatData$default(this, collection, (Boolean) null, 2, (Object) null));
    }

    public void addData(int i, BaseNode baseNode) {
        Intrinsics.checkParameterIsNotNull(baseNode, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        addData(i, (Collection<? extends BaseNode>) CollectionsKt.arrayListOf(new BaseNode[]{baseNode}));
    }

    public void addData(BaseNode baseNode) {
        Intrinsics.checkParameterIsNotNull(baseNode, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        addData((Collection<? extends BaseNode>) CollectionsKt.arrayListOf(new BaseNode[]{baseNode}));
    }

    public void addData(int i, Collection<? extends BaseNode> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "newData");
        super.addData(i, flatData$default(this, collection, (Boolean) null, 2, (Object) null));
    }

    public void addData(Collection<? extends BaseNode> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "newData");
        super.addData(flatData$default(this, collection, (Boolean) null, 2, (Object) null));
    }

    public void removeAt(int i) {
        notifyItemRangeRemoved(i + getHeaderLayoutCount(), removeNodesAt(i));
        compatibilityDataSizeChanged(0);
    }

    public void setData(int i, BaseNode baseNode) {
        Intrinsics.checkParameterIsNotNull(baseNode, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        int removeNodesAt = removeNodesAt(i);
        List flatData$default = flatData$default(this, CollectionsKt.arrayListOf(new BaseNode[]{baseNode}), (Boolean) null, 2, (Object) null);
        getData().addAll(i, flatData$default);
        if (removeNodesAt == flatData$default.size()) {
            notifyItemRangeChanged(i + getHeaderLayoutCount(), removeNodesAt);
            return;
        }
        notifyItemRangeRemoved(getHeaderLayoutCount() + i, removeNodesAt);
        notifyItemRangeInserted(i + getHeaderLayoutCount(), flatData$default.size());
    }

    public void setDiffNewData(List<BaseNode> list) {
        if (hasEmptyView()) {
            setNewInstance(list);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        super.setDiffNewData(flatData$default(this, list, (Boolean) null, 2, (Object) null));
    }

    public void setDiffNewData(DiffUtil.DiffResult diffResult, List<BaseNode> list) {
        Intrinsics.checkParameterIsNotNull(diffResult, "diffResult");
        Intrinsics.checkParameterIsNotNull(list, "list");
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            super.setDiffNewData(diffResult, flatData$default(this, list, (Boolean) null, 2, (Object) null));
        }
    }

    private final int removeNodesAt(int i) {
        if (i >= getData().size()) {
            return 0;
        }
        int removeChildAt = removeChildAt(i);
        getData().remove(i);
        int i2 = removeChildAt + 1;
        BaseNode baseNode = (BaseNode) getData().get(i);
        if (!(baseNode instanceof NodeFooterImp) || ((NodeFooterImp) baseNode).getFooterNode() == null) {
            return i2;
        }
        getData().remove(i);
        return i2 + 1;
    }

    private final int removeChildAt(int i) {
        if (i >= getData().size()) {
            return 0;
        }
        BaseNode baseNode = (BaseNode) getData().get(i);
        Collection childNode = baseNode.getChildNode();
        if (childNode == null || childNode.isEmpty()) {
            return 0;
        }
        if (!(baseNode instanceof BaseExpandNode)) {
            List<BaseNode> childNode2 = baseNode.getChildNode();
            if (childNode2 == null) {
                Intrinsics.throwNpe();
            }
            List flatData$default = flatData$default(this, childNode2, (Boolean) null, 2, (Object) null);
            getData().removeAll(flatData$default);
            return flatData$default.size();
        } else if (!((BaseExpandNode) baseNode).isExpanded()) {
            return 0;
        } else {
            List<BaseNode> childNode3 = baseNode.getChildNode();
            if (childNode3 == null) {
                Intrinsics.throwNpe();
            }
            List flatData$default2 = flatData$default(this, childNode3, (Boolean) null, 2, (Object) null);
            getData().removeAll(flatData$default2);
            return flatData$default2.size();
        }
    }

    public final void nodeAddData(BaseNode baseNode, BaseNode baseNode2) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(baseNode2, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode != null) {
            childNode.add(baseNode2);
            if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
                addData(getData().indexOf(baseNode) + childNode.size(), baseNode2);
            }
        }
    }

    public final void nodeAddData(BaseNode baseNode, int i, BaseNode baseNode2) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(baseNode2, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode != null) {
            childNode.add(i, baseNode2);
            if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
                addData(getData().indexOf(baseNode) + 1 + i, baseNode2);
            }
        }
    }

    public final void nodeAddData(BaseNode baseNode, int i, Collection<? extends BaseNode> collection) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(collection, "newData");
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode != null) {
            childNode.addAll(i, collection);
            if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
                addData(getData().indexOf(baseNode) + 1 + i, collection);
            }
        }
    }

    public final void nodeRemoveData(BaseNode baseNode, int i) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode != null && i < childNode.size()) {
            if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
                remove(getData().indexOf(baseNode) + 1 + i);
                BaseNode remove = childNode.remove(i);
                return;
            }
            childNode.remove(i);
        }
    }

    public final void nodeRemoveData(BaseNode baseNode, BaseNode baseNode2) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(baseNode2, "childNode");
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode == null) {
            return;
        }
        if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
            remove(baseNode2);
            childNode.remove(baseNode2);
            return;
        }
        childNode.remove(baseNode2);
    }

    public final void nodeSetData(BaseNode baseNode, int i, BaseNode baseNode2) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(baseNode2, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode != null && i < childNode.size()) {
            if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
                setData(getData().indexOf(baseNode) + 1 + i, baseNode2);
                childNode.set(i, baseNode2);
                return;
            }
            childNode.set(i, baseNode2);
        }
    }

    public final void nodeReplaceChildData(BaseNode baseNode, Collection<? extends BaseNode> collection) {
        Intrinsics.checkParameterIsNotNull(baseNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(collection, "newData");
        List<BaseNode> childNode = baseNode.getChildNode();
        if (childNode == null) {
            return;
        }
        if (!(baseNode instanceof BaseExpandNode) || ((BaseExpandNode) baseNode).isExpanded()) {
            int indexOf = getData().indexOf(baseNode);
            int removeChildAt = removeChildAt(indexOf);
            childNode.clear();
            childNode.addAll(collection);
            List flatData$default = flatData$default(this, collection, (Boolean) null, 2, (Object) null);
            int i = indexOf + 1;
            getData().addAll(i, flatData$default);
            int headerLayoutCount = i + getHeaderLayoutCount();
            if (removeChildAt == flatData$default.size()) {
                notifyItemRangeChanged(headerLayoutCount, removeChildAt);
                return;
            }
            notifyItemRangeRemoved(headerLayoutCount, removeChildAt);
            notifyItemRangeInserted(headerLayoutCount, flatData$default.size());
            return;
        }
        childNode.clear();
        childNode.addAll(collection);
    }

    static /* synthetic */ List flatData$default(BaseNodeAdapter baseNodeAdapter, Collection collection, Boolean bool, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bool = null;
            }
            return baseNodeAdapter.flatData(collection, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
    }

    private final List<BaseNode> flatData(Collection<? extends BaseNode> collection, Boolean bool) {
        BaseNode footerNode;
        ArrayList arrayList = new ArrayList();
        for (BaseNode baseNode : collection) {
            arrayList.add(baseNode);
            boolean z = false;
            if (baseNode instanceof BaseExpandNode) {
                if (Intrinsics.areEqual(bool, true) || ((BaseExpandNode) baseNode).isExpanded()) {
                    Collection childNode = baseNode.getChildNode();
                    if (childNode == null || childNode.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        arrayList.addAll(flatData(childNode, bool));
                    }
                }
                if (bool != null) {
                    ((BaseExpandNode) baseNode).setExpanded(bool.booleanValue());
                }
            } else {
                Collection childNode2 = baseNode.getChildNode();
                if (childNode2 == null || childNode2.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    arrayList.addAll(flatData(childNode2, bool));
                }
            }
            if ((baseNode instanceof NodeFooterImp) && (footerNode = ((NodeFooterImp) baseNode).getFooterNode()) != null) {
                arrayList.add(footerNode);
            }
        }
        return arrayList;
    }

    static /* synthetic */ int collapse$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, boolean z3, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            boolean z4 = z;
            boolean z5 = (i2 & 4) != 0 ? true : z2;
            boolean z6 = (i2 & 8) != 0 ? true : z3;
            if ((i2 & 16) != 0) {
                obj = null;
            }
            return baseNodeAdapter.collapse(i, z4, z5, z6, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
    }

    private final int collapse(int i, boolean z, boolean z2, boolean z3, Object obj) {
        BaseNode baseNode = (BaseNode) getData().get(i);
        if (baseNode instanceof BaseExpandNode) {
            BaseExpandNode baseExpandNode = (BaseExpandNode) baseNode;
            if (baseExpandNode.isExpanded()) {
                int headerLayoutCount = i + getHeaderLayoutCount();
                baseExpandNode.setExpanded(false);
                Collection childNode = baseNode.getChildNode();
                if (childNode == null || childNode.isEmpty()) {
                    notifyItemChanged(headerLayoutCount, obj);
                    return 0;
                }
                List<BaseNode> childNode2 = baseNode.getChildNode();
                if (childNode2 == null) {
                    Intrinsics.throwNpe();
                }
                List<BaseNode> flatData = flatData(childNode2, z ? false : null);
                int size = flatData.size();
                getData().removeAll(flatData);
                if (z3) {
                    if (z2) {
                        notifyItemChanged(headerLayoutCount, obj);
                        notifyItemRangeRemoved(headerLayoutCount + 1, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    static /* synthetic */ int expand$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, boolean z3, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            boolean z4 = z;
            boolean z5 = (i2 & 4) != 0 ? true : z2;
            boolean z6 = (i2 & 8) != 0 ? true : z3;
            if ((i2 & 16) != 0) {
                obj = null;
            }
            return baseNodeAdapter.expand(i, z4, z5, z6, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    private final int expand(int i, boolean z, boolean z2, boolean z3, Object obj) {
        BaseNode baseNode = (BaseNode) getData().get(i);
        if (baseNode instanceof BaseExpandNode) {
            BaseExpandNode baseExpandNode = (BaseExpandNode) baseNode;
            if (!baseExpandNode.isExpanded()) {
                int headerLayoutCount = getHeaderLayoutCount() + i;
                baseExpandNode.setExpanded(true);
                Collection childNode = baseNode.getChildNode();
                if (childNode == null || childNode.isEmpty()) {
                    notifyItemChanged(headerLayoutCount, obj);
                    return 0;
                }
                List<BaseNode> childNode2 = baseNode.getChildNode();
                if (childNode2 == null) {
                    Intrinsics.throwNpe();
                }
                List<BaseNode> flatData = flatData(childNode2, z ? true : null);
                int size = flatData.size();
                getData().addAll(i + 1, flatData);
                if (z3) {
                    if (z2) {
                        notifyItemChanged(headerLayoutCount, obj);
                        notifyItemRangeInserted(headerLayoutCount + 1, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    public static /* synthetic */ int collapse$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                z2 = true;
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.collapse(i, z, z2, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
    }

    public final int collapse(int i, boolean z, boolean z2, Object obj) {
        return collapse(i, false, z, z2, obj);
    }

    public static /* synthetic */ int expand$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                z2 = true;
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.expand(i, z, z2, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    public final int expand(int i, boolean z, boolean z2, Object obj) {
        return expand(i, false, z, z2, obj);
    }

    public static /* synthetic */ int expandOrCollapse$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                z2 = true;
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.expandOrCollapse(i, z, z2, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
    }

    public final int expandOrCollapse(int i, boolean z, boolean z2, Object obj) {
        BaseNode baseNode = (BaseNode) getData().get(i);
        if (!(baseNode instanceof BaseExpandNode)) {
            return 0;
        }
        if (((BaseExpandNode) baseNode).isExpanded()) {
            return collapse(i, false, z, z2, obj);
        }
        return expand(i, false, z, z2, obj);
    }

    public static /* synthetic */ int expandAndChild$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                z2 = true;
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.expandAndChild(i, z, z2, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndChild");
    }

    public final int expandAndChild(int i, boolean z, boolean z2, Object obj) {
        return expand(i, true, z, z2, obj);
    }

    public static /* synthetic */ int collapseAndChild$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                z2 = true;
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.collapseAndChild(i, z, z2, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapseAndChild");
    }

    public final int collapseAndChild(int i, boolean z, boolean z2, Object obj) {
        return collapse(i, true, z, z2, obj);
    }

    public static /* synthetic */ void expandAndCollapseOther$default(BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, boolean z3, boolean z4, Object obj, Object obj2, int i2, Object obj3) {
        if (obj3 == null) {
            boolean z5 = (i2 & 2) != 0 ? false : z;
            boolean z6 = true;
            boolean z7 = (i2 & 4) != 0 ? true : z2;
            boolean z8 = (i2 & 8) != 0 ? true : z3;
            if ((i2 & 16) == 0) {
                z6 = z4;
            }
            Object obj4 = null;
            Object obj5 = (i2 & 32) != 0 ? null : obj;
            if ((i2 & 64) == 0) {
                obj4 = obj2;
            }
            baseNodeAdapter.expandAndCollapseOther(i, z5, z7, z8, z6, obj5, obj4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndCollapseOther");
    }

    public final void expandAndCollapseOther(int i, boolean z, boolean z2, boolean z3, boolean z4, Object obj, Object obj2) {
        int i2;
        int i3;
        int expand = expand(i, z, z3, z4, obj);
        if (expand != 0) {
            int findParentNode = findParentNode(i);
            int i4 = 0;
            int i5 = findParentNode == -1 ? 0 : findParentNode + 1;
            if (i - i5 > 0) {
                int i6 = i5;
                i2 = i;
                do {
                    i6++;
                    i2 -= collapse(i6, z2, z3, z4, obj2);
                } while (i6 < i2);
            } else {
                i2 = i;
            }
            if (findParentNode == -1) {
                i3 = getData().size() - 1;
            } else {
                List<BaseNode> childNode = ((BaseNode) getData().get(findParentNode)).getChildNode();
                if (childNode != null) {
                    i4 = childNode.size();
                }
                i3 = findParentNode + i4 + expand;
            }
            int i7 = i2 + expand;
            if (i7 < i3) {
                int i8 = i7 + 1;
                while (i8 <= i3) {
                    i8++;
                    i3 -= collapse(i8, z2, z3, z4, obj2);
                }
            }
        }
    }

    public final int findParentNode(BaseNode baseNode) {
        Intrinsics.checkParameterIsNotNull(baseNode, "node");
        int indexOf = getData().indexOf(baseNode);
        if (!(indexOf == -1 || indexOf == 0)) {
            for (int i = indexOf - 1; i >= 0; i--) {
                List<BaseNode> childNode = ((BaseNode) getData().get(i)).getChildNode();
                if (childNode != null && childNode.contains(baseNode)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final int findParentNode(int i) {
        if (i == 0) {
            return -1;
        }
        BaseNode baseNode = (BaseNode) getData().get(i);
        for (int i2 = i - 1; i2 >= 0; i2--) {
            List<BaseNode> childNode = ((BaseNode) getData().get(i2)).getChildNode();
            if (childNode != null && childNode.contains(baseNode)) {
                return i2;
            }
        }
        return -1;
    }
}
