package com.bonree.sdk.bm;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public abstract class a implements d {
    protected static final Logger a = Logger.getLogger(a.class.getName());
    private final String b;
    private final int c;

    public abstract List<String> c();

    public /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.c, ((d) obj).b());
    }

    protected a(String str, int i) {
        this.b = str;
        this.c = i;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    private static List<String> a(Collection<? extends InetAddress> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (InetAddress hostAddress : collection) {
            arrayList.add(hostAddress.getHostAddress());
        }
        return arrayList;
    }

    private int a(d dVar) {
        return Integer.compare(this.c, dVar.b());
    }
}
