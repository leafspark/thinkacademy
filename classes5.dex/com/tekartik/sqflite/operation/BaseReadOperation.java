package com.tekartik.sqflite.operation;

import com.tekartik.sqflite.Constant;
import com.tekartik.sqflite.SqlCommand;
import java.util.List;

public abstract class BaseReadOperation implements Operation {
    /* access modifiers changed from: protected */
    public abstract OperationResult getOperationResult();

    private String getSql() {
        return (String) getArgument(Constant.PARAM_SQL);
    }

    private List<Object> getSqlArguments() {
        return (List) getArgument(Constant.PARAM_SQL_ARGUMENTS);
    }

    public Integer getTransactionId() {
        return (Integer) getArgument(Constant.PARAM_TRANSACTION_ID);
    }

    public boolean hasNullTransactionId() {
        return hasArgument(Constant.PARAM_TRANSACTION_ID) && getTransactionId() == null;
    }

    public SqlCommand getSqlCommand() {
        return new SqlCommand(getSql(), getSqlArguments());
    }

    public Boolean getInTransactionChange() {
        return getBoolean(Constant.PARAM_IN_TRANSACTION_CHANGE);
    }

    public boolean getNoResult() {
        return Boolean.TRUE.equals(getArgument(Constant.PARAM_NO_RESULT));
    }

    public boolean getContinueOnError() {
        return Boolean.TRUE.equals(getArgument(Constant.PARAM_CONTINUE_OR_ERROR));
    }

    private Boolean getBoolean(String str) {
        Object argument = getArgument(str);
        if (argument instanceof Boolean) {
            return (Boolean) argument;
        }
        return null;
    }

    public String toString() {
        return "" + getMethod() + " " + getSql() + " " + getSqlArguments();
    }
}
