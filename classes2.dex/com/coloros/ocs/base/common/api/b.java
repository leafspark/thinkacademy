package com.coloros.ocs.base.common.api;

import android.os.Looper;
import android.os.Message;
import com.coloros.ocs.base.common.ConnectionResult;
import com.coloros.ocs.base.common.a;

class b extends a {
    OnConnectionSucceedListener a;
    OnConnectionFailedListener b;
    private final String c = "b";
    private a d;

    b(Looper looper, a aVar) {
        super(looper);
        this.d = aVar;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        com.coloros.ocs.base.a.b.b(this.c, "business handler what ".concat(String.valueOf(i)));
        if (i == 100) {
            OnConnectionSucceedListener onConnectionSucceedListener = this.a;
            if (onConnectionSucceedListener != null) {
                onConnectionSucceedListener.onConnectionSucceed();
            }
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.d.sendMessage(obtain);
        } else if (i == 101) {
            int i2 = message.arg1;
            OnConnectionFailedListener onConnectionFailedListener = this.b;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 5;
            this.d.sendMessage(obtain2);
        }
    }
}
