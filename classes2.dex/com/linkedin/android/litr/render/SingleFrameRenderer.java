package com.linkedin.android.litr.render;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/linkedin/android/litr/render/SingleFrameRenderer;", "", "renderFrame", "Landroid/graphics/Bitmap;", "input", "presentationTimeNs", "", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SingleFrameRenderer.kt */
public interface SingleFrameRenderer {
    Bitmap renderFrame(Bitmap bitmap, long j);
}
