package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;


abstract class AbstractCLBancoFibra extends AbstractCampoLivre {


	private static final long serialVersionUID = 1L;

	protected AbstractCLBancoFibra(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo){
		
		return new CLBancoFibra().build(titulo);
	}
}
