package com.didi.hummer.render.event;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.lifecycle.ILifeCycle;
import com.didi.hummer.render.event.base.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EventManager implements ILifeCycle, IEventListener {
    public HashMap<String, List<JSCallback>> mEventListeners;

    public void onCreate() {
        this.mEventListeners = new HashMap<>();
    }

    public void onDestroy() {
        HashMap<String, List<JSCallback>> hashMap = this.mEventListeners;
        if (hashMap != null) {
            for (List<JSCallback> next : hashMap.values()) {
                if (next != null) {
                    for (JSCallback jSCallback : next) {
                        if (jSCallback != null) {
                            jSCallback.release();
                        }
                    }
                    next.clear();
                }
            }
            this.mEventListeners.clear();
        }
    }

    public void addEventListener(String str, JSCallback jSCallback) {
        if (this.mEventListeners.containsKey(str)) {
            List list = this.mEventListeners.get(str);
            if (!list.contains(jSCallback)) {
                list.add(jSCallback);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(jSCallback);
        this.mEventListeners.put(str, arrayList);
    }

    public void removeEventListener(String str, JSCallback jSCallback) {
        if (this.mEventListeners.containsKey(str) && jSCallback != null) {
            List list = this.mEventListeners.get(str);
            JSCallback jSCallback2 = null;
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    JSCallback jSCallback3 = (JSCallback) it.next();
                    if (jSCallback3 != null && jSCallback3.equals(jSCallback)) {
                        jSCallback2 = jSCallback3;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (jSCallback2 != null) {
                jSCallback2.release();
                list.remove(jSCallback2);
            }
        }
    }

    public void clearEventListeners(String str) {
        if (this.mEventListeners.containsKey(str)) {
            List<JSCallback> list = this.mEventListeners.get(str);
            for (JSCallback jSCallback : list) {
                if (jSCallback != null) {
                    jSCallback.release();
                }
            }
            list.clear();
        }
    }

    public void dispatchEvent(String str, Event event) {
        if (this.mEventListeners.containsKey(str)) {
            for (JSCallback call : this.mEventListeners.get(str)) {
                call.call(event);
            }
        }
    }

    public boolean contains(String str) {
        return this.mEventListeners.containsKey(str);
    }

    public boolean isEmpty() {
        HashMap<String, List<JSCallback>> hashMap = this.mEventListeners;
        return hashMap == null || hashMap.isEmpty();
    }
}
