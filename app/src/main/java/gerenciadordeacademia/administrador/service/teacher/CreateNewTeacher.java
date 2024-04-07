package gerenciadordeacademia.administrador.service.teacher;

import gerenciadordeacademia.administrador.domain.Professor;
import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.service.Implementation;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;

public class CreateNewTeacher implements Implementation{

    private TeacherManager teacherManager;
    private Name name;
    private Username userName;
    private Password password;
    private UserStatus status;

    public CreateNewTeacher(TeacherManager teacherManager,Name name, Username userName, Password password, UserStatus status) {
        this.teacherManager = teacherManager;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    @Override
    public void execute() {

        if (teacherManager.getProfessor(userName) != null) {
            // Já existe um usúario com esse userName
            return;
        }

        if (name == null || userName == null || password == null) {
            // Pelo menos um dos paramentros foram null.
            return;
        }
        
        teacherManager.createNewTeacher(new Professor(name, userName, password, status));
    }
    
}
