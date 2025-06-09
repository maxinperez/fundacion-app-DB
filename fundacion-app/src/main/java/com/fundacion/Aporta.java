package com.fundacion;

public class Aporta {
    private int dniAporta;
    private int idProgramaAporta;
    private Integer idMp;  
    private String frecuencia;  
    private int monto;


    public Aporta(int dniAporta, int idProgramaAporta, Integer idMp, String frecuencia, int monto) {
        this.dniAporta = dniAporta;
        this.idProgramaAporta = idProgramaAporta;
        this.idMp = idMp;
        this.frecuencia = frecuencia;
        this.monto = monto;
    }

    public int getDniAporta() {
        return dniAporta;
    }

    public void setDniAporta(int dniAporta) {
        this.dniAporta = dniAporta;
    }

    public int getIdProgramaAporta() {
        return idProgramaAporta;
    }

    public void setIdProgramaAporta(int idProgramaAporta) {
        this.idProgramaAporta = idProgramaAporta;
    }

    public Integer getIdMp() {
        return idMp;
    }

    public void setIdMp(Integer idMp) {
        this.idMp = idMp;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
