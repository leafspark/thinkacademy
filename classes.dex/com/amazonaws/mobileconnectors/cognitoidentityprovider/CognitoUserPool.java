package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.cognito.clientcontext.data.UserContextDataProvider;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoPinpointSharedContext;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoSecretHash;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class CognitoUserPool {
    private static final String DEFAULT_SHARED_PREFERENCES_NAME = "CognitoIdentityProviderCache";
    private static final int USER_POOL_ID_MAX_LENGTH = 55;
    private static final String USER_POOL_ID_PATTERN = "^[\\w-]+_[0-9a-zA-Z]+$";
    private static final Log logger = LogFactory.getLog((Class<?>) CognitoUserPool.class);
    private boolean advancedSecurityDataCollectionFlag;
    AWSKeyValueStore awsKeyValueStore;
    private AmazonCognitoIdentityProvider client;
    private final String clientId;
    private final String clientSecret;
    /* access modifiers changed from: private */
    public final Context context;
    private boolean isPersistenceEnabled;
    private String pinpointEndpointId;
    private String secretHash;
    private final String userPoolId;

    @Deprecated
    public CognitoUserPool(Context context2, String str, String str2, String str3, ClientConfiguration clientConfiguration) {
        this(context2, str, str2, str3, clientConfiguration, Regions.US_EAST_1);
    }

    @Deprecated
    public CognitoUserPool(Context context2, String str, String str2, String str3) {
        this(context2, str, str2, str3, new ClientConfiguration(), Regions.US_EAST_1);
    }

    public CognitoUserPool(Context context2, AWSConfiguration aWSConfiguration) {
        this.advancedSecurityDataCollectionFlag = true;
        this.isPersistenceEnabled = true;
        try {
            initialize(context2);
            JSONObject optJsonObject = aWSConfiguration.optJsonObject("CognitoUserPool");
            this.context = context2;
            this.userPoolId = optJsonObject.getString("PoolId");
            this.clientId = optJsonObject.getString("AppClientId");
            this.clientSecret = optJsonObject.optString("AppClientSecret");
            this.pinpointEndpointId = CognitoPinpointSharedContext.getPinpointEndpoint(context2, optJsonObject.optString("PinpointAppId"));
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setUserAgent(aWSConfiguration.getUserAgent());
            clientConfiguration.setUserAgentOverride(aWSConfiguration.getUserAgentOverride());
            AmazonCognitoIdentityProviderClient amazonCognitoIdentityProviderClient = new AmazonCognitoIdentityProviderClient((AWSCredentials) new AnonymousAWSCredentials(), clientConfiguration);
            this.client = amazonCognitoIdentityProviderClient;
            amazonCognitoIdentityProviderClient.setRegion(Region.getRegion(Regions.fromName(optJsonObject.getString("Region"))));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read PoolId, AppClientId, AppClientSecret, or Region from AWSConfiguration please check your setup or awsconfiguration.json file", e);
        }
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, Regions regions) {
        this(context2, str, str2, str3, new ClientConfiguration(), regions);
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, Regions regions, String str4) {
        this(context2, str, str2, str3, new ClientConfiguration(), regions, str4);
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, ClientConfiguration clientConfiguration, Regions regions) {
        this(context2, str, str2, str3, clientConfiguration, regions, (String) null);
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, ClientConfiguration clientConfiguration, Regions regions, String str4) {
        this.advancedSecurityDataCollectionFlag = true;
        this.isPersistenceEnabled = true;
        initialize(context2);
        this.context = context2;
        if (str.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Both UserPoolId and ClientId are required.");
        } else if (str.length() > 55 || !Pattern.matches(USER_POOL_ID_PATTERN, str)) {
            throw new IllegalArgumentException("Invalid userPoolId format.");
        } else {
            this.userPoolId = str;
            this.clientId = str2;
            this.clientSecret = str3;
            AmazonCognitoIdentityProviderClient amazonCognitoIdentityProviderClient = new AmazonCognitoIdentityProviderClient((AWSCredentials) new AnonymousAWSCredentials(), clientConfiguration);
            this.client = amazonCognitoIdentityProviderClient;
            amazonCognitoIdentityProviderClient.setRegion(Region.getRegion(regions));
            this.pinpointEndpointId = CognitoPinpointSharedContext.getPinpointEndpoint(context2, str4);
        }
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider) {
        this(context2, str, str2, str3, amazonCognitoIdentityProvider, (String) null);
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, String str4) {
        this(context2, str, str2, str3, amazonCognitoIdentityProvider, str4, (String) null);
    }

    public CognitoUserPool(Context context2, String str, String str2, String str3, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, String str4, String str5) {
        this.advancedSecurityDataCollectionFlag = true;
        this.isPersistenceEnabled = true;
        initialize(context2);
        this.context = context2;
        if (str.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Both UserPoolId and ClientId are required.");
        } else if (str.length() > 55 || !Pattern.matches(USER_POOL_ID_PATTERN, str)) {
            throw new IllegalArgumentException("Invalid userPoolId format.");
        } else {
            this.userPoolId = str;
            this.clientId = str2;
            this.clientSecret = str3;
            this.client = amazonCognitoIdentityProvider;
            this.pinpointEndpointId = CognitoPinpointSharedContext.getPinpointEndpoint(context2, str4);
            if (str5 != null && !str5.isEmpty()) {
                this.client.setEndpoint(str5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setIdentityProvider(AmazonCognitoIdentityProvider amazonCognitoIdentityProvider) {
        this.client = amazonCognitoIdentityProvider;
    }

    private void initialize(Context context2) {
        this.awsKeyValueStore = new AWSKeyValueStore(context2, DEFAULT_SHARED_PREFERENCES_NAME, this.isPersistenceEnabled);
        CognitoDeviceHelper.setPersistenceEnabled(this.isPersistenceEnabled);
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setAdvancedSecurityDataCollectionFlag(boolean z) {
        this.advancedSecurityDataCollectionFlag = z;
    }

    public void setPersistenceEnabled(boolean z) {
        this.isPersistenceEnabled = z;
        this.awsKeyValueStore.setPersistenceEnabled(z);
        CognitoDeviceHelper.setPersistenceEnabled(z);
    }

    public void signUpInBackground(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map<String, String> map, SignUpHandler signUpHandler) {
        signUpInBackground(str, str2, cognitoUserAttributes, map, Collections.emptyMap(), signUpHandler);
    }

    public void signUp(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map<String, String> map, SignUpHandler signUpHandler) {
        signUp(str, str2, cognitoUserAttributes, map, Collections.emptyMap(), signUpHandler);
    }

    public void signUpInBackground(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map<String, String> map, Map<String, String> map2, SignUpHandler signUpHandler) {
        final String str3 = str;
        final String str4 = str2;
        final CognitoUserAttributes cognitoUserAttributes2 = cognitoUserAttributes;
        final Map<String, String> map3 = map;
        final Map<String, String> map4 = map2;
        final SignUpHandler signUpHandler2 = signUpHandler;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Runnable runnable;
                Handler handler = new Handler(CognitoUserPool.this.context.getMainLooper());
                try {
                    final SignUpResult access$100 = CognitoUserPool.this.signUpInternal(str3, str4, cognitoUserAttributes2, map3, map4);
                    final CognitoUser user = CognitoUserPool.this.getUser(str3);
                    runnable = new Runnable() {
                        public void run() {
                            signUpHandler2.onSuccess(user, access$100);
                        }
                    };
                } catch (Exception e) {
                    runnable = new Runnable() {
                        public void run() {
                            signUpHandler2.onFailure(e);
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
    }

    public void signUp(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map<String, String> map, Map<String, String> map2, SignUpHandler signUpHandler) {
        try {
            signUpHandler.onSuccess(getUser(str), signUpInternal(str, str2, cognitoUserAttributes, map, map2));
        } catch (Exception e) {
            signUpHandler.onFailure(e);
        }
    }

    /* access modifiers changed from: private */
    public SignUpResult signUpInternal(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map<String, String> map, Map<String, String> map2) {
        ArrayList arrayList;
        if (map != null) {
            arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                AttributeType attributeType = new AttributeType();
                attributeType.setName((String) next.getKey());
                attributeType.setValue((String) next.getValue());
                arrayList.add(attributeType);
            }
        } else {
            arrayList = null;
        }
        this.secretHash = CognitoSecretHash.getSecretHash(str, this.clientId, this.clientSecret);
        SignUpRequest withUserContextData = new SignUpRequest().withUsername(str).withPassword(str2).withClientId(this.clientId).withSecretHash(this.secretHash).withUserAttributes((Collection<AttributeType>) cognitoUserAttributes.getAttributesList()).withValidationData((Collection<AttributeType>) arrayList).withClientMetadata(map2).withUserContextData(getUserContextData(str));
        String pinpointEndpointId2 = getPinpointEndpointId();
        if (pinpointEndpointId2 != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId2);
            withUserContextData.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.client.signUp(withUserContextData);
    }

    public CognitoUser getCurrentUser() {
        String str = "CognitoIdentityProvider." + this.clientId + ".LastAuthUser";
        if (this.awsKeyValueStore.contains(str)) {
            return getUser(this.awsKeyValueStore.get(str));
        }
        return getUser();
    }

    public CognitoUser getUser() {
        return new CognitoUser(this, (String) null, this.clientId, this.clientSecret, (String) null, this.client, this.context);
    }

    public CognitoUser getUser(String str) {
        if (str == null) {
            return getUser();
        }
        if (str.isEmpty()) {
            return getUser();
        }
        String str2 = this.clientId;
        String str3 = this.clientSecret;
        return new CognitoUser(this, str, str2, str3, CognitoSecretHash.getSecretHash(str, str2, str3), this.client, this.context);
    }

    /* access modifiers changed from: protected */
    public String getPinpointEndpointId() {
        return this.pinpointEndpointId;
    }

    /* access modifiers changed from: protected */
    public UserContextDataType getUserContextData(String str) {
        if (!this.advancedSecurityDataCollectionFlag) {
            return null;
        }
        String encodedContextData = UserContextDataProvider.getInstance().getEncodedContextData(this.context, str, getUserPoolId(), this.clientId);
        UserContextDataType userContextDataType = new UserContextDataType();
        userContextDataType.setEncodedData(encodedContextData);
        return userContextDataType;
    }
}
