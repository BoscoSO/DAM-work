/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Propietario
 */
public class Ejercicio7Controller implements Initializable {

    @FXML
    private ProgressBar barraProgress;
    private double progreso;
    @FXML
    private ToggleGroup gruppo1;
    @FXML
    private Label lblMsg;
    @FXML
    private ToggleGroup grupo2;
    @FXML
    private Rectangle rect;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progreso=barraProgress.getProgress();
    }    

    @FXML
    private void avanza(ActionEvent event) {
       if((progreso+0.1)>1)
            barraProgress.setProgress(1);
        else
           barraProgress.setProgress(progreso+0.1);
       
        progreso=barraProgress.getProgress();
    }

    @FXML
    private void retrocede(ActionEvent event) {
        if((progreso-0.1)<0)
            barraProgress.setProgress(0);
        else
            barraProgress.setProgress(progreso-0.1);
        progreso=barraProgress.getProgress();
    }

    @FXML
    private void changeSel(ActionEvent event) {
        
       String cadena=((RadioButton) gruppo1.getSelectedToggle()).getText();
       
       lblMsg.setText("Has seleccionado: "+cadena);
    }

    @FXML
    private void changeTogg(ActionEvent event) {
        if(grupo2.getSelectedToggle()!=null){
            String col=((ToggleButton)grupo2.getSelectedToggle()).getText();

            if(col.equals("Rojo")){
                rect.setFill(Color.RED);
            }else if(col.equals("Azul")){
                rect.setFill(Color.BLUE);
            }else if(col.equals("Amarilo")){
                rect.setFill(Color.YELLOW);
            }
        }else{
            rect.setFill(Color.WHITE);
        }
        
    }
    
}
