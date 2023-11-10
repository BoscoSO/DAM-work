package xestionAlumnado.logica;

import java.util.ArrayList;
import java.util.List;

import xestionAlumnado.dto.Alumnado;

public class LogicaAlumnos {


	private static List<Alumnado> alumnos=new ArrayList<Alumnado>(); 
	
	public LogicaAlumnos() {
		alumnos.add(new Alumnado("AAAA", "1111"));
		alumnos.add(new Alumnado("BBBB", "2222"));
		alumnos.add(new Alumnado("CCCC", "3333"));
		alumnos.add(new Alumnado("DDDD", "4444"));
	}

	public static void añadirAlumno(Alumnado cl) {	
		alumnos.add(cl);
	}
	
	public static List<Alumnado> getListAlumnado(){
		return alumnos;
	}
	public static void modAlumno(String nome,String curso,int index) {
		alumnos.get(index).setNome(nome);
		alumnos.get(index).setCurso(curso);
	}
	
}
