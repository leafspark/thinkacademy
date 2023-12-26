package com.bonree.sdk.agent.engine.network.okhttp3.external;

import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.n.b;
import com.bonree.sdk.v.d;
import com.bonree.sdk.v.e;
import java.io.IOException;
import java.net.Socket;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp3NetworkInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Socket socket;
        Response proceed = chain.proceed(chain.request());
        try {
            Request request = chain.request();
            Object obj = null;
            b bVar = (request == null || request.tag() == null || !(request.tag() instanceof b)) ? null : (b) request.tag();
            if (!(bVar == null || chain == null || chain.connection() == null || (socket = chain.connection().socket()) == null || bVar == null)) {
                if (socket instanceof e) {
                    ((e) socket).a(bVar);
                } else {
                    try {
                        obj = z.a(z.a((Object) socket, "socket"), "impl");
                    } catch (Throwable unused) {
                    }
                    if (obj == null) {
                        obj = z.a((Object) socket, "impl");
                    }
                    if (obj instanceof d) {
                        ((d) obj).a(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            g.b("networkInterception:" + th);
        }
        return proceed;
    }
}
