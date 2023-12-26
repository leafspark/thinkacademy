package com.tal.app.thinkacademy.live.abilitypack.keyboardfill.listenbody;

import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillResult;
import com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene;
import com.tal.app.thinkacademy.live.business.keyboardfill.CommitScene;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0000H\u0016JS\u0010\u0011\u001a\u00020\b2K\u0010\u0012\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0004J\"\u0010\u0018\u001a\u00020\b2\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\nJS\u0010\u0019\u001a\u00020\b2K\u0010\u0012\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0004J\"\u0010\u001a\u001a\u00020\b2\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\nR(\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "onCheckErrorBlock", "Lkotlin/Function3;", "", "", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;", "", "onCheckResultBlock", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "onSubmitErrorBlock", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "onSubmitResultBlock", "dispatch", "listener", "onCheckError", "block", "Lkotlin/ParameterName;", "name", "code", "msg", "scene", "onCheckResult", "onSubmitError", "onSubmitResult", "CheckError", "CheckResult", "SubmitError", "SubmitResult", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillListenerBody.kt */
public class KeyboardFillListenerBody extends ListenerBody<KeyboardFillListenerBody> {
    private Function3<? super Integer, ? super String, ? super CheckScene, Unit> onCheckErrorBlock;
    private Function2<? super KeyboardFillResult, ? super CheckScene, Unit> onCheckResultBlock;
    private Function3<? super Integer, ? super String, ? super CommitScene, Unit> onSubmitErrorBlock;
    private Function2<? super KeyboardFillResult, ? super CommitScene, Unit> onSubmitResultBlock;

    public void dispatch(KeyboardFillListenerBody keyboardFillListenerBody) {
        Function3<? super Integer, ? super String, ? super CommitScene, Unit> function3;
        Intrinsics.checkNotNullParameter(keyboardFillListenerBody, "listener");
        if (keyboardFillListenerBody instanceof CheckResult) {
            Function2<? super KeyboardFillResult, ? super CheckScene, Unit> function2 = this.onCheckResultBlock;
            if (function2 != null) {
                CheckResult checkResult = (CheckResult) keyboardFillListenerBody;
                function2.invoke(checkResult.getResult(), checkResult.getScene());
            }
        } else if (keyboardFillListenerBody instanceof CheckError) {
            Function3<? super Integer, ? super String, ? super CheckScene, Unit> function32 = this.onCheckErrorBlock;
            if (function32 != null) {
                CheckError checkError = (CheckError) keyboardFillListenerBody;
                function32.invoke(Integer.valueOf(checkError.getCode()), checkError.getMsg(), checkError.getScene());
            }
        } else if (keyboardFillListenerBody instanceof SubmitResult) {
            Function2<? super KeyboardFillResult, ? super CommitScene, Unit> function22 = this.onSubmitResultBlock;
            if (function22 != null) {
                SubmitResult submitResult = (SubmitResult) keyboardFillListenerBody;
                function22.invoke(submitResult.getResult(), submitResult.getScene());
            }
        } else if ((keyboardFillListenerBody instanceof SubmitError) && (function3 = this.onSubmitErrorBlock) != null) {
            SubmitError submitError = (SubmitError) keyboardFillListenerBody;
            function3.invoke(Integer.valueOf(submitError.getCode()), submitError.getMsg(), submitError.getScene());
        }
    }

    public final void onCheckResult(Function2<? super KeyboardFillResult, ? super CheckScene, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.onCheckResultBlock = function2;
    }

    public final void onCheckError(Function3<? super Integer, ? super String, ? super CheckScene, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.onCheckErrorBlock = function3;
    }

    public final void onSubmitResult(Function2<? super KeyboardFillResult, ? super CommitScene, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.onSubmitResultBlock = function2;
    }

    public final void onSubmitError(Function3<? super Integer, ? super String, ? super CommitScene, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.onSubmitErrorBlock = function3;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody$CheckResult;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "result", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "scene", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;", "(Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;)V", "getResult", "()Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "getScene", "()Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KeyboardFillListenerBody.kt */
    public static final class CheckResult extends KeyboardFillListenerBody {
        private final KeyboardFillResult result;
        private final CheckScene scene;

        public static /* synthetic */ CheckResult copy$default(CheckResult checkResult, KeyboardFillResult keyboardFillResult, CheckScene checkScene, int i, Object obj) {
            if ((i & 1) != 0) {
                keyboardFillResult = checkResult.result;
            }
            if ((i & 2) != 0) {
                checkScene = checkResult.scene;
            }
            return checkResult.copy(keyboardFillResult, checkScene);
        }

        public final KeyboardFillResult component1() {
            return this.result;
        }

        public final CheckScene component2() {
            return this.scene;
        }

        public final CheckResult copy(KeyboardFillResult keyboardFillResult, CheckScene checkScene) {
            Intrinsics.checkNotNullParameter(checkScene, "scene");
            return new CheckResult(keyboardFillResult, checkScene);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CheckResult)) {
                return false;
            }
            CheckResult checkResult = (CheckResult) obj;
            return Intrinsics.areEqual(this.result, checkResult.result) && this.scene == checkResult.scene;
        }

        public int hashCode() {
            KeyboardFillResult keyboardFillResult = this.result;
            return ((keyboardFillResult == null ? 0 : keyboardFillResult.hashCode()) * 31) + this.scene.hashCode();
        }

        public String toString() {
            return "CheckResult(result=" + this.result + ", scene=" + this.scene + ')';
        }

        public CheckResult(KeyboardFillResult keyboardFillResult, CheckScene checkScene) {
            Intrinsics.checkNotNullParameter(checkScene, "scene");
            this.result = keyboardFillResult;
            this.scene = checkScene;
        }

