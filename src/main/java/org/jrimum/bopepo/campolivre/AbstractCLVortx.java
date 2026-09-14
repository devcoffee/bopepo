package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.vallia.digitoverificador.Modulo;

/**
 * <p>
 * Interface comum para todos os campos livres do Banco Vortx que venham a
 * existir.
 * </p>
 *
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 *
 * @since 0.2
 *
 * @version 0.2
 */
abstract class AbstractCLVortx extends AbstractCampoLivre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1882819688182515282L;

	/**
	 * <p>
	 * Cria um campo livre com um determinado número de campos.
	 * </p>
	 *
	 * @see AbstractCampoLivre
	 *
	 * @param fieldsLength Número de campos
	 */
	protected AbstractCLVortx(Integer fieldsLength) {

		super(fieldsLength);
	}

	/**
	 * Cria o campo livre da Vortx.
	 *
	 * @param titulo Título
	 * @return Campo livre
	 */
	protected static CampoLivre create(Titulo titulo) {

		return new CLVortx(titulo);
	}

	/**
	 * <p>
	 * Calcula o dígito verificador do Nosso Número da Vortx.
	 * </p>
	 *
	 * <p>
	 * Para o cálculo, deve ser acrescentado o número da carteira (21) à esquerda do
	 * Nosso Número e aplicado módulo 11 com base 7.
	 * </p>
	 *
	 * <p>
	 * O cálculo utiliza multiplicadores de 2 a 7, da direita para a esquerda,
	 * reiniciando em 2 após o 7.
	 * </p>
	 *
	 * <p>
	 * Caso o resultado seja 0, 10 ou 11, o dígito será 0.
	 * </p>
	 *
	 * @param nossoNumero Nosso Número sem o dígito verificador
	 * @return Dígito verificador
	 */
	String calculeDigitoNossoNumero(String nossoNumero) {

		final String numeroParaCalculo = "21" + nossoNumero;

		int soma = Modulo.calculeSomaSequencialMod11(numeroParaCalculo, 2, 7);

		int resto = soma % 11;
		int digito = 11 - resto;

		if (digito == 0 || digito == 10 || digito == 11)
			digito = 0;

		return String.valueOf(digito);
	}
}