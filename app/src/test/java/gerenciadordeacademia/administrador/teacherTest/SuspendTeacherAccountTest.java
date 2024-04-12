package gerenciadordeacademia.administrador.teacherTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.UserAlreadySuspendException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.service.TeacherService;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;
import gerenciadordeacademia.administrador.teacherManager.TeacherRepository;

class SuspendTeacherAccountTest {
    private TeacherManager teacherManager = TeacherManager.getInstance(new TeacherRepository());
    private TeacherService service = new TeacherService(teacherManager);

    @Test
    void suspendTeacherAccountTest() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_one");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewTeacher(name, userName, password, status);
            //Verificando se a conta foi suspendida
            assertEquals(true, service.suspendTeacherAccount(userName));
        });
    }

    @Test
    void suspendTeacherAccountUserAlreadySuspend() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_two");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewTeacher(name, userName, password, status);
            //Exceção para a conta JÁ SUSPENDIDA
            assertThrows(UserAlreadySuspendException.class, () -> service.suspendTeacherAccount(userName));
        });
    }

    @Test
    void suspendTeacherAccountUserNotFoundException() {
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
