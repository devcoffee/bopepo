package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.parametro.ParametroBancoFibra;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.texgit.type.component.Fillers;
import org.jrimum.texgit.type.component.FixedField;

public class CLBancoFibra extends AbstractCLBancoFibra {

	private static final long serialVersionUID = -5787328473435278119L;

	public static final Integer FIELDS_LENGTH = Integer.valueOf(4);

	public static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
	public static final Integer CARTEIRA_LENGTH = Integer.valueOf(3);
	public static final Integer OPERACAO_LENGTH = Integer.valueOf(7);
	public static final Integer NOSSO_NUMERO_COM_DV_LENGTH = Integer.valueOf(11);

	protected CLBancoFibra() {
		super(FIELDS_LENGTH);
	}
	
	@Override
	protected void checkValues(Titulo titulo) {
		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN10);
        checkTamanhoDigitoDoNossoNumero(titulo, 1, "Digito do nosso número deve ir de 0 a 9");
        checkParametroBancario(titulo, ParametroBancoFibra.OPERACAO);
        checkParametroBancarioMenorOuIgualQue(titulo, ParametroBancoFibra.OPERACAO, 9999999);
	}
	

	@Override
	protected void addFields(Titulo titulo) {
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getParametrosBancarios().<Integer>getValor(ParametroBancoFibra.OPERACAO), OPERACAO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNossoNumero() + titulo.getDigitoDoNossoNumero(), NOSSO_NUMERO_COM_DV_LENGTH, Fillers.ZERO_LEFT));
	}
}
