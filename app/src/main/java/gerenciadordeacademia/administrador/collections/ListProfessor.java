package main.java.gerenciadordeacademia.administrador.collections;

import java.util.ArrayList;
import java.util.List;

import main.java.gerenciadordeacademia.administrador.domain.Professor;

public class ListProfessor {
    private List<Professor> professores;

    public ListStudent() {
        this.professores = new ArrayList<>();
    }

    private List<Professor> getProfessores() {
        return professores;
    }

    public int size() {
        return getProfessores().size();
    }

    public void add(Professor novoProfessor) {
        getProfessores().add(novoProfessor);
    }

    public Professor getProfessor(int index) {
        return getProfessores().get(index);
    }

    public Professor getProfessor(Professor object) {
        return getProfessores().get(getProfessores().indexOf(object));
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
