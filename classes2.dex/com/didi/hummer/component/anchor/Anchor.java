package com.didi.hummer.component.anchor;

import com.didi.hummer.annotation.Component;
import com.didi.hummer.component.view.View;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.facebook.yoga.YogaDisplay;

@Component("Anchor")
public class Anchor extends View {
    public Anchor(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
        getYogaNode().setDisplay(YogaDisplay.NONE);
    }
}
