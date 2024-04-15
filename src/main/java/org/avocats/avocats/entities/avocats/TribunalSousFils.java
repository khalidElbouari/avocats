package org.avocats.avocats.entities.avocats;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class TribunalSousFils {
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nom;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "id_fils", nullable = false)
	private TribunalFils fils;

	public TribunalFils getFils() {
		return fils;
	}
	public void setFils(TribunalFils fils) {
		this.fils = fils;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
