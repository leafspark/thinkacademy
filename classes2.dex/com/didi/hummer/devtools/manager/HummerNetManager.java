package com.didi.hummer.devtools.manager;

import com.didi.hummer.devtools.bean.NetBean;
import java.util.ArrayList;
import java.util.List;

public class HummerNetManager {
    private List<NetBean> nets = new ArrayList();

    public List<NetBean> getNets() {
        return this.nets;
    }

    public void addData(String str, Object obj, Object obj2) {
        this.nets.add(new NetBean(str, obj, obj2));
    }
}
