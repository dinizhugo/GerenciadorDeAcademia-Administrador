package gerenciadordeacademia.administrador.teacherTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.exceptions.IncorrectTermException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.service.TeacherService;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;
import gerenciadordeacademia.administrador.teacherManager.TeacherRepository;

class SearchTeacherTest {
    private TeacherManager teacherManager = TeacherManager.getInstance(new TeacherRepository());
    private TeacherService service = new TeacherService(teacherManager);

    @Test
    void searchTeacherTest() {
        assertDoesNotThrow(() -> {
        //Criando um professor
        Name name = new Name("testando");
        Username userName = new Username("tester_one");
        Password password = new Password("321");
        UserStatus status = new UserStatus(true);
        service.createNewTeacher(name, userName, password, status);
        //Salvando o professor tester_one na variavel professor.
        Professor professor = teacherManager.getProfessor(userName);
        //Procurando pelo professor
        assertEquals(professor, service.searchTeacherAccount("tester_one"));
        });
    }

    @Test
    void searchTeacherUserNotFoundException() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_two");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewTeacher(name, userName, password, status);
        });
        String randomName = "fulano";
        assertThrows(UserNotFoundException.class, () -> service.searchTeacherAccount(randomName));
    }

    @Test
    void searchTeacherIncorrectTermException() {
        assertDoesNotThrow(() -> {
            //Criando um professor
            Name name = new Name("testando");
            Username userName = new Username("tester_three");
            Password password = new Password("321");
            UserStatus status = new UserStatus(true);
            service.createNewTeacher(name, userName, password, status);
        });
        String key = "";
        assertThrows(IncorrectTermException.class, () -> service.searchTeacherAccount(key));
    }
}
