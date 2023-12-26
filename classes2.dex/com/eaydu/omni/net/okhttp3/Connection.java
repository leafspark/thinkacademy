package com.eaydu.omni.net.okhttp3;

import java.net.Socket;

public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
