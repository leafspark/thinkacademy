package com.tal.app.thinkacademy.business.shop.widget.dialog;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.ShopConstantsKt;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassFilterData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.lib.commui.adapter.ListDriver;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\nJ&\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassFilterPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "()V", "mDayAdapter", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassTabListDayAdapter;", "mDefTitleArray", "", "", "[Ljava/lang/String;", "mTabItemClickListener", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/OnTabItemClickListener;", "mTeacherAdapter", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassTabListTeacherAdapter;", "mTimeAdapter", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "getPageTitle", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "setFilterData", "filterData", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;", "setOnTabItemClick", "listener", "setSelected", "day", "time", "teacherId", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterAdapter.kt */
public final class ClassFilterPagerAdapter extends PagerAdapter {
    private ClassTabListDayAdapter mDayAdapter = new ClassTabListDayAdapter(1);
    private final String[] mDefTitleArray = {"Day", "Time", "Teacher"};
    private OnTabItemClickListener mTabItemClickListener;
    private ClassTabListTeacherAdapter mTeacherAdapter = new ClassTabListTeacherAdapter();
    private ClassTabListDayAdapter mTimeAdapter = new ClassTabListDayAdapter(0, 1, (DefaultConstructorMarker) null);

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View recyclerView = new RecyclerView(viewGroup.getContext());
        if (i == 0) {
            recyclerView.setLayoutManager(new GridLayoutManager(viewGroup.getContext(), 3));
            recyclerView.addItemDecoration(new ListDriver(5.0f, 10.0f));
            recyclerView.setPadding(SizeUtils.dp2px(11.0f), 0, SizeUtils.dp2px(11.0f), 0);
            recyclerView.setAdapter(this.mDayAdapter);
            ClassTabListDayAdapter classTabListDayAdapter = this.mDayAdapter;
            if (classTabListDayAdapter != null) {
                classTabListDayAdapter.setOnItemClickListener(new ClassFilterPagerAdapter$$ExternalSyntheticLambda1(classTabListDayAdapter, this));
            }
        } else if (i == 1) {
            recyclerView.setLayoutManager(new GridLayoutManager(viewGroup.getContext(), 2));
            recyclerView.setPadding(SizeUtils.dp2px(6.0f), 0, SizeUtils.dp2px(6.0f), 0);
            recyclerView.addItemDecoration(new ListDriver(10.0f));
            recyclerView.setAdapter(this.mTimeAdapter);
            ClassTabListDayAdapter classTabListDayAdapter2 = this.mTimeAdapter;
            if (classTabListDayAdapter2 != null) {
                classTabListDayAdapter2.setOnItemClickListener(new ClassFilterPagerAdapter$$ExternalSyntheticLambda0(classTabListDayAdapter2, this));
            }
        } else if (i == 2) {
            recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
            recyclerView.setPadding(SizeUtils.dp2px(11.0f), 0, SizeUtils.dp2px(11.0f), 0);
            recyclerView.addItemDecoration(new ListDriver(5.0f, 10.0f));
            recyclerView.setAdapter(this.mTeacherAdapter);
            ClassTabListTeacherAdapter classTabListTeacherAdapter = this.mTeacherAdapter;
            if (classTabListTeacherAdapter != null) {
                classTabListTeacherAdapter.setOnItemClickListener(new ClassFilterPagerAdapter$$ExternalSyntheticLambda2(classTabListTeacherAdapter, this));
            }
        }
        viewGroup.addView(recyclerView);
        return recyclerView;
    }

    /* access modifiers changed from: private */
    /* renamed from: instantiateItem$lambda-1$lambda-0  reason: not valid java name */
    public static final void m362instantiateItem$lambda1$lambda0(ClassTabListDayAdapter classTabListDayAdapter, ClassFilterPagerAdapter classFilterPagerAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(classTabListDayAdapter, "$this_run");
        Intrinsics.checkNotNullParameter(classFilterPagerAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        String str = (String) classTabListDayAdapter.getItem(i);
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"日期列表选择结果：" + str + " pos:" + i});
        boolean selectedItem$default = ClassTabListDayAdapter.setSelectedItem$default(classTabListDayAdapter, str, false, 2, (Object) null);
        classTabListDayAdapter.notifyDataSetChanged();
        OnTabItemClickListener onTabItemClickListener = classFilterPagerAdapter.mTabItemClickListener;
        if (onTabItemClickListener != null) {
            if (!selectedItem$default) {
                str = null;
            }
            onTabItemClickListener.onDayItemClick(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: instantiateItem$lambda-3$lambda-2  reason: not valid java name */
    public static final void m363instantiateItem$lambda3$lambda2(ClassTabListDayAdapter classTabListDayAdapter, ClassFilterPagerAdapter classFilterPagerAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(classTabListDayAdapter, "$this_run");
        Intrinsics.checkNotNullParameter(classFilterPagerAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        String str = (String) classTabListDayAdapter.getItem(i);
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"时间列表选择结果：" + str + " pos:" + i});
        boolean selectedItem$default = ClassTabListDayAdapter.setSelectedItem$default(classTabListDayAdapter, str, false, 2, (Object) null);
        classTabListDayAdapter.notifyDataSetChanged();
        OnTabItemClickListener onTabItemClickListener = classFilterPagerAdapter.mTabItemClickListener;
        if (onTabItemClickListener != null) {
            if (!selectedItem$default) {
                str = null;
            }
            onTabItemClickListener.onTimeItemClick(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: instantiateItem$lambda-5$lambda-4  reason: not valid java name */
    public static final void m364instantiateItem$lambda5$lambda4(ClassTabListTeacherAdapter classTabListTeacherAdapter, ClassFilterPagerAdapter classFilterPagerAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(classTabListTeacherAdapter, "$this_run");
        Intrinsics.checkNotNullParameter(classFilterPagerAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        ShopClassTeacherData shopClassTeacherData = (ShopClassTeacherData) classTabListTeacherAdapter.getItem(i);
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"老师列表选择结果：" + shopClassTeacherData.getSysName() + " pos:" + i});
        boolean selectedId$default = ClassTabListTeacherAdapter.setSelectedId$default(classTabListTeacherAdapter, shopClassTeacherData.getTeacherId(), false, 2, (Object) null);
        classTabListTeacherAdapter.notifyDataSetChanged();
        OnTabItemClickListener onTabItemClickListener = classFilterPagerAdapter.mTabItemClickListener;
        if (onTabItemClickListener != null) {
            if (!selectedId$default) {
                shopClassTeacherData = null;
            }
            onTabItemClickListener.onTeacherItemClick(shopClassTeacherData);
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        viewGroup.removeView((View) obj);
        if (i == 0) {
            this.mDayAdapter = null;
        } else if (i == 1) {
            this.mTimeAdapter = null;
        } else if (i == 2) {
            this.mTeacherAdapter = null;
        }
    }

    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            String string = Utils.getApp().getString(R.string.day);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                Utils.…string.day)\n            }");
            return string;
        } else if (i == 1) {
            String string2 = Utils.getApp().getString(R.string.time);
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                Utils.…tring.time)\n            }");
            return string2;
        } else if (i != 2) {
            return "";
        } else {
            String string3 = Utils.getApp().getString(R.string.teacher);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                Utils.…ng.teacher)\n            }");
            return string3;
        }
    }

    public int getCount() {
        return this.mDefTitleArray.length;
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual((Object) view, obj);
    }

    public final void setOnTabItemClick(OnTabItemClickListener onTabItemClickListener) {
        Intrinsics.checkNotNullParameter(onTabItemClickListener, "listener");
        this.mTabItemClickListener = onTabItemClickListener;
    }

    public final void setSelected(String str, String str2, String str3) {
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"班级列表筛选弹窗 设置默认选中项 setSelected day=" + str + ", time=" + str2 + ", teacherId=" + str3});
        ClassTabListDayAdapter classTabListDayAdapter = this.mDayAdapter;
        if (classTabListDayAdapter != null) {
            classTabListDayAdapter.setSelectedItem(str, true);
            classTabListDayAdapter.notifyDataSetChanged();
        }
        ClassTabListDayAdapter classTabListDayAdapter2 = this.mTimeAdapter;
        if (classTabListDayAdapter2 != null) {
            classTabListDayAdapter2.setSelectedItem(str2, true);
            classTabListDayAdapter2.notifyDataSetChanged();
        }
        ClassTabListTeacherAdapter classTabListTeacherAdapter = this.mTeacherAdapter;
        if (classTabListTeacherAdapter != null) {
            classTabListTeacherAdapter.setSelectedId(str3, true);
            classTabListTeacherAdapter.notifyDataSetChanged();
        }
    }

    public final void setFilterData(ShopClassFilterData shopClassFilterData) {
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"班级列表筛选弹窗 适配器 setFilterData"});
        if (shopClassFilterData != null) {
            ClassTabListDayAdapter classTabListDayAdapter = this.mDayAdapter;
            if (classTabListDayAdapter != null) {
                classTabListDayAdapter.setList(shopClassFilterData.getDay());
            }
            ClassTabListDayAdapter classTabListDayAdapter2 = this.mTimeAdapter;
            if (classTabListDayAdapter2 != null) {
                classTabListDayAdapter2.setList(shopClassFilterData.getTime());
            }
            ClassTabListTeacherAdapter classTabListTeacherAdapter = this.mTeacherAdapter;
            if (classTabListTeacherAdapter != null) {
                classTabListTeacherAdapter.setList(shopClassFilterData.getTeacher());
            }
        }
    }
}
