package xestionClientes.gui.editorYRender;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

public class MiCellEditor extends DefaultCellEditor{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JSpinner spinner;
    JSpinner.DefaultEditor editor;
    JTextField textField;
    boolean valueSet;


    public MiCellEditor() {
        super(new JTextField());

		
        
        spinner = new JSpinner(new SpinnerDateModel());
		spinner.setEditor(new JSpinner.DateEditor(spinner,"dd-MM-yyyy"));
        editor = ((JSpinner.DateEditor)spinner.getEditor());
        textField = editor.getTextField();
        textField.addFocusListener( new FocusListener() {
            public void focusGained( FocusEvent fe ) {

                SwingUtilities.invokeLater( new Runnable() {
                    public void run() {
                        if ( valueSet ) {
                            textField.setCaretPosition(1);
                        }
                    }
                });
            }
            public void focusLost( FocusEvent fe ) {
            }
        });
        textField.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                stopCellEditing();
            }
        });
    }


    public Component getTableCellEditorComponent( JTable table, Object value, boolean isSelected, int row, int column ) {
        if ( !valueSet ) {
            spinner.setValue(value);
        }
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                textField.requestFocus();
            }
        });
        return spinner;
    }

    public boolean isCellEditable( EventObject eo ) {

        if ( eo instanceof KeyEvent ) {
            KeyEvent ke = (KeyEvent)eo;
            textField.setText(String.valueOf(ke.getKeyChar()));

            valueSet = true;
        } else {
            valueSet = false;
        }
        return true;
    }


    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    public boolean stopCellEditing() {
        try {
            editor.commitEdit();
            spinner.commitEdit();
        } catch ( java.text.ParseException e ) {
            JOptionPane.showMessageDialog(null, "Invalid value, discarding.");
        }
        return super.stopCellEditing();
    }
}