package com.tal.app.thinkacademy.live.business.keyboardfill;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillResult;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.listenbody.KeyboardFillListenerBody;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillView;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/listenbody/KeyboardFillListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillDriver.kt */
final class KeyboardFillDriver$initObserver$1 extends Lambda implements Function1<KeyboardFillListenerBody, Unit> {
    final /* synthetic */ KeyboardFillDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyboardFillDriver$initObserver$1(KeyboardFillDriver keyboardFillDriver) {
        super(1);
        this.this$0 = keyboardFillDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardFillListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardFillListenerBody keyboardFillListenerBody) {
        Intrinsics.checkNotNullParameter(keyboardFillListenerBody, "$this$observeListener");
        final KeyboardFillDriver keyboardFillDriver = this.this$0;
        keyboardFillListenerBody.onCheckError(new Function3<Integer, String, CheckScene, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).intValue(), (String) obj2, (CheckScene) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, String str, CheckScene checkScene) {
                Intrinsics.checkNotNullParameter(str, "msg");
                Intrinsics.checkNotNullParameter(checkScene, "scene");
                XesLog.e(KeyboardFillDriver.TAG, "check接口异常 code:" + i + ", msg:" + str + ", scene:" + checkScene);
                if (checkScene == CheckScene.FirstLoad) {
                    XesLog.s(KeyboardFillDriver.TAG, "check接口异常，显示键盘");
                    KeyboardFillView access$getMKeyboardView$p = keyboardFillDriver.mKeyboardView;
                    if (access$getMKeyboardView$p != null) {
                        access$getMKeyboardView$p.show();
                    }
                }
            }
        });
        final KeyboardFillDriver keyboardFillDriver2 = this.this$0;
        keyboardFillListenerBody.onCheckResult(new Function2<KeyboardFillResult, CheckScene, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((KeyboardFillResult) obj, (CheckScene) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyboardFillResult keyboardFillResult, CheckScene checkScene) {
                Intrinsics.checkNotNullParameter(checkScene, "scene");
                if (keyboardFillResult != null) {
                    KeyboardFillDriver keyboardFillDriver = keyboardFillDriver2;
                    XesLog.s(KeyboardFillDriver.TAG, "check接口成功 " + checkScene + ", " + GsonUtils.toJson(keyboardFillResult));
                    if (checkScene == CheckScene.FirstLoad) {
                        InteractLogReport.uploadLog(keyboardFillDriver.mInteractId, keyboardFillDriver.mPlanId, keyboardFillDriver.mClassId);
                        CharSequence option = keyboardFillResult.getOption();
                        if (option == null || option.length() == 0) {
                            KeyboardFillView access$getMKeyboardView$p = keyboardFillDriver.mKeyboardView;
                            if (access$getMKeyboardView$p != null) {
                                access$getMKeyboardView$p.show();
                            }
                        } else {
                            keyboardFillDriver.mSubmit = true;
                            KeyboardFillView access$getMKeyboardView$p2 = keyboardFillDriver.mKeyboardView;
                            if (access$getMKeyboardView$p2 != null) {
                                access$getMKeyboardView$p2.setResult(keyboardFillResult.getOption());
                            }
                        }
                    }
                    if (checkScene == CheckScene.StopCommit) {
                        CharSequence option2 = keyboardFillResult.getOption();
                        if (!(option2 == null || option2.length() == 0)) {
                            keyboardFillDriver.mSubmit = true;
                            KeyboardFillView access$getMKeyboardView$p3 = keyboardFillDriver.mKeyboardView;
                            if (access$getMKeyboardView$p3 != null) {
                                access$getMKeyboardView$p3.setResult(keyboardFillResult.getOption());
                            }
                        }
                    }
                    if (!keyboardFillDriver.mGotCoins && keyboardFillResult.getAnswerStat() == 1) {
                        keyboardFillDriver.mGotCoins = true;
                        XesLog.s(KeyboardFillDriver.TAG, "check轮询，答题正确");
                        KeyboardFillView access$getMKeyboardView$p4 = keyboardFillDriver.mKeyboardView;
                        if (access$getMKeyboardView$p4 != null) {
                            access$getMKeyboardView$p4.showSuccess();
                        }
                        keyboardFillDriver.hideKeyboard(4000);
                        keyboardFillDriver.showCoinsToast(keyboardFillResult.getAddCoin(), keyboardFillResult.getUserTotalGold());
                    }
                }
            }
        });
        final KeyboardFillDriver keyboardFillDriver3 = this.this$0;
        keyboardFillListenerBody.onSubmitError(new Function3<Integer, String, CommitScene, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).intValue(), (String) obj2, (CommitScene) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, String str, CommitScene commitScene) {
                Intrinsics.checkNotNullParameter(str, "msg");
                Intrinsics.checkNotNullParameter(commitScene, "scene");
                XesLog.e(KeyboardFillDriver.TAG, "submit接口异常 code:" + i + ", msg:" + str + ", scene:" + commitScene);
                keyboardFillDriver3.showToastView(R.string.submit_failed);
            }
        });
        final KeyboardFillDriver keyboardFillDriver4 = this.this$0;
        keyboardFillListenerBody.onSubmitResult(new Function2<KeyboardFillResult, CommitScene, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((KeyboardFillResult) obj, (CommitScene) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyboardFillResult keyboardFillResult, CommitScene commitScene) {
                Intrinsics.checkNotNullParameter(commitScene, "scene");
                if (keyboardFillResult != null) {
                    KeyboardFillDriver keyboardFillDriver = keyboardFillDriver4;
                    XesLog.s(KeyboardFillDriver.TAG, "submit接口成功 " + commitScene + ", " + GsonUtils.toJson(keyboardFillResult));
                    keyboardFillDriver.mSubmit = true;
                    if (keyboardFillResult.getAnswerStat() == 1) {
                        keyboardFillDriver.mGotCoins = true;
                        XesLog.s(KeyboardFillDriver.TAG, "提交成功，答题正确");
                        KeyboardFillView access$getMKeyboardView$p = keyboardFillDriver.mKeyboardView;
                        if (access$getMKeyboardView$p != null) {
                            access$getMKeyboardView$p.showSuccess();
                        }
                        keyboardFillDriver.hideKeyboard(3800);
                        keyboardFillDriver.showCoinsToast(keyboardFillResult.getAddCoin(), keyboardFillResult.getUserTotalGold());
                        keyboardFillDriver.removePlugin(4000);
                        return;
                    }
                    KeyboardFillView access$getMKeyboardView$p2 = keyboardFillDriver.mKeyboardView;
                    if (access$getMKeyboardView$p2 != null) {
                        access$getMKeyboardView$p2.hide();
                    }
                    keyboardFillDriver.showToastView(R.string.submit_successfully);
                    if (commitScene == CommitScene.CloseCommit) {
                        keyboardFillDriver.removePlugin(0);
                    }
                }
            }
        });
    }
}
