package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.junit.Before;
import org.junit.Test;


public class TestCLBancoFibra extends AbstractCampoLivreBaseTest<CLBancoFibra> {

	@Before
	public void setUp(){

		titulo.getContaBancaria().setBanco(BancosSuportados.BANCO_FIBRA.create());
		titulo.getContaBancaria().setAgencia(new Agencia(1234, "1"));
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(6789));
		titulo.getContaBancaria().setCarteira(new Carteira(500));
		titulo.setNossoNumero("123456789");
		titulo.setDigitoDoNossoNumero("1");
		titulo.setParametrosBancarios(new ParametrosBancariosMap(org.jrimum.bopepo.parametro.ParametroBancoFibra.OPERACAO, 1234567));
		
		createCampoLivreToTest();

		setCampoLivreEsperadoComoString("1234567890500123456789100");
	}


	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroNulo() {
		testeSeNaoPermiteNossoNumeroNulo();
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComBrancos() {
		testeSeNaoPermiteNossoNumeroComBrancos(CLBancoFibra.NOSSO_NUMERO_COM_DV_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComEspacos() {

		testeSeNaoPermiteNossoNumeroComEspacos(CLBancoFibra.NOSSO_NUMERO_COM_DV_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComTamanhoDiferenteDe10() {
		testeSeNaoPermiteNossoNumeroComTamanhoDiferenteDoEspecificado(CLBancoFibra.NOSSO_NUMERO_COM_DV_LENGTH - 1);
	}

}
