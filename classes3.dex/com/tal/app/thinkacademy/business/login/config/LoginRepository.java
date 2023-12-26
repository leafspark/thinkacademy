package com.tal.app.thinkacademy.business.login.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J5\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJE\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ3\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0013\u0010#\u001a\u0004\u0018\u00010$H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010%\u001a\u0004\u0018\u00010&H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010'\u001a\u0004\u0018\u00010(H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010)\u001a\u0004\u0018\u00010*H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005JC\u0010+\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0019\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u000100H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u00101\u001a\u0004\u0018\u000102H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u00103\u001a\u0004\u0018\u000104H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u00105\u001a\u0004\u0018\u00010\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005JY\u00106\u001a\u0004\u0018\u00010\u00012\b\u00107\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u00108\u001a\u0004\u0018\u00010\f2\u0012\b\u0002\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u00010\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010;JO\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010=JO\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010@J5\u0010A\u001a\u0004\u0018\u00010\u00012\b\u0010B\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010\t2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t00H@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u001d\u0010F\u001a\u0004\u0018\u00010\u00072\b\u0010G\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ#\u0010H\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020I2\u0006\u0010J\u001a\u00020KH@ø\u0001\u0000¢\u0006\u0002\u0010L\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "", "()V", "accountCheck", "Lcom/tal/app/thinkacademy/business/login/entity/AccountCheckData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountLogin", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "accountName", "", "password", "type", "", "countryCallingCode", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNewStudent", "Lcom/tal/app/thinkacademy/business/login/entity/AddNewStudent;", "nickName", "firstName", "lastName", "gradeId", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bannersData", "", "Lcom/tal/app/thinkacademy/business/login/entity/BannersData;", "bindEmail", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "codeLogin", "verificationCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountList", "Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "schoolCode", "getBasicUserInfo", "Lcom/tal/app/thinkacademy/common/user/BasicUserInfo;", "getBasicUserInfoOnly", "Lcom/tal/app/thinkacademy/business/login/entity/UseGetInfo;", "getGradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "getMasterUserInfo", "Lcom/tal/app/thinkacademy/business/login/entity/MasterUserBean;", "getSmsCode", "contactInfo", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeZoneList", "", "initEntryInfoData", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "legalFiles", "Lcom/tal/app/thinkacademy/business/login/entity/AboutListEntity;", "loginOut", "modifyUserBasicInfo", "avatar", "grade", "linkedAccount", "Lcom/tal/app/thinkacademy/business/login/entity/LinkedAccount;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "securityCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lcom/tal/app/thinkacademy/business/login/entity/SetPasswordData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitFeedback", "tag", "details", "images", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchLogin", "targetUid", "uploadPublicRead", "Lokhttp3/RequestBody;", "body", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginRepository.kt */
public final class LoginRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object uploadPublicRead(okhttp3.RequestBody r8, okhttp3.MultipartBody.Part r9, kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$uploadPublicRead$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.login.config.LoginRepository$uploadPublicRead$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$uploadPublicRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$uploadPublicRead$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$uploadPublicRead$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r8 = r2.uploadPublicRead(r8, r9, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r10
            r10 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.transform(r10, r0)
            if (r10 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.uploadPublicRead(okhttp3.RequestBody, okhttp3.MultipartBody$Part, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object legalFiles(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.AboutListEntity> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$legalFiles$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.LoginRepository$legalFiles$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$legalFiles$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$legalFiles$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$legalFiles$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r7 = r7.legalFiles(r4, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.legalFiles(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[PHI: r15 
      PHI: (r15v2 java.lang.Object) = (r15v5 java.lang.Object), (r15v1 java.lang.Object) binds: [B:19:0x0078, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSmsCode(java.lang.String r11, java.lang.String r12, java.lang.Integer r13, java.lang.Integer r14, kotlin.coroutines.Continuation<java.lang.Object> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getSmsCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getSmsCode$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getSmsCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getSmsCode$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getSmsCode$1
            r0.<init>(r10, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x007b
        L_0x002e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0036:
            java.lang.Object r11 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r11 = (com.tal.app.thinkacademy.common.network.NetData) r11
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x006e
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r15)
            com.tal.app.thinkacademy.common.network.NetData r15 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            com.tal.app.thinkacademy.business.login.entity.post.GetCode r6 = new com.tal.app.thinkacademy.business.login.entity.post.GetCode
            com.tal.app.thinkacademy.business.login.entity.post.GetCodeHeader r7 = new com.tal.app.thinkacademy.business.login.entity.post.GetCodeHeader
            r7.<init>(r4, r5, r4)
            com.tal.app.thinkacademy.business.login.entity.post.GetCodeData r8 = new com.tal.app.thinkacademy.business.login.entity.post.GetCodeData
            r8.<init>(r11, r12, r13, r14)
            r6.<init>(r7, r8)
            r0.L$0 = r15
            r0.label = r5
            java.lang.Object r11 = r2.getSmsCode(r6, r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r9 = r15
            r15 = r11
            r11 = r9
        L_0x006e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r15 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r15
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r15 = r11.transform(r15, r0)
            if (r15 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getSmsCode(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getSmsCode$default(LoginRepository loginRepository, String str, String str2, Integer num, Integer num2, Continuation continuation, int i, Object obj) {
        String str3 = (i & 1) != 0 ? "" : str;
        String str4 = (i & 2) != 0 ? "" : str2;
        if ((i & 4) != 0) {
            num = 1;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = 1;
        }
        return loginRepository.getSmsCode(str3, str4, num3, num2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[PHI: r12 
      PHI: (r12v2 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:19:0x0072, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object codeLogin(java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.UserBean> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$codeLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.tal.app.thinkacademy.business.login.config.LoginRepository$codeLogin$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$codeLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$codeLogin$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$codeLogin$1
            r0.<init>(r7, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0075
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r12)
            com.tal.app.thinkacademy.common.network.NetData r12 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            com.tal.app.thinkacademy.business.login.entity.post.CodeLogin r5 = new com.tal.app.thinkacademy.business.login.entity.post.CodeLogin
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            r5.<init>(r8, r9, r10, r11)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r8 = r2.codeLogin(r5, r0)
            if (r8 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r12
            r12 = r8
            r8 = r6
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r12 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r12
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r12 = r8.transform(r12, r0)
            if (r12 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.codeLogin(java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[PHI: r12 
      PHI: (r12v2 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:19:0x0072, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object accountLogin(java.lang.String r8, java.lang.String r9, int r10, java.lang.String r11, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.UserBean> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$accountLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.tal.app.thinkacademy.business.login.config.LoginRepository$accountLogin$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$accountLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$accountLogin$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$accountLogin$1
            r0.<init>(r7, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0075
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r12)
            com.tal.app.thinkacademy.common.network.NetData r12 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            com.tal.app.thinkacademy.business.login.entity.post.AccountLogin r5 = new com.tal.app.thinkacademy.business.login.entity.post.AccountLogin
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            r5.<init>(r8, r9, r10, r11)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r8 = r2.accountLogin(r5, r0)
            if (r8 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r12
            r12 = r8
            r8 = r6
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r12 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r12
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r12 = r8.transform(r12, r0)
            if (r12 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.accountLogin(java.lang.String, java.lang.String, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loginOut(kotlin.coroutines.Continuation<java.lang.Object> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$loginOut$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.LoginRepository$loginOut$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$loginOut$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$loginOut$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$loginOut$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r7 = r7.loginOut(r4, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.loginOut(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x006e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object bindEmail(java.lang.String r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$bindEmail$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.login.config.LoginRepository$bindEmail$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$bindEmail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$bindEmail$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$bindEmail$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            com.tal.app.thinkacademy.business.login.entity.post.BindEmail r5 = new com.tal.app.thinkacademy.business.login.entity.post.BindEmail
            r5.<init>(r8)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.bindEmail(r5, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0063:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.bindEmail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getBasicUserInfo(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.BasicUserInfo> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfo$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfo$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfo$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r7 = r7.getBasicUserInfo(r4, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getBasicUserInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initEntryInfoData(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.InitEntryInfoBean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$initEntryInfoData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.LoginRepository$initEntryInfoData$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$initEntryInfoData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$initEntryInfoData$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$initEntryInfoData$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r7 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r7 = r7.initEntryInfoData(r4, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.initEntryInfoData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:18:0x006c, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object bannersData(kotlin.coroutines.Continuation<? super java.util.List<com.tal.app.thinkacademy.business.login.entity.BannersData>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$bannersData$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.login.config.LoginRepository$bannersData$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$bannersData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$bannersData$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$bannersData$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006f
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r9 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r9 = r9.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r9 = com.tal.app.thinkacademy.lib.network.Api.create(r9, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r9 = (com.tal.app.thinkacademy.business.login.config.ApiService) r9
            com.tal.app.thinkacademy.business.login.entity.post.BannersRequest r6 = new com.tal.app.thinkacademy.business.login.entity.post.BannersRequest
            r7 = 3
            r6.<init>(r5, r5, r7, r5)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r9.bannersData(r6, r0)
            if (r9 != r1) goto L_0x0062
            return r1
        L_0x0062:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r9 = r2.transform(r9, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.bannersData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0081, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGradeStageList(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.GradeStageList> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getGradeStageList$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getGradeStageList$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getGradeStageList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getGradeStageList$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getGradeStageList$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0084
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r9 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "school_code"
            java.lang.String r6 = ""
            java.lang.String r9 = r9.getString(r5, r6, r2)
            com.tal.app.thinkacademy.business.login.entity.post.GetGradeList r2 = new com.tal.app.thinkacademy.business.login.entity.post.GetGradeList
            com.tal.app.thinkacademy.common.entity.Header r5 = new com.tal.app.thinkacademy.common.entity.Header
            r5.<init>(r9)
            r2.<init>(r5)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r5 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r5 = r5.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r5 = (com.tal.app.thinkacademy.business.login.config.ApiService) r5
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r2 = r5.getGradeStageList(r2, r0)
            if (r2 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r7 = r2
            r2 = r9
            r9 = r7
        L_0x0076:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r9 = r2.transform(r9, r0)
            if (r9 != r1) goto L_0x0084
            return r1
        L_0x0084:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getGradeStageList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object modifyUserBasicInfo$default(LoginRepository loginRepository, String str, String str2, String str3, String str4, Integer num, List list, Continuation continuation, int i, Object obj) {
        return loginRepository.modifyUserBasicInfo(str, str2, str3, str4, num, (i & 32) != 0 ? null : list, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083 A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0080, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object modifyUserBasicInfo(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.util.List<com.tal.app.thinkacademy.business.login.entity.LinkedAccount> r20, kotlin.coroutines.Continuation<java.lang.Object> r21) {
        /*
            r14 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$modifyUserBasicInfo$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.tal.app.thinkacademy.business.login.config.LoginRepository$modifyUserBasicInfo$1 r1 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$modifyUserBasicInfo$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0017
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r14
            goto L_0x001d
        L_0x0017:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$modifyUserBasicInfo$1 r1 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$modifyUserBasicInfo$1
            r2 = r14
            r1.<init>(r14, r0)
        L_0x001d:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0041
            if (r4 == r6) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0083
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0075
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.business.login.entity.post.ModifyUserInfo r0 = new com.tal.app.thinkacademy.business.login.entity.post.ModifyUserInfo
            com.tal.app.thinkacademy.business.login.entity.post.Data r4 = new com.tal.app.thinkacademy.business.login.entity.post.Data
            r7 = r4
            r8 = r15
            r9 = r17
            r10 = r19
            r11 = r18
            r12 = r16
            r13 = r20
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r0.<init>(r4)
            com.tal.app.thinkacademy.common.network.NetData r4 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r8 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r8)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r1.L$0 = r4
            r1.label = r6
            java.lang.Object r0 = r7.modifyUserBasicInfo(r0, r1)
            if (r0 != r3) goto L_0x0075
            return r3
        L_0x0075:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r6 = 0
            r1.L$0 = r6
            r1.label = r5
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x0083
            return r3
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.modifyUserBasicInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getAccountList$default(LoginRepository loginRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return loginRepository.getAccountList(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x006b, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAccountList(java.lang.String r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.AccountListEntity> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getAccountList$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getAccountList$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getAccountList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getAccountList$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getAccountList$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0060
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r8 = r2.getAccountList(r4, r8, r0)
            if (r8 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0060:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getAccountList(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094 A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:19:0x0091, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addNewStudent(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.String r18, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.AddNewStudent> r19) {
        /*
            r13 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$addNewStudent$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.tal.app.thinkacademy.business.login.config.LoginRepository$addNewStudent$1 r1 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$addNewStudent$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0017
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r13
            goto L_0x001d
        L_0x0017:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$addNewStudent$1 r1 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$addNewStudent$1
            r2 = r13
            r1.<init>(r13, r0)
        L_0x001d:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0041
            if (r4 == r6) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0094
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0086
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r7 = "school_code"
            java.lang.String r8 = ""
            java.lang.String r0 = r0.getString(r7, r8, r4)
            com.tal.app.thinkacademy.business.login.entity.post.NewStudent r4 = new com.tal.app.thinkacademy.business.login.entity.post.NewStudent
            r7 = r4
            r8 = r14
            r9 = r15
            r10 = r16
            r11 = r17
            r12 = r18
            r7.<init>(r8, r9, r10, r11, r12)
            com.tal.app.thinkacademy.common.network.NetData r7 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r8 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r8 = r8.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r9 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r8 = com.tal.app.thinkacademy.lib.network.Api.create(r8, r9)
            com.tal.app.thinkacademy.business.login.config.ApiService r8 = (com.tal.app.thinkacademy.business.login.config.ApiService) r8
            com.tal.app.thinkacademy.business.login.entity.post.AddNewStudentRequest r9 = new com.tal.app.thinkacademy.business.login.entity.post.AddNewStudentRequest
            com.tal.app.thinkacademy.common.entity.Header r10 = new com.tal.app.thinkacademy.common.entity.Header
            r10.<init>(r0)
            r9.<init>(r10, r4)
            r1.L$0 = r7
            r1.label = r6
            java.lang.Object r0 = r8.addNewStudent(r9, r1)
            if (r0 != r3) goto L_0x0085
            return r3
        L_0x0085:
            r4 = r7
        L_0x0086:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r6 = 0
            r1.L$0 = r6
            r1.label = r5
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x0094
            return r3
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.addNewStudent(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x0083, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object switchLogin(java.lang.String r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.UserBean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$switchLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.login.config.LoginRepository$switchLogin$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$switchLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$switchLogin$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$switchLogin$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0086
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0078
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r10 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "school_code"
            java.lang.String r6 = ""
            java.lang.String r10 = r10.getString(r5, r6, r2)
            com.tal.app.thinkacademy.common.entity.SwitchData r2 = new com.tal.app.thinkacademy.common.entity.SwitchData
            r2.<init>(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r5 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r5 = r5.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r5 = (com.tal.app.thinkacademy.business.login.config.ApiService) r5
            com.tal.app.thinkacademy.common.entity.SwitchLogin r6 = new com.tal.app.thinkacademy.common.entity.SwitchLogin
            com.tal.app.thinkacademy.common.entity.Header r7 = new com.tal.app.thinkacademy.common.entity.Header
            r7.<init>(r10)
            r6.<init>(r7, r2)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = r5.switchLogin(r6, r0)
            if (r10 != r1) goto L_0x0078
            return r1
        L_0x0078:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x0086
            return r1
        L_0x0086:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.switchLogin(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMasterUserInfo(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.MasterUserBean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getMasterUserInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getMasterUserInfo$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getMasterUserInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getMasterUserInfo$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getMasterUserInfo$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r7 = r7.getMasterUserInfo(r4, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getMasterUserInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r12 
      PHI: (r12v2 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitFeedback(java.lang.String r9, java.lang.String r10, java.lang.String[] r11, kotlin.coroutines.Continuation<java.lang.Object> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$submitFeedback$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.tal.app.thinkacademy.business.login.config.LoginRepository$submitFeedback$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$submitFeedback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$submitFeedback$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$submitFeedback$1
            r0.<init>(r8, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0068
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r12)
            com.tal.app.thinkacademy.common.network.NetData r12 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            com.tal.app.thinkacademy.business.login.entity.post.SubmitFeedback r5 = new com.tal.app.thinkacademy.business.login.entity.post.SubmitFeedback
            com.tal.app.thinkacademy.business.login.entity.post.Feedback r6 = new com.tal.app.thinkacademy.business.login.entity.post.Feedback
            r6.<init>(r9, r10, r11)
            r5.<init>(r6)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r9 = r2.submitFeedback(r5, r0)
            if (r9 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r12
            r12 = r9
            r9 = r7
        L_0x0068:
            com.tal.app.thinkacademy.lib.restful.HiResponse r12 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r12
            r10 = 0
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r12 = r9.transform(r12, r0)
            if (r12 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.submitFeedback(java.lang.String, java.lang.String, java.lang.String[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0088, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object securityCheck(java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.lang.String r20, java.lang.Integer r21, kotlin.coroutines.Continuation<java.lang.Object> r22) {
        /*
            r16 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$securityCheck$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.tal.app.thinkacademy.business.login.config.LoginRepository$securityCheck$1 r1 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$securityCheck$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r16
            goto L_0x001f
        L_0x0018:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$securityCheck$1 r1 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$securityCheck$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0044
            if (r4 == r7) goto L_0x003c
            if (r4 != r5) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x008b
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007d
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.network.NetData r4 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r0 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r8 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0, r8)
            com.tal.app.thinkacademy.business.login.config.ApiService r0 = (com.tal.app.thinkacademy.business.login.config.ApiService) r0
            com.tal.app.thinkacademy.business.login.entity.post.SecurityCheck r8 = new com.tal.app.thinkacademy.business.login.entity.post.SecurityCheck
            com.tal.app.thinkacademy.business.login.entity.post.SecurityCheckHeader r9 = new com.tal.app.thinkacademy.business.login.entity.post.SecurityCheckHeader
            r9.<init>(r6, r7, r6)
            com.tal.app.thinkacademy.business.login.entity.post.SecurityCheckData r15 = new com.tal.app.thinkacademy.business.login.entity.post.SecurityCheckData
            r10 = r15
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r20
            r5 = r15
            r15 = r21
            r10.<init>(r11, r12, r13, r14, r15)
            r8.<init>(r9, r5)
            r1.L$0 = r4
            r1.label = r7
            java.lang.Object r0 = r0.securityCheck(r8, r1)
            if (r0 != r3) goto L_0x007d
            return r3
        L_0x007d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r1.L$0 = r6
            r5 = 2
            r1.label = r5
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x008b
            return r3
        L_0x008b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.securityCheck(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object securityCheck$default(LoginRepository loginRepository, String str, String str2, Integer num, String str3, Integer num2, Continuation continuation, int i, Object obj) {
        return loginRepository.securityCheck((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 14 : num, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? 1 : num2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0088, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setPassword(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Integer r21, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.SetPasswordData> r22) {
        /*
            r16 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$setPassword$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.tal.app.thinkacademy.business.login.config.LoginRepository$setPassword$1 r1 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$setPassword$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r16
            goto L_0x001f
        L_0x0018:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$setPassword$1 r1 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$setPassword$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0044
            if (r4 == r7) goto L_0x003c
            if (r4 != r5) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x008b
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007d
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.network.NetData r4 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r0 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r8 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0, r8)
            com.tal.app.thinkacademy.business.login.config.ApiService r0 = (com.tal.app.thinkacademy.business.login.config.ApiService) r0
            com.tal.app.thinkacademy.business.login.entity.post.ChangePassword r8 = new com.tal.app.thinkacademy.business.login.entity.post.ChangePassword
            com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordHeader r9 = new com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordHeader
            r9.<init>(r6, r7, r6)
            com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordData r15 = new com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordData
            r10 = r15
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r20
            r5 = r15
            r15 = r21
            r10.<init>(r11, r12, r13, r14, r15)
            r8.<init>(r9, r5)
            r1.L$0 = r4
            r1.label = r7
            java.lang.Object r0 = r0.setPassword(r8, r1)
            if (r0 != r3) goto L_0x007d
            return r3
        L_0x007d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r1.L$0 = r6
            r5 = 2
            r1.label = r5
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x008b
            return r3
        L_0x008b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.setPassword(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object setPassword$default(LoginRepository loginRepository, String str, String str2, String str3, String str4, Integer num, Continuation continuation, int i, Object obj) {
        return loginRepository.setPassword((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? 1 : num, continuation);
    }

    public static /* synthetic */ Object changePassword$default(LoginRepository loginRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return loginRepository.changePassword(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x008f, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object changePassword(java.lang.String r20, kotlin.coroutines.Continuation<java.lang.Object> r21) {
        /*
            r19 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$changePassword$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.tal.app.thinkacademy.business.login.config.LoginRepository$changePassword$1 r1 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$changePassword$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r19
            goto L_0x001f
        L_0x0018:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$changePassword$1 r1 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$changePassword$1
            r2 = r19
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0044
            if (r4 == r7) goto L_0x003c
            if (r4 != r5) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0092
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0084
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.network.NetData r4 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r0 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r8 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0, r8)
            com.tal.app.thinkacademy.business.login.config.ApiService r0 = (com.tal.app.thinkacademy.business.login.config.ApiService) r0
            com.tal.app.thinkacademy.business.login.entity.post.ChangePassword r8 = new com.tal.app.thinkacademy.business.login.entity.post.ChangePassword
            com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordHeader r9 = new com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordHeader
            r9.<init>(r6, r7, r6)
            com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordData r15 = new com.tal.app.thinkacademy.business.login.entity.post.ChangePasswordData
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 30
            r18 = 0
            r10 = r15
            r11 = r20
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r8.<init>(r9, r5)
            r1.L$0 = r4
            r1.label = r7
            java.lang.Object r0 = r0.changePassword(r8, r1)
            if (r0 != r3) goto L_0x0084
            return r3
        L_0x0084:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r1.L$0 = r6
            r5 = 2
            r1.label = r5
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x0092
            return r3
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.changePassword(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:18:0x006c, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object accountCheck(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.AccountCheckData> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$accountCheck$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.login.config.LoginRepository$accountCheck$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$accountCheck$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$accountCheck$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$accountCheck$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006f
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r9 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r9 = r9.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r9 = com.tal.app.thinkacademy.lib.network.Api.create(r9, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r9 = (com.tal.app.thinkacademy.business.login.config.ApiService) r9
            com.tal.app.thinkacademy.business.login.entity.post.AccountCheckRequest r6 = new com.tal.app.thinkacademy.business.login.entity.post.AccountCheckRequest
            r7 = 3
            r6.<init>(r5, r5, r7, r5)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r9.accountCheck(r6, r0)
            if (r9 != r1) goto L_0x0062
            return r1
        L_0x0062:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r9 = r2.transform(r9, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.accountCheck(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0066, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTimeZoneList(kotlin.coroutines.Continuation<? super java.lang.String[]> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getTimeZoneList$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getTimeZoneList$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getTimeZoneList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getTimeZoneList$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getTimeZoneList$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getTimeZoneList(r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getTimeZoneList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0066, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getBasicUserInfoOnly(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.UseGetInfo> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfoOnly$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfoOnly$1 r0 = (com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfoOnly$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfoOnly$1 r0 = new com.tal.app.thinkacademy.business.login.config.LoginRepository$getBasicUserInfoOnly$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005c
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r8 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r8 = r8.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r8 = com.tal.app.thinkacademy.lib.network.Api.create(r8, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r8 = (com.tal.app.thinkacademy.business.login.config.ApiService) r8
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r8 = com.tal.app.thinkacademy.business.login.config.ApiService.DefaultImpls.basicInfoUserGet$default(r8, r4, r0, r5, r4)
            if (r8 != r1) goto L_0x005c
            return r1
        L_0x005c:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r8 = r2.transform(r8, r0)
            if (r8 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.LoginRepository.getBasicUserInfoOnly(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
