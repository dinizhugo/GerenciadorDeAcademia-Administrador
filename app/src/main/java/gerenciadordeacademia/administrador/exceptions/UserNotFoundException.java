package gerenciadordeacademia.administrador.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Não foi possível encontrar um usuário com esse username.");
    }
}
