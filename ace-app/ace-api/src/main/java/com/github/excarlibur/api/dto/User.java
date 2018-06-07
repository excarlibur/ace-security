package com.github.excarlibur.api.dto;

/**
 * Created by chenxuewei on 2018/6/5.
 */
public class User {

  public User() {
  }

  public User(String username, Integer age) {
    this.username = username;
    this.age = age;
  }

  private String username;

  private Integer age;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
