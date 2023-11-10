/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.net.URL;
import java.util.ResourceBundle;
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
public class HellowfxController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private Button btn1;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java "
                       + javaVersion+ ".");
        
    }    

    @FXML
    private void buttonClicked(ActionEvent event) {
        System.out.println("ehyy");
    }
    
}
