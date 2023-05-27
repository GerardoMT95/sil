package it.eng.sil.module.batch;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public final static int APPUNTAMENTI = 1;
	public final static int AZIONI_PROGRAMMATE = 2;
	public final static int CONFERMA_DID = 3;
	public final static int PERDITA_DISOCC = 4;

	public final static String BATCH_APPUNTAMENTI = "APPUNSMS";
	public final static String BATCH_AZIONE_PROGRAMMATE = "AZIONSMS";
	public final static String BATCH_CONFERMA_DID = "DIDSMS";
	public final static String BATCH_PERDITA_DISOC = "PERDISMS";

	public static final Map<String, Integer> mapBatch = new HashMap<String, Integer>();
	static {
		mapBatch.put("APPUNSMS", new Integer(1));
		mapBatch.put("AZIONSMS", new Integer(2));
		mapBatch.put("DIDSMS", new Integer(3));
		mapBatch.put("PERDISMS", new Integer(4));
	}

	public static String statementInsertArchivio = "insert into AM_MOV_APP_ARCHIVIO (PRGMOVIMENTOAPP, STRAZCODICEFISCALE, STRAZPARTITAIVA, "
			+ " STRAZRAGIONESOCIALE, CODAZATECO, CODAZCCNL, NUMAZDIPENDENTI, STRPATINAIL, STRUAINDIRIZZO, "
			+ " CODUACOM,STRUACAP,STRUATEL,STRUAFAX,STRUAEMAIL,STRUALINDIRIZZO,CODUALCOM,STRCODICEFISCALE, "
			+ " STRCOGNOME,STRNOME,STRSESSO,DATNASC,CODCOMNASC,CODCITTADINANZA,CODCOMDOM,STRINDIRIZZODOM, "
			+ " STRCAPDOM,DATSCADENZA,CODTIPOTITOLO,CODCPI,DATCOMUNICAZ,DATINIZIOMOV,CODTIPOMOV, "
			+ " CODMANSIONE,STRDESATTIVITA,CODCONTRATTO,CODMONOTEMPO,FLGSOCIO,CODCCNL,DECRETRIBUZIONEMEN, "
			+ " NUMLIVELLO,FLGLEGGE68,FLGLAVDOMICILIO,CODAGEVOLAZIONE,CODORARIO,CODMVCESSAZIONE,DATFINEMOV, "
			+ " STRNOTE,CDNUTINS,DTMINS,CDNUTMOD,DTMMOD,STRMATRICOLA,CODTIPOASS,CODNORMATIVA,CODGRADO, "
			+ " FLGARTIGIANA,DATCFL,STRNUMCFL,STRTIPOCFL,NUMMESIAPPRENDISTATO,CODMONOPROV,STRPOSINPS,CODSTATOATTO, "
			+ " FLGASSPROPRIA,STRAZINTCODICEFISCALE,STRAZINTPARTITAIVA,STRAZINTRAGIONESOCIALE,CODAZINTATECO,NUMAZINTDIPENDENTI, "
			+ " CODAZINTTIPOAZIENDA,STRUAINTINDIRIZZO,CODUAINTCOM,STRUAINTCAP,STRAZNUMALBOINTERINALI,STRNUMREGISTROCOMMITT, "
			+ " DATREGISTROCOMMITT,FLGRETRIBUZIONEMENCCNL,STRLUOGODILAVORO,CODCPILAV,DATVISITAMEDICA,STRAPPCODICEFISCALETUTORE, "
			+ " STRAPPCOGNOMETUTORE,STRAPPNOMETUTORE,NUMAPPANNIESPTUTORE,STRAPPLIVELLOTUTORE,CODAPPMANSIONETUTORE,CODAZTIPOAZIENDA, "
			+ " STRAZINTNUMCONTRATTO,DATAZINTINIZIOCONTRATTO,DATAZINTFINECONTRATTO,STRAZINTRAP,NUMAZINTSOGGETTI,NUMGGTRAMOVCOMUNICAZIONE, "
			+ " STRREFERENTE,STRNUMPRTPROVINCIA,NUMGGPREVISTIAGR,NUMGGEFFETTUATIAGR,PRGMOVIMENTOAPPCVE,FLGASSDACESS,FLGTITOLARETUTORE, "
			+ " NUMORESETT,CODCOMNASCDI,DATNASCDI,STRSESSODI,CODLAVORAZIONE,CODLIVELLOAGR,CODCATEGORIA,STRVERSIONETRACCIATO, "
			+ " CODQUALIFICASRQ,CODTIPOCOMUNIC,CODCOMUNICAZIONE,CODTIPODOCEX,STRNUMDOCEX,CODMOTIVOPERMSOGGEX,CODTIPOENTEPREV, "
			+ " STRCODICEENTEPREV,CODTIPOTRASF,CODTIPOCONTRATTO,STRCODICEFISCALEAZPREC,STRRAGIONESOCIALEAZPREC,CODCOMAZPREC,STRINDIRIZZOAZPREC, "
			+ " STRCAPAZPREC,CODATECOAZPREC,STRPATAZPREC,STRTELAZPREC,STRFAXAZPREC,STREMAILAZPREC, "
			+ " DATINIZIORAPLAV,DATFINERAPLAV,CODSOGGETTO, "
			+ " CODCOMUNICAZIONEPREC,DATFINEPRORAPLAV,DATCESSRAPLAV,CODTIPOSOMM, NUMPROTESTERNO, NUMANNOPROTESTERNO, NUMCONVENZIONE, DATCONVENZIONE, "
			+ " CODTIPOMIS, FLGLAVOROAGR, FLGDISTPARZIALE, FLGDISTAZESTERA, FLGPA, FLGPAGAMENTORIMPATRIO, FLGAZUTILIZESTERA, "
			+ " DATFINEAFFITTORAMO, STRNUMAGSOMMINISTRAZIONE, FLGSISTEMAZIONEALLOGGIATIVA, "
			+ " CODQUESTURA, STRCOGNOMELEGRAPP, STRNOMELEGRAPP, CODCITTADINANZALEGRAPP, STRSESSOLEGRAPP, DATNASCLEGRAPP, "
			+ " CODCOMNASCLEGRAPP, DATSCADENZALEGRAPP, CODTIPODOCEXLEGRAPP, STRNUMDOCEXLEGRAPP, CODMOTIVOPERMSOGGEXLEGRAPP, CODQUESTURALEGRAPP, "
			+ " FLGAZESTERA, STRCFAZESTERA, STRRAGSOCAZESTERA, CODTIPOENTEPROMOTORE, FLGSOGGINITALIA, DATFINEPERIODOFORMATIVO, FLGLAVOROINMOBILITA, "
			+ " FLGLAVOROSTAGIONALE, STRCODFISCPROMOTORETIR, FLGPROSECUZIONE, CODVARIAZIONE, STRDENOMINAZIONETIR, CODCATEGORIATIR,	CODTIPOLOGIATIR, "
			+ " CODSOGGPROMOTOREMIN, FLGASSOBBL, CODCATASSOBBL, STRUALTEL, STRUALFAX, STRUALEMAIL, STREMAILREFERENTE) "
			+ " SELECT PRGMOVIMENTOAPP, STRAZCODICEFISCALE, STRAZPARTITAIVA,STRAZRAGIONESOCIALE,CODAZATECO, "
			+ " CODAZCCNL,NUMAZDIPENDENTI,STRPATINAIL,STRUAINDIRIZZO,CODUACOM,STRUACAP,STRUATEL,STRUAFAX,STRUAEMAIL, "
			+ " STRUALINDIRIZZO,CODUALCOM,STRCODICEFISCALE,STRCOGNOME,STRNOME,STRSESSO,DATNASC,CODCOMNASC,CODCITTADINANZA, "
			+ " CODCOMDOM,STRINDIRIZZODOM,STRCAPDOM,DATSCADENZA,CODTIPOTITOLO,CODCPI,DATCOMUNICAZ,DATINIZIOMOV,CODTIPOMOV, "
			+ " CODMANSIONE,STRDESATTIVITA,CODCONTRATTO,CODMONOTEMPO,FLGSOCIO,CODCCNL,DECRETRIBUZIONEMEN,NUMLIVELLO,FLGLEGGE68, "
			+ " FLGLAVDOMICILIO,CODAGEVOLAZIONE,CODORARIO,CODMVCESSAZIONE,DATFINEMOV,STRNOTE,CDNUTINS,DTMINS,CDNUTMOD,DTMMOD, "
			+ " STRMATRICOLA,CODTIPOASS,CODNORMATIVA,CODGRADO,FLGARTIGIANA,DATCFL,STRNUMCFL,STRTIPOCFL,NUMMESIAPPRENDISTATO, "
			+ " CODMONOPROV,STRPOSINPS,CODSTATOATTO,FLGASSPROPRIA,STRAZINTCODICEFISCALE,STRAZINTPARTITAIVA,STRAZINTRAGIONESOCIALE, "
			+ " CODAZINTATECO,NUMAZINTDIPENDENTI,CODAZINTTIPOAZIENDA,STRUAINTINDIRIZZO,CODUAINTCOM,STRUAINTCAP,STRAZNUMALBOINTERINALI, "
			+ " STRNUMREGISTROCOMMITT,DATREGISTROCOMMITT,FLGRETRIBUZIONEMENCCNL,STRLUOGODILAVORO,CODCPILAV,DATVISITAMEDICA,STRAPPCODICEFISCALETUTORE, "
			+ " STRAPPCOGNOMETUTORE,STRAPPNOMETUTORE,NUMAPPANNIESPTUTORE,STRAPPLIVELLOTUTORE,CODAPPMANSIONETUTORE,CODAZTIPOAZIENDA,STRAZINTNUMCONTRATTO,DATAZINTINIZIOCONTRATTO, "
			+ " DATAZINTFINECONTRATTO,STRAZINTRAP,NUMAZINTSOGGETTI,NUMGGTRAMOVCOMUNICAZIONE,STRREFERENTE,STRNUMPRTPROVINCIA,NUMGGPREVISTIAGR,NUMGGEFFETTUATIAGR,PRGMOVIMENTOAPPCVE, "
			+ " FLGASSDACESS,FLGTITOLARETUTORE,NUMORESETT,CODCOMNASCDI,DATNASCDI,STRSESSODI,CODLAVORAZIONE,CODLIVELLOAGR,CODCATEGORIA,STRVERSIONETRACCIATO,CODQUALIFICASRQ, "
			+ " CODTIPOCOMUNIC,CODCOMUNICAZIONE,CODTIPODOCEX,STRNUMDOCEX,CODMOTIVOPERMSOGGEX,CODTIPOENTEPREV,STRCODICEENTEPREV,CODTIPOTRASF,CODTIPOCONTRATTO,STRCODICEFISCALEAZPREC, "
			+ " STRRAGIONESOCIALEAZPREC,CODCOMAZPREC,STRINDIRIZZOAZPREC,STRCAPAZPREC,CODATECOAZPREC,STRPATAZPREC,STRTELAZPREC,STRFAXAZPREC,STREMAILAZPREC, "
			+ " DATINIZIORAPLAV,DATFINERAPLAV,CODSOGGETTO,CODCOMUNICAZIONEPREC,DATFINEPRORAPLAV,DATCESSRAPLAV,CODTIPOSOMM, "
			+ " NUMPROTESTERNO, NUMANNOPROTESTERNO, NUMCONVENZIONE, DATCONVENZIONE, CODTIPOMIS, FLGLAVOROAGR, FLGDISTPARZIALE, FLGDISTAZESTERA, FLGPA, "
			+ " FLGPAGAMENTORIMPATRIO, FLGAZUTILIZESTERA, DATFINEAFFITTORAMO, STRNUMAGSOMMINISTRAZIONE, FLGSISTEMAZIONEALLOGGIATIVA, "
			+ " CODQUESTURA, STRCOGNOMELEGRAPP, STRNOMELEGRAPP, CODCITTADINANZALEGRAPP, STRSESSOLEGRAPP, DATNASCLEGRAPP, "
			+ " CODCOMNASCLEGRAPP, DATSCADENZALEGRAPP, CODTIPODOCEXLEGRAPP, STRNUMDOCEXLEGRAPP, CODMOTIVOPERMSOGGEXLEGRAPP, CODQUESTURALEGRAPP, "
			+ " FLGAZESTERA, STRCFAZESTERA, STRRAGSOCAZESTERA, CODTIPOENTEPROMOTORE, FLGSOGGINITALIA, DATFINEPERIODOFORMATIVO, FLGLAVOROINMOBILITA, "
			+ " FLGLAVOROSTAGIONALE, STRCODFISCPROMOTORETIR, FLGPROSECUZIONE, CODVARIAZIONE, STRDENOMINAZIONETIR, CODCATEGORIATIR,	CODTIPOLOGIATIR, "
			+ " CODSOGGPROMOTOREMIN, FLGASSOBBL, CODCATASSOBBL, STRUALTEL, STRUALFAX, STRUALEMAIL, STREMAILREFERENTE, "
			+ " DECRETRIBUZIONEANN, STRTRACCIATO " + " FROM AM_MOVIMENTO_APPOGGIO WHERE PRGMOVIMENTOAPP = ";

}
