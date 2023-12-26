package com.tal.app.thinkacademy.common.business.browser.helper;

import android.content.Intent;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0014@BX\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0014@BX\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017R\"\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR\"\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\t¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserDataHelper;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "<set-?>", "", "classId", "getClassId", "()Ljava/lang/String;", "Lcom/tal/app/thinkacademy/common/business/browser/agent/AgentConfig;", "config", "getConfig", "()Lcom/tal/app/thinkacademy/common/business/browser/agent/AgentConfig;", "header", "", "getHeader", "()Ljava/util/Map;", "homeworkId", "getHomeworkId", "", "homeworkType", "getHomeworkType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "mCacheJumpUrl", "getMCacheJumpUrl", "setMCacheJumpUrl", "(Ljava/lang/String;)V", "mIsCanUseCache", "", "getMIsCanUseCache", "()Z", "setMIsCanUseCache", "(Z)V", "planId", "getPlanId", "shareCode", "getShareCode", "url", "getUrl", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserDataHelper.kt */
public final class BrowserDataHelper {
    private String classId;
    private AgentConfig config;
    private String homeworkId;
    private Integer homeworkType;
    private String mCacheJumpUrl = "";
    private boolean mIsCanUseCache;
    private Integer planId;
    private String shareCode;
    private String url;

    public BrowserDataHelper(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mIsCanUseCache = intent.getBooleanExtra("can_use_cache", false);
        this.mCacheJumpUrl = intent.getStringExtra("cache_jump_url");
        this.url = intent.getStringExtra("jump_key");
        Serializable serializableExtra = intent.getSerializableExtra("agent_config");
        this.config = serializableExtra instanceof AgentConfig ? (AgentConfig) serializableExtra : null;
        this.homeworkId = intent.getStringExtra("homework_id");
        this.classId = intent.getStringExtra(LeanplumUtil.classId);
        this.planId = Integer.valueOf(intent.getIntExtra("plan_id", 0));
        this.homeworkType = Integer.valueOf(intent.getIntExtra("homework_type", 0));
        this.shareCode = intent.getStringExtra("shareCode");
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

    public final boolean getMIsCanUseCache() {
        return this.mIsCanUseCache;
    }

    public final void setMIsCanUseCache(boolean z) {
        this.mIsCanUseCache = z;
    }

    public final String getMCacheJumpUrl() {
        return this.mCacheJumpUrl;
    }

    public final void setMCacheJumpUrl(String str) {
        this.mCacheJumpUrl = str;
    }

    public final Map<String, String> getHeader() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("appVersionNumber", AppUtils.getAppVersionCode() + "");
        hashMap.put("device", "8");
        hashMap.put("userAgent", "ThinkAcademyApp");
        hashMap.put("systemName", "android");
        return hashMap;
    }
}
