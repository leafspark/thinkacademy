package com.didi.hummer.adapter.navigator.impl;

import android.content.Intent;
import com.didi.hummer.adapter.navigator.NavCallback;
import com.didi.hummer.adapter.navigator.impl.router.ActivityLauncher;

public final /* synthetic */ class DefaultNavigatorAdapter$$ExternalSyntheticLambda0 implements ActivityLauncher.Callback {
    public final /* synthetic */ DefaultNavigatorAdapter f$0;
    public final /* synthetic */ NavCallback f$1;

    public /* synthetic */ DefaultNavigatorAdapter$$ExternalSyntheticLambda0(DefaultNavigatorAdapter defaultNavigatorAdapter, NavCallback navCallback) {
        this.f$0 = defaultNavigatorAdapter;
        this.f$1 = navCallback;
    }

    public final void onActivityResult(int i, Intent intent) {
        this.f$0.lambda$openPage$0$DefaultNavigatorAdapter(this.f$1, i, intent);
    }
}
