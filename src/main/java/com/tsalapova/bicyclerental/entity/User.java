package com.tsalapova.bicyclerental.entity;

import java.util.Objects;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class User implements Entity {

  private long id;
  private String login;
  private String password;
  private String salt;
  private String role;

  public User(long id, String login, String password, String salt, String role) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.salt = salt;
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return id == user.id &&
            Objects.equals(login, user.login) &&
            Objects.equals(password, user.password) &&
            Objects.equals(salt, user.salt) &&
            Objects.equals(role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password, salt, role);
  }
}
