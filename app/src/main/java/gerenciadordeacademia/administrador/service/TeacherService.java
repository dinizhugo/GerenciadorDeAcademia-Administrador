package gerenciadordeacademia.administrador.service;

import gerenciadordeacademia.administrador.exceptions.*;
import gerenciadordeacademia.administrador.domain.models.*;
import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;
import java.util.List;

public class TeacherService {
    private TeacherManager manager;

    public TeacherService(TeacherManager manager) {
        this.manager = manager;
    }

    public void createNewTeacher(Name name, Username userName, Password password, UserStatus status) throws UserAlreadyExistsException{
        if (manager.searchTeacher(userName.getStringUserName()) != null) {
            throw new UserAlreadyExistsException();
        }
        
        manager.createNewTeacher(new Professor(name, userName, password, status));
    }

    public Professor searchTeacherAccount(String key) throws UserNotFoundException, IncorrectTermException {
        if (key.isBlank()) {
            throw new IncorrectTermException();
        }

        if (manager.searchTeacher(key) == null) {
            throw new UserNotFoundException();
        }
        return manager.searchTeacher(key);
    }

    public boolean suspendTeacherAccount(Username userName) throws UserNotFoundException, UserAlreadySuspendException {
        if (manager.getProfessor(userName) == null) {
            throw new UserNotFoundException();
        }

        if (!manager.getProfessor(userName).getStatusConta().isActive()) {
            throw new UserAlreadySuspendException();
        }

        manager.suspendAccount(userName);
        return true;
    }

    public boolean activateTeacherAccount(Username userName) throws UserNotFoundException,  UserAlreadyActiveException {
        if (manager.getProfessor(userName) == null) {
            throw new UserNotFoundException();
        }

        if (manager.getProfessor(userName).getStatusConta().isActive()) {
            throw new UserAlreadyActiveException();
        }

        manager.activateAccount(userName);
        return true;
    } 

    public List<Professor> showAllTeachersAccount() throws EmptyListException {
        if (manager.showAllTeachers() == null) {
            throw new EmptyListException();
        }
        return manager.showAllTeachers();
    }
}
