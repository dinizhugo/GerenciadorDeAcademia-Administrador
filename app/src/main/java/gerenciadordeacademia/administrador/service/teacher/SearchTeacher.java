package gerenciadordeacademia.administrador.service.teacher;

import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.teacherManager.TeacherManager;

public class SearchTeacher implements Service {
    private TeacherManager teacherManager;
    private String key;

    public SearchTeacher(TeacherManager teacherManager, String key) {
        this.teacherManager = teacherManager;
        this.key = key;
    }

    @Override
    public void service() {
        if (key.isBlank()) {
            // Termo para busca não satisfaz a condição
            return;
        }

        if (teacherManager.searchTeacher(key) == null) {
            // Não existe nenhum Professor com esse "nome"
            return;
        }

        teacherManager.searchTeacher(key);
    }
    
}
