package xestionAlumnado.gui.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import xestionAlumnado.dto.Alumnado;

public class AlumnadoTableModel extends AbstractTableModel {
	
	private List<Alumnado> listaAlumnado;
	private String[] columnas = {"Nome", "Curso"};
	
	
	public AlumnadoTableModel(List<Alumnado> listaAlumnado) {
		this.listaAlumnado = listaAlumnado;
	}
	
	@Override
	public int getRowCount() {
		return listaAlumnado.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return listaAlumnado.get(rowIndex).getNome();
			case 1:
				return listaAlumnado.get(rowIndex).getCurso();
		}
		return null;
	}
		
	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}
}
