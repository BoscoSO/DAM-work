package studentsDB.gui.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import studentsDB.dto.Student;

public class AlumnadoTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Student> listaAlumnado;
	private String[] columnas = {"Dni", "Nome","Apelidos","Idade"};
	
	
	public AlumnadoTableModel(List<Student> listaAlumnado) {
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
				return listaAlumnado.get(rowIndex).getDni();
			case 1:
				return listaAlumnado.get(rowIndex).getNome();
			case 2:
				return listaAlumnado.get(rowIndex).getApelidos();
			case 3:
				return listaAlumnado.get(rowIndex).getIdade();
		}
		return null;
	}
		
	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}
}
