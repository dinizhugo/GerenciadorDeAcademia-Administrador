package gerenciadordeacademia.administrador.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("Usuário já existe.");
    }
}
