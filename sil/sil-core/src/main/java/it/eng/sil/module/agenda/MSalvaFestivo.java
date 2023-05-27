package it.eng.sil.module.agenda;

import java.math.BigDecimal;
import java.util.Vector;

import com.engiweb.framework.base.SessionContainer;
import com.engiweb.framework.base.SourceBean;
import com.engiweb.framework.dbaccess.DataConnectionManager;
import com.engiweb.framework.dbaccess.Utils;
import com.engiweb.framework.dbaccess.sql.DataConnection;
import com.engiweb.framework.dbaccess.sql.SQLCommand;
import com.engiweb.framework.dbaccess.sql.result.DataResult;
import com.engiweb.framework.dbaccess.sql.result.ScrollableDataResult;
import com.engiweb.framework.dispatching.module.AbstractModule;
import com.engiweb.framework.util.QueryExecutor;

import it.eng.afExt.dbaccess.sql.DBKeyGenerator;
import it.eng.afExt.utils.LogUtils;
import it.eng.afExt.utils.MessageCodes;
import it.eng.afExt.utils.ReportOperationResult;
import it.eng.afExt.utils.StringUtils;
import it.eng.sil.Values;
import it.eng.sil.security.User;

public class MSalvaFestivo extends AbstractModule {
	private String className = this.getClass().getName();

	private String dataFineDef = "01/01/2100";

	public MSalvaFestivo() {
	}

