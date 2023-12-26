package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundViewDelegate;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.SeletedGradeAdapter;
import com.tal.app.thinkacademy.business.shop.bean.request.AddStudentRequest;
import com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.widget.TextInputFilter;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012<\b\u0002\u0010\b\u001a6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u001a\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/AddStudentDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/BusShopDialogAddStudentBinding;", "context", "Landroid/content/Context;", "gradeList", "", "Lcom/tal/app/thinkacademy/common/user/Grade;", "listener", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/AddStudent;", "Lkotlin/ParameterName;", "name", "addStudent", "Lcom/tal/app/thinkacademy/business/shop/bean/request/AddStudentRequest;", "request", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "easternNameOrderEnabled", "", "isShowGrade", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/SeletedGradeAdapter;", "mGradeId", "", "mMaxDisplayNameLength", "mNameOneKeyListen", "Landroid/text/method/KeyListener;", "mNameTwoKeyListen", "mNickNameKeyListen", "clearFocus", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "getFirstName", "", "getLastName", "setDisplayNameHint", "setEditTextEllipsize", "v", "Landroid/view/View;", "hasFocus", "showGrade", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddStudentDialog.kt */
public final class AddStudentDialog extends BaseBindDialog<BusShopDialogAddStudentBinding> {
    /* access modifiers changed from: private */
    public boolean easternNameOrderEnabled;
    private boolean isShowGrade;
    private SeletedGradeAdapter mAdapter;
    /* access modifiers changed from: private */
    public int mGradeId;
    /* access modifiers changed from: private */
    public final int mMaxDisplayNameLength;
    private KeyListener mNameOneKeyListen;
    private KeyListener mNameTwoKeyListen;
    private KeyListener mNickNameKeyListen;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddStudentDialog(Context context, List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i & 4) != 0 ? null : function2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddStudentDialog(Context context, List<Grade> list, final Function2<? super AddStudent, ? super AddStudentRequest, Unit> function2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "gradeList");
        this.mGradeId = -1;
        this.mMaxDisplayNameLength = 65;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        canceledOnTouchOutside(false);
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setSoftInputMode(48);
        }
        SchoolDataInfo currentSchoolInfo = SchoolConstants.INSTANCE.getCurrentSchoolInfo();
        this.easternNameOrderEnabled = currentSchoolInfo == null ? false : currentSchoolInfo.getEasternNameOrderEnabled();
        this.binding.etDisplayName.setFilters(new TextInputFilter[]{new TextInputFilter()});
        this.binding.etNameOne.setFilters(new TextInputFilter[]{new TextInputFilter()});
        this.binding.etNameTwo.setFilters(new TextInputFilter[]{new TextInputFilter()});
        this.mNickNameKeyListen = this.binding.etDisplayName.getKeyListener();
        this.mNameOneKeyListen = this.binding.etNameOne.getKeyListener();
        this.mNameTwoKeyListen = this.binding.etNameTwo.getKeyListener();
        if (!this.binding.etDisplayName.hasFocus()) {
            this.binding.etDisplayName.setKeyListener((KeyListener) null);
            this.binding.etDisplayName.setText(this.binding.etDisplayName.getText());
        }
        if (!this.binding.etNameOne.hasFocus()) {
            this.binding.etNameOne.setKeyListener((KeyListener) null);
            this.binding.etNameOne.setText(this.binding.etNameOne.getText());
        }
        if (!this.binding.etNameTwo.hasFocus()) {
            this.binding.etNameTwo.setKeyListener((KeyListener) null);
            this.binding.etNameTwo.setText(this.binding.etNameTwo.getText());
        }
        this.binding.etNameOne.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AddStudentDialog this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                if (StringsKt.isBlank(this.this$0.binding.etDisplayName.getText().toString())) {
                    this.this$0.setDisplayNameHint();
                }
            }
        });
        this.binding.etNameTwo.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AddStudentDialog this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                if (StringsKt.isBlank(this.this$0.binding.etDisplayName.getText().toString())) {
                    this.this$0.setDisplayNameHint();
                }
            }
        });
        this.binding.etDisplayName.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AddStudentDialog this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                boolean z = false;
                if (editable != null && editable.length() == 0) {
                    z = true;
                }
                if (z) {
                    this.this$0.setDisplayNameHint();
                }
            }
        });
        if (this.easternNameOrderEnabled) {
            TextView textView = this.binding.tvNameOne;
            if (textView != null) {
                textView.setText(context.getString(R.string.last_name));
            }
            EditText editText = this.binding.etNameOne;
            if (editText != null) {
                editText.setHint(context.getString(R.string.enter_last_name));
            }
            TextView textView2 = this.binding.tvNameTwo;
            if (textView2 != null) {
                textView2.setText(context.getString(R.string.first_name));
            }
            EditText editText2 = this.binding.etNameTwo;
            if (editText2 != null) {
                editText2.setHint(context.getString(R.string.enter_first_name));
            }
        } else {
            TextView textView3 = this.binding.tvNameOne;
            if (textView3 != null) {
                textView3.setText(context.getString(R.string.first_name));
            }
            EditText editText3 = this.binding.etNameOne;
            if (editText3 != null) {
                editText3.setHint(context.getString(R.string.enter_first_name));
            }
            TextView textView4 = this.binding.tvNameTwo;
            if (textView4 != null) {
                textView4.setText(context.getString(R.string.last_name));
            }
            EditText editText4 = this.binding.etNameTwo;
            if (editText4 != null) {
                editText4.setHint(context.getString(R.string.enter_last_name));
            }
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 3;
        RecyclerView recyclerView = this.binding.recyclerView;
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(context, intRef.element);
        gridLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(gridLayoutManager);
        int dp2px = SizeUtils.dp2px(16.0f) * 2;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = ((context.getResources().getDisplayMetrics().widthPixels - dp2px) - dp2px) / intRef.element;
        final Ref.IntRef intRef3 = new Ref.IntRef();
        intRef3.element = intRef2.element - SizeUtils.dp2px(101.0f);
        final Ref.IntRef intRef4 = new Ref.IntRef();
        intRef4.element = (intRef3.element * 3) / (intRef.element - 1);
        final List<Grade> list2 = list;
        this.binding.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(rect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(recyclerView, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                AddStudentDialog.super.getItemOffsets(rect, view, recyclerView, state);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
                if (childLayoutPosition == 0 || childLayoutPosition == 1 || childLayoutPosition == 2) {
                    rect.top = SizeUtils.dp2px(16.0f);
                }
                if (childLayoutPosition == list2.size() - 1 || childLayoutPosition == list2.size() - 2 || childLayoutPosition == list2.size() - 3) {
                    rect.bottom = SizeUtils.dp2px(6.0f);
                }
                int i = childLayoutPosition % intRef.element;
                if (i == 0) {
                    rect.left = 0;
                    rect.right = intRef3.element;
                } else if (i == 1) {
                    rect.left = intRef4.element - intRef3.element;
                    rect.right = intRef2.element - (intRef4.element - intRef3.element);
                } else if (i == 2) {
                    rect.left = intRef3.element;
                    rect.right = 0;
                }
            }
        });
        this.mAdapter = new SeletedGradeAdapter(list, -1);
        this.binding.recyclerView.setAdapter(this.mAdapter);
        SeletedGradeAdapter seletedGradeAdapter = this.mAdapter;
        if (seletedGradeAdapter != null) {
            seletedGradeAdapter.setOnItemClickListener(new AddStudentDialog$$ExternalSyntheticLambda3(this));
        }
        this.binding.etDisplayName.setOnFocusChangeListener(new AddStudentDialog$$ExternalSyntheticLambda2(this));
        this.binding.etNameOne.setOnFocusChangeListener(new AddStudentDialog$$ExternalSyntheticLambda1(this));
        this.binding.etNameTwo.setOnFocusChangeListener(new AddStudentDialog$$ExternalSyntheticLambda0(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = this.binding.ivClose;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivClose");
        rxUnDoubleUtil.setOnUnDoubleClickListener(imageView, 300, new Function0<Unit>(this) {
            final /* synthetic */ AddStudentDialog this$0;

            {
                this.this$0 = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
                r0 = r0.getText();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke() {
                /*
                    r5 = this;
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r0 = r5.this$0
                    r0.clearFocus()
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r0 = r5.this$0
                    androidx.viewbinding.ViewBinding r0 = r0.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r0
                    android.widget.EditText r0 = r0.etNameOne
                    r1 = 0
                    if (r0 != 0) goto L_0x0012
                L_0x0010:
                    r0 = r1
                    goto L_0x001d
                L_0x0012:
                    android.text.Editable r0 = r0.getText()
                    if (r0 != 0) goto L_0x0019
                    goto L_0x0010
                L_0x0019:
                    java.lang.String r0 = r0.toString()
                L_0x001d:
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x002c
                    boolean r0 = kotlin.text.StringsKt.isBlank(r0)
                    if (r0 == 0) goto L_0x002a
                    goto L_0x002c
                L_0x002a:
                    r0 = r2
                    goto L_0x002d
                L_0x002c:
                    r0 = r3
                L_0x002d:
                    r0 = r0 ^ r3
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r4 = r5.this$0
                    androidx.viewbinding.ViewBinding r4 = r4.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r4 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r4
                    android.widget.EditText r4 = r4.etNameTwo
                    if (r4 != 0) goto L_0x003a
                L_0x0038:
                    r4 = r1
                    goto L_0x0045
                L_0x003a:
                    android.text.Editable r4 = r4.getText()
                    if (r4 != 0) goto L_0x0041
                    goto L_0x0038
                L_0x0041:
                    java.lang.String r4 = r4.toString()
                L_0x0045:
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    if (r4 == 0) goto L_0x0052
                    boolean r4 = kotlin.text.StringsKt.isBlank(r4)
                    if (r4 == 0) goto L_0x0050
                    goto L_0x0052
                L_0x0050:
                    r4 = r2
                    goto L_0x0053
                L_0x0052:
                    r4 = r3
                L_0x0053:
                    if (r4 != 0) goto L_0x0056
                    r0 = r3
                L_0x0056:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r4 = r5.this$0
                    androidx.viewbinding.ViewBinding r4 = r4.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r4 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r4
                    android.widget.TextView r4 = r4.tvGrade
                    if (r4 != 0) goto L_0x0062
                L_0x0060:
                    r4 = r1
                    goto L_0x006d
                L_0x0062:
                    java.lang.CharSequence r4 = r4.getText()
                    if (r4 != 0) goto L_0x0069
                    goto L_0x0060
                L_0x0069:
                    java.lang.String r4 = r4.toString()
                L_0x006d:
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    if (r4 == 0) goto L_0x0077
                    boolean r4 = kotlin.text.StringsKt.isBlank(r4)
                    if (r4 == 0) goto L_0x0078
                L_0x0077:
                    r2 = r3
                L_0x0078:
                    if (r2 != 0) goto L_0x007b
                    goto L_0x007c
                L_0x007b:
                    r3 = r0
                L_0x007c:
                    if (r3 == 0) goto L_0x0089
                    kotlin.jvm.functions.Function2<com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudent, com.tal.app.thinkacademy.business.shop.bean.request.AddStudentRequest, kotlin.Unit> r0 = r14
                    if (r0 != 0) goto L_0x0083
                    goto L_0x008e
                L_0x0083:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudent r2 = com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudent.CLOSE
                    r0.invoke(r2, r1)
                    goto L_0x008e
                L_0x0089:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r0 = r5.this$0
                    r0.dismiss()
                L_0x008e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog.AnonymousClass11.invoke():void");
            }
        });
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        View view = this.binding.rlGrade;
        Intrinsics.checkNotNullExpressionValue(view, "binding.rlGrade");
        rxUnDoubleUtil2.setOnUnDoubleClickListener(view, 300, new Function0<Unit>(this) {
            final /* synthetic */ AddStudentDialog this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.clearFocus();
                this.this$0.showGrade();
            }
        });
        RxUnDoubleUtil rxUnDoubleUtil3 = RxUnDoubleUtil.INSTANCE;
        View view2 = this.binding.tvSave;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.tvSave");
        rxUnDoubleUtil3.setOnUnDoubleClickListener(view2, 300, new Function0<Unit>(this) {
            final /* synthetic */ AddStudentDialog this$0;

            {
                this.this$0 = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
                r0 = r0.getText();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x00df, code lost:
                if ((r7 == null || kotlin.text.StringsKt.isBlank(r7)) == false) goto L_0x00e1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke() {
                /*
                    r11 = this;
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r0 = r11.this$0
                    r0.clearFocus()
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r0 = r11.this$0
                    androidx.viewbinding.ViewBinding r0 = r0.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r0
                    android.widget.EditText r0 = r0.etNameOne
                    r1 = 0
                    if (r0 != 0) goto L_0x0012
                L_0x0010:
                    r0 = r1
                    goto L_0x001d
                L_0x0012:
                    android.text.Editable r0 = r0.getText()
                    if (r0 != 0) goto L_0x0019
                    goto L_0x0010
                L_0x0019:
                    java.lang.String r0 = r0.toString()
                L_0x001d:
                    r2 = r0
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    r3 = 1
                    r4 = 0
                    if (r2 == 0) goto L_0x002d
                    boolean r5 = kotlin.text.StringsKt.isBlank(r2)
                    if (r5 == 0) goto L_0x002b
                    goto L_0x002d
                L_0x002b:
                    r5 = r4
                    goto L_0x002e
                L_0x002d:
                    r5 = r3
                L_0x002e:
                    if (r5 == 0) goto L_0x0042
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r5 = r11.this$0
                    androidx.viewbinding.ViewBinding r5 = r5.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r5 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r5
                    android.widget.ImageView r5 = r5.ivNameOne
                    if (r5 != 0) goto L_0x003b
                    goto L_0x0040
                L_0x003b:
                    int r6 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_warning_edit
                    r5.setImageResource(r6)
                L_0x0040:
                    r5 = r4
                    goto L_0x0053
                L_0x0042:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r5 = r11.this$0
                    androidx.viewbinding.ViewBinding r5 = r5.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r5 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r5
                    android.widget.ImageView r5 = r5.ivNameOne
                    if (r5 != 0) goto L_0x004d
                    goto L_0x0052
                L_0x004d:
                    int r6 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_edit
                    r5.setImageResource(r6)
                L_0x0052:
                    r5 = r3
                L_0x0053:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r6 = r11.this$0
                    androidx.viewbinding.ViewBinding r6 = r6.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r6 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r6
                    android.widget.EditText r6 = r6.etNameTwo
                    if (r6 != 0) goto L_0x005f
                L_0x005d:
                    r6 = r1
                    goto L_0x006a
                L_0x005f:
                    android.text.Editable r6 = r6.getText()
                    if (r6 != 0) goto L_0x0066
                    goto L_0x005d
                L_0x0066:
                    java.lang.String r6 = r6.toString()
                L_0x006a:
                    r7 = r6
                    java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                    if (r7 == 0) goto L_0x0078
                    boolean r8 = kotlin.text.StringsKt.isBlank(r7)
                    if (r8 == 0) goto L_0x0076
                    goto L_0x0078
                L_0x0076:
                    r8 = r4
                    goto L_0x0079
                L_0x0078:
                    r8 = r3
                L_0x0079:
                    if (r8 == 0) goto L_0x008d
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r5 = r11.this$0
                    androidx.viewbinding.ViewBinding r5 = r5.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r5 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r5
                    android.widget.ImageView r5 = r5.ivNameTwo
                    if (r5 != 0) goto L_0x0086
                    goto L_0x008b
                L_0x0086:
                    int r8 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_warning_edit
                    r5.setImageResource(r8)
                L_0x008b:
                    r5 = r4
                    goto L_0x009d
                L_0x008d:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r8 = r11.this$0
                    androidx.viewbinding.ViewBinding r8 = r8.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r8 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r8
                    android.widget.ImageView r8 = r8.ivNameTwo
                    if (r8 != 0) goto L_0x0098
                    goto L_0x009d
                L_0x0098:
                    int r9 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_edit
                    r8.setImageResource(r9)
                L_0x009d:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r8 = r11.this$0
                    androidx.viewbinding.ViewBinding r8 = r8.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r8 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r8
                    android.widget.EditText r8 = r8.etDisplayName
                    if (r8 != 0) goto L_0x00a9
                L_0x00a7:
                    r8 = r1
                    goto L_0x00b4
                L_0x00a9:
                    android.text.Editable r8 = r8.getText()
                    if (r8 != 0) goto L_0x00b0
                    goto L_0x00a7
                L_0x00b0:
                    java.lang.String r8 = r8.toString()
                L_0x00b4:
                    r9 = r8
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    if (r9 == 0) goto L_0x00c2
                    boolean r10 = kotlin.text.StringsKt.isBlank(r9)
                    if (r10 == 0) goto L_0x00c0
                    goto L_0x00c2
                L_0x00c0:
                    r10 = r4
                    goto L_0x00c3
                L_0x00c2:
                    r10 = r3
                L_0x00c3:
                    if (r10 == 0) goto L_0x014e
                    if (r2 == 0) goto L_0x00d0
                    boolean r2 = kotlin.text.StringsKt.isBlank(r2)
                    if (r2 == 0) goto L_0x00ce
                    goto L_0x00d0
                L_0x00ce:
                    r2 = r4
                    goto L_0x00d1
                L_0x00d0:
                    r2 = r3
                L_0x00d1:
                    if (r2 == 0) goto L_0x00e1
                    if (r7 == 0) goto L_0x00de
                    boolean r2 = kotlin.text.StringsKt.isBlank(r7)
                    if (r2 == 0) goto L_0x00dc
                    goto L_0x00de
                L_0x00dc:
                    r2 = r4
                    goto L_0x00df
                L_0x00de:
                    r2 = r3
                L_0x00df:
                    if (r2 != 0) goto L_0x00ef
                L_0x00e1:
                    if (r9 == 0) goto L_0x00ec
                    int r2 = r9.length()
                    if (r2 != 0) goto L_0x00ea
                    goto L_0x00ec
                L_0x00ea:
                    r2 = r4
                    goto L_0x00ed
                L_0x00ec:
                    r2 = r3
                L_0x00ed:
                    if (r2 != 0) goto L_0x0101
                L_0x00ef:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r2 = r11.this$0
                    androidx.viewbinding.ViewBinding r2 = r2.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r2
                    android.widget.ImageView r2 = r2.ivDisplayName
                    if (r2 != 0) goto L_0x00fa
                    goto L_0x00ff
                L_0x00fa:
                    int r5 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_warning_edit
                    r2.setImageResource(r5)
                L_0x00ff:
                    r5 = r4
                    goto L_0x015e
                L_0x0101:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r2 = r11.this$0
                    java.lang.String r2 = r2.getFirstName()
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r7 = r11.this$0
                    java.lang.String r7 = r7.getLastName()
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>()
                    r8.append(r2)
                    r2 = 32
                    r8.append(r2)
                    r8.append(r7)
                    java.lang.String r2 = r8.toString()
                    int r7 = r2.length()
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r8 = r11.this$0
                    int r8 = r8.mMaxDisplayNameLength
                    if (r7 <= r8) goto L_0x013c
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r7 = r11.this$0
                    int r7 = r7.mMaxDisplayNameLength
                    java.lang.String r2 = r2.substring(r4, r7)
                    java.lang.String r7 = "this as java.lang.String…ing(startIndex, endIndex)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
                L_0x013c:
                    r8 = r2
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r2 = r11.this$0
                    androidx.viewbinding.ViewBinding r2 = r2.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r2
                    android.widget.ImageView r2 = r2.ivDisplayName
                    if (r2 != 0) goto L_0x0148
                    goto L_0x015e
                L_0x0148:
                    int r7 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_edit
                    r2.setImageResource(r7)
                    goto L_0x015e
                L_0x014e:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r2 = r11.this$0
                    androidx.viewbinding.ViewBinding r2 = r2.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r2
                    android.widget.ImageView r2 = r2.ivDisplayName
                    if (r2 != 0) goto L_0x0159
                    goto L_0x015e
                L_0x0159:
                    int r7 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_edit
                    r2.setImageResource(r7)
                L_0x015e:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r2 = r11.this$0
                    androidx.viewbinding.ViewBinding r2 = r2.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r2
                    android.widget.TextView r2 = r2.tvGrade
                    if (r2 != 0) goto L_0x0169
                    goto L_0x0174
                L_0x0169:
                    java.lang.CharSequence r2 = r2.getText()
                    if (r2 != 0) goto L_0x0170
                    goto L_0x0174
                L_0x0170:
                    java.lang.String r1 = r2.toString()
                L_0x0174:
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    if (r1 == 0) goto L_0x0180
                    boolean r1 = kotlin.text.StringsKt.isBlank(r1)
                    if (r1 == 0) goto L_0x017f
                    goto L_0x0180
                L_0x017f:
                    r3 = r4
                L_0x0180:
                    if (r3 == 0) goto L_0x0193
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r1 = r11.this$0
                    androidx.viewbinding.ViewBinding r1 = r1.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r1
                    android.widget.ImageView r1 = r1.ivGrade
                    if (r1 != 0) goto L_0x018d
                    goto L_0x01a4
                L_0x018d:
                    int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_warning_edit
                    r1.setImageResource(r2)
                    goto L_0x01a4
                L_0x0193:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r1 = r11.this$0
                    androidx.viewbinding.ViewBinding r1 = r1.binding
                    com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogAddStudentBinding) r1
                    android.widget.ImageView r1 = r1.ivGrade
                    if (r1 != 0) goto L_0x019e
                    goto L_0x01a3
                L_0x019e:
                    int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_dialog_perfect_infor_icon_unfold_light
                    r1.setImageResource(r2)
                L_0x01a3:
                    r4 = r5
                L_0x01a4:
                    if (r4 == 0) goto L_0x01df
                    kotlin.jvm.functions.Function2<com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudent, com.tal.app.thinkacademy.business.shop.bean.request.AddStudentRequest, kotlin.Unit> r1 = r14
                    if (r1 != 0) goto L_0x01ab
                    goto L_0x01df
                L_0x01ab:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudent r2 = com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudent.ADDSTUDENT
                    com.tal.app.thinkacademy.business.shop.bean.request.AddStudentRequest r3 = new com.tal.app.thinkacademy.business.shop.bean.request.AddStudentRequest
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r4 = r11.this$0
                    boolean r4 = r4.easternNameOrderEnabled
                    if (r4 == 0) goto L_0x01bf
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                    r4 = r6
                    goto L_0x01c3
                L_0x01bf:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    r4 = r0
                L_0x01c3:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r5 = r11.this$0
                    boolean r5 = r5.easternNameOrderEnabled
                    if (r5 == 0) goto L_0x01cf
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    goto L_0x01d3
                L_0x01cf:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                    r0 = r6
                L_0x01d3:
                    com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog r5 = r11.this$0
                    int r5 = r5.mGradeId
                    r3.<init>(r8, r4, r0, r5)
                    r1.invoke(r2, r3)
                L_0x01df:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog.AnonymousClass13.invoke():void");
            }
        });
    }

    /* access modifiers changed from: protected */
    public BusShopDialogAddStudentBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BusShopDialogAddStudentBinding inflate = BusShopDialogAddStudentBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m261_init_$lambda2(AddStudentDialog addStudentDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(addStudentDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        SeletedGradeAdapter seletedGradeAdapter = addStudentDialog.mAdapter;
        String str = null;
        Grade grade = seletedGradeAdapter == null ? null : (Grade) seletedGradeAdapter.getItem(i);
        TextView textView = addStudentDialog.binding.tvGrade;
        if (textView != null) {
            if (grade != null) {
                str = grade.getName();
            }
            textView.setText(str);
        }
        if (grade == null) {
            i2 = -1;
        } else {
            i2 = grade.getValue();
        }
        addStudentDialog.mGradeId = i2;
        SeletedGradeAdapter seletedGradeAdapter2 = addStudentDialog.mAdapter;
        if (seletedGradeAdapter2 != null) {
            seletedGradeAdapter2.updatePosition(i);
        }
        SeletedGradeAdapter seletedGradeAdapter3 = addStudentDialog.mAdapter;
        if (seletedGradeAdapter3 != null) {
            seletedGradeAdapter3.notifyDataSetChanged();
        }
        addStudentDialog.clearFocus();
        addStudentDialog.isShowGrade = true;
        addStudentDialog.showGrade();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m262_init_$lambda3(AddStudentDialog addStudentDialog, View view, boolean z) {
        Intrinsics.checkNotNullParameter(addStudentDialog, "this$0");
        if (view.getId() == R.id.etDisplayName) {
            if (z) {
                addStudentDialog.isShowGrade = true;
                addStudentDialog.showGrade();
                addStudentDialog.binding.ivDisplayName.setVisibility(8);
            } else {
                addStudentDialog.binding.ivDisplayName.setVisibility(0);
                addStudentDialog.binding.ivDisplayName.setImageResource(R.drawable.bus_shop_dialog_perfect_infor_icon_edit);
            }
            addStudentDialog.setEditTextEllipsize(view, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final void m263_init_$lambda4(AddStudentDialog addStudentDialog, View view, boolean z) {
        Intrinsics.checkNotNullParameter(addStudentDialog, "this$0");
        if (view.getId() == R.id.etNameOne) {
            if (z) {
                addStudentDialog.isShowGrade = true;
                addStudentDialog.showGrade();
                addStudentDialog.binding.ivNameOne.setVisibility(8);
            } else {
                addStudentDialog.binding.ivNameOne.setVisibility(0);
                addStudentDialog.binding.ivNameOne.setImageResource(R.drawable.bus_shop_dialog_perfect_infor_icon_edit);
            }
            addStudentDialog.setEditTextEllipsize(view, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final void m264_init_$lambda5(AddStudentDialog addStudentDialog, View view, boolean z) {
        Intrinsics.checkNotNullParameter(addStudentDialog, "this$0");
        if (view.getId() == R.id.etNameTwo) {
            if (z) {
                addStudentDialog.isShowGrade = true;
                addStudentDialog.showGrade();
                ImageView imageView = addStudentDialog.binding.ivNameTwo;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else {
                ImageView imageView2 = addStudentDialog.binding.ivNameTwo;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                ImageView imageView3 = addStudentDialog.binding.ivNameTwo;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.bus_shop_dialog_perfect_infor_icon_edit);
                }
            }
            addStudentDialog.setEditTextEllipsize(view, z);
        }
    }

    /* access modifiers changed from: private */
    public final void showGrade() {
        boolean z = !this.isShowGrade;
        this.isShowGrade = z;
        RoundViewDelegate roundViewDelegate = null;
        if (z) {
            RoundLinearLayout roundLinearLayout = this.binding.recyclerViewBg;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(0);
            }
            RoundLinearLayout roundLinearLayout2 = this.binding.rlEditBg;
            RoundViewDelegate delegate = roundLinearLayout2 == null ? null : roundLinearLayout2.getDelegate();
            if (delegate != null) {
                delegate.setCornerRadius_BL(0);
            }
            RoundLinearLayout roundLinearLayout3 = this.binding.rlEditBg;
            if (roundLinearLayout3 != null) {
                roundViewDelegate = roundLinearLayout3.getDelegate();
            }
            if (roundViewDelegate != null) {
                roundViewDelegate.setCornerRadius_BR(0);
            }
            ImageView imageView = this.binding.ivGrade;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.bus_shop_dialog_perfect_infor_icon_fold);
                return;
            }
            return;
        }
        RoundLinearLayout roundLinearLayout4 = this.binding.recyclerViewBg;
        if (roundLinearLayout4 != null) {
            roundLinearLayout4.setVisibility(8);
        }
        RoundLinearLayout roundLinearLayout5 = this.binding.rlEditBg;
        RoundViewDelegate delegate2 = roundLinearLayout5 == null ? null : roundLinearLayout5.getDelegate();
        if (delegate2 != null) {
            delegate2.setCornerRadius_BL(SizeUtils.dp2px(8.0f));
        }
        RoundLinearLayout roundLinearLayout6 = this.binding.rlEditBg;
        if (roundLinearLayout6 != null) {
            roundViewDelegate = roundLinearLayout6.getDelegate();
        }
        if (roundViewDelegate != null) {
            roundViewDelegate.setCornerRadius_BR(SizeUtils.dp2px(8.0f));
        }
        ImageView imageView2 = this.binding.ivGrade;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.bus_shop_dialog_perfect_infor_icon_unfold_light);
        }
    }

    /* access modifiers changed from: private */
    public final void clearFocus() {
        KeyboardUtil.hideKeyboard(this.binding.etNameOne);
        this.binding.etDisplayName.clearFocus();
        this.binding.etNameOne.clearFocus();
        this.binding.etNameTwo.clearFocus();
    }

    /* access modifiers changed from: private */
    public final void setDisplayNameHint() {
        String firstName = getFirstName();
        String lastName = getLastName();
        boolean z = true;
        if (firstName.length() == 0) {
            if (lastName.length() != 0) {
                z = false;
            }
            if (z) {
                this.binding.etDisplayName.setHint(getContext().getString(R.string.enter_display_name));
                return;
            }
        }
        this.binding.etDisplayName.setHint(firstName + ' ' + lastName);
    }

    /* access modifiers changed from: private */
    public final String getFirstName() {
        return this.binding.etNameOne.getText().toString();
    }

    /* access modifiers changed from: private */
    public final String getLastName() {
        return this.binding.etNameTwo.getText().toString();
    }

    private final void setEditTextEllipsize(View view, boolean z) {
        if (z) {
            if (Intrinsics.areEqual((Object) view, (Object) this.binding.etDisplayName)) {
                this.binding.etDisplayName.setKeyListener(this.mNickNameKeyListen);
                this.binding.etDisplayName.setText(this.binding.etDisplayName.getText());
            } else if (Intrinsics.areEqual((Object) view, (Object) this.binding.etNameOne)) {
                this.binding.etNameOne.setKeyListener(this.mNameOneKeyListen);
                this.binding.etNameOne.setText(this.binding.etNameOne.getText());
            } else if (Intrinsics.areEqual((Object) view, (Object) this.binding.etNameTwo)) {
                this.binding.etNameTwo.setKeyListener(this.mNameTwoKeyListen);
                this.binding.etNameTwo.setText(this.binding.etNameTwo.getText());
            }
        } else if (Intrinsics.areEqual((Object) view, (Object) this.binding.etDisplayName)) {
            this.binding.etDisplayName.setKeyListener((KeyListener) null);
            this.binding.etDisplayName.setText(this.binding.etDisplayName.getText());
        } else if (Intrinsics.areEqual((Object) view, (Object) this.binding.etNameOne)) {
            this.binding.etNameOne.setKeyListener((KeyListener) null);
            this.binding.etNameOne.setText(this.binding.etNameOne.getText());
        } else if (Intrinsics.areEqual((Object) view, (Object) this.binding.etNameTwo)) {
            this.binding.etNameTwo.setKeyListener((KeyListener) null);
            this.binding.etNameTwo.setText(this.binding.etNameTwo.getText());
        }
    }
}
