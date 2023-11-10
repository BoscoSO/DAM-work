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
public class JLabelRelojPropertyEdittorSupport  extends PropertyEditorSupport {
        
    private JLabelRelojPanel labelRelojPanel= new JLabelRelojPanel();

        @Override
	public boolean supportsCustomEditor() {
		return true;
	}
	
	@Override
	public Component getCustomEditor() {
		return labelRelojPanel;
	}
	
	@Override
	public Object getValue() {
		return labelRelojPanel.getSelectedValue();
	}
	
	@Override
	public String getJavaInitializationString() {
	
            boolean b= labelRelojPanel.getSelectedValue();
            
            if(b)return "true";
            
            return "false";
	
	}	
}
