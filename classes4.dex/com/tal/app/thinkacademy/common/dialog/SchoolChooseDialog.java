package com.tal.app.thinkacademy.common.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JT\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/dialog/SchoolChooseDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mChangeCountryDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "showSchool", "", "filter", "", "", "select", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "SchoolCodeBean", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolChooseDialog.kt */
public final class SchoolChooseDialog {
    private final Context context;
    private BaseDialog mChangeCountryDialog;

    public SchoolChooseDialog(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public static /* synthetic */ void showSchool$default(SchoolChooseDialog schoolChooseDialog, List list, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        schoolChooseDialog.showSchool(list, function2);
    }

    public final void showSchool(List<String> list, Function2<? super Integer, ? super String, Unit> function2) {
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …A_NOT_CLEAR\n            )");
        int parseInt = Integer.parseInt(string);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        List<SchoolDataInfo> schoolList = SchoolConstants.INSTANCE.getSchoolList();
        if (schoolList != null) {
            int i = 0;
            for (Object next : schoolList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SchoolDataInfo schoolDataInfo = (SchoolDataInfo) next;
                List list2 = (List) objectRef.element;
                int tryParseInt = ParseUtils.tryParseInt(schoolDataInfo.getSchoolCode(), 0);
                String schoolName = schoolDataInfo.getSchoolName();
                if (schoolName == null) {
                    schoolName = "";
                }
                list2.add(new SchoolCodeBean(tryParseInt, schoolName));
                i = i2;
            }
        }
        if (list != null) {
            Collection arrayList = new ArrayList();
            for (Object next2 : (Iterable) objectRef.element) {
                if (list.contains(String.valueOf(((SchoolCodeBean) next2).getCode()))) {
                    arrayList.add(next2);
                }
            }
            objectRef.element = TypeIntrinsics.asMutableList((List) arrayList);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int i3 = 0;
        for (Object next3 : (Iterable) objectRef.element) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((SchoolCodeBean) next3).getCode() == parseInt) {
                intRef.element = i3;
            }
            i3 = i4;
        }
        BaseDialog baseDialog = this.mChangeCountryDialog;
        if (baseDialog == null) {
            BaseDialog baseDialog2 = new BaseDialog(this.context);
            baseDialog2.contentView(R.layout.dialog_wheel).gravity(80).layoutParams(new LinearLayout.LayoutParams(-1, -2)).canceledOnTouchOutside(true);
            WheelView wheelView = (WheelView) baseDialog2.findViewById(R.id.wheelView);
            wheelView.setCyclic(false);
            wheelView.setItemHeight(SizeUtils.dp2px(60.0f));
            wheelView.setRoundRadius(SizeUtils.dp2px(30.0f));
            wheelView.setTextColorCenter(ContextCompat.getColor(baseDialog2.getContext(), R.color.color_ffaa0a));
            wheelView.setTextColorOut(ContextCompat.getColor(baseDialog2.getContext(), R.color.color_A2AAB8));
            wheelView.setDividerColor(ContextCompat.getColor(baseDialog2.getContext(), R.color.color_14ffaa0a));
            wheelView.setDividerType(WheelView.DividerType.ROUND_RECT);
            wheelView.setAdapter(new SchoolChooseDialog$showSchool$4$1(objectRef));
            wheelView.setCurrentItem(intRef.element);
            wheelView.setOnItemSelectedListener(new SchoolChooseDialog$$ExternalSyntheticLambda2(intRef));
            ((ImageView) baseDialog2.findViewById(R.id.iv_cancel)).setOnClickListener(new SchoolChooseDialog$$ExternalSyntheticLambda0(baseDialog2));
            ((ImageView) baseDialog2.findViewById(R.id.iv_confirm)).setOnClickListener(new SchoolChooseDialog$$ExternalSyntheticLambda1(baseDialog2, parseInt, objectRef, intRef, function2));
            this.mChangeCountryDialog = baseDialog2;
        } else {
            WheelView wheelView2 = baseDialog == null ? null : (WheelView) baseDialog.findViewById(R.id.wheelView);
            if (wheelView2 != null) {
                wheelView2.setCurrentItem(intRef.element);
            }
        }
        BaseDialog baseDialog3 = this.mChangeCountryDialog;
        if (baseDialog3 != null) {
            baseDialog3.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSchool$lambda-7$lambda-4  reason: not valid java name */
    public static final void m43showSchool$lambda7$lambda4(Ref.IntRef intRef, int i) {
        Intrinsics.checkNotNullParameter(intRef, "$currentIndex");
        intRef.element = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: showSchool$lambda-7$lambda-5  reason: not valid java name */
    public static final void m44showSchool$lambda7$lambda5(BaseDialog baseDialog, View view) {
        Intrinsics.checkNotNullParameter(baseDialog, "$this_apply");
        LeanplumUtil.commonTrack$default(LeanplumUtil.click_school_selector_close, (HashMap) null, 2, (Object) null);
        baseDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showSchool$lambda-7$lambda-6  reason: not valid java name */
    public static final void m45showSchool$lambda7$lambda6(BaseDialog baseDialog, int i, Ref.ObjectRef objectRef, Ref.IntRef intRef, Function2 function2, View view) {
        Intrinsics.checkNotNullParameter(baseDialog, "$this_apply");
        Intrinsics.checkNotNullParameter(objectRef, "$schoolList");
        Intrinsics.checkNotNullParameter(intRef, "$currentIndex");
        LeanplumUtil.commonTrack$default(LeanplumUtil.click_school_selector_submit, (HashMap) null, 2, (Object) null);
        baseDialog.dismiss();
        if (i != ((SchoolCodeBean) ((List) objectRef.element).get(intRef.element)).getCode()) {
            if (function2 != null) {
                function2.invoke(Integer.valueOf(((SchoolCodeBean) ((List) objectRef.element).get(intRef.element)).getCode()), ((SchoolCodeBean) ((List) objectRef.element).get(intRef.element)).getName());
            }
            ChooseSchoolUtil.INSTANCE.updateSchoolInfo(((SchoolCodeBean) ((List) objectRef.element).get(intRef.element)).getCode());
            ChooseSchoolUtil.INSTANCE.changeSchool(((SchoolCodeBean) ((List) objectRef.element).get(intRef.element)).getCode(), baseDialog.getContext());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/dialog/SchoolChooseDialog$SchoolCodeBean;", "", "code", "", "name", "", "(ILjava/lang/String;)V", "getCode", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchoolChooseDialog.kt */
    private static final class SchoolCodeBean {
        private final int code;
        private final String name;

        public static /* synthetic */ SchoolCodeBean copy$default(SchoolCodeBean schoolCodeBean, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = schoolCodeBean.code;
            }
            if ((i2 & 2) != 0) {
                str = schoolCodeBean.name;
            }
            return schoolCodeBean.copy(i, str);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.name;
        }

        public final SchoolCodeBean copy(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new SchoolCodeBean(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SchoolCodeBean)) {
                return false;
            }
            SchoolCodeBean schoolCodeBean = (SchoolCodeBean) obj;
            return this.code == schoolCodeBean.code && Intrinsics.areEqual(this.name, schoolCodeBean.name);
        }

        public int hashCode() {
            return (this.code * 31) + this.name.hashCode();
        }

        public String toString() {
            return "SchoolCodeBean(code=" + this.code + ", name=" + this.name + ')';
        }

        public SchoolCodeBean(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.code = i;
            this.name = str;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getName() {
            return this.name;
        }
    }
}
