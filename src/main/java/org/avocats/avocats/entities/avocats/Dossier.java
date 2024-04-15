package org.avocats.avocats.entities.avocats;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class Dossier implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long id;
	@Column(unique = true, nullable = false, length = 20, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	private Date DateCreation;
	
     private String typeDecas;
	 private String sujet;
	 private String typeProsedure;
	 private Date dateProchSession;
	  private String id_client;
	 
	  
	@OneToMany(mappedBy = "dossiers", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<CalendrieSeance> calendrieSeances;
	


	
	public Dossier() {
		
	}

	@Column(unique = true, length = 20, name = "NUMERO_NATIONAL")
	private String numeroNational;
	
	
     @ManyToOne(cascade = CascadeType.REMOVE) 
     @JoinColumn(name = "id_bureau",nullable = false) 
	  private BureauAvocat bureau;
	 
	public Collection<Client> getClient() {
		return client;
	}
	public void setClient(Collection<Client> client) {
		this.client = client;
	}
	
	@ManyToMany(mappedBy = "dossier",cascade = CascadeType.REMOVE)
	private Collection<Client> client;
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable( name = "dossier_juge", joinColumns = @JoinColumn( name = "dossier_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn( name = "juge_id", referencedColumnName = "id"))
	private Collection<Juge> juge;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable( name = "dossie_tri", joinColumns = @JoinColumn( name ="dossier_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn( name="tri_id", referencedColumnName = "id"))
	private Collection<Tribunal> tribunal;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "Type_Dossier",referencedColumnName="ID_TYPE")
    private TypeDossier typeD;
	
	
	
	
	
	public TypeDossier getTypeD() {
		return typeD;
	}
	public void setTypeD(TypeDossier typeD) {
		this.typeD = typeD;
	}
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable( name = "dossier_Avocat", joinColumns = @JoinColumn( name = "dossier_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn( name = "avocat_id", referencedColumnName = "id"))
	private Collection<Avocat> avocat;
	
	
	
	public Collection<Avocat> getAvocat() {
		return avocat;
	}
	public void setAvocat(Collection<Avocat> avocat) {
		this.avocat = avocat;
	}
	public Collection<Juge> getJuge() {
		return juge;
	}
	public void setJuge(Collection<Juge> juge) {
		this.juge = juge;
	}
	public Collection<Tribunal> getTribunal() {
		return tribunal;
	}
	
	public void setTribunal(Collection<Tribunal> tribunal) {
		this.tribunal = tribunal;
	}
	
	
	
	
	  public BureauAvocat getBureau() { return bureau; } public void
	  setBureau(BureauAvocat bureau) { this.bureau = bureau; }
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getNumeroNational() {
		return numeroNational;
	}
	public void setNumeroNational(String numeroNational) {
		this.numeroNational = numeroNational;
	}
	public String getTypeDecas() {
		return typeDecas;
	}
	public void setTypeDecas(String typeDecas) {
		this.typeDecas = typeDecas;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getTypeProsedure() {
		return typeProsedure;
	}
	public void setTypeProsedure(String typeProsedure) {
		this.typeProsedure = typeProsedure;
	}
	public Date getDateProchSession() {
		return dateProchSession;
	}
	public void setDateProchSession(Date dateProchSession) {
		this.dateProchSession = dateProchSession;
	}
	public String getId_client() {
		return id_client;
	}
	public Collection<CalendrieSeance> getCalendrieSeances() {
		return calendrieSeances;
	}
	public void setCalendrieSeances(Collection<CalendrieSeance> calendrieSeances) {
		this.calendrieSeances = calendrieSeances;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public Collection<CalendrieSeance> getCalendrieSeance() {
		return calendrieSeances;
	}
	public void setCalendrieSeance(Collection<CalendrieSeance> calendrieSeances) {
		this.calendrieSeances = calendrieSeances;
	}
	public Dossier( String numeroDossier, Date dateCreation, String typeDecas, String sujet,
			String typeProsedure, Date dateProchSession,
			String numeroNational, TypeDossier typeD,BureauAvocat bureau) {
		this.numeroDossier = numeroDossier;
		this.DateCreation = dateCreation;
		this.typeDecas = typeDecas;
		this.sujet = sujet;
		this.typeProsedure = typeProsedure;
		this.dateProchSession = dateProchSession;
		this.numeroNational = numeroNational;
		this.typeD = typeD;
		this.bureau = bureau;
	}


	
}
