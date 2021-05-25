package br.com.aweboard.features.domain.user.deleteuser.usecases;

import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public class DeleteTeacherUseCase extends AbstractDeleteUserUseCase {

  public DeleteTeacherUseCase(IUserRepository iUserRepository) {
   super(iUserRepository);
  }

}
