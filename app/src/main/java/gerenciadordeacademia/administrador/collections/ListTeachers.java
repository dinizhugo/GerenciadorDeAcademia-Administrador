package gerenciadordeacademia.administrador.collections;

import java.util.List;

import gerenciadordeacademia.administrador.domain.Professor;

import java.util.ArrayList;


public class ListTeachers {
    private List<Professor> professores;

    public ListTeachers() {
        this.professores = new ArrayList<>();
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public int size() {
        return getProfessores().size();
    }

    public void add(Professor novoProfessor) {
        getProfessores().add(novoProfessor);
    }

    // OS MÉTODOS "getProfessor" PODEM SER EXCLUIDOS FUTURAMENTE SE NÃO TIVEREM USO. 
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
