package it.eng.myportal.entity;
// Generated Mar 1, 2012 12:28:41 PM by Hibernate Tools 3.4.0.CR1
import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.eng.myportal.entity.decodifiche.DeMansione;
import it.eng.myportal.entity.decodifiche.DeProfessione;
import it.eng.myportal.entity.decodifiche.DeQualificaSrq;
import it.eng.myportal.entity.decodifiche.DeTipoFormazione;
/**
 * OrCorso generated by hbm2java
 */
@Entity
@Table(name="or_corso"
    ,schema="myportal"
)
public class OrCorso extends AbstractEntity  implements java.io.Serializable {
	private static final long serialVersionUID = 101289L;
     private Integer idOrCorso;


     private OrEnteCorso orEnteCorso;
     private DeQualificaSrq deQualificaSrq;
     private DeMansione deMansione;
     private DeTipoFormazione deTipoFormazione;
     private DeProfessione deProfessione;
     private String titoloCorso;
     private String descrizioneCorso;
     private String contenutiPercorso;
     private String requisitiAccesso;
     private String iscrizione;
     private String criteriSelezione;
     private Date dtAvvio;
     private String attestatoRilascio;
     private String durata;
     private String periodoSvolgimento;
     private Integer numeroPartecipanti;
     private BigDecimal quotaIscrizioneIndividuale;
     private String amministrazioneCompetente;
     private String codiceIdentificativo;
     private String scuolaCapofila;
     private String universita;
     private String imprese;

     private Integer idCorso;

     private Set<OrSedeCorso> orSedeCorsos = new HashSet<OrSedeCorso>(0);
     private Set<OrEdizioneAvviata> orEdizioneAvviatas = new HashSet<OrEdizioneAvviata>(0);
    public OrCorso() {
    }
    
