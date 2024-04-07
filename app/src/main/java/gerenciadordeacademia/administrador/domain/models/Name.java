package gerenciadordeacademia.administrador.domain.models;

public class Name {
    private String name;

    public Name(String name) {
        if (isValid(name)) {
            this.name = name;
        }
    }

    public String getStringName() {
        return name;
    }

    public void setStringName(String name) {
        this.name = name;
    }

    private boolean isValid(String name) {
        return name.isBlank() ? false : true;
    }

}
