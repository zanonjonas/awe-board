package br.com.aweboard.features.domain.adduser.repositories;

import br.com.aweboard.core.entities.IUser;

public interface IAddUserRepository {
  void addUser(IUser user);

  boolean userExists(IUser user);
}
