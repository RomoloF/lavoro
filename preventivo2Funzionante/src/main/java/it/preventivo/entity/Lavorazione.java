package it.preventivo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lavorazione")
public class Lavorazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lavorazione")
    private Integer idLavorazione;

    private String descrizione;

    private java.math.BigDecimal prezzo;

    public Lavorazione() {
		super();
	}

	@ManyToMany(mappedBy = "lavoraziones")
    private List<Preventivo> preventivos;

	public Integer getIdLavorazione() {
		return idLavorazione;
	}

	public void setIdLavorazione(Integer idLavorazione) {
		this.idLavorazione = idLavorazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public java.math.BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(java.math.BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public List<Preventivo> getPreventivos() {
		return preventivos;
	}

	public void setPreventivos(List<Preventivo> preventivos) {
		this.preventivos = preventivos;
	}


}