package com.tal.app.thinkacademy.live.abilitypack.keyboardfill;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.lib.utils.HWCoroutineScopeKt;
import com.tal.app.thinkacademy.live.abilitypack.LiveRepository;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.listenbody.KeyboardFillListenerBody;
import com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene;
import com.tal.app.thinkacademy.live.business.keyboardfill.CommitScene;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\rJ\b\u0010\u001b\u001a\u00020\u000fH\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/KeyboardFillViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mListenerData", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "getMListenerData", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mLiveRepository", "Lcom/tal/app/thinkacademy/live/abilitypack/LiveRepository;", "mSubmitPosting", "", "check", "", "planId", "", "classId", "interactionId", "", "scene", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;", "commit", "option", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "isSubmitPosting", "onVmDestroy", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillViewModel.kt */
public final class KeyboardFillViewModel extends AbilityViewModel {
    private final ListenerData<KeyboardFillListenerBody> mListenerData = new ListenerData<>();
    /* access modifiers changed from: private */
    public final LiveRepository mLiveRepository = new LiveRepository();
    /* access modifiers changed from: private */
    public boolean mSubmitPosting;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyboardFillViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
    }

    public final ListenerData<KeyboardFillListenerBody> getMListenerData() {
        return this.mListenerData;
    }

    public final void check(int i, int i2, String str, CheckScene checkScene) {
        Intrinsics.checkNotNullParameter(checkScene, "scene");
        HWCoroutineScopeKt.launchWithException(ViewModelKt.getViewModelScope((ViewModel) this), new KeyboardFillViewModel$check$1(this, checkScene), new KeyboardFillViewModel$check$2(this, i, i2, str, checkScene, (Continuation<? super KeyboardFillViewModel$check$2>) null));
    }

    public final void commit(int i, int i2, String str, String str2, CommitScene commitScene) {
        CommitScene commitScene2 = commitScene;
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "option");
        Intrinsics.checkNotNullParameter(commitScene2, "scene");
        this.mSubmitPosting = true;
        HWCoroutineScopeKt.launchWithException(ViewModelKt.getViewModelScope((ViewModel) this), new KeyboardFillViewModel$commit$1(this, commitScene2), new KeyboardFillViewModel$commit$2(this, i, i2, str, str3, commitScene2, (Continuation<? super KeyboardFillViewModel$commit$2>) null));
    }

    public final boolean isSubmitPosting() {
        return this.mSubmitPosting;
    }
}
