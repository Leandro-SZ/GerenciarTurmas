package org.example.gerenciarturmas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GerenciarDAO {

    public ObservableList<UsuarioDTO> lerUsuariosParaTabela() {
        String sql = """
            SELECT t.turma, t.turno, ti.nome_instrutor
            FROM rl_instrutor_turmas i
            INNER JOIN tb_turmas t ON i.id_turma = t.id_turma
            INNER JOIN tb_instrutor ti ON i.id_instrutor = ti.id_instrutor
            """;

        ObservableList<UsuarioDTO> lista = FXCollections.observableArrayList();

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new UsuarioDTO(
                        rs.getString("turma"),
                        rs.getString("turno"),
                        rs.getString("nome_instrutor")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
