package main.java.gerenciadordeacademia.administrador.teacherManager;

import java.util.List;

import main.java.gerenciadordeacademia.administrador.domain.Aluno;
import main.java.gerenciadordeacademia.administrador.domain.Professor;
import main.java.gerenciadordeacademia.administrador.domain.models.Username;

public interface DataServiceTeacher {
    void adcionarProfessor(Professor professor);
    void suspenderContaProfessor(Username userName);
    void editarContaProfessor(Username userName);
    Professor buscarProfessor(String busca);
    List<Professor> mostrarListaProfessor();
}

