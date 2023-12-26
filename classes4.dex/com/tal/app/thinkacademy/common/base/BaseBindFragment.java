package com.tal.app.thinkacademy.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J'\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H$¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0007J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0005\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/base/BaseBindFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/XesBaseFragment;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Landroidx/viewbinding/ViewBinding;", "getLayoutId", "", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseBindFragment.kt */
public abstract class BaseBindFragment<VB extends ViewBinding> extends XesBaseFragment {
    private VB _binding;

    /* access modifiers changed from: protected */
    public abstract VB createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z);

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "0", imports = {}))
    public final int getLayoutId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final VB getBinding() {
        VB vb = this._binding;
        if (vb != null) {
            return vb;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_binding");
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VB createViewBinding = createViewBinding(layoutInflater, viewGroup, false);
        this._binding = createViewBinding;
        if (createViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_binding");
            createViewBinding = null;
        }
        this.layoutView = createViewBinding.getRoot();
        return this.layoutView;
    }
}
