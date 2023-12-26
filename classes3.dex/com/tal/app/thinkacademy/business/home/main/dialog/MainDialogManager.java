package com.tal.app.thinkacademy.business.home.main.dialog;

import com.tal.app.thinkacademy.business.home.main.MainActivity;
import com.tal.app.thinkacademy.business.home.main.api.HomeRepository;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.HWCoroutineScopeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R~\u0010\u0007\u001am\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012>\u0012<\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011R~\u0010\u0012\u001am\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012>\u0012<\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0001\u0010\u0017\u001as\u0012o\u0012m\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012>\u0012<\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u0018X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/dialog/MainDialogManager;", "", "activity", "Lcom/tal/app/thinkacademy/business/home/main/MainActivity;", "(Lcom/tal/app/thinkacademy/business/home/main/MainActivity;)V", "TAG", "", "checkUnpay", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "previous", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "next", "Lkotlin/jvm/functions/Function3;", "checkUpdate", "repository", "Lcom/tal/app/thinkacademy/business/home/main/api/HomeRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stack", "", "cancelChain", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startChain", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainDialogManager.kt */
public final class MainDialogManager {
    /* access modifiers changed from: private */
    public final String TAG = "MainDialogManager";
    /* access modifiers changed from: private */
    public final MainActivity activity;
    private final Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> checkUnpay;
    private final Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> checkUpdate;
    /* access modifiers changed from: private */
    public final HomeRepository repository = new HomeRepository();
    private CoroutineScope scope;
    private final List<Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object>> stack;

    public MainDialogManager(MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, "activity");
        this.activity = mainActivity;
        List<Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object>> arrayList = new ArrayList<>();
        this.stack = arrayList;
        Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> mainDialogManager$checkUpdate$1 = new MainDialogManager$checkUpdate$1(this, (Continuation<? super MainDialogManager$checkUpdate$1>) null);
        this.checkUpdate = mainDialogManager$checkUpdate$1;
        Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> mainDialogManager$checkUnpay$1 = new MainDialogManager$checkUnpay$1(this, (Continuation<? super MainDialogManager$checkUnpay$1>) null);
        this.checkUnpay = mainDialogManager$checkUnpay$1;
        arrayList.add(mainDialogManager$checkUpdate$1);
        arrayList.add(mainDialogManager$checkUnpay$1);
    }

    public final void startChain() {
        XesLog.dt(this.TAG, new Object[]{"startChain"});
        if (this.scope == null) {
            this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        }
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            HWCoroutineScopeKt.launchWithException(coroutineScope, new MainDialogManager$startChain$1(this), new MainDialogManager$startChain$2(this, (Continuation<? super MainDialogManager$startChain$2>) null));
        }
    }

    /* access modifiers changed from: private */
    public final Object next(boolean z, Continuation<? super Unit> continuation) {
        if (this.stack.size() <= 0) {
            return Unit.INSTANCE;
        }
        Object invoke = this.stack.remove(0).invoke(Boxing.boxBoolean(z), new MainDialogManager$next$2(this, (Continuation<? super MainDialogManager$next$2>) null), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    public final void cancelChain() {
        XesLog.dt(this.TAG, new Object[]{"cancelChain"});
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, "正常取消", (Throwable) null, 2, (Object) null);
        }
    }
}
