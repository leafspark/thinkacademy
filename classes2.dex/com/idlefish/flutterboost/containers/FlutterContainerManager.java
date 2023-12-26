package com.idlefish.flutterboost.containers;

import android.app.Activity;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FlutterContainerManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlutterContainerManager";
    private final LinkedList<FlutterViewContainer> activeContainers;
    private final Map<String, FlutterViewContainer> allContainers;

    private FlutterContainerManager() {
        this.allContainers = new HashMap();
        this.activeContainers = new LinkedList<>();
    }

    private static class LazyHolder {
        static final FlutterContainerManager INSTANCE = new FlutterContainerManager();

        private LazyHolder() {
        }
    }

    public static FlutterContainerManager instance() {
        return LazyHolder.INSTANCE;
    }

    public void addContainer(String str, FlutterViewContainer flutterViewContainer) {
        this.allContainers.put(str, flutterViewContainer);
    }

    public void activateContainer(String str, FlutterViewContainer flutterViewContainer) {
        if (str != null && flutterViewContainer != null) {
            if (this.activeContainers.contains(flutterViewContainer)) {
                this.activeContainers.remove(flutterViewContainer);
            }
            this.activeContainers.add(flutterViewContainer);
        }
    }

    public void removeContainer(String str) {
        if (str != null) {
            this.activeContainers.remove(this.allContainers.remove(str));
        }
    }

    public FlutterViewContainer findContainerById(String str) {
        if (this.allContainers.containsKey(str)) {
            return this.allContainers.get(str);
        }
        return null;
    }

    public boolean isActiveContainer(FlutterViewContainer flutterViewContainer) {
        return this.activeContainers.contains(flutterViewContainer);
    }

    public FlutterViewContainer getTopContainer() {
        if (this.activeContainers.size() > 0) {
            return this.activeContainers.getLast();
        }
        return null;
    }

    public FlutterViewContainer getTopActivityContainer() {
        int size = this.activeContainers.size();
        if (size == 0) {
            return null;
        }
        for (int i = size - 1; i >= 0; i--) {
            FlutterViewContainer flutterViewContainer = this.activeContainers.get(i);
            if (flutterViewContainer instanceof Activity) {
                return flutterViewContainer;
            }
        }
        return null;
    }

    public boolean isTopContainer(String str) {
        FlutterViewContainer topContainer = getTopContainer();
        return topContainer != null && topContainer.getUniqueId() == str;
    }

    public int getContainerSize() {
        return this.allContainers.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("activeContainers=" + this.activeContainers.size() + ", [");
        this.activeContainers.forEach(new FlutterContainerManager$$ExternalSyntheticLambda0(sb));
        sb.append("]");
        return sb.toString();
    }
}
