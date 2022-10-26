package com.geekbrains.sep22.geekcloudclient;


import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthController{

    @FXML
    private MFXButton authBtn;

    @FXML
    private MFXTextField loginField;

    @FXML
    private MFXTextField passField;
    Connection connection = null;
    boolean check = false;

    @FXML
    void authBtnClick(ActionEvent event) throws SQLException, IOException {
        if (checkUser() == true) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("geek-cloud-client.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Check LOGIN or PASS");
            alert.showAndWait();
        }
    }

    public boolean checkUser() throws SQLException {
        connection = dbConnect.getConnect();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1 FROM users where login=? and password=?")) {
            preparedStatement.setString(1, loginField.getText());
            preparedStatement.setString(2, passField.getText());
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    check = true;
                } else {
                    check = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
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