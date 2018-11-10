package NewEntry;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewEntryController implements Initializable{

    @FXML private JFXButton addentry, clear, cancel;
    @FXML private JFXTextField username, urladdress;
    @FXML private JFXPasswordField password;
    //needs to use enum  @FXML private JFXComboBox<>;
    public void initialize(URL url, ResourceBundle rb)
    {

    }



    @FXML
    private void clearFields(ActionEvent event)
    {
        username.setText("");
        urladdress.setText("");
        password.setText("");
    }

    @FXML
    private void Exit(ActionEvent event)
    {

       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure you want to close?");
        alert.initStyle(StageStyle.UNDECORATED);
        alert.getDialogPane().setBackground((new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY))));
        //alert.showAndWait();
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()== ButtonType.OK)
        {
        Stage stage = (Stage) this.username.getScene().getWindow();
        stage.close();
        }
        if(result.get()==ButtonType.CANCEL){
            alert.close();
        }



}}
