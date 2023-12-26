package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.common.gson.annotations.SerializedName;

public class InstructionEventBean extends BaseEventInfo {
    @SerializedName("ir")
    private InstructionResultBean instructionResult;
    @SerializedName("sta")
    private int status;
    @SerializedName("tki")
    private String taskID;
    @SerializedName("t")
    private int type;

    public String getTaskID() {
        return this.taskID;
    }

    public void setTaskID(String str) {
        this.taskID = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public InstructionResultBean getInstructionResult() {
        return this.instructionResult;
    }

    public void setInstructionResult(InstructionResultBean instructionResultBean) {
        this.instructionResult = instructionResultBean;
    }

    public String toString() {
        return "InstructionEventBean{taskID='" + this.taskID + '\'' + ", status=" + this.status + ", type=" + this.type + ", instructionResult=" + this.instructionResult + '}';
    }
}
