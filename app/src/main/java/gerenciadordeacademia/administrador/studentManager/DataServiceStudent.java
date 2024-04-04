//package main.java.gerenciadordeacademia.administrador.studentManager;

import java.util.List;

import main.java.gerenciadordeacademia.administrador.domain.Aluno;
import main.java.gerenciadordeacademia.administrador.domain.models.Username;

public interface DataServiceStudent {
    void adcionarAluno(Aluno aluno);
    void suspenderContaAluno(Username userName);
    void editarContaAluno(Username userName);
    Aluno buscarAluno(String busca);
    List<Aluno> mostrarListaAluno();
}
