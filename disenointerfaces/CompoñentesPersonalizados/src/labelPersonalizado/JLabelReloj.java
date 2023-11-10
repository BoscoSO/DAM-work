/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labelPersonalizado;

import javax.swing.JLabel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 *
 * @author Propietario
 */
public class JLabelReloj extends JLabel {

    private DateTimeFormatter formateador;
    private boolean alarmaOn=false;
            
    boolean formato24 = false;
    JLabelRelojAlarma alarma;
    
    
    public JLabelReloj() {
        init();
    } 
    public JLabelReloj(boolean formato24,boolean alarma) {
        this.formato24=formato24;
        format();
        init();
    } 
    public boolean isFormato24() {
        return formato24;
    }
    public void setFormato24(boolean formato24) {
        this.formato24 = formato24;
        format();
    }

    public JLabelRelojAlarma getAlarma() {
        return alarma;
    }

    public void setAlarma(JLabelRelojAlarma alarma) {
        this.alarma = alarma;
        alarmaOn=alarma.isAlarma();
        
    }

    private void format(){
         if (formato24) {
            formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        } else {
            formateador = DateTimeFormatter.ofPattern("hh:mm:ss");
        }
    }
    private void init() {
        
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        
        format();
       
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        String hora=formateador.format(LocalDateTime.now());
                        setText(hora);
                        if(alarmaOn){
                            if(hora.equals(alarma.getHora())){
                                System.out.println("YA ES HORA");
                                alarma.setAlarma(false); alarmaOn=false;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

}
