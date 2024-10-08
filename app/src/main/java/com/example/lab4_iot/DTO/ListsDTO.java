package com.example.lab4_iot.DTO;

import java.util.List;

public class ListsDTO {
    private List<Ligas> ligas;
    private List<Posiciones> posiciones;


    public List<Ligas> getLigas() {
        return ligas;
    }

    public void setLigas(List<Ligas> ligas) {
        this.ligas = ligas;
    }

    public List<Posiciones> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(List<Posiciones> posiciones) {
        this.posiciones = posiciones;
    }
}
