package com.tekartik.sqflite.operation;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MethodCallOperation extends BaseOperation {
    final MethodCall methodCall;
    public final Result result;

    public MethodCallOperation(MethodCall methodCall2, MethodChannel.Result result2) {
        this.methodCall = methodCall2;
        this.result = new Result(result2);
    }

    public String getMethod() {
        return this.methodCall.method;
    }

    public <T> T getArgument(String str) {
        return this.methodCall.argument(str);
    }

    public boolean hasArgument(String str) {
        return this.methodCall.hasArgument(str);
    }

    public OperationResult getOperationResult() {
        return this.result;
    }

    class Result implements OperationResult {
        final MethodChannel.Result result;

        Result(MethodChannel.Result result2) {
            this.result = result2;
        }

        public void success(Object obj) {
            this.result.success(obj);
        }

        public void error(String str, String str2, Object obj) {
            this.result.error(str, str2, obj);
        }
    }
}
