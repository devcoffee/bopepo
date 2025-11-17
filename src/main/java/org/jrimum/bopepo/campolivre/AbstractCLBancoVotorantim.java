package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;


abstract class AbstractCLBancoVotorantim extends AbstractCampoLivre {


	private static final long serialVersionUID = 1L;

	protected AbstractCLBancoVotorantim(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo){
		
		return new CLBancoVotorantim().build(titulo);
	}
}
