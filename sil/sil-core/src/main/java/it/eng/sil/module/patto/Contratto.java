package it.eng.sil.module.patto;

import com.engiweb.framework.base.SourceBean;

import it.eng.sil.module.AbstractSimpleModule;

public class Contratto extends AbstractSimpleModule {
	public void service(SourceBean request, SourceBean response) {
		doSelect(request, response);
	}
}
