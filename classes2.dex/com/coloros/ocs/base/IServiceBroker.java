package com.coloros.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.coloros.ocs.base.IAuthenticationListener;

public interface IServiceBroker extends IInterface {

    public static class Default implements IServiceBroker {
        public IBinder asBinder() {
            return null;
        }

        public IBinder getBinder(String str, String str2) throws RemoteException {
            return null;
        }

        public void handleAuthentication(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException {
        }
    }

    IBinder getBinder(String str, String str2) throws RemoteException;

    void handleAuthentication(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IServiceBroker {
        private static final String DESCRIPTOR = "com.coloros.ocs.base.IServiceBroker";
        static final int TRANSACTION_getBinder = 2;
        static final int TRANSACTION_handleAuthentication = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IServiceBroker)) {
                return new Proxy(iBinder);
            }
            return (IServiceBroker) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                handleAuthentication(parcel.readString(), parcel.readString(), IAuthenticationListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                IBinder binder = getBinder(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binder);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        static class Proxy implements IServiceBroker {
            public static IServiceBroker sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void handleAuthentication(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iAuthenticationListener != null ? iAuthenticationListener.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().handleAuthentication(str, str2, iAuthenticationListener);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder getBinder(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBinder(str, str2);
                    }
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    obtain2.recycle();
                    obtain.recycle();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IServiceBroker iServiceBroker) {
            if (Proxy.sDefaultImpl != null || iServiceBroker == null) {
                return false;
            }
            Proxy.sDefaultImpl = iServiceBroker;
            return true;
        }

        public static IServiceBroker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
