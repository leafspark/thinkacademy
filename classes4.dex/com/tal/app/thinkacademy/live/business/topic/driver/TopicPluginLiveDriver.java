package com.tal.app.thinkacademy.live.business.topic.driver;

import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.LiveStabilityUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.commui.wheel.timer.MessageHandler;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.topic.IActionListenter;
import com.tal.app.thinkacademy.live.business.topic.api.TopicApi;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.business.topic.bean.request.SubmitAnswerRequest;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;

@PluginAnnotation(desc = "互动题插件", ircType = {"interact", "interact_f", "mode"}, moduleId = "214")
@ViewLevels({@ViewLevel(level = 10, name = "interact")})
public class TopicPluginLiveDriver extends BaseTopicPluginDriver implements IActionListenter {
    private static final String TAG = "TopicPluginLiveDriver";

    /* access modifiers changed from: protected */
    public IActionListenter initIActionListener() {
        return this;
    }

    public TopicPluginLiveDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }

    public void submitAnswer(List<List<String>> list, int i, boolean z) {
        List<List<String>> list2 = list;
        int i2 = i;
        final boolean z2 = z;
        boolean z3 = true;
        XesLog.i(Tag.TOPIC, "准备提交 isStopAnswer = " + z2 + " isRight = " + i2 + " interactId = " + this.interactId);
        if (this.isSubmitting) {
            XesLog.i(Tag.TOPIC, "已提交过，不再提交");
            if (z2) {
                XesLog.i(Tag.TOPIC, "是停止答题，且已提交过，销毁插件");
                removePlugin(MessageHandler.WHAT_ITEM_SELECTED);
                return;
            }
            return;
        }
        XesLog.i(Tag.TOPIC, "开始提交");
        this.isSubmitting = true;
        SoundPoolUtils.play(this.mContext, R.raw.live_business_choice_submit, 0);
        ArrayList arrayList = null;
        if (list2 != null) {
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                for (int i4 = 0; i4 < list2.get(i3).size(); i4++) {
                    if ("TRUE".equalsIgnoreCase((String) list2.get(i3).get(i4))) {
                        arrayList.add("T");
                    } else if ("FALSE".equalsIgnoreCase((String) list2.get(i3).get(i4))) {
                        arrayList.add("F");
                    } else {
                        arrayList.add((String) list2.get(i3).get(i4));
                    }
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        if (i2 != 1) {
            z3 = false;
        }
        HWEventTracking.get().ostaIaBaseInteractionSubmit(this.interactId, this.QUESTION_TYPE_TRACK, z3);
        SoundPoolUtils.play(this.mContext, R.raw.live_business_choice_submit, 0);
        Call<HiResponse<AnswerBean>> submitAnswer = ((TopicApi) Api.create(TopicApi.class)).submitAnswer(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/question/student/submit", new SubmitAnswerRequest(this.planId, this.classId, this.interactId, this.questionId, arrayList2, i, this.userInfoProxy.getNickName(), (GameJsSubmitData) null));
        AnonymousClass2 r2 = new OmyCallback<HiResponse<AnswerBean>>(new IError() {
            public void onFail(int i, String str) {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "提交接口fail " + TopicPluginLiveDriver.this.interactId);
                ToastUtils.showShort(R.string.net_fail);
                if (TopicPluginLiveDriver.this.topicPluginView != null) {
                    TopicPluginLiveDriver.this.topicPluginView.showAnswerView(z2);
                }
                String str2 = TopicPluginLiveDriver.this.QUESTION_TYPE;
                String str3 = TopicPluginLiveDriver.this.interactId;
                LiveStabilityUtils.live_stability_track(str2, str3, "submit", 0, i + " : " + str);
            }

            public void onError(int i, String str) {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "提交接口error " + TopicPluginLiveDriver.this.interactId);
                if (TopicPluginLiveDriver.this.topicPluginView != null) {
                    TopicPluginLiveDriver.this.topicPluginView.showAnswerView(z2);
                }
                String str2 = TopicPluginLiveDriver.this.QUESTION_TYPE;
                String str3 = TopicPluginLiveDriver.this.interactId;
                LiveStabilityUtils.live_stability_track(str2, str3, "submit", 0, i + " : " + str);
            }
        }) {
            public void onSuccess(HiResponse<AnswerBean> hiResponse) {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "提交接口成功 " + TopicPluginLiveDriver.this.interactId);
                AnswerBean data = hiResponse.getData();
                if (data != null) {
                    TopicPluginLiveDriver.this.updateUserLevel(data.getLevel());
                    if (TopicPluginLiveDriver.this.topicPluginView != null) {
                        TopicPluginLiveDriver.this.topicPluginView.setAnswerBean(data);
                        TopicPluginLiveDriver.this.topicPluginView.showAnswerView(z2);
                    }
                    TopicPluginLiveDriver.this.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(data.getUserLatestCoin());
                    LiveStabilityUtils.live_stability_track(TopicPluginLiveDriver.this.QUESTION_TYPE, TopicPluginLiveDriver.this.interactId, "submit", 1, "");
                }
            }
        };
        if (!(submitAnswer instanceof Call)) {
            submitAnswer.enqueue(r2);
        } else {
            Retrofit2Instrumentation.enqueue((Call) submitAnswer, r2);
        }
    }

    public void updateUserCoins(int i, int i2) {
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.USERCOINS_KEY, i + "", new CoinEventData(GoldSource.TOPIC_GOLD, i2, true, true)));
    }

    public void updateUserLevel(int i) {
        PluginEventBus.onEvent(DataBusKey.LEVEL_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.LEVEL_KEY, String.valueOf(i)));
    }
}
