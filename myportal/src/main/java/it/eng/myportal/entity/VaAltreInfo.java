package it.eng.myportal.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

// Generated Mar 1, 2012 12:28:41 PM by Hibernate Tools 3.4.0.CR1
import it.eng.myportal.entity.decodifiche.DeGenere;
import it.eng.myportal.entity.decodifiche.DeMotivoGenereSil;
import it.eng.myportal.entity.decodifiche.sil.DeAreaSil;
import org.hibernate.annotations.Type;

/**
 * VaAltreInfo generated by hbm2java
 */
@Entity
@Table(name = "va_altre_info", schema = "myportal")
public class VaAltreInfo extends AbstractEntity implements java.io.Serializable {
	private static final long serialVersionUID = 546480L;
	private Integer idVaDatiVacancy;

	private VaDatiVacancy vaDatiVacancy;
	private String opzAutomunito;
	private String opzMotomunito;
	private String opzVitto;
	private String opzAlloggio;
	private String opzFuorisede;
	private String ulterioriRequisiti;
	private String opzTrasferta;

	// Campi aggiunti per Trento (aprile 2017)
	private String opzMilite;
	private DeGenere deGenere;
	private DeMotivoGenereSil deMotivoGenereSil;
	private String notaMotivoGenere;
	private DeAreaSil deAreaSil;
	private String localita;
	
	//campi aggiunti x IDO 2020
	private Date dataPresuntaAssunzione;
	private String turni;
	private Boolean flagOrarioContinuato;
	private Boolean flagMezzoPubblico;
	private String InfoMezzoPubblico;
	private String sceltaAuto;
	private String sceltaMoto;
	private String sceltaTrasferta;
	private String infoTrasferta;

