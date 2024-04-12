package gerenciadordeacademia.administrador.domain.models;

import gerenciadordeacademia.administrador.exceptions.UninformedParameterException;

public class Password {
    private String password;

    public Password(String password) throws UninformedParameterException {
        if (password == null || password.isBlank()) {
            throw new UninformedParameterException();
        }
        this.password = password;
    }

    public String getStringPassword() {
        return password;
    }

    public void setStringPassword(String password) {
        this.password = password;
    }
    
}
