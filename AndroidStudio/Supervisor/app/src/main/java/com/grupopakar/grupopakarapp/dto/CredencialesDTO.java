package com.grupopakar.grupopakarapp.dto;

import java.io.Serializable;

/**
 * @author carlos.juarez
 */

public class CredencialesDTO implements Serializable {
    private String usuario;
    private String password;

    public CredencialesDTO(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
