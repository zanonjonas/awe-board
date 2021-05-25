package br.com.aweboard.core.entities;

public abstract class User implements IUser {
  String uuid;
  String name;
  String login;
  String password;

  public User(String uuid, String name, String login, String password) {
    this.uuid = uuid;
    this.name = name;
    this.login = login;
    this.password = password;
  }

  public User(String name, String login, String password) {
    this.name = name;
    this.login = login;
    this.password = password;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


}
