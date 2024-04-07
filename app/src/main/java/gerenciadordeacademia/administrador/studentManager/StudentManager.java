package gerenciadordeacademia.administrador.studentManager;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.Username;

import java.util.List;

public class StudentManager {
    private DataServiceStudent repository;
    private static StudentManager instance;

    private StudentManager(DataServiceStudent repository) {
        this.repository = repository;
    }

    public static StudentManager getInstance(DataServiceStudent repository) {
        if (instance == null) {
            instance = new StudentManager(repository);
        }
        return instance;
    }

    public void createNewStudent(Aluno aluno) {
        repository.adcionarAluno(aluno);
    }

    public void suspendAccount(Username userName) {
        repository.suspenderContaAluno(userName);
    }

    public void activateAccount(Username userName) {
        repository.ActivateStudentAccount(userName);
    }

    public Aluno searchStudent(String search) {
        return repository.buscarAluno(search);
    }

    public Aluno getAluno(Username userName) {
        return repository.getAluno(userName);
    }

    public List<Aluno> showAllStudents() {
        return repository.mostrarListaAluno();
    }
}
