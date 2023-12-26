package com.tal.app.thinkacademy.common.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/InitListener;", "", "isNcAgc", "", "()Z", "reportError", "", "code", "", "msg", "", "reportReadMicTimeout", "duration", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioRecordHelper.kt */
public interface InitListener {
    boolean isNcAgc();

    void reportError(int i, String str);

    void reportReadMicTimeout(long j);
}
