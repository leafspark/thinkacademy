package com.tal.app.thinkacademy.live.core.plugin;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginEventBus2 {
    private static Map<String, MyMutableLiveData<PluginEventData>> eventMap = new ConcurrentHashMap();

    public static void register(LifecycleOwner lifecycleOwner, String str, Observer<PluginEventData> observer) {
        MyMutableLiveData myMutableLiveData = eventMap.get(str);
        if (myMutableLiveData == null) {
            myMutableLiveData = new MyMutableLiveData();
            eventMap.put(str, myMutableLiveData);
        }
        myMutableLiveData.observe(lifecycleOwner, observer);
    }

    public static void onEvent(String str, PluginEventData pluginEventData) {
        MyMutableLiveData myMutableLiveData = eventMap.get(str);
        if (myMutableLiveData != null) {
            myMutableLiveData.postValue(pluginEventData);
        }
    }

    public static void unregister(String str, Observer<PluginEventData> observer) {
        MyMutableLiveData myMutableLiveData = eventMap.get(str);
        if (myMutableLiveData != null) {
            myMutableLiveData.removeObserver(observer);
        }
    }

    public static class MyMutableLiveData<T> extends MutableLiveData<T> {
        private boolean isWithStick = false;

        public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            if (!this.isWithStick) {
                hookVersion(this);
            }
            PluginEventBus2.super.observe(lifecycleOwner, observer);
        }

        public void setWithStick(boolean z) {
            this.isWithStick = z;
        }

        private void hookVersion(MyMutableLiveData myMutableLiveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mVersion");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(myMutableLiveData)).intValue() != -1) {
                    declaredField.set(myMutableLiveData, -1);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
