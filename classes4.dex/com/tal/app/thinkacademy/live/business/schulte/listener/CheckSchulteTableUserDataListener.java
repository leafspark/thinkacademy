package com.tal.app.thinkacademy.live.business.schulte.listener;

import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/listener/CheckSchulteTableUserDataListener;", "", "onError", "", "code", "", "msg", "", "onSubmitted", "schulteTableUserData", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "onUnSubmitted", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckSchulteTableUserDataListener.kt */
public interface CheckSchulteTableUserDataListener {
    void onError(int i, String str);

    void onSubmitted(SchulteTableUserDataBean schulteTableUserDataBean);

    void onUnSubmitted();
}
