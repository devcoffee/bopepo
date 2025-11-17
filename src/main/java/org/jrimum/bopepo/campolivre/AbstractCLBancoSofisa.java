package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.Titulo;

/**
* @author Jose.Leite
*/
abstract class AbstractCLBancoSofisa extends AbstractCampoLivre {

	private static final long serialVersionUID = 6881152801814960204L;
	
	
	protected AbstractCLBancoSofisa(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo){
		
		return new CLBancoSofisa().build(titulo);
	}

}
