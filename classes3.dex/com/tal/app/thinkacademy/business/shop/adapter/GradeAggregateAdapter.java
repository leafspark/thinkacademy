package com.tal.app.thinkacademy.business.shop.adapter;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateClassItemProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateDiagnosisProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateHeadTitleProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateHtmlProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateLeaveInfoItemInput;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateLeaveInfoItemMoreSelect;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateLeaveInfoItemPostButton;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateLeaveInfoItemSelect;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateTeacherItemProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate.GradeAggregateTitleProvider;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHeadDescription;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml;
import com.tal.app.thinkacademy.business.shop.bean.LeaveLayoutType;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.ChosenSchoolBean;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.user.Grade;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\u001e\u0010 \u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001e2\u0006\u0010#\u001a\u00020\u0004H\u0014J\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/GradeAggregateAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "()V", "mChosenCountryIndex", "", "getMChosenCountryIndex", "()I", "setMChosenCountryIndex", "(I)V", "mGradeList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/common/user/Grade;", "Lkotlin/collections/ArrayList;", "getMGradeList", "()Ljava/util/ArrayList;", "setMGradeList", "(Ljava/util/ArrayList;)V", "mPhoneAreaNum", "", "getMPhoneAreaNum", "()Ljava/lang/String;", "setMPhoneAreaNum", "(Ljava/lang/String;)V", "mPhoneLengthMax", "getMPhoneLengthMax", "setMPhoneLengthMax", "mPhoneLengthMin", "getMPhoneLengthMin", "setMPhoneLengthMin", "getInternationalList", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "getItemType", "data", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "position", "getPhoneAreaInfo", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateAdapter.kt */
public final class GradeAggregateAdapter extends BaseNodeAdapter {
    private int mChosenCountryIndex = -1;
    private ArrayList<Grade> mGradeList;
    private String mPhoneAreaNum = DbParams.GZIP_DATA_EVENT;
    private int mPhoneLengthMax = 99;
    private int mPhoneLengthMin = 1;

