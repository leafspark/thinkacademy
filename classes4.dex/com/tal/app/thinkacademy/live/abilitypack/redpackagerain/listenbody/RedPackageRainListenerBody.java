package com.tal.app.thinkacademy.live.abilitypack.redpackagerain.listenbody;

import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0007#$%&'()B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0000H\u0016JB\u0010\u001b\u001a\u00020\u000b2:\u0010\u001c\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004J\u0014\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\u0014\u0010\u001e\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\u0014\u0010\u001f\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJB\u0010 \u001a\u00020\u000b2:\u0010\u001c\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0004JB\u0010!\u001a\u00020\u000b2:\u0010\u001c\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u0004J\u0014\u0010\"\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\rRD\u0010\u0003\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000RD\u0010\u0010\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000RD\u0010\u0015\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000\u0001\u0007*+,-./0¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "coinSettlementMessageAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "interactId", "", "coin", "", "destroyDowngradeMessageAction", "Lkotlin/Function0;", "gameEndMessageAction", "getGameCoinMessageAction", "loadDowngradeMessageAction", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "redPackageRainMsgBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;", "redPackageRainDowngradeStatus", "loadGameMessageAction", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "redPackageRainResBean", "playGameMessageAction", "dispatch", "listener", "onCoinSettlementMessage", "action", "onDestroyDowngradeMessage", "onGameEndMessage", "onGetGameCoinMessage", "onLoadDowngradeMessage", "onLoadGameMessage", "onPlayGameMessage", "CoinSettlementMessage", "DestroyDowngradeMessage", "GameEndMessage", "GetGameCoinMessage", "LoadDowngradeMessage", "LoadGameMessage", "PlayGameMessage", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$LoadGameMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$PlayGameMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$GetGameCoinMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$GameEndMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$CoinSettlementMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$LoadDowngradeMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$DestroyDowngradeMessage;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainListenerBody.kt */
public abstract class RedPackageRainListenerBody extends ListenerBody<RedPackageRainListenerBody> {
    private Function2<? super String, ? super Integer, Unit> coinSettlementMessageAction;
    private Function0<Unit> destroyDowngradeMessageAction;
    private Function0<Unit> gameEndMessageAction;
    private Function0<Unit> getGameCoinMessageAction;
    private Function2<? super RedPackageRainMsgBean, ? super RedPackageRainDowngradeStatus, Unit> loadDowngradeMessageAction;
    private Function2<? super RedPackageRainMsgBean, ? super RedPackageRainResBean, Unit> loadGameMessageAction;
    private Function0<Unit> playGameMessageAction;

    public /* synthetic */ RedPackageRainListenerBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RedPackageRainListenerBody() {
    }

    public void dispatch(RedPackageRainListenerBody redPackageRainListenerBody) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(redPackageRainListenerBody, "listener");
        if (redPackageRainListenerBody instanceof LoadGameMessage) {
            Function2<? super RedPackageRainMsgBean, ? super RedPackageRainResBean, Unit> function2 = this.loadGameMessageAction;
            if (function2 != null) {
                LoadGameMessage loadGameMessage = (LoadGameMessage) redPackageRainListenerBody;
                function2.invoke(loadGameMessage.getRedPackageRainMsgBean(), loadGameMessage.getRedPackageRainResBean());
            }
        } else if (redPackageRainListenerBody instanceof PlayGameMessage) {
            Function0<Unit> function02 = this.playGameMessageAction;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (redPackageRainListenerBody instanceof GetGameCoinMessage) {
            Function0<Unit> function03 = this.getGameCoinMessageAction;
            if (function03 != null) {
                function03.invoke();
            }
        } else if (redPackageRainListenerBody instanceof GameEndMessage) {
            Function0<Unit> function04 = this.gameEndMessageAction;
            if (function04 != null) {
                function04.invoke();
            }
        } else if (redPackageRainListenerBody instanceof CoinSettlementMessage) {
            Function2<? super String, ? super Integer, Unit> function22 = this.coinSettlementMessageAction;
            if (function22 != null) {
                CoinSettlementMessage coinSettlementMessage = (CoinSettlementMessage) redPackageRainListenerBody;
                function22.invoke(coinSettlementMessage.getInteractId(), coinSettlementMessage.getCoin());
            }
        } else if (redPackageRainListenerBody instanceof LoadDowngradeMessage) {
            Function2<? super RedPackageRainMsgBean, ? super RedPackageRainDowngradeStatus, Unit> function23 = this.loadDowngradeMessageAction;
            if (function23 != null) {
                LoadDowngradeMessage loadDowngradeMessage = (LoadDowngradeMessage) redPackageRainListenerBody;
                function23.invoke(loadDowngradeMessage.getRedPackageRainMsgBean(), loadDowngradeMessage.getRedPackageRainDowngradeStatus());
            }
        } else if ((redPackageRainListenerBody instanceof DestroyDowngradeMessage) && (function0 = this.destroyDowngradeMessageAction) != null) {
            function0.invoke();
        }
    }

