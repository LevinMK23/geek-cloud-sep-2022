package com.geekbrains.sep22.geekcloudclient;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegController {

    @FXML
    private MFXTextField loginRegField;

    @FXML
    private MFXTextField passRegField;

    @FXML
    private MFXButton regOkBtn;
    Connection connection = null;
    PreparedStatement preparedStatement;
    String query = null;
    @FXML
    void regOkBtnClick(ActionEvent event) throws SQLException {
        String login = loginRegField.getText();
        String password = passRegField.getText();
        if (login.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        } else {
            query = "INSERT users (login, password) VALUE " + "('" + loginRegField.getText() + "', '" + passRegField.getText() + "');";
            connection = dbConnect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            Stage stage = (Stage) regOkBtn.getScene().getWindow();
            stage.close();
        }
    }
}
