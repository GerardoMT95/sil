/*
 * Creato il 22-gen-04
 *
 * Per modificare il modello associato a questo file generato, aprire
 * Finestra&gt;Preferenze&gt;Java&gt;Generazione codice&gt;Codice e commenti
 */
package it.eng.sil.module.preferenze;

import java.sql.Connection;

import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.dbaccess.DataConnectionManager;
import com.engiweb.framework.dbaccess.sql.DataConnection;

import it.eng.afExt.dbaccess.sql.IDynamicStatementProvider2;
import it.eng.sil.Values;
import it.eng.sil.util.ga.db.Tabella;

/**
 * @author Franco Vuoto
 * 
 */

public class DynamicSalvaTabDecod implements IDynamicStatementProvider2 {

	static org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(DynamicSalvaTabDecod.class.getName());

	private String className = this.getClass().getName();

	public DynamicSalvaTabDecod() {
	}

	public String getStatement(SourceBean request, SourceBean response) {

		boolean skipComments = false;
		boolean showKeys = false;
		String tableName = ((String) request.getAttribute("TABLE_NAME")).toUpperCase();

		String skipCommentsStr = (String) request.getAttribute("SKIP_COMMENTS");
		if (skipCommentsStr != null) {
			skipComments = skipCommentsStr.equalsIgnoreCase("true");
		}

		String showKeysStr = (String) request.getAttribute("SHOW_KEYS");
		if (showKeysStr != null) {
			showKeys = showKeysStr.equalsIgnoreCase("true");
		}
		DataConnection dataConnection = null;
		Connection conn = null;
		Tabella tab = null;
		try {

			DataConnectionManager dataConnectionManager = DataConnectionManager.getInstance();
			dataConnection = dataConnectionManager.getConnection(Values.DB_SIL_DATI);

			conn = dataConnection.getInternalConnection();

			// oracle.jdbc.OracleConnection oracleConnection =
			// (oracle.jdbc.OracleConnection) conn;
			String userNameSQL = conn.getMetaData().getUserName();
			if (!skipComments) {
				// oracleConnection.setRemarksReporting(true);
			}
			;
			tab = new Tabella(conn, userNameSQL, tableName);
			// oracleConnection.setRemarksReporting(false);

			response.setAttribute("Tabella", tab);

		} catch (Exception ex) {

			it.eng.sil.util.TraceWrapper.debug(_logger, className + "::service()", ex);

		} finally {
			try {
				dataConnection.close();
				// conn.close();
			} catch (Exception ex) {
				it.eng.sil.util.TraceWrapper.debug(_logger, className + "::service()", ex);

			}

		}

		String query = new GenQuery(tab).generaUpdate(request, response).toString();
		_logger.debug("Query=" + query);

		return query;

	}

}