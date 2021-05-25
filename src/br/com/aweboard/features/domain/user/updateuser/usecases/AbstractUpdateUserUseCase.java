package br.com.aweboard.features.domain.user.updateuser.usecases;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.features.domain.user.repositories.IUserRepository;
import br.com.aweboard.features.domain.user.exceptions.UserDoesNotExistsException;

public abstract class AbstractUpdateUserUseCase {

  private IUserRepository iUserRepository;

  public AbstractUpdateUserUseCase(IUserRepository iUserRepository) {
    this.iUserRepository = iUserRepository;
  }

  public void updateUser(IUser user) throws UserDoesNotExistsException {
    if (!iUserRepository.userExists(user)) {
      throw new UserDoesNotExistsException();
    }

    iUserRepository.updateUser(user);
  }
}
