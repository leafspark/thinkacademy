package com.amazonaws.services.cognitoidentityprovider;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.cognitoidentityprovider.model.AdminAddUserToGroupRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AdminForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AdminRemoveUserFromGroupRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteGroupRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteIdentityProviderRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteResourceServerRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolClientRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.transform.AdminAddUserToGroupRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDeleteUserRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.AdminForgetDeviceRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.AdminRemoveUserFromGroupRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.AliasExistsExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.CodeDeliveryFailureExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.CodeMismatchExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.ConcurrentModificationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteGroupRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteIdentityProviderRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteResourceServerRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserPoolClientRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserPoolRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.DuplicateProviderExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.EnableSoftwareTokenMFAExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.ExpiredCodeExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.ForgetDeviceRequestMarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.GroupExistsExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InternalErrorExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidEmailRoleAccessPolicyExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidLambdaResponseExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidOAuthFlowExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidParameterExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidPasswordExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidSmsRoleAccessPolicyExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidSmsRoleTrustRelationshipExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.InvalidUserPoolConfigurationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.MFAMethodNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.NotAuthorizedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.PasswordResetRequiredExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.PreconditionNotMetExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.ScopeDoesNotExistExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.SoftwareTokenMFANotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.TooManyFailedAttemptsExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.TooManyRequestsExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UnauthorizedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UnexpectedLambdaExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UnsupportedIdentityProviderExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UnsupportedOperationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UnsupportedTokenTypeExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UnsupportedUserStateExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UserImportInProgressExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UserLambdaValidationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UserNotConfirmedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UserNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UserPoolAddOnNotEnabledExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UserPoolTaggingExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentityprovider.model.transform.UsernameExistsExceptionUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;

