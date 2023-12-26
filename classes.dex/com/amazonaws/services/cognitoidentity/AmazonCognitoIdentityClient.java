package com.amazonaws.services.cognitoidentity;

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
import com.amazonaws.services.cognitoidentity.model.DeleteIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.SetIdentityPoolRolesRequest;
import com.amazonaws.services.cognitoidentity.model.UnlinkDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.UnlinkIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.transform.ConcurrentModificationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentityPoolRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeveloperUserAlreadyRegisteredExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ExternalServiceExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InternalErrorExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidIdentityPoolConfigurationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidParameterExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.NotAuthorizedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceConflictExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.SetIdentityPoolRolesRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.TooManyRequestsExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UnlinkDeveloperIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UnlinkIdentityRequestMarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;

public class AmazonCognitoIdentityClient extends AmazonWebServiceClient implements AmazonCognitoIdentity {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AmazonCognitoIdentityClient() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonCognitoIdentityClient(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonCognitoIdentityClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonCognitoIdentityClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new ConcurrentModificationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DeveloperUserAlreadyRegisteredExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ExternalServiceExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidIdentityPoolConfigurationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidParameterExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new NotAuthorizedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceConflictExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TooManyRequestsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("cognito-identity.us-east-1.amazonaws.com");
        this.endpointPrefix = "cognito-identity";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/cognitoidentity/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/cognitoidentity/request.handler2s"));
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
    public com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolResult createIdentityPool(com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolResult r0 = (com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.createIdentityPool(com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest):com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolResult");
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
    public com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult deleteIdentities(com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentitiesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentitiesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentitiesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentitiesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult r0 = (com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.deleteIdentities(com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesRequest):com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult");
    }

    public void deleteIdentityPool(DeleteIdentityPoolRequest deleteIdentityPoolRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteIdentityPoolRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteIdentityPoolRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteIdentityPoolRequestMarshaller().marshall(deleteIdentityPoolRequest);
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
    public com.amazonaws.services.cognitoidentity.model.DescribeIdentityResult describeIdentity(com.amazonaws.services.cognitoidentity.model.DescribeIdentityRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.DescribeIdentityRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.DescribeIdentityResult r0 = (com.amazonaws.services.cognitoidentity.model.DescribeIdentityResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.describeIdentity(com.amazonaws.services.cognitoidentity.model.DescribeIdentityRequest):com.amazonaws.services.cognitoidentity.model.DescribeIdentityResult");
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
    public com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolResult describeIdentityPool(com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityPoolRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityPoolRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityPoolResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityPoolResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolResult r0 = (com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.describeIdentityPool(com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolRequest):com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolResult");
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
    public com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult getCredentialsForIdentity(com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult r0 = (com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.getCredentialsForIdentity(com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest):com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult");
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
    public com.amazonaws.services.cognitoidentity.model.GetIdResult getId(com.amazonaws.services.cognitoidentity.model.GetIdRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.GetIdRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetIdRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.GetIdRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.GetIdResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetIdResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.GetIdResult r0 = (com.amazonaws.services.cognitoidentity.model.GetIdResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.getId(com.amazonaws.services.cognitoidentity.model.GetIdRequest):com.amazonaws.services.cognitoidentity.model.GetIdResult");
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
    public com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult getIdentityPoolRoles(com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.GetIdentityPoolRolesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetIdentityPoolRolesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.GetIdentityPoolRolesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetIdentityPoolRolesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult r0 = (com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.getIdentityPoolRoles(com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesRequest):com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult");
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
    public com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult getOpenIdToken(com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult r0 = (com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.getOpenIdToken(com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest):com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult");
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
    public com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult getOpenIdTokenForDeveloperIdentity(com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenForDeveloperIdentityRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenForDeveloperIdentityRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenForDeveloperIdentityResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenForDeveloperIdentityResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult r0 = (com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.getOpenIdTokenForDeveloperIdentity(com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest):com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult");
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
    public com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapResult getPrincipalTagAttributeMap(com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.GetPrincipalTagAttributeMapRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetPrincipalTagAttributeMapRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.GetPrincipalTagAttributeMapResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.GetPrincipalTagAttributeMapResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapResult r0 = (com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.getPrincipalTagAttributeMap(com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapRequest):com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapResult");
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
    public com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult listIdentities(com.amazonaws.services.cognitoidentity.model.ListIdentitiesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.ListIdentitiesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.ListIdentitiesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.ListIdentitiesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.ListIdentitiesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.ListIdentitiesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult r0 = (com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.listIdentities(com.amazonaws.services.cognitoidentity.model.ListIdentitiesRequest):com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult");
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
    public com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult listIdentityPools(com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.ListIdentityPoolsRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.ListIdentityPoolsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.ListIdentityPoolsResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.ListIdentityPoolsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult r0 = (com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.listIdentityPools(com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsRequest):com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult");
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
    public com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult listTagsForResource(com.amazonaws.services.cognitoidentity.model.ListTagsForResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.ListTagsForResourceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.ListTagsForResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.ListTagsForResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.ListTagsForResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.ListTagsForResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult r0 = (com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.listTagsForResource(com.amazonaws.services.cognitoidentity.model.ListTagsForResourceRequest):com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult");
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
    public com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityResult lookupDeveloperIdentity(com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.LookupDeveloperIdentityRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.LookupDeveloperIdentityRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.LookupDeveloperIdentityResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.LookupDeveloperIdentityResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityResult r0 = (com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.lookupDeveloperIdentity(com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityRequest):com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityResult");
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
    public com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult mergeDeveloperIdentities(com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.MergeDeveloperIdentitiesRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.MergeDeveloperIdentitiesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.MergeDeveloperIdentitiesResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.MergeDeveloperIdentitiesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult r0 = (com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.mergeDeveloperIdentities(com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesRequest):com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult");
    }

    public void setIdentityPoolRoles(SetIdentityPoolRolesRequest setIdentityPoolRolesRequest) throws AmazonServiceException, AmazonClientException {
        Request<SetIdentityPoolRolesRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) setIdentityPoolRolesRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new SetIdentityPoolRolesRequestMarshaller().marshall(setIdentityPoolRolesRequest);
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
    public com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult setPrincipalTagAttributeMap(com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.SetPrincipalTagAttributeMapRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.SetPrincipalTagAttributeMapRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.SetPrincipalTagAttributeMapResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.SetPrincipalTagAttributeMapResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult r0 = (com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.setPrincipalTagAttributeMap(com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapRequest):com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult");
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
    public com.amazonaws.services.cognitoidentity.model.TagResourceResult tagResource(com.amazonaws.services.cognitoidentity.model.TagResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.TagResourceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.TagResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.TagResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.TagResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.TagResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.TagResourceResult r0 = (com.amazonaws.services.cognitoidentity.model.TagResourceResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.tagResource(com.amazonaws.services.cognitoidentity.model.TagResourceRequest):com.amazonaws.services.cognitoidentity.model.TagResourceResult");
    }

    public void unlinkDeveloperIdentity(UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest) throws AmazonServiceException, AmazonClientException {
        Request<UnlinkDeveloperIdentityRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) unlinkDeveloperIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UnlinkDeveloperIdentityRequestMarshaller().marshall(unlinkDeveloperIdentityRequest);
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

    public void unlinkIdentity(UnlinkIdentityRequest unlinkIdentityRequest) throws AmazonServiceException, AmazonClientException {
        Request<UnlinkIdentityRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) unlinkIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UnlinkIdentityRequestMarshaller().marshall(unlinkIdentityRequest);
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
    public com.amazonaws.services.cognitoidentity.model.UntagResourceResult untagResource(com.amazonaws.services.cognitoidentity.model.UntagResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.UntagResourceRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.UntagResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.UntagResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.UntagResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.UntagResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.UntagResourceResult r0 = (com.amazonaws.services.cognitoidentity.model.UntagResourceResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.untagResource(com.amazonaws.services.cognitoidentity.model.UntagResourceRequest):com.amazonaws.services.cognitoidentity.model.UntagResourceResult");
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
    public com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolResult updateIdentityPool(com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.cognitoidentity.model.transform.UpdateIdentityPoolRequestMarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.UpdateIdentityPoolRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.transform.UpdateIdentityPoolResultJsonUnmarshaller r4 = new com.amazonaws.services.cognitoidentity.model.transform.UpdateIdentityPoolResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolResult r0 = (com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient.updateIdentityPool(com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolRequest):com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolResult");
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
