package br.com.aweboard.features.domain.user.deleteuser.usecases;

import br.com.aweboard.features.domain.user.repositories.IUserRepository;

public class DeleteStudentUseCase extends AbstractDeleteUserUseCase {

  public DeleteStudentUseCase(IUserRepository iUserRepository) {
   super(iUserRepository);
  }

}
