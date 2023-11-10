/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonPersonalizado;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Propietario
 */
public class JButtonCor extends JButton implements Serializable {
    private Cores cores;
    private Cores coresHover;

    public JButtonCor() {
        init();
    }

    public JButtonCor( Cores cores2) {
        cores=cores2;
        init();
    }

    public void setCores(Cores cores) {
        this.cores = cores;
        
        setForeground(cores.getCorText());
        
        setBackground(cores.getCorFond());
    }
    public Cores getCores() {
        return cores;
    }

    public Cores getCoresHover() {
        return coresHover;
    }

    public void setCoresHover(Cores coresHover) {
        this.coresHover = coresHover;
        
    }
    
    public void init(){
        this.addMouseListener(new MouseAdapter() {
           
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(coresHover!=null){
                    if(coresHover.getCorFond()!=null)
                        setBackground(coresHover.getCorFond());
                    if(coresHover.getCorText()!=null)
                        setForeground(coresHover.getCorText());
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); 
                if(cores!=null){
                    if(cores.getCorFond()!=null)
                        setBackground(cores.getCorFond());
                    if(cores.getCorText()!=null)
                        setForeground(cores.getCorText());
                }
            }
            
        });
    }
    
    



   

    
    
    
    
}
