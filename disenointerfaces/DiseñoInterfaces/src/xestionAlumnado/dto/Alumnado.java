package xestionAlumnado.dto;

import java.util.Vector;

public class Alumnado {
	private String nome;
	private String curso;
	
	public Alumnado(String nome, String curso) {
		this.nome = nome;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}
	public String getCurso() {
		return curso;
	}

	public String[] toArray() {
		return new String[] {nome,curso};
	}

	public void setNome(String nomeX) {
		this.nome=nomeX;
		
	}
	public void setCurso(String cursoX) {
		this.curso=cursoX;
		
	}
	
	
}
