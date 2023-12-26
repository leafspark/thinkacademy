package com.tal.app.thinkacademy.common.base.model;

import java.io.Serializable;

public class ConfigInfo implements Serializable {
    private ConfigItem international;

    public ConfigItem getInternational() {
        return this.international;
    }

    public void setInternational(ConfigItem configItem) {
        this.international = configItem;
    }

    public class ConfigItem {
        private String countryCallingCode;
        private String countryName;
        private String phoneMaxLength;
        private String phoneMinLength;

        public ConfigItem() {
        }

        public String getCountryCallingCode() {
            return this.countryCallingCode;
        }

        public void setCountryCallingCode(String str) {
            this.countryCallingCode = str;
        }

        public String getPhoneMaxLength() {
            return this.phoneMaxLength;
        }

        public void setPhoneMaxLength(String str) {
            this.phoneMaxLength = str;
        }

        public String getPhoneMinLength() {
            return this.phoneMinLength;
        }

        public void setPhoneMinLength(String str) {
            this.phoneMinLength = str;
        }

        public String getCountryName() {
            return this.countryName;
        }

        public void setCountryName(String str) {
            this.countryName = str;
        }
    }
}
