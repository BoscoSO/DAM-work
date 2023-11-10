package cuenta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import bdCuentas.BaseDatos;
import bdCuentas.BaseDatosException;
import dni.DNI;
import dni.DNIException;
import utilidadesbanco.CCCException;
import utilidadesbanco.IbanException;

public class Cliente implements Comparable<Cliente>,Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private final DNI dni;
	private final String nombre;
	

	private BaseDatos accesoBD;
	private Set<Cuenta> cuentas;
	
	
	public Cliente(String dni, String nombre,BaseDatos bd) throws ClienteException, DNIException  {
		this.cuentas=new HashSet<>();
		
		this.dni=new DNI(dni.toLowerCase());
		if(nombre.isEmpty()) throw new ClienteException("El nombre introducido esta vacio");
		if(nombre.length()>20)throw new ClienteException("El nombre introducido supera los 20 caracteres");
		this.nombre = nombre;
		
		accesoBD=bd;
		accesoBD.añadirCliente(this);
	}

	public String[] getCuentasInfo() {
		String[] s=new String[cuentas.size()];
		int i=0;
		for(Cuenta c: cuentas) {
			s[i++]="-"+c.getIBAN()+" |Saldo: "+c.getSaldo()+"€"; 
		} 
		return s;
	}
	public String[] getCuentas() {
		String[] s=new String[cuentas.size()];
		int i=0;
		for(Cuenta c: cuentas) {
			s[i++]=c.getIBAN();
			
		}
		return s;
	}
	public Cuenta getCC(int i) {
		for(Cuenta c:cuentas){
			if(i==0) {
				return c;
			}
			i--;
		}
		return null;
	}

	public String getDni() {
		return dni.getDNI();
	}
	public String getNombre() {
		return nombre;
	}
	public String getInfo(boolean conCuentas) {
		if(conCuentas) {
			String cadena="";
			for(String c:getCuentasInfo()) {
				cadena+="   -"+c+"\n";
			}
			return this.nombre+" | DNI: "+this.getDni()+"\n"+cadena;
		}else
			return this.nombre+" | DNI: "+this.getDni();
	}
	public boolean esCliente(String nom,String dni) {
		if(this.nombre.equals(nom) && this.getDni().equals(dni.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public void eliminarCliente(BaseDatos bd) throws ClienteException {
		if(cuentas.isEmpty()) {
			bd.eliminarCliente(this.getDni());
		}else {
			throw new ClienteException("Este cliente todavia tiene cuentas");
		}
	}
	
	public void eliminarCuenta(String iban) {
		boolean encontrada=false;
		Cuenta aux=null;
		for(Cuenta c:cuentas) {
			if(c.getIBAN().equals(iban)) {
				aux=c;
				encontrada=true;
				break;
			}
		}
		if(encontrada) {
			cuentas.remove(aux);
		}
		
	}
	public void addCuenta(int op,String iban, Cuenta c) throws IbanException, CCCException, ClienteException, DNIException, BaseDatosException {
		if(c!=null) {
			c.addCliente(getNombre(), getDni(),false);
			this.cuentas.add(c);
		}else {
			Cuenta cc;
			try {
				cc=accesoBD.getCuenta(iban);
			}catch(BaseDatosException e) {
				cc=null;
			}
			if(cc!=null) {
				cc.addCliente(getNombre(), getDni(),false);
				this.cuentas.add(cc);
			}else {
				boolean encontrada=false;
				
				for(Cuenta cu :cuentas) {
					if(cu.getIBAN().equals(iban)) {
						encontrada=true;break;
					}
				}
				if(!encontrada) {
					Cuenta ccc;
					if(op==0) {	
						ccc=new CuentaRegalito(iban,this,accesoBD);
					}else {
						ccc=new CuentaPlusTransfer(iban,this,accesoBD);
					}
//					ccc.addCliente(getNombre(), getDni(),false);
				
					this.cuentas.add(ccc);
				}else {
					throw new ClienteException("Esta cuenta ya se encuentra añadida");
				}
		
			}
		}
	}

//	@Override
//	public int compareTo(Cliente o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
	@Override
	public int compareTo(Cliente cliente) {
		return (int) nombre.compareTo(cliente.getNombre());
       
	}
}
