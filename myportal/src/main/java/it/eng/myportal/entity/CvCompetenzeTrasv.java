package it.eng.myportal.entity;

// Generated Mar 1, 2012 12:28:41 PM by Hibernate Tools 3.4.0.CR1
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CvCompetenzeTrasv generated by hbm2java
 */
@Entity
@Table(name = "cv_competenze_trasv", schema = "myportal")
@NamedQueries({
	@NamedQuery(name = "CvCompetenzeTrasvByCvId", query = "select d from CvCompetenzeTrasv d where d.cvDatiPersonali.idCvDatiPersonali = :cvId")
})
public class CvCompetenzeTrasv extends AbstractEntity implements java.io.Serializable {
	private static final long serialVersionUID = 385326L;
	private Integer idCvCompetenzeTrasv;

	private CvDatiPersonali cvDatiPersonali;
	private String capCompRelInterpersonali;
	private String capCompTecniche;
	private String capCompOrganizzative;
	private String capCompAltre;

	public CvCompetenzeTrasv() {
	}

	@Id
	@SequenceGenerator(name = "cv_competenze_trasv_id_cv_competenze_trasv_seq", sequenceName = "cv_competenze_trasv_id_cv_competenze_trasv_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cv_competenze_trasv_id_cv_competenze_trasv_seq")
	@Column(name = "id_cv_competenze_trasv", unique = true, nullable = false)
	public Integer getIdCvCompetenzeTrasv() {
		return this.idCvCompetenzeTrasv;
	}

	public void setIdCvCompetenzeTrasv(Integer idCvCompetenzeTrasv) {
		this.idCvCompetenzeTrasv = idCvCompetenzeTrasv;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cv_dati_personali", nullable = false)
	public CvDatiPersonali getCvDatiPersonali() {
		return this.cvDatiPersonali;
	}

	public void setCvDatiPersonali(CvDatiPersonali cvDatiPersonali) {
		this.cvDatiPersonali = cvDatiPersonali;
	}

	@Column(name = "cap_comp_rel_interpersonali", length = 5000)
	public String getCapCompRelInterpersonali() {
		return this.capCompRelInterpersonali;
	}

	public void setCapCompRelInterpersonali(String capCompRelInterpersonali) {
		this.capCompRelInterpersonali = capCompRelInterpersonali;
	}

	@Column(name = "cap_comp_tecniche", length = 5000)
	public String getCapCompTecniche() {
		return this.capCompTecniche;
	}

	public void setCapCompTecniche(String capCompTecniche) {
		this.capCompTecniche = capCompTecniche;
	}

	@Column(name = "cap_comp_organizzative", length = 5000)
	public String getCapCompOrganizzative() {
		return this.capCompOrganizzative;
	}

	public void setCapCompOrganizzative(String capCompOrganizzative) {
		this.capCompOrganizzative = capCompOrganizzative;
	}

	@Column(name = "cap_comp_altre", length = 5000)
	public String getCapCompAltre() {
		return capCompAltre;
	}

	public void setCapCompAltre(String capCompAltre) {
		this.capCompAltre = capCompAltre;
	}
	
	

}
