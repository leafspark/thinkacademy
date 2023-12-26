package com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody;

import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableEndBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableShowRankListBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStartBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0006\u001f !\"#$B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0000H\u0016J\u001c\u0010\u0018\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u001c\u0010\u001a\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004J@\u0010\u001b\u001a\u00020\u000628\u0010\u0019\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\nJ\u001c\u0010\u001c\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004J\u001c\u0010\u001d\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00060\u0004J\u001c\u0010\u001e\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00060\u0004R\u001e\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000\u0001\u0006%&'()*¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "onGameOverBlock", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "", "onGameStartBlock", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "onGameSubmitErrorBlock", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "interactId", "", "duration", "onLoadBlock", "onRankListBlock", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "onUnloadBlock", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableEndBean;", "dispatch", "listener", "onGameOver", "block", "onGameStart", "onGameSubmitError", "onLoad", "onRankList", "onUnload", "GameOver", "GameStart", "GameSubmitError", "Load", "RankList", "UnLoad", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$Load;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$GameStart;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$GameSubmitError;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$GameOver;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$RankList;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$UnLoad;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableListenerBody.kt */
public abstract class SchulteTableListenerBody extends ListenerBody<SchulteTableListenerBody> {
    private Function1<? super SchulteTableUserDataBean, Unit> onGameOverBlock;
    private Function1<? super SchulteTableStartBean, Unit> onGameStartBlock;
    private Function2<? super String, ? super Float, Unit> onGameSubmitErrorBlock;
    private Function1<? super SchulteTableStartBean, Unit> onLoadBlock;
    private Function1<? super SchulteTableShowRankListBean, Unit> onRankListBlock;
    private Function1<? super SchulteTableEndBean, Unit> onUnloadBlock;

    public /* synthetic */ SchulteTableListenerBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SchulteTableListenerBody() {
    }

    public void dispatch(SchulteTableListenerBody schulteTableListenerBody) {
        Function1<? super SchulteTableEndBean, Unit> function1;
        Intrinsics.checkNotNullParameter(schulteTableListenerBody, "listener");
        if (schulteTableListenerBody instanceof Load) {
            Function1<? super SchulteTableStartBean, Unit> function12 = this.onLoadBlock;
            if (function12 != null) {
                function12.invoke(((Load) schulteTableListenerBody).getGameBean());
            }
        } else if (schulteTableListenerBody instanceof GameStart) {
            Function1<? super SchulteTableStartBean, Unit> function13 = this.onGameStartBlock;
            if (function13 != null) {
                function13.invoke(((GameStart) schulteTableListenerBody).getGameBean());
            }
        } else if (schulteTableListenerBody instanceof GameSubmitError) {
            Function2<? super String, ? super Float, Unit> function2 = this.onGameSubmitErrorBlock;
            if (function2 != null) {
                GameSubmitError gameSubmitError = (GameSubmitError) schulteTableListenerBody;
                function2.invoke(gameSubmitError.getInteractId(), Float.valueOf(gameSubmitError.getDuration()));
            }
        } else if (schulteTableListenerBody instanceof GameOver) {
            Function1<? super SchulteTableUserDataBean, Unit> function14 = this.onGameOverBlock;
            if (function14 != null) {
                function14.invoke(((GameOver) schulteTableListenerBody).getResultBean());
            }
        } else if (schulteTableListenerBody instanceof RankList) {
            Function1<? super SchulteTableShowRankListBean, Unit> function15 = this.onRankListBlock;
            if (function15 != null) {
                function15.invoke(((RankList) schulteTableListenerBody).getRankListBean());
            }
        } else if ((schulteTableListenerBody instanceof UnLoad) && (function1 = this.onUnloadBlock) != null) {
            function1.invoke(((UnLoad) schulteTableListenerBody).getEndBean());
        }
    }

    public final void onLoad(Function1<? super SchulteTableStartBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onLoadBlock = function1;
    }

    public final void onGameStart(Function1<? super SchulteTableStartBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onGameStartBlock = function1;
    }

    public final void onGameSubmitError(Function2<? super String, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.onGameSubmitErrorBlock = function2;
    }

    public final void onGameOver(Function1<? super SchulteTableUserDataBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onGameOverBlock = function1;
    }

    public final void onRankList(Function1<? super SchulteTableShowRankListBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onRankListBlock = function1;
    }

