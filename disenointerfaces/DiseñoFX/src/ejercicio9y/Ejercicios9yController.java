/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9y;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.AbstractList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author Propietario
 */
public class Ejercicios9yController implements Initializable {

    @FXML
    private DatePicker dataPicker;
    @FXML
    private Label lbl;
    @FXML
    private ToggleGroup intocables;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Label labelColor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //dataPicker.setConverter(new LocalDateStringConverter(FormatStyle.LONG));
        
        dataPicker.setOnAction(e ->{
          
            lbl.setText(dataPicker.getValue().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        });
       
        
        
    }

    @FXML
    private void pulsado(ActionEvent event) {
        System.out.println("Accediendo a menus ");
    }

    @FXML
    private void colorea(ActionEvent event) {
        labelColor.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    
}