    public GradeAggregateAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addFullSpanNodeProvider(new GradeAggregateHeadTitleProvider());
        addFullSpanNodeProvider(new GradeAggregateHtmlProvider());
        addFullSpanNodeProvider(new GradeAggregateDiagnosisProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addFullSpanNodeProvider(new GradeAggregateTitleProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addNodeProvider(new GradeAggregateTeacherItemProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addNodeProvider(new GradeAggregateClassItemProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addNodeProvider(new GradeAggregateLeaveInfoItemInput());
        addNodeProvider(new GradeAggregateLeaveInfoItemSelect());
        addNodeProvider(new GradeAggregateLeaveInfoItemMoreSelect());
        addNodeProvider(new GradeAggregateLeaveInfoItemPostButton());
    }

    /* access modifiers changed from: protected */
    public int getItemType(List<? extends BaseNode> list, int i) {
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
        UserLeaveComponentData userLeaveComponentData = list.get(i);
        if (userLeaveComponentData instanceof GradeAggregateHeadDescription) {
            return GradeAggregateEnum.HEAD_TITLE.getValue();
        }
        if (userLeaveComponentData instanceof GradeAggregateHtml) {
            return GradeAggregateEnum.HTML.getValue();
        }
        if (userLeaveComponentData instanceof GradeAggregateDiagnosisNode) {
            return GradeAggregateEnum.DIAGNOSIS.getValue();
        }
        if (userLeaveComponentData instanceof GradeAggregateTitleNode) {
            return GradeAggregateEnum.COMPONENTTITLE.getValue();
        }
        if (userLeaveComponentData instanceof GradeAggregateTeacherNode) {
            return GradeAggregateEnum.TEACHERLIST.getValue();
        }
        if (userLeaveComponentData instanceof ShopClassGoodsData) {
            return GradeAggregateEnum.CLASSLIST.getValue();
        }
        if (userLeaveComponentData instanceof UserLeaveComponentData) {
            String optionsType = userLeaveComponentData.getOptionsType();
            if (Intrinsics.areEqual((Object) optionsType, (Object) LeaveLayoutType.LAYOUT_INPUT.getTypeName())) {
                return GradeAggregateEnum.LEAVE_INFO_INPUT.getValue();
            }
            if (Intrinsics.areEqual((Object) optionsType, (Object) LeaveLayoutType.LAYOUT_SINGLE_SELECT.getTypeName())) {
                return GradeAggregateEnum.LEAVE_INFO_SINGLE_SELECT.getValue();
            }
            if (Intrinsics.areEqual((Object) optionsType, (Object) LeaveLayoutType.LAYOUT_MORE_SELECT.getTypeName())) {
                return GradeAggregateEnum.LEAVE_INFO_MORE_SELECT.getValue();
            }
            return GradeAggregateEnum.LEAVE_INFO_INPUT.getValue();
        } else if (userLeaveComponentData instanceof UserLeaveButtonData) {
            return GradeAggregateEnum.LEAVE_INFO_POST_BUTTON.getValue();
        } else {
            return -1;
        }
    }

    public final ArrayList<Grade> getMGradeList() {
        return this.mGradeList;
    }

    public final void setMGradeList(ArrayList<Grade> arrayList) {
        this.mGradeList = arrayList;
    }

    public final int getMChosenCountryIndex() {
        return this.mChosenCountryIndex;
    }

    public final void setMChosenCountryIndex(int i) {
        this.mChosenCountryIndex = i;
    }

    public final int getMPhoneLengthMax() {
        return this.mPhoneLengthMax;
    }

    public final void setMPhoneLengthMax(int i) {
        this.mPhoneLengthMax = i;
    }

    public final int getMPhoneLengthMin() {
        return this.mPhoneLengthMin;
    }

    public final void setMPhoneLengthMin(int i) {
        this.mPhoneLengthMin = i;
    }

    public final String getMPhoneAreaNum() {
        return this.mPhoneAreaNum;
    }

    public final void setMPhoneAreaNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mPhoneAreaNum = str;
    }

    public final void getPhoneAreaInfo() {
        List<ConfigInfo.Country> internationalList;
        ChosenSchoolBean chosenSchoolBean = (ChosenSchoolBean) ShareDataManager.getInstance().getCacheEntity(ChosenSchoolBean.class, "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (chosenSchoolBean == null) {
            return;
        }
        if (this.mChosenCountryIndex == -1) {
            this.mPhoneLengthMin = chosenSchoolBean.phoneMinLength;
            this.mPhoneLengthMax = chosenSchoolBean.phoneMaxLength;
            SchoolDataInfo schoolInfo = SchoolConstants.INSTANCE.getSchoolInfo(chosenSchoolBean.schoolCode);
            if (schoolInfo != null) {
                setMPhoneLengthMin(schoolInfo.getPhoneMinLength());
                setMPhoneLengthMax(schoolInfo.getPhoneMaxLength());
            }
            if (getInternationalList() != null && (internationalList = getInternationalList()) != null) {
                int i = 0;
                for (Object next : internationalList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ConfigInfo.Country country = (ConfigInfo.Country) next;
                    if (Intrinsics.areEqual((Object) chosenSchoolBean.countryCallingCode, (Object) country.getCountryCallingCode())) {
                        setMChosenCountryIndex(i);
                        setMPhoneLengthMin(country.getPhoneMinLength());
                        setMPhoneLengthMax(country.getPhoneMaxLength());
                        setMPhoneAreaNum(country.getCountryCallingCode());
                        return;
                    }
                    i = i2;
                }
                return;
            }
            return;
        }
        List<ConfigInfo.Country> internationalList2 = getInternationalList();
        if (internationalList2 != null) {
            ConfigInfo.Country country2 = internationalList2.get(getMChosenCountryIndex());
            setMPhoneLengthMin(country2.getPhoneMinLength());
            setMPhoneLengthMax(country2.getPhoneMaxLength());
            setMPhoneAreaNum(country2.getCountryCallingCode());
        }
    }

    public final List<ConfigInfo.Country> getInternationalList() {
        return ImConfig.INSTANCE.getInternationalInfo();
    }
}
