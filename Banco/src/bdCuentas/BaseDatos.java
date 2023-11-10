package bdCuentas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cuenta.Cliente;
import cuenta.Cuenta;
import cuenta.MovimientoException;

public class BaseDatos implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Map<String,Cliente> clientesBD= new HashMap<>();
    private Map<String,Cuenta> cuentasBD= new HashMap<>();
    

    
    public boolean trasferir(BigDecimal i, String ibanDestino) throws BaseDatosException, MovimientoException {
		if(cuentasBD.containsKey(ibanDestino)) {
			cuentasBD.get(ibanDestino).ingresar(i);
			return true;
		}else {
			return false;
		}
		
	}   
    
	
	public void añadirCuenta(Cuenta c) {
		String iban=c.getIBAN();
		cuentasBD.put(iban, c);
		
	}
	public void eliminarCuenta(String key) {
		for(Map.Entry<String, Cliente> cliente : clientesBD.entrySet()) {
			cliente.getValue().eliminarCuenta(key);
		}
		this.cuentasBD.remove(key);	
	}
	public String verTodasCuentas() { 
		String cadena="";
		
		List<Cuenta> ordenado = new ArrayList<>(cuentasBD.values()); 
		Collections.sort(ordenado);
		int i=0;
		
		while(i<ordenado.size()) {
			cadena+=ordenado.get(i).getInfo()+"\n";
			i++;
		}
		
		return cadena;
	}
	
	public void añadirCliente(Cliente c) {
		String dni=c.getDni();
		clientesBD.put(dni, c);
	} 
	public void eliminarCliente(String key) {
		this.clientesBD.remove(key);	
	}
	public String verTodosClientes() {
		String cadena="";
		
		List<Cliente> ordenado = new ArrayList<>(clientesBD.values()); 
		Collections.sort(ordenado);
		int i=0;
		
		while(i<ordenado.size()) {
			cadena+=ordenado.get(i).getInfo(true)+"\n";
			i++;
		}
		
		return cadena;
	}
	
	public void comprobarDatos(String dni, String iban) throws BaseDatosException {
		dni=dni.toLowerCase();
		
		if(clientesBD.containsKey(dni)) {
			throw new BaseDatosException("Este dni ya esta en uso");
		}
		if(cuentasBD.containsKey(iban)) {
			throw new BaseDatosException("Este iban ya pertenece a una cuenta");
		}
							
			
	}
	public Cuenta getCuenta(String iban) throws BaseDatosException {
		if(cuentasBD.containsKey(iban)){
			return cuentasBD.get(iban);
		}else {
			throw new BaseDatosException("No existe una cuenta con ese IBAN");
		}
		
	}
	public Cliente getCliente(String nom,String dni) throws BaseDatosException {
		if(clientesBD.containsKey(dni)){
			if(clientesBD.get(dni).getNombre().equals(nom)) {
				return clientesBD.get(dni);
			}else {
				throw new BaseDatosException("El nombre no coincide con el titular de ese DNI");
			}
		}else {
			throw new BaseDatosException("No existe un cliente con ese DNI");
		}
		
	}


}
