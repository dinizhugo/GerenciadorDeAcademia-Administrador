package main.java.gerenciadordeacademia.administrador.domain.models;


public class UserStatus {
    private boolean active;

    public UserStatus(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
}
