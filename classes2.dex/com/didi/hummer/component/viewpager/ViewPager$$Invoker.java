package com.didi.hummer.component.viewpager;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class ViewPager$$Invoker extends BaseInvoker<ViewPager> {
    public String getName() {
        return "ViewPager";
    }

    /* access modifiers changed from: protected */
    public ViewPager createInstance(JSValue jSValue, Object[] objArr) {
        return new ViewPager(this.mHummerContext, jSValue);
    }

    /* access modifiers changed from: protected */
    public Object invoke(ViewPager viewPager, String str, Object[] objArr) {
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -1811086742:
                if (str.equals("setCurrentItem")) {
                    c = 0;
                    break;
                }
                break;
            case -1136975066:
                if (str.equals("onPageScrollStateChange")) {
                    c = 1;
                    break;
                }
                break;
            case -347436201:
                if (str.equals("onItemView")) {
                    c = 2;
                    break;
                }
                break;
            case -136881570:
                if (str.equals("onPageChange")) {
                    c = 3;
                    break;
                }
                break;
            case 317074811:
                if (str.equals("onPageScroll")) {
                    c = 4;
                    break;
                }
                break;
            case 925617692:
                if (str.equals("dbg_getDescription")) {
                    c = 5;
                    break;
                }
                break;
            case 1984503596:
                if (str.equals("setData")) {
                    c = 6;
                    break;
                }
                break;
            case 2096925462:
                if (str.equals("onItemClick")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (objArr.length > 0 && objArr[0] != null) {
                    i = objArr[0].intValue();
                }
                viewPager.setCurrentItem(i);
                break;
            case 1:
                viewPager.onPageScrollStateChange((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                break;
            case 2:
                viewPager.onItemView((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                break;
            case 3:
                viewPager.onPageChange((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                break;
            case 4:
                viewPager.onPageScroll((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                break;
            case 5:
                JSCallback jSCallback = (objArr.length <= 0 || objArr[0] == null) ? null : objArr[0];
                if (objArr.length > 1 && objArr[1] != null) {
                    i = objArr[1].intValue();
                }
                viewPager.dbg_getDescription(jSCallback, i);
                break;
            case 6:
                viewPager.setData((objArr.length <= 0 || objArr[0] == null) ? null : (List) HMGsonUtil.fromJson(objArr[0], new TypeToken<List<Object>>() {
                }.getType()));
                break;
            case 7:
                viewPager.onItemClick((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                break;
        }
        return null;
    }
}
