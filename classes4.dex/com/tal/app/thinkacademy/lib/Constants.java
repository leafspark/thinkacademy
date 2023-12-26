package com.tal.app.thinkacademy.lib;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/Constants;", "", "()V", "IRC_PATH", "", "getIRC_PATH$annotations", "getIRC_PATH", "()Ljava/lang/String;", "setIRC_PATH", "(Ljava/lang/String;)V", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Constants.kt */
public final class Constants {
    public static final Constants INSTANCE = new Constants();
    private static String IRC_PATH = ("irc" + File.pathSeparator + "workspace");

    @JvmStatic
    public static /* synthetic */ void getIRC_PATH$annotations() {
    }

    private Constants() {
    }

    public static final String getIRC_PATH() {
        return IRC_PATH;
    }

    public static final void setIRC_PATH(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        IRC_PATH = str;
    }
}
