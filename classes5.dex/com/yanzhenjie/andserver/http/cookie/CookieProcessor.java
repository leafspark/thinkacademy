package com.yanzhenjie.andserver.http.cookie;

import java.util.List;
import org.apache.httpcore.Header;

public interface CookieProcessor {
    String generateHeader(Cookie cookie);

    List<Cookie> parseCookieHeader(Header[] headerArr);
}
