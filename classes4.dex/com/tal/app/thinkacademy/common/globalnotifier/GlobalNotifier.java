package com.tal.app.thinkacademy.common.globalnotifier;

import com.tal.app.thinkacademy.common.globalnotifier.listener.OnGlobalNotifier;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/globalnotifier/GlobalNotifier;", "", "()V", "sSubscriberList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/common/globalnotifier/listener/OnGlobalNotifier;", "Lkotlin/collections/ArrayList;", "publish", "", "type", "Lcom/tal/app/thinkacademy/common/globalnotifier/TNotifyType;", "data", "subscribe", "subscriber", "unSubscribe", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlobalNotifier.kt */
public final class GlobalNotifier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<GlobalNotifier> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GlobalNotifier$Companion$instance$2.INSTANCE);
    private ArrayList<OnGlobalNotifier> sSubscriberList;

    public /* synthetic */ GlobalNotifier(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void publish(TNotifyType tNotifyType) {
        Intrinsics.checkNotNullParameter(tNotifyType, "type");
        publish$default(this, tNotifyType, (Object) null, 2, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/globalnotifier/GlobalNotifier$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/globalnotifier/GlobalNotifier;", "getInstance", "()Lcom/tal/app/thinkacademy/common/globalnotifier/GlobalNotifier;", "instance$delegate", "Lkotlin/Lazy;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GlobalNotifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalNotifier getInstance() {
            return (GlobalNotifier) GlobalNotifier.instance$delegate.getValue();
        }
    }

    private GlobalNotifier() {
        this.sSubscriberList = new ArrayList<>();
    }

    public final synchronized void subscribe(OnGlobalNotifier onGlobalNotifier) {
        Intrinsics.checkNotNullParameter(onGlobalNotifier, "subscriber");
        ArrayList<OnGlobalNotifier> arrayList = this.sSubscriberList;
        if (arrayList != null) {
            arrayList.add(onGlobalNotifier);
        }
    }

    public final synchronized void unSubscribe(OnGlobalNotifier onGlobalNotifier) {
        Intrinsics.checkNotNullParameter(onGlobalNotifier, "subscriber");
        ArrayList<OnGlobalNotifier> arrayList = this.sSubscriberList;
        if (arrayList != null) {
            arrayList.remove(onGlobalNotifier);
        }
    }

    public static /* synthetic */ void publish$default(GlobalNotifier globalNotifier, TNotifyType tNotifyType, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        globalNotifier.publish(tNotifyType, obj);
    }

    public final synchronized void publish(TNotifyType tNotifyType, Object obj) {
        Intrinsics.checkNotNullParameter(tNotifyType, "type");
        ArrayList<OnGlobalNotifier> arrayList = this.sSubscriberList;
        if (arrayList != null) {
            int i = 0;
            ArrayList<OnGlobalNotifier> arrayList2 = arrayList.size() > 0 ? arrayList : null;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        arrayList.get(i).onGlobalNotify(tNotifyType, obj);
                        if (i == size) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
        }
    }
}
