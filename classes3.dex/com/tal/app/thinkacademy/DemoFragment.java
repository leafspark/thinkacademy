package com.tal.app.thinkacademy;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.common.base.BaseVmFragment;
import com.tal.app.thinkacademy.databinding.FragmentDemoBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/DemoFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "Lcom/tal/app/thinkacademy/DemoViewModel;", "Lcom/tal/app/thinkacademy/databinding/FragmentDemoBinding;", "()V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DemoFragment.kt */
public final class DemoFragment extends BaseVmFragment<DemoViewModel, FragmentDemoBinding> {
    /* access modifiers changed from: protected */
    public FragmentDemoBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDemoBinding inflate = FragmentDemoBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater,container,attach)");
        return inflate;
    }
}
