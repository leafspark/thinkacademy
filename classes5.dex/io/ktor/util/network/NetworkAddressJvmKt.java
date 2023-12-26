package io.ktor.util.network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0019\u0010\u0006\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\t*\n\u0010\n\"\u00020\u00022\u00020\u0002*\n\u0010\u000b\"\u00020\f2\u00020\f¨\u0006\r"}, d2 = {"hostname", "", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "getHostname", "(Ljava/net/SocketAddress;)Ljava/lang/String;", "port", "", "getPort", "(Ljava/net/SocketAddress;)I", "NetworkAddress", "UnresolvedAddressException", "Ljava/nio/channels/UnresolvedAddressException;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkAddressJvm.kt */
public final class NetworkAddressJvmKt {
    public static final String getHostname(SocketAddress socketAddress) {
        InetAddress address;
        String hostName;
        Intrinsics.checkNotNullParameter(socketAddress, "<this>");
        boolean z = socketAddress instanceof InetSocketAddress;
        String str = null;
        InetSocketAddress inetSocketAddress = z ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null && (hostName = inetSocketAddress.getHostName()) != null) {
            return hostName;
        }
        InetSocketAddress inetSocketAddress2 = z ? (InetSocketAddress) socketAddress : null;
        if (!(inetSocketAddress2 == null || (address = inetSocketAddress2.getAddress()) == null)) {
            str = address.getHostName();
        }
        return str == null ? "" : str;
    }

    public static final int getPort(SocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(socketAddress, "<this>");
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null) {
            return inetSocketAddress.getPort();
        }
        return 0;
    }

    public static final SocketAddress NetworkAddress(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        return new InetSocketAddress(str, i);
    }
}
