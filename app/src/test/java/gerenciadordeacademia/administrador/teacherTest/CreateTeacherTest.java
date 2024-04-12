package gerenciadordeacademia.administrador.teacherTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.*;
import gerenciadordeacademia.administrador.exceptions.UserAlreadyExistsException;
import gerenciadordeacademia.administrador.service.TeacherService;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;
import gerenciadordeacademia.administrador.teacherManager.TeacherRepository;

class CreateTeacherTest {
    private TeacherManager teacherManager = TeacherManager.getInstance(new TeacherRepository());
    private TeacherService service = new TeacherService(teacherManager);

    @Test
    void createNewTeacherTest() {
        Name name = assertDoesNotThrow(() -> new Name("Hugo"));
        Username userName = assertDoesNotThrow(() -> new Username("hugo_freitas"));
        Password password = assertDoesNotThrow(() ->new Password("321"));
        UserStatus status = new UserStatus(true);

        // Verifica se não há exceção ao criar um novo professor
        assertDoesNotThrow(() -> service.createNewTeacher(name, userName, password, status));

        // Verifica se o professor foi criado corretamente
        Professor professor = teacherManager.getProfessor(userName);
        assertNotNull(professor); // Verifica se o professor não é nulo
        assertEquals(name, professor.getNome()); // Verifica se o nome do professor está correto
        assertEquals(userName, professor.getUsername()); // Verifica se o nome de usuário do professor está correto
        assertEquals(password, professor.getSenha()); // Verifica se a senha do professor está correta
        assertEquals(status, professor.getStatusConta()); // Verifica se o status do professor está correto
    }

    // REVER ESSE CASO DE TESTE...

    /*@Test
    void createNewTeacherParameterException() {
        String newName = "";
        //assertThrows(UninformedParameterException.class,new Name(newName));
        assertThrows(UninformedParameterException.class, () -> new Name(newName));
    }*/

    @Test
    void createNewTeacherUserAlreadyExistsException() {
        Name nameLuis = assertDoesNotThrow(() -> new Name("Luis"));
        Username userNameLuis = assertDoesNotThrow(() -> new Username("luis_otavio"));
        Password passwordLuis = assertDoesNotThrow(() ->new Password("321"));
        UserStatus statusLuis = new UserStatus(true);

        // Verifica se não há exceção ao criar um novo professor
        assertDoesNotThrow(() -> service.createNewTeacher(nameLuis, userNameLuis, passwordLuis, statusLuis));
        

        Name nameLuiz = assertDoesNotThrow(() -> new Name("luiz"));
        Username userNameLuiz = assertDoesNotThrow(() -> new Username("luis_otavio"));
        Password passwordLuiz = assertDoesNotThrow(() -> new Password("321"));
        UserStatus statusLuiz = new UserStatus(true);

        Exception exception = assertThrows(UserAlreadyExistsException.class, () -> service.createNewTeacher(nameLuiz, userNameLuiz, passwordLuiz, statusLuiz));

        assertEquals("Usuário já existe.", exception.getMessage());
    }
}