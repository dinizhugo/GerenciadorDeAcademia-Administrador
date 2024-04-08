package gerenciadordeacademia.administrador.service.student;

import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.studentManager.StudentManager;

public class SuspendStudentAccount implements Service {

    private StudentManager studentManager;   
    private Username userName;

    public SuspendStudentAccount(StudentManager studentManager, Username userName) {
        this.studentManager = studentManager;
        this.userName = userName;
    }

    @Override
    public void service() {
        if (userName == null) {
            //Parametro vazio
            return;
        }

        if (studentManager.getAluno(userName) == null) {
            // O professor com esser userName não existe.
            return;
        }

        if (!studentManager.getAluno(userName).getStatusConta().isActive()) {
            // A conta já está suspensa.
            return;
        }

        studentManager.suspendAccount(userName);
        
    }
    
}