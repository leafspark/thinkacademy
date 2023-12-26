package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class FileInstructionResultBean extends InstructionResultBean {
    @SerializedName("fp")
    private String filePath;

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String toString() {
        return "FileInstructionResultBean{filePath='" + this.filePath + '\'' + '}';
    }
}
