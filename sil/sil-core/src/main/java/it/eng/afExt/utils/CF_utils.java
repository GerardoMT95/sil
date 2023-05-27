package it.eng.afExt.utils;

/**
 * @author Alessio Rolfini
 * @version 1.0, 17/07/2003
 */
public class CF_utils {

	/***************************************************************************
	 * FUNZIONI PUBLIC
	 **************************************************************************/

	/**
	 * Verifica la correttezza del codice fiscale passato nel primo parametro. Controlli effettuati: - che la lunghezza
	 * sia = 16 (checkLength); - che caratteri in VII, VIII, X, XI posizione siano numerici (gli ultimi tre caratteri
	 * possono anche essere alfanumerici in caso di omonimie) (checkCaratteriNumerici) - che i caratteri in I, II, III,
	 * IV, V, VI posizione siano alfabetici (checkCaratteriAlfabetici) - validità del check digit (checkDigit) -
	 * corrispondenza del codice fiscale rispetto a: - giorno di nascita, sesso (checkSesso) - cognome (checkCognome) -
	 * nome (checkNome) - mese di nascita (CheckMese) - anno di nascita (CheckAnno) - comune di nascita (CheckComune)
	 * 
	 * In caso di fallimento, per il primo (in ordine di tempo) controllo che fallisce viene sollevata un'eccezione
	 * CfException che restituisce nel Message una stringa che identifica il codice di errore. vengono di seguito
	 * elencati i codici in base ai controlli non andati a buon fine: - lunghezza non valida: CfException.ERR_LUNGHEZZA
	 * (0) - errore nei caratteri numerici: CfException.ERR_CARATTERI_NUMERICI (1) - errore nei caratteri alfabetici:
	 * CfException.ERR_CARATTERI_ALFABETICI (2) - errore nel giorno di nascita e/o nel sesso: CfException.ERR_SESSO (3)
	 * - errore nel check digit: CfException.ERR_CHECK_DIGIT (4) - errore nel cognome: CfException.ERR_COGNOME (5) -
	 * errore nel nome: CfException.ERR_NOME (6) - errore nel mese di nascita: CfException.ERR_MESE (7) - errore
	 * nell'anno di nascita: CfException.ERR_ANNO (8) - errore nel comune di nascita: CfException.ERR_COMUNE (9)
	 * 
	 * @param codfiscale
	 *            il codice fiscale nome il nome dell'individuo cognome il cognome dell'individuo sesso il sesso
	 *            dell'individuo ("M" o "F") data_nascita la data di nascita dell'individuo (in formato "GG/MM/AAAA")
	 *            comune il comune di nascita dell'individuo
	 * @return 0 se è tutto andato bene.
	 * @throws CfException
	 *             Se il codice fiscale non è valido (vedi sopra)
	 * @see CfException
	 */
	public static int verificaCF(String codfiscale, String nome, String cognome, String sesso, String data_nascita,
			String comune) throws CfException {

		codfiscale = codfiscale.toUpperCase(); // "normalizzo" il codice
												// fiscale

		// se si tratta di un codice fiscale temporaneo esegui i controlli specifici su di esso
		if (isCodiceTemporaneo(codfiscale)) {
			if (!isCodiceTemporaneoNumerico(codfiscale))
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_NAN);
			if (!checkNumericoCF(codfiscale))
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_CHECK_DIGIT);
			return 0;
		}

		// controllo della lunghezza
		if (!checkLength(codfiscale)) { // se il controllo non va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_LUNGHEZZA);
		}

		// controllo della correttezza posizionale dei caratteri numerici
		if (!checkCaratteriNumerici(codfiscale)) { // se il controllo non va a
													// buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_NUMERICI);
		}

		// controllo del carattere del mese
		if (!checkCarattereMese(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERE_MESE);
		}

		// controllo della correttezza posizionale dei caratteri alfabetici
		if (!checkCaratteriAlfabetici(codfiscale)) { // se il controllo non
														// va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_ALFABETICI);
		}

		// controllo del sesso
		if (!checkSesso(codfiscale, sesso, data_nascita)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_SESSO);
		}

		// controllo del check digit
		if (!checkDigit(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CHECK_DIGIT);
		}

		// controllo della congruenza con il cognome
		if (!checkCognome(codfiscale, cognome)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_COGNOME);
		}

		// controllo della congruenza con il nome
		if (!checkNome(codfiscale, nome)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_NOME);
		}

		// controllo della congruenza del mese
		if (!checkMese(codfiscale, data_nascita)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_MESE);
		}

		// controllo della congruenza dell'anno di nascita
		if (!checkAnno(codfiscale, data_nascita)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_ANNO);
		}

		// controllo della congruenza del comune di nascita
		if (!checkComune(codfiscale, comune)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_COMUNE);
		}

		// se siamo riusciti ad arrivare fin qui tutto ok!
		return 0;
	}

	public static int verificaParzialeCF(String codfiscale, String nome, String cognome, String data_nascita,
			String comune) throws CfException {

		codfiscale = codfiscale.toUpperCase(); // "normalizzo" il codice fiscale

		// se si tratta di un codice fiscale temporaneo esegui i controlli specifici su di esso
		if (isCodiceTemporaneo(codfiscale)) {
			if (!isCodiceTemporaneoNumerico(codfiscale))
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_NAN);
			if (!checkNumericoCF(codfiscale))
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_CHECK_DIGIT);
			return 0;
		}

		// controllo della lunghezza
		if (!checkLength(codfiscale)) { // se il controllo non va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_LUNGHEZZA);
		}

		// controllo della correttezza posizionale dei caratteri numerici
		if (!checkCaratteriNumerici(codfiscale)) { // se il controllo non va a
													// buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_NUMERICI);
		}

		// controllo del carattere del mese
		if (!checkCarattereMese(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERE_MESE);
		}

		// controllo della correttezza posizionale dei caratteri alfabetici
		if (!checkCaratteriAlfabetici(codfiscale)) { // se il controllo non va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_ALFABETICI);
		}

		// controllo del sesso
		// if (!checkSesso(codfiscale, sesso, data_nascita)) {
		// throw new CfException(MessageCodes.CodiceFiscale.ERR_SESSO);
		// }

		// controllo del check digit
		if (!checkDigit(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CHECK_DIGIT);
		}

		// controllo della congruenza con il cognome
		if (!checkCognome(codfiscale, cognome)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_COGNOME);
		}

		// controllo della congruenza con il nome
		if (!checkNome(codfiscale, nome)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_NOME);
		}

		// controllo della congruenza del mese
		if (!checkMese(codfiscale, data_nascita)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_MESE);
		}

		// controllo della congruenza dell'anno di nascita
		if (!checkAnno(codfiscale, data_nascita)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_ANNO);
		}

		// controllo della congruenza del comune di nascita
		if (!checkComune(codfiscale, comune)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_COMUNE);
		}

		// se siamo riusciti ad arrivare fin qua tutto ok!
		return 0;
	}

	public static int verificaParzialeCF(String codfiscale, String nome, String cognome) throws CfException {

		codfiscale = codfiscale.toUpperCase(); // "normalizzo" il codice fiscale

		// se si tratta di un codice fiscale temporaneo esegui i controlli specifici su di esso
		if (isCodiceTemporaneo(codfiscale)) {
			if (!isCodiceTemporaneoNumerico(codfiscale))
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_NAN);
			if (!checkNumericoCF(codfiscale))
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_CHECK_DIGIT);
			return 0;
		}

		// controllo della lunghezza
		if (!checkLength(codfiscale)) { // se il controllo non va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_LUNGHEZZA);
		}

		// controllo della correttezza posizionale dei caratteri numerici
		if (!checkCaratteriNumerici(codfiscale)) { // se il controllo non va a
													// buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_NUMERICI);
		}

		// controllo del carattere del mese
		// if (!checkCarattereMese(codfiscale)) {
		// throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERE_MESE);
		// }

		// controllo della correttezza posizionale dei caratteri alfabetici
		if (!checkCaratteriAlfabetici(codfiscale)) { // se il controllo non va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_ALFABETICI);
		}

		// controllo del sesso
		// if (!checkSesso(codfiscale, sesso, data_nascita)) {
		// throw new CfException(MessageCodes.CodiceFiscale.ERR_SESSO);
		// }

		// controllo del check digit
		if (!checkDigit(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CHECK_DIGIT);
		}

		// controllo della congruenza con il cognome
		if (!checkCognome(codfiscale, cognome)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_COGNOME);
		}

		// controllo della congruenza con il nome
		if (!checkNome(codfiscale, nome)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_NOME);
		}

		// controllo della congruenza del mese
		// if (!checkMese(codfiscale, data_nascita)) {
		// throw new CfException(MessageCodes.CodiceFiscale.ERR_MESE);
		// }

		// controllo della congruenza dell'anno di nascita
		// if (!checkAnno(codfiscale, data_nascita)) {
		// throw new CfException(MessageCodes.CodiceFiscale.ERR_ANNO);
		// }

		// controllo della congruenza del comune di nascita
		// if (!checkComune(codfiscale, comune)) {
		// throw new CfException(MessageCodes.CodiceFiscale.ERR_COMUNE);
		// }

		// se siamo riusciti ad arrivare fin qua è tutto ok!
		return 0;
	}

	private static boolean isCodiceTemporaneoNumerico(String codfiscale) {
		boolean ret = true;
		for (int i = 0; i < codfiscale.length() && ret; i++) {
			ret = Character.isDigit(codfiscale.charAt(i));
		}
		return ret;
	}

	private static boolean isCodiceTemporaneo(String codfiscale) {
		return (codfiscale.length() == 11);
	}

	/**
	 * 
	 * Esegue una verifica parziale del codice fiscale controllandone lunghezza, caratteri numerici e caratteri
	 * alfabetici, check digit. Controlla anche il codice comune e restituisce il CF trasformazto per i casi di
	 * omocodia, sostituendo le lettere con i numeri appropriati.
	 * 
	 * @param codfiscale
	 *            codice fiscale da esaminare
	 * @return il codice fiscale con il codice comune valido
	 * @throws CfException
	 */
	public static String verificaCF(String codfiscale) throws CfException {

		codfiscale = codfiscale.toUpperCase(); // "normalizzo" il codice
												// fiscale

		// controllo della lunghezza
		if (!checkLength(codfiscale)) { // se il controllo non va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_LUNGHEZZA); // exception: // "CF_LEN"
		}

		// controllo della correttezza posizionale dei caratteri numerici
		if (!checkCaratteriNumerici(codfiscale)) { // se il controllo non va a // buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_NUMERICI);
		}

		// controllo della correttezza posizionale dei caratteri alfabetici
		if (!checkCaratteriAlfabetici(codfiscale)) { // se il controllo non // va a buon fine
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_ALFABETICI);
		}

		// controllo del check digit
		if (!checkDigit(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CHECK_DIGIT);
		}

		// controllo del carattere del mese
		if (!checkCarattereMese(codfiscale)) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERE_MESE);
		}

		String toReturn;
		toReturn = checkAndReplaceCodiceComune(codfiscale);
		// controllo e sostituzione codice comune
		if (toReturn == null) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_COMUNE);
		}

		return toReturn;
	}

	public static int verificaParzialeCF(String codfiscale) throws CfException {
		codfiscale = codfiscale.toUpperCase();

		// controllo della lunghezza
		if (codfiscale.length() != 11 && codfiscale.length() != 16) {
			throw new CfException(MessageCodes.CodiceFiscale.ERR_LUNGHEZZA); // exception:
		}

		if (codfiscale.length() == 16) {
			// controllo della correttezza posizionale dei caratteri numerici
			if (!checkCaratteriNumerici(codfiscale)) { // se il controllo non va a // buon fine
				throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_NUMERICI);
			}

			// controllo della correttezza posizionale dei caratteri alfabetici
			if (!checkCaratteriAlfabetici(codfiscale)) { // se il controllo non // va a buon fine
				throw new CfException(MessageCodes.CodiceFiscale.ERR_CARATTERI_ALFABETICI);
			}

			// controllo del check digit
			if (!checkDigit(codfiscale)) {
				throw new CfException(MessageCodes.CodiceFiscale.ERR_CHECK_DIGIT);
			}
		} else {
			if (!isCodiceTemporaneoNumerico(codfiscale)) {
				throw new CfException(MessageCodes.CodiceFiscale.ERRPROV_NAN);
			}
			if (!checkNumericoCF(codfiscale)) {
				throw new CfException(MessageCodes.CodiceFiscaleAzienda.ERR_CHECK_DIGIT);
			}
		}

		return 0;
	}

	/**
	 * Verifica la correttezza di un codice fiscale inserito nella maschera di anagrafica dell'azienda. Viene verificata
	 * la lunghezza, che deve essere di 11 caratteri (se numerico) oppure 16 (se alfanumerico); Se la lunghezza è 11 il
	 * codice è numerico. Se la lunghezza è 16 il codice è alfanumerico: in questo caso viene verificata la
	 * corrispondenza posizionale dei caratteri e dei numeri ed il check digit.
	 */

	public static int verificaCFAzienda(String codfiscale) throws CfAZException {

		if ((codfiscale.length() != 11) && (codfiscale.length() != 16)) {
			throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_LUNGHEZZA);
		}

		if (isCodiceTemporaneo(codfiscale)) {
			if (!isCodiceTemporaneoNumerico(codfiscale))
				throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_NAN);
			if (!checkNumericoCF(codfiscale))
				throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_CHECK_DIGIT);
			return 0;
		}

		if (codfiscale.length() == 16) // codice fiscale alfanumerico
		{
			if (!checkCaratteriNumerici(codfiscale)) {
				throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_CARATTERI_NUMERICI);
			}

			if (!checkCaratteriAlfabetici(codfiscale)) {
				throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_CARATTERI_ALFABETICI);
			}

			if (!checkDigit(codfiscale)) {
				throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_CHECK_DIGIT);
			}
		}
		return 0;

	}

	/***************************************************************************
	 * FUNZIONI PRIVATE
	 **************************************************************************/

	/**
	 * checkLength Controlla la lunghezza del codice fiscale in input, che deve tassativamente essere di 16 caratteri
	 * 
	 * @param codfiscale
	 * @return true se la lunghezza è corretta false se la lunghezza non è corretta
	 * 
	 */
	private static boolean checkLength(String codfiscale) {
		if (codfiscale.length() == 16) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checkCaratteriNumerici Controlla la correttezza posizionale dei caratteri numerici.
	 * 
	 * @param codfiscale
	 * @return true se i caratteri numerici del codice fiscale sono ben posizionati false se i caratteri numerici del
	 *         codice fiscale non sono ben posizionati.
	 */
	private static boolean checkCaratteriNumerici(String codfiscale) {
		boolean ok = true;
		for (int k = 0; (k < codfiscale.length()) && (ok); k++) {
			char car = codfiscale.charAt(k);
			if (k == 6 || k == 7 || k == 9 || k == 10 /*
														 * || k==12 || k==13 || k==14
														 */) // controllo
																// caratteri
																// numerici
			{
				// M.F. 30/09/2002 N.B. gli ultimi 3 caratteri possono essere
				// anche alfabetici in caso di omonimie
				if (!StringUtils.isDigit(car)) { // se il carattere non è
													// numerico:
					ok = false;
				}
			}

		}
		return ok;
	}

	/**
	 * checkCaratteriAlfabetici Controlla la correttezza posizionale dei caratteri numerici.
	 * 
	 * @param codfiscale
	 * @return true: se i caratteri numerici del codice fiscale sono ben posizionati false: se i caratteri numerici del
	 *         codice fiscale non sono ben posizionati.
	 */
	private static boolean checkCaratteriAlfabetici(String codfiscale) {
		boolean ok = true;
		for (int k = 0; (k < codfiscale.length()) && (ok); k++) {
			char car = codfiscale.charAt(k);
			if (k == 0 || k == 1 || k == 2 || k == 3 || k == 4 || k == 5) { // controllo
																			// caratteri
																			// alfabetici
				// M.F. 30/09/2002 N.B. solo i primi sei caratteri devono essere
				// alfabetici
				if (StringUtils.isDigit(car)) { // se il carattere non è
												// alfabetico, ma è un numero:
					ok = false;
				}
			}
		}
		return ok;
	}

	/**
	 * Controlla l'ottavo carattere
	 * 
	 * @param codicefiscale
	 * @return
	 */
	private static boolean checkCarattereMese(String codicefiscale) {
		char c = codicefiscale.charAt(8);
		switch (c) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'H':
		case 'L':
		case 'M':
		case 'P':
		case 'R':
		case 'S':
		case 'T':
			return true;
		default:
			return false;
		}
	}

	/**
	 * checkSesso Controlla la correttezza del codice fiscale rispetto al sesso dichiarato ed al giorno di nascita.
	 * Viene introdotto un modificatore: se l'individuo è maschio il modificatore è 0; se l'individuo è femmina il
	 * modificatore è 40. Questo valore viene sottratto al giorno di nascita presente nel codice fiscale. Se il
	 * risultato corrisponde con la data di nascita, siamo in presenza di dati corretti. Altrimenti la funzione
	 * restituisce FALSE.
	 * 
	 * @param codfiscale
	 * @return true: se i caratteri numerici del codice fiscale sono ben posizionati false: se i caratteri numerici del
	 *         codice fiscale non sono ben posizionati.
	 */
	private static boolean checkSesso(String codfiscale, String sesso, String data_nascita) {
		int modificatore_sesso = 0;
		switch (sesso.charAt(0)) {
		case 'M': {
			modificatore_sesso = 0;
		}
			break;
		case 'F': {
			modificatore_sesso = 40;
		}
			break;
		}
		// controllo la corrispondenza tra il sesso dichiarato, la data di
		// nascita ed
		// il codice fiscale. Il valore di verità che scaturisce dall'operazione
		// viene ritornato.
		// se i dati corrispondono la funzione restituirà true
		// altrimenti la funzione restituirà false.

		int gg_int = new Integer(codfiscale.substring(9, 11)).intValue();
		int gg_data_nascita_int = new Integer(data_nascita.substring(0, 2)).intValue();
		return (gg_data_nascita_int == (gg_int - modificatore_sesso));

	}

	/**
	 * checkDigit Controlla la correttezza del codice di controllo (check digit) del codice fiscale.
	 * 
	 * @param codfiscale
	 * @return true: se il controllo è andato a buon fine false: se il controllo non è andato a buon fine
	 * 
	 * @author Finessi_M
	 */
	private static boolean checkDigit(String codfiscale) {

		// check_code
		// definizione array CARATTERI PARI
		String[][] tabCarPari = new String[36][2];
		for (int i = 0; i < tabCarPari.length; i++) {
			tabCarPari[i] = new String[2];
		}

		// valorizzazione array
		tabCarPari[0][0] = "0";
		tabCarPari[0][1] = "0";
		tabCarPari[1][0] = "1";
		tabCarPari[1][1] = "1";
		tabCarPari[2][0] = "2";
		tabCarPari[2][1] = "2";
		tabCarPari[3][0] = "3";
		tabCarPari[3][1] = "3";
		tabCarPari[4][0] = "4";
		tabCarPari[4][1] = "4";
		tabCarPari[5][0] = "5";
		tabCarPari[5][1] = "5";
		tabCarPari[6][0] = "6";
		tabCarPari[6][1] = "6";
		tabCarPari[7][0] = "7";
		tabCarPari[7][1] = "7";
		tabCarPari[8][0] = "8";
		tabCarPari[8][1] = "8";
		tabCarPari[9][0] = "9";
		tabCarPari[9][1] = "9";
		tabCarPari[10][0] = "A";
		tabCarPari[10][1] = "0";
		tabCarPari[11][0] = "B";
		tabCarPari[11][1] = "1";
		tabCarPari[12][0] = "C";
		tabCarPari[12][1] = "2";
		tabCarPari[13][0] = "D";
		tabCarPari[13][1] = "3";
		tabCarPari[14][0] = "E";
		tabCarPari[14][1] = "4";
		tabCarPari[15][0] = "F";
		tabCarPari[15][1] = "5";
		tabCarPari[16][0] = "G";
		tabCarPari[16][1] = "6";
		tabCarPari[17][0] = "H";
		tabCarPari[17][1] = "7";
		tabCarPari[18][0] = "I";
		tabCarPari[18][1] = "8";
		tabCarPari[19][0] = "J";
		tabCarPari[19][1] = "9";
		tabCarPari[20][0] = "K";
		tabCarPari[20][1] = "10";
		tabCarPari[21][0] = "L";
		tabCarPari[21][1] = "11";
		tabCarPari[22][0] = "M";
		tabCarPari[22][1] = "12";
		tabCarPari[23][0] = "N";
		tabCarPari[23][1] = "13";
		tabCarPari[24][0] = "O";
		tabCarPari[24][1] = "14";
		tabCarPari[25][0] = "P";
		tabCarPari[25][1] = "15";
		tabCarPari[26][0] = "Q";
		tabCarPari[26][1] = "16";
		tabCarPari[27][0] = "R";
		tabCarPari[27][1] = "17";
		tabCarPari[28][0] = "S";
		tabCarPari[28][1] = "18";
		tabCarPari[29][0] = "T";
		tabCarPari[29][1] = "19";
		tabCarPari[30][0] = "U";
		tabCarPari[30][1] = "20";
		tabCarPari[31][0] = "V";
		tabCarPari[31][1] = "21";
		tabCarPari[32][0] = "W";
		tabCarPari[32][1] = "22";
		tabCarPari[33][0] = "X";
		tabCarPari[33][1] = "23";
		tabCarPari[34][0] = "Y";
		tabCarPari[34][1] = "24";
		tabCarPari[35][0] = "Z";
		tabCarPari[35][1] = "25";

		// definizione array CARATTERI DISPARI
		String[][] tabCarDispari = new String[36][2];
		for (int i = 0; i < tabCarDispari.length; i++) {
			tabCarDispari[i] = new String[2];
		}

		// valorizzazione array
		tabCarDispari[0][0] = "1";
		tabCarDispari[0][1] = "00";
		tabCarDispari[1][0] = "2";
		tabCarDispari[1][1] = "5";
		tabCarDispari[2][0] = "3";
		tabCarDispari[2][1] = "7";
		tabCarDispari[3][0] = "4";
		tabCarDispari[3][1] = "9";
		tabCarDispari[4][0] = "5";
		tabCarDispari[4][1] = "13";
		tabCarDispari[5][0] = "6";
		tabCarDispari[5][1] = "15";
		tabCarDispari[6][0] = "7";
		tabCarDispari[6][1] = "17";
		tabCarDispari[7][0] = "8";
		tabCarDispari[7][1] = "19";
		tabCarDispari[8][0] = "9";
		tabCarDispari[8][1] = "21";
		tabCarDispari[9][0] = "0";
		tabCarDispari[9][1] = "1";
		tabCarDispari[10][0] = "A";
		tabCarDispari[10][1] = "1";
		tabCarDispari[11][0] = "B";
		tabCarDispari[11][1] = "0";
		tabCarDispari[12][0] = "C";
		tabCarDispari[12][1] = "5";
		tabCarDispari[13][0] = "D";
		tabCarDispari[13][1] = "7";
		tabCarDispari[14][0] = "E";
		tabCarDispari[14][1] = "9";
		tabCarDispari[15][0] = "F";
		tabCarDispari[15][1] = "13";
		tabCarDispari[16][0] = "G";
		tabCarDispari[16][1] = "15";
		tabCarDispari[17][0] = "H";
		tabCarDispari[17][1] = "17";
		tabCarDispari[18][0] = "I";
		tabCarDispari[18][1] = "19";
		tabCarDispari[19][0] = "J";
		tabCarDispari[19][1] = "21";
		tabCarDispari[20][0] = "K";
		tabCarDispari[20][1] = "2";
		tabCarDispari[21][0] = "L";
		tabCarDispari[21][1] = "4";
		tabCarDispari[22][0] = "M";
		tabCarDispari[22][1] = "18";
		tabCarDispari[23][0] = "N";
		tabCarDispari[23][1] = "20";
		tabCarDispari[24][0] = "O";
		tabCarDispari[24][1] = "11";
		tabCarDispari[25][0] = "P";
		tabCarDispari[25][1] = "3";
		tabCarDispari[26][0] = "Q";
		tabCarDispari[26][1] = "6";
		tabCarDispari[27][0] = "R";
		tabCarDispari[27][1] = "8";
		tabCarDispari[28][0] = "S";
		tabCarDispari[28][1] = "12";
		tabCarDispari[29][0] = "T";
		tabCarDispari[29][1] = "14";
		tabCarDispari[30][0] = "U";
		tabCarDispari[30][1] = "16";
		tabCarDispari[31][0] = "V";
		tabCarDispari[31][1] = "10";
		tabCarDispari[32][0] = "W";
		tabCarDispari[32][1] = "22";
		tabCarDispari[33][0] = "X";
		tabCarDispari[33][1] = "25";
		tabCarDispari[34][0] = "Y";
		tabCarDispari[34][1] = "24";
		tabCarDispari[35][0] = "Z";
		tabCarDispari[35][1] = "23";

		// definizione array CARATTERI CHECK-DIGIT
		String[][] tabCarCheck = new String[26][2];
		for (int i = 0; i < tabCarCheck.length; i++) {
			tabCarCheck[i] = new String[2];
		}

		// valorizzazione array
		tabCarCheck[0][0] = "A";
		tabCarCheck[0][1] = "0";
		tabCarCheck[1][0] = "B";
		tabCarCheck[1][1] = "1";
		tabCarCheck[2][0] = "C";
		tabCarCheck[2][1] = "2";
		tabCarCheck[3][0] = "D";
		tabCarCheck[3][1] = "3";
		tabCarCheck[4][0] = "E";
		tabCarCheck[4][1] = "4";
		tabCarCheck[5][0] = "F";
		tabCarCheck[5][1] = "5";
		tabCarCheck[6][0] = "G";
		tabCarCheck[6][1] = "6";
		tabCarCheck[7][0] = "H";
		tabCarCheck[7][1] = "7";
		tabCarCheck[8][0] = "I";
		tabCarCheck[8][1] = "8";
		tabCarCheck[9][0] = "J";
		tabCarCheck[9][1] = "9";
		tabCarCheck[10][0] = "K";
		tabCarCheck[10][1] = "10";
		tabCarCheck[11][0] = "L";
		tabCarCheck[11][1] = "11";
		tabCarCheck[12][0] = "M";
		tabCarCheck[12][1] = "12";
		tabCarCheck[13][0] = "N";
		tabCarCheck[13][1] = "13";
		tabCarCheck[14][0] = "O";
		tabCarCheck[14][1] = "14";
		tabCarCheck[15][0] = "P";
		tabCarCheck[15][1] = "15";
		tabCarCheck[16][0] = "Q";
		tabCarCheck[16][1] = "16";
		tabCarCheck[17][0] = "R";
		tabCarCheck[17][1] = "17";
		tabCarCheck[18][0] = "S";
		tabCarCheck[18][1] = "18";
		tabCarCheck[19][0] = "T";
		tabCarCheck[19][1] = "19";
		tabCarCheck[20][0] = "U";
		tabCarCheck[20][1] = "20";
		tabCarCheck[21][0] = "V";
		tabCarCheck[21][1] = "21";
		tabCarCheck[22][0] = "W";
		tabCarCheck[22][1] = "22";
		tabCarCheck[23][0] = "X";
		tabCarCheck[23][1] = "23";
		tabCarCheck[24][0] = "Y";
		tabCarCheck[24][1] = "24";
		tabCarCheck[25][0] = "Z";
		tabCarCheck[25][1] = "25";

		int numPari = 0; // sommatoria caratteri pari
		int numDispari = 0; // sommatoria caratteri dispari
		for (int i = 0; i < codfiscale.length() - 1; i++) {
			char c = codfiscale.charAt(i);

			if ((i + 1) % 2 != 0) // numeri dispari
			{
				int tmpNum = 0;
				char[] tmpchar;
				for (int j = 0; j < tabCarDispari.length; j++) {
					tmpchar = tabCarDispari[j][0].toCharArray();
					// if (tabCarDispari[j][0] == c)
					if (tmpchar[0] == c) {
						tmpNum = Integer.parseInt(tabCarDispari[j][1], 10);
						break;
					}
				}
				numDispari += tmpNum;
			} else // numeri pari
			{
				int tmpNum = 0;
				char[] tmpchar;
				for (int j = 0; j < tabCarPari.length; j++) {
					tmpchar = tabCarPari[j][0].toCharArray();
					// if (tabCarPari[j][0] == c)
					if (tmpchar[0] == c) {
						tmpNum = Integer.parseInt(tabCarPari[j][1], 10);
						break;
					}
				}
				numPari += tmpNum;

			}
		} // for

		int checkDigit = (numPari + numDispari) % 26;

		char tmpCheck = codfiscale.charAt(codfiscale.length() - 1);
		int tmpCheckInt = 0;
		char[] tmpchar;

		for (int j = 0; j < tabCarCheck.length; j++) {
			tmpchar = tabCarCheck[j][0].toCharArray();
			// if (tabCarCheck[j][0] == tmpCheck)
			if (tmpchar[0] == tmpCheck) {
				tmpCheckInt = Integer.parseInt(tabCarCheck[j][1], 10);
				break;
			}
		}

		if (checkDigit == tmpCheckInt) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * checkCognome Controlla se il cognome è corrispondente ai primi tre caratteri del codice fiscale
	 * 
	 * @param codfiscale
	 *            cognome
	 * @return true: se il cognome corrisponde false: se i primi tre caratteri non corrispondono al cognome dichiarato
	 */
	private static boolean checkCognome(String codfiscale, String cognome) {
		cognome = cognome.toUpperCase();
		String vocali = "";
		String consonanti = "";

		// costruisco, in base al cognome, i primi 3 caratteri del codice
		// fiscale
		for (int k = 0; ((k < cognome.length()) && (consonanti.length() < 3)); k++) {
			char car = cognome.charAt(k);
			if (car == 'A' || car == 'E' || car == 'I' || car == 'O' || car == 'U') {
				vocali = vocali + car;
			} else if (car == 'B' || car == 'C' || car == 'D' || car == 'F' || car == 'G' || car == 'H' || car == 'J'
					|| car == 'K' || car == 'L' || car == 'M' || car == 'N' || car == 'P' || car == 'Q' || car == 'R'
					|| car == 'S' || car == 'T' || car == 'V' || car == 'W' || car == 'X' || car == 'X' || car == 'Y'
					|| car == 'Z') {
				consonanti = consonanti + car;
			}
		}

		if (consonanti.length() < 3) { // Se le consonanti sono minori di tre

			for (int i = 0; (consonanti.length() < 3) && (vocali.length() > i); i++) {
				// aggiungo tante vocali quante ne servono affinche'
				// le consonanti siano tre.
				consonanti = consonanti + vocali.substring(i, i + 1);
			}
		}
		if (consonanti.length() < 3) { // se le consonanti continuano ad essere
										// tre, aggiungo delle X
			for (int i = 0; consonanti.length() < 3; i++) {
				consonanti = consonanti + "X";
			}
		}

		if ((consonanti.compareTo(codfiscale.substring(0, 3))) == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * checkNome Controlla se il nome è corrispondente alla seconda serie di tre caratteri del codice fiscale
	 * 
	 * @param codfiscale
	 *            nome
	 * @return true: se il nome corrisponde false: se la seconda serie di tre caratteri non corrisponde al nome
	 *         dichiarato
	 */
	private static boolean checkNome(String codfiscale, String nome) {
		nome = nome.toUpperCase();
		String vocali = "";
		String consonanti = "";

		// costruisco, in base al nome, la seconda serie di 3 caratteri del
		// codice fiscale
		for (int k = 0; (k < nome.length()); k++) {
			char car = nome.charAt(k);
			if (car == 'A' || car == 'E' || car == 'I' || car == 'O' || car == 'U') {
				vocali = vocali + car;
			} else if (car == 'B' || car == 'C' || car == 'D' || car == 'F' || car == 'G' || car == 'H' || car == 'J'
					|| car == 'K' || car == 'L' || car == 'M' || car == 'N' || car == 'P' || car == 'Q' || car == 'R'
					|| car == 'S' || car == 'T' || car == 'V' || car == 'W' || car == 'X' || car == 'X' || car == 'Y'
					|| car == 'Z') {
				consonanti = consonanti + car;
			}
		}

		// se la lunghezza delle consonanti è maggiore di quattro
		// prelevo solo la prima, la terza e la quarta consonante
		if (consonanti.length() >= 4) {
			consonanti = consonanti.substring(0, 1) + consonanti.substring(2, 4);
		} else if (consonanti.length() < 3) {
			// se la lunghezza è minore di tre aggiungo le vocali
			for (int k = 0; ((k < vocali.length()) && (consonanti.length() < 3)); k++) {
				consonanti = consonanti + vocali.substring(k, k + 1);
			}
			// se non basta, aggiungo le X
			if (consonanti.length() < 3) {
				for (int i = 0; consonanti.length() < 3; i++) {
					consonanti = consonanti + "X";
				}
			}
		}

		if ((consonanti.compareTo(codfiscale.substring(3, 6))) == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * checkMese Controlla se il mese del codice fiscale corrisponde al mese della data di nascita secondo la seguente
	 * codifica: A= Gennaio; B= Febbraio; C= Marzo; D= Aprile; E= Maggio; H= Giugno; L= Luglio; M= Agosto; P= Settembre;
	 * R= Ottobre; S= Novembre; T= Dicembre
	 * 
	 * @param codfiscale
	 *            data_nascita
	 * @return true: se il mese di nsacita corrisponde al codice fiscale false: se il mese di nascita non corrisponde al
	 *         codice fiscale
	 */
	private static boolean checkMese(String codfiscale, String data_nascita) {

		char[] mesi = new char[13]; // uno in più perché parto da 1 e non da 0
		int i;
		// imposto la tabella di trascodifica
		mesi[1] = 'A';
		mesi[2] = 'B';
		mesi[3] = 'C';
		mesi[4] = 'D';
		mesi[5] = 'E';
		mesi[6] = 'H';
		mesi[7] = 'L';
		mesi[8] = 'M';
		mesi[9] = 'P';
		mesi[10] = 'R';
		mesi[11] = 'S';
		mesi[12] = 'T';

		char mese_codfiscale = codfiscale.charAt(8);
		for (i = 1; (i <= 12) && (mesi[i] != mese_codfiscale); i++) {
			// vuoto, perché il controllo è fatto sul ciclo. Se troviamo la
			// corrispondenza
			// tra il mese ed il codice fiscale, allora usciamo dal ciclo.
		}
		if (i == 13) {
			return false; // non abbiamo trovato alcun mese corrispondente
							// alla lettera
			// presente nel codice fiscale. Il codice fiscale è sbagliato.
		} else { // Mi basterà leggere i e vedere se è uguale alla data di
					// nascita
			// però prima devo formattare i
			String i_string = String.valueOf(i); // lo trasformo in una
													// stringa
			if (i < 10) { // se i è di una sola cifra
				i_string = "0" + i_string; // aggiungo uno 0 prima della cifra
											// significativa
			}
			// ora sono pronto per effettuare il controllo
			if ((i_string.compareTo(data_nascita.substring(3, 5))) == 0) {
				return true; // se il controllo ha successo
			} else {
				return false; // se il controllo fallisce
			}
		}
	}

	/**
	 * checkAnno Controlla se l'anno del codice fiscale corrisponde all'anno di nascita
	 * 
	 * @param codfiscale
	 *            data_nascita
	 * @return true se l'anno di nsacita corrisponde al codice fiscale false se l'anno di nascita non corrisponde al
	 *         codice fiscale
	 */
	private static boolean checkAnno(String codfiscale, String data_nascita) {
		// if
		// ((codfiscale.substring(6,7).compareTo(data_nascita.substring(8,9)))==0)
		if ((codfiscale.substring(6, 8).compareTo(data_nascita.substring(8, 10))) == 0) {
			return true;
		} else {
			return false;
		}

	}

	private static String checkAndReplaceCodiceComune(String codfiscale) {
		char[] arry = codfiscale.toCharArray();

		// sostituisci eventuali lettere con i numeri corrispondenti
		if (!Character.isDigit(arry[12])) {
			arry[12] = replaceOmocodia(arry[12]);
		}
		if (!Character.isDigit(arry[13])) {
			arry[13] = replaceOmocodia(arry[13]);
		}
		if (!Character.isDigit(arry[14])) {
			arry[14] = replaceOmocodia(arry[14]);
		}

		if (arry[12] == 'X' || arry[13] == 'X' || arry[14] == 'X') {
			return null;
		} else {
			// ricompongo il codice. Se qualcosa è andato storto ci sarà una X di mezzo che fa saltare il controllo
			// successivo.
			String ncodfiscale = new String(arry);
			return ncodfiscale;
		}

	}

	/**
	 * checkComune Controlla se il comune inserito corrisponde al comune presente nel codice fiscale
	 * 
	 * @param codfiscale
	 *            comune
	 * @return true se il comune corrisponde false se il comune non corrisponde
	 */
	private static boolean checkComune(String codfiscale, String comuneOrig) {
		String codiceComuneCF = codfiscale.substring(11, 15);
		char _0 = codiceComuneCF.charAt(0);
		char _1 = codiceComuneCF.charAt(1);
		char _2 = codiceComuneCF.charAt(2);
		char _3 = codiceComuneCF.charAt(3);

		// sostituisci eventuali lettere con i numeri corrispondenti
		if (!Character.isDigit(_1)) {
			_1 = replaceOmocodia(_1);
		}
		if (!Character.isDigit(_2)) {
			_2 = replaceOmocodia(_2);
		}
		if (!Character.isDigit(_3)) {
			_3 = replaceOmocodia(_3);
		}
		// ricompongo il codice. Se qualcosa è andato storto ci sarà una X di mezzo che fa saltare il controllo
		// successivo.
		codiceComuneCF = "" + _0 + _1 + _2 + _3;

		// se il codice torna tutto OK
		if ((codiceComuneCF.compareTo(comuneOrig)) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Tabella B è conversione di cifre in caratteri alfabetici (per omocodici) 0 = L 4 = Q 8 = U 1 = M 5 = R 9 = V 2 =
	 * N 6 = S 3 = P 7 = T
	 * 
	 * @see http://www.agenziaentrate.it/wps/wcm/connect/Nsilib/Nsi/Servizi/Codice+fiscale+-+tessera+sanitaria/NSI+Informazioni+sulla+codificazione+delle+persone+fisiche
	 */

	private static char replaceOmocodia(char _cod) {
		switch (_cod) {
		case 'L':
			return '0';
		case 'M':
			return '1';
		case 'N':
			return '2';
		case 'P':
			return '3';
		case 'Q':
			return '4';
		case 'R':
			return '5';
		case 'S':
			return '6';
		case 'T':
			return '7';
		case 'U':
			return '8';
		case 'V':
			return '9';
		default:
			return 'X';
		}
	}

	private static boolean checkNumericoCF(String codfiscale) {

		/*
		 * boolean ok=true; for (int k=0; k<codfiscale.length()-1 && ok; k++) {
		 * ok=StringUtils.isDigit(codfiscale.charAt(k)); } return ok;
		 */

		// controlla se tutti i caratteri sono numeri
		// for (int i = 0; i < codfiscale.length(); i++) {
		// // controlla se il carattere è un numero
		// char c = codfiscale.charAt(i);
		// if (!StringUtils.isDigit(c)) {
		// throw new CfAZException(MessageCodes.CodiceFiscaleAzienda.ERR_NAN);
		// }
		// }

		// controllo check-digit
		int sumDispari = 0;
		int sumPari1 = 0;
		int sumPari2 = 0;

		for (int i = 0; i < codfiscale.length() - 1; i++) {
			int c = codfiscale.charAt(i) - '0';

			if ((i + 1) % 2 != 0) // numeri dispari
			{
				sumDispari += c;
			} else // numeri pari
			{
				// se il doppio di c è un numero a duna cifra lo sommo
				if (c >= 0 && c <= 4)
					sumPari1 += c * 2;
				// se ha due cifre le sommo e aggiungo il risultato della somma
				else if (c >= 5 && c <= 9)
					sumPari2 += (c * 2) - 9;
			}
		}

		int total = sumDispari + sumPari1 + sumPari2;

		String Totale = Integer.toString(total);

		// ultima cifra
		char tmpCheck = Totale.charAt(Totale.length() - 1);
		// ultima cifra in formato numerico
		int inttmpCheck = tmpCheck - '0';
		int CheckDigit = 0;

		// se l'ultima cifra è diversa da 0 la sottraggo a 10. ecco la check digit
		if (inttmpCheck >= 1 && inttmpCheck <= 9)
			CheckDigit = 10 - inttmpCheck;
		// CheckDigit = 10 - tmpchk[0];
		else // altrimenti la check digit è 0
			CheckDigit = 0;

		// corrisponde alla mia checkdigit?
		if (!(CheckDigit == (codfiscale.charAt(codfiscale.length() - 1) - '0'))) {
			return false;
		}

		return true; // Se siamo arrivati fin qui è tutto ok!
	}

}