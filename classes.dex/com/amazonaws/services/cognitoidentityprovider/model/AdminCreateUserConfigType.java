package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class AdminCreateUserConfigType implements Serializable {
    private Boolean allowAdminCreateUserOnly;
    private MessageTemplateType inviteMessageTemplate;
    private Integer unusedAccountValidityDays;

    public Boolean isAllowAdminCreateUserOnly() {
        return this.allowAdminCreateUserOnly;
    }

    public Boolean getAllowAdminCreateUserOnly() {
        return this.allowAdminCreateUserOnly;
    }

    public void setAllowAdminCreateUserOnly(Boolean bool) {
        this.allowAdminCreateUserOnly = bool;
    }

    public AdminCreateUserConfigType withAllowAdminCreateUserOnly(Boolean bool) {
        this.allowAdminCreateUserOnly = bool;
        return this;
    }

    public Integer getUnusedAccountValidityDays() {
        return this.unusedAccountValidityDays;
    }

    public void setUnusedAccountValidityDays(Integer num) {
        this.unusedAccountValidityDays = num;
    }

    public AdminCreateUserConfigType withUnusedAccountValidityDays(Integer num) {
        this.unusedAccountValidityDays = num;
        return this;
    }

    public MessageTemplateType getInviteMessageTemplate() {
        return this.inviteMessageTemplate;
    }

    public void setInviteMessageTemplate(MessageTemplateType messageTemplateType) {
        this.inviteMessageTemplate = messageTemplateType;
    }

    public AdminCreateUserConfigType withInviteMessageTemplate(MessageTemplateType messageTemplateType) {
        this.inviteMessageTemplate = messageTemplateType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAllowAdminCreateUserOnly() != null) {
            sb.append("AllowAdminCreateUserOnly: " + getAllowAdminCreateUserOnly() + ",");
        }
        if (getUnusedAccountValidityDays() != null) {
            sb.append("UnusedAccountValidityDays: " + getUnusedAccountValidityDays() + ",");
        }
        if (getInviteMessageTemplate() != null) {
            sb.append("InviteMessageTemplate: " + getInviteMessageTemplate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        if (getAllowAdminCreateUserOnly() == null) {
            i = 0;
        } else {
            i = getAllowAdminCreateUserOnly().hashCode();
        }
        int i4 = (i + 31) * 31;
        if (getUnusedAccountValidityDays() == null) {
            i2 = 0;
        } else {
            i2 = getUnusedAccountValidityDays().hashCode();
        }
        int i5 = (i4 + i2) * 31;
        if (getInviteMessageTemplate() != null) {
            i3 = getInviteMessageTemplate().hashCode();
        }
        return i5 + i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminCreateUserConfigType)) {
            return false;
        }
        AdminCreateUserConfigType adminCreateUserConfigType = (AdminCreateUserConfigType) obj;
        if ((adminCreateUserConfigType.getAllowAdminCreateUserOnly() == null) ^ (getAllowAdminCreateUserOnly() == null)) {
            return false;
        }
        if (adminCreateUserConfigType.getAllowAdminCreateUserOnly() != null && !adminCreateUserConfigType.getAllowAdminCreateUserOnly().equals(getAllowAdminCreateUserOnly())) {
            return false;
        }
        if ((adminCreateUserConfigType.getUnusedAccountValidityDays() == null) ^ (getUnusedAccountValidityDays() == null)) {
            return false;
        }
        if (adminCreateUserConfigType.getUnusedAccountValidityDays() != null && !adminCreateUserConfigType.getUnusedAccountValidityDays().equals(getUnusedAccountValidityDays())) {
            return false;
        }
        if ((adminCreateUserConfigType.getInviteMessageTemplate() == null) ^ (getInviteMessageTemplate() == null)) {
            return false;
        }
        return adminCreateUserConfigType.getInviteMessageTemplate() == null || adminCreateUserConfigType.getInviteMessageTemplate().equals(getInviteMessageTemplate());
    }
}
