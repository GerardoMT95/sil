package it.eng.sil.action.report.patto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Vector;

import com.engiweb.framework.base.RequestContainer;
import com.engiweb.framework.base.SourceBean;
import com.inet.report.Area;
import com.inet.report.BorderProperties;
import com.inet.report.Element;
import com.inet.report.Engine;
import com.inet.report.Field;
import com.inet.report.FieldPart;
import com.inet.report.GeneralProperties;
import com.inet.report.Paragraph;
import com.inet.report.Picture;
import com.inet.report.PromptField;
import com.inet.report.RDC;
import com.inet.report.Section;
import com.inet.report.Subreport;
import com.inet.report.Text;
import com.inet.report.TextPart;

import it.eng.afExt.utils.DateUtils;
import it.eng.afExt.utils.MessageCodes;
import it.eng.afExt.utils.StringUtils;
import it.eng.afExt.utils.TransactionQueryExecutor;
import it.eng.sil.action.report.utils.inet.ReportUtils;
import it.eng.sil.action.report.utils.inet.Style;
import it.eng.sil.action.report.utils.inet.StyleFactory;
import it.eng.sil.action.report.utils.inet.StyleUtils;
import it.eng.sil.module.patto.MansioniRow;
import it.eng.sil.module.voucher.Properties;
import it.eng.sil.security.User;
import it.eng.sil.util.Utils;
import it.eng.sil.util.amministrazione.impatti.PattoBean;

/**
 * 
 * @author Administrator
 */
public class ApiAccordoGenerico_UMB {
	Style campo;
	Style titoloSezione;
	Style etichetta;
	Style etichetta2;
	Style titolo2;
	Style titolo3;
	Style titolo2Centrato;
	StyleFactory styleFactory;
	/**
	 * estremo sinistro del report da cui poter scrivere (in decimi di millimetro)
	 */
	private int LEFT = 80;
	private int LEFT_TITOLO_PUNTO = LEFT;
	private int LEFT_TITOLO_PUNTO_T = LEFT_TITOLO_PUNTO + 100;

	private int ACCETTAZIONELENMAXLAV = 30;
	private int SPAZI_TRA_OPERATORE_LAV = 85;
	private int SPAZI_TRA_OPERATORE_LAV_MIN = 90;
	//
	private SourceBean statoOccupazionale = null;
	private Vector ambitoProfessionale = null;
	private SourceBean cat181 = null;
	private Vector appuntamenti = null;
	private Vector azioniConcordate = null;
	private SourceBean infoGenerali = null;
	private SourceBean operatore = null;
	private Vector impegni = null;
	private Vector laurea;
	private Vector movimenti;
	private String docInOut;
	private String regione;
	private Vector<String> programmiAperti;
	private static final String[] misureGG = { PattoBean.DB_MISURE_GARANZIA_GIOVANI,
			PattoBean.DB_MISURE_NUOVA_GARANZIA_GIOVANI, PattoBean.DB_MISURE_GARANZIA_GIOVANI_UMBRIA,
			PattoBean.DB_MISURE_NUOVA_GARANZIA_GIOVANI_UMBRIA };
	//

	private String datProtocollazione;
	private String codMonoIO;
	private String riferimentoDoc;
	//
	private Engine eng = null;
	private String installAppPath = null;

	private String fileType = Engine.EXPORT_PDF;

	private String privacy;

	private String flgPattoOnline;

	private Vector soggettiAccreditati = null;
	private TransactionQueryExecutor txExec = null;

	public void setSoggettiAccreditati(Vector soggettiAccreditati) {
		this.soggettiAccreditati = soggettiAccreditati;
	}

