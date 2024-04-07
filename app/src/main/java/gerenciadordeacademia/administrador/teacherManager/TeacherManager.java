package gerenciadordeacademia.administrador.teacherManager;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Username;

import java.util.List;

public class TeacherManager {
    private DataServiceTeacher service;
    private static TeacherManager instance;

    private TeacherManager(DataServiceTeacher service) {
        this.service = service;
    }

    public static TeacherManager getInstance(DataServiceTeacher service) {
        if (instance == null) {
            instance = new TeacherManager(service);
        }
        return instance;
    }

    public void createNewTeacher(Professor professor) {
        service.adcionarProfessor(professor);
    }

    public void suspendAccount(Username userName) {
        service.suspenderContaProfessor(userName);
    }

    public Professor searchTeacher(String search) {
        return service.buscarProfessor(search);
    }

    public List<Professor> showAllTeachers() {
        return service.mostrarListaProfessor();
    }

    public Professor getProfessor(Username userName) {
        return service.getProfessor(userName);
    }

}
