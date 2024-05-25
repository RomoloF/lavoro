package it.preventivo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the utente database table.
 *
 */
@Entity
@Table(name="utente")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idutente;

	@Column(name="categoria_lavori_id")
	private int categoriaLavoriId;

	private String cognome;

	@Column(name="creato_il")
	private String creatoIl;

	@Temporal(TemporalType.DATE)
	@Column(name="data_di_nascita")
	private Date dataDiNascita;

	private String email;

	@Column(name="modificato_il")
	private String modificatoIl;

	private String nome;

	private String password;

	 @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	    private List<Preventivo> preventivi;



	public Utente() {
	}

	public long getIdutente() {
		return this.idutente;
	}

	public void setIdutente(long idutente) {
		this.idutente = idutente;
	}

	public int getCategoriaLavoriId() {
		return this.categoriaLavoriId;
	}

	public void setCategoriaLavoriId(int categoriaLavoriId) {
		this.categoriaLavoriId = categoriaLavoriId;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCreatoIl() {
		return this.creatoIl;
	}

	public void setCreatoIl(String creatoIl) {
		this.creatoIl = creatoIl;
	}

	public Date getDataDiNascita() {
		return this.dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModificatoIl() {
		return this.modificatoIl;
	}

	public void setModificatoIl(String modificatoIl) {
		this.modificatoIl = modificatoIl;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}