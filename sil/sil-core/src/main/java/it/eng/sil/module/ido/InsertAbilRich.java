package it.eng.sil.module.ido;

import java.math.BigDecimal;
import java.util.Collection;

import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.base.SourceBeanException;

import it.eng.afExt.utils.ReportOperationResult;
import it.eng.afExt.utils.StringUtils;
import it.eng.sil.module.AbstractSimpleModule;
import it.eng.sil.util.collectionexecutor.Action;
import it.eng.sil.util.collectionexecutor.ActionException;
import it.eng.sil.util.collectionexecutor.CollectionExecutor;
import it.eng.sil.util.collectionexecutor.InsertElementAction;

public class InsertAbilRich extends AbstractSimpleModule {
	public void service(SourceBean request, SourceBean response) throws Exception {
		boolean ok = true;
		int numeroElementi = 0;
		int prevIdSuccess = 0;
		int prevIdElementDuplicate = 0;

		Action insertAction = new InsertElementAction(this);

		Boolean updateFlg = new Boolean(false);
		String flgInvioCL = StringUtils.getAttributeStrNotNull(request, "flgInvioCL");

		Collection elenco = AbstractSimpleModule.getArgumentValues(request, "CODABILITAZIONEGEN");

		CollectionExecutor collectionExecutor = new CollectionExecutor(elenco, insertAction, "CODABILITAZIONEGEN");

		numeroElementi = elenco.size();

		if ("S".equals(flgInvioCL) && numeroElementi == 1) {
			this.setSectionQuerySelect("QUERY_SELECT");
			SourceBean sbQueryDuplicate = doSelect(request, response);

			if (!sbQueryDuplicate.containsAttribute("ROW")) {
				this.setSectionQuerySelect("VERIFICA_FLGCL");
				SourceBean sbFlgCL = doSelect(request, response);
				BigDecimal numFlag = (BigDecimal) sbFlgCL.getAttribute("ROW.CONTAFLAG");
				if (numFlag.intValue() > 0) {
					setSectionQueryUpdate("QUERY_UPDATE_FLGCL");
					updateFlg = doUpdate(request, response);

					if (!updateFlg.booleanValue())
						throw new Exception("Errore nell'aggiornamento della mansione");
				}
			}
			response.delAttribute("USER_MESSAGE");
		}

		this.setSectionQuerySelect("QUERY_SELECT");
		if (numeroElementi > 1) {
			prevIdSuccess = disableMessageIdSuccess();
			prevIdElementDuplicate = disableMessageIdElementDuplicate();
		}

		ReportOperationResult reportOperation = new ReportOperationResult(this, response);
		try {
			collectionExecutor.execute(request, response);
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
				// doInsert... richiamato nella chiamata a
				// doInsertMultiSelection
				reportSuccess(reportOperation);
			}
		}
	}
}