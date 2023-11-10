package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;

public class ValidacionMaiusculas extends StringValidator {

	@Override
	public void validate(Problems problemas, String nomeComponente, String texto) {
		if ((!"".equals(texto)) && !Character.isUpperCase(texto.charAt(0)))
			problemas.add("Campo "+nomeComponente + ": ten que empezar por maiúsculas");
	}
	
}
