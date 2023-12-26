package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public class LensFacingCameraFilter implements CameraFilter {
    private int mLensFacing;

    public /* synthetic */ CameraFilter.Id getId() {
        return CameraFilter.CC.$default$getId(this);
    }

    public LensFacingCameraFilter(int i) {
        this.mLensFacing = i;
    }

    public List<CameraInfo> filter(List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo next : list) {
            Preconditions.checkArgument(next instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            Integer lensFacing = ((CameraInfoInternal) next).getLensFacing();
            if (lensFacing != null && lensFacing.intValue() == this.mLensFacing) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}
