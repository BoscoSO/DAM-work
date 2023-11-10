package cuenta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import dni.DNIException;
import utilidadesbanco.CCCException;
import utilidadesbanco.IbanException;
import utilidadesbanco.UtilidadesBanco;
import bdCuentas.BaseDatos;
import bdCuentas.BaseDatosException;
public abstract class Cuenta implements Comparable<Cuenta>,Serializable{


	private static final long serialVersionUID = 1L;


	private String iban;
	private BigDecimal saldo;
	protected BaseDatos accesoBD;
	private Set<Cliente> clientes;
	
	public Cuenta(String iban,BaseDatos bd) throws IbanException, CCCException, DNIException {
		this.clientes=new HashSet<>();
		accesoBD=bd;
		if(UtilidadesBanco.validarIBAN(iban)) {
			this.iban = iban;
			this.saldo=new BigDecimal(0);	
		}
	
		accesoBD.añadirCuenta(this);
	}
	public Cuenta(String iban, Cliente cliente,BaseDatos bd) throws IbanException, CCCException {
		this.clientes=new HashSet<>();
		accesoBD=bd;
		if(UtilidadesBanco.validarIBAN(iban)) {
			this.iban = iban;
			this.saldo=new BigDecimal(0);	
		}
		clientes.add(cliente);
		accesoBD.añadirCuenta(this);
	}
	public String getInfo() {
		return "-"+this.getIBAN()+" |Saldo: "+this.getSaldo()+"€"; 
	}
	public String getIBAN() {
		return this.iban;
	}
	public String getSaldo() {
		return this.saldo.toString();
	}	
	public String[] getClientesInfo() {
		String[] s=new String[clientes.size()];
		int i=0;
		for(Cliente c: clientes) {
			s[i++]="-"+c.getNombre()+". DNI:"+c.getDni();
		}
		return s;
	}	
	public boolean comprobarClientes(String nom, String dni) {
		
		for(Cliente c:clientes) {
			if(c.getNombre().equals(nom) && c.getDni().equals(dni)  ) {
				return true;
			}
		}
		return false;
	}
	
	public void ingresar(BigDecimal n) throws MovimientoException {
		if(n.intValue()<=0) {
			throw new MovimientoException("Cantidad negativa");
		}else saldo=saldo.add(n);		
	}
	public void retirar(BigDecimal n) throws MovimientoException {
		if(n.intValue()<=0) {
			throw new MovimientoException("Cantidad negativa");
		}else if(n.compareTo(saldo)<=0) {
			saldo=saldo.add(n.negate());		
		}else throw new MovimientoException("No posees de tal cantidad");
	}
	public abstract String getRegalito();
	public abstract void transferencia(String ibanDestino,int cantidad) throws IbanException, CCCException, MovimientoException, BaseDatosException;
	
	public void addCliente(String nom,String dni,boolean añadir) throws BaseDatosException{
		
		Cliente c=accesoBD.getCliente(nom, dni);
		if(c!=null) {
			if(añadir)
				try {
					c.addCuenta(0, null, this);
				} catch (IbanException | CCCException | ClienteException | DNIException e) {
					System.out.println(e.getMessage());
				}
			this.clientes.add(c);	//AÑADIMOS LA CUENTA A UN ARRAY DE CUENTAS		
		}
		
	
	}

	public void eliminarCuenta(BaseDatos bd) throws Exception {
		if(saldo.intValue()==0) {
			bd.eliminarCuenta(this.getIBAN());
		}else {
			throw new Exception("Asegurese de que retira todo el saldo antes de eliminar la cuenta");
		}
	}

	@Override
	public int compareTo(Cuenta cuenta) {
		return (int)(cuenta.saldo.intValueExact()-this.saldo.intValueExact());
	}
}
