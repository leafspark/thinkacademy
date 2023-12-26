package com.didi.hummer.component.input;

import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.style.HummerStyleUtils;

@Component("TextArea")
public class TextArea extends Input {
    /* access modifiers changed from: protected */
    public boolean isSingleLine() {
        return false;
    }

    public TextArea(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    @JsAttribute({"textLineClamp"})
    public void setTextLineClamp(int i) {
        this.maxLines = i;
    }

    public void resetStyle() {
        super.resetStyle();
        setTextLineClamp(0);
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        if (!str.equals(HummerStyleUtils.Hummer.TEXT_LINE_CLAMP)) {
            return super.setStyle(str, obj);
        }
        setTextLineClamp(Float.valueOf(String.valueOf(obj)).intValue());
        return true;
    }
}
