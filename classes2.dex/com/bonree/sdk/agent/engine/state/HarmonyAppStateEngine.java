package com.bonree.sdk.agent.engine.state;

import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.q;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilityLifecycleCallbacks;
import ohos.aafwk.ability.AbilityPackage;
import ohos.app.ElementsCallback;
import ohos.bundle.AbilityInfo;
import ohos.global.configuration.Configuration;
import ohos.utils.PacMap;

public class HarmonyAppStateEngine extends f implements AbilityLifecycleCallbacks, ElementsCallback {
    public void onAbilityInactive(Ability ability) {
    }

    public void onAbilitySaveState(PacMap pacMap) {
    }

    public void onAbilityStop(Ability ability) {
    }

    public void onConfigurationUpdated(Configuration configuration) {
    }

    public void setViewName(Object obj) {
        if (obj != null && (obj instanceof Ability)) {
            this.mViewName = obj.getClass().getName();
        }
    }

    public String getViewName() {
        return this.mViewName;
    }

    /* access modifiers changed from: protected */
    public void register() {
        if (this.services.size() == 1 || !this.isRegisterSuccessful) {
            try {
                a.a().c("HarmonyAppStateEngine is start.", new Object[0]);
                AbilityPackage a = q.a();
                if (a != null) {
                    a.registerCallbacks(this, this);
                    this.isRegisterSuccessful = true;
                }
            } catch (Throwable th) {
                a.a().a("HarmonyAppStateEngine is start error ; ", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        if (isEmptyServices()) {
            a.a().c("HarmonyAppStateEngine is stop.", new Object[0]);
            AbilityPackage a = q.a();
            if (a != null) {
                a.unregisterCallbacks(this, this);
            }
            this.isRegisterSuccessful = false;
        }
    }

    public void onAbilityStart(Ability ability) {
        if (ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            abilityStart(ability.hashCode());
        }
    }

    public void onAbilityActive(Ability ability) {
        setViewName(ability);
    }

    public void onAbilityForeground(Ability ability) {
        if (ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            abilityStart(ability.hashCode());
        }
    }

    private void abilityStart(int i) {
        this.activeActivityCount.incrementAndGet();
        if (this.mHappenBackground) {
            this.mHappenBackground = false;
            notifyService(e.FOREGROUND);
        }
    }

    public void onAbilityBackground(Ability ability) {
        if (ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            int decrementAndGet = this.activeActivityCount.decrementAndGet();
            if (!this.mHappenBackground && decrementAndGet == 0) {
                this.mHappenBackground = true;
                notifyService(e.BACKGROUND);
                this.activeActivityCount.set(0);
            }
        }
    }

    public void onMemoryLevel(int i) {
        a.a().c("trim memory: %d, background: %b", Integer.valueOf(i), Boolean.valueOf(this.mHappenBackground));
        if (i == 20) {
            this.activeActivityCount.set(0);
            if (!this.mHappenBackground) {
                this.mHappenBackground = true;
                notifyService(e.BACKGROUND);
            }
        }
    }
}
