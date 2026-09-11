package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Teste unitário do campo livre do Banco Vórtx.
 * </p>
 *
 * @author Bike
 */
public class TestCLBancoVortx extends AbstractCampoLivreBaseTest<CLVortx> {

	private final int NOSSO_NUMERO_LENGTH = 11;

	@Before
	public void setUp() {

		titulo.getContaBancaria().setBanco(BancosSuportados.VORTX.create());
		titulo.getContaBancaria().setAgencia(new Agencia(19, "0"));
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(2600));
		titulo.getContaBancaria().setCarteira(new Carteira(21));

		titulo.setNossoNumero("00000000001");
		titulo.setDigitoDoNossoNumero("9");

		createCampoLivreToTest();

		setCampoLivreEsperadoComoString("0019000000260000000000001");
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
	public void seNaoPermiteNossoNumeroComTamanhoDiferenteDe11() {
		testeSeNaoPermiteNossoNumeroComTamanhoDiferenteDoEspecificado(NOSSO_NUMERO_LENGTH - 1);
	}
}