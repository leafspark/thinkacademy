package com.tal.app.thinkacademy.common.globalnotifier.listener;

import com.tal.app.thinkacademy.common.globalnotifier.TNotifyType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/globalnotifier/listener/OnGlobalNotifier;", "", "onGlobalNotify", "", "type", "Lcom/tal/app/thinkacademy/common/globalnotifier/TNotifyType;", "data", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnGlobalNotifier.kt */
public interface OnGlobalNotifier {
    void onGlobalNotify(TNotifyType tNotifyType, Object obj);
}
