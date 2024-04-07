package gerenciadordeacademia.administrador.studentManager;


import java.util.List;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.Username;

public interface DataServiceStudent {
    void adcionarAluno(Aluno aluno);
    void suspenderContaAluno(Username userName);
    void ActivateStudentAccount(Username userName);
    Aluno buscarAluno(String busca);
    Aluno getAluno(Username userName);
    List<Aluno> mostrarListaAluno();
}
