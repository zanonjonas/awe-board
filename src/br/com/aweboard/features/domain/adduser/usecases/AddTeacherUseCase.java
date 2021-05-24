package br.com.aweboard.features.domain.adduser.usecases;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.features.domain.adduser.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.adduser.entities.Teacher;
import br.com.aweboard.features.domain.adduser.repositories.IAddUserRepository;

public class AddTeacherUseCase implements IAddUserUseCase{

  private Teacher teacher;
  private IAddUserRepository iAddUserRepository;

  public AddTeacherUseCase(IAddUserRepository iAddUserRepository) {
   this.iAddUserRepository = iAddUserRepository;
  }

  @Override
  public void addUser(IUser user) throws UserAlreadyExistsException {
    if (iAddUserRepository.userExists(user)) throw new UserAlreadyExistsException();

    iAddUserRepository.addUser(user);

  }
}
