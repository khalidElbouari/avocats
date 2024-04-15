package org.avocats.avocats.entities.avocats;

import java.util.Collection;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity

public class Tribunal {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "id_type", nullable = false)
	private TypeTribunal type_tri;
	
	@ManyToOne
	@JoinColumn(name="id_tri")
	private Tribunal tribunal;
	
	@ManyToMany(mappedBy = "tribunal")
	private Collection<Dossier> dossier;
	
	
	public Collection<Dossier> getDossier() {
		return dossier;
	}
	public void setDossier(Collection<Dossier> dossier) {
		this.dossier = dossier;
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
	
	public TypeTribunal getType_tri() {
		return type_tri;
	}
	public void setType_tri(TypeTribunal type_tri) {
		this.type_tri = type_tri;
	}
	
	public Tribunal getTribunal() {
		return tribunal;
	}
	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

}
