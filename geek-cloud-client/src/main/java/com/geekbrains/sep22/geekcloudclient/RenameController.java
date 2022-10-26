package com.geekbrains.sep22.geekcloudclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class RenameController implements Initializable {
    private String newFileName = null;
    private boolean isRenamed = false;

    @FXML
    private Button applyBtn;

    @FXML
    private Button closeBtn;
    @FXML
    private TextField newNameField;

    public void init(String fileName){
        newNameField.setText(fileName);
    }

    @FXML
    void applyBtnClick(ActionEvent event) {
        isRenamed = true;
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void closeBtnClick(ActionEvent event) {
        isRenamed = false;
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    public boolean getModalResult() {
        return isRenamed;
    }

    public String getNewName(){
        return newNameField.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
