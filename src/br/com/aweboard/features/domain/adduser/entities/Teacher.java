package br.com.aweboard.features.domain.adduser.entities;

import br.com.aweboard.core.entities.User;

public class Teacher extends User {
  public Teacher(String name, String login, String password) {
    super(name, login, password);
  }
}
