/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4y5;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Propietario
 */
public class Ejercicio4Controller implements Initializable {

    @FXML
    private CheckBox btnChk;
    
    @FXML
    private Slider slider;
    
    
    @FXML
    private ImageView imgMudo;
    @FXML
    private ImageView imgBajo;
    @FXML
    private ImageView imgMedio;
    @FXML
    private ImageView imgAlto;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label lblChoice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBox.setItems(FXCollections.observableArrayList("Elemento 1", "Elemento 2", "Elemento 3"));
        
        
        choiceBox.valueProperty().addListener(new  ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                  lblChoice.setText(choiceBox.getValue());
            }
        });
        
        
        
        slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
               
                 setImgVol(slider.getValue());
            }
        }
        );
                
        
    }

    @FXML
    private void chkBox(ActionEvent event) {
        
         Stage s=(Stage) btnChk.getScene().getWindow();
        
               
        if (btnChk.isSelected()) {
            s.setTitle("");
            btnChk.setText("Muestra título");
        } else {
            s.setTitle("Ejercicio 4");
            btnChk.setText("Oculta título");
        }
    }


    private void setImgVol(double value){
        
            imgMudo.setVisible(false);
            imgBajo.setVisible(false);
            imgMedio.setVisible(false);
            imgAlto.setVisible(false);
        if(value<2){
            imgMudo.setVisible(true);
        }else if(value<30){
            imgBajo.setVisible(true);
        }else if(value<70){
            imgMedio.setVisible(true);
        }else  imgAlto.setVisible(true);
    }




}
