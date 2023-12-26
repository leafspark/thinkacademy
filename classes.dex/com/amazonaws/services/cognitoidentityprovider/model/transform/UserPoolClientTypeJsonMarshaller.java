package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.TokenValidityUnitsType;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolClientType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;
import java.util.List;

class UserPoolClientTypeJsonMarshaller {
    private static UserPoolClientTypeJsonMarshaller instance;

    UserPoolClientTypeJsonMarshaller() {
    }

    public void marshall(UserPoolClientType userPoolClientType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (userPoolClientType.getUserPoolId() != null) {
            String userPoolId = userPoolClientType.getUserPoolId();
            awsJsonWriter.name("UserPoolId");
            awsJsonWriter.value(userPoolId);
        }
        if (userPoolClientType.getClientName() != null) {
            String clientName = userPoolClientType.getClientName();
            awsJsonWriter.name("ClientName");
            awsJsonWriter.value(clientName);
        }
        if (userPoolClientType.getClientId() != null) {
            String clientId = userPoolClientType.getClientId();
            awsJsonWriter.name("ClientId");
            awsJsonWriter.value(clientId);
        }
        if (userPoolClientType.getClientSecret() != null) {
            String clientSecret = userPoolClientType.getClientSecret();
            awsJsonWriter.name("ClientSecret");
            awsJsonWriter.value(clientSecret);
        }
        if (userPoolClientType.getLastModifiedDate() != null) {
            Date lastModifiedDate = userPoolClientType.getLastModifiedDate();
            awsJsonWriter.name("LastModifiedDate");
            awsJsonWriter.value(lastModifiedDate);
        }
        if (userPoolClientType.getCreationDate() != null) {
            Date creationDate = userPoolClientType.getCreationDate();
            awsJsonWriter.name("CreationDate");
            awsJsonWriter.value(creationDate);
        }
        if (userPoolClientType.getRefreshTokenValidity() != null) {
            Integer refreshTokenValidity = userPoolClientType.getRefreshTokenValidity();
            awsJsonWriter.name("RefreshTokenValidity");
            awsJsonWriter.value(refreshTokenValidity);
        }
        if (userPoolClientType.getAccessTokenValidity() != null) {
            Integer accessTokenValidity = userPoolClientType.getAccessTokenValidity();
            awsJsonWriter.name("AccessTokenValidity");
            awsJsonWriter.value(accessTokenValidity);
        }
        if (userPoolClientType.getIdTokenValidity() != null) {
            Integer idTokenValidity = userPoolClientType.getIdTokenValidity();
            awsJsonWriter.name("IdTokenValidity");
            awsJsonWriter.value(idTokenValidity);
        }
        if (userPoolClientType.getTokenValidityUnits() != null) {
            TokenValidityUnitsType tokenValidityUnits = userPoolClientType.getTokenValidityUnits();
            awsJsonWriter.name("TokenValidityUnits");
            TokenValidityUnitsTypeJsonMarshaller.getInstance().marshall(tokenValidityUnits, awsJsonWriter);
        }
        if (userPoolClientType.getReadAttributes() != null) {
            List<String> readAttributes = userPoolClientType.getReadAttributes();
            awsJsonWriter.name("ReadAttributes");
            awsJsonWriter.beginArray();
            for (String next : readAttributes) {
                if (next != null) {
                    awsJsonWriter.value(next);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getWriteAttributes() != null) {
            List<String> writeAttributes = userPoolClientType.getWriteAttributes();
            awsJsonWriter.name("WriteAttributes");
            awsJsonWriter.beginArray();
            for (String next2 : writeAttributes) {
                if (next2 != null) {
                    awsJsonWriter.value(next2);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getExplicitAuthFlows() != null) {
            List<String> explicitAuthFlows = userPoolClientType.getExplicitAuthFlows();
            awsJsonWriter.name("ExplicitAuthFlows");
            awsJsonWriter.beginArray();
            for (String next3 : explicitAuthFlows) {
                if (next3 != null) {
                    awsJsonWriter.value(next3);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getSupportedIdentityProviders() != null) {
            List<String> supportedIdentityProviders = userPoolClientType.getSupportedIdentityProviders();
            awsJsonWriter.name("SupportedIdentityProviders");
            awsJsonWriter.beginArray();
            for (String next4 : supportedIdentityProviders) {
                if (next4 != null) {
                    awsJsonWriter.value(next4);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getCallbackURLs() != null) {
            List<String> callbackURLs = userPoolClientType.getCallbackURLs();
            awsJsonWriter.name("CallbackURLs");
            awsJsonWriter.beginArray();
            for (String next5 : callbackURLs) {
                if (next5 != null) {
                    awsJsonWriter.value(next5);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getLogoutURLs() != null) {
            List<String> logoutURLs = userPoolClientType.getLogoutURLs();
            awsJsonWriter.name("LogoutURLs");
            awsJsonWriter.beginArray();
            for (String next6 : logoutURLs) {
                if (next6 != null) {
                    awsJsonWriter.value(next6);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getDefaultRedirectURI() != null) {
            String defaultRedirectURI = userPoolClientType.getDefaultRedirectURI();
            awsJsonWriter.name("DefaultRedirectURI");
            awsJsonWriter.value(defaultRedirectURI);
        }
        if (userPoolClientType.getAllowedOAuthFlows() != null) {
            List<String> allowedOAuthFlows = userPoolClientType.getAllowedOAuthFlows();
            awsJsonWriter.name("AllowedOAuthFlows");
            awsJsonWriter.beginArray();
            for (String next7 : allowedOAuthFlows) {
                if (next7 != null) {
                    awsJsonWriter.value(next7);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getAllowedOAuthScopes() != null) {
            List<String> allowedOAuthScopes = userPoolClientType.getAllowedOAuthScopes();
            awsJsonWriter.name("AllowedOAuthScopes");
            awsJsonWriter.beginArray();
            for (String next8 : allowedOAuthScopes) {
                if (next8 != null) {
                    awsJsonWriter.value(next8);
                }
            }
            awsJsonWriter.endArray();
        }
        if (userPoolClientType.getAllowedOAuthFlowsUserPoolClient() != null) {
            Boolean allowedOAuthFlowsUserPoolClient = userPoolClientType.getAllowedOAuthFlowsUserPoolClient();
            awsJsonWriter.name("AllowedOAuthFlowsUserPoolClient");
            awsJsonWriter.value(allowedOAuthFlowsUserPoolClient.booleanValue());
        }
        if (userPoolClientType.getAnalyticsConfiguration() != null) {
            AnalyticsConfigurationType analyticsConfiguration = userPoolClientType.getAnalyticsConfiguration();
            awsJsonWriter.name("AnalyticsConfiguration");
            AnalyticsConfigurationTypeJsonMarshaller.getInstance().marshall(analyticsConfiguration, awsJsonWriter);
        }
        if (userPoolClientType.getPreventUserExistenceErrors() != null) {
            String preventUserExistenceErrors = userPoolClientType.getPreventUserExistenceErrors();
            awsJsonWriter.name("PreventUserExistenceErrors");
            awsJsonWriter.value(preventUserExistenceErrors);
        }
        if (userPoolClientType.getEnableTokenRevocation() != null) {
            Boolean enableTokenRevocation = userPoolClientType.getEnableTokenRevocation();
            awsJsonWriter.name("EnableTokenRevocation");
            awsJsonWriter.value(enableTokenRevocation.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static UserPoolClientTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UserPoolClientTypeJsonMarshaller();
        }
        return instance;
    }
}
