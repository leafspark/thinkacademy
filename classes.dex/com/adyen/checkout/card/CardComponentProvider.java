package com.adyen.checkout.card;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.card.CardConfiguration;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.repository.BinLookupRepository;
import com.adyen.checkout.components.StoredPaymentComponentProvider;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import com.adyen.checkout.components.repository.PublicKeyRepository;
import com.adyen.checkout.core.log.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002J4\u0010\t\u001a\u00020\u0002\"\f\b\u0000\u0010\n*\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u000fJ4\u0010\t\u001a\u00020\u0002\"\f\b\u0000\u0010\n*\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0012J3\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J3\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¨\u0006\u0017"}, d2 = {"Lcom/adyen/checkout/card/CardComponentProvider;", "Lcom/adyen/checkout/components/StoredPaymentComponentProvider;", "Lcom/adyen/checkout/card/CardComponent;", "Lcom/adyen/checkout/card/CardConfiguration;", "()V", "checkSupportedCardTypes", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "cardConfiguration", "get", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "configuration", "(Landroidx/savedstate/SavedStateRegistryOwner;Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;Lcom/adyen/checkout/card/CardConfiguration;)Lcom/adyen/checkout/card/CardComponent;", "storedPaymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;", "(Landroidx/savedstate/SavedStateRegistryOwner;Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;Lcom/adyen/checkout/card/CardConfiguration;)Lcom/adyen/checkout/card/CardComponent;", "savedStateRegistryOwner", "viewModelStoreOwner", "defaultArgs", "Landroid/os/Bundle;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardComponentProvider.kt */
public final class CardComponentProvider implements StoredPaymentComponentProvider<CardComponent, CardConfiguration> {
    public <T extends SavedStateRegistryOwner & ViewModelStoreOwner> CardComponent get(T t, PaymentMethod paymentMethod, CardConfiguration cardConfiguration) {
        Intrinsics.checkNotNullParameter(t, "owner");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(cardConfiguration, "configuration");
        return get((SavedStateRegistryOwner) t, (ViewModelStoreOwner) t, paymentMethod, cardConfiguration, (Bundle) null);
    }

    public CardComponent get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, PaymentMethod paymentMethod, CardConfiguration cardConfiguration, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(cardConfiguration, "configuration");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new CardComponentProvider$get$$inlined$viewModelFactory$1(savedStateRegistryOwner, bundle, paymentMethod, checkSupportedCardTypes(paymentMethod, cardConfiguration), new BinLookupRepository(), new PublicKeyRepository(), new CardValidationMapper())).get(CardComponent.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewModelStoreOwner, factory).get(CardComponent::class.java)");
        return (CardComponent) viewModel;
    }

    public <T extends SavedStateRegistryOwner & ViewModelStoreOwner> CardComponent get(T t, StoredPaymentMethod storedPaymentMethod, CardConfiguration cardConfiguration) {
        Intrinsics.checkNotNullParameter(t, "owner");
        Intrinsics.checkNotNullParameter(storedPaymentMethod, "storedPaymentMethod");
        Intrinsics.checkNotNullParameter(cardConfiguration, "configuration");
        return get((SavedStateRegistryOwner) t, (ViewModelStoreOwner) t, storedPaymentMethod, cardConfiguration, (Bundle) null);
    }

    public CardComponent get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, StoredPaymentMethod storedPaymentMethod, CardConfiguration cardConfiguration, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(storedPaymentMethod, "storedPaymentMethod");
        Intrinsics.checkNotNullParameter(cardConfiguration, "configuration");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new CardComponentProvider$get$$inlined$viewModelFactory$2(savedStateRegistryOwner, bundle, storedPaymentMethod, cardConfiguration, new PublicKeyRepository())).get(CardComponent.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewModelStoreOwner, factory).get(CardComponent::class.java)");
        return (CardComponent) viewModel;
    }

    private final CardConfiguration checkSupportedCardTypes(PaymentMethod paymentMethod, CardConfiguration cardConfiguration) {
        List<CardType> supportedCardTypes = cardConfiguration.getSupportedCardTypes();
        Intrinsics.checkNotNullExpressionValue(supportedCardTypes, "cardConfiguration.supportedCardTypes");
        boolean z = true;
        if (!supportedCardTypes.isEmpty()) {
            return cardConfiguration;
        }
        List<String> brands = paymentMethod.getBrands();
        List<CardType> list = CardConfiguration.DEFAULT_SUPPORTED_CARDS_LIST;
        Collection collection = brands;
        if (collection != null && !collection.isEmpty()) {
            z = false;
        }
        if (!z) {
            list = new ArrayList<>();
            for (String next : brands) {
                CardType byBrandName = CardType.getByBrandName(next);
                if (byBrandName != null) {
                    list.add(byBrandName);
                } else {
                    Logger.e(CardComponentProviderKt.TAG, Intrinsics.stringPlus("Failed to get card type for brand: ", next));
                }
            }
        } else {
            Logger.d(CardComponentProviderKt.TAG, "Falling back to DEFAULT_SUPPORTED_CARDS_LIST");
        }
        CardConfiguration.Builder newBuilder = cardConfiguration.newBuilder();
        Intrinsics.checkNotNullExpressionValue(list, "supportedCardTypes");
        Object[] array = list.toArray(new CardType[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        CardType[] cardTypeArr = (CardType[]) array;
        Configuration build = newBuilder.setSupportedCardTypes((CardType[]) Arrays.copyOf(cardTypeArr, cardTypeArr.length)).build();
        Intrinsics.checkNotNullExpressionValue(build, "cardConfiguration.newBuilder()\n            .setSupportedCardTypes(*supportedCardTypes.toTypedArray())\n            .build()");
        return (CardConfiguration) build;
    }
}
