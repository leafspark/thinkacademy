package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.entity.ContactInfo;
import com.tal.app.thinkacademy.business.study.study.entity.ContactInfoDetail;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/ContactInformationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "listener", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "convert", "holder", "item", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactInformationAdapter.kt */
public final class ContactInformationAdapter extends BaseQuickAdapter<ContactInfo, BaseViewHolder> {
    private Function1<? super ContactInfo, Unit> listener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactInformationAdapter(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function1);
    }

    public final Function1<ContactInfo, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(Function1<? super ContactInfo, Unit> function1) {
        this.listener = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContactInformationAdapter(List<ContactInfo> list, Function1<? super ContactInfo, Unit> function1) {
        super(R.layout.item_contact_information, list);
        Intrinsics.checkNotNullParameter(list, "list");
        this.listener = function1;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, ContactInfo contactInfo) {
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        ContactInfo contactInfo2 = contactInfo;
        Intrinsics.checkNotNullParameter(baseViewHolder2, "holder");
        Intrinsics.checkNotNullParameter(contactInfo2, "item");
        int i = 0;
        if (getItemPosition(contactInfo2) == getData().size() - 1) {
            baseViewHolder2.getView(R.id.contact_item_root).getDelegate().setCornerRadius_BL(SizeUtils.dp2px(10.0f));
            baseViewHolder2.getView(R.id.contact_item_root).getDelegate().setCornerRadius_BR(SizeUtils.dp2px(10.0f));
        } else {
            baseViewHolder2.getView(R.id.contact_item_root).getDelegate().setCornerRadius_BL(0);
            baseViewHolder2.getView(R.id.contact_item_root).getDelegate().setCornerRadius_BR(0);
        }
        String type = contactInfo.getType();
        if (Intrinsics.areEqual((Object) type, (Object) ContactInfoType.weChat.getTypeName())) {
            ((ImageView) baseViewHolder2.getView(R.id.ivContactInfo)).setImageResource(R.drawable.icon_wechat_big);
        } else if (Intrinsics.areEqual((Object) type, (Object) ContactInfoType.whatsApp.getTypeName())) {
            ((ImageView) baseViewHolder2.getView(R.id.ivContactInfo)).setImageResource(R.drawable.icon_whatsapp_big);
        } else if (Intrinsics.areEqual((Object) type, (Object) ContactInfoType.line.getTypeName())) {
            ((ImageView) baseViewHolder2.getView(R.id.ivContactInfo)).setImageResource(R.drawable.icon_line_big);
        }
        TextView textView = (TextView) baseViewHolder2.getView(R.id.textViewCopyCommon);
        textView.getPaint().setFlags(8);
        textView.getPaint().setAntiAlias(true);
        ContactInfoDetail value = contactInfo.getValue();
        String str = null;
        CharSequence account = value == null ? null : value.getAccount();
        if (account == null || StringsKt.isBlank(account)) {
            baseViewHolder2.getView(R.id.accountLayout).setVisibility(8);
            baseViewHolder2.getView(R.id.wechatCopyLayout).setVisibility(8);
        } else {
            TextView textView2 = (TextView) baseViewHolder2.getView(R.id.tvAccountNumber);
            ContactInfoDetail value2 = contactInfo.getValue();
            textView2.setText(value2 == null ? null : value2.getAccount());
            baseViewHolder2.getView(R.id.accountLayout).setVisibility(0);
            if (Intrinsics.areEqual((Object) ContactInfoType.weChat.getTypeName(), (Object) contactInfo.getType())) {
                baseViewHolder2.setGone(R.id.wechatCopyLayout, false);
                TextView textView3 = (TextView) baseViewHolder2.getView(R.id.wechatCopyDesc);
                textView3.getPaint().setFlags(8);
                textView3.getPaint().setAntiAlias(true);
                baseViewHolder2.setGone(R.id.textViewCopyCommon, true);
                baseViewHolder2.setGone(R.id.imageViewCopyCommon, true);
            } else {
                baseViewHolder2.setGone(R.id.wechatCopyLayout, true);
                baseViewHolder2.setGone(R.id.textViewCopyCommon, false);
                baseViewHolder2.setGone(R.id.imageViewCopyCommon, false);
            }
        }
        ContactInfoDetail value3 = contactInfo.getValue();
        CharSequence qrCode = value3 == null ? null : value3.getQrCode();
        if (qrCode == null || StringsKt.isBlank(qrCode)) {
            baseViewHolder2.getView(R.id.ivQRCode).setVisibility(8);
            baseViewHolder2.getView(R.id.qrDescLayout).setVisibility(8);
        } else {
            XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
            ImageView imageView = (ImageView) baseViewHolder2.getView(R.id.ivQRCode);
            Context context = getContext();
            ContactInfoDetail value4 = contactInfo.getValue();
            if (value4 != null) {
                str = value4.getQrCode();
            }
            XesImageLoader.loadImageNormal$default(xesImageLoader, imageView, context, str, R.drawable.default_image_loading, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
            baseViewHolder2.getView(R.id.ivQRCode).setVisibility(0);
            View view = baseViewHolder2.getView(R.id.qrDescLayout);
            if (!Intrinsics.areEqual((Object) ContactInfoType.weChat.getTypeName(), (Object) contactInfo.getType())) {
                i = 8;
            }
            view.setVisibility(i);
        }
        RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(baseViewHolder2.getView(R.id.accountLayout), 500, new ContactInformationAdapter$convert$1$1(this, contactInfo2));
        RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(baseViewHolder2.getView(R.id.wechatCopyLayout), 500, new ContactInformationAdapter$convert$1$2(this, contactInfo2));
    }
}
