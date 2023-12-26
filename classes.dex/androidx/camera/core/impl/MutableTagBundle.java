package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Map;

public class MutableTagBundle extends TagBundle {
    private MutableTagBundle(Map<String, Object> map) {
        super(map);
    }

    public static MutableTagBundle create() {
        return new MutableTagBundle(new ArrayMap());
    }

    public static MutableTagBundle from(TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        for (String next : tagBundle.listKeys()) {
            arrayMap.put(next, tagBundle.getTag(next));
        }
        return new MutableTagBundle(arrayMap);
    }

    public void putTag(String str, Object obj) {
        this.mTagMap.put(str, obj);
    }

    public void addTagBundle(TagBundle tagBundle) {
        if (this.mTagMap != null && tagBundle.mTagMap != null) {
            this.mTagMap.putAll(tagBundle.mTagMap);
        }
    }
}
