package com.didi.hummer.component.switchview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.event.view.SwitchEvent;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

@Component("Switch")
public class Switch extends HMBase<android.widget.Switch> implements CompoundButton.OnCheckedChangeListener {
    @JsProperty("checked")
    private boolean checked;
    private Integer mOffTrackColor;
    private Integer mOnTrackColor;

    public Switch(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    public void onCreate() {
        super.onCreate();
        ((android.widget.Switch) getView()).setOnCheckedChangeListener(this);
    }

    public void onDestroy() {
        super.onDestroy();
        ((android.widget.Switch) getView()).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
    }

    /* access modifiers changed from: protected */
    public android.widget.Switch createViewInstance(Context context) {
        return new android.widget.Switch(context);
    }

    public void setChecked(boolean z) {
        doChecked(z);
        getNode().setContent(z ? "Yes" : "No");
    }

    @JsAttribute({"onColor"})
    public void setOnColor(int i) {
        this.mOnTrackColor = Integer.valueOf(i);
        if (((android.widget.Switch) getView()).isChecked()) {
            setTrackColor(Integer.valueOf(i));
        }
    }

    @JsAttribute({"offColor"})
    public void setOffColor(int i) {
        this.mOffTrackColor = Integer.valueOf(i);
        if (!((android.widget.Switch) getView()).isChecked()) {
            setTrackColor(Integer.valueOf(i));
        }
    }

    @JsAttribute({"thumbColor"})
    public void setThumbColor(int i) {
        setColor(((android.widget.Switch) getView()).getThumbDrawable(), Integer.valueOf(i));
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.checked = z;
        setTrackColor(z);
        SwitchEvent switchEvent = new SwitchEvent();
        switchEvent.setType(SwitchEvent.HM_EVENT_TYPE_SWITCH);
        switchEvent.setTimestamp(System.currentTimeMillis());
        switchEvent.setState(z);
        this.mEventManager.dispatchEvent(SwitchEvent.HM_EVENT_TYPE_SWITCH, switchEvent);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public void doChecked(boolean z) {
        if (((android.widget.Switch) getView()).isChecked() != z) {
            ((android.widget.Switch) getView()).setChecked(z);
            setTrackColor(z);
        }
    }

    private void setColor(Drawable drawable, Integer num) {
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
        }
    }

    private void setTrackColor(boolean z) {
        setTrackColor(z ? this.mOnTrackColor : this.mOffTrackColor);
    }

    private void setTrackColor(Integer num) {
        setColor(((android.widget.Switch) getView()).getTrackDrawable(), num);
    }

    public void resetStyle() {
        super.resetStyle();
        this.mOnTrackColor = null;
        this.mOffTrackColor = null;
        ((android.widget.Switch) getView()).getTrackDrawable().clearColorFilter();
        ((android.widget.Switch) getView()).getThumbDrawable().clearColorFilter();
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1742453971:
                if (str.equals(HummerStyleUtils.Hummer.THUMB_COLOR)) {
                    c = 0;
                    break;
                }
                break;
            case -1351809852:
                if (str.equals(HummerStyleUtils.Hummer.ON_COLOR)) {
                    c = 1;
                    break;
                }
                break;
            case -800022732:
                if (str.equals(HummerStyleUtils.Hummer.OFF_COLOR)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setThumbColor(((Integer) obj).intValue());
                break;
            case 1:
                setOnColor(((Integer) obj).intValue());
                break;
            case 2:
                setOffColor(((Integer) obj).intValue());
                break;
            default:
                return false;
        }
        return true;
    }
}
