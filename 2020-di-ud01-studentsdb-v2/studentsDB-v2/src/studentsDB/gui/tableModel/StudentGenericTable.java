/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsDB.gui.tableModel;

import java.util.List;

import studentsDB.dto.Student;

public class StudentGenericTable extends GenericTableModel<Student>{
	
	

    
	public StudentGenericTable(List columnIdentifiers) {
		super(columnIdentifiers);
	}
	
	
	
	@Override
	public Class<?> getColumnClass(int arg0) {
		switch(arg0) {
			case 0:return String.class;
			case 1:return String.class;
			case 2:return String.class;
			case 3:return Integer.class;
		
		}
		return null;
	}

	@Override
	public Object getValueAt(int row, int colum) {
		switch(colum) {
			case 0:
				return getDomainObject(row).getDni();
			case 1:
				return getDomainObject(row).getNome();
			case 2:
				return getDomainObject(row).getApelidos();
			case 3:
				return getDomainObject(row).getIdade();

		}
		return null ;
	}

	@Override
	public void setValueAt(Object arg0, int row, int colum) {
		switch(colum) {
			case 0:
				getDomainObject(row).setDni((String)arg0);
				break;
			case 1:
				getDomainObject(row).setNome((String)arg0);
				break;
			case 2:
				getDomainObject(row).setApelidos((String)arg0);
				break;
			case 3:
				getDomainObject(row).setIdade((int)arg0);;
				break;

		}	
		
	}
        
        public void actualizarTabla(List<Student> lista){
            
            
            clearTableModelData();
            addRows(lista);
        }

}

