package gerenciadordeacademia.administrador.teacherManager;

import java.util.List;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Username;

public interface DataServiceTeacher {
    void adcionarProfessor(Professor professor);
    void suspenderContaProfessor(Username userName);
    Professor buscarProfessor(String busca);
    List<Professor> mostrarListaProfessor();
}

