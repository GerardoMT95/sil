package it.eng.sil.module.agenda;

import java.math.BigDecimal;

import com.engiweb.framework.base.SessionContainer;
import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.base.SourceBeanException;
import com.engiweb.framework.dispatching.module.AbstractModule;
import com.engiweb.framework.util.QueryExecutor;

import it.eng.afExt.dbaccess.sql.DBKeyGenerator;
import it.eng.afExt.utils.MessageCodes;
import it.eng.afExt.utils.ReportOperationResult;
import it.eng.sil.Values;
import it.eng.sil.security.User;

public class MSalvaSlot extends AbstractModule {
	private String className = this.getClass().getName();

	public MSalvaSlot() {
	}

	public void service(SourceBean request, SourceBean response) {
		String pool = (String) getConfig().getAttribute("POOL");
		SessionContainer sessionContainer = getRequestContainer().getSessionContainer();
		User user = (User) sessionContainer.getAttribute(User.USERID);
		SourceBean statement = null;
		Boolean esito = null;
		ReportOperationResult result = new ReportOperationResult(this, response);

		String prgSlotStr = (String) request.getAttribute("PRGSLOT");
		try {
			if ((prgSlotStr == null) || (prgSlotStr.equals(""))) {
				// INSERT
				BigDecimal prgSlot = DBKeyGenerator.getNextSequence(Values.DB_SIL_DATI, "S_AG_SLOT");
				request.updAttribute("PRGSLOT", prgSlot);
				response.setAttribute("PRGSLOT", prgSlot.toString());
				statement = (SourceBean) getConfig().getAttribute("QUERIES.INSERT_QUERY");
				esito = (Boolean) QueryExecutor.executeQuery(getRequestContainer(), getResponseContainer(), pool,
						statement, "INSERT");

			} else {
				response.setAttribute("PRGSLOT", prgSlotStr);
				statement = (SourceBean) getConfig().getAttribute("QUERIES.UPDATE_QUERY");
				esito = (Boolean) QueryExecutor.executeQuery(getRequestContainer(), getResponseContainer(), pool,
						statement, "UPDATE");
			}
		} catch (SourceBeanException e) {
			esito = new Boolean(false);
			result.reportFailure(e, className, "Errore durante l'inserimento/modifica dello Slot");
		}

		if ((esito != null) && (esito.booleanValue() == true)) {
			result.reportSuccess(MessageCodes.General.UPDATE_SUCCESS);
		} else {
			result.reportFailure(MessageCodes.General.UPDATE_FAIL);
		}
	}
}
