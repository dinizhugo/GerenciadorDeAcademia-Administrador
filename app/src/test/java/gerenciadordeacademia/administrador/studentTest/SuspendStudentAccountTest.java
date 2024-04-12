package gerenciadordeacademia.administrador.studentTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.UserAlreadySuspendException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.service.StudentService;
import gerenciadordeacademia.administrador.studentManager.StudentManager;
import gerenciadordeacademia.administrador.studentManager.StudentRepository;


class SuspendStudentAccountTest {
    private StudentManager studentManager = StudentManager.getInstance(new StudentRepository());
    private StudentService service = new StudentService(studentManager);

    @Test
    void suspendStudentAccountTest() {
        assertDoesNotThrow(() -> {
            Name name = new Name("testando");
            Username userName = new Username("tester_one");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewStudent(name, userName, password, status);
            assertEquals(true, service.suspendStudentAccount(userName));
        });
    }

    @Test
    void suspendStudentAccountUserAlreadySuspend() {
        assertDoesNotThrow(() -> {
            Name name = new Name("testando");
            Username userName = new Username("tester_two");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewStudent(name, userName, password, status);
            assertThrows(UserAlreadySuspendException.class, () -> service.suspendStudentAccount(userName));
        });
    }

    @Test
    void suspendStudentAccountUserNotFoundException() {
        assertDoesNotThrow(() -> {
            Name name = new Name("testando");
            Username userName = new Username("tester_three");
            Password password = new Password("321");
            UserStatus status = new UserStatus(false);
            service.createNewStudent(name, userName, password, status);
            Username randomUserName = new Username("fulano");
            assertThrows(UserNotFoundException.class, () -> service.suspendStudentAccount(randomUserName));
        });
    }
}
