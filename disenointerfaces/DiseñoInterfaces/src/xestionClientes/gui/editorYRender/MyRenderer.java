package xestionClientes.gui.editorYRender;

import java.awt.Component;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
public class MyRenderer extends JLabel implements TableCellRenderer {
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

   public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row,int col) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
      
      String s = "";
      
//      if (col == 3) {
    	  DateFormat dForm= new SimpleDateFormat("dd/MM/yyyy");
    	  Date  d=(Date) value;
    	  
  		
    	  s = dForm.format(d);
         
		 c = renderer.getTableCellRendererComponent(table, s,isSelected, hasFocus, row, col);
		
         
//      }


//	   if (value instanceof Date) {
//		   value = f.format(value);
//	   }
//	   
//	    c=renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	   return c;
	   

	   
   }
}