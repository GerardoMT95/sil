package it.eng.myportal.entity.decodifiche.min;

import it.eng.myportal.entity.AbstractDecodeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "de_iscrizione_corso_min", schema = "myportal")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class DeIscrizioneCorsoMin extends AbstractDecodeEntity {
	private static final long serialVersionUID = -1875117247369375911L;

	private String codIscrizioneCorsoMin;
	private String descrizione;

	@Id
	@Column(name = "cod_iscrizione_corso_min", unique = true, nullable = false, length = 8)
	public String getCodIscrizioneCorsoMin() {
		return codIscrizioneCorsoMin;
	}

	public void setCodIscrizioneCorsoMin(String codIscrizioneCorsoMin) {
		this.codIscrizioneCorsoMin = codIscrizioneCorsoMin;
	}

	@Column(name = "descrizione", nullable = false, length = 2000)
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codIscrizioneCorsoMin == null) ? 0 : codIscrizioneCorsoMin.hashCode());
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
		DeIscrizioneCorsoMin other = (DeIscrizioneCorsoMin) obj;
		if (codIscrizioneCorsoMin == null) {
			if (other.codIscrizioneCorsoMin != null)
				return false;
		} else if (!codIscrizioneCorsoMin.equals(other.codIscrizioneCorsoMin))
			return false;
		return true;
	}
}
