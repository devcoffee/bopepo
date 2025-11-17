package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.junit.Before;
import org.junit.Test;

/**
* @author Jose.Leite
*/
public class TestCLBancoSofisa extends AbstractCampoLivreBaseTest<CLBancoSofisa> {

	@Before
	public void setUp(){

		titulo.getContaBancaria().setBanco(BancosSuportados.BANCO_SOFISA.create());
		titulo.getContaBancaria().setAgencia(new Agencia(1234, "1"));
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(6789));
		titulo.getContaBancaria().setCarteira(new Carteira(999));
		titulo.setNossoNumero("1234567890");
		titulo.setDigitoDoNossoNumero("9");
		
		titulo.setParametrosBancarios(new ParametrosBancariosMap(org.jrimum.bopepo.parametro.ParametroBancoSofisa.OPERACAO, 1234567));
		createCampoLivreToTest();

		setCampoLivreEsperadoComoString("1234999123456712345678909");
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
	public void seNaoPermiteCarteiraComCodigoAcimaDe3Digitos() {
		testeSeNaoPermiteCarteiraComCodigoAcimaDoLimite(1111);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroNulo() {
		testeSeNaoPermiteNossoNumeroNulo();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComBrancos() {
		testeSeNaoPermiteNossoNumeroComBrancos(CLBancoSofisa.NOSSO_NUMERO_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComEspacos() {
		testeSeNaoPermiteNossoNumeroComEspacos(CLBancoSofisa.NOSSO_NUMERO_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComTamanhoDiferenteDe10() {
		testeSeNaoPermiteNossoNumeroComTamanhoDiferenteDoEspecificado(CLBancoSofisa.NOSSO_NUMERO_LENGTH - 1);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaContaNulo() {
		testeSeNaoPermiteNumeroDaContaNulo();
	}
	
}
