/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author a19boscoso
 */
public class HelloWorld extends Application{
// ruta CLASE
    // /home/SANCLEMENTE/a19boscoso/A19Boscoso/DI/SDK_FX/openjfx-11.0.2_linux-x64_bin-sdk/javafx-sdk-11.0.2/lib
//ruta CASA
    // "D:\Propietario\SanClemente\DAM2\DI\software\JavaFX11\javafx-sdk-11.0.2\lib"
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hellowfx.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
