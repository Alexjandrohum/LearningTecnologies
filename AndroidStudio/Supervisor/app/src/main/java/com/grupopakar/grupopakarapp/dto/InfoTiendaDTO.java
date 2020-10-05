package com.grupopakar.grupopakarapp.dto;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @author rosa.zalas
 */
public class InfoTiendaDTO implements Serializable {

    private int idInformacionTienda;
    private String nombreConcepto;
    private String valorConcepto;
    private boolean editable;

    public InfoTiendaDTO() {
        this.idInformacionTienda = 0;
        this.nombreConcepto = "";
        this.valorConcepto = "";
        this.editable = false;
    }

    public InfoTiendaDTO(int idInformacionTienda, String valorConcepto) {
        this.idInformacionTienda = idInformacionTienda;
        this.valorConcepto = valorConcepto;
        this.editable = false;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getIdInformacionTienda() {
        return idInformacionTienda;
    }

    public void setIdInformacionTienda(int idTiendaInfo) {
        this.idInformacionTienda = idTiendaInfo;
    }

    public String getValorConcepto() {
        return valorConcepto;
    }

    public void setValorConcepto(String valorConcepto) {
        this.valorConcepto = valorConcepto;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    @Override
    @NonNull
    public String toString() {
        return "InfoTiendaDTO{" + "idTiendaInfo=" + idInformacionTienda + ", nombreConcepto=" + nombreConcepto + ", valorConcepto=" + valorConcepto + '}';
    }
}
