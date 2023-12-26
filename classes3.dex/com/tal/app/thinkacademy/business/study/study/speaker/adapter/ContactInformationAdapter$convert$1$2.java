package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import com.tal.app.thinkacademy.business.study.study.entity.ContactInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactInformationAdapter.kt */
final class ContactInformationAdapter$convert$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ContactInfo $item;
    final /* synthetic */ ContactInformationAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactInformationAdapter$convert$1$2(ContactInformationAdapter contactInformationAdapter, ContactInfo contactInfo) {
        super(0);
        this.this$0 = contactInformationAdapter;
        this.$item = contactInfo;
    }

    public final void invoke() {
        Function1<ContactInfo, Unit> listener = this.this$0.getListener();
        if (listener != null) {
            listener.invoke(this.$item);
        }
    }
}
