package com.fundacion;

public class TarjetaDebito extends MedioPago{
    private int idTarjetaDebito;
    private String cbu;
    private String nroCuenta;
    private String nombreBanco;
    private String sucursalBanco;
    private String tipoCuenta;

    public TarjetaDebito(int idPago, String nombreTitular, String tipo,
                         String cbu, String nroCuenta, String nombreBanco,
                         String sucursalBanco, String tipoCuenta) {
        super(idPago, nombreTitular, tipo);
        this.cbu = cbu;
        this.nroCuenta = nroCuenta;
        this.nombreBanco = nombreBanco;
        this.sucursalBanco = sucursalBanco;
        this.tipoCuenta = tipoCuenta;
    }


    public int getIdTarjetaDebito() {
        return idTarjetaDebito;
    }

    public void setIdTarjetaDebito(int idTarjetaDebito) {
        this.idTarjetaDebito = idTarjetaDebito;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getSucursalBanco() {
        return sucursalBanco;
    }

    public void setSucursalBanco(String sucursalBanco) {
        this.sucursalBanco = sucursalBanco;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
