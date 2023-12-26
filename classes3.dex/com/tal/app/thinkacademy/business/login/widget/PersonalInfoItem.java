package com.tal.app.thinkacademy.business.login.widget;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.business.login.databinding.PersonalInfoItemLayoutBinding;
import com.tal.app.thinkacademy.business.login.entity.LinkedAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/PersonalInfoItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/tal/app/thinkacademy/business/login/databinding/PersonalInfoItemLayoutBinding;", "mInfo", "Lcom/tal/app/thinkacademy/business/login/entity/LinkedAccount;", "getLinkAccount", "setData", "", "info", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoItem.kt */
public final class PersonalInfoItem extends FrameLayout {
    private PersonalInfoItemLayoutBinding mBinding;
    private LinkedAccount mInfo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalInfoItem(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalInfoItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PersonalInfoItem(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalInfoItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        PersonalInfoItemLayoutBinding inflate = PersonalInfoItemLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context),this,true)");
        this.mBinding = inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r4 = r8.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setData(com.tal.app.thinkacademy.business.login.entity.LinkedAccount r8) {
        /*
            r7 = this;
            r7.mInfo = r8
            com.tal.app.thinkacademy.business.login.databinding.PersonalInfoItemLayoutBinding r0 = r7.mBinding
            java.lang.String r1 = "mBinding"
            r2 = 0
            if (r0 != 0) goto L_0x000d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000d:
            android.widget.TextView r0 = r0.itemTitle
            java.lang.String r3 = ""
            if (r8 != 0) goto L_0x0017
        L_0x0013:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            goto L_0x0020
        L_0x0017:
            java.lang.String r4 = r8.getName()
            if (r4 != 0) goto L_0x001e
            goto L_0x0013
        L_0x001e:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L_0x0020:
            r0.setText(r4)
            com.tal.app.thinkacademy.business.login.databinding.PersonalInfoItemLayoutBinding r0 = r7.mBinding
            if (r0 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x002b:
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.itemEt
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r7.getContext()
            int r6 = com.tal.app.thinkacademy.business.login.R.string.personal_contact_edit
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            r5 = 32
            r4.append(r5)
            if (r8 != 0) goto L_0x0047
            goto L_0x004f
        L_0x0047:
            java.lang.String r5 = r8.getName()
            if (r5 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r3 = r5
        L_0x004f:
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setHint(r3)
            com.tal.app.thinkacademy.business.login.databinding.PersonalInfoItemLayoutBinding r0 = r7.mBinding
            if (r0 != 0) goto L_0x0063
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0063:
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.itemEt
            if (r8 != 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            java.lang.String r2 = r8.getValue()
        L_0x006c:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.widget.PersonalInfoItem.setData(com.tal.app.thinkacademy.business.login.entity.LinkedAccount):void");
    }

    public final LinkedAccount getLinkAccount() {
        LinkedAccount linkedAccount = this.mInfo;
        if (linkedAccount != null) {
            PersonalInfoItemLayoutBinding personalInfoItemLayoutBinding = this.mBinding;
            CharSequence charSequence = null;
            if (personalInfoItemLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                personalInfoItemLayoutBinding = null;
            }
            Editable text = personalInfoItemLayoutBinding.itemEt.getText();
            if (text != null) {
                charSequence = StringsKt.trim(text);
            }
            linkedAccount.setValue(String.valueOf(charSequence));
        }
        return this.mInfo;
    }
}
