package com.fundacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverM{
    private static final String URL = "jdbc:mysql://localhost:3306/fundacion?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "SimonSegundo";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a la base de datos");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Prueba la conexión
        conectar();
    }
}
