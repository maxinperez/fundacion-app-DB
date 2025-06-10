package com.fundacion.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fundacion.Padrino;

public class PadrinoDAO {

    private Connection connection;

    public PadrinoDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarPadrino(Padrino padrino) {
        String sql = "INSERT INTO Padrino (dni, nombre, apellido, direccion, email, fecha_nacimiento, facebook, cod_postal, telefono_fijo, telefono_celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, padrino.getDni());
            stmt.setString(2, padrino.getNombre());
            stmt.setString(3, padrino.getApellido());
            stmt.setString(4, padrino.getDireccion());
            stmt.setString(5, padrino.getEmail());
            stmt.setDate(6, (padrino.getFechaNacimiento()));
            stmt.setString(7, padrino.getFacebook());
            stmt.setInt(8, padrino.getCodPostal());
            stmt.setString(9, padrino.getTelefonoFijo());
            stmt.setString(10, padrino.getTelefonoCelular());
            stmt.executeUpdate();

            System.out.println("Padrino insertado correctamente.");

            // Elegir tipo de padrino (Donante o Contacto)
            Scanner scanner = new Scanner(System.in);
            System.out.print("¿Este padrino es Donante (D), Contacto (C) o ninguno (N)? ");
            String tipo = scanner.nextLine().trim().toUpperCase();

            switch (tipo) {
                case "D":
                    insertarComoDonante(padrino.getDni());
                    break;
                case "C":
                    insertarComoContacto(padrino.getDni());
                    break;
                case "N":
                    System.out.println("El padrino fue insertado sin rol adicional.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertarComoDonante(int dni) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese CUIL: ");
        long cuil = sc.nextLong();
        sc.nextLine();
        System.out.print("Ingrese ocupación (puede estar vacía): ");
        String ocupacion = sc.nextLine();

        String sql = "INSERT INTO Donante (dni_donante, cuil, ocupacion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dni);
            stmt.setLong(2, cuil);
            stmt.setString(3, ocupacion.isEmpty() ? null : ocupacion);
            stmt.executeUpdate();
            System.out.println("Donante insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertarComoContacto(int dni) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fecha alta (YYYY-MM-DD): ");
        Date fechaAlta = Date.valueOf(sc.nextLine());
        System.out.print("Fecha primer contacto (YYYY-MM-DD): ");
        Date fechaPrimerContacto = Date.valueOf(sc.nextLine());
        System.out.print("Estado (Sin llamar, Error, En gestion, Adherido, Amigo, No acepta, Baja, Voluntario): ");
        String estado = sc.nextLine();

        String sql = "INSERT INTO Contacto (dni_contacto, fecha_alta, fecha_primer_contacto, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dni);
            stmt.setDate(2, fechaAlta);
            stmt.setDate(3, fechaPrimerContacto);
            stmt.setString(4, estado);
            stmt.executeUpdate();
            System.out.println("Contacto insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarPorDni(int dni) throws SQLException {
        String sql = "DELETE FROM donante WHERE dni_donante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dni);
            int filas = stmt.executeUpdate();// devuelve las filas afectadas
            return filas > 0;// por eso si afecto mas de una.. es porque se borro el padrino.
        }
    }

    public Padrino obtenerPorDni(int dni) throws SQLException {
        String sql = "SELECT * FROM padrino WHERE dni = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Padrino p = new Padrino();
                p.setDni(rs.getInt("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                // aca podriamos agregar mas setters de padrino.
                return p;
            }
        }
        return null;
    }

    public List<Padrino> obtenerTodos() throws SQLException {
        List<Padrino> padrinos = new ArrayList<>();
        String sql = "SELECT * FROM padrino";
        try (Statement stmt = connection.createStatement()) {// se usa statement porque no hay que traer atributos.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Padrino p = new Padrino();
                p.setDni(rs.getInt("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                padrinos.add(p);
            }
        }
        return padrinos;
    }
    public void listarPadrinosConProgramas() {
        String sql = "SELECT p1.dni, p1.nombre, p1.apellido, a.id_programa_aporta, a.monto, a.frecuencia, p.nombre AS nombre_programa " +
                     "FROM Padrino AS p1 " +
                     "INNER JOIN Aporta AS a ON a.dni_aporta = p1.dni " +
                     "INNER JOIN Programa AS p ON a.id_programa_aporta = p.id_programa " +
                     "ORDER BY p1.dni";
    
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                System.out.println(
                    " El padrino " + rs.getString("nombre") + " " +
                     rs.getString("apellido") + " " + "con el DNI  " + rs.getInt("dni") +
                    ", aporta al programa " + rs.getString("nombre_programa") +
                    " un monto de " + rs.getInt("monto") +
                    " con frecuencia " + rs.getString("frecuencia"));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 }

