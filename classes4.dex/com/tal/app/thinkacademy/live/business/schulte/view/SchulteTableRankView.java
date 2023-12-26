package com.tal.app.thinkacademy.live.business.schulte.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.schulte.adapter.SchulteRankListAdapter;
import com.tal.app.thinkacademy.live.business.schulte.api.ISceneChange;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableRankListUserDataBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableShowRankListBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aH\u0016J\u001a\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0003J\b\u0010!\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableRankView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tal/app/thinkacademy/live/business/schulte/api/ISceneChange;", "context", "Landroid/content/Context;", "rankList", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;)V", "layoutBoard", "Landroid/view/View;", "layoutFlags", "layoutSelf", "lottieHorn", "Lcom/airbnb/lottie/LottieAnimationView;", "mAdapter", "Lcom/tal/app/thinkacademy/live/business/schulte/adapter/SchulteRankListAdapter;", "mRankListView", "Landroidx/recyclerview/widget/RecyclerView;", "mScrollRunnable", "Ljava/lang/Runnable;", "tvBestTime", "Landroid/widget/TextView;", "destroy", "", "hide", "end", "Lkotlin/Function0;", "show", "showSelf", "myNumber", "", "selfData", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableRankListUserDataBean;", "stopScroll", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableRankView.kt */
public final class SchulteTableRankView extends ConstraintLayout implements ISceneChange {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "排行榜页";
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.SCHULTE_TABLE;
    private View layoutBoard;
    private final View layoutFlags;
    private View layoutSelf;
    private final LottieAnimationView lottieHorn;
    private final SchulteRankListAdapter mAdapter;
    private final RecyclerView mRankListView;
    private Runnable mScrollRunnable;
    private final TextView tvBestTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTableRankView(Context context, SchulteTableShowRankListBean schulteTableShowRankListBean) {
        super(context);
        SchulteTableRankListUserDataBean schulteTableRankListUserDataBean;
        int i;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(schulteTableShowRankListBean, "rankList");
        XesLog.i(TAG, SUB_TAG, "初始化布局");
        setAlpha(0.0f);
        LayoutInflater from = LayoutInflater.from(context);
        int i2 = R.layout.layout_schulte_table_rank;
        ViewGroup viewGroup = (ViewGroup) this;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i2, viewGroup, true);
        } else {
            XMLParseInstrumentation.inflate(from, i2, viewGroup, true);
        }
        RecyclerView findViewById = findViewById(R.id.rv_rank);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rv_rank)");
        this.mRankListView = findViewById;
        View findViewById2 = findViewById(R.id.tv_rank_join);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_rank_join)");
        this.tvBestTime = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.layout_rank_flags);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_rank_flags)");
        this.layoutFlags = findViewById3;
        LottieAnimationView findViewById4 = findViewById(R.id.lottie_rank_horn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.lottie_rank_horn)");
        this.lottieHorn = findViewById4;
        View findViewById5 = findViewById(R.id.layout_rank_board);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.layout_rank_board)");
        this.layoutBoard = findViewById5;
        View findViewById6 = findViewById(R.id.layout_rank_self);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.layout_rank_self)");
        this.layoutSelf = findViewById6;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List<SchulteTableRankListUserDataBean> rankList = schulteTableShowRankListBean.getRankList();
        if (rankList == null) {
            i = 0;
            schulteTableRankListUserDataBean = null;
        } else {
            int i3 = 0;
            i = 0;
            schulteTableRankListUserDataBean = null;
            for (Object next : rankList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SchulteTableRankListUserDataBean schulteTableRankListUserDataBean2 = (SchulteTableRankListUserDataBean) next;
                Integer showTopNum = schulteTableShowRankListBean.getShowTopNum();
                if (i3 < (showTopNum == null ? 0 : showTopNum.intValue())) {
                    if (i3 < 3) {
                        arrayList.add(schulteTableRankListUserDataBean2);
                    } else {
                        arrayList2.add(schulteTableRankListUserDataBean2);
                    }
                }
                if (schulteTableRankListUserDataBean == null && schulteTableRankListUserDataBean2.getUserId() != null) {
                    String userId = schulteTableRankListUserDataBean2.getUserId();
                    UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                    if (Intrinsics.areEqual(userId, userInfoEntity == null ? null : userInfoEntity.getUid())) {
                        schulteTableRankListUserDataBean = schulteTableRankListUserDataBean2;
                        i = i4;
                    }
                }
                i3 = i4;
            }
        }
        Tag tag = TAG;
        XesLogTag xesLogTag = tag;
        Object[] objArr = new Object[2];
        objArr[0] = SUB_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("总上榜人数：");
        List<SchulteTableRankListUserDataBean> rankList2 = schulteTableShowRankListBean.getRankList();
        sb.append(rankList2 == null ? null : Integer.valueOf(rankList2.size()));
        sb.append("，tops榜人数：");
        sb.append(arrayList.size());
        sb.append("，普通榜人数：");
        sb.append(arrayList2.size());
        objArr[1] = sb.toString();
        XesLog.i(xesLogTag, objArr);
        RecyclerView.Adapter schulteRankListAdapter = new SchulteRankListAdapter(arrayList2);
        this.mAdapter = schulteRankListAdapter;
        BaseQuickAdapter.addHeaderView$default((BaseQuickAdapter) schulteRankListAdapter, new SchulteTableRankTopView(context2, arrayList, arrayList2.size() == 0), 0, 0, 6, (Object) null);
        this.mRankListView.setAdapter(schulteRankListAdapter);
        if (i > 0) {
            XesLog.i(tag, SUB_TAG, Intrinsics.stringPlus("用户已参与，名次：", Integer.valueOf(i)));
            this.tvBestTime.setVisibility(0);
            showSelf(i, schulteTableRankListUserDataBean);
            this.layoutSelf.setVisibility(0);
            Integer showTopNum2 = schulteTableShowRankListBean.getShowTopNum();
            if (i <= (showTopNum2 == null ? 0 : showTopNum2.intValue())) {
                XesLog.i(tag, SUB_TAG, "用户上榜");
                this.tvBestTime.setBackgroundResource(R.drawable.ic_schulte_table_rank_join_up);
                this.tvBestTime.setText(R.string.schulte_table_rank_congratulations);
                this.lottieHorn.setVisibility(0);
                this.layoutFlags.setVisibility(0);
            } else {
                XesLog.i(tag, SUB_TAG, "用户未上榜");
                this.tvBestTime.setBackgroundResource(R.drawable.ic_schulte_table_rank_join);
                this.tvBestTime.setText(R.string.schulte_table_rank_un_congratulations);
            }
        } else {
            this.tvBestTime.setVisibility(8);
            XesLog.i(tag, SUB_TAG, "用户未参与");
        }
        this.mRankListView.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            final /* synthetic */ SchulteTableRankView this$0;

            {
                this.this$0 = r1;
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                XesLog.i(SchulteTableRankView.TAG, SchulteTableRankView.SUB_TAG, Intrinsics.stringPlus("onScrollStateChanged ", Integer.valueOf(i)));
                if (i == 1) {
                    this.this$0.stopScroll();
                }
            }
        });
        XesLog.i(tag, SUB_TAG, "初始化完成");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableRankView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableRankView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void show(Function0<Unit> function0) {
        Tag tag = TAG;
        XesLog.i(tag, SUB_TAG, "显示");
        SoundPoolUtils.playSameTime(getContext(), R.raw.live_business_schulte_rank, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.layoutFlags, View.TRANSLATION_Y, new float[]{0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400);
        animatorSet.play(ofFloat2).after(ofFloat);
        animatorSet.start();
        this.lottieHorn.playAnimation();
        Runnable runnable = this.mScrollRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            return;
        }
        SchulteTableRankView$$ExternalSyntheticLambda0 schulteTableRankView$$ExternalSyntheticLambda0 = new SchulteTableRankView$$ExternalSyntheticLambda0(this);
        this.mScrollRunnable = schulteTableRankView$$ExternalSyntheticLambda0;
        postDelayed(schulteTableRankView$$ExternalSyntheticLambda0, 1000);
        XesLog.i(tag, SUB_TAG, "开始自滚动");
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-1  reason: not valid java name */
    public static final void m433show$lambda1(SchulteTableRankView schulteTableRankView) {
        Intrinsics.checkNotNullParameter(schulteTableRankView, "this$0");
        if (schulteTableRankView.mRankListView.canScrollVertically(1)) {
            schulteTableRankView.mRankListView.scrollBy(0, 1);
            schulteTableRankView.postDelayed(schulteTableRankView.mScrollRunnable, 100);
            return;
        }
        schulteTableRankView.stopScroll();
    }

    public void hide(Function0<Unit> function0) {
        XesLog.i(TAG, SUB_TAG, "隐藏");
    }

    /* access modifiers changed from: private */
    public final void stopScroll() {
        if (this.mScrollRunnable != null) {
            XesLog.i(TAG, SUB_TAG, "停止自滚动");
            removeCallbacks(this.mScrollRunnable);
            this.mScrollRunnable = null;
        }
    }

    private final void showSelf(int i, SchulteTableRankListUserDataBean schulteTableRankListUserDataBean) {
        Unit unit;
        if (schulteTableRankListUserDataBean != null) {
            TextView textView = (TextView) findViewById(R.id.rank_name);
            TextView textView2 = (TextView) findViewById(R.id.rank_score);
            ImageView imageView = (ImageView) findViewById(R.id.rank_head);
            TextView textView3 = (TextView) findViewById(R.id.rank_coins);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append('.');
            ((TextView) findViewById(R.id.rank_number)).setText(sb.toString());
            String nickName = schulteTableRankListUserDataBean.getNickName();
            if (nickName != null) {
                textView.setText(nickName);
            }
            String duration = schulteTableRankListUserDataBean.getDuration();
            if (duration != null) {
                textView2.setText(Intrinsics.stringPlus(duration, "s"));
            }
            String coin = schulteTableRankListUserDataBean.getCoin();
            if (coin == null) {
                unit = null;
            } else {
                textView3.setText(Intrinsics.stringPlus("+", coin));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                SchulteTableRankView schulteTableRankView = this;
                textView3.setVisibility(4);
            }
            String avatar = schulteTableRankListUserDataBean.getAvatar();
            if (avatar != null) {
                ImageLoaderJ.loadCircle(getContext(), avatar, imageView, R.drawable.icon_default_user);
            }
        }
    }

    public void destroy() {
        XesLog.i(TAG, SUB_TAG, "销毁");
        stopScroll();
    }
}
