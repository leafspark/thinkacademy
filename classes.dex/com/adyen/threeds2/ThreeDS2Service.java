package com.adyen.threeds2;

import android.content.Context;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.exception.SDKAlreadyInitializedException;
import com.adyen.threeds2.exception.SDKNotInitializedException;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.h;
import com.adyen.threeds2.parameters.ConfigParameters;
import java.util.List;

public interface ThreeDS2Service {
    public static final ThreeDS2Service INSTANCE = h.a;

    void cleanup(Context context) throws SDKNotInitializedException;

    Transaction createTransaction(String str, String str2) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException;

    String getSDKVersion();

    List<Warning> getWarnings();

    void initialize(Context context, ConfigParameters configParameters, String str, UiCustomization uiCustomization) throws InvalidInputException, SDKAlreadyInitializedException, SDKRuntimeException;
}
