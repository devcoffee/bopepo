package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Teste unitário do campo livre do Banco Intermedium.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:fernandobgi@gmail.com">Fernando Dias</a>
 * 
 */
public class TestCLBancoInter extends AbstractCampoLivreBaseTest<CLBancoInter> {

	private final int NOSSO_NUMERO_LENGTH = 10;

	@Before
	public void setUp() {

		titulo.getContaBancaria().setBanco(BancosSuportados.BANCO_INTER.create());
		titulo.getContaBancaria().setAgencia(new Agencia(54, "0"));
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(6789));
		titulo.getContaBancaria().setCarteira(new Carteira(999));
		titulo.setNossoNumero("1234567890");
		titulo.setDigitoDoNossoNumero("9");
		titulo.setParametrosBancarios(new ParametrosBancariosMap(org.jrimum.bopepo.parametro.ParametroBancoInter.OPERACAO, 1234567));

		createCampoLivreToTest();

		setCampoLivreEsperadoComoString("0054999123456712345678909");
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteAgenciaNula() {
		testeSeNaoPermiteAgenciaNula();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaAgenciaAcimaDe4Digitos() {
		testeSeNaoPermiteNumeroDaAgenciaComDigitosAcimaDoLimite(10000);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteCarteiraNull() {
		testeSeNaoPermiteCarteiraNula();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroNulo() {
		testeSeNaoPermiteNossoNumeroNulo();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComBrancos() {
		testeSeNaoPermiteNossoNumeroComBrancos(NOSSO_NUMERO_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComEspacos() {
		testeSeNaoPermiteNossoNumeroComEspacos(NOSSO_NUMERO_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComTamanhoDiferenteDe10() {
		testeSeNaoPermiteNossoNumeroComTamanhoDiferenteDoEspecificado(NOSSO_NUMERO_LENGTH - 1);
	}
}
