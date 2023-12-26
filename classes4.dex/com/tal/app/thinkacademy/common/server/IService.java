package com.tal.app.thinkacademy.common.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tal.app.thinkacademy.common.server.IServerConnectListener;

public interface IService extends IInterface {
    public static final String DESCRIPTOR = "com.tal.app.thinkacademy.common.server.IService";

    public static class Default implements IService {
        public IBinder asBinder() {
            return null;
        }

        public boolean isServerRunning() throws RemoteException {
            return false;
        }

        public void setCallback(IServerConnectListener iServerConnectListener) throws RemoteException {
        }
    }

    boolean isServerRunning() throws RemoteException;

    void setCallback(IServerConnectListener iServerConnectListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IService {
        static final int TRANSACTION_isServerRunning = 1;
        static final int TRANSACTION_setCallback = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IService.DESCRIPTOR);
        }

        public static IService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IService.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IService)) {
                return new Proxy(iBinder);
            }
            return (IService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IService.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean isServerRunning = isServerRunning();
                    parcel2.writeNoException();
                    parcel2.writeInt(isServerRunning ? 1 : 0);
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    setCallback(IServerConnectListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IService.DESCRIPTOR);
            return true;
        }

        private static class Proxy implements IService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IService.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean isServerRunning() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IService.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCallback(IServerConnectListener iServerConnectListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IService.DESCRIPTOR);
                    obtain.writeStrongInterface(iServerConnectListener);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
