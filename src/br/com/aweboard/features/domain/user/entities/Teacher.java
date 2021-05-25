package br.com.aweboard.features.domain.user.entities;

import br.com.aweboard.core.entities.User;

public class Teacher extends User {
  public Teacher(String name, String login, String password) {
    super(name, login, password);
  }

  public Teacher(String uuid, String name, String login, String password) {
    super(uuid, name, login, password);
  }
}
