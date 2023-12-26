package com.tal.app.thinkacademy.business.login.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/TempListPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "behavior", "", "mList", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentManager;ILjava/util/List;)V", "getCount", "getItem", "position", "getItemPosition", "any", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TempListPagerAdapter.kt */
public final class TempListPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TempListPagerAdapter(FragmentManager fragmentManager, int i, List<Fragment> list) {
        super(fragmentManager, i);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(list, "mList");
        this.mList = list;
    }

    public Fragment getItem(int i) {
        return this.mList.get(i);
    }

    public int getCount() {
        return this.mList.size();
    }

    public int getItemPosition(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "any");
        if (CollectionsKt.contains(this.mList, obj)) {
            return TempListPagerAdapter.super.getItemPosition(obj);
        }
        return -2;
    }
}
