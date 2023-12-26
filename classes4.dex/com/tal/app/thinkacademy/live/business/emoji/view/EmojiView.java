package com.tal.app.thinkacademy.live.business.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.databinding.LayoutEmojiViewBinding;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiLocalImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineLottieResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.data.EmojiData;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ9\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J5\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/view/EmojiView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "kotlin.jvm.PlatformType", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LayoutEmojiViewBinding;", "setData", "", "emojiBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "isLoop", "", "lottieEndListener", "Lkotlin/Function0;", "(Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "emojiJsonString", "(Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "setVisibility", "visibility", "ViewVisibility", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiView.kt */
public final class EmojiView extends RelativeLayout {
    private String TAG;
    /* access modifiers changed from: private */
    public LayoutEmojiViewBinding mViewBinding;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/view/EmojiView$ViewVisibility;", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: EmojiView.kt */
    public @interface ViewVisibility {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmojiView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-6$lambda-3$lambda-2  reason: not valid java name */
    public static final void m220setData$lambda6$lambda3$lambda2(Throwable th) {
    }

    public final void setData(EmojiBean<?> emojiBean) {
        setData$default(this, (EmojiBean) emojiBean, (Boolean) null, (Function0) null, 6, (Object) null);
    }

    public final void setData(EmojiBean<?> emojiBean, Boolean bool) {
        setData$default(this, (EmojiBean) emojiBean, bool, (Function0) null, 4, (Object) null);
    }

    public final void setData(String str) {
        setData$default(this, str, (Boolean) null, (Function0) null, 6, (Object) null);
    }

    public final void setData(String str, Boolean bool) {
        setData$default(this, str, bool, (Function0) null, 4, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "EmojiView";
        LayoutEmojiViewBinding inflate = LayoutEmojiViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this, true)");
        this.mViewBinding = inflate;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmojiView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void setData$default(EmojiView emojiView, String str, Boolean bool, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        emojiView.setData(str, bool, (Function0<Unit>) function0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setData(java.lang.String r7, java.lang.Boolean r8, kotlin.jvm.functions.Function0<kotlin.Unit> r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 == 0) goto L_0x0014
            return
        L_0x0014:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x006d }
            r0.<init>(r7)     // Catch:{ all -> 0x006d }
            java.lang.String r3 = "type"
            int r0 = r0.optInt(r3)     // Catch:{ all -> 0x006d }
            r3 = 0
            java.lang.String r4 = "object : TypeToken<Emoji…esourceBean?>?>() {}.type"
            if (r0 == r2) goto L_0x0053
            r5 = 2
            if (r0 == r5) goto L_0x003f
            r5 = 3
            if (r0 == r5) goto L_0x002b
            goto L_0x0066
        L_0x002b:
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView$setData$3 r0 = new com.tal.app.thinkacademy.live.business.emoji.view.EmojiView$setData$3     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            java.lang.reflect.Type r0 = r0.getType()     // Catch:{ all -> 0x006d }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ all -> 0x006d }
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r0)     // Catch:{ all -> 0x006d }
            r3 = r7
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r3 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r3     // Catch:{ all -> 0x006d }
            goto L_0x0066
        L_0x003f:
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView$setData$2 r0 = new com.tal.app.thinkacademy.live.business.emoji.view.EmojiView$setData$2     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            java.lang.reflect.Type r0 = r0.getType()     // Catch:{ all -> 0x006d }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ all -> 0x006d }
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r0)     // Catch:{ all -> 0x006d }
            r3 = r7
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r3 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r3     // Catch:{ all -> 0x006d }
            goto L_0x0066
        L_0x0053:
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView$setData$1 r0 = new com.tal.app.thinkacademy.live.business.emoji.view.EmojiView$setData$1     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            java.lang.reflect.Type r0 = r0.getType()     // Catch:{ all -> 0x006d }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ all -> 0x006d }
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r0)     // Catch:{ all -> 0x006d }
            r3 = r7
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r3 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r3     // Catch:{ all -> 0x006d }
        L_0x0066:
            if (r3 != 0) goto L_0x0069
            goto L_0x007c
        L_0x0069:
            r6.setData((com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean<?>) r3, (java.lang.Boolean) r8, (kotlin.jvm.functions.Function0<kotlin.Unit>) r9)     // Catch:{ all -> 0x006d }
            goto L_0x007c
        L_0x006d:
            r7 = move-exception
            r7.printStackTrace()
            java.lang.String r7 = r6.TAG
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.String r9 = "表情数据解析异常"
            r8[r1] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r7, r8)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.emoji.view.EmojiView.setData(java.lang.String, java.lang.Boolean, kotlin.jvm.functions.Function0):void");
    }

    public static /* synthetic */ void setData$default(EmojiView emojiView, EmojiBean emojiBean, Boolean bool, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        emojiView.setData((EmojiBean<?>) emojiBean, bool, (Function0<Unit>) function0);
    }

    public final void setData(EmojiBean<?> emojiBean, Boolean bool, Function0<Unit> function0) {
        Object resource;
        ImageView imageView;
        ImageView imageView2 = this.mViewBinding.emojiIV;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView = this.mViewBinding.emojiLV;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = this.mViewBinding.emojiLV;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        if (emojiBean != null) {
            int type = emojiBean.getType();
            boolean z = true;
            if (type == 1) {
                EmojiBean emojiByName = EmojiData.getEmojiByName(emojiBean.getName());
                if (emojiByName != null) {
                    Object resource2 = emojiByName.getResource();
                    if (resource2 instanceof EmojiLocalImageResourceBean) {
                        EmojiLocalImageResourceBean emojiLocalImageResourceBean = (EmojiLocalImageResourceBean) resource2;
                        if (emojiLocalImageResourceBean.getResId() > 0) {
                            ImageView imageView3 = this.mViewBinding.emojiIV;
                            if (imageView3 != null) {
                                imageView3.setImageResource(emojiLocalImageResourceBean.getResId());
                            }
                            ImageView imageView4 = this.mViewBinding.emojiIV;
                            if (imageView4 != null) {
                                imageView4.setVisibility(0);
                            }
                        }
                    }
                }
            } else if (type == 2) {
                Object resource3 = emojiBean.getResource();
                if (resource3 != null && (resource3 instanceof EmojiOnlineLottieResourceBean)) {
                    LottieAnimationView lottieAnimationView3 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView3 != null) {
                        lottieAnimationView3.cancelAnimation();
                    }
                    LottieAnimationView lottieAnimationView4 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView4 != null) {
                        lottieAnimationView4.setIgnoreDisabledSystemAnimations(true);
                    }
                    LottieAnimationView lottieAnimationView5 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView5 != null) {
                        lottieAnimationView5.setAnimationFromUrl(((EmojiOnlineLottieResourceBean) resource3).getJsonUrl());
                    }
                    LottieAnimationView lottieAnimationView6 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView6 != null) {
                        lottieAnimationView6.setFailureListener(EmojiView$$ExternalSyntheticLambda0.INSTANCE);
                    }
                    LottieAnimationView lottieAnimationView7 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView7 != null) {
                        lottieAnimationView7.playAnimation();
                    }
                    LottieAnimationView lottieAnimationView8 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView8 != null) {
                        lottieAnimationView8.setRepeatCount(Intrinsics.areEqual(bool, true) ? -1 : 0);
                    }
                    LottieAnimationView lottieAnimationView9 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView9 != null) {
                        lottieAnimationView9.setVisibility(0);
                    }
                    LottieAnimationView lottieAnimationView10 = this.mViewBinding.emojiLV;
                    if (lottieAnimationView10 != null) {
                        lottieAnimationView10.addAnimatorListener(new EmojiView$setData$5$2$2(this, function0));
                    }
                }
            } else if (type == 3 && (resource = emojiBean.getResource()) != null && (resource instanceof EmojiOnlineImageResourceBean)) {
                EmojiOnlineImageResourceBean emojiOnlineImageResourceBean = (EmojiOnlineImageResourceBean) resource;
                CharSequence imgUrl = emojiOnlineImageResourceBean.getImgUrl();
                if (imgUrl != null && !StringsKt.isBlank(imgUrl)) {
                    z = false;
                }
                if (!z && (imageView = this.mViewBinding.emojiIV) != null) {
                    ImageLoaderJ.loadFitCenter(getContext(), emojiOnlineImageResourceBean.getImgUrl(), imageView);
                    imageView.setVisibility(0);
                }
            }
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if ((i == 4 || i == 8) && this.mViewBinding.emojiLV != null) {
            this.mViewBinding.emojiLV.cancelAnimation();
        }
    }
}
