package it.eng.sil.module.presel;

import java.util.Collection;

import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.base.SourceBeanException;

//import it.eng.sil.module.*;
import it.eng.afExt.utils.ReportOperationResult;
import it.eng.sil.module.AbstractAlternativaSimpleModule;
import it.eng.sil.module.AbstractSimpleModule;
import it.eng.sil.util.collectionexecutor.Action;
import it.eng.sil.util.collectionexecutor.ActionException;
import it.eng.sil.util.collectionexecutor.CollectionExecutor;
import it.eng.sil.util.collectionexecutor.InsertElementAction;

/*public class InsertConoscenzaInfo extends AbstractSimpleModule
 {
 public void service(SourceBean request, SourceBean response) {

 doInsert(request, response);
 }
 }*/

public class InsertConoscenzaInfo extends AbstractAlternativaSimpleModule {
	public void service(SourceBean request, SourceBean response) {
		Object objCodDettaglio = null;
		String strCodDettaglio = "";
		objCodDettaglio = request.getAttribute("CODICE");
		if (objCodDettaglio != null) {
			strCodDettaglio = objCodDettaglio.toString();
		}
		if (strCodDettaglio.compareTo("") == 0) {
			doInsert(request, response);
		} else {
			boolean ok = true;
			int numeroElementi = 0;
			int prevIdSuccess = 0;
			int prevIdElementDuplicate = 0;

			getPrgAlternativa(request);

			Action insertAction = new InsertElementAction(this);

			Collection elenco = AbstractSimpleModule.getArgumentValues(request, "CODICE");

			CollectionExecutor objExecutor = new CollectionExecutor(elenco, insertAction, "CODICE");

			numeroElementi = elenco.size();
			if (numeroElementi > 1) {
				prevIdSuccess = disableMessageIdSuccess();
				prevIdElementDuplicate = disableMessageIdElementDuplicate();
			}

			ReportOperationResult reportOperation = new ReportOperationResult(this, response);
			try {

				objExecutor.execute(request, response);
			} catch (ActionException aExp) {
				ok = false;
			} catch (SourceBeanException sbExp) {
				ok = false;
			}

			if (numeroElementi > 1) {
				setMessageIdSuccess(prevIdSuccess);
				setMessageIdElementDuplicate(prevIdElementDuplicate);

				if (ok) {

					// In caso di problemi, un messaggio viene già inserito
					// e visualizzato col tag showErrors dal metodo
					// doInsert... richiamato
					reportSuccess(reportOperation);
				}
			}
		}
	}
}