package gerenciadordeacademia.administrador.studentManager;

import gerenciadordeacademia.administrador.collections.ListStudent;
import gerenciadordeacademia.administrador.domain.Aluno;
import gerenciadordeacademia.administrador.domain.models.Username;

import java.util.List;
import java.util.Optional;

public class StudentRepository implements DataServiceStudent {
    protected ListStudent listaAlunos;

    public StudentRepository() {
        this.listaAlunos = new ListStudent();
    }

    @Override
    public void adcionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    @Override
    public void suspenderContaAluno(Username userName) {
        Optional<Aluno> usuario = listaAlunos.getAlunos().stream().filter(u -> u.equals(userName)).findFirst();
        if (usuario.isPresent()) {
            usuario.get().getStatusConta().setActive(false);
            return;
        }
    }
    
    @Override
    public Aluno buscarAluno(String busca) {
        Optional<Aluno> usuario = listaAlunos.getAlunos().stream().filter(u -> u.getNome().getStringName().toLowerCase().contains(busca.toLowerCase()) || u.getUsername().getStringUserName().contains(busca)).findFirst();
        return usuario.isPresent() ? usuario.get() : null;
    }

    @Override
    public List<Aluno> mostrarListaAluno() {
      return listaAlunos.getAlunos();
    }

    @Override
    public void ActivateStudentAccount(Username userName) {
        Optional<Aluno> usuario = listaAlunos.getAlunos().stream().filter(u -> u.equals(userName)).findFirst();
        if (usuario.isPresent()) {
            usuario.get().getStatusConta().setActive(true);
            return;
        }
    }

    @Override
    public Aluno getAluno(Username userName) {
        Optional<Aluno> usuario = listaAlunos.getAlunos().stream().filter(u -> u.getUsername().getStringUserName().equals(userName)).findFirst();
        return usuario.isPresent() ? usuario.get() : null;
    }
}