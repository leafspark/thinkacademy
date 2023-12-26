package com.didi.hummer.core.engine;

import com.didi.hummer.core.engine.base.IObjectOperator;
import com.didi.hummer.core.engine.base.IValueOperator;
import com.didi.hummer.core.engine.base.JSIdentify;
import com.didi.hummer.core.engine.base.JSReleasable;

public interface JSValue extends IValueOperator, IObjectOperator, JSReleasable, JSIdentify {
    JSContext getJSContext();

    boolean isValid();
}
