package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.RecordedSpec;
import com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\r"}, d2 = {"makePrice", "", "schoolCode", "price", "", "recordedClassItemBind", "", "context", "Landroid/content/Context;", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRecordedItemData;", "bus_shop_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherRecordedCardNodeProvider.kt */
public final class TeacherRecordedCardNodeProviderKt {
    public static final void recordedClassItemBind(Context context, BaseViewHolder baseViewHolder, ShopRecordedItemData shopRecordedItemData, String str) {
        RecordedTeacherItem recordedTeacherItem;
        RecordedTeacherItem recordedTeacherItem2;
        List<RecordedTeacherItem> teacherList;
        Integer lessonCount;
        Integer lessonCount2;
        Context context2 = context;
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        String str2 = str;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(baseViewHolder2, "holder");
        Intrinsics.checkNotNullParameter(shopRecordedItemData, "item");
        Intrinsics.checkNotNullParameter(str2, "schoolCode");
        baseViewHolder2.setText(R.id.tvClassName, shopRecordedItemData.getTitle());
        int i = R.id.tvDiscipline;
        RecordedSpec spec = shopRecordedItemData.getSpec();
        List list = null;
        CharSequence subject = spec == null ? null : spec.getSubject();
        int i2 = 0;
        baseViewHolder2.setGone(i, subject == null || StringsKt.isBlank(subject));
        int i3 = R.id.tvDiscipline;
        RecordedSpec spec2 = shopRecordedItemData.getSpec();
        baseViewHolder2.setText(i3, spec2 == null ? null : spec2.getSubject());
        int i4 = R.id.tvLessonsCount;
        RecordedSpec spec3 = shopRecordedItemData.getSpec();
        baseViewHolder2.setGone(i4, ((spec3 != null && (lessonCount2 = spec3.getLessonCount()) != null) ? lessonCount2.intValue() : 0) <= 0);
        int i5 = R.id.tvLessonsCount;
        StringBuilder sb = new StringBuilder();
        RecordedSpec spec4 = shopRecordedItemData.getSpec();
        sb.append(spec4 == null ? null : spec4.getLessonCount());
        sb.append(' ');
        RecordedSpec spec5 = shopRecordedItemData.getSpec();
        sb.append(context2.getString(((spec5 != null && (lessonCount = spec5.getLessonCount()) != null) ? lessonCount.intValue() : 1) > 1 ? R.string.lessons : R.string.single_lesson));
        baseViewHolder2.setText(i5, sb.toString());
        Integer showOrgPrice = shopRecordedItemData.getShowOrgPrice();
        int intValue = showOrgPrice == null ? 0 : showOrgPrice.intValue();
        Integer showPrice = shopRecordedItemData.getShowPrice();
        int intValue2 = showPrice == null ? 0 : showPrice.intValue();
        baseViewHolder2.setText(R.id.tvOrgPrice, makePrice(str2, intValue));
        ((TextView) baseViewHolder2.getView(R.id.tvOrgPrice)).getPaint().setFlags(16);
        baseViewHolder2.setText(R.id.tvShowPrice, intValue2 <= 0 ? context2.getString(R.string.free) : makePrice(str2, intValue2));
        baseViewHolder2.setGone(R.id.tvOrgPrice, intValue <= intValue2);
        List arrayList = new ArrayList();
        RecordedSpec spec6 = shopRecordedItemData.getSpec();
        if (!(spec6 == null || (teacherList = spec6.getTeacherList()) == null)) {
            if (teacherList.isEmpty()) {
                teacherList = null;
            }
            if (teacherList != null) {
                arrayList.addAll(teacherList);
            }
        }
        if (arrayList.size() <= 0) {
            baseViewHolder2.setVisible(R.id.layout_teacher, false);
            baseViewHolder2.setGone(R.id.layout_more_teacher, true);
        } else if (arrayList.size() < 3) {
            baseViewHolder2.setGone(R.id.layout_teacher, false);
            baseViewHolder2.setGone(R.id.layout_more_teacher, true);
            ConfigInfo.TeacherName schoolTeacherName = SchoolConstants.INSTANCE.getSchoolTeacherName(str2);
            List arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(R.id.teacher_root_1));
            arrayList2.add(Integer.valueOf(R.id.teacher_root_2));
            int i6 = 0;
            for (Object next : arrayList2) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int intValue3 = ((Number) next).intValue();
                if (i6 < arrayList.size()) {
                    baseViewHolder2.setGone(intValue3, false);
                } else {
                    baseViewHolder2.setGone(intValue3, true);
                }
                i6 = i7;
            }
            List list2 = arrayList.size() > 0 ? arrayList : null;
            if (!(list2 == null || (recordedTeacherItem2 = (RecordedTeacherItem) list2.get(0)) == null)) {
                XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder2.getView(R.id.iv_teacher_avatar_1), context, recordedTeacherItem2.getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false);
                baseViewHolder2.setText(R.id.tv_teacher_name_1, recordedTeacherItem2.getSysName());
                int i8 = R.id.tv_teacher_role_1;
                Integer teacherType = recordedTeacherItem2.getTeacherType();
                baseViewHolder2.setText(i8, (teacherType != null && teacherType.intValue() == 1) ? schoolTeacherName.getLecturerTitle() : schoolTeacherName.getAssistantTitle());
            }
            if (arrayList.size() > 1) {
                i2 = 1;
            }
            if (i2 != 0) {
                list = arrayList;
            }
            if (list != null && (recordedTeacherItem = (RecordedTeacherItem) list.get(1)) != null) {
                XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder2.getView(R.id.iv_teacher_avatar_2), context, recordedTeacherItem.getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false);
                baseViewHolder2.setText(R.id.tv_teacher_name_2, recordedTeacherItem.getSysName());
                int i9 = R.id.tv_teacher_role_2;
                Integer teacherType2 = recordedTeacherItem.getTeacherType();
                baseViewHolder2.setText(i9, (teacherType2 != null && teacherType2.intValue() == 1) ? schoolTeacherName.getLecturerTitle() : schoolTeacherName.getAssistantTitle());
            }
        } else {
            baseViewHolder2.setGone(R.id.layout_teacher, true);
            baseViewHolder2.setGone(R.id.layout_more_teacher, true);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_1));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_2));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_3));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_4));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_5));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_6));
            int i10 = 0;
            for (Object next2 : arrayList3) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ImageView imageView = (ImageView) next2;
                if (i10 < arrayList.size()) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                i10 = i11;
            }
            if (arrayList.size() > 5) {
                while (i2 < 5) {
                    XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
                    Object obj = arrayList3.get(i2);
                    Intrinsics.checkNotNullExpressionValue(obj, "avatarList[i]");
                    xesImageLoader.loadCircleWithBorderImage((ImageView) obj, context, ((RecordedTeacherItem) arrayList.get(i2)).getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false);
                    i2++;
                }
                ((ImageView) arrayList3.get(5)).setImageResource(R.drawable.bus_shop_ic_avatar_more);
                return;
            }
            int size = arrayList.size();
            while (i2 < size) {
                XesImageLoader xesImageLoader2 = XesImageLoader.INSTANCE;
                Object obj2 = arrayList3.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj2, "avatarList[i]");
                XesImageLoader.loadCircleWithBorderImage$default(xesImageLoader2, (ImageView) obj2, context, ((RecordedTeacherItem) arrayList.get(i2)).getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false, 32, (Object) null);
                i2++;
            }
        }
    }

    public static final String makePrice(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        ConfigInfo.CurrencyDesc schoolCurrency = SchoolConstants.INSTANCE.getSchoolCurrency(str);
        return Intrinsics.stringPlus(schoolCurrency.getSymbol(), new DecimalFormat("#####.##").format(Float.valueOf((((float) i) * 1.0f) / ((float) schoolCurrency.getMinorUnit()))));
    }
}
