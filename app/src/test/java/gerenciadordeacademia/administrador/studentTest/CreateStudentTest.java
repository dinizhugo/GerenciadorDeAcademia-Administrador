package gerenciadordeacademia.administrador.studentTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.*;
import gerenciadordeacademia.administrador.exceptions.UserAlreadyExistsException;
import gerenciadordeacademia.administrador.service.StudentService;
import gerenciadordeacademia.administrador.studentManager.StudentManager;
import gerenciadordeacademia.administrador.studentManager.StudentRepository;

class CreateStudentTest {
    private StudentManager studentManager = StudentManager.getInstance(new StudentRepository());
    private StudentService service = new StudentService(studentManager);

    @Test
    void createNewStudentTest() {
        Name name = assertDoesNotThrow(() -> new Name("Hugo"));
        Username userName = assertDoesNotThrow(() -> new Username("hugo_freitas"));
        Password password = assertDoesNotThrow(() ->new Password("321"));
        UserStatus status = new UserStatus(true);

        // Verifica se não há exceção ao criar um novo professor
        assertDoesNotThrow(() -> service.createNewStudent(name, userName, password, status));

        // Verifica se o aluno foi criado corretamente
        Aluno aluno = studentManager.getAluno(userName);
        assertNotNull(aluno); // Verifica se o aluno não é nulo
        assertEquals(name, aluno.getNome()); // Verifica se o nome do aluno está correto
        assertEquals(userName, aluno.getUsername()); // Verifica se o nome de usuário do aluno está correto
        assertEquals(password, aluno.getSenha()); // Verifica se a senha do aluno está correta
        assertEquals(status, aluno.getStatusConta()); // Verifica se o status do professor está correto
    }


    @Test
    void createNewStudentUserAlreadyExistsException() {
        Name nameLuis = assertDoesNotThrow(() -> new Name("Luis"));
        Username userNameLuis = assertDoesNotThrow(() -> new Username("luis_otavio"));
        Password passwordLuis = assertDoesNotThrow(() ->new Password("321"));
        UserStatus statusLuis = new UserStatus(true);

        // Verifica se não há exceção ao criar um novo professor
        assertDoesNotThrow(() -> service.createNewStudent(nameLuis, userNameLuis, passwordLuis, statusLuis));
        

        Name nameLuiz = assertDoesNotThrow(() -> new Name("luiz"));
        Username userNameLuiz = assertDoesNotThrow(() -> new Username("luis_otavio"));
        Password passwordLuiz = assertDoesNotThrow(() -> new Password("321"));
        UserStatus statusLuiz = new UserStatus(true);

        Exception exception = assertThrows(UserAlreadyExistsException.class, () -> service.createNewStudent(nameLuiz, userNameLuiz, passwordLuiz, statusLuiz));

        assertEquals("Usuário já existe.", exception.getMessage());
    }
}