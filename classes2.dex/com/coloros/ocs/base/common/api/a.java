package com.coloros.ocs.base.common.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.coloros.ocs.base.IAuthenticationListener;
import com.coloros.ocs.base.a.b;
import com.coloros.ocs.base.common.CapabilityInfo;

class a extends com.coloros.ocs.base.common.a {
    private final String a = "a";
    private BaseClient b;

    static a a(BaseClient baseClient) {
        HandlerThread handlerThread = new HandlerThread("base_client");
        handlerThread.start();
        return new a(handlerThread.getLooper(), baseClient);
    }

    private a(Looper looper, BaseClient baseClient) {
        super(looper);
        this.b = baseClient;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        b.b(this.a, "base client handler what ".concat(String.valueOf(i)));
        if (i == 1) {
            BaseClient baseClient = this.b;
            b.c(BaseClient.a, "onAuthenticateSucceed");
            baseClient.b = 1;
            baseClient.d = (CapabilityInfo) message.obj;
            b.b(BaseClient.a, "handleAuthenticateSuccess");
            if (baseClient.g == null) {
                baseClient.a((Handler) null);
            }
            Message obtain = Message.obtain();
            obtain.what = 100;
            baseClient.g.sendMessage(obtain);
            baseClient.a();
        } else if (i == 2) {
            BaseClient baseClient2 = this.b;
            int i2 = message.arg1;
            b.b(BaseClient.a, "onFailed time");
            if (baseClient2.e != null) {
                baseClient2.c.getApplicationContext().unbindService(baseClient2.e);
                baseClient2.h = null;
            }
            baseClient2.b = 4;
            baseClient2.d = BaseClient.b(i2);
            b.b(BaseClient.a, "connect failed , error code is ".concat(String.valueOf(i2)));
            if (i2 == 1002 || i2 == 1003 || i2 == 1004 || i2 == 1005 || i2 == 1006 || i2 == 1007 || i2 == 1008) {
                baseClient2.a(i2);
                if (baseClient2.f != null) {
                    baseClient2.f.a();
                }
            }
        } else if (i == 3) {
            BaseClient baseClient3 = this.b;
            if (baseClient3.h != null && baseClient3.h.asBinder() != null && baseClient3.h.asBinder().isBinderAlive()) {
                try {
                    b.b(BaseClient.a, "thread handle authenticate");
                    baseClient3.h.handleAuthentication(baseClient3.getClientName(), "1.0.1", new IAuthenticationListener.Stub() {
                        public final void onSuccess(CapabilityInfo capabilityInfo) {
                            b.b(BaseClient.a, "thread authenticate success");
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = capabilityInfo;
                            BaseClient.this.k.sendMessage(obtain);
                        }

                        public final void onFail(int i) {
                            b.c(BaseClient.a, "errorCode ".concat(String.valueOf(i)));
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.arg1 = i;
                            BaseClient.this.k.sendMessage(obtain);
                        }
                    });
                } catch (RemoteException e) {
                    e.printStackTrace();
                    String str = BaseClient.a;
                    b.d(str, "the exception that service broker authenticates is " + e.getMessage());
                }
            }
        } else if (i == 4) {
            this.b.c();
        } else if (i == 5) {
            this.b.b();
        }
    }
}
