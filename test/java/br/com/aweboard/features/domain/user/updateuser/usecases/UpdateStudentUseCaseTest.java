package br.com.aweboard.features.domain.user.updateuser.usecases;

import br.com.aweboard.features.domain.user.entities.Student;
import br.com.aweboard.features.domain.user.repositories.IUserRepository;
import br.com.aweboard.features.domain.user.exceptions.UserDoesNotExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UpdateStudentUseCaseTest {

  private Student tStudent;
  private IUserRepository iUserRepositoryMock;
  static UpdateStudentUseCase updateStudentUseCase;

  @BeforeEach
  void setUp(){
    makeTStudent();

    iUserRepositoryMock = Mockito.mock(IUserRepository.class);
    updateStudentUseCase = new UpdateStudentUseCase(iUserRepositoryMock);
  }

  void makeTStudent(){
    tStudent = new Student("Gabriela Bandeira",
            "gabs.student",
            "password");

  }

  @Test
  @DisplayName("Updating Student successfully")
  public void testAddStudent() throws UserDoesNotExistsException {
    when(iUserRepositoryMock.userExists(tStudent)).thenReturn(true);
    updateStudentUseCase.updateUser(tStudent);

    verify(iUserRepositoryMock, times(1)).updateUser(tStudent);
  }

  @Test
  @DisplayName("Updating a not existing student")
  public void testAddExistingStudent() throws UserDoesNotExistsException {
    when(iUserRepositoryMock.userExists(tStudent)).thenReturn(false);

    Assertions.assertThrows(UserDoesNotExistsException.class, () -> {
      updateStudentUseCase.updateUser(tStudent);
    });
  }
}