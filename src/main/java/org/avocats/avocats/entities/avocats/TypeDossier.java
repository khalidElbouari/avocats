package org.avocats.avocats.entities.avocats;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class TypeDossier {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
@Column(unique = true, nullable = false, name = "ID_TYPE")
	private Long id;
    private String nom;
    @OneToMany(mappedBy = "typeD", fetch = FetchType.LAZY)
	private Collection<Dossier> dossier;
    
	public TypeDossier() {
		super();
		
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
	public Collection<Dossier> getDossier() {
		return dossier;
	}
	public void setDossier(Collection<Dossier> dossier) {
		this.dossier = dossier;
	}
    
}