     @Id 
	@SequenceGenerator(name = "or_corso_id_or_corso_seq", sequenceName="or_corso_id_or_corso_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "or_corso_id_or_corso_seq")
    @Column(name="id_or_corso", unique=true, nullable=false)
    public Integer getIdOrCorso() {
        return this.idOrCorso;
    }
    public void setIdOrCorso(Integer idOrCorso) {
        this.idOrCorso = idOrCorso;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_or_ente_corso", nullable=false)
    public OrEnteCorso getOrEnteCorso() {
        return this.orEnteCorso;
    }
    public void setOrEnteCorso(OrEnteCorso orEnteCorso) {
        this.orEnteCorso = orEnteCorso;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_qualifica_srq_rilasciata")
    public DeQualificaSrq getDeQualificaSrq() {
        return this.deQualificaSrq;
    }
    public void setDeQualificaSrq(DeQualificaSrq deQualificaSrq) {
        this.deQualificaSrq = deQualificaSrq;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_mansione")
    public DeMansione getDeMansione() {
        return this.deMansione;
    }
    public void setDeMansione(DeMansione deMansione) {
        this.deMansione = deMansione;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_tipo_formazione")
    public DeTipoFormazione getDeTipoFormazione() {
        return this.deTipoFormazione;
    }
    public void setDeTipoFormazione(DeTipoFormazione deTipoFormazione) {
        this.deTipoFormazione = deTipoFormazione;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_professione")
    public DeProfessione getDeProfessione() {
        return this.deProfessione;
    }
    public void setDeProfessione(DeProfessione deProfessione) {
        this.deProfessione = deProfessione;
    }
    @Column(name="titolo_corso", nullable=false, length=400)
    public String getTitoloCorso() {
        return this.titoloCorso;
    }
    public void setTitoloCorso(String titoloCorso) {
        this.titoloCorso = titoloCorso;
    }
    @Column(name="descrizione_corso", length=4000)
    public String getDescrizioneCorso() {
        return this.descrizioneCorso;
    }
    public void setDescrizioneCorso(String descrizioneCorso) {
        this.descrizioneCorso = descrizioneCorso;
    }
    @Column(name="contenuti_percorso", length=4000)
    public String getContenutiPercorso() {
        return this.contenutiPercorso;
    }
    public void setContenutiPercorso(String contenutiPercorso) {
        this.contenutiPercorso = contenutiPercorso;
    }
    @Column(name="requisiti_accesso", length=4000)
    public String getRequisitiAccesso() {
        return this.requisitiAccesso;
    }
    public void setRequisitiAccesso(String requisitiAccesso) {
        this.requisitiAccesso = requisitiAccesso;
    }
    @Column(name="iscrizione", length=1000)
    public String getIscrizione() {
        return this.iscrizione;
    }
    public void setIscrizione(String iscrizione) {
        this.iscrizione = iscrizione;
    }
    @Column(name="criteri_selezione", length=4000)
    public String getCriteriSelezione() {
        return this.criteriSelezione;
    }
    public void setCriteriSelezione(String criteriSelezione) {
        this.criteriSelezione = criteriSelezione;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_avvio", length=29)
    public Date getDtAvvio() {
        return this.dtAvvio;
    }
    public void setDtAvvio(Date dtAvvio) {
        this.dtAvvio = dtAvvio;
    }
    @Column(name="attestato_rilascio", length=250)
    public String getAttestatoRilascio() {
        return this.attestatoRilascio;
    }
    public void setAttestatoRilascio(String attestatoRilascio) {
        this.attestatoRilascio = attestatoRilascio;
    }
    @Column(name="durata", length=100)
    public String getDurata() {
        return this.durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }
    @Column(name="periodo_svolgimento", length=1000)
    public String getPeriodoSvolgimento() {
        return this.periodoSvolgimento;
    }
    public void setPeriodoSvolgimento(String periodoSvolgimento) {
        this.periodoSvolgimento = periodoSvolgimento;
    }
    @Column(name="numero_partecipanti")
    public Integer getNumeroPartecipanti() {
        return this.numeroPartecipanti;
    }
    public void setNumeroPartecipanti(Integer numeroPartecipanti) {
        this.numeroPartecipanti = numeroPartecipanti;
    }
    @Column(name="quota_iscrizione_individuale", precision=12, scale=0)
    public BigDecimal getQuotaIscrizioneIndividuale() {
        return this.quotaIscrizioneIndividuale;
    }
    public void setQuotaIscrizioneIndividuale(BigDecimal quotaIscrizioneIndividuale) {
        this.quotaIscrizioneIndividuale = quotaIscrizioneIndividuale;
    }
    @Column(name="amministrazione_competente", length=1000)
    public String getAmministrazioneCompetente() {
        return this.amministrazioneCompetente;
    }
    public void setAmministrazioneCompetente(String amministrazioneCompetente) {
        this.amministrazioneCompetente = amministrazioneCompetente;
    }
    @Column(name="codice_identificativo", length=20)
    public String getCodiceIdentificativo() {
        return this.codiceIdentificativo;
    }
    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }
    @Column(name="scuola_capofila", length=200)
    public String getScuolaCapofila() {
        return this.scuolaCapofila;
    }
    public void setScuolaCapofila(String scuolaCapofila) {
        this.scuolaCapofila = scuolaCapofila;
    }
    @Column(name="universita", length=1000)
    public String getUniversita() {
        return this.universita;
    }
    public void setUniversita(String universita) {
        this.universita = universita;
    }
    @Column(name="imprese", length=1000)
    public String getImprese() {
        return this.imprese;
    }
    public void setImprese(String imprese) {
        this.imprese = imprese;
    }
    
@OneToMany(fetch=FetchType.LAZY, mappedBy="orCorso")
    public Set<OrSedeCorso> getOrSedeCorsos() {
        return this.orSedeCorsos;
    }
    public void setOrSedeCorsos(Set<OrSedeCorso> orSedeCorsos) {
        this.orSedeCorsos = orSedeCorsos;
    }
@OneToMany(fetch=FetchType.LAZY, mappedBy="orCorso")
    public Set<OrEdizioneAvviata> getOrEdizioneAvviatas() {
        return this.orEdizioneAvviatas;
    }
    public void setOrEdizioneAvviatas(Set<OrEdizioneAvviata> orEdizioneAvviatas) {
        this.orEdizioneAvviatas = orEdizioneAvviatas;
    }
    @Column(name="id_corso", nullable=false)
	public Integer getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(Integer idCorso) {
		this.idCorso = idCorso;
	}
}
