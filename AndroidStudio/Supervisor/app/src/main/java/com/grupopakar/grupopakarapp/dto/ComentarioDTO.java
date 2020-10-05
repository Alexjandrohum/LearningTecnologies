package com.grupopakar.grupopakarapp.dto;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos.juarez
 */
public class ComentarioDTO {
    
    private int idComentario;
    private int idComentarioPadre;
    private int idTienda;
    private String fecha;
    private String nombreUsuario;
    private String comentario;
    private List<ComentarioDTO> respuestas;

    public ComentarioDTO() {
        this.respuestas = new ArrayList<>();
        idComentarioPadre = 0;
    }

    public ComentarioDTO(int idComentarioPadre, int idTienda, String comentario) {
        this.idComentarioPadre = idComentarioPadre;
        this.idTienda = idTienda;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<ComentarioDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<ComentarioDTO> respuestas) {
        this.respuestas = respuestas;
    }

    public int getIdComentarioPadre() {
        return idComentarioPadre;
    }

    public void setIdComentarioPadre(int idComentarioPadre) {
        this.idComentarioPadre = idComentarioPadre;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    @Override
    @NonNull
    public String toString() {
        return "ComentarioDTO{" + "idComentario=" + idComentario + ", idComentarioPadre=" + idComentarioPadre + ", idTienda=" + idTienda + ", fecha=" + fecha + ", nombreUsuario=" + nombreUsuario + ", comentario=" + comentario + ", respuestas=" + respuestas + '}';
    }


    
}
