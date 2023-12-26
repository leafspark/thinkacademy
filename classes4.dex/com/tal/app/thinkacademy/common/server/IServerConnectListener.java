package com.tal.app.thinkacademy.common.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IServerConnectListener extends IInterface {
    public static final String DESCRIPTOR = "com.tal.app.thinkacademy.common.server.IServerConnectListener";

    public static class Default implements IServerConnectListener {
        public IBinder asBinder() {
            return null;
        }

        public void onException(String str) throws RemoteException {
        }

        public void onRequestError(int i, String str) throws RemoteException {
        }

        public void onStarted(String str) throws RemoteException {
        }

        public void onStopped() throws RemoteException {
        }
    }

    void onException(String str) throws RemoteException;

    void onRequestError(int i, String str) throws RemoteException;

    void onStarted(String str) throws RemoteException;

    void onStopped() throws RemoteException;

    public static abstract class Stub extends Binder implements IServerConnectListener {
        static final int TRANSACTION_onException = 3;
        static final int TRANSACTION_onRequestError = 4;
        static final int TRANSACTION_onStarted = 1;
        static final int TRANSACTION_onStopped = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IServerConnectListener.DESCRIPTOR);
        }

        public static IServerConnectListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IServerConnectListener.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IServerConnectListener)) {
                return new Proxy(iBinder);
            }
            return (IServerConnectListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IServerConnectListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onStarted(parcel.readString());
                    parcel2.writeNoException();
                } else if (i == 2) {
                    onStopped();
                    parcel2.writeNoException();
                } else if (i == 3) {
                    onException(parcel.readString());
                    parcel2.writeNoException();
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onRequestError(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IServerConnectListener.DESCRIPTOR);
            return true;
        }

        private static class Proxy implements IServerConnectListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServerConnectListener.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onStarted(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IServerConnectListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStopped() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IServerConnectListener.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onException(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IServerConnectListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IServerConnectListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
