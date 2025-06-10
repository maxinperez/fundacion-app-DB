package com.fundacion;
import java.sql.Date;

public class Contacto extends Padrino{
    private Date fechaAlta;
    private Date fechaBaja;
    private Date fechaRechazo;
    private Date fechaPrimerContacto;
    private String estado; // ENUM en la DB

    public Contacto(int dni, String nombre, String apellido, String direccion, String email, Date fechaNacimiento,
                    String facebook, int codPostal, String telefonoFijo, String telefonoCelular,
                    Date fechaAlta, Date fechaBaja, Date fechaRechazo, Date fechaPrimerContacto, String estado) {
        super(dni, nombre, apellido, direccion, email, fechaNacimiento, facebook, codPostal, telefonoFijo, telefonoCelular);
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.fechaRechazo = fechaRechazo;
        this.fechaPrimerContacto = fechaPrimerContacto;
        this.estado = estado;
    }

    public Date getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(Date fechaAlta) { this.fechaAlta = fechaAlta; }

    public Date getFechaBaja() { return fechaBaja; }
    public void setFechaBaja(Date fechaBaja) { this.fechaBaja = fechaBaja; }

    public Date getFechaRechazo() { return fechaRechazo; }
    public void setFechaRechazo(Date fechaRechazo) { this.fechaRechazo = fechaRechazo; }

    public Date getFechaPrimerContacto() { return fechaPrimerContacto; }
    public void setFechaPrimerContacto(Date fechaPrimerContacto) { this.fechaPrimerContacto = fechaPrimerContacto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
