package com.tal.app.thinkacademy.live.business.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.gift.bean.BarrageBean;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPrivateRemindView;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BarrageLiveView extends BaseLivePluginView {
    private LinkedBlockingQueue<BarrageBean> bottomQueue = new LinkedBlockingQueue<>(32);
    private Context context;
    private ThreadPoolExecutor executor;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    private int locationIndex = -1;
    private LinkedBlockingQueue<BarrageBean> middleQueue = new LinkedBlockingQueue<>(32);
    /* access modifiers changed from: private */
    public LiveAreaLayoutParams pptLp;
    private List<LinkedBlockingQueue<BarrageBean>> queues = new ArrayList();
    private RelativeLayout rlBottom;
    private List<RelativeLayout> rlList = new ArrayList();
    private RelativeLayout rlMiddle;
    private RelativeLayout rlTop;
    private LinkedBlockingQueue<BarrageBean> topQueue = new LinkedBlockingQueue<>(32);

    public BarrageLiveView(Context context2) {
        super(context2);
        this.context = context2;
        init();
    }

    public BarrageLiveView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        init();
    }

    public BarrageLiveView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }

    public int getLayoutId() {
        return R.layout.live_business_live_barrage_view;
    }

    private void init() {
        this.rlTop = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_barrage_top);
        this.rlMiddle = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_barrage_middle);
        this.rlBottom = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_barrage_bottom);
        this.rlList.add(this.rlTop);
        this.rlList.add(this.rlMiddle);
        this.rlList.add(this.rlBottom);
        this.pptLp = LiveAreaContext.get().getPptLp();
        this.queues.add(this.topQueue);
        this.queues.add(this.middleQueue);
        this.queues.add(this.bottomQueue);
        consumeBarrage();
    }

    private synchronized int getIndex() {
        int i = this.locationIndex + 1;
        this.locationIndex = i;
        if (i == 3) {
            this.locationIndex = 0;
        }
        return this.locationIndex;
    }

    public void produceBarrage(BarrageBean barrageBean) {
        try {
            this.queues.get(getIndex()).put(barrageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void consumeBarrage() {
        this.executor = new ThreadPoolExecutor(3, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        for (int i = 0; i < 3; i++) {
            this.executor.execute(createRunnable(i));
        }
    }

    private Runnable createRunnable(final int i) {
        final LinkedBlockingQueue linkedBlockingQueue = this.queues.get(i);
        return new Runnable() {
            public void run() {
                while (true) {
                    try {
                        final BarrageBean barrageBean = (BarrageBean) linkedBlockingQueue.take();
                        Thread.sleep(100);
                        View access$000 = BarrageLiveView.this.getLastView(i);
                        if (access$000 == null) {
                            Handler access$200 = BarrageLiveView.this.handler;
                            AnonymousClass1 r2 = new Runnable() {
                                public void run() {
                                    BarrageLiveView.this.createBarrageView(barrageBean, i);
                                }
                            };
                            if (!(access$200 instanceof Handler)) {
                                access$200.post(r2);
                            } else {
                                AsynchronousInstrumentation.handlerPost(access$200, r2);
                            }
                        } else {
                            do {
                            } while (access$000.getTranslationX() > ((float) (BarrageLiveView.this.pptLp.width - access$000.getMeasuredWidth())));
                            Handler access$2002 = BarrageLiveView.this.handler;
                            AnonymousClass2 r22 = new Runnable() {
                                public void run() {
                                    BarrageLiveView.this.createBarrageView(barrageBean, i);
                                }
                            };
                            if (!(access$2002 instanceof Handler)) {
                                access$2002.post(r22);
                            } else {
                                AsynchronousInstrumentation.handlerPost(access$2002, r22);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void createBarrageView(BarrageBean barrageBean, final int i) {
        if (barrageBean != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, SizeUtils.dp2px(37.0f));
            LayoutInflater from = LayoutInflater.from(this.context);
            int i2 = R.layout.live_business_include_live_barrage_layout;
            final View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i2, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_live_business_gift_send_toast);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_live_business_gift_send_toast);
            if ("I".equals(barrageBean.getNickName())) {
                textView.setTextColor(ContextCompat.getColor(this.context, R.color.COLOR_FFDC0A));
            }
            textView.setText(barrageBean.getMessage());
            ImageLoaderJ.load(this.context, barrageBean.getIcon_mobile(), imageView);
            inflate.setTranslationX((float) this.pptLp.width);
            this.rlList.get(i).addView(inflate, layoutParams);
            inflate.post(new Runnable() {
                public void run() {
                    BarrageLiveView.this.startBarrage(inflate, i);
                }
            });
        }
    }

    public void startBarrage(final View view, final int i) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{(float) this.pptLp.width, (float) (-view.getMeasuredWidth())});
            ofFloat.setDuration(LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    BarrageLiveView.this.removeEndView(i, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public synchronized void removeEndView(int i, View view) {
        this.rlList.get(i).removeView(view);
    }

    /* access modifiers changed from: private */
    public synchronized View getLastView(int i) {
        int childCount = this.rlList.get(i).getChildCount() - 1;
        if (childCount == -1) {
            return null;
        }
        return this.rlList.get(i).getChildAt(childCount);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BarrageLiveView.super.onDetachedFromWindow();
        this.executor.shutdown();
    }
}
