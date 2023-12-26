package com.adyen.checkout.components.util;

import com.adyen.checkout.core.api.Environment;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/adyen/checkout/components/util/ValidationUtils;", "", "()V", "CLIENT_KEY_LIVE_PREFIX", "", "CLIENT_KEY_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CLIENT_KEY_REGEX", "CLIENT_KEY_TEST_PREFIX", "EMAIL_PATTERN", "EMAIL_REGEX", "PHONE_PATTERN", "PHONE_REGEX", "doesClientKeyMatchEnvironment", "", "clientKey", "environment", "Lcom/adyen/checkout/core/api/Environment;", "isClientKeyValid", "isEmailValid", "emailAddress", "isPhoneNumberValid", "phoneNumber", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ValidationUtils.kt */
public final class ValidationUtils {
    private static final String CLIENT_KEY_LIVE_PREFIX = "live_";
    private static final Pattern CLIENT_KEY_PATTERN = Pattern.compile(CLIENT_KEY_REGEX);
    private static final String CLIENT_KEY_REGEX = "([a-z]){4}\\_([A-z]|\\d){32}";
    private static final String CLIENT_KEY_TEST_PREFIX = "test_";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, 2);
    private static final String EMAIL_REGEX = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    public static final ValidationUtils INSTANCE = new ValidationUtils();
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    private static final String PHONE_REGEX = "^\\D*(\\d\\D*){9,14}$";

    private ValidationUtils() {
    }

    public final boolean isPhoneNumberValid(String str) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        return PHONE_PATTERN.matcher(str).matches();
    }

    public final boolean isEmailValid(String str) {
        Intrinsics.checkNotNullParameter(str, "emailAddress");
        return EMAIL_PATTERN.matcher(str).matches();
    }

    public final boolean isClientKeyValid(String str) {
        Intrinsics.checkNotNullParameter(str, "clientKey");
        return CLIENT_KEY_PATTERN.matcher(str).matches();
    }

    public final boolean doesClientKeyMatchEnvironment(String str, Environment environment) {
        Intrinsics.checkNotNullParameter(str, "clientKey");
        Intrinsics.checkNotNullParameter(environment, "environment");
        boolean areEqual = Intrinsics.areEqual(environment, Environment.TEST);
        boolean z = Intrinsics.areEqual(environment, Environment.EUROPE) || Intrinsics.areEqual(environment, Environment.AUSTRALIA) || Intrinsics.areEqual(environment, Environment.UNITED_STATES);
        if (z && StringsKt.startsWith$default(str, CLIENT_KEY_LIVE_PREFIX, false, 2, (Object) null)) {
            return true;
        }
        if (areEqual && StringsKt.startsWith$default(str, CLIENT_KEY_TEST_PREFIX, false, 2, (Object) null)) {
            return true;
        }
        if (z || areEqual) {
            return false;
        }
        return true;
    }
}
