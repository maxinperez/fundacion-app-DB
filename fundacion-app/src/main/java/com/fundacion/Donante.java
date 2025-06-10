package com.fundacion;
import java.sql.Date;

public class Donante extends Padrino{
    private long cuil;
    private String ocupacion;


     public Donante(int dni, String nombre, String apellido, String direccion, String email, Date fechaNacimiento,
                   String facebook, int codPostal, String telefonoFijo, String telefonoCelular,
                   long cuil, String ocupacion) {
        super(dni, nombre, apellido, direccion, email, fechaNacimiento, facebook, codPostal, telefonoFijo, telefonoCelular);
        this.cuil = cuil;
        this.ocupacion = ocupacion;
    }
    

    public long getCuil() { return cuil; }
    public void setCuil(long cuil) { this.cuil = cuil; }

    public String getOcupacion() { return ocupacion; }
    public void setOcupacion(String ocupacion) { this.ocupacion = ocupacion; }
}
