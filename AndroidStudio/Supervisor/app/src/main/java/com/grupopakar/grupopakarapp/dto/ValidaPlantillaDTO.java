package com.grupopakar.grupopakarapp.dto;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @author pablo.martinez
 */
public class ValidaPlantillaDTO implements Serializable {

    private int idTienda;
    private int idEmpleadoARevisar;
    private boolean valorRevision;
    private String comentario;

    public ValidaPlantillaDTO() {
        this.idTienda = 0;
        this.idEmpleadoARevisar = 0;
        this.valorRevision = false;
        this.comentario = "";
    }

    public ValidaPlantillaDTO(int idTienda, int idEmpleadoARevisar, boolean valorRevision, String comentario) {
        this.idTienda = idTienda;
        this.idEmpleadoARevisar = idEmpleadoARevisar;
        this.valorRevision = valorRevision;
        this.comentario = comentario;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdEmpleadoARevisar() {
        return idEmpleadoARevisar;
    }

    public void setIdEmpleadoARevisar(int idEmpleadoARevisar) {
        this.idEmpleadoARevisar = idEmpleadoARevisar;
    }

    public boolean isValorRevision() {
        return valorRevision;
    }

    public void setValorRevision(boolean valorRevision) {
        this.valorRevision = valorRevision;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    @NonNull
    public String toString() {
        return "ValidaPlantillaDTO{" + "idTienda=" + idTienda + ", idEmpleadoARevisar=" + idEmpleadoARevisar + ", valorRevision=" + valorRevision + ", comentario=" + comentario + '}';
    }

}
