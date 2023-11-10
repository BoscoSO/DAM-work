/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Propietario
 */
public class PrincipalApp  extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("ejercicio7.fxml"));
        stage.setTitle("Ejercicio 7");
        stage.setScene(new Scene(root));
        stage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}