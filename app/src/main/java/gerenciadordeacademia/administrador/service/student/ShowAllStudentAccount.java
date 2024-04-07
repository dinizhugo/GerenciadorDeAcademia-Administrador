package gerenciadordeacademia.administrador.service.student;

import gerenciadordeacademia.administrador.service.Implementation;
import gerenciadordeacademia.administrador.studentManager.StudentManager;

public class ShowAllStudentAccount implements Implementation{

    private StudentManager studentManager;

    public ShowAllStudentAccount(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    public void execute() {
        studentManager.showAllStudents();
    }
    
}
