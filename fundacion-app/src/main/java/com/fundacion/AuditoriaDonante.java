package com.fundacion;

import java.sql.Date;
import java.sql.Timestamp;

public class AuditoriaDonante {
    private int idAuditoria;
    private int dniDonante;
    private String nombreDonante;
    private String apellidoDonante;
    private String direccionDonante;
    private String emailDonante;
    private Date fechaNacimientoDonante;
    private String facebookDonante;
    private int codPostalDonante;
    private int telefonoFijoDonante;
    private int telefonoCelularDonante;
    private long cuilDonante;
    private String ocupacionDonante;
    private Timestamp fechaEliminacionDonante;
    private String usuario;


    public AuditoriaDonante(int idAuditoria, int dniDonante, String nombreDonante, String apellidoDonante, String direccionDonante,
                            String emailDonante, Date fechaNacimientoDonante, String facebookDonante, int codPostalDonante,
                            int telefonoFijoDonante, int telefonoCelularDonante, long cuilDonante, String ocupacionDonante,
                            Timestamp fechaEliminacionDonante, String usuario) {
        this.idAuditoria = idAuditoria;
        this.dniDonante = dniDonante;
        this.nombreDonante = nombreDonante;
        this.apellidoDonante = apellidoDonante;
        this.direccionDonante = direccionDonante;
        this.emailDonante = emailDonante;
        this.fechaNacimientoDonante = fechaNacimientoDonante;
        this.facebookDonante = facebookDonante;
        this.codPostalDonante = codPostalDonante;
        this.telefonoFijoDonante = telefonoFijoDonante;
        this.telefonoCelularDonante = telefonoCelularDonante;
        this.cuilDonante = cuilDonante;
        this.ocupacionDonante = ocupacionDonante;
        this.fechaEliminacionDonante = fechaEliminacionDonante;
        this.usuario = usuario;
    }

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public int getDniDonante() {
        return dniDonante;
    }

    public void setDniDonante(int dniDonante) {
        this.dniDonante = dniDonante;
    }

    public String getNombreDonante() {
        return nombreDonante;
    }

    public void setNombreDonante(String nombreDonante) {
        this.nombreDonante = nombreDonante;
    }

    public String getApellidoDonante() {
        return apellidoDonante;
    }

    public void setApellidoDonante(String apellidoDonante) {
        this.apellidoDonante = apellidoDonante;
    }

    public String getDireccionDonante() {
        return direccionDonante;
    }

    public void setDireccionDonante(String direccionDonante) {
        this.direccionDonante = direccionDonante;
    }

    public String getEmailDonante() {
        return emailDonante;
    }

    public void setEmailDonante(String emailDonante) {
        this.emailDonante = emailDonante;
    }

    public Date getFechaNacimientoDonante() {
        return fechaNacimientoDonante;
    }

    public void setFechaNacimientoDonante(Date fechaNacimientoDonante) {
        this.fechaNacimientoDonante = fechaNacimientoDonante;
    }

    public String getFacebookDonante() {
        return facebookDonante;
    }

    public void setFacebookDonante(String facebookDonante) {
        this.facebookDonante = facebookDonante;
    }

    public int getCodPostalDonante() {
        return codPostalDonante;
    }

    public void setCodPostalDonante(int codPostalDonante) {
        this.codPostalDonante = codPostalDonante;
    }

    public int getTelefonoFijoDonante() {
        return telefonoFijoDonante;
    }

    public void setTelefonoFijoDonante(int telefonoFijoDonante) {
        this.telefonoFijoDonante = telefonoFijoDonante;
    }

    public int getTelefonoCelularDonante() {
        return telefonoCelularDonante;
    }

    public void setTelefonoCelularDonante(int telefonoCelularDonante) {
        this.telefonoCelularDonante = telefonoCelularDonante;
    }

    public long getCuilDonante() {
        return cuilDonante;
    }

    public void setCuilDonante(long cuilDonante) {
        this.cuilDonante = cuilDonante;
    }

    public String getOcupacionDonante() {
        return ocupacionDonante;
    }

    public void setOcupacionDonante(String ocupacionDonante) {
        this.ocupacionDonante = ocupacionDonante;
    }

    public Timestamp getFechaEliminacionDonante() {
        return fechaEliminacionDonante;
    }

    public void setFechaEliminacionDonante(Timestamp fechaEliminacionDonante) {
        this.fechaEliminacionDonante = fechaEliminacionDonante;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
