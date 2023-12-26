package com.tal.app.thinkacademy.common.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH$¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0017R\u0010\u0010\u0005\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/XesBaseActivity;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "(Landroid/view/ViewGroup;Z)Landroidx/viewbinding/ViewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "Landroid/view/View;", "layoutResID", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseBindActivity.kt */
public abstract class BaseBindActivity<VB extends ViewBinding> extends XesBaseActivity {
    private VB _binding;

    /* access modifiers changed from: protected */
    public abstract VB createViewBinding(ViewGroup viewGroup, boolean z);

    @Deprecated(message = "")
    public void setContentView(int i) {
    }

    @Deprecated(message = "")
    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        this._binding = createViewBinding((ViewGroup) findViewById, false);
        super.setContentView(getBinding().getRoot());
    }
}
