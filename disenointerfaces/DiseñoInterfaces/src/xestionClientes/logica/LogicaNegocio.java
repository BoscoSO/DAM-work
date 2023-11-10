package xestionClientes.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xestionClientes.dto.Cliente;

public class LogicaNegocio {


	private static List<Cliente> clientes=new ArrayList<Cliente>(); 
	

	public static void añadirCliente(Cliente cl) {	
		clientes.add(cl);
	}
	
	public static List<Cliente> getListClients(){
		return clientes;
	}
	public static void modCliente(String nome, String apelidos, Date data, String provincia,int i) {
		clientes.get(i).setNome(nome);
		clientes.get(i).setApelidos(apelidos);
		clientes.get(i).setData(data);
		clientes.get(i).setProvincia(provincia);
	}
}
