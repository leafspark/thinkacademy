package com.tal.app.thinkacademy.business.shop.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a0\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001c"}, d2 = {"mDecimalFormat", "Ljava/text/DecimalFormat;", "mTagArray", "", "Lcom/tal/app/thinkacademy/business/shop/adapter/ClassTagRes;", "[Lcom/tal/app/thinkacademy/business/shop/adapter/ClassTagRes;", "classItemBind", "", "context", "Landroid/content/Context;", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "schoolCode", "", "classPrice", "isFull", "", "getTagResIndex", "", "remainSellTime", "store", "sellStore", "makePrice", "currencyDesc", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "price", "bus_shop_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListAdapter.kt */
public final class ClassListAdapterKt {
    private static final DecimalFormat mDecimalFormat = new DecimalFormat("#####.##");
    private static final ClassTagRes[] mTagArray = {new ClassTagRes(R.string.New, R.drawable.bus_shop_shape_bg_class_tag_ffaa0a), new ClassTagRes(R.string.coming_soon, R.drawable.bus_shop_shape_bg_class_tag_02ca8a), new ClassTagRes(R.string.popular, R.drawable.bus_shop_shape_bg_class_tag_ffc300), new ClassTagRes(R.string.count_left, R.drawable.bus_shop_shape_bg_class_tag_3370ff), new ClassTagRes(R.string.full, R.drawable.bus_shop_shape_bg_class_tag_ff5463)};

    private static final int getTagResIndex(int i, int i2, int i3) {
        boolean z = true;
        if (i > 1000) {
            return 1;
        }
        float f = (((float) i3) * 1.0f) / ((float) i2);
        double d = (double) f;
        if (0.0d <= d && d <= 0.25d) {
            return 0;
        }
        if (0.25d <= d && d <= 0.5d) {
            return 2;
        }
        if (f != 1.0f) {
            z = false;
        }
        return z ? 4 : 3;
    }

    public static final void classItemBind(Context context, BaseViewHolder baseViewHolder, ShopClassGoodsData shopClassGoodsData, String str) {
        String str2;
        CharSequence charSequence;
        String str3;
        ShopClassTeacherData shopClassTeacherData;
        ShopClassTeacherData shopClassTeacherData2;
        Context context2 = context;
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        ShopClassGoodsData shopClassGoodsData2 = shopClassGoodsData;
        String str4 = str;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(baseViewHolder2, "holder");
        Intrinsics.checkNotNullParameter(shopClassGoodsData2, "item");
        Intrinsics.checkNotNullParameter(str4, "schoolCode");
        baseViewHolder2.setText(R.id.tv_class_name, shopClassGoodsData.getTitle());
        int store = shopClassGoodsData.getStore();
        if (store > 1) {
            str2 = context2.getString(R.string.spaces);
        } else {
            str2 = context2.getString(R.string.space);
        }
        String stringPlus = Intrinsics.stringPlus("%s ", str2);
        int i = R.id.tv_class_space;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[1];
        if (store > 999) {
            store = 999;
        }
        int i2 = 0;
        objArr[0] = Integer.valueOf(store);
        String format = String.format(stringPlus, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        baseViewHolder2.setText(i, format);
        int store2 = shopClassGoodsData.getStore() - shopClassGoodsData.getSellStore();
        TextView textView = (TextView) baseViewHolder2.getView(R.id.tv_class_tag);
        int tagResIndex = getTagResIndex(shopClassGoodsData.getRemainSellTime(), shopClassGoodsData.getStore(), shopClassGoodsData.getSellStore());
        ClassTagRes classTagRes = mTagArray[tagResIndex];
        String string = context2.getString(classTagRes.getTextRes());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(tagRes.textRes)");
        if (tagResIndex == 3) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(store2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            charSequence = format2;
        } else {
            charSequence = string;
        }
        textView.setText(charSequence);
        textView.setBackground(ContextCompat.getDrawable(context2, classTagRes.getBgRes()));
        classPrice(context2, baseViewHolder2, shopClassGoodsData2, tagResIndex == 4, str4);
        ShopClassGoodsSpecData spec = shopClassGoodsData.getSpec();
        if (spec != null) {
            int i3 = R.id.tv_class_form;
            if (Intrinsics.areEqual((Object) spec.getPlatformType(), (Object) "3")) {
                str3 = context2.getString(R.string.in_person);
            } else {
                str3 = context2.getString(R.string.online);
            }
            baseViewHolder2.setText(i3, str3);
            baseViewHolder2.setText(R.id.tv_class_difficulty, context2.getString(R.string.difficulty));
            baseViewHolder2.getView(R.id.ratingbar_class_difficulty).setProgress(spec.getLevelDegreeStar() * 2);
            baseViewHolder2.setText(R.id.tv_class_date, spec.getStartDate() + " - " + spec.getEndDate());
            baseViewHolder2.setText(R.id.tv_class_time, spec.getTimeDesc());
            List arrayList = new ArrayList();
            List<ShopClassTeacherData> teacherList = spec.getTeacherList();
            if (teacherList != null) {
                if (teacherList.isEmpty()) {
                    teacherList = null;
                }
                if (teacherList != null) {
                    Boolean.valueOf(arrayList.addAll(teacherList));
                }
            }
            List<ShopClassTeacherData> tutorList = spec.getTutorList();
            if (tutorList != null) {
                if (tutorList.isEmpty()) {
                    tutorList = null;
                }
                if (tutorList != null) {
                    Boolean.valueOf(arrayList.addAll(tutorList));
                }
            }
            if (arrayList.size() < 3) {
                baseViewHolder2.setVisible(R.id.layout_teacher, true);
                baseViewHolder2.setVisible(R.id.layout_more_teacher, false);
                ConfigInfo.TeacherName schoolTeacherName = SchoolConstants.INSTANCE.getSchoolTeacherName(str4);
                List arrayList2 = new ArrayList();
                arrayList2.add(Integer.valueOf(R.id.teacher_root_1));
                arrayList2.add(Integer.valueOf(R.id.teacher_root_2));
                int i4 = 0;
                for (Object next : arrayList2) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    int intValue = ((Number) next).intValue();
                    if (i4 < arrayList.size()) {
                        baseViewHolder2.setGone(intValue, false);
                    } else {
                        baseViewHolder2.setGone(intValue, true);
                    }
                    i4 = i5;
                }
                List list = arrayList.size() > 0 ? arrayList : null;
                if (!(list == null || (shopClassTeacherData2 = (ShopClassTeacherData) list.get(0)) == null)) {
                    XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder2.getView(R.id.iv_teacher_avatar_1), context, shopClassTeacherData2.getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false);
                    baseViewHolder2.setText(R.id.tv_teacher_name_1, shopClassTeacherData2.getSysName());
                    baseViewHolder2.setText(R.id.tv_teacher_role_1, shopClassTeacherData2.getTeacherType() == 1 ? schoolTeacherName.getLecturerTitle() : schoolTeacherName.getAssistantTitle());
                }
                if (arrayList.size() > 1) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    arrayList = null;
                }
                if (arrayList != null && (shopClassTeacherData = (ShopClassTeacherData) arrayList.get(1)) != null) {
                    XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder2.getView(R.id.iv_teacher_avatar_2), context, shopClassTeacherData.getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false);
                    baseViewHolder2.setText(R.id.tv_teacher_name_2, shopClassTeacherData.getSysName());
                    baseViewHolder2.setText(R.id.tv_teacher_role_2, shopClassTeacherData.getTeacherType() == 1 ? schoolTeacherName.getLecturerTitle() : schoolTeacherName.getAssistantTitle());
                    return;
                }
                return;
            }
            baseViewHolder2.setVisible(R.id.layout_teacher, false);
            baseViewHolder2.setVisible(R.id.layout_more_teacher, true);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_1));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_2));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_3));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_4));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_5));
            arrayList3.add(baseViewHolder2.getView(R.id.iv_teacher_avatar_group_6));
            int i6 = 0;
            for (Object next2 : arrayList3) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ImageView imageView = (ImageView) next2;
                if (i6 < arrayList.size()) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                i6 = i7;
            }
            if (arrayList.size() > 5) {
                while (i2 < 5) {
                    XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
                    Object obj = arrayList3.get(i2);
                    Intrinsics.checkNotNullExpressionValue(obj, "avatarList[i]");
                    xesImageLoader.loadCircleWithBorderImage((ImageView) obj, context, ((ShopClassTeacherData) arrayList.get(i2)).getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false);
                    i2++;
                }
                ((ImageView) arrayList3.get(5)).setImageResource(R.drawable.bus_shop_ic_avatar_more);
            } else {
                int size = arrayList.size();
                while (i2 < size) {
                    XesImageLoader xesImageLoader2 = XesImageLoader.INSTANCE;
                    Object obj2 = arrayList3.get(i2);
                    Intrinsics.checkNotNullExpressionValue(obj2, "avatarList[i]");
                    XesImageLoader.loadCircleWithBorderImage$default(xesImageLoader2, (ImageView) obj2, context, ((ShopClassTeacherData) arrayList.get(i2)).getAvatar(), 1, context2.getColor(R.color.color_DEE2E7), R.drawable.circle_user_default_image, false, 32, (Object) null);
                    i2++;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void classPrice(android.content.Context r7, com.chad.library.adapter.base.viewholder.BaseViewHolder r8, com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData r9, boolean r10, java.lang.String r11) {
        /*
            com.tal.app.thinkacademy.common.constants.SchoolConstants r0 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CurrencyDesc r11 = r0.getSchoolCurrency(r11)
            int r0 = r9.getPerShowPrice()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0028
            int r4 = r9.getPerOrgPrice()
            int r5 = r9.getPerShowPrice()
            if (r4 <= r5) goto L_0x003b
            int r4 = r9.getPerOrgPrice()
            java.lang.String r4 = makePrice(r11, r4)
            goto L_0x003c
        L_0x0028:
            int r4 = r9.getOrgPrice()
            int r5 = r9.getShowPrice()
            if (r4 <= r5) goto L_0x003b
            int r4 = r9.getOrgPrice()
            java.lang.String r4 = makePrice(r11, r4)
            goto L_0x003c
        L_0x003b:
            r4 = r3
        L_0x003c:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r5 = r9.getSpec()
            if (r5 != 0) goto L_0x0043
            goto L_0x004f
        L_0x0043:
            int r6 = r5.getLeftLesson()
            int r5 = r5.getLessonCount()
            if (r6 != r5) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r4 = r3
        L_0x004f:
            if (r0 == 0) goto L_0x005a
            int r7 = r9.getPerShowPrice()
            java.lang.String r7 = makePrice(r11, r7)
            goto L_0x0076
        L_0x005a:
            int r5 = r9.getShowPrice()
            if (r5 > 0) goto L_0x0067
            int r9 = com.tal.app.thinkacademy.business.shop.R.string.free
            java.lang.String r7 = r7.getString(r9)
            goto L_0x0070
        L_0x0067:
            int r7 = r9.getShowPrice()
            java.lang.String r7 = makePrice(r11, r7)
            r3 = r4
        L_0x0070:
            java.lang.String r9 = "{\n        if (item.showP…howPrice)\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            r4 = r3
        L_0x0076:
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.layout_price
            if (r10 == 0) goto L_0x007d
            int r11 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_shape_bg_stroke_f4f6fa
            goto L_0x007f
        L_0x007d:
            int r11 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_shape_bg_stroke_fff9ec
        L_0x007f:
            r8.setBackgroundResource(r9, r11)
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.tv_org_price
            android.view.View r9 = r8.getView(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r11 = r4.length()
            if (r11 <= 0) goto L_0x0094
            r11 = r1
            goto L_0x0095
        L_0x0094:
            r11 = r2
        L_0x0095:
            r3 = 8
            if (r11 == 0) goto L_0x00a9
            r9.setVisibility(r2)
            android.text.TextPaint r11 = r9.getPaint()
            r5 = 16
            r11.setFlags(r5)
            r9.setText(r4)
            goto L_0x00ac
        L_0x00a9:
            r9.setVisibility(r3)
        L_0x00ac:
            int r9 = com.tal.app.thinkacademy.business.shop.R.id.tv_show_price
            android.view.View r9 = r8.getView(r9)
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r9 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r9
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r9.setText(r7)
            r7 = r10 ^ 1
            r9.setHasData(r7)
            int r7 = com.tal.app.thinkacademy.business.shop.R.id.tv_price_company
            android.view.View r7 = r8.getView(r7)
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r7 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r7
            if (r0 == 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r2 = r3
        L_0x00ca:
            r7.setVisibility(r2)
            r8 = r10 ^ 1
            r7.setHasData(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.adapter.ClassListAdapterKt.classPrice(android.content.Context, com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData, boolean, java.lang.String):void");
    }

    private static final String makePrice(ConfigInfo.CurrencyDesc currencyDesc, int i) {
        return Intrinsics.stringPlus(currencyDesc.getSymbol(), mDecimalFormat.format(Float.valueOf((((float) i) * 1.0f) / ((float) currencyDesc.getMinorUnit()))));
    }
}
