package cuenta;
import java.math.BigDecimal;

import bdCuentas.BaseDatos;
import bdCuentas.BaseDatosException;
import dni.DNIException;
import utilidadesbanco.CCCException;
import utilidadesbanco.IbanException;
import utilidadesbanco.UtilidadesBanco;

public class CuentaPlusTransfer extends Cuenta {
	
	private static final long serialVersionUID = 1L;

	public CuentaPlusTransfer(String iban, BaseDatos bd) throws IbanException, CCCException, ClienteException, DNIException {
		super(iban,bd);
	}
	
	public CuentaPlusTransfer(String iban, Cliente cliente,BaseDatos bd) throws IbanException, CCCException {
		super(iban,cliente,bd);
	}
	
	@Override
	public String getRegalito() {
		return "A este tipo de cuenta no le corresponde regalito";
	}

	@Override
	public void transferencia(String ibanDestino,int cantidad) throws IbanException, CCCException, MovimientoException, BaseDatosException {
		if(UtilidadesBanco.validarIBAN(ibanDestino)) {
		
			BigDecimal i=new BigDecimal(cantidad);
			this.retirar(i);
			boolean bien=false;
			bien=accesoBD.trasferir(i, ibanDestino);
			
			if(!bien) this.ingresar(i); 
		}
	}
	


}