    public final void onLoadGameMessage(Function2<? super RedPackageRainMsgBean, ? super RedPackageRainResBean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.loadGameMessageAction = function2;
    }

    public final void onPlayGameMessage(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.playGameMessageAction = function0;
    }

    public final void onGetGameCoinMessage(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.getGameCoinMessageAction = function0;
    }

    public final void onGameEndMessage(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.gameEndMessageAction = function0;
    }

    public final void onCoinSettlementMessage(Function2<? super String, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.coinSettlementMessageAction = function2;
    }

    public final void onLoadDowngradeMessage(Function2<? super RedPackageRainMsgBean, ? super RedPackageRainDowngradeStatus, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.loadDowngradeMessageAction = function2;
    }

    public final void onDestroyDowngradeMessage(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.destroyDowngradeMessageAction = function0;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$LoadGameMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "redPackageRainMsgBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "redPackageRainResBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;)V", "getRedPackageRainMsgBean", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "setRedPackageRainMsgBean", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;)V", "getRedPackageRainResBean", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "setRedPackageRainResBean", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class LoadGameMessage extends RedPackageRainListenerBody {
        private RedPackageRainMsgBean redPackageRainMsgBean;
        private RedPackageRainResBean redPackageRainResBean;

        public final RedPackageRainMsgBean getRedPackageRainMsgBean() {
            return this.redPackageRainMsgBean;
        }

        public final void setRedPackageRainMsgBean(RedPackageRainMsgBean redPackageRainMsgBean2) {
            this.redPackageRainMsgBean = redPackageRainMsgBean2;
        }

        public final RedPackageRainResBean getRedPackageRainResBean() {
            return this.redPackageRainResBean;
        }

        public final void setRedPackageRainResBean(RedPackageRainResBean redPackageRainResBean2) {
            this.redPackageRainResBean = redPackageRainResBean2;
        }

        public LoadGameMessage(RedPackageRainMsgBean redPackageRainMsgBean2, RedPackageRainResBean redPackageRainResBean2) {
            super((DefaultConstructorMarker) null);
            this.redPackageRainMsgBean = redPackageRainMsgBean2;
            this.redPackageRainResBean = redPackageRainResBean2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$PlayGameMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "()V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class PlayGameMessage extends RedPackageRainListenerBody {
        public PlayGameMessage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$GetGameCoinMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "()V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class GetGameCoinMessage extends RedPackageRainListenerBody {
        public GetGameCoinMessage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$GameEndMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "()V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class GameEndMessage extends RedPackageRainListenerBody {
        public GameEndMessage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$CoinSettlementMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "interactId", "", "coin", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCoin", "()Ljava/lang/Integer;", "setCoin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInteractId", "()Ljava/lang/String;", "setInteractId", "(Ljava/lang/String;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class CoinSettlementMessage extends RedPackageRainListenerBody {
        private Integer coin;
        private String interactId;

        public final Integer getCoin() {
            return this.coin;
        }

        public final String getInteractId() {
            return this.interactId;
        }

        public final void setCoin(Integer num) {
            this.coin = num;
        }

        public final void setInteractId(String str) {
            this.interactId = str;
        }

        public CoinSettlementMessage(String str, Integer num) {
            super((DefaultConstructorMarker) null);
            this.interactId = str;
            this.coin = num;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$LoadDowngradeMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "redPackageRainMsgBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "redPackageRainDowngradeStatus", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;)V", "getRedPackageRainDowngradeStatus", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;", "setRedPackageRainDowngradeStatus", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;)V", "getRedPackageRainMsgBean", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "setRedPackageRainMsgBean", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class LoadDowngradeMessage extends RedPackageRainListenerBody {
        private RedPackageRainDowngradeStatus redPackageRainDowngradeStatus;
        private RedPackageRainMsgBean redPackageRainMsgBean;

        public final RedPackageRainMsgBean getRedPackageRainMsgBean() {
            return this.redPackageRainMsgBean;
        }

        public final void setRedPackageRainMsgBean(RedPackageRainMsgBean redPackageRainMsgBean2) {
            this.redPackageRainMsgBean = redPackageRainMsgBean2;
        }

        public final RedPackageRainDowngradeStatus getRedPackageRainDowngradeStatus() {
            return this.redPackageRainDowngradeStatus;
        }

        public final void setRedPackageRainDowngradeStatus(RedPackageRainDowngradeStatus redPackageRainDowngradeStatus2) {
            this.redPackageRainDowngradeStatus = redPackageRainDowngradeStatus2;
        }

        public LoadDowngradeMessage(RedPackageRainMsgBean redPackageRainMsgBean2, RedPackageRainDowngradeStatus redPackageRainDowngradeStatus2) {
            super((DefaultConstructorMarker) null);
            this.redPackageRainMsgBean = redPackageRainMsgBean2;
            this.redPackageRainDowngradeStatus = redPackageRainDowngradeStatus2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody$DestroyDowngradeMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "()V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainListenerBody.kt */
    public static final class DestroyDowngradeMessage extends RedPackageRainListenerBody {
        public DestroyDowngradeMessage() {
            super((DefaultConstructorMarker) null);
        }
    }
}
