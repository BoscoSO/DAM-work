/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author a19boscoso
 */
public class Ejercicios1Controller implements Initializable {

    @FXML
    private Button btnMsgLable;
    @FXML
    private Label lblMsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    

    @FXML
    private void btnMsgLbl(ActionEvent event) {
        lblMsg.setText("Hola, Encantado de Conocerte");
    }

    @FXML
    private void btnSalir(ActionEvent event) {
        Platform.exit();
    }
    
}
