package gerenciadordeacademia.administrador.teacherManager;

import java.util.List;
import java.util.Optional;

import gerenciadordeacademia.administrador.collections.ListTeachers;
import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Username;

public class TeacherRepository implements DataServiceTeacher {

    protected ListTeachers listaProfessores;

    public TeacherRepository() {
        this.listaProfessores = new ListTeachers();
    }

    @Override
    public void adcionarProfessor(Professor professor) {
        listaProfessores.add(professor);
    }

    @Override
    public void suspenderContaProfessor(Username userName) {
        Optional<Professor> usuario = listaProfessores.getProfessores().stream().filter(u -> u.equals(userName)).findFirst();
        if (usuario.isPresent()) {
            usuario.get().getStatusConta().setActive(false);
            return;
        }
    }
    
    @Override
    public Professor buscarProfessor(String busca) {
        Optional<Professor> usuario = listaProfessores.getProfessores().stream().filter(u -> u.getNome().getStringName().toLowerCase().contains(busca.toLowerCase()) || u.getUsername().getStringUserName().contains(busca)).findFirst();
        return usuario.isPresent() ? usuario.get() : null;
    }

    @Override
    public Professor getProfessor(Username userName) {
        Optional<Professor> usuario = listaProfessores.getProfessores().stream().filter(u -> u.getUsername().equals(userName)).findFirst();
        return usuario.isPresent() ? usuario.get() : null;
    }

    @Override
    public List<Professor> mostrarListaProfessor() {
        return listaProfessores.isEmpty() ? null : listaProfessores.getProfessores();
    }

    @Override
    public void activateTeacherAccount(Username userName) {
        Optional<Professor> usuario = listaProfessores.getProfessores().stream().filter(u -> u.equals(userName)).findFirst();
        if (usuario.isPresent()) {
            usuario.get().getStatusConta().setActive(true);
            return;
        }
    }
    
}
