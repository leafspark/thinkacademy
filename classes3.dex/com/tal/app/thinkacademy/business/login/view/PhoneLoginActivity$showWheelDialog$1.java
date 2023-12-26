package com.tal.app.thinkacademy.business.login.view;

import android.text.InputFilter;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneLoginActivity.kt */
final class PhoneLoginActivity$showWheelDialog$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ PhoneLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneLoginActivity$showWheelDialog$1(PhoneLoginActivity phoneLoginActivity) {
        super(1);
        this.this$0 = phoneLoginActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.this$0.mChosenCountryIndex = i;
        List access$getInternationalList = this.this$0.getInternationalList();
        Intrinsics.checkNotNull(access$getInternationalList);
        ConfigInfo.Country country = (ConfigInfo.Country) access$getInternationalList.get(this.this$0.mChosenCountryIndex);
        TextView textView = this.this$0.getBinding().tvCountryCode;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.this$0.getString(R.string.Login_format_call_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Login_format_call_code)");
        String format = String.format(string, Arrays.copyOf(new Object[]{country.getCountryCallingCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        this.this$0.mPhoneLengthMin = country.getPhoneMinLength();
        this.this$0.mPhoneLengthMax = country.getPhoneMaxLength();
        this.this$0.getBinding().etPhoneNumber.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.this$0.mPhoneLengthMax)});
        this.this$0.resetStatus();
    }
}
