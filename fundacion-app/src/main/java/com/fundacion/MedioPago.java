package com.fundacion;

public class MedioPago {
    public int idPago;
    public String nombreTitular;
    public String tipo;  // Enum ('debito', 'credito')

    public MedioPago(int idPago, String nombreTitular, String tipo) {
        this.idPago = idPago;
        this.nombreTitular = nombreTitular;
        this.tipo = tipo;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
