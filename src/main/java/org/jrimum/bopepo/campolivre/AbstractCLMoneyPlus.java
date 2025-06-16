package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;


abstract class AbstractCLMoneyPlus extends AbstractCampoLivre {


	private static final long serialVersionUID = 1L;

	protected AbstractCLMoneyPlus(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo){
		
		return new CLMoneyPlus().build(titulo);
	}
}
