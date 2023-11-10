/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labelPersonalizado;


/**
 *
 * @author Propietario
 */
public class JLabelRelojAlarma {
    
    private boolean alarma = false;
    private String hora;
    
    public JLabelRelojAlarma(boolean alarma,String hora){
        this.alarma=alarma;
        this.hora=hora;
    }
    public JLabelRelojAlarma(){
    }
    public boolean isAlarma() {
        return alarma;
    }

    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
    }



    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return hora;
    }
    
}
