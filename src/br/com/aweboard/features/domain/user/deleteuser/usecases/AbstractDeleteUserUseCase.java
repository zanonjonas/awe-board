package br.com.aweboard.features.domain.user.deleteuser.usecases;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.features.domain.user.exceptions.UserDoesNotExistsException;
import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public abstract class AbstractDeleteUserUseCase {

  private IUserRepository iUserRepository;

  public AbstractDeleteUserUseCase(IUserRepository iUserRepository) {
    this.iUserRepository = iUserRepository;
  }

  public void deleteUser(IUser user) throws UserDoesNotExistsException {
    if (!iUserRepository.userExists(user)) {
      throw new UserDoesNotExistsException();
    }

    iUserRepository.deleteUser(user);
  }
}
