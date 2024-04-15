package org.avocats.avocats.entities.avocats;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RDV {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String heur;
	private String sujet;
	
	@ManyToOne @JoinColumn(name = "id_client", nullable = false)
	private Client client;
	
	@ManyToOne @JoinColumn(name = "id_bureau", nullable = false)
	private BureauAvocat bureau;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHeur() {
		return heur;
	}
	public void setHeur(String heur) {
		this.heur = heur;
	}
	
	public BureauAvocat getBureau() {
		return bureau;
	}
	public void setBureau(BureauAvocat bureau) {
		this.bureau = bureau;
	}
	
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	

}
