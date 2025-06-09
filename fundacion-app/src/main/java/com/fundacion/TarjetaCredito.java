package com.fundacion;


public class TarjetaCredito extends MedioPago {
    private int idTarjetaCredito;
    private long numeroTarjeta;
    private String fechaVencimiento;  // formato VARCHAR(5), por ejemplo "12/25"
    

     public TarjetaCredito(int idPago, String nombreTitular, String tipo,
                          long numeroTarjeta, String fechaVencimiento) {
        super(idPago, nombreTitular, tipo);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    public void setIdTarjetaCredito(int idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
