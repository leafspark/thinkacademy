package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    public <T extends Quirk> T get(Class<T> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            T t = (Quirk) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public boolean contains(Class<? extends Quirk> cls) {
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                return true;
            }
        }
        return false;
    }
}
