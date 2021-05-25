package br.com.aweboard.features.domain.user.updateuser.usecases;

import br.com.aweboard.features.domain.user.entities.Teacher;
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
class UpdateTeacherUseCaseTest {

  private Teacher tTeacher;
  private IUserRepository iUserRepositoryMock;
  static UpdateTeacherUseCase updateTeacherUseCase;

  @BeforeEach
  void setUp(){
    makeTTeacher();

    iUserRepositoryMock = Mockito.mock(IUserRepository.class);
    updateTeacherUseCase = new UpdateTeacherUseCase(iUserRepositoryMock);
  }

  void makeTTeacher(){
    tTeacher = new Teacher("Gabriela Bandeira",
            "gabs.teacher",
            "password");

  }

  @Test
  @DisplayName("Updating Teacher successfully")
  public void testAddTeacher() throws UserDoesNotExistsException {
    when(iUserRepositoryMock.userExists(tTeacher)).thenReturn(true);
    updateTeacherUseCase.updateUser(tTeacher);

    verify(iUserRepositoryMock, times(1)).updateUser(tTeacher);
  }

  @Test
  @DisplayName("Updating a not existing teacher")
  public void testAddExistingTeacher() throws UserDoesNotExistsException {
    when(iUserRepositoryMock.userExists(tTeacher)).thenReturn(false);

    Assertions.assertThrows(UserDoesNotExistsException.class, () -> {
      updateTeacherUseCase.updateUser(tTeacher);
    });
  }
}