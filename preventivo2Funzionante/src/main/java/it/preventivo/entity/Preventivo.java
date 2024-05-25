package it.preventivo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "preventivo")
public class Preventivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preventivo")
    private Integer idPreventivo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_preventivo")
    private java.util.Date dataPreventivo;

    private String stato;

    public Preventivo() {
		super();
	}

	@ManyToOne
    @JoinColumn(name = "fk_id_utente")
    private Utente utente;

    @ManyToMany
    @JoinTable(
            name = "preventivo_lavorazione",
            joinColumns = @JoinColumn(name = "id_preventivo"),
            inverseJoinColumns = @JoinColumn(name = "id_lavorazione")
    )
    private List<Lavorazione> lavoraziones;

	public Integer getIdPreventivo() {
		return idPreventivo;
	}

	public void setIdPreventivo(Integer idPreventivo) {
		this.idPreventivo = idPreventivo;
	}

	public java.util.Date getDataPreventivo() {
		return dataPreventivo;
	}

	public void setDataPreventivo(java.util.Date dataPreventivo) {
		this.dataPreventivo = dataPreventivo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Lavorazione> getLavoraziones() {
		return lavoraziones;
	}

	public void setLavoraziones(List<Lavorazione> lavoraziones) {
		this.lavoraziones = lavoraziones;
	}



}

