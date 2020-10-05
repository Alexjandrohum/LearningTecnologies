package com.example.conectarapi.api;

public class ModeloPerfil {
    public int id;
    public String nom;
    public String ap;
    public String am;
    public String gru;
    public String sem;
    public String car;

    public int getMatricula() {
        return id;
    }

    public void setMatricula(int matricula) {
        this.id = matricula;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getGru() {
        return gru;
    }

    public void setGru(String gru) {
        this.gru = gru;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
