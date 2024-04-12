package gerenciadordeacademia.administrador.service;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.*;
import gerenciadordeacademia.administrador.exceptions.EmptyListException;
import gerenciadordeacademia.administrador.exceptions.IncorrectTermException;
import gerenciadordeacademia.administrador.exceptions.UserAlreadyActiveException;
import gerenciadordeacademia.administrador.exceptions.UserAlreadyExistsException;
import gerenciadordeacademia.administrador.exceptions.UserAlreadySuspendException;
import gerenciadordeacademia.administrador.exceptions.UserNotFoundException;
import gerenciadordeacademia.administrador.studentManager.StudentManager;
import java.util.List;

public class StudentService {
    private StudentManager manager;

    public StudentService(StudentManager manager) {
        this.manager = manager;
    }

    public void createNewStudent(Name name, Username userName, Password password, UserStatus status) throws UserAlreadyExistsException{
        if (manager.searchStudent(userName.getStringUserName()) != null) {
            throw new UserAlreadyExistsException();
        }
        
        manager.createNewStudent(new Aluno(name, userName, password, status));
    }

    public Aluno searchStudentAccount(String key) throws UserNotFoundException, IncorrectTermException {
        if (key.isBlank()) {
            throw new IncorrectTermException();
        }

        if (manager.searchStudent(key) == null) {
            throw new UserNotFoundException();
        }
        return manager.searchStudent(key);
    }

    public boolean suspendStudentAccount(Username userName) throws UserNotFoundException, UserAlreadySuspendException {
        if (manager.getAluno(userName) == null) {
            throw new UserNotFoundException();
        }

        if (!manager.getAluno(userName).getStatusConta().isActive()) {
            throw new UserAlreadySuspendException();
        }

        manager.suspendAccount(userName);
        return true;
    }

    public boolean activateStudentAccount(Username userName) throws UserNotFoundException,  UserAlreadyActiveException {
        if (manager.getAluno(userName) == null) {
            throw new UserNotFoundException();
        }

        if (manager.getAluno(userName).getStatusConta().isActive()) {
            throw new UserAlreadyActiveException();
        }

        manager.activateAccount(userName);
        return true;
    } 

    public List<Aluno> showAllStudentsAccount() throws EmptyListException {
        if (manager.showAllStudents() == null) {
            throw new EmptyListException();
        }
        return manager.showAllStudents();
    }
}
