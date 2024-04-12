package gerenciadordeacademia.administrador.exceptions;

public class IncorrectTermException extends Exception {
    public IncorrectTermException() {
        super("O termo não satisfaz as condições para busca.");
    }
}
