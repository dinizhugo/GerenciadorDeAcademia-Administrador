package gerenciadordeacademia.administrador.studentTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.IncorrectTermException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.service.StudentService;
import gerenciadordeacademia.administrador.studentManager.StudentManager;
import gerenciadordeacademia.administrador.studentManager.StudentRepository;

class SearchStudentTest {
    private StudentManager studentManager = StudentManager.getInstance(new StudentRepository());
    private StudentService service = new StudentService(studentManager);
    
    @Test
    void searchStudentTest() {
        assertDoesNotThrow(() -> {
        Name name = new Name("testando");
        Username userName = new Username("tester_one");
        Password password = new Password("321");
        UserStatus status = new UserStatus(true);
        service.createNewStudent(name, userName, password, status);
        Aluno aluno = studentManager.getAluno(userName);
        assertEquals(aluno, service.searchStudentAccount("tester_one"));
        });
    }

    @Test
    void searchStudentUserNotFoundException() {
        assertDoesNotThrow(() -> {
            Name name = new Name("testando");
            Username userName = new Username("tester_two");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewStudent(name, userName, password, status);
        });
        String randomName = "fulano";
        assertThrows(UserNotFoundException.class, () -> service.searchStudentAccount(randomName));
    }

    @Test
    void searchStudentIncorrectTermException() {
        assertDoesNotThrow(() -> {
            Name name = new Name("testando");
            Username userName = new Username("tester_three");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewStudent(name, userName, password, status);
        });
        String key = "";
        assertThrows(IncorrectTermException.class, () -> service.searchStudentAccount(key));
    }
}
