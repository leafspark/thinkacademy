package com.adyen.checkout.card;

import android.content.Context;
import com.adyen.checkout.card.InstallmentOptions;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.components.model.payments.request.Installments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0004¨\u0006\u001b"}, d2 = {"Lcom/adyen/checkout/card/InstallmentUtils;", "", "()V", "areInstallmentValuesValid", "", "installmentConfiguration", "Lcom/adyen/checkout/card/InstallmentConfiguration;", "getTextForInstallmentOption", "", "context", "Landroid/content/Context;", "installmentModel", "Lcom/adyen/checkout/card/InstallmentModel;", "isCardBasedOptionsValid", "cardBasedInstallmentOptions", "", "Lcom/adyen/checkout/card/InstallmentOptions$CardBasedInstallmentOptions;", "makeInstallmentModelList", "installmentOptions", "Lcom/adyen/checkout/card/InstallmentOptions;", "makeInstallmentModelObject", "Lcom/adyen/checkout/components/model/payments/request/Installments;", "makeInstallmentOptions", "configuration", "cardType", "Lcom/adyen/checkout/card/data/CardType;", "isCardTypeReliable", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentUtils.kt */
public final class InstallmentUtils {
    public static final InstallmentUtils INSTANCE = new InstallmentUtils();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstallmentUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InstallmentOption.values().length];
            iArr[InstallmentOption.REGULAR.ordinal()] = 1;
            iArr[InstallmentOption.REVOLVING.ordinal()] = 2;
            iArr[InstallmentOption.ONE_TIME.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private InstallmentUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.adyen.checkout.card.InstallmentOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.adyen.checkout.card.InstallmentOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.adyen.checkout.card.InstallmentOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.adyen.checkout.card.InstallmentOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.adyen.checkout.card.InstallmentOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.adyen.checkout.card.InstallmentOptions$CardBasedInstallmentOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.adyen.checkout.card.InstallmentOptions} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.adyen.checkout.card.InstallmentModel> makeInstallmentOptions(com.adyen.checkout.card.InstallmentConfiguration r6, com.adyen.checkout.card.data.CardType r7, boolean r8) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0009
        L_0x0005:
            java.util.List r1 = r6.getCardBasedOptions()
        L_0x0009:
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x000f
            r1 = r2
            goto L_0x0010
        L_0x000f:
            r1 = r3
        L_0x0010:
            if (r6 != 0) goto L_0x0014
            r4 = r0
            goto L_0x0018
        L_0x0014:
            com.adyen.checkout.card.InstallmentOptions$DefaultInstallmentOptions r4 = r6.getDefaultOptions()
        L_0x0018:
            if (r4 == 0) goto L_0x001c
            r4 = r2
            goto L_0x001d
        L_0x001c:
            r4 = r3
        L_0x001d:
            if (r1 == 0) goto L_0x005c
            if (r8 == 0) goto L_0x005c
            if (r6 != 0) goto L_0x0025
        L_0x0023:
            r8 = r3
            goto L_0x0058
        L_0x0025:
            java.util.List r8 = r6.getCardBasedOptions()
            if (r8 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r1 = r8 instanceof java.util.Collection
            if (r1 == 0) goto L_0x003c
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x003c
            goto L_0x0023
        L_0x003c:
            java.util.Iterator r8 = r8.iterator()
        L_0x0040:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0023
            java.lang.Object r1 = r8.next()
            com.adyen.checkout.card.InstallmentOptions$CardBasedInstallmentOptions r1 = (com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions) r1
            com.adyen.checkout.card.data.CardType r1 = r1.getCardType()
            if (r1 != r7) goto L_0x0054
            r1 = r2
            goto L_0x0055
        L_0x0054:
            r1 = r3
        L_0x0055:
            if (r1 == 0) goto L_0x0040
            r8 = r2
        L_0x0058:
            if (r8 == 0) goto L_0x005c
            r8 = r2
            goto L_0x005d
        L_0x005c:
            r8 = r3
        L_0x005d:
            if (r8 == 0) goto L_0x0091
            if (r6 != 0) goto L_0x0062
            goto L_0x008a
        L_0x0062:
            java.util.List r6 = r6.getCardBasedOptions()
            if (r6 != 0) goto L_0x0069
            goto L_0x008a
        L_0x0069:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x006f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0088
            java.lang.Object r8 = r6.next()
            r1 = r8
            com.adyen.checkout.card.InstallmentOptions$CardBasedInstallmentOptions r1 = (com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions) r1
            com.adyen.checkout.card.data.CardType r1 = r1.getCardType()
            if (r1 != r7) goto L_0x0084
            r1 = r2
            goto L_0x0085
        L_0x0084:
            r1 = r3
        L_0x0085:
            if (r1 == 0) goto L_0x006f
            r0 = r8
        L_0x0088:
            com.adyen.checkout.card.InstallmentOptions$CardBasedInstallmentOptions r0 = (com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions) r0
        L_0x008a:
            com.adyen.checkout.card.InstallmentOptions r0 = (com.adyen.checkout.card.InstallmentOptions) r0
            java.util.List r6 = r5.makeInstallmentModelList(r0)
            goto L_0x00a5
        L_0x0091:
            if (r4 == 0) goto L_0x00a1
            if (r6 != 0) goto L_0x0096
            goto L_0x009a
        L_0x0096:
            com.adyen.checkout.card.InstallmentOptions$DefaultInstallmentOptions r0 = r6.getDefaultOptions()
        L_0x009a:
            com.adyen.checkout.card.InstallmentOptions r0 = (com.adyen.checkout.card.InstallmentOptions) r0
            java.util.List r6 = r5.makeInstallmentModelList(r0)
            goto L_0x00a5
        L_0x00a1:
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00a5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.InstallmentUtils.makeInstallmentOptions(com.adyen.checkout.card.InstallmentConfiguration, com.adyen.checkout.card.data.CardType, boolean):java.util.List");
    }

    private final List<InstallmentModel> makeInstallmentModelList(InstallmentOptions installmentOptions) {
        if (installmentOptions == null) {
            return CollectionsKt.emptyList();
        }
        List<InstallmentModel> arrayList = new ArrayList<>();
        arrayList.add(new InstallmentModel(R.string.checkout_card_installments_option_one_time, (Integer) null, InstallmentOption.ONE_TIME));
        if (installmentOptions.getIncludeRevolving()) {
            arrayList.add(new InstallmentModel(R.string.checkout_card_installments_option_revolving, 1, InstallmentOption.REVOLVING));
        }
        Iterable<Number> values = installmentOptions.getValues();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (Number intValue : values) {
            arrayList2.add(new InstallmentModel(R.string.checkout_card_installments_option_regular, Integer.valueOf(intValue.intValue()), InstallmentOption.REGULAR));
        }
        arrayList.addAll((List) arrayList2);
        return arrayList;
    }

    public final String getTextForInstallmentOption(Context context, InstallmentModel installmentModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        InstallmentOption option = installmentModel == null ? null : installmentModel.getOption();
        int i = option == null ? -1 : WhenMappings.$EnumSwitchMapping$0[option.ordinal()];
        if (i == 1) {
            String string = context.getString(installmentModel.getTextResId(), new Object[]{installmentModel.getValue()});
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(installmentModel.textResId, installmentModel.value)");
            return string;
        } else if (i != 2 && i != 3) {
            return "";
        } else {
            String string2 = context.getString(installmentModel.getTextResId());
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(installmentModel.textResId)");
            return string2;
        }
    }

    public final Installments makeInstallmentModelObject(InstallmentModel installmentModel) {
        InstallmentOption option = installmentModel == null ? null : installmentModel.getOption();
        int i = option == null ? -1 : WhenMappings.$EnumSwitchMapping$0[option.ordinal()];
        if (i == 1 || i == 2) {
            return new Installments(installmentModel.getOption().getType(), installmentModel.getValue());
        }
        return null;
    }

    public final boolean isCardBasedOptionsValid(List<InstallmentOptions.CardBasedInstallmentOptions> list) {
        boolean z;
        boolean z2 = false;
        if (list != null) {
            Map linkedHashMap = new LinkedHashMap();
            for (Object next : list) {
                CardType cardType = ((InstallmentOptions.CardBasedInstallmentOptions) next).getCardType();
                Object obj = linkedHashMap.get(cardType);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(cardType, obj);
                }
                ((List) obj).add(next);
            }
            Collection values = linkedHashMap.values();
            if (values != null) {
                Iterable iterable = values;
                if (!((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((List) it.next()).size() > 1) {
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
            }
        }
        return !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areInstallmentValuesValid(com.adyen.checkout.card.InstallmentConfiguration r5) {
        /*
            r4 = this;
            java.lang.String r0 = "installmentConfiguration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.adyen.checkout.card.InstallmentOptions$DefaultInstallmentOptions r1 = r5.getDefaultOptions()
            r0.add(r1)
            java.util.List r5 = r5.getCardBasedOptions()
            java.util.Collection r5 = (java.util.Collection) r5
            r0.addAll(r5)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r5 = kotlin.collections.CollectionsKt.filterNotNull(r0)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r0 = r5 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0034
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0034
            goto L_0x0078
        L_0x0034:
            java.util.Iterator r5 = r5.iterator()
        L_0x0038:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r5.next()
            com.adyen.checkout.card.InstallmentOptions r0 = (com.adyen.checkout.card.InstallmentOptions) r0
            java.util.List r0 = r0.getValues()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0059
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0059
        L_0x0057:
            r0 = r2
            goto L_0x0075
        L_0x0059:
            java.util.Iterator r0 = r0.iterator()
        L_0x005d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0057
            java.lang.Object r3 = r0.next()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 > r1) goto L_0x0071
            r3 = r1
            goto L_0x0072
        L_0x0071:
            r3 = r2
        L_0x0072:
            if (r3 == 0) goto L_0x005d
            r0 = r1
        L_0x0075:
            if (r0 == 0) goto L_0x0038
            r2 = r1
        L_0x0078:
            r5 = r2 ^ 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.InstallmentUtils.areInstallmentValuesValid(com.adyen.checkout.card.InstallmentConfiguration):boolean");
    }
}
