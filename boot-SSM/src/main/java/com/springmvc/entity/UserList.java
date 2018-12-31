package com.springmvc.entity;


public class UserList {
 public UserList(Integer uId, String uUsername, String uName, String uPassword, String uPhonenumber, String uSex, String uAge) {
  this.uId = uId;
  this.uUsername = uUsername;
  this.uName = uName;
  this.uPassword = uPassword;
  this.uPhonenumber = uPhonenumber;
  this.uSex = uSex;
  this.uAge = uAge;
 }

 public Integer getuId() {
  return uId;
 }

 public void setuId(Integer uId) {
  this.uId = uId;
 }

 public String getuUsername() {
  return uUsername;
 }

 public void setuUsername(String uUsername) {
  this.uUsername = uUsername;
 }

 public String getuName() {
  return uName;
 }

 public void setuName(String uName) {
  this.uName = uName;
 }

 public String getuPassword() {
  return uPassword;
 }

 public void setuPassword(String uPassword) {
  this.uPassword = uPassword;
 }

 public String getuPhonenumber() {
  return uPhonenumber;
 }

 public void setuPhonenumber(String uPhonenumber) {
  this.uPhonenumber = uPhonenumber;
 }

 public String getuSex() {
  return uSex;
 }

 public void setuSex(String uSex) {
  this.uSex = uSex;
 }

 public String getuAge() {
  return uAge;
 }

 public void setuAge(String uAge) {
  this.uAge = uAge;
 }

 private Integer uId;

    private String uUsername;

    private String uName;

    private String uPassword;

    private String uPhonenumber;

    private String uSex;

    private String uAge;


}