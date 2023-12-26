package com.bonree.sdk.bs;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;

final class af implements Runnable {
    private /* synthetic */ InputStream a;

    af(InputStream inputStream) {
        this.a = inputStream;
    }

    public final void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                } else {
                    ad.a((Closeable) bufferedReader);
                    return;
                }
            } catch (Throwable unused) {
                ad.a((Closeable) bufferedReader);
                return;
            }
        }
    }
}
