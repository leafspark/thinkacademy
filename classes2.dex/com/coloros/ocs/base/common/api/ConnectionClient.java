package com.coloros.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.coloros.ocs.base.IAuthenticationListener;
import com.coloros.ocs.base.IServiceBroker;
import com.coloros.ocs.base.a.b;

public class ConnectionClient {
    private static final String BIND_SERVICE_INTENT_STRING = "com.coloros.opencapabilityservice";
    private static final String BIND_SERVICE_NAME = "com.coloros.ocs.opencapabilityservice.service.ColorOcsService";
    private static final String BIND_SERVICE_PACKAGE_NAME = "com.coloros.ocs.opencapabilityservice";
    /* access modifiers changed from: private */
    public final String TAG = "ConnectionClient";
    /* access modifiers changed from: private */
    public String mClientName;
    private Context mContext;
    /* access modifiers changed from: private */
    public IAuthenticationListener mListener;
    private a mServiceConnectionImpl;

    private Intent getServiceIntent() {
        Intent intent = new Intent(BIND_SERVICE_INTENT_STRING);
        b.a(this.TAG, "packageName = ".concat(BIND_SERVICE_PACKAGE_NAME));
        intent.setComponent(new ComponentName(BIND_SERVICE_PACKAGE_NAME, BIND_SERVICE_NAME));
        return intent;
    }

    public void bind(Context context, String str, IAuthenticationListener iAuthenticationListener) {
        if (this.mContext == null) {
            this.mContext = context;
        }
        if (TextUtils.isEmpty(this.mClientName)) {
            this.mClientName = str;
        }
        if (this.mListener == null) {
            this.mListener = iAuthenticationListener;
        }
        this.mServiceConnectionImpl = new a(this, (byte) 0);
        if (!this.mContext.getApplicationContext().bindService(getServiceIntent(), this.mServiceConnectionImpl, 1)) {
            b.a(this.TAG, "connection client bindService failed");
        }
    }

    public void unBind() {
        Context context = this.mContext;
        if (context != null && this.mServiceConnectionImpl != null) {
            context.getApplicationContext().unbindService(this.mServiceConnectionImpl);
            this.mServiceConnectionImpl = null;
        }
    }

    class a implements ServiceConnection {
        private a() {
        }

        /* synthetic */ a(ConnectionClient connectionClient, byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.b(ConnectionClient.this.TAG, "onServiceConnected");
            try {
                IServiceBroker.Stub.asInterface(iBinder).handleAuthentication(ConnectionClient.this.mClientName, "1.0.1", ConnectionClient.this.mListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            b.d(ConnectionClient.this.TAG, "onServiceDisconnected()");
        }
    }
}
