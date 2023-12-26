package com.idlefish.flutterboost;

import java.util.Map;

public interface EventListener {
    void onEvent(String str, Map<String, Object> map);
}
