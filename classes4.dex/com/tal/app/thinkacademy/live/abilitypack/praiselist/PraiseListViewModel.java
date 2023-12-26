package com.tal.app.thinkacademy.live.abilitypack.praiselist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.listenbody.PraiseListListenerBody;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u00020\u0016H\u0014J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/PraiseListViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mListenerData", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/listenbody/PraiseListListenerBody;", "getMListenerData", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mUserInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "fromFile", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "getUserAvatar", "", "getUserId", "onVmDestroy", "", "saveToGallery", "", "path", "title", "description", "screenshot", "view", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListViewModel.kt */
public final class PraiseListViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PRAISE_LIST;
    private final ListenerData<PraiseListListenerBody> mListenerData = new ListenerData<>();
    private final UserInfoProxy mUserInfo = getMLiveRoomProvider().getDataStorage().getUserInfo();

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PraiseListViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/PraiseListViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseListViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ListenerData<PraiseListListenerBody> getMListenerData() {
        return this.mListenerData;
    }

    public final String getUserId() {
        UserInfoProxy userInfoProxy = this.mUserInfo;
        if (userInfoProxy == null) {
            return null;
        }
        return userInfoProxy.getId();
    }

    public final String getUserAvatar() {
        UserInfoProxy userInfoProxy = this.mUserInfo;
        if (userInfoProxy == null) {
            return null;
        }
        return userInfoProxy.getAvatar();
    }

    public final void screenshot(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new PraiseListViewModel$screenshot$1(this, view, context, (Continuation<? super PraiseListViewModel$screenshot$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Bitmap screenshot(View view) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            XesLog.e(TAG, Intrinsics.stringPlus("截屏- 异常：", e.getMessage()));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final boolean saveToGallery(Context context, String str, String str2, String str3) {
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), str, str2, str3);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile(context, new File(str)));
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final Uri fromFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(context, Intrinsics.stringPlus(context.getApplicationContext().getPackageName(), ".fileprovider"), file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n            FileProvid…rovider\", file)\n        }");
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "{\n            Uri.fromFile(file)\n        }");
        return fromFile;
    }
}
