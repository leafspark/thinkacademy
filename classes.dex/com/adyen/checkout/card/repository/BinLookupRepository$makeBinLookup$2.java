package com.adyen.checkout.card.repository;

import com.adyen.checkout.card.CardConfiguration;
import com.adyen.checkout.card.api.BinLookupConnection;
import com.adyen.checkout.card.api.model.BinLookupRequest;
import com.adyen.checkout.card.api.model.BinLookupResponse;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.cse.exception.EncryptionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/adyen/checkout/card/api/model/BinLookupResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.card.repository.BinLookupRepository$makeBinLookup$2", f = "BinLookupRepository.kt", i = {}, l = {80, 121}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BinLookupRepository.kt */
final class BinLookupRepository$makeBinLookup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BinLookupResponse>, Object> {
    final /* synthetic */ CardConfiguration $cardConfiguration;
    final /* synthetic */ String $cardNumber;
    final /* synthetic */ String $publicKey;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BinLookupRepository$makeBinLookup$2(CardConfiguration cardConfiguration, String str, String str2, Continuation<? super BinLookupRepository$makeBinLookup$2> continuation) {
        super(2, continuation);
        this.$cardConfiguration = cardConfiguration;
        this.$cardNumber = str;
        this.$publicKey = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> binLookupRepository$makeBinLookup$2 = new BinLookupRepository$makeBinLookup$2(this.$cardConfiguration, this.$cardNumber, this.$publicKey, continuation);
        binLookupRepository$makeBinLookup$2.L$0 = obj;
        return (Continuation) binLookupRepository$makeBinLookup$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BinLookupResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred async$default = BuildersKt.async$default((CoroutineScope) this.L$0, Dispatchers.getDefault(), (CoroutineStart) null, new BinLookupRepository$makeBinLookup$2$deferredEncryption$1(this.$cardNumber, this.$publicKey, (Continuation<? super BinLookupRepository$makeBinLookup$2$deferredEncryption$1>) null), 2, (Object) null);
            this.label = 1;
            obj = async$default.await((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
                return (BinLookupResponse) obj;
            } catch (EncryptionException e) {
                Logger.e(BinLookupRepositoryKt.TAG, "checkCardType - Failed to encrypt BIN", e);
                return null;
            } catch (IOException e2) {
                Logger.e(BinLookupRepositoryKt.TAG, "checkCardType - Failed to call binLookup API.", e2);
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(obj, "deferredEncryption.await()");
        String str = (String) obj;
        List<CardType> supportedCardTypes = this.$cardConfiguration.getSupportedCardTypes();
        Intrinsics.checkNotNullExpressionValue(supportedCardTypes, "cardConfiguration.supportedCardTypes");
        Iterable<CardType> iterable = supportedCardTypes;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CardType txVariant : iterable) {
            arrayList.add(txVariant.getTxVariant());
        }
        String uuid = UUID.randomUUID().toString();
        this.label = 2;
        obj = BuildersKt.withContext(Dispatchers.getIO(), new BinLookupRepository$makeBinLookup$2$invokeSuspend$$inlined$suspendedCall$1(new BinLookupConnection(new BinLookupRequest(str, uuid, (List) arrayList), this.$cardConfiguration.getEnvironment(), this.$cardConfiguration.getClientKey()), (Continuation) null), (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (BinLookupResponse) obj;
    }
}
