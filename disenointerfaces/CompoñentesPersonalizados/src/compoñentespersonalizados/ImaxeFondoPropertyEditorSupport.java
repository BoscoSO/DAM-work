/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoñentespersonalizados;


import java.awt.Component;
import java.beans.PropertyEditorSupport;

public class ImaxeFondoPropertyEditorSupport extends PropertyEditorSupport {

	private ImaxeFondoPanel imaxeFondoPanel= new ImaxeFondoPanel();
	@Override
	public boolean supportsCustomEditor() {
		return true;
	}
	
	@Override
	public Component getCustomEditor() {
		return imaxeFondoPanel;
	}
	
	@Override
	public Object getValue() {
		return imaxeFondoPanel.getSelectedValue();
	}
	
	@Override
	public String getJavaInitializationString() {
	
		ImaxeFondo imaxeFondo = imaxeFondoPanel.getSelectedValue();
		return "new compoñentespersonalizados.ImaxeFondo(new java.io.File(\""+imaxeFondo.getRuta().getAbsolutePath()+"\"),"+ imaxeFondo.getOpacidade()+"f)";
	
	}	
	
}
