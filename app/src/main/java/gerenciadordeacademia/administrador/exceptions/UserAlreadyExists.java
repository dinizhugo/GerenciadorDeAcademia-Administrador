package gerenciadordeacademia.administrador.exceptions;

public class UserAlreadyExists extends Exception {
    public UserAlreadyExists() {
        super("Usuário já existe.");
    }
}
