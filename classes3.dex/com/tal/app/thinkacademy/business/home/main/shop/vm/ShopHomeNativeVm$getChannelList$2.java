package com.tal.app.thinkacademy.business.home.main.shop.vm;

import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelGroup;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListData;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getChannelList$2", f = "ShopHomeNativeVm.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShopHomeNativeVm.kt */
final class ShopHomeNativeVm$getChannelList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $schoolCode;
    int label;
    final /* synthetic */ ShopHomeNativeVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeVm$getChannelList$2(ShopHomeNativeVm shopHomeNativeVm, String str, Continuation<? super ShopHomeNativeVm$getChannelList$2> continuation) {
        super(2, continuation);
        this.this$0 = shopHomeNativeVm;
        this.$schoolCode = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopHomeNativeVm$getChannelList$2(this.this$0, this.$schoolCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopHomeNativeVm$getChannelList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getChannelListReal(this.$schoolCode, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ChannelListData channelListData = (ChannelListData) obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (List) new ArrayList();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = new ShopDialogChannelData((Channel) null, (List) null, (String) null, false, 12, (DefaultConstructorMarker) null);
        if (channelListData != null) {
            ((ShopDialogChannelData) objectRef2.element).setSelectorTitle(channelListData.getSelectorTitle());
            ((ShopDialogChannelData) objectRef2.element).setServerDefaultChannelId(channelListData.getDefaultChannelId() > 0);
            if (((ShopDialogChannelData) objectRef2.element).isServerDefaultChannelId()) {
                ((ShopDialogChannelData) objectRef2.element).setDefaultChannel(new Channel(channelListData.getDefaultGroupId(), Boxing.boxInt(channelListData.getDefaultChannelId()), channelListData.getDefaultChannelName(), Boxing.boxDouble(0.0d), Boxing.boxBoolean(false)));
            }
            if (channelListData.getChannelGroups() == null || !(!channelListData.getChannelGroups().isEmpty())) {
                List<Channel> channels = channelListData.getChannels();
                if (channels != null) {
                    Collection collection = channels;
                    if (!collection.isEmpty()) {
                        if (((ShopDialogChannelData) objectRef2.element).getDefaultChannel() == null) {
                            ((ShopDialogChannelData) objectRef2.element).setDefaultChannel(channels.get(0));
                        }
                        ((List) objectRef.element).addAll(collection);
                    }
                }
            } else {
                int i2 = 0;
                for (Object next : channelListData.getChannelGroups()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ChannelGroup channelGroup = (ChannelGroup) next;
                    List<Channel> channels2 = channelGroup.getChannels();
                    if (channels2 != null) {
                        Collection collection2 = channels2;
                        if (!collection2.isEmpty()) {
                            CharSequence name = channelGroup.getName();
                            if (!(name == null || name.length() == 0)) {
                                ((List) objectRef.element).add(channelGroup);
                            }
                            if (!((ShopDialogChannelData) objectRef2.element).isServerDefaultChannelId() && ((ShopDialogChannelData) objectRef2.element).getDefaultChannel() == null) {
                                ((ShopDialogChannelData) objectRef2.element).setDefaultChannel(channels2.get(0));
                            }
                            ((List) objectRef.element).addAll(collection2);
                        }
                    }
                    i2 = i3;
                }
            }
        }
        ((ShopDialogChannelData) objectRef2.element).setList((List) objectRef.element);
        this.this$0.getMChannelList().postSuccess(objectRef2.element);
        XesLog.dt("ShopHomeNativeVm", new Object[]{"getChannelList success"});
        return Unit.INSTANCE;
    }
}
