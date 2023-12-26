package com.tal.app.thinkacademy.lib.network.exception;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "", "onError", "", "code", "", "msg", "", "onFail", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IError.kt */
public interface IError {
    void onError(int i, String str);

    void onFail(int i, String str);
}
