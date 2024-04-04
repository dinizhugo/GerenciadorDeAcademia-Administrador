package main.java.gerenciadordeacademia.administrador.domain;

import main.java.gerenciadordeacademia.administrador.domain.models.Nome;
import main.java.gerenciadordeacademia.administrador.domain.models.Password;
import main.java.gerenciadordeacademia.administrador.domain.models.UserStatus;
import main.java.gerenciadordeacademia.administrador.domain.models.Username;

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

    public User(Name nome, Username username, Password senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.statusConta = true;
    }


    public String getNome() {
        return nome;
    }


    public String getUsername() {
        return username;
    }


    public String getSenha() {
        return senha;
    }

    public UserStatus isStatusConta() {
        return statusConta;
    }
}
