package gerenciadordeacademia.administrador.studentTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.UserAlreadyActiveException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.service.StudentService;
import gerenciadordeacademia.administrador.studentManager.StudentManager;
import gerenciadordeacademia.administrador.studentManager.StudentRepository;


class ActivateStudentAccountTest {
    private StudentManager studentManager = StudentManager.getInstance(new StudentRepository());
    private StudentService service = new StudentService(studentManager);

    @Test
    void activateStudentAccountTest() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_one");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewStudent(name, userName, password, status);
            //Verificando se a conta foi suspendida
            assertEquals(true, service.activateStudentAccount(userName));
        });
    }

    @Test
    void activateStudentAccountUserAlreadyActive() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_two");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewStudent(name, userName, password, status);
            //Exceção para a conta JÁ ATIVA
            assertThrows(UserAlreadyActiveException.class, () -> service.activateStudentAccount(userName));
        });
    }

    @Test
    void activateStudentAccountUserNotFoundException() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_three");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewStudent(name, userName, password, status);
            //Exceção para a conta NÃO ENCONTRADA
            Username randomUserName = new Username("fulano");
            assertThrows(UserNotFoundException.class, () -> service.suspendStudentAccount(randomUserName));
        });
    }
}
