package gerenciadordeacademia.administrador.exceptions;

public class UserAlreadyActiveException extends Exception {
    public UserAlreadyActiveException() {
        super("O usuário já está com a conta ativa.");
    }
}
