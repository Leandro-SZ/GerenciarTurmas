package org.example.gerenciarturmas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private TableView<UsuarioDTO> tabelaUsuarios;
    @FXML
    private TableColumn<UsuarioDTO, String> colTurma;
    @FXML
    private TableColumn<UsuarioDTO, String> colTurno;
    @FXML
    private TableColumn<UsuarioDTO, String> colInstrutor;

    public void initialize() {
        // Vincula a coluna ao atributo da classe UsuarioDTO
        colTurma.setCellValueFactory(new PropertyValueFactory<>("turma"));
        colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        colInstrutor.setCellValueFactory(new PropertyValueFactory<>("nomeInstrutor"));

        // Carrega os dados
        GerenciarDAO dao = new GerenciarDAO();
        tabelaUsuarios.setItems(dao.lerUsuariosParaTabela());
    }

}

