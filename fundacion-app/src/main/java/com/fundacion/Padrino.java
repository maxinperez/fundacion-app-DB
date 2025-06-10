package com.fundacion;
import java.sql.Date;
import java.util.Scanner;

public class Padrino {
    public int dni;
    public String nombre;
    public String apellido;
    public String direccion;
    public String email;
    public Date fechaNacimiento;
    public String facebook;
    public int codPostal;
    public String telefonoFijo;
    public String telefonoCelular;

   
     public Padrino() {
        try{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese DNI: ");
        this.dni = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese nombre: ");
        this.nombre = scanner.nextLine();

        System.out.print("Ingrese apellido: ");
        this.apellido = scanner.nextLine();

        System.out.print("Ingrese dirección: ");
        this.direccion = scanner.nextLine();

        System.out.print("Ingrese email: ");
        this.email = scanner.nextLine();

        System.out.print("Ingrese fecha de nacimiento (yyyy-mm-dd): ");
        String fechaNacimientoStr = scanner.nextLine();
        this.fechaNacimiento = Date.valueOf(fechaNacimientoStr); // convierte a java.sql.Date

        System.out.print("Ingrese Facebook: ");
        this.facebook = scanner.nextLine();

        System.out.print("Ingrese código postal: ");
        this.codPostal = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese teléfono fijo: ");
        this.telefonoFijo = scanner.nextLine();

        System.out.print("Ingrese teléfono celular: ");
        this.telefonoCelular = scanner.nextLine();
        } catch (NumberFormatException e) {
        System.err.println("Error: Entrada numérica inválida. Verifique DNI o Código Postal.");
    } catch (IllegalArgumentException e) {
        System.err.println("Error: Formato de fecha inválido. Use yyyy-mm-dd.");
    }
}
    public Padrino(int dni, String nombre, String apellido, String direccion, String email,
                   Date fechaNacimiento, String facebook, int codPostal,
                   String telefonoFijo, String telefonoCelular) {
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

    public String getTelefonoFijo() { return telefonoFijo; }
    public void setTelefonoFijo(String telefonoFijo) { this.telefonoFijo = telefonoFijo; }

    public String getTelefonoCelular() { return telefonoCelular; }
    public void setTelefonoCelular(String telefonoCelular) { this.telefonoCelular = telefonoCelular; }
}
