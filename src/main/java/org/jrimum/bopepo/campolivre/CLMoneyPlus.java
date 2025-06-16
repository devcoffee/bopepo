package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.texgit.type.component.Fillers;
import org.jrimum.texgit.type.component.FixedField;


public class CLMoneyPlus extends AbstractCLMoneyPlus {
	

	private static final long serialVersionUID = 1795549427658541445L;

	/**
	 * Número de campos = 5.
	 */
	private static final Integer FIELDS_LENGTH = Integer.valueOf(5);

	/**
	 * Tamanho do campo Agência = 4. 20 a 23
	 */
	private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
	
	/**
	 * Tamanho do campo Carteira = 2. 24 a 25
	 */
	private static final Integer CARTEIRA_LENGTH = Integer.valueOf(2);
	
	/**
	 * Tamanho do campo Nosso Número = 11. 26 a 36
	 */
	private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(11);
	
	/**
	 * Tamanho do campo Conta = 7.  37 a 43
	 */
	private static final Integer CONTA_LENGTH = Integer.valueOf(7);
	
	/**
	 * Tamanho do campo Constante = 1.  44 a 44
	 */
	private static final Integer CONSTANT_LENGTH = Integer.valueOf(1);
	
	/**
	 * Valor do campo Constante =  0. 
	 */
	private static final Integer CONSTANT_VALUE = Integer.valueOf(0);

	/**
	 * Constante em forma de campo {@linkplain #CONSTANT_VALUE} e {@linkplain #CONSTANT_LENGTH}.
	 */
	private static final FixedField<Integer> CONSTANT_FIELD = new FixedField<Integer>(CONSTANT_VALUE, CONSTANT_LENGTH);
	

	protected CLMoneyPlus() {
		
		super(FIELDS_LENGTH);
	}
	
	@Override
	protected void checkValues(Titulo titulo){
		
		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
		checkCarteiraNotNull(titulo);
		checkCodigoDaCarteira(titulo);
		checkCodigoDaCarteiraMenorOuIgualQue(titulo, 99);
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN11);
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
	}
	

	@Override
	protected void addFields(Titulo titulo) {
		
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, Fillers.ZERO_LEFT));
		this.add(CONSTANT_FIELD);
	}
}
