package gerenciadordeacademia.administrador.service.teacher;

import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;

public class ShowAllTeachersAccount implements Service{

    private TeacherManager teacherManager;

    public ShowAllTeachersAccount(TeacherManager teacherManager) {
        this.teacherManager = teacherManager;
    }

    @Override
    public void service() {
        teacherManager.showAllTeachers();
    }
    
}
