package com.tal.app.thinkacademy.common.base;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tbruyelle.rxpermissions3.Permission;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.core.Observable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0004J\u0006\u0010\u001d\u001a\u00020\u001aJ\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0015H\u0014J5\u0010\"\u001a\u00020\u00152\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0#\"\u00020\u001c2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00150%H\u0004¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0015H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "VM", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "mRxPermissions", "Lcom/tbruyelle/rxpermissions3/RxPermissions;", "getMRxPermissions", "()Lcom/tbruyelle/rxpermissions3/RxPermissions;", "setMRxPermissions", "(Lcom/tbruyelle/rxpermissions3/RxPermissions;)V", "mViewModel", "getMViewModel", "()Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "setMViewModel", "(Lcom/tal/app/thinkacademy/common/base/BaseViewModel;)V", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "applyOverrideConfiguration", "", "overrideConfiguration", "Landroid/content/res/Configuration;", "initVM", "isGranted", "", "permission", "", "isViewModelInitialized", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "request", "", "accept", "Lkotlin/Function1;", "Lcom/tbruyelle/rxpermissions3/Permission;", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "startObserve", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseVmActivity.kt */
public abstract class BaseVmActivity<VM extends BaseViewModel, VB extends ViewBinding> extends BaseBindActivity<VB> implements LifecycleObserver {
    private RxPermissions mRxPermissions;
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

    /* access modifiers changed from: protected */
    public final RxPermissions getMRxPermissions() {
        return this.mRxPermissions;
    }

    /* access modifiers changed from: protected */
    public final void setMRxPermissions(RxPermissions rxPermissions) {
        this.mRxPermissions = rxPermissions;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        initVM();
        super.onCreate(bundle);
        this.mRxPermissions = new RxPermissions((FragmentActivity) this);
        startObserve();
    }

    public final boolean isViewModelInitialized() {
        return this.mViewModel != null;
    }

    private final void initVM() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Objects.requireNonNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "parameterizedType.actualTypeArguments");
        Type type = (Type) ArraysKt.first((Object[]) actualTypeArguments);
        ViewModelProvider.NewInstanceFactory newInstanceFactory = new ViewModelProvider.NewInstanceFactory();
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.tal.app.thinkacademy.common.base.BaseVmActivity>");
        BaseViewModel create = newInstanceFactory.create((Class) type);
        Intrinsics.checkNotNullExpressionValue(create, "NewInstanceFactory().create(first as Class<VM>)");
        setMViewModel(create);
        getLifecycle().addObserver(getMViewModel());
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i;
        }
        super.applyOverrideConfiguration(configuration);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getLifecycle().removeObserver(getMViewModel());
        super.onDestroy();
        this.mRxPermissions = null;
    }

    /* access modifiers changed from: protected */
    public final boolean isGranted(String str) {
        RxPermissions rxPermissions = this.mRxPermissions;
        if (rxPermissions == null) {
            return false;
        }
        return rxPermissions.isGranted(str);
    }

    /* access modifiers changed from: protected */
    public final void request(String[] strArr, Function1<? super Permission, Unit> function1) {
        Observable requestEach;
        Intrinsics.checkNotNullParameter(strArr, "permission");
        Intrinsics.checkNotNullParameter(function1, "accept");
        RxPermissions rxPermissions = this.mRxPermissions;
        if (rxPermissions != null && (requestEach = rxPermissions.requestEach((String[]) Arrays.copyOf(strArr, strArr.length))) != null) {
            requestEach.subscribe(new BaseVmActivity$$ExternalSyntheticLambda0(function1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: request$lambda-1  reason: not valid java name */
    public static final void m4request$lambda1(Function1 function1, Permission permission) {
        Intrinsics.checkNotNullParameter(function1, "$accept");
        Intrinsics.checkNotNullExpressionValue(permission, "it");
        function1.invoke(permission);
    }
}
