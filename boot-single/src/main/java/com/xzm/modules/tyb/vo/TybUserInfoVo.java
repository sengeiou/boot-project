package com.xzm.modules.tyb.vo;

public class TybUserInfoVo {
    public UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    //    @Data
    public static  class   UserInfo{
        private String nickName;
        private String phone;
        private String phoneUrl;
        private Integer pushStatus;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoneUrl() {
            return phoneUrl;
        }

        public void setPhoneUrl(String phoneUrl) {
            this.phoneUrl = phoneUrl;
        }

        public Integer getPushStatus() {
            return pushStatus;
        }

        public void setPushStatus(Integer pushStatus) {
            this.pushStatus = pushStatus;
        }
    }

}
