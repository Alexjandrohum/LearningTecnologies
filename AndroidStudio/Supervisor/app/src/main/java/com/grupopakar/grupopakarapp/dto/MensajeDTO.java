package com.grupopakar.grupopakarapp.dto;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @author carlos.juarez
 */
public class MensajeDTO implements Serializable {

    private String Estatus;

    public MensajeDTO() {
    }

    public MensajeDTO(String estatus) {
        this.Estatus = estatus;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        this.Estatus = estatus;
    }

    @Override
    @NonNull
    public String toString() {
        return "MensajeDTO{" +
                "Estatus='" + Estatus + '\'' +
                '}';
    }
}
