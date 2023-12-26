package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChooseMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.RegisterMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.VerifyMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoNotAuthorizedException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.DevicesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.RegisterMfaHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoSecretHash;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.Hkdf;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserResult;
import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidParameterException;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult;
import com.amazonaws.services.cognitoidentityprovider.model.NewDeviceMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult;
import com.amazonaws.services.cognitoidentityprovider.model.ResourceNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.SMSMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResponseType;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CognitoUser {
    private static final Object GET_CACHED_SESSION_LOCK = new Object();
    private static final Log LOGGER = LogFactory.getLog((Class<?>) CognitoUser.class);
    private static final int SRP_RADIX = 16;
    /* access modifiers changed from: private */
    public CognitoUserSession cipSession = null;
    /* access modifiers changed from: private */
    public final String clientId;
    private final String clientSecret;
    /* access modifiers changed from: private */
    public final AmazonCognitoIdentityProvider cognitoIdentityProviderClient;
    /* access modifiers changed from: private */
    public final Context context;
    private String deviceKey = null;
    /* access modifiers changed from: private */
    public final CognitoUserPool pool;
    private String secretHash;
    private String userId;
    /* access modifiers changed from: private */
    public String usernameInternal;

    protected CognitoUser(CognitoUserPool cognitoUserPool, String str, String str2, String str3, String str4, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, Context context2) {
        this.pool = cognitoUserPool;
        this.context = context2;
        this.userId = str;
        this.cognitoIdentityProviderClient = amazonCognitoIdentityProvider;
        this.clientId = str2;
        this.clientSecret = str3;
        this.secretHash = str4;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserPoolId() {
        return this.pool.getUserPoolId();
    }

    /* access modifiers changed from: protected */
    public AmazonCognitoIdentityProvider getCognitoIdentityProviderClient() {
        return this.cognitoIdentityProviderClient;
    }

    public void confirmSignUpInBackground(String str, boolean z, GenericHandler genericHandler) {
        confirmSignUpInBackground(str, z, Collections.emptyMap(), genericHandler);
    }

    public void confirmSignUp(String str, boolean z, GenericHandler genericHandler) {
        confirmSignUp(str, z, Collections.emptyMap(), genericHandler);
    }

    public void confirmSignUpInBackground(String str, boolean z, Map<String, String> map, GenericHandler genericHandler) {
        if (genericHandler != null) {
            final String str2 = str;
            final boolean z2 = z;
            final Map<String, String> map2 = map;
            final GenericHandler genericHandler2 = genericHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.confirmSignUpInternal(str2, z2, map2);
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler2.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void confirmSignUp(String str, boolean z, Map<String, String> map, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                confirmSignUpInternal(str, z, map);
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void confirmSignUpInternal(String str, boolean z, Map<String, String> map) {
        ConfirmSignUpRequest withUserContextData = new ConfirmSignUpRequest().withClientId(this.clientId).withSecretHash(this.secretHash).withUsername(this.userId).withConfirmationCode(str).withForceAliasCreation(Boolean.valueOf(z)).withClientMetadata(map).withUserContextData(getUserContextData());
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withUserContextData.setAnalyticsMetadata(analyticsMetadataType);
        }
        this.cognitoIdentityProviderClient.confirmSignUp(withUserContextData);
    }

    public void resendConfirmationCodeInBackground(VerificationHandler verificationHandler) {
        resendConfirmationCodeInBackground(Collections.emptyMap(), verificationHandler);
    }

    public void resendConfirmationCodeInBackground(final Map<String, String> map, final VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final ResendConfirmationCodeResult access$200 = CognitoUser.this.resendConfirmationCodeInternal(map);
                        runnable = new Runnable() {
                            public void run() {
                                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(access$200.getCodeDeliveryDetails()));
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                verificationHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void resendConfirmationCode(VerificationHandler verificationHandler) {
        resendConfirmationCode(Collections.emptyMap(), verificationHandler);
    }

    public void resendConfirmationCode(Map<String, String> map, VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            try {
                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(resendConfirmationCodeInternal(map).getCodeDeliveryDetails()));
            } catch (Exception e) {
                verificationHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public ResendConfirmationCodeResult resendConfirmationCodeInternal(Map<String, String> map) {
        ResendConfirmationCodeRequest withClientMetadata = new ResendConfirmationCodeRequest().withUsername(this.userId).withClientId(this.clientId).withSecretHash(this.secretHash).withClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        withClientMetadata.setUserContextData(getUserContextData());
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withClientMetadata.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.cognitoIdentityProviderClient.resendConfirmationCode(withClientMetadata);
    }

    public void forgotPasswordInBackground(ForgotPasswordHandler forgotPasswordHandler) {
        forgotPasswordInBackground(Collections.emptyMap(), forgotPasswordHandler);
    }

    public void forgotPassword(ForgotPasswordHandler forgotPasswordHandler) {
        forgotPassword(Collections.emptyMap(), forgotPasswordHandler);
    }

    public void forgotPasswordInBackground(final Map<String, String> map, final ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final ForgotPasswordContinuation forgotPasswordContinuation = new ForgotPasswordContinuation(this, new CognitoUserCodeDeliveryDetails(CognitoUser.this.forgotPasswordInternal(map).getCodeDeliveryDetails()), true, forgotPasswordHandler);
                        runnable = new Runnable() {
                            public void run() {
                                forgotPasswordHandler.getResetCode(forgotPasswordContinuation);
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                forgotPasswordHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void forgotPassword(Map<String, String> map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            try {
                forgotPasswordHandler.getResetCode(new ForgotPasswordContinuation(this, new CognitoUserCodeDeliveryDetails(forgotPasswordInternal(map).getCodeDeliveryDetails()), false, forgotPasswordHandler));
            } catch (Exception e) {
                forgotPasswordHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public ForgotPasswordResult forgotPasswordInternal(Map<String, String> map) {
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setClientId(this.clientId);
        forgotPasswordRequest.setSecretHash(this.secretHash);
        forgotPasswordRequest.setUsername(this.userId);
        forgotPasswordRequest.setUserContextData(getUserContextData());
        forgotPasswordRequest.setClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            forgotPasswordRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.cognitoIdentityProviderClient.forgotPassword(forgotPasswordRequest);
    }

    public void confirmPasswordInBackground(String str, String str2, ForgotPasswordHandler forgotPasswordHandler) {
        confirmPasswordInBackground(str, str2, Collections.emptyMap(), forgotPasswordHandler);
    }

    public void confirmPasswordInBackground(String str, String str2, Map<String, String> map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            final String str3 = str;
            final String str4 = str2;
            final Map<String, String> map2 = map;
            final ForgotPasswordHandler forgotPasswordHandler2 = forgotPasswordHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.confirmPasswordInternal(str3, str4, map2);
                        runnable = new Runnable() {
                            public void run() {
                                forgotPasswordHandler2.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                forgotPasswordHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void confirmPassword(String str, String str2, ForgotPasswordHandler forgotPasswordHandler) {
        confirmPassword(str, str2, Collections.emptyMap(), forgotPasswordHandler);
    }

    public void confirmPassword(String str, String str2, Map<String, String> map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            try {
                confirmPasswordInternal(str, str2, map);
                forgotPasswordHandler.onSuccess();
            } catch (Exception e) {
                forgotPasswordHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void confirmPasswordInternal(String str, String str2, Map<String, String> map) {
        ConfirmForgotPasswordRequest confirmForgotPasswordRequest = new ConfirmForgotPasswordRequest();
        confirmForgotPasswordRequest.setUsername(this.userId);
        confirmForgotPasswordRequest.setClientId(this.clientId);
        confirmForgotPasswordRequest.setSecretHash(this.secretHash);
        confirmForgotPasswordRequest.setConfirmationCode(str);
        confirmForgotPasswordRequest.setPassword(str2);
        confirmForgotPasswordRequest.setUserContextData(getUserContextData());
        confirmForgotPasswordRequest.setClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            confirmForgotPasswordRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        this.cognitoIdentityProviderClient.confirmForgotPassword(confirmForgotPasswordRequest);
    }

    public void getSessionInBackground(final AuthenticationHandler authenticationHandler) {
        if (authenticationHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.getCachedSession();
                        runnable = new Runnable() {
                            public void run() {
                                authenticationHandler.onSuccess(CognitoUser.this.cipSession, (CognitoDevice) null);
                            }
                        };
                    } catch (CognitoNotAuthorizedException unused) {
                        runnable = new Runnable() {
                            public void run() {
                                authenticationHandler.getAuthenticationDetails(new AuthenticationContinuation(this, CognitoUser.this.context, true, authenticationHandler), this.getUserId());
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                authenticationHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void getSession(AuthenticationHandler authenticationHandler) {
        getSession(Collections.emptyMap(), authenticationHandler);
    }

    public void getSession(Map<String, String> map, AuthenticationHandler authenticationHandler) {
        if (authenticationHandler != null) {
            try {
                getCachedSession();
                authenticationHandler.onSuccess(this.cipSession, (CognitoDevice) null);
            } catch (InvalidParameterException e) {
                authenticationHandler.onFailure(e);
            } catch (CognitoNotAuthorizedException unused) {
                AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this, this.context, false, authenticationHandler);
                authenticationContinuation.setClientMetaData(map);
                authenticationHandler.getAuthenticationDetails(authenticationContinuation, getUserId());
            } catch (Exception e2) {
                authenticationHandler.onFailure(e2);
            }
        } else {
            throw new InvalidParameterException("callback is null");
        }
    }

    public Runnable initiateUserAuthentication(AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return initiateUserAuthentication(Collections.emptyMap(), authenticationDetails, authenticationHandler, z);
    }

    public Runnable initiateUserAuthentication(Map<String, String> map, AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, final boolean z) {
        final Runnable _initiateUserAuthentication = _initiateUserAuthentication(map, authenticationDetails, new AuthenticationHandler() {
            public void onSuccess(final CognitoUserSession cognitoUserSession, final CognitoDevice cognitoDevice) {
                if (z) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    AnonymousClass1 r1 = new Runnable() {
                        public void run() {
                            authenticationHandler.onSuccess(cognitoUserSession, cognitoDevice);
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                } else {
                    authenticationHandler.onSuccess(cognitoUserSession, cognitoDevice);
                }
            }

            public void getAuthenticationDetails(final AuthenticationContinuation authenticationContinuation, final String str) {
                if (z) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    AnonymousClass2 r1 = new Runnable() {
                        public void run() {
                            authenticationHandler.getAuthenticationDetails(authenticationContinuation, str);
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                } else {
                    authenticationHandler.getAuthenticationDetails(authenticationContinuation, str);
                }
            }

            public void getMFACode(final MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                if (z) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    AnonymousClass3 r1 = new Runnable() {
                        public void run() {
                            authenticationHandler.getMFACode(multiFactorAuthenticationContinuation);
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                } else {
                    authenticationHandler.getMFACode(multiFactorAuthenticationContinuation);
                }
            }

            public void authenticationChallenge(final ChallengeContinuation challengeContinuation) {
                if (z) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    AnonymousClass4 r1 = new Runnable() {
                        public void run() {
                            authenticationHandler.authenticationChallenge(challengeContinuation);
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                } else {
                    authenticationHandler.authenticationChallenge(challengeContinuation);
                }
            }

            public void onFailure(final Exception exc) {
                if (z) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    AnonymousClass5 r1 = new Runnable() {
                        public void run() {
                            authenticationHandler.onFailure(exc);
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                } else {
                    authenticationHandler.onFailure(exc);
                }
            }
        }, z);
        return z ? new Runnable() {
            public void run() {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        _initiateUserAuthentication.run();
                    }
                });
                if (!(thread instanceof Thread)) {
                    thread.start();
                } else {
                    AsynchronousInstrumentation.threadStart(thread);
                }
            }
        } : _initiateUserAuthentication;
    }

    /* access modifiers changed from: package-private */
    public Runnable _initiateUserAuthentication(Map<String, String> map, final AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, boolean z) {
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(authenticationDetails.getAuthenticationType())) {
            return startWithUserSrpAuth(map, authenticationDetails, authenticationHandler, z);
        }
        if (CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE.equals(authenticationDetails.getAuthenticationType())) {
            return startWithCustomAuth(map, authenticationDetails, authenticationHandler, z);
        }
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD.equals(authenticationDetails.getAuthenticationType())) {
            return startWithUserPasswordAuth(map, authenticationDetails, authenticationHandler, z);
        }
        return new Runnable() {
            public void run() {
                AuthenticationHandler authenticationHandler = authenticationHandler;
                authenticationHandler.onFailure(new CognitoParameterInvalidException("Unsupported authentication type " + authenticationDetails.getAuthenticationType()));
            }
        };
    }

    public Runnable respondToMfaChallenge(String str, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHandler authenticationHandler, boolean z) {
        return respondToMfaChallenge(Collections.emptyMap(), str, respondToAuthChallengeResult, authenticationHandler, z);
    }

    public Runnable respondToMfaChallenge(Map<String, String> map, String str, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHandler authenticationHandler, boolean z) {
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        HashMap hashMap = new HashMap();
        if ("SMS_MFA".equals(respondToAuthChallengeResult.getChallengeName())) {
            hashMap.put(CognitoServiceConstants.CHLG_RESP_SMS_MFA_CODE, str);
        } else if (CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(respondToAuthChallengeResult.getChallengeName())) {
            hashMap.put(CognitoServiceConstants.CHLG_RESP_SOFTWARE_TOKEN_MFA_CODE, str);
        }
        hashMap.put("USERNAME", this.usernameInternal);
        hashMap.put("DEVICE_KEY", this.deviceKey);
        hashMap.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
        respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
        respondToAuthChallengeRequest.setChallengeResponses(hashMap);
        respondToAuthChallengeRequest.setUserContextData(getUserContextData());
        respondToAuthChallengeRequest.setClientMetadata(map);
        return respondToChallenge(map, respondToAuthChallengeRequest, authenticationHandler, z);
    }

    /* access modifiers changed from: protected */
    public CognitoUserSession getCachedSession() {
        synchronized (GET_CACHED_SESSION_LOCK) {
            if (this.userId != null) {
                CognitoUserSession cognitoUserSession = this.cipSession;
                if (cognitoUserSession == null || !cognitoUserSession.isValidForThreshold()) {
                    CognitoUserSession readCachedTokens = readCachedTokens();
                    if (readCachedTokens.isValidForThreshold()) {
                        this.cipSession = readCachedTokens;
                        cacheLastAuthUser();
                        CognitoUserSession cognitoUserSession2 = this.cipSession;
                        return cognitoUserSession2;
                    } else if (readCachedTokens.getRefreshToken() != null) {
                        try {
                            CognitoUserSession refreshSession = refreshSession(readCachedTokens);
                            this.cipSession = refreshSession;
                            cacheTokens(refreshSession);
                            CognitoUserSession cognitoUserSession3 = this.cipSession;
                            return cognitoUserSession3;
                        } catch (NotAuthorizedException e) {
                            clearCachedTokens();
                            throw new CognitoNotAuthorizedException("User is not authenticated", e);
                        } catch (UserNotFoundException e2) {
                            clearCachedTokens();
                            throw new CognitoNotAuthorizedException("User does not exist", e2);
                        } catch (Exception e3) {
                            throw new CognitoInternalErrorException("Failed to authenticate user", e3);
                        }
                    } else {
                        throw new CognitoNotAuthorizedException("User is not authenticated");
                    }
                } else {
                    cacheLastAuthUser();
                    CognitoUserSession cognitoUserSession4 = this.cipSession;
                    return cognitoUserSession4;
                }
            } else {
                throw new CognitoNotAuthorizedException("User-ID is null");
            }
        }
    }

    public void changePasswordInBackground(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler != null) {
            final String str3 = str;
            final String str4 = str2;
            final GenericHandler genericHandler2 = genericHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.changePasswordInternal(str3, str4, this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler2.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void changePassword(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                changePasswordInternal(str, str2, getCachedSession());
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void changePasswordInternal(String str, String str2, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setPreviousPassword(str);
        changePasswordRequest.setProposedPassword(str2);
        changePasswordRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        this.cognitoIdentityProviderClient.changePassword(changePasswordRequest);
    }

    public void getDetailsInBackground(final GetDetailsHandler getDetailsHandler) {
        if (getDetailsHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final CognitoUserDetails access$700 = CognitoUser.this.getUserDetailsInternal(this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                getDetailsHandler.onSuccess(access$700);
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                getDetailsHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void getDetails(GetDetailsHandler getDetailsHandler) {
        if (getDetailsHandler != null) {
            try {
                getDetailsHandler.onSuccess(getUserDetailsInternal(getCachedSession()));
            } catch (Exception e) {
                getDetailsHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public CognitoUserDetails getUserDetailsInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        GetUserResult user = this.cognitoIdentityProviderClient.getUser(getUserRequest);
        return new CognitoUserDetails(new CognitoUserAttributes(user.getUserAttributes()), new CognitoUserSettings(user.getMFAOptions()));
    }

    public void getAttributeVerificationCodeInBackground(String str, VerificationHandler verificationHandler) {
        getAttributeVerificationCodeInBackground(Collections.emptyMap(), str, verificationHandler);
    }

    public void getAttributeVerificationCodeInBackground(Map<String, String> map, String str, VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            final Map<String, String> map2 = map;
            final String str2 = str;
            final VerificationHandler verificationHandler2 = verificationHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final GetUserAttributeVerificationCodeResult access$800 = CognitoUser.this.getAttributeVerificationCodeInternal(map2, str2, this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                verificationHandler2.onSuccess(new CognitoUserCodeDeliveryDetails(access$800.getCodeDeliveryDetails()));
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                verificationHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void getAttributeVerificationCode(String str, VerificationHandler verificationHandler) {
        getAttributeVerificationCode(Collections.emptyMap(), str, verificationHandler);
    }

    public void getAttributeVerificationCode(Map<String, String> map, String str, VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            try {
                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(getAttributeVerificationCodeInternal(map, str, getCachedSession()).getCodeDeliveryDetails()));
            } catch (Exception e) {
                verificationHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public GetUserAttributeVerificationCodeResult getAttributeVerificationCodeInternal(Map<String, String> map, String str, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest = new GetUserAttributeVerificationCodeRequest();
        getUserAttributeVerificationCodeRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        getUserAttributeVerificationCodeRequest.setAttributeName(str);
        getUserAttributeVerificationCodeRequest.setClientMetadata(map);
        return this.cognitoIdentityProviderClient.getUserAttributeVerificationCode(getUserAttributeVerificationCodeRequest);
    }

    public void verifyAttributeInBackground(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler != null) {
            final String str3 = str;
            final String str4 = str2;
            final GenericHandler genericHandler2 = genericHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        VerifyUserAttributeResult unused = CognitoUser.this.verifyAttributeInternal(str3, str4, this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler2.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void verifyAttribute(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                verifyAttributeInternal(str, str2, getCachedSession());
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public VerifyUserAttributeResult verifyAttributeInternal(String str, String str2, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        VerifyUserAttributeRequest verifyUserAttributeRequest = new VerifyUserAttributeRequest();
        verifyUserAttributeRequest.setAttributeName(str);
        verifyUserAttributeRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        verifyUserAttributeRequest.setCode(str2);
        return this.cognitoIdentityProviderClient.verifyUserAttribute(verifyUserAttributeRequest);
    }

    public void associateSoftwareTokenInBackground(final String str, final RegisterMfaHandler registerMfaHandler) {
        if (registerMfaHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    boolean z;
                    AssociateSoftwareTokenResult associateSoftwareTokenResult;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUserSession cachedSession = this.getCachedSession();
                        if (!StringUtils.isBlank(str)) {
                            associateSoftwareTokenResult = CognitoUser.this.associateTotpMfaInternalWithSession(str);
                            z = true;
                        } else {
                            associateSoftwareTokenResult = CognitoUser.this.associateTotpMfaInternalWithTokens(cachedSession);
                            z = false;
                        }
                        final String session = associateSoftwareTokenResult.getSession();
                        final HashMap hashMap = new HashMap();
                        hashMap.put("type", CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA);
                        hashMap.put("secretKey", associateSoftwareTokenResult.getSecretCode());
                        runnable = z ? new Runnable() {
                            public void run() {
                                registerMfaHandler.onVerify(new VerifyMfaContinuation(CognitoUser.this.context, CognitoUser.this.clientId, this, registerMfaHandler, hashMap, true, session, true));
                            }
                        } : new Runnable() {
                            public void run() {
                                registerMfaHandler.onVerify(new VerifyMfaContinuation(CognitoUser.this.context, CognitoUser.this.clientId, this, registerMfaHandler, hashMap, false, session, true));
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                registerMfaHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void associateSoftwareToken(String str, RegisterMfaHandler registerMfaHandler) {
        AssociateSoftwareTokenResult associateSoftwareTokenResult;
        boolean z;
        if (registerMfaHandler != null) {
            try {
                CognitoUserSession cachedSession = getCachedSession();
                if (!StringUtils.isBlank(str)) {
                    associateSoftwareTokenResult = associateTotpMfaInternalWithSession(str);
                    z = true;
                } else {
                    associateSoftwareTokenResult = associateTotpMfaInternalWithTokens(cachedSession);
                    z = false;
                }
                String session = associateSoftwareTokenResult.getSession();
                HashMap hashMap = new HashMap();
                hashMap.put("type", CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA);
                hashMap.put("secretKey", associateSoftwareTokenResult.getSecretCode());
                registerMfaHandler.onVerify(new VerifyMfaContinuation(this.context, this.clientId, this, registerMfaHandler, hashMap, z, session, false));
            } catch (Exception e) {
                registerMfaHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public AssociateSoftwareTokenResult associateTotpMfaInternalWithTokens(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        AssociateSoftwareTokenRequest associateSoftwareTokenRequest = new AssociateSoftwareTokenRequest();
        associateSoftwareTokenRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        return associateTotpMfaInternal(associateSoftwareTokenRequest);
    }

    /* access modifiers changed from: private */
    public AssociateSoftwareTokenResult associateTotpMfaInternalWithSession(String str) {
        if (str != null) {
            AssociateSoftwareTokenRequest associateSoftwareTokenRequest = new AssociateSoftwareTokenRequest();
            associateSoftwareTokenRequest.setSession(str);
            return associateTotpMfaInternal(associateSoftwareTokenRequest);
        }
        throw new CognitoNotAuthorizedException("session token is invalid");
    }

    private AssociateSoftwareTokenResult associateTotpMfaInternal(AssociateSoftwareTokenRequest associateSoftwareTokenRequest) {
        return this.cognitoIdentityProviderClient.associateSoftwareToken(associateSoftwareTokenRequest);
    }

    public void verifySoftwareTokenInBackground(String str, String str2, String str3, RegisterMfaHandler registerMfaHandler) {
        if (registerMfaHandler != null) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final RegisterMfaHandler registerMfaHandler2 = registerMfaHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    boolean z;
                    VerifySoftwareTokenResult verifySoftwareTokenResult;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUserSession cachedSession = this.getCachedSession();
                        if (!StringUtils.isBlank(str4)) {
                            verifySoftwareTokenResult = CognitoUser.this.verifyTotpAssociationWithSession(str4, str5, str6);
                            z = true;
                        } else {
                            verifySoftwareTokenResult = CognitoUser.this.verifyTotpAssociationWithTokens(cachedSession, str5, str6);
                            z = false;
                        }
                        final String session = verifySoftwareTokenResult.getSession();
                        if (!VerifySoftwareTokenResponseType.ERROR.equals(verifySoftwareTokenResult.getStatus())) {
                            if (z) {
                                runnable = new Runnable() {
                                    public void run() {
                                        registerMfaHandler2.onSuccess(session);
                                    }
                                };
                            } else {
                                runnable = new Runnable() {
                                    public void run() {
                                        registerMfaHandler2.onSuccess((String) null);
                                    }
                                };
                            }
                            if (!(handler instanceof Handler)) {
                                handler.post(runnable);
                            } else {
                                AsynchronousInstrumentation.handlerPost(handler, runnable);
                            }
                        } else {
                            throw new CognitoInternalErrorException("verification failed");
                        }
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                registerMfaHandler2.onFailure(e);
                            }
                        };
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void verifySoftwareToken(String str, String str2, String str3, RegisterMfaHandler registerMfaHandler) {
        boolean z;
        VerifySoftwareTokenResult verifySoftwareTokenResult;
        if (registerMfaHandler != null) {
            try {
                CognitoUserSession cachedSession = getCachedSession();
                if (!StringUtils.isBlank(str)) {
                    verifySoftwareTokenResult = verifyTotpAssociationWithSession(str, str2, str3);
                    z = true;
                } else {
                    verifySoftwareTokenResult = verifyTotpAssociationWithTokens(cachedSession, str2, str3);
                    z = false;
                }
                String session = verifySoftwareTokenResult.getSession();
                if (VerifySoftwareTokenResponseType.ERROR.equals(verifySoftwareTokenResult.getStatus())) {
                    throw new CognitoInternalErrorException("verification failed");
                } else if (z) {
                    registerMfaHandler.onSuccess(session);
                } else {
                    registerMfaHandler.onSuccess((String) null);
                }
            } catch (Exception e) {
                registerMfaHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public VerifySoftwareTokenResult verifyTotpAssociationWithTokens(CognitoUserSession cognitoUserSession, String str, String str2) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        VerifySoftwareTokenRequest verifySoftwareTokenRequest = new VerifySoftwareTokenRequest();
        verifySoftwareTokenRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        verifySoftwareTokenRequest.setUserCode(str);
        verifySoftwareTokenRequest.setFriendlyDeviceName(str2);
        return verifyTotpAssociationInternal(verifySoftwareTokenRequest);
    }

    /* access modifiers changed from: private */
    public VerifySoftwareTokenResult verifyTotpAssociationWithSession(String str, String str2, String str3) {
        if (str != null) {
            VerifySoftwareTokenRequest verifySoftwareTokenRequest = new VerifySoftwareTokenRequest();
            verifySoftwareTokenRequest.setSession(str);
            verifySoftwareTokenRequest.setUserCode(str2);
            verifySoftwareTokenRequest.setFriendlyDeviceName(str3);
            return verifyTotpAssociationInternal(verifySoftwareTokenRequest);
        }
        throw new CognitoNotAuthorizedException("session token is invalid");
    }

    private VerifySoftwareTokenResult verifyTotpAssociationInternal(VerifySoftwareTokenRequest verifySoftwareTokenRequest) {
        return this.cognitoIdentityProviderClient.verifySoftwareToken(verifySoftwareTokenRequest);
    }

    public void updateAttributesInBackground(CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        updateAttributesInBackground(Collections.emptyMap(), cognitoUserAttributes, updateAttributesHandler);
    }

    public void updateAttributesInBackground(Map<String, String> map, CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        if (updateAttributesHandler != null) {
            final Map<String, String> map2 = map;
            final CognitoUserAttributes cognitoUserAttributes2 = cognitoUserAttributes;
            final UpdateAttributesHandler updateAttributesHandler2 = updateAttributesHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        UpdateUserAttributesResult access$1500 = CognitoUser.this.updateAttributesInternal(map2, cognitoUserAttributes2, this.getCachedSession());
                        final ArrayList arrayList = new ArrayList();
                        if (access$1500.getCodeDeliveryDetailsList() != null) {
                            for (CodeDeliveryDetailsType cognitoUserCodeDeliveryDetails : access$1500.getCodeDeliveryDetailsList()) {
                                arrayList.add(new CognitoUserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails));
                            }
                        }
                        runnable = new Runnable() {
                            public void run() {
                                updateAttributesHandler2.onSuccess(arrayList);
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                updateAttributesHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void updateAttributes(CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        updateAttributes(cognitoUserAttributes, Collections.emptyMap(), updateAttributesHandler);
    }

    public void updateAttributes(CognitoUserAttributes cognitoUserAttributes, Map<String, String> map, UpdateAttributesHandler updateAttributesHandler) {
        if (updateAttributesHandler != null) {
            try {
                UpdateUserAttributesResult updateAttributesInternal = updateAttributesInternal(map, cognitoUserAttributes, getCachedSession());
                ArrayList arrayList = new ArrayList();
                if (updateAttributesInternal.getCodeDeliveryDetailsList() != null) {
                    for (CodeDeliveryDetailsType cognitoUserCodeDeliveryDetails : updateAttributesInternal.getCodeDeliveryDetailsList()) {
                        arrayList.add(new CognitoUserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails));
                    }
                }
                updateAttributesHandler.onSuccess(arrayList);
            } catch (Exception e) {
                updateAttributesHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public UpdateUserAttributesResult updateAttributesInternal(Map<String, String> map, CognitoUserAttributes cognitoUserAttributes, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        UpdateUserAttributesRequest updateUserAttributesRequest = new UpdateUserAttributesRequest();
        updateUserAttributesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        updateUserAttributesRequest.setUserAttributes(cognitoUserAttributes.getAttributesList());
        updateUserAttributesRequest.setClientMetadata(map);
        return this.cognitoIdentityProviderClient.updateUserAttributes(updateUserAttributesRequest);
    }

    public void deleteAttributesInBackground(final List<String> list, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.deleteAttributesInternal(list, this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void deleteAttributes(List<String> list, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                deleteAttributesInternal(list, getCachedSession());
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void deleteAttributesInternal(List<String> list, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        } else if (!cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        } else if (list != null && list.size() >= 1) {
            DeleteUserAttributesRequest deleteUserAttributesRequest = new DeleteUserAttributesRequest();
            deleteUserAttributesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            deleteUserAttributesRequest.setUserAttributeNames(list);
            this.cognitoIdentityProviderClient.deleteUserAttributes(deleteUserAttributesRequest);
        }
    }

    public RevokeTokenResult revokeTokens() {
        try {
            CognitoUserSession cachedSession = getCachedSession();
            if (CognitoJWTParser.hasClaim(cachedSession.getAccessToken().getJWTToken(), "origin_jti")) {
                String token = cachedSession.getRefreshToken().getToken();
                RevokeTokenRequest revokeTokenRequest = new RevokeTokenRequest();
                revokeTokenRequest.setToken(token);
                revokeTokenRequest.setClientId(this.clientId);
                if (!StringUtils.isBlank(this.clientSecret)) {
                    revokeTokenRequest.setClientSecret(this.clientSecret);
                }
                return this.cognitoIdentityProviderClient.revokeToken(revokeTokenRequest);
            }
            LOGGER.debug("Access Token does not contain `origin_jti` claim. Skip revoking tokens.");
            return null;
        } catch (Exception e) {
            LOGGER.warn("Failed to revoke tokens.", e);
            return null;
        }
    }

    public void signOut() {
        this.cipSession = null;
        clearCachedTokens();
    }

    public void globalSignOutInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.globalSignOutInternal(this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                CognitoUser.this.signOut();
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void globalSignOut(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                globalSignOutInternal(getCachedSession());
                signOut();
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void globalSignOutInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        } else if (cognitoUserSession.isValid()) {
            GlobalSignOutRequest globalSignOutRequest = new GlobalSignOutRequest();
            globalSignOutRequest.setAccessToken(getCachedSession().getAccessToken().getJWTToken());
            this.cognitoIdentityProviderClient.globalSignOut(globalSignOutRequest);
        } else {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
    }

    public void deleteUserInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.deleteUserInternal(this.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void deleteUser(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                deleteUserInternal(getCachedSession());
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void deleteUserInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        } else if (cognitoUserSession.isValid()) {
            DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
            deleteUserRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            this.cognitoIdentityProviderClient.deleteUser(deleteUserRequest);
        } else {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
    }

    public void setUserSettingsInBackground(final CognitoUserSettings cognitoUserSettings, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            final CognitoUserSession cachedSession = getCachedSession();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.setUserSettingsInternal(cognitoUserSettings, cachedSession);
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void setUserSettings(CognitoUserSettings cognitoUserSettings, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                setUserSettingsInternal(cognitoUserSettings, getCachedSession());
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void setUserSettingsInternal(CognitoUserSettings cognitoUserSettings, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        } else if (cognitoUserSettings != null) {
            SetUserSettingsRequest setUserSettingsRequest = new SetUserSettingsRequest();
            setUserSettingsRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            setUserSettingsRequest.setMFAOptions(cognitoUserSettings.getSettingsList());
            this.cognitoIdentityProviderClient.setUserSettings(setUserSettingsRequest);
        } else {
            throw new CognitoParameterInvalidException("user attributes is null");
        }
    }

    public void setUserMfaSettingsInBackground(final List<CognitoMfaSettings> list, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            final CognitoUserSession cachedSession = getCachedSession();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.setUserMfaSettingsInternal(list, cachedSession);
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void setUserMfaSettingsInternal(List<CognitoMfaSettings> list, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        } else if (list == null || list.size() < 1) {
            throw new CognitoParameterInvalidException("mfa settings are empty");
        } else {
            SetUserMFAPreferenceRequest setUserMFAPreferenceRequest = new SetUserMFAPreferenceRequest();
            setUserMFAPreferenceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            for (CognitoMfaSettings next : list) {
                if ("SMS_MFA".equals(next.getMfaName())) {
                    SMSMfaSettingsType sMSMfaSettingsType = new SMSMfaSettingsType();
                    sMSMfaSettingsType.setEnabled(Boolean.valueOf(next.isEnabled()));
                    sMSMfaSettingsType.setPreferredMfa(Boolean.valueOf(next.isPreferred()));
                    setUserMFAPreferenceRequest.setSMSMfaSettings(sMSMfaSettingsType);
                }
                if (CognitoMfaSettings.TOTP_MFA.equals(next.getMfaName())) {
                    SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType = new SoftwareTokenMfaSettingsType();
                    softwareTokenMfaSettingsType.setEnabled(Boolean.valueOf(next.isEnabled()));
                    softwareTokenMfaSettingsType.setPreferredMfa(Boolean.valueOf(next.isPreferred()));
                    setUserMFAPreferenceRequest.setSoftwareTokenMfaSettings(softwareTokenMfaSettingsType);
                }
            }
            this.cognitoIdentityProviderClient.setUserMFAPreference(setUserMFAPreferenceRequest);
        }
    }

    private void clearCachedTokens() {
        try {
            String format = String.format("CognitoIdentityProvider.%s.%s.idToken", new Object[]{this.clientId, this.userId});
            String format2 = String.format("CognitoIdentityProvider.%s.%s.accessToken", new Object[]{this.clientId, this.userId});
            String format3 = String.format("CognitoIdentityProvider.%s.%s.refreshToken", new Object[]{this.clientId, this.userId});
            this.pool.awsKeyValueStore.remove(format);
            this.pool.awsKeyValueStore.remove(format2);
            this.pool.awsKeyValueStore.remove(format3);
        } catch (Exception e) {
            LOGGER.error("Error while deleting from SharedPreferences", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a4 A[Catch:{ Exception -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d6 A[Catch:{ Exception -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession readCachedTokens() {
        /*
            r9 = this;
            java.lang.String r0 = "."
            java.lang.String r1 = "CognitoIdentityProvider."
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession r2 = new com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession
            r3 = 0
            r2.<init>(r3, r3, r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r4.<init>()     // Catch:{ Exception -> 0x0104 }
            r4.append(r1)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = r9.clientId     // Catch:{ Exception -> 0x0104 }
            r4.append(r5)     // Catch:{ Exception -> 0x0104 }
            r4.append(r0)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = r9.userId     // Catch:{ Exception -> 0x0104 }
            r4.append(r5)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = ".idToken"
            r4.append(r5)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r5.<init>()     // Catch:{ Exception -> 0x0104 }
            r5.append(r1)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r6 = r9.clientId     // Catch:{ Exception -> 0x0104 }
            r5.append(r6)     // Catch:{ Exception -> 0x0104 }
            r5.append(r0)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r6 = r9.userId     // Catch:{ Exception -> 0x0104 }
            r5.append(r6)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r6 = ".accessToken"
            r5.append(r6)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r6.<init>()     // Catch:{ Exception -> 0x0104 }
            r6.append(r1)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r9.clientId     // Catch:{ Exception -> 0x0104 }
            r6.append(r1)     // Catch:{ Exception -> 0x0104 }
            r6.append(r0)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = r9.userId     // Catch:{ Exception -> 0x0104 }
            r6.append(r0)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = ".refreshToken"
            r6.append(r0)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r1 = r9.pool     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.internal.keyvaluestore.AWSKeyValueStore r1 = r1.awsKeyValueStore     // Catch:{ Exception -> 0x0104 }
            boolean r1 = r1.contains(r4)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r6 = " is null."
            java.lang.String r7 = "IdToken for "
            if (r1 == 0) goto L_0x0099
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r1 = r9.pool     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.internal.keyvaluestore.AWSKeyValueStore r1 = r1.awsKeyValueStore     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.get(r4)     // Catch:{ Exception -> 0x0104 }
            if (r1 == 0) goto L_0x0082
            com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken r4 = new com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken     // Catch:{ Exception -> 0x0104 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0104 }
            goto L_0x009a
        L_0x0082:
            com.amazonaws.logging.Log r1 = LOGGER     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r8.<init>()     // Catch:{ Exception -> 0x0104 }
            r8.append(r7)     // Catch:{ Exception -> 0x0104 }
            r8.append(r4)     // Catch:{ Exception -> 0x0104 }
            r8.append(r6)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x0104 }
            r1.warn(r4)     // Catch:{ Exception -> 0x0104 }
        L_0x0099:
            r4 = r3
        L_0x009a:
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r1 = r9.pool     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.internal.keyvaluestore.AWSKeyValueStore r1 = r1.awsKeyValueStore     // Catch:{ Exception -> 0x0104 }
            boolean r1 = r1.contains(r5)     // Catch:{ Exception -> 0x0104 }
            if (r1 == 0) goto L_0x00cb
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r1 = r9.pool     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.internal.keyvaluestore.AWSKeyValueStore r1 = r1.awsKeyValueStore     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.get(r5)     // Catch:{ Exception -> 0x0104 }
            if (r1 == 0) goto L_0x00b4
            com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken r5 = new com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken     // Catch:{ Exception -> 0x0104 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0104 }
            goto L_0x00cc
        L_0x00b4:
            com.amazonaws.logging.Log r1 = LOGGER     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r8.<init>()     // Catch:{ Exception -> 0x0104 }
            r8.append(r7)     // Catch:{ Exception -> 0x0104 }
            r8.append(r5)     // Catch:{ Exception -> 0x0104 }
            r8.append(r6)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x0104 }
            r1.warn(r5)     // Catch:{ Exception -> 0x0104 }
        L_0x00cb:
            r5 = r3
        L_0x00cc:
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r1 = r9.pool     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.internal.keyvaluestore.AWSKeyValueStore r1 = r1.awsKeyValueStore     // Catch:{ Exception -> 0x0104 }
            boolean r1 = r1.contains(r0)     // Catch:{ Exception -> 0x0104 }
            if (r1 == 0) goto L_0x00fd
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r1 = r9.pool     // Catch:{ Exception -> 0x0104 }
            com.amazonaws.internal.keyvaluestore.AWSKeyValueStore r1 = r1.awsKeyValueStore     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.get(r0)     // Catch:{ Exception -> 0x0104 }
            if (r1 == 0) goto L_0x00e6
            com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken r3 = new com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken     // Catch:{ Exception -> 0x0104 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0104 }
            goto L_0x00fd
        L_0x00e6:
            com.amazonaws.logging.Log r1 = LOGGER     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r8.<init>()     // Catch:{ Exception -> 0x0104 }
            r8.append(r7)     // Catch:{ Exception -> 0x0104 }
            r8.append(r0)     // Catch:{ Exception -> 0x0104 }
            r8.append(r6)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x0104 }
            r1.warn(r0)     // Catch:{ Exception -> 0x0104 }
        L_0x00fd:
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession r0 = new com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession     // Catch:{ Exception -> 0x0104 }
            r0.<init>(r4, r5, r3)     // Catch:{ Exception -> 0x0104 }
            r2 = r0
            goto L_0x010c
        L_0x0104:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = LOGGER
            java.lang.String r3 = "Error while reading the tokens from the persistent store."
            r1.error(r3, r0)
        L_0x010c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.readCachedTokens():com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession");
    }

    /* access modifiers changed from: package-private */
    public void cacheTokens(CognitoUserSession cognitoUserSession) {
        try {
            String str = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".idToken";
            String str2 = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".accessToken";
            String str3 = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".refreshToken";
            String str4 = "CognitoIdentityProvider." + this.clientId + ".LastAuthUser";
            if (cognitoUserSession != null) {
                String str5 = null;
                this.pool.awsKeyValueStore.put(str, cognitoUserSession.getIdToken() != null ? cognitoUserSession.getIdToken().getJWTToken() : null);
                this.pool.awsKeyValueStore.put(str2, cognitoUserSession.getAccessToken() != null ? cognitoUserSession.getAccessToken().getJWTToken() : null);
                AWSKeyValueStore aWSKeyValueStore = this.pool.awsKeyValueStore;
                if (cognitoUserSession.getRefreshToken() != null) {
                    str5 = cognitoUserSession.getRefreshToken().getToken();
                }
                aWSKeyValueStore.put(str3, str5);
            }
            this.pool.awsKeyValueStore.put(str4, this.userId);
        } catch (Exception e) {
            LOGGER.error("Error while writing to SharedPreferences.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void cacheLastAuthUser() {
        try {
            this.pool.awsKeyValueStore.put("CognitoIdentityProvider." + this.clientId + ".LastAuthUser", this.userId);
        } catch (Exception e) {
            LOGGER.error("Error while writing to SharedPreferences.", e);
        }
    }

    private CognitoUserSession getCognitoUserSession(AuthenticationResultType authenticationResultType) {
        return getCognitoUserSession(authenticationResultType, (CognitoRefreshToken) null);
    }

    private CognitoUserSession getCognitoUserSession(AuthenticationResultType authenticationResultType, CognitoRefreshToken cognitoRefreshToken) {
        CognitoIdToken cognitoIdToken = new CognitoIdToken(authenticationResultType.getIdToken());
        CognitoAccessToken cognitoAccessToken = new CognitoAccessToken(authenticationResultType.getAccessToken());
        if (cognitoRefreshToken == null) {
            cognitoRefreshToken = new CognitoRefreshToken(authenticationResultType.getRefreshToken());
        }
        return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
    }

    private CognitoUserSession refreshSession(CognitoUserSession cognitoUserSession) {
        InitiateAuthResult initiateAuth = this.cognitoIdentityProviderClient.initiateAuth(initiateRefreshTokenAuthRequest(cognitoUserSession));
        if (initiateAuth.getAuthenticationResult() != null) {
            return getCognitoUserSession(initiateAuth.getAuthenticationResult(), cognitoUserSession.getRefreshToken());
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    public Runnable respondToChallenge(RespondToAuthChallengeRequest respondToAuthChallengeRequest, AuthenticationHandler authenticationHandler, boolean z) {
        return respondToChallenge(Collections.emptyMap(), respondToAuthChallengeRequest, authenticationHandler, z);
    }

    public Runnable respondToChallenge(Map<String, String> map, RespondToAuthChallengeRequest respondToAuthChallengeRequest, final AuthenticationHandler authenticationHandler, boolean z) {
        if (respondToAuthChallengeRequest != null) {
            try {
                if (respondToAuthChallengeRequest.getChallengeResponses() != null) {
                    respondToAuthChallengeRequest.getChallengeResponses().put("DEVICE_KEY", this.deviceKey);
                }
            } catch (ResourceNotFoundException e) {
                if (!e.getMessage().contains("Device")) {
                    return new Runnable() {
                        public void run() {
                            authenticationHandler.onFailure(e);
                        }
                    };
                }
                CognitoDeviceHelper.clearCachedDevice(this.usernameInternal, this.pool.getUserPoolId(), this.context);
                final boolean z2 = z;
                final AuthenticationHandler authenticationHandler2 = authenticationHandler;
                final Map<String, String> map2 = map;
                return new Runnable() {
                    public void run() {
                        AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this, CognitoUser.this.context, z2, authenticationHandler2);
                        authenticationContinuation.setClientMetaData(map2);
                        authenticationHandler2.getAuthenticationDetails(authenticationContinuation, this.getUserId());
                    }
                };
            } catch (Exception e2) {
                return new Runnable() {
                    public void run() {
                        authenticationHandler.onFailure(e2);
                    }
                };
            }
        }
        return handleChallenge(map, this.cognitoIdentityProviderClient.respondToAuthChallenge(respondToAuthChallengeRequest), (AuthenticationDetails) null, authenticationHandler, z);
    }

    private Runnable startWithUserSrpAuth(Map<String, String> map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        final Map<String, String> map2 = map;
        final AuthenticationDetails authenticationDetails2 = authenticationDetails;
        final AuthenticationHandler authenticationHandler2 = authenticationHandler;
        final boolean z2 = z;
        return new Runnable() {
            public void run() {
                AuthenticationHelper authenticationHelper = new AuthenticationHelper(CognitoUser.this.pool.getUserPoolId());
                try {
                    InitiateAuthResult initiateAuth = CognitoUser.this.cognitoIdentityProviderClient.initiateAuth(CognitoUser.this.initiateUserSrpAuthRequest(map2, authenticationDetails2, authenticationHelper));
                    CognitoUser.this.updateInternalUsername(initiateAuth.getChallengeParameters());
                    if (!CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(initiateAuth.getChallengeName())) {
                        CognitoUser.this.handleChallenge((Map<String, String>) map2, initiateAuth, authenticationDetails2, authenticationHandler2, z2).run();
                    } else if (authenticationDetails2.getPassword() != null) {
                        CognitoUser.this.respondToChallenge(map2, CognitoUser.this.userSrpAuthRequest(map2, initiateAuth.getChallengeParameters(), authenticationDetails2.getPassword(), initiateAuth.getChallengeName(), initiateAuth.getSession(), authenticationHelper), authenticationHandler2, z2).run();
                    } else {
                        throw new IllegalStateException("Failed to find password in authentication details to response to PASSWORD_VERIFIER challenge");
                    }
                } catch (ResourceNotFoundException e) {
                    CognitoUser cognitoUser = CognitoUser.this;
                    if (e.getMessage().contains("Device")) {
                        CognitoDeviceHelper.clearCachedDevice(CognitoUser.this.usernameInternal, CognitoUser.this.pool.getUserPoolId(), CognitoUser.this.context);
                        AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(cognitoUser, CognitoUser.this.context, z2, authenticationHandler2);
                        authenticationContinuation.setClientMetaData(map2);
                        authenticationHandler2.getAuthenticationDetails(authenticationContinuation, cognitoUser.getUserId());
                        return;
                    }
                    authenticationHandler2.onFailure(e);
                } catch (Exception e2) {
                    authenticationHandler2.onFailure(e2);
                }
            }
        };
    }

    private Runnable startWithCustomAuth(Map<String, String> map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        final Map<String, String> map2 = map;
        final AuthenticationDetails authenticationDetails2 = authenticationDetails;
        final AuthenticationHandler authenticationHandler2 = authenticationHandler;
        final boolean z2 = z;
        return new Runnable() {
            public void run() {
                try {
                    AuthenticationHelper authenticationHelper = new AuthenticationHelper(CognitoUser.this.getUserPoolId());
                    InitiateAuthResult initiateAuth = CognitoUser.this.cognitoIdentityProviderClient.initiateAuth(CognitoUser.this.initiateCustomAuthRequest(map2, authenticationDetails2, authenticationHelper));
                    CognitoUser.this.updateInternalUsername(initiateAuth.getChallengeParameters());
                    if (!CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(initiateAuth.getChallengeName())) {
                        CognitoUser.this.handleChallenge((Map<String, String>) map2, initiateAuth, authenticationDetails2, authenticationHandler2, z2).run();
                    } else if (authenticationDetails2.getPassword() != null) {
                        CognitoUser.this.respondToChallenge(map2, CognitoUser.this.userSrpAuthRequest(map2, initiateAuth.getChallengeParameters(), authenticationDetails2.getPassword(), initiateAuth.getChallengeName(), initiateAuth.getSession(), authenticationHelper), authenticationHandler2, z2).run();
                    } else {
                        throw new IllegalStateException("Failed to find password in authentication details to response to PASSWORD_VERIFIER challenge");
                    }
                } catch (Exception e) {
                    authenticationHandler2.onFailure(e);
                }
            }
        };
    }

    private Runnable handleChallenge(Map<String, String> map, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, boolean z) {
        AnonymousClass26 r13 = new Runnable() {
            public void run() {
                authenticationHandler.onFailure(new CognitoInternalErrorException("Authentication failed due to an internal error"));
            }
        };
        if (respondToAuthChallengeResult == null) {
            return r13;
        }
        updateInternalUsername(respondToAuthChallengeResult.getChallengeParameters());
        String challengeName = respondToAuthChallengeResult.getChallengeName();
        if (challengeName == null) {
            final CognitoUserSession cognitoUserSession = getCognitoUserSession(respondToAuthChallengeResult.getAuthenticationResult());
            cacheTokens(cognitoUserSession);
            NewDeviceMetadataType newDeviceMetadata = respondToAuthChallengeResult.getAuthenticationResult().getNewDeviceMetadata();
            if (newDeviceMetadata == null) {
                return new Runnable() {
                    public void run() {
                        authenticationHandler.onSuccess(cognitoUserSession, (CognitoDevice) null);
                    }
                };
            }
            ConfirmDeviceResult confirmDevice = confirmDevice(newDeviceMetadata);
            if (confirmDevice == null || !confirmDevice.isUserConfirmationNecessary().booleanValue()) {
                return new Runnable() {
                    public void run() {
                        authenticationHandler.onSuccess(cognitoUserSession, (CognitoDevice) null);
                    }
                };
            }
            final CognitoDevice cognitoDevice = new CognitoDevice(newDeviceMetadata.getDeviceKey(), (CognitoUserAttributes) null, (Date) null, (Date) null, (Date) null, this, this.context);
            return new Runnable() {
                public void run() {
                    authenticationHandler.onSuccess(cognitoUserSession, cognitoDevice);
                }
            };
        } else if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(challengeName)) {
            return new Runnable() {
                public void run() {
                    authenticationHandler.onFailure(new CognitoInternalErrorException("Authentication failed due to an internal error: PASSWORD_VERIFIER challenge encountered not at the start of authentication flow"));
                }
            };
        } else {
            if ("SMS_MFA".equals(challengeName) || CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(challengeName)) {
                final MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation = new MultiFactorAuthenticationContinuation(this, this.context, respondToAuthChallengeResult, z, authenticationHandler);
                multiFactorAuthenticationContinuation.setClientMetaData(map);
                return new Runnable() {
                    public void run() {
                        authenticationHandler.getMFACode(multiFactorAuthenticationContinuation);
                    }
                };
            } else if (CognitoServiceConstants.CHLG_TYPE_SELECT_MFA_TYPE.equals(challengeName)) {
                final ChooseMfaContinuation chooseMfaContinuation = new ChooseMfaContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z, authenticationHandler);
                return new Runnable() {
                    public void run() {
                        authenticationHandler.authenticationChallenge(chooseMfaContinuation);
                    }
                };
            } else if (CognitoServiceConstants.CHLG_TYPE_MFA_SETUP.equals(challengeName)) {
                final RegisterMfaContinuation registerMfaContinuation = new RegisterMfaContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z, authenticationHandler);
                return new Runnable() {
                    public void run() {
                        authenticationHandler.authenticationChallenge(registerMfaContinuation);
                    }
                };
            } else if (CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH.equals(challengeName)) {
                return deviceSrpAuthentication(map, respondToAuthChallengeResult, authenticationHandler, z);
            } else {
                if (CognitoServiceConstants.CHLG_TYPE_NEW_PASSWORD_REQUIRED.equals(challengeName)) {
                    Context context2 = this.context;
                    String str = this.usernameInternal;
                    String str2 = this.clientId;
                    final NewPasswordContinuation newPasswordContinuation = new NewPasswordContinuation(this, context2, str, str2, CognitoSecretHash.getSecretHash(str, str2, this.clientSecret), respondToAuthChallengeResult, z, authenticationHandler);
                    return new Runnable() {
                        public void run() {
                            authenticationHandler.authenticationChallenge(newPasswordContinuation);
                        }
                    };
                }
                Context context3 = this.context;
                String str3 = this.usernameInternal;
                String str4 = this.clientId;
                final ChallengeContinuation challengeContinuation = new ChallengeContinuation(this, context3, str3, str4, CognitoSecretHash.getSecretHash(str3, str4, this.clientSecret), respondToAuthChallengeResult, z, authenticationHandler);
                challengeContinuation.setClientMetaData(map);
                return new Runnable() {
                    public void run() {
                        authenticationHandler.authenticationChallenge(challengeContinuation);
                    }
                };
            }
        }
    }

    /* access modifiers changed from: private */
    public Runnable handleChallenge(Map<String, String> map, InitiateAuthResult initiateAuthResult, AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, boolean z) {
        try {
            RespondToAuthChallengeResult respondToAuthChallengeResult = new RespondToAuthChallengeResult();
            respondToAuthChallengeResult.setChallengeName(initiateAuthResult.getChallengeName());
            respondToAuthChallengeResult.setSession(initiateAuthResult.getSession());
            respondToAuthChallengeResult.setAuthenticationResult(initiateAuthResult.getAuthenticationResult());
            respondToAuthChallengeResult.setChallengeParameters(initiateAuthResult.getChallengeParameters());
            return handleChallenge(map, respondToAuthChallengeResult, authenticationDetails, authenticationHandler, z);
        } catch (Exception e) {
            return new Runnable() {
                public void run() {
                    authenticationHandler.onFailure(e);
                }
            };
        }
    }

    private Runnable startWithUserPasswordAuth(Map<String, String> map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        final Map<String, String> map2 = map;
        final AuthenticationDetails authenticationDetails2 = authenticationDetails;
        final AuthenticationHandler authenticationHandler2 = authenticationHandler;
        final boolean z2 = z;
        return new Runnable() {
            public void run() {
                try {
                    InitiateAuthResult initiateAuth = CognitoUser.this.cognitoIdentityProviderClient.initiateAuth(CognitoUser.this.initiateUserPasswordAuthRequest(map2, authenticationDetails2));
                    String unused = CognitoUser.this.usernameInternal = initiateAuth.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_USER_ID_FOR_SRP);
                    CognitoUser.this.handleChallenge((Map<String, String>) map2, initiateAuth, authenticationDetails2, authenticationHandler2, z2).run();
                } catch (Exception e) {
                    authenticationHandler2.onFailure(e);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public InitiateAuthRequest initiateUserPasswordAuthRequest(Map<String, String> map, AuthenticationDetails authenticationDetails) {
        if (StringUtils.isBlank(authenticationDetails.getUserId()) || StringUtils.isBlank(authenticationDetails.getPassword())) {
            throw new CognitoNotAuthorizedException("User name and password are required");
        }
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setClientMetadata(map);
        initiateAuthRequest.addAuthParametersEntry("USERNAME", authenticationDetails.getUserId());
        initiateAuthRequest.addAuthParametersEntry("PASSWORD", authenticationDetails.getPassword());
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", CognitoSecretHash.getSecretHash(this.userId, this.clientId, this.clientSecret));
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType next : authenticationDetails.getValidationData()) {
                hashMap.put(next.getName(), next.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        return initiateAuthRequest;
    }

    private Runnable deviceSrpAuthentication(Map<String, String> map, RespondToAuthChallengeResult respondToAuthChallengeResult, final AuthenticationHandler authenticationHandler, boolean z) {
        String deviceSecret = CognitoDeviceHelper.getDeviceSecret(this.usernameInternal, this.pool.getUserPoolId(), this.context);
        String deviceGroupKey = CognitoDeviceHelper.getDeviceGroupKey(this.usernameInternal, this.pool.getUserPoolId(), this.context);
        AuthenticationHelper authenticationHelper = new AuthenticationHelper(deviceGroupKey);
        try {
            RespondToAuthChallengeResult respondToAuthChallenge = this.cognitoIdentityProviderClient.respondToAuthChallenge(initiateDevicesAuthRequest(map, respondToAuthChallengeResult, authenticationHelper));
            if (!CognitoServiceConstants.CHLG_TYPE_DEVICE_PASSWORD_VERIFIER.equals(respondToAuthChallenge.getChallengeName())) {
                return handleChallenge(map, respondToAuthChallenge, (AuthenticationDetails) null, authenticationHandler, z);
            }
            return handleChallenge(map, this.cognitoIdentityProviderClient.respondToAuthChallenge(deviceSrpAuthRequest(map, respondToAuthChallenge, deviceSecret, deviceGroupKey, authenticationHelper)), (AuthenticationDetails) null, authenticationHandler, z);
        } catch (NotAuthorizedException unused) {
            CognitoDeviceHelper.clearCachedDevice(this.usernameInternal, this.pool.getUserPoolId(), this.context);
            final boolean z2 = z;
            final AuthenticationHandler authenticationHandler2 = authenticationHandler;
            final Map<String, String> map2 = map;
            return new Runnable() {
                public void run() {
                    AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this, CognitoUser.this.context, z2, authenticationHandler2);
                    authenticationContinuation.setClientMetaData(map2);
                    authenticationHandler2.getAuthenticationDetails(authenticationContinuation, this.getUserId());
                }
            };
        } catch (Exception e) {
            return new Runnable() {
                public void run() {
                    authenticationHandler.onFailure(e);
                }
            };
        }
    }

    /* access modifiers changed from: private */
    public InitiateAuthRequest initiateUserSrpAuthRequest(Map<String, String> map, AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        this.userId = authenticationDetails.getUserId();
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setClientMetadata(map);
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", CognitoSecretHash.getSecretHash(this.userId, this.clientId, this.clientSecret));
        initiateAuthRequest.addAuthParametersEntry("USERNAME", authenticationDetails.getUserId());
        initiateAuthRequest.addAuthParametersEntry("SRP_A", authenticationHelper.getA().toString(16));
        String str = this.deviceKey;
        if (str == null) {
            initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", CognitoDeviceHelper.getDeviceKey(authenticationDetails.getUserId(), this.pool.getUserPoolId(), this.context));
        } else {
            initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", str);
        }
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType next : authenticationDetails.getValidationData()) {
                hashMap.put(next.getName(), next.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            initiateAuthRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    /* access modifiers changed from: private */
    public InitiateAuthRequest initiateCustomAuthRequest(Map<String, String> map, AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setClientMetadata(map);
        Map<String, String> authenticationParameters = authenticationDetails.getAuthenticationParameters();
        if (this.clientSecret != null && authenticationParameters.get("SECRET_HASH") == null) {
            String secretHash2 = CognitoSecretHash.getSecretHash(authenticationDetails.getUserId(), this.clientId, this.clientSecret);
            this.secretHash = secretHash2;
            authenticationParameters.put("SECRET_HASH", secretHash2);
        }
        if ("SRP_A".equals(authenticationDetails.getCustomChallenge())) {
            authenticationParameters.put("SRP_A", authenticationHelper.getA().toString(16));
        }
        initiateAuthRequest.setAuthParameters(authenticationDetails.getAuthenticationParameters());
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType next : authenticationDetails.getValidationData()) {
                hashMap.put(next.getName(), next.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    private RespondToAuthChallengeRequest initiateDevicesAuthRequest(Map<String, String> map, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHelper authenticationHelper) {
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeName(CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH);
        respondToAuthChallengeRequest.setClientMetadata(map);
        respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
        respondToAuthChallengeRequest.addChallengeResponsesEntry("USERNAME", this.usernameInternal);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("SRP_A", authenticationHelper.getA().toString(16));
        respondToAuthChallengeRequest.addChallengeResponsesEntry("DEVICE_KEY", this.deviceKey);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setUserContextData(getUserContextData());
        return respondToAuthChallengeRequest;
    }

    private InitiateAuthRequest initiateRefreshTokenAuthRequest(CognitoUserSession cognitoUserSession) {
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.addAuthParametersEntry(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN, cognitoUserSession.getRefreshToken().getToken());
        if (this.deviceKey == null) {
            String str = this.usernameInternal;
            if (str != null) {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            } else {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(cognitoUserSession.getUsername(), this.pool.getUserPoolId(), this.context);
            }
        }
        initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", this.deviceKey);
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", this.clientSecret);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            initiateAuthRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    /* access modifiers changed from: private */
    public RespondToAuthChallengeRequest userSrpAuthRequest(Map<String, String> map, Map<String, String> map2, String str, String str2, String str3, AuthenticationHelper authenticationHelper) {
        String str4 = map2.get("USERNAME");
        String str5 = map2.get(CognitoServiceConstants.CHLG_PARAM_USER_ID_FOR_SRP);
        String str6 = map2.get(CognitoServiceConstants.CHLG_PARAM_SALT);
        String str7 = map2.get(CognitoServiceConstants.CHLG_PARAM_SECRET_BLOCK);
        this.usernameInternal = str4;
        this.deviceKey = CognitoDeviceHelper.getDeviceKey(str4, this.pool.getUserPoolId(), this.context);
        this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
        BigInteger bigInteger = new BigInteger(map2.get(CognitoServiceConstants.CHLG_PARAM_SRP_B), 16);
        if (!bigInteger.mod(AuthenticationHelper.N).equals(BigInteger.ZERO)) {
            byte[] passwordAuthenticationKey = authenticationHelper.getPasswordAuthenticationKey(str5, str, bigInteger, new BigInteger(str6, 16));
            Date date = new Date();
            try {
                Mac instance = Mac.getInstance("HmacSHA256");
                instance.init(new SecretKeySpec(passwordAuthenticationKey, "HmacSHA256"));
                instance.update(this.pool.getUserPoolId().split("_", 2)[1].getBytes(StringUtils.UTF8));
                instance.update(str5.getBytes(StringUtils.UTF8));
                instance.update(Base64.decode(str7));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String format = simpleDateFormat.format(date);
                byte[] doFinal = instance.doFinal(format.getBytes(StringUtils.UTF8));
                HashMap hashMap = new HashMap();
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SECRET_BLOCK, str7);
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SIGNATURE, new String(Base64.encode(doFinal), StringUtils.UTF8));
                hashMap.put(CognitoServiceConstants.CHLG_RESP_TIMESTAMP, format);
                hashMap.put("USERNAME", this.usernameInternal);
                hashMap.put("DEVICE_KEY", this.deviceKey);
                hashMap.put("SECRET_HASH", this.secretHash);
                RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
                respondToAuthChallengeRequest.setChallengeName(str2);
                respondToAuthChallengeRequest.setClientId(this.clientId);
                respondToAuthChallengeRequest.setSession(str3);
                respondToAuthChallengeRequest.setChallengeResponses(hashMap);
                respondToAuthChallengeRequest.setClientMetadata(map);
                String pinpointEndpointId = this.pool.getPinpointEndpointId();
                if (pinpointEndpointId != null) {
                    AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
                    analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
                    respondToAuthChallengeRequest.setAnalyticsMetadata(analyticsMetadataType);
                }
                respondToAuthChallengeRequest.setUserContextData(getUserContextData());
                return respondToAuthChallengeRequest;
            } catch (Exception e) {
                throw new CognitoInternalErrorException("SRP error", e);
            }
        } else {
            throw new CognitoInternalErrorException("SRP error, B cannot be zero");
        }
    }

    public RespondToAuthChallengeRequest deviceSrpAuthRequest(Map<String, String> map, RespondToAuthChallengeResult respondToAuthChallengeResult, String str, String str2, AuthenticationHelper authenticationHelper) {
        this.usernameInternal = respondToAuthChallengeResult.getChallengeParameters().get("USERNAME");
        BigInteger bigInteger = new BigInteger(respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SRP_B), 16);
        if (!bigInteger.mod(AuthenticationHelper.N).equals(BigInteger.ZERO)) {
            byte[] passwordAuthenticationKey = authenticationHelper.getPasswordAuthenticationKey(this.deviceKey, str, bigInteger, new BigInteger(respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SALT), 16));
            Date date = new Date();
            try {
                Mac instance = Mac.getInstance("HmacSHA256");
                instance.init(new SecretKeySpec(passwordAuthenticationKey, "HmacSHA256"));
                instance.update(str2.getBytes(StringUtils.UTF8));
                instance.update(this.deviceKey.getBytes(StringUtils.UTF8));
                instance.update(Base64.decode(respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SECRET_BLOCK)));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String format = simpleDateFormat.format(date);
                byte[] doFinal = instance.doFinal(format.getBytes(StringUtils.UTF8));
                this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
                HashMap hashMap = new HashMap();
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SECRET_BLOCK, respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SECRET_BLOCK));
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SIGNATURE, new String(Base64.encode(doFinal), StringUtils.UTF8));
                hashMap.put(CognitoServiceConstants.CHLG_RESP_TIMESTAMP, format);
                hashMap.put("USERNAME", this.usernameInternal);
                hashMap.put("DEVICE_KEY", this.deviceKey);
                hashMap.put("SECRET_HASH", this.secretHash);
                RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
                respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
                respondToAuthChallengeRequest.setClientId(this.clientId);
                respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
                respondToAuthChallengeRequest.setChallengeResponses(hashMap);
                respondToAuthChallengeRequest.setUserContextData(getUserContextData());
                respondToAuthChallengeRequest.setClientMetadata(map);
                return respondToAuthChallengeRequest;
            } catch (Exception e) {
                throw new CognitoInternalErrorException("SRP error", e);
            }
        } else {
            throw new CognitoInternalErrorException("SRP error, B cannot be zero");
        }
    }

    public void listDevicesInBackground(int i, String str, DevicesHandler devicesHandler) {
        if (devicesHandler != null) {
            final int i2 = i;
            final String str2 = str;
            final DevicesHandler devicesHandler2 = devicesHandler;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        ListDevicesResult access$3100 = CognitoUser.this.listDevicesInternal(this.getCachedSession(), i2, str2);
                        final ArrayList arrayList = new ArrayList();
                        for (DeviceType cognitoDevice : access$3100.getDevices()) {
                            arrayList.add(new CognitoDevice(cognitoDevice, this, CognitoUser.this.context));
                        }
                        runnable = new Runnable() {
                            public void run() {
                                devicesHandler2.onSuccess(arrayList);
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                devicesHandler2.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void listDevices(int i, String str, DevicesHandler devicesHandler) {
        if (devicesHandler != null) {
            try {
                ListDevicesResult listDevicesInternal = listDevicesInternal(getCachedSession(), i, str);
                ArrayList arrayList = new ArrayList();
                for (DeviceType cognitoDevice : listDevicesInternal.getDevices()) {
                    arrayList.add(new CognitoDevice(cognitoDevice, this, this.context));
                }
                devicesHandler.onSuccess(arrayList);
            } catch (Exception e) {
                devicesHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public CognitoDevice thisDevice() {
        if (this.deviceKey == null) {
            String str = this.usernameInternal;
            if (str != null) {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            } else {
                String str2 = this.userId;
                if (str2 != null) {
                    String deviceKey2 = CognitoDeviceHelper.getDeviceKey(str2, this.pool.getUserPoolId(), this.context);
                    this.deviceKey = deviceKey2;
                    if (deviceKey2 == null) {
                        this.deviceKey = CognitoDeviceHelper.getDeviceKey(readCachedTokens().getUsername(), this.pool.getUserPoolId(), this.context);
                    }
                }
            }
        }
        String str3 = this.deviceKey;
        if (str3 == null) {
            return null;
        }
        return new CognitoDevice(str3, (CognitoUserAttributes) null, (Date) null, (Date) null, (Date) null, this, this.context);
    }

    private ConfirmDeviceResult confirmDevice(NewDeviceMetadataType newDeviceMetadataType) {
        Map<String, String> generateVerificationParameters = CognitoDeviceHelper.generateVerificationParameters(newDeviceMetadataType.getDeviceKey(), newDeviceMetadataType.getDeviceGroupKey());
        new ConfirmDeviceResult().setUserConfirmationNecessary(false);
        try {
            ConfirmDeviceResult confirmDeviceInternal = confirmDeviceInternal(getCachedSession(), newDeviceMetadataType.getDeviceKey(), generateVerificationParameters.get("verifier"), generateVerificationParameters.get("salt"), CognitoDeviceHelper.getDeviceName());
            CognitoDeviceHelper.cacheDeviceKey(this.usernameInternal, this.pool.getUserPoolId(), newDeviceMetadataType.getDeviceKey(), this.context);
            CognitoDeviceHelper.cacheDeviceVerifier(this.usernameInternal, this.pool.getUserPoolId(), generateVerificationParameters.get("secret"), this.context);
            CognitoDeviceHelper.cacheDeviceGroupKey(this.usernameInternal, this.pool.getUserPoolId(), newDeviceMetadataType.getDeviceGroupKey(), this.context);
            return confirmDeviceInternal;
        } catch (Exception e) {
            LOGGER.error("Device confirmation failed: ", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public ListDevicesResult listDevicesInternal(CognitoUserSession cognitoUserSession, int i, String str) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
        ListDevicesRequest listDevicesRequest = new ListDevicesRequest();
        if (i < 1) {
            listDevicesRequest.setLimit(10);
        } else {
            listDevicesRequest.setLimit(Integer.valueOf(i));
        }
        listDevicesRequest.setPaginationToken(str);
        listDevicesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        return this.cognitoIdentityProviderClient.listDevices(listDevicesRequest);
    }

    private ConfirmDeviceResult confirmDeviceInternal(CognitoUserSession cognitoUserSession, String str, String str2, String str3, String str4) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        } else if (str != null && str4 != null) {
            DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = new DeviceSecretVerifierConfigType();
            deviceSecretVerifierConfigType.setPasswordVerifier(str2);
            deviceSecretVerifierConfigType.setSalt(str3);
            ConfirmDeviceRequest confirmDeviceRequest = new ConfirmDeviceRequest();
            confirmDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            confirmDeviceRequest.setDeviceKey(str);
            confirmDeviceRequest.setDeviceName(str4);
            confirmDeviceRequest.setDeviceSecretVerifierConfig(deviceSecretVerifierConfigType);
            return this.cognitoIdentityProviderClient.confirmDevice(confirmDeviceRequest);
        } else if (str == null) {
            throw new CognitoParameterInvalidException("Device key is null");
        } else {
            throw new CognitoParameterInvalidException("Device name is null");
        }
    }

    /* access modifiers changed from: private */
    public void updateInternalUsername(Map<String, String> map) {
        if (this.usernameInternal == null && map != null && map.containsKey("USERNAME")) {
            String str = map.get("USERNAME");
            this.usernameInternal = str;
            this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            if (this.secretHash == null) {
                this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
            }
        }
    }

    private UserContextDataType getUserContextData() {
        return this.pool.getUserContextData(this.userId);
    }

    private static class AuthenticationHelper {
        private static final String DERIVED_KEY_INFO = "Caldera Derived Key";
        private static final int DERIVED_KEY_SIZE = 16;
        private static final int EPHEMERAL_KEY_LENGTH = 1024;
        private static final BigInteger GG;
        private static final String HEX_N = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
        private static final BigInteger KK;
        /* access modifiers changed from: private */
        public static final BigInteger N;
        private static final SecureRandom SECURE_RANDOM;
        private static final ThreadLocal<MessageDigest> THREAD_MESSAGE_DIGEST;
        private BigInteger A;
        private BigInteger a;
        private String poolName;

        public AuthenticationHelper(String str) {
            BigInteger bigInteger;
            BigInteger modPow;
            do {
                BigInteger bigInteger2 = new BigInteger(1024, SECURE_RANDOM);
                bigInteger = N;
                BigInteger mod = bigInteger2.mod(bigInteger);
                this.a = mod;
                modPow = GG.modPow(mod, bigInteger);
                this.A = modPow;
            } while (modPow.mod(bigInteger).equals(BigInteger.ZERO));
            if (str.contains("_")) {
                this.poolName = str.split("_", 2)[1];
            } else {
                this.poolName = str;
            }
        }

        public BigInteger geta() {
            return this.a;
        }

        public BigInteger getA() {
            return this.A;
        }

        static {
            BigInteger bigInteger = new BigInteger(HEX_N, 16);
            N = bigInteger;
            BigInteger valueOf = BigInteger.valueOf(2);
            GG = valueOf;
            AnonymousClass1 r2 = new ThreadLocal<MessageDigest>() {
                /* access modifiers changed from: protected */
                public MessageDigest initialValue() {
                    try {
                        return MessageDigest.getInstance("SHA-256");
                    } catch (NoSuchAlgorithmException e) {
                        throw new CognitoInternalErrorException("Exception in authentication", e);
                    }
                }
            };
            THREAD_MESSAGE_DIGEST = r2;
            try {
                SECURE_RANDOM = SecureRandom.getInstance("SHA1PRNG");
                MessageDigest messageDigest = (MessageDigest) r2.get();
                messageDigest.reset();
                messageDigest.update(bigInteger.toByteArray());
                KK = new BigInteger(1, messageDigest.digest(valueOf.toByteArray()));
            } catch (NoSuchAlgorithmException e) {
                throw new CognitoInternalErrorException(e.getMessage(), e);
            }
        }

        public byte[] getPasswordAuthenticationKey(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            messageDigest.reset();
            messageDigest.update(this.A.toByteArray());
            BigInteger bigInteger3 = new BigInteger(1, messageDigest.digest(bigInteger.toByteArray()));
            if (!bigInteger3.equals(BigInteger.ZERO)) {
                messageDigest.reset();
                messageDigest.update(this.poolName.getBytes(StringUtils.UTF8));
                messageDigest.update(str.getBytes(StringUtils.UTF8));
                messageDigest.update(":".getBytes(StringUtils.UTF8));
                byte[] digest = messageDigest.digest(str2.getBytes(StringUtils.UTF8));
                messageDigest.reset();
                messageDigest.update(bigInteger2.toByteArray());
                BigInteger bigInteger4 = new BigInteger(1, messageDigest.digest(digest));
                BigInteger bigInteger5 = KK;
                BigInteger bigInteger6 = GG;
                BigInteger bigInteger7 = N;
                BigInteger mod = bigInteger.subtract(bigInteger5.multiply(bigInteger6.modPow(bigInteger4, bigInteger7))).modPow(this.a.add(bigInteger3.multiply(bigInteger4)), bigInteger7).mod(bigInteger7);
                try {
                    Hkdf instance = Hkdf.getInstance("HmacSHA256");
                    instance.init(mod.toByteArray(), bigInteger3.toByteArray());
                    return instance.deriveKey(DERIVED_KEY_INFO, 16);
                } catch (NoSuchAlgorithmException e) {
                    throw new CognitoInternalErrorException(e.getMessage(), e);
                }
            } else {
                throw new CognitoInternalErrorException("Hash of A and B cannot be zero");
            }
        }
    }
}
