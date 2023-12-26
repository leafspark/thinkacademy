package com.tal.app.thinkacademy.live.business.redpackagerain.api;

import com.tal.app.thinkacademy.common.network.EmptyPostBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.GameResBean;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/api/GameResApi;", "", "getGamePackage", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/GameResBean;", "url", "", "body", "Lcom/tal/app/thinkacademy/common/network/EmptyPostBean;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameResApi.kt */
public interface GameResApi {
    @POST
    Call<HiResponse<GameResBean>> getGamePackage(@Url String str, @Body EmptyPostBean emptyPostBean);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameResApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call getGamePackage$default(GameResApi gameResApi, String str, EmptyPostBean emptyPostBean, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    emptyPostBean = new EmptyPostBean();
                }
                return gameResApi.getGamePackage(str, emptyPostBean);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGamePackage");
        }
    }
}
