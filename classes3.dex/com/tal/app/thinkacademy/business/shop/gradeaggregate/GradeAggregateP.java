package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding;
import com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.common.user.GradeStage;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0012J\u0006\u00102\u001a\u00020-J\b\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020-H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020-H\u0002J\u0006\u00109\u001a\u00020-R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0011j\b\u0012\u0004\u0012\u00020\u001b`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0011j\b\u0012\u0004\u0012\u00020!`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateP;", "", "mViewModel", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm;", "activity", "Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;", "(Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm;Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;)V", "getActivity", "()Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;", "setActivity", "(Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;)V", "context", "Ljava/lang/ref/SoftReference;", "mDayDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopDialogWheelBinding;", "mDayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mDayPosition", "mDayScrollPosition", "mEditEmail", "Landroid/widget/EditText;", "mEditName", "mGradeDialog", "mGradeList", "Lcom/tal/app/thinkacademy/common/user/Grade;", "mGradePosition", "mGradeScrollPosition", "mPageId", "mTimeDialog", "mTimeList", "", "mTimePosition", "mTimeScrollPosition", "mTvDay", "Landroid/widget/TextView;", "mTvGroup", "mTvTime", "getMViewModel", "()Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm;", "setMViewModel", "(Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm;)V", "clearFocus", "", "footViewShow", "footView", "Landroid/view/View;", "pageId", "onDestroy", "showDayDialog", "showGradeDialog", "showSubmitToast", "success", "", "showTimeDialog", "viewmModelObserve", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateP.kt */
public final class GradeAggregateP {
    private GradeAggregateActivity activity;
    private SoftReference<GradeAggregateActivity> context = new SoftReference<>(this.activity);
    private BaseBindDialog<ShopDialogWheelBinding> mDayDialog;
    /* access modifiers changed from: private */
    public ArrayList<Integer> mDayList = CollectionsKt.arrayListOf(Integer.valueOf(R.string.monday), Integer.valueOf(R.string.tuesday), Integer.valueOf(R.string.wednesday), Integer.valueOf(R.string.thursday), Integer.valueOf(R.string.friday), Integer.valueOf(R.string.saturday), Integer.valueOf(R.string.sunday));
    private int mDayPosition;
    private int mDayScrollPosition;
    /* access modifiers changed from: private */
    public EditText mEditEmail;
    /* access modifiers changed from: private */
    public EditText mEditName;
    private BaseBindDialog<ShopDialogWheelBinding> mGradeDialog;
    /* access modifiers changed from: private */
    public ArrayList<Grade> mGradeList = new ArrayList<>();
    private int mGradePosition;
    private int mGradeScrollPosition;
    /* access modifiers changed from: private */
    public int mPageId = -1;
    private BaseBindDialog<ShopDialogWheelBinding> mTimeDialog;
    /* access modifiers changed from: private */
    public ArrayList<String> mTimeList = CollectionsKt.arrayListOf("8~10", "10~12", "12~14", "14~16", "16~18", "18~20");
    private int mTimePosition;
    private int mTimeScrollPosition;
    /* access modifiers changed from: private */
    public TextView mTvDay;
    /* access modifiers changed from: private */
    public TextView mTvGroup;
    /* access modifiers changed from: private */
    public TextView mTvTime;
    private GradeAggregateVm mViewModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateP.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GradeAggregateP(GradeAggregateVm gradeAggregateVm, GradeAggregateActivity gradeAggregateActivity) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "activity");
        this.mViewModel = gradeAggregateVm;
        this.activity = gradeAggregateActivity;
    }

    public final GradeAggregateVm getMViewModel() {
        return this.mViewModel;
    }

    public final void setMViewModel(GradeAggregateVm gradeAggregateVm) {
        this.mViewModel = gradeAggregateVm;
    }

    public final GradeAggregateActivity getActivity() {
        return this.activity;
    }

    public final void setActivity(GradeAggregateActivity gradeAggregateActivity) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "<set-?>");
        this.activity = gradeAggregateActivity;
    }

    public final void viewmModelObserve() {
        LifecycleOwner lifecycleOwner;
        StateLiveData<GradeStageList> gradeStageLists;
        StateLiveData<Object> submitIntention;
        SoftReference<GradeAggregateActivity> softReference = this.context;
        if (softReference != null && (lifecycleOwner = (GradeAggregateActivity) softReference.get()) != null) {
            GradeAggregateVm mViewModel2 = getMViewModel();
            if (!(mViewModel2 == null || (submitIntention = mViewModel2.getSubmitIntention()) == null)) {
                submitIntention.observe(lifecycleOwner, new GradeAggregateP$$ExternalSyntheticLambda11(lifecycleOwner, this));
            }
            GradeAggregateVm mViewModel3 = getMViewModel();
            if (mViewModel3 != null && (gradeStageLists = mViewModel3.getGradeStageLists()) != null) {
                gradeStageLists.observe(lifecycleOwner, new GradeAggregateP$$ExternalSyntheticLambda12(lifecycleOwner, this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-2$lambda-0  reason: not valid java name */
    public static final void m352viewmModelObserve$lambda2$lambda0(GradeAggregateActivity gradeAggregateActivity, GradeAggregateP gradeAggregateP, StateData stateData) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "$activity");
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        gradeAggregateActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            gradeAggregateP.showSubmitToast(true);
            return;
        }
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-2$lambda-1  reason: not valid java name */
    public static final void m353viewmModelObserve$lambda2$lambda1(GradeAggregateActivity gradeAggregateActivity, GradeAggregateP gradeAggregateP, StateData stateData) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "$activity");
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        gradeAggregateActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            Object data = stateData.getData();
            Intrinsics.checkNotNull(data);
            List list = ((GradeStageList) data).getList();
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                List list2 = ((GradeStage) list.get(i)).getList();
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    gradeAggregateP.mGradeList.add((Grade) list2.get(i3));
                }
                i = i2;
            }
            gradeAggregateP.showGradeDialog();
            return;
        }
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
    }

    public final void footViewShow(View view, int i) {
        GradeAggregateActivity gradeAggregateActivity;
        View view2;
        GradeAggregateActivity gradeAggregateActivity2;
        long j;
        TextView textView;
        TextView textView2;
        long j2;
        View view3 = view;
        Intrinsics.checkNotNullParameter(view3, "footView");
        this.mPageId = i;
        SoftReference<GradeAggregateActivity> softReference = this.context;
        if (softReference != null && (gradeAggregateActivity = softReference.get()) != null) {
            View view4 = (RoundRelativeLayout) view3.findViewById(R.id.rlGroup);
            this.mTvGroup = (TextView) view3.findViewById(R.id.tvGroup);
            TextView textView3 = (TextView) view3.findViewById(R.id.groupPrompt);
            View view5 = (RoundRelativeLayout) view3.findViewById(R.id.rlDay);
            this.mTvDay = (TextView) view3.findViewById(R.id.tvDay);
            TextView textView4 = (TextView) view3.findViewById(R.id.dayPrompt);
            View view6 = (RoundRelativeLayout) view3.findViewById(R.id.rlTime);
            this.mTvTime = (TextView) view3.findViewById(R.id.tvTime);
            TextView textView5 = (TextView) view3.findViewById(R.id.timePrompt);
            this.mEditEmail = (EditText) view3.findViewById(R.id.editEmail);
            TextView textView6 = (TextView) view3.findViewById(R.id.emailPrompt);
            this.mEditName = (EditText) view3.findViewById(R.id.editName);
            TextView textView7 = (TextView) view3.findViewById(R.id.namePrompt);
            LinearLayout linearLayout = (LinearLayout) view3.findViewById(R.id.llSeleted);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = view3.findViewById(R.id.ivSeleted);
            View view7 = (RoundTextView) view3.findViewById(R.id.tvSubmit);
            ((ImageView) objectRef.element).setSelected(true);
            if (linearLayout == null) {
                gradeAggregateActivity2 = gradeAggregateActivity;
                view2 = view4;
                j = 300;
            } else {
                gradeAggregateActivity2 = gradeAggregateActivity;
                view2 = view4;
                j = 300;
                RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(linearLayout, 300, new GradeAggregateP$footViewShow$1$1(objectRef));
            }
            EditText editText = this.mEditEmail;
            if (editText != null) {
                editText.setOnFocusChangeListener(new GradeAggregateP$$ExternalSyntheticLambda10(textView6, this));
            }
            EditText editText2 = this.mEditName;
            if (editText2 != null) {
                editText2.setOnFocusChangeListener(new GradeAggregateP$$ExternalSyntheticLambda9(textView7, this));
            }
            if (view7 == null) {
                textView2 = textView5;
                j2 = j;
                textView = textView3;
            } else {
                textView = textView3;
                long j3 = j;
                textView2 = textView5;
                j2 = 300;
                RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view7, 300, new GradeAggregateP$footViewShow$1$4(this, textView3, textView4, textView5, textView6, textView7, gradeAggregateActivity2, objectRef));
            }
            if (view2 != null) {
                RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view2, j2, new GradeAggregateP$footViewShow$1$5(textView, this, gradeAggregateActivity2));
            }
            if (view5 != null) {
                RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view5, j2, new GradeAggregateP$footViewShow$1$6(textView4, this));
            }
            if (view6 != null) {
                RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view6, j2, new GradeAggregateP$footViewShow$1$7(textView2, this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: footViewShow$lambda-9$lambda-5  reason: not valid java name */
    public static final void m341footViewShow$lambda9$lambda5(TextView textView, GradeAggregateP gradeAggregateP, View view, boolean z) {
        GradeAggregateActivity gradeAggregateActivity;
        EditText editText;
        GradeAggregateActivity gradeAggregateActivity2;
        EditText editText2;
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        if (view.getId() != R.id.editEmail) {
            return;
        }
        if (z) {
            textView.setVisibility(8);
            EditText editText3 = gradeAggregateP.mEditEmail;
            if (editText3 != null) {
                editText3.setBackgroundResource(R.drawable.bug_shop_edittext_r6_color_fff9ec);
            }
            SoftReference<GradeAggregateActivity> softReference = gradeAggregateP.context;
            if (softReference != null && (gradeAggregateActivity2 = softReference.get()) != null && (editText2 = gradeAggregateP.mEditEmail) != null) {
                editText2.setTextColor(gradeAggregateActivity2.getColor(R.color.color_ffaa0a));
                return;
            }
            return;
        }
        EditText editText4 = gradeAggregateP.mEditEmail;
        if (editText4 != null) {
            editText4.setBackground((Drawable) null);
        }
        SoftReference<GradeAggregateActivity> softReference2 = gradeAggregateP.context;
        if (softReference2 != null && (gradeAggregateActivity = softReference2.get()) != null && (editText = gradeAggregateP.mEditEmail) != null) {
            editText.setTextColor(gradeAggregateActivity.getColor(R.color.color_172b4d));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: footViewShow$lambda-9$lambda-8  reason: not valid java name */
    public static final void m342footViewShow$lambda9$lambda8(TextView textView, GradeAggregateP gradeAggregateP, View view, boolean z) {
        GradeAggregateActivity gradeAggregateActivity;
        EditText editText;
        GradeAggregateActivity gradeAggregateActivity2;
        EditText editText2;
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        if (view.getId() != R.id.editName) {
            return;
        }
        if (z) {
            textView.setVisibility(8);
            EditText editText3 = gradeAggregateP.mEditName;
            if (editText3 != null) {
                editText3.setBackgroundResource(R.drawable.bug_shop_edittext_r6_color_fff9ec);
            }
            SoftReference<GradeAggregateActivity> softReference = gradeAggregateP.context;
            if (softReference != null && (gradeAggregateActivity2 = softReference.get()) != null && (editText2 = gradeAggregateP.mEditName) != null) {
                editText2.setTextColor(gradeAggregateActivity2.getColor(R.color.color_ffaa0a));
                return;
            }
            return;
        }
        EditText editText4 = gradeAggregateP.mEditName;
        if (editText4 != null) {
            editText4.setBackground((Drawable) null);
        }
        SoftReference<GradeAggregateActivity> softReference2 = gradeAggregateP.context;
        if (softReference2 != null && (gradeAggregateActivity = softReference2.get()) != null && (editText = gradeAggregateP.mEditName) != null) {
            editText.setTextColor(gradeAggregateActivity.getColor(R.color.color_172b4d));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fc, code lost:
        r0 = r0.binding;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showGradeDialog() {
        /*
            r6 = this;
            java.lang.ref.SoftReference<com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity> r0 = r6.context
            if (r0 != 0) goto L_0x0006
            goto L_0x017b
        L_0x0006:
            java.lang.Object r0 = r0.get()
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r0 = (com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity) r0
            if (r0 != 0) goto L_0x0010
            goto L_0x017b
        L_0x0010:
            boolean r1 = r0.isFinishing()
            if (r1 != 0) goto L_0x017b
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            r2 = 0
            if (r1 != 0) goto L_0x015d
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showGradeDialog$1$1 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showGradeDialog$1$1
            r1.<init>(r0)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog r1 = (com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog) r1
            r6.mGradeDialog = r1
            r3 = 80
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r1 = r1.gravity(r3)
            if (r1 != 0) goto L_0x002d
            goto L_0x0041
        L_0x002d:
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = -1
            r5 = -2
            r3.<init>(r4, r5)
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r1 = r1.layoutParams(r3)
            if (r1 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            r3 = 1
            r1.canceledOnTouchOutside(r3)
        L_0x0041:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            if (r1 != 0) goto L_0x0046
            goto L_0x0056
        L_0x0046:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0052
            goto L_0x0056
        L_0x0052:
            r3 = 0
            r1.setCyclic(r3)
        L_0x0056:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            if (r1 != 0) goto L_0x005b
            goto L_0x0070
        L_0x005b:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0062
            goto L_0x0070
        L_0x0062:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0067
            goto L_0x0070
        L_0x0067:
            r3 = 1114636288(0x42700000, float:60.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r1.setItemHeight(r3)
        L_0x0070:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            if (r1 != 0) goto L_0x0075
            goto L_0x008a
        L_0x0075:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x007c
            goto L_0x008a
        L_0x007c:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0081
            goto L_0x008a
        L_0x0081:
            r3 = 1106247680(0x41f00000, float:30.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r1.setRoundRadius(r3)
        L_0x008a:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            if (r1 != 0) goto L_0x008f
            goto L_0x00a7
        L_0x008f:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0096
            goto L_0x00a7
        L_0x0096:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_ffaa0a
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColorCenter(r3)
        L_0x00a7:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            if (r1 != 0) goto L_0x00ac
            goto L_0x00c4
        L_0x00ac:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00b3
            goto L_0x00c4
        L_0x00b3:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c4
        L_0x00b8:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColorOut(r3)
        L_0x00c4:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mGradeDialog
            if (r1 != 0) goto L_0x00c9
            goto L_0x00e0
        L_0x00c9:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00d0
            goto L_0x00e0
        L_0x00d0:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00d5
            goto L_0x00e0
        L_0x00d5:
            android.content.Context r0 = (android.content.Context) r0
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_14ffaa0a
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r3)
            r1.setDividerColor(r0)
        L_0x00e0:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f6
        L_0x00e5:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x00ec
            goto L_0x00f6
        L_0x00ec:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x00f1
            goto L_0x00f6
        L_0x00f1:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView$DividerType r1 = com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView.DividerType.ROUND_RECT
            r0.setDividerType(r1)
        L_0x00f6:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x00fc
        L_0x00fa:
            r0 = r2
            goto L_0x0105
        L_0x00fc:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0103
            goto L_0x00fa
        L_0x0103:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
        L_0x0105:
            if (r0 != 0) goto L_0x0108
            goto L_0x0112
        L_0x0108:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showGradeDialog$1$2 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showGradeDialog$1$2
            r1.<init>(r6)
            com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter r1 = (com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter) r1
            r0.setAdapter(r1)
        L_0x0112:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x0117
            goto L_0x012b
        L_0x0117:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x011e
            goto L_0x012b
        L_0x011e:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x0123
            goto L_0x012b
        L_0x0123:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda2 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda2
            r1.<init>(r6)
            r0.setOnItemSelectedListener(r1)
        L_0x012b:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x0130
            goto L_0x0144
        L_0x0130:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0137
            goto L_0x0144
        L_0x0137:
            android.widget.ImageView r0 = r0.ivCancel
            if (r0 != 0) goto L_0x013c
            goto L_0x0144
        L_0x013c:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda6 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda6
            r1.<init>(r6)
            r0.setOnClickListener(r1)
        L_0x0144:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x0149
            goto L_0x015d
        L_0x0149:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0150
            goto L_0x015d
        L_0x0150:
            android.widget.ImageView r0 = r0.ivConfirm
            if (r0 != 0) goto L_0x0155
            goto L_0x015d
        L_0x0155:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda7 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda7
            r1.<init>(r6)
            r0.setOnClickListener(r1)
        L_0x015d:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x0162
            goto L_0x016b
        L_0x0162:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r2 = r0.wheelView
        L_0x016b:
            if (r2 != 0) goto L_0x016e
            goto L_0x0173
        L_0x016e:
            int r0 = r6.mGradePosition
            r2.setCurrentItem(r0)
        L_0x0173:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mGradeDialog
            if (r0 != 0) goto L_0x0178
            goto L_0x017b
        L_0x0178:
            r0.show()
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP.showGradeDialog():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showGradeDialog$lambda-13$lambda-10  reason: not valid java name */
    public static final void m346showGradeDialog$lambda13$lambda10(GradeAggregateP gradeAggregateP, int i) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        gradeAggregateP.mGradeScrollPosition = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: showGradeDialog$lambda-13$lambda-11  reason: not valid java name */
    public static final void m347showGradeDialog$lambda13$lambda11(GradeAggregateP gradeAggregateP, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = gradeAggregateP.mGradeDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showGradeDialog$lambda-13$lambda-12  reason: not valid java name */
    public static final void m348showGradeDialog$lambda13$lambda12(GradeAggregateP gradeAggregateP, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        int i = gradeAggregateP.mGradeScrollPosition;
        gradeAggregateP.mGradePosition = i;
        TextView textView = gradeAggregateP.mTvGroup;
        if (textView != null) {
            textView.setText(gradeAggregateP.mGradeList.get(i).getName());
        }
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = gradeAggregateP.mGradeDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fd, code lost:
        r1 = r1.binding;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showDayDialog() {
        /*
            r6 = this;
            java.lang.ref.SoftReference<com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity> r0 = r6.context
            if (r0 != 0) goto L_0x0006
            goto L_0x017c
        L_0x0006:
            java.lang.Object r0 = r0.get()
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r0 = (com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity) r0
            if (r0 != 0) goto L_0x0010
            goto L_0x017c
        L_0x0010:
            boolean r1 = r0.isFinishing()
            if (r1 != 0) goto L_0x017c
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            r2 = 0
            if (r1 != 0) goto L_0x015e
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showDayDialog$1$1 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showDayDialog$1$1
            r1.<init>(r0)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog r1 = (com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog) r1
            r6.mDayDialog = r1
            r3 = 80
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r1 = r1.gravity(r3)
            if (r1 != 0) goto L_0x002d
            goto L_0x0041
        L_0x002d:
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = -1
            r5 = -2
            r3.<init>(r4, r5)
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r1 = r1.layoutParams(r3)
            if (r1 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            r3 = 1
            r1.canceledOnTouchOutside(r3)
        L_0x0041:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x0046
            goto L_0x0056
        L_0x0046:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0052
            goto L_0x0056
        L_0x0052:
            r3 = 0
            r1.setCyclic(r3)
        L_0x0056:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x005b
            goto L_0x0070
        L_0x005b:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0062
            goto L_0x0070
        L_0x0062:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0067
            goto L_0x0070
        L_0x0067:
            r3 = 1114636288(0x42700000, float:60.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r1.setItemHeight(r3)
        L_0x0070:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x0075
            goto L_0x008a
        L_0x0075:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x007c
            goto L_0x008a
        L_0x007c:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0081
            goto L_0x008a
        L_0x0081:
            r3 = 1106247680(0x41f00000, float:30.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r1.setRoundRadius(r3)
        L_0x008a:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x008f
            goto L_0x00a7
        L_0x008f:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0096
            goto L_0x00a7
        L_0x0096:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_ffaa0a
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColorCenter(r3)
        L_0x00a7:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x00ac
            goto L_0x00c4
        L_0x00ac:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00b3
            goto L_0x00c4
        L_0x00b3:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c4
        L_0x00b8:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColorOut(r3)
        L_0x00c4:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x00c9
            goto L_0x00e1
        L_0x00c9:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00d0
            goto L_0x00e1
        L_0x00d0:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00d5
            goto L_0x00e1
        L_0x00d5:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_14ffaa0a
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setDividerColor(r3)
        L_0x00e1:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x00e6
            goto L_0x00f7
        L_0x00e6:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00ed
            goto L_0x00f7
        L_0x00ed:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00f2
            goto L_0x00f7
        L_0x00f2:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView$DividerType r3 = com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView.DividerType.ROUND_RECT
            r1.setDividerType(r3)
        L_0x00f7:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x00fd
        L_0x00fb:
            r1 = r2
            goto L_0x0106
        L_0x00fd:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0104
            goto L_0x00fb
        L_0x0104:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
        L_0x0106:
            if (r1 != 0) goto L_0x0109
            goto L_0x0113
        L_0x0109:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showDayDialog$1$2 r3 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showDayDialog$1$2
            r3.<init>(r6, r0)
            com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter r3 = (com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter) r3
            r1.setAdapter(r3)
        L_0x0113:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x0118
            goto L_0x012c
        L_0x0118:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x011f
            goto L_0x012c
        L_0x011f:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0124
            goto L_0x012c
        L_0x0124:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda1 r3 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda1
            r3.<init>(r6)
            r1.setOnItemSelectedListener(r3)
        L_0x012c:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x0131
            goto L_0x0145
        L_0x0131:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0138
            goto L_0x0145
        L_0x0138:
            android.widget.ImageView r1 = r1.ivCancel
            if (r1 != 0) goto L_0x013d
            goto L_0x0145
        L_0x013d:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda4 r3 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda4
            r3.<init>(r6)
            r1.setOnClickListener(r3)
        L_0x0145:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mDayDialog
            if (r1 != 0) goto L_0x014a
            goto L_0x015e
        L_0x014a:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0151
            goto L_0x015e
        L_0x0151:
            android.widget.ImageView r1 = r1.ivConfirm
            if (r1 != 0) goto L_0x0156
            goto L_0x015e
        L_0x0156:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda8 r3 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda8
            r3.<init>(r6, r0)
            r1.setOnClickListener(r3)
        L_0x015e:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mDayDialog
            if (r0 != 0) goto L_0x0163
            goto L_0x016c
        L_0x0163:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x016a
            goto L_0x016c
        L_0x016a:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r2 = r0.wheelView
        L_0x016c:
            if (r2 != 0) goto L_0x016f
            goto L_0x0174
        L_0x016f:
            int r0 = r6.mDayPosition
            r2.setCurrentItem(r0)
        L_0x0174:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mDayDialog
            if (r0 != 0) goto L_0x0179
            goto L_0x017c
        L_0x0179:
            r0.show()
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP.showDayDialog():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showDayDialog$lambda-17$lambda-14  reason: not valid java name */
    public static final void m343showDayDialog$lambda17$lambda14(GradeAggregateP gradeAggregateP, int i) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        gradeAggregateP.mDayScrollPosition = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: showDayDialog$lambda-17$lambda-15  reason: not valid java name */
    public static final void m344showDayDialog$lambda17$lambda15(GradeAggregateP gradeAggregateP, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = gradeAggregateP.mDayDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDayDialog$lambda-17$lambda-16  reason: not valid java name */
    public static final void m345showDayDialog$lambda17$lambda16(GradeAggregateP gradeAggregateP, GradeAggregateActivity gradeAggregateActivity, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "$activity");
        int i = gradeAggregateP.mDayScrollPosition;
        gradeAggregateP.mDayPosition = i;
        TextView textView = gradeAggregateP.mTvDay;
        if (textView != null) {
            Integer num = gradeAggregateP.mDayList.get(i);
            Intrinsics.checkNotNullExpressionValue(num, "mDayList[mDayPosition]");
            textView.setText(gradeAggregateActivity.getString(num.intValue()));
        }
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = gradeAggregateP.mDayDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fc, code lost:
        r0 = r0.binding;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showTimeDialog() {
        /*
            r6 = this;
            java.lang.ref.SoftReference<com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity> r0 = r6.context
            if (r0 != 0) goto L_0x0006
            goto L_0x017b
        L_0x0006:
            java.lang.Object r0 = r0.get()
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r0 = (com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity) r0
            if (r0 != 0) goto L_0x0010
            goto L_0x017b
        L_0x0010:
            boolean r1 = r0.isFinishing()
            if (r1 != 0) goto L_0x017b
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            r2 = 0
            if (r1 != 0) goto L_0x015d
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showTimeDialog$1$1 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showTimeDialog$1$1
            r1.<init>(r0)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog r1 = (com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog) r1
            r6.mTimeDialog = r1
            r3 = 80
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r1 = r1.gravity(r3)
            if (r1 != 0) goto L_0x002d
            goto L_0x0041
        L_0x002d:
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = -1
            r5 = -2
            r3.<init>(r4, r5)
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r1 = r1.layoutParams(r3)
            if (r1 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            r3 = 1
            r1.canceledOnTouchOutside(r3)
        L_0x0041:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            if (r1 != 0) goto L_0x0046
            goto L_0x0056
        L_0x0046:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0052
            goto L_0x0056
        L_0x0052:
            r3 = 0
            r1.setCyclic(r3)
        L_0x0056:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            if (r1 != 0) goto L_0x005b
            goto L_0x0070
        L_0x005b:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0062
            goto L_0x0070
        L_0x0062:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0067
            goto L_0x0070
        L_0x0067:
            r3 = 1114636288(0x42700000, float:60.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r1.setItemHeight(r3)
        L_0x0070:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            if (r1 != 0) goto L_0x0075
            goto L_0x008a
        L_0x0075:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x007c
            goto L_0x008a
        L_0x007c:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x0081
            goto L_0x008a
        L_0x0081:
            r3 = 1106247680(0x41f00000, float:30.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r1.setRoundRadius(r3)
        L_0x008a:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            if (r1 != 0) goto L_0x008f
            goto L_0x00a7
        L_0x008f:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x0096
            goto L_0x00a7
        L_0x0096:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_ffaa0a
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColorCenter(r3)
        L_0x00a7:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            if (r1 != 0) goto L_0x00ac
            goto L_0x00c4
        L_0x00ac:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00b3
            goto L_0x00c4
        L_0x00b3:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c4
        L_0x00b8:
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColorOut(r3)
        L_0x00c4:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r1 = r6.mTimeDialog
            if (r1 != 0) goto L_0x00c9
            goto L_0x00e0
        L_0x00c9:
            androidx.viewbinding.ViewBinding r1 = r1.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r1
            if (r1 != 0) goto L_0x00d0
            goto L_0x00e0
        L_0x00d0:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r1 = r1.wheelView
            if (r1 != 0) goto L_0x00d5
            goto L_0x00e0
        L_0x00d5:
            android.content.Context r0 = (android.content.Context) r0
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_14ffaa0a
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r3)
            r1.setDividerColor(r0)
        L_0x00e0:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f6
        L_0x00e5:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x00ec
            goto L_0x00f6
        L_0x00ec:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x00f1
            goto L_0x00f6
        L_0x00f1:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView$DividerType r1 = com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView.DividerType.ROUND_RECT
            r0.setDividerType(r1)
        L_0x00f6:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x00fc
        L_0x00fa:
            r0 = r2
            goto L_0x0105
        L_0x00fc:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0103
            goto L_0x00fa
        L_0x0103:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
        L_0x0105:
            if (r0 != 0) goto L_0x0108
            goto L_0x0112
        L_0x0108:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showTimeDialog$1$2 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$showTimeDialog$1$2
            r1.<init>(r6)
            com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter r1 = (com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter) r1
            r0.setAdapter(r1)
        L_0x0112:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x0117
            goto L_0x012b
        L_0x0117:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x011e
            goto L_0x012b
        L_0x011e:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r0 = r0.wheelView
            if (r0 != 0) goto L_0x0123
            goto L_0x012b
        L_0x0123:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda3 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda3
            r1.<init>(r6)
            r0.setOnItemSelectedListener(r1)
        L_0x012b:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x0130
            goto L_0x0144
        L_0x0130:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0137
            goto L_0x0144
        L_0x0137:
            android.widget.ImageView r0 = r0.ivCancel
            if (r0 != 0) goto L_0x013c
            goto L_0x0144
        L_0x013c:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda0 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda0
            r1.<init>(r6)
            r0.setOnClickListener(r1)
        L_0x0144:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x0149
            goto L_0x015d
        L_0x0149:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0150
            goto L_0x015d
        L_0x0150:
            android.widget.ImageView r0 = r0.ivConfirm
            if (r0 != 0) goto L_0x0155
            goto L_0x015d
        L_0x0155:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda5 r1 = new com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$$ExternalSyntheticLambda5
            r1.<init>(r6)
            r0.setOnClickListener(r1)
        L_0x015d:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x0162
            goto L_0x016b
        L_0x0162:
            androidx.viewbinding.ViewBinding r0 = r0.binding
            com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding) r0
            if (r0 != 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView r2 = r0.wheelView
        L_0x016b:
            if (r2 != 0) goto L_0x016e
            goto L_0x0173
        L_0x016e:
            int r0 = r6.mTimePosition
            r2.setCurrentItem(r0)
        L_0x0173:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding> r0 = r6.mTimeDialog
            if (r0 != 0) goto L_0x0178
            goto L_0x017b
        L_0x0178:
            r0.show()
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP.showTimeDialog():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showTimeDialog$lambda-21$lambda-18  reason: not valid java name */
    public static final void m349showTimeDialog$lambda21$lambda18(GradeAggregateP gradeAggregateP, int i) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        gradeAggregateP.mTimeScrollPosition = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: showTimeDialog$lambda-21$lambda-19  reason: not valid java name */
    public static final void m350showTimeDialog$lambda21$lambda19(GradeAggregateP gradeAggregateP, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = gradeAggregateP.mTimeDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showTimeDialog$lambda-21$lambda-20  reason: not valid java name */
    public static final void m351showTimeDialog$lambda21$lambda20(GradeAggregateP gradeAggregateP, View view) {
        Intrinsics.checkNotNullParameter(gradeAggregateP, "this$0");
        int i = gradeAggregateP.mTimeScrollPosition;
        gradeAggregateP.mTimePosition = i;
        TextView textView = gradeAggregateP.mTvTime;
        if (textView != null) {
            textView.setText(gradeAggregateP.mTimeList.get(i));
        }
        BaseBindDialog<ShopDialogWheelBinding> baseBindDialog = gradeAggregateP.mTimeDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void clearFocus() {
        EditText editText = this.mEditEmail;
        if (editText != null) {
            KeyboardUtil.hideKeyboard(editText);
            editText.clearFocus();
        }
        EditText editText2 = this.mEditName;
        if (editText2 != null) {
            editText2.clearFocus();
        }
    }

    private final void showSubmitToast(boolean z) {
        GradeAggregateActivity gradeAggregateActivity;
        SoftReference<GradeAggregateActivity> softReference = this.context;
        if (softReference != null && (gradeAggregateActivity = softReference.get()) != null) {
            LayoutInflater layoutInflater = gradeAggregateActivity.getLayoutInflater();
            int i = R.layout.layout_custom_toast;
            View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ayout_custom_toast, null)");
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
            if (z) {
                imageView.setImageResource(R.drawable.add_account_success);
                textView.setText(gradeAggregateActivity.getString(R.string.submission_successful));
            } else {
                imageView.setImageResource(R.drawable.add_account_failed);
                textView.setText(gradeAggregateActivity.getString(R.string.submission_failed));
            }
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showCustomShort(inflate);
        }
    }

    public final void onDestroy() {
        this.mViewModel = null;
        this.context = null;
    }
}
