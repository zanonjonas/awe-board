package br.com.aweboard.features.domain.adduser.usecases;

import br.com.aweboard.features.domain.adduser.entities.Teacher;
import br.com.aweboard.features.domain.adduser.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.adduser.entities.Student;
import br.com.aweboard.features.domain.adduser.repositories.IAddUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class AddTeacherUseCaseTest {

  private Teacher tTeacher;
  private IAddUserRepository iAddUserRepositoryMock;
  private AddTeacherUseCase addTeacherUseCase;

  @BeforeEach
  void setUp(){
    makeTStudent();

    iAddUserRepositoryMock = Mockito.mock(IAddUserRepository.class);
    addTeacherUseCase = new AddTeacherUseCase(iAddUserRepositoryMock);
  }

  void makeTStudent(){
    tTeacher = new Teacher("Gabriela Prof",
            "gabs.teacher",
            "password");

  }

  @Test
  @DisplayName("Adding Teacher successfully")
  public void testAddTeacher() throws UserAlreadyExistsException {
    addTeacherUseCase.addUser(tTeacher);

    verify(iAddUserRepositoryMock, times(1)).addUser(tTeacher);
  }

  @Test
  @DisplayName("Adding an existing teacher")
  public void testAddExistingTeacher() throws UserAlreadyExistsException {
    when(iAddUserRepositoryMock.userExists(tTeacher)).thenReturn(true);

    Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
      addTeacherUseCase.addUser(tTeacher);
    });
  }
}