package main.java.gerenciadordeacademia.administrador.collections;

import java.util.List;

import main.java.gerenciadordeacademia.administrador.domain.Aluno;

public class ListStudent {
    private List<Aluno> alunos;

    public ListStudent() {
        this.alunos = new ArrayList<>();
    }

    private List<Aluno> getAlunos() {
        return alunos;
    }

    public int size() {
        return getAlunos().size();
    }

    public void add(Aluno novoAluno) {
        getAlunos().add(novoAluno);
    }

    public Aluno getAluno(int index) {
        return getAlunos().get(index);
    }

    public Aluno getAluno(Aluno object) {
        return getAlunos().get(getAlunos().indexOf(object));
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
