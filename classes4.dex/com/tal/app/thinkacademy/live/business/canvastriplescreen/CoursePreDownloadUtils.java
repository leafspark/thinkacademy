package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.util.CourseLoadInfoManager;
import java.util.ArrayList;
import java.util.List;

public class CoursePreDownloadUtils {
    public static void loadPicPre(Context context, String str) {
        XesImageLoader.INSTANCE.preloadImage(context, str);
    }

    public static List<CourseWareBean> getCourseLivePicList() {
        ArrayList arrayList = new ArrayList();
        for (CourseLoadInfoEntity next : CourseLoadInfoManager.getInstance().getInClassIpadPicList()) {
            CourseWareBean courseWareBean = new CourseWareBean();
            courseWareBean.imgUrl = next.thumbnailPath;
            courseWareBean.pageId = next.pageId;
            courseWareBean.courseWareId = next.packageId;
            arrayList.add(courseWareBean);
        }
        return arrayList;
    }
}
