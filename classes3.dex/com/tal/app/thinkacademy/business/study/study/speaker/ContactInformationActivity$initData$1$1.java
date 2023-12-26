package com.tal.app.thinkacademy.business.study.study.speaker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tal.app.thinkacademy.business.study.study.entity.ContactInfo;
import com.tal.app.thinkacademy.business.study.study.entity.ContactInfoDetail;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.ContactInfoType;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.utils.ClipboardUtilKt;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactInformationActivity.kt */
final class ContactInformationActivity$initData$1$1 extends Lambda implements Function1<ContactInfo, Unit> {
    final /* synthetic */ ContactInformationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactInformationActivity$initData$1$1(ContactInformationActivity contactInformationActivity) {
        super(1);
        this.this$0 = contactInformationActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContactInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContactInfo contactInfo) {
        Intrinsics.checkNotNullParameter(contactInfo, "it");
        Context context = (Context) this.this$0;
        ContactInfoDetail value = contactInfo.getValue();
        ClipboardUtilKt.copyClipboard(context, value == null ? null : value.getAccount());
        ToastUtils.setGravity(17, 0, 0);
        String type = contactInfo.getType();
        if (Intrinsics.areEqual((Object) type, (Object) ContactInfoType.weChat.getTypeName())) {
            ToastUtils.showShort(this.this$0.getString(R.string.copy_succeeded), new Object[0]);
            try {
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("weixin://")));
            } catch (Exception unused) {
            }
        } else if (Intrinsics.areEqual((Object) type, (Object) ContactInfoType.whatsApp.getTypeName())) {
            ToastUtils.showShort(this.this$0.getString(R.string.copy_succeeded), new Object[0]);
        } else if (Intrinsics.areEqual((Object) type, (Object) ContactInfoType.line.getTypeName())) {
            ToastUtils.showShort(this.this$0.getString(R.string.copy_succeeded), new Object[0]);
        }
    }
}
