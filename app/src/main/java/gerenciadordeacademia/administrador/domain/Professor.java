package gerenciadordeacademia.administrador.domain;

import gerenciadordeacademia.administrador.domain.models.Name;
import gerenciadordeacademia.administrador.domain.models.Password;
import gerenciadordeacademia.administrador.domain.models.UserStatus;
import gerenciadordeacademia.administrador.domain.models.Username;

public class Professor extends User {

    public Professor(Name nome, Username username, Password senha, UserStatus status) {
        super(nome, username, senha, status);
    }
    
}
