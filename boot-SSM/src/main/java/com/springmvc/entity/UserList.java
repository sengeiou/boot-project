package com.springmvc.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserList {
    @Getter
    @Setter
   private Integer uId;
    @Getter
    @Setter
    private String uUsername;
    @Getter
    @Setter
    private String uName;
    @Getter
    @Setter
    private String uPassword;
    @Getter
    @Setter
    private String uPhonenumber;
    @Getter
    @Setter
    private String uSex;
    @Getter
    @Setter
    private String uAge;
}