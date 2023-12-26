package com.bonree.sdk.agent.engine.external;

import com.bonree.sdk.x.b;
import ohos.aafwk.ability.Ability;
import ohos.bundle.AbilityInfo;

public class AbilityInfo {
    public static void endStopAbilitySlice(Ability ability, Object obj) {
    }

    public static void startStopAbilitySlice(Ability ability, Object obj) {
    }

    public static void stopAbility(Ability ability) {
    }

    public static void onStartTrace(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().a(ability.getAbilityInfo().className);
        }
    }

    public static void endStartTrace(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().b(ability.getAbilityInfo().className);
        }
    }

    public static void onActiveAbility(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().c(ability.getAbilityInfo().className);
        }
    }

    public static void endActiveTrace(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().d(ability.getAbilityInfo().className);
        }
    }

    public static void onForegroundTrace(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().g(ability.getAbilityInfo().className);
        }
    }

    public static void endForegroundTrace(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().h(ability.getAbilityInfo().className);
        }
    }

    public static void onBackgroundTrace(Ability ability) {
        if (ability != null) {
            ability.getAbilityInfo().getType();
            AbilityInfo.AbilityType abilityType = AbilityInfo.AbilityType.PAGE;
        }
    }

    public static void endBackgroundTrace(Ability ability) {
        if (ability != null) {
            ability.getAbilityInfo().getType();
            AbilityInfo.AbilityType abilityType = AbilityInfo.AbilityType.PAGE;
        }
    }

    public static void inActiveAbility(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().e(ability.getAbilityInfo().className);
        }
    }

    public static void endInActiveAbility(Ability ability) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            b.a().f(ability.getAbilityInfo().className);
        }
    }

    public static void startOnStartAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().a(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void endOnStartAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().b(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void startOnActiveAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().c(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void endOnActiveAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().d(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void startInActiveAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().e(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void endInActiveAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().f(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void startOnBackGroundAbilitySlice(Ability ability, Object obj) {
        if (ability != null) {
            ability.getAbilityInfo().getType();
            AbilityInfo.AbilityType abilityType = AbilityInfo.AbilityType.PAGE;
        }
    }

    public static void endOnBackGroundAbilitySlice(Ability ability, Object obj) {
        if (ability != null) {
            ability.getAbilityInfo().getType();
            AbilityInfo.AbilityType abilityType = AbilityInfo.AbilityType.PAGE;
        }
    }

    public static void startForeGroundAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().g(ability == null ? null : ability.getClass().getName(), obj);
        }
    }

    public static void endForeGroundAbilitySlice(Ability ability, Object obj) {
        if (ability != null && ability.getAbilityInfo().getType() == AbilityInfo.AbilityType.PAGE) {
            com.bonree.sdk.y.b.a().h(ability == null ? null : ability.getClass().getName(), obj);
        }
    }
}
