package com.grupopakar.grupopakarapp.dto;

import java.io.Serializable;

/**
 * @author alberto.quirino
 */
public class InfoTareaDTO implements Serializable {

    private int idTarea;
    private int idTienda;
    private boolean valorEstatusTarea;

    public InfoTareaDTO(int idTarea, boolean valorEstatusTarea, int idTienda) {
        this.idTarea = idTarea;
        this.valorEstatusTarea = valorEstatusTarea;
        this.idTienda = idTienda;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public boolean isValorEstatusTarea() {
        return valorEstatusTarea;
    }

    public void setValorEstatusTarea(boolean valorEstatusTarea) {
        this.valorEstatusTarea = valorEstatusTarea;
    }

}
