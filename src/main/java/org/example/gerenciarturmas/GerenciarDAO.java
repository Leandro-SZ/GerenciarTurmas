package org.example.gerenciarturmas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciarDAO {

    public List<String> lerUsuario() {
        // 1. SQL corrigido: removido o '+', adicionado o 'ON' e ajustado o WHERE
        String sql = "SELECT ti.nome_instrutor, t.turno, i.id_instrutor " +
                "FROM rl_instrutor_turmas i " +
                "INNER JOIN tb_turmas t ON i.id_turma = t.id_turma " +
                "INNER JOIN tb_instrutor ti ON i.id_instrutor = ti.id_instrutor " +
                "WHERE i.id_instrutor = ?"; // Ajustei para buscar pelo nome do instrutor

        List<String> usuarios = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,  "1");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) { // Use 'while' se um instrutor puder ter várias turmas
                    // 2. Aqui você deve usar os nomes que estão no SELECT acima
                    String info = rs.getString("nome_instrutor") +
                            " | Turno: " + rs.getString("turno") +
                            " | ID: " + rs.getInt("id_instrutor");
                    IO.println(info);
                    usuarios.add(info);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário", e);
        }
        return usuarios;
    }
}
