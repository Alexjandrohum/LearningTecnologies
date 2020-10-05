package com.alexjandrohum.semanas.api;

public class ModeloSemanal {

    public String estudios;
    public String nombre;
    public String apep;
    public String apem;
    public String salon;
    public String materia;
    public String dia;
    public String horain;
    public String horafin;
    public int credito;
    public String clavemat;
    public String opcioncur;

    public ModeloSemanal(String estudios, String nombre, String apep, String apem, String salon, String materia, String dia, String horain, String horafin, int credito, String clavemat, String opcioncur) {
        this.estudios = estudios;
        this.nombre = nombre;
        this.apep = apep;
        this.apem = apem;
        this.salon = salon;
        this.materia = materia;
        this.dia = dia;
        this.horain = horain;
        this.horafin = horafin;
        this.credito = credito;
        this.clavemat = clavemat;
        this.opcioncur = opcioncur;
    }


    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApep() {
        return apep;
    }

    public void setApep(String apep) {
        this.apep = apep;
    }

    public String getApem() {
        return apem;
    }

    public void setApem(String apem) {
        this.apem = apem;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorain() {
        return horain;
    }

    public void setHorain(String horain) {
        this.horain = horain;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public String getClavemat() {
        return clavemat;
    }

    public void setClavemat(String clavemat) {
        this.clavemat = clavemat;
    }

    public String getOpcioncur() {
        return opcioncur;
    }

    public void setOpcioncur(String opcioncur) {
        this.opcioncur = opcioncur;
    }
}
