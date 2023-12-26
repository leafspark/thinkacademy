package com.tal.app.thinkacademy.business.home.main.shop.provider;

import android.widget.ImageView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopHomeViewType;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course;
import com.tal.app.thinkacademy.business.home.main.shop.bean.Teacher;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J(\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J(\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J \u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/provider/ItemNormalNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "mSchoolCode", "", "mTeacherIdList", "", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "makePrice", "currencyDesc", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "price", "onClick", "view", "Landroid/view/View;", "data", "position", "reportCourseCard", "node", "setPrice", "isSame", "", "perShowPrice", "showPrice", "setTeacher", "mutableList", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Teacher;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemNormalNodeProvider.kt */
public final class ItemNormalNodeProvider extends BaseNodeProvider {
    private final String mSchoolCode = SchoolConstants.INSTANCE.schoolCode();
    private final List<Integer> mTeacherIdList;

    public ItemNormalNodeProvider() {
        List<Integer> arrayList = new ArrayList<>();
        this.mTeacherIdList = arrayList;
        arrayList.add(Integer.valueOf(R.id.teacher_1));
        arrayList.add(Integer.valueOf(R.id.teacher_2));
        arrayList.add(Integer.valueOf(R.id.teacher_3));
    }

    public int getItemViewType() {
        return ShopHomeViewType.ITEM_NORMAL_CARD.getValue();
    }

    public int getLayoutId() {
        return R.layout.shop_item_normal_layout;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        String str;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        int i = 0;
        if (baseNode instanceof ShopHomeDataType1Course) {
            ShopHomeDataType1Course shopHomeDataType1Course = (ShopHomeDataType1Course) baseNode;
            baseViewHolder.setText(R.id.main_title, shopHomeDataType1Course.getShowName());
            baseViewHolder.setText(R.id.sub_title, shopHomeDataType1Course.getSuitableStudents());
            CharSequence levelDegreeName = shopHomeDataType1Course.getLevelDegreeName();
            if (!(levelDegreeName == null || levelDegreeName.length() == 0)) {
                baseViewHolder.setText(R.id.sign_level_degree_name, shopHomeDataType1Course.getLevelDegreeName());
                baseViewHolder.setGone(R.id.sign_level_degree_name, false);
            } else {
                baseViewHolder.setGone(R.id.sign_level_degree_name, true);
            }
            baseViewHolder.setGone(R.id.sign_lesson_count, false);
            Integer lessonCount = shopHomeDataType1Course.getLessonCount();
            if ((lessonCount == null ? 0 : lessonCount.intValue()) > 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(shopHomeDataType1Course.getLessonCount());
                sb.append(' ');
                sb.append(getContext().getText(R.string.lessons));
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(shopHomeDataType1Course.getLessonCount());
                sb2.append(' ');
                sb2.append(getContext().getText(R.string.single_lesson));
                str = sb2.toString();
            }
            baseViewHolder.setText(R.id.sign_lesson_count, str);
            Boolean isSame = shopHomeDataType1Course.isSame();
            boolean booleanValue = isSame == null ? false : isSame.booleanValue();
            Integer perShowPrice = shopHomeDataType1Course.getPerShowPrice();
            int intValue = perShowPrice == null ? 0 : perShowPrice.intValue();
            Integer showPrice = shopHomeDataType1Course.getShowPrice();
            if (showPrice != null) {
                i = showPrice.intValue();
            }
            setPrice(baseViewHolder, booleanValue, intValue, i);
            setTeacher(baseViewHolder, shopHomeDataType1Course.getTeacherList());
        } else if (baseNode instanceof ShopHomeDataType12CourseConfig) {
            ShopHomeDataType12CourseConfig shopHomeDataType12CourseConfig = (ShopHomeDataType12CourseConfig) baseNode;
            baseViewHolder.setText(R.id.main_title, shopHomeDataType12CourseConfig.getName());
            baseViewHolder.setText(R.id.sub_title, shopHomeDataType12CourseConfig.getSuitableStudents());
            Collection levelDegreeList = shopHomeDataType12CourseConfig.getLevelDegreeList();
            if (!(levelDegreeList == null || levelDegreeList.isEmpty())) {
                baseViewHolder.setText(R.id.sign_level_degree_name, shopHomeDataType12CourseConfig.getLevelDegreeList().get(0));
                baseViewHolder.setGone(R.id.sign_level_degree_name, false);
            } else {
                baseViewHolder.setGone(R.id.sign_level_degree_name, true);
            }
            baseViewHolder.setGone(R.id.sign_lesson_count, true);
            setPrice(baseViewHolder, shopHomeDataType12CourseConfig.isSame(), shopHomeDataType12CourseConfig.getPerGoodsPrice(), shopHomeDataType12CourseConfig.getGoodsPrice());
            setTeacher(baseViewHolder, shopHomeDataType12CourseConfig.getTeacherList());
        }
    }

    private final void setPrice(BaseViewHolder baseViewHolder, boolean z, int i, int i2) {
        if (z) {
            baseViewHolder.setGone(R.id.show_from, true);
            baseViewHolder.setGone(R.id.show_end, true);
        } else {
            baseViewHolder.setGone(R.id.show_from, false);
            baseViewHolder.setGone(R.id.show_end, false);
        }
        if (i > 0) {
            baseViewHolder.setGone(R.id.show_lesson, false);
            baseViewHolder.setText(R.id.show_price, makePrice(SchoolConstants.INSTANCE.getSchoolCurrency(this.mSchoolCode), i));
            return;
        }
        baseViewHolder.setGone(R.id.show_lesson, true);
        if (i2 > 0 || !z) {
            baseViewHolder.setText(R.id.show_price, makePrice(SchoolConstants.INSTANCE.getSchoolCurrency(this.mSchoolCode), i2));
            return;
        }
        baseViewHolder.setText(R.id.show_price, getContext().getString(R.string.free));
        baseViewHolder.setGone(R.id.show_from, true);
        baseViewHolder.setGone(R.id.show_end, true);
    }

    private final String makePrice(ConfigInfo.CurrencyDesc currencyDesc, int i) {
        if (i % currencyDesc.getMinorUnit() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Intrinsics.stringPlus(currencyDesc.getSymbol(), Integer.valueOf(i / currencyDesc.getMinorUnit())), Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Intrinsics.stringPlus(currencyDesc.getSymbol(), Float.valueOf((((float) i) * 1.0f) / ((float) currencyDesc.getMinorUnit()))), Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    private final void setTeacher(BaseViewHolder baseViewHolder, List<Teacher> list) {
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        List<Teacher> list2 = list;
        Collection collection = list2;
        int i = 0;
        if (collection == null || collection.isEmpty()) {
            for (Object next : this.mTeacherIdList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                baseViewHolder2.setGone(((Number) next).intValue(), true);
                i = i2;
            }
            return;
        }
        int i3 = 0;
        for (Object next2 : this.mTeacherIdList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) next2).intValue();
            if (i3 < list.size()) {
                baseViewHolder2.setGone(intValue, false);
                XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder2.getView(intValue), getContext(), list2.get(i3).getAvatar(), 1, getContext().getColor(R.color.color_dee2e7), R.drawable.default_image_user, false);
            } else {
                baseViewHolder2.setGone(intValue, true);
            }
            i3 = i4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void reportCourseCard(com.chad.library.adapter.base.entity.node.BaseNode r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x003b
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course r10 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course) r10
            java.lang.Integer r0 = r10.getCourseId()
            if (r0 != 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            int r1 = r0.intValue()
        L_0x0016:
            r4 = r1
            java.lang.String r0 = r10.getShowName()
            if (r0 != 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r0
        L_0x0020:
            if (r10 != 0) goto L_0x0024
        L_0x0022:
            r6 = r2
            goto L_0x002c
        L_0x0024:
            java.lang.String r0 = r10.getLevelDegreeName()
            if (r0 != 0) goto L_0x002b
            goto L_0x0022
        L_0x002b:
            r6 = r0
        L_0x002c:
            java.lang.String r10 = r10.getSubjectTag()
            if (r10 != 0) goto L_0x0034
            r7 = r2
            goto L_0x0035
        L_0x0034:
            r7 = r10
        L_0x0035:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack$ShopLinkType r8 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.ShopLinkType.JUMP_CLASS_LIST_PAGE
            r3.hw_shop_course_card_click(r4, r5, r6, r7, r8)
            goto L_0x0087
        L_0x003b:
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig
            if (r0 == 0) goto L_0x0087
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig r10 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig) r10
            java.util.List r0 = r10.getLevelDegreeList()
            if (r0 == 0) goto L_0x0064
            java.util.List r0 = r10.getLevelDegreeList()
            if (r0 != 0) goto L_0x004f
            r0 = r1
            goto L_0x0053
        L_0x004f:
            int r0 = r0.size()
        L_0x0053:
            if (r0 <= 0) goto L_0x0064
            java.util.List r0 = r10.getLevelDegreeList()
            if (r0 != 0) goto L_0x005d
            r0 = 0
            goto L_0x0065
        L_0x005d:
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0064:
            r0 = r2
        L_0x0065:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r4 = r10.getPageId()
            java.lang.String r1 = r10.getName()
            if (r1 != 0) goto L_0x0073
            r5 = r2
            goto L_0x0074
        L_0x0073:
            r5 = r1
        L_0x0074:
            if (r0 != 0) goto L_0x0078
            r6 = r2
            goto L_0x0079
        L_0x0078:
            r6 = r0
        L_0x0079:
            java.lang.String r10 = r10.getSubjectTag()
            if (r10 != 0) goto L_0x0081
            r7 = r2
            goto L_0x0082
        L_0x0081:
            r7 = r10
        L_0x0082:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack$ShopLinkType r8 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.ShopLinkType.JUMP_CLASS_LIST_PAGE
            r3.hw_shop_course_card_click(r4, r5, r6, r7, r8)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.provider.ItemNormalNodeProvider.reportCourseCard(com.chad.library.adapter.base.entity.node.BaseNode):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(com.chad.library.adapter.base.viewholder.BaseViewHolder r5, android.view.View r6, com.chad.library.adapter.base.entity.node.BaseNode r7, int r8) {
        /*
            r4 = this;
            java.lang.String r8 = "helper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            java.lang.String r5 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            java.lang.String r5 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            boolean r5 = r7 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course
            r6 = 0
            if (r5 == 0) goto L_0x003f
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r8 = r7
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course r8 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course) r8
            java.lang.Integer r0 = r8.getCourseId()
            if (r0 != 0) goto L_0x0023
            goto L_0x0027
        L_0x0023:
            int r6 = r0.intValue()
        L_0x0027:
            java.lang.String r0 = "courseId"
            r5.putInt(r0, r6)
            java.lang.String r6 = r8.getShowName()
            java.lang.String r8 = "courseName"
            r5.putString(r8, r6)
            com.tal.app.thinkacademy.lib.route.XesRoute r6 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            java.lang.String r8 = "/shop/class_list_activity"
            r6.navigation(r8, r5)
            goto L_0x008a
        L_0x003f:
            boolean r5 = r7 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig
            if (r5 == 0) goto L_0x008a
            com.tal.app.thinkacademy.lib.route.XesRoute r5 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            r0 = r7
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig r0 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig) r0
            int r1 = r0.getPageId()
            java.lang.String r2 = "pageId"
            r8.putInt(r2, r1)
            boolean r1 = r0.isSame()
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "isShowFrom"
            r8.putBoolean(r3, r1)
            int r1 = r0.getPerGoodsPrice()
            if (r1 <= 0) goto L_0x006a
            r6 = r2
        L_0x006a:
            java.lang.String r1 = "isShowLesson"
            r8.putBoolean(r1, r6)
            int r6 = r0.getPerGoodsPrice()
            if (r6 <= 0) goto L_0x007a
            int r6 = r0.getPerGoodsPrice()
            goto L_0x007e
        L_0x007a:
            int r6 = r0.getGoodsPrice()
        L_0x007e:
            java.lang.String r0 = "showPrice"
            r8.putInt(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            java.lang.String r6 = "/shop/grade_aggregate_activity"
            r5.navigation(r6, r8)
        L_0x008a:
            r4.reportCourseCard(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.provider.ItemNormalNodeProvider.onClick(com.chad.library.adapter.base.viewholder.BaseViewHolder, android.view.View, com.chad.library.adapter.base.entity.node.BaseNode, int):void");
    }
}
