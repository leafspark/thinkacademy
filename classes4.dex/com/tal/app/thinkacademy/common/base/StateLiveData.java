package com.tal.app.thinkacademy.common.base;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.tal.app.thinkacademy.common.entity.StateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0015\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tal/app/thinkacademy/common/entity/StateData;", "()V", "postError", "", "errorCode", "", "errorMsg", "", "postFailure", "status", "postSuccess", "data", "(Ljava/lang/Object;)V", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StateLiveData.kt */
public final class StateLiveData<T> extends MutableLiveData<StateData<T>> {
    public final void postFailure(int i, String str) {
        StateData failure = new StateData().failure(i, str);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            setValue(failure);
        } else {
            postValue(failure);
        }
    }

    public final void postError(int i, String str) {
        StateData error = new StateData().error(i, str);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            setValue(error);
        } else {
            postValue(error);
        }
    }

    public final void postSuccess(T t) {
        StateData success = new StateData().success(t);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            setValue(success);
        } else {
            postValue(success);
        }
    }
}
