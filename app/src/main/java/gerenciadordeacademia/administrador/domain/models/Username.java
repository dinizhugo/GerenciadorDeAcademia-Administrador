package gerenciadordeacademia.administrador.domain.models;

import gerenciadordeacademia.administrador.exceptions.UninformedParameterException;

public class Username {
    private String userName;

    public Username(String userName) throws UninformedParameterException {
        if (userName == null || userName.isBlank()) {
            throw new UninformedParameterException();
        }
        this.userName = userName;
    }

    public String getStringUserName() {
        return userName;
    }

    public void setStringUserName(String userName) {
        this.userName = userName;
    }
    
}
