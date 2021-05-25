package br.com.aweboard.features.domain.user.adduser.usecases;

import br.com.aweboard.features.domain.user.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.user.entities.Student;
import br.com.aweboard.features.domain.user.repositories.IUserRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AddStudentUseCaseTest {

  private Student tStudent;
  private IUserRepository iUserRepositoryMock;
  static AddStudentUseCase addStudentUseCase;

  @BeforeEach
  void setUp(){
    makeTStudent();

    iUserRepositoryMock = Mockito.mock(IUserRepository.class);
    addStudentUseCase = new AddStudentUseCase(iUserRepositoryMock);
  }

  void makeTStudent(){
    tStudent = new Student("Gabriela Bandeira",
            "gabs.student",
            "password");

  }

  @Test
  @DisplayName("Adding Student successfully")
  public void testAddStudent() throws UserAlreadyExistsException{
    addStudentUseCase.addUser(tStudent);

    verify(iUserRepositoryMock, times(1)).addUser(tStudent);
  }

  @Test
  @DisplayName("Adding an existing student")
  public void testAddExistingStudent() {
    when(iUserRepositoryMock.userExists(tStudent)).thenReturn(true);

    Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
      addStudentUseCase.addUser(tStudent);
    });
  }
}