public class AmazonCognitoIdentityProviderClient extends AmazonWebServiceClient implements AmazonCognitoIdentityProvider {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AmazonCognitoIdentityProviderClient() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonCognitoIdentityProviderClient(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonCognitoIdentityProviderClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonCognitoIdentityProviderClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonCognitoIdentityProviderClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonCognitoIdentityProviderClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonCognitoIdentityProviderClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonCognitoIdentityProviderClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new AliasExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CodeDeliveryFailureExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CodeMismatchExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ConcurrentModificationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DuplicateProviderExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EnableSoftwareTokenMFAExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ExpiredCodeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new GroupExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidEmailRoleAccessPolicyExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidLambdaResponseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidOAuthFlowExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidParameterExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidPasswordExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidSmsRoleAccessPolicyExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidSmsRoleTrustRelationshipExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidUserPoolConfigurationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new MFAMethodNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new NotAuthorizedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new PasswordResetRequiredExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new PreconditionNotMetExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ScopeDoesNotExistExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new SoftwareTokenMFANotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TooManyFailedAttemptsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TooManyRequestsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnauthorizedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnexpectedLambdaExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedIdentityProviderExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedOperationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedTokenTypeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedUserStateExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UserImportInProgressExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UserLambdaValidationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UserNotConfirmedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UserNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UserPoolAddOnNotEnabledExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UserPoolTaggingExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UsernameExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("cognito-idp.us-east-1.amazonaws.com");
        this.endpointPrefix = "cognito-idp";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/cognitoidentityprovider/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/cognitoidentityprovider/request.handler2s"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesResult addCustomAttributes(com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AddCustomAttributesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AddCustomAttributesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AddCustomAttributesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AddCustomAttributesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.addCustomAttributes(com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesRequest):com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesResult");
    }

    public void adminAddUserToGroup(AdminAddUserToGroupRequest adminAddUserToGroupRequest) throws AmazonServiceException, AmazonClientException {
        Request<AdminAddUserToGroupRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) adminAddUserToGroupRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new AdminAddUserToGroupRequestMarshaller().marshall(adminAddUserToGroupRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpResult adminConfirmSignUp(com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminConfirmSignUpRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminConfirmSignUpRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminConfirmSignUpResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminConfirmSignUpResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminConfirmSignUp(com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserResult adminCreateUser(com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminCreateUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminCreateUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminCreateUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminCreateUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminCreateUser(com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserResult");
    }

    public void adminDeleteUser(AdminDeleteUserRequest adminDeleteUserRequest) throws AmazonServiceException, AmazonClientException {
        Request<AdminDeleteUserRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) adminDeleteUserRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new AdminDeleteUserRequestMarshaller().marshall(adminDeleteUserRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult adminDeleteUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDeleteUserAttributesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDeleteUserAttributesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDeleteUserAttributesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDeleteUserAttributesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminDeleteUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserResult adminDisableProviderForUser(com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableProviderForUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableProviderForUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableProviderForUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableProviderForUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminDisableProviderForUser(com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserResult adminDisableUser(com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminDisableUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminDisableUser(com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserResult adminEnableUser(com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminEnableUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminEnableUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminEnableUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminEnableUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminEnableUser(com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserResult");
    }

    public void adminForgetDevice(AdminForgetDeviceRequest adminForgetDeviceRequest) throws AmazonServiceException, AmazonClientException {
        Request<AdminForgetDeviceRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) adminForgetDeviceRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new AdminForgetDeviceRequestMarshaller().marshall(adminForgetDeviceRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceResult adminGetDevice(com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetDeviceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetDeviceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetDeviceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetDeviceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminGetDevice(com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserResult adminGetUser(com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminGetUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminGetUser(com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminGetUserResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthResult adminInitiateAuth(com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminInitiateAuthRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminInitiateAuthRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminInitiateAuthResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminInitiateAuthResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminInitiateAuth(com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult adminLinkProviderForUser(com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminLinkProviderForUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminLinkProviderForUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminLinkProviderForUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminLinkProviderForUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminLinkProviderForUser(com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesResult adminListDevices(com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListDevicesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListDevicesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListDevicesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListDevicesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminListDevices(com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserResult adminListGroupsForUser(com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListGroupsForUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListGroupsForUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListGroupsForUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListGroupsForUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminListGroupsForUser(com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsResult adminListUserAuthEvents(com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListUserAuthEventsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListUserAuthEventsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListUserAuthEventsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminListUserAuthEventsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminListUserAuthEvents(com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsResult");
    }

    public void adminRemoveUserFromGroup(AdminRemoveUserFromGroupRequest adminRemoveUserFromGroupRequest) throws AmazonServiceException, AmazonClientException {
        Request<AdminRemoveUserFromGroupRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) adminRemoveUserFromGroupRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new AdminRemoveUserFromGroupRequestMarshaller().marshall(adminRemoveUserFromGroupRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult adminResetUserPassword(com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminResetUserPasswordRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminResetUserPasswordRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminResetUserPasswordResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminResetUserPasswordResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminResetUserPassword(com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeResult adminRespondToAuthChallenge(com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminRespondToAuthChallengeRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminRespondToAuthChallengeRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminRespondToAuthChallengeResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminRespondToAuthChallengeResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminRespondToAuthChallenge(com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminRespondToAuthChallengeResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceResult adminSetUserMFAPreference(com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserMFAPreferenceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserMFAPreferenceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserMFAPreferenceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserMFAPreferenceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminSetUserMFAPreference(com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordResult adminSetUserPassword(com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserPasswordRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserPasswordRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserPasswordResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserPasswordResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminSetUserPassword(com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsResult adminSetUserSettings(com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserSettingsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserSettingsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserSettingsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminSetUserSettingsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminSetUserSettings(com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackResult adminUpdateAuthEventFeedback(com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateAuthEventFeedbackRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateAuthEventFeedbackRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateAuthEventFeedbackResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateAuthEventFeedbackResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminUpdateAuthEventFeedback(com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult adminUpdateDeviceStatus(com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateDeviceStatusRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateDeviceStatusRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateDeviceStatusResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateDeviceStatusResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminUpdateDeviceStatus(com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesResult adminUpdateUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateUserAttributesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateUserAttributesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateUserAttributesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUpdateUserAttributesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminUpdateUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutResult adminUserGlobalSignOut(com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUserGlobalSignOutRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUserGlobalSignOutRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUserGlobalSignOutResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AdminUserGlobalSignOutResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.adminUserGlobalSignOut(com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutRequest):com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult associateSoftwareToken(com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AssociateSoftwareTokenRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AssociateSoftwareTokenRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.AssociateSoftwareTokenResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.AssociateSoftwareTokenResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.associateSoftwareToken(com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest):com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult changePassword(com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ChangePasswordRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ChangePasswordRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ChangePasswordResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ChangePasswordResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.changePassword(com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest):com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult confirmDevice(com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmDeviceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmDeviceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmDeviceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmDeviceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.confirmDevice(com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceRequest):com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult confirmForgotPassword(com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmForgotPasswordRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmForgotPasswordRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmForgotPasswordResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmForgotPasswordResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.confirmForgotPassword(com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest):com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpResult confirmSignUp(com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmSignUpRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmSignUpRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmSignUpResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ConfirmSignUpResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.confirmSignUp(com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest):com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateGroupResult createGroup(com.amazonaws.services.cognitoidentityprovider.model.CreateGroupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateGroupRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateGroupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateGroupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateGroupResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateGroupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateGroupResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateGroupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createGroup(com.amazonaws.services.cognitoidentityprovider.model.CreateGroupRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateGroupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderResult createIdentityProvider(com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateIdentityProviderRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateIdentityProviderRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateIdentityProviderResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateIdentityProviderResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createIdentityProvider(com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerResult createResourceServer(com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateResourceServerRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateResourceServerRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateResourceServerResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateResourceServerResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createResourceServer(com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobResult createUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserImportJobRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserImportJobRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserImportJobResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserImportJobResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolResult createUserPool(com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createUserPool(com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientResult createUserPoolClient(com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolClientRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolClientRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolClientResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolClientResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createUserPoolClient(com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainResult createUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolDomainRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolDomainRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolDomainResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.CreateUserPoolDomainResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.createUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainRequest):com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainResult");
    }

    public void deleteGroup(DeleteGroupRequest deleteGroupRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteGroupRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteGroupRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteGroupRequestMarshaller().marshall(deleteGroupRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    public void deleteIdentityProvider(DeleteIdentityProviderRequest deleteIdentityProviderRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteIdentityProviderRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteIdentityProviderRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteIdentityProviderRequestMarshaller().marshall(deleteIdentityProviderRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    public void deleteResourceServer(DeleteResourceServerRequest deleteResourceServerRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteResourceServerRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteResourceServerRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteResourceServerRequestMarshaller().marshall(deleteResourceServerRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    public void deleteUser(DeleteUserRequest deleteUserRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteUserRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteUserRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteUserRequestMarshaller().marshall(deleteUserRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult deleteUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserAttributesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserAttributesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserAttributesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserAttributesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.deleteUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest):com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult");
    }

    public void deleteUserPool(DeleteUserPoolRequest deleteUserPoolRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteUserPoolRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteUserPoolRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteUserPoolRequestMarshaller().marshall(deleteUserPoolRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    public void deleteUserPoolClient(DeleteUserPoolClientRequest deleteUserPoolClientRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteUserPoolClientRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteUserPoolClientRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteUserPoolClientRequestMarshaller().marshall(deleteUserPoolClientRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult deleteUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserPoolDomainRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserPoolDomainRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserPoolDomainResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DeleteUserPoolDomainResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.deleteUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainRequest):com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderResult describeIdentityProvider(com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeIdentityProviderRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeIdentityProviderRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeIdentityProviderResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeIdentityProviderResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeIdentityProvider(com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerResult describeResourceServer(com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeResourceServerRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeResourceServerRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeResourceServerResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeResourceServerResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeResourceServer(com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationResult describeRiskConfiguration(com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeRiskConfigurationRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeRiskConfigurationRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeRiskConfigurationResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeRiskConfigurationResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeRiskConfiguration(com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobResult describeUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserImportJobRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserImportJobRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserImportJobResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserImportJobResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolResult describeUserPool(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeUserPool(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientResult describeUserPoolClient(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolClientRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolClientRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolClientResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolClientResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeUserPoolClient(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainResult describeUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolDomainRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolDomainRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolDomainResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.DescribeUserPoolDomainResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.describeUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainRequest):com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainResult");
    }

    public void forgetDevice(ForgetDeviceRequest forgetDeviceRequest) throws AmazonServiceException, AmazonClientException {
        Request<ForgetDeviceRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) forgetDeviceRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new ForgetDeviceRequestMarshaller().marshall(forgetDeviceRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult forgotPassword(com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ForgotPasswordRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ForgotPasswordRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ForgotPasswordResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ForgotPasswordResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.forgotPassword(com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest):com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderResult getCSVHeader(com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetCSVHeaderRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetCSVHeaderRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetCSVHeaderResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetCSVHeaderResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getCSVHeader(com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderRequest):com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult getDevice(com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetDeviceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetDeviceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetDeviceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetDeviceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getDevice(com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest):com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetGroupResult getGroup(com.amazonaws.services.cognitoidentityprovider.model.GetGroupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetGroupRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetGroupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetGroupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetGroupResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetGroupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetGroupResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetGroupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getGroup(com.amazonaws.services.cognitoidentityprovider.model.GetGroupRequest):com.amazonaws.services.cognitoidentityprovider.model.GetGroupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierResult getIdentityProviderByIdentifier(com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetIdentityProviderByIdentifierRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetIdentityProviderByIdentifierRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetIdentityProviderByIdentifierResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetIdentityProviderByIdentifierResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getIdentityProviderByIdentifier(com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierRequest):com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateResult getSigningCertificate(com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetSigningCertificateRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetSigningCertificateRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetSigningCertificateResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetSigningCertificateResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getSigningCertificate(com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateRequest):com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationResult getUICustomization(com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUICustomizationRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUICustomizationRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUICustomizationResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUICustomizationResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getUICustomization(com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationRequest):com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetUserResult getUser(com.amazonaws.services.cognitoidentityprovider.model.GetUserRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetUserRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetUserResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetUserResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getUser(com.amazonaws.services.cognitoidentityprovider.model.GetUserRequest):com.amazonaws.services.cognitoidentityprovider.model.GetUserResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult getUserAttributeVerificationCode(com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserAttributeVerificationCodeRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserAttributeVerificationCodeRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserAttributeVerificationCodeResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserAttributeVerificationCodeResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getUserAttributeVerificationCode(com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest):com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigResult getUserPoolMfaConfig(com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserPoolMfaConfigRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserPoolMfaConfigRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserPoolMfaConfigResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GetUserPoolMfaConfigResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.getUserPoolMfaConfig(com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigRequest):com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutResult globalSignOut(com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GlobalSignOutRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GlobalSignOutRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.GlobalSignOutResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.GlobalSignOutResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.globalSignOut(com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest):com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult initiateAuth(com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.InitiateAuthRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.InitiateAuthRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.InitiateAuthResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.InitiateAuthResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.initiateAuth(com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest):com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult listDevices(com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListDevicesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListDevicesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListDevicesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListDevicesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listDevices(com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest):com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListGroupsResult listGroups(com.amazonaws.services.cognitoidentityprovider.model.ListGroupsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListGroupsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListGroupsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListGroupsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListGroupsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListGroupsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListGroupsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListGroupsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listGroups(com.amazonaws.services.cognitoidentityprovider.model.ListGroupsRequest):com.amazonaws.services.cognitoidentityprovider.model.ListGroupsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersResult listIdentityProviders(com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListIdentityProvidersRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListIdentityProvidersRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListIdentityProvidersResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListIdentityProvidersResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listIdentityProviders(com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersRequest):com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersResult listResourceServers(com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListResourceServersRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListResourceServersRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListResourceServersResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListResourceServersResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listResourceServers(com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersRequest):com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceResult listTagsForResource(com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListTagsForResourceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListTagsForResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListTagsForResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListTagsForResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listTagsForResource(com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceRequest):com.amazonaws.services.cognitoidentityprovider.model.ListTagsForResourceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsResult listUserImportJobs(com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserImportJobsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserImportJobsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserImportJobsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserImportJobsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listUserImportJobs(com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsRequest):com.amazonaws.services.cognitoidentityprovider.model.ListUserImportJobsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsResult listUserPoolClients(com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolClientsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolClientsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolClientsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolClientsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listUserPoolClients(com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsRequest):com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsResult listUserPools(com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUserPoolsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listUserPools(com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsRequest):com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListUsersResult listUsers(com.amazonaws.services.cognitoidentityprovider.model.ListUsersRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListUsersRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListUsersResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListUsersResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listUsers(com.amazonaws.services.cognitoidentityprovider.model.ListUsersRequest):com.amazonaws.services.cognitoidentityprovider.model.ListUsersResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupResult listUsersInGroup(com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersInGroupRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersInGroupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersInGroupResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ListUsersInGroupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.listUsersInGroup(com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupRequest):com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult resendConfirmationCode(com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ResendConfirmationCodeRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ResendConfirmationCodeRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.ResendConfirmationCodeResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.ResendConfirmationCodeResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.resendConfirmationCode(com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest):com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult respondToAuthChallenge(com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.RespondToAuthChallengeRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.RespondToAuthChallengeRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.RespondToAuthChallengeResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.RespondToAuthChallengeResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.respondToAuthChallenge(com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest):com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult revokeToken(com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.RevokeTokenRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.RevokeTokenRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.RevokeTokenResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.RevokeTokenResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.revokeToken(com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenRequest):com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationResult setRiskConfiguration(com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetRiskConfigurationRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetRiskConfigurationRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetRiskConfigurationResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetRiskConfigurationResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.setRiskConfiguration(com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationRequest):com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationResult setUICustomization(com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUICustomizationRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUICustomizationRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUICustomizationResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUICustomizationResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.setUICustomization(com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationRequest):com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceResult setUserMFAPreference(com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserMFAPreferenceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserMFAPreferenceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserMFAPreferenceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserMFAPreferenceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.setUserMFAPreference(com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest):com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigResult setUserPoolMfaConfig(com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserPoolMfaConfigRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserPoolMfaConfigRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserPoolMfaConfigResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserPoolMfaConfigResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.setUserPoolMfaConfig(com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigRequest):com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsResult setUserSettings(com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserSettingsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserSettingsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserSettingsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SetUserSettingsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.setUserSettings(com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest):com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.SignUpResult signUp(com.amazonaws.services.cognitoidentityprovider.model.SignUpRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SignUpRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SignUpRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.SignUpRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.SignUpResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.SignUpResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.SignUpResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.SignUpResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.signUp(com.amazonaws.services.cognitoidentityprovider.model.SignUpRequest):com.amazonaws.services.cognitoidentityprovider.model.SignUpResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobResult startUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.StartUserImportJobRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.StartUserImportJobRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.StartUserImportJobResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.StartUserImportJobResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.startUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobRequest):com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobResult stopUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.StopUserImportJobRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.StopUserImportJobRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.StopUserImportJobResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.StopUserImportJobResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.stopUserImportJob(com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobRequest):com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.TagResourceResult tagResource(com.amazonaws.services.cognitoidentityprovider.model.TagResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.TagResourceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.TagResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.TagResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.TagResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.TagResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.TagResourceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.TagResourceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.tagResource(com.amazonaws.services.cognitoidentityprovider.model.TagResourceRequest):com.amazonaws.services.cognitoidentityprovider.model.TagResourceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UntagResourceResult untagResource(com.amazonaws.services.cognitoidentityprovider.model.UntagResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UntagResourceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UntagResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UntagResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UntagResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UntagResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UntagResourceResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UntagResourceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.untagResource(com.amazonaws.services.cognitoidentityprovider.model.UntagResourceRequest):com.amazonaws.services.cognitoidentityprovider.model.UntagResourceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackResult updateAuthEventFeedback(com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateAuthEventFeedbackRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateAuthEventFeedbackRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateAuthEventFeedbackResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateAuthEventFeedbackResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateAuthEventFeedback(com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult updateDeviceStatus(com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateDeviceStatusRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateDeviceStatusRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateDeviceStatusResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateDeviceStatusResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateDeviceStatus(com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupResult updateGroup(com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateGroupRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateGroupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateGroupResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateGroupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateGroup(com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderResult updateIdentityProvider(com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateIdentityProviderRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateIdentityProviderRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateIdentityProviderResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateIdentityProviderResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateIdentityProvider(com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerResult updateResourceServer(com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateResourceServerRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateResourceServerRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateResourceServerResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateResourceServerResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateResourceServer(com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult updateUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserAttributesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserAttributesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserAttributesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserAttributesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateUserAttributes(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolResult updateUserPool(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateUserPool(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientResult updateUserPoolClient(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolClientRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolClientRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolClientResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolClientResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateUserPoolClient(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainResult updateUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolDomainRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolDomainRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolDomainResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.UpdateUserPoolDomainResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.updateUserPoolDomain(com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainRequest):com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult verifySoftwareToken(com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.VerifySoftwareTokenRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.VerifySoftwareTokenRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.VerifySoftwareTokenResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.VerifySoftwareTokenResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.verifySoftwareToken(com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest):com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult verifyUserAttribute(com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent(r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent(r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.cognitoidentityprovider.model.transform.VerifyUserAttributeRequestMarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.VerifyUserAttributeRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.transform.VerifyUserAttributeResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentityprovider.model.transform.VerifyUserAttributeResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult r0 = (com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent(r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient.verifyUserAttribute(com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest):com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult");
    }

    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    /* JADX INFO: finally extract failed */
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.jsonErrorUnmarshallers), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }
}
