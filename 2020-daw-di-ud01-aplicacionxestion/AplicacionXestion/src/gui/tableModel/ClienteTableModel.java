package xestionClientes.gui.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import xestionClientes.dto.Cliente;

public class ClienteTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Cliente> listaClientes;
	private String[] columnas = {"Nome", "Apelidos","Data de alta","Provincia"};
	
	
	public ClienteTableModel(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	@Override
	public int getRowCount() {
		return listaClientes.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return listaClientes.get(rowIndex).getNome();
			case 1:
				return listaClientes.get(rowIndex).getApelidos();
			case 2:
				return listaClientes.get(rowIndex).getData();
			case 3:
				return listaClientes.get(rowIndex).getProvincia();
		}
		return null;
	}
		
	@Override
	public String getColumnName(int column) {
		if(column>=columnas.length && column<0)
			throw new IndexOutOfBoundsException();
		
		return columnas[column];
		
	}
	@Override
	public boolean isCellEditable(int row,int colum) {
		return true;
	}
	
}
