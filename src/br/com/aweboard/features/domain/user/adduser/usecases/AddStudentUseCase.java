package br.com.aweboard.features.domain.user.adduser.usecases;

import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public class AddStudentUseCase extends AbstractAddUserUseCase {

  public AddStudentUseCase(IUserRepository iUserRepository) {
    super(iUserRepository);
  }

}
