package com.tal.app.thinkacademy.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.databinding.FragmentBaseMainBinding;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.RoutePose;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0005J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/common/base/BaseMainFragment;", "VM", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "()V", "mBaseBinding", "Lcom/tal/app/thinkacademy/common/databinding/FragmentBaseMainBinding;", "jumpNext", "", "pose", "Lcom/tal/app/thinkacademy/lib/interfaces/route/RoutePose;", "bundle", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "setupScreen", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseMainFragment.kt */
public abstract class BaseMainFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseVmFragment<VM, VB> {
    private FragmentBaseMainBinding mBaseBinding;

    /* access modifiers changed from: protected */
    public final void jumpNext(RoutePose routePose) {
        Intrinsics.checkNotNullParameter(routePose, "pose");
        jumpNext$default(this, routePose, (Bundle) null, 2, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        setupScreen(layoutInflater, viewGroup);
        return onCreateView;
    }

    private final void setupScreen(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (PadUtils.isPad(getContext())) {
            FragmentBaseMainBinding inflate = FragmentBaseMainBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
            inflate.screenMain.addView(getBinding().getRoot());
            this.layoutView = inflate.getRoot();
            this.mBaseBinding = inflate;
        }
    }

    public static /* synthetic */ void jumpNext$default(BaseMainFragment baseMainFragment, RoutePose routePose, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            baseMainFragment.jumpNext(routePose, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jumpNext");
    }

    /* access modifiers changed from: protected */
    public final void jumpNext(RoutePose routePose, Bundle bundle) {
        Intrinsics.checkNotNullParameter(routePose, "pose");
        if (PadUtils.isPad(getContext())) {
            Fragment fragment = (Fragment) XesRoute.getInstance().get(routePose.fPath, bundle);
            FragmentBaseMainBinding fragmentBaseMainBinding = this.mBaseBinding;
            if (fragmentBaseMainBinding != null) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                beginTransaction.replace(fragmentBaseMainBinding.screenSecond.getId(), fragment);
                beginTransaction.commit();
                return;
            }
            return;
        }
        XesRoute.getInstance().navigation(routePose.aPath, bundle);
    }
}
