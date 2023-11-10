/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labelPersonalizado;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Propietario
 */
public class JLabelRelojAlarmaPropertyEdittorSupport extends PropertyEditorSupport {
        
    private JLabelRelojAlarmaPanel labelAlarmaPanel=new JLabelRelojAlarmaPanel();
    
        @Override
	public boolean supportsCustomEditor() {
		return true;
	}
	
	@Override
	public Component getCustomEditor() {
		return labelAlarmaPanel;
	}
	
	@Override
	public Object getValue() {
		return labelAlarmaPanel.getSelectedValue();
	}
	
	@Override
	public String getJavaInitializationString() {
	
            JLabelRelojAlarma alarma= labelAlarmaPanel.getSelectedValue();
            return "new labelPersonalizado.JLabelRelojAlarma("+getStr(alarma.isAlarma())+",\""+alarma.getHora()+"\")";
	}	
        public String getStr(boolean a){
            if(a)return "true";
            return "false";
        }
}
