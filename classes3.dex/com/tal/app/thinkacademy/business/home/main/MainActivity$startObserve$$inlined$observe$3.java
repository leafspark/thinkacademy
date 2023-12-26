package com.tal.app.thinkacademy.business.home.main;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.home.main.MainActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class MainActivity$startObserve$$inlined$observe$3<T> implements Observer<T> {
    final /* synthetic */ MainActivity this$0;

    public MainActivity$startObserve$$inlined$observe$3(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onChanged(T t) {
        StateData stateData = (StateData) t;
        int i = MainActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            this.this$0.mClientLoggingIn = false;
            XesLog.s(Tag.PUSH, new Object[]{"clientLogin 接口成功"});
        } else if (i == 2) {
            this.this$0.mClientLoggingIn = false;
            XesLog.e(Tag.PUSH, new Object[]{"clientLogin 接口失败：" + stateData.getCode() + ',' + stateData.getMsg()});
        } else if (i == 3) {
            this.this$0.mClientLoggingIn = false;
            XesLog.e(Tag.PUSH, new Object[]{Intrinsics.stringPlus("clientLogin 接口错误：", stateData.getMsg())});
        }
    }
}
