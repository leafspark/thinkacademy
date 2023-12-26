package com.tal.app.thinkacademy.common.business.browser.dispatch;

import java.util.Map;

public interface IDispatcher {
    void dispatch(JsInjection jsInjection, String str, Map<String, Object> map);
}
