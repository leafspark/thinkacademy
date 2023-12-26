package com.tal.app.thinkacademy.live.abilitypack.photowall;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photowall/PhotoWallViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "getCorrectCoin", "", "getReviseCoin", "isAddCoinCorrect", "", "onVmDestroy", "", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoWallViewModel.kt */
public final class PhotoWallViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.BasePhotosOnTheWallPlugin;
    private final ILiveRoomProvider provider;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photowall/PhotoWallViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoWallViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoWallViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public final boolean isAddCoinCorrect() {
        try {
            Map<String, String> initModuleMap = this.provider.getInitModuleMap();
            if (initModuleMap != null) {
                String str = initModuleMap.get("218");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("addCoinCorrect")) {
                        String optString = jSONObject.optString("addCoinCorrect");
                        XesLog.i(TAG, Intrinsics.stringPlus("是否开启批改奖励金币=", Boolean.valueOf(Intrinsics.areEqual(optString, "1"))));
                        return Intrinsics.areEqual(optString, "1");
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XesLog.i(TAG, "默认关闭批改奖励金币");
        return false;
    }

    public final int getCorrectCoin() {
        try {
            Map<String, String> initModuleMap = this.provider.getInitModuleMap();
            if (initModuleMap != null) {
                String str = initModuleMap.get("218");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("correctCoin")) {
                        String optString = jSONObject.optString("correctCoin");
                        XesLog.i(TAG, Intrinsics.stringPlus("批改正确加的金币=", optString));
                        Intrinsics.checkNotNullExpressionValue(optString, "correctCoin");
                        return Integer.parseInt(optString);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XesLog.i(TAG, "默认兜底批改正确不加金币");
        return 0;
    }

    public final int getReviseCoin() {
        try {
            Map<String, String> initModuleMap = this.provider.getInitModuleMap();
            if (initModuleMap != null) {
                String str = initModuleMap.get("218");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("reviseCoin")) {
                        String optString = jSONObject.optString("reviseCoin");
                        XesLog.i(TAG, Intrinsics.stringPlus("订正后批改正确加的金币=", optString));
                        Intrinsics.checkNotNullExpressionValue(optString, "reviseCoin");
                        return Integer.parseInt(optString);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XesLog.i(TAG, "默认兜底订正后批改正确不加金币");
        return 0;
    }
}
