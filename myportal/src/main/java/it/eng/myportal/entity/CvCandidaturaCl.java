package it.eng.myportal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import it.eng.myportal.entity.decodifiche.DeStatoInvioCl;
import it.eng.myportal.entity.decodifiche.DeTipoComunicazioneCl;

/**
 * CvCandidaturaCl generated by hbm2java
 */
@Entity
@Table(name = "cv_candidatura_cl", schema = "myportal")
@NamedQueries({
	@NamedQuery(
	name = "findCandidaturaByCodComunicazione",
	query = "select l from CvCandidaturaCl l where l.codComunicazione = :codComunicazione"
	),
	@NamedQuery(
	name = "findCandidaturaByCodComunicazionePrec",
	query = "select l from CvCandidaturaCl l where l.codComunicazionePrec = :codComunicazione"
	),
	@NamedQuery(
	name = "findCandidatureDaInviare",
	query = "select l from CvCandidaturaCl l where l.deStatoInvioCl.codStatoInvioCl in ('PA','CA','VA','MA')"
	)
})
public class CvCandidaturaCl extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5353865150532485505L;
	private Integer idCvDatiPersonali;
	private CvDatiPersonali cvDatiPersonali;
	private DeStatoInvioCl deStatoInvioCl;
	private DeTipoComunicazioneCl deTipoComunicazioneCl;
	private String codComunicazione;
	private String codComunicazionePrec;
	private Date dtInvio;

	public CvCandidaturaCl() {
		cvDatiPersonali = new CvDatiPersonali();
		deStatoInvioCl = new DeStatoInvioCl();
		deTipoComunicazioneCl = new DeTipoComunicazioneCl();
	}

	public CvCandidaturaCl(Integer idCvCandidaturaCl,
			CvDatiPersonali cvDatiPersonali,
			DeTipoComunicazioneCl deTipoComunicazioneCl, Date dtmIns,
			Date dtmMod, Integer idPrincipalIns, Integer idPrincipalMod) {
		this.idCvDatiPersonali = idCvCandidaturaCl;
		this.cvDatiPersonali = cvDatiPersonali;
		this.deTipoComunicazioneCl = deTipoComunicazioneCl;

	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "cvDatiPersonali"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id_cv_dati_personali", unique = true, nullable = false)
	public Integer getIdCvDatiPersonali() {
		return this.idCvDatiPersonali;
	}

	public void setIdCvDatiPersonali(Integer idCvDatiPersonali) {
		this.idCvDatiPersonali = idCvDatiPersonali;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public CvDatiPersonali getCvDatiPersonali() {
		return this.cvDatiPersonali;
	}

	public void setCvDatiPersonali(CvDatiPersonali cvDatiPersonali) {
		this.cvDatiPersonali = cvDatiPersonali;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_stato_invio_cl")
	public DeStatoInvioCl getDeStatoInvioCl() {
		return this.deStatoInvioCl;
	}

	public void setDeStatoInvioCl(DeStatoInvioCl deStatoInvioCl) {
		this.deStatoInvioCl = deStatoInvioCl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipo_comunicazione_cl", nullable = false)
	public DeTipoComunicazioneCl getDeTipoComunicazioneCl() {
		return this.deTipoComunicazioneCl;
	}

	public void setDeTipoComunicazioneCl(
			DeTipoComunicazioneCl deTipoComunicazioneCl) {
		this.deTipoComunicazioneCl = deTipoComunicazioneCl;
	}

	@Column(name = "cod_comunicazione", length = 25, unique = true)
	public String getCodComunicazione() {
		return this.codComunicazione;
	}

	public void setCodComunicazione(String codComunicazione) {
		this.codComunicazione = codComunicazione;
	}

	@Column(name = "cod_comunicazione_prec", length = 25, unique = true)
	public String getCodComunicazionePrec() {
		return this.codComunicazionePrec;
	}

	public void setCodComunicazionePrec(String codComunicazionePrec) {
		this.codComunicazionePrec = codComunicazionePrec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_invio", length = 13)
	public Date getDtInvio() {
		return this.dtInvio;
	}

	public void setDtInvio(Date dtInvio) {
		this.dtInvio = dtInvio;
	}
}
