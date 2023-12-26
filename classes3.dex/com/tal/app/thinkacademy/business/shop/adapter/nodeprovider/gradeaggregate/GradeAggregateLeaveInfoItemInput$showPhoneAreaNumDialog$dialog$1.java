package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "select", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemInput.kt */
final class GradeAggregateLeaveInfoItemInput$showPhoneAreaNumDialog$dialog$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ BaseNodeAdapter $adapter;
    final /* synthetic */ List<ConfigInfo.Country> $countryList;
    final /* synthetic */ BaseViewHolder $helper;
    final /* synthetic */ UserLeaveComponentData $item;
    final /* synthetic */ GradeAggregateLeaveInfoItemInput this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateLeaveInfoItemInput$showPhoneAreaNumDialog$dialog$1(List<ConfigInfo.Country> list, BaseViewHolder baseViewHolder, GradeAggregateLeaveInfoItemInput gradeAggregateLeaveInfoItemInput, BaseNodeAdapter baseNodeAdapter, UserLeaveComponentData userLeaveComponentData) {
        super(2);
        this.$countryList = list;
        this.$helper = baseViewHolder;
        this.this$0 = gradeAggregateLeaveInfoItemInput;
        this.$adapter = baseNodeAdapter;
        this.$item = userLeaveComponentData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str) {
        List<ConfigInfo.Country> list = this.$countryList;
        if (list != null) {
            BaseViewHolder baseViewHolder = this.$helper;
            GradeAggregateLeaveInfoItemInput gradeAggregateLeaveInfoItemInput = this.this$0;
            GradeAggregateAdapter gradeAggregateAdapter = this.$adapter;
            UserLeaveComponentData userLeaveComponentData = this.$item;
            if ((!list.isEmpty()) && list.size() > i) {
                ConfigInfo.Country country = list.get(i);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = gradeAggregateLeaveInfoItemInput.getContext().getString(R.string.Login_format_call_code);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.Login_format_call_code)");
                String format = String.format(string, Arrays.copyOf(new Object[]{country.getCountryCallingCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                ((TextView) baseViewHolder.getView(R.id.text_phone_prefix)).setText(format);
                GradeAggregateAdapter gradeAggregateAdapter2 = gradeAggregateAdapter;
                gradeAggregateAdapter2.setMChosenCountryIndex(i);
                gradeAggregateAdapter2.setMPhoneAreaNum(country.getCountryCallingCode());
                gradeAggregateAdapter2.setMPhoneLengthMin(country.getPhoneMinLength());
                gradeAggregateAdapter2.setMPhoneLengthMax(country.getPhoneMaxLength());
                gradeAggregateLeaveInfoItemInput.setAreaInfo(userLeaveComponentData, gradeAggregateAdapter2);
            }
        }
    }
}
