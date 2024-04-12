package gerenciadordeacademia.administrador.teacherTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.EmptyListException;
import gerenciadordeacademia.administrador.service.TeacherService;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;
import gerenciadordeacademia.administrador.teacherManager.TeacherRepository;

class ShowAllTeachersAccountTest {
    private TeacherManager teacherManager = TeacherManager.getInstance(new TeacherRepository());
    private TeacherService service = new TeacherService(teacherManager);

    @Test
    void showAllTeachersAccountTest() {
        assertDoesNotThrow(() -> {
            service.createNewTeacher(new Name("Breno"), new Username("breno_professor"), new Password("321"), new UserStatus(true));
            service.createNewTeacher(new Name("Pedro"), new Username("pedro_professor"), new Password("321"), new UserStatus(true));
            service.createNewTeacher(new Name("Daiane"), new Username("daiane_professor"), new Password("321"), new UserStatus(true));
            List<Professor> professores = teacherManager.showAllTeachers();
            assertEquals(professores, service.showAllTeachersAccount());
        });

    }

    @Test
    void showAllTeachersAccountEmptyListException() {
        assertThrows(EmptyListException.class, () -> service.showAllTeachersAccount());
    }
}
