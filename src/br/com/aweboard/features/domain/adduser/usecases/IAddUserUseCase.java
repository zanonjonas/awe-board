package br.com.aweboard.features.domain.adduser.usecases;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.features.domain.adduser.exceptions.UserAlreadyExistsException;

public interface IAddUserUseCase {
  public void addUser(IUser user) throws UserAlreadyExistsException;
}
