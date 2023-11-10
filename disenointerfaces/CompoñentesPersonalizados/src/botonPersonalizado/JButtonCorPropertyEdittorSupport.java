/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonPersonalizado;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Propietario
 */
public class JButtonCorPropertyEdittorSupport extends PropertyEditorSupport {
    
    private JButtonPanel editorCores= new JButtonPanel();
	@Override
	public boolean supportsCustomEditor() {
		return true;
	}
	
	@Override
	public Component getCustomEditor() {
		return editorCores;
	}
	
	@Override
	public Object getValue() {
		return editorCores.getSelectedValue();
	}
	
	@Override
	public String getJavaInitializationString() {
	
		Cores cores = editorCores.getSelectedValue();
		return "new botonPersonalizado.Cores("+
                        "new java.awt.Color("+cores.getCorText().getRed()+","+cores.getCorText().getGreen()+","+cores.getCorText().getBlue()+"),"+
                        "new java.awt.Color("+cores.getCorFond().getRed()+","+cores.getCorFond().getGreen()+","+cores.getCorFond().getBlue()+"))";
	
	}	
	
}
