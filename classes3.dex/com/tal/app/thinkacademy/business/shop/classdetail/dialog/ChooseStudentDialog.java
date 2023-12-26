package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.entity.AccountListEntity;
import com.tal.app.thinkacademy.business.login.entity.UserAccount;
import com.tal.app.thinkacademy.business.shop.adapter.ChooseSudentAdapter;
import com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogChooseStudentBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bn\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012S\b\u0002\u0010\u0007\u001aM\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ChooseStudentDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/BusShopDialogChooseStudentBinding;", "context", "Landroid/content/Context;", "accountListEntity", "Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "listener", "Lkotlin/Function3;", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ChooseStudent;", "Lkotlin/ParameterName;", "name", "chooose", "", "isSwitch", "", "uid", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;Lkotlin/jvm/functions/Function3;)V", "lastUid", "mChooseSudentAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/ChooseSudentAdapter;", "mUid", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseStudentDialog.kt */
public final class ChooseStudentDialog extends BaseBindDialog<BusShopDialogChooseStudentBinding> {
    /* access modifiers changed from: private */
    public String lastUid;
    private ChooseSudentAdapter mChooseSudentAdapter;
    /* access modifiers changed from: private */
    public String mUid;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChooseStudentDialog(Context context, AccountListEntity accountListEntity, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, accountListEntity, (i & 4) != 0 ? null : function3);
    }

    public ChooseStudentDialog(Context context, AccountListEntity accountListEntity, final Function3<? super ChooseStudent, ? super Boolean, ? super String, Unit> function3) {
        super(context);
        List<UserAccount> associatedAccount;
        UserAccount currentAccount;
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
        List arrayList = new ArrayList();
        if (!(accountListEntity == null || (currentAccount = accountListEntity.getCurrentAccount()) == null)) {
            arrayList.add(currentAccount);
        }
        if (!(accountListEntity == null || (associatedAccount = accountListEntity.getAssociatedAccount()) == null)) {
            Collection collection = associatedAccount;
            if (!collection.isEmpty()) {
                arrayList.addAll(collection);
            }
        }
        int size = arrayList.size();
        if (size >= 0 && size < 4) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, SizeUtils.dp2px(404.0f));
            layoutParams.addRule(12);
            RoundRelativeLayout roundRelativeLayout = this.binding.rvBg;
            if (roundRelativeLayout != null) {
                roundRelativeLayout.setLayoutParams(layoutParams);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, SizeUtils.dp2px(613.0f));
            layoutParams2.addRule(12);
            RoundRelativeLayout roundRelativeLayout2 = this.binding.rvBg;
            if (roundRelativeLayout2 != null) {
                roundRelativeLayout2.setLayoutParams(layoutParams2);
            }
        }
        if (arrayList.size() == 6) {
            RoundTextView roundTextView = this.binding.tvAddStudent;
            if (roundTextView != null) {
                roundTextView.setVisibility(8);
            }
            RoundTextView roundTextView2 = this.binding.tvContinue;
            if (roundTextView2 != null) {
                roundTextView2.setVisibility(8);
            }
            RoundTextView roundTextView3 = this.binding.tvMatchContinue;
            if (roundTextView3 != null) {
                roundTextView3.setVisibility(0);
            }
        } else {
            RoundTextView roundTextView4 = this.binding.tvAddStudent;
            if (roundTextView4 != null) {
                roundTextView4.setVisibility(0);
            }
            RoundTextView roundTextView5 = this.binding.tvContinue;
            if (roundTextView5 != null) {
                roundTextView5.setVisibility(0);
            }
            RoundTextView roundTextView6 = this.binding.tvMatchContinue;
            if (roundTextView6 != null) {
                roundTextView6.setVisibility(8);
            }
        }
        RecyclerView recyclerView = this.binding.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        ((UserAccount) arrayList.get(0)).setSeleted(true);
        String uid = ((UserAccount) arrayList.get(0)).getUid();
        uid = uid == null ? "" : uid;
        this.lastUid = uid;
        this.mUid = uid;
        this.mChooseSudentAdapter = new ChooseSudentAdapter(arrayList);
        RecyclerView recyclerView2 = this.binding.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mChooseSudentAdapter);
        }
        ChooseSudentAdapter chooseSudentAdapter = this.mChooseSudentAdapter;
        if (chooseSudentAdapter != null) {
            chooseSudentAdapter.setOnItemClickListener(new ChooseStudentDialog$$ExternalSyntheticLambda0(arrayList, this));
        }
        ImageView imageView = this.binding.ivClose;
        if (imageView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView, 300, new Function0<Unit>(this) {
                final /* synthetic */ ChooseStudentDialog this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.dismiss();
                }
            });
        }
        View view = this.binding.tvAddStudent;
        if (view != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view, 300, new Function0<Unit>(this) {
                final /* synthetic */ ChooseStudentDialog this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.dismiss();
                    Function3<ChooseStudent, Boolean, String, Unit> function3 = function3;
                    if (function3 != null) {
                        function3.invoke(ChooseStudent.ADDSTUDENT, null, null);
                    }
                }
            });
        }
        View view2 = this.binding.tvContinue;
        if (view2 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view2, 300, new Function0<Unit>(this) {
                final /* synthetic */ ChooseStudentDialog this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.dismiss();
                    Function3<ChooseStudent, Boolean, String, Unit> function3 = function3;
                    if (function3 != null) {
                        function3.invoke(ChooseStudent.CONTINUE, Boolean.valueOf(!Intrinsics.areEqual((Object) this.this$0.mUid, (Object) this.this$0.lastUid)), this.this$0.mUid);
                    }
                }
            });
        }
        View view3 = this.binding.tvMatchContinue;
        if (view3 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view3, 300, new Function0<Unit>(this) {
                final /* synthetic */ ChooseStudentDialog this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.dismiss();
                    Function3<ChooseStudent, Boolean, String, Unit> function3 = function3;
                    if (function3 != null) {
                        function3.invoke(ChooseStudent.CONTINUE, Boolean.valueOf(!Intrinsics.areEqual((Object) this.this$0.mUid, (Object) this.this$0.lastUid)), this.this$0.mUid);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-6  reason: not valid java name */
    public static final void m279_init_$lambda6(List list, ChooseStudentDialog chooseStudentDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(list, "$accountList");
        Intrinsics.checkNotNullParameter(chooseStudentDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((UserAccount) it.next()).setSeleted(false);
        }
        ((UserAccount) list.get(i)).setSeleted(true);
        String uid = ((UserAccount) list.get(i)).getUid();
        if (uid == null) {
            uid = "";
        }
        chooseStudentDialog.mUid = uid;
        ChooseSudentAdapter chooseSudentAdapter = chooseStudentDialog.mChooseSudentAdapter;
        if (chooseSudentAdapter != null) {
            chooseSudentAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public BusShopDialogChooseStudentBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BusShopDialogChooseStudentBinding inflate = BusShopDialogChooseStudentBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
