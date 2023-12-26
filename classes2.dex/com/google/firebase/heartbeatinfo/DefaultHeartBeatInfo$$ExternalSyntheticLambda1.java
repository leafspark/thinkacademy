package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class DefaultHeartBeatInfo$$ExternalSyntheticLambda1 implements Provider {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ DefaultHeartBeatInfo$$ExternalSyntheticLambda1(Context context) {
        this.f$0 = context;
    }

    public final Object get() {
        return HeartBeatInfoStorage.getInstance(this.f$0);
    }
}
