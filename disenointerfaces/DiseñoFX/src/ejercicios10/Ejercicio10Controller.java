/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author a19boscoso
 */
public class Ejercicio10Controller implements Initializable {

    @FXML
    private Label msg1;
    @FXML
    private Label msg2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pulsado(ActionEvent event) {
        msg1.setText("Estas en la pestaña 1");
    }

    @FXML
    private void pulsado2(ActionEvent event) {
        msg2.setText("Estas en la pestaña 2");
    }
    
}
