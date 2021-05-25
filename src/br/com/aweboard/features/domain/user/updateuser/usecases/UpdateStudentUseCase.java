package br.com.aweboard.features.domain.user.updateuser.usecases;

import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public class UpdateStudentUseCase extends AbstractUpdateUserUseCase {

  public UpdateStudentUseCase(IUserRepository iUserRepository) {
   super(iUserRepository);
  }

}
