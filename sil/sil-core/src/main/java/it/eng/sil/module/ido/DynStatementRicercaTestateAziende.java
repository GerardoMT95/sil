package it.eng.sil.module.ido;

import com.engiweb.framework.base.RequestContainer;
import com.engiweb.framework.base.SourceBean;

import it.eng.afExt.dbaccess.sql.IDynamicStatementProvider;
import it.eng.afExt.utils.StringUtils;

/**
 * Effettua la ricerca dinamica di una azienda dati: - o la partita iva - o il codice fiscale - o la ragione sociale - o
 * nessuna delle precedenti (restituisce TUTTO)
 * 
 * @author Alessio Rolfini
 * 
 */
public class DynStatementRicercaTestateAziende implements IDynamicStatementProvider {

	private static final String SELECT_SQL_BASE = " select distinct "
			+ "az.prgAzienda, az.strCodiceFiscale, az.strPartitaIva, az.strRagioneSociale, "
			+ "tipoaz.strDescrizione as desTipoAzienda " + "FROM AN_AZIENDA az "
			+ "LEFT JOIN AN_UNITA_AZIENDA auz on az.prgAzienda=auz.prgAzienda "
			+ "LEFT JOIN DE_COMUNE c on auz.codcom=c.codcom "
			+ "LEFT JOIN DE_PROVINCIA p on c.CODPROVINCIA=p.codprovincia "
			+ "LEFT JOIN DE_TIPO_AZIENDA tipoaz on tipoaz.codTipoAzienda=az.codTipoAzienda "
			+ "LEFT JOIN DE_AZ_STATO stato on stato.codAzStato=auz.codAzStato ";

	/*
	 * private static final String SELECT_SQL_BASE = " select distinct " + "az.prgAzienda, az.strCodiceFiscale,
	 * az.strPartitaIva, az.strRagioneSociale, "+ "tipoaz.strDescrizione as desTipoAzienda " + "FROM AN_AZIENDA az "+
	 * "LEFT JOIN DE_TIPO_AZIENDA tipoaz on tipoaz.codTipoAzienda=az.codTipoAzienda ";
	 */

	public String getStatement(RequestContainer requestContainer, SourceBean config) {
		SourceBean req = requestContainer.getServiceRequest();

		String cf = (String) req.getAttribute("cf");
		String pi = (String) req.getAttribute("piva");
		String ragsoc = (String) req.getAttribute("RagioneSociale");
		String codTipoAzienda = (String) req.getAttribute("codTipoAzienda");
		String codAzStato = (String) req.getAttribute("codAzStato");
		String codProvincia = (String) req.getAttribute("codProvincia");
		String codComAz = (String) req.getAttribute("codComAz");
		String indirizzo = (String) req.getAttribute("indirizzo");
		String CPI = (String) req.getAttribute("codCPI");
		String flgSedeLegale = (String) req.getAttribute("flgSedeLegale");
		String naturaAz = (String) req.getAttribute("codNatGiuridica");
		String strDenominazioneAz = (String) req.getAttribute("strDenominazioneAz");

		StringBuffer query_totale = new StringBuffer(SELECT_SQL_BASE);
		StringBuffer buf = new StringBuffer();

		if ((ragsoc != null) && (!ragsoc.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			ragsoc = StringUtils.replace(ragsoc, "'", "''");
			buf.append(" UPPER(az.strRagioneSociale)  like UPPER('%" + ragsoc + "%')");
		}

		if ((pi != null) && (!pi.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" UPPER(az.strPartitaIva) like UPPER('%" + pi + "%')");
		}

		if ((cf != null) && (!cf.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" upper(az.strcodicefiscale) like upper('%" + cf + "%')");
		}

		if ((codTipoAzienda != null) && (!codTipoAzienda.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" az.codTipoAzienda = '" + codTipoAzienda + "'");
		}

		if ((codAzStato != null) && (!codAzStato.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" auz.codAzStato = '" + codAzStato + "'");
		}

		if ((naturaAz != null) && (!naturaAz.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" az.CODNATGIURIDICA = '" + naturaAz + "'");
		}

		if ((codProvincia != null) && (!codProvincia.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" p.codProvincia = '" + codProvincia + "'");
		}

		if ((codComAz != null) && !codComAz.equals("")) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" UPPER(auz.codcom) = UPPER('" + codComAz + "')");
		}

		if ((indirizzo != null) && !indirizzo.equals("")) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			indirizzo = StringUtils.replace(indirizzo, "'", "''");
			buf.append(" UPPER(auz.strIndirizzo) LIKE UPPER('%" + indirizzo + "%')");
		}

		if ((CPI != null) && !CPI.equals("")) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" c.CODCPI = '" + CPI + "'");
		}

		if ((flgSedeLegale != null) && flgSedeLegale.equals("on")) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			buf.append(" auz.flgsede like 'S' ");
		}

		if ((strDenominazioneAz != null) && (!strDenominazioneAz.equals(""))) {
			if (buf.length() == 0) {
				buf.append(" WHERE ");
			} else {
				buf.append(" AND");
			}
			strDenominazioneAz = StringUtils.replace(strDenominazioneAz, "'", "''");
			buf.append(" lower(auz.strDenominazione)  like ('%" + strDenominazioneAz.toLowerCase() + "%')");
		}

		buf.append(" order by az.strRagioneSociale ");
		query_totale.append(buf.toString());
		return query_totale.toString();

	}

}