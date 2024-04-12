package gerenciadordeacademia.administrador.exceptions;

public class UserAlreadySuspendException extends Exception {
    public UserAlreadySuspendException() {
        super("O usuário já está com a conta suspendida.");
    }
}
