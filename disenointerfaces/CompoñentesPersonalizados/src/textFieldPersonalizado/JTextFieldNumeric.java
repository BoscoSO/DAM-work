/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textFieldPersonalizado;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author a19boscoso
 */
public class JTextFieldNumeric extends JTextField{
    boolean numeric=false;
    
    public JTextFieldNumeric() {
        init();
    }
    
    public JTextFieldNumeric(boolean num) {
          this.numeric=num;
          init();
    }  
        
    public boolean isNumeric() {
        return numeric;
    }

    public void setNumeric(boolean numeric) {
        this.numeric = numeric;
    }
    
     private void init(){
         
         addKeyListener(new KeyAdapter() {
             @Override
             public void keyTyped(KeyEvent e) {
                if(numeric){
                    char car = e.getKeyChar();
                    if((car<'0' || car>'9') && (car<',' || car>'.')) 
                        e.consume();
                }
             }         
         });
    }
}    