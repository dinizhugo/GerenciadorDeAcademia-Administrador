package gerenciadordeacademia.administrador.service.student;

import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.studentManager.StudentManager;

public class CreateNewStudent implements Service {
    private StudentManager studentManager;
    private Name name;
    private Username userName;
    private Password password;
    private UserStatus status;

    public CreateNewStudent(StudentManager studentManager, Name name, Username userName, Password password, UserStatus status) {
        this.studentManager = studentManager;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    @Override
    public void service() {

        if (studentManager.getAluno(userName) != null) {
            // Já existe um usúario com esse userName
            return;
        }

        if (name == null || userName == null || password == null) {
            // Pelo menos um dos paramentros foram null.
            return;
        }
        
        studentManager.createNewStudent(new Aluno(name, userName, password, status));
    }   
}
