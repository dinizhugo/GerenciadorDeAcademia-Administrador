package gerenciadordeacademia.administrador.service.student;

import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.studentManager.StudentManager;

public class ShowAllStudentAccount implements Service{

    private StudentManager studentManager;

    public ShowAllStudentAccount(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    public void service() {
        studentManager.showAllStudents();
    }
    
}
