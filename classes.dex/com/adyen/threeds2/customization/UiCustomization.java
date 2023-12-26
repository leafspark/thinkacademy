package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.util.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class UiCustomization {
    private final Map<ButtonType, ButtonCustomization> a = new HashMap();
    private final Map<Class<? extends Customization>, Customization> b = new HashMap();

    public enum ButtonType {
        VERIFY,
        CONTINUE,
        NEXT,
        CANCEL,
        RESEND
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.customization.UiCustomization$ButtonType[] r0 = com.adyen.threeds2.customization.UiCustomization.ButtonType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.adyen.threeds2.customization.UiCustomization$ButtonType r1 = com.adyen.threeds2.customization.UiCustomization.ButtonType.CANCEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.customization.UiCustomization$ButtonType r1 = com.adyen.threeds2.customization.UiCustomization.ButtonType.RESEND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.customization.UiCustomization.a.<clinit>():void");
        }
    }

    private ButtonCustomization a(ButtonType buttonType) {
        ButtonCustomization buttonCustomization = this.a.get(buttonType);
        if (buttonCustomization != null) {
            return buttonCustomization;
        }
        ButtonCustomization buttonCustomization2 = new ButtonCustomization();
        this.a.put(buttonType, buttonCustomization2);
        return buttonCustomization2;
    }

    public ButtonCustomization getButtonCustomization(ButtonType buttonType) throws InvalidInputException {
        Preconditions.requireNonNull("buttonType", buttonType);
        return a(buttonType);
    }

    public ExpandableInfoCustomization getExpandableInfoCustomization() {
        return (ExpandableInfoCustomization) a(ExpandableInfoCustomization.class);
    }

    public LabelCustomization getLabelCustomization() {
        return (LabelCustomization) a(LabelCustomization.class);
    }

    public ScreenCustomization getScreenCustomization() {
        return (ScreenCustomization) a(ScreenCustomization.class);
    }

    public SelectionItemCustomization getSelectionItemCustomization() {
        return (SelectionItemCustomization) a(SelectionItemCustomization.class);
    }

    public TextBoxCustomization getTextBoxCustomization() {
        return (TextBoxCustomization) a(TextBoxCustomization.class);
    }

    public ToolbarCustomization getToolbarCustomization() {
        return (ToolbarCustomization) a(ToolbarCustomization.class);
    }

    public void setBorderColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((TextBoxCustomization) a(TextBoxCustomization.class)).setBorderColor(str);
        ((SelectionItemCustomization) a(SelectionItemCustomization.class)).setBorderColor(str);
        ((ExpandableInfoCustomization) a(ExpandableInfoCustomization.class)).setBorderColor(str);
    }

    public void setButtonCustomization(ButtonCustomization buttonCustomization, ButtonType buttonType) throws InvalidInputException {
        Preconditions.requireNonNull("buttonType", buttonType);
        this.a.put(buttonType, buttonCustomization);
    }

    public void setExpandableInfoCustomization(ExpandableInfoCustomization expandableInfoCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("expandableInfoCustomization", expandableInfoCustomization);
        this.b.put(ExpandableInfoCustomization.class, expandableInfoCustomization);
    }

    public void setHighlightedBackgroundColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((SelectionItemCustomization) a(SelectionItemCustomization.class)).setHighlightedBackgroundColor(str);
        ((ExpandableInfoCustomization) a(ExpandableInfoCustomization.class)).setHighlightedBackgroundColor(str);
        for (ButtonType a2 : Arrays.asList(new ButtonType[]{ButtonType.CANCEL, ButtonType.RESEND})) {
            a(a2).setBackgroundColor(str);
        }
    }

    public void setLabelCustomization(LabelCustomization labelCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("labelCustomization", labelCustomization);
        this.b.put(LabelCustomization.class, labelCustomization);
    }

    public void setScreenBackgroundColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ScreenCustomization) a(ScreenCustomization.class)).setBackgroundColor(str);
    }

    public void setScreenCustomization(ScreenCustomization screenCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("screenCustomization", screenCustomization);
        this.b.put(ScreenCustomization.class, screenCustomization);
    }

    public void setSelectionItemCustomization(SelectionItemCustomization selectionItemCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("selectionItemCustomization", selectionItemCustomization);
        this.b.put(SelectionItemCustomization.class, selectionItemCustomization);
    }

    public void setStatusBarColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ScreenCustomization) a(ScreenCustomization.class)).setStatusBarColor(str);
    }

    public void setTextBoxCustomization(TextBoxCustomization textBoxCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("textBoxCustomization", textBoxCustomization);
        this.b.put(TextBoxCustomization.class, textBoxCustomization);
    }

    public void setTextColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ScreenCustomization) a(ScreenCustomization.class)).setTextColor(str);
        ((ToolbarCustomization) a(ToolbarCustomization.class)).setTextColor(str);
        a(ButtonType.CANCEL).setTextColor(str);
        LabelCustomization labelCustomization = (LabelCustomization) a(LabelCustomization.class);
        labelCustomization.setTextColor(str);
        labelCustomization.setHeadingTextColor(str);
        labelCustomization.setInputLabelTextColor(str);
        ((TextBoxCustomization) a(TextBoxCustomization.class)).setTextColor(str);
        ((SelectionItemCustomization) a(SelectionItemCustomization.class)).setTextColor(str);
        ExpandableInfoCustomization expandableInfoCustomization = (ExpandableInfoCustomization) a(ExpandableInfoCustomization.class);
        expandableInfoCustomization.setTextColor(str);
        expandableInfoCustomization.setHeadingTextColor(str);
        expandableInfoCustomization.setExpandStateIndicatorColor(str);
    }

    public void setTintColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ToolbarCustomization) a(ToolbarCustomization.class)).setBackgroundColor(str);
        ((SelectionItemCustomization) a(SelectionItemCustomization.class)).setSelectionIndicatorTintColor(str);
        for (ButtonType buttonType : ButtonType.values()) {
            ButtonCustomization a2 = a(buttonType);
            int i = a.a[buttonType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    a2.setBackgroundColor(str);
                } else {
                    a2.setTextColor(str);
                }
            }
        }
    }

    public void setToolbarCustomization(ToolbarCustomization toolbarCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("toolbarCustomization", toolbarCustomization);
        this.b.put(ToolbarCustomization.class, toolbarCustomization);
    }

    public void setToolbarTitle(String str) {
        Preconditions.requireNonEmpty("title", str);
        ((ToolbarCustomization) a(ToolbarCustomization.class)).setHeaderText(str);
    }

    private <T extends Customization> T a(Class<T> cls) {
        T t = (Customization) this.b.get(cls);
        if (t != null) {
            return t;
        }
        try {
            T t2 = (Customization) cls.newInstance();
            this.b.put(cls, t2);
            return t2;
        } catch (InstantiationException e) {
            throw new RuntimeException("Could not instantiate " + cls.getSimpleName(), e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Could not access constructor of " + cls.getSimpleName(), e2);
        }
    }
}
