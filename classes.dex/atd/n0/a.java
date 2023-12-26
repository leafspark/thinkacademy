package atd.n0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.adyen.threeds2.R;
import com.adyen.threeds2.customization.ButtonCustomization;
import com.adyen.threeds2.customization.Customization;
import com.adyen.threeds2.customization.ExpandableInfoCustomization;
import com.adyen.threeds2.customization.LabelCustomization;
import com.adyen.threeds2.customization.ScreenCustomization;
import com.adyen.threeds2.customization.SelectionItemCustomization;
import com.adyen.threeds2.customization.TextBoxCustomization;
import com.adyen.threeds2.customization.ToolbarCustomization;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.internal.ui.widget.DividerView;
import com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView;
import com.adyen.threeds2.internal.ui.widget.ToolbarView;

public final class a {
    private final UiCustomization a;

    /* renamed from: atd.n0.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0004a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.internal.ui.widget.DividerView$b[] r0 = com.adyen.threeds2.internal.ui.widget.DividerView.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.ui.widget.DividerView.b.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.ui.widget.DividerView.b.VERTICAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.n0.a.C0004a.<clinit>():void");
        }
    }

    public a(UiCustomization uiCustomization) {
        this.a = uiCustomization;
    }

    private void b(Button button, ButtonCustomization buttonCustomization) {
        if (buttonCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(buttonCustomization.getBackgroundColor());
            if (parseHexColorCode != null) {
                a(button.getBackground(), parseHexColorCode, true);
            }
            a(button, buttonCustomization);
        }
    }

    private void c(Button button, ButtonCustomization buttonCustomization) {
        if (buttonCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(buttonCustomization.getBackgroundColor());
            if (parseHexColorCode != null) {
                a(button.getBackground(), parseHexColorCode);
            }
            a(button, buttonCustomization);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Window window) {
        ScreenCustomization screenCustomization;
        Integer parseHexColorCode;
        UiCustomization uiCustomization = this.a;
        if (uiCustomization != null && (screenCustomization = uiCustomization.getScreenCustomization()) != null) {
            Integer parseHexColorCode2 = Customization.parseHexColorCode(screenCustomization.getBackgroundColor());
            if (parseHexColorCode2 != null) {
                ColorDrawable colorDrawable = new ColorDrawable(parseHexColorCode2.intValue());
                if (Build.VERSION.SDK_INT >= 21) {
                    colorDrawable.setTint(parseHexColorCode2.intValue());
                }
                window.setBackgroundDrawable(colorDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21 && (parseHexColorCode = Customization.parseHexColorCode(screenCustomization.getStatusBarColor())) != null) {
                window.setStatusBarColor(parseHexColorCode.intValue());
            }
        }
    }

    private void b(Drawable drawable, Integer num) {
        if (drawable != null && num != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (drawable instanceof InsetDrawable) {
                    b(((InsetDrawable) drawable).getDrawable(), num);
                } else if (drawable instanceof StateListDrawable) {
                    DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                    if (drawableContainerState != null) {
                        for (int i = 0; i < drawableContainerState.getChildren().length; i++) {
                            b(drawableContainerState.getChild(i), num);
                        }
                    }
                } else if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius((float) num.intValue());
                }
            }
            if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable)) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable;
                b(rippleDrawable.getNumberOfLayers() > 0 ? rippleDrawable.getDrawable(0) : null, num);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, AttributeSet attributeSet) {
        if (this.a != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            if (view instanceof ProgressBar) {
                a((ProgressBar) view, styleAttribute);
            } else if (view instanceof CompoundButton) {
                a((CompoundButton) view);
            } else if (view instanceof Button) {
                a((Button) view, styleAttribute);
            } else if (view instanceof EditText) {
                a((EditText) view);
            } else if (view instanceof TextView) {
                a((TextView) view, styleAttribute);
            } else if (view instanceof ToolbarView) {
                a((ToolbarView) view);
            } else if (view instanceof ExpandableInfoTextView) {
                a((ExpandableInfoTextView) view);
            } else if (view instanceof DividerView) {
                a((DividerView) view);
            } else if (view instanceof ViewGroup) {
                a(view, styleAttribute);
            }
        }
    }

    private void a(ProgressBar progressBar, int i) {
        ToolbarCustomization toolbarCustomization;
        Integer parseHexColorCode;
        if (i == R.style.Widget_ThreeDS2_ProgressBar && (toolbarCustomization = this.a.getToolbarCustomization()) != null && (parseHexColorCode = Customization.parseHexColorCode(toolbarCustomization.getBackgroundColor())) != null) {
            a(progressBar.getIndeterminateDrawable(), parseHexColorCode);
        }
    }

    private void a(CompoundButton compoundButton) {
        Integer parseHexColorCode;
        SelectionItemCustomization selectionItemCustomization = this.a.getSelectionItemCustomization();
        if (selectionItemCustomization != null && Build.VERSION.SDK_INT >= 21 && (parseHexColorCode = Customization.parseHexColorCode(selectionItemCustomization.getSelectionIndicatorTintColor())) != null) {
            compoundButton.setButtonTintList(ColorStateList.valueOf(parseHexColorCode.intValue()));
        }
    }

    private void a(Button button, int i) {
        if (i == R.style.Widget_ThreeDS2_Button_Borderless_Cancel) {
            b(button, this.a.getButtonCustomization(UiCustomization.ButtonType.CANCEL));
        } else if (i == R.style.Widget_ThreeDS2_Button_Borderless_Resend) {
            b(button, this.a.getButtonCustomization(UiCustomization.ButtonType.RESEND));
        } else if (i == R.style.Widget_ThreeDS2_Button_Colored_Verify) {
            c(button, this.a.getButtonCustomization(UiCustomization.ButtonType.VERIFY));
        } else if (i == R.style.Widget_ThreeDS2_Button_Colored_Continue) {
            c(button, this.a.getButtonCustomization(UiCustomization.ButtonType.CONTINUE));
        } else if (i == R.style.Widget_ThreeDS2_Button_Colored_Next) {
            c(button, this.a.getButtonCustomization(UiCustomization.ButtonType.NEXT));
        }
    }

    private void a(Button button, ButtonCustomization buttonCustomization) {
        int cornerRadius = buttonCustomization.getCornerRadius();
        if (cornerRadius >= 0) {
            b(button.getBackground(), Integer.valueOf(cornerRadius));
        }
        a((TextView) button, (Customization) buttonCustomization);
    }

    private void a(EditText editText) {
        TextBoxCustomization textBoxCustomization = this.a.getTextBoxCustomization();
        if (textBoxCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(textBoxCustomization.getBorderColor());
            if (parseHexColorCode != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    editText.setBackgroundTintList(ColorStateList.valueOf(parseHexColorCode.intValue()));
                } else {
                    a(editText.getBackground(), parseHexColorCode);
                }
            }
            a((TextView) editText, (Customization) textBoxCustomization);
        }
    }

    private void a(TextView textView, int i) {
        if (i == R.style.TextAppearance_ThreeDS2_Widget_Toolbar_Title) {
            a(textView, (Customization) this.a.getToolbarCustomization());
        } else if (i == R.style.TextAppearance_ThreeDS2_Heading) {
            LabelCustomization labelCustomization = this.a.getLabelCustomization();
            a(textView, labelCustomization.getHeadingTextColor(), labelCustomization.getHeadingTextFontName(), labelCustomization.getHeadingTextFontSize());
        } else if (i == R.style.TextAppearance_ThreeDS2_InputLabel) {
            LabelCustomization labelCustomization2 = this.a.getLabelCustomization();
            a(textView, labelCustomization2.getInputLabelTextColor(), labelCustomization2.getInputLabelTextFontName(), labelCustomization2.getInputLabelTextFontSize());
        } else if (i == R.style.TextAppearance_ThreeDS2_SelectItem_Title) {
            a(textView, (Customization) this.a.getSelectionItemCustomization());
        } else if (i == R.style.TextAppearance_ThreeDS2_Widget_ExpandableInfoText_Title) {
            ExpandableInfoCustomization expandableInfoCustomization = this.a.getExpandableInfoCustomization();
            a(textView, expandableInfoCustomization.getHeadingTextColor(), expandableInfoCustomization.getHeadingTextFontName(), expandableInfoCustomization.getHeadingTextFontSize());
        } else if (i == R.style.TextAppearance_ThreeDS2_Widget_ExpandableInfoText_Info) {
            a(textView, (Customization) this.a.getExpandableInfoCustomization());
        } else {
            a(textView, (Customization) this.a.getLabelCustomization());
        }
    }

    private void a(TextView textView, Customization customization) {
        if (customization != null) {
            a(textView, customization.getTextColor(), customization.getTextFontName(), customization.getTextFontSize());
        }
    }

    private void a(TextView textView, String str, String str2, int i) {
        Integer parseHexColorCode = Customization.parseHexColorCode(str);
        if (parseHexColorCode != null) {
            textView.setTextColor(parseHexColorCode.intValue());
        }
        Typeface parseTypeface = Customization.parseTypeface(textView.getContext(), str2);
        if (parseTypeface != null) {
            textView.setTypeface(parseTypeface);
        }
        if (i > 0) {
            textView.setTextSize((float) i);
        }
    }

    private void a(ToolbarView toolbarView) {
        ToolbarCustomization toolbarCustomization = this.a.getToolbarCustomization();
        if (toolbarCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(toolbarCustomization.getBackgroundColor());
            if (parseHexColorCode != null) {
                toolbarView.setBackgroundColor(parseHexColorCode.intValue());
            }
            String headerText = toolbarCustomization.getHeaderText();
            if (!TextUtils.isEmpty(headerText)) {
                toolbarView.setTitle(headerText);
            }
            String buttonText = toolbarCustomization.getButtonText();
            if (!TextUtils.isEmpty(buttonText)) {
                toolbarView.setCancelButtonText(buttonText);
            }
            Integer parseHexColorCode2 = Customization.parseHexColorCode(toolbarCustomization.getTextColor());
            if (parseHexColorCode2 != null) {
                toolbarView.setTitleTextColor(parseHexColorCode2.intValue());
                toolbarView.setCancelButtonTextColor(parseHexColorCode2.intValue());
            }
            Typeface parseTypeface = Customization.parseTypeface(toolbarView.getContext(), toolbarCustomization.getTextFontName());
            if (parseTypeface != null) {
                toolbarView.setTitleTypeface(parseTypeface);
                toolbarView.setCancelButtonTextTypeface(parseTypeface);
            }
            int textFontSize = toolbarCustomization.getTextFontSize();
            if (textFontSize > 0) {
                toolbarView.setTitleFontSize(Integer.valueOf(textFontSize));
            }
        }
    }

    private void a(ExpandableInfoTextView expandableInfoTextView) {
        ExpandableInfoCustomization expandableInfoCustomization = this.a.getExpandableInfoCustomization();
        if (expandableInfoCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(expandableInfoCustomization.getHighlightedBackgroundColor());
            if (parseHexColorCode != null) {
                expandableInfoTextView.setHeaderBackgroundColor(parseHexColorCode.intValue());
            }
            Integer parseHexColorCode2 = Customization.parseHexColorCode(expandableInfoCustomization.getExpandedStateIndicatorColor());
            if (parseHexColorCode2 != null) {
                expandableInfoTextView.setStateIndicatorColor(parseHexColorCode2.intValue());
            }
        }
    }

    private void a(View view, int i) {
        SelectionItemCustomization selectionItemCustomization;
        Integer parseHexColorCode;
        if (i == R.style.Widget_ThreeDS2_SelectItem && (selectionItemCustomization = this.a.getSelectionItemCustomization()) != null && (parseHexColorCode = Customization.parseHexColorCode(selectionItemCustomization.getHighlightedBackgroundColor())) != null) {
            a(view.getBackground(), parseHexColorCode, true);
        }
    }

    private void a(DividerView dividerView) {
        ExpandableInfoCustomization expandableInfoCustomization;
        int id = dividerView.getId();
        if (id == R.id.dividerView_info) {
            ExpandableInfoCustomization expandableInfoCustomization2 = this.a.getExpandableInfoCustomization();
            if (expandableInfoCustomization2 != null) {
                a(dividerView, expandableInfoCustomization2.getBorderColor(), expandableInfoCustomization2.getBorderWidth());
            }
        } else if (id == R.id.dividerView_select) {
            SelectionItemCustomization selectionItemCustomization = this.a.getSelectionItemCustomization();
            if (selectionItemCustomization != null) {
                a(dividerView, selectionItemCustomization.getBorderColor(), selectionItemCustomization.getBorderWidth());
            }
        } else if (id == R.id.dividerView_logos && (expandableInfoCustomization = this.a.getExpandableInfoCustomization()) != null) {
            a(dividerView, expandableInfoCustomization.getBorderColor(), expandableInfoCustomization.getBorderWidth());
        }
    }

    private void a(DividerView dividerView, String str, int i) {
        Integer parseHexColorCode = Customization.parseHexColorCode(str);
        if (parseHexColorCode != null) {
            dividerView.setColor(parseHexColorCode.intValue());
        }
        if (i >= 0) {
            int i2 = C0004a.a[dividerView.getOrientation().ordinal()];
            if (i2 == 1) {
                dividerView.setThickness(i);
            } else if (i2 == 2) {
                dividerView.setThickness(i);
            }
        }
    }

    private void a(Drawable drawable, Integer num) {
        a(drawable, num, false);
    }

    private void a(Drawable drawable, Integer num, boolean z) {
        if (drawable != null && num != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (drawable instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) drawable;
                    if (z) {
                        rippleDrawable.setColor(ColorStateList.valueOf(num.intValue()));
                    }
                    a(rippleDrawable.getNumberOfLayers() > 0 ? rippleDrawable.getDrawable(0) : null, num);
                } else if (drawable instanceof InsetDrawable) {
                    a(((InsetDrawable) drawable).getDrawable(), num);
                } else if (drawable instanceof ColorDrawable) {
                    ColorDrawable colorDrawable = (ColorDrawable) drawable;
                    colorDrawable.setTint(num.intValue());
                    colorDrawable.setColor(num.intValue());
                } else {
                    drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                }
            } else if (drawable instanceof ColorDrawable) {
                ((ColorDrawable) drawable).setColor(num.intValue());
            } else {
                drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
