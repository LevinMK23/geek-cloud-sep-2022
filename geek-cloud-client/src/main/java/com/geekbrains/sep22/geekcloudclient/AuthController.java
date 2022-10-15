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

public class AuthController {

    @FXML
    private MFXButton authBtn;

    @FXML
    private MFXTextField loginField;

    @FXML
    private MFXTextField passField;

    @FXML
    void authBtnClick(ActionEvent event) {
        if () {

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("LOGIN or PASS is incorrect");
            alert.showAndWait();
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