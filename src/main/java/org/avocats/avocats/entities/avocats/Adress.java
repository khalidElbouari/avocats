package org.avocats.avocats.entities.avocats;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;



@Entity
public class Adress {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nom;
	private boolean supp;
	
	@OneToOne @JoinColumn(name = "id_bureau", nullable = false)
	private BureauAvocat bureau;

	@ManyToOne
	@JoinColumn(name = "id_ville", nullable = false)
	private Ville ville;
	
	public BureauAvocat getBureau() {
		return bureau;
	}
	public void setBureau(BureauAvocat bureau) {
		this.bureau = bureau;
	}
	
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
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
	
	public boolean isSupp() {
		return supp;
	}
	public void setSupp(boolean supp) {
		this.supp = supp;
	}
	
	

}
