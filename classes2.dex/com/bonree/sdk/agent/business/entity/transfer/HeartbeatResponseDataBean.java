package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.agent.business.entity.instruction.InstructionContentBean;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class HeartbeatResponseDataBean {
    @SerializedName("s")
    private String session;
    @SerializedName("sta")
    private int status;
    @SerializedName("tl")
    private transient List<TaskConfiguration<?>> taskList;
    @SerializedName("tid")
    private String trackID;

    public enum ResponseStatus {
        DEFAULT,
        REQUEST,
        TASK,
        SHUTDOWN,
        ERROR
    }

    public static class TaskConfiguration<T extends InstructionContentBean> {
        @SerializedName("tc")
        public T instructionContentBean;
        @SerializedName("tki")
        public String taskID;
        @SerializedName("t")
        public int type;

        public enum OrderType {
            NETWORK,
            PING,
            GET_LOG
        }

        public String getTaskID() {
            return this.taskID;
        }

        public void setTaskID(String str) {
            this.taskID = str;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public T getInstructionContentBean() {
            return this.instructionContentBean;
        }

        public void setInstructionContentBean(T t) {
            this.instructionContentBean = t;
        }

        public String toString() {
            return "TaskConfiguration{taskID='" + this.taskID + '\'' + ", type=" + this.type + ", instructionContentBean=" + this.instructionContentBean + '}';
        }
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getTrackID() {
        return this.trackID;
    }

    public void setTrackID(String str) {
        this.trackID = str;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public List<TaskConfiguration<?>> getTaskList() {
        return this.taskList;
    }

    public void setTaskList(List<TaskConfiguration<?>> list) {
        this.taskList = list;
    }

    public String toString() {
        return "HeartbeatResponseBean{status=" + this.status + ", trackID='" + this.trackID + '\'' + ", session='" + this.session + '\'' + ", taskList=" + this.taskList + '}';
    }
}
