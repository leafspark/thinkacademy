package com.adyen.threeds2;

import android.app.Activity;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.parameters.ChallengeParameters;

public interface Transaction {
    void close();

    void doChallenge(Activity activity, ChallengeParameters challengeParameters, ChallengeStatusReceiver challengeStatusReceiver, int i) throws InvalidInputException;

    AuthenticationRequestParameters getAuthenticationRequestParameters();

    ProgressDialog getProgressView(Activity activity) throws InvalidInputException;
}
