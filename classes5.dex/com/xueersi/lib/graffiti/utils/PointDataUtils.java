package com.xueersi.lib.graffiti.utils;

import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;

public class PointDataUtils {
    public static boolean existActionEndPoint(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList == null) {
            return false;
        }
        for (int i = 0; i < pointList.size(); i++) {
            if (pointList.get(i).getPointAction() == 2) {
                return true;
            }
        }
        return false;
    }
}
