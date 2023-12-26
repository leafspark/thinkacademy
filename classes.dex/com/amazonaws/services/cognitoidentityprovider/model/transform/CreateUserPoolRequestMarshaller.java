package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AccountRecoverySettingType;
import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.EmailConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.LambdaConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.SchemaAttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.SmsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnsType;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolPolicyType;
import com.amazonaws.services.cognitoidentityprovider.model.UsernameConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.VerificationMessageTemplateType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class CreateUserPoolRequestMarshaller implements Marshaller<Request<CreateUserPoolRequest>, CreateUserPoolRequest> {
    public Request<CreateUserPoolRequest> marshall(CreateUserPoolRequest createUserPoolRequest) {
        if (createUserPoolRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(createUserPoolRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.CreateUserPool");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (createUserPoolRequest.getPoolName() != null) {
                    String poolName = createUserPoolRequest.getPoolName();
                    jsonWriter.name("PoolName");
                    jsonWriter.value(poolName);
                }
                if (createUserPoolRequest.getPolicies() != null) {
                    UserPoolPolicyType policies = createUserPoolRequest.getPolicies();
                    jsonWriter.name("Policies");
                    UserPoolPolicyTypeJsonMarshaller.getInstance().marshall(policies, jsonWriter);
                }
                if (createUserPoolRequest.getLambdaConfig() != null) {
                    LambdaConfigType lambdaConfig = createUserPoolRequest.getLambdaConfig();
                    jsonWriter.name("LambdaConfig");
                    LambdaConfigTypeJsonMarshaller.getInstance().marshall(lambdaConfig, jsonWriter);
                }
                if (createUserPoolRequest.getAutoVerifiedAttributes() != null) {
                    List<String> autoVerifiedAttributes = createUserPoolRequest.getAutoVerifiedAttributes();
                    jsonWriter.name("AutoVerifiedAttributes");
                    jsonWriter.beginArray();
                    for (String next : autoVerifiedAttributes) {
                        if (next != null) {
                            jsonWriter.value(next);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createUserPoolRequest.getAliasAttributes() != null) {
                    List<String> aliasAttributes = createUserPoolRequest.getAliasAttributes();
                    jsonWriter.name("AliasAttributes");
                    jsonWriter.beginArray();
                    for (String next2 : aliasAttributes) {
                        if (next2 != null) {
                            jsonWriter.value(next2);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createUserPoolRequest.getUsernameAttributes() != null) {
                    List<String> usernameAttributes = createUserPoolRequest.getUsernameAttributes();
                    jsonWriter.name("UsernameAttributes");
                    jsonWriter.beginArray();
                    for (String next3 : usernameAttributes) {
                        if (next3 != null) {
                            jsonWriter.value(next3);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createUserPoolRequest.getSmsVerificationMessage() != null) {
                    String smsVerificationMessage = createUserPoolRequest.getSmsVerificationMessage();
                    jsonWriter.name("SmsVerificationMessage");
                    jsonWriter.value(smsVerificationMessage);
                }
                if (createUserPoolRequest.getEmailVerificationMessage() != null) {
                    String emailVerificationMessage = createUserPoolRequest.getEmailVerificationMessage();
                    jsonWriter.name("EmailVerificationMessage");
                    jsonWriter.value(emailVerificationMessage);
                }
                if (createUserPoolRequest.getEmailVerificationSubject() != null) {
                    String emailVerificationSubject = createUserPoolRequest.getEmailVerificationSubject();
                    jsonWriter.name("EmailVerificationSubject");
                    jsonWriter.value(emailVerificationSubject);
                }
                if (createUserPoolRequest.getVerificationMessageTemplate() != null) {
                    VerificationMessageTemplateType verificationMessageTemplate = createUserPoolRequest.getVerificationMessageTemplate();
                    jsonWriter.name("VerificationMessageTemplate");
                    VerificationMessageTemplateTypeJsonMarshaller.getInstance().marshall(verificationMessageTemplate, jsonWriter);
                }
                if (createUserPoolRequest.getSmsAuthenticationMessage() != null) {
                    String smsAuthenticationMessage = createUserPoolRequest.getSmsAuthenticationMessage();
                    jsonWriter.name("SmsAuthenticationMessage");
                    jsonWriter.value(smsAuthenticationMessage);
                }
                if (createUserPoolRequest.getMfaConfiguration() != null) {
                    String mfaConfiguration = createUserPoolRequest.getMfaConfiguration();
                    jsonWriter.name("MfaConfiguration");
                    jsonWriter.value(mfaConfiguration);
                }
                if (createUserPoolRequest.getDeviceConfiguration() != null) {
                    DeviceConfigurationType deviceConfiguration = createUserPoolRequest.getDeviceConfiguration();
                    jsonWriter.name("DeviceConfiguration");
                    DeviceConfigurationTypeJsonMarshaller.getInstance().marshall(deviceConfiguration, jsonWriter);
                }
                if (createUserPoolRequest.getEmailConfiguration() != null) {
                    EmailConfigurationType emailConfiguration = createUserPoolRequest.getEmailConfiguration();
                    jsonWriter.name("EmailConfiguration");
                    EmailConfigurationTypeJsonMarshaller.getInstance().marshall(emailConfiguration, jsonWriter);
                }
                if (createUserPoolRequest.getSmsConfiguration() != null) {
                    SmsConfigurationType smsConfiguration = createUserPoolRequest.getSmsConfiguration();
                    jsonWriter.name("SmsConfiguration");
                    SmsConfigurationTypeJsonMarshaller.getInstance().marshall(smsConfiguration, jsonWriter);
                }
                if (createUserPoolRequest.getUserPoolTags() != null) {
                    Map<String, String> userPoolTags = createUserPoolRequest.getUserPoolTags();
                    jsonWriter.name("UserPoolTags");
                    jsonWriter.beginObject();
                    for (Map.Entry next4 : userPoolTags.entrySet()) {
                        String str = (String) next4.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next4.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (createUserPoolRequest.getAdminCreateUserConfig() != null) {
                    AdminCreateUserConfigType adminCreateUserConfig = createUserPoolRequest.getAdminCreateUserConfig();
                    jsonWriter.name("AdminCreateUserConfig");
                    AdminCreateUserConfigTypeJsonMarshaller.getInstance().marshall(adminCreateUserConfig, jsonWriter);
                }
                if (createUserPoolRequest.getSchema() != null) {
                    List<SchemaAttributeType> schema = createUserPoolRequest.getSchema();
                    jsonWriter.name("Schema");
                    jsonWriter.beginArray();
                    for (SchemaAttributeType next5 : schema) {
                        if (next5 != null) {
                            SchemaAttributeTypeJsonMarshaller.getInstance().marshall(next5, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createUserPoolRequest.getUserPoolAddOns() != null) {
                    UserPoolAddOnsType userPoolAddOns = createUserPoolRequest.getUserPoolAddOns();
                    jsonWriter.name("UserPoolAddOns");
                    UserPoolAddOnsTypeJsonMarshaller.getInstance().marshall(userPoolAddOns, jsonWriter);
                }
                if (createUserPoolRequest.getUsernameConfiguration() != null) {
                    UsernameConfigurationType usernameConfiguration = createUserPoolRequest.getUsernameConfiguration();
                    jsonWriter.name("UsernameConfiguration");
                    UsernameConfigurationTypeJsonMarshaller.getInstance().marshall(usernameConfiguration, jsonWriter);
                }
                if (createUserPoolRequest.getAccountRecoverySetting() != null) {
                    AccountRecoverySettingType accountRecoverySetting = createUserPoolRequest.getAccountRecoverySetting();
                    jsonWriter.name("AccountRecoverySetting");
                    AccountRecoverySettingTypeJsonMarshaller.getInstance().marshall(accountRecoverySetting, jsonWriter);
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(CreateUserPoolRequest)");
        }
    }
}
