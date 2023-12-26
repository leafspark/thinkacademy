package org.apache.httpcore.ssl;

import java.net.Socket;
import java.util.Map;

public interface PrivateKeyStrategy {
    String chooseAlias(Map<String, PrivateKeyDetails> map, Socket socket);
}
