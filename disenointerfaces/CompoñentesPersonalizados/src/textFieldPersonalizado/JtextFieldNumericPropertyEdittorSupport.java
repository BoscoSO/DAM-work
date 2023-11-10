/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textFieldPersonalizado;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author a19boscoso
 */
public class JtextFieldNumericPropertyEdittorSupport extends PropertyEditorSupport {
  
    
    private JTextFieldNumericPanel textFieldEditor= new JTextFieldNumericPanel();

        @Override
	public boolean supportsCustomEditor() {
		return true;
	}
	
	@Override
	public Component getCustomEditor() {
		return textFieldEditor;
	}
	
	@Override
	public Object getValue() {
		return textFieldEditor.getSelectedValue();
	}
	
	@Override
	public String getJavaInitializationString() {
	
            boolean b= textFieldEditor.getSelectedValue();
            
            if(b)return "true";
            
            return "false";
	
	}	
}
