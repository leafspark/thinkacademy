package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tal.app.thinkacademy.business.login.adapter.SelectSchoolAdapter;
import com.tal.app.thinkacademy.business.login.databinding.ActivitySelectSchoolBinding;
import com.tal.app.thinkacademy.business.login.presenter.SelectSchoolViewModel;
import com.tal.app.thinkacademy.business.login.view.item.SchoolItem;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PadAutoCenterScreen
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u000fH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/SelectSchoolActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/SelectSchoolViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivitySelectSchoolBinding;", "()V", "mPath", "", "mSchoolList", "", "Lcom/tal/app/thinkacademy/business/login/view/item/SchoolItem;", "mSelectSchoolAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter;", "schoolCode", "", "addItemToList", "", "list", "schoolName", "schoolUrl", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "initData", "initListener", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectSchoolActivity.kt */
public final class SelectSchoolActivity extends BaseVmActivity<SelectSchoolViewModel, ActivitySelectSchoolBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SelectSchoolActivity";
    /* access modifiers changed from: private */
    public String mPath;
    /* access modifiers changed from: private */
    public List<SchoolItem> mSchoolList = new ArrayList();
    /* access modifiers changed from: private */
    public SelectSchoolAdapter mSelectSchoolAdapter;
    /* access modifiers changed from: private */
    public int schoolCode;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/SelectSchoolActivity$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SelectSchoolActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public ActivitySelectSchoolBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivitySelectSchoolBinding inflate = ActivitySelectSchoolBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SelectSchoolActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        initData();
        initView();
        initListener();
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra("school_selection_path");
        this.mPath = stringExtra;
        CharSequence charSequence = stringExtra;
        int i = 0;
        LeanplumUtil.longTrack$default("school_selection_pv", (String) null, (String) null, (String) null, (String) null, charSequence == null || charSequence.length() == 0 ? "others" : this.mPath, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16350, (Object) null);
        List<SchoolItem> list = this.mSchoolList;
        List schoolList = SchoolConstants.INSTANCE.getSchoolList();
        if (schoolList != null) {
            for (Object next : schoolList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SchoolDataInfo schoolDataInfo = (SchoolDataInfo) next;
                String schoolName = schoolDataInfo.getSchoolName();
                String str = "";
                if (schoolName == null) {
                    schoolName = str;
                }
                String schoolIconUrl = schoolDataInfo.getSchoolIconUrl();
                if (schoolIconUrl == null) {
                    schoolIconUrl = str;
                }
                String schoolCode2 = schoolDataInfo.getSchoolCode();
                if (schoolCode2 != null) {
                    str = schoolCode2;
                }
                addItemToList(list, schoolName, schoolIconUrl, str);
                i = i2;
            }
        }
    }

    private final void addItemToList(List<SchoolItem> list, String str, String str2, String str3) {
        list.add(new SchoolItem(str, str2, str3, false, 8, (DefaultConstructorMarker) null));
    }

    private final void initView() {
        this.mSelectSchoolAdapter = new SelectSchoolAdapter(this.mSchoolList);
        int i = 2;
        if (getResources().getConfiguration().orientation == 2) {
            i = 4;
        }
        getBinding().rvSelectSchool.setLayoutManager(new GridLayoutManager((Context) this, i));
        getBinding().rvSelectSchool.setAdapter(this.mSelectSchoolAdapter);
    }

    private final void initListener() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvNext;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvNext");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new SelectSchoolActivity$initListener$1(this), 1, (Object) null);
        SelectSchoolAdapter selectSchoolAdapter = this.mSelectSchoolAdapter;
        if (selectSchoolAdapter != null) {
            selectSchoolAdapter.setOnItemClickListener(new SelectSchoolActivity$initListener$2(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mSelectSchoolAdapter = null;
        SelectSchoolActivity.super.onDestroy();
    }
}
