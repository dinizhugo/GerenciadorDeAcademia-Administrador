package gerenciadordeacademia.administrador.service.teacher;

import gerenciadordeacademia.administrador.domain.models.Username;
import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;

public class SuspendTeacherAccount implements Service {

    private TeacherManager teacherManager;
    private Username userName;

    public SuspendTeacherAccount(TeacherManager teacherManager, Username userName) {
        this.teacherManager = teacherManager;
        this.userName = userName;
    }

    @Override
    public void service() {
        if (userName == null) {
            //Parametro vazio
            return;
        }

        if (teacherManager.getProfessor(userName) == null) {
            // O professor com esser userName não existe.
            return;
        }

        if (!teacherManager.getProfessor(userName).getStatusConta().isActive()) {
            // A conta já está suspensa.
            return;
        }

        teacherManager.suspendAccount(userName);
        
    }
    
}
