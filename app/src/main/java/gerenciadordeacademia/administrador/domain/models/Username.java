package gerenciadordeacademia.administrador.domain.models;

public class Username {
    private String userName;

    public Username(String userName) {
        this.userName = userName;
    }

    public String getStringUserName() {
        return userName;
    }

    public void setStringUserName(String userName) {
        this.userName = userName;
    }
    
}
