package com.didi.hummer.render.utility;

import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.luck.picture.lib.tools.PictureFileUtils;

public class YogaNodeUtil {
    public static YogaNode createYogaNode() {
        if ((YogaNode.class.getModifiers() & PictureFileUtils.KB) != 0) {
            return YogaNodeFactory.create();
        }
        try {
            return YogaNode.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
