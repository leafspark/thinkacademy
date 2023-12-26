package com.tal.app.thinkacademy.live.core.layout;

import com.tal.app.thinkacademy.lib.utils.StickyLiveData;

public class LayoutLiveData extends StickyLiveData<LiveAreaContext> {
    public void changed() {
        postValue(LiveAreaContext.get());
    }
}
