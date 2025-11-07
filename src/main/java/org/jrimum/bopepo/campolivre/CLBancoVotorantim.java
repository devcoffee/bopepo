package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.parametro.ParametroBancoVotorantim;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.texgit.type.component.Fillers;
import org.jrimum.texgit.type.component.FixedField;

public class CLBancoVotorantim extends AbstractCLBancoVotorantim {

	private static final long serialVersionUID = -5787328473435278119L;

	private static final Integer FIELDS_LENGTH = Integer.valueOf(4);

	private static final Integer CONVENIO_LENGTH = Integer.valueOf(10);
	
	private static final Integer FIXO_LENGTH = Integer.valueOf(3);

	private static final Integer NOSSO_NUMERO_COM_DV_LENGTH = Integer.valueOf(10);

	private static final Integer CONSTANT_LENGTH = Integer.valueOf(2);

	private static final Integer CONSTANT_VALUE = Integer.valueOf(0);

	private static final FixedField<Integer> CONSTANT_FIELD = new FixedField<Integer>(CONSTANT_VALUE, CONSTANT_LENGTH, Fillers.ZERO_LEFT);
	

	protected CLBancoVotorantim() {
		
		super(FIELDS_LENGTH);
	}
	
	@Override
	protected void checkValues(Titulo titulo){
		
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN9);
        checkTamanhoDigitoDoNossoNumero(titulo,1, "Digito do nosso número deve ir de 0 a 9");
        checkParametroBancario(titulo, ParametroBancoVotorantim.CONVENIO);
	}
	

	@Override
	protected void addFields(Titulo titulo) {
		
		this.add(new FixedField<Integer>(titulo.getParametrosBancarios().<Integer>getValor(ParametroBancoVotorantim.CONVENIO), CONVENIO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(500, FIXO_LENGTH));
		this.add(new FixedField<String>(titulo.getNossoNumero() + titulo.getDigitoDoNossoNumero(), NOSSO_NUMERO_COM_DV_LENGTH, Fillers.ZERO_LEFT));
		this.add(CONSTANT_FIELD);
	}
}
