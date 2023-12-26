package com.tal.app.thinkacademy.common.flutter;

import android.os.Bundle;
import android.view.View;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import io.flutter.embedding.android.RenderMode;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/HwFlutterFragment;", "Lcom/idlefish/flutterboost/containers/FlutterBoostFragment;", "()V", "didFragmentHide", "", "getRenderMode", "Lio/flutter/embedding/android/RenderMode;", "isUseTextureView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwFlutterFragment.kt */
public final class HwFlutterFragment extends FlutterBoostFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.FLUTTER;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/HwFlutterFragment$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwFlutterFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean isUseTextureView() {
        return Intrinsics.areEqual("1", HwCloudControlHelper.Companion.get().getCloudKeyValue("flutter_use_texture_view"));
    }

    public RenderMode getRenderMode() {
        if (isUseTextureView()) {
            XesLog.i(TAG, "渲染模式：HwFlutterFragment 使用TextureView");
            return RenderMode.texture;
        }
        XesLog.i(TAG, "渲染模式：HwFlutterFragment 使用SurfaceView");
        return RenderMode.surface;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        HwFlutterFragment.super.onViewCreated(view, bundle);
        HashMap hashMap = new HashMap();
        HwFlutterUtil.INSTANCE.setupJumpParams(hashMap);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putSerializable("url_param", hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void didFragmentHide() {
        HwFlutterFragment.super.didFragmentHide();
        if (isUseTextureView()) {
            detachFromEngineIfNeeded();
        }
    }
}
