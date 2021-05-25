package br.com.aweboard.features.domain.user.adduser.usecases;

import br.com.aweboard.features.domain.user.entities.Teacher;
import br.com.aweboard.features.domain.user.exceptions.UserAlreadyExistsException;
import br.com.aweboard.features.domain.user.repositories.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class AddTeacherUseCaseTest {

  private Teacher tTeacher;
  private IUserRepository iUserRepositoryMock;
  private AddTeacherUseCase addTeacherUseCase;

  @BeforeEach
  void setUp(){
    makeTStudent();

    iUserRepositoryMock = Mockito.mock(IUserRepository.class);
    addTeacherUseCase = new AddTeacherUseCase(iUserRepositoryMock);
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

    verify(iUserRepositoryMock, times(1)).addUser(tTeacher);
  }

  @Test
  @DisplayName("Adding an existing teacher")
  public void testAddExistingTeacher() throws UserAlreadyExistsException {
    when(iUserRepositoryMock.userExists(tTeacher)).thenReturn(true);

    Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
      addTeacherUseCase.addUser(tTeacher);
    });
  }
}