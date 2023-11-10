package xestionClientes.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Cliente {
	private String nome;
	private String apelidos;
	private Date data;
	private String provincia;
	
	public Cliente(String nome, String apelidos, Date data, String provincia) {
		this.nome = nome;
		this.apelidos = apelidos;
		this.data = data;
		this.provincia = provincia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelidos() {
		return apelidos;
	}

	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}
	public Date getData() {
		 
		
		return this.data;
	}
//	public String getData2() {
//		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//		return data.toString();//sdf.format(data);
//	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public Object[] toArray() {
		return new Object[] {nome,apelidos,provincia,getData()};
	}
	
	
}
