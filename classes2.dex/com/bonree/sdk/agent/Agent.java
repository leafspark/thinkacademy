package com.bonree.sdk.agent;

import com.bonree.sdk.agent.engine.external.ClassRewriter;
import com.bonree.sdk.d.b;

@ClassRewriter(activity = true, click = true, isHap = false, version = "7.10.0", webview = true)
public class Agent {
    public static final String AGENT_VERSION = "7.10.0";
    public static String CLASSREWRITER_VERSION = "Null";
    public static String CUSTOMER = "Bonree";
    public static boolean IS_HAP = false;
    public static String PROTOCOL_VERSION = "2023041101";
    public static String RELEASE_DATE = "20230428 22:02";
    private static final Object a = new Object();
    private static b b;

    public static String getAgentVersion() {
        return AGENT_VERSION;
    }

    static b a() {
        b bVar;
        synchronized (a) {
            bVar = b;
        }
        return bVar;
    }

    public static void setImpl(b bVar) {
        synchronized (a) {
            b = bVar;
        }
    }

    public static boolean isNullAgentImpl() {
        boolean z;
        synchronized (a) {
            z = b == null;
        }
        return z;
    }

    public static String getClassRewriterVersion() {
        return CLASSREWRITER_VERSION;
    }
}
