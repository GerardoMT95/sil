package it.eng.myportal.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

// Generated Mar 1, 2012 12:28:41 PM by Hibernate Tools 3.4.0.CR1
import it.eng.myportal.dtos.MsgMessaggioAtipicoMiniDTO;
import it.eng.myportal.entity.decodifiche.DeRuoloPortale;
import it.eng.myportal.utils.ConstantsSingleton;

/**
 * PfPrincipal generated by hbm2java
 */
@Entity
@Table(name = "pf_principal", schema = "mycas", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@NamedQueries({ 
	@NamedQuery(name = "findAbilitatiByUsername", query = "SELECT pf FROM PfPrincipal pf WHERE upper(pf.username) = :username AND pf.flagAbilitato = 'Y'"),
	@NamedQuery(name = "findByIdVaDatiVacancy", query = "SELECT pp FROM VaDatiVacancy vdv join vdv.pfPrincipal pp WHERE vdv.idVaDatiVacancy = :idVaDatiVacancy"),
	@NamedQuery(name = "findPaleseByIdVaDatiVacancy", query = "SELECT pp FROM VaDatiVacancy vdv join vdv.pfPrincipalPalese pp WHERE vdv.idVaDatiVacancy = :idVaDatiVacancy"),
})

public class PfPrincipal extends AbstractEntity implements java.io.Serializable {
	private static final long serialVersionUID = 317391L;
	private Integer idPfPrincipal;

	private String username;
	private String passWord;
	private Date dtScadenza;
	private Boolean flagAbilitato;
	private Boolean flagAbilitatoServizi;
	private Boolean flagAbilitatoSare;
	private Boolean flagAbilitaPec;
	private DeRuoloPortale deRuoloPortale;

	private UtenteInfo utenteInfo;
	private AziendaInfo aziendaInfo;
	private CoordinatoreInfo coordinatoreInfo;
	private ConsulenteInfo consulenteInfo;
	private CertificatoreInfo certificatoreInfo;

	private String cognome;
	private String confirmationToken;
	@Column(name = "domanda", length = 255)
	private String domanda;
	private Date dtEmailPassword;
	private Date dtEmailVerification;
	private Date dtFineValidita;
	private Date dtLastCheckin;
	private Date dtmConfirm;
	private String email;

	private String indirizzoUtente;
	private String motivoFineValidita;
	private String nome;
	private Integer numTentativi;
	private String passwordToken;

	private String privacy;

	private String registrazioneForteToken;

	private String richiestaRegForteToken;

	private Set<CvDatiPersonali> cvDatiPersonalis = new HashSet<CvDatiPersonali>(0);

	private Set<CvDatiPersonali> cvDatiPersonaliPalesi = new HashSet<CvDatiPersonali>(0);
	private Set<RvTestata> rvTestatas = new HashSet<RvTestata>(0);
	private Set<CvLetteraAcc> cvLetteraAccs = new HashSet<CvLetteraAcc>(0);

	private Set<MsgMessaggioLetto> msgMessaggioLettosForIdPfPrincipal = new HashSet<MsgMessaggioLetto>(0);

	private Set<MsgMessaggio> msgMessaggiosForIdPfPrincipalTo = new HashSet<MsgMessaggio>(0);

	private Set<Regione> regionesForIdPfPrincipal = new HashSet<Regione>(0);

	private Set<MsgMessaggio> msgMessaggiosForIdPfPrincipalFrom = new HashSet<MsgMessaggio>(0);

	private Set<PtScrivania> ptScrivaniasForIdPfPrincipal = new HashSet<PtScrivania>(0);

	private Set<Provincia> provinciasForIdPfPrincipal = new HashSet<Provincia>(0);

	/**
	 * vacancy visualizzabili
	 */
	private Set<VaDatiVacancy> viewableVaDatiVacancy = new HashSet<VaDatiVacancy>(0);

	/**
	 * cv visualizzabili
	 */
	private Set<CvDatiPersonali> viewableCvDatiPersonali = new HashSet<CvDatiPersonali>(0);

	private Set<AcCandidatura> acCandidaturas = new HashSet<AcCandidatura>(0);

	private AziendaInfoRettifica aziendaInfoRettifica;

	private Set<VaDatiVacancy> vaDatiVacancies = new HashSet<VaDatiVacancy>(0);
	private Set<VaDatiVacancy> vaDatiVacanciesPalesi = new HashSet<VaDatiVacancy>(0);

	private SvAziendaInfo svAziendaInfo;

	private Set<Patronato> patronatosForIdPfPrincipal = new HashSet<Patronato>(0);

	private Set<SoggettoPubblico> soggettoPubbsForIdPfPrincipal = new HashSet<SoggettoPubblico>(0);

	public PfPrincipal() {
	}

	@Id
	@SequenceGenerator(name = "mycas.pf_principal_id_pf_principal_seq", sequenceName = "mycas.pf_principal_id_pf_principal_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mycas.pf_principal_id_pf_principal_seq")
	@Column(name = "id_pf_principal", unique = true, nullable = false)
	public Integer getIdPfPrincipal() {
		return this.idPfPrincipal;
	}

	public void setIdPfPrincipal(Integer idPfPrincipal) {
		this.idPfPrincipal = idPfPrincipal;
	}

	@Column(name = "username", unique = true, nullable = false, length = 16)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "pass_word", nullable = false, length = 1024)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_scadenza", nullable = false, length = 13)
	public Date getDtScadenza() {
		return this.dtScadenza;
	}

	public void setDtScadenza(Date dtScadenza) {
		this.dtScadenza = dtScadenza;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<AcCandidatura> getAcCandidaturas() {
		return this.acCandidaturas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<VaDatiVacancy> getVaDatiVacancies() {
		return this.vaDatiVacancies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipalPalese")
	public Set<VaDatiVacancy> getVaDatiVacanciesPalesi() {
		return this.vaDatiVacanciesPalesi;
	}

	public void setAcCandidaturas(Set<AcCandidatura> acCandidaturas) {
		this.acCandidaturas = acCandidaturas;
	}

	public void setVaDatiVacancies(Set<VaDatiVacancy> vaDatiVacancies) {
		this.vaDatiVacancies = vaDatiVacancies;
	}

	public void setVaDatiVacanciesPalesi(Set<VaDatiVacancy> vaDatiVacanciesPalesi) {
		this.vaDatiVacanciesPalesi = vaDatiVacanciesPalesi;
	}

	@Type(type = "yes_no")
	@Column(name = "flag_abilitato", nullable = false, length = 1)
	public Boolean getFlagAbilitato() {
		return this.flagAbilitato;
	}

	public void setFlagAbilitato(Boolean flagAbilitato) {
		this.flagAbilitato = flagAbilitato;
	}

	@Type(type = "yes_no")
	@Column(name = "flag_abilitato_servizi", nullable = false, length = 1)
	public Boolean getFlagAbilitatoServizi() {
		return this.flagAbilitatoServizi;
	}

	public void setFlagAbilitatoServizi(Boolean flagAbilitatoServizi) {
		this.flagAbilitatoServizi = flagAbilitatoServizi;
	}

	@Type(type = "yes_no")
	@Column(name = "flag_abilitato_sare", nullable = false, length = 1)
	public Boolean getFlagAbilitatoSare() {
		return this.flagAbilitatoSare;
	}

	public void setFlagAbilitatoSare(Boolean flagAbilitatoSare) {
		this.flagAbilitatoSare = flagAbilitatoSare;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<MsgMessaggioLetto> getMsgMessaggioLettosForIdPfPrincipal() {
		return this.msgMessaggioLettosForIdPfPrincipal;
	}

	public void setMsgMessaggioLettosForIdPfPrincipal(Set<MsgMessaggioLetto> msgMessaggioLettosForIdPfPrincipal) {
		this.msgMessaggioLettosForIdPfPrincipal = msgMessaggioLettosForIdPfPrincipal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipalTo")
	public Set<MsgMessaggio> getMsgMessaggiosForIdPfPrincipalTo() {
		return this.msgMessaggiosForIdPfPrincipalTo;
	}

	public void setMsgMessaggiosForIdPfPrincipalTo(Set<MsgMessaggio> msgMessaggiosForIdPfPrincipalTo) {
		this.msgMessaggiosForIdPfPrincipalTo = msgMessaggiosForIdPfPrincipalTo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<Regione> getRegionesForIdPfPrincipal() {
		return this.regionesForIdPfPrincipal;
	}

	public void setRegionesForIdPfPrincipal(Set<Regione> regionesForIdPfPrincipal) {
		this.regionesForIdPfPrincipal = regionesForIdPfPrincipal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipalFrom")
	public Set<MsgMessaggio> getMsgMessaggiosForIdPfPrincipalFrom() {
		return this.msgMessaggiosForIdPfPrincipalFrom;
	}

	public void setMsgMessaggiosForIdPfPrincipalFrom(Set<MsgMessaggio> msgMessaggiosForIdPfPrincipalFrom) {
		this.msgMessaggiosForIdPfPrincipalFrom = msgMessaggiosForIdPfPrincipalFrom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<PtScrivania> getPtScrivaniasForIdPfPrincipal() {
		return this.ptScrivaniasForIdPfPrincipal;
	}

	public void setPtScrivaniasForIdPfPrincipal(Set<PtScrivania> ptScrivaniasForIdPfPrincipal) {
		this.ptScrivaniasForIdPfPrincipal = ptScrivaniasForIdPfPrincipal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<Provincia> getProvinciasForIdPfPrincipal() {
		return this.provinciasForIdPfPrincipal;
	}

	public void setProvinciasForIdPfPrincipal(Set<Provincia> provinciasForIdPfPrincipal) {
		this.provinciasForIdPfPrincipal = provinciasForIdPfPrincipal;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public UtenteInfo getUtenteInfo() {
		return this.utenteInfo;
	}

	public void setUtenteInfo(UtenteInfo utenteInfo) {
		this.utenteInfo = utenteInfo;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public AziendaInfo getAziendaInfo() {
		return this.aziendaInfo;
	}

	public void setAziendaInfo(AziendaInfo aziendaInfo) {
		this.aziendaInfo = aziendaInfo;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public CoordinatoreInfo getCoordinatoreInfo() {
		return this.coordinatoreInfo;
	}

	public void setCoordinatoreInfo(CoordinatoreInfo coordinatoreInfo) {
		this.coordinatoreInfo = coordinatoreInfo;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public CertificatoreInfo getCertificatoreInfo() {
		return this.certificatoreInfo;
	}

	public void setCertificatoreInfo(CertificatoreInfo certificatoreInfo) {
		this.certificatoreInfo = certificatoreInfo;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public AziendaInfoRettifica getAziendaInfoRettifica() {
		return this.aziendaInfoRettifica;
	}

	public void setAziendaInfoRettifica(AziendaInfoRettifica aziendaInfoRettifica) {
		this.aziendaInfoRettifica = aziendaInfoRettifica;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public SvAziendaInfo getSvAziendaInfo() {
		return this.svAziendaInfo;
	}

	public void setSvAziendaInfo(SvAziendaInfo svAziendaInfo) {
		this.svAziendaInfo = svAziendaInfo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<CvDatiPersonali> getCvDatiPersonalis() {
		return this.cvDatiPersonalis;
	}

	public void setCvDatiPersonalis(Set<CvDatiPersonali> cvDatiPersonalis) {
		this.cvDatiPersonalis = cvDatiPersonalis;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipalPalese")
	public Set<CvDatiPersonali> getCvDatiPersonaliPalesi() {
		return this.cvDatiPersonaliPalesi;
	}

	public void setCvDatiPersonaliPalesi(Set<CvDatiPersonali> cvDatiPersonaliPalesi) {
		this.cvDatiPersonaliPalesi = cvDatiPersonaliPalesi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<RvTestata> getRvTestatas() {
		return this.rvTestatas;
	}

	public void setRvTestatas(Set<RvTestata> rvTestatas) {
		this.rvTestatas = rvTestatas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<CvLetteraAcc> getCvLetteraAccs() {
		return this.cvLetteraAccs;
	}

	public void setCvLetteraAccs(Set<CvLetteraAcc> cvLetteraAccs) {
		this.cvLetteraAccs = cvLetteraAccs;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "va_abilita_vis_contatto_az", joinColumns = { @JoinColumn(name = "id_pf_principal", referencedColumnName = "id_pf_principal") }, inverseJoinColumns = { @JoinColumn(name = "id_va_dati_vacancy", referencedColumnName = "id_va_dati_vacancy") })
	public Set<VaDatiVacancy> getViewableVaDatiVacancy() {
		return viewableVaDatiVacancy;
	}

	public void setViewableVaDatiVacancy(Set<VaDatiVacancy> viewableVaDatiVacancy) {
		this.viewableVaDatiVacancy = viewableVaDatiVacancy;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cv_abilita_vis_contatto_lav", joinColumns = { @JoinColumn(name = "id_pf_principal", referencedColumnName = "id_pf_principal") }, inverseJoinColumns = { @JoinColumn(name = "id_cv_dati_personali", referencedColumnName = "id_cv_dati_personali") })
	public Set<CvDatiPersonali> getViewableCvDatiPersonali() {
		return viewableCvDatiPersonali;
	}

	public void setViewableCvDatiPersonali(Set<CvDatiPersonali> viewableCvDatiPersonali) {
		this.viewableCvDatiPersonali = viewableCvDatiPersonali;
	}

	@Transient
	public boolean isUtente() {
		return getUtenteInfo() != null;
	}

	@Transient
	public boolean isAzienda() {
		return getAziendaInfo() != null;
	}

	@Transient
	public boolean isProvincia() {
		return !getProvinciasForIdPfPrincipal().isEmpty();
	}

	@Transient
	public boolean isRegione() {
		return !getRegionesForIdPfPrincipal().isEmpty();
	}

	@Transient
	public boolean isConsulente() {
		return getConsulenteInfo() != null;
	}

	@Transient
	public boolean isCoordinatore() {
		return getCoordinatoreInfo() != null;
	}

	@Transient
	public boolean isAdministrator() {
		return getIdPfPrincipal().intValue() == 0;
	}

	@Transient
	public boolean isCertificatore() {
		return getCertificatoreInfo() != null;
	}

	@Transient
	public boolean isClicLavoro() {
		return ConstantsSingleton.USERNAME_CLICLAVORO_CANDIDATURE.equals(getUsername());
	}

	@Transient
	public boolean isPatronato() {
		return !getPatronatosForIdPfPrincipal().isEmpty();
	}

	@Transient
	public boolean isSoggettoPubblico() {
		return !getSoggettoPubbsForIdPfPrincipal().isEmpty();
	}

	/**
	 * Restituisce true se l'utente non è un consulente. Se l'utente è un consulente deve avere i permessi per
	 * visualizzare la pratica
	 * 
	 * @return
	 */
	@Transient
	public boolean canViewPraticaAtipici(MsgMessaggioAtipicoMiniDTO pratica) {
		if (getConsulenteInfo() == null) {
			return true;
		} else {
			if (pratica.getCodTipoPratica() == null) {
				return false;
			} else {
				/*
				 * un consulente puo' vedere le pratiche della sua stessa categoria (partita iva/atipico). Inoltre se le
				 * pratiche NON sono chiuse solo quelle dello stesso tipo per cui e' abilitato (cod_tipo_pratica)
				 */
				if (((pratica.isPartitaIva() && consulenteInfo.isPartitaIva()) || (pratica.isAtipico() && consulenteInfo
						.isAtipico()))
						&& (consulenteInfo.getDeTipoPratica().getCodTipoPratica().equals(pratica.getCodTipoPratica()) || pratica
								.getCodStatoPratica().equals(ConstantsSingleton.DeStatoPratica.CHIUSA))) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * Restituisce true se l'utente non è un consulente. Se l'utente è un consulente deve avere i permessi per
	 * visualizzare la pratica
	 * 
	 * @return
	 */
	@Transient
	public boolean canViewPraticaAtipici(MsgMessaggioAtipico pratica) {
		if (getConsulenteInfo() == null) {
			return true;
		} else {
			if (pratica.getDeTipoPratica().getCodTipoPratica() == null) {
				return false;
			} else {
				/*
				 * un consulente puo' vedere le pratiche della sua stessa categoria (partita iva/atipico). Inoltre se le
				 * pratiche NON sono chiuse solo quelle dello stesso tipo per cui e' abilitato (cod_tipo_pratica)
				 */
				if (((pratica.isPartitaIva() && consulenteInfo.isPartitaIva()) || (pratica.isAtipico() && consulenteInfo
						.isAtipico()))
						&& (consulenteInfo.getDeTipoPratica().getCodTipoPratica()
								.equals(pratica.getDeTipoPratica().getCodTipoPratica()) || pratica.getDeStatoPratica()
								.getCodStatoPratica().equals(ConstantsSingleton.DeStatoPratica.CHIUSA))) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	@Column(name = "risposta", length = 255)
	private String risposta;

	private String stileSelezionato;
	private String telefonoUtente;

	@Column(name = "cognome", nullable = false, length = 50)
	public String getCognome() {
		return this.cognome;
	}

	@Column(name = "confirmation_token", length = 250)
	public String getConfirmationToken() {
		return this.confirmationToken;
	}

	public String getDomanda() {
		return domanda;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_email_password", length = 29)
	public Date getDtEmailPassword() {
		return this.dtEmailPassword;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_email_verification", length = 29)
	public Date getDtEmailVerification() {
		return this.dtEmailVerification;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fine_validita", length = 29)
	public Date getDtFineValidita() {
		return this.dtFineValidita;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_checkin", length = 29)
	public Date getDtLastCheckin() {
		return dtLastCheckin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtm_confirm", length = 29)
	public Date getDtmConfirm() {
		return this.dtmConfirm;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	@Column(name = "indirizzo_utente", length = 150)
	public String getIndirizzoUtente() {
		return this.indirizzoUtente;
	}

	@Column(name = "motivo_fine_validita", length = 80)
	public String getMotivoFineValidita() {
		return this.motivoFineValidita;
	}

	@Column(name = "nome", nullable = false, length = 50)
	public String getNome() {
		return this.nome;
	}

	@Column(name = "num_tentativi", nullable = false)
	public Integer getNumTentativi() {
		return numTentativi;
	}

	@Column(name = "password_token", length = 250)
	public String getPasswordToken() {
		return passwordToken;
	}

	@Column(name = "privacy", length = 1)
	public String getPrivacy() {
		return this.privacy;
	}

	@Column(name = "registrazione_forte_token", length = 250)
	public String getRegistrazioneForteToken() {
		return registrazioneForteToken;
	}

	@Column(name = "richiesta_reg_forte_token", length = 255)
	public String getRichiestaRegForteToken() {
		return richiestaRegForteToken;
	}

	public String getRisposta() {
		return risposta;
	}

	@Column(name = "stile_selezionato", length = 20)
	public String getStileSelezionato() {
		return this.stileSelezionato;
	}

	@Column(name = "telefono_utente", length = 30)
	public String getTelefonoUtente() {
		return this.telefonoUtente;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public void setDtEmailPassword(Date dtEmailPassword) {
		this.dtEmailPassword = dtEmailPassword;
	}

	public void setDtEmailVerification(Date dtEmailVerification) {
		this.dtEmailVerification = dtEmailVerification;
	}

	public void setDtFineValidita(Date dtFineValidita) {
		this.dtFineValidita = dtFineValidita;
	}

	public void setDtLastCheckin(Date dtLastCheckin) {
		this.dtLastCheckin = dtLastCheckin;
	}

	public void setDtmConfirm(Date dtmConfirm) {
		this.dtmConfirm = dtmConfirm;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIndirizzoUtente(String indirizzoUtente) {
		this.indirizzoUtente = indirizzoUtente;
	}

	public void setMotivoFineValidita(String motivoFineValidita) {
		this.motivoFineValidita = motivoFineValidita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumTentativi(Integer numTentativi) {
		this.numTentativi = numTentativi;
	}

	public void setPasswordToken(String passwordToken) {
		this.passwordToken = passwordToken;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public void setRegistrazioneForteToken(String registrazioneForteToken) {
		this.registrazioneForteToken = registrazioneForteToken;
	}

	public void setRichiestaRegForteToken(String richiestaRegForteToken) {
		this.richiestaRegForteToken = richiestaRegForteToken;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public void setStileSelezionato(String stileSelezionato) {
		this.stileSelezionato = stileSelezionato;
	}

	public void setTelefonoUtente(String telefonoUtente) {
		this.telefonoUtente = telefonoUtente;
	}

	@Type(type = "yes_no")
	@Column(name = "flag_abilita_pec", nullable = true, length = 1)
	public Boolean getFlagAbilitaPec() {
		return flagAbilitaPec;
	}

	public void setFlagAbilitaPec(Boolean flagAbilitaPec) {
		this.flagAbilitaPec = flagAbilitaPec;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public ConsulenteInfo getConsulenteInfo() {
		return consulenteInfo;
	}

	public void setConsulenteInfo(ConsulenteInfo consulenteInfo) {
		this.consulenteInfo = consulenteInfo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_ruolo_portale", nullable = false)
	public DeRuoloPortale getDeRuoloPortale() {
		return deRuoloPortale;
	}

	public void setDeRuoloPortale(DeRuoloPortale deRuoloPortale) {
		this.deRuoloPortale = deRuoloPortale;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof PfPrincipal))
			return false;
		if (this.getIdPfPrincipal() == null || ((PfPrincipal) obj).getIdPfPrincipal() == null)
			return false;
		return (this.getIdPfPrincipal().equals(((PfPrincipal) obj).getIdPfPrincipal()));

	}

	@Override
	public int hashCode() {
		if (getIdPfPrincipal() == null)
			return 0;
		return getIdPfPrincipal().hashCode();
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<Patronato> getPatronatosForIdPfPrincipal() {
		return this.patronatosForIdPfPrincipal;
	}

	public void setPatronatosForIdPfPrincipal(Set<Patronato> patronatosForIdPfPrincipal) {
		this.patronatosForIdPfPrincipal = patronatosForIdPfPrincipal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pfPrincipal")
	public Set<SoggettoPubblico> getSoggettoPubbsForIdPfPrincipal() {
		return soggettoPubbsForIdPfPrincipal;
	}

	public void setSoggettoPubbsForIdPfPrincipal(Set<SoggettoPubblico> soggettoPubbsForIdPfPrincipal) {
		this.soggettoPubbsForIdPfPrincipal = soggettoPubbsForIdPfPrincipal;
	}
}