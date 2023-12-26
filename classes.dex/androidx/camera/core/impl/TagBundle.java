package androidx.camera.core.impl;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Map;
import java.util.Set;

public class TagBundle {
    private static final TagBundle EMPTY_TAGBUNDLE = new TagBundle(new ArrayMap());
    protected final Map<String, Object> mTagMap;

    protected TagBundle(Map<String, Object> map) {
        this.mTagMap = map;
    }

    public static TagBundle emptyBundle() {
        return EMPTY_TAGBUNDLE;
    }

    public static TagBundle create(Pair<String, Object> pair) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put((String) pair.first, pair.second);
        return new TagBundle(arrayMap);
    }

    public static TagBundle from(TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        for (String next : tagBundle.listKeys()) {
            arrayMap.put(next, tagBundle.getTag(next));
        }
        return new TagBundle(arrayMap);
    }

    public Object getTag(String str) {
        return this.mTagMap.get(str);
    }

    public Set<String> listKeys() {
        return this.mTagMap.keySet();
    }
}
