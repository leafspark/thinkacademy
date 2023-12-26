package com.coloros.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.coloros.ocs.base.a.c;
import com.coloros.ocs.base.common.AuthResult;
import com.coloros.ocs.base.common.api.Api.ApiOptions;
import com.coloros.ocs.base.internal.ClientSettings;

public class Api<O extends ApiOptions> {
    private AbstractClientBuilder<?, O> mClientBuilder;
    private ClientKey<?> mClientKey;
    private String mName;

    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        public abstract T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o);
    }

    public interface AnyClient {
    }

    public static class AnyClientKey<C extends AnyClient> {
    }

    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface Client extends AnyClient {
        <T> void addQueue(TaskListenerHolder<T> taskListenerHolder);

        void connect();

        void disconnect();

        AuthResult getAuthResult();

        Looper getLooper();

        int getMinApkVersion();

        IBinder getRemoteService();

        String getTargetPackageName();

        boolean isConnected();

        boolean isConnecting();

        boolean requiresColorService();

        void setOnClearListener(e eVar);

        void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler);

        void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler);
    }

    public static class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder iBinder);

        Context getContext();

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int i, T t);
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        c.a(abstractClientBuilder, (Object) "can not construct whit the null AbstractClientBuilder");
        c.a(clientKey, (Object) "can not construct with the null ClientKey");
        this.mName = str;
        this.mClientBuilder = abstractClientBuilder;
        this.mClientKey = clientKey;
    }

    public BaseClientBuilder<?, O> getBaseClientBuilder() {
        return this.mClientBuilder;
    }

    public AbstractClientBuilder<?, O> getClientBuilder() {
        c.a(this.mClientBuilder != null, (Object) "The ClientBuilder is null");
        return this.mClientBuilder;
    }

    public ClientKey<?> getClientKey() {
        ClientKey<?> clientKey = this.mClientKey;
        if (clientKey != null) {
            return clientKey;
        }
        throw new IllegalStateException("This API was constructed with null clientKey.");
    }

    public String getName() {
        return this.mName;
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }

        public static class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }
    }
}
