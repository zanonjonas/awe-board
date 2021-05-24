package br.com.aweboard.features.domain.adduser.usecases;

import br.com.aweboard.core.entities.IUser;
import br.com.aweboard.features.domain.adduser.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.adduser.entities.Student;
import br.com.aweboard.features.domain.adduser.repositories.IAddUserRepository;

public class AddStudentUseCase implements IAddUserUseCase{

  private Student student;
  private IAddUserRepository iAddUserRepository;

  public AddStudentUseCase(IAddUserRepository iAddUserRepository) {
   this.iAddUserRepository = iAddUserRepository;
  }

  @Override
  public void addUser(IUser user) throws UserAlreadyExistsException {
    student = (Student) user;

    if (iAddUserRepository.userExists(user)) throw new UserAlreadyExistsException();

      iAddUserRepository.addUser(user);

  }


}
