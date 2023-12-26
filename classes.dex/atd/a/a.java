package atd.a;

import atd.a.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class a {
    static final int b = ((int) TimeUnit.SECONDS.toMillis(60));
    static final int c = ((int) TimeUnit.SECONDS.toMillis(60));
    private final b a = new g();

    private HttpURLConnection b(i iVar) throws IOException {
        HttpURLConnection a2 = this.a.a(iVar.d());
        a2.setRequestMethod(iVar.c().a());
        a2.setConnectTimeout(a());
        a2.setReadTimeout(b());
        a2.setUseCaches(false);
        a2.setDoInput(true);
        a2.setDoOutput(iVar.c().b());
        Map<String, List<String>> b2 = iVar.b();
        if (b2 != null) {
            for (Map.Entry next : b2.entrySet()) {
                String str = (String) next.getKey();
                for (String addRequestProperty : (List) next.getValue()) {
                    a2.addRequestProperty(str, addRequestProperty);
                }
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public atd.a.j a(atd.a.i r3) throws java.io.IOException {
        /*
            r2 = this;
            java.net.HttpURLConnection r0 = r2.b(r3)     // Catch:{ all -> 0x002e }
            r0.connect()     // Catch:{ all -> 0x002c }
            atd.a.f r1 = r3.c()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.b()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0022
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ all -> 0x002c }
            byte[] r3 = r3.a()     // Catch:{ all -> 0x002c }
            r1.write(r3)     // Catch:{ all -> 0x002c }
            r1.flush()     // Catch:{ all -> 0x002c }
            r1.close()     // Catch:{ all -> 0x002c }
        L_0x0022:
            atd.a.j r3 = r2.a((java.net.HttpURLConnection) r0)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x002b
            r0.disconnect()
        L_0x002b:
            return r3
        L_0x002c:
            r3 = move-exception
            goto L_0x0030
        L_0x002e:
            r3 = move-exception
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.disconnect()
        L_0x0035:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atd.a.a.a(atd.a.i):atd.a.j");
    }

    /* access modifiers changed from: protected */
    public abstract int b();

    private j a(HttpURLConnection httpURLConnection) throws IOException {
        j.a a2 = new j.a().a(httpURLConnection.getResponseCode()).a((Map<String, List<String>>) httpURLConnection.getHeaderFields()).a(httpURLConnection.getResponseMessage());
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            errorStream = httpURLConnection.getInputStream();
        }
        a2.a(a(errorStream));
        return a2.a();
    }

    private byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr);
        while (read > 0) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
