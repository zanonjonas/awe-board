package br.com.aweboard.features.domain.user.adduser.usecases;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.core.entities.User;
import br.com.aweboard.features.domain.user.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.user.repositories.IUserRepository;

import java.util.UUID;

public abstract class AbstractAddUserUseCase {

  private User user;
  private IUserRepository iUserRepository;

  public AbstractAddUserUseCase(IUserRepository iUserRepository) {
    this.iUserRepository = iUserRepository;
  }

  public void addUser(IUser user) throws UserAlreadyExistsException {
    this.user = (User) user;
    this.user.setUuid(UUID.randomUUID().toString());

    if (iUserRepository.userExists(user)) throw new UserAlreadyExistsException();

    iUserRepository.addUser(user);
  };
}
