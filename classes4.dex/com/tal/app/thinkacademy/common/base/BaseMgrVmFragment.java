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
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0004J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0004J\b\u0010\u0013\u001a\u00020\u0014H$J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0004J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0004R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/common/base/BaseMgrVmFragment;", "VM", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "()V", "mFm", "Landroidx/fragment/app/FragmentManager;", "mFrags", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "add", "", "fragment", "commit", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "getFragmentId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "show", "position", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseMgrVmFragment.kt */
public abstract class BaseMgrVmFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseVmFragment<VM, VB> {
    private FragmentManager mFm;
    private ArrayList<Fragment> mFrags = new ArrayList<>();

    /* access modifiers changed from: protected */
    public abstract int getFragmentId();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        try {
            this.mFm = getChildFragmentManager();
        } catch (Exception unused) {
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public final void add(Fragment fragment) {
        if (fragment != null) {
            try {
                if (this.mFm == null) {
                    this.mFm = getChildFragmentManager();
                }
                this.mFrags.add(fragment);
                FragmentManager fragmentManager = this.mFm;
                FragmentTransaction beginTransaction = fragmentManager == null ? null : fragmentManager.beginTransaction();
                if (beginTransaction != null) {
                    beginTransaction.add(getFragmentId(), fragment);
                }
                commit(beginTransaction);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void show(Fragment fragment) {
        if (fragment != null) {
            try {
                if (this.mFm == null) {
                    this.mFm = getChildFragmentManager();
                }
                FragmentManager fragmentManager = this.mFm;
                FragmentTransaction beginTransaction = fragmentManager == null ? null : fragmentManager.beginTransaction();
                Iterator<Fragment> it = this.mFrags.iterator();
                while (it.hasNext()) {
                    Fragment next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "mFrags");
                    Fragment fragment2 = next;
                    if (Intrinsics.areEqual(fragment2, fragment)) {
                        if (beginTransaction != null) {
                            beginTransaction.show(fragment2);
                        }
                    } else if (beginTransaction != null) {
                        beginTransaction.hide(fragment2);
                    }
                }
                commit(beginTransaction);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void commit(FragmentTransaction fragmentTransaction) {
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    public final void show(int i) {
        boolean z = false;
        if (i >= 0 && i < this.mFrags.size()) {
            z = true;
        }
        if (z) {
            show(this.mFrags.get(i));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFrags.clear();
        this.mFm = null;
    }
}
