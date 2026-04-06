package org.example.gerenciarturmas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onBuscarTurmas(){
        GerenciarDAO dao = new GerenciarDAO();
        dao.lerUsuario();
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
