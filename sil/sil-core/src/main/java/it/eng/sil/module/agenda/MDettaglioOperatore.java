package it.eng.sil.module.agenda;

import com.engiweb.framework.base.SourceBean;

import it.eng.sil.module.AbstractSimpleModule;

public class MDettaglioOperatore extends AbstractSimpleModule {
	public MDettaglioOperatore() {
	}

	private String className = this.getClass().getName();

	public void service(SourceBean request, SourceBean response) {
		doSelect(request, response);
	}
}