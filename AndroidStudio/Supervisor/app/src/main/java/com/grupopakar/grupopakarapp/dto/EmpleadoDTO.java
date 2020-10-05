package com.grupopakar.grupopakarapp.dto;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author pablo.martinez
 */
public class EmpleadoDTO implements Serializable {

    private int idEmpleado;
    private String numeroControl;
    private String nombreEmpleado;
    private String puestoEmpleado;
    private boolean validarPlantilla;
    private String rutaImagen;
    private String descanso;

    public EmpleadoDTO() {
        this.idEmpleado = 0;
        this.numeroControl = "";
        this.nombreEmpleado = "";
        this.puestoEmpleado = "";
        this.rutaImagen = "";
        this.descanso = "";
    }

    public String getDescanso() {
        return descanso;
    }

    public void setDescanso(String descanso) {
        this.descanso = descanso;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public boolean isValidarPlantilla() {
        return validarPlantilla;
    }

    public void setValidarPlantilla(boolean validarPlantilla) {
        this.validarPlantilla = validarPlantilla;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idEmpleado);
        return hash;
    }

    @Override
    @NonNull
    public String toString() {
        return "EmpleadoDTO{" + "idEmpleado=" + idEmpleado + ", numeroControl=" + numeroControl + ", nombreEmpleado=" + nombreEmpleado + ", puestoEmpleado=" + puestoEmpleado + ", validarPlantilla=" + validarPlantilla + ", rutaImagen=" + rutaImagen + '}';
    }

}
