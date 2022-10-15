package com.geekbrains.sep22.geekcloudclient;

import com.geekbrains.db.dbConnect;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AuthController{

    @FXML
    private MFXButton authBtn;

    @FXML
    private MFXTextField loginField;

    @FXML
    private MFXTextField passField;
    Connection connection = null;

    @FXML
    void authBtnClick(ActionEvent event) throws SQLException, IOException {
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM users");
        while (result.next()) {
            if (loginField.getText().equals(result.getString("login")) &&
                    passField.getText().equals(result.getString("password"))) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("geek-cloud-client.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("LOGIN or PASS is incorrect");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void regBtnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("regFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}