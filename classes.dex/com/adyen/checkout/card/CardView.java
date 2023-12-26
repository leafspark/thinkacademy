package com.adyen.checkout.card;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.card.databinding.CardViewBinding;
import com.adyen.checkout.card.ui.SecurityCodeInput;
import com.adyen.checkout.components.api.ImageLoader;
import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import com.adyen.checkout.components.ui.view.AdyenLinearLayout;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;
import com.adyen.checkout.components.ui.view.RoundCornerImageView;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.util.BuildUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ]2\"\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006:\u0001]B%\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\bH\u0014J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u0019H\u0002J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0014J\b\u00108\u001a\u00020\u0019H\u0014J\u0010\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u0002H\u0002J\u0012\u0010;\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010<\u001a\u00020\u0019H\u0016J\b\u0010=\u001a\u00020\u0019H\u0014J\u0016\u0010>\u001a\u00020\u00192\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0002J\b\u0010B\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\u0019H\u0002J\b\u0010D\u001a\u00020\u0019H\u0002J\u0010\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u000203H\u0002J#\u0010G\u001a\u00020\u00192\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010I\u001a\u000203H\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\u00020\u00192\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u000203H\u0002J\u0010\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u000203H\u0002J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u000203H\u0002J\u0010\u0010W\u001a\u00020\u00192\u0006\u0010X\u001a\u00020\u0013H\u0002J\u0012\u0010Y\u001a\u00020\u00192\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0010\u0010\\\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u0002H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/adyen/checkout/card/CardView;", "Lcom/adyen/checkout/components/ui/view/AdyenLinearLayout;", "Lcom/adyen/checkout/card/CardOutputData;", "Lcom/adyen/checkout/card/CardConfiguration;", "Lcom/adyen/checkout/card/CardComponentState;", "Lcom/adyen/checkout/card/CardComponent;", "Landroidx/lifecycle/Observer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/adyen/checkout/card/databinding/CardViewBinding;", "installmentListAdapter", "Lcom/adyen/checkout/card/InstallmentListAdapter;", "mCardInputData", "Lcom/adyen/checkout/card/CardInputData;", "mImageLoader", "Lcom/adyen/checkout/components/api/ImageLoader;", "getActivity", "Landroid/app/Activity;", "goToNextInputIfFocus", "", "view", "Landroid/view/View;", "handleCvcUIState", "cvcUIState", "Lcom/adyen/checkout/card/InputFieldUIState;", "handleExpiryDateUIState", "expiryDateUIState", "highlightValidationErrors", "initBrandSelectionListeners", "initCardBrandLogoViews", "selectedIndex", "initCardNumberInput", "initExpiryDateInput", "initHolderNameInput", "initInstallments", "initKcpAuthenticationInput", "initKcpBirthDateOrTaxNumberInput", "initKcpCardPasswordInput", "initLocalizedStrings", "localizedContext", "initPostalCodeInput", "initSecurityCodeInput", "initSocialSecurityNumberInput", "initView", "isConfirmationRequired", "", "notifyInputDataChanged", "observeComponentChanges", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onAttachedToWindow", "onCardNumberValidated", "cardOutputData", "onChanged", "onComponentAttached", "onDetachedFromWindow", "onExpiryDateValidated", "expiryDateState", "Lcom/adyen/checkout/components/ui/FieldState;", "Lcom/adyen/checkout/card/data/ExpiryDate;", "resetBrandSelectionInput", "selectPrimaryBrand", "selectSecondaryBrand", "setCardErrorState", "hasFocus", "setCardNumberError", "stringResId", "shouldShowSecondaryLogo", "(Ljava/lang/Integer;Z)V", "setDualBrandedCardImages", "detectedCardTypes", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "validation", "Lcom/adyen/checkout/components/ui/Validation;", "setKcpAuthVisibility", "shouldShowKCPAuth", "setPostalCodeVisibility", "shouldShowPostalCode", "setSocialSecurityNumberVisibility", "shouldShowSocialSecurityNumber", "setStoredCardInterface", "storedCardInput", "updateInstallmentSelection", "installmentModel", "Lcom/adyen/checkout/card/InstallmentModel;", "updateInstallments", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardView.kt */
public final class CardView extends AdyenLinearLayout<CardOutputData, CardConfiguration, CardComponentState, CardComponent> implements Observer<CardOutputData> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PRIMARY_BRAND_INDEX = 0;
    private static final int SECONDARY_BRAND_INDEX = 1;
    private static final float SELECTED_BRAND_LOGO_ALPHA = 1.0f;
    private static final float UNSELECTED_BRAND_LOGO_ALPHA = 0.2f;
    private final CardViewBinding binding;
    private InstallmentListAdapter installmentListAdapter;
    private final CardInputData mCardInputData;
    private ImageLoader mImageLoader;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CardView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputFieldUIState.values().length];
            iArr[InputFieldUIState.REQUIRED.ordinal()] = 1;
            iArr[InputFieldUIState.OPTIONAL.ordinal()] = 2;
            iArr[InputFieldUIState.HIDDEN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean isConfirmationRequired() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CardViewBinding inflate = CardViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        this.mCardInputData = new CardInputData((String) null, (ExpiryDate) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, 0, (InstallmentModel) null, 2047, (DefaultConstructorMarker) null);
        setOrientation(1);
        int dimension = (int) getResources().getDimension(R.dimen.standard_margin);
        setPadding(dimension, dimension, dimension, 0);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/adyen/checkout/card/CardView$Companion;", "", "()V", "PRIMARY_BRAND_INDEX", "", "SECONDARY_BRAND_INDEX", "SELECTED_BRAND_LOGO_ALPHA", "", "UNSELECTED_BRAND_LOGO_ALPHA", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CardView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Window window;
        super.onAttachedToWindow();
        BuildUtils buildUtils = BuildUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!buildUtils.isDebugBuild(context)) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Activity activity = getActivity(context2);
            if (activity != null && (window = activity.getWindow()) != null) {
                window.addFlags(8192);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Window window;
        super.onDetachedFromWindow();
        BuildUtils buildUtils = BuildUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!buildUtils.isDebugBuild(context)) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Activity activity = getActivity(context2);
            if (activity != null && (window = activity.getWindow()) != null) {
                window.clearFlags(8192);
            }
        }
    }

    public void initView() {
        initCardNumberInput();
        initExpiryDateInput();
        initSecurityCodeInput();
        initHolderNameInput();
        initSocialSecurityNumberInput();
        initKcpAuthenticationInput();
        initPostalCodeInput();
        this.binding.switchStorePaymentMethod.setOnCheckedChangeListener(new CardView$$ExternalSyntheticLambda2(this));
        if (((CardComponent) getComponent()).isStoredPaymentMethod()) {
            CardInputData storedPaymentInputData = ((CardComponent) getComponent()).getStoredPaymentInputData();
            if (storedPaymentInputData != null) {
                setStoredCardInterface(storedPaymentInputData);
            }
        } else {
            View view = this.binding.textInputLayoutCardHolder;
            Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutCardHolder");
            int i = 0;
            view.setVisibility(((CardComponent) getComponent()).isHolderNameRequired() ? 0 : 8);
            SwitchCompat switchCompat = this.binding.switchStorePaymentMethod;
            Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.switchStorePaymentMethod");
            View view2 = switchCompat;
            if (!((CardComponent) getComponent()).showStorePaymentField()) {
                i = 8;
            }
            view2.setVisibility(i);
        }
        notifyInputDataChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m37initView$lambda0(CardView cardView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        cardView.mCardInputData.setStorePaymentSelected(z);
        cardView.notifyInputDataChanged();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: protected */
    public void initLocalizedStrings(Context context) {
        Intrinsics.checkNotNullParameter(context, "localizedContext");
        int[] iArr = {16843088};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.AdyenCheckout_Card_CardNumberInput, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "localizedContext.obtainStyledAttributes(R.style.AdyenCheckout_Card_CardNumberInput, myAttrs)");
        this.binding.textInputLayoutCardNumber.setHint(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(R.style.AdyenCheckout_Card_ExpiryDateInput, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "localizedContext.obtainStyledAttributes(R.style.AdyenCheckout_Card_ExpiryDateInput, myAttrs)");
        this.binding.textInputLayoutExpiryDate.setHint(obtainStyledAttributes2.getString(0));
        obtainStyledAttributes2.recycle();
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(R.style.AdyenCheckout_Card_SecurityCodeInput, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes3, "localizedContext.obtainStyledAttributes(R.style.AdyenCheckout_Card_SecurityCodeInput, myAttrs)");
        this.binding.textInputLayoutSecurityCode.setHint(obtainStyledAttributes3.getString(0));
        obtainStyledAttributes3.recycle();
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(R.style.AdyenCheckout_Card_HolderNameInput, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes4, "localizedContext.obtainStyledAttributes(R.style.AdyenCheckout_Card_HolderNameInput, myAttrs)");
        this.binding.textInputLayoutCardHolder.setHint(obtainStyledAttributes4.getString(0));
        obtainStyledAttributes4.recycle();
        TypedArray obtainStyledAttributes5 = context.obtainStyledAttributes(R.style.AdyenCheckout_Card_PostalCodeInput, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes5, "localizedContext.obtainStyledAttributes(R.style.AdyenCheckout_Card_PostalCodeInput, myAttrs)");
        this.binding.textInputLayoutPostalCode.setHint(obtainStyledAttributes5.getString(0));
        obtainStyledAttributes5.recycle();
        TypedArray obtainStyledAttributes6 = context.obtainStyledAttributes(R.style.AdyenCheckout_Card_StorePaymentSwitch, new int[]{16843087});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes6, "localizedContext.obtainStyledAttributes(R.style.AdyenCheckout_Card_StorePaymentSwitch, myAttrs)");
        this.binding.switchStorePaymentMethod.setText(obtainStyledAttributes6.getString(0));
        obtainStyledAttributes6.recycle();
    }

    public void onComponentAttached() {
        ImageLoader.Companion companion = ImageLoader.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mImageLoader = companion.getInstance(context, ((CardConfiguration) ((CardComponent) getComponent()).getConfiguration()).getEnvironment());
    }

    public void onChanged(CardOutputData cardOutputData) {
        EditText editText;
        if (cardOutputData != null) {
            onCardNumberValidated(cardOutputData);
            onExpiryDateValidated(cardOutputData.getExpiryDateState());
            setSocialSecurityNumberVisibility(cardOutputData.isSocialSecurityNumberRequired());
            setKcpAuthVisibility(cardOutputData.isKCPAuthRequired());
            setPostalCodeVisibility(cardOutputData.isPostalCodeRequired());
            handleCvcUIState(cardOutputData.getCvcUIState());
            handleExpiryDateUIState(cardOutputData.getExpiryDateUIState());
            updateInstallments(cardOutputData);
        }
        if (((CardComponent) getComponent()).isStoredPaymentMethod() && ((CardComponent) getComponent()).requiresInput() && (editText = this.binding.textInputLayoutSecurityCode.getEditText()) != null) {
            editText.requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public void observeComponentChanges(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        ((CardComponent) getComponent()).observeOutputData(lifecycleOwner, this);
    }

    public void highlightValidationErrors() {
        boolean z;
        CardOutputData cardOutputData = (CardOutputData) ((CardComponent) getComponent()).getOutputData();
        if (cardOutputData != null) {
            Validation validation = cardOutputData.getCardNumberState().getValidation();
            boolean z2 = false;
            if (validation instanceof Validation.Invalid) {
                this.binding.editTextCardNumber.requestFocus();
                setCardNumberError$default(this, Integer.valueOf(((Validation.Invalid) validation).getReason()), false, 2, (Object) null);
                z = true;
            } else {
                z = false;
            }
            Validation validation2 = cardOutputData.getExpiryDateState().getValidation();
            if (validation2 instanceof Validation.Invalid) {
                if (!z) {
                    this.binding.textInputLayoutExpiryDate.requestFocus();
                    z = true;
                }
                this.binding.textInputLayoutExpiryDate.setError(this.mLocalizedContext.getString(((Validation.Invalid) validation2).getReason()));
            }
            Validation validation3 = cardOutputData.getSecurityCodeState().getValidation();
            if (validation3 instanceof Validation.Invalid) {
                if (!z) {
                    this.binding.textInputLayoutSecurityCode.requestFocus();
                    z = true;
                }
                this.binding.textInputLayoutSecurityCode.setError(this.mLocalizedContext.getString(((Validation.Invalid) validation3).getReason()));
            }
            Validation validation4 = cardOutputData.getHolderNameState().getValidation();
            View view = this.binding.textInputLayoutCardHolder;
            Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutCardHolder");
            if ((view.getVisibility() == 0) && (validation4 instanceof Validation.Invalid)) {
                if (!z) {
                    this.binding.textInputLayoutCardHolder.requestFocus();
                }
                this.binding.textInputLayoutCardHolder.setError(this.mLocalizedContext.getString(((Validation.Invalid) validation4).getReason()));
            }
            Validation validation5 = cardOutputData.getPostalCodeState().getValidation();
            View view2 = this.binding.textInputLayoutPostalCode;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.textInputLayoutPostalCode");
            if (view2.getVisibility() == 0) {
                z2 = true;
            }
            if (z2 && (validation5 instanceof Validation.Invalid)) {
                if (!z) {
                    this.binding.textInputLayoutPostalCode.requestFocus();
                }
                this.binding.textInputLayoutPostalCode.setError(this.mLocalizedContext.getString(((Validation.Invalid) validation5).getReason()));
            }
        }
    }

    private final void notifyInputDataChanged() {
        ((CardComponent) getComponent()).inputDataChanged(this.mCardInputData);
    }

    private final void onCardNumberValidated(CardOutputData cardOutputData) {
        boolean z;
        List<DetectedCardType> detectedCardTypes = cardOutputData.getDetectedCardTypes();
        boolean z2 = false;
        if (detectedCardTypes.isEmpty()) {
            RoundCornerImageView roundCornerImageView = this.binding.cardBrandLogoImageViewPrimary;
            roundCornerImageView.setStrokeWidth(0.0f);
            roundCornerImageView.setImageResource(R.drawable.ic_card);
            roundCornerImageView.setAlpha(1.0f);
            FrameLayout frameLayout = this.binding.cardBrandLogoContainerSecondary;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cardBrandLogoContainerSecondary");
            frameLayout.setVisibility(8);
            this.binding.editTextCardNumber.setAmexCardFormat(false);
            resetBrandSelectionInput();
            return;
        }
        this.binding.cardBrandLogoImageViewPrimary.setStrokeWidth(4.0f);
        ImageLoader imageLoader = this.mImageLoader;
        if (imageLoader != null) {
            String txVariant = detectedCardTypes.get(0).getCardType().getTxVariant();
            Intrinsics.checkNotNullExpressionValue(txVariant, "detectedCardTypes[0].cardType.txVariant");
            RoundCornerImageView roundCornerImageView2 = this.binding.cardBrandLogoImageViewPrimary;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView2, "binding.cardBrandLogoImageViewPrimary");
            imageLoader.load(txVariant, (ImageView) roundCornerImageView2, 0, R.drawable.ic_card);
        }
        setDualBrandedCardImages(detectedCardTypes, cardOutputData.getCardNumberState().getValidation());
        Iterable iterable = detectedCardTypes;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((DetectedCardType) it.next()).getCardType() == CardType.AMERICAN_EXPRESS) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.binding.editTextCardNumber.setAmexCardFormat(z2);
    }

    private final void setDualBrandedCardImages(List<DetectedCardType> list, Validation validation) {
        boolean hasFocus = this.binding.textInputLayoutCardNumber.hasFocus();
        int i = 0;
        Unit unit = null;
        if (!(validation instanceof Validation.Invalid) || hasFocus) {
            DetectedCardType detectedCardType = (DetectedCardType) CollectionsKt.getOrNull(list, 1);
            if (detectedCardType != null) {
                if (!detectedCardType.isReliable()) {
                    detectedCardType = null;
                }
                if (detectedCardType != null) {
                    FrameLayout frameLayout = this.binding.cardBrandLogoContainerSecondary;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cardBrandLogoContainerSecondary");
                    frameLayout.setVisibility(0);
                    this.binding.cardBrandLogoImageViewSecondary.setStrokeWidth(4.0f);
                    ImageLoader imageLoader = this.mImageLoader;
                    if (imageLoader != null) {
                        String txVariant = detectedCardType.getCardType().getTxVariant();
                        Intrinsics.checkNotNullExpressionValue(txVariant, "it.cardType.txVariant");
                        RoundCornerImageView roundCornerImageView = this.binding.cardBrandLogoImageViewSecondary;
                        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.cardBrandLogoImageViewSecondary");
                        imageLoader.load(txVariant, (ImageView) roundCornerImageView, 0, R.drawable.ic_card);
                    }
                    Iterator<DetectedCardType> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (it.next().isSelected()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    initCardBrandLogoViews(i);
                    initBrandSelectionListeners();
                    unit = Unit.INSTANCE;
                }
            }
            if (unit == null) {
                CardView cardView = this;
                cardView.binding.cardBrandLogoImageViewPrimary.setAlpha(1.0f);
                FrameLayout frameLayout2 = cardView.binding.cardBrandLogoContainerSecondary;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.cardBrandLogoContainerSecondary");
                frameLayout2.setVisibility(8);
                cardView.resetBrandSelectionInput();
                return;
            }
            return;
        }
        setCardNumberError$default(this, Integer.valueOf(((Validation.Invalid) validation).getReason()), false, 2, (Object) null);
    }

    private final void onExpiryDateValidated(FieldState<ExpiryDate> fieldState) {
        if (fieldState.getValidation().isValid()) {
            goToNextInputIfFocus((View) this.binding.editTextExpiryDate);
        }
    }

    private final void goToNextInputIfFocus(View view) {
        if (getRootView().findFocus() == view && view != null) {
            findViewById(view.getNextFocusForwardId()).requestFocus();
        }
    }

    private final void initCardNumberInput() {
        this.binding.editTextCardNumber.setOnChangeListener(new CardView$$ExternalSyntheticLambda4(this));
        this.binding.editTextCardNumber.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda14(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initCardNumberInput$lambda-9  reason: not valid java name */
    public static final void m21initCardNumberInput$lambda9(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "it");
        CardInputData cardInputData = cardView.mCardInputData;
        String rawValue = cardView.binding.editTextCardNumber.getRawValue();
        Intrinsics.checkNotNullExpressionValue(rawValue, "binding.editTextCardNumber.rawValue");
        cardInputData.setCardNumber(rawValue);
        cardView.notifyInputDataChanged();
        cardView.setCardErrorState(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: initCardNumberInput$lambda-10  reason: not valid java name */
    public static final void m20initCardNumberInput$lambda10(CardView cardView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        cardView.setCardErrorState(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r0 = r0.getCardNumberState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setCardErrorState(boolean r6) {
        /*
            r5 = this;
            com.adyen.checkout.components.ViewableComponent r0 = r5.getComponent()
            com.adyen.checkout.card.CardComponent r0 = (com.adyen.checkout.card.CardComponent) r0
            boolean r0 = r0.isStoredPaymentMethod()
            if (r0 != 0) goto L_0x0070
            com.adyen.checkout.components.ViewableComponent r0 = r5.getComponent()
            com.adyen.checkout.card.CardComponent r0 = (com.adyen.checkout.card.CardComponent) r0
            com.adyen.checkout.components.base.OutputData r0 = r0.getOutputData()
            com.adyen.checkout.card.CardOutputData r0 = (com.adyen.checkout.card.CardOutputData) r0
            r1 = 0
            if (r0 != 0) goto L_0x001d
        L_0x001b:
            r0 = r1
            goto L_0x0028
        L_0x001d:
            com.adyen.checkout.components.ui.FieldState r0 = r0.getCardNumberState()
            if (r0 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            com.adyen.checkout.components.ui.Validation r0 = r0.getValidation()
        L_0x0028:
            boolean r2 = r0 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r2 == 0) goto L_0x0030
            r3 = r0
            com.adyen.checkout.components.ui.Validation$Invalid r3 = (com.adyen.checkout.components.ui.Validation.Invalid) r3
            goto L_0x0031
        L_0x0030:
            r3 = r1
        L_0x0031:
            r4 = 0
            if (r3 != 0) goto L_0x0036
            r3 = r4
            goto L_0x003a
        L_0x0036:
            boolean r3 = r3.getShowErrorWhileEditing()
        L_0x003a:
            if (r6 == 0) goto L_0x0040
            if (r3 != 0) goto L_0x0040
            r6 = 1
            goto L_0x0041
        L_0x0040:
            r6 = r4
        L_0x0041:
            if (r6 == 0) goto L_0x0060
            com.adyen.checkout.components.ViewableComponent r6 = r5.getComponent()
            com.adyen.checkout.card.CardComponent r6 = (com.adyen.checkout.card.CardComponent) r6
            com.adyen.checkout.components.base.OutputData r6 = r6.getOutputData()
            com.adyen.checkout.card.CardOutputData r6 = (com.adyen.checkout.card.CardOutputData) r6
            if (r6 != 0) goto L_0x0052
            goto L_0x005c
        L_0x0052:
            com.adyen.checkout.components.ViewableComponent r0 = r5.getComponent()
            com.adyen.checkout.card.CardComponent r0 = (com.adyen.checkout.card.CardComponent) r0
            boolean r4 = r0.isDualBrandedFlow(r6)
        L_0x005c:
            r5.setCardNumberError(r1, r4)
            goto L_0x0070
        L_0x0060:
            if (r2 == 0) goto L_0x0070
            com.adyen.checkout.components.ui.Validation$Invalid r0 = (com.adyen.checkout.components.ui.Validation.Invalid) r0
            int r6 = r0.getReason()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0 = 2
            setCardNumberError$default(r5, r6, r4, r0, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.setCardErrorState(boolean):void");
    }

    static /* synthetic */ void setCardNumberError$default(CardView cardView, Integer num, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardView.setCardNumberError(num, z);
    }

    private final void setCardNumberError(Integer num, boolean z) {
        int i = 8;
        if (num == null) {
            this.binding.textInputLayoutCardNumber.setError((CharSequence) null);
            FrameLayout frameLayout = this.binding.cardBrandLogoContainerPrimary;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cardBrandLogoContainerPrimary");
            frameLayout.setVisibility(0);
            FrameLayout frameLayout2 = this.binding.cardBrandLogoContainerSecondary;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.cardBrandLogoContainerSecondary");
            View view = frameLayout2;
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
            return;
        }
        this.binding.textInputLayoutCardNumber.setError(this.mLocalizedContext.getString(num.intValue()));
        FrameLayout frameLayout3 = this.binding.cardBrandLogoContainerPrimary;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.cardBrandLogoContainerPrimary");
        frameLayout3.setVisibility(8);
        FrameLayout frameLayout4 = this.binding.cardBrandLogoContainerSecondary;
        Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.cardBrandLogoContainerSecondary");
        frameLayout4.setVisibility(8);
    }

    private final void initCardBrandLogoViews(int i) {
        if (i == 0) {
            selectPrimaryBrand();
        } else if (i == 1) {
            selectSecondaryBrand();
        } else {
            throw new CheckoutException("Illegal brand index selected. Selected index must be either 0 or 1.");
        }
    }

    private final void initBrandSelectionListeners() {
        this.binding.cardBrandLogoContainerPrimary.setOnClickListener(new CardView$$ExternalSyntheticLambda11(this));
        this.binding.cardBrandLogoContainerSecondary.setOnClickListener(new CardView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initBrandSelectionListeners$lambda-12  reason: not valid java name */
    public static final void m18initBrandSelectionListeners$lambda12(CardView cardView, View view) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        cardView.mCardInputData.setSelectedCardIndex(0);
        cardView.notifyInputDataChanged();
        cardView.selectPrimaryBrand();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initBrandSelectionListeners$lambda-13  reason: not valid java name */
    public static final void m19initBrandSelectionListeners$lambda13(CardView cardView, View view) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        cardView.mCardInputData.setSelectedCardIndex(1);
        cardView.notifyInputDataChanged();
        cardView.selectSecondaryBrand();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void resetBrandSelectionInput() {
        this.binding.cardBrandLogoContainerPrimary.setOnClickListener((View.OnClickListener) null);
        this.binding.cardBrandLogoContainerSecondary.setOnClickListener((View.OnClickListener) null);
    }

    private final void selectPrimaryBrand() {
        this.binding.cardBrandLogoImageViewPrimary.setAlpha(1.0f);
        this.binding.cardBrandLogoImageViewSecondary.setAlpha(0.2f);
    }

    private final void selectSecondaryBrand() {
        this.binding.cardBrandLogoImageViewPrimary.setAlpha(0.2f);
        this.binding.cardBrandLogoImageViewSecondary.setAlpha(1.0f);
    }

    private final void initExpiryDateInput() {
        this.binding.editTextExpiryDate.setOnChangeListener(new CardView$$ExternalSyntheticLambda5(this));
        this.binding.editTextExpiryDate.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda18(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initExpiryDateInput$lambda-14  reason: not valid java name */
    public static final void m22initExpiryDateInput$lambda14(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "it");
        ExpiryDate date = cardView.binding.editTextExpiryDate.getDate();
        Intrinsics.checkNotNullExpressionValue(date, "binding.editTextExpiryDate.date");
        cardView.mCardInputData.setExpiryDate(date);
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutExpiryDate.setError((CharSequence) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getExpiryDateState();
     */
    /* renamed from: initExpiryDateInput$lambda-15  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m23initExpiryDateInput$lambda15(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getExpiryDateState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutExpiryDate
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutExpiryDate
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m23initExpiryDateInput$lambda15(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void initSecurityCodeInput() {
        EditText editText = this.binding.textInputLayoutSecurityCode.getEditText();
        SecurityCodeInput securityCodeInput = editText instanceof SecurityCodeInput ? (SecurityCodeInput) editText : null;
        if (securityCodeInput != null) {
            securityCodeInput.setOnChangeListener(new CardView$$ExternalSyntheticLambda8(this));
        }
        if (securityCodeInput != null) {
            securityCodeInput.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda17(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initSecurityCodeInput$lambda-16  reason: not valid java name */
    public static final void m33initSecurityCodeInput$lambda16(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "editable");
        cardView.mCardInputData.setSecurityCode(editable.toString());
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutSecurityCode.setError((CharSequence) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getSecurityCodeState();
     */
    /* renamed from: initSecurityCodeInput$lambda-17  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m34initSecurityCodeInput$lambda17(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getSecurityCodeState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutSecurityCode
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutSecurityCode
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m34initSecurityCodeInput$lambda17(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void initHolderNameInput() {
        EditText editText = this.binding.textInputLayoutCardHolder.getEditText();
        AdyenTextInputEditText adyenTextInputEditText = editText instanceof AdyenTextInputEditText ? (AdyenTextInputEditText) editText : null;
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnChangeListener(new CardView$$ExternalSyntheticLambda6(this));
        }
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda19(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initHolderNameInput$lambda-18  reason: not valid java name */
    public static final void m24initHolderNameInput$lambda18(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "editable");
        cardView.mCardInputData.setHolderName(editable.toString());
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutCardHolder.setError((CharSequence) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getHolderNameState();
     */
    /* renamed from: initHolderNameInput$lambda-19  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m25initHolderNameInput$lambda19(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getHolderNameState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutCardHolder
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutCardHolder
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m25initHolderNameInput$lambda19(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void initSocialSecurityNumberInput() {
        EditText editText = this.binding.textInputLayoutSocialSecurityNumber.getEditText();
        AdyenTextInputEditText adyenTextInputEditText = editText instanceof AdyenTextInputEditText ? (AdyenTextInputEditText) editText : null;
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnChangeListener(new CardView$$ExternalSyntheticLambda3(this));
        }
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda13(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initSocialSecurityNumberInput$lambda-20  reason: not valid java name */
    public static final void m35initSocialSecurityNumberInput$lambda20(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "editable");
        cardView.mCardInputData.setSocialSecurityNumber(editable.toString());
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutSocialSecurityNumber.setError((CharSequence) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getSocialSecurityNumberState();
     */
    /* renamed from: initSocialSecurityNumberInput$lambda-21  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m36initSocialSecurityNumberInput$lambda21(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getSocialSecurityNumberState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutSocialSecurityNumber
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutSocialSecurityNumber
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m36initSocialSecurityNumberInput$lambda21(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void initKcpAuthenticationInput() {
        initKcpBirthDateOrTaxNumberInput();
        initKcpCardPasswordInput();
    }

    private final void initKcpBirthDateOrTaxNumberInput() {
        EditText editText = this.binding.textInputLayoutKcpBirthDateOrTaxNumber.getEditText();
        AdyenTextInputEditText adyenTextInputEditText = editText instanceof AdyenTextInputEditText ? (AdyenTextInputEditText) editText : null;
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnChangeListener(new CardView$$ExternalSyntheticLambda7(this));
        }
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda15(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initKcpBirthDateOrTaxNumberInput$lambda-22  reason: not valid java name */
    public static final void m27initKcpBirthDateOrTaxNumberInput$lambda22(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "it");
        cardView.mCardInputData.setKcpBirthDateOrTaxNumber(editable.toString());
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutKcpBirthDateOrTaxNumber.setError((CharSequence) null);
        cardView.binding.textInputLayoutKcpBirthDateOrTaxNumber.setHint(cardView.mLocalizedContext.getString(((CardComponent) cardView.getComponent()).getKcpBirthDateOrTaxNumberHint(editable.toString())));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getKcpBirthDateOrTaxNumberState();
     */
    /* renamed from: initKcpBirthDateOrTaxNumberInput$lambda-23  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m28initKcpBirthDateOrTaxNumberInput$lambda23(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getKcpBirthDateOrTaxNumberState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutKcpBirthDateOrTaxNumber
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutKcpBirthDateOrTaxNumber
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m28initKcpBirthDateOrTaxNumberInput$lambda23(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void initKcpCardPasswordInput() {
        EditText editText = this.binding.textInputLayoutKcpCardPassword.getEditText();
        AdyenTextInputEditText adyenTextInputEditText = editText instanceof AdyenTextInputEditText ? (AdyenTextInputEditText) editText : null;
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnChangeListener(new CardView$$ExternalSyntheticLambda10(this));
        }
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda16(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initKcpCardPasswordInput$lambda-24  reason: not valid java name */
    public static final void m29initKcpCardPasswordInput$lambda24(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "it");
        cardView.mCardInputData.setKcpCardPassword(editable.toString());
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutKcpCardPassword.setError((CharSequence) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getKcpCardPasswordState();
     */
    /* renamed from: initKcpCardPasswordInput$lambda-25  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m30initKcpCardPasswordInput$lambda25(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getKcpCardPasswordState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutKcpCardPassword
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutKcpCardPassword
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m30initKcpCardPasswordInput$lambda25(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void initPostalCodeInput() {
        EditText editText = this.binding.textInputLayoutPostalCode.getEditText();
        AdyenTextInputEditText adyenTextInputEditText = editText instanceof AdyenTextInputEditText ? (AdyenTextInputEditText) editText : null;
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnChangeListener(new CardView$$ExternalSyntheticLambda9(this));
        }
        if (adyenTextInputEditText != null) {
            adyenTextInputEditText.setOnFocusChangeListener(new CardView$$ExternalSyntheticLambda12(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPostalCodeInput$lambda-26  reason: not valid java name */
    public static final void m31initPostalCodeInput$lambda26(CardView cardView, Editable editable) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        Intrinsics.checkNotNullParameter(editable, "it");
        cardView.mCardInputData.setPostalCode(editable.toString());
        cardView.notifyInputDataChanged();
        cardView.binding.textInputLayoutPostalCode.setError((CharSequence) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r2 = r2.getPostalCodeState();
     */
    /* renamed from: initPostalCodeInput$lambda-27  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m32initPostalCodeInput$lambda27(com.adyen.checkout.card.CardView r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.adyen.checkout.components.ViewableComponent r2 = r1.getComponent()
            com.adyen.checkout.card.CardComponent r2 = (com.adyen.checkout.card.CardComponent) r2
            com.adyen.checkout.components.base.OutputData r2 = r2.getOutputData()
            com.adyen.checkout.card.CardOutputData r2 = (com.adyen.checkout.card.CardOutputData) r2
            r0 = 0
            if (r2 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0021
        L_0x0016:
            com.adyen.checkout.components.ui.FieldState r2 = r2.getPostalCodeState()
            if (r2 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.adyen.checkout.components.ui.Validation r2 = r2.getValidation()
        L_0x0021:
            if (r3 == 0) goto L_0x002b
            com.adyen.checkout.card.databinding.CardViewBinding r1 = r1.binding
            com.google.android.material.textfield.TextInputLayout r1 = r1.textInputLayoutPostalCode
            r1.setError(r0)
            goto L_0x0046
        L_0x002b:
            if (r2 == 0) goto L_0x0046
            boolean r3 = r2 instanceof com.adyen.checkout.components.ui.Validation.Invalid
            if (r3 == 0) goto L_0x0046
            com.adyen.checkout.card.databinding.CardViewBinding r3 = r1.binding
            com.google.android.material.textfield.TextInputLayout r3 = r3.textInputLayoutPostalCode
            android.content.Context r1 = r1.mLocalizedContext
            com.adyen.checkout.components.ui.Validation$Invalid r2 = (com.adyen.checkout.components.ui.Validation.Invalid) r2
            int r2 = r2.getReason()
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3.setError(r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardView.m32initPostalCodeInput$lambda27(com.adyen.checkout.card.CardView, android.view.View, boolean):void");
    }

    private final void updateInstallments(CardOutputData cardOutputData) {
        View view = this.binding.textInputLayoutInstallments;
        Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutInstallments");
        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = this.binding.autoCompleteTextViewInstallments;
        Intrinsics.checkNotNullExpressionValue(appCompatAutoCompleteTextView, "binding.autoCompleteTextViewInstallments");
        if (!cardOutputData.getInstallmentOptions().isEmpty()) {
            if (this.installmentListAdapter == null) {
                initInstallments();
            }
            if (cardOutputData.getInstallmentState().getValue() == null) {
                updateInstallmentSelection((InstallmentModel) CollectionsKt.first(cardOutputData.getInstallmentOptions()));
                InstallmentUtils installmentUtils = InstallmentUtils.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                appCompatAutoCompleteTextView.setText(installmentUtils.getTextForInstallmentOption(context, (InstallmentModel) CollectionsKt.first(cardOutputData.getInstallmentOptions())));
            }
            InstallmentListAdapter installmentListAdapter2 = this.installmentListAdapter;
            if (installmentListAdapter2 != null) {
                installmentListAdapter2.setItems(cardOutputData.getInstallmentOptions());
            }
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    private final void initInstallments() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        InstallmentListAdapter installmentListAdapter2 = new InstallmentListAdapter(context);
        this.installmentListAdapter = installmentListAdapter2;
        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = this.binding.autoCompleteTextViewInstallments;
        appCompatAutoCompleteTextView.setInputType(0);
        appCompatAutoCompleteTextView.setAdapter(installmentListAdapter2);
        appCompatAutoCompleteTextView.setOnItemClickListener(new CardView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initInstallments$lambda-30$lambda-29$lambda-28  reason: not valid java name */
    public static final void m26initInstallments$lambda30$lambda29$lambda28(CardView cardView, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(cardView, "this$0");
        InstallmentListAdapter installmentListAdapter2 = cardView.installmentListAdapter;
        cardView.updateInstallmentSelection(installmentListAdapter2 == null ? null : installmentListAdapter2.getItem(i));
        SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
    }

    private final void handleCvcUIState(InputFieldUIState inputFieldUIState) {
        int i = WhenMappings.$EnumSwitchMapping$0[inputFieldUIState.ordinal()];
        if (i == 1) {
            View view = this.binding.textInputLayoutSecurityCode;
            Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutSecurityCode");
            view.setVisibility(0);
            this.binding.textInputLayoutSecurityCode.setHint(R.string.checkout_card_security_code_hint);
        } else if (i == 2) {
            View view2 = this.binding.textInputLayoutSecurityCode;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.textInputLayoutSecurityCode");
            view2.setVisibility(0);
            this.binding.textInputLayoutSecurityCode.setHint(R.string.checkout_card_security_code_optional_hint);
        } else if (i == 3) {
            View view3 = this.binding.textInputLayoutSecurityCode;
            Intrinsics.checkNotNullExpressionValue(view3, "binding.textInputLayoutSecurityCode");
            view3.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.binding.textInputLayoutExpiryDate.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginEnd(0);
            this.binding.textInputLayoutExpiryDate.setLayoutParams(layoutParams2);
        }
    }

    private final void handleExpiryDateUIState(InputFieldUIState inputFieldUIState) {
        int i = WhenMappings.$EnumSwitchMapping$0[inputFieldUIState.ordinal()];
        if (i == 1) {
            View view = this.binding.textInputLayoutExpiryDate;
            Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutExpiryDate");
            view.setVisibility(0);
            this.binding.textInputLayoutExpiryDate.setHint(R.string.checkout_card_expiry_date_hint);
        } else if (i == 2) {
            View view2 = this.binding.textInputLayoutExpiryDate;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.textInputLayoutExpiryDate");
            view2.setVisibility(0);
            this.binding.textInputLayoutExpiryDate.setHint(R.string.checkout_card_expiry_date_optional_hint);
        } else if (i == 3) {
            View view3 = this.binding.textInputLayoutExpiryDate;
            Intrinsics.checkNotNullExpressionValue(view3, "binding.textInputLayoutExpiryDate");
            view3.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.binding.textInputLayoutSecurityCode.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(0);
            this.binding.textInputLayoutSecurityCode.setLayoutParams(layoutParams2);
        }
    }

    private final void setSocialSecurityNumberVisibility(boolean z) {
        View view = this.binding.textInputLayoutSocialSecurityNumber;
        Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutSocialSecurityNumber");
        view.setVisibility(z ? 0 : 8);
    }

    private final void setKcpAuthVisibility(boolean z) {
        View view = this.binding.textInputLayoutKcpBirthDateOrTaxNumber;
        Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutKcpBirthDateOrTaxNumber");
        int i = 0;
        view.setVisibility(z ? 0 : 8);
        View view2 = this.binding.textInputLayoutKcpCardPassword;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.textInputLayoutKcpCardPassword");
        View view3 = view2;
        if (!z) {
            i = 8;
        }
        view3.setVisibility(i);
    }

    private final void setPostalCodeVisibility(boolean z) {
        View view = this.binding.textInputLayoutPostalCode;
        Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutPostalCode");
        view.setVisibility(z ? 0 : 8);
    }

    private final void setStoredCardInterface(CardInputData cardInputData) {
        this.binding.editTextCardNumber.setText(this.mLocalizedContext.getString(R.string.card_number_4digit, new Object[]{cardInputData.getCardNumber()}));
        this.binding.editTextCardNumber.setEnabled(false);
        this.binding.editTextExpiryDate.setDate(cardInputData.getExpiryDate());
        this.binding.editTextExpiryDate.setEnabled(false);
        SwitchCompat switchCompat = this.binding.switchStorePaymentMethod;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.switchStorePaymentMethod");
        switchCompat.setVisibility(8);
        View view = this.binding.textInputLayoutCardHolder;
        Intrinsics.checkNotNullExpressionValue(view, "binding.textInputLayoutCardHolder");
        view.setVisibility(8);
        View view2 = this.binding.textInputLayoutPostalCode;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.textInputLayoutPostalCode");
        view2.setVisibility(8);
    }

    private final void updateInstallmentSelection(InstallmentModel installmentModel) {
        if (installmentModel != null) {
            this.mCardInputData.setInstallmentOption(installmentModel);
            notifyInputDataChanged();
        }
    }

    private final Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "context.baseContext");
        return getActivity(baseContext);
    }
}
