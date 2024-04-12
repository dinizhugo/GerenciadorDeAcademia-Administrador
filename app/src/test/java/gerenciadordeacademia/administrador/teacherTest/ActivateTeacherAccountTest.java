package gerenciadordeacademia.administrador.teacherTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.UserAlreadyActiveException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.service.TeacherService;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;
import gerenciadordeacademia.administrador.teacherManager.TeacherRepository;

class ActivateTeacherAccountTest {
    private TeacherManager teacherManager = TeacherManager.getInstance(new TeacherRepository());
    private TeacherService service = new TeacherService(teacherManager);

    @Test
    void activateTeacherAccountTest() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_one");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewTeacher(name, userName, password, status);
            //Verificando se a conta foi suspendida
            assertEquals(true, service.activateTeacherAccount(userName));
        });
    }

    @Test
    void activateTeacherAccountUserAlreadyActive() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_two");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewTeacher(name, userName, password, status);
            //Exceção para a conta JÁ ATIVA
            assertThrows(UserAlreadyActiveException.class, () -> service.activateTeacherAccount(userName));
        });
    }

    @Test
    void activateTeacherAccountUserNotFoundException() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_three");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewTeacher(name, userName, password, status);
            //Exceção para a conta NÃO ENCONTRADA
            Username randomUserName = new Username("fulano");
            assertThrows(UserNotFoundException.class, () -> service.suspendTeacherAccount(randomUserName));
        });
    }
}
