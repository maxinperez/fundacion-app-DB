package com.fundacion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fundacion.AuditoriaDonante;

public class AuditoriaDonanteDAO {
    private Connection connection;
    public AuditoriaDonanteDAO(Connection connection) {
        this.connection = connection;
    }

    // Obtener un registro por id
    public AuditoriaDonante obtenerPorId(int idAuditoria) throws SQLException {
        AuditoriaDonante ad = null;
        String sql = "SELECT id_auditoria, dni_donante, fecha_eliminacion_donante, usuario " +
                     "FROM Auditoria_Donante WHERE id_auditoria = ?";
    
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAuditoria);
    
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ad = new AuditoriaDonante();
                    ad.setIdAuditoria(rs.getInt("id_auditoria"));
                    ad.setDniDonante(rs.getInt("dni_donante"));
                    ad.setFechaEliminacionDonante(rs.getTimestamp("fecha_eliminacion_donante"));
                    ad.setUsuario(rs.getString("usuario"));
                }
            }
        }
    
        return ad;
    }

    // Obtener todos los registros
    public List<AuditoriaDonante> listarTodos() throws SQLException {
        List<AuditoriaDonante> lista = new ArrayList<>();
        String sql = "SELECT id_auditoria, dni_donante, fecha_eliminacion_donante, usuario FROM Auditoria_Donante";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
             ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AuditoriaDonante ad = new AuditoriaDonante();
                ad.setIdAuditoria(rs.getInt("id_auditoria"));
                ad.setDniDonante(rs.getInt("dni_donante"));
                ad.setFechaEliminacionDonante(rs.getTimestamp("fecha_eliminacion_donante"));
                ad.setUsuario(rs.getString("usuario"));
                lista.add(ad);
            }
        }
        return lista;
    }
}
