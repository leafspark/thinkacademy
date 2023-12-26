package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class DefaultHeartBeatInfo$$ExternalSyntheticLambda4 implements ThreadFactory {
    public static final /* synthetic */ DefaultHeartBeatInfo$$ExternalSyntheticLambda4 INSTANCE = new DefaultHeartBeatInfo$$ExternalSyntheticLambda4();

    private /* synthetic */ DefaultHeartBeatInfo$$ExternalSyntheticLambda4() {
    }

    public final Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.lambda$static$0(runnable);
    }
}
