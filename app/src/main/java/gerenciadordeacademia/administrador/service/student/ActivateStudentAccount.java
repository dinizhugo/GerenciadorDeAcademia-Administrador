package gerenciadordeacademia.administrador.service.student;

import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.service.Implementation;
import gerenciadordeacademia.administrador.studentManager.StudentManager;

public class ActivateStudentAccount implements Implementation{
    private StudentManager studentManager;
    private Username userName;

    public ActivateStudentAccount(StudentManager studentManager, Username userName) {
        this.studentManager = studentManager;
        this.userName = userName;
    }

    @Override
    public void execute() {
        if (userName == null) {
            //Parametro vazio
            return;
        }

        if (studentManager.getAluno(userName) == null) {
            // O professor com esser userName não existe.
            return;
        }

        if (studentManager.getAluno(userName).getStatusConta().isActive()) {
            // A conta já está ativada.
            return;
        }

        studentManager.activateAccount(userName);
    }
    
}
