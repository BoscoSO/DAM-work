/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTableView;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author a19boscoso
 */
public class PrincipalApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("ejercicioTableView.fxml"));
        stage.setTitle("Ejercicio Table View");
        stage.setScene(new Scene(root));
        stage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}