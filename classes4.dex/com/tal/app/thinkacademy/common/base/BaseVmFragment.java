package com.tal.app.thinkacademy.common.base;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "VM", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/BaseBindFragment;", "()V", "mIsViewCreated", "", "getMIsViewCreated", "()Z", "setMIsViewCreated", "(Z)V", "mViewModel", "getMViewModel", "()Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "setMViewModel", "(Lcom/tal/app/thinkacademy/common/base/BaseViewModel;)V", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "initVM", "", "isViewModelInitialized", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "startObserve", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseVmFragment.kt */
public abstract class BaseVmFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseBindFragment<VB> {
    private boolean mIsViewCreated;
    protected VM mViewModel;

    public void startObserve() {
    }

    /* access modifiers changed from: protected */
    public final VM getMViewModel() {
        VM vm = this.mViewModel;
        if (vm != null) {
            return vm;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMViewModel(VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.mViewModel = vm;
    }

    public final boolean isViewModelInitialized() {
        return this.mViewModel != null;
    }

    public final boolean getMIsViewCreated() {
        return this.mIsViewCreated;
    }

    public final void setMIsViewCreated(boolean z) {
        this.mIsViewCreated = z;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        initVM();
        super.onViewCreated(view, bundle);
        startObserve();
        this.mIsViewCreated = true;
    }

    private final void initVM() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Objects.requireNonNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "parameterizedType.actualTypeArguments");
        Type type = (Type) ArraysKt.first((Object[]) actualTypeArguments);
        ViewModelProvider.NewInstanceFactory newInstanceFactory = new ViewModelProvider.NewInstanceFactory();
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.tal.app.thinkacademy.common.base.BaseVmFragment>");
        BaseViewModel create = newInstanceFactory.create((Class) type);
        Intrinsics.checkNotNullExpressionValue(create, "NewInstanceFactory().create(first as Class<VM>)");
        setMViewModel(create);
        getLifecycle().addObserver(getMViewModel());
    }

    public void onDestroy() {
        getLifecycle().removeObserver(getMViewModel());
        super.onDestroy();
    }
}
