/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Propietario
 */
public class Ejercicio3Controller implements Initializable {

    private String[] nums = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private ArrayList<String> numeros =new ArrayList<String>();
    private int resAnterior;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(String n:nums)
            numeros.add(n);
    }

    @FXML
    private void btn(ActionEvent event) {
        Button btn = (Button) event.getSource();

        switch (btn.getText()) {

            case "x^2":
                break;
            case "x^3":
                break;
            case "ACL":
                break;
            case "AC":
                break;
            case "CE":
                break;
            case "=":
                procesarMierda(textArea.getText());
                break;
            default:
                textArea.appendText(btn.getText());
                break;

        }

    }

    private void procesarMierda(String cadena) {
        if (numeros.contains(cadena.charAt(0))){
            
        }else{
            textArea.setText("Operacion no reconocida");
        }

    }

}
