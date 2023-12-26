package com.amazonaws.services.kms;

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
import com.amazonaws.services.kms.model.CreateAliasRequest;
import com.amazonaws.services.kms.model.CreateKeyRequest;
import com.amazonaws.services.kms.model.CreateKeyResult;
import com.amazonaws.services.kms.model.DeleteAliasRequest;
import com.amazonaws.services.kms.model.DeleteImportedKeyMaterialRequest;
import com.amazonaws.services.kms.model.DisableKeyRequest;
import com.amazonaws.services.kms.model.DisableKeyRotationRequest;
import com.amazonaws.services.kms.model.EnableKeyRequest;
import com.amazonaws.services.kms.model.EnableKeyRotationRequest;
import com.amazonaws.services.kms.model.GenerateRandomRequest;
import com.amazonaws.services.kms.model.GenerateRandomResult;
import com.amazonaws.services.kms.model.ListAliasesRequest;
import com.amazonaws.services.kms.model.ListAliasesResult;
import com.amazonaws.services.kms.model.ListKeysRequest;
import com.amazonaws.services.kms.model.ListKeysResult;
import com.amazonaws.services.kms.model.PutKeyPolicyRequest;
import com.amazonaws.services.kms.model.RetireGrantRequest;
import com.amazonaws.services.kms.model.RevokeGrantRequest;
import com.amazonaws.services.kms.model.TagResourceRequest;
import com.amazonaws.services.kms.model.UntagResourceRequest;
import com.amazonaws.services.kms.model.UpdateAliasRequest;
import com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest;
import com.amazonaws.services.kms.model.UpdatePrimaryRegionRequest;
import com.amazonaws.services.kms.model.transform.AlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterInvalidConfigurationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotActiveExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotRelatedExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CreateAliasRequestMarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreHasCMKsExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreNameInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DeleteAliasRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DeleteImportedKeyMaterialRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DependencyTimeoutExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DisableKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DisableKeyRotationRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DisabledExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.EnableKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.EnableKeyRotationRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ExpiredImportTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectKeyExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectKeyMaterialExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectTrustAnchorExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidAliasNameExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidArnExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidCiphertextExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidGrantIdExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidGrantTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidImportTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidKeyUsageExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidMarkerExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInternalExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInvalidSignatureExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KeyUnavailableExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.NotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.PutKeyPolicyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.RetireGrantRequestMarshaller;
import com.amazonaws.services.kms.model.transform.RevokeGrantRequestMarshaller;
import com.amazonaws.services.kms.model.transform.TagExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.TagResourceRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UnsupportedOperationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.UntagResourceRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UpdateAliasRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UpdateKeyDescriptionRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UpdatePrimaryRegionRequestMarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;

