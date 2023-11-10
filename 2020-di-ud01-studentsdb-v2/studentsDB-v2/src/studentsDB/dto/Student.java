package studentsDB.dto;

public class Student {

	private String dni;
	private String nome;
	private String apelidos;
	private int idade;

	public Student(String dni, String nome, String apelidos, int idade) {
		this.dni = dni;
		this.nome = nome;
		this.apelidos = apelidos;
		this.idade = idade;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDni() {
		return dni;
	}
	public String getNome() {
		return nome;
	}
	public String getApelidos() {
		return apelidos;
	}
	public int getIdade() {
		return idade;
	}
	
	
	
	
}
