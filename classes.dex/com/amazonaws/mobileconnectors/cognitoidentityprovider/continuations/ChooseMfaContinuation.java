package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ChooseMfaContinuation extends ChallengeContinuation {
    private List<String> mfaOptions = getListFromString((String) getParameters().get(CognitoServiceConstants.CHLG_PARAM_MFAS_CAN_CHOOSE));

    public ChooseMfaContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
    }

    public List<String> getMfaOptions() {
        if (this.mfaOptions == null) {
            this.mfaOptions = getListFromString((String) getParameters().get(CognitoServiceConstants.CHLG_PARAM_MFAS_CAN_CHOOSE));
        }
        return this.mfaOptions;
    }

    public void setMfaOption(String str) {
        List<String> mfaOptions2 = getMfaOptions();
        if (str == null || !mfaOptions2.contains(str)) {
            throw new CognitoParameterInvalidException(String.format(Locale.US, "invalid MFA option: %s", new Object[]{str}));
        }
        setChallengeResponse(CognitoServiceConstants.CHLG_RESP_ANSWER, str);
    }

    public void continueTask() {
        if (this.challengeResponses.containsKey(CognitoServiceConstants.CHLG_RESP_ANSWER)) {
            super.continueTask();
            return;
        }
        throw new CognitoParameterInvalidException("MFA option is not set");
    }

    private List<String> getListFromString(String str) {
        return Arrays.asList(str.replace("[", "").replace("]", "").replace("\"", "").split(","));
    }
}
