package br.com.aweboard.features.domain.adduser.usecases;

import br.com.aweboard.features.domain.adduser.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.adduser.entities.Student;
import br.com.aweboard.features.domain.adduser.repositories.IAddUserRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AddStudentUseCaseTest {

  private Student tStudent;
  private IAddUserRepository iAddUserRepositoryMock;
  static AddStudentUseCase addStudentUseCase;

  @BeforeEach
  void setUp(){
    makeTStudent();

    iAddUserRepositoryMock = Mockito.mock(IAddUserRepository.class);
    addStudentUseCase = new AddStudentUseCase(iAddUserRepositoryMock);
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

    verify(iAddUserRepositoryMock, times(1)).addUser(tStudent);
  }

  @Test
  @DisplayName("Adding an existing student")
  public void testAddExistingStudent() throws UserAlreadyExistsException {
    when(iAddUserRepositoryMock.userExists(tStudent)).thenReturn(true);

    Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
      addStudentUseCase.addUser(tStudent);
    });
  }





}