public class AWSKMSClient extends AmazonWebServiceClient implements AWSKMS {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AWSKMSClient() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AWSKMSClient(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AWSKMSClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AWSKMSClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new AlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterInvalidConfigurationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterNotActiveExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterNotRelatedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreHasCMKsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreInvalidStateExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreNameInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DependencyTimeoutExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DisabledExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ExpiredImportTokenExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IncorrectKeyExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IncorrectKeyMaterialExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IncorrectTrustAnchorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidAliasNameExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidArnExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidCiphertextExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidGrantIdExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidGrantTokenExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidImportTokenExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidKeyUsageExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidMarkerExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSInternalExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSInvalidSignatureExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSInvalidStateExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KeyUnavailableExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new NotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TagExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedOperationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("kms.us-east-1.amazonaws.com");
        this.endpointPrefix = "kms";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/kms/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/kms/request.handler2s"));
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
    public com.amazonaws.services.kms.model.CancelKeyDeletionResult cancelKeyDeletion(com.amazonaws.services.kms.model.CancelKeyDeletionRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.CancelKeyDeletionRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.CancelKeyDeletionRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.CancelKeyDeletionRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.CancelKeyDeletionResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.CancelKeyDeletionResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.CancelKeyDeletionResult r0 = (com.amazonaws.services.kms.model.CancelKeyDeletionResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.cancelKeyDeletion(com.amazonaws.services.kms.model.CancelKeyDeletionRequest):com.amazonaws.services.kms.model.CancelKeyDeletionResult");
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
    public com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult connectCustomKeyStore(com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult r0 = (com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.connectCustomKeyStore(com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest):com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult");
    }

    public void createAlias(CreateAliasRequest createAliasRequest) throws AmazonServiceException, AmazonClientException {
        Request<CreateAliasRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) createAliasRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new CreateAliasRequestMarshaller().marshall(createAliasRequest);
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
    public com.amazonaws.services.kms.model.CreateCustomKeyStoreResult createCustomKeyStore(com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.CreateCustomKeyStoreResult r0 = (com.amazonaws.services.kms.model.CreateCustomKeyStoreResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.createCustomKeyStore(com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest):com.amazonaws.services.kms.model.CreateCustomKeyStoreResult");
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
    public com.amazonaws.services.kms.model.CreateGrantResult createGrant(com.amazonaws.services.kms.model.CreateGrantRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.CreateGrantRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.CreateGrantRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.CreateGrantRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.CreateGrantResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.CreateGrantResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.CreateGrantResult r0 = (com.amazonaws.services.kms.model.CreateGrantResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.createGrant(com.amazonaws.services.kms.model.CreateGrantRequest):com.amazonaws.services.kms.model.CreateGrantResult");
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
    public com.amazonaws.services.kms.model.CreateKeyResult createKey(com.amazonaws.services.kms.model.CreateKeyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.CreateKeyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.CreateKeyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.CreateKeyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.CreateKeyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.CreateKeyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.CreateKeyResult r0 = (com.amazonaws.services.kms.model.CreateKeyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.createKey(com.amazonaws.services.kms.model.CreateKeyRequest):com.amazonaws.services.kms.model.CreateKeyResult");
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
    public com.amazonaws.services.kms.model.DecryptResult decrypt(com.amazonaws.services.kms.model.DecryptRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.DecryptRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.DecryptRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.DecryptRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.DecryptResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.DecryptResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.DecryptResult r0 = (com.amazonaws.services.kms.model.DecryptResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.decrypt(com.amazonaws.services.kms.model.DecryptRequest):com.amazonaws.services.kms.model.DecryptResult");
    }

    public void deleteAlias(DeleteAliasRequest deleteAliasRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteAliasRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteAliasRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteAliasRequestMarshaller().marshall(deleteAliasRequest);
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
    public com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult deleteCustomKeyStore(com.amazonaws.services.kms.model.DeleteCustomKeyStoreRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.DeleteCustomKeyStoreRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult r0 = (com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.deleteCustomKeyStore(com.amazonaws.services.kms.model.DeleteCustomKeyStoreRequest):com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult");
    }

    public void deleteImportedKeyMaterial(DeleteImportedKeyMaterialRequest deleteImportedKeyMaterialRequest) throws AmazonServiceException, AmazonClientException {
        Request<DeleteImportedKeyMaterialRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) deleteImportedKeyMaterialRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DeleteImportedKeyMaterialRequestMarshaller().marshall(deleteImportedKeyMaterialRequest);
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
    public com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult describeCustomKeyStores(com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult r0 = (com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.describeCustomKeyStores(com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest):com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult");
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
    public com.amazonaws.services.kms.model.DescribeKeyResult describeKey(com.amazonaws.services.kms.model.DescribeKeyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.DescribeKeyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.DescribeKeyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.DescribeKeyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.DescribeKeyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.DescribeKeyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.DescribeKeyResult r0 = (com.amazonaws.services.kms.model.DescribeKeyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.describeKey(com.amazonaws.services.kms.model.DescribeKeyRequest):com.amazonaws.services.kms.model.DescribeKeyResult");
    }

    public void disableKey(DisableKeyRequest disableKeyRequest) throws AmazonServiceException, AmazonClientException {
        Request<DisableKeyRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) disableKeyRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DisableKeyRequestMarshaller().marshall(disableKeyRequest);
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

    public void disableKeyRotation(DisableKeyRotationRequest disableKeyRotationRequest) throws AmazonServiceException, AmazonClientException {
        Request<DisableKeyRotationRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) disableKeyRotationRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new DisableKeyRotationRequestMarshaller().marshall(disableKeyRotationRequest);
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
    public com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult disconnectCustomKeyStore(com.amazonaws.services.kms.model.DisconnectCustomKeyStoreRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.DisconnectCustomKeyStoreRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult r0 = (com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.disconnectCustomKeyStore(com.amazonaws.services.kms.model.DisconnectCustomKeyStoreRequest):com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult");
    }

    public void enableKey(EnableKeyRequest enableKeyRequest) throws AmazonServiceException, AmazonClientException {
        Request<EnableKeyRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) enableKeyRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new EnableKeyRequestMarshaller().marshall(enableKeyRequest);
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

    public void enableKeyRotation(EnableKeyRotationRequest enableKeyRotationRequest) throws AmazonServiceException, AmazonClientException {
        Request<EnableKeyRotationRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) enableKeyRotationRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new EnableKeyRotationRequestMarshaller().marshall(enableKeyRotationRequest);
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
    public com.amazonaws.services.kms.model.EncryptResult encrypt(com.amazonaws.services.kms.model.EncryptRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.EncryptRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.EncryptRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.EncryptRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.EncryptResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.EncryptResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.EncryptResult r0 = (com.amazonaws.services.kms.model.EncryptResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.encrypt(com.amazonaws.services.kms.model.EncryptRequest):com.amazonaws.services.kms.model.EncryptResult");
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
    public com.amazonaws.services.kms.model.GenerateDataKeyResult generateDataKey(com.amazonaws.services.kms.model.GenerateDataKeyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GenerateDataKeyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GenerateDataKeyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GenerateDataKeyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GenerateDataKeyResult r0 = (com.amazonaws.services.kms.model.GenerateDataKeyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.generateDataKey(com.amazonaws.services.kms.model.GenerateDataKeyRequest):com.amazonaws.services.kms.model.GenerateDataKeyResult");
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
    public com.amazonaws.services.kms.model.GenerateDataKeyPairResult generateDataKeyPair(com.amazonaws.services.kms.model.GenerateDataKeyPairRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GenerateDataKeyPairRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyPairRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GenerateDataKeyPairRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GenerateDataKeyPairResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyPairResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GenerateDataKeyPairResult r0 = (com.amazonaws.services.kms.model.GenerateDataKeyPairResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.generateDataKeyPair(com.amazonaws.services.kms.model.GenerateDataKeyPairRequest):com.amazonaws.services.kms.model.GenerateDataKeyPairResult");
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
    public com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintext(com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GenerateDataKeyPairWithoutPlaintextRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyPairWithoutPlaintextRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextResult r0 = (com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.generateDataKeyPairWithoutPlaintext(com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextRequest):com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextResult");
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
    public com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintext(com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult r0 = (com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.generateDataKeyWithoutPlaintext(com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest):com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult");
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
    public com.amazonaws.services.kms.model.GenerateRandomResult generateRandom(com.amazonaws.services.kms.model.GenerateRandomRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GenerateRandomRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateRandomRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GenerateRandomRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GenerateRandomResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GenerateRandomResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GenerateRandomResult r0 = (com.amazonaws.services.kms.model.GenerateRandomResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.generateRandom(com.amazonaws.services.kms.model.GenerateRandomRequest):com.amazonaws.services.kms.model.GenerateRandomResult");
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
    public com.amazonaws.services.kms.model.GetKeyPolicyResult getKeyPolicy(com.amazonaws.services.kms.model.GetKeyPolicyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GetKeyPolicyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GetKeyPolicyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GetKeyPolicyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GetKeyPolicyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GetKeyPolicyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GetKeyPolicyResult r0 = (com.amazonaws.services.kms.model.GetKeyPolicyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.getKeyPolicy(com.amazonaws.services.kms.model.GetKeyPolicyRequest):com.amazonaws.services.kms.model.GetKeyPolicyResult");
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
    public com.amazonaws.services.kms.model.GetKeyRotationStatusResult getKeyRotationStatus(com.amazonaws.services.kms.model.GetKeyRotationStatusRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GetKeyRotationStatusRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GetKeyRotationStatusRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GetKeyRotationStatusRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GetKeyRotationStatusResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GetKeyRotationStatusResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GetKeyRotationStatusResult r0 = (com.amazonaws.services.kms.model.GetKeyRotationStatusResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.getKeyRotationStatus(com.amazonaws.services.kms.model.GetKeyRotationStatusRequest):com.amazonaws.services.kms.model.GetKeyRotationStatusResult");
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
    public com.amazonaws.services.kms.model.GetParametersForImportResult getParametersForImport(com.amazonaws.services.kms.model.GetParametersForImportRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GetParametersForImportRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GetParametersForImportRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GetParametersForImportRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GetParametersForImportResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GetParametersForImportResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GetParametersForImportResult r0 = (com.amazonaws.services.kms.model.GetParametersForImportResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.getParametersForImport(com.amazonaws.services.kms.model.GetParametersForImportRequest):com.amazonaws.services.kms.model.GetParametersForImportResult");
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
    public com.amazonaws.services.kms.model.GetPublicKeyResult getPublicKey(com.amazonaws.services.kms.model.GetPublicKeyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.GetPublicKeyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.GetPublicKeyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.GetPublicKeyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.GetPublicKeyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.GetPublicKeyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.GetPublicKeyResult r0 = (com.amazonaws.services.kms.model.GetPublicKeyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.getPublicKey(com.amazonaws.services.kms.model.GetPublicKeyRequest):com.amazonaws.services.kms.model.GetPublicKeyResult");
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
    public com.amazonaws.services.kms.model.ImportKeyMaterialResult importKeyMaterial(com.amazonaws.services.kms.model.ImportKeyMaterialRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ImportKeyMaterialRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ImportKeyMaterialRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ImportKeyMaterialRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ImportKeyMaterialResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ImportKeyMaterialResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ImportKeyMaterialResult r0 = (com.amazonaws.services.kms.model.ImportKeyMaterialResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.importKeyMaterial(com.amazonaws.services.kms.model.ImportKeyMaterialRequest):com.amazonaws.services.kms.model.ImportKeyMaterialResult");
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
    public com.amazonaws.services.kms.model.ListAliasesResult listAliases(com.amazonaws.services.kms.model.ListAliasesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ListAliasesRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ListAliasesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ListAliasesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ListAliasesResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ListAliasesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ListAliasesResult r0 = (com.amazonaws.services.kms.model.ListAliasesResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.listAliases(com.amazonaws.services.kms.model.ListAliasesRequest):com.amazonaws.services.kms.model.ListAliasesResult");
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
    public com.amazonaws.services.kms.model.ListGrantsResult listGrants(com.amazonaws.services.kms.model.ListGrantsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ListGrantsRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ListGrantsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ListGrantsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ListGrantsResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ListGrantsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ListGrantsResult r0 = (com.amazonaws.services.kms.model.ListGrantsResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.listGrants(com.amazonaws.services.kms.model.ListGrantsRequest):com.amazonaws.services.kms.model.ListGrantsResult");
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
    public com.amazonaws.services.kms.model.ListKeyPoliciesResult listKeyPolicies(com.amazonaws.services.kms.model.ListKeyPoliciesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ListKeyPoliciesRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ListKeyPoliciesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ListKeyPoliciesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ListKeyPoliciesResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ListKeyPoliciesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ListKeyPoliciesResult r0 = (com.amazonaws.services.kms.model.ListKeyPoliciesResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.listKeyPolicies(com.amazonaws.services.kms.model.ListKeyPoliciesRequest):com.amazonaws.services.kms.model.ListKeyPoliciesResult");
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
    public com.amazonaws.services.kms.model.ListKeysResult listKeys(com.amazonaws.services.kms.model.ListKeysRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ListKeysRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ListKeysRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ListKeysRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ListKeysResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ListKeysResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ListKeysResult r0 = (com.amazonaws.services.kms.model.ListKeysResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.listKeys(com.amazonaws.services.kms.model.ListKeysRequest):com.amazonaws.services.kms.model.ListKeysResult");
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
    public com.amazonaws.services.kms.model.ListResourceTagsResult listResourceTags(com.amazonaws.services.kms.model.ListResourceTagsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ListResourceTagsRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ListResourceTagsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ListResourceTagsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ListResourceTagsResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ListResourceTagsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ListResourceTagsResult r0 = (com.amazonaws.services.kms.model.ListResourceTagsResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.listResourceTags(com.amazonaws.services.kms.model.ListResourceTagsRequest):com.amazonaws.services.kms.model.ListResourceTagsResult");
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
    public com.amazonaws.services.kms.model.ListRetirableGrantsResult listRetirableGrants(com.amazonaws.services.kms.model.ListRetirableGrantsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ListRetirableGrantsRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ListRetirableGrantsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ListRetirableGrantsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ListRetirableGrantsResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ListRetirableGrantsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ListRetirableGrantsResult r0 = (com.amazonaws.services.kms.model.ListRetirableGrantsResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.listRetirableGrants(com.amazonaws.services.kms.model.ListRetirableGrantsRequest):com.amazonaws.services.kms.model.ListRetirableGrantsResult");
    }

    public void putKeyPolicy(PutKeyPolicyRequest putKeyPolicyRequest) throws AmazonServiceException, AmazonClientException {
        Request<PutKeyPolicyRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) putKeyPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new PutKeyPolicyRequestMarshaller().marshall(putKeyPolicyRequest);
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
    public com.amazonaws.services.kms.model.ReEncryptResult reEncrypt(com.amazonaws.services.kms.model.ReEncryptRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ReEncryptRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ReEncryptRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ReEncryptRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ReEncryptResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ReEncryptResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ReEncryptResult r0 = (com.amazonaws.services.kms.model.ReEncryptResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.reEncrypt(com.amazonaws.services.kms.model.ReEncryptRequest):com.amazonaws.services.kms.model.ReEncryptResult");
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
    public com.amazonaws.services.kms.model.ReplicateKeyResult replicateKey(com.amazonaws.services.kms.model.ReplicateKeyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ReplicateKeyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ReplicateKeyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ReplicateKeyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ReplicateKeyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ReplicateKeyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ReplicateKeyResult r0 = (com.amazonaws.services.kms.model.ReplicateKeyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.replicateKey(com.amazonaws.services.kms.model.ReplicateKeyRequest):com.amazonaws.services.kms.model.ReplicateKeyResult");
    }

    public void retireGrant(RetireGrantRequest retireGrantRequest) throws AmazonServiceException, AmazonClientException {
        Request<RetireGrantRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) retireGrantRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new RetireGrantRequestMarshaller().marshall(retireGrantRequest);
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

    public void revokeGrant(RevokeGrantRequest revokeGrantRequest) throws AmazonServiceException, AmazonClientException {
        Request<RevokeGrantRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) revokeGrantRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new RevokeGrantRequestMarshaller().marshall(revokeGrantRequest);
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
    public com.amazonaws.services.kms.model.ScheduleKeyDeletionResult scheduleKeyDeletion(com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.ScheduleKeyDeletionResult r0 = (com.amazonaws.services.kms.model.ScheduleKeyDeletionResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.scheduleKeyDeletion(com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest):com.amazonaws.services.kms.model.ScheduleKeyDeletionResult");
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
    public com.amazonaws.services.kms.model.SignResult sign(com.amazonaws.services.kms.model.SignRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.SignRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.SignRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.SignRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.SignResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.SignResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.SignResult r0 = (com.amazonaws.services.kms.model.SignResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.sign(com.amazonaws.services.kms.model.SignRequest):com.amazonaws.services.kms.model.SignResult");
    }

    public void tagResource(TagResourceRequest tagResourceRequest) throws AmazonServiceException, AmazonClientException {
        Request<TagResourceRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) tagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new TagResourceRequestMarshaller().marshall(tagResourceRequest);
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

    public void untagResource(UntagResourceRequest untagResourceRequest) throws AmazonServiceException, AmazonClientException {
        Request<UntagResourceRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) untagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UntagResourceRequestMarshaller().marshall(untagResourceRequest);
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

    public void updateAlias(UpdateAliasRequest updateAliasRequest) throws AmazonServiceException, AmazonClientException {
        Request<UpdateAliasRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) updateAliasRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UpdateAliasRequestMarshaller().marshall(updateAliasRequest);
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
    public com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult updateCustomKeyStore(com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult r0 = (com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.updateCustomKeyStore(com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest):com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult");
    }

    public void updateKeyDescription(UpdateKeyDescriptionRequest updateKeyDescriptionRequest) throws AmazonServiceException, AmazonClientException {
        Request<UpdateKeyDescriptionRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) updateKeyDescriptionRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UpdateKeyDescriptionRequestMarshaller().marshall(updateKeyDescriptionRequest);
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

    public void updatePrimaryRegion(UpdatePrimaryRegionRequest updatePrimaryRegionRequest) throws AmazonServiceException, AmazonClientException {
        Request<UpdatePrimaryRegionRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) updatePrimaryRegionRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UpdatePrimaryRegionRequestMarshaller().marshall(updatePrimaryRegionRequest);
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
    public com.amazonaws.services.kms.model.VerifyResult verify(com.amazonaws.services.kms.model.VerifyRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
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
            com.amazonaws.services.kms.model.transform.VerifyRequestMarshaller r4 = new com.amazonaws.services.kms.model.transform.VerifyRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.kms.model.VerifyRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.transform.VerifyResultJsonUnmarshaller r4 = new com.amazonaws.services.kms.model.transform.VerifyResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.kms.model.VerifyResult r0 = (com.amazonaws.services.kms.model.VerifyResult) r0     // Catch:{ all -> 0x004c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.kms.AWSKMSClient.verify(com.amazonaws.services.kms.model.VerifyRequest):com.amazonaws.services.kms.model.VerifyResult");
    }

    public CreateKeyResult createKey() throws AmazonServiceException, AmazonClientException {
        return createKey(new CreateKeyRequest());
    }

    public ListKeysResult listKeys() throws AmazonServiceException, AmazonClientException {
        return listKeys(new ListKeysRequest());
    }

    public ListAliasesResult listAliases() throws AmazonServiceException, AmazonClientException {
        return listAliases(new ListAliasesRequest());
    }

    public void retireGrant() throws AmazonServiceException, AmazonClientException {
        retireGrant(new RetireGrantRequest());
    }

    public GenerateRandomResult generateRandom() throws AmazonServiceException, AmazonClientException {
        return generateRandom(new GenerateRandomRequest());
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