        public final KeyboardFillResult getResult() {
            return this.result;
        }

        public final CheckScene getScene() {
            return this.scene;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody$CheckError;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "code", "", "msg", "", "scene", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;", "(ILjava/lang/String;Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getScene", "()Lcom/tal/app/thinkacademy/live/business/keyboardfill/CheckScene;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KeyboardFillListenerBody.kt */
    public static final class CheckError extends KeyboardFillListenerBody {
        private final int code;
        private final String msg;
        private final CheckScene scene;

        public static /* synthetic */ CheckError copy$default(CheckError checkError, int i, String str, CheckScene checkScene, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = checkError.code;
            }
            if ((i2 & 2) != 0) {
                str = checkError.msg;
            }
            if ((i2 & 4) != 0) {
                checkScene = checkError.scene;
            }
            return checkError.copy(i, str, checkScene);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final CheckScene component3() {
            return this.scene;
        }

        public final CheckError copy(int i, String str, CheckScene checkScene) {
            Intrinsics.checkNotNullParameter(str, "msg");
            Intrinsics.checkNotNullParameter(checkScene, "scene");
            return new CheckError(i, str, checkScene);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CheckError)) {
                return false;
            }
            CheckError checkError = (CheckError) obj;
            return this.code == checkError.code && Intrinsics.areEqual(this.msg, checkError.msg) && this.scene == checkError.scene;
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.scene.hashCode();
        }

        public String toString() {
            return "CheckError(code=" + this.code + ", msg=" + this.msg + ", scene=" + this.scene + ')';
        }

        public CheckError(int i, String str, CheckScene checkScene) {
            Intrinsics.checkNotNullParameter(str, "msg");
            Intrinsics.checkNotNullParameter(checkScene, "scene");
            this.code = i;
            this.msg = str;
            this.scene = checkScene;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final CheckScene getScene() {
            return this.scene;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody$SubmitResult;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "result", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "scene", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "(Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;)V", "getResult", "()Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "getScene", "()Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KeyboardFillListenerBody.kt */
    public static final class SubmitResult extends KeyboardFillListenerBody {
        private final KeyboardFillResult result;
        private final CommitScene scene;

        public static /* synthetic */ SubmitResult copy$default(SubmitResult submitResult, KeyboardFillResult keyboardFillResult, CommitScene commitScene, int i, Object obj) {
            if ((i & 1) != 0) {
                keyboardFillResult = submitResult.result;
            }
            if ((i & 2) != 0) {
                commitScene = submitResult.scene;
            }
            return submitResult.copy(keyboardFillResult, commitScene);
        }

        public final KeyboardFillResult component1() {
            return this.result;
        }

        public final CommitScene component2() {
            return this.scene;
        }

        public final SubmitResult copy(KeyboardFillResult keyboardFillResult, CommitScene commitScene) {
            Intrinsics.checkNotNullParameter(commitScene, "scene");
            return new SubmitResult(keyboardFillResult, commitScene);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubmitResult)) {
                return false;
            }
            SubmitResult submitResult = (SubmitResult) obj;
            return Intrinsics.areEqual(this.result, submitResult.result) && this.scene == submitResult.scene;
        }

        public int hashCode() {
            KeyboardFillResult keyboardFillResult = this.result;
            return ((keyboardFillResult == null ? 0 : keyboardFillResult.hashCode()) * 31) + this.scene.hashCode();
        }

        public String toString() {
            return "SubmitResult(result=" + this.result + ", scene=" + this.scene + ')';
        }

        public SubmitResult(KeyboardFillResult keyboardFillResult, CommitScene commitScene) {
            Intrinsics.checkNotNullParameter(commitScene, "scene");
            this.result = keyboardFillResult;
            this.scene = commitScene;
        }

        public final KeyboardFillResult getResult() {
            return this.result;
        }

        public final CommitScene getScene() {
            return this.scene;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody$SubmitError;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "code", "", "msg", "", "scene", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "(ILjava/lang/String;Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getScene", "()Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KeyboardFillListenerBody.kt */
    public static final class SubmitError extends KeyboardFillListenerBody {
        private final int code;
        private final String msg;
        private final CommitScene scene;

        public static /* synthetic */ SubmitError copy$default(SubmitError submitError, int i, String str, CommitScene commitScene, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = submitError.code;
            }
            if ((i2 & 2) != 0) {
                str = submitError.msg;
            }
            if ((i2 & 4) != 0) {
                commitScene = submitError.scene;
            }
            return submitError.copy(i, str, commitScene);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final CommitScene component3() {
            return this.scene;
        }

        public final SubmitError copy(int i, String str, CommitScene commitScene) {
            Intrinsics.checkNotNullParameter(str, "msg");
            Intrinsics.checkNotNullParameter(commitScene, "scene");
            return new SubmitError(i, str, commitScene);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubmitError)) {
                return false;
            }
            SubmitError submitError = (SubmitError) obj;
            return this.code == submitError.code && Intrinsics.areEqual(this.msg, submitError.msg) && this.scene == submitError.scene;
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.scene.hashCode();
        }

        public String toString() {
            return "SubmitError(code=" + this.code + ", msg=" + this.msg + ", scene=" + this.scene + ')';
        }

        public SubmitError(int i, String str, CommitScene commitScene) {
            Intrinsics.checkNotNullParameter(str, "msg");
            Intrinsics.checkNotNullParameter(commitScene, "scene");
            this.code = i;
            this.msg = str;
            this.scene = commitScene;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final CommitScene getScene() {
            return this.scene;
        }
    }
}
