package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.junit.Before;
import org.junit.Test;


public class TestCLBancoVotorantim extends AbstractCampoLivreBaseTest<CLBancoVotorantim> {

	@Before
	public void setUp(){

		titulo.getContaBancaria().setBanco(BancosSuportados.BANCO_VOTORANTIM.create());
		titulo.getContaBancaria().setAgencia(new Agencia(1234, "1"));
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(6789));
		titulo.setParametrosBancarios(new ParametrosBancariosMap(org.jrimum.bopepo.parametro.ParametroBancoVotorantim.CONVENIO, 1234567890));
		titulo.getContaBancaria().setCarteira(new Carteira(500));
		titulo.setNossoNumero("123456789");
		titulo.setDigitoDoNossoNumero("1");

		createCampoLivreToTest();

		setCampoLivreEsperadoComoString("1234567890500123456789100");
	}


	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroNulo() {
		testeSeNaoPermiteNossoNumeroNulo();
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComBrancos() {
		testeSeNaoPermiteNossoNumeroComBrancos(CLBancoVotorantim.NOSSO_NUMERO_COM_DV_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComEspacos() {

		testeSeNaoPermiteNossoNumeroComEspacos(CLBancoVotorantim.NOSSO_NUMERO_COM_DV_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComTamanhoDiferenteDe10() {
		testeSeNaoPermiteNossoNumeroComTamanhoDiferenteDoEspecificado(CLBancoVotorantim.NOSSO_NUMERO_COM_DV_LENGTH - 1);
	}

}
