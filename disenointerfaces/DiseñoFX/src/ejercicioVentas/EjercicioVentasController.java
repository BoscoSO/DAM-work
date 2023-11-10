/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVentas;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author a19boscoso
 */
public class EjercicioVentasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modalNone(ActionEvent event) {
        Stage stg= new Stage();
        stg.initModality(Modality.NONE);
        Button b=(Button)event.getSource();
        
        stg.initOwner(b.getScene().getWindow());
        stg.showAndWait();
    }

    @FXML
    private void modalWindow(ActionEvent event) {
        Stage stg= new Stage();
        stg.initModality(Modality.WINDOW_MODAL);
        Button b=(Button)event.getSource();
        
        stg.initOwner(b.getScene().getWindow());
        stg.showAndWait();
    }

    @FXML
    private void modalApp(ActionEvent event) {
        Stage stg= new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        Button b=(Button)event.getSource();
        
        stg.initOwner(b.getScene().getWindow());
        stg.showAndWait();
    }

    @FXML
    private void alert_info(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION, "Here is some information..");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
           // ok pulsado           
        }
        
    }

    @FXML
    private void alert_warning(ActionEvent event) {
        Alert alert = new Alert(AlertType.WARNING, "esto es un aviso, anda con ojo");
        alert.setHeaderText("Ten Cuidado!!!!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
           // ok pulsado           
        }
    }

    @FXML
    private void alert_error(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR, "this is an error");
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
           // ok pulsado           
        }
    }
    
}
