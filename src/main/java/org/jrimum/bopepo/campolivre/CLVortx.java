package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.texgit.type.component.Fillers;
import org.jrimum.texgit.type.component.FixedField;

class CLVortx extends AbstractCLVortx {

	private static final long serialVersionUID = 1L;

	/**
	 * Número de campos do Campo Livre.
	 */
	private static final Integer FIELDS_LENGTH = Integer.valueOf(3);

	/**
	 * Tamanho da agência.
	 */
	private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);

	/**
	 * Tamanho da conta + dígito.
	 */
	private static final Integer CONTA_LENGTH = Integer.valueOf(10);

	/**
	 * Tamanho do Nosso Número.
	 */
	private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(11);

	protected CLVortx(Titulo titulo) {

		super(FIELDS_LENGTH);

		checkValues(titulo);
		addFields(titulo);
	}

	@Override
	protected void checkValues(Titulo titulo) {

		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);

		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);

		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN11);
	}

	@Override
	protected void addFields(Titulo titulo) {

		/*
		 * Posições 20-23 Agência do beneficiário.
		 */
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH,
				Fillers.ZERO_LEFT));

		/*
		 * Posições 24-33 Conta do beneficiário + dígito.
		 */
		String conta = String.valueOf(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta())
				+ titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta();

		this.add(new FixedField<String>(conta, CONTA_LENGTH, Fillers.ZERO_LEFT));

		/*
		 * Posições 34-44 Nosso Número sem o dígito verificador.
		 */
		this.add(new FixedField<String>(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, Fillers.ZERO_LEFT));
	}
}