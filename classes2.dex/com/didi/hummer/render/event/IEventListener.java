package com.didi.hummer.render.event;

import com.didi.hummer.core.engine.JSCallback;

public interface IEventListener {
    void addEventListener(String str, JSCallback jSCallback);

    void clearEventListeners(String str);

    void removeEventListener(String str, JSCallback jSCallback);
}
