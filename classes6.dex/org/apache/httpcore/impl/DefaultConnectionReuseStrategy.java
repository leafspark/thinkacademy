package org.apache.httpcore.impl;

import org.apache.httpcore.ConnectionReuseStrategy;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.TokenIterator;
import org.apache.httpcore.message.BasicTokenIterator;

public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (java.lang.Long.parseLong(r11[0].getValue()) < 0) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean keepAlive(org.apache.httpcore.HttpResponse r10, org.apache.httpcore.protocol.HttpContext r11) {
        /*
            r9 = this;
            java.lang.String r0 = "HTTP response"
            org.apache.httpcore.util.Args.notNull(r10, r0)
            java.lang.String r0 = "HTTP context"
            org.apache.httpcore.util.Args.notNull(r11, r0)
            org.apache.httpcore.StatusLine r0 = r10.getStatusLine()
            int r0 = r0.getStatusCode()
            java.lang.String r1 = "Transfer-Encoding"
            java.lang.String r2 = "Content-Length"
            r3 = 0
            r4 = 204(0xcc, float:2.86E-43)
            if (r0 != r4) goto L_0x0033
            org.apache.httpcore.Header r0 = r10.getFirstHeader(r2)
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = r0.getValue()     // Catch:{ NumberFormatException -> 0x002c }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x002c }
            if (r0 <= 0) goto L_0x002c
            return r3
        L_0x002c:
            org.apache.httpcore.Header r0 = r10.getFirstHeader(r1)
            if (r0 == 0) goto L_0x0033
            return r3
        L_0x0033:
            java.lang.String r0 = "http.request"
            java.lang.Object r11 = r11.getAttribute(r0)
            org.apache.httpcore.HttpRequest r11 = (org.apache.httpcore.HttpRequest) r11
            java.lang.String r0 = "Close"
            java.lang.String r4 = "Connection"
            if (r11 == 0) goto L_0x005b
            org.apache.httpcore.message.BasicTokenIterator r5 = new org.apache.httpcore.message.BasicTokenIterator     // Catch:{ ParseException -> 0x005a }
            org.apache.httpcore.HeaderIterator r6 = r11.headerIterator(r4)     // Catch:{ ParseException -> 0x005a }
            r5.<init>(r6)     // Catch:{ ParseException -> 0x005a }
        L_0x004a:
            boolean r6 = r5.hasNext()     // Catch:{ ParseException -> 0x005a }
            if (r6 == 0) goto L_0x005b
            java.lang.String r6 = r5.nextToken()     // Catch:{ ParseException -> 0x005a }
            boolean r6 = r0.equalsIgnoreCase(r6)     // Catch:{ ParseException -> 0x005a }
            if (r6 == 0) goto L_0x004a
        L_0x005a:
            return r3
        L_0x005b:
            org.apache.httpcore.StatusLine r5 = r10.getStatusLine()
            org.apache.httpcore.ProtocolVersion r5 = r5.getProtocolVersion()
            org.apache.httpcore.Header r1 = r10.getFirstHeader(r1)
            r6 = 1
            if (r1 == 0) goto L_0x0077
            java.lang.String r11 = r1.getValue()
            java.lang.String r1 = "chunked"
            boolean r11 = r1.equalsIgnoreCase(r11)
            if (r11 != 0) goto L_0x0095
            return r3
        L_0x0077:
            boolean r11 = r9.canResponseHaveBody(r11, r10)
            if (r11 == 0) goto L_0x0095
            org.apache.httpcore.Header[] r11 = r10.getHeaders(r2)
            int r1 = r11.length
            if (r1 != r6) goto L_0x0094
            r11 = r11[r3]
            java.lang.String r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x0094 }
            long r1 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x0094 }
            r7 = 0
            int r11 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x0095
        L_0x0094:
            return r3
        L_0x0095:
            org.apache.httpcore.HeaderIterator r11 = r10.headerIterator(r4)
            boolean r1 = r11.hasNext()
            if (r1 != 0) goto L_0x00a5
            java.lang.String r11 = "Proxy-Connection"
            org.apache.httpcore.HeaderIterator r11 = r10.headerIterator(r11)
        L_0x00a5:
            boolean r10 = r11.hasNext()
            if (r10 == 0) goto L_0x00d0
            org.apache.httpcore.message.BasicTokenIterator r10 = new org.apache.httpcore.message.BasicTokenIterator     // Catch:{ ParseException -> 0x00cf }
            r10.<init>(r11)     // Catch:{ ParseException -> 0x00cf }
            r11 = r3
        L_0x00b1:
            boolean r1 = r10.hasNext()     // Catch:{ ParseException -> 0x00cf }
            if (r1 == 0) goto L_0x00cc
            java.lang.String r1 = r10.nextToken()     // Catch:{ ParseException -> 0x00cf }
            boolean r2 = r0.equalsIgnoreCase(r1)     // Catch:{ ParseException -> 0x00cf }
            if (r2 == 0) goto L_0x00c2
            return r3
        L_0x00c2:
            java.lang.String r2 = "Keep-Alive"
            boolean r1 = r2.equalsIgnoreCase(r1)     // Catch:{ ParseException -> 0x00cf }
            if (r1 == 0) goto L_0x00b1
            r11 = r6
            goto L_0x00b1
        L_0x00cc:
            if (r11 == 0) goto L_0x00d0
            return r6
        L_0x00cf:
            return r3
        L_0x00d0:
            org.apache.httpcore.HttpVersion r10 = org.apache.httpcore.HttpVersion.HTTP_1_0
            boolean r10 = r5.lessEquals(r10)
            r10 = r10 ^ r6
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.httpcore.impl.DefaultConnectionReuseStrategy.keepAlive(org.apache.httpcore.HttpResponse, org.apache.httpcore.protocol.HttpContext):boolean");
    }

    /* access modifiers changed from: protected */
    public TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ((httpRequest != null && httpRequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }
}
