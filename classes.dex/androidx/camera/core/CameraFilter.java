package androidx.camera.core;

import java.util.List;

public interface CameraFilter {
    List<CameraInfo> filter(List<CameraInfo> list);

    Id getId();

    /* renamed from: androidx.camera.core.CameraFilter$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Id $default$getId(CameraFilter _this) {
            return Id.DEFAULT;
        }
    }

    public static abstract class Id {
        public static final Id DEFAULT = create(new Object());

        public abstract Object getValue();

        public static Id create(Object obj) {
            return new AutoValue_CameraFilter_Id(obj);
        }
    }
}
