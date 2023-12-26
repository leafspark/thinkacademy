package com.adyen.threeds2;

public interface ChallengeStatusReceiver {
    void cancelled();

    void completed(CompletionEvent completionEvent);

    void protocolError(ProtocolErrorEvent protocolErrorEvent);

    void runtimeError(RuntimeErrorEvent runtimeErrorEvent);

    void timedout();
}
