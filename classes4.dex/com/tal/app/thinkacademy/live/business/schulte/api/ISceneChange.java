package com.tal.app.thinkacademy.live.business.schulte.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/api/ISceneChange;", "", "destroy", "", "hide", "end", "Lkotlin/Function0;", "show", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISceneChange.kt */
public interface ISceneChange {
    void destroy();

    void hide(Function0<Unit> function0);

    void show(Function0<Unit> function0);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ISceneChange.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void show$default(ISceneChange iSceneChange, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function0 = null;
                }
                iSceneChange.show(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }

        public static /* synthetic */ void hide$default(ISceneChange iSceneChange, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function0 = null;
                }
                iSceneChange.hide(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
    }
}
