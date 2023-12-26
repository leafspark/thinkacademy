package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EditState extends UIThreadSet<Activity> {
    private static final String LOGTAG = "SA.EditState";
    private final Map<Activity, Set<EditBinding>> mCurrentEdits = new HashMap();
    private final Map<String, List<ViewVisitor>> mIntendedEdits = new HashMap();
    private final Handler mUiThreadHandler = new Handler(Looper.getMainLooper());

    public void add(Activity activity) {
        super.add(activity);
        applyEditsOnActivity(activity);
    }

    public void remove(Activity activity) {
        super.remove(activity);
        removeChangesOnActivity(activity);
    }

    private void applyEditsOnActivity(Activity activity) {
        List list;
        List list2;
        String canonicalName = activity.getClass().getCanonicalName();
        Window window = activity.getWindow();
        View rootView = (window == null || !window.isActive()) ? null : window.getDecorView().getRootView();
        if (rootView != null) {
            synchronized (this.mIntendedEdits) {
                list = this.mIntendedEdits.get(canonicalName);
                list2 = this.mIntendedEdits.get((Object) null);
            }
            if (list != null) {
                applyChangesFromList(activity, rootView, list);
            }
            if (list2 != null) {
                applyChangesFromList(activity, rootView, list2);
            }
        }
    }

    private void applyChangesFromList(Activity activity, View view, List<ViewVisitor> list) {
        synchronized (this.mCurrentEdits) {
            if (!this.mCurrentEdits.containsKey(activity)) {
                this.mCurrentEdits.put(activity, new HashSet());
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.mCurrentEdits.get(activity).add(new EditBinding(view, list.get(i), this.mUiThreadHandler));
            }
        }
    }

    private void removeChangesOnActivity(Activity activity) {
        synchronized (this.mCurrentEdits) {
            Set<EditBinding> set = this.mCurrentEdits.get(activity);
            if (set != null) {
                for (EditBinding kill : set) {
                    kill.kill();
                }
                this.mCurrentEdits.remove(activity);
            }
        }
    }

    private static class EditBinding implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        private boolean mAlive = true;
        private volatile boolean mDying = false;
        private final ViewVisitor mEdit;
        private final Handler mHandler;
        private final WeakReference<View> mViewRoot;

        public EditBinding(View view, ViewVisitor viewVisitor, Handler handler) {
            this.mEdit = viewVisitor;
            this.mViewRoot = new WeakReference<>(view);
            this.mHandler = handler;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        public void onGlobalLayout() {
            run();
        }

        public void run() {
            if (this.mAlive) {
                View view = (View) this.mViewRoot.get();
                if (view == null || this.mDying) {
                    cleanUp();
                    return;
                }
                this.mEdit.visit(view);
                this.mHandler.removeCallbacks(this);
                this.mHandler.postDelayed(this, 5000);
            }
        }

        public void kill() {
            this.mDying = true;
            this.mHandler.post(this);
        }

        private void cleanUp() {
            if (this.mAlive) {
                View view = (View) this.mViewRoot.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        if (Build.VERSION.SDK_INT < 16) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        } else {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                    }
                }
                this.mEdit.cleanup();
            }
            this.mAlive = false;
        }
    }
}
