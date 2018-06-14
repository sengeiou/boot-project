package com.xzm.modules.tyb.vo;

import lombok.Data;

@Data
public class TybUserInfoVo {
    public UserInfo userInfo;
    @Data
    public static  class   UserInfo{
        private String nickName;
        private String phone;
        private String phoneUrl;
        private Integer pushStatus;
    }

}
