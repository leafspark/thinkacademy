package com.yanzhenjie.andserver.http.session;

import java.io.IOException;

public interface SessionManager {
    void add(Session session) throws IOException;

    void changeSessionId(Session session);

    Session createSession();

    Session findSession(String str) throws IOException, ClassNotFoundException;

    void remove(Session session);
}
