package br.com.aweboard.features.domain.user.entities;

import br.com.aweboard.core.entities.User;

public class Student extends User {
  public Student(String name, String login, String password) {
    super(name, login, password);
  }

  public Student(String uuid, String name, String login, String password) {
    super(uuid, name, login, password);
  }
}
