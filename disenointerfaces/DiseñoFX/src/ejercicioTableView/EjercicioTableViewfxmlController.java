/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTableView;

import ejercicioTableView.dto.Alumno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author a19boscoso
 */
public class EjercicioTableViewfxmlController implements Initializable {

    @FXML
    private TableView<Alumno> tabla;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellido;
    @FXML
    private TextField campoCorreo;
    @FXML
    private Label msgError;
    private ObservableList<Alumno> data = FXCollections.observableArrayList(new Alumno("Bosco","Suarez","bosco@mail.com"),new Alumno("Aurora","Voreal","aurora@mail.com"));
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        tabla.setEditable(true);
        
        TableColumn<Alumno, String> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Alumno, String> column2 = new TableColumn<>("Apellido");
        column2.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        TableColumn<Alumno, String> column3 = new TableColumn<>("Correo");
        column3.setCellValueFactory(new PropertyValueFactory<>("correo"));
        
        
        column1.setCellFactory(TextFieldTableCell.forTableColumn());
        column1.setOnEditCommit(
                new EventHandler<CellEditEvent<Alumno, String>>() {
                    @Override
                    public void handle(CellEditEvent<Alumno, String> t) {
                        ((Alumno) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                                ).setNombre(t.getNewValue());
                    }
                }
        );
        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(
                new EventHandler<CellEditEvent<Alumno, String>>() {
                    @Override
                    public void handle(CellEditEvent<Alumno, String> t) {
                        ((Alumno) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                                ).setApellido(t.getNewValue());
                    }
                }
        );
        column3.setCellFactory(TextFieldTableCell.forTableColumn());
        column3.setOnEditCommit(
                new EventHandler<CellEditEvent<Alumno, String>>() {
                    @Override
                    public void handle(CellEditEvent<Alumno, String> t) {
                        ((Alumno) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                                ).setCorreo(t.getNewValue());
                    }
                }
        );
        tabla.getColumns().add(column1);
        tabla.getColumns().add(column2);
        tabla.getColumns().add(column3);
        tabla.setItems(data);
        
        
        
        
    }    

    @FXML
    private void altaAlumno(ActionEvent event) {
        msgError.setText("");
        String n=campoNombre.getText();
        String a=campoApellido.getText();
        String c=campoCorreo.getText();
        if(!c.isBlank() || !a.isBlank() || !c.isBlank()){
            if(data==null)
                data  = FXCollections.observableArrayList(new Alumno(n,a,c));
            else
                data.add(new Alumno(n,a,c));

            tabla.setItems(data);
        
            
            
            campoNombre.setText("");
            campoApellido.setText("");
            campoCorreo.setText("");
        }else
            msgError.setText("Revisa los valores introducidos");
        
        
    }
    
}
