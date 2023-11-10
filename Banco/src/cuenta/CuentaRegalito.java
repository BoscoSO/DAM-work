package cuenta;

import java.math.BigDecimal;
import java.util.Random;

import bdCuentas.BaseDatos;
import bdCuentas.BaseDatosException;
import dni.DNIException;
import utilidadesbanco.CCCException;
import utilidadesbanco.IbanException;
import utilidadesbanco.UtilidadesBanco;

public class CuentaRegalito extends Cuenta {

	private static final long serialVersionUID = 1L;
	
	private String[] regalitos= {" Calendario","a Vajilla"," Apartamento en San Xenxo"};
	private boolean regalo;
	private final BigDecimal comm= new BigDecimal(1);
	
	public CuentaRegalito(String iban,BaseDatos bd) throws IbanException, CCCException, ClienteException, DNIException {
		super(iban,bd);
		this.regalo=true;
	}
	
	

	public CuentaRegalito(String iban, Cliente cliente,BaseDatos bd) throws IbanException, CCCException {
		super(iban,cliente,bd);
		this.regalo=true;
	}



	@Override
	public String getRegalito() { 
		// TODO Auto-generated method stub
		if(regalo) {
			Random r=new Random();
			regalo=false;
			return "Enhorabuena! le ha tocado un"+regalitos[r.nextInt(3)];
		}else {
			return "El regalo consta como entregado, disfrutelo!";
		}
	}
	
	@Override
	public void transferencia(String ibanDestino,int cantidad) throws IbanException, CCCException, MovimientoException, BaseDatosException {
		if(UtilidadesBanco.validarIBAN(ibanDestino)) {
		
			BigDecimal i=new BigDecimal(cantidad);
			this.retirar(i.add(comm));
			boolean bien=false;
			bien=accesoBD.trasferir(i, ibanDestino);
			
			if(!bien) this.ingresar(i.add(comm)); 
		}
	}


}
