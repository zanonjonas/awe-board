package br.com.aweboard.features.domain.user.repositories;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.features.domain.user.entities.Student;

public interface IUserRepository {
  void addUser(IUser user);

  boolean userExists(IUser user);

  void updateUser(IUser user);

  void deleteUser(IUser user);
}
