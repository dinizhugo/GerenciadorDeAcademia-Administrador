package gerenciadordeacademia.administrador.teacherManager;

import java.util.List;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Username;

public interface DataServiceTeacher {
    void adcionarProfessor(Professor professor);
    void suspenderContaProfessor(Username userName);
    void activateTeacherAccount(Username userName);
    Professor buscarProfessor(String busca);
    Professor getProfessor(Username username);
    List<Professor> mostrarListaProfessor();
}

