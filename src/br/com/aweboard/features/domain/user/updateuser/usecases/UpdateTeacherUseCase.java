package br.com.aweboard.features.domain.user.updateuser.usecases;

import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public class UpdateTeacherUseCase extends AbstractUpdateUserUseCase {

  public UpdateTeacherUseCase(IUserRepository iUserRepository) {
   super(iUserRepository);
  }

}
