package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/StateData;", "T", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "mStatus", "getMStatus", "setMStatus", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "status", "Lcom/tal/app/thinkacademy/common/entity/StateData$DataStatus;", "getStatus", "()Lcom/tal/app/thinkacademy/common/entity/StateData$DataStatus;", "setStatus", "(Lcom/tal/app/thinkacademy/common/entity/StateData$DataStatus;)V", "error", "failure", "success", "(Ljava/lang/Object;)Lcom/tal/app/thinkacademy/common/entity/StateData;", "DataStatus", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StateData.kt */
public final class StateData<T> {
    private int code;
    private T data;
    private int mStatus;
    private String msg;
    private DataStatus status = DataStatus.SUCCESS;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/StateData$DataStatus;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "FAILURE", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StateData.kt */
    public enum DataStatus {
        SUCCESS,
        ERROR,
        FAILURE
    }

    public final DataStatus getStatus() {
        return this.status;
    }

    public final void setStatus(DataStatus dataStatus) {
        Intrinsics.checkNotNullParameter(dataStatus, "<set-?>");
        this.status = dataStatus;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final StateData<T> success(T t) {
        this.status = DataStatus.SUCCESS;
        this.data = t;
        return this;
    }

    public final StateData<T> failure(int i, String str) {
        this.status = DataStatus.FAILURE;
        this.mStatus = i;
        this.msg = str;
        return this;
    }

    public final StateData<T> error(int i, String str) {
        this.status = DataStatus.ERROR;
        this.code = i;
        this.msg = str;
        return this;
    }
}
