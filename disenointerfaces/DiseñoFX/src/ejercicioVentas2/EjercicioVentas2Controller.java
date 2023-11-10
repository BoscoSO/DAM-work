/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVentas2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author a19boscoso
 */
public class EjercicioVentas2Controller implements Initializable {

    @FXML
    private TextArea areaTxt;
    @FXML
    private Label lblEscoge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        areaTxt.setText("Resultados:\n");
    }    

    @FXML
    private void showAlert(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.ERROR, "el fichero indicado no existe!");
        alert.setHeaderText("Fichero no encontrado");
        
        
        Label label = new Label("Se encontro lo siguiente:");
        TextArea textArea = new TextArea("Grandes errores han sido cometidos hasta aquí\n anda con mas cuidado");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        
        
        alert.getDialogPane().setExpandableContent(expContent);
        
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
           // ok pulsado           
        }
    }

    @FXML
    private void dialogoConfirm(ActionEvent event) {
        
       List<String> colors = List.of("Blanco", "Rojo", "Verde");
        ChoiceDialog choiceDialog = new ChoiceDialog<>("Rojo", colors);
        choiceDialog.setHeaderText("De que color es el caballo blanco de santiago?");
        choiceDialog.setContentText("Opciones: ");
        Optional<ButtonType> result =choiceDialog.showAndWait();
        if (result.isPresent() && colors.contains(result.get())) {
            String res=result.toString().substring(9, result.toString().length()-1);
            areaTxt.appendText("Usted escogio "+res+"\n");         
            if(res.equals("Blanco"))
                 areaTxt.appendText("-Acertaste-\n");
        }else
              areaTxt.appendText("Usted Cancelo\n");
    }

    @FXML
    private void dialogEscoge(ActionEvent event) {
        ButtonType btn1 = new ButtonType("AYER", ButtonData.LEFT);
        ButtonType btn2 = new ButtonType("HOY", ButtonData.YES);
        ButtonType btn3 = new ButtonType("MAÑANA", ButtonData.RIGHT);
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Pregunta trampa");
        dialog.setContentText("Cuando prefieres hacer las tareas?");
        dialog.getDialogPane().getButtonTypes().add(btn1);
        dialog.getDialogPane().getButtonTypes().add(btn2);
        dialog.getDialogPane().getButtonTypes().add(btn3);
        
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent()) {
            if(result.get().getButtonData()==ButtonData.LEFT)
                lblEscoge.setText("un poco tarde no crees?");
            if(result.get().getButtonData()==ButtonData.YES)
                lblEscoge.setText("Perfecto!");
            if(result.get().getButtonData()==ButtonData.RIGHT)
                lblEscoge.setText("vago...");
     
        }
        
    }

    @FXML
    private void dialogResponde(ActionEvent event) {
        
        Dialog d= new TextInputDialog();
        d.setTitle("Responde Sinceramente");
        d.setContentText("¿Cómo se llama tu abuela?");
          Optional<ButtonType> result = d.showAndWait();
        if (result.isPresent()) {
            lblEscoge.setText("Se llama "+result.toString().substring(9, result.toString().length()-1));
        }else {
             lblEscoge.setText("Usted Cancelo");
        }
    }

    private <T> List<T> getNodesOfType(Pane parent, Class<T> type) {
        List<T> elements = new ArrayList<>();
        for (Node node : parent.getChildren()) {
            if (node instanceof Pane) {
                elements.addAll(getNodesOfType((Pane) node, type));
            } else if (type.isAssignableFrom(node.getClass())) {
                //noinspection unchecked
                elements.add((T) node);
            }
        }
        return Collections.unmodifiableList(elements);
    }
    
    @FXML
    private void login(ActionEvent event) {
        
        
        Parent root;
        
        
        
        try {
            root = FXMLLoader.load(getClass().getResource("contentLogin.fxml"));  
           
            Dialog d=new Dialog();
            d.setResizable(false);
            
            ButtonType btn1 = new ButtonType("Login", ButtonData.OK_DONE);
                
               
            DialogPane dp=new DialogPane();
            dp.setContent(root);
            dp.getButtonTypes().addAll(ButtonType.CANCEL,btn1);
            TextField name= getNodesOfType(dp,TextField.class).get(0);
            PasswordField pssw= getNodesOfType(dp,PasswordField.class).get(0);
            
            Platform.runLater(() -> name.requestFocus());

            
            ImageView icon = new ImageView(this.getClass().getResource("icono_login.png").toString());
            icon.setFitHeight(48);
            icon.setFitWidth(48);
            
            
            
            d.setDialogPane(dp);
            
            d.setHeaderText("Un diálogo personalizado");
                     
            d.setGraphic(icon);
            d.setTitle("Login");
            
            d.setResultConverter((p) -> {
                if (p == btn1) {
                    return new Pair<>(name.getText(), pssw.getText().toCharArray());
                }
                return null;
            });
            
           
            
            Optional<ButtonType> result = d.showAndWait();
            
            if (result.isPresent()) {
                     lblEscoge.setText("Logeado correctamente como "+name.getText()+" | Pssw: "+pssw.getText());
            }else 
                   lblEscoge.setText("Login Cancelado");
            
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        
        
    }
    
}
