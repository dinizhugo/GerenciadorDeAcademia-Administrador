package gerenciadordeacademia.administrador.studentTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.EmptyListException;
import gerenciadordeacademia.administrador.service.StudentService;
import gerenciadordeacademia.administrador.studentManager.StudentManager;
import gerenciadordeacademia.administrador.studentManager.StudentRepository;

class ShowAllStudentsAccountTest {
    private StudentManager studentManager = StudentManager.getInstance(new StudentRepository());
    private StudentService service = new StudentService(studentManager);

    @Test
    void showAllStudentsAccountTest() {
        assertDoesNotThrow(() -> {
            service.createNewStudent(new Name("Breno"), new Username("breno_professor"), new Password("321"), new UserStatus(true));
            service.createNewStudent(new Name("Pedro"), new Username("pedro_professor"), new Password("321"), new UserStatus(true));
            service.createNewStudent(new Name("Daiane"), new Username("daiane_professor"), new Password("321"), new UserStatus(true));
            List<Aluno> alunos = studentManager.showAllStudents();
            assertEquals(alunos, service.showAllStudentsAccount());
        });

    }

    @Test
    void showAllStudentsAccountEmptyListException() {
        assertThrows(EmptyListException.class, () -> service.showAllStudentsAccount());
    }
}
