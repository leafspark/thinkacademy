package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u001d\u001a\u00020\u001e2\f\b\u0001\u0010\u001f\u001a\u00020 \"\u00020\u0006J\u0014\u0010!\u001a\u00020\u001e2\f\b\u0001\u0010\u001f\u001a\u00020 \"\u00020\u0006J\u001d\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H&¢\u0006\u0002\u0010&J+\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH\u0016J\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J-\u0010-\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00102J-\u00103\u001a\u0002042\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00105J-\u00106\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00102J\u0018\u00107\u001a\u00020$2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0006H\u0016J-\u0010;\u001a\u0002042\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00105J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020$H\u0016J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020$H\u0016J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0006H\u0016J\u001b\u0010A\u001a\u00020\u001e2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0000¢\u0006\u0002\bCR+\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R+\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "T", "", "()V", "clickViewIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getClickViewIds", "()Ljava/util/ArrayList;", "clickViewIds$delegate", "Lkotlin/Lazy;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "itemViewType", "getItemViewType", "()I", "layoutId", "getLayoutId", "longClickViewIds", "getLongClickViewIds", "longClickViewIds$delegate", "weakAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "addChildClickViewIds", "", "ids", "", "addChildLongClickViewIds", "convert", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "getAdapter", "getChildClickViewIds", "getChildLongClickViewIds", "onChildClick", "view", "Landroid/view/View;", "data", "position", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)V", "onChildLongClick", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)Z", "onClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLongClick", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "onViewHolderCreated", "viewHolder", "setAdapter", "adapter", "setAdapter$com_github_CymChad_brvah", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseItemProvider.kt */
public abstract class BaseItemProvider<T> {
    private final Lazy clickViewIds$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, BaseItemProvider$clickViewIds$2.INSTANCE);
    public Context context;
    private final Lazy longClickViewIds$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, BaseItemProvider$longClickViewIds$2.INSTANCE);
    private WeakReference<BaseProviderMultiAdapter<T>> weakAdapter;

    private final ArrayList<Integer> getClickViewIds() {
        return (ArrayList) this.clickViewIds$delegate.getValue();
    }

    private final ArrayList<Integer> getLongClickViewIds() {
        return (ArrayList) this.longClickViewIds$delegate.getValue();
    }

    public abstract void convert(BaseViewHolder baseViewHolder, T t);

    public void convert(BaseViewHolder baseViewHolder, T t, List<? extends Object> list) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "helper");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
    }

    public abstract int getItemViewType();

    public abstract int getLayoutId();

    public void onChildClick(BaseViewHolder baseViewHolder, View view, T t, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "helper");
        Intrinsics.checkParameterIsNotNull(view, BaseEventInfo.EVENT_TYPE_VIEW);
    }

    public boolean onChildLongClick(BaseViewHolder baseViewHolder, View view, T t, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "helper");
        Intrinsics.checkParameterIsNotNull(view, BaseEventInfo.EVENT_TYPE_VIEW);
        return false;
    }

    public void onClick(BaseViewHolder baseViewHolder, View view, T t, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "helper");
        Intrinsics.checkParameterIsNotNull(view, BaseEventInfo.EVENT_TYPE_VIEW);
    }

    public boolean onLongClick(BaseViewHolder baseViewHolder, View view, T t, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "helper");
        Intrinsics.checkParameterIsNotNull(view, BaseEventInfo.EVENT_TYPE_VIEW);
        return false;
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
    }

    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
    }

    public void onViewHolderCreated(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "viewHolder");
    }

    public final Context getContext() {
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context2;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "<set-?>");
        this.context = context2;
    }

    public final void setAdapter$com_github_CymChad_brvah(BaseProviderMultiAdapter<T> baseProviderMultiAdapter) {
        Intrinsics.checkParameterIsNotNull(baseProviderMultiAdapter, "adapter");
        this.weakAdapter = new WeakReference<>(baseProviderMultiAdapter);
    }

    public BaseProviderMultiAdapter<T> getAdapter() {
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.weakAdapter;
        if (weakReference != null) {
            return (BaseProviderMultiAdapter) weakReference.get();
        }
        return null;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return new BaseViewHolder(AdapterUtilsKt.getItemView(viewGroup, getLayoutId()));
    }

    public final ArrayList<Integer> getChildClickViewIds() {
        return getClickViewIds();
    }

    public final ArrayList<Integer> getChildLongClickViewIds() {
        return getLongClickViewIds();
    }

    public final void addChildClickViewIds(int... iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "ids");
        for (int valueOf : iArr) {
            getClickViewIds().add(Integer.valueOf(valueOf));
        }
    }

    public final void addChildLongClickViewIds(int... iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "ids");
        for (int valueOf : iArr) {
            getLongClickViewIds().add(Integer.valueOf(valueOf));
        }
    }
}
