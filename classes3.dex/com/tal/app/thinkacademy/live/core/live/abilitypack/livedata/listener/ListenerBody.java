package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "T", "", "()V", "dispatch", "", "listener", "(Ljava/lang/Object;)V", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListenerBody.kt */
public abstract class ListenerBody<T> {
    public abstract void dispatch(T t);
}
