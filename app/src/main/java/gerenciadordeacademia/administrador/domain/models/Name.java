package gerenciadordeacademia.administrador.domain.models;

import gerenciadordeacademia.administrador.exceptions.UninformedParameterException;

public class Name {
    private String name;

    public Name(String name) throws UninformedParameterException {
        if (validateName(name)) {
            this.name = name;
        }
    }

    public String getStringName() {
        return name;
    }

    public void setStringName(String name) {
        this.name = name;
    }

    public boolean validateName(String name) throws UninformedParameterException {
        if (name.isEmpty()) {
            throw new UninformedParameterException();
        }
        return true;
    }
}
