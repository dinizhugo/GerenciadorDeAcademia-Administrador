package gerenciadordeacademia.administrador.service.student;

import gerenciadordeacademia.administrador.service.Service;
import gerenciadordeacademia.administrador.studentManager.StudentManager;

public class SearchStudent implements Service {
    private StudentManager studentManager;
    private String key;

    public SearchStudent(StudentManager studentManager, String key) {
        this.studentManager = studentManager;
        this.key = key;
    }

    public void service() {
        if (key.isBlank()) {
            // Termo para busca não satisfaz a condição
            return;
        }

        if (studentManager.searchStudent(key) == null) {
            // Não existe nenhum Professor com esse "nome"
            return;
        }

        studentManager.searchStudent(key);
    }
}
