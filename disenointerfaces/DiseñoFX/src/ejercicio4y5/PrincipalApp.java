/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4y5;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 *
 * @author Propietario
 */
public class PrincipalApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("ejercicio4.fxml"));
        stage.setTitle("Ejercicio 4");
        stage.setScene(new Scene(root));
        stage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}