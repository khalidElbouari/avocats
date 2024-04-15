package org.avocats.avocats.entities.avocats;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class TribunalFils {
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nom;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "id_mere", nullable = false)
	private TribunalMere mere;

	public TribunalMere getMere() {
		return mere;
	}
	public void setMere(TribunalMere mere) {
		this.mere = mere;
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
