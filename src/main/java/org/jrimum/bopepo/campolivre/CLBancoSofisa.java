package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.parametro.ParametroBancoSofisa;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.texgit.type.component.Fillers;
import org.jrimum.texgit.type.component.FixedField;

/**
* @author Jose.Leite
*/
public class CLBancoSofisa extends AbstractCLBancoSofisa {

	private static final long serialVersionUID = 2002946286397696913L;
	
	
	public static final Integer FIELDS_LENGTH = Integer.valueOf(5);
	
	public static final Integer AGENCIA_LENGTH = Integer.valueOf(4);

	public static final Integer CARTEIRA_LENGTH = Integer.valueOf(3);
	
	public static final Integer OPERACAO_LENGTH = Integer.valueOf(7);
	
	public static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(10);
	
	public static final Integer DIG_NOSSO_NUMERO_LENGTH = Integer.valueOf(1);



	protected CLBancoSofisa() {
		
		super(FIELDS_LENGTH);
	}
	
	@Override
	protected void checkValues(Titulo titulo){
		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
		checkCarteiraNotNull(titulo);
		checkCodigoDaCarteira(titulo);
		checkCodigoDaCarteiraMenorOuIgualQue(titulo, 999);
		checkNossoNumero(titulo);
		checkDigitoDoNossoNumero(titulo);
		checkTamanhoDigitoDoNossoNumero(titulo,DIG_NOSSO_NUMERO_LENGTH, "Digito do nosso número deve ir de 0 a 9");
		checkTamanhoDoNossoNumero(titulo, NOSSO_NUMERO_LENGTH);
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
		checkParametroBancario(titulo, ParametroBancoSofisa.OPERACAO);
		checkParametroBancarioMenorOuIgualQue(titulo, ParametroBancoSofisa.OPERACAO, 9999999);
	}
	

	@Override
	protected void addFields(Titulo titulo) {
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getParametrosBancarios().<Integer>getValor(ParametroBancoSofisa.OPERACAO), OPERACAO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getDigitoDoNossoNumero(), DIG_NOSSO_NUMERO_LENGTH));
	}
}
