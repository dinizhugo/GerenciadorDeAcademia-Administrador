package gerenciadordeacademia.administrador.domain;

import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;

public class User {
    private Name nome;
    private Username username;
    private Password senha;
    private UserStatus statusConta;

    public User(Name nome, Username username, Password senha, UserStatus status) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.statusConta = status;
    }

    public UserStatus isStatusConta() {
        return statusConta;
    }


    public Name getNome() {
        return nome;
    }


    public Username getUsername() {
        return username;
    }


    public Password getSenha() {
        return senha;
    }


    public UserStatus getStatusConta() {
        return statusConta;
    }
}