	public void setTransaction(TransactionQueryExecutor txExecCurr) {
		this.txExec = txExecCurr;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setInstallAppPath(String installAppPath) {
		this.installAppPath = installAppPath;
	}

	/**
	 * Viene impostato il tipo di report da generare (il tipo nostro viene mappato col tipo interno di crystal clear)
	 * 
	 * @param tipoFile
	 *            e' l'estensione del file del report (es. pdf, doc)
	 */
	public void setFileType(String tipoFile) {
		if (tipoFile.equalsIgnoreCase("PDF"))
			this.fileType = Engine.EXPORT_PDF;
		else if (tipoFile.equalsIgnoreCase("RTF"))
			this.fileType = Engine.EXPORT_RTF;
		else if (tipoFile.equalsIgnoreCase("HTML"))
			this.fileType = Engine.EXPORT_HTML;
		else if (tipoFile.equalsIgnoreCase("XLS"))
			this.fileType = Engine.EXPORT_XLS;
		else
			this.fileType = Engine.EXPORT_PDF;
	}

	public void setRiferimentoDoc(String s) {
		this.riferimentoDoc = s;
	}

	public void setInfoGenerali(SourceBean infoGenerali) {
		this.infoGenerali = infoGenerali;
	}

	public void setAzioniConcordate(Vector azioniConcordate) {
		this.azioniConcordate = azioniConcordate;
	}

	public void setAppuntamenti(Vector appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	public void setStatoOccupazionale(SourceBean statoOccupazionale) {
		this.statoOccupazionale = statoOccupazionale;
	}

	public void setAmbitoProfessionale(Vector ambitoProfessionale) throws Exception {
		this.ambitoProfessionale = MansioniRow.getMansioni(ambitoProfessionale);
	}

	public void setImpegni(Vector impegni) {
		this.impegni = impegni;
	}

	public void setCat181(SourceBean cat181) {
		this.cat181 = cat181;
	}

	public void setOperatore(SourceBean operatore) {
		this.operatore = operatore;
	}

	public void setLaurea(Vector laurea) {
		this.laurea = laurea;
	}

	public void setMovimenti(Vector movimenti) {
		this.movimenti = movimenti;
	}

	public Engine getEngine() {
		return this.eng;
	}

	public void setDatProtocollazione(String s) {
		this.datProtocollazione = s;
	}

	public void setCodMonoIO(String s) {
		this.codMonoIO = s;
	}

	public void setDocInOut(String s) {
		this.docInOut = s;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	/** Creates a new instance of Patto */
	public ApiAccordoGenerico_UMB() {
		styleFactory = new StyleFactory();
		campo = styleFactory.getStyle(StyleFactory.CAMPO);
		titoloSezione = styleFactory.getStyle(StyleFactory.TITOLO_SEZIONE);
		etichetta = styleFactory.getStyle(StyleFactory.ETICHETTA);
		etichetta2 = styleFactory.getStyle(StyleFactory.ETICHETTA2);
		titolo2 = styleFactory.getStyle(StyleFactory.TITOLO2);
		titolo3 = styleFactory.getStyle(StyleFactory.TITOLO3);
		titolo2Centrato = styleFactory.getStyle(StyleFactory.TITOLO2CENTRATO);

	}

	public ApiAccordoGenerico_UMB(String[] a) throws Exception {
		start();
	}

	public void inizializza(SourceBean infoGen, SourceBean statoOcc, Vector appuntaments, SourceBean operatore,
			Vector azioniConcordats, Vector ambitoProfs, Vector impegniV, String installAppPath, String tipoFile,
			SourceBean cat181, Vector titoloStudio, Vector mov, String ambito, String strParam, String docInOut,
			String regione, SourceBean documentoIdentita, String privacy, Vector soggetti,
			TransactionQueryExecutor txExec) throws Exception {
		try {

			this.setInfoGenerali(infoGen);
			this.setStatoOccupazionale(statoOcc);
			this.setAppuntamenti(appuntaments);
			this.setAzioniConcordate(azioniConcordats);
			this.setAmbitoProfessionale(ambitoProfs);
			if (operatore != null) {
				this.setOperatore(operatore);
			}
			this.setImpegni(impegniV);
			this.setInstallAppPath(installAppPath);
			this.setFileType(tipoFile);
			this.setCat181(cat181);
			this.setLaurea(titoloStudio);
			this.setMovimenti(mov);
			this.setRiferimentoDoc(ambito);
			this.regione = regione;
			this.setPrivacy(privacy);
			this.setSoggettiAccreditati(soggetti);
			if (txExec != null) {
				this.setTransaction(txExec);
			}

			if (strParam != null && !strParam.equals("")) {
				this.setDatProtocollazione(strParam);
			}

			if (strParam != null && !strParam.equals("")) {
				this.setCodMonoIO(strParam);
				if (strParam.equalsIgnoreCase("I"))
					this.setDocInOut("Input");
				else
					this.setDocInOut("Output");
			}
			if (this.infoGenerali != null) {
				BigDecimal prgPattoLav = (BigDecimal) this.infoGenerali.getAttribute("prgpattolavoratore");
				this.programmiAperti = PattoBean.checkProgrammi(prgPattoLav, this.txExec);
				this.flgPattoOnline = this.infoGenerali.containsAttribute("FLGPATTOONLINE")
						? this.infoGenerali.getAttribute("FLGPATTOONLINE").toString()
						: "";
			}
			this.start();
		} catch (Exception e) {
			throw e;
		}
	}

	public void start() throws Exception {
		try {
			eng = RDC.createEmptyEngine(getFileType());
			eng.setReportTitle("Patto");
			eng.setLocale(new Locale("IT", "it"));
			// ReportUtils.initReport(eng);
			ReportUtils.initReportSenzaMarginiPattoUMB(eng, this.installAppPath);
			// inserisco il parametro del numero di protocollo in modo che se si
			// verifica che il numero di protocollo
			// reale differisce da quello visualizzato nel form di stampa, possa
			// essere sostituito appunto da quello reale.
			// Questa operazione avviene in modo trasparente nella fase di
			// protocollazione nella classe Documento.
			PromptField pNumProt = ReportUtils.addPromptField("numProt", PromptField.STRING, "numero di protocollo",
					eng);
			PromptField pAnnoProt = ReportUtils.addPromptField("numAnnoProt", PromptField.STRING,
					"anno di protocollazione", eng);
			PromptField pDataProt = ReportUtils.addPromptField("dataProt", PromptField.STRING,
					"data di protocollazione", eng);
			// si imposta il valore del parametro col numero di protocollo
			// spedito dal form di stampa
			//

			/***********************************************************************************************************/
			Area header = eng.getArea("RH"); // Report Header
			header.setSuppress(false);
			Section secRH = header.getSection(0);
			secRH.setHeight(StyleUtils.toTwips(100));

			Area ph = eng.getArea("PH"); // Page Header
			ph.setSuppress(true);
			ph.getSection(0).setHeight(0);

			intestazione(secRH, header); // Logo + 2 titoli principali -- i due loghi in alto vanno nella stessa sezione
											// così come gli altri titoli presenti nell'intestazione
			testataCPIUmbria(secRH, header, infoGenerali); // Indirizzo - telefono - email

			// Sezione Detail : sezione indirizzo, telefono, email
			Area details = eng.getArea("D");
			protocollazione(details, pNumProt, pAnnoProt, pDataProt);
			/***********************************************************************************************************/

			addBR(details, 50);
			titoloMinore(details);

			datiCPI(details, infoGenerali);
			datiLavoratore(details, infoGenerali);

			addBR(details, 40);
			impegni(details, impegni);

			//
			addBR(details, 40);
			azioniAccordo(details, azioniConcordate);

			//
			addBR(details, 40);
			appuntamentiAccordo(details, appuntamenti);

			//
			addBR(details, 40);
			informazioniUtente(details, infoGenerali);
			// fine del report
			Section section = details.addSection();
			//
			// generazione del sorgente xml per eventuale debugging col desiger
			//
			// System.out.println("costruzione report terminata. Salvataggio su
			// file");
			// RDC.saveEngine(new File("C:/pattoTEST.rpt"), eng);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sezione protocollazione
	 * 
	 * @param pField
	 *            il prompt field del numero di protocollo
	 */
	private void protocollazione(Area details, Field numProt, Field annoProt, Field dataProt) throws Exception {
		Section section = details.addSection();
		// Text t = ReportUtils.addText(section, "Anno ", etichetta, LEFT, 500);
		// ReportUtils.addTextPart(t.getParagraph(0), this.numAnnoProt, campo);
		Text t = ReportUtils.addTextWithFont(section, "Anno ", etichetta, LEFT, 500, "SansSerif");
		FieldPart tp = t.getParagraph(0).addFieldPart(annoProt);
		tp.setX(0);
		campo.setStyle(tp);
		tp.setFontName("SansSerif");
		t = ReportUtils.addTextFont(section, "Num ", etichetta, 420, "SansSerif");
		// t = ReportUtils.addText(section, "Num ", etichetta, 420);
		// ReportUtils.addTextPart(t.getParagraph(0), this.numProtocolloStr,
		// campo);
		// inserisco il promptField nel campo di visualizzazione del numero di
		// protocollo
		// per questa operazione non esiste una utilità
		tp = t.getParagraph(0).addFieldPart(numProt);
		tp.setX(0);
		campo.setStyle(tp);
		tp.setFontName("SansSerif");
		t = ReportUtils.addTextFont(section, "Data di prot. ", etichetta, 920, "SansSerif");
		// t = ReportUtils.addText(section, "Data di prot. ", etichetta, 920);
		// ReportUtils.addTextPart(t.getParagraph(0), this.datProtocollazione,
		// campo);
		tp = t.getParagraph(0).addFieldPart(dataProt);
		tp.setX(0);
		campo.setStyle(tp);
		tp.setFontName("SansSerif");

		// TODO: logo europa
		// String installAppPath = ConfigSingleton.getRootPath() + java.io.File.separatorChar;
		// if(regione.equals(RER)) {
		// section.addPicture(section.getWidth() - 1680, 0, 1680, 1560, installAppPath +
		// "WEB-INF/report/img/logoUE112x104.jpg");
		// }
		section = details.addSection();
		// t = ReportUtils.addText(section, "Doc. di ", etichetta, LEFT);
		t = ReportUtils.addTextFont(section, "Doc. di ", etichetta, LEFT, "SansSerif");
		// ReportUtils.addTextPart(t.getParagraph(0), this.docInOut, campo);
		ReportUtils.addTextPartWithFont(t.getParagraph(0), this.docInOut, campo, "SansSerif");
		t = ReportUtils.addTextFont(section, "Rif. ", etichetta, 420, "SansSerif");
		ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), this.riferimentoDoc, campo, "SansSerif", 9);
	}

	private void titoloMinore(Area details) throws Exception {
		Section section = details.addSection();
		String s = "Accordo per il lavoro per adesione alle misure concordate con il Centro per l'Impiego";
		// ReportUtils.addText(section, s, etichetta, LEFT);
		ReportUtils.addTextFont(section, s, etichetta, LEFT, "SansSerif");
	}

	/**
	 * sezione dati CPI rivista
	 * 
	 * @param infoGenerali
	 */
	private void datiCPI(Area details, SourceBean infoGenerali) throws Exception {
		if (infoGenerali == null)
			infoGenerali = new SourceBean("");

		String cpi = Utils.notNull(infoGenerali.getAttribute("CPI"));
		String via = Utils.notNull(infoGenerali.getAttribute("INDIRIZZO"));
		String tel = Utils.notNull(infoGenerali.getAttribute("TEL"));
		String fax = Utils.notNull(infoGenerali.getAttribute("FAX"));
		String email = Utils.notNull(infoGenerali.getAttribute("EMAIL"));

		Section section = details.addSection();
		// ReportUtils.addText(section, "Tra", etichetta, LEFT + 800);
		ReportUtils.addTextFont(section, "Tra", etichetta, LEFT + 800, "SansSerif");

		section = details.addSection();
		Text t = ReportUtils.addTextFont(section, "Centro per l'impiego di " + cpi.toUpperCase(), etichetta, LEFT,
				"SansSerif");

		section = details.addSection();
		t = ReportUtils.addTextFont(section, "indirizzo: ", etichetta, LEFT, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), via, etichetta, "SansSerif");

		section = details.addSection();
		t = ReportUtils.addTextFont(section, "tel.: ", etichetta, LEFT, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), tel, etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), "   fax: ", etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), fax, etichetta, "SansSerif");

