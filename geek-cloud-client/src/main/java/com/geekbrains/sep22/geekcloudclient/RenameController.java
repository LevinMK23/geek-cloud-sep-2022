package com.geekbrains.sep22.geekcloudclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

public class RenameController{

    @FXML
    private Button applyBtn;

    @FXML
    private Button closeBtn;

    @FXML
    private TextField newNameField;
    CloudMainController cloudMainController = new CloudMainController();

    @FXML
    void applyBtnClick(ActionEvent event) {

    }

    @FXML
    void closeBtnClick(ActionEvent event) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

}
