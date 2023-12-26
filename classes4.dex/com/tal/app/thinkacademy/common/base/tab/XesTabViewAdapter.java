package com.tal.app.thinkacademy.common.base.tab;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo;
import java.util.List;

public class XesTabViewAdapter {
    private Fragment mCurFragment;
    private FragmentManager mFragmentManager;
    private List<XesTabBottomInfo<?>> mInfoList;

    public XesTabViewAdapter(FragmentManager fragmentManager, List<XesTabBottomInfo<?>> list) {
        this.mFragmentManager = fragmentManager;
        this.mInfoList = list;
    }

    public void instantiateItem(View view, int i) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        Fragment fragment = this.mCurFragment;
        if (fragment != null) {
            beginTransaction.hide(fragment);
        }
        String str = view.getId() + ":" + i;
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            beginTransaction.show(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            if (findFragmentByTag != null && !findFragmentByTag.isAdded()) {
                beginTransaction.add(view.getId(), findFragmentByTag, str);
            }
        }
        this.mCurFragment = findFragmentByTag;
        beginTransaction.commitNowAllowingStateLoss();
    }

    public Fragment getCurrentFragment() {
        return this.mCurFragment;
    }

    public Fragment getItem(int i) {
        try {
            return this.mInfoList.get(i).fragment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCount() {
        List<XesTabBottomInfo<?>> list = this.mInfoList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
