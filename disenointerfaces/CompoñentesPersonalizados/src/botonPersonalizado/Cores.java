/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonPersonalizado;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Propietario
 */
public class Cores  implements Serializable {
    private Color corText;
    private Color corFond;
    
    
    public Cores(){

    }
    public Cores(Color corText, Color corFond) {
        this.corText = corText;
        this.corFond = corFond;
    }
    
    public Color getCorText() {
        return corText;
    }

    public void setCorText(Color corText) {
        this.corText = corText;
    }

    public Color getCorFond() {
        return corFond;
    }

    public void setCorFond(Color corFond) {
        this.corFond = corFond;
    }

    @Override
    public String toString() {
        return "Cores";
    }
    
}
