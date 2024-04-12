package gerenciadordeacademia.administrador.exceptions;

public class EmptyListException extends Exception {
    public EmptyListException() {
        super("A lista está vazia.");
    }
}