		section = details.addSection();
		t = ReportUtils.addTextFont(section, "email: ", etichetta, LEFT, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), email, etichetta, "SansSerif");
	}

	/**
	 * sezione dati lavoratore
	 * 
	 * @param details
	 * @param infoLavoratore
	 */
	private void datiLavoratore(Area details, SourceBean infoLavoratore) throws Exception {
		if (infoLavoratore == null)
			infoLavoratore = new SourceBean("");

		String nome = Utils.notNull(infoLavoratore.getAttribute("NOMELAVORATORE"));
		String cognome = Utils.notNull(infoLavoratore.getAttribute("COGNOMELAVORATORE"));
		String codiceFiscale = (String) infoLavoratore.getAttribute("STRCODICEFISCALE");
		String luogoNascita = Utils.notNull(infoLavoratore.getAttribute("com_nasc"));
		String dataNascita = Utils.notNull(infoLavoratore.getAttribute("dat_nasc"));
		String comDomicilio = Utils.notNull(infoLavoratore.getAttribute("com_dom"));
		String indDomicilio = Utils.notNull(infoLavoratore.getAttribute("strindirizzodom"));
		String telefono = Utils.notNull(infoLavoratore.getAttribute("strteldom"));
		String email = Utils.notNull(infoLavoratore.getAttribute("stremail"));
		String indiceProfilo = Utils.notNull(infoLavoratore.getAttribute("numindicesvantaggio150"));
		String dataRiferimento = Utils.notNull(infoLavoratore.getAttribute("datriferimento150"));
		String indiceGG = Utils.notNull(infoLavoratore.getAttribute("numindicesvantaggio2"));
		String dataRiferimentoGG = Utils.notNull(infoLavoratore.getAttribute("datriferimento"));

		Section section = details.addSection();
		ReportUtils.addText(section, "e", etichetta, LEFT + 800);

		section = details.addSection();
		StringBuilder datiLav = new StringBuilder("il/la Signor/a ").append(nome).append(" ").append(cognome);
		Text t = ReportUtils.addTextFont(section, datiLav.toString(), etichetta, LEFT, "SansSerif");

		section = details.addSection();
		t = ReportUtils.addTextFont(section, "codice fiscale ", etichetta, LEFT, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), codiceFiscale, etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), " nato/a a ", etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), luogoNascita, etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), ", il ", etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), dataNascita, etichetta, "SansSerif");

		section = details.addSection();
		t = ReportUtils.addTextFont(section, "domiciliato/a a ", etichetta, LEFT, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), comDomicilio, etichetta, "SansSerif");
		ReportUtils.addTextPartWithFont(t.getParagraph(0), " " + indDomicilio.trim(), etichetta, "SansSerif");

		if (!telefono.equals("")) {
			section = details.addSection();
			t = ReportUtils.addTextFont(section, "numero di telefono: ", etichetta, LEFT, "SansSerif");
			ReportUtils.addTextPartWithFont(t.getParagraph(0), telefono, etichetta, "SansSerif");
		}

		if (!email.equals("")) {
			section = details.addSection();
			t = ReportUtils.addTextFont(section, "indirizzo di posta elettronica: ", etichetta, LEFT, "SansSerif");
			ReportUtils.addTextPartWithFont(t.getParagraph(0), email, etichetta, "SansSerif");
		}

		if (!indiceProfilo.equals("")) {
			section = details.addSection();
			t = ReportUtils.addTextFont(section, "indice del profilo personale di occupabilità: ", etichetta, LEFT,
					"SansSerif");
			ReportUtils.addTextPartWithFont(t.getParagraph(0), indiceProfilo, etichetta, "SansSerif");
		}

		if (!dataRiferimento.equals("")) {
			section = details.addSection();
			t = ReportUtils.addTextFont(section, "data di riferimento: ", etichetta, LEFT, "SansSerif");
			ReportUtils.addTextPartWithFont(t.getParagraph(0), dataRiferimento, etichetta, "SansSerif");
		}

		if (!indiceGG.equals("")) {
			section = details.addSection();
			t = ReportUtils.addTextFont(section, "indice GG: ", etichetta, LEFT, "SansSerif");
			ReportUtils.addTextPartWithFont(t.getParagraph(0), indiceGG, etichetta, "SansSerif");
		}

		if (!dataRiferimentoGG.equals("")) {
			section = details.addSection();
			t = ReportUtils.addTextFont(section, "data di riferimento GG: ", etichetta, LEFT, "SansSerif");
			ReportUtils.addTextPartWithFont(t.getParagraph(0), dataRiferimentoGG, etichetta, "SansSerif");
		}
	}

	/**
	 * sezione impegni lavoratore ed impegni cpi
	 */
	private void impegni(Area details, Vector impegni) throws Exception {

		Style s = (Style) etichetta.clone();
		s.setFontSize(12);
		Section section = details.addSection();
		ReportUtils.addTextFont(section, "In rispetto del presente Accordo l'utente si impegna a:", s, LEFT,
				"SansSerif");
		addBR(details, 20);
		Vector impegniLavoratore = new Vector();
		for (int i = 0; i < impegni.size(); i++) {
			// vengono selezionati gli impegni del lavoratore (codice 'S')
			SourceBean impegno = (SourceBean) impegni.get(i);
			String codiceImp = (String) impegno.getAttribute("codMonoImpegnoDi");
			if (Utils.notNull(codiceImp).equals("S"))
				impegniLavoratore.add(impegno);
		}
		// nel vettore impegni rimangono gli impegni del cpi (vengono tolti gli
		// impegni del lavoratore)
		impegni.removeAll(impegniLavoratore);
		impegniLavoratore(details, impegniLavoratore);
		addBR(details, 20);
		section = details.addSection();
		ReportUtils.addTextFont(section,
				"Il mancato rispetto degli impegni assunti anche in caso di convocazione con mezzi informali (sms / email)  comporterà la sospensione del presente patto e di tutte le misure in esso contenute.",
				etichetta, LEFT, "SansSerif");
		addBR(details, 20);
		section = details.addSection();
		ReportUtils.addTextFont(section, "Il CPI si impegna a:", s, LEFT, "SansSerif");
		addBR(details, 20);
		impegniCPI(details, impegni);
	}

	/**
	 * Gli impegni del lavoratore vengono stampati in un elenco puntato
	 */
	private void impegniLavoratore(Area details, Vector impegniLavoratore) throws Exception {
		if (impegniLavoratore == null)
			return;

		for (int i = 0; i < impegniLavoratore.size(); i++) {
			SourceBean row = (SourceBean) impegniLavoratore.get(i);
			titoloPuntato(details, (String) row.getAttribute("strDescrizione"), etichetta);
			// impegni(details, row);
		}
	}

	/**
	 * Gli impegni del cpi vengono stampati in un elenco puntato
	 */
	private void impegniCPI(Area details, Vector impegniCpi) throws Exception {
		if (impegniCpi == null)
			return;

		for (int i = 0; i < impegniCpi.size(); i++) {
			SourceBean row = (SourceBean) impegniCpi.get(i);
			titoloPuntato(details, (String) row.getAttribute("strDescrizione"), etichetta);
			// impegni(details, row);
		}
	}

	/**
	 * Sezione misure: azioni collegate al patto per gli esiti proposto/in corso, avviato, concluso, rifiutato,
	 * interrotto
	 */
	@SuppressWarnings("rawtypes")
	private void azioniAccordo(Area details, Vector azioni) throws Exception {

		if (!azioni.isEmpty()) {
			Section section = details.addSection();
			String temp = "L'accordo prevede i programmi/aree indicati di seguito: ";
			ReportUtils.addTextFont(section, temp, etichetta, LEFT, "SansSerif");
			addBR(details, 40);
			User user = (User) RequestContainer.getRequestContainer().getSessionContainer().getAttribute("@@USER@@");
			String azione_ragg_before = "";
			String colloquio_before = "";
			for (int i = 0; i < azioni.size(); i++) {
				SourceBean programma = (SourceBean) azioni.get(i);
				boolean flgProgramma = false;
				String codMonoProgramma = programma.containsAttribute("CODMONOPROGRAMMA")
						? programma.getAttribute("CODMONOPROGRAMMA").toString()
						: "";
				if (codMonoProgramma != null && !codMonoProgramma.equals("")) {
					flgProgramma = true;
				}
				String colloquio = programma.getAttribute("PRGCOLLOQUIO").toString();
				String dataInizio = Utils.notNull(programma.getAttribute("dataInizioProg"));
				String dataFine = Utils.notNull(programma.getAttribute("dataFineProg"));
				String descrProgrServ = Utils.notNull(programma.getAttribute("descrizioneProgramma"));
				String azione_ragg = programma.getAttribute("azione_ragg").toString();
				String codServizio = programma.getAttribute("codServizio").toString();

				if ((user.getCodTipo().equalsIgnoreCase(Properties.SOGGETTO_ACCREDITATO)
						&& codServizio.equals(MessageCodes.Patto.COD_SERVIZIO_URI))
						|| !user.getCodTipo().equalsIgnoreCase(Properties.SOGGETTO_ACCREDITATO)) {

					if (!colloquio_before.equalsIgnoreCase(colloquio)) {
						addBR(details, 20);
						section = details.addSection();
						Text t;
						if (flgProgramma) {
							t = ReportUtils.addTextFont(section, "Programma: ", campo, LEFT, "SansSerif");
						} else {
							t = ReportUtils.addTextFont(section, "Area: ", campo, LEFT, "SansSerif");
						}
						ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), descrProgrServ, etichetta, "SansSerif");
						ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), " data inizio ", etichetta, "SansSerif");
						ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), dataInizio, etichetta, "SansSerif");
						if (StringUtils.isFilledNoBlank(dataFine)) {
							ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), " data fine ", etichetta,
									"SansSerif");
							ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), dataFine, etichetta, "SansSerif");
						}
						colloquio_before = colloquio;
					}

					Text t;
					if (!azione_ragg.equalsIgnoreCase(azione_ragg_before)) {
						addBR(details, 20);
						section = details.addSection();
						t = ReportUtils.addTextFont(section, "Servizio: ", campo, LEFT, "SansSerif");
						ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), azione_ragg, etichetta, "SansSerif");

						ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), " con le seguenti misure: ", campo,
								"SansSerif");
						azione_ragg_before = azione_ragg;
					}

					addBR(details, 20);
					section = details.addSection();
					t = ReportUtils.addTextFont(section, "Misura: ", campo, LEFT_TITOLO_PUNTO_T, "SansSerif");
					ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), programma.getAttribute("misura").toString(),
							etichetta, "SansSerif");
					section = details.addSection();
					t = ReportUtils.addTextFont(section, "Esito: ", campo, LEFT_TITOLO_PUNTO_T, "SansSerif");
					String esito = Utils.notNull(programma.getAttribute("esito"));
					ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), esito, etichetta, "SansSerif");
					String strNote = Utils.notNull(programma.getAttribute("Strnote"));
					if (StringUtils.isFilledNoBlank(strNote)) {
						section = details.addSection();
						t = ReportUtils.addTextFont(section, "Note: ", campo, LEFT_TITOLO_PUNTO_T, "SansSerif");
						ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), strNote, etichetta, "SansSerif");
					}
					section = details.addSection();
					String notaaggiuntiva = Utils.notNull(programma.getAttribute("notaaggiuntiva"));
					if (StringUtils.isFilledNoBlank(notaaggiuntiva)) {
						String[] infoAzione = notaaggiuntiva.split("-");
						t = ReportUtils.addTextFont(section, infoAzione[0], etichetta, LEFT_TITOLO_PUNTO_T,
								"SansSerif");
						for (int k = 1; k < infoAzione.length; k++) {
							ReportUtils.addTextPartWithSizeFont(t.getParagraph(0), infoAzione[k],
									(k % 2 == 0) ? etichetta : campo, "SansSerif");
						}
					}
				}
			}
		}

	}

	/**
	 * appuntamenti legati al patto
	 * 
	 * @param appuntamenti
	 */
	@SuppressWarnings("rawtypes")
	private void appuntamentiAccordo(Area details, Vector appuntamenti) throws Exception {

		if (!appuntamenti.isEmpty()) {

			for (int i = 0; i < appuntamenti.size(); i++) {
				if (i > 0 && i < appuntamenti.size()) {
					addBR(details, 40);
				}
				Section section = details.addSection();
				SourceBean appuntamento = (SourceBean) appuntamenti.get(i);
				String tipoApp = Utils.notNull(appuntamento.getAttribute("Codstatoappuntamento"));
				StringBuilder incipit = new StringBuilder("È stato fissato un appuntamento con ");
				incipit.append("il Centro per l'impiego mediante presentazione ");
				incipit.append("al servizio di ").append(appuntamento.getAttribute("DesServizio").toString());
				int tipoAppuntamento = 0;
				if (!tipoApp.equals("")) {
					tipoAppuntamento = Integer.valueOf(tipoApp).intValue();

					switch (tipoAppuntamento) {
					case 2:
						incipit.append(" da svolgersi entro il ");
						break;
					case 3:
						incipit.append(" che si è svolto il ");
						break;
					case 4:
						incipit.append(" che doveva svolgersi entro il ");
						break;

					default:
						break;
					}
					incipit.append(appuntamento.getAttribute("dataApp").toString());
				}
				ReportUtils.addTextFont(section, incipit.toString(), etichetta, LEFT, "SansSerif");

				section = details.addSection();
				Text t = ReportUtils.addTextFont(section, "Stato appuntamento: ", campo, LEFT, "SansSerif");
				ReportUtils.addTextPartWithFont(t.getParagraph(0), appuntamento.getAttribute("DesStato").toString(),
						etichetta, "SansSerif");
				section = details.addSection();
				if (tipoAppuntamento != 2) {
					t = ReportUtils.addTextFont(section, "Esito appuntamento: ", campo, LEFT, "SansSerif");
					ReportUtils.addTextPartWithFont(t.getParagraph(0), appuntamento.getAttribute("DesEsito").toString(),
							etichetta, "SansSerif");
					section = details.addSection();
				}
				t = ReportUtils.addTextFont(section, "Orario: ", campo, LEFT, "SansSerif");
				ReportUtils.addTextPartWithFont(t.getParagraph(0), appuntamento.getAttribute("orario").toString(),
						etichetta, "SansSerif");
				section = details.addSection();
				t = ReportUtils.addTextFont(section, "Durata appuntamento: ", campo, LEFT, "SansSerif");
				String durata = Utils.notNull(appuntamento.getAttribute("Durata"));
				ReportUtils.addTextPartWithFont(t.getParagraph(0), durata + " minuti", etichetta, "SansSerif");
			}
		}
	}

	/**
	 * LE INFORMAZIONI UTENTE VENGONO INSERITE NEL REPORT UTILIZZANDO UN SUBREPORT LETTO DA DISCO, ovvero un subreport
	 * creato col designer di Crystal Clear al quale vengono passati 3 parametri.
	 */
	private void informazioniUtente(Area details, SourceBean infoGenerali) throws Exception {
		if (infoGenerali == null) {
			infoGenerali = new SourceBean("");
		}
		String cpi = (String) infoGenerali.getAttribute("CPI");
		String dataStipula = (String) infoGenerali.getAttribute("datStipula");
		Section section = details.addSection();
		section.setNewPageBefore(false);
		// aggiunta del subreport da disco
		Subreport sub = section.addSubreport(0, 0, StyleUtils.toTwips(1950), StyleUtils.toTwips(56),
				"file:" + this.installAppPath + "/WEB-INF/report/patto/_informazioniAccordo_CC_RER.rpt");
		// impostazione dei bordi e degli headers e footers
		// N.B. quando viene importato un subreport le informazioni sul layout
		// del page header, page footer,
		// report header e footer vengono perse, per cui e' necessario
		// reimpostarle.
		// In questo caso voglio eliminarli e togliere il bordo.
		sub.setLeftLineStyle(BorderProperties.NO_LINE);
		sub.setBottomLineStyle(BorderProperties.NO_LINE);
		sub.setTopLineStyle(BorderProperties.NO_LINE);
		sub.setRightLineStyle(BorderProperties.NO_LINE);
		Engine eng = sub.getEngine();
		eng.getArea("RH").setHeight(0);
		eng.getArea("RF").setHeight(0);
		eng.getArea("RH").setSuppress(true);
		eng.getArea("RF").setSuppress(true);

		paginaInformazioni(details, cpi, dataStipula);
	}

	private void intestazione(Area area) throws Exception {
		Text text = null;
		Paragraph par = null;
		TextPart tp = null;

		Section sec = area.addSection();
		text = sec.addText(100, 0, sec.getWidth() - 100, 200);
		text.setCanGrow(true);
		par = text.addParagraph();
		par.setHorAlign(GeneralProperties.ALIGN_HORIZONTAL_CENTER);
		tp = par.addTextPart("ARPAL Umbria - Agenzia Regionale per le Politiche Attive del Lavoro");
		tp.setFontSize(12);
		tp.setFontName("Arial");
		tp.setBold(true);
	}

	private void intestazione(Section sec, Area area) throws Exception {

		// sec.addPicture(StyleUtils.toTwips(LEFT + 650), StyleUtils.toTwips(0) ,2415, 1575, this.installAppPath
		// + "/WEB-INF/report/img/_logo_arpal.png");

		// sec.addPicture(StyleUtils.toTwips(LEFT + 650), StyleUtils.toTwips(0) , StyleUtils.toTwips(400),
		// StyleUtils.toTwips(283), this.installAppPath
		// + "/WEB-INF/report/img/arpal_logo_grande_842_595.jpg");

		sec.addPicture(StyleUtils.toTwips(LEFT + 650), StyleUtils.toTwips(0), StyleUtils.toTwips(425),
				StyleUtils.toTwips(227), this.installAppPath + "/WEB-INF/report/img/_logo_arpal_vettoriale.png");

		// sec.addPicture(StyleUtils.toTwips(LEFT + 650), StyleUtils.toTwips(0) ,StyleUtils.toTwips(380),
		// StyleUtils.toTwips(205), this.installAppPath
		// + "/WEB-INF/report/img/_logo_arpal_new.png");

		// sec.addPicture(StyleUtils.toTwips(0), StyleUtils.toTwips(230), StyleUtils.toTwips(1850),
		// StyleUtils.toTwips(17), this.installAppPath
		// + "/WEB-INF/report/img/riga_logo_arpal_umbria.png");

		sec.addPicture(StyleUtils.toTwips(0), StyleUtils.toTwips(270), StyleUtils.toTwips(1850), StyleUtils.toTwips(25),
				this.installAppPath + "/WEB-INF/report/img/riga_rossa.png");

		addBR(area, 50);

		testoParametrizzatoTitoli(sec, area, "ARPAL UMBRIA", true, 12, GeneralProperties.ALIGN_HORIZONTAL_CENTER);

		testoParametrizzatoTitoli(sec, area, "Agenzia Regionale per le Politiche Attive del Lavoro", true, 12,
				GeneralProperties.ALIGN_HORIZONTAL_CENTER);

	}

	/*
	 * Inserisce testo con i seguenti parametri: allineamento, testo da visualizzare, grassetto, size font
	 * 
	 */
	private void testoParametrizzatoTitoli(Section sec, Area area, String txt, boolean isBold, int sizeFont,
			int allineamento) throws Exception {
		Text text = null;
		Paragraph par = null;
		TextPart tp = null;
		sec = area.addSection();
		text = sec.addText(100, 0, sec.getWidth() - 100, 200); // sec.getWidth() - 100
		text.setCanGrow(true);
		par = text.addParagraph();
		par.setHorAlign(allineamento);
		tp = par.addTextPart(txt);
		// Style s = (Style) campo.clone();
		// s.setStyle(tp);
		tp.setFontSize(sizeFont);
		// tp.setFontName("Verdana");
		tp.setFontName("SansSerif");
		tp.setBold(isBold);
	}

	private void testoParametrizzatoSottoTitoli(Section sec, Area area, int posY, String txt, boolean isBold,
			int sizeFont, int allineamento) throws Exception {
		Text text = null;
		Paragraph par = null;
		TextPart tp = null;
		// sec = area.addSection();
		text = sec.addText(100, StyleUtils.toTwips(posY), sec.getWidth() - 100, 200); // sec.getWidth() - 100
		text.setCanGrow(true);
		par = text.addParagraph();
		par.setHorAlign(allineamento);
		tp = par.addTextPart(txt);
		// Style s = (Style) campo.clone();
		// s.setStyle(tp);
		tp.setFontSize(sizeFont);
		// tp.setFontName("Verdana");
		tp.setFontName("SansSerif");
		tp.setBold(isBold);
	}

	private void testataCPI(Area area, SourceBean row) throws Exception {
		if (row == null)
			row = new SourceBean("");
		//
		String cpi = (String) row.getAttribute("CPI");
		String tel = (String) row.getAttribute("TEL");
		String fax = (String) row.getAttribute("FAX");
		String eMail = (String) row.getAttribute("EMAIL");
		// String intestazione = (String) row.getAttribute("STRINTESTAZIONESTAMPA");
		//
		Section sec = area.addSection();
		sec.setHeight(StyleUtils.toTwips(250));

		sec.addBox(StyleUtils.toTwips(80), 0, StyleUtils.toTwips(1470), StyleUtils.toTwips(205));

		//
		Text text = sec.addText(StyleUtils.toTwips(100), StyleUtils.toTwips(5), StyleUtils.toTwips(1250),
				StyleUtils.toTwips(80));
		Paragraph p = text.addParagraph();
		TextPart tp = p.addTextPart("CENTRO PER L'IMPIEGO DI " + Utils.notNull(cpi).toUpperCase());
		tp.setFontSize(12);
		tp.setFontName("Arial");
		tp.setBold(true);
		tp.setUnderline(true);
		//
		String codTipoPattoMisura = row.containsAttribute("codtipopatto") ? row.getAttribute("codtipopatto").toString()
				: "";
		boolean isPattoGG = false;

		if (this.programmiAperti != null && !this.programmiAperti.isEmpty()
				&& PattoBean.checkMisureProgramma(this.programmiAperti, misureGG)) {
			isPattoGG = true;
		}

		if (Arrays.asList(misureGG).contains(codTipoPattoMisura) || isPattoGG) {
			sec.addPicture(StyleUtils.toTwips(1155), StyleUtils.toTwips(26), 900, 836,
					this.installAppPath + "/WEB-INF/report/img/logo_internal.png");
		}

		//
		text = sec.addText(StyleUtils.toTwips(100), StyleUtils.toTwips(95), StyleUtils.toTwips(600),
				StyleUtils.toTwips(50));
		p = text.addParagraph();
		tp = p.addTextPart("tel. " + Utils.notNull(tel));
		Style s = (Style) campo.clone();
		s.setStyle(tp);
		tp.setBold(true);
		//
		text = sec.addText(StyleUtils.toTwips(720), StyleUtils.toTwips(95), StyleUtils.toTwips(350),
				StyleUtils.toTwips(50));
		p = text.addParagraph();
		tp = p.addTextPart("fax. " + Utils.notNull(fax));
		s = (Style) campo.clone();
		s.setStyle(tp);
		tp.setBold(true);
		//
		text = sec.addText(StyleUtils.toTwips(100), StyleUtils.toTwips(150), StyleUtils.toTwips(1000),
				StyleUtils.toTwips(50));
		p = text.addParagraph();
		tp = p.addTextPart("e-mail " + Utils.notNull(eMail));
		s = (Style) campo.clone();
		s.setStyle(tp);

		tp.setBold(true);
		//
		sec.addBox(StyleUtils.toTwips(1548), 0, StyleUtils.toTwips(240), StyleUtils.toTwips(205));
		/*
		 * text = sec.addText(StyleUtils.toTwips(1500), StyleUtils.toTwips(50), StyleUtils.toTwips(350), StyleUtils
		 * .toTwips(80)); p = text.addParagraph(); tp = p.addTextPart( Utils.notNull(intestazione).toUpperCase());
		 * tp.setFontSize(11); tp.setFontName("Arial"); tp.setBold(true); text.setCanGrow(true);
		 */
		//
		sec.addPicture(StyleUtils.toTwips(1595), StyleUtils.toTwips(26), 795, 870,
				this.installAppPath + "/WEB-INF/report/img/_loghiAvuti/logo_BO.gif");
		Vector elements = sec.getElementsV();
		int contatoreImmagini = 0;
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i) instanceof Picture) {
				if (Arrays.asList(misureGG).contains(codTipoPattoMisura) || isPattoGG) {
					if (contatoreImmagini > 0) {
						((Element) elements.get(i)).setSuppress(true);
					}
				} else {
					((Element) elements.get(i)).setSuppress(true);
				}
				contatoreImmagini = contatoreImmagini + 1;
			}
		}
	}

	private void testataCPIUmbria(Section sec, Area area, SourceBean row) throws Exception {
		if (row == null)
			row = new SourceBean("");

		String cpi = (String) row.getAttribute("CPI");
		String tel = (String) row.getAttribute("TEL");
		String indirizzo = (String) row.getAttribute("INDIRIZZO");
		// String fax = (String) row.getAttribute("FAX");
		String eMail = (String) row.getAttribute("EMAIL");

		testoParametrizzatoTitoli(sec, area, "Centro per l'impiego di " + Utils.notNull(cpi).toUpperCase(), true, 12,
				GeneralProperties.ALIGN_HORIZONTAL_CENTER); // va in una sezione a parte

		String codTipoPattoMisura = row.containsAttribute("codtipopatto") ? row.getAttribute("codtipopatto").toString()
				: "";

		/*
		 * boolean isPattoGG = false;
		 * 
		 * if (this.programmiAperti != null && !this.programmiAperti.isEmpty() &&
		 * PattoBean.checkMisureProgramma(this.programmiAperti, misureGG)) { isPattoGG = true; }
		 * 
		 * if (Arrays.asList(misureGG).contains(codTipoPattoMisura) || isPattoGG) {
		 * sec.addPicture(StyleUtils.toTwips(1075), StyleUtils.toTwips(26), 900, 836, this.installAppPath +
		 * "/WEB-INF/report/img/logo_internal.png"); }
		 */
		sec = area.addSection();
		// l'indirizzo , l'email e il telefono vanno nella stessa sezione
		testoParametrizzatoSottoTitoli(sec, area, 10, Utils.notNull(indirizzo), true, 8,
				GeneralProperties.ALIGN_HORIZONTAL_CENTER);
		testoParametrizzatoSottoTitoli(sec, area, 65, "tel.: " + Utils.notNull(tel), true, 8,
				GeneralProperties.ALIGN_HORIZONTAL_CENTER);

		/*
		 * text = sec.addText(StyleUtils.toTwips(720), StyleUtils.toTwips(95), StyleUtils.toTwips(350),
		 * StyleUtils.toTwips(50)); p = text.addParagraph(); tp = p.addTextPart("fax. " + Utils.notNull(fax)); s =
		 * (Style) campo.clone(); s.setStyle(tp); tp.setBold(true);
		 */

		testoParametrizzatoSottoTitoli(sec, area, 115, "e-mail: " + Utils.notNull(eMail), true, 8,
				GeneralProperties.ALIGN_HORIZONTAL_CENTER);

		sec.addPicture(StyleUtils.toTwips(0), StyleUtils.toTwips(180), StyleUtils.toTwips(1850), StyleUtils.toTwips(2),
				this.installAppPath + "/WEB-INF/report/img/logo_riga_gray_arpal.png");

		/*
		 * sec.addBox(StyleUtils.toTwips(1548), 0, StyleUtils.toTwips(240), StyleUtils.toTwips(205));
		 * 
		 * sec.addPicture(StyleUtils.toTwips(1595), StyleUtils.toTwips(26), 795, 870, this.installAppPath +
		 * "/WEB-INF/report/img/_loghiAvuti/logo_BO.gif"); Vector elements = sec.getElementsV(); int contatoreImmagini =
		 * 0; for (int i = 0; i < elements.size(); i++) { if (elements.get(i) instanceof Picture) { if
		 * (Arrays.asList(misureGG).contains(codTipoPattoMisura) || isPattoGG) { if (contatoreImmagini > 0) { ((Element)
		 * elements.get(i)).setSuppress(true); } } else { ((Element) elements.get(i)).setSuppress(true); }
		 * contatoreImmagini = contatoreImmagini + 1; } }
		 */
	}

	private void addBR(Area details, int height) throws Exception {
		Section section = details.addSection();
		section.setHeight(StyleUtils.toTwips(height));
	}

	/**
	 * come stile viene usato 'CAMPO' ma con fontSize = 12 (anzicche' 11 dello stile CAMPO)
	 */
	private void titoloPuntato(Area details, String titolo, Style s) throws Exception {
		Section section = details.addSection();
		section.addPicture(StyleUtils.toTwips(LEFT + 50), StyleUtils.toTwips(19), StyleUtils.toTwips(17),
				StyleUtils.toTwips(17), this.installAppPath + "/WEB-INF/report/img/punto_carta.gif");
		ReportUtils.addTextFont(section, titolo, s, LEFT_TITOLO_PUNTO_T, "SansSerif");
	}

	private void paginaInformazioni(Area details, String cpi, String dataStipula) throws Exception {

		addBR(details, 50);
		Section section = details.addSection();
		Text text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(5), StyleUtils.toTwips(1250),
				StyleUtils.toTwips(80));
		Paragraph p = text.addParagraph();
		TextPart tp = p.addTextPart(cpi + ", li " + dataStipula);
		tp.setFontSize(11);
		tp.setFontName("SansSerif");

		addBR(details, 30);
		section = details.addSection();
		text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(5), StyleUtils.toTwips(1250),
				StyleUtils.toTwips(80));
		p = text.addParagraph();
		tp = p.addTextPart("Data stampa " + DateUtils.getNow());
		tp.setFontSize(11);
		tp.setFontName("SansSerif");

		addBR(details, 60);
		section = details.addSection();
		text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(5), StyleUtils.toTwips(1250),
				StyleUtils.toTwips(80));
		p = text.addParagraph();
		tp = p.addTextPart("Per il CPI");
		tp.setFontSize(11);
		tp.setFontName("SansSerif");

		addBR(details, 20);
		section = details.addSection();
		text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(5), StyleUtils.toTwips(1250),
				StyleUtils.toTwips(80));
		p = text.addParagraph();
		tp = p.addTextPart("Firma dell'operatore CPI");
		tp.setFontSize(11);
		tp.setFontName("SansSerif");
		text = section.addText(StyleUtils.toTwips(1260), StyleUtils.toTwips(5), StyleUtils.toTwips(500),
				StyleUtils.toTwips(80));
		p = text.addParagraph();
		tp = p.addTextPart("Firma del lavoratore");
		tp.setFontSize(11);
		tp.setFontName("SansSerif");

		if (this.flgPattoOnline != null && this.flgPattoOnline.equalsIgnoreCase(Properties.FLAG_S)) {
			String nomeUt = "";
			String cognomeUt = "";
			String nomeLav = "";
			String cognomeLav = "";

			if (this.operatore != null) {
				nomeUt = Utils.notNull(this.operatore.getAttribute("ROW.STRNOMEUTENTE"));
				cognomeUt = Utils.notNull(this.operatore.getAttribute("ROW.STRCOGNOMEUTENTE"));
			}

			if (this.infoGenerali != null) {
				nomeLav = Utils.notNull(this.infoGenerali.getAttribute("NOMELAVORATORE"));
				cognomeLav = Utils.notNull(this.infoGenerali.getAttribute("COGNOMELAVORATORE"));
			}

			addBR(details, 20);

			section = details.addSection();
			// om20201203: riporto da 3.35.0, non è possibile impostare la proprietà canGrow sulla section			
			// section.setCanGrow(true);
			text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(0), StyleUtils.toTwips(650),
					StyleUtils.toTwips(20));
			text.setCanGrow(true);
			p = text.addParagraph();
			p.setCanGrow(true);
			tp = p.addTextPart("sottoscritto con firma elettronica da");
			tp.setFontSize(11);
			tp.setFontName("SansSerif");

			text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(50), StyleUtils.toTwips(550),
					StyleUtils.toTwips(20));
			text.setCanGrow(true);
			p = text.addParagraph();
			p.setCanGrow(true);
			tp = p.addTextPart("da" + " " + nomeUt + " " + cognomeUt);
			tp.setFontSize(11);
			tp.setFontName("SansSerif");

			text = section.addText(StyleUtils.toTwips(1260), StyleUtils.toTwips(0), StyleUtils.toTwips(650),
					StyleUtils.toTwips(20));
			text.setCanGrow(true);
			p = text.addParagraph();
			p.setCanGrow(true);
			tp = p.addTextPart("sottoscritto con firma elettronica");
			tp.setFontSize(11);
			tp.setFontName("SansSerif");

			text = section.addText(StyleUtils.toTwips(1260), StyleUtils.toTwips(50), StyleUtils.toTwips(550),
					StyleUtils.toTwips(20));
			text.setCanGrow(true);
			p = text.addParagraph();
			p.setCanGrow(true);
			tp = p.addTextPart("da" + " " + nomeLav + " " + cognomeLav);
			tp.setFontSize(11);
			tp.setFontName("SansSerif");

		}

		addBR(details, 50);
		section = details.addSection();
		text = section.addText(StyleUtils.toTwips(130), StyleUtils.toTwips(5), StyleUtils.toTwips(1700),
				StyleUtils.toTwips(400));
		p = text.addParagraph();

		if (StringUtils.isFilledNoBlank(privacy) && privacy.equalsIgnoreCase("1")) {
			tp = p.addTextPart(
					"\n\n\nE' stata inoltre ricevuta/presa visione dell'informativa prevista dall'art 13 del Regolamento europeo n. 679/2016.");
		} else {
			tp = p.addTextPart(
					"\n\n\nE' stata inoltre ricevuta/presa visione dell'informativa prevista dall'art.13 del Regolamento europeo n. 679/2016");
		}
		tp.setFontSize(11);
		tp.setFontName("SansSerif");
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws Exception {
		try {
			ApiAccordoGenerico_RER_CAL p = new ApiAccordoGenerico_RER_CAL(args);
		} finally {
			System.out.println("exit");
			System.exit(0);
		}
	}
}