package gerenciadordeacademia.administrador.service.teacher;

import gerenciadordeacademia.administrador.service.Implementation;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;

public class ShowAllTeachersAccount implements Implementation{

    private TeacherManager teacherManager;

    public ShowAllTeachersAccount(TeacherManager teacherManager) {
        this.teacherManager = teacherManager;
    }

    @Override
    public void execute() {
        teacherManager.showAllTeachers();
    }
    
}
