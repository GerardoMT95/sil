package it.eng.sil.module.ido;

import com.engiweb.framework.base.SourceBean;

import it.eng.sil.module.AbstractAlternativaSimpleModule;

public class MAggiornaLinguaRichiesta extends AbstractAlternativaSimpleModule {
	public void service(SourceBean request, SourceBean response) {
		getPrgAlternativa(request);
		doUpdateNoDuplicate(request, response, "PRGLINGUA");
	}
}
