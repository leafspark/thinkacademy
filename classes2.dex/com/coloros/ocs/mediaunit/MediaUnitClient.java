package com.coloros.ocs.mediaunit;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.coloros.ocs.base.common.api.Api;
import com.coloros.ocs.base.common.api.ColorApi;
import com.coloros.ocs.base.common.api.TaskListenerHolder;
import com.coloros.ocs.base.internal.ClientSettings;
import com.coloros.ocs.base.task.TaskImpl;
import com.coloros.ocs.mediaunit.IKaraokeService;
import java.util.ArrayList;

public final class MediaUnitClient extends ColorApi<Api.ApiOptions.NoOptions, MediaUnitClient> {
    private static final Api<Api.ApiOptions.NoOptions> API;
    private static final String BIND_SERVICE_ACTION = "com.coloros.opencapabilityservice";
    private static final String BIND_SERVICE_NAME = "com.coloros.ocs.opencapabilityservice.capability.karaoke.KaraokeService";
    private static final String BIND_SERVICE_PACKAGE_NAME = "com.coloros.ocs.opencapabilityservice";
    private static final Api.AbstractClientBuilder<MediaClient, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
    private static final Api.ClientKey<MediaClient> CLIENT_KEY;
    private static final String TAG = "MediaUnitClientImpl";
    private static MediaUnitClient sMediaUnitClient;
    private ServiceConnection mConnection;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public final IBinder mICallBack = new Binder();
    /* access modifiers changed from: private */
    public IKaraokeService mService;

    public int getVersion() {
        return 0;
    }

    public boolean hasFeature(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void init() {
    }

    static {
        Api.ClientKey<MediaClient> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        MediaClientBuilder mediaClientBuilder = new MediaClientBuilder();
        CLIENT_BUILDER = mediaClientBuilder;
        API = new Api<>("MediaClient.API", mediaClientBuilder, clientKey);
    }

    private MediaUnitClient(Context context) {
        super(context, API, null, new ClientSettings(context.getPackageName(), 1, new ArrayList()));
        this.mContext = context;
        init();
    }

    protected static synchronized MediaUnitClient initialize(Context context) {
        synchronized (MediaUnitClient.class) {
            MediaUnitClient mediaUnitClient = sMediaUnitClient;
            if (mediaUnitClient != null) {
                return mediaUnitClient;
            }
            checkRuntimeEnvironment(context);
            MediaUnitClient mediaUnitClient2 = sMediaUnitClient;
            return mediaUnitClient2;
        }
    }

    private static void checkRuntimeEnvironment(Context context) {
        sMediaUnitClient = new MediaUnitClient(context);
    }

    /* access modifiers changed from: private */
    public void bindService() {
        this.mConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IKaraokeService unused = MediaUnitClient.this.mService = IKaraokeService.Stub.asInterface(iBinder);
                try {
                    MediaUnitClient.this.mService.requestAudioLoopback(MediaUnitClient.this.mICallBack, MediaUnitClient.this.mContext.getPackageName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                IKaraokeService unused = MediaUnitClient.this.mService = null;
            }
        };
        Intent intent = new Intent(BIND_SERVICE_ACTION);
        intent.setComponent(new ComponentName(BIND_SERVICE_PACKAGE_NAME, BIND_SERVICE_NAME));
        this.mContext.bindService(intent, this.mConnection, 1);
    }

    public int requestAudioLoopback() {
        Log.i(TAG, "requestAudioLoopback " + this.mICallBack);
        doRegisterListener(Looper.myLooper(), new TaskListenerHolder.SuccessNotifier<Void>() {
            public void notifyListener(TaskImpl<Void> taskImpl) {
                if (MediaUnitClient.this.mService == null) {
                    MediaUnitClient.this.bindService();
                    return;
                }
                try {
                    MediaUnitClient.this.mService.requestAudioLoopback(MediaUnitClient.this.mICallBack, MediaUnitClient.this.mContext.getPackageName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }, new TaskListenerHolder.FailureNotifier<Void>() {
            public void onNotifyListenerFailed(TaskImpl taskImpl, int i, String str) {
                Log.e(MediaUnitClient.TAG, "errorCode -- " + i);
            }
        });
        return 0;
    }

    public int abandonAudioLoopback() {
        doRegisterListener(Looper.myLooper(), new TaskListenerHolder.SuccessNotifier<Void>() {
            public void notifyListener(TaskImpl<Void> taskImpl) {
                if (MediaUnitClient.this.mService != null) {
                    try {
                        MediaUnitClient.this.mService.abandonAudioLoopback(MediaUnitClient.this.mContext.getPackageName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new TaskListenerHolder.FailureNotifier<Void>() {
            public void onNotifyListenerFailed(TaskImpl taskImpl, int i, String str) {
                Log.e(MediaUnitClient.TAG, "errorCode -- " + i);
            }
        });
        return 0;
    }

    private void destroy() {
        this.mContext.unbindService(this.mConnection);
    }

    public static void release() {
        sMediaUnitClient.destroy();
    }
}