	public void service(SourceBean request, SourceBean response) {
		String pool = (String) getConfig().getAttribute("POOL");
		SessionContainer sessionContainer = getRequestContainer().getSessionContainer();
		User user = (User) sessionContainer.getAttribute(User.USERID);
		SourceBean statement = null;
		Boolean esito = null;
		ReportOperationResult result = new ReportOperationResult(this, response);

		String prgGiornoNl = (String) request.getAttribute("PRGGIORNONL");
		boolean okApp = false;
		boolean okEv = false;
		boolean okSlot = false;
		boolean okContatti = false;
		int numGG = Integer.parseInt(request.getAttribute("NUMGG").toString());
		int numMM = Integer.parseInt(request.getAttribute("NUMMM").toString());
		String tipo = (String) request.getAttribute("tipo");
		String codCpi = (String) request.getAttribute("CODCPI");
		String data = (String) request.getAttribute("data");
		StringBuffer buf = new StringBuffer();
		String datInizioVal = StringUtils.getAttributeStrNotNull(request, "DATINIZIOVAL");
		String datFineVal = StringUtils.getAttributeStrNotNull(request, "DATFINEVAL");

		DataConnectionManager dcm = null;
		DataConnection conn = null;
		SQLCommand stmt = null;
		DataResult res = null;
		ScrollableDataResult sdr = null;
		SourceBean rowsSourceBean = null;
		SourceBean row = null;

		int i = 0;
		try {
			dcm = DataConnectionManager.getInstance();
			conn = dcm.getConnection(Values.DB_SIL_DATI);

			if ((prgGiornoNl == null) || (prgGiornoNl.equals(""))) {
				// INSERT
				BigDecimal prgGG = DBKeyGenerator.getNextSequence(Values.DB_SIL_DATI, "S_AG_GIORNONL");
				request.updAttribute("PRGGIORNONL", prgGG);
				response.setAttribute("PRGGIORNONL", prgGG.toString());

				// Devo controllare che per il giorno selezionato non ci siano
				// APPUNTAMENTI già fissati
				buf.append("SELECT COUNT(*) AS NRO FROM AG_AGENDA WHERE CODCPI='" + codCpi + "' ");

				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DTMDATAORA, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DTMDATAORA, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}

				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				BigDecimal nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okApp = true;
				}

				// Devo controllare che per il giorno di riposo selezionato nei
				// periodi di validità
				// non ci siano EVENTI già fissati
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_EVENTO WHERE CODCPIEVENTO='" + codCpi + "' ");
				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DATEVENTO, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DATEVENTO, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DATEVENTO, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DATEVENTO, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}

				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okEv = true;
				}

				// Devo controllare che per il giorno di riposo selezionato nei
				// periodi di validità
				// non ci siano CONTATTI già fissati
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_CONTATTO WHERE CODCPICONTATTO='" + codCpi + "' ");
				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DATCONTATTO, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DATCONTATTO, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DATCONTATTO, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DATCONTATTO, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}

				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okContatti = true;
				}

				// Devo controllare che per il giorno selezionato non ci siano
				// SLOT
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_SLOT WHERE CODCPI='" + codCpi + "' ");
				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DTMDATAORA, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DTMDATAORA, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}
				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okSlot = true;
				}

				if (okApp && okEv && okContatti && okSlot) {
					// Si può effettuare l'inserimento della regola
					statement = (SourceBean) getConfig().getAttribute("QUERIES.INSERT_QUERY");
					esito = (Boolean) QueryExecutor.executeQuery(getRequestContainer(), getResponseContainer(), pool,
							statement, "INSERT");
					LogUtils.logDebug("MSalvaFestivo", "Inserimento Regola Festivo", statement);

					// In caso di inserimento di una ripetizione devo effettuare
					// ulteriori controlli
					if (tipo.equals("A") && esito.booleanValue() == true) {
						// 1. Controllo giorni NL con definizione puntuale
						// compresi nel periodo di validità
						// della regola in inserimento -> vanno cancellate
						// queste regole puntuali
						buf = new StringBuffer(
								"select * from ag_giornonl where (codcpi='" + codCpi + "' or codcpi is null) ");
						buf.append("and NUMGG=" + numGG + " and NUMMM=" + numMM + " and NUMAAAA is not null ");
						buf.append(" and to_date(to_char(datinizioval,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('"
								+ datInizioVal + "', 'dd/mm/yyyy')");
						buf.append(" and to_date(to_char(datfineval,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date('"
								+ datFineVal + "', 'dd/mm/yyyy')");

						stmt = conn.createSelectCommand(buf.toString());
						res = stmt.execute();
						LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						sdr = (ScrollableDataResult) res.getDataObject();
						rowsSourceBean = sdr.getSourceBean();
						Vector rows = rowsSourceBean.getAttributeAsVector("ROW");
						BigDecimal prg = new BigDecimal("1");
						for (i = 0; i < rows.size(); i++) {
							row = (SourceBean) rows.elementAt(i);
							prg = (BigDecimal) row.getAttribute("PRGGIORNONL");
							stmt = conn.createDeleteCommand("delete from ag_giornonl where prggiornonl="
									+ prg.toString() + " and (codCpi='" + codCpi + "' or codcpi is null)  ");
							stmt.execute();
							LogUtils.logDebug("MSalvaFestivo", "delete from ag_giornonl where prggiornonl="
									+ prg.toString() + " and (codCpi='" + codCpi + "' or codcpi is null)  ", this);
						}
						// 2. Controllo giorni NL con ricorrenza annuale con
						// intersezione periodo di validità
						// sulla data di fine validità -> devo aggiornare la
						// data di inzio validità
						buf = new StringBuffer(
								"select * from ag_giornonl where (codcpi='" + codCpi + "' or codcpi is null) ");
						buf.append("and NUMGG=" + numGG + " and NUMMM=" + numMM + " and NUMAAAA is null ");
						buf.append("and to_date(to_char(datinizioval,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date('"
								+ datFineVal + "', 'dd/mm/yyyy')");
						buf.append("and to_date(to_char(datfineval, 'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('"
								+ datFineVal + "','dd/mm/yyyy')");
						buf.append(" and prggiornonl<>" + prgGG);

						stmt = conn.createSelectCommand(buf.toString());
						res = stmt.execute();
						LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						sdr = (ScrollableDataResult) res.getDataObject();
						rowsSourceBean = sdr.getSourceBean();
						rows = rowsSourceBean.getAttributeAsVector("ROW");
						BigDecimal numKlo = new BigDecimal("1");
						for (i = 0; i < rows.size(); i++) {
							row = (SourceBean) rows.elementAt(i);
							prg = (BigDecimal) row.getAttribute("PRGGIORNONL");
							numKlo = (BigDecimal) row.getAttribute("NUMKLOGIORNONL");
							numKlo = numKlo.add(new BigDecimal(1));
							buf = new StringBuffer("update ag_giornonl set datInizioVal=to_date('" + datFineVal
									+ "', 'dd/mm/yyyy')+1,");
							buf.append(" numklogiornonl=" + numKlo + " where (codCpi='" + codCpi
									+ "' or codcpi is null) and prggiornonl=" + prg.toString());
							stmt = conn.createUpdateCommand(buf.toString());
							stmt.execute();
							LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						}

						// 3. Controllo giorni NL con ricorrenza annuale con
						// intersezione periodo di validità
						// sulla data di inizio validità
						buf = new StringBuffer(
								"select * from ag_giornonl where (codcpi='" + codCpi + "' or codcpi is null) ");
						buf.append("and NUMGG=" + numGG + " and NUMMM=" + numMM + " and NUMAAAA is null ");
						buf.append("and to_date(to_char(datfineval,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('"
								+ datInizioVal + "', 'dd/mm/yyyy')");
						buf.append("and to_date(to_char(datinizioval, 'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date('"
								+ datInizioVal + "','dd/mm/yyyy')");
						buf.append(" and prggiornonl<>" + prgGG);

						stmt = conn.createSelectCommand(buf.toString());
						res = stmt.execute();
						LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						sdr = (ScrollableDataResult) res.getDataObject();
						rowsSourceBean = sdr.getSourceBean();
						rows = rowsSourceBean.getAttributeAsVector("ROW");
						for (i = 0; i < rows.size(); i++) {
							row = (SourceBean) rows.elementAt(i);
							prg = (BigDecimal) row.getAttribute("PRGGIORNONL");
							numKlo = (BigDecimal) row.getAttribute("NUMKLOGIORNONL");
							numKlo = numKlo.add(new BigDecimal(1));
							buf = new StringBuffer("update ag_giornonl set datFineVal=to_date('" + datInizioVal
									+ "', 'dd/mm/yyyy')-1,");
							buf.append(" numklogiornonl=" + numKlo + " where (codCpi='" + codCpi
									+ "' or codcpi is null) and prggiornonl=" + prg.toString());
							stmt = conn.createUpdateCommand(buf.toString());
							res = stmt.execute();
							LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						}

					} // fine if(tipo.equals("A") && esito.booleanValue() ==
						// true)
				} // fine if(okApp)
				else {
					esito = new Boolean(false);
					if (tipo.equals("A")) {
						result.reportFailure(MessageCodes.Agenda.APPUNTAMENTI_NEGLI_ANNI);
					} else {
						result.reportFailure(MessageCodes.Agenda.APPUNTAMENTI_NEL_GIORNO);
					}
				}

				// fine insert : if ((prgGiornoNl == null) ||
				// (prgGiornoNl.equals("")))
			} else {
				// UPDATE
				// Devo controllare che per il giorno selezionato non ci siano
				// APPUNTAMENTI già fissati
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_AGENDA WHERE CODCPI='" + codCpi + "' ");

				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DTMDATAORA, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DTMDATAORA, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}

				stmt = conn.createSelectCommand(buf.toString());
				res = stmt.execute();
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				BigDecimal nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okApp = true;
				}

				// Devo controllare che per il giorno di riposo selezionato nei
				// periodi di validità
				// non ci siano EVENTI già fissati
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_EVENTO WHERE CODCPIEVENTO='" + codCpi + "' ");
				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DATEVENTO, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DATEVENTO, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DATEVENTO, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DATEVENTO, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}

				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okEv = true;
				}

				// Devo controllare che per il giorno di riposo selezionato nei
				// periodi di validità
				// non ci siano CONTATTI già fissati
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_CONTATTO WHERE CODCPICONTATTO='" + codCpi + "' ");
				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DATCONTATTO, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DATCONTATTO, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DATCONTATTO, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DATCONTATTO, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}

				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okContatti = true;
				}

				// Devo controllare che per il giorno selezionato non ci siano
				// SLOT
				buf = new StringBuffer();
				buf.append("SELECT COUNT(*) AS NRO FROM AG_SLOT WHERE CODCPI='" + codCpi + "' ");
				if (tipo.equals("O")) {
					// solo oggi
					buf.append(" and to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'),'dd/mm/yyyy')=");
					buf.append("to_date('" + data + "', 'dd/mm/yyyy') ");
					request.updAttribute("DATINIZIOVAL", data);
					request.updAttribute("DATFINEVAL", data);
				} else {
					// ripetizione annuale
					if (datInizioVal.equals("")) {
						datInizioVal = data;
					}
					if (datFineVal.equals("")) {
						datFineVal = dataFineDef;
					}
					buf.append(" and to_number(to_char(DTMDATAORA, 'dd'))=" + numGG);
					buf.append(" and to_number(to_char(DTMDATAORA, 'mm'))=" + numMM);
					buf.append(" and ( to_date(to_char(DTMDATAORA, 'dd/mm/yyyy'), 'dd/mm/yyyy') ");
					buf.append(" BETWEEN to_date('" + datInizioVal + "', 'dd/mm/yyyy') and ");
					buf.append(" to_date('" + datFineVal + "', 'dd/mm/yyyy') )");
					request.updAttribute("NUMAAAA", "");
					request.updAttribute("DATINIZIOVAL", datInizioVal);
					request.updAttribute("DATFINEVAL", datFineVal);
				}
				stmt = conn.createSelectCommand(buf.toString());
				LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
				res = stmt.execute();
				sdr = (ScrollableDataResult) res.getDataObject();
				rowsSourceBean = sdr.getSourceBean();
				nro = (BigDecimal) rowsSourceBean.getAttribute("ROW.NRO");
				if (nro.equals(new BigDecimal(0))) {
					okSlot = true;
				}

				if (okApp && okContatti && okEv && okSlot) {
					// Si può effettuare la modifica della regola
					statement = (SourceBean) getConfig().getAttribute("QUERIES.UPDATE_QUERY");
					esito = (Boolean) QueryExecutor.executeQuery(getRequestContainer(), getResponseContainer(), pool,
							statement, "UPDATE");
					LogUtils.logDebug("MSalvaFestivo", "Modifica Regola Festivo", statement);

					// In caso di MODIFICA di una ripetizione devo effettuare
					// ulteriori controlli
					if (tipo.equals("A") && esito.booleanValue() == true) {
						// 1. Controllo giorni NL con definizione puntuale
						// compresi nel periodo di validità
						// della regola in inserimento -> vanno cancellate
						// queste regole puntuali
						buf = new StringBuffer(
								"select * from ag_giornonl where (codcpi='" + codCpi + "' or codcpi is null) ");
						buf.append("and NUMGG=" + numGG + " and NUMMM=" + numMM + " and NUMAAAA is not null ");
						buf.append(" and to_date(to_char(datinizioval,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('"
								+ datInizioVal + "', 'dd/mm/yyyy')");
						buf.append(" and to_date(to_char(datfineval,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date('"
								+ datFineVal + "', 'dd/mm/yyyy')");

						stmt = conn.createSelectCommand(buf.toString());
						res = stmt.execute();
						LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						sdr = (ScrollableDataResult) res.getDataObject();
						rowsSourceBean = sdr.getSourceBean();
						Vector rows = rowsSourceBean.getAttributeAsVector("ROW");
						BigDecimal prg = new BigDecimal("1");
						for (i = 0; i < rows.size(); i++) {
							row = (SourceBean) rows.elementAt(i);
							prg = (BigDecimal) row.getAttribute("PRGGIORNONL");
							stmt = conn.createDeleteCommand("delete from ag_giornonl where prggiornonl="
									+ prg.toString() + " and (codCpi='" + codCpi + "' or codcpi is null)  ");
							stmt.execute();
							LogUtils.logDebug("MSalvaFestivo", "delete from ag_giornonl where prggiornonl="
									+ prg.toString() + " and (codCpi='" + codCpi + "' or codcpi is null)  ", this);
						}
						// 2. Controllo giorni NL con ricorrenza annuale con
						// intersezione periodo di validità
						// sulla data di fine validità -> devo aggiornare la
						// data di inzio validità
						buf = new StringBuffer(
								"select * from ag_giornonl where (codcpi='" + codCpi + "' or codcpi is null) ");
						buf.append("and NUMGG=" + numGG + " and NUMMM=" + numMM + " and NUMAAAA is null ");
						buf.append("and to_date(to_char(datinizioval,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date('"
								+ datFineVal + "', 'dd/mm/yyyy')");
						buf.append("and to_date(to_char(datfineval, 'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('"
								+ datFineVal + "','dd/mm/yyyy')");
						buf.append(" and prggiornonl<>" + prgGiornoNl);

						stmt = conn.createSelectCommand(buf.toString());
						res = stmt.execute();
						LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						sdr = (ScrollableDataResult) res.getDataObject();
						rowsSourceBean = sdr.getSourceBean();
						rows = rowsSourceBean.getAttributeAsVector("ROW");
						BigDecimal numKlo = new BigDecimal("1");
						for (i = 0; i < rows.size(); i++) {
							row = (SourceBean) rows.elementAt(i);
							prg = (BigDecimal) row.getAttribute("PRGGIORNONL");
							numKlo = (BigDecimal) row.getAttribute("NUMKLOGIORNONL");
							numKlo = numKlo.add(new BigDecimal(1));
							buf = new StringBuffer("update ag_giornonl set datInizioVal=to_date('" + datFineVal
									+ "', 'dd/mm/yyyy')+1,");
							buf.append(" numklogiornonl=" + numKlo + " where (codCpi='" + codCpi
									+ "' or codcpi is null) and prggiornonl=" + prg.toString());
							stmt = conn.createUpdateCommand(buf.toString());
							stmt.execute();
							LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						}

						// 3. Controllo giorni NL con ricorrenza annuale con
						// intersezione periodo di validità
						// sulla data di inizio validità
						buf = new StringBuffer(
								"select * from ag_giornonl where (codcpi='" + codCpi + "' or codcpi is null) ");
						buf.append("and NUMGG=" + numGG + " and NUMMM=" + numMM + " and NUMAAAA is null ");
						buf.append("and to_date(to_char(datfineval,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('"
								+ datInizioVal + "', 'dd/mm/yyyy')");
						buf.append("and to_date(to_char(datinizioval, 'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date('"
								+ datInizioVal + "','dd/mm/yyyy')");
						buf.append(" and prggiornonl<>" + prgGiornoNl);

						stmt = conn.createSelectCommand(buf.toString());
						res = stmt.execute();
						LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						sdr = (ScrollableDataResult) res.getDataObject();
						rowsSourceBean = sdr.getSourceBean();
						rows = rowsSourceBean.getAttributeAsVector("ROW");
						for (i = 0; i < rows.size(); i++) {
							row = (SourceBean) rows.elementAt(i);
							prg = (BigDecimal) row.getAttribute("PRGGIORNONL");
							numKlo = (BigDecimal) row.getAttribute("NUMKLOGIORNONL");
							numKlo = numKlo.add(new BigDecimal(1));
							buf = new StringBuffer("update ag_giornonl set datFineVal=to_date('" + datInizioVal
									+ "', 'dd/mm/yyyy')-1,");
							buf.append(" numklogiornonl=" + numKlo + " where (codCpi='" + codCpi
									+ "' or codcpi is null) and prggiornonl=" + prg.toString());
							stmt = conn.createUpdateCommand(buf.toString());
							res = stmt.execute();
							LogUtils.logDebug("MSalvaFestivo", buf.toString(), this);
						}

					} // fine if(tipo.equals("A") && esito.booleanValue() ==
						// true)
				} // fine if(okApp)
				else {
					esito = new Boolean(false);
					if (tipo.equals("A")) {
						result.reportFailure(MessageCodes.Agenda.APPUNTAMENTI_NEGLI_ANNI);
					} else {
						result.reportFailure(MessageCodes.Agenda.APPUNTAMENTI_NEL_GIORNO);
					}
				}

			}
		} catch (Exception e) {
			esito = new Boolean(false);
			result.reportFailure(e, className, "Errore nell'inserimento/modifica regola giorno festivo");
		} finally {
			Utils.releaseResources(conn, stmt, res);
		}

		if ((esito != null) && (esito.booleanValue() == true)) {
			result.reportSuccess(MessageCodes.General.UPDATE_SUCCESS);
		} else {
			result.reportFailure(MessageCodes.General.UPDATE_FAIL);
		}
	}
}
