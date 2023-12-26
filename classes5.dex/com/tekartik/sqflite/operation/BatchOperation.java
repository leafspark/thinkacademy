package com.tekartik.sqflite.operation;

import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchOperation extends BaseOperation {
    final Map<String, Object> map;
    final boolean noResult;
    final BatchOperationResult operationResult = new BatchOperationResult();

    public BatchOperation(Map<String, Object> map2, boolean z) {
        this.map = map2;
        this.noResult = z;
    }

    public String getMethod() {
        return (String) this.map.get(Constant.PARAM_METHOD);
    }

    public <T> T getArgument(String str) {
        return this.map.get(str);
    }

    public boolean hasArgument(String str) {
        return this.map.containsKey(str);
    }

    public OperationResult getOperationResult() {
        return this.operationResult;
    }

    public Map<String, Object> getOperationSuccessResult() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constant.PARAM_RESULT, this.operationResult.result);
        return hashMap;
    }

    public Map<String, Object> getOperationError() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Constant.PARAM_ERROR_CODE, this.operationResult.errorCode);
        hashMap2.put(Constant.PARAM_ERROR_MESSAGE, this.operationResult.errorMessage);
        hashMap2.put(Constant.PARAM_ERROR_DATA, this.operationResult.errorData);
        hashMap.put(Constant.PARAM_ERROR, hashMap2);
        return hashMap;
    }

    public void handleError(MethodChannel.Result result) {
        result.error(this.operationResult.errorCode, this.operationResult.errorMessage, this.operationResult.errorData);
    }

    public boolean getNoResult() {
        return this.noResult;
    }

    public void handleSuccess(List<Map<String, Object>> list) {
        if (!getNoResult()) {
            list.add(getOperationSuccessResult());
        }
    }

    public void handleErrorContinue(List<Map<String, Object>> list) {
        if (!getNoResult()) {
            list.add(getOperationError());
        }
    }

    public class BatchOperationResult implements OperationResult {
        String errorCode;
        Object errorData;
        String errorMessage;
        Object result;

        public BatchOperationResult() {
        }

        public void success(Object obj) {
            this.result = obj;
        }

        public void error(String str, String str2, Object obj) {
            this.errorCode = str;
            this.errorMessage = str2;
            this.errorData = obj;
        }
    }
}
