package com.didi.hummer.component.input;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.text.FontManager;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.event.view.InputEvent;
import com.didi.hummer.render.style.HummerNode;
import com.didi.hummer.render.style.HummerStyleUtils;

@Component("Input")
public class Input extends HMBase<EditText> {
    @JsProperty("focused")
    private boolean focused;
    private TextView.OnEditorActionListener mOnEditorActionListener = new Input$$ExternalSyntheticLambda2(this);
    private View.OnFocusChangeListener mOnFocusChangeListener = new Input$$ExternalSyntheticLambda0(this);
    private View.OnKeyListener mOnKeyListener = new Input$$ExternalSyntheticLambda1(this);
    protected final HMInputProperty mProperty = new HMInputProperty((EditText) getView(), isSingleLine());
    private TextWatcher mTextWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            String str;
            int lineCount = ((EditText) Input.this.getView()).getLineCount();
            if (Input.this.maxLines <= 0 || lineCount <= Input.this.maxLines) {
                InputEvent inputEvent = new InputEvent();
                inputEvent.setType(InputEvent.HM_EVENT_TYPE_INPUT);
                inputEvent.setText(editable.toString());
                inputEvent.setState(2);
                inputEvent.setTimestamp(System.currentTimeMillis());
                Input.this.mEventManager.dispatchEvent(InputEvent.HM_EVENT_TYPE_INPUT, inputEvent);
                Input.this.requestLayout();
                return;
            }
            String obj = editable.toString();
            int selectionStart = ((EditText) Input.this.getView()).getSelectionStart();
            if (selectionStart != ((EditText) Input.this.getView()).getSelectionEnd() || selectionStart >= obj.length() || selectionStart < 1) {
                str = obj.substring(0, editable.length() - 1);
            } else {
                str = obj.substring(0, selectionStart - 1) + obj.substring(selectionStart);
            }
            ((EditText) Input.this.getView()).removeTextChangedListener(this);
            ((EditText) Input.this.getView()).setText(str);
            ((EditText) Input.this.getView()).addTextChangedListener(this);
            ((EditText) Input.this.getView()).setSelection(((EditText) Input.this.getView()).getText().length());
        }
    };
    protected int maxLines = 0;
    private ColorStateList orgHintColors;
    private ColorStateList orgTextColors;
    private float orgTextSize;
    private Typeface orgTypeface;
    @JsProperty("placeholder")
    private String placeholder;
    @JsProperty("text")
    private String text;

    /* access modifiers changed from: protected */
    public boolean isSingleLine() {
        return true;
    }

    public Input(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    public void onCreate() {
        super.onCreate();
        this.orgTextColors = ((EditText) getView()).getTextColors();
        this.orgHintColors = ((EditText) getView()).getHintTextColors();
        this.orgTextSize = ((EditText) getView()).getTextSize();
        setFontFamily(FontManager.DEFAULT_FONT_FAMILY);
        this.orgTypeface = ((EditText) getView()).getTypeface();
        ((EditText) getView()).setBackgroundColor(0);
        ((EditText) getView()).setImeOptions(6);
        ((EditText) getView()).addTextChangedListener(this.mTextWatcher);
        ((EditText) getView()).setOnFocusChangeListener(this.mOnFocusChangeListener);
        ((EditText) getView()).setOnEditorActionListener(this.mOnEditorActionListener);
        ((EditText) getView()).setOnKeyListener(this.mOnKeyListener);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ((EditText) getView()).setFocusable(z);
        ((EditText) getView()).setFocusableInTouchMode(z);
    }

    public /* synthetic */ void lambda$new$0$Input(View view, boolean z) {
        if (z) {
            InputEvent inputEvent = new InputEvent();
            inputEvent.setType(InputEvent.HM_EVENT_TYPE_INPUT);
            inputEvent.setText(((EditText) getView()).getText().toString());
            inputEvent.setState(1);
            inputEvent.setTimestamp(System.currentTimeMillis());
            this.mEventManager.dispatchEvent(InputEvent.HM_EVENT_TYPE_INPUT, inputEvent);
            return;
        }
        InputEvent inputEvent2 = new InputEvent();
        inputEvent2.setType(InputEvent.HM_EVENT_TYPE_INPUT);
        inputEvent2.setText(((EditText) getView()).getText().toString());
        inputEvent2.setState(3);
        inputEvent2.setTimestamp(System.currentTimeMillis());
        this.mEventManager.dispatchEvent(InputEvent.HM_EVENT_TYPE_INPUT, inputEvent2);
    }

    public /* synthetic */ boolean lambda$new$1$Input(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || keyEvent.getAction() != 0 || getView() == null || !TextUtils.isEmpty(((EditText) getView()).getText())) {
            return false;
        }
        InputEvent inputEvent = new InputEvent();
        inputEvent.setType(InputEvent.HM_EVENT_TYPE_INPUT);
        inputEvent.setText("");
        inputEvent.setState(2);
        inputEvent.setTimestamp(System.currentTimeMillis());
        this.mEventManager.dispatchEvent(InputEvent.HM_EVENT_TYPE_INPUT, inputEvent);
        return false;
    }

    public /* synthetic */ boolean lambda$new$2$Input(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
            if (i != 5) {
                if (i != 6) {
                    z = true;
                } else {
                    setFocused(false);
                }
            }
            InputEvent inputEvent = new InputEvent();
            inputEvent.setType(InputEvent.HM_EVENT_TYPE_INPUT);
            inputEvent.setText(((EditText) getView()).getText().toString());
            inputEvent.setState(4);
            inputEvent.setTimestamp(System.currentTimeMillis());
            this.mEventManager.dispatchEvent(InputEvent.HM_EVENT_TYPE_INPUT, inputEvent);
        }
        return z;
    }

    public void onDestroy() {
        super.onDestroy();
        ((EditText) getView()).removeTextChangedListener(this.mTextWatcher);
        ((EditText) getView()).setOnKeyListener((View.OnKeyListener) null);
    }

    /* access modifiers changed from: protected */
    public EditText createViewInstance(Context context) {
        return new EditText(context);
    }

    /* access modifiers changed from: private */
    public void requestLayout() {
        getYogaNode().dirty();
        ((EditText) getView()).requestLayout();
    }

    public void setText(String str) {
        this.mProperty.setText(str);
        requestLayout();
    }

    public String getText() {
        return this.mProperty.getText();
    }

    public void setPlaceholder(String str) {
        this.mProperty.setPlaceholder(str);
        requestLayout();
    }

    public void setFocused(boolean z) {
        if (!((EditText) getView()).isFocused() || !z) {
            this.mProperty.setFocused(z);
        }
    }

    public boolean getFocused() {
        return ((EditText) getView()).isFocused();
    }

    @JsAttribute({"type"})
    public void setType(String str) {
        this.mProperty.setType(str);
    }

    @JsAttribute({"color"})
    public void setColor(int i) {
        this.mProperty.setTextColor(i);
    }

    @JsAttribute({"placeholderColor"})
    public void setPlaceholderColor(int i) {
        this.mProperty.setPlaceholderColor(i);
    }

    @JsAttribute({"cursorColor"})
    public void setCursorColor(int i) {
        this.mProperty.setCursorColor(i);
    }

    @JsAttribute({"textAlign"})
    public void setTextAlign(String str) {
        this.mProperty.setTextAlign(str);
    }

    @JsAttribute({"fontFamily"})
    public void setFontFamily(String str) {
        this.mProperty.setFontFamily(getContext(), str);
        requestLayout();
    }

    @JsAttribute({"fontSize"})
    public void setFontSize(float f) {
        this.mProperty.setFontSize(f);
        requestLayout();
    }

    @JsAttribute({"placeholderFontSize"})
    @Deprecated
    public void setPlaceholderFontSize(float f) {
        this.mProperty.setPlaceholderFontSize(f);
        requestLayout();
    }

    @JsAttribute({"maxLength"})
    public void setMaxLength(int i) {
        this.mProperty.setMaxLength(i);
    }

    @JsAttribute({"returnKeyType"})
    public void setReturnKeyType(String str) {
        this.mProperty.setReturnKeyType(str);
    }

    public HummerNode getNode() {
        HummerNode node = super.getNode();
        node.setContent(String.valueOf(((EditText) getView()).getText()));
        return node;
    }

    public void resetStyle() {
        super.resetStyle();
        ((EditText) getView()).setBackgroundColor(0);
        ((EditText) getView()).setTextColor(this.orgTextColors);
        ((EditText) getView()).setHintTextColor(this.orgHintColors);
        ((EditText) getView()).setTextSize(0, this.orgTextSize);
        ((EditText) getView()).setTypeface(this.orgTypeface);
        setType(NJInputType.DEFAULT);
        setReturnKeyType(NJReturnKeyType.DONE);
        setTextAlign(NJTextAlign.LEFT);
        this.mProperty.resetCursorColor();
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1595747923:
                if (str.equals(HummerStyleUtils.Hummer.CURSOR_COLOR)) {
                    c = 0;
                    break;
                }
                break;
            case -1576785488:
                if (str.equals(HummerStyleUtils.Hummer.PLACEHOLDER_COLOR)) {
                    c = 1;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals(HummerStyleUtils.Hummer.FONT_FAMILY)) {
                    c = 2;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals(HummerStyleUtils.Hummer.TEXT_ALIGN)) {
                    c = 3;
                    break;
                }
                break;
            case -791400086:
                if (str.equals(HummerStyleUtils.Hummer.MAX_LENGTH)) {
                    c = 4;
                    break;
                }
                break;
            case 3575610:
                if (str.equals(HummerStyleUtils.Hummer.TYPE)) {
                    c = 5;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 6;
                    break;
                }
                break;
            case 365601008:
                if (str.equals(HummerStyleUtils.Hummer.FONT_SIZE)) {
                    c = 7;
                    break;
                }
                break;
            case 947486441:
                if (str.equals(HummerStyleUtils.Hummer.RETURN_KEY_TYPE)) {
                    c = 8;
                    break;
                }
                break;
            case 1035364227:
                if (str.equals(HummerStyleUtils.Hummer.PLACEHOLDER_FONT_SIZE)) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setCursorColor(((Integer) obj).intValue());
                break;
            case 1:
                setPlaceholderColor(((Integer) obj).intValue());
                break;
            case 2:
                setFontFamily(String.valueOf(obj));
                break;
            case 3:
                setTextAlign(String.valueOf(obj));
                break;
            case 4:
                setMaxLength((int) ((Float) obj).floatValue());
                break;
            case 5:
                setType(String.valueOf(obj));
                break;
            case 6:
                setColor(((Integer) obj).intValue());
                break;
            case 7:
                setFontSize(((Float) obj).floatValue());
                break;
            case 8:
                setReturnKeyType(String.valueOf(obj));
                break;
            case 9:
                setPlaceholderFontSize(((Float) obj).floatValue());
                break;
            default:
                return false;
        }
        return true;
    }
}
