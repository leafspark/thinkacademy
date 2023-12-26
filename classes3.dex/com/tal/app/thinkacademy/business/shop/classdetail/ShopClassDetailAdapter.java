package com.tal.app.thinkacademy.business.shop.classdetail;

import android.os.Bundle;
import android.view.View;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0014J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\"H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mClassId", "", "getMClassId", "()Ljava/lang/String;", "setMClassId", "(Ljava/lang/String;)V", "mSchoolCode", "", "mTagArray", "", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailAdapter$ClassTagRes;", "[Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailAdapter$ClassTagRes;", "mTeacherTypeDesc", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "convert", "", "holder", "item", "getTagResIndex", "remainSellTime", "", "store", "sellStore", "makePrice", "currencyDesc", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "price", "showClassCardPrice", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailInfoBean;", "ClassTagRes", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailAdapter.kt */
public final class ShopClassDetailAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private String mClassId = "0";
    private int mSchoolCode = 4401;
    private final ClassTagRes[] mTagArray;
    private ConfigInfo.TeacherName mTeacherTypeDesc;

    private final int getTagResIndex(long j, int i, int i2) {
        boolean z = true;
        if (j > 1000) {
            return 1;
        }
        float f = (((float) i2) * 1.0f) / ((float) i);
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

    public ShopClassDetailAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        try {
            String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_UK, ShareDataManager.SHAREDATA_NOT_CLEAR);
            Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
            this.mSchoolCode = Integer.parseInt(string);
        } catch (Exception unused) {
        }
        this.mTeacherTypeDesc = SchoolConstants.INSTANCE.getSchoolTeacherName(String.valueOf(this.mSchoolCode));
        addItemType(ShopClassDetailItemType.CourseTitle.getType(), R.layout.item_shop_class_detail_course_title);
        addItemType(ShopClassDetailItemType.CourseCard.getType(), R.layout.item_shop_class_detail_course_card);
        addItemType(ShopClassDetailItemType.Admission.getType(), R.layout.item_shop_class_detail_admission_test);
        addItemType(ShopClassDetailItemType.CourseHighlights.getType(), R.layout.item_shop_class_detail_course_highlight);
        addItemType(ShopClassDetailItemType.TeacherTitle.getType(), R.layout.item_shop_class_detail_normal_title);
        addItemType(ShopClassDetailItemType.TeacherCard.getType(), R.layout.item_shop_class_detail_teacher_card);
        addItemType(ShopClassDetailItemType.ScheduleTitle.getType(), R.layout.item_shop_class_detail_schedule_title);
        addItemType(ShopClassDetailItemType.ScheduleInfo.getType(), R.layout.item_shop_class_detail_schedule_info);
        addItemType(ShopClassDetailItemType.ScheduleMore.getType(), R.layout.item_shop_class_detail_schedule_more);
        addItemType(ShopClassDetailItemType.CourseDetailTitle.getType(), R.layout.item_shop_class_detail_normal_title);
        addItemType(ShopClassDetailItemType.CourseDetailInfo.getType(), R.layout.item_shop_class_detail_course_detail_info);
        addItemType(ShopClassDetailItemType.StepsTitle.getType(), R.layout.item_shop_class_detail_normal_title);
        addItemType(ShopClassDetailItemType.StepsInfo.getType(), R.layout.item_shop_class_detail_steps_info);
        this.mTagArray = new ClassTagRes[]{new ClassTagRes(R.string.New, R.drawable.bus_shop_shape_bg_class_tag_ffaa0a), new ClassTagRes(R.string.coming_soon, R.drawable.bus_shop_shape_bg_class_tag_02ca8a), new ClassTagRes(R.string.popular, R.drawable.bus_shop_shape_bg_class_tag_ffc300), new ClassTagRes(R.string.count_left, R.drawable.bus_shop_shape_bg_class_tag_3370ff), new ClassTagRes(R.string.full, R.drawable.bus_shop_shape_bg_class_tag_ff5463)};
    }

    public final String getMClassId() {
        return this.mClassId;
    }

    public final void setMClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mClassId = str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0574, code lost:
        if ((r3.length() > 0) == true) goto L_0x0576;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x064a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02f6 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r22, com.chad.library.adapter.base.entity.MultiItemEntity r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            int r3 = r23.getItemType()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseTitle
            int r4 = r4.getType()
            r5 = 3
            r6 = 1092616192(0x41200000, float:10.0)
            java.lang.String r7 = "format(format, *args)"
            r8 = 1
            r9 = 0
            if (r3 != r4) goto L_0x00e5
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.course_title
            android.view.View r1 = r1.getView(r3)
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r1 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r1
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r2
            java.lang.Object r3 = r2.getData()
            boolean r3 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean
            if (r3 == 0) goto L_0x0b0d
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            int r3 = r3.getStore()
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            int r4 = r4.getSellStore()
            int r3 = r3 - r4
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            java.lang.String r4 = r4.getTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            long r10 = r4.getRemainSellTime()
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            int r4 = r4.getStore()
            java.lang.Object r12 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r12 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r12
            int r12 = r12.getSellStore()
            int r4 = r0.getTagResIndex(r10, r4, r12)
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter$ClassTagRes[] r10 = r0.mTagArray
            r10 = r10[r4]
            android.content.Context r11 = r21.getContext()
            int r12 = r10.getTextRes()
            java.lang.String r11 = r11.getString(r12)
            java.lang.String r12 = "context.getString(tagRes.textRes)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r12 = (java.util.List) r12
            if (r4 != r5) goto L_0x00b2
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r4 = new java.lang.Object[r8]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r9] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r8)
            java.lang.String r11 = java.lang.String.format(r11, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)
        L_0x00b2:
            r12.add(r11)
            android.graphics.Rect r3 = new android.graphics.Rect
            int r4 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r5 = 1073741824(0x40000000, float:2.0)
            int r7 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r5)
            int r6 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            int r5 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r5)
            r3.<init>(r4, r7, r6, r5)
            r1.setTagPadding(r3)
            int r3 = r10.getBgRes()
            r1.setTagBackgroundStyle(r3)
            java.lang.Object r2 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r2
            java.lang.String r2 = r2.getTitle()
            r1.setTagStart(r12, r2)
            goto L_0x0b0d
        L_0x00e5:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseCard
            int r4 = r4.getType()
            r10 = 0
            r11 = 2
            if (r3 != r4) goto L_0x03d9
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r2
            java.lang.Object r3 = r2.getData()
            boolean r3 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean
            if (r3 == 0) goto L_0x0b0d
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_difficulty
            android.content.Context r4 = r21.getContext()
            int r5 = com.tal.app.thinkacademy.business.shop.R.string.difficulty
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r3 = r3.getSpec()
            if (r3 != 0) goto L_0x011c
            r3 = r9
            goto L_0x0120
        L_0x011c:
            int r3 = r3.getLevelDegreeStar()
        L_0x0120:
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.ratingbar_class_difficulty
            android.view.View r4 = r1.getView(r4)
            androidx.appcompat.widget.AppCompatRatingBar r4 = (androidx.appcompat.widget.AppCompatRatingBar) r4
            int r3 = r3 * r11
            r4.setProgress(r3)
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            int r3 = r3.getStore()
            if (r3 <= r8) goto L_0x0143
            android.content.Context r4 = r21.getContext()
            int r5 = com.tal.app.thinkacademy.business.shop.R.string.spaces
            java.lang.String r4 = r4.getString(r5)
            goto L_0x014d
        L_0x0143:
            android.content.Context r4 = r21.getContext()
            int r5 = com.tal.app.thinkacademy.business.shop.R.string.space
            java.lang.String r4 = r4.getString(r5)
        L_0x014d:
            java.lang.String r5 = "%s "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r4)
            int r6 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_space
            kotlin.jvm.internal.StringCompanionObject r12 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12[r9] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r12, r8)
            java.lang.String r3 = java.lang.String.format(r4, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r6, r3)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_form
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r4.getSpec()
            if (r4 != 0) goto L_0x017f
            r4 = r10
            goto L_0x0183
        L_0x017f:
            java.lang.String r4 = r4.getPlatformType()
        L_0x0183:
            java.lang.String r6 = "3"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0196
            android.content.Context r4 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.string.in_person
            java.lang.String r4 = r4.getString(r6)
            goto L_0x01a0
        L_0x0196:
            android.content.Context r4 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.string.online
            java.lang.String r4 = r4.getString(r6)
        L_0x01a0:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_date
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Object r6 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r6 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r6
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r6 = r6.getSpec()
            if (r6 != 0) goto L_0x01ba
            r6 = r10
            goto L_0x01be
        L_0x01ba:
            java.lang.String r6 = r6.getStartDate()
        L_0x01be:
            r4.append(r6)
            java.lang.String r6 = " - "
            r4.append(r6)
            java.lang.Object r6 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r6 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r6
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r6 = r6.getSpec()
            if (r6 != 0) goto L_0x01d4
            r6 = r10
            goto L_0x01d8
        L_0x01d4:
            java.lang.String r6 = r6.getEndDate()
        L_0x01d8:
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_time
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r4.getSpec()
            if (r4 != 0) goto L_0x01f3
            goto L_0x01f7
        L_0x01f3:
            java.lang.String r10 = r4.getTimeDesc()
        L_0x01f7:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r1.setText(r3, r10)
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r3 = r3.getSpec()
            if (r3 != 0) goto L_0x020a
        L_0x0208:
            r3 = r9
            goto L_0x022d
        L_0x020a:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent r3 = r3.getPlatformContent()
            if (r3 != 0) goto L_0x0211
            goto L_0x0208
        L_0x0211:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailClassRoom r3 = r3.getClassRoom()
            if (r3 != 0) goto L_0x0218
            goto L_0x0208
        L_0x0218:
            java.lang.String r3 = r3.getVenueAddress()
            if (r3 != 0) goto L_0x021f
            goto L_0x0208
        L_0x021f:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0229
            r3 = r8
            goto L_0x022a
        L_0x0229:
            r3 = r9
        L_0x022a:
            if (r3 != r8) goto L_0x0208
            r3 = r8
        L_0x022d:
            if (r3 == 0) goto L_0x0252
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_address
            r1.setGone(r3, r9)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_address
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r4.getSpec()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent r4 = r4.getPlatformContent()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailClassRoom r4 = r4.getClassRoom()
            java.lang.String r4 = r4.getVenueAddress()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            goto L_0x0257
        L_0x0252:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_address
            r1.setGone(r3, r8)
        L_0x0257:
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r3 = r3.getSpec()
            if (r3 != 0) goto L_0x0265
        L_0x0263:
            r3 = r9
            goto L_0x0288
        L_0x0265:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent r3 = r3.getPlatformContent()
            if (r3 != 0) goto L_0x026c
            goto L_0x0263
        L_0x026c:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailClassRoom r3 = r3.getClassRoom()
            if (r3 != 0) goto L_0x0273
            goto L_0x0263
        L_0x0273:
            java.lang.String r3 = r3.getVenuePhone()
            if (r3 != 0) goto L_0x027a
            goto L_0x0263
        L_0x027a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0284
            r3 = r8
            goto L_0x0285
        L_0x0284:
            r3 = r9
        L_0x0285:
            if (r3 != r8) goto L_0x0263
            r3 = r8
        L_0x0288:
            if (r3 == 0) goto L_0x02ad
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_phone_num
            r1.setGone(r3, r9)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_phone_num
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r4.getSpec()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent r4 = r4.getPlatformContent()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailClassRoom r4 = r4.getClassRoom()
            java.lang.String r4 = r4.getVenuePhone()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            goto L_0x02b2
        L_0x02ad:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_phone_num
            r1.setGone(r3, r8)
        L_0x02b2:
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            boolean r3 = r0.showClassCardPrice(r1, r3)
            java.lang.Object r4 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r4
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r4.getSpec()
            if (r4 != 0) goto L_0x02ca
        L_0x02c8:
            r4 = r9
            goto L_0x02df
        L_0x02ca:
            java.lang.String r4 = r4.getFeeDescClazz()
            if (r4 != 0) goto L_0x02d1
            goto L_0x02c8
        L_0x02d1:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x02db
            r4 = r8
            goto L_0x02dc
        L_0x02db:
            r4 = r9
        L_0x02dc:
            if (r4 != r8) goto L_0x02c8
            r4 = r8
        L_0x02df:
            if (r4 == 0) goto L_0x02e7
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.price_desc_btn
            r1.setGone(r4, r9)
            goto L_0x02ec
        L_0x02e7:
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.price_desc_btn
            r1.setGone(r4, r8)
        L_0x02ec:
            com.tal.app.thinkacademy.common.constants.SchoolConstants r4 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            int r6 = r0.mSchoolCode
            boolean r4 = r4.isShowGstOrVat(r6)
            if (r4 == 0) goto L_0x0319
            if (r3 != 0) goto L_0x0319
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.vat_info_description
            r1.setGone(r3, r9)
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            int r3 = r3.getShowPriceIsInclude()
            if (r3 != r8) goto L_0x0311
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.vat_info_description
            int r4 = com.tal.app.thinkacademy.business.shop.R.string.gst_excluded
            r1.setText(r3, r4)
            goto L_0x031e
        L_0x0311:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.vat_info_description
            int r4 = com.tal.app.thinkacademy.business.shop.R.string.vat_included
            r1.setText(r3, r4)
            goto L_0x031e
        L_0x0319:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.vat_info_description
            r1.setGone(r3, r8)
        L_0x031e:
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r3 = r3.getSpec()
            if (r3 != 0) goto L_0x032c
            r3 = r9
            goto L_0x0330
        L_0x032c:
            int r3 = r3.getLessonCount()
        L_0x0330:
            java.lang.Object r2 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r2
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r2 = r2.getSpec()
            if (r2 != 0) goto L_0x033e
            r2 = r9
            goto L_0x0342
        L_0x033e:
            int r2 = r2.getLeftLesson()
        L_0x0342:
            if (r3 != r2) goto L_0x037d
            if (r3 <= r8) goto L_0x0351
            android.content.Context r2 = r21.getContext()
            int r4 = com.tal.app.thinkacademy.business.shop.R.string.lessons
            java.lang.String r2 = r2.getString(r4)
            goto L_0x035b
        L_0x0351:
            android.content.Context r2 = r21.getContext()
            int r4 = com.tal.app.thinkacademy.business.shop.R.string.single_lesson
            java.lang.String r2 = r2.getString(r4)
        L_0x035b:
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r2)
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.total_lesson_and_remain
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r5 = new java.lang.Object[r8]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5[r9] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r5, r8)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r4, r2)
            goto L_0x0b0d
        L_0x037d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            if (r3 <= r8) goto L_0x0392
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.string.lessons
            java.lang.String r5 = r5.getString(r6)
            goto L_0x039c
        L_0x0392:
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.string.single_lesson
            java.lang.String r5 = r5.getString(r6)
        L_0x039c:
            r4.append(r5)
            java.lang.String r5 = "/%s "
            r4.append(r5)
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.string.course_left
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.total_lesson_and_remain
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r6 = new java.lang.Object[r11]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6[r9] = r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6[r8] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r6, r11)
            java.lang.String r2 = java.lang.String.format(r4, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r5, r2)
            goto L_0x0b0d
        L_0x03d9:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.Admission
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x0426
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r2
            java.lang.Object r3 = r2.getData()
            boolean r3 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean
            if (r3 == 0) goto L_0x0b0d
            java.lang.Object r2 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r2
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailExamEntrance r2 = r2.getExamEntrance()
            if (r2 != 0) goto L_0x03fc
            goto L_0x0400
        L_0x03fc:
            int r9 = r2.getStatus()
        L_0x0400:
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_admission_test_normal
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.admission_test_desc_no_need_test
            if (r9 == r11) goto L_0x0416
            if (r9 == r5) goto L_0x0411
            r4 = 4
            if (r9 == r4) goto L_0x040c
            goto L_0x041a
        L_0x040c:
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_admission_test_fail
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.admission_test_desc_fail
            goto L_0x041a
        L_0x0411:
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_admission_test_success
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.admission_test_desc_success
            goto L_0x041a
        L_0x0416:
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_admission_test_normal
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.admission_test_desc_normal
        L_0x041a:
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.admission_test_bg
            r1.setImageResource(r4, r2)
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.admission_desc
            r1.setText(r2, r3)
            goto L_0x0b0d
        L_0x0426:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseHighlights
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x04eb
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r2
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r3 = r2.getDynamic()
            if (r3 != 0) goto L_0x043c
        L_0x043a:
            r3 = r9
            goto L_0x0447
        L_0x043c:
            java.util.List r3 = r3.getHighlight()
            if (r3 != 0) goto L_0x0443
            goto L_0x043a
        L_0x0443:
            int r3 = r3.size()
        L_0x0447:
            if (r3 <= 0) goto L_0x04a6
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.course_high_lights_title
            r1.setGone(r4, r9)
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.course_high_lights_content
            r1.setGone(r4, r9)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r5 = r2.getDynamic()
            if (r5 != 0) goto L_0x045f
            goto L_0x049a
        L_0x045f:
            java.util.List r5 = r5.getHighlight()
            if (r5 != 0) goto L_0x0466
            goto L_0x049a
        L_0x0466:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = r9
        L_0x046d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0496
            java.lang.Object r7 = r5.next()
            int r11 = r6 + 1
            if (r6 >= 0) goto L_0x047e
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x047e:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight r7 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight) r7
            java.lang.String r7 = r7.getTitle()
            r4.append(r7)
            int r7 = r3 + -1
            if (r6 >= r7) goto L_0x0494
            r7 = 7
            if (r6 <= r7) goto L_0x048f
            goto L_0x0496
        L_0x048f:
            java.lang.String r6 = " · "
            r4.append(r6)
        L_0x0494:
            r6 = r11
            goto L_0x046d
        L_0x0496:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x049a:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.course_high_lights_content
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            goto L_0x04b0
        L_0x04a6:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.course_high_lights_title
            r1.setGone(r3, r8)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.course_high_lights_content
            r1.setGone(r3, r8)
        L_0x04b0:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r3 = r2.getStaticData()
            if (r3 != 0) goto L_0x04b8
        L_0x04b6:
            r3 = r9
            goto L_0x04c3
        L_0x04b8:
            java.util.List r3 = r3.getTrialLessons()
            if (r3 != 0) goto L_0x04bf
            goto L_0x04b6
        L_0x04bf:
            int r3 = r3.size()
        L_0x04c3:
            if (r3 <= 0) goto L_0x04cb
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teaching_video
            r1.setGone(r3, r9)
            goto L_0x04d0
        L_0x04cb:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teaching_video
            r1.setGone(r3, r8)
        L_0x04d0:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r2 = r2.getStaticData()
            if (r2 != 0) goto L_0x04d7
            goto L_0x04db
        L_0x04d7:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait r10 = r2.getPortrait()
        L_0x04db:
            if (r10 == 0) goto L_0x04e4
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.suit_info
            r1.setGone(r2, r9)
            goto L_0x0b0d
        L_0x04e4:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.suit_info
            r1.setGone(r2, r8)
            goto L_0x0b0d
        L_0x04eb:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.TeacherTitle
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x04fc
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.normal_title
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.shop_detail_teacher
            r1.setText(r2, r3)
            goto L_0x0b0d
        L_0x04fc:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.TeacherCard
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x060f
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r11 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_icon
            android.view.View r3 = r1.getView(r3)
            r12 = r3
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            android.content.Context r13 = r21.getContext()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher) r2
            java.lang.String r14 = r2.getAvatar()
            r15 = 1
            android.content.Context r3 = r21.getContext()
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_e3e5e9
            int r16 = r3.getColor(r4)
            int r17 = com.tal.app.thinkacademy.business.shop.R.drawable.circle_user_default_image
            r18 = 0
            r11.loadCircleWithBorderImage(r12, r13, r14, r15, r16, r17, r18)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_name
            java.lang.String r4 = r2.getSysName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            int r3 = r2.getTeacherType()
            java.lang.String r4 = "mTeacherTypeDesc"
            if (r3 != r8) goto L_0x055c
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_next
            r1.setGone(r3, r9)
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_desc
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$TeacherName r5 = r0.mTeacherTypeDesc
            if (r5 != 0) goto L_0x0551
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0552
        L_0x0551:
            r10 = r5
        L_0x0552:
            java.lang.String r4 = r10.getLecturerTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            goto L_0x0598
        L_0x055c:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_next
            r1.setGone(r3, r8)
            java.lang.String r3 = r2.getTutorDuty()
            if (r3 != 0) goto L_0x0569
        L_0x0567:
            r8 = r9
            goto L_0x0576
        L_0x0569:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0573
            r3 = r8
            goto L_0x0574
        L_0x0573:
            r3 = r9
        L_0x0574:
            if (r3 != r8) goto L_0x0567
        L_0x0576:
            if (r8 == 0) goto L_0x0584
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_desc
            java.lang.String r4 = r2.getTutorDuty()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
            goto L_0x0598
        L_0x0584:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.teacher_desc
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$TeacherName r5 = r0.mTeacherTypeDesc
            if (r5 != 0) goto L_0x058e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x058f
        L_0x058e:
            r10 = r5
        L_0x058f:
            java.lang.String r4 = r10.getAssistantTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r3, r4)
        L_0x0598:
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_ffffff
            java.lang.Integer r2 = r2.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r3 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r3 = r3.getType()
            r4 = 1094713344(0x41400000, float:12.0)
            if (r2 != 0) goto L_0x05a9
            goto L_0x05b3
        L_0x05a9:
            int r5 = r2.intValue()
            if (r5 != r3) goto L_0x05b3
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_top_radius_10
        L_0x05b1:
            r3 = r9
            goto L_0x05f9
        L_0x05b3:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r3 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r3 = r3.getType()
            if (r2 != 0) goto L_0x05bc
            goto L_0x05ce
        L_0x05bc:
            int r5 = r2.intValue()
            if (r5 != r3) goto L_0x05ce
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r4)
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_bottom_radius_10
        L_0x05c8:
            r20 = r3
            r3 = r2
            r2 = r20
            goto L_0x05f9
        L_0x05ce:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r3 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r3 = r3.getType()
            if (r2 != 0) goto L_0x05d7
            goto L_0x05e4
        L_0x05d7:
            int r5 = r2.intValue()
            if (r5 != r3) goto L_0x05e4
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r4)
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_radius10
            goto L_0x05c8
        L_0x05e4:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r3 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Normal
            int r3 = r3.getType()
            if (r2 != 0) goto L_0x05ed
            goto L_0x05f6
        L_0x05ed:
            int r2 = r2.intValue()
            if (r2 != r3) goto L_0x05f6
            int r2 = com.tal.app.thinkacademy.business.shop.R.color.color_ffffff
            goto L_0x05b1
        L_0x05f6:
            int r2 = com.tal.app.thinkacademy.business.shop.R.color.color_ffffff
            goto L_0x05b1
        L_0x05f9:
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.teacher_root_layout
            r1.setBackgroundResource(r5, r2)
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.teacher_root_layout
            android.view.View r1 = r1.getView(r2)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r4)
            r1.setPadding(r9, r2, r9, r3)
            goto L_0x0b0d
        L_0x060f:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.ScheduleTitle
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x0667
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r2
            java.lang.Object r3 = r2.getData()
            boolean r3 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation
            if (r3 == 0) goto L_0x0660
            java.lang.Object r3 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r3 = r3.getStaticData()
            if (r3 != 0) goto L_0x0633
        L_0x0631:
            r3 = r9
            goto L_0x0648
        L_0x0633:
            java.lang.String r3 = r3.getPlanDescription()
            if (r3 != 0) goto L_0x063a
            goto L_0x0631
        L_0x063a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0644
            r3 = r8
            goto L_0x0645
        L_0x0644:
            r3 = r9
        L_0x0645:
            if (r3 != r8) goto L_0x0631
            r3 = r8
        L_0x0648:
            if (r3 == 0) goto L_0x0660
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.title_description
            java.lang.Object r2 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r2
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r2 = r2.getStaticData()
            java.lang.String r2 = r2.getPlanDescription()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r3, r2)
            r8 = r9
        L_0x0660:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.title_description
            r1.setGone(r2, r8)
            goto L_0x0b0d
        L_0x0667:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.ScheduleInfo
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x07f1
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu
            if (r3 == 0) goto L_0x0b0d
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.schedule_name
            android.view.View r3 = r1.getView(r3)
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r3 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu) r2
            java.lang.String r4 = r2.getName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            int r5 = r2.isStarted()
            r6 = 10
            if (r5 != 0) goto L_0x06eb
            int r5 = r2.getLocal_position_num()
            if (r5 >= r6) goto L_0x06c3
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r5 = new java.lang.Object[r11]
            int r6 = r2.getLocal_position_num()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r9] = r6
            android.content.Context r6 = r21.getContext()
            int r10 = com.tal.app.thinkacademy.business.shop.R.string.shop_course_started
            java.lang.String r6 = r6.getString(r10)
            r5[r8] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r11)
            java.lang.String r6 = "0%s %s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            goto L_0x0728
        L_0x06c3:
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r5 = new java.lang.Object[r11]
            int r6 = r2.getLocal_position_num()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r9] = r6
            android.content.Context r6 = r21.getContext()
            int r10 = com.tal.app.thinkacademy.business.shop.R.string.shop_course_started
            java.lang.String r6 = r6.getString(r10)
            r5[r8] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r11)
            java.lang.String r6 = "%s %s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            goto L_0x0728
        L_0x06eb:
            int r5 = r2.getLocal_position_num()
            if (r5 >= r6) goto L_0x070d
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r5 = new java.lang.Object[r8]
            int r6 = r2.getLocal_position_num()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r9] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r8)
            java.lang.String r6 = "0%s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            goto L_0x0728
        L_0x070d:
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r5 = new java.lang.Object[r8]
            int r6 = r2.getLocal_position_num()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r9] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r8)
            java.lang.String r6 = "%s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
        L_0x0728:
            r4.add(r5)
            android.graphics.Rect r5 = new android.graphics.Rect
            r6 = 1084227584(0x40a00000, float:5.0)
            int r7 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r10 = 1077936128(0x40400000, float:3.0)
            int r11 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r10)
            int r6 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            int r10 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r10)
            r5.<init>(r7, r11, r6, r10)
            r3.setTagPadding(r5)
            int r5 = r2.isStarted()
            if (r5 != 0) goto L_0x076d
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r5 = r5.getColor(r6)
            r3.setTextColor(r5)
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r5 = r5.getColor(r6)
            r3.setTagTextColor(r5)
            int r5 = com.tal.app.thinkacademy.business.shop.R.drawable.bg_f4f6fa_11_corners
            r3.setTagBackgroundStyle(r5)
            goto L_0x078c
        L_0x076d:
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.color.color_172b4d
            int r5 = r5.getColor(r6)
            r3.setTextColor(r5)
            android.content.Context r5 = r21.getContext()
            int r6 = com.tal.app.thinkacademy.business.shop.R.color.color_ff850a
            int r5 = r5.getColor(r6)
            r3.setTagTextColor(r5)
            int r5 = com.tal.app.thinkacademy.business.shop.R.drawable.bg_fff3dc_11_corners
            r3.setTagBackgroundStyle(r5)
        L_0x078c:
            java.lang.String r5 = r2.getName()
            r3.setTagStart(r4, r5)
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_ffffff
            r4 = 1098907648(0x41800000, float:16.0)
            com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r4)
            java.lang.Integer r4 = r2.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r5 = r5.getType()
            if (r4 != 0) goto L_0x07a7
            goto L_0x07b5
        L_0x07a7:
            int r6 = r4.intValue()
            if (r6 != r5) goto L_0x07b5
            r3 = 1101004800(0x41a00000, float:20.0)
            com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_top_radius_10
            goto L_0x07da
        L_0x07b5:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r5 = r5.getType()
            if (r4 != 0) goto L_0x07be
            goto L_0x07c8
        L_0x07be:
            int r6 = r4.intValue()
            if (r6 != r5) goto L_0x07c8
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_bottom_radius_10
        L_0x07c6:
            r8 = r9
            goto L_0x07da
        L_0x07c8:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r5 = r5.getType()
            if (r4 != 0) goto L_0x07d1
            goto L_0x07da
        L_0x07d1:
            int r4 = r4.intValue()
            if (r4 != r5) goto L_0x07da
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_radius10
            goto L_0x07c6
        L_0x07da:
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.bottom_line
            r1.setVisible(r4, r8)
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.schedule_date_desc
            java.lang.String r2 = r2.getTimeDesc()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r4, r2)
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.schedule_root_layout
            r1.setBackgroundResource(r2, r3)
            goto L_0x0b0d
        L_0x07f1:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.ScheduleMore
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x0846
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r2
            java.lang.Object r3 = r2.getData()
            boolean r3 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo
            if (r3 == 0) goto L_0x0b0d
            java.lang.Object r2 = r2.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo) r2
            java.util.List r2 = r2.getSyllabus()
            if (r2 != 0) goto L_0x0815
            r2 = r9
            goto L_0x0819
        L_0x0815:
            int r2 = r2.size()
        L_0x0819:
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.view_all_lessons
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            android.content.Context r4 = r21.getContext()
            int r5 = com.tal.app.thinkacademy.business.shop.R.string.shop_view_all_lessons_format
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "context.getString(R.stri…_view_all_lessons_format)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Object[] r5 = new java.lang.Object[r8]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5[r9] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r8)
            java.lang.String r2 = java.lang.String.format(r4, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r3, r2)
            goto L_0x0b0d
        L_0x0846:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseDetailTitle
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x0857
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.normal_title
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.course_details
            r1.setText(r2, r3)
            goto L_0x0b0d
        L_0x0857:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseDetailInfo
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x09b1
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.course_detail_info_image
            android.view.View r3 = r1.getView(r3)
            r11 = r3
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.subsampling_scale_image
            android.view.View r1 = r1.getView(r3)
            com.tal.app.thinkacademy.lib.utils.HwBIgImage r1 = (com.tal.app.thinkacademy.lib.utils.HwBIgImage) r1
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseDetailPic
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r3 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.ALL
            kotlin.jvm.internal.Ref$IntRef r4 = new kotlin.jvm.internal.Ref$IntRef
            r4.<init>()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseDetailPic r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseDetailPic) r2
            java.lang.Integer r5 = r2.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r7 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r7 = r7.getType()
            if (r5 != 0) goto L_0x088a
            goto L_0x089b
        L_0x088a:
            int r10 = r5.intValue()
            if (r10 != r7) goto L_0x089b
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r4.element = r3
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r3 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.TOP
        L_0x0898:
            r18 = r3
            goto L_0x08cb
        L_0x089b:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r7 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r7 = r7.getType()
            if (r5 != 0) goto L_0x08a4
            goto L_0x08b3
        L_0x08a4:
            int r10 = r5.intValue()
            if (r10 != r7) goto L_0x08b3
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r4.element = r3
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r3 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.BOTTOM
            goto L_0x0898
        L_0x08b3:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r7 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r7 = r7.getType()
            if (r5 != 0) goto L_0x08bc
            goto L_0x0898
        L_0x08bc:
            int r5 = r5.intValue()
            if (r5 != r7) goto L_0x0898
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r4.element = r3
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r3 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.ALL
            goto L_0x0898
        L_0x08cb:
            java.lang.Integer r3 = r2.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r5 = r5.getType()
            r7 = 8
            r10 = 1107296256(0x42000000, float:32.0)
            if (r3 != 0) goto L_0x08dc
            goto L_0x094d
        L_0x08dc:
            int r3 = r3.intValue()
            if (r3 != r5) goto L_0x094d
            r1.setVisibility(r9)
            r11.setVisibility(r7)
            r1.setZoomEnabled(r9)
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter$convert$3 r3 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter$convert$3
            r3.<init>(r4)
            android.view.ViewOutlineProvider r3 = (android.view.ViewOutlineProvider) r3
            r1.setOutlineProvider(r3)
            r1.setClipToOutline(r8)
            java.lang.String r3 = r2.getUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r4 = r1.getMUrlCheckTag()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L_0x0912
            boolean r3 = r1.getMIsLoadSuccess()
            if (r3 == 0) goto L_0x0912
            goto L_0x0b0d
        L_0x0912:
            java.lang.String r3 = r2.getUrl()
            r1.setMUrlCheckTag(r3)
            r1.setMIsLoadSuccess(r9)
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bg_default_image
            com.davemorrissey.labs.subscaleview.ImageSource r3 = com.davemorrissey.labs.subscaleview.ImageSource.resource(r3)
            r1.setImage(r3)
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r4 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            r5 = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView r5 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView) r5
            android.content.Context r1 = r21.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r10)
            int r6 = r1 - r3
            android.content.Context r7 = r21.getContext()
            java.lang.String r8 = r2.getUrl()
            int r9 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_default_course_info_image
            r4.loadBigPicAutoHeight(r5, r6, r7, r8, r9)
            goto L_0x0b0d
        L_0x094d:
            r1.setVisibility(r7)
            r11.setVisibility(r9)
            int r1 = r4.element
            if (r1 != 0) goto L_0x0985
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r1 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            android.content.Context r3 = r21.getContext()
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r3 = r3.widthPixels
            int r4 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r10)
            int r12 = r3 - r4
            android.content.Context r13 = r21.getContext()
            java.lang.String r14 = r2.getUrl()
            int r15 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_default_course_info_image
            r16 = 0
            r17 = 0
            r18 = 48
            r19 = 0
            r10 = r1
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.loadImageAutoHeight$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x0b0d
        L_0x0985:
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r1 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            android.content.Context r3 = r21.getContext()
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r3 = r3.widthPixels
            int r4 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r10)
            int r12 = r3 - r4
            android.content.Context r13 = r21.getContext()
            java.lang.String r14 = r2.getUrl()
            int r15 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r16 = 0
            int r17 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_default_course_info_image
            r10 = r1
            r10.loadRoundCornerImageAutoHeight(r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0b0d
        L_0x09b1:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.StepsTitle
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x09f4
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r3 == 0) goto L_0x0b0d
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r2
            java.lang.Object r3 = r2.getData()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x0b0d
            android.content.Context r3 = r21.getContext()
            int r4 = com.tal.app.thinkacademy.business.shop.R.string.shop_class_detail_buy_steps_title
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.stri…s_detail_buy_steps_title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = com.tal.app.thinkacademy.business.shop.R.id.normal_title
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r5 = new java.lang.Object[r8]
            java.lang.Object r2 = r2.getData()
            r5[r9] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r8)
            java.lang.String r2 = java.lang.String.format(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r4, r2)
            goto L_0x0b0d
        L_0x09f4:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.StepsInfo
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x0b0d
            boolean r3 = r2 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep
            if (r3 == 0) goto L_0x0b0d
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_ffffff
            com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep) r2
            int r4 = r2.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r5 = r5.getType()
            if (r4 != r5) goto L_0x0a19
            int r3 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_top_radius_10
            r4 = r3
            r7 = r8
            r3 = r9
            r5 = r3
            r6 = r5
            goto L_0x0a6c
        L_0x0a19:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r5 = r5.getType()
            if (r4 != r5) goto L_0x0a40
            java.lang.String r3 = r2.getLocal_faq_desc()
            if (r3 != 0) goto L_0x0a29
        L_0x0a27:
            r3 = r9
            goto L_0x0a37
        L_0x0a29:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0a33
            r3 = r8
            goto L_0x0a34
        L_0x0a33:
            r3 = r9
        L_0x0a34:
            if (r3 != r8) goto L_0x0a27
            r3 = r8
        L_0x0a37:
            int r4 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_bottom_radius_10
            int r5 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r6 = r8
            r7 = r9
            goto L_0x0a6c
        L_0x0a40:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r5 = r5.getType()
            if (r4 != r5) goto L_0x0a67
            java.lang.String r3 = r2.getLocal_faq_desc()
            if (r3 != 0) goto L_0x0a50
        L_0x0a4e:
            r3 = r9
            goto L_0x0a5e
        L_0x0a50:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0a5a
            r3 = r8
            goto L_0x0a5b
        L_0x0a5a:
            r3 = r9
        L_0x0a5b:
            if (r3 != r8) goto L_0x0a4e
            r3 = r8
        L_0x0a5e:
            int r4 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_radius10
            int r5 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r6 = r9
            r7 = r6
            goto L_0x0a6c
        L_0x0a67:
            r4 = r3
            r6 = r8
            r7 = r6
            r3 = r9
            r5 = r3
        L_0x0a6c:
            int r10 = r2.getLocal_position()
            if (r10 <= r11) goto L_0x0a78
            int r10 = com.tal.app.thinkacademy.business.shop.R.id.info_number
            r1.setGone(r10, r8)
            goto L_0x0a97
        L_0x0a78:
            int r10 = com.tal.app.thinkacademy.business.shop.R.id.info_number
            r1.setGone(r10, r9)
            int r10 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_steps_1
            int r12 = r2.getLocal_position()
            if (r12 == 0) goto L_0x0a90
            if (r12 == r8) goto L_0x0a8d
            if (r12 == r11) goto L_0x0a8a
            goto L_0x0a92
        L_0x0a8a:
            int r10 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_steps_3
            goto L_0x0a92
        L_0x0a8d:
            int r10 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_steps_2
            goto L_0x0a92
        L_0x0a90:
            int r10 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_ic_shop_class_steps_1
        L_0x0a92:
            int r11 = com.tal.app.thinkacademy.business.shop.R.id.info_number
            r1.setImageResource(r11, r10)
        L_0x0a97:
            int r10 = com.tal.app.thinkacademy.business.shop.R.id.main_title
            java.lang.String r11 = r2.getTitle()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r10, r11)
            int r10 = com.tal.app.thinkacademy.business.shop.R.id.sub_title
            java.lang.String r11 = r2.getDesc()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r10, r11)
            int r10 = com.tal.app.thinkacademy.business.shop.R.id.top_line
            r6 = r6 ^ r8
            r1.setGone(r10, r6)
            int r6 = com.tal.app.thinkacademy.business.shop.R.id.bottom_line
            r7 = r7 ^ r8
            r1.setGone(r6, r7)
            int r6 = com.tal.app.thinkacademy.business.shop.R.id.faq_desc
            r7 = r3 ^ 1
            r1.setGone(r6, r7)
            if (r3 == 0) goto L_0x0afd
            int r3 = com.tal.app.thinkacademy.business.shop.R.id.faq_desc
            android.view.View r3 = r1.getView(r3)
            r11 = r3
            android.widget.TextView r11 = (android.widget.TextView) r11
            com.tal.app.thinkacademy.common.utils.TextHighLightUtil r10 = com.tal.app.thinkacademy.common.utils.TextHighLightUtil.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r2.getLocal_faq_desc()
            r3.append(r6)
            java.lang.String r6 = r2.getLocal_faq_name()
            r3.append(r6)
            r6 = 46
            r3.append(r6)
            java.lang.String r12 = r3.toString()
            java.lang.String r2 = r2.getLocal_faq_name()
            java.lang.String r3 = "."
            java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            int r14 = com.tal.app.thinkacademy.business.shop.R.color.color_ffaa0a
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter$$ExternalSyntheticLambda0 r15 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter$$ExternalSyntheticLambda0
            r15.<init>(r0)
            r10.setTextHighLightWithClick(r11, r12, r13, r14, r15)
        L_0x0afd:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.step_info_root
            r1.setBackgroundResource(r2, r4)
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.step_info_root
            android.view.View r1 = r1.getView(r2)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            r1.setPadding(r9, r9, r9, r5)
        L_0x0b0d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.chad.library.adapter.base.entity.MultiItemEntity):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-3  reason: not valid java name */
    public static final void m249convert$lambda3(ShopClassDetailAdapter shopClassDetailAdapter, View view) {
        Intrinsics.checkNotNullParameter(shopClassDetailAdapter, "this$0");
        String touchHost = UrlUtils.INSTANCE.getTouchHost();
        Bundle bundle = new Bundle();
        StringBuffer stringBuffer = new StringBuffer(touchHost);
        stringBuffer.append("/app-v2/faq");
        bundle.putString("jump_key", stringBuffer.toString());
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
        ShopTrack.INSTANCE.hw_steps_FAQ_click(shopClassDetailAdapter.mClassId);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean showClassCardPrice(com.chad.library.adapter.base.viewholder.BaseViewHolder r11, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r12) {
        /*
            r10 = this;
            long r0 = r12.getRemainSellTime()
            int r2 = r12.getStore()
            int r3 = r12.getSellStore()
            int r0 = r10.getTagResIndex(r0, r2, r3)
            r1 = 1
            r2 = 0
            r3 = 4
            if (r0 != r3) goto L_0x0017
            r0 = r1
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            com.tal.app.thinkacademy.common.constants.SchoolConstants r3 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            int r4 = r10.mSchoolCode
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CurrencyDesc r3 = r3.getSchoolCurrency(r4)
            int r4 = r12.getPerShowPrice()
            if (r4 <= 0) goto L_0x002c
            r4 = r1
            goto L_0x002d
        L_0x002c:
            r4 = r2
        L_0x002d:
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0044
            int r6 = r12.getOrgPrice()
            int r7 = r12.getSellPrice()
            if (r6 <= r7) goto L_0x0057
            int r6 = r12.getPerOrgPrice()
            java.lang.String r6 = r10.makePrice(r3, r6)
            goto L_0x0058
        L_0x0044:
            int r6 = r12.getOrgPrice()
            int r7 = r12.getSellPrice()
            if (r6 <= r7) goto L_0x0057
            int r6 = r12.getOrgPrice()
            java.lang.String r6 = r10.makePrice(r3, r6)
            goto L_0x0058
        L_0x0057:
            r6 = r5
        L_0x0058:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r7 = r12.getSpec()
            if (r7 != 0) goto L_0x005f
            goto L_0x006b
        L_0x005f:
            int r8 = r7.getLeftLesson()
            int r7 = r7.getLessonCount()
            if (r8 != r7) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r6 = r5
        L_0x006b:
            if (r4 == 0) goto L_0x0077
            int r12 = r12.getPerShowPrice()
            java.lang.String r12 = r10.makePrice(r3, r12)
            r3 = r2
            goto L_0x0099
        L_0x0077:
            int r7 = r12.getShowPrice()
            if (r7 > 0) goto L_0x0089
            android.content.Context r12 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.free
            java.lang.String r12 = r12.getString(r3)
            r3 = r1
            goto L_0x0093
        L_0x0089:
            int r12 = r12.getShowPrice()
            java.lang.String r12 = r10.makePrice(r3, r12)
            r3 = r2
            r5 = r6
        L_0x0093:
            java.lang.String r6 = "{\n            if (item.s…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
            r6 = r5
        L_0x0099:
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tv_org_price
            android.view.View r5 = r11.getView(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r7 = r6.length()
            if (r7 <= 0) goto L_0x00ab
            r7 = r1
            goto L_0x00ac
        L_0x00ab:
            r7 = r2
        L_0x00ac:
            r8 = 8
            if (r7 == 0) goto L_0x00c0
            r5.setVisibility(r2)
            android.text.TextPaint r7 = r5.getPaint()
            r9 = 16
            r7.setFlags(r9)
            r5.setText(r6)
            goto L_0x00c3
        L_0x00c0:
            r5.setVisibility(r8)
        L_0x00c3:
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tv_show_price
            android.view.View r5 = r11.getView(r5)
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r5 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r5
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r5.setText(r12)
            r12 = r0 ^ 1
            r5.setHasData(r12)
            int r12 = com.tal.app.thinkacademy.business.shop.R.id.tv_price_company
            android.view.View r11 = r11.getView(r12)
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r11 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r11
            if (r4 == 0) goto L_0x00e0
            goto L_0x00e1
        L_0x00e0:
            r2 = r8
        L_0x00e1:
            r11.setVisibility(r2)
            r12 = r0 ^ 1
            r11.setHasData(r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailAdapter.showClassCardPrice(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean):boolean");
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailAdapter$ClassTagRes;", "", "textRes", "", "bgRes", "(II)V", "getBgRes", "()I", "setBgRes", "(I)V", "getTextRes", "setTextRes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailAdapter.kt */
    private static final class ClassTagRes {
        private int bgRes;
        private int textRes;

        public static /* synthetic */ ClassTagRes copy$default(ClassTagRes classTagRes, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = classTagRes.textRes;
            }
            if ((i3 & 2) != 0) {
                i2 = classTagRes.bgRes;
            }
            return classTagRes.copy(i, i2);
        }

        public final int component1() {
            return this.textRes;
        }

        public final int component2() {
            return this.bgRes;
        }

        public final ClassTagRes copy(int i, int i2) {
            return new ClassTagRes(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClassTagRes)) {
                return false;
            }
            ClassTagRes classTagRes = (ClassTagRes) obj;
            return this.textRes == classTagRes.textRes && this.bgRes == classTagRes.bgRes;
        }

        public int hashCode() {
            return (this.textRes * 31) + this.bgRes;
        }

        public String toString() {
            return "ClassTagRes(textRes=" + this.textRes + ", bgRes=" + this.bgRes + ')';
        }

        public ClassTagRes(int i, int i2) {
            this.textRes = i;
            this.bgRes = i2;
        }

        public final int getBgRes() {
            return this.bgRes;
        }

        public final int getTextRes() {
            return this.textRes;
        }

        public final void setBgRes(int i) {
            this.bgRes = i;
        }

        public final void setTextRes(int i) {
            this.textRes = i;
        }
    }
}
