package com.coloros.ocs.mediaunit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IKaraokeService extends IInterface {

    public static class Default implements IKaraokeService {
        public int abandonAudioLoopback(String str) throws RemoteException {
            return 0;
        }

        public IBinder asBinder() {
            return null;
        }

        public int requestAudioLoopback(IBinder iBinder, String str) throws RemoteException {
            return 0;
        }
    }

    int abandonAudioLoopback(String str) throws RemoteException;

    int requestAudioLoopback(IBinder iBinder, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IKaraokeService {
        private static final String DESCRIPTOR = "com.coloros.ocs.mediaunit.IKaraokeService";
        static final int TRANSACTION_abandonAudioLoopback = 2;
        static final int TRANSACTION_requestAudioLoopback = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IKaraokeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IKaraokeService)) {
                return new Proxy(iBinder);
            }
            return (IKaraokeService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int requestAudioLoopback = requestAudioLoopback(parcel.readStrongBinder(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(requestAudioLoopback);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                int abandonAudioLoopback = abandonAudioLoopback(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(abandonAudioLoopback);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IKaraokeService {
            public static IKaraokeService sDefaultImpl;
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

            public int requestAudioLoopback(IBinder iBinder, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestAudioLoopback(iBinder, str);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int abandonAudioLoopback(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().abandonAudioLoopback(str);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IKaraokeService iKaraokeService) {
            if (Proxy.sDefaultImpl != null || iKaraokeService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iKaraokeService;
            return true;
        }

        public static IKaraokeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
