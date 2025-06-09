package com.fundacion;
import java.sql.Date;

public class Padrino {
    public int dni;
    public String nombre;
    public String apellido;
    public String direccion;
    public String email;
    public Date fechaNacimiento;
    public String facebook;
    public int codPostal;
    public int telefonoFijo;
    public int telefonoCelular;


    public Padrino(int dni, String nombre, String apellido, String direccion, String email,
                   Date fechaNacimiento, String facebook, int codPostal,
                   int telefonoFijo, int telefonoCelular) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.facebook = facebook;
        this.codPostal = codPostal;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
    }

    // Getters y Setters
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getFacebook() { return facebook; }
    public void setFacebook(String facebook) { this.facebook = facebook; }

    public int getCodPostal() { return codPostal; }
    public void setCodPostal(int codPostal) { this.codPostal = codPostal; }

    public int getTelefonoFijo() { return telefonoFijo; }
    public void setTelefonoFijo(int telefonoFijo) { this.telefonoFijo = telefonoFijo; }

    public int getTelefonoCelular() { return telefonoCelular; }
    public void setTelefonoCelular(int telefonoCelular) { this.telefonoCelular = telefonoCelular; }
}
