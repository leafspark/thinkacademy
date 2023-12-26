package com.tal.app.thinkacademy.common.business.browser.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR$\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0016@BX\u000e¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0016@BX\u000e¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019R\"\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\"\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\t¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "classId", "getClassId", "()Ljava/lang/String;", "Lcom/tal/app/thinkacademy/common/business/browser/agent/AgentConfig;", "config", "getConfig", "()Lcom/tal/app/thinkacademy/common/business/browser/agent/AgentConfig;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "header", "", "getHeader", "()Ljava/util/Map;", "homeworkId", "getHomeworkId", "", "homeworkType", "getHomeworkType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "intentData", "", "getIntentData", "()Lkotlin/Unit;", "planId", "getPlanId", "shareCode", "getShareCode", "url", "getUrl", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserHelper.kt */
public final class BrowserHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static BrowserHelper mHelper;
    private String classId;
    private AgentConfig config;
    private final WeakReference<Context> contextWeakRef;
    private String homeworkId;
    private Integer homeworkType;
    private Integer planId;
    private String shareCode;
    private String url;

    public /* synthetic */ BrowserHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private BrowserHelper(Context context) {
        this.contextWeakRef = new WeakReference<>(context);
    }

    public final String getUrl() {
        return this.url;
    }

    public final AgentConfig getConfig() {
        return this.config;
    }

    public final String getHomeworkId() {
        return this.homeworkId;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final Integer getPlanId() {
        return this.planId;
    }

    public final Integer getHomeworkType() {
        return this.homeworkType;
    }

    public final String getShareCode() {
        return this.shareCode;
    }

    public final Unit getIntentData() {
        Context context = (Context) this.contextWeakRef.get();
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            this.url = intent.getStringExtra("jump_key");
            Serializable serializableExtra = intent.getSerializableExtra("agent_config");
            this.config = serializableExtra instanceof AgentConfig ? (AgentConfig) serializableExtra : null;
            this.homeworkId = intent.getStringExtra("homework_id");
            this.classId = intent.getStringExtra(LeanplumUtil.classId);
            this.planId = Integer.valueOf(intent.getIntExtra("plan_id", 0));
            this.homeworkType = Integer.valueOf(intent.getIntExtra("homework_type", 0));
            this.shareCode = intent.getStringExtra("shareCode");
        }
        return Unit.INSTANCE;
    }

    public final Map<String, String> getHeader() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("appVersionNumber", AppUtils.getAppVersionCode() + "");
        hashMap.put("device", "8");
        hashMap.put("userAgent", "ThinkAcademyApp");
        hashMap.put("systemName", "android");
        return hashMap;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserHelper$Companion;", "", "()V", "mHelper", "Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserHelper;", "getInstance", "context", "Landroid/content/Context;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final BrowserHelper getInstance(Context context) {
            if (BrowserHelper.mHelper == null) {
                BrowserHelper.mHelper = new BrowserHelper(context, (DefaultConstructorMarker) null);
            }
            return BrowserHelper.mHelper;
        }
    }
}
