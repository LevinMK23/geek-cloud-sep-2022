package com.geekbrains.sep22.geekcloudclient;

import com.geekbrains.db.dbConnect;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

        query = "INSERT users (login, password) VALUE " + "('" + loginRegField.getText() + "', '" + passRegField.getText() + ");";
        connection = dbConnect.getConnect();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();

    }
}
