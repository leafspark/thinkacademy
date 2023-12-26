package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Pathfinder {
    private static final String TAG = "SA.PathFinder";
    private final IntStack mIndexStack = new IntStack();

    public interface Accumulator {
        void accumulate(View view);
    }

    public static boolean hasClassName(Object obj, String str) {
        for (Class cls = obj.getClass(); cls.getCanonicalName() != null; cls = cls.getSuperclass()) {
            if (cls.getCanonicalName().equals(str)) {
                return true;
            }
            if (cls == Object.class) {
                return false;
            }
        }
        return false;
    }

    public void findTargetsInRoot(View view, List<PathElement> list, Accumulator accumulator) {
        if (!list.isEmpty()) {
            if (this.mIndexStack.full()) {
                SALog.i(TAG, "Path is too deep, there is no memory to perfrom the finding");
                return;
            }
            List<PathElement> subList = list.subList(1, list.size());
            View findPrefixedMatch = findPrefixedMatch(list.get(0), view, this.mIndexStack.alloc());
            this.mIndexStack.free();
            if (findPrefixedMatch != null) {
                findTargetsInMatchedView(findPrefixedMatch, subList, accumulator);
            }
        }
    }

    private void findTargetsInMatchedView(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            accumulator.accumulate(view);
        } else if (this.mIndexStack.full()) {
            SALog.i(TAG, "Path is too deep, there is no memory to perfrom the finding");
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PathElement pathElement = list.get(0);
            List<PathElement> subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int alloc = this.mIndexStack.alloc();
            for (int i = 0; i < childCount; i++) {
                View findPrefixedMatch = findPrefixedMatch(pathElement, viewGroup.getChildAt(i), alloc);
                if (findPrefixedMatch != null) {
                    findTargetsInMatchedView(findPrefixedMatch, subList, accumulator);
                }
                if (pathElement.index >= 0 && this.mIndexStack.read(alloc) > pathElement.index) {
                    break;
                }
            }
            this.mIndexStack.free();
        }
    }

    private View findPrefixedMatch(PathElement pathElement, View view, int i) {
        View findPrefixedMatch;
        int read = this.mIndexStack.read(i);
        if (matches(pathElement, view)) {
            this.mIndexStack.increment(i);
            if (pathElement.index == -1 || pathElement.index == read) {
                return view;
            }
        }
        if (pathElement.prefix != 1 || !(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null && (findPrefixedMatch = findPrefixedMatch(pathElement, childAt, i)) != null) {
                return findPrefixedMatch;
            }
        }
        return null;
    }

    private boolean matches(PathElement pathElement, View view) {
        if (pathElement.viewClassName != null && !hasClassName(view, pathElement.viewClassName)) {
            return false;
        }
        if (-1 == pathElement.viewId || view.getId() == pathElement.viewId) {
            return true;
        }
        return false;
    }

    public static class PathElement {
        public static final int SHORTEST_PREFIX = 1;
        public static final int ZERO_LENGTH_PREFIX = 0;
        public final int index;
        public final int prefix;
        public final String viewClassName;
        public final int viewId;

        public PathElement(int i, String str, int i2, int i3) {
            this.prefix = i;
            this.viewClassName = str;
            this.index = i2;
            this.viewId = i3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.prefix == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                String str = this.viewClassName;
                if (str != null) {
                    jSONObject.put("view_class", str);
                }
                int i = this.index;
                if (i > -1) {
                    jSONObject.put("index", i);
                }
                int i2 = this.viewId;
                if (i2 > -1) {
                    jSONObject.put("id", i2);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                throw new RuntimeException("Can't serialize PathElement to String", e);
            }
        }
    }

    private static class IntStack {
        private static final int MAX_INDEX_STACK_SIZE = 256;
        private final int[] mStack = new int[MAX_INDEX_STACK_SIZE];
        private int mStackSize = 0;

        public boolean full() {
            return this.mStack.length == this.mStackSize;
        }

        public int alloc() {
            int i = this.mStackSize;
            this.mStackSize = i + 1;
            this.mStack[i] = 0;
            return i;
        }

        public int read(int i) {
            return this.mStack[i];
        }

        public void increment(int i) {
            int[] iArr = this.mStack;
            iArr[i] = iArr[i] + 1;
        }

        public void free() {
            int i = this.mStackSize - 1;
            this.mStackSize = i;
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(this.mStackSize);
            }
        }
    }
}
