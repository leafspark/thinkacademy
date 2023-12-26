package com.coloros.ocs.base.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class e {
    public static a a(Object obj) {
        return new a(obj);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static class a {
        private Object a;
        private List<String> b = new ArrayList();

        public a(Object obj) {
            Objects.requireNonNull(obj, "null reference");
            this.a = obj;
        }

        public final a a(String str, Object obj) {
            List<String> list = this.b;
            list.add(c.a(str + "=" + obj));
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.a.getClass().getSimpleName());
            sb.append('{');
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.b.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