	public VaAltreInfo() {
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "vaDatiVacancy"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id_va_dati_vacancy", unique = true, nullable = false)
	public Integer getIdVaDatiVacancy() {
		return this.idVaDatiVacancy;
	}

	public void setIdVaDatiVacancy(Integer idVaDatiVacancy) {
		this.idVaDatiVacancy = idVaDatiVacancy;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public VaDatiVacancy getVaDatiVacancy() {
		return this.vaDatiVacancy;
	}

	public void setVaDatiVacancy(VaDatiVacancy vaDatiVacancy) {
		this.vaDatiVacancy = vaDatiVacancy;
	}

	@Column(name = "opz_automunito", length = 1)
	public String getOpzAutomunito() {
		return this.opzAutomunito;
	}

	public void setOpzAutomunito(String opzAutomunito) {
		this.opzAutomunito = opzAutomunito;
	}

	@Column(name = "opz_trasferta", length = 1)
	public String getOpzTrasferta() {
		return this.opzTrasferta;
	}

	public void setOpzTrasferta(String opzTrasferta) {
		this.opzTrasferta = opzTrasferta;
	}

	
	@Column(name = "opz_motomunito", length = 1)
	public String getOpzMotomunito() {
		return this.opzMotomunito;
	}

	public void setOpzMotomunito(String opzMotomunito) {
		this.opzMotomunito = opzMotomunito;
	}

	@Column(name = "opz_vitto", length = 1)
	public String getOpzVitto() {
		return this.opzVitto;
	}

	public void setOpzVitto(String opzVitto) {
		this.opzVitto = opzVitto;
	}

	@Column(name = "opz_alloggio", length = 1)
	public String getOpzAlloggio() {
		return this.opzAlloggio;
	}

	public void setOpzAlloggio(String opzAlloggio) {
		this.opzAlloggio = opzAlloggio;
	}

	@Column(name = "opz_fuorisede", length = 1)
	public String getOpzFuorisede() {
		return this.opzFuorisede;
	}

	public void setOpzFuorisede(String opzFuorisede) {
		this.opzFuorisede = opzFuorisede;
	}

	@Column(name = "ulteriori_requisiti", length = 1000)
	public String getUlterioriRequisiti() {
		return ulterioriRequisiti;
	}

	public void setUlterioriRequisiti(String ulterioriRequisiti) {
		this.ulterioriRequisiti = ulterioriRequisiti;
	}

	@Column(name = "opz_milite", length = 1)
	public String getOpzMilite() {
		return opzMilite;
	}

	public void setOpzMilite(String opzMilite) {
		this.opzMilite = opzMilite;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_genere", nullable = true)
	public DeGenere getDeGenere() {
		return deGenere;
	}

	public void setDeGenere(DeGenere deGenere) {
		this.deGenere = deGenere;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_motivo_genere_sil", nullable = true)
	public DeMotivoGenereSil getDeMotivoGenereSil() {
		return deMotivoGenereSil;
	}

	public void setDeMotivoGenereSil(DeMotivoGenereSil deMotivoGenereSil) {
		this.deMotivoGenereSil = deMotivoGenereSil;
	}

	@Column(name = "nota_motivo_genere", length = 2000)
	public String getNotaMotivoGenere() {
		return notaMotivoGenere;
	}

	public void setNotaMotivoGenere(String notaMotivoGenere) {
		this.notaMotivoGenere = notaMotivoGenere;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_area_sil", nullable = true)
	public DeAreaSil getDeAreaSil() {
		return deAreaSil;
	}

	public void setDeAreaSil(DeAreaSil deAreaSil) {
		this.deAreaSil = deAreaSil;
	}

	@Column(name = "localita", length = 100)
	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_presunta_assunzione", length = 13)
	public Date getDataPresuntaAssunzione() {
		return dataPresuntaAssunzione;
	}

	public void setDataPresuntaAssunzione(Date dataPresuntaAssunzione) {
		this.dataPresuntaAssunzione = dataPresuntaAssunzione;
	}

	@Column(length=250, name="turni")
	public String getTurni() {
		return turni;
	}

	public void setTurni(String turni) {
		this.turni = turni;
	}
	@Column(name = "flag_orario_continuato")
	public Boolean getFlagOrarioContinuato() {
		return flagOrarioContinuato;
	}

	public void setFlagOrarioContinuato(Boolean flagOrarioContinuato) {
		this.flagOrarioContinuato = flagOrarioContinuato;
	}

	@Type(type = "yes_no")
	@Column(name = "flag_mezzo_pubblico", length = 1)
	public Boolean getFlagMezzoPubblico() {
		return flagMezzoPubblico;
	}

	public void setFlagMezzoPubblico(Boolean flagMezzoPubblico) {
		this.flagMezzoPubblico = flagMezzoPubblico;
	}

	@Column(name = "info_mezzo_pubblico", length = 250)
	public String getInfoMezzoPubblico() {
		return InfoMezzoPubblico;
	}

	public void setInfoMezzoPubblico(String infoMezzoPubblico) {
		InfoMezzoPubblico = infoMezzoPubblico;
	}

	@Column(name = "info_trasferta", length = 250)
	public String getInfoTrasferta() {
		return infoTrasferta;
	}

	public void setInfoTrasferta(String infoTrasferta) {
		this.infoTrasferta = infoTrasferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVaDatiVacancy == null) ? 0 : idVaDatiVacancy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaAltreInfo other = (VaAltreInfo) obj;
		if (idVaDatiVacancy == null) {
			if (other.idVaDatiVacancy != null)
				return false;
		} else if (!idVaDatiVacancy.equals(other.idVaDatiVacancy))
			return false;
		return true;
	}


	@Transient
	public String getSceltaAuto() {
		if (opzAutomunito != null && this.opzAutomunito.equalsIgnoreCase("Y")) {
			sceltaAuto = "Y";
		} else if(opzAutomunito != null && this.opzAutomunito.equalsIgnoreCase("N")) {
			sceltaAuto =  "N";
		}if(sceltaAuto == null){
			sceltaAuto = "";
		}
		return sceltaAuto;
	}

	public void setSceltaAuto(String sceltaAuto) {
		if (sceltaAuto != null && sceltaAuto.equalsIgnoreCase("N")) {
			this.opzAutomunito = "N";
		} else if (sceltaAuto != null && sceltaAuto.equalsIgnoreCase("Y")) {

			this.opzAutomunito = "Y";
		}
		if (sceltaAuto == null) {
			this.opzAutomunito = "";
		}
	}


	@Transient
	public String getSceltaMoto() {
		if (opzMotomunito != null && this.opzMotomunito.equalsIgnoreCase("Y")) {
			sceltaMoto = "Y";
		} else if(opzMotomunito != null && this.opzMotomunito.equalsIgnoreCase("N")) {
			sceltaMoto =  "N";
		}if(sceltaMoto == null){
			sceltaMoto = "";
		}
		return sceltaMoto;
	}

	public void setSceltaMoto(String sceltaMoto) {
		if (sceltaMoto != null && sceltaMoto.equalsIgnoreCase("N")) {
			this.opzMotomunito = "N";
		} else if (sceltaMoto != null && sceltaMoto.equalsIgnoreCase("Y")) {

			this.opzMotomunito = "Y";
		}
		if (sceltaMoto == null) {
			this.opzMotomunito = "";
		}
	}

	@Transient
	public String getSceltaTrasferta() {
		if (opzTrasferta != null && this.opzTrasferta.equalsIgnoreCase("Y")) {
			sceltaTrasferta = "Y";
		} else if(opzTrasferta != null && this.opzTrasferta.equalsIgnoreCase("N")) {
			sceltaTrasferta =  "N";
		}if(sceltaTrasferta == null){
			sceltaTrasferta = "";
		}
/*
		if (opzFuorisede != null && this.opzFuorisede.equalsIgnoreCase("Y")) {
			sceltaTrasferta = "Y";
		} else if(opzFuorisede != null && this.opzFuorisede.equalsIgnoreCase("N")) {
			sceltaTrasferta =  "N";
		}if(sceltaTrasferta == null){
			sceltaTrasferta = "";
		}
*/		
		return sceltaTrasferta;
	}

	public void setSceltaTrasferta(String sceltaTrasferta) {
		if (sceltaTrasferta != null && sceltaTrasferta.equalsIgnoreCase("N")) {
			this.opzTrasferta = "N";
		} else if (sceltaTrasferta != null && sceltaTrasferta.equalsIgnoreCase("Y")) {

			this.opzTrasferta = "Y";
		}
		if (sceltaTrasferta == null) {
			this.opzTrasferta = "";
		}
		/*
		if (sceltaTrasferta != null && sceltaTrasferta.equalsIgnoreCase("N")) {
			this.opzFuorisede = "N";
		} else if (sceltaTrasferta != null && sceltaTrasferta.equalsIgnoreCase("Y")) {

			this.opzFuorisede = "Y";
		}
		if (sceltaTrasferta == null) {
			this.opzFuorisede = "";
		}
		*/
	}



}
