package br.com.aweboard.features.domain.user.adduser.usecases;

import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public class AddTeacherUseCase extends AbstractAddUserUseCase {

  public AddTeacherUseCase(IUserRepository iUserRepository) {
   super(iUserRepository);
  }

}
