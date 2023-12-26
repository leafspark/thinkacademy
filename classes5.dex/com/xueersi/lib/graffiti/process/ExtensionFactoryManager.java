package com.xueersi.lib.graffiti.process;

import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.lib.graffiti.utils.ListUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExtensionFactoryManager {
    private final Map<Integer, List<ExtensionFactory>> searchMap = new ConcurrentHashMap();

    public void remove(ExtensionFactory extensionFactory) {
        if (extensionFactory != null) {
            List list = this.searchMap.get(Integer.valueOf(extensionFactory.messageType()));
            if (list != null) {
                list.remove(extensionFactory);
            }
        }
    }

    public void add(ExtensionFactory extensionFactory) {
        if (extensionFactory != null) {
            int messageType = extensionFactory.messageType();
            List list = this.searchMap.get(Integer.valueOf(messageType));
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.searchMap.put(Integer.valueOf(messageType), list);
            }
            if (!list.contains(extensionFactory)) {
                list.add(extensionFactory);
            }
        }
    }

    public ExtensionFactory hit(WXWBAction wXWBAction) {
        if (wXWBAction == null) {
            return null;
        }
        List list = this.searchMap.get(Integer.valueOf(wXWBAction.getMessageType()));
        if (!ListUtil.isNotEmpty(list)) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                return (ExtensionFactory) list.get(0);
            }
            ExtensionFactory extensionFactory = (ExtensionFactory) it.next();
            int[] businessTypes = extensionFactory.businessTypes();
            int[] pointTypes = extensionFactory.pointTypes();
            if (businessTypes != null && businessTypes.length > 0) {
                int length = businessTypes.length;
                while (i < length) {
                    if (businessTypes[i] == wXWBAction.getBusinessType()) {
                        return extensionFactory;
                    }
                    i++;
                }
                continue;
            } else if (pointTypes != null && pointTypes.length > 0) {
                int length2 = pointTypes.length;
                while (i < length2) {
                    if (pointTypes[i] == wXWBAction.getPointType()) {
                        return extensionFactory;
                    }
                    i++;
                }
                continue;
            }
        }
    }
}
