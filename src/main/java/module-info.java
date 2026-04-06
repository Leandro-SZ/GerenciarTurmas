module org.example.gerenciarturmas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.example.gerenciarturmas to javafx.fxml;
    exports org.example.gerenciarturmas;
}