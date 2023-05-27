package it.eng.sil.module.profil;

import com.engiweb.framework.base.SessionContainer;
import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.dispatching.module.AbstractModule;
import com.engiweb.framework.util.QueryExecutor;

import it.eng.sil.security.User;

/**
 * 
 * @author Franco Vuoto
 * @version 1.0
 */
public class ProfDettaglioProfilo extends AbstractModule {

	static org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ProfDettaglioProfilo.class.getName());
	private String className = this.getClass().getName();

	public ProfDettaglioProfilo() {
	}

	public void service(SourceBean request, SourceBean response) {
		String pool = (String) getConfig().getAttribute("POOL");
		SessionContainer sessionContainer = getRequestContainer().getSessionContainer();
		User user = (User) sessionContainer.getAttribute(User.USERID);
		SourceBean statement = null;
		SourceBean rowsSourceBean = null;

		String cdnprofilo = (String) request.getAttribute("cdnprofilo");

		try {
			if ((cdnprofilo == null) || (cdnprofilo.equals(""))) {
				cdnprofilo = (String) getServiceResponse().getAttribute("PROFSALVAPROFILO.cdnprofilo");
				request.updAttribute("cdnprofilo", cdnprofilo);
			}

			statement = (SourceBean) getConfig().getAttribute("QUERIES.SELECT_QUERY");

			rowsSourceBean = (SourceBean) QueryExecutor.executeQuery(getRequestContainer(), getResponseContainer(),
					pool, statement, "SELECT");

			it.eng.sil.util.TraceWrapper.debug(_logger, className + "::service() rowsSourceBean", rowsSourceBean);

			response.setAttribute(rowsSourceBean);
		} catch (Exception ex) {
			it.eng.sil.util.TraceWrapper.debug(_logger, className + "::service()", ex);

		}
	}
}