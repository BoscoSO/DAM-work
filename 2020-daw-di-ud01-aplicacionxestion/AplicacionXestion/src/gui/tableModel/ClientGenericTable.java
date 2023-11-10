package xestionClientes.gui.tableModel;

import java.util.Date;
import java.util.List;

import xestionClientes.dto.Cliente;

public class ClientGenericTable extends GenericTableModel<Cliente>{
	
	

    
	public ClientGenericTable(List columnIdentifiers) {
		super(columnIdentifiers);
	}
	
	
	
	@Override
	public Class<?> getColumnClass(int arg0) {
		switch(arg0) {
			case 0:return String.class;
			case 1:return String.class;
			case 2:return Date.class;
			case 3:return String.class;
		
		}
		return null;
	}

	@Override
	public Object getValueAt(int row, int colum) {
		switch(colum) {
			case 0:
				return getDomainObject(row).getNome();
			case 1:
				return getDomainObject(row).getApelidos();
			case 2:
				return getDomainObject(row).getData();
			case 3:
				return getDomainObject(row).getProvincia();

		}
		return null ;
	}

	@Override
	public void setValueAt(Object arg0, int row, int colum) {
		switch(colum) {
			case 0:
				getDomainObject(row).setNome((String)arg0);
				break;
			case 1:
				getDomainObject(row).setApelidos((String)arg0);
				break;
			case 2:
				getDomainObject(row).setData((Date)arg0);
				break;
			case 3:
				getDomainObject(row).setProvincia((String)arg0);;
				break;

		}	
		
	}

}
