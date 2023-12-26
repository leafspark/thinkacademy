package okhttp3.internal.platform.android;

import com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.platform.Platform;

public class KeepAdapter {

    public static class a {
        public static void a(SSLSocketFactory sSLSocketFactory) {
            try {
                Platform platform = Platform.get();
                Field declaredField = Class.forName("okhttp3.internal.platform.AndroidPlatform").getDeclaredField("socketAdapters");
                boolean z = true;
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(platform);
                if (list != null && (sSLSocketFactory instanceof BrSocketFactory)) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        SocketAdapter socketAdapter = (SocketAdapter) it.next();
                        if (socketAdapter != null && "okhttp3.internal.platform.android.BrSocketAdapter".equals(socketAdapter.getClass().getName())) {
                            break;
                        }
                    }
                    if (!z) {
                        list.add((BrSocketAdapter) Class.forName("okhttp3.internal.platform.android.BrSocketAdapter").newInstance());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
