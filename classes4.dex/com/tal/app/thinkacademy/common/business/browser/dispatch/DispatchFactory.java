package com.tal.app.thinkacademy.common.business.browser.dispatch;

import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class DispatchFactory {
    private Map<String, IDispatcher> dispatcherMap;

    public DispatchFactory(FragmentActivity fragmentActivity) {
        HashMap hashMap = new HashMap();
        this.dispatcherMap = hashMap;
        hashMap.put("ThinkAcademyApp", new LogInOutDispatcher(fragmentActivity));
        this.dispatcherMap.put("HWClassCourseware", new CourseWareDispatcher(fragmentActivity));
        this.dispatcherMap.put("HWTouchStore", new TouchStoreDispatcher(fragmentActivity));
    }

    public IDispatcher getDispatcher(String str) {
        return this.dispatcherMap.get(str);
    }

    public void setFragmentActivity(FragmentActivity fragmentActivity) {
        for (IDispatcher next : this.dispatcherMap.values()) {
            if (next instanceof LogInOutDispatcher) {
                ((LogInOutDispatcher) next).setActivityWef(new WeakReference(fragmentActivity));
            } else if (next instanceof CourseWareDispatcher) {
                ((CourseWareDispatcher) next).setActivityWef(new WeakReference(fragmentActivity));
            } else if (next instanceof TouchStoreDispatcher) {
                ((TouchStoreDispatcher) next).setActivityWef(new WeakReference(fragmentActivity));
            }
        }
    }

    public boolean getHwCourseIsCacheComplete() {
        IDispatcher iDispatcher = this.dispatcherMap.get("HWTouchStore");
        if (iDispatcher == null || !(iDispatcher instanceof TouchStoreDispatcher)) {
            return false;
        }
        return ((TouchStoreDispatcher) iDispatcher).isCourseCached();
    }

    public void setHwCourseIsCacheComplete(boolean z) {
        IDispatcher iDispatcher = this.dispatcherMap.get("HWTouchStore");
        if (iDispatcher != null && (iDispatcher instanceof TouchStoreDispatcher)) {
            ((TouchStoreDispatcher) iDispatcher).setCourseCached(z);
        }
    }
}