    public final void onUnload(Function1<? super SchulteTableEndBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onUnloadBlock = function1;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$Load;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "gameBean", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "(Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;)V", "getGameBean", "()Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableListenerBody.kt */
    public static final class Load extends SchulteTableListenerBody {
        private final SchulteTableStartBean gameBean;

        public static /* synthetic */ Load copy$default(Load load, SchulteTableStartBean schulteTableStartBean, int i, Object obj) {
            if ((i & 1) != 0) {
                schulteTableStartBean = load.gameBean;
            }
            return load.copy(schulteTableStartBean);
        }

        public final SchulteTableStartBean component1() {
            return this.gameBean;
        }

        public final Load copy(SchulteTableStartBean schulteTableStartBean) {
            return new Load(schulteTableStartBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Load) && Intrinsics.areEqual(this.gameBean, ((Load) obj).gameBean);
        }

        public int hashCode() {
            SchulteTableStartBean schulteTableStartBean = this.gameBean;
            if (schulteTableStartBean == null) {
                return 0;
            }
            return schulteTableStartBean.hashCode();
        }

        public String toString() {
            return "Load(gameBean=" + this.gameBean + ')';
        }

        public Load(SchulteTableStartBean schulteTableStartBean) {
            super((DefaultConstructorMarker) null);
            this.gameBean = schulteTableStartBean;
        }

        public final SchulteTableStartBean getGameBean() {
            return this.gameBean;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$GameStart;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "gameBean", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "(Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;)V", "getGameBean", "()Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableListenerBody.kt */
    public static final class GameStart extends SchulteTableListenerBody {
        private final SchulteTableStartBean gameBean;

        public static /* synthetic */ GameStart copy$default(GameStart gameStart, SchulteTableStartBean schulteTableStartBean, int i, Object obj) {
            if ((i & 1) != 0) {
                schulteTableStartBean = gameStart.gameBean;
            }
            return gameStart.copy(schulteTableStartBean);
        }

        public final SchulteTableStartBean component1() {
            return this.gameBean;
        }

        public final GameStart copy(SchulteTableStartBean schulteTableStartBean) {
            Intrinsics.checkNotNullParameter(schulteTableStartBean, "gameBean");
            return new GameStart(schulteTableStartBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GameStart) && Intrinsics.areEqual(this.gameBean, ((GameStart) obj).gameBean);
        }

        public int hashCode() {
            return this.gameBean.hashCode();
        }

        public String toString() {
            return "GameStart(gameBean=" + this.gameBean + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GameStart(SchulteTableStartBean schulteTableStartBean) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(schulteTableStartBean, "gameBean");
            this.gameBean = schulteTableStartBean;
        }

        public final SchulteTableStartBean getGameBean() {
            return this.gameBean;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$GameSubmitError;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "interactId", "", "duration", "", "(Ljava/lang/String;F)V", "getDuration", "()F", "getInteractId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableListenerBody.kt */
    public static final class GameSubmitError extends SchulteTableListenerBody {
        private final float duration;
        private final String interactId;

        public static /* synthetic */ GameSubmitError copy$default(GameSubmitError gameSubmitError, String str, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gameSubmitError.interactId;
            }
            if ((i & 2) != 0) {
                f = gameSubmitError.duration;
            }
            return gameSubmitError.copy(str, f);
        }

        public final String component1() {
            return this.interactId;
        }

        public final float component2() {
            return this.duration;
        }

        public final GameSubmitError copy(String str, float f) {
            return new GameSubmitError(str, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GameSubmitError)) {
                return false;
            }
            GameSubmitError gameSubmitError = (GameSubmitError) obj;
            return Intrinsics.areEqual(this.interactId, gameSubmitError.interactId) && Intrinsics.areEqual(Float.valueOf(this.duration), Float.valueOf(gameSubmitError.duration));
        }

        public int hashCode() {
            String str = this.interactId;
            return ((str == null ? 0 : str.hashCode()) * 31) + Float.floatToIntBits(this.duration);
        }

        public String toString() {
            return "GameSubmitError(interactId=" + this.interactId + ", duration=" + this.duration + ')';
        }

        public final float getDuration() {
            return this.duration;
        }

        public final String getInteractId() {
            return this.interactId;
        }

        public GameSubmitError(String str, float f) {
            super((DefaultConstructorMarker) null);
            this.interactId = str;
            this.duration = f;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$GameOver;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "resultBean", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "(Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;)V", "getResultBean", "()Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableListenerBody.kt */
    public static final class GameOver extends SchulteTableListenerBody {
        private final SchulteTableUserDataBean resultBean;

        public static /* synthetic */ GameOver copy$default(GameOver gameOver, SchulteTableUserDataBean schulteTableUserDataBean, int i, Object obj) {
            if ((i & 1) != 0) {
                schulteTableUserDataBean = gameOver.resultBean;
            }
            return gameOver.copy(schulteTableUserDataBean);
        }

        public final SchulteTableUserDataBean component1() {
            return this.resultBean;
        }

        public final GameOver copy(SchulteTableUserDataBean schulteTableUserDataBean) {
            Intrinsics.checkNotNullParameter(schulteTableUserDataBean, "resultBean");
            return new GameOver(schulteTableUserDataBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GameOver) && Intrinsics.areEqual(this.resultBean, ((GameOver) obj).resultBean);
        }

        public int hashCode() {
            return this.resultBean.hashCode();
        }

        public String toString() {
            return "GameOver(resultBean=" + this.resultBean + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GameOver(SchulteTableUserDataBean schulteTableUserDataBean) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(schulteTableUserDataBean, "resultBean");
            this.resultBean = schulteTableUserDataBean;
        }

        public final SchulteTableUserDataBean getResultBean() {
            return this.resultBean;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$RankList;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "rankListBean", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "(Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;)V", "getRankListBean", "()Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableListenerBody.kt */
    public static final class RankList extends SchulteTableListenerBody {
        private final SchulteTableShowRankListBean rankListBean;

        public static /* synthetic */ RankList copy$default(RankList rankList, SchulteTableShowRankListBean schulteTableShowRankListBean, int i, Object obj) {
            if ((i & 1) != 0) {
                schulteTableShowRankListBean = rankList.rankListBean;
            }
            return rankList.copy(schulteTableShowRankListBean);
        }

        public final SchulteTableShowRankListBean component1() {
            return this.rankListBean;
        }

        public final RankList copy(SchulteTableShowRankListBean schulteTableShowRankListBean) {
            Intrinsics.checkNotNullParameter(schulteTableShowRankListBean, "rankListBean");
            return new RankList(schulteTableShowRankListBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RankList) && Intrinsics.areEqual(this.rankListBean, ((RankList) obj).rankListBean);
        }

        public int hashCode() {
            return this.rankListBean.hashCode();
        }

        public String toString() {
            return "RankList(rankListBean=" + this.rankListBean + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RankList(SchulteTableShowRankListBean schulteTableShowRankListBean) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(schulteTableShowRankListBean, "rankListBean");
            this.rankListBean = schulteTableShowRankListBean;
        }

        public final SchulteTableShowRankListBean getRankListBean() {
            return this.rankListBean;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody$UnLoad;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "endBean", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableEndBean;", "(Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableEndBean;)V", "getEndBean", "()Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableEndBean;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableListenerBody.kt */
    public static final class UnLoad extends SchulteTableListenerBody {
        private final SchulteTableEndBean endBean;

        public static /* synthetic */ UnLoad copy$default(UnLoad unLoad, SchulteTableEndBean schulteTableEndBean, int i, Object obj) {
            if ((i & 1) != 0) {
                schulteTableEndBean = unLoad.endBean;
            }
            return unLoad.copy(schulteTableEndBean);
        }

        public final SchulteTableEndBean component1() {
            return this.endBean;
        }

        public final UnLoad copy(SchulteTableEndBean schulteTableEndBean) {
            Intrinsics.checkNotNullParameter(schulteTableEndBean, "endBean");
            return new UnLoad(schulteTableEndBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnLoad) && Intrinsics.areEqual(this.endBean, ((UnLoad) obj).endBean);
        }

        public int hashCode() {
            return this.endBean.hashCode();
        }

        public String toString() {
            return "UnLoad(endBean=" + this.endBean + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnLoad(SchulteTableEndBean schulteTableEndBean) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(schulteTableEndBean, "endBean");
            this.endBean = schulteTableEndBean;
        }

        public final SchulteTableEndBean getEndBean() {
            return this.endBean;
        }
    }
